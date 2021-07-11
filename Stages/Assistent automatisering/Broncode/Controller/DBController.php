<?php

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 18-02-2021
 * Project: Afstudeeropdracht - ModernIQ
 * Bestandsnaam: DBController.php
 * Omschrijving: Een databasecontroller voor het uitvoeren van opdrachten op de centrale lokale SQL-server, die voort zijn gekomen uit het verzoek van de client
 */

class DBController 
{
//    protected $servername = "127.0.0.1";
//    protected $username = "root";
//    protected $userpassword = "tre!h9587sty#e";
    protected $servername = "moderniqdb.mysql.database.azure.com";
    protected $username = "AO13";
    protected $userpassword = "7G5HT44NnH4g3Zh";
    protected $serverpassword = "";
    protected $database = "iqdb";
    protected $dbport = 3306;
    protected $conn = "";
    public $rs = null;
    private $currentTable;
    
    //Onderstaande functie is om de database-verbinding te testen en bevestigen
    public function setDBConnection()
    {
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/showError.js", "w");
        fclose($fp);
        //  Maak een SQL-verbinding aan met de database
        $this->conn = new mysqli($this->servername, $this->username, $this->userpassword, $this->database, $this->dbport);
        if($this->conn->connect_errno)
        {

            $jQueryShowError = "$(document).ready(function () {";
            $jQueryShowError .= "alert(\"Verbinding database mislukt:" . $this->conn->connect_error . "\");";
            $jQueryShowError .= "});";
            file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
        }
    }
    
    function prepareStatement($statement, $table)
    {
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/showError.js", "w");
        fclose($fp);
        if ($this->conn->connect_error)
            die("MySQL-verbinding mislukt: " . $this->conn->connect_error); 
        $this->currentTable = $table;
        $prepStmt = $this->conn->prepare($statement);
        if($prepStmt instanceof mysqli_stmt)
            return $prepStmt;
        else
        {            
            $jQueryShowError = "$(document).ready(function () {";
            $jQueryShowError .= "alert(\"MySQL Errorcode " . $this->conn->errno . ":" .  $this->conn->error . "\");";
            $jQueryShowError .= "});";
            file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
            //trigger_error(htmlentities(mysqli_error($this->conn)),E_USER_ERROR);
            return false;
        }
    }
    
    function executeStatement($statement, $dmlType)
    {
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/showError.js", "w");
        fclose($fp);
        if($statement->execute())
        {
            switch($dmlType)
            {
                case "insert":
                    return $statement->insert_id;
                case "update":
                    return $statement->affected_rows;
                case "delete":
                    return $statement->affected_rows;
                case "query":
                    $resultSet = $statement->get_result();
                    if($resultSet != false)
                    {
                        if($resultSet->num_rows > 0)
                            return $resultSet;
                        else
                        {
                            //$this->showMsgNoResults();
                            return false;
                        }
                    }
                    else
                    {
                        $this->showMsgNoResults();
                        return false;
                    }
            }
        }
        else
        {            
            $jQueryShowError = "$(document).ready(function () {";
            $jQueryShowError .= "alert(\"MySQL Errorcode " . $statement->errno . ":" .  $statement->error . "\");";
            $jQueryShowError .= "});";
            file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
            return false;
            //trigger_error(htmlentities(mysqli_error($this->conn)),E_USER_ERROR);
        }
    }
    
    private function showMsgNoResults()
    {
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/showError.js", "w");
        fclose($fp);

        $jQueryShowError = "$(document).ready(function () {";
        $jQueryShowError .= "alert(\"Er zijn geen records gevonden in tabel '" . $this->currentTable . "'\");";
        $jQueryShowError .= "});";
        file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
    }
    
    public function closeConnection()
    {
        $this->rs = null;
        $this->conn->close();
        $this->conn = null;
    }
}