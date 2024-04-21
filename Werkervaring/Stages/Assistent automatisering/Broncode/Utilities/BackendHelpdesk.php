<?php
//error_reporting(E_ERROR);
require_once $_SERVER['DOCUMENT_ROOT'] . "/Model/DBDomain.php";
$dbDomain = new DBDomain();
session_start();

date_default_timezone_set('Europe/Amsterdam'); //lokale tijdszone instellen
  
// based on original work from the PHP Laravel framework
if (!function_exists('str_contains')) 
{
    function str_contains($haystack, $needle) 
    {
        return $needle !== '' && mb_strpos($haystack, $needle) !== false;
    }
}            
  

if ($_GET["ingelogd"] == "nee" || !isset($_SESSION['username']) || empty($_SESSION['username']))
    $_SESSION['ingelogd'] = "nee";
else 
{
    //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
//    $fp = fopen("../../Resource/addUI.js", "w");
//    fclose($fp);
//    
//    file_put_contents("../Resource/addUI.js", $jQueryFillNav, FILE_APPEND);
}

//else if ($_SESSION['ingelogd']=="ja")
//{
//    echo "<script> $(document).ready( function () {" 
//    .  "$('header').append('<b><a href=\"mijnAccount.php\" title=\"accountKnop\">ingelogd als " . $_SESSION['fullname'] . "<br> (" . $_SESSION['email'] . ")</a></b>"
//    . "<a href=\"login.php?ingelogd=nee\" title=\"logoutknop\">uitloggen</a>')" 
//    . "});</script>";
//}
    
  
?>

