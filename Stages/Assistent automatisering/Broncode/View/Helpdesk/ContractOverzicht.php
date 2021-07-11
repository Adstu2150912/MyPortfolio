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
    <title>Contract overzicht</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/ContractOverzicht.css" media="screen">
<script class="u-script" type="text/javascript" src="../../Resource/JS/jquery.js"></script>
    <script class="u-script" type="text/javascript" src=".././/Resource/JS/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 3.8.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "ModernIQ",
		"url": "index.html",
		"logo": "images/iq_logo.png"
}</script>
    <?php if ($_SESSION['ingelogd']=="ja")
    {
        echo "<script type=\"text/javascript\"> $(document).ready(function () {" 
        .  " $('header').append('<div id=\"accountBox\"><b><a href=\"MijnAccount.php\" title=\"accountKnop\">Ingelogd als " . $_SESSION['fullname'] . "<br> (" . $_SESSION['email'] . ")</a></b>"
        . " | <a href=\"Inlogpagina-helpdesk.php?ingelogd=nee\" title=\"logoutknop\">Uitloggen</a></div>')" 
        . "});</script>";
    }?>
    <?php    
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/addUI.js", "w");
        fclose($fp);        
        
        
        $jQueryVerversForm = "$(document).ready(function () {";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
      
        $dbDomain->openConnection();
        $params = "YEAR(ingangsDatum) AS jaar, COUNT(ingangsDatum) AS aantal";
        $table = "licentie";
        $condition = " WHERE (pakketID = 1 OR pakketID = 11) AND ((status < 20 AND status <> 1) OR (status BETWEEN 111 AND 119)) GROUP BY YEAR(ingangsDatum);";
        $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
        $result2 = false;
        $totAantal = 0;
        if($result != false)
        {
            while($row = $result->fetch_assoc())
            {   
                $row2 = null;
                $jQueryVerversForm = " $('#tblContracten > tbody').append('<tr style=\"height: 76px;\" class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\"><td align=\"center\">" . $row["jaar"] . "</td><td align=\"center\">" . $row["aantal"] . "</td>";
                
                $params2 = "YEAR(supportTot) AS jaar, count(supportTot) AS aantal";
                $table2 = "licentie";
                $condition2 = " WHERE (pakketID = 1 OR pakketID = 11) AND (status BETWEEN 2 AND 5) AND YEAR(supportTot)=" . $row["jaar"] . " GROUP BY YEAR(supportTot);";
                $result2 = $dbDomain->getSelectiveResult($params2, $table2, $condition2, false, null, null);                
                if($result2 != false)
                    if($result2->num_rows == 0)
                    {
                        $dAantal = $row["aantal"];
                        $jQueryVerversForm .= "<td align=\"center\"> 0 </td><td align=\"center\"> 0 </td>";    
                    }
                    else
                        $row2 = $result2->fetch_assoc();

                if($row2 != null)
                {
                    $dAantal = $row["aantal"] - $row2["aantal"];                    
                    $totAantal += $dAantal;
                    $jQueryVerversForm .= "<td align=\"center\">" . $row2["aantal"] . "</td><td align=\"center\">" . $totAantal .  "</td>";
                }
                else
                    $jQueryVerversForm .= "<td align=\"center\">" . $dAantal . "</td><td align=\"center\">" . $totAantal .  "</td>";
                
                $jQueryVerversForm .= "</tr>";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }
            $result->free();
            if($result2 != false)
                $result2->free();
        }
        $jQueryVerversForm = "<tr class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\"><td colspan=\"3\" align=\"center\">totaal op dit moment</td><td colspan=\"2\" align=\"right\">" . $totAantal . "</td></tr>";
        $jQueryVerversForm .= "')});";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
        
        $dbDomain->closeConnection();              
    ?>
    <?php
    if($_SESSION["nachtmodus"] == "1")
    {
        echo "<script type=\"text/javascript\"> $(document).ready(function () {"
        . "$('header').append('<a href=\"index.php\"><img src=\"../../Resource/IMG/iq_logo(nachtmodus).png\" class=\"u-logo-image u-logo-image-1\" data-image-width=\"317.75\" style=\"height:100px\">');"
        . "$('body').css('background', 'black');"
        . "$('#main > *').css('background-color', '#4B4B4B');"
        . "$('header').css('background', '#4B4B4B');"
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
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <script type="text/javascript" src="../../Resource/JS/addUI.js"></script>
    <meta property="og:title" content="ContractOverzicht">
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
        <section class="u-clearfix u-section-1" id="sec-67f2">
          <div class="u-clearfix u-sheet u-sheet-1">
            <h4 class="u-text u-text-default u-text-1">Nieuw/vervallen Assistent - Contracten per jaar</h4>
            <div class="u-expanded-width u-table u-table-responsive u-table-1">
              <table class="u-table-entity" id="tblContracten">
                <colgroup>
                  <col width="20%">
                  <col width="20%">
                  <col width="20%">
                  <col width="20%">
                  <col width="20%">
                </colgroup>
                <thead class="u-grey-50 u-table-header u-table-header-1">
                  <tr style="height: 45px;">
                    <th class="u-border-1 u-border-grey-50 u-table-cell">Jaar</th>
                    <th class="u-border-1 u-border-grey-50 u-table-cell">Nieuw aantal</th>
                    <th class="u-border-1 u-border-grey-50 u-table-cell">Vervallen aantal</th>
                    <th class="u-border-1 u-border-grey-50 u-table-cell">Toename aantal</th>
                    <th class="u-border-1 u-border-grey-50 u-table-cell">Cumulatief aantal</th>
                  </tr>
                </thead>
                <tbody class="u-table-body">
                </tbody>
              </table>
            </div>
          </div>
        </section>
        <section class="u-align-left u-clearfix u-section-2" id="sec-e08b">
          <div class="u-clearfix u-sheet u-sheet-1">
            <h6 class="u-text u-text-default u-text-1">Controlegetal: 
            <?php 
            $dbDomain->openConnection();
            $params3 = "COUNT(licentieID) AS aantal";
            $table3 = "licentie";
            $condition3 = " WHERE status = 0 AND (pakketID = 1 OR pakketID = 11);";
            $result3 = $dbDomain->getSelectiveResult($params3, $table3, $condition3, false, null, null);
            if($result != false)
            {
                $row3 = $result3->fetch_assoc();
                echo $row3["aantal"];
                $result3->free();
            }
            else
                echo "0";            
            $dbDomain->closeConnection();
            ?> contracten met statuscode 0</h6>
          </div>
        </section>
        </div>
    </div>
  </body>
</html>