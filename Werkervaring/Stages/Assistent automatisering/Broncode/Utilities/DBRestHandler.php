<?php

/* 
    Een utiliteitsklasse voor het verwerken van verzoeken uit de centrale telefooncentrale (API) van 3CX naar de centrale MySQL database
*/

require_multi($_SERVER['DOCUMENT_ROOT'] . "/Utilities/SimpleRestUtility.php", $_SERVER['DOCUMENT_ROOT'] . "/Model/DBDomain.php");

function require_multi($files) {
    $files = func_get_args();
    foreach($files as $file)
        require_once($file);
}
		
class DBRestHandler extends SimpleRestUtility 
{
    public function encodeJson($responseData) 
    {
        $jsonResponse = json_encode($responseData);
        return $jsonResponse;		
    }
    
    public function getResult($table, $condition, $queryType, $strDataTypes, $aValues) 
    {
        $dbDomain = new DBDomain();
        $dbDomain->openConnection();
        $rawData = $dbDomain->getResult($table, $condition, true, $strDataTypes, $aValues);
        $this->setResult($rawData, $queryType);
        $dbDomain->closeConnection();
    }
    
    public function setResult($rawData, $queryType)
    {
        if(empty($rawData) || $rawData === false)
            $this->resultError();
        else
        {
            if($rawData->num_rows > 0)
            {
                $statusCode = 200;
                $requestContentType = 'application/json';
                $this->setHttpHeaders($requestContentType, $statusCode);
                //Als HTML-tekst hieronder niet gevonden is, dan moet deze WEL in JSON geformateerd worden.
                if(is_string($rawData) !== true)
                {
                    switch ($queryType)
                    {
                        case "searchPhoneNum":
                            $json_array = null;

                            while($row = mysqli_fetch_assoc($rawData))
                            {
                                $aResult["result"]["contact"]["id"] = $row["registratieID"];
                                $aResult["result"]["contact"]["company"] = $row["kantoorNaam"];
                                $aResult["result"]["contact"]["businessphone"] = $row["telNr1"];
                                $aResult["result"]["contact"]["businessphone2"] = $row["telNr2"];
                                $aResult["result"]["contact"]["email"] = $row["emailAdres"];
                                $aResult["result"]["contact"]["person"] = $row["contactpersoonFormelenaam"];
                                $aResult["result"]["contact"]["firstname"] = $row["contactpersoonVoornaam"];
                                $aResult["result"]["contact"]["lastname"] = $row["contactpersoonAchternaam"];
                                $json_array = $aResult;
                            }

                            if(strpos($requestContentType,'application/json') !== false)
                            {
                                if(!isset($json_array))
                                    echo $this->encodeJson($rawData);
                                else
                                    echo $this->encodeJson($json_array);           
                            }
                            else
                                $this->resultError();
                            break;
                    }
                }
                else
                    $this->resultError();
            }
            else
                $this->resultError();
        }
    }
    
    public function resultError()
    {
        $statusCode = 404;
        $rawData = array('error' => 'No data found!');
        $requestContentType = 'application/json';
        $this->setHttpHeaders($requestContentType, $statusCode);
        echo $this->encodeJson($rawData);
    }
    
    public function accessDenied()
    {
        $statusCode = 401;
        $rawData = array('error' => 'Access denied!');
        $requestContentType = 'application/json';
        $this->setHttpHeaders($requestContentType, $statusCode);
        $response = $this->encodeJson($rawData);
        
        echo $response;
    }
}
?>