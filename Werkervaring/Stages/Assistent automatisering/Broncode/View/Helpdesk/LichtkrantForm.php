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
    <title>Lichtkrant</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
    <link rel="stylesheet" href="../../Resource/CSS/LichtkrantForm.css" media="screen">
    <script class="u-script" type="text/javascript" src="../../Resource/JS/jquery.js"></script>
    <script class="u-script" type="text/javascript" src="../../Resource/JS/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 3.8.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "ModernIQ",
		"url": "index.html",
		"logo": "images/iq_logo.png"
}</script>
    <?php
    if($_POST["btnSubmit"] == "Vastleggen")
    {
        $statusLichtKrant =  file_put_contents("../../Resource/Lichtkrant.txt", $_POST["txtLichtkrant"] . "\r\n" . $_POST["txtControleDatum"]);
    
        $lichtKrant = file_get_contents("../../Resource/Lichtkrant.txt");
    }
    ?>
    <?php 
    if ($_SESSION['ingelogd']=="ja")
    {
        echo "<script type=\"text/javascript\"> $(document).ready(function () {" 
        .  " $('header').append('<div id=\"accountBox\"><b><a href=\"MijnAccount.php\" title=\"accountKnop\">Ingelogd als " . $_SESSION['fullname'] . "<br> (" . $_SESSION['email'] . ")</a></b>"
        . " | <a href=\"Inlogpagina-helpdesk.php?ingelogd=nee\" title=\"logoutknop\">Uitloggen</a></div>')" 
        . "});</script>";
    }
    ?>
    <?php 
        if(isset($_GET["typeForm"]) && !empty($_GET["typeForm"]) && empty($_POST["typeForm"]))
        {
            $_POST["typeForm"] = $_GET["typeForm"];
            unset($_GET["typeForm"]);
        }        
    ?>
    <?php
        if($_SESSION["nachtmodus"] == "1")
        {
            echo "<script type=\"text/javascript\"> $(document).ready(function () {"
            . "$('header').append('<a href=\"index.php\"><img src=\"../../Resource/IMG/iq_logo(nachtmodus).png\" class=\"u-logo-image u-logo-image-1\" data-image-width=\"317.75\" style=\"height:100px\">');"
            . "$('body').css('background', 'black');"
            . "$('header').css('background', '#4B4B4B');"
            . "$('body').css('color', '#ddd');"
            . "$('#main > *').css('background-color', '#4B4B4B');"
            . "$('thead').css('color', '#ffffff');"
            . "$('thead').css('background-color', '#696969');" 
            . "$('#btnSubmit').addClass('u-border-white');"
            . "$('#btnSubmit').addClass('u-hover-white');"
            . "$('#btnSubmit').addClass('u-text-white');"
            . "$('#btnSubmit').addClass('u-text-hover-black');"
            . "$('input').css('color', 'black');"
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
    <script type="text/javascript" src="../../Resource/JS/addUI.js"></script>
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <meta property="og:title" content="Lichtkrantform">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.php">
    <meta property="og:url" content="index.php">
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
    <section class="u-clearfix u-section-1" id="sec-dd03">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h6 class="u-align-left u-text u-text-default u-text-1" id="formTitel">Lichtkrant Assistent CRM</h6>
        <div class="u-expanded-width u-table u-table-responsive u-table-1" id="mainContainer">
        <form action="LichtkrantForm.php" method="POST">
          <table class="u-table-entity">
            <colgroup>
              <col width="50%">
              <col width="50%">
            </colgroup>
            <tbody class="u-table-body">
              <tr style="height: 65px;">
                <td class="u-table-cell">
                    Ter info:
                    <br/>
                    Als de lichtkrant leeg dient te zijn, dan heeft deze minimaal 2 regels nodig.<b style="color:red">Zet in dat geval op 2 regels een spatie!</b>  
                    <br/>
                    <br/>
                    <br/>
                    1e regel: tekst van de lichtkrant. Aan één stuk, ZONDER enters.
                    <br/>
                    2e regel: url van de landingspagina
                </td>
              </tr>
              <tr style="height: 65px;">
                  <td class="u-table-cell"><b>Huidige tekst (lichtkrant in Assistent)</b></td>
              </tr>
              <tr>
                  <td class="u-table-cell"><textarea placeholder="" rows="2" cols="50" id="txtLichtkrant" name="txtLichtkrant" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"><?php echo str_replace(array("\r\n", "\n\r", "\r", "\n"),"&#13;&#10;",$lichtKrant) ?></textarea></td>
              </tr>
              <tr>
                  <td>
                      Assistent houdt op gebruikersniveau bij welk bericht als laatste is ontvangen. Als de datum hieronder wijzigt
                      <br/>
                      weet Assistent dat er een nieuw bericht klaar staat.
                  </td>
              </tr>
              <tr>
                  <td><b>Controledatum (JJJJMMDDHHMM)</b></td>
                  <td><input type="text" id="txtControleDatum" name="txtControleDatum" required=""></td>
              </tr>
            </tbody>
          </table>
        <input type="hidden" name="typeForm" value="<?php echo $_POST["typeForm"];?>">
        <input id="btnSubmit" name="btnSubmit" type="submit" class="u-border-2 u-btn u-button-style u-none u-btn-1" value="Vastleggen">
        </form>
        </div>
      </div>
    </section>
        </div>
    </div>
  </body>
</html>