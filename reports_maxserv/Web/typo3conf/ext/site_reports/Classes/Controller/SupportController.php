<?php
namespace MaxServ\SiteReports\Controller;

/*
 * This file is part of the TYPO3 CMS project.
 *
 * It is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License, either version 2
 * of the License, or any later version.
 *
 * For the full copyright and license information, please read the
 * LICENSE.txt file that was distributed with this source code.
 *
 * The TYPO3 project - inspiring people to share!
 */

use MaxServ\SiteReports\Domain\Model\Project;
use MaxServ\SiteReports\Domain\Model\ProjectField;
use MaxServ\SiteReports\Domain\Repository\ProjectRepository;
use MaxServ\SiteReports\Domain\Repository\WorklogRepository;
use MaxServ\SiteReports\Utility\GraphColorUtility;
use MaxServ\SiteReports\Utility\JiraUtility;
use TYPO3\CMS\Extbase\Mvc\Controller\ActionController;
use Spipu\Html2Pdf;
use Html2PdfExtension\Html2Pdf\Extension;

/**
 * Class SupportController
 * @package MaxServ\SiteReports\Controller
 */
class SupportController extends ActionController
{

    /**
     * @var \MaxServ\SiteReports\Domain\Repository\ProjectRepository
     * @inject
     */
    protected $projectRepository;

    /**
     * @var \MaxServ\SiteReports\Domain\Repository\WorklogRepository
     * @inject
     */
    protected $worklogRepository;

	/**
	 * @var \MaxServ\SiteReports\Domain\Repository\ProjectContactRepository
	 * @inject
	 */
	protected $projectContactRepository;

	/**
	 * @var \MaxServ\SiteReports\Domain\Repository\ProjectCommentRepository
	 * @inject
	 */
	protected $projectCommentRepository;

	/**
	 * //action form
	 *
	 * //@param array $request
	 *
	 * //@return void
	 */
	/*public function formAction($request) {
		$request['origin']
	}*/


    public function listProjectsAction()
    {
        if (is_array($this->settings) &&
            array_key_exists('supportProjectType', $this->settings) &&
            !empty($this->settings['supportProjectType'])
        ) {
            $projects = $this->projectRepository->findByProjectCategory($this->settings['supportProjectType']);

            $startDate = new \DateTime;
            $startDate->setTimestamp(mktime(0, 0, 0, date('m'), 1, date('Y')));

            $endDate = new \DateTime;
            $endDate->setTimestamp(mktime(23, 59, 59, date('m'), date('t'), date('Y')));

            $this->view->assign('data', $this->configurationManager->getContentObject()->data);
            $this->view->assign('startDate', $startDate);
            $this->view->assign('endDate', $endDate);
            $this->view->assign('projects', $projects);
        }
    }

    /**
 * @param \MaxServ\SiteReports\Domain\Model\Project $project
 */
	public function showAction($project)
	{
		$fields = $project->getFields();
		$assocFields = [];
		$percentage = '';
		$assocContacts = $this->projectContactRepository->getContactsOnProject();
		$assocComments = $this->projectCommentRepository->getCommentsOnProject();
		$progressClass = '';
		/** @var ProjectField $field */
		foreach ($fields as $field) {
			$value = $field->getValue();
			if (!empty($value) && $value !== 'NULL') {
				$assocFields[$field->getId()] = ['name' => $field->getName(), 'value' => $value];
			}
		}

		$startDate = new \DateTime;
		$startDate->setTimestamp(mktime(0, 0, 0, date('m'), 1, date('Y')));

		$endDate = new \DateTime;
		$endDate->setTimestamp(mktime(23, 59, 59, date('m'), date('t'), date('Y')));

		$projectHours = $this->worklogRepository->getHoursOnProjectInPeriod(

			[$project->getKey()],
			[],
			$startDate->getTimestamp(),

			$endDate->getTimestamp()
		);

		$lastYears = $this->getLastYears(2, true);
		$currentYear = $this->getMonths(11, true, 12);
		$lastYear = $this->getMonths(11, true, 0);
		$beforeLastYear = $this->getMonths(11, true, -12);
		$countedMonths = 1;

		foreach ($currentYear as $month) {
			/** @var \DateTime $month */
			$labels[] = strftime('%b %Y', $month->getTimestamp());
			$tmpStartDate = mktime(0, 0, 0, $month->format('m'), 1, $month->format('Y'));
			$tmpEndDate = mktime(0, 0, 0, $month->format('m') + 1, 1, $month->format('Y')) - 1;

			$tmpHours = $this->worklogRepository->getHoursOnProjectInPeriod(
				[$project->getKey()],
				[],
				$tmpStartDate,
				$tmpEndDate
			);

			$tmpIssues = $this->worklogRepository->getIssuesOnProjectInPeriod(
				[$project->getKey()],
				[],
				$tmpStartDate,
				$tmpEndDate
			);

			$data[] = $tmpHours;
			$data2[] = (float)$assocFields[3]['value'] * $countedMonths;

			$loggedIssues[] = $tmpIssues;

			$countedMonths++;
		}

		foreach ($lastYear as $month) {
			/** @var \DateTime $month */
			$labelsLastYear[] = strftime('%b %Y', $month->getTimestamp());
			$tmpStartDate = mktime(0, 0, 0, $month->format('m'), 1, $month->format('Y'));
			$tmpEndDate = mktime(0, 0, 0, $month->format('m') + 1, 1, $month->format('Y')) - 1;

			$tmpHours = $this->worklogRepository->getHoursOnProjectInPeriod(
				[$project->getKey()],
				[],
				$tmpStartDate,
				$tmpEndDate
			);

			$tmpIssues = $this->worklogRepository->getIssuesOnProjectInPeriod(
				[$project->getKey()],
				[],
				$tmpStartDate,
				$tmpEndDate
			);

			$dataLastYear[] = $tmpHours;
			$loggedIssuesLastYear[] = $tmpIssues;
		}

		foreach ($beforeLastYear as $month) {
			/** @var \DateTime $month */
			$labelsBeforeLastYear[] = strftime('%b %Y', $month->getTimestamp());
			$tmpStartDate = mktime(0, 0, 0, $month->format('m'), 1, $month->format('Y'));
			$tmpEndDate = mktime(0, 0, 0, $month->format('m') + 1, 1, $month->format('Y')) - 1;

			$tmpHours = $this->worklogRepository->getHoursOnProjectInPeriod(
				[$project->getKey()],
				[],
				$tmpStartDate,
				$tmpEndDate
			);

			$tmpIssues = $this->worklogRepository->getIssuesOnProjectInPeriod(
				[$project->getKey()],
				[],
				$tmpStartDate,
				$tmpEndDate
			);

			$dataBeforeLastYear[] = $tmpHours;
			$loggedIssuesBeforeLastYear[] = $tmpIssues;
		}

		$labelsPieChartJson = [
			"Uren verbruikt",
			"Uren resterend"
		];

		$dataSetPieChart[] = [
			'backgroundColor' => ["#000000", "#E0E0E0"],
			'data' => [20,80]
		];

		$dataSetLineChart[] = [
			'label' => 'Uren besteed',
			'borderColor' => '#FF0000',
			'backgroundColor' => '#FF0000',
			'data' => $data,
			'fill' => false,
			'pointRadius' => '6',
		];

		$dataSetLineChart[] = [
			'type' => 'line',
			'label' => 'Uren in overeenkomst',
			'fill' => false,
			'borderColor' => GraphColorUtility::getColor(0),
			'backgroundColor' => GraphColorUtility::getColor(0),
			'data' => $data2,
			'pointRadius' => '6'
		];

		$dataSetLineChartLastYear[] = [
			'label' => 'Uren besteed',
			'borderColor' => '#FF0000',
			'backgroundColor' => '#FF0000',
			'data' => $dataLastYear,
			'fill' => false,
			'pointRadius' => '6',
		];

		$dataSetLineChartLastYear[] = [
			'type' => 'line',
			'label' => 'Uren in overeenkomst',
			'fill' => false,
			'borderColor' => GraphColorUtility::getColor(0),
			'backgroundColor' => GraphColorUtility::getColor(0),
			'data' => $data2,
			'pointRadius' => '6'
		];

		$dataSetLineChartBeforeLastYear[] = [
			'label' => 'Uren besteed',
			'borderColor' => '#FF0000',
			'backgroundColor' => '#FF0000',
			'data' => $dataBeforeLastYear,
			'fill' => false,
			'pointRadius' => '6',
		];

		$dataSetLineChartBeforeLastYear[] = [
			'type' => 'line',
			'label' => 'Uren in overeenkomst',
			'fill' => false,
			'borderColor' => GraphColorUtility::getColor(0),
			'backgroundColor' => GraphColorUtility::getColor(0),
			'data' => $data2,
			'pointRadius' => '6'
		];

		$dataSetBarChart[] = [
			'label' => 'Tickets gelogd',
			'borderColor' => GraphColorUtility::getColor(0),
			'backgroundColor' => '#0090d7',
			'data' => $loggedIssues,
			'fill' => false,
			'pointRadius' => '6',
		];

		$dataSetBarChartLastYear[] = [
			'label' => 'Tickets gelogd',
			'borderColor' => GraphColorUtility::getColor(0),
			'backgroundColor' => '#0090d7',
			'data' => $loggedIssuesLastYear,
			'fill' => false,
			'pointRadius' => '6',
		];

		$dataSetBarChartBeforeLastYear[] = [
			'label' => 'Tickets gelogd',
			'borderColor' => GraphColorUtility::getColor(0),
			'backgroundColor' => '#0090d7',
			'data' => $loggedIssuesBeforeLastYear,
			'fill' => false,
			'pointRadius' => '6',
		];

		$jiraUtility = new JiraUtility(
			$this->settings['jira']['host'],
			$this->settings['jira']['username'],
			$this->settings['jira']['password']
		);

		$openIssues = $jiraUtility->sendRequest('/rest/api/2/search', 'POST', ['jql' => 'project=' . $project->getKey() . ' AND resolution = Unresolved AND status != Gefactureerd AND status != "Niet facturabel"  ORDER BY created ASC']);

		$progressClass = 'progress-bar-success';
		if ($percentage > 75) {
			$progressClass = 'progress-bar-warning';
		}
		if ($percentage > 100) {
			$progressClass = 'progress-bar-danger';
		}

		$this->view->assign('project', $project);
		$this->view->assign('assocFields', $assocFields);
		$this->view->assign('assocContacts', $assocContacts);
		$this->view->assign('assocComments', $assocComments);
		$this->view->assign('percentage', $percentage);
		$this->view->assign('progressClass', $progressClass);
		$this->view->assign('projectHours', $projectHours);
		$this->view->assign('labelJson', json_encode($labels));
		$this->view->assign('labelLastYearJson', json_encode($labelsLastYear));
		$this->view->assign('labelBeforeLastYearJson', json_encode($labelsBeforeLastYear));
		$this->view->assign('labelsPieChartJson', json_encode($labelsPieChartJson));
		//Zet associatieve array om in JSON string
		//Dit is bedoeld voor alle lijngrafieken
		$this->view->assign('datasetLineChartJson', json_encode($dataSetLineChart));
		$this->view->assign('dataSetLineChartLastYearJson', json_encode($dataSetLineChartLastYear));
		$this->view->assign('dataSetLineChartBeforeLastYearJson', json_encode($dataSetLineChartBeforeLastYear));
		//Zet associatieve array om in JSON string, zodat de arraysleutels (keys)
		//Dit is bedoeld voor alle staafgrafieken
		$this->view->assign('datasetBarChartJson', json_encode($dataSetBarChart));
		$this->view->assign('dataSetBarChartLastYearJson', json_encode($dataSetBarChartLastYear));
		$this->view->assign('dataSetBarChartBeforeLastYearJson', json_encode($dataSetBarChartBeforeLastYear));
		//Dit is bedoeld voor alle cirkeldiagrammen
		$this->view->assign('dataSetPieChartJson', json_encode($dataSetPieChart));
		$this->view->assign('openIssues', $openIssues->issues);
		//Geef deze array door aan de viewhelper, zodat het vanuit daar aangeroepen kan worden
		$this->view->assign('lastYears', $lastYears);
	}

	/**
	 * @param \MaxServ\SiteReports\Domain\Model\Project $project
	 */
	public function listPdfAction($project)
	{
		$this->view->assign('project', $project);
		$content = $this->view->render();
		$html2pdf = new Html2Pdf\Html2Pdf('L', 'A4', 'nl');
		$html2pdf->setDefaultFont('Arial');
		$html2pdf->writeHTML($content);
		// set default timezone
		date_default_timezone_set("Europe/Amsterdam");
		$html2pdf->output('support-overzicht' . date("F, Y", time()) . '.pdf', 'D');
	}

	/**
	 * @param \MaxServ\SiteReports\Domain\Model\Project $project
	 */
	public function showPdfAction($project)
	{
		$html2pdf = new Html2Pdf\Html2Pdf('L', 'A4', 'nl', true);
		$html2pdf->addExtension(new Extension\Html2PdfExtension());
		$html2pdf->pdf->IncludeJS("typo3/sysext/core/Resources/Public/JavaScript/Contrib/jquery/jquery-3.1.1.js");
		$html2pdf->pdf->IncludeJS("typo3conf/ext/site_reports/Resources/Public/Javascripts/vendor/Chart.min.js");
		$html2pdf->pdf->IncludeJS("typo3conf/ext/site_reports/Resources/Public/Javascripts/Charts.js");
		$this->view->assign('project', $project);
		$content = $this->view->render();
		$html2pdf->setDefaultFont('Arial');
		$html2pdf->writeHTML($content);
		$html2pdf->output($project->getKey() . '-support-overzicht.pdf', 'D');
	}

	/**
     * @param float $hoursMax
     * @param float $hoursCurrent
     *
     * @return float
     */
    protected function getPercentage($hoursMax, $hoursCurrent)
    {
        return (float)$hoursCurrent * 100 / $hoursMax;
    }

    /**
     * @param int $amount
     * @param bool $reverse
     * @return array
     */
    protected function getLastMonths($amount = 12, $reverse = false)
    {
        $startDate = new \DateTime;
        $startDate->setTimestamp(mktime(0, 0, 0, date('m'), 1, date('Y')));

        $data[] = \DateTime::createFromFormat('d-m-Y', $startDate->format('d-m-Y'));
        for ($i=0; $i<$amount; $i++) {
            $startDate->sub(new \DateInterval('P1M'));
            $data[] = \DateTime::createFromFormat('d-m-Y', $startDate->format('d-m-Y'));
        }

        if ($reverse) {
            return array_reverse($data);
        } else {
            return $data;
        }
    }

	/**
	 * @param int $iterations
	 * @param int $months
	 * @param bool $reverse
	 * @return array
	 */
	protected function getMonths($iterations = 12, $reverse = false, $months)
	{
		$startDate = new \DateTime;
		$startDate->setTimestamp(mktime(0, 0, 0, $months , 1, date('Y')));
		$data[] = \DateTime::createFromFormat('d-m-Y', $startDate->format('d-m-Y'));
		for ($i=0; $i<$iterations; $i++) {
			$startDate->sub(new \DateInterval('P1M'));
			$data[] = \DateTime::createFromFormat('d-m-Y', $startDate->format('d-m-Y'));
		}

		if ($reverse) {
			return array_reverse($data);
		} else {
			return $data;
		}
	}

	/**
	 * @param int $amount
	 * @param bool $reverse
	 * @return array
	 */
	protected function getLastYears($amount = 3, $reverse = false)
	{
		$startDate = new \DateTime;
		$startDate->setTimestamp(mktime(0, 0, 0, 12 , 1, date('Y')));;
		$data[] = date_format($startDate, 'Y');
		for ($i=0; $i<$amount; $i++) {
			$startDate->sub(new \DateInterval('P1Y'));
			$data[] = date_format($startDate, 'Y');
		}

		if ($reverse) {
			return array_reverse($data);
		} else {
			return $data;
		}
	}
}