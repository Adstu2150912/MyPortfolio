<?php
//Laat geen geautomatiseerde PHP foutmeldingen zien in het HTML-document
error_reporting(0);
include "../../Utilities/BackendHelpdesk.php";
?>

<?php

//Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
$fp = fopen("../../Resource/JS/addUI.js", "w");
fclose($fp);
$fp = fopen("../../Resource/JS/showError.js", "w");
fclose($fp);

$jQueryShowError = "$(document).ready(function () {";
$jQueryVerversForm = "$(document).ready(function () {";

try
{
    if(filter_input(INPUT_POST, "btnSubmit", FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW) === "Login" && $_POST["txtWachtwoord"] !== "*****")
    {        
        //Geef de gebruiker alleen toegang als het ingevoerde wachtwoord alleen alfabetische karakters, cijfers en/of underscores bevat
        if(preg_match("/^\w+$/", $_POST["txtWachtwoord"]) === 1)
        {
            $dbDomain->openConnection();
            $table = "users";
            $condition = " WHERE active = 1 AND username = ? AND password = ?;";
            $strDataTypes = "ss";
            $aValues = [$_POST["txtInlogNaam"], $_POST["txtWachtwoord"]];
            $result = $dbDomain->getResult($table, $condition, true, $strDataTypes, $aValues);

            if ($result != false)
            {
                if($result->num_rows > 0)
                {
                    $row = $result->fetch_assoc();
                    $_SESSION['ingelogd'] = "ja";
                    if ($row["admin"] == "1")
                        $_SESSION['ingelogdAdmin']="ja";
                    else
                        $_SESSION['ingelogdAdmin']="nee"; 
                    $_SESSION['username'] = $row["username"];                    
                    $_SESSION['fullname'] = $row["fullname"];
                    $_SESSION['password'] = $row["password"];
                    if($_POST["chkRememberMe"] === "on")
                        $_SESSION['rememberMe'] = true;
                    $_SESSION['nachtmodus'] = $row["nachtModus"];
                    $_SESSION['email'] = $row["email"];
//                    if (ini_get("session.use_cookies"))
//                        $params = session_get_cookie_params(); 
//
//                    if(isset($params) && !empty($params))
//                    {
//                        setcookie("username",$row["username"], ["expires" => (time() + 100), "path" => $params["path"], "domain" => $params["domain"], "secure" => $params["secure"], "httponly" => $params["httponly"], "samesite" => "Strict"]);
//                        if ($_POST["chkRememberMe"] == "true")
//                        {
//                            setcookie("password",$row["password"], ["expires" => (time() + 100), "path" => $params["path"], "domain" => $params["domain"], "secure" => $params["secure"], "httponly" => $params["httponly"], "samesite" => "Strict"]);
//                        }
//                        else
//                        {
//                            setcookie("password","",0,"","",0);
//                        }
//                    }
                    $result->free();
                    
                    $dbDomain->closeConnection();
                    header("Location: index.php"); 
                }
                else
                    throw new Exception("Ingevoerde inloggegevens bestaan niet in IQ. Voer uw geldige inloggegevens.");
            }
            else
                throw new Exception("Ingevoerde inloggegevens bestaan niet in IQ. Voer uw geldige inloggegevens.");
        }
        else
            throw new Exception("Ingevoerde wachtwoord mag alleen alfabetische karakters, cijfers en/of underscores bevatten");
    }
    else if(filter_input(INPUT_GET, "ingelogd", FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW) === "nee")
    {
        if(!empty($_SESSION['rememberMe']))
        {
           $jQueryVerversForm .= "$('#txtInlogNaam').val('" . $_SESSION['username'] ."');";
           $jQueryVerversForm .= "$('#txtWachtwoord').val('" . $_SESSION['password'] ."');";
           $jQueryVerversForm .= "$('#checkbox-34ee').prop('checked', true);";
        }

        unset($_SESSION['password']);
        unset($_SESSION['username']);
        unset($_SESSION['fullname']);
        unset($_SESSION['email']);
        unset($_SESSION['ingelogdAdmin']);
        $_SESSION['ingelogd'] = "nee";

    //    $_SESSION = array(); 

    //    if (ini_get("session.use_cookies")) 
    //    { 
    //        $params = session_get_cookie_params(); 
    //        setcookie(session_name(), '', time() - 42000, 
    //            $params["path"], $params["domain"], 
    //            $params["secure"], $params["httponly"], "Strict" 
    //        ); 
    //    }

    //    session_destroy();
    }
//    else
//    {
//        //Als de sessietijd verlopen is, zorg ervoor dat de inloggegevens onthouden blijven.
//        if(!empty($_SESSION['rememberMe']))
//        {
//           $jQueryVerversForm .= "$('#txtInlogNaam').val('" . $_SESSION['username'] ."');";
//           $jQueryVerversForm .= "$('#txtWachtwoord').val('" . $_SESSION['password'] ."');";
//           $jQueryVerversForm .= "$('#checkbox-34ee').prop('checked', true);";
//        }
//    }
   
}
catch(Exception $e)
{
    $jQueryShowError .= "alert('" . $e->getMessage() . "');";    
}

$jQueryShowError .= "});";
$jQueryVerversForm .= "});";

file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);

?>


<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Inlogpagina helpdesk</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
    <link rel="stylesheet" href="../../Resource/CSS/Inlogpagina-helpdesk.css" media="screen">
    <script class="u-script" type="text/javascript" src="../../Resource/JS/jquery.js"></script>
    <!--<script class="u-script" type="text/javascript" src="../../Resource/JS/nicepage.js" defer=""></script>-->
    <meta name="generator" content="Nicepage 3.7.2, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "ModernIQ",
		"url": "index.html",
		"logo": "images/iq_logo.png"
}</script>
    <script type="text/javascript" src="../../Resource/JS/addUI.js"></script>
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <meta property="og:title" content="Inlogpagina helpdesk">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
  </head>
  <body class="u-body">
      <header class="u-clearfix u-grey-40 u-header u-header" id="sec-aa4e">
        <img src="../../Resource/IMG/iq_logo(lichtmodus).png" class="u-logo-image u-logo-image-1" data-image-width="317.75" style="height:100px">
      </header>
    <section class="u-align-center u-clearfix u-section-1" id="sec-2f73">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-form u-form-1">
        <form action="Inlogpagina-helpdesk.php" method="POST" class="u-clearfix u-form-horizontal u-form-spacing-15 u-inner-form" style="padding: 15px" name="frmInlogHelpdesk">
            <div class="u-form-group u-form-name u-form-group-1">
              <label class="u-form-control-hidden u-label">Naam</label>
              <input type="text" placeholder="Inlognaam" id="txtInlogNaam" name="txtInlogNaam" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
            </div>
            <div class="u-form-group u-form-group-2">
              <label class="u-form-control-hidden u-label">Wachtwoord</label>
              <input type="password" placeholder="Wachtwoord" id="txtWachtwoord" name="txtWachtwoord" class="u-border-1 u-border-grey-30 u-input u-input-rectangle" required="required">
            </div>
            <div class="u-form-checkbox u-form-group u-form-group-3">
              <input type="checkbox" id="checkbox-34ee" name="chkRememberMe">
              <label for="checkbox-34ee" class="u-label">Onthoud mij</label>
            </div>
            <div class="u-form-group u-form-submit u-form-group-4">
              <input class="u-btn u-btn-submit u-button-style" name="btnSubmit" type="submit" value="Login">
            </div>
          </form>
        </div>
      </div>
    </section>
  </body>
</html>