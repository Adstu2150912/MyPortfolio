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
    <title>Agenda</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/TotaalAgenda.css" media="screen">
    <script class="u-script" type="text/javascript" src="../../Resource/JS/jquery.js"></script>
    <script class="u-script" type="text/javascript" src="../../Resource/JS/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 3.10.2, nicepage.com">
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

        $jQueryVerversTabel = "$(document).ready(function () {";
              
        $dbDomain->openConnection();
        
        if(!empty($_GET["agenda"]))
        {
            $jQueryVerversTabel .= "$('#tblAgenda > thead').append('<tr style=\"height: 43px;\">"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">RelatieID</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Kantoornaam</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Agendadatum</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Agendareden</th>"
              . "</tr>');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
            
            switch($_GET["agenda"])
            {
                case "el":
                    $params = "registratie.registratieID, licentie.pakketID, kantoorNaam, agenda.agendadatum, agenda.tekst";
                    $table = "agenda";
                    $condition = " INNER JOIN registratie ON agenda.registratieID=registratie.registratieID "
                    . " INNER JOIN licentie ON registratie.registratieID = licentie.registratieID"
                    . " INNER JOIN kantoor ON registratie.registratieID = kantoor.registratieID" 
                    . " WHERE agenda.af = 0 AND voor = 'el' ORDER BY agenda.agendadatum;";
                    $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
                    if($result != false)
                    {
                        while($row = $result->fetch_assoc())
                        {
                            $jQueryVerversTabel = "$('#tblAgenda > tbody').append('";
                            $jQueryVerversTabel .= "<tr style=\"height: 76px;\"><td class=\"u-border-1 u-table-cell\"><a href=\"Relatiekaart.php?id=" . $row["registratieID"] . "&pakket=" . $row["pakketID"] . "\">" . $row["registratieID"] . "</a></td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["kantoorNaam"] . "</td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["agendadatum"] . "</td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . str_replace(array("\r\n", "\n\r", "\r", "\n"), "<br><br>",$row["tekst"]) . "</td>";
                            $jQueryVerversTabel .= "</tr>');";
                            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                        }
                        $jQueryVerversTabel = "$('#main').prepend('<h6 class=\"u-align-left u-text u-text-default u-text-1\" id=\"formTitel\">Agenda voor Esther - Aantal agendapunten: " . $result->num_rows . "</h6>')";
                        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                        $result->free();
                    }
                    break;
                case "cm":
                    $params = "registratie.registratieID, licentie.pakketID, kantoorNaam, agenda.agendadatum, agenda.tekst";
                    $table = "agenda";
                    $condition = " INNER JOIN registratie ON agenda.registratieID = registratie.registratieID"
                    . " INNER JOIN licentie ON registratie.registratieID = licentie.registratieID"
                    . " INNER JOIN kantoor ON registratie.registratieID = kantoor.registratieID"        
                    . " WHERE agenda.af = 0 AND voor = 'cm' ORDER BY agenda.agendadatum;";
                    $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
                    if($result != false)
                    {
                        while($row = $result->fetch_assoc())
                        {
                            $jQueryVerversTabel = "$('#tblAgenda > tbody').append('";
                            $jQueryVerversTabel .= "<tr style=\"height: 76px;\"><td class=\"u-border-1 u-table-cell\"><a href=\"Relatiekaart.php?id=" . $row["registratieID"] . "&pakket=" . $row["pakketID"] . "\">" . $row["registratieID"] . "</a></td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["kantoorNaam"] . "</td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["agendadatum"] . "</td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . str_replace(array("\r\n", "\n\r", "\r", "\n"), "<br><br>",$row["tekst"]) . "</td>";
                            $jQueryVerversTabel .= "</tr>');";
                            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                        }
                        $jQueryVerversTabel = "$('#main').prepend('<h6 class=\"u-align-left u-text u-text-default u-text-1\" id=\"formTitel\">Agenda voor Conny - Aantal agendapunten: " . $result->num_rows . "</h6>')";
                        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                        $result->free();
                    }
                    break;
                case "rl":
                    $params = "registratie.registratieID, licentie.pakketID, kantoorNaam, agenda.agendadatum, agenda.tekst";
                    $table = "agenda";
                    $condition = " INNER JOIN registratie ON agenda.registratieID = registratie.registratieID "
                    . " INNER JOIN licentie ON registratie.registratieID = licentie.registratieID"
                    . " INNER JOIN kantoor ON registratie.registratieID = kantoor.registratieID" 
                    . " WHERE agenda.af = 0 AND voor = 'rl' ORDER BY agenda.agendadatum;";
                    $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
                    $jQueryVerversTabel .= " $('#tblAgenda > tbody').append('";
                    if($result != false)
                    {
                        while($row = $result->fetch_assoc())
                        {
                            $jQueryVerversTabel = " $('#tblAgenda > tbody').append('";
                            $jQueryVerversTabel .= "<tr style=\"height: 76px;\"><td class=\"u-border-1 u-table-cell\"><a href=\"Relatiekaart.php?id=" . $row["registratieID"] . "&pakket=" . $row["pakketID"] . "\">" . $row["registratieID"] . "</a></td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["kantoorNaam"] . "</td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["agendadatum"] . "</td>";
                            $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . str_replace(array("\r\n", "\n\r", "\r", "\n"), "<br><br>",$row["tekst"]) . "</td>";
                            $jQueryVerversTabel .= "</tr>');";
                            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                        }
                                            
                        $jQueryVerversTabel = "$('#main').prepend('<h6 class=\"u-align-left u-text u-text-default u-text-1\" id=\"formTitel\">Agenda voor Rodney - Aantal agendapunten: " . $result->num_rows . "</h6>')";
                        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                        $result->free();
                    }
                    break;
            }
        }
        else
        {
            $jQueryVerversTabel .= "$('#tblAgenda > thead').append('<tr style=\"height: 43px;\">"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">RelatieID</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Van</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Voor</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Kantoornaam</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Laatste contact</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Agendadatum</th>"
              . "<th class=\"u-border-1 u-border-black u-table-cell\">Agendareden</th>"
              . "</tr>');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
            
            $params = "agenda.*, kantoor.kantoorNaam, licentie.pakketID";
            $table = "agenda";
            $condition = " INNER JOIN registratie ON agenda.registratieID = registratie.registratieID"
            . " INNER JOIN licentie ON registratie.registratieID = licentie.registratieID"
            . " INNER JOIN kantoor ON registratie.registratieID = kantoor.registratieID" 
            . " WHERE agenda.af = 0 AND agenda.agendadatum < DATE_ADD(NOW(), INTERVAL 1 DAY) ORDER BY agenda.agendadatum;";
            $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
            if($result != false)
            {
                while($row = $result->fetch_assoc())
                {
                    $jQueryVerversTabel = " $('#tblAgenda > tbody').append('";
                    $jQueryVerversTabel .= "<tr style=\"height: 76px;\"><td class=\"u-border-1 u-table-cell u-table-cell-8\"><a href=\"Relatiekaart.php?id=" . $row["registratieID"] . "&pakket=" . $row["pakketID"] . "\">" . $row["registratieID"] . "</a></td>";
                    $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["van"] . "</td>";
                    $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["voor"] . "</td>";
                    $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["kantoorNaam"] . "</td>";
                    $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">";                

                    $params2 = "datumtijd, vraag, antwoord";
                    $table2 = "helpdesk";
                    $condition2 = " WHERE RegistratieID = " . $row["registratieID"] . " ORDER BY datumtijd DESC;";
                    $result2 = $dbDomain->getSelectiveResult($params2, $table2, $condition2, false, null, null);
                    if($result2 != false)
                    {
                        if($result2->num_rows > 0)
                        {
                            $row2 = $result2->fetch_assoc();
                            if(isset($row2["datumtijd"]))
                            {
                                $huidigeDatum = date_create(date("Y-m-d"));
                                $supportTotDatum = date_create($row2["datumtijd"]);
                                $datumVerschil = date_diff($huidigeDatum, $supportTotDatum);
                                $jQueryVerversTabel .= "<a href=\"Relatiekaart.php?id=" . $row["registratieID"] . "&pakket=" . $row["pakketID"] . "\">" . (date_create($row2["datumtijd"])->format("d-m-Y")) 
                                . "(" . $datumVerschil->days . " dagen geleden)</a>" 
                                . "<br>" 
                                . $row2["vraag"] 
                                . "...<br>" 
                                . $row2["antwoord"] 
                                . "...";
                            }
                        }
                        $result2->free();
                    }
                    $jQueryVerversTabel .= "</td>";
                    $jQueryVerversTabel .= "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . $row["agendadatum"] . "</td>";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                    $jQueryVerversTabel = "<td class=\"u-border-1 u-border-grey-30 u-table-cell\">" . str_replace(array("\r\n", "\n\r", "\r", "\n"), "<br><br>", $row["tekst"]) . "</td>";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                    $jQueryVerversTabel = "</tr>');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
                }
                $result->free();
            }
        }
        
        $dbDomain->closeConnection();
        $jQueryVerversTabel = "});";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversTabel, FILE_APPEND);
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
            . "$('tblAgenda > tbody > tr:first-child').css('background', '#696969');"
            . "$('body').css('color', '#ddd');"
            . "$('tblAgenda > a').css('background', '#fff !important');"
            . "$('tblAgenda > a').css('color', '#000 !important');"
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
            . "$('tblAgenda > thead').addClass('u-black');"
            . "$('tblAgenda > thead > tr > th').addClass('u-border-black');"
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
    <meta property="og:title" content="Agenda">
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
                <a href="Zoekvenster-helpdeskitems.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Zoek helpdesk</a>
                <a href="TotaalAgenda.php?agenda=cm" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Conny</a>
                <a href="TotaalAgenda.php?agenda=el" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Esther</a>
                <a href="TotaalAgenda.php?agenda=rl" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Rodney</a>
                <a href="Selectievenster.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Selecties</a>                
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
            </section>
    <section class="u-clearfix u-section-1" id="sec-7f57">
      <div class="u-clearfix u-sheet u-sheet-1" id="main">
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
          <table class="u-table-entity" id="tblAgenda">
            <colgroup>
              <col width="1%">
              <col width="1%">
              <col width="1%">
              <col width="10%">
              <col width="18%">
              <col width="1%">
              <col width="16%">
            </colgroup>
            <thead class="u-black u-table-header u-table-header-1">   
            </thead>
            <tbody class="u-table-body">              
            </tbody>
          </table>
        </div>
      </div>
    </section>
        </div>
    </div>
  </body>
</html>