<?php
namespace MaxServ\SiteReports\Domain\Repository;

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

use MaxServ\SiteReports\Domain\Model\Worklog;
use MaxServ\SiteReports\Utility\DateUtility;
use MaxServ\SiteReports\Utility\GraphColorUtility;
use MaxServ\SiteReports\ViewHelpers\GetGraphColorsViewHelper;
use TYPO3\CMS\Backend\Utility\BackendUtility;
use TYPO3\CMS\Core\Database\DatabaseConnection;
use TYPO3\CMS\Core\Utility\GeneralUtility;
use TYPO3\CMS\Extbase\Persistence\Generic\QueryResult;
use TYPO3\CMS\Extbase\Persistence\Repository;

/**
 * Class WorklogRepository
 * @package MaxServ\SiteReports\Domain\Repository
 */
class WorklogRepository extends Repository
{

    /**
     * @var array
     */
    protected static $notBillableProjects = ['MSDIV', 'IMPRODUCTIEF', 'MANAGEMENT', 'SALES', 'OPS', 'MAGE2', 'MS'];
    /**
     * @var array
     */
    protected static $excludedProjects = ['VRIJ', 'ZIEK'];
    /**
     * @var array
     */
    protected $defaultOrderings = array(
        'crdate' => \TYPO3\CMS\Extbase\Persistence\QueryInterface::ORDER_DESCENDING
    );

    /**
     * @param $worklogId
     * @return null|Worklog
     */
    public function findByWorklogId($worklogId)
    {
        $query = $this->findAll()->getQuery();
        $query->getQuerySettings()->setRespectStoragePage(false);
        $query->matching(
            $query->equals('worklogId', $worklogId)
        );
        $query->setLimit(1);
        $ret = $query->execute();

        if ($query->count() > 0) {
            return $ret->getFirst();
        } else {
            return null;
        }
    }

    public function getStatisticsPerPeriodWithFilter($period, $users = [])
    {
        $statistics = [];

        if ($period === 'thisYear') {
            $dates = DateUtility::getStartEndDateOfPeriod($period, true);

            $projectsThisPeriod = $this->getProjectsThisPeriod($dates, $users);

            $statistics = [];
            for ($i = 11; $i >= 0; $i--) {
                $statistics['label'][] = strftime('%b %Y', mktime(0, 0, 0, date('m') - $i, date('d'), date('Y')));
            }

            $dataSets = [];
            $projectCodes = [];

            $colorIndex = 0;
            foreach ((array)$projectsThisPeriod as $project) {
                $data = [];
                for ($i = 11; $i >= 0; $i--) {
                    $startDate = mktime(0, 0, 0, date('m') - $i, 1, date('Y'));
                    $endDate = mktime(23, 59, 59, date('m') - ($i - 1), 1, date('Y')) - (86400);

                    $data[] = $this->getHoursOnProjectInPeriod(
                        [$project['project_code']],
                        $users,
                        $startDate,
                        $endDate
                    );
                }

                $dataSets[] = [
                    'label' => $project['project_code'],
                    'type' => 'bar',
                    'backgroundColor' => GraphColorUtility::getColor($colorIndex),
                    'data' => $data,
                    'borderColor' => 'white',
                    'borderWidth' => 1
                ];
                $colorIndex++;
                $projectCodes[] = $project['project_code'];
            }

            //overig
            $data = [];
            for ($i = 11; $i >= 0; $i--) {
                $startDate = mktime(0, 0, 0, date('m') - $i, 1, date('Y'));
                $endDate = mktime(23, 59, 59, date('m') - ($i - 1), 1, date('Y')) - (86400);

                $data[] = $this->getHoursOnProjectInPeriod($projectCodes, $users, $startDate, $endDate, true);
            }

            $dataSets[] = [
                'label' => 'OVERIG',
                'type' => 'bar',
                'backgroundColor' => GraphColorUtility::getColor($colorIndex),
                'data' => $data,
                'borderColor' => 'white',
                'borderWidth' => 1
            ];

            $statistics['datasets'] = $dataSets;
        }
        if ($period === 'thisMonth') {
            $dates = DateUtility::getStartEndDateOfPeriod($period, true);
            $projectsThisPeriod = $this->getProjectsThisPeriod($dates, $users);
            $statistics = [];
            for ($i = 4; $i >= 0; $i--) {
                $statistics['label'][] = strftime(
                    'Week %U',
                    mktime(0, 0, 0, date('m'), date('d') - ($i * 7), date('Y'))
                );
            }

            $dataSets = [];
            $projectCodes = [];

            $colorIndex = 0;
            foreach ((array)$projectsThisPeriod as $project) {
                $data = [];
                for ($i = 4; $i >= 0; $i--) {
                    $startDate = mktime(0, 0, 0, date('m'), date('d') - ($i * 7) - date('w'), date('Y'));
                    $endDate = mktime(23, 59, 59, date('m'), date('d') - ($i * 7) - date('w') + 6, date('Y'));

                    $data[] = $this->getHoursOnProjectInPeriod(
                        [$project['project_code']],
                        $users,
                        $startDate,
                        $endDate
                    );
                }

                $dataSets[] = [
                    'label' => $project['project_code'],
                    'type' => 'bar',
                    'backgroundColor' => GraphColorUtility::getColor($colorIndex),
                    'data' => $data,
                    'borderColor' => 'white',
                    'borderWidth' => 1
                ];
                $colorIndex++;
                $projectCodes[] = $project['project_code'];
            }

            //overig
            $data = [];
            for ($i = 4; $i >= 0; $i--) {
                $startDate = mktime(0, 0, 0, date('m'), date('d') - ($i * 7) - date('w'), date('Y'));
                $endDate = mktime(23, 59, 59, date('m'), date('d') - ($i * 7) - date('w') + 6, date('Y'));

                $data[] = $this->getHoursOnProjectInPeriod($projectCodes, $users, $startDate, $endDate, true);
            }

            $dataSets[] = [
                'label' => 'OVERIG',
                'type' => 'bar',
                'backgroundColor' => GraphColorUtility::getColor($colorIndex),
                'data' => $data,
                'borderColor' => 'white',
                'borderWidth' => 1
            ];

            $statistics['datasets'] = $dataSets;
        }
        if ($period === 'thisWeek') {
            $dates = DateUtility::getStartEndDateOfPeriod($period, true);

            $projectsThisPeriod = $this->getProjectsThisPeriod($dates, $users);

            $statistics = [];
            for ($i = 7; $i >= 0; $i--) {
                $statistics['label'][] = strftime('%e %b', mktime(0, 0, 0, date('m'), date('d') - $i, date('Y')));
            }

            $dataSets = [];
            $projectCodes = [];

            $colorIndex = 0;
            foreach ((array)$projectsThisPeriod as $project) {
                $data = [];
                for ($i = 7; $i >= 0; $i--) {
                    $startDate = mktime(0, 0, 0, date('m'), date('d') - $i, date('Y'));
                    $endDate = mktime(23, 59, 59, date('m'), date('d') - $i, date('Y'));

                    $data[] = $this->getHoursOnProjectInPeriod(
                        [$project['project_code']],
                        $users,
                        $startDate,
                        $endDate
                    );
                }

                $dataSets[] = [
                    'label' => $project['project_code'],
                    'type' => 'bar',
                    'backgroundColor' => GraphColorUtility::getColor($colorIndex),
                    'data' => $data,
                    'borderColor' => 'white',
                    'borderWidth' => 1
                ];
                $colorIndex++;
                $projectCodes[] = $project['project_code'];
            }

            //overig
            $data = [];
            for ($i = 7; $i >= 0; $i--) {
                $startDate = mktime(0, 0, 0, date('m'), date('d') - $i, date('Y'));
                $endDate = mktime(23, 59, 59, date('m'), date('d') - $i, date('Y'));

                $data[] = $this->getHoursOnProjectInPeriod($projectCodes, $users, $startDate, $endDate, true);
            }

            $dataSets[] = [
                'label' => 'OVERIG',
                'type' => 'bar',
                'backgroundColor' => GraphColorUtility::getColor($colorIndex),
                'data' => $data,
                'borderColor' => 'white',
                'borderWidth' => 1
            ];

            $statistics['datasets'] = $dataSets;
        }

        return $statistics;
    }

    /**
     * @param array $dates
     * @param array $users
     *
     * @return array
     */
    private function getProjectsThisPeriod($dates, $users)
    {
        $db = $this->getDatabaseConnection();

        $enableFields = BackendUtility::deleteClause('tx_sitereports_domain_model_worklog');
        $enableFields .= BackendUtility::BEenableFields('tx_sitereports_domain_model_worklog');

        $where = '1 = 1' . $enableFields;

        if (!empty($dates['startDate'])) {
            $where .= $where ? ' AND ' : '';

            $where .= 'started >= ' . $dates['startDate'];
        }
        if (!empty($dates['endDate'])) {
            $where .= $where ? ' AND ' : '';

            $where .= 'started <= ' . $dates['endDate'];
        }
        if (is_array($users) && count($users) > 0) {
            $where .= $where ? ' AND ' : '';

            $where .= 'username IN ("' . implode('","', $users) . '")';
        }

        if (is_array(self::$excludedProjects) && count(self::$excludedProjects) > 0) {
            $where .= ' AND project_code NOT IN ("' . implode('","', self::$excludedProjects) . '")';
        }

        return $db->exec_SELECTgetRows(
		'sum(time_spent) as time, project_code',
		'tx_sitereports_domain_model_worklog',
		$where,
		'project_code',
		'time DESC',
		10
	);
    }

    /**
     * @return DatabaseConnection
     */
    protected function getDatabaseConnection()
    {
        return $GLOBALS['TYPO3_DB'];
    }

    /**
     * @param array $projectCodes
     * @param array $users
     * @param int $startDate
     * @param int $endDate
     * @param bool $negate
     *
     * @return float
     */
    public function getHoursOnProjectInPeriod($projectCodes, $users = [], $startDate = 0, $endDate = 0, $negate = false)
    {
        $db = $this->getDatabaseConnection();

        $enableFields = \TYPO3\CMS\Backend\Utility\BackendUtility::deleteClause('tx_sitereports_domain_model_worklog');
        $enableFields .= \TYPO3\CMS\Backend\Utility\BackendUtility::BEenableFields('tx_sitereports_domain_model_worklog');

        $where = '1=1' . $enableFields;

        if (count($users) > 0) {
            $where .= ' AND username IN ("' .
                implode(
                    '","',
                    $users
                ) . '")';
        }

        if ($startDate) {
            $where .= ' AND started >= ' . $startDate;
        }

        if ($endDate) {
            $where .= ' AND started <= ' . $endDate;
        }

        if (count($projectCodes) > 0) {
            $where .= ' AND project_code ' . ($negate ? 'NOT ' : '') . ' IN ("' .
                implode(
                    '","',
                    $projectCodes
                ) . '")';
        }

        if (is_array(self::$excludedProjects) && count(self::$excludedProjects) > 0) {
            $where .= ' AND project_code NOT IN ("' . implode('","', self::$excludedProjects) . '")';
        }



        $dataArray = (array)$db->exec_SELECTgetSingleRow(
            'sum(time_spent) as time',
            'tx_sitereports_domain_model_worklog',
            $where
        );
        return (float)number_format((int)$dataArray['time'] / 3600, 2, '.', '');
    }

	/**
	 * @param array $projectCodes
	 * @param array $users
	 * @param int $startDate
	 * @param int $endDate
	 * @param bool $negate
	 *
	 * @return int
	 */
	public function getIssuesOnProjectInPeriod($projectCodes, $users = [], $startDate = 0, $endDate = 0, $negate = false)
	{
		$db = $this->getDatabaseConnection();

		$enableFields = \TYPO3\CMS\Backend\Utility\BackendUtility::deleteClause('tx_sitereports_domain_model_worklog');
		$enableFields .= \TYPO3\CMS\Backend\Utility\BackendUtility::BEenableFields('tx_sitereports_domain_model_worklog');

		$where = '1=1' . $enableFields;

		if (count($users) > 0) {
			$where .= ' AND username IN ("' .
				implode(
					'","',
					$users
				) . '")';
		}

		if (count($projectCodes) > 0) {
			$where .= ' AND project_code ' . ($negate ? 'NOT ' : '') . ' IN ("' .
				implode(
					'","',
					$projectCodes
				) . '")';
		}

		if ($startDate) {
			$where .= ' AND started >= ' . $startDate;
		}

		if ($endDate) {
			$where .= ' AND started <= ' . $endDate;
		}

		if (is_array(self::$excludedProjects) && count(self::$excludedProjects) > 0) {
			$where .= ' AND project_code NOT IN ("' . implode('","', self::$excludedProjects) . '")';
		}

		$dataArray = (array)$db->exec_SELECTgetSingleRow(
			'count(DISTINCT(issue_key)) as tickets',
			'tx_sitereports_domain_model_worklog',
			$where
		);
		return $dataArray['tickets'];
	}

    /**
     * @param array $dates
     * @param array $users
     * @param string $period
     * @param bool $splitInPeriods
     * @param bool $previous
     *
     * @return array
     */
    public function getProductivityInPeriod($dates, $users, $period, $splitInPeriods = false, $previous = false)
    {
        $retVal = [];

        if (!$splitInPeriods) {
            $data = $this->getStatisticsWithFilter($dates, $users);

            $totalTime = 0;
            $improductiveTime = 0;
            foreach ($data as $project) {
                if ((int)$project['internal'] === 1) {
                    $improductiveTime += $project['time'];
                }
                $totalTime += $project['time'];
            }

            $productiveTime = $totalTime - $improductiveTime;

            $retVal = [
                'totalTime' => $totalTime,
                'improductiveTime' => $improductiveTime,
                'productiveTime' => $productiveTime,
                'percentageBillable' => ($productiveTime * 100 / $totalTime)
            ];
        } else {
            if ($period === 'thisWeek') {
                // seperate in days
                $splitPer = 'day';
                $data = $this->getStatisticsWithFilter($dates, $users, $splitPer, 'day ASC');

                $improductiveTimeArray = [];
                $totalTimeArray = [];

                foreach ($data as $project) {
                    if ((int)$project['internal'] === 1) {
                        $improductiveTimeArray[$project['day']] += $project['time'];
                    }
                    $totalTimeArray[$project['day']] += $project['time'];
                }

                $numberOfDays = 7;
                for ($i = $numberOfDays; $i >= 1; $i--) {
                    $date = date('Y-m-d', mktime(0, 0, 0, date('m'), date('d') - date('w') + 7 - $i, date('y')));

                    $productiveTime = $totalTimeArray[$date] - $improductiveTimeArray[$date];
                    $percentageBillable = 0;
                    if ($totalTimeArray[$date] > 0) {
                        $percentageBillable = (float)($productiveTime * 100 / $totalTimeArray[$date]);
                    }


                    $retVal[$date] = [
                        'totalTime' => $data,
                        'improductiveTime' => (float)$improductiveTimeArray[$date],
                        'productiveTime' => (float)$productiveTime,
                        'percentageBillable' => $percentageBillable
                    ];
                }
            } elseif ($period === 'thisMonth') {
                // seperate in days
                $splitPer = 'day';
                $data = $this->getStatisticsWithFilter($dates, $users, $splitPer, 'day ASC');

                $improductiveTimeArray = [];
                $totalTimeArray = [];

                foreach ($data as $project) {
                    if ((int)$project['internal'] === 1) {
                        $improductiveTimeArray[$project['day']] += $project['time'];
                    }
                    $totalTimeArray[$project['day']] += $project['time'];
                }

                $numberOfDays = 31;
                for ($i = $numberOfDays; $i >= 1; $i--) {
                    $date = date('Y-m-d', mktime(0, 0, 0, date('m') + 1, 1 - $i, date('y')));

                    $productiveTime = $totalTimeArray[$date] - $improductiveTimeArray[$date];
                    $percentageBillable = 0;
                    if ($totalTimeArray[$date] > 0) {
                        $percentageBillable = (float)($productiveTime * 100 / $totalTimeArray[$date]);
                    }


                    $retVal[$date] = [
                        'totalTime' => $data,
                        'improductiveTime' => (float)$improductiveTimeArray[$date],
                        'productiveTime' => (float)$productiveTime,
                        'percentageBillable' => $percentageBillable
                    ];
                }
            } elseif ($period === 'thisYear') {
                // seperate in months
                $splitPer = 'month';
                $data = $this->getStatisticsWithFilter($dates, $users, $splitPer, 'month ASC');

                $improductiveTimeArray = [];
                $totalTimeArray = [];

                foreach ($data as $project) {
                    if ((int)$project['internal'] === 1) {
                        $improductiveTimeArray[$project['month']] += $project['time'];
                    }
                    $totalTimeArray[$project['month']] += $project['time'];
                }

                $numberOfMonths = 12;
                for ($i = 1; $i <= $numberOfMonths; $i++) {
                    $tmpDate = mktime(0, 0, 0, $i, 1, date('y'));
                    $date = date('Y-m-d', $tmpDate);
                    $month = date('Y-m', $tmpDate);

                    $productiveTime = $totalTimeArray[$month] - $improductiveTimeArray[$month];
                    $percentageBillable = 0;
                    if ($totalTimeArray[$month] > 0) {
                        $percentageBillable = (float)($productiveTime * 100 / $totalTimeArray[$month]);
                    }

                    $retVal[$date] = [
                        'totalTime' => $data,
                        'improductiveTime' => (float)$improductiveTimeArray[$month],
                        'productiveTime' => (float)$productiveTime,
                        'percentageBillable' => $percentageBillable
                    ];
                }
            } elseif ($period === 'free') {
                $start = new \DateTime;
                $start->setTimestamp($dates['startDate']);

                $end = new \DateTime;
                $end->setTimestamp($dates['endDate']);

                $interval = $start->diff($end);

                $numberOfDays = (int)$interval->format('%a') + 1;
                if ($numberOfDays < 100) {
                    // seperate in days
                    $splitPer = 'day';
                } else {
                    // seperate in months
                    $splitPer = 'month';
                }
                $data = $this->getStatisticsWithFilter($dates, $users, $splitPer, $splitPer . ' ASC');

                $improductiveTimeArray = [];
                $totalTimeArray = [];

                foreach ($data as $project) {
                    if ((int)$project['internal'] === 1) {
                        $improductiveTimeArray[$project[$splitPer]] += $project['time'];
                    }
                    $totalTimeArray[$project[$splitPer]] += $project['time'];
                }

                if ($splitPer === 'day') {
                    for ($i = 0; $i < $numberOfDays; $i++) {
                        $date = date(
                            'Y-m-d',
                            mktime(
                                0,
                                0,
                                0,
                                date('m', $dates['startDate']),
                                date('d', $dates['startDate']) + $i,
                                date('y', $dates['startDate'])
                            )
                        );

                        $productiveTime = $totalTimeArray[$date] - $improductiveTimeArray[$date];
                        $percentageBillable = 0;
                        if ($totalTimeArray[$date] > 0) {
                            $percentageBillable = (float)($productiveTime * 100 / $totalTimeArray[$date]);
                        }


                        $retVal[$date] = [
                            'totalTime' => $data,
                            'improductiveTime' => (float)$improductiveTimeArray[$date],
                            'productiveTime' => (float)$productiveTime,
                            'percentageBillable' => $percentageBillable
                        ];
                    }
                } else {
                    $numberOfMonths = ((int)$interval->format('%y') * 12) + (int)$interval->format('%m') + 1;
                    for ($i = 1; $i <= $numberOfMonths; $i++) {
                        $tmpDate = mktime(0, 0, 0, $i, 1, date('y', $dates['startDate']));
                        $date = date('Y-m-d', $tmpDate);
                        $month = date('Y-m', $tmpDate);

                        $productiveTime = $totalTimeArray[$month] - $improductiveTimeArray[$month];
                        $percentageBillable = 0;
                        if ($totalTimeArray[$month] > 0) {
                            $percentageBillable = (float)($productiveTime * 100 / $totalTimeArray[$month]);
                        }

                        $retVal[$date] = [
                            'totalTime' => $data,
                            'improductiveTime' => (float)$improductiveTimeArray[$month],
                            'productiveTime' => (float)$productiveTime,
                            'percentageBillable' => $percentageBillable
                        ];
                    }
                }
            }
        }

        return $retVal;
    }


    /**
     * @param array $dates
     * @param array $users
     * @param string $splitPer
     * @param string $oderBy
     * @param bool $last
     * @return array|NULL
     */
    public function getStatisticsWithFilter(
        $dates = [],
        $users = [],
        $splitPer = '',
        $orderBy = 'time DESC',
        $last = false
    ) {
        $db = $this->getDatabaseConnection();
//        $db->exec_UPDATEquery(
//            'tx_sitereports_domain_model_worklog',
//            'issue_summary like "%gootje%"',
//            ['project_code' => 'IMPRODUCTIEF']
//        );
//        $db->exec_UPDATEquery(
//            'tx_sitereports_domain_model_worklog',
//            'issue_key = "MSDIV-1255"',
//            ['project_code' => 'MANAGEMENT']
//        );
//        $db->exec_UPDATEquery(
//            'tx_sitereports_domain_model_worklog',
//            'issue_key = "MSDIV-1254"',
//            ['project_code' => 'SALES']
//        );
//        $db->exec_UPDATEquery(
//            'tx_sitereports_domain_model_worklog',
//            'project_code = "MS"',
//            ['project_code' => 'SALES']
//        );
//        $db->exec_UPDATEquery(
//            'tx_sitereports_domain_model_worklog',
//            'issue_key = "MSDIV-1253"',
//            ['project_code' => 'VRIJ']
//        );
//        $db->exec_UPDATEquery(
//            'tx_sitereports_domain_model_worklog',
//            'issue_key = "MSDIV-1267"',
//            ['project_code' => 'ZIEK']
//        );

        $enableFields = BackendUtility::deleteClause('tx_sitereports_domain_model_worklog');
        $enableFields .= BackendUtility::BEenableFields('tx_sitereports_domain_model_worklog');

        $where = '1 = 1' . $enableFields;

        if (is_array(self::$excludedProjects) && count(self::$excludedProjects) > 0) {
            $where .= ' AND project_code NOT IN ("' . implode('","', self::$excludedProjects) . '")';
        }

        if (array_key_exists('startDate', $dates) && !empty($dates['startDate'])) {
            $where .= ' AND started >= ' . $dates['startDate'];
        }
        if (array_key_exists('endDate', $dates) && !empty($dates['endDate'])) {
            $where .= ' AND started <= ' . $dates['endDate'];
        }
        if (is_array($users) && count($users) > 0) {
            $where .= ' AND username IN ("' . implode('","', $users) . '")';
        }

        switch ($splitPer) {
            case 'day':
                $select_extra = ', FROM_UNIXTIME(started, \'%Y-%m-%d\') as day';
                $groupBy = 'day, project_code';
                break;
            case 'month':
                $select_extra = ', FROM_UNIXTIME(started, \'%Y-%m\') as month';
                $groupBy = 'month, project_code';
                break;
            default:
                $select_extra = '';
                $groupBy = 'project_code';
        }
        $statisticsTotal = (array)$db->exec_SELECTgetSingleRow(
            'sum(time_spent) as time',
            'tx_sitereports_domain_model_worklog',
            $where
        );

        $statistics = $db->exec_SELECTgetRows(
            'sum(time_spent) as time, internal, project_code' . $select_extra,
            'tx_sitereports_domain_model_worklog',
            $where,
            $groupBy,
            $orderBy
        );
        if (is_array($statistics)) {
            array_walk(
                $statistics,
                '\MaxServ\SiteReports\Domain\Repository\WorklogRepository::getPercentageFromRow',
                $statisticsTotal['time']
            );
        }
        return $statistics;
    }

    /**
     * @param $item
     * @param $key
     * @param $total
     */
    private function getPercentageFromRow(&$item, $key, $total)
    {
        $item['percentage'] = $item['time'] * 100 / $total;
    }
}
