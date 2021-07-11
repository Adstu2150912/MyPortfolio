<?php

/* 
Een restcontroller voor correcte verwijzingen van clientverzoeken naar toebehorende functionaliteit
*/


require_once $_SERVER['DOCUMENT_ROOT'] . "/Utility/DBRestHandler.php";

		
$view = "";
$dml = ""; //Soort SQL-statement in de Data-Manipulation Language dat verwacht uitgevoerd te worden
$table = "";
$condition = "";
$statement = "";

$dbRestHandler = new DBRestHandler();

if(isset($_GET["view"]))
    $view = $_GET["view"];

if(isset($_GET["dml"]))
    $dml = $_GET["dml"];

if(isset($_GET["table"]))
    $table = $_GET["table"];

if(isset($_GET["condition"]))
    $condition = $_GET["condition"];

if(isset($_GET["statement"]))
    $statement = $_GET["statement"];
    
/*
onderstaande switch blokken bevat URL-mapping
waarin URL query van de client op geldigheid en soort verzoek gecontrolleerd wordt, bij aanvang van deze RESTful service
*/

switch($view)
{
    case "all":
        $dbRestHandler->getAllResults($table);
        break;

    case "single":
        $dbRestHandler->getResult($table, $condition);
        break;

    case "" :
        //404 - not found;
        break;
}

switch($dml)
{
    case "insert":
        $dbRestHandler->executeDML($statement);
        break;
    case "update":
        $dbRestHandler->executeDML($statement);
        break;
    case "delete":
        $dbRestHandler->executeDML($statement);
        break;
    case "":
        //404 - not found;
        break;
}

?>

