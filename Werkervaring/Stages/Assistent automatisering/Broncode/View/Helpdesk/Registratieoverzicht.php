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
    <title>Registratieoverzicht</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/Registratieoverzicht.css" media="screen">
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
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/addUI.js", "w");
        fclose($fp);

        $jQueryVerversForm = "$(document).ready(function () {";         
        $jQueryVerversForm .= "$('#tblRegistraties > thead').append('<tr style=\"height: 43px;\">"
          . "<th class=\"u-border-1 u-border-black u-table-cell\">Kantoornaam</th>"
          . "<th class=\"u-border-1 u-border-black u-table-cell\">Emailadres</th>"
          . "<th class=\"u-border-1 u-border-black u-table-cell\">Pakket</th>"
          . "<th class=\"u-border-1 u-border-black u-table-cell\">Aantal gebruikers</th>"
          . "<th class=\"u-border-1 u-border-black u-table-cell\">Aangemeld</th>"
          . "<th class=\"u-border-1 u-border-black u-table-cell\">Support tot</th>"
          . "<th class=\"u-border-1 u-border-black u-table-cell\">Statuscode</th>"
          . "</tr>');";
        $jQueryVerversForm .= "$('#tabelTitel').append('Totaaloverzicht van lopende registraties');";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

        $dbDomain->openConnection();
        $table = "kantoor";
        $condition = "INNER JOIN registratie ON kantoor.registratieID = registratie.registratieID "
        . "INNER JOIN licentie ON registratie.registratieID = licentie.registratieID";
        $condition .= " LEFT OUTER JOIN pakketten ON licentie.pakketID = pakketten.id WHERE (licentie.pakketID = 1 OR licentie.pakketID = 11) AND status = 0 ORDER BY ingangsDatum, status;";
        $result = $dbDomain->getResult($table, $condition, false, null, null);
        if($result != false)
        {
            while($row = $result->fetch_assoc())
            {
                $jQueryVerversForm = "$('#tblRegistraties > tbody').append('";
                $jQueryVerversForm .= "<tr style=\"height: 76px;\"><td class=\"u-border-1 u-border-grey-30 u-grey-50 u-table-cell u-table-cell-8\"><a href=\"Relatiekaart.php?id=" . $row["registratieID"] . "&pakket=" . $row["pakketID"] . "\">" . $row["kantoorNaam"] . "</a></td>";
                $jQueryVerversForm .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["emailAdres"] . "</td>";
                $jQueryVerversForm .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["Omschrijving"] . "</td>";
                $jQueryVerversForm .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["aantalGebruikers"] . "</td>";
                $jQueryVerversForm .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["ingangsDatum"] . "</td>";
                $jQueryVerversForm .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">";                

                $huidigeDatum = date_create(date("Y-m-d"));
                $supportTotDatum = date_create($row["supportTot"]);
                $datumVerschil = date_diff($huidigeDatum, $supportTotDatum);


                //onderstaande datumverschil in dagen moet omgezet worden van een string naar een geheel getal
                if(intval($datumVerschil->format("a")) >= 0)
                    $jQueryVerversForm .= $row["supportTot"];
                $jQueryVerversForm .= "</td>";
                $jQueryVerversForm .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["status"] . "</td>";
                $jQueryVerversForm .= "</tr>');";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }
            $result->free();
        }

        $dbDomain->closeConnection();
        $jQueryVerversForm = "});";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
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
            . "$('#main > *').css('background-color', '#4B4B4B');"
            . "$('thead').css('color', '#ffffff');"
            . "$('thead').css('background-color', '#696969');" 
            . "$('tblRegistraties > thead').css('background', '#4B4B4B');"
            . "$('tblRegistraties > tbody > tr:first-child').css('background', '#696969');"
            . "$('body').css('color', '#ddd');"
            . "$('tblRegistraties > a').css('background', '#fff !important');"
            . "$('tblRegistraties > a').css('color', '#000 !important');"
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
            . "$('tblRegistraties > thead').addClass('u-black');"
            . "$('tblRegistraties > thead > tr > th').addClass('u-border-black');"
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
    <meta property="og:title" content="Registratieoverzicht">
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
                <a href="TotaalAgenda.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Algemene agenda</a>
                <a href="TotaalAgenda.php?agenda=cm" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Conny</a>
                <a href="TotaalAgenda.php?agenda=el" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Esther</a>
                <a href="TotaalAgenda.php?agenda=rl" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Rodney</a>
                <a href="Selectievenster.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Selecties</a>
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
            </section>
        <section class="u-clearfix u-section-1" id="sec-c596">
          <div class="u-clearfix u-sheet u-sheet-1">
            <h4 class="u-text u-text-1" id="tabelTitel"></h4>
            <div class="u-expanded-width u-table u-table-responsive u-table-1">
              <table class="u-table-entity" id="tblRegistraties">
                <colgroup>
                  <col width="14.3%">
                  <col width="14.3%">
                  <col width="14.3%">
                  <col width="14.3%">
                  <col width="14.3%">
                  <col width="14.500000000000005%">
                  <col width="13.900000000000006%">
                </colgroup>
                <thead class="u-table-header u-table-header-1">
                </thead>
                <tbody class="u-table-alt-grey-5 u-table-body">
                </tbody>
              </table>
            </div>
          </div>
        </section>
        </div>
    </div>
  </body>
</html>