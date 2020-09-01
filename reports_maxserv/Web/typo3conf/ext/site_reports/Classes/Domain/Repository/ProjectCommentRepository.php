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

use TYPO3\CMS\Backend\Utility\BackendUtility;
use TYPO3\CMS\Core\Database\DatabaseConnection;
use TYPO3\CMS\Extbase\Persistence\Repository;

/**
 * Class ProjectCommentRepository
 * @package MaxServ\SiteReports\Domain\Repository
 */
class ProjectCommentRepository extends Repository
{
	/**
	 * @return DatabaseConnection
	 */
	protected function getDatabaseConnection()
	{
		return $GLOBALS['TYPO3_DB'];
	}

	/**
	 * @return array
	 */
	public function getCommentsOnProject()
	{
		$db = $this->getDatabaseConnection();

		$enableFields = BackendUtility::deleteClause('tx_sitereports_domain_model_projectcomment');
		$enableFields .= BackendUtility::BEenableFields('tx_sitereports_domain_model_projectcomment');

		$where = '1=1' . $enableFields;

		$dataArray = (array)$db->exec_SELECTgetRows(
			'tstamp, comment, project',
			'tx_sitereports_domain_model_projectcomment',
			$where
		);

		return $dataArray;
	}

}
