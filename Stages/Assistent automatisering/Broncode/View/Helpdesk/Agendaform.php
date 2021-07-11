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
    <title>Agendapunt</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/Agendaform.css" media="screen">
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
        if($_POST["btnSubmit"] === "Vastleggen" && $_POST["typeForm"] === "new")
        {
            $dbDomain->openConnection();
//            $dmlStatement = "INSERT INTO agenda VALUES(0, " . filter_input(INPUT_POST, "regID", FILTER_SANITIZE_NUMBER_INT) . ", '" . (date_create($_POST["dpAgendaDatum"]))->format("Y-m-d H:i:s") . "', '" . $_POST["ddmVanBehandelaar"]
//            . "', '" . $_POST["ddmVoorBehandelaar"] . "','" . $_POST["txtAgendaReden"] . "', 0);";
            
            $dmlStatement = "INSERT INTO agenda VALUES(?, ?, ?, ?, ?, ?, ?)";
            $aValues = [0, filter_input(INPUT_POST, "regID", FILTER_SANITIZE_NUMBER_INT), (date_create($_POST["dpAgendaDatum"]))->format("Y-m-d H:i:s"), $_POST["ddmVanBehandelaar"], $_POST["ddmVoorBehandelaar"], $_POST["txtAgendaReden"], 0];
            
            $dbDomain->executeStatement($dmlStatement, "iissssi", $aValues, "insert");
            $dbDomain->closeConnection();
            header("Location: Relatiekaart.php?id=" . $_POST["regID"]);
        }
        else if($_POST["btnSubmit"] === "Vastleggen" && $_POST["typeForm"] === "edit")
        {
            $dbDomain->openConnection();
            $dmlStatement = "UPDATE agenda SET agendadatum = ?, van = ?, voor = ?,"
            . "tekst = ?"
            . " WHERE id = ?;";
            $aValues = [(date_create($_POST["dpAgendaDatum"]))->format("Y-m-d H:i:s"), $_POST["ddmVanBehandelaar"], $_POST["ddmVoorBehandelaar"], $_POST["txtAgendaReden"], filter_input(INPUT_POST, "agendaID", FILTER_SANITIZE_NUMBER_INT)];
            $dbDomain->executeStatement($dmlStatement, "ssssi", $aValues, "update");
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
    
        $regID = filter_input(INPUT_GET, "regID", FILTER_VALIDATE_INT);
        $agendaID = filter_input(INPUT_GET, "agendaID", FILTER_VALIDATE_INT);
        if($regID != false && $regID != null && empty($_POST["regID"]))
        {
            $_POST["regID"] = $regID;
            unset($_GET["regID"]);
        }
        if($agendaID != null && $agendaID != false && empty($_POST["agendaID"]))
        {
            $_POST["agendaID"] = $agendaID;
            unset($_GET["agendaID"]);
        }
        
        if(isset($_GET["typeForm"]) && !empty($_GET["typeForm"]) && empty($_POST["typeForm"]))
        {
            $_POST["typeForm"] = $_GET["typeForm"];
            unset($_GET["typeForm"]);
        }
        
        $jQueryFillForm = "$(document).ready(function () {";
        
        if($_POST["typeForm"] == "new" || $_POST["typeForm"] == "edit")
        {
            $jQueryFillForm .= "$('#frmAgendapunt').append('" . "<input id=\"btnSubmit\" name=\"btnSubmit\" type=\"submit\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" value=\"Vastleggen\">" . "');";
        }
        
        $dbDomain->openConnection();
        $table = "users";
        $condition = " WHERE active = 1 ORDER BY fullname;";
        $result = $dbDomain->getResult($table, $condition, false, null, null);
        
        $table2 = "kantoor";
        $condition2 = " WHERE registratieID = " . $_POST["regID"] . ";";
        $result2 = $dbDomain->getResult($table2, $condition2, false, null, null);
        if($result2 != false)
            if($result2->num_rows > 0)
                $row2 = $result2->fetch_assoc();
            
        $result4 = false;
            
        if(!empty($_POST["agendaID"]))
        {
            $table4 = "agenda";
            $condition4 = " WHERE id = " . $_POST["agendaID"] . ";";
            $result4 = $dbDomain->getResult($table4, $condition4, false, null, null);
            if($result4 != false)
                $row4 = $result4->fetch_assoc();           
        }
        
        if($_POST["typeForm"] == "new")
        {
            if($result2 != false && $row2 != null)
                $jQueryFillForm .= "$('#formTitel').append('" . "Nieuw agendapunt aanmaken voor kantoor: " . $row2["kantoorNaam"] . "');";
            $jQueryDdm1 = "$('#ddmVanBehandelaar').append('"; 
            $jQueryDdm2 = "$('#ddmVoorBehandelaar').append('";
            $jQueryDdm1Val = "";
            if($result != false)
                while($row = $result->fetch_assoc())
                {
                    if($_SESSION["fullname"] === $row["fullname"])
                        $jQueryDdm1Val = "$('#ddmVanBehandelaar').val('" . $row["username"] . "');"; 
                    $jQueryDdm1 .= "<option value=\"" . $row["username"] . "\">" . $row["fullname"] . "</option>";
                    if($_SESSION["fullname"] != $row["fullname"])
                        $jQueryDdm2 .= "<option value=\"" . $row["username"] . "\">" . $row["fullname"] . "</option>";                    
                }       

            $jQueryDdm1 .= "');";
            $jQueryDdm2 .= "');";
            
            $jQueryFillForm .= $jQueryDdm1 . $jQueryDdm2 . $jQueryDdm1Val;
            $jQueryFillForm .= "$('#dpAgendaDatum').val('" . date("Y-m-d\TH:i") . "');";
        }
        else if(!empty($_POST["agendaID"]) && $_POST["typeForm"] == "edit")
        {
            if($result2 != false && $row2 != null)
                $jQueryFillForm .= "$('#formTitel').append('" . "Agendapunt wijzigen voor kantoor: " . $row2["kantoorNaam"] . "');";
            $jQueryDdm1Val = "";
            $jQueryDdm2Val = "";
            $jQueryDdm1 = "$('#ddmVanBehandelaar').append('"; 
            $jQueryDdm2 = "$('#ddmVoorBehandelaar').append('"; 
            if($result != false)
                while($row = $result->fetch_assoc())
                {
                    if($row4["van"] === $row["username"])
                        $jQueryDdm1Val = "$('#ddmVanBehandelaar').val('" . $row["username"] . "');"; 
                    else if($row4["voor"] === $row["username"])
                        $jQueryDdm1Val = "$('#ddmVoorBehandelaar').val('" . $row["username"] . "');";
                    $jQueryDdm1 .= "<option value=\"" . $row["username"] . "\">" . $row["fullname"] . "</option>";
                    if($row["fullname"] !== $_SESSION["fullname"])
                        $jQueryDdm2 .= "<option value=\"" . $row["username"] . "\">" . $row["fullname"] . "</option>";                    
                }       
            $jQueryDdm1 .= "');";
            $jQueryDdm2 .= "');";
            
            $jQueryFillForm .= $jQueryDdm1 . $jQueryDdm2 . $jQueryDdm1Val . $jQueryDdm2Val;

            $jQueryFillForm .= "$('#dpAgendaDatum').val('" . (date_create($row4["agendadatum"]))->format("Y-m-d\TH:i") . "');";
            $jQueryFillForm .= "$('#txtAgendaReden').val('" . str_replace(array("\r\n", "\n\r", "\r", "\n"),"&#13;&#10;",$row4["tekst"]) . "');";
        }    
        
        file_put_contents("../../Resource/JS/addUI.js", $jQueryFillForm, FILE_APPEND);
        
        if($result != false)
            $result->free();
        if($result2 != false)
            $result2->free();
        if($result4 != false)
            $result4->free();
        
        $dbDomain->closeConnection();  
    ?>
    <?php
        echo "<script type=\"text/javascript\"> $(document).ready(function () {"
        . "$('#btnMenu').click(function () {"
        . "if($('nav').css('display') == 'none')"
        . "{"
        . "$('nav').css('display', 'inline-block')"
        . "}"
        . "else"
        . "{"
        . "$('nav').css('display', 'none')"  
        . "}"
        . "});"
        . "});</script>";
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
    <meta property="og:title" content="Agendaform">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.php">
    <meta property="og:url" content="index.php">
  </head>
  <body class="u-body">
      <header class="u-grey-40 u-header u-header" id="sec-aa4e">      
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
        <h6 class="u-align-left u-text u-text-default u-text-1" id="formTitel"></h6>
        <div class="u-expanded-width u-table u-table-responsive u-table-1" id="tblHelpdeskItem">
        <form action=Agendaform.php method="POST" name="frmAgendapunt" id="frmAgendapunt">
          <table class="u-table-entity">
            <colgroup>
              <col width="50%">
              <col width="50%">
            </colgroup>
            <tbody class="u-table-body">
              <tr style="height: 65px;">
                <td class="u-table-cell">Van:</td>
                <td class="u-table-cell"><select id="ddmVanBehandelaar" name="ddmVanBehandelaar" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""></select></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Voor:</td>
                <td class="u-table-cell"><select id="ddmVoorBehandelaar" name="ddmVoorBehandelaar" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""></select></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Agendadatum:</td>
                <td class="u-table-cell"><input type="datetime-local" id="dpAgendaDatum" name="dpAgendaDatum" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required=""></td>
              </tr>
              <tr style="height: 65px;">
                <td class="u-table-cell">Reden:</td>
                <td class="u-table-cell"><input type="text" id="txtAgendaReden" name="txtAgendaReden" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" maxlength="100" required=""></td>
              </tr>              
            </tbody>
          </table>
        <input type="hidden" name="typeForm" value="<?php echo $_POST["typeForm"];?>">
        <input type="hidden" name="regID" value="<?php echo $_POST["regID"];?>">
        <input type="hidden" name="agendaID" value="<?php echo $_POST["agendaID"];?>">
        </form>
        </div>
      </div>
    </section>
        </div>
    </div>
  </body>
</html>