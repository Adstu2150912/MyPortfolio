<?php

/* 
Een utiliteitsklasse voor het verwerken van verzoeken naar de centrale online SQL-server
*/

require_multi($_SERVER['DOCUMENT_ROOT'] . "/Utility/SimpleRestUtility.php", $_SERVER['DOCUMENT_ROOT'] . "/Domain/Model/DBDomain.php");

function require_multi($files) {
    $files = func_get_args();
    foreach($files as $file)
        require_once($file);
}

		
class DBRestHandler extends SimpleRestUtility {

    function getAllResults($table) {	
        $dbDomain = new DBDomain();
        $rawData = $dbDomain->getAllResults($table);

        if(empty($rawData)) {
            $statusCode = 404;
            $rawData = array('error' => 'No data found!');
        } 
        else
            $statusCode = 200;

        $requestContentType = 'application/json'; // $_POST['HTTP_ACCEPT']; $_SERVER['HTTP_ACCEPT'];
        $this ->setHttpHeaders($requestContentType, $statusCode);

        //Als HTML-tekst hieronder gevonden is, dan moet deze NIET in JSON geformateerd worden. Deze string is hoogstwaarschijnlijk een (PHP-gerelateerde) automatisch gegenereerde (fout/waarschuwing) melding van de server
        if(is_string($rawData) === true)
        {
            if(preg_match("/<[^<]+>/",$rawData, $matches) === 1)
            {
                //echo $rawData;
            }
        }
        else
        {
            $json_array = array();
            while($row = mysqli_fetch_assoc($rawData))
            {
                $json_array[] = $row;
            }
            //$result["output"] = $rawData->fetch_all();

            if(strpos($requestContentType,'application/json') !== false){
                if(!isset($json_array[0]))
                    $response = $this->encodeJson($rawData);
                else
                    $response = $this->encodeJson($json_array);
                echo $response;
            }
    //        else if(strpos($requestContentType,'text/html') !== false){
    //                $response = $this->encodeHtml($rawData);
    //                echo $response;
    //        } else if(strpos($requestContentType,'application/xml') !== false){
    //                $response = $this->encodeXml($rawData);
    //                echo $response;
    //        }
        }
        

    }

    public function encodeHtml($responseData) 
    {
        $htmlResponse = "<table border='1'>";
        foreach($responseData as $key=>$value) {
            $htmlResponse .= "<tr><td>". $key. "</td><td>". $value. "</td></tr>";
        }
        $htmlResponse .= "</table>";
        return $htmlResponse;		
    }

    public function encodeJson($responseData) 
    {
        $jsonResponse = json_encode($responseData);
        return $jsonResponse;		
    }

    public function encodeXml($responseData) 
    {
        // maak een nieuw object aan uit de klasse 'SimpleXMLElement'
        $xml = new SimpleXMLElement('<?xml version="1.0"?><cursus></cursus>');
        foreach($responseData as $key=>$value) {
            $xml->addChild($key, $value);
        }
        return $xml->asXML();
    }

    public function getResult($table, $condition) 
    {
        $dbDomain = new DBDomain();
        $rawData = $dbDomain->getResult($table, $condition);

        if(empty($rawData)) {
            $statusCode = 404;
            $rawData = array('error' => 'No data found!');		
        } else {
            $statusCode = 200;
        }

        $requestContentType = 'application/json';//$_SERVER['HTTP_ACCEPT'];
        $this ->setHttpHeaders($requestContentType, $statusCode);

        //Als HTML-tekst hieronder gevonden is, dan moet deze NIET in JSON geformateerd worden. Deze string is hoogstwaarschijnlijk een (PHP-gerelateerde) automatisch gegenereerde (fout/waarschuwing) melding van de server
        if(is_string($rawData) === true)
        {
            if(preg_match("/<[^<]+>/",$rawData, $matches) === 1)
            {
                //echo $rawData;
            }  
        }
        else
        {
            $json_array = array();
           
            while($row = mysqli_fetch_assoc($rawData))
            {
                $json_array[] = $row;
            }
            //$result["output"] = $rawData->fetch_all();

            if(strpos($requestContentType,'application/json') !== false){
                if(!isset($json_array[0]))
                    $response = $this->encodeJson($rawData);
                else
                    $response = $this->encodeJson($json_array);
                echo $response;
            }
    //        else if(strpos($requestContentType,'text/html') !== false){
    //                $response = $this->encodeHtml($rawData);
    //                echo $response;
    //        } else if(strpos($requestContentType,'application/xml') !== false){
    //                $response = $this->encodeXml($rawData);
    //                echo $response;
    //        }
        }
    }
    
    public function executeDML($statement)
    {
        $dbDomain = new DBDomain();
        $rawdata = $dbDomain->executeDML($statement);
        
        if(empty($rawData)) {
            $statusCode = 404;
            $rawData = array('success' => 0);		
        } else {
            $statusCode = 200;
        }
        
        $requestContentType = 'application/json'; //$_SERVER['HTTP_ACCEPT'];
        $this ->setHttpHeaders($requestContentType, $statusCode);
        //$result = $rawData;

        //Als HTML-tekst hieronder gevonden is, dan moet deze NIET in JSON geformateerd worden. Deze string is hoogstwaarschijnlijk een (PHP-gerelateerde) automatisch gegenereerde (fout/waarschuwing) melding van de server
        if(is_string($rawData) === true)
        {
            if(preg_match("/<[^<]+>/",$rawData, $matches) === 1)
            {
                //echo $rawData;
            }  
        }
        else
        {
//            $json_array = array();
//
//            while($row = mysqli_fetch_assoc($rawData))
//            {
//                $json_array[] = $row;
//            }

            //$result["output"] = $rawData->fetch_all();
    //        else if(strpos($requestContentType,'text/html') !== false){
    //                $response = $this->encodeHtml($rawData);
    //                echo $response;
    //        } else if(strpos($requestContentType,'application/xml') !== false){
    //                $response = $this->encodeXml($rawData);
    //                echo $response;
    //        }
            if(strpos($requestContentType,'application/json') !== false){
                $response = $this->encodeJson($rawData);
                echo $response;
            }
        }      
    }
}
?>

