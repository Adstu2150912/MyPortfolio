<?php
namespace MaxServ\SiteReports\ViewHelpers;

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
use MaxServ\SiteReports\Domain\Repository\WorklogRepository;
use TYPO3\CMS\Core\Utility\GeneralUtility;

/**
 * Class GetProjectDataViewHelper
 * @package MaxServ\SiteReports\ViewHelpers
 */
class GetProjectDataViewHelper extends \TYPO3\CMS\Fluid\Core\ViewHelper\AbstractViewHelper
{
	/**
	 * @var \MaxServ\SiteReports\Domain\Repository\WorklogRepository
	 * @inject
	 */
	protected $workLogRepository;
	/**
	 * @param \MaxServ\SiteReports\Domain\Model\Project $project
	 * @param \DateTime $startDate
	 * @param \DateTime $endDate
	 * @return string
	 */

	public function render($project, $startDate, $endDate)
	{
		$projectFields = $this->getProjectFields($project);
		$projectHours = $this->getProjectHours($project, $startDate, $endDate);
		$percentage = 0;
		// set default timezone
		date_default_timezone_set("Europe/Amsterdam");
		$currentMonth = date("F", time());

		if ((float)$projectFields[3]['value']) {
			$percentage = $this->getPercentage((float)$projectFields[3]['value'], (float)$projectHours);
		}

		$progressClass = 'progress-bar-success';
		if ($percentage > 75) {
			$progressClass = 'progress-bar-warning';
		}
		if ($percentage > 100) {
			$progressClass = 'progress-bar-danger';
		}

		$templateVariableContainer = $this->renderingContext->getVariableProvider();
		$templateVariableContainer->add('assocFields', $projectFields);
		$templateVariableContainer->add('projectHours', (float)$projectHours);
		$templateVariableContainer->add('percentage', (float)$percentage);
		$templateVariableContainer->add('progressClass', $progressClass);
		$templateVariableContainer->add('currentMonth', $currentMonth);

		$content = $this->renderChildren();
		$templateVariableContainer->remove('assocFields');
		$templateVariableContainer->remove('projectHours');
		$templateVariableContainer->remove('percentage');
		$templateVariableContainer->remove('progressClass');
		$templateVariableContainer->remove('currentMonth');
		return $content;
	}

	/**
	 * @param \MaxServ\SiteReports\Domain\Model\Project $project
	 * @return array
	 */
	protected function getProjectFields($project) {
		$data = [];
		if ($project instanceof Project) {
			$fields = $project->getFields();

			/** @var ProjectField $field */
			foreach ($fields as $field) {
				$value = $field->getValue();
				if (!empty($value) && $value !== 'NULL') {
					$data[$field->getId()] = ['name' => $field->getName(), 'value' => $value];
				}
			}
			/*Geeft totaal aantal contracturen terug per project, waarvan het aantal afhankelijk is van contractsduur*/
			for($i = 0; $i < count($data); $i++){
				if (!empty($data[6]["value"]) && $data[6]["value"] !== "NULL"){
					$project->setTotalContractHours($data[3]['value'], $data[6]['value']);
					$data[6] = ['name' => $data[6]['name'], 'value' => $data[6]['value'],
						'totalContractHours' => $project->getTotalContractHours()];
				}
			}
			return $data;
		}

	}

	/**
	 * @param \MaxServ\SiteReports\Domain\Model\Project $project
	 * @param \DateTime $startDate
	 * @param \DateTime $endDate
	 */
	protected function getProjectHours($project, $startDate, $endDate)
	{
		if (!$this->workLogRepository instanceof WorklogRepository) {
			$this->workLogRepository = $this->objectManager->get(WorklogRepository::class);
		}
		$hours = $this->workLogRepository->getHoursOnProjectInPeriod([$project->getKey()], [], $startDate->getTimestamp(), $endDate->getTimestamp());

		return $hours;
	}

	/*Geeft de uitkomst terug van deling tussen gebruikte uren en totaal uren*/
	/**
	 * @param float $hoursMax
	 * @param float $hoursCurrent
	 *
	 * @return float
	 */
	protected function getPercentage($hoursMax, $hoursCurrent) {
		return (float)$hoursCurrent * 100 / $hoursMax;
	}
}
