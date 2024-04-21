<?php
$GLOBALS['TYPO3_CONF_VARS']['SC_OPTIONS']['extbase']['commandControllers'][] =
    'MaxServ\\SiteReports\\Command\\ImportWorklogsCommandController';
$GLOBALS['TYPO3_CONF_VARS']['SC_OPTIONS']['extbase']['commandControllers'][] =
    'MaxServ\\SiteReports\\Command\\ImportProjectsCommandController';
$GLOBALS['TYPO3_CONF_VARS']['SC_OPTIONS']['extbase']['commandControllers'][] =
    'MaxServ\\SiteReports\\Command\\ImportBoardsCommandController';

\TYPO3\CMS\Extbase\Utility\ExtensionUtility::configurePlugin(
    'MaxServ.SiteReports',
    'Statistics',
    array(
        'Hours' => 'statistics',
    ),
    array(
        'Hours' => 'statistics',
    )
);

\TYPO3\CMS\Extbase\Utility\ExtensionUtility::configurePlugin(
    'MaxServ.SiteReports',
    'Productivity',
    array(
        'Hours' => 'productivity',
    ),
    array(
        'Hours' => 'productivity',
    )
);

\TYPO3\CMS\Extbase\Utility\ExtensionUtility::configurePlugin(
    'MaxServ.SiteReports',
    'SupportList',
    array(
        'Support' => 'listProjects, show, listPdf, showPdf,',
    ),
    array(
        'Support' => 'listProjects, show, listPdf, showPdf',
    )
);

\TYPO3\CMS\Core\Utility\ExtensionManagementUtility::addTypoScript('reports', 'setup', '
config.tx_extbase.persistence.classes {
	MaxServ\SiteReports\Domain\Model\FrontendUser {
		mapping {
			tableName = fe_users
			recordType =
		 }
	}
	MaxServ\SiteReports\Domain\Model\FrontendUserGroup {
		mapping {
			tableName = fe_groups
			recordType =
		 }
	}
	MaxServ\SiteReports\Domain\Model\ProjectCategory {
		mapping {
			tableName = tx_sitereports_domain_model_projectcategory
			recordType =
		 }
	}
	MaxServ\SiteReports\Domain\Model\ProjectField {
		mapping {
			tableName = tx_sitereports_domain_model_projectfield
			recordType =
		 }
	}
	MaxServ\SiteReports\Domain\Model\Project {
		mapping {
			tableName = tx_sitereports_domain_model_project
			columns {
			    number_of_open_issues.mapOnProperty = numberOfOpenIssues
			}
		 }
	}
}
', 43);
$GLOBALS['TYPO3_CONF_VARS']['FE']['pageNotFound_handling'] = '';