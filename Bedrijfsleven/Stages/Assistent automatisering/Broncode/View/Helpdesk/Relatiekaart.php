<?php
//Laat geen geautomatiseerde PHP foutmeldingen zien in het HTML-document
error_reporting(0);

include "../../Utilities/BackendHelpdesk.php";

//Als er niet is ingelogd of de PHP-sessie is verlopen, dan moet de gebruiker worden teruggewezen naar het inlogpagina
if($_SESSION["ingelogd"] == "nee")
    header("Location: Inlogpagina-helpdesk.php");

//Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
$fp = fopen("../../Resource/JS/addUI.js", "w");
fclose($fp);

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
    <title>Relatiekaart</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
<link rel="stylesheet" href="../../Resource/CSS/Relatiekaart.css" media="screen">
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
    if ($_SESSION['ingelogd']=="ja")
    {
        echo "<script type=\"text/javascript\"> $(document).ready(function () {" 
        .  " $('header').append('<div id=\"accountBox\"><b><a href=\"MijnAccount.php\" title=\"accountKnop\">Ingelogd als " . $_SESSION['fullname'] . "<br> (" . $_SESSION['email'] . ")</a></b>"
        . " | <a href=\"Inlogpagina-helpdesk.php?ingelogd=nee\" title=\"logoutknop\">Uitloggen</a></div>')" 
        . "});</script>";
    }
    ?>
    <?php
        $row = null;
        $dbDomain->openConnection();
        $table = "kantoor";
        $condition = " INNER JOIN registratie ON kantoor.registratieID = registratie.registratieID"
        . " INNER JOIN licentie ON registratie.registratieID = licentie.registratieID"
        . " LEFT OUTER JOIN licentiemodules ON licentie.licentieID = licentiemodules.licentieID"
        . " LEFT OUTER JOIN relatiebeheer ON kantoor.kantoorID = relatiebeheer.kantoorID"
        . " LEFT OUTER JOIN demosessie ON relatiebeheer.relatieID = demosessie.relatieID";
        if(isset($_GET["id"]) && !empty($_GET["id"]))
        {
            $_GET["id"] = filter_input(INPUT_GET, "id", FILTER_SANITIZE_NUMBER_INT);
            $_GET["pakket"] = filter_input(INPUT_GET, "pakket", FILTER_SANITIZE_NUMBER_INT);
            $condition .= " WHERE registratie.registratieID = " . $_GET["id"];
            if(isset($_GET["pakket"]) && !empty($_GET["pakket"]))
                $condition .= " AND licentie.pakketID = " . $_GET["pakket"] . ";";
        }
        else if(isset($_GET["phoneNumber"]) && !empty($_GET["phoneNumber"]))
        {
            $_GET["phoneNumber"] = filter_input(INPUT_GET, "phoneNumber", FILTER_SANITIZE_NUMBER_INT);
            $condition .= " WHERE telNr1 = '" . $_GET["phoneNumber"] . "' OR telNr2 = '" . $_GET["phoneNumber"] . "';";
        }
        $result = $dbDomain->getResult($table, $condition, false, null, null);
        if($result != false)
            if($result->num_rows === 1)
                $row = $result->fetch_assoc();
        
        if(isset($_GET["phoneNumber"]) && isset($_GET["displayName"]))
        {            
            if($result->num_rows > 1)
            {
                $jQueryUpdatePage = "$(document).ready(function () {"
                . "alert('Er zijn meerdere kantoren die hetzelfde telefoonnummer hebben als de beller!');"
                . "$('#tdMsgKantoorkKeuze').append('<font color=red style=\"background: white;\">Er zijn meerdere kantoren die hetzelfde telefoonnummer hebben als de beller.</font>');"
                . "$('#kantoorNaamWaarde').append('<select id=\"ddmKantoren\" style=\"color:black\"><option value=\"\">--Kies uw gewenste kantoor--</option>";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryUpdatePage, FILE_APPEND);
                
                while($row = $result->fetch_assoc())
                {
                    $jQueryUpdatePage = "<option value=\"" . $row["registratieID"] . "\">"
                    . $row["kantoorNaam"] . "</option>";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryUpdatePage, FILE_APPEND);
                }
                
                $result->free();
                $jQueryUpdatePage = "</select>');});";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryUpdatePage, FILE_APPEND);
            }
            else if($result->num_rows == 1)
            {
                $jQueryUpdatePage = "$(document).ready(function () {"
                . "$('#tdMsgKantoorkKeuze').append('Kantoornaam:');"
                . "$('#kantoorNaamWaarde').append('" . $row["kantoorNaam"] . "');"
                . "open('HelpdeskItem.php?regID=" . $row["registratieID"] . "&typeForm=new&crmIntegratie=true', '_blank');"
                . "});";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryUpdatePage, FILE_APPEND);
            }
            else
            {
                //Er is geen geldige relatiekaart gevonden
                $jQueryUpdatePage = "$(document).ready(function () {"
                . "$('#tdMsgKantoorkKeuze').append('Kantoornaam:');"
                . "$('#kantoorNaamWaarde').append('onbekend');"
                . "});";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryUpdatePage, FILE_APPEND);
                //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
                $fp = fopen("../../Resource/JS/showError.js", "w");
                fclose($fp);
                $jQueryShowError = "$(document).ready(function () {";
                $jQueryShowError .= "alert(\"Er is geen geldige relatiekaart, met telefoonnummer (" . $_GET["phoneNumber"] . "), gevonden in de database! Maak deze registratie (opnieuw) aan.\");";
                $jQueryShowError .= "});";
                file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
            }
        }
        else
        {
            $jQueryUpdatePage = "$(document).ready(function () {"
            . "$('#tdMsgKantoorkKeuze').append('Kantoornaam:');";

            if(!isset($row) || empty($row) || $row == false)
            {
                //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
                $fp = fopen("../../Resource/JS/showError.js", "w");
                fclose($fp);
                $jQueryShowError = "$(document).ready(function () {";
                $jQueryShowError .= "alert(\"Gezochte registratie bestaat niet in de database! Maak deze registratie (opnieuw) aan.\");";
                $jQueryShowError .= "});";
                file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
            }
            else
                $jQueryUpdatePage .= "$('#kantoorNaamWaarde').append('" . $row["kantoorNaam"] . "');";
            
            $jQueryUpdatePage .= "});";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryUpdatePage, FILE_APPEND);
        }
    ?>
    <?php
        if(isset($_GET["agendaID"]) && !empty($_GET["agendaID"]))
        {
            $dbDomain->openConnection();
            $agendaID = filter_input(INPUT_GET, "agendaID", FILTER_SANITIZE_NUMBER_INT);
            $dmlStatement = "UPDATE agenda SET af = 1 WHERE id = " . $agendaID . ";";
            $dbDomain->executeStatement($dmlStatement, null, null, null);
            $dbDomain->closeConnection();
        }
    ?>
    <?php       
        $jQueryVerversForm = "$(document).ready(function () {";              
        
        if(isset($row) || !empty($row) || $row != false)
        {
            if(isset($_GET["id"]) && !empty($_GET["id"]) && empty($_POST["regID"]))
            {
                $_POST["regID"] = filter_input(INPUT_GET, "id", FILTER_SANITIZE_NUMBER_INT);
                unset($_GET["id"]);
            }
            else
                $_POST["regID"] = $row["registratieID"];
            
            if(isset($_GET["pakket"]) && !empty($_GET["pakket"]) && empty($_POST["pakketID"]))
            {
                $_POST["pakketID"] = filter_input(INPUT_GET, "pakket", FILTER_SANITIZE_NUMBER_INT);
                unset($_GET["pakket"]);
            }
            else
                $_POST["pakketID"] = $row["pakketID"];
            
            if($row["ipBan"] == "1")            
                $jQueryVerversForm .= "$('#titelKopRelatie').after('<h5><font color=\"red\" style=\"background: white;\"><b>LET OP: BLOKKADE ***** LET OP: BLOKKADE ***** LET OP: BLOKKADE </b></font></h5>');";
            if($_SESSION["fullname"] == "Romy Tyszka" && $row["bewaking"] == "1")
                $jQueryVerversForm .= "$('#titelKopRelatie').after('<h5><font color=\"red\" style=\"background: white;\"><b>LET OP: BEWAKEN ***** LET OP: BEWAKEN ***** LET OP: BEWAKEN </b></font></h5>');";            
            
            $tblFactuur = "facturen";
            $conditionTblFact = " WHERE afgewerkt = 0 AND registratie_id = " . $_POST["regID"] . ";";
            
            $rsFactuur = $dbDomain->getResult($tblFactuur, $conditionTblFact, false, null, null);
            if($rsFactuur != false)
            {
                if($rsFactuur->num_rows > 0)//\"opl.asp?id=" . $_POST["regID"]. "\"
                    $jQueryVerversForm .= "$('#titelKopRelatie').after('<a href=\"#" . "\"><H5><font color=\"red\" style=\"background: white;\">LET OP: DEZE RELATIE HEEFT EEN OPENSTAAND SALDO!&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; KLIK HIER</FONT></H5></a><br>');";
                $rsFactuur->free();
            }
            $jQueryVerversForm .= "$('#tdWijzigLicentie').append('<td colspan=\"4\"><a href=\"Relatieform.php?id=" . $_POST["regID"] . "&typeForm=edit\" class=\"u-border-2 u-btn u-button-style u-none\">Licentie aanpassen</a></td>');";
            $jQueryVerversForm .= "$('#lblAgenda').after('<a href=\"Agendaform.php?typeForm=new&regID=" . $_POST["regID"] . "\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" id=\"btnNieuwAgendaPunt\">Nieuw agendapunt aanmaken</a>');";
            $jQueryVerversForm .= "$('#lblHelpdesk').after('<a href=\"HelpdeskItem.php?regID=" . $_POST["regID"] . "&typeForm=new\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" id=\"btnNieuwHelpdeskItem\">Nieuw item aanmaken</a>');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            $jQueryVerversForm = "";
            
            $werktMetApp = "n.t.b.";
            $gebruiktIncasso = "n.t.b.";
            $geefKorting = "n.t.b.";
            $heeftBoekingen = false;
            $heeftHypotheken = false;
            $heeftADN = false;
            $heeftMaandbetalers = false;
            $heeftDeclaratie = false;
            $heeftBoekhouding = false;
            $heeftRolls = false;
            $heeftPakketten = false;
            $heeftSubagenten = false;
            $heeftVolmacht = false;
            $heeftWebExport = false;
            $heeftClientServer = false;

            switch(intval($row["werktMetApp"]))
            {
                case 1:
                    $werktMetApp = "Ja";
                    break;
                case 0:
                    $werktMetApp = "Nee";
                    break;
            }

            switch(intval($row["autoIncasso"]))
            {
                case 1:
                    $gebruiktIncasso = "Ja";
                    break;
                case 0:
                    $gebruiktIncasso = "Nee";
                    break;
            }

            switch(intval($row["heeftKorting"]))
            {
                case 1:
                    $geefKorting = "Ja";
                    break;
                case 0:
                    $geefKorting = "Nee";
                    break;
            }

            if(intval($row["heeftBoekingen"]) === 1)
                $heeftBoekingen = true;
            if(intval($row["heeftHypotheken"]) === 1)
                $heeftHypotheken = true;
            if(intval($row["heeftADN"]) === 1)
                $heeftADN = true;
            if(intval($row["heeftMaandBetalers"]) === 1)
                $heeftMaandbetalers = true;
            if(intval($row["heeftDeclaratie"]) === 1)
                $heeftDeclaratie = true;
            if(intval($row["heeftBoekhouding"]) === 1)
                $heeftBoekhouding = true;
            if(intval($row["heeftRolls"]) === 1)
                $heeftRolls = true;
            if(intval($row["heeftPakketten"]) === 1)
                $heeftPakketten = true;
            if($row["heeftSubagenten"] === 1)
                $heeftSubagenten = true;
            if($row["heeftVolmacht"] === 1)
                $heeftVolmacht = true;
            if($row["heeftWebexport"] === 1)
                $heeftWebExport = true;
            if($row["heeftClientServer"] === 1)
                $heeftClientServer = true;

            $jQueryVerversForm .= " $('#titelKopRelatie').append('" . "Registratie: " . $row["registratieID"] . " - " . $row["kantoorNaam"] . "');";
            $jQueryVerversForm .= " $('#oudKantoorNaamWaarde').append('" . $row["oudKantoorNaam"] . "');";
            $jQueryVerversForm .= " $('#contactPersoonWaarde').append('" . $row["contactpersoonFormelenaam"] . "');";
            $jQueryVerversForm .= " $('#cpVoornaamWaarde').append('" . $row["contactpersoonVoornaam"] . "');";            
            $jQueryVerversForm .= " $('#postAdres').append('" . $row["postAdres"] .  "');";
            $jQueryVerversForm .= " $('#postAdres').append(' " . $row["postPostcode"] . "');";
            $jQueryVerversForm .= " $('#postAdres').append(\" " . $row["postWoonplaats"] . "\");";
            $jQueryVerversForm .= " $('#vestigingsAdres').append('" . $row["vestigingsAdres"] . "');";
            $jQueryVerversForm .= " $('#vestigingsAdres').append(' " . $row["vestigingsPostcode"] . "');";
            $jQueryVerversForm .= " $('#vestigingsAdres').append(\" " . $row["vestigingsWoonplaats"] . "\");";
            $jQueryVerversForm .= " $('#telNrWaarde').append('" . $row["telNr1"] . "');";
//            if(isset($row["telNr1"]) && !empty($row["telNr1"]))
//                $jQueryVerversForm .= "$('#telNrWaarde').prop('onclick','open(\"HelpdeskItem.php?regID=" . $row["registratieID"] . "&typeForm=new&crmIntegratie=true\", \"_blank\")');";
            $jQueryVerversForm .= " $('#IBANWaarde').append('" . $row["IBAN"] . "');";
            $jQueryVerversForm .= " $('#telNr2Waarde').append('" . $row["telNr2"] . "');";
//            if(isset($row["telNr2"]) && !empty($row["telNr2"]))
//                $jQueryVerversForm .= "$('#telNr2Waarde').prop('onclick','open(\"HelpdeskItem.php?regID=" . $row["registratieID"] . "&typeForm=new&crmIntegratie=true\", \"_blank\")');";
            $jQueryVerversForm .= " $('#BICWaarde').append('" . $row["BIC"] . "');";
            $jQueryVerversForm .= " $('#emailAdresWaarde').append('" . $row["emailAdres"] . "');";
            $jQueryVerversForm .= " $('#mandaatNrWaarde').append('" . $row["mandaatNr"] . "');";
            if($row["websiteURL"] !== ".")
                if(str_contains($row["websiteURL"], "http://") || str_contains($row["websiteURL"], "https://") || str_contains($row["websiteURL"], "www"))
                    $jQueryVerversForm .= " $('#webLinkWaarde').append('<a href=\"" . $row["websiteURL"] . "\">" . $row["websiteURL"] . "</a>');";
                else
                    $jQueryVerversForm .= " $('#webLinkWaarde').append('<a href=\"http://" . $row["websiteURL"] . "\">" . $row["websiteURL"] . "</a>');";
            $jQueryVerversForm .= " $('#werktMetAppWaarde').append('" . $werktMetApp  . "');";
            if(intval($row["kvkNr"]) != 0)
                $jQueryVerversForm .= " $('#kvkNummerWaarde').append('" . $row["kvkNr"] . "');";
            if(!empty($row["urlLinkedIn"]) && isset($row["urlLinkedIn"]))
                $jQueryVerversForm .= " $('#LinkedInWaarde').append('<a href=\"" . $row["urlLinkedIn"] . ">" . $row["urlLinkedIn"] . "</a>');";
            $jQueryVerversForm .= " $('#loginPSWaarde').append('" . $row["loginWachtwoord"] . "');";
            if($_SESSION["ingelogdAdmin"] == "ja")
                if($row["pakketID"] != 1 && $row["pakketID"] != 11 && $row["pakketID"] != 3 && $row["pakketID"] != 4 && $row["pakketID"] != 5)
                {
                    $jQueryVerversForm .= "$('#tblKantoorData1 > tbody').prepend('<tr style=\"height: 30px;\">"
                    . "<td class=\"u-table-cell u-table-cell-1\" id=\"lblExtKlantNr\"></td>"
                    . "<td class=\"u-table-cell\" id=\"extKlantNrWaarde\"></td>"
                    . "<td class=\"u-table-cell u-table-cell-3\"></td>"
                    . "<td class=\"u-table-cell\"></td>"
                    . "</tr>');";
                    $jQueryVerversForm .= "$('#lblExtKlantNr').append('Extern klantnummer:');";
                    $jQueryVerversForm .= " $('#extKlantNrWaarde').append('" . $row["externKlantNr"] . "');";                    
                }

            $table2 = "pakketten";
            $condition2 = " WHERE id = " . $row["pakketID"];
            $result2 = $dbDomain->getResult($table2, $condition2, false, null, null);

            if($result2 != false)
            {
                $row2 = $result2->fetch_assoc();
                $jQueryVerversForm .= " $('#pakketWaarde').append('" . $row["pakketID"] . " - " . $row2["Omschrijving"] . "');";                
            }
            else
                $jQueryVerversForm .= " $('#pakketWaarde').append('" . $row["pakketID"] . "');";

            $jQueryVerversForm .= " $('#numUsersWaarde').append('" . $row["aantalGebruikers"] . "');";
            $jQueryVerversForm .= " $('#ingangsDatumWaarde').append('" . date_create($row["ingangsDatum"])->format("d-m-Y") . "');";
            $jQueryVerversForm .= " $('#eindDatumWaarde').append('" . date_create($row["supportTot"])->format("d-m-Y") . "');";

            $params3 = "omschrijving";
            $table3 = "statuscode";
            $condition3 = " WHERE statuscode = " . $row["status"];
            $result3 = $dbDomain->getSelectiveResult($params3, $table3, $condition3, false, null, null);

            if($result3 != false)
            {
                if($result3->num_rows > 0)
                {
                    $row3 = $result3->fetch_assoc();
                    $jQueryVerversForm .= " $('#statusWaarde').append('" . $row3["omschrijving"] . "');";
                }
            }

            if($row["pakketID"] == 1 || $row["pakketID"] == 11)
            {
                //haal gegevens uit het tabel 'stats' (deze tabel moet nog geëxporteerd worden uit database 'ass20_stats')
                //$params4 = "ID, versie, timestamp";
                $params4 = "id, versie, laatstIngelogd";
                $table4 = "stats";
                $condition4 = " WHERE handeling = 'inloggen' AND kantoor = '" . str_replace("'","",$row["kantoorNaam"]) . "' ORDER BY id DESC LIMIT 1";
                $result4 = $dbDomain->getSelectiveResult($params4, $table4, $condition4, false, null, null);

                if($result4 != false)
                {
                    $row4 = $result4->fetch_assoc();

                    $jQueryVerversForm .= " $('#ass20VersieWaarde').append('" . $row4["versie"] . "');";
                    $jQueryVerversForm .= " $('#laatstInlogDatumTijd').append('" . date_create($row4["timestamp"])->format("d-m-Y") . "');";
                }
            }

            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

            $jQueryVerversForm = " $('#moduleWaarde').append('"
            . ($heeftBoekingen ? "| Boekingen | " : "")
            . ($heeftHypotheken ? "Hypotheken | " : "" )
            . ($heeftADN ? "ADN | " : "")
            . ($heeftMaandbetalers ? "Maandbetalers | " : "")                    
            . ($heeftDeclaratie ? "Declaratie | " : "")
            . ($heeftBoekhouding ? "Boekhouding | " : "")
            . ($heeftRolls ? "Rolls | " : "")
            . ($heeftPakketten ? "Pakketten | " : "")
            . ($heeftSubagenten ? "Subagenten | " : "")
            . ($heeftVolmacht ? "Volmacht | " : "")
            . ($heeftWebExport ? "WebExport |" : "")
            . ($heeftClientServer ? "ClientServer |" : "");

            $jQueryVerversForm .= "');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

            if($row["pakketID"] === 90 || $row["pakketID"] === 91)
            {
                $jQueryVerversForm = "$('#tblLicentie > tbody').append('" 
                . "<tr><td colspan=\"4\">"
                . "<p style=\"color:red\"><b>Verwijder een licentie alléén als je zeker weet dat die nooit meer nodig is! Een prospect verwijder je dus alleen als het bedrijf niet meer bestaat - het kan immers zijn dat iemand na jaren nog eens opduikt. Dan is het handig om de gegevens nog bij de hand te hebben.<br><br>Een \"probeersel\" kan je natuurlijk zonder problemen verwijderen.<br><br></b></p>"
                . "</td><tr>" 
                . "<td colspan=\"4\" class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">"
                . "<input id=\"btnVerwijderProspect\" type=\"button\" value=\"Prospects verwijderen\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\">"
                . "</td>"
                . "</tr>"
                . "');";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }

            if(isset($row["licentieBedrag"]) && !empty($row["licentieBedrag"]) && !is_nan(floatval($row["licentieBedrag"])))
            {
                if(!is_nan(floatval($row["btwPercentage"])))
                {
                    $jQueryVerversForm = "$('#lblLicBedrag').append('Licentiebedrag incl. btw:');";
                    $licentieBedragIncBtw = floatval($row["licentieBedrag"]) * (1 + floatval($row["btwPercentage"]) / 100);
                }
                else
                {
                    $jQueryVerversForm = "$('#lblLicBedrag').append('Licentiebedrag excl. btw:');";
                    $licentieBedragIncBtw = floatval($row["licentieBedrag"]);
                }
                
                $licentieBedragIncBtw = (round($licentieBedragIncBtw * 100)) / 100;
                $jQueryVerversForm .= " $('#licBedragWaarde').append('" . number_format($licentieBedragIncBtw , 2) . "');";
            }
            
            $jQueryVerversForm .= " $('#licPeriodeWaarde').append('" . $row["licentiePeriode"] . " mnd');";
            if(!empty($row["ekFactuurDatum"]))
                $jQueryVerversForm .= " $('#ekFacDatumWaarde').append('" . date_create($row["ekFactuurDatum"])->format("d-m-Y") . "');";
            $jQueryVerversForm .= " $('#laatsteIndexWaarde').append('" . date_create($row["datumLaatsteIndex"])->format("d-m-Y") . "');";
            $jQueryVerversForm .= " $('#btwPercWaarde').append('" . str_replace(".",",",strval($row["btwPercentage"])) . "');";
            $jQueryVerversForm .= " $('#autoIncassoWaarde').append('" . $gebruiktIncasso . "');";
            $jQueryVerversForm .= " $('#heeftKortingWaarde').append('" . $geefKorting . "');";

            if($geefKorting === "Ja")
            {
                $jQueryVerversForm .= " $('#redenKortingWaarde').append('" . $row["redenKorting"] .  "');";
                $jQueryVerversForm .= " $('#hoogteKortingWaarde').append('" . str_replace(".",",",strval($row["hoogteKorting"])) . "');";
            }

            $params5 = "COUNT(registratie_id) AS aantal";
            $tabel5 = "facturen";
            $condition5 = " WHERE bijzonderheden LIKE '%storno%' AND DATEDIFF(DATE(NOW()), factuurdatum) < 180 AND registratie_id = " . $_POST["regID"];
            $result5 = $dbDomain->getSelectiveResult($params5, $tabel5, $condition5, false, null, null);
            
//            $huidigeDatum = date_create(date("Y-m-d"));
//            $factuurDatum = date_create($row5["factuurdatum"]);
//            $datumVerschil = date_diff($huidigeDatum, $factuurDatum);
            
            if($result5 != false)
            {
                $row5 = $result5->fetch_assoc();
                $jQueryVerversForm .= " $('#aantalStornoWaarde').append('" . $row5["aantal"] . "');";
            }

            if(!empty($row["laatstOpgehaaldOp"]))
                $jQueryVerversForm .= " $('#recentDatumLicentieWaarde').append('" . date_create($row["laatstOpgehaaldOp"])->format("d-m-Y") . "');";

            if(!empty($row["demoDatum"]))
                $jQueryVerversForm .= " $('#demoDatumWaarde').append('" . date_create($row["demoDatum"])->format("d-m-Y") . "');";

            if($row["bronID"] != "" && isset($row["bronID"]))
            {
                $params6 = "omschrijving";
                $tabel6 = "bronnen";
                $condition6 = " WHERE id = " . $row["bronID"];
                $result6 = $dbDomain->getSelectiveResult($params6, $tabel6, $condition6, false, null, null);
                if($result6 != false)
                {    
                    if($result6->num_rows > 0)
                    {
                        $row6 = $result6->fetch_assoc();
                        $jQueryVerversForm .= " $('#bronWaarde').append('" . $row6["omschrijving"] . "');";                      
                    }            
                }
            } 

            $jQueryVerversForm .= " $('#bron2Waarde').append('" . $row["bronOmschrijving"] .  "');";
            $jQueryVerversForm .= " $('#conversiePersoonWaarde').append('" . $row["conversieDoor"] . "');";
            $jQueryVerversForm .= " $('#conPakketWaarde').append('" . $row["conversiePakket"] . "');";

            $jQueryVerversForm .= " $('#vorigPakketWaarde').append('" . $row["vorigPakket"] . "');";

            if($_SESSION["ingelogdAdmin"] == "ja")
            {
                $jQueryVerversForm .= "$('#lblProducent').append('Producent:');";
                $jQueryVerversForm .= " $('#producentWaarde').append('" . $row["producent"] . "');";
            }
            if(!empty($row["datumMailing"]))
                $jQueryVerversForm .= " $('#datumMailingWaarde').append('" . date_create($row["datumMailing"])->format("d-m-Y") . "');";
            $jQueryVerversForm .= " $('#welkomstgeschenkWaarde').append('" . $row["welkomstGeschenk"] . "');";
            $jQueryVerversForm .= " $('#verstuurdOpWaarde').append('" . date_create($row["verstuurdOp"])->format("d-m-Y") . "');";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            
            if(isset($row["opmerkingen"]) && !empty($row["opmerkingen"]))
            {
                $jQueryVerversForm = " $('#txtArNotities').append('" . str_replace(array("\r\n", "\n\r", "\r", "\n"),"&#13;&#10;",$row["opmerkingen"]) . "');";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }
            else
            {
                $jQueryVerversForm = " $('#txtArNotities').append('Er zijn geen opmerkingen');";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }
            
            $table7 = "agenda";
            $condition7 = " WHERE af = 0 AND registratieId = " . $_POST["regID"] . " ORDER BY agendadatum;";
            $result7 = $dbDomain->getResult($table7, $condition7, false, null, null);

            if($result7 != false)
            {
                if($result7->num_rows > 0)
                {
                    while($row7 = $result7->fetch_assoc())
                    {
                        if(isset($row7["tekst"]) && !empty($row7["tekst"]))
                            $row7["tekst"] = str_replace(array("\r\n", "\n\r", "\r", "\n"),"<br><br>",$row7["tekst"]);
                      $jQueryVerversForm = " $('#tblAgenda > tbody').append('";
                      $jQueryVerversForm .= "<tr style=\"height: 30x;\">"; 
                      $jQueryVerversForm .= "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" . $row7["van"] 
                        . "</td><td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" . $row7["voor"] .
                        "</td><td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" . date_create($row7["agendadatum"])->format("d-m-Y") .
                        "</td><td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" . $row7["tekst"] .
                        "</td><td><a href=\"Agendaform.php?typeForm=edit&agendaID=" . $row7["id"] 
                        . "&regID=" . $_POST["regID"] . "\">wijzigen</a> | <a href=\"Relatiekaart.php?agendaID=" . $row7["id"] . "&id=" . $_POST["regID"] . "&pakket=" . $_POST["pakketID"] . "\">afleggen</a></td>" 
                        ."</tr>');";
                      file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                   } 
                }
            }
            else
            {
                $jQueryVerversForm = " $('#tblAgenda > tbody').append('";
                $jQueryVerversForm .= "<tr><td></td><td colspan=\"5\">Er zijn (voor deze relatie) geen openstaande agendapunten</td></tr>";
                $jQueryVerversForm .= "');";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }

            $table8 = "helpdesk";
            $condition8 = " WHERE RegistratieID = " . $row["registratieID"] . " ORDER BY datumtijd DESC, sticky DESC;";
            $result8 = $dbDomain->getResult($table8, $condition8, false, null, null);

            $jQueryVerversForm = "";

            if($result8 != false)
            {
                if($result8->num_rows > 0)
                {
                    $jQueryVerversForm = " $('#aantalHDWaarde').append('" . $result8->num_rows . " items');";
                    $jQueryVerversForm .= "$('#tblHelpdesk > tbody').append('";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                    while($row8 = $result8->fetch_assoc())
                    {
                        if(isset($row8["vraag"]) && !empty($row8["vraag"]))
                            $row8["vraag"] = str_replace(array("\r\n", "\n\r", "\r", "\n"), "<br><br>",$row8["vraag"]);
                        $jQueryVerversForm = " <tr style=\"height: 30px;\">" 
                        . "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" 
                        . "<a href=\"HelpdeskItem.php?regID=" . $_POST["regID"] . "&ticketID=" . $row8["id"] . "\">" 
                        . $row8["datumtijd"] . "</a></td>"
                        . "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" .$row8["persoon"] . "</td>"
                        . "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" .$row8["Behandelaar"] . "</td>"
                        . "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" . $row8["categorie"] . "</td>"
                        . "</tr>";
                        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                    }
                    $jQueryVerversForm = "');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
            }
            else
            {
                $jQueryVerversForm = " $('#aantalHDWaarde').append('0 items');";
                $jQueryVerversForm .= " $('#sec-7a1b').append('Er zijn geen helpdeskitems die aan de voorwaarden voldoen');";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }

            //Als er nog geldige resultsets zijn aangemaakt uit de SQL-verbinding, maak deze dan leeg zodat deze vrij wordt gemaakt uit de werkgeheugen
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
            if($result6 != false)
                $result6->free();
            if($result7 != false)
                $result7->free();
            if($result8 != false)
                $result8->free();
            $dbDomain->closeConnection();

            $jQueryVerversForm = "});";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
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
    <script type="text/javascript" src="../../Resource/JS/checkCRMIntegratie.js"></script>
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>
    <meta property="og:title" content="Relatiekaart">
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
        <section id="sec-42ff" class="mainContent">
          <h5 class="u-text" id="titelKopRelatie"></h5>   
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity" id="tblKantoorData1">
              <colgroup>
                <col width="25%">
                <col width="25%">
                <col width="25%">
                <col width="25%">
              </colgroup>
              <tbody class="u-table-body">
                <tr style="height: 30px;">
                  <td class="u-table-cell u-table-cell-1" id="tdMsgKantoorkKeuze"></td>
                  <td class="u-table-cell" id="kantoorNaamWaarde"></td>
                  <td class="u-table-cell u-table-cell-3">evt. oude kantoornaam: </td>
                  <td class="u-table-cell" id="oudKantoorNaamWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-5">Contactpersoon:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="contactPersoonWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-7">Voornaam:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="cpVoornaamWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">Vestigingsadres:</td>                  
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-11" id="vestigingsAdres" colspan="3"></td>
                </tr>                
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Postadres:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="postAdres" colspan="3"></td>                  
                </tr>
              </tbody>
            </table>
          </div>
        </section>
        <section id="sec-7bf0" class="mainContent">
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity">
              <colgroup>
                <col width="25%">
                <col width="25%">
                <col width="25%">
                <col width="25%">
              </colgroup>
              <tbody class="u-table-body">
                <tr style="height: 30px;">
                  <td class="u-table-cell u-table-cell-1">Telefoon:</td>
                  <td class="u-table-cell" id="telNrWaarde" onclick="parent.open('HelpdeskItem.php?regID=<?php echo $row["registratieID"] ?>&typeForm=new&crmIntegratie=true', '_blank')"></td>
                  <td class="u-table-cell u-table-cell-3">IBAN:</td>
                  <td class="u-table-cell" id="IBANWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-5">Telefoon2:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="telNr2Waarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-7">BIC:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="BICWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">Emailadres:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="emailAdresWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-11">Mandaatnummer:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="mandaatNrWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Website:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="webLinkWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-15">Werkt met de app:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="werktMetAppWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-17">KvK-nummer:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="kvkNummerWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-19">LinkedIn:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="LinkedInWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-21">Login password:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="loginPSWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                </tr>
              </tbody>
            </table>
          </div>
        </section>
        <section class="mainContent u-valign-middle" id="sec-eba9">
          <div class="u-border-3 u-border-custom-color-1 u-line u-line-horizontal u-line-1"></div>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity" id="tblLicentie">
              <colgroup>
                <col width="25%">
                <col width="25%">
                <col width="25%">
                <col width="25%">
              </colgroup>
              <tbody class="u-table-body">
                <tr style="height: 30px;">
                  <td class="u-table-cell u-table-cell-5">Pakket:</td>
                  <td class="u-table-cell" id="pakketWaarde"></td>
                  <td class="u-table-cell u-table-cell-7">Aantal gebruikers:</td>
                  <td class="u-table-cell" id="numUsersWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">Ingangsdatum:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="ingangsDatumWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-11">Einddatum:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="eindDatumWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-13">Status:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-14" id="statusWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-15">Laatste inlog:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-16" id="laatstInlogDatumTijd"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-17">Huidige versie:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="ass20VersieWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-21">Modules:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" colspan="3" id="moduleWaarde"></td>
                </tr>
                <tr id="tdWijzigLicentie">                    
                </tr>
              </tbody>
            </table>
          </div>
        </section>
        <section id="sec-d72c" class="mainContent">
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity">
              <colgroup>
                <col width="25%">
                <col width="25%">
                <col width="25%">
                <col width="25%">
              </colgroup>
              <tbody class="u-table-body">
                <tr style="height: 30px;">
                  <td class="u-table-cell u-table-cell-1">Licentieperiode in mnd:</td>
                  <td class="u-table-cell" id="licPeriodeWaarde"></td>
                  <td class="u-table-cell u-table-cell-3">e.k. factuurdatum:</td>
                  <td class="u-table-cell" id="ekFacDatumWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-5" id="lblLicBedrag"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="licBedragWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-7">laatste index:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="laatsteIndexWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">BTW percentage:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="btwPercWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-11">autom. incasso:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="autoIncassoWaarde"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Korting:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="heeftKortingWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="redenKortingWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="hoogteKortingWaarde"></td>
                </tr>
              </tbody>
            </table>
          </div>
        </section>
        <section id="sec-6d16" class="mainContent">
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity">
              <colgroup>
                <col width="50%">
                <col width="50%">
              </colgroup>
              <tbody class="u-table-body">
                <tr style="height: 30px;">
                    <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="aantalStornoWaarde">Aantal storno's laatste 6 mnd: </td>
                    <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="recentDatumLicentieWaarde">licentie laatst opgehaald op: </td>
                </tr>
              </tbody>
            </table>
          </div>
        </section>
        <section id="sec-4d4d" class="mainContent">
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity">
              <colgroup>
                <col width="19%">
                <col width="31.2%">
                <col width="24.8%">
                <col width="25%">
              </colgroup>
              <tbody class="u-table-body">
                <tr style="height: 30px;">
                  <td class="u-table-cell u-table-cell-1">Demonstratie gehad op:</td>
                  <td class="u-table-cell" id="demoDatumWaarde"></td>
                  <td class="u-table-cell"></td>
                  <td class="u-table-cell"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-5">Bron:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="bronWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="bron2Waarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">Conversie door:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="conversiePersoonWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" colspan=\"2\"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Conversie gedaan vanuit:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="conPakketWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" colspan=\"2\"></td>              
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-17">Vorig pakket:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="vorigPakketWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" colspan=\"2\"></td>
                </tr>
                <tr style="height: 30px;">
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-21" id="lblProducent"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="producentWaarde"></td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-23">Datum mailing:</td>
                  <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="datumMailingWaarde"></td>
                </tr>
              </tbody>
            </table>
          </div>
        </section>
        <section id="sec-2871" class="mainContent">
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity">
              <colgroup>
                <col width="50%">
                <col width="50%">
              </colgroup>
              <tbody class="u-table-body">
                <tr style="height: 30px;">
                    <td class="u-text u-text-1 u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="welkomstgeschenkWaarde">Welkomstgeschenk:</td>                 
                    <td class="u-text u-text-2 u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="verstuurdOpWaarde">Verstuurd op: </td>
                </tr>
              </tbody>
            </table>
          </div>
        </section>
        <section id="sec-f653" class="mainContent">
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
            <p class="u-align-center u-text u-text-1">Notities:</p>     
            <textarea placeholder="" rows="4" cols="50" id="txtArNotities" name="txtArNotities" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" readonly></textarea>
        </section>
        <section id="sec-ae3f" class="mainContent">
          <div class="u-border-3 u-border-grey-dark-1 u-line u-line-vertical u-line-1"></div>
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-2"></div>
          <h5 class="u-align-center u-text u-text-1" id="lblAgenda">Agenda</h5>          
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity" id="tblAgenda">
              <colgroup>
                <col width="20%">
                <col width="20%">
                <col width="20%">
                <col width="20%">
                <col width="20%">
              </colgroup>
              <thead class="u-grey-50 u-table-header u-table-header-1">
                <tr style="height: 26px;">
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Van</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Voor</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Datum</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Reden</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell"></th>
                </tr>
              </thead>
              <tbody class="u-table-body">
              </tbody>
            </table>
          </div>
        </section>
        <section id="sec-7a1b" class="mainContent">
          <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
          <h5 class="u-align-center u-text u-text-1" id='lblHelpdesk'>Helpdeskitems</h5>          
          <h6 class="u-align-center u-text u-text-2" id="aantalHDWaarde"></h6>
          <div class="u-table u-table-responsive u-table-1">
            <table class="u-table-entity" id="tblHelpdesk">
              <colgroup>
                <col width="20%">
                <col width="20%">
                <col width="20%">
                <col width="20%">
                <col width="20%">
              </colgroup>
              <thead class="u-grey-50 u-table-header u-table-header-1">
                <tr style="height: 21px;">
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Datum</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Contactpersoon</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Behandelaar</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Tekst</th>
                  <th class="u-border-1 u-border-grey-50 u-table-cell">Categorie</th>
                </tr>
              </thead>
              <tbody class="u-table-body">
              </tbody>
            </table>
          </div>
        </section>
        </div>
    </div>
  </body>
</html>