<?php
$labelReferencePrefix = 'LLL:EXT:site_reports/Resources/Private/Language/Tca.xlf:tx_sitereports_domain_model_projectcomment';
$relativeExtensionPath = \TYPO3\CMS\Core\Utility\ExtensionManagementUtility::extRelPath('site_reports');

return array(
	'ctrl' => array(
		'title' => $labelReferencePrefix,
		'label' => 'comment',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden'
		),
		'iconfile' => $relativeExtensionPath . 'Resources/Public/Images/Icons/projectcomment.svg',
	),
	'types' => array(
		'1' => array(
			'showitem' => 'comment, project'
		)
	),
	'columns' => array(
		'comment' => array(
			'exclude' => 1,
			'label' => $labelReferencePrefix . '.comment',
			'config' => array(
				'type' => 'input',
				'eval' => 'trim,required',
			)
		),
		'project' => array(
			'exclude' => 1,
			'label' => $labelReferencePrefix . '.project',
			'config' => array(
				'type' => 'input',
				'eval' => 'trim,required',
			)
		),
	)
);
