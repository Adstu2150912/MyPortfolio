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
    <title>Zoekvenster helpdesk</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
    <link rel="stylesheet" href="../../Resource/CSS/Zoekvenster-helpdeskitems.css" media="screen">
    <script class="u-script" type="text/javascript" src="../../Resource/JS/jquery.js"></script>
    <script class="u-script" type="text/javascript" src="../../Resource/JS/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 3.9.0, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "ModernIQ",
		"url": "index.html",
		"logo": "images/iq_logo.png"
}</script>
    <?php
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/addUI.js", "w");
        fclose($fp);
        
        $dbDomain->openConnection();
        $table = "onderwerpen";
        $condition = " ORDER BY omschrijving;";
        $result = $dbDomain->getResult($table, $condition, false, null, null);
        
        if($result != false)
        {
            $jQueryVerversDdm = " $(document).ready(function () { $('#ddmCategorieVeld').append(\"";
            $jQueryVerversDdm .= "<option value='' selected>--Maak een keuze--</option>";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversDdm, FILE_APPEND);
            
            while($row = $result->fetch_assoc())
            {
                $jQueryVerversDdm = "<option value='" . $row["omschrijving"] . "'>" . $row["omschrijving"] . "</option>";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversDdm, FILE_APPEND);
            }

            $jQueryVerversDdm = "\")});";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversDdm, FILE_APPEND);
            $result->free();
        }
           
        $dbDomain->closeConnection();
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
        if($_SESSION["nachtmodus"] == "1")
        {
            echo "<script type=\"text/javascript\"> $(document).ready(function () {"
            . "$('header').append('<a href=\"index.php\"><img src=\"../../Resource/IMG/iq_logo(nachtmodus).png\" class=\"u-logo-image u-logo-image-1\" data-image-width=\"317.75\" style=\"height:100px\">');"
            . "$('body').css('background', 'black');"
            . "$('header').css('background', '#4B4B4B');"
            . "$('body').css('color', '#ddd');"
            . "$('#main > *').css('background-color', '#4B4B4B');"
            . "$('tblHelpdesk > a').css('background', '#fff !important');"
            . "$('tblHelpdesk > a').css('color', '#000 !important');"
            . "$('thead').css('color', '#ffffff');"
            . "$('thead').css('background-color', '#696969');"
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
            . "$('.u-btn').addClass('u-border-black');"
            . "$('.u-btn').addClass('u-hover-black');"
            . "$('.u-btn').addClass('u-text-black');"
            . "$('.u-btn').addClass('u-text-hover-white');"
            . "$('.u-btn').css('border', '0 none transparent !important');"
            . "});</script>";
        }
    ?>
    <script type="text/javascript" src="../../Resource/JS/addUI.js"></script>
    <script type="text/javascript" src="../../Resource/JS/zoekAsyncHelpdesk.js"></script>
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <meta property="og:title" content="Zoekvenster helpdesk">
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
                <a href="Registratieoverzicht.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Kantorenlijst</a>
                <a href="Zoekvenster-registraties.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Zoek registratie(s)</a>
                <a href="TotaalAgenda.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Algemene agenda</a>
                <a href="TotaalAgenda.php?agenda=cm" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Conny</a>
                <a href="TotaalAgenda.php?agenda=el" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Esther</a>
                <a href="TotaalAgenda.php?agenda=rl" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Rodney</a>
                <a href="Selectievenster.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Selecties</a>                
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
            </section>
    <section class="u-clearfix u-section-1" id="sec-e82d">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h3 class="u-text u-text-1">Zoek helpdesk</h3>
        <div class="u-form u-form-1">          
            <div class="u-form-group u-form-partition-factor-2 u-form-select u-form-group-1">
              <div class="u-form-select-wrapper">
                <label for="txtZoekWaarde" class="u-label">Zoek naar vraag/antwoord:</label>
                <input type="text" id="txtZoekWaarde" name="txtZoekWaarde" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
              </div>
            </div>
            <div class="u-form-group">
              <label for="ddmCategorieVeld" class="u-label">Categorie:</label>
              <select id="ddmCategorieVeld" name="ddmCategorieVeld" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
              </select>
            </div>
            <input id="btnSubmit" name="btnSubmit" type="button" value="Zoeken" class="u-btn u-button-style">
        </div>
      </div>
    </section>
    <section class="u-align-center u-clearfix u-section-2" id="sec-fcf2">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
            <table class="u-table-entity u-table-entity-1" id="tblHelpdesk" style="display:none">
            <colgroup>
              <col width="33.3%">
              <col width="33.3%">
              <col width="33.400000000000006%">
            </colgroup>
            <thead class="u-black u-table-header u-table-header-1">
              <tr style="height: 21px;">
                <th class="u-border-1 u-border-grey-50 u-table-cell">Datum</th>
                <th class="u-border-1 u-border-grey-50 u-table-cell">Tekst</th>
                <th class="u-border-1 u-border-grey-50 u-table-cell">Categorie</th>
              </tr>
            </thead>
            <tbody class="u-table-body" name="tblHelpdeskContainer">           
            </tbody>
          </table>
        </div>
      </div>
    </section>
        </div>
    </div>
  </body>
</html>