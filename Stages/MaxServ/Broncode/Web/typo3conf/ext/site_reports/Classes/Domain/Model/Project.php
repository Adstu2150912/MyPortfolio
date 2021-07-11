<?php
namespace MaxServ\SiteReports\Domain\Model;

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

use TYPO3\CMS\Extbase\DomainObject\AbstractEntity;
use MaxServ\SiteReports\Domain\Model\ProjectCategory;
use TYPO3\CMS\Extbase\Persistence\ObjectStorage;

/**
 * Class Project
 * @package MaxServ\SiteReports\Domain\Model
 */
class Project extends AbstractEntity
{

    /** @var string */
    protected $key;

    /** @var string */
    protected $name;

    /** @var string */
    protected $avatar;

    /** @var int */
    protected $id;

    /** @var bool */
    protected $hidden;

    /** @var \MaxServ\SiteReports\Domain\Model\ProjectCategory */
    protected $category;

    /** @var  \TYPO3\CMS\Extbase\Persistence\ObjectStorage<\MaxServ\SiteReports\Domain\Model\ProjectField> */
    protected $fields;

    /** @var  \TYPO3\CMS\Extbase\Persistence\ObjectStorage<\MaxServ\SiteReports\Domain\Model\Worklog> */
    protected $worklogs;

	/** @var  \TYPO3\CMS\Extbase\Persistence\ObjectStorage<\MaxServ\SiteReports\Domain\Model\ProjectContact> */
	protected $contacts;

    /** @var  \MaxServ\SiteReports\Domain\Model\FrontendUserGroup */
    protected $tribe;

    /** @var int */
    protected $numberOfOpenIssues;

    /** @var int */
    protected $totalContractHours;

    /**
     * @return void
     */
    protected function initStorageObjects()
    {
        $this->fields = new \TYPO3\CMS\Extbase\Persistence\ObjectStorage();
        $this->worklogs = new \TYPO3\CMS\Extbase\Persistence\ObjectStorage();
		$this->contacts = new \TYPO3\CMS\Extbase\Persistence\ObjectStorage();
    }

    /**
     * @return string
     */
    public function getKey()
    {
        return $this->key;
    }

    /**
     * @param string $key
     */
    public function setKey($key)
    {
        $this->key = $key;
    }

    /**
     * @return string
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * @param string $name
     */
    public function setName($name)
    {
        $this->name = $name;
    }

    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return ProjectCategory
     */
    public function getCategory()
    {
        return $this->category;
    }

    /**
     * @param ProjectCategory $category
     */
    public function setCategory($category)
    {
        $this->category = $category;
    }

    /**
     * @return \TYPO3\CMS\Extbase\Persistence\ObjectStorage
     */
    public function getFields()
    {
        return $this->fields;
    }

    /**
     * @param \TYPO3\CMS\Extbase\Persistence\ObjectStorage $fields
     */
    public function setFields($fields)
    {
        $this->fields = $fields;
    }

	/**
	 * @param ProjectField $field
	 */
	public function addField($field)
	{
		if (!$this->fields instanceof ObjectStorage) {
			$this->initStorageObjects();
		}

		$this->fields->attach($field);
	}

	/**
	 * @return \TYPO3\CMS\Extbase\Persistence\ObjectStorage
	 */
	public function getContacts()
	{
		return $this->contacts;
	}

	/**
	 * @param \TYPO3\CMS\Extbase\Persistence\ObjectStorage $contacts
	 */
	public function setContacts($contacts)
	{
		$this->contacts = $contacts;
	}

    /**
     * @param ProjectContact $contact
     */
    public function addContact($contact)
    {
        if (!$this->contacts instanceof ObjectStorage) {
            $this->initStorageObjects();
        }

        $this->contacts->attach($contact);
    }

    /**
     * @return bool
     */
    public function isHidden()
    {
        return $this->hidden;
    }

    /**
     * @param bool $hidden
     */
    public function setHidden($hidden)
    {
        $this->hidden = $hidden;
    }

    /**
     * @return int
     */
    public function getNumberOfOpenIssues()
    {
        return $this->numberOfOpenIssues;
    }

    /**
     * @param int $numberOfOpenIssues
     */
    public function setNumberOfOpenIssues($numberOfOpenIssues)
    {
        $this->numberOfOpenIssues = $numberOfOpenIssues;
    }

    /**
     * @return FrontendUserGroup
     */
    public function getTribe()
    {
        return $this->tribe;
    }

    /**
     * @param FrontendUserGroup $tribe
     */
    public function setTribe($tribe)
    {
        $this->tribe = $tribe;
    }

	/**
	 * @return string
	 */
	public function getAvatar()
	{
		return $this->avatar;
	}

	/**
	 * @param string $avatar
	 */
	public function setAvatar($avatar)
	{
		$this->avatar = $avatar;
	}

    /**
     * @return ObjectStorage
     */
    public function getWorklogs()
    {
        return $this->worklogs;
    }

    /**
     * @param ObjectStorage $worklogs
     */
    public function setWorklogs($worklogs)
    {
        $this->worklogs = $worklogs;
    }


    /**
     * @param Worklog $worklog
     */
    public function addWorklog($worklog)
    {
        if (!$this->worklogs instanceof ObjectStorage) {
            $this->initStorageObjects();
        }

        $this->worklogs->attach($worklog);
    }
	/*Haal hier uitkomst op door vermenigvuldiging van contracturen met contractsduur*/
	/*Bepaal totaal aantal contracturen aan de hand van contractsduur*/
	/**
	 * @return string
	 */
	public function getTotalContractHours()
	{
		return $this->totalContractHours;
	}

	/**
	 * @param int $contractHours
	 * @param $period
	 */
	public function setTotalContractHours($contractHours, $period)
	{
		switch ($period){
			case "kwartaal":
				$this->totalContractHours = $contractHours * 3;
				break;
			case "maand":
				$this->totalContractHours = $contractHours * 12;
				break;
			case "eenmalig":
				$this->totalContractHours = $contractHours;
				break;
			default:
				$this->totalContractHours = $contractHours * 12;
				break;
		}

	}
}
