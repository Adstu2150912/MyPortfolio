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
    <title>Helpdesk item</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/HelpdeskItem.css" media="screen">
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
        if($_POST["btnSubmit"] == "Opslaan" && $_POST["typeForm"] == "new")
        {
            $dbDomain->openConnection();
            $dmlStatement = "INSERT INTO helpdesk(id, RegistratieID, kantoor, versie, categorie, vraag, datumtijd, afgelegd, Behandelaar, persoon, tijdsduur, helpType, sticky) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
            $strDataTypes = "iisssssissisi";
            $aValues = [0,filter_input(INPUT_POST, "regID", FILTER_SANITIZE_NUMBER_INT), $_POST["txtKantoornaam"], $_POST["txtPakket"], $_POST["ddmCategorie"], $_POST["txtArNotities"], (date_create($_POST["dpGespreksDatum"]))->format("Y-m-d H:i:s"), 1, $_SESSION["fullname"], $_POST["txtContactpersoon"], $_POST["tijdsDuur"], $_POST["soortMelding"],$_POST["rbSticky"]];
            $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
            $dbDomain->closeConnection();
            header("Location: Relatiekaart.php?id=" . $_POST["regID"]);
        }
        else if($_POST["btnSubmit"] == "Opslaan" && $_POST["typeForm"] == "edit")
        {
            $dbDomain->openConnection();
            $dmlStatement = "UPDATE helpdesk SET kantoor = ?, versie = ?, categorie = ?,"
            . "vraag = ?, datumtijd = ?, persoon = ?,"
            . "tijdsduur = ?, helpType = ?, AangepastDoor = ?, sticky = ?"
            . " WHERE id = ?;";
            $strDataTypes = "ssssssissii";
            $aValues = [$_POST["txtKantoornaam"], $_POST["txtPakket"], $_POST["ddmCategorie"], $_POST["txtArNotities"], (date_create($_POST["dpGespreksDatum"]))->format("Y-m-d H:i:s"), $_POST["txtContactpersoon"], 
            intval($_POST["tijdsDuur"]), $_POST["soortMelding"], $_SESSION["fullname"], intval($_POST["rbSticky"]), intval($_POST["ticketID"])];
            $dbDomain->executeStatement($dmlStatement,$strDataTypes, $aValues, "update");
            $dbDomain->closeConnection();
            header("Location: Relatiekaart.php?id=" . $_POST["regID"]);
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
    
        if(isset($_GET["regID"]) && !empty($_GET["regID"]) && empty($_POST["regID"]))
        {
            $_POST["regID"] = filter_input(INPUT_GET, "regID", FILTER_SANITIZE_NUMBER_INT);            
            unset($_GET["regID"]);
        }
        if(isset($_GET["ticketID"]) && !empty($_GET["ticketID"]) && empty($_POST["ticketID"]))
        {
            $_POST["ticketID"] = filter_input(INPUT_GET, "ticketID", FILTER_SANITIZE_NUMBER_INT);
            unset($_GET["ticketID"]);
        }
        if(isset($_GET["typeForm"]) && !empty($_GET["typeForm"]) && empty($_POST["typeForm"]))
        {
            $_POST["typeForm"] = $_GET["typeForm"];
            unset($_GET["typeForm"]);
        }
        if(isset($_GET["crmIntegratie"]) && !empty($_GET["crmIntegratie"]) && empty($_POST["crmIntegratie"]))
        {
            $_POST["crmIntegratie"] = $_GET["crmIntegratie"];
            unset($_GET["crmIntegratie"]);
        }
        
        $jQueryFillForm = "$(document).ready(function () {";
        
        $dbDomain->openConnection();
        $table = "users";
        $condition = " WHERE active = 1 ORDER BY fullname;";
        $result = $dbDomain->getResult($table, $condition, false, null, null);
        
        $table2 = "kantoor";
        $condition2 = " INNER JOIN registratie ON kantoor.registratieID = registratie.registratieID "
        . "INNER JOIN licentie ON registratie.registratieID = licentie.registratieID";
        $condition2 .= " WHERE registratie.registratieID = " . $_POST["regID"] . ";";        
        $result2 = $dbDomain->getResult($table2, $condition2, false, null, null);
        if($result2 != null)
            if($result2->num_rows > 0)
                $row2 = $result2->fetch_assoc();
        
        $table3 = "pakketten";
        $condition3 = " WHERE id = " . $row2["pakketID"] . ";";
        $result3 = $dbDomain->getResult($table3, $condition3, false, null, null);
        $row3 = null;
        $result4 = false;
        
        if(!empty($_POST["ticketID"]))
        {
            $table4 = "helpdesk";
            $condition4 = " WHERE id = " . $_POST["ticketID"] . ";";
            $result4 = $dbDomain->getResult($table4, $condition4, false, null, null);
            $row4 = $result4->fetch_assoc();
        }
        
        $jQueryFillForm .= "$('#txtKantoornaam').val('" . $row2["kantoorNaam"] . "');";
        
        if($result3 != false)
        {
            if($result3->num_rows > 0)
                $row3 = $result3->fetch_assoc();
        }
        
        $jQueryFillForm .= "$('#ddmCategorie').append(\"";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        
        $table5 = "onderwerpen";
        $condition5 = " ORDER BY omschrijving;";
        $result5 = $dbDomain->getResult($table5, $condition5, false, null, null); 
        if($result5 != false)
            while($row5 = $result5->fetch_assoc())
            {
                $jQueryFillForm = "<option value='" . $row5["omschrijving"] . "'>" . $row5["omschrijving"] . "</option>";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
            }                   
                
        $jQueryFillForm = "\");";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        
        $jQueryFillForm = "";
        
        if($_POST["typeForm"] == "new")
        {
            $jQueryFillForm .= "$('#txtBehandelaar').val('" . $_SESSION["fullname"] . "');";            
            $jQueryFillForm .= "$('#dpGespreksDatum').val('" . date("Y-m-d\TH:i") . "');";
            
            if($row3 != null)
                $jQueryFillForm .= " $('#txtPakket').val('" . $row2["pakketID"] . " - " . $row3["Omschrijving"] . "');";
            
            $jQueryFillForm .= "$('#frmHelpdeskItem').append('" . "<input id=\"btnSubmit\" name=\"btnSubmit\" type=\"submit\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" value=\"Opslaan\">" . "');";
            
            file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        }
        else if(!empty($_POST["ticketID"]))
        {
            if($_SESSION["fullname"] == $row4["Behandelaar"])
                $jQueryFillForm .= "$('#frmHelpdeskItem').append('" . "<input id=\"btnSubmit\" name=\"btnSubmit\" type=\"submit\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" value=\"Opslaan\">" . "');";            
            
            $jQueryFillForm .= "$('#txtBehandelaar').val('" . $row4["Behandelaar"] . "');"; 
            switch($row4["helpType"])
            {
                case "Telefoon":
                    $jQueryFillForm .= " $('#rbTelefoon').prop('checked', true);";
                    break;
                case "Email":
                    $jQueryFillForm .= " $('#rbEmail').prop('checked', true);";
                    break;
                case "Persoonlijk":
                    $jQueryFillForm .= "$('#rbPersoonlijk').prop('checked', true);";
                    break;
                case "Anders":
                    $jQueryFillForm .= "$('#rbAnders').prop('checked', true);";
                    break;
            }

            switch($row4["tijdsduur"])
            {
                case "5":
                    $jQueryFillForm .= " $('#rb5min').prop('checked', true);";
                    break;
                case "15":
                    $jQueryFillForm .= " $('#rb15min').prop('checked', true);";
                    break;
                case "30":
                    $jQueryFillForm .= "$('#rb30min').prop('checked', true);";
                    break;
                case "60":
                    $jQueryFillForm .= "$('#rb60min').prop('checked', true);";
                    break;
                case "120":
                    $jQueryFillForm .= "$('#rb120min').prop('checked', true);";
                    break;
                case "999":
                    $jQueryFillForm .= "$('#rb120plus').prop('checked', true);";
                    break;
            }

            switch($row4["sticky"])
            {
                case "0":
                    $jQueryFillForm .= "$('#rbNee').prop('checked', true);";
                    break;
                case "1":
                    $jQueryFillForm .= "$('#rbJa').prop('checked', true);";
                    break;
            }

            $jQueryFillForm .= "$('#txtContactpersoon').val('" . $row4["persoon"] . "');";
            $jQueryFillForm .= "$('#dpGespreksDatum').val('" . (date_create($row4["datumtijd"]))->format("Y-m-d\TH:i") . "');";
            $jQueryFillForm .= "$('#ddmCategorie').val('" . $row4["categorie"] . "');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
            $jQueryFillForm = "$('#txtArNotities').val('" . str_replace(array("\r\n", "\n\r", "\r", "\n"),"&#13;&#10;",$row4["vraag"]) . "');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
            $jQueryFillForm = " $('#txtPakket').val('" . $row4["versie"] . "');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);            
        }

        if($_POST["crmIntegratie"] == "true")
        {
            $jQueryFillForm = " $('#rbTelefoon').prop('checked', true);";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        }         
        
        if($result != false)
            $result->free();
        if($result2 != false)
            $result2->free();
        if($result3 != false)
            $result3->free();
        if($result4 != false)
            $result4->free();
        if($result5 != false)
            $result5->free();
        
        $dbDomain->closeConnection();  
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
//            . "$('sec-ece5 > a').css('background', '#fff !important');"
//            . "$('sec-ece5 > a').css('color', '#000 !important');"
            . "$('#btnSubmit').css('border', '0 none #fff !important');"
            . "$('#txtBehandelaar').css('color', '#111111')"
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
        
        $jQueryFillForm = "";
        
        if(isset($_POST["regID"]) && !empty($_POST["regID"]))
        {
            $jQueryFillForm .= "$('#navMenu > div:first-child').prepend('<a href=\"Relatiekaart.php?id=" 
            . $_POST["regID"] . "\" class=\"u-border-2 u-btn u-button-style u-none u-border-white u-hover-white u-text-white u-text-hover-black\" "
            . ".style=\"border:0 none #fff !important\">Terug naar relatiekaart</a>');";            
        }
        
        $jQueryFillForm .= "});";       
        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        
    ?>
    <script type="text/javascript" src="../../Resource/JS/addUI.js"></script>
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <meta property="og:title" content="HelpdeskItem">
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
        <h6 class="u-align-left u-text u-text-default u-text-1">Huidige helpdeskitem</h6>
        <div class="u-expanded-width u-table u-table-responsive u-table-1" id="tblHelpdeskItem">
        <form action=HelpdeskItem.php method="POST" name="frmHelpdeskItem" id="frmHelpdeskItem">
          <table class="u-table-entity">
            <colgroup>
              <col width="50%">
              <col width="50%">
            </colgroup>
            <tbody class="u-table-body">
              <tr style="height: 65px;">
                <td class="u-table-cell">Behandelaar:</td>
                <td class="u-table-cell"><input type="text" id="txtBehandelaar" readonly=""></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Soort gesprek:</td>
                <td class="u-table-cell">
                    <input type="radio" id="rbTelefoon" name="soortMelding" value="Telefoon"> <label for="rbTelefoon">Telefoon</label> 
                    <input type="radio" id="rbEmail" name="soortMelding" value="Email"><label for="rbEmail">Email</label> 
                    <input type="radio" id="rbPersoonlijk" name="soortMelding" value="Persoonlijk"><label for="rbPersoonlijk">Persoonlijk</label>  
                    <input type="radio" id="rbAnders" name="soortMelding" value="Anders"><label for="rbAnders">Anders</label>
                </td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Datum en tijd:</td>
                <td class="u-table-cell"><input type="datetime-local" id="dpGespreksDatum" name="dpGespreksDatum" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""></td>                
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Kantoornaam:</td>
                <td class="u-table-cell"><input type="text" id="txtKantoornaam" name="txtKantoornaam" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Contactpersoon:</td>
                <td class="u-table-cell">
                    <input type="text" id="txtContactpersoon" name="txtContactpersoon" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="">
                </td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Pakket\Versie:</td>
                <td class="u-table-cell">
                    <input type="text" id="txtPakket" name="txtPakket" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""> 
                    <input type=button value=" ? " onclick="javascript:alert('Het Assistent-versienummer wordt indien mogelijk opgehaald uit de database. Anders vul je NVT in.');">  
                    <font color="red" style="background: white;">---> bij MKBoek 3, 4 of 5 invullen !!</font>
                </td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Onder welk categorie valt het probleem:</td>
                <td class="u-table-cell">
                    <select id="ddmCategorie" name="ddmCategorie" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                        <option value="">-Geen-</option>                        
                    </select>
                </td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Tekst:</td>
                <td class="u-table-cell"><textarea placeholder="" rows="2" cols="50" id="txtArNotities" name="txtArNotities" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></textarea></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Tijdsduur item (in minuten):</td>
                <td class="u-table-cell">
                    <input type="radio" id="rb5min" name="tijdsDuur" value="5" checked> <label for="5min"> 5 </label> 
                    <input type="radio" id="rb15min" name="tijdsDuur" value="15"><label for="15min"> 15 </label> 
                    <input type="radio" id="rb30min" name="tijdsDuur" value="30"><label for="30min"> 30 </label>  
                    <input type="radio" id="rb60min" name="tijdsDuur" value="60"><label for="60min"> 60 </label>
                    <input type="radio" id="rb120min" name="tijdsDuur" value="120"><label for="120min"> 120 </label>
                    <input type="radio" id="rb120plus" name="tijdsDuur" value="999"><label for="120plusMin"> langer dan 120 </label>
                </td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Sticky:</td>
                <td class="u-table-cell">
                    <input type="radio" id="rbJa" name="rbSticky" value="1"> <label for="rbJa"> Ja </label> 
                    <input type="radio" id="rbNee" name="rbSticky" value="0" checked><label for="rbNee"> Nee </label>
                    <input type=button value=" ? " onclick="javascript:alert('Een helpdeskitem met de kwalificatie Sticky verschijnt altijd bovenaan de lijst met items bij deze klant.');">
                </td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell"></td>
                <td class="u-table-cell"></td>
              </tr>
            </tbody>
          </table>
        <input type="hidden" name="typeForm" value="<?php echo $_POST["typeForm"];?>">
        <input type="hidden" name="regID" value="<?php echo $_POST["regID"];?>">
        <input type="hidden" name="ticketID" value="<?php echo $_POST["ticketID"];?>">
        </form>
        </div>
      </div>
    </section>
        </div>
    </div>
  </body>
</html>