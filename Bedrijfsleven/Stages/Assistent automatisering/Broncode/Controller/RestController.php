<?php

/* 
    Een restcontroller voor correcte verwijzingen van clientverzoeken naar toebehorende functionaliteit
*/

require_once $_SERVER['DOCUMENT_ROOT'] . "/Utilities/DBRestHandler.php";

		
$view = "";
$phoneNum = ""; //telefoonnummer van een kantoor/klant gebruiken om telefoongesprek mee te beginnen
$callDirection = ""; //bepalen wat voor soort gesprek recent plaats vondt; van dit gesprek worden de meest belangrijke gegevens opgeslagen in de database
$grantAccess = false; //boolean flag om te bepalen of toegang tot deze REST API wordt aangenomen of geweigerd
$dbRestHandler = new DBRestHandler();

if(isset($_POST["view"]))
    $view = $_POST["view"];
if(isset($_POST["callDirection"]))
    $callDirection = $_POST["callDirection"];
if(isset($_POST["phone"]))
    $phoneNum = $_POST["phone"];


//Als gegeven API-sleutel gelijk is aan onderstaande UUID, dan pas mag toegang verleent worden 
if(isset($_POST["APIkey"]) && !empty($_POST["APIkey"]))
{
    if($_POST["APIkey"] == "50c0c49c-1a10-43b5-9510-8f89feb3b3ad")
        $grantAccess = true;
}

if($grantAccess)
{
    /*
    onderstaande switch blokken bevat URL-mapping
    waarin URL query van de client op geldigheid en soort verzoek gecontrolleerd wordt, bij aanvang van deze RESTful service
    */
    switch($view)
    {
        case "searchPhoneNum":
            //Onderstaande nummer mag alleen cijfers bevatten om SQL-injecties te voorkomen
            if(!empty($phoneNum) && preg_match("/^\d*$/", $phoneNum) === 1)
                $dbRestHandler->getResult("kantoor", " WHERE telNr1 = ? OR telNr2 = ?;", "searchPhoneNum", "ii", [$phoneNum, $phoneNum]);
            else
                $dbRestHandler->resultError();
            break;
        case "" :
            //404 - not found;
            break;
    }

}
else
{
    $dbRestHandler->accessDenied();
}



?>
