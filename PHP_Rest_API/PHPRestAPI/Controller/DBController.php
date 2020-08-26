<?php

/* 
Een databasecontroller voor het uitvoeren van opdrachten op de centrale online SQL-server, die voort zijn gekomen uit het verzoek van de client
*/


class DBController {
    protected $servername = "172.104.237.208";
    protected $username = "PROJECT";
    protected $userpassword = "Administrator1!";
    protected $serverpassword = "";
    protected $database = "beroepsProduct4";
    protected $dbport = 3306;
    
    private function setDBConnection()
    {
		//	Maak een SQL-verbinding aan
		//	$conn = mysqli_connect($this->servername, $this->username, $this->userpassword, $this->database, $this->dbport);
		//	echo $conn->server_info;
    }
    
    function executeDML($statement) 
    {
        $conn = mysqli_connect($this->servername, $this->username, $this->userpassword, $this->database, $this->dbport);   
        $result = mysqli_query($conn, $statement);
        if (!$result) {
            //check op redudantie
            if($conn->errno == 1062) {
                return false;
            } else {
                trigger_error (mysqli_error($conn),E_USER_NOTICE);				
            }
        }		
        
        $affectedRows = mysqli_affected_rows($conn);
        return $affectedRows;		
    }
    
    public function executeSelectQuery($query)
    {  
        $conn = mysqli_connect($this->servername, $this->username, $this->userpassword, $this->database, $this->dbport);

        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }
        else if(!$conn)
        {
            echo "Error: Unable to connect to MySQL." . PHP_EOL;
            echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
            echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
            exit;
        }
        else
        {
            //echo "Connected successfully (".$conn->host_info.")";
        }
        $results = mysqli_query($conn, $query);
//        if ($results === false ) {
//            echo mysqli_error($conn);
//        }    
        return $results;
    }
}

?>