<?php
require_once $_SERVER['DOCUMENT_ROOT'] . "/Controller/DBController.php";

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 18-02-2021
 * Project: Afstudeeropdracht - ModernIQ
 * Bestandsnaam: DBDomain.php
 * Omschrijving: Een domein klasse voor het verwerken van verzoeken naar de centrale lokale SQL-server
 */
Class DBDomain
{
    private $aResult = array();
    private $dbController;
    private $prepStatement;
    
    public function getAllFields($table)
    {        
        $query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS"
        . " WHERE TABLE_NAME = ? AND TABLE_SCHEMA = 'iqdb';";
        if($this->dbController != null)
        {
            $stmt = $this->dbController->prepareStatement($query, $$table);
            if($stmt instanceof mysqli_stmt) 
            {
                $stmt->bind_param("s", $table);
                $this->aResult = $this->dbController->executeStatement($stmt, 'query');
            }
            else 
                $this->aResult = false;
        }
        return $this->aResult; 
    }
    
    public function getAllResults($table)
    {
        $query = "SELECT * FROM " . $table;
        if($this->dbController != null)
        {
            $stmt = $this->dbController->prepareStatement($query, $table);
            if($stmt instanceof mysqli_stmt) 
            {                
                $this->aResult = $this->dbController->executeStatement($stmt, 'query');
            }
            else 
                $this->aResult = false;
        }
        return $this->aResult;
    }
    
    public function getResult($table, $condition, $bindParam, $strDataTypes, $aValues)
    {
        if(!empty($condition))
            $query = "SELECT * FROM " . $table . " " . $condition;
        if($this->dbController != null)
        {
            $stmt = $this->dbController->prepareStatement($query, $table);
            if($stmt instanceof mysqli_stmt) 
            {
                if($bindParam)
                    $stmt->bind_param($strDataTypes, ...$aValues);
                $this->aResult = $this->dbController->executeStatement($stmt, 'query');
            }
            else 
                $this->aResult = false;
        }
        
        return $this->aResult;
    }
    
    public function getSelectiveResult($params, $table, $condition, $bindParam, $strDataTypes, $aValues) 
    {
        if(!empty($condition))
            $query = "SELECT " . $params . " FROM " . $table . " " . $condition;
        if($this->dbController != null)
        {
            $stmt = $this->dbController->prepareStatement($query, $table);
            if($stmt instanceof mysqli_stmt) 
            {
                if($bindParam)
                    if($strDataTypes === null)
                        $stmt->bind_param(...$aValues);
                    else
                        $stmt->bind_param($strDataTypes, ...$aValues);
                $this->aResult = $this->dbController->executeStatement($stmt, 'query');
            }
            else 
                $this->aResult = false;
        }
        
        return $this->aResult;
    }
    
    public function executeStatement($statement, $strDataTypes, $aValues, $dmlType)
    {
        if($this->dbController != null)
        {
            $stmt = $this->dbController->prepareStatement($statement, null);
            if($stmt instanceof mysqli_stmt) 
            {  
                if($dmlType === "insert" || $dmlType === "update" || $dmlType === "delete")
                {
                    if($strDataTypes === null)
                        $stmt->bind_param(...$aValues);
                    else
                        $stmt->bind_param($strDataTypes, ...$aValues);
                }
                $this->aResult = $this->dbController->executeStatement($stmt, $dmlType);
            }
            else 
                $this->aResult = false;
        }
        
        return $this->aResult;
    }
    
    public function openConnection()
    {
        $this->dbController = new DBController();
        $this->dbController->setDBConnection();
    }
    
    public function testConnection()
    {
        if($this->dbController != null)
            $this->dbController->setDBConnection();
    }
    
    public function closeConnection()
    {
        if($this->dbController != null)
            $this->dbController->closeConnection();    
        $this->dbController = null;
    }
}

