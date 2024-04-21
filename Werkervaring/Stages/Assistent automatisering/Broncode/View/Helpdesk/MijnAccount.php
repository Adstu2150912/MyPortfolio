<?php
//Laat geen geautomatiseerde PHP foutmeldingen zien in het HTML-document
error_reporting(0);

include "../../Utilities/BackendHelpdesk.php";

//Als er niet is ingelogd of de PHP-sessie is verlopen, dan moet de gebruiker worden teruggewezen naar het inlogpagina
if($_SESSION["ingelogd"] == "nee")
    header("Location: Inlogpagina-helpdesk.php");

$fp = fopen("../../Resource/JS/showError.js", "w");
fclose($fp);
?>

<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>MijnAccount</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/MijnAccount.css" media="screen">
    <script class="u-script" type="text/javascript" src="../../Resource/JS/jquery.js"></script>
    <meta name="generator" content="Nicepage 3.9.3, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "ModernIQ",
		"url": "index.html",
		"logo": "images/iq_logo.png"
}</script>
    <?php
    
    if($_POST["btnSubmit"] == "Opslaan")
    {
        $dbDomain->openConnection();
        $dmlStatement = "UPDATE users SET nachtModus = ? WHERE username = ?;";
        $strDataTypes = "is";
        $_POST["rgNachtModus"] = filter_input(INPUT_POST, "rgNachtModus", FILTER_SANITIZE_NUMBER_INT);
        $aValues = [$_POST["rgNachtModus"], $_SESSION["username"]];
        $numAffectedRows = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");
        $dbDomain->closeConnection();
        $_SESSION["nachtmodus"] = $_POST["rgNachtModus"];
        header("Location: index.php");
    }
    
    ?>
    <?php 
    if ($_SESSION['ingelogd']=="ja")
    {
        echo "<script type=\"text/javascript\"> $(document).ready(function () {" 
        .  " $('header').append('<div id=\"accountBox\">"
        . "<a href=\"Inlogpagina-helpdesk.php?ingelogd=nee\" title=\"logoutknop\">Uitloggen</a></div>')" 
        . "});</script>";
    }
    
    if($_SESSION["nachtmodus"] == "1")
    {
        echo "<script type=\"text/javascript\"> $(document).ready(function () {"
        . "$('header').append('<a href=\"index.php\"><img src=\"../../Resource/IMG/iq_logo(nachtmodus).png\" class=\"u-logo-image u-logo-image-1\" data-image-width=\"317.75\" style=\"height:100px\">');"
        . "$('#rbAan').prop('checked', 'true');"
        . "$('body').css('background', 'black');"
        . "$('body').css('color', '#ddd');"
        . "$('header').css('background', '#4B4B4B');"
        . "$('#main > *').css('background-color', '#4B4B4B');"
        . "$('thead').css('color', '#ffffff');"
        . "$('thead').css('background-color', '#696969');" 
        . "$('#txtWachtwoord').css('color', 'black');"
        . "$('#btnSubmit').addClass('u-border-white');"
        . "$('#btnSubmit').addClass('u-hover-white');"
        . "$('#btnSubmit').addClass('u-text-white');"
        . "$('#btnSubmit').addClass('u-text-hover-black');"
        . "$('#btnSubmit').css('border', '0 none #fff !important');"
        . "$('.u-btn').addClass('u-border-white');"
        . "$('.u-btn').addClass('u-hover-white');"
        . "$('.u-btn').addClass('u-text-white');"
        . "$('.u-btn').addClass('u-text-hover-black');"
        . "$('.u-btn').css('border', '0 none #fff !important');"
        . "});</script>";
    }
    else
    {
        echo "<script type=\"text/javascript\"> $(document).ready(function () {"
        . "$('header').append('<a href=\"index.php\"><img src=\"../../Resource/IMG/iq_logo(lichtmodus).png\" class=\"u-logo-image u-logo-image-1\" data-image-width=\"317.75\" style=\"height:100px\">');"
        . "$('#rbUit').prop('checked', 'true');"
        . "$('body').css('background', '#ffffff');"
        . "$('body').css('color', '#111111');"
        . "$('#btnSubmit').addClass('u-border-black');"
        . "$('#btnSubmit').addClass('u-hover-black');"
        . "$('#btnSubmit').addClass('u-text-black');"
        . "$('#btnSubmit').addClass('u-text-hover-white');"
        . "$('#btnSubmit').css('border', '0 none transparent !important');"
        . "$('.u-btn').addClass('u-border-black');"
        . "$('.u-btn').addClass('u-hover-black');"
        . "$('.u-btn').addClass('u-text-black');"
        . "$('.u-btn').addClass('u-text-hover-white');"
        . "$('.u-btn').css('border', '0 none transparent !important');"
        . "});</script>";
    }
    ?>
    <?php
        echo "<script type=\"text/javascript\"> $(document).ready(function () {"
        . "$('#rbAan').change(function(){"
        . "if($('#rbAan').prop('checked') == true) {"
        . "$('header').empty();"
        . "$('header').append('<a href=\"index.php\"><img src=\"../../Resource/IMG/iq_logo(nachtmodus).png\" class=\"u-logo-image u-logo-image-1\" data-image-width=\"317.75\" style=\"height:100px\">');"
        . "$('body').css('background', 'black');"
        . "$('body').css('color', '#ddd');"
        . "$('#main > *').css('background-color', '#4B4B4B');"
        . "$('#txtWachtwoord').css('color', 'black');"
        . "$('header').css('background', '#4B4B4B');"        
        . "$('#btnSubmit').removeClass('u-border-black');"
        . "$('#btnSubmit').removeClass('u-hover-black');"
        . "$('#btnSubmit').removeClass('u-text-black');"
        . "$('#btnSubmit').removeClass('u-text-hover-white');"
        . "$('#btnSubmit').addClass('u-border-white');"
        . "$('#btnSubmit').addClass('u-hover-white');"
        . "$('#btnSubmit').addClass('u-text-white');"
        . "$('#btnSubmit').addClass('u-text-hover-black');"
        . "$('#btnSubmit').css('border', '0 none #fff !important');"
        . "$('.u-btn').removeClass('u-border-black');"
        . "$('.u-btn').removeClass('u-hover-black');"
        . "$('.u-btn').removeClass('u-text-black');"
        . "$('.u-btn').removeClass('u-text-hover-white');"
        . "$('.u-btn').addClass('u-border-white');"
        . "$('.u-btn').addClass('u-hover-white');"
        . "$('.u-btn').addClass('u-text-white');"
        . "$('.u-btn').addClass('u-text-hover-black');"
        . "$('.u-btn').css('border', '0 none #fff !important');"
        . "}});"
        . "$('#rbUit').change(function(){"
        . "if($('#rbUit').prop('checked') == true){"
        . "$('header').empty();"
        . "$('header').append('<a href=\"index.php\"><img src=\"../../Resource/IMG/iq_logo(lichtmodus).png\" class=\"u-logo-image u-logo-image-1\" data-image-width=\"317.75\" style=\"height:100px\">');"
        . "$('body').css('background', '#ffffff');"
        . "$('body').css('color', 'black');"
        . "$('header').css('background', '#999999');"
        . "$('#main > *').css('background-color', '#FFFFFF');"
        . "$('#btnSubmit').removeClass('u-border-white');"
        . "$('#btnSubmit').removeClass('u-hover-white');"
        . "$('#btnSubmit').removeClass('u-text-white');"
        . "$('#btnSubmit').removeClass('u-text-hover-black');"
        . "$('#btnSubmit').addClass('u-border-black');"
        . "$('#btnSubmit').addClass('u-hover-black');"
        . "$('#btnSubmit').addClass('u-text-black');"
        . "$('#btnSubmit').addClass('u-text-hover-white');"
        . "$('#btnSubmit').css('border', '0 none transparent !important');"
        . "$('.u-btn').removeClass('u-border-white');"
        . "$('.u-btn').removeClass('u-hover-white');"
        . "$('.u-btn').removeClass('u-text-white');"
        . "$('.u-btn').removeClass('u-text-hover-black');"
        . "$('.u-btn').addClass('u-border-black');"
        . "$('.u-btn').addClass('u-hover-black');"
        . "$('.u-btn').addClass('u-text-black');"
        . "$('.u-btn').addClass('u-text-hover-white');"
        . "$('.u-btn').css('border', '0 none transparent !important');"
        . "}});"
        . "});</script>";
    ?>
    
    <meta property="og:title" content="MijnAccount">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.php">
    <meta property="og:url" content="index.php">
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <script class="u-script" type="text/javascript" src="../../Resource/JS/nicepage.js" defer=""></script>
  </head>
  <body class="u-body">
      <header class="u-clearfix u-grey-40 u-header u-header" id="sec-aa4e">
      </header>
    <div id="mainContainer">
        <div id="main">
            <section id="navMenu">
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>                
                <a href="Relatieform.php?typeForm=new" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Nieuw relatiekaart</a>                
                <a href="Zoekvenster-registraties.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Zoek registratie(s)</a>
                <a href="Zoekvenster-helpdeskitems.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Zoek helpdesk</a>
                <a href="Registratieoverzicht.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Kantorenlijst</a>
                <a href="TotaalAgenda.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Algemene agenda</a>
                <a href="TotaalAgenda.php?agenda=cm" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Conny</a>
                <a href="TotaalAgenda.php?agenda=el" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Esther</a>
                <a href="TotaalAgenda.php?agenda=rl" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Rodney</a>
                <a href="Selectievenster.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Selecties</a>
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
            </section>
            <section class="u-align-center u-section-1" id="sec-3b87">
              <div class="u-clearfix u-sheet u-sheet-1">
                <h5 class="u-text u-text-default u-text-1">Mijn account: <?php echo "<b>" . $_SESSION['fullname'] . "<br> (" . $_SESSION['email'] . "</b>)";?></h5>
                <div class="u-expanded-width u-table u-table-responsive u-table-1">
                    <form action="MijnAccount.php" method="POST" name="frmMijnAccount">
                      <table class="u-table-entity u-table-entity-1">
                        <colgroup>
                          <col width="50%">
                          <col width="50%">
                        </colgroup>
                        <tbody class="u-table-body">
                          <tr style="height: 65px;">
                            <td class="u-table-cell">Nachtmodus:</td>
                            <td class="u-table-cell">
                                <input type="radio" id="rbAan" name="rgNachtModus" value="1"><label for="rbAan">Aan</label>
                                <input type="radio" id="rbUit" name="rgNachtModus" value="0"><label for="rbUit">Uit</label>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                      <input type="submit" name="btnSubmit" id="btnSubmit" value="Opslaan" class="u-border-2 u-btn u-button-style u-none u-btn-1">
                    </form>
                </div>
              </div>
            </section>
        </div>
    </div>
  </body>
</html>