<?php
require_once $_SERVER['DOCUMENT_ROOT'] . "/Controller/DBController.php";

/* 
Een domein klasse voor het verwerken van verzoeken naar de centrale online SQL-server
*/
Class DBDomain 
{	
    private $aResult = array();
	
    public function getAllResults($table){
            $query = "SELECT * FROM " . $table;
            $dbcontroller = new DBController();
            $this->aResult = $dbcontroller->executeSelectQuery($query);
            return $this->aResult;
    }

    public function getResult($table, $condition){
            $condition = str_replace("EQUALS", "=", $condition);
            $condition = str_replace("_", " ", $condition);
            if(empty($condition))
            {
                $query = "SELECT * FROM " . $table;
            }  
            else
            {
                $query = "SELECT * FROM " . $table . " WHERE " . $condition;
            }                
            $dbcontroller = new DBController();
            $this->aResult = $dbcontroller->executeSelectQuery($query);
            
            return $this->aResult;
    }
    
    public function executeDML($statement)
    {
        $dbcontroller = new DBController();
        $statement = str_replace("EQUALS", "=", $statement);
        $statement = str_replace("_", " ", $statement);
        $this->aResult = $dbcontroller->executeDML($statement);
        if($this->aResult > 0){
            $this->aResult = array('success'=>1);
            return $this->aResult;
        }
        else
        {
            $this->aResult = array('success'=>0);
            return $this->aResult;
        }
    }
}
?>

