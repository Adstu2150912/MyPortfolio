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
    <title>Selectie formulier</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/Selectieform.css" media="screen">
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
        if($_POST["btnSubmit"] == "Vastleggen" && $_POST["typeForm"] == "new")
        {            
            if(!str_contains(substr($_POST["txtSelectie"], 0, 6), "INSERT") || !str_contains($_POST["txtSelectie"], "UPDATE") || !str_contains($_POST["txtSelectie"], "DELETE"))
            {
                $dbDomain->openConnection();
                $strDataTypes = "isss";
                $aValues = [0, $_POST["txtNaam"], $_POST["txtOmschrijving"], $_POST["txtSelectie"]];
                $dmlStatement = "INSERT INTO iqselecties VALUES(?, ?, ?, ?);";
                
                $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                $dbDomain->closeConnection();
                header("Location: Selectievenster.php");
            }
        }
        else if($_POST["btnSubmit"] == "Vastleggen" && $_POST["typeForm"] == "edit")
        {
            if(!str_contains($_POST["txtSelectie"], "INSERT") || !str_contains($_POST["txtSelectie"], "UPDATE") || !str_contains($_POST["txtSelectie"], "DELETE"))
            {
                $dbDomain->openConnection();
                $strDataTypes = "sssi";
                $aValues = [$_POST["txtNaam"], $_POST["txtOmschrijving"], $_POST["txtSelectie"], filter_input(INPUT_POST, "id", FILTER_SANITIZE_NUMBER_INT)];
                $dmlStatement = "UPDATE iqselecties SET naam = ?, omschrijving = ?, selectie = ? WHERE id = ?;";
                $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");
                $dbDomain->closeConnection();
                header("Location: Selectievenster.php");
            }
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
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/addUI.js", "w");
        fclose($fp);
    
        if(isset($_GET["id"]) && !empty($_GET["id"]) && empty($_POST["id"]))
        {
            $_POST["id"] = filter_input(INPUT_GET, "id", FILTER_SANITIZE_NUMBER_INT);
            unset($_GET["id"]);
        }
        if(isset($_GET["typeForm"]) && !empty($_GET["typeForm"]) && empty($_POST["typeForm"]))
        {
            $_POST["typeForm"] = $_GET["typeForm"];
            unset($_GET["typeForm"]);
        }
        
        $jQueryFillForm = "$(document).ready(function () {";
        
        $jQueryFillForm .= "$('#frmSelectie').append('" . "<input id=\"btnTestSelectie\" name=\"btnTestSelectie\" type=\"button\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" value=\"Testen\" disabled=\"true\">" . "');";
        
        switch($_POST["typeForm"])
        {
            case "new":
                $jQueryFillForm .= "$('#formTitel').append('Nieuw selectie aanmaken');";
                $jQueryFillForm .= "$('#frmSelectie').append('" . "<input id=\"btnSubmit\" name=\"btnSubmit\" type=\"submit\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" value=\"Vastleggen\" disabled=\"true\">" . "');";
                $jQueryFillForm .= "$('#btnSubmit').prop('disabled', true);";
                $jQueryFillForm .= "$('#btnTestSelectie').prop('disabled', true);";
                break;
            case "edit":
                $jQueryFillForm .= "$('#formTitel').append('Selectie wijzigen');";
                $jQueryFillForm .= "$('#frmSelectie').append('" . "<input id=\"btnSubmit\" name=\"btnSubmit\" type=\"submit\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" value=\"Vastleggen\" disabled=\"true\">" . "');";
                if(!empty($_POST["id"]))
                {
                    $dbDomain->openConnection();
                    $table = "iqselecties";
                    $condition = " WHERE id = " . $_POST["id"] . ";";
                    $result = $dbDomain->getResult($table, $condition, false, null, null);

                    if($result != false)
                    {
                        $row = $result->fetch_assoc();
                        $jQueryFillForm .= "$('#txtNaam').val('" . $row["naam"] . "');";
                        $jQueryFillForm .= "$('#txtOmschrijving').val('" . $row["omschrijving"] . "');";
                        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
                        $jQueryFillForm = "$('#txtSelectie').val(\"" . str_replace(array("\r\n", "\n\r", "\r", "\n"),"&#13;&#10;",$row["selectie"]) . "\");";
                        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
                        $jQueryFillForm = "$('#btnSubmit').prop('disabled', false);";
                        $jQueryFillForm .= "$('#btnTestSelectie').prop('disabled', false);";
                        $result->free();
                    }
                    else
                    {
                        $jQueryFillForm .= "$('#btnSubmit').prop('disabled', true);";
                        $jQueryFillForm .= "$('#btnTestSelectie').prop('disabled', true);";
                    }
                    $dbDomain->closeConnection();  
                }
                else
                {
                    $jQueryFillForm .= "$('#btnSubmit').prop('disabled', true);";
                    $jQueryFillForm .= "$('#btnTestSelectie').prop('disabled', true);";
                }
                break;
        }

        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        
        $dbDomain->openConnection();
        $result2 = $dbDomain->executeStatement("SELECT TABLE_NAME "
        . " FROM INFORMATION_SCHEMA.TABLES "
        . " WHERE TABLE_SCHEMA = 'iqdb';", null, null, "query");
        
        if($result2 != false)
        {
            $jQueryFillForm = "$('#ddmTabel').append('";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
            while($row2 = $result2->fetch_array())
            {
                $jQueryFillForm = "<option value=\"" . $row2[0] . "\">" . $row2[0] . "</option>";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
            }            
            $jQueryFillForm = "');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
            $result2->free();
        }
        
        
        
        $dbDomain->closeConnection();
        
        $jQueryFillForm = "$('#frmSelectie > table > tbody').prepend('<tr style=\"height: 65px;\">"
        . "<td class=\"u-table-cell\">ID:</td>"
        . "<td class=\"u-table-cell\">" . $_POST["id"] . "</td></tr>');";
        
//        $jQueryFillForm .= "$('#txtSelectie').change(function (){"
//        . "  var strSelectie = $('#txtSelectie').val();"
//        . "  alert('Selectie is veranderd!');"
//        . "  if(strSelectie.startsWith('SELECT') === true){"
//        . "  alert('Selectie begint met een SELECT!');"
//        . "  $('#btnSubmit').prop('disabled', false);"
//        . "  $('#btnTestSelectie').prop('disabled', false);"
//        . "  } else(strSelectie.startsWith('SELECT') === false) {"
//        . "   alert('Selectie moet beginnen met een SELECT!');"
//        . "   $('#btnSubmit').prop('disabled', true);"
//        . "   $('#btnTestSelectie').prop('disabled', true);"
//        . "   }});";
        
        $jQueryFillForm .= "});";
        
        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        
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
            . "$('select').css('color', 'black');"
            . "$('.u-btn').addClass('u-border-white');"
            . "$('.u-btn').addClass('u-hover-white');"
            . "$('.u-btn').addClass('u-text-white');"
            . "$('.u-btn').addClass('u-text-hover-black');"
            . "$('.u-btn').css('border', '0 none #fff !important');"
            . "$('#btnSubmit').addClass('u-border-white');"
            . "$('#btnSubmit').addClass('u-hover-white');"
            . "$('#btnSubmit').addClass('u-text-white');"
            . "$('#btnSubmit').addClass('u-text-hover-black');"
            . "$('#btnSubmit').css('border', '0 none #fff !important');"
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
            . "$('#btnSubmit').addClass('u-border-black');"
            . "$('#btnSubmit').addClass('u-hover-black');"
            . "$('#btnSubmit').addClass('u-text-black');"
            . "$('#btnSubmit').addClass('u-text-hover-white');"
            . "$('#btnSubmit').css('border', '0 none transparent !important');"
            . "});</script>";
        }
    ?>
    <script type="text/javascript" src="../../Resource/JS/addUI.js"></script>
    <script type="text/javascript" src="../../Resource/JS/asyncDBVerzoek.js"></script>
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <script>
        $('document').ready(function () 
        {
            $("#txtSelectie").change(function ()
            {
                var strSelectie = $("#txtSelectie").val();
                if(strSelectie.startsWith("SELECT") === true)
                {
                    $("#btnSubmit").prop('disabled', false);
                    $("#btnTestSelectie").prop('disabled', false);
                }
                else if(strSelectie.startsWith("SELECT") === false)
                {                    
                    $("#btnSubmit").prop('disabled', true);
                    $("#btnTestSelectie").prop('disabled', true);
                }
            });
        });
    </script>
    <meta property="og:title" content="Selectieform">
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
                <a href="Selectievenster.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Terug naar overzicht</a>
                <a href="Relatieform.php?typeForm=new" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Nieuw relatiekaart</a>                
                <a href="Zoekvenster-registraties.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Zoek registratie(s)</a>
                <a href="Zoekvenster-helpdeskitems.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Zoek helpdesk</a>
                <a href="Registratieoverzicht.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Kantorenlijst</a>
                <a href="TotaalAgenda.php" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Algemene agenda</a>
                <a href="TotaalAgenda.php?agenda=cm" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Conny</a>
                <a href="TotaalAgenda.php?agenda=el" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Esther</a>
                <a href="TotaalAgenda.php?agenda=rl" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Agenda Rodney</a>
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
            </section>
    <section class="u-clearfix u-section-1" id="sec-dd03">
      <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
      <div class="u-clearfix u-sheet u-sheet-1">
        <h6 class="u-align-left u-text u-text-default u-text-1" id="formTitel"></h6>
        <div class="u-expanded-width u-table u-table-responsive u-table-1" id="mainContainer">
        <form action=Selectieform.php method="POST" name="frmSelectie" id="frmSelectie">
          <table class="u-table-entity">
            <colgroup>
              <col width="50%">
              <col width="50%">
            </colgroup>
            <tbody class="u-table-body">
              <tr style="height: 65px;">
                <td class="u-table-cell">Naam:</td>
                <td class="u-table-cell"><input type="text" id="txtNaam" name="txtNaam" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Omschrijving:</td>
                <td class="u-table-cell"><input type="text" id="txtOmschrijving" name="txtOmschrijving" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Selectie:</td>
                <td class="u-table-cell"><input type="text" id="txtSelectie" name="txtSelectie" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""></td>
              </tr>
            </tbody>
          </table>
        <input type="hidden" name="typeForm" value="<?php echo $_POST["typeForm"];?>">
        <input type="hidden" name="id" value="<?php echo $_POST["id"];?>">
        </form>
        </div>
      </div>
    </section>
    <section class="u-align-center u-clearfix u-section-2" id="sec-fcf2">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
          <table class="u-table-entity u-table-entity-1" id="tblSQLOverzicht">
            <thead class="u-black u-table-header u-table-header-1">
                <th>Tabel: <select id="ddmTabel" name="ddmTabel" required><option value="" selected>--Kies een tabel--</option></select></th>
                <th>Veld</th>
            </thead>
            <tbody class="u-table-body">
            </tbody>
          </table>
        </div>
      </div>
    </section>
    <section class="u-align-center u-clearfix u-section-3">
      <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
          <table class="u-table-entity u-table-entity-1" id="tblTestResultaat">
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