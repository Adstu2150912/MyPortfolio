<?php
error_reporting(0);
include "../../Utilities/BackendHelpdesk.php";

if($_SESSION["ingelogd"] == "nee")
    header("Location: Inlogpagina-helpdesk.php");

?>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>Relatieformulier</title>
    <link rel="stylesheet" href="../../Resource/CSS/nicepage.css" media="screen">
    <link rel="stylesheet" href="../../Resource/CSS/Relatieform.css" media="screen">
    <link rel="stylesheet" href="https://code.jquery.com/qunit/qunit-2.15.0.css">
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
        if($_POST["btnSubmit"] == "VASTLEGGEN" && $_POST["typeForm"] == "new")
        {
            $isFormValid = true;
            if(empty($_POST["producent"]) || !isset($_POST["producent"]))
                $_POST["producent"] = "";           
            
            if(!empty($_POST["txtKortingPerc"]))
            {
                $_POST["txtKortingPerc"] = str_replace(",",".",$_POST["txtKortingPerc"]);
                $_POST["txtKortingPerc"] = filter_input(INPUT_POST, "txtKortingPerc", FILTER_VALIDATE_FLOAT, ["options" => ["decimal"]]);
                if($_POST["txtKortingPerc"] === false)
                {
                    $jQueryShowError = "$(document).ready(function () {";
                    $jQueryShowError .= "alert(\"Ingevoerde kortingspercentage is ongeldig! Dit moet uitsluitend een decimaal zijn zonder valutateken. Vul een punt i.p.v. een comma.\");";
                    $jQueryShowError .= "});";
                    file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                    $isFormValid = false;
                }
            }
            if(!empty($_POST["txtBTWPerc"]))
            {
                $_POST["txtBTWPerc"] = str_replace(",",".",$_POST["txtBTWPerc"]);
                $_POST["txtBTWPerc"] = filter_input(INPUT_POST, "txtBTWPerc", FILTER_VALIDATE_FLOAT, ["options" => ["decimal"]]);
                if($_POST["txtBTWPerc"] === false)
                {
                    $jQueryShowError = "$(document).ready(function () {";
                    $jQueryShowError .= "alert(\"Ingevoerde btw-percentage is ongeldig! Dit moet uitsluitend een decimaal zijn zonder valutateken. Vul een punt i.p.v. een comma.\");";
                    $jQueryShowError .= "});";
                    file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                    $isFormValid = false;
                }
            }
            if(!empty($_POST["txtLicBedrag"]))
            {
                $_POST["txtLicBedrag"] = str_replace(",",".",$_POST["txtLicBedrag"]);            
                $_POST["txtLicBedrag"] = filter_input(INPUT_POST, "txtLicBedrag", FILTER_VALIDATE_FLOAT, ["options" => ["decimal"]]);
                if($_POST["txtBTWPerc"] === false)
                {
                    $jQueryShowError = "$(document).ready(function () {";
                    $jQueryShowError .= "alert(\"Ingevoerde licentiebedrag is ongeldig! Dit moet uitsluitend een decimaal zijn zonder valutateken. Vul een punt i.p.v. een comma.\");";
                    $jQueryShowError .= "});";
                    file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                    $isFormValid = false;
                }
            }
            
            if($isFormValid)
            {
                $dbDomain->openConnection();
                $dmlStatement = "INSERT INTO registratie(registratieID, bewaking, websiteURL, urlLinkedIn, opmerkingen)"
                . "VALUES(?,?,?,?,?);";
                $strDataTypes = "iisss";
                $isBewaakt = 0;
                if($_POST["bewaking"] == "on")
                    $isBewaakt = 1;
                $aValues = [0, $isBewaakt, $_POST["txtWebsite"], $_POST["txtLinkedIn"], $_POST["txtArNotities"]];
                $nieuwRegistratieID = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                
                if($nieuwRegistratieID != false)
                {
                    $dmlStatement = "INSERT INTO kantoor(kantoorID, registratieID, kantoorNaam, oudKantoorNaam, kvkNr, telNr1, telNr2, emailAdres, ipAdres, ipBan, BIC, IBAN, autoIncasso, aantalGebruikers, loginWachtwoord,"
                    . "contactpersoonFormelenaam, contactpersoonVoornaam, contactpersoonAchternaam,vestigingsAdres, vestigingsPostcode, vestigingsWoonplaats, bezoekAdres, bezoekPostcode, bezoekWoonplaats,"
                    . "postAdres, postPostcode, postWoonplaats, mandaatNr, factuurPerMail, werktMetApp, werktMetAplaza)"
                    . "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                    $strDataTypes = "iississssissiissssssssssssssiii";
                    $aValues = array(); 
                    $aValues[] = 0; $aValues[] = $nieuwRegistratieID; $aValues[] = $_POST["txtKantoornaam"]; $aValues[] = $_POST["txtKantoornaam_oud"]; $aValues[] = intval($_POST["txtKvKNr"]); $aValues[] = $_POST["txtTelNr"]; $aValues[] = $_POST["txtTelNr2"];
                    $aValues[] = $_POST["txtEmailadres"]; $aValues[] = "X";
                    if($_POST["chkBlokkade"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;
                    $aValues[] = $_POST["ddmBIC"]; $aValues[] = $_POST["txtIBAN"];
                    if($_POST["rgIncasso"] == "ja")
                        $aValues[] = 1;
                    else if($_POST["rgIncasso"] == "nee")
                        $aValues[] = 0;
                    $aValues[] = intval($_POST["txtAantalGebr"]); $aValues[] = $_POST["txtWachtwoord"]; $aValues[] = $_POST["txtContactpersoon"]; $aValues[] = $_POST["txtCPvoornaam"]; $aValues[] = $_POST["txtCPachternaam"];
                    $aValues[] = $_POST["txtVestigingsadres"]; $aValues[] = $_POST["txtVestigingsPostcode"]; $aValues[] = $_POST["txtVestigingsWoonplaats"]; $aValues[] = $_POST["txtBezoekadres"]; $aValues[] = $_POST["txtBezoekPostcode"]; $aValues[] = $_POST["txtBezoekWoonplaats"];
                    $aValues[] = $_POST["txtPostadres"]; $aValues[] = $_POST["txtPostPostcode"]; $aValues[] = $_POST["txtPostWoonplaats"]; $aValues[] = $_POST["txtMandaatnr"];
                    if($_POST["rgFactuurMail"] == "ja")
                        $aValues[] = 1;
                    else if($_POST["rgFactuurMail"] == "nee")
                        $aValues[] = 0;
                    if($_POST["rgWerktMetApp"] == "ja")
                        $aValues[] = 1; 
                    else if($_POST["rgWerktMetApp"] == "nee")
                        $aValues[] = 0;
                    $aValues[] = 0;
                    
                    $nieuwKantoorID = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                    
                    if($nieuwKantoorID != false)
                    {                        
                        $dmlStatement = "INSERT INTO licentie(licentieID, registratieID, pakketID, status, ingangsDatum, geldigTot, supportTot, "
                        . "licentiePeriode, licentieBedrag, btwPercentage, heeftKorting, hoogteKorting, redenKorting"; 
                        $strDataTypes = "iiiisssisdids";
                        $aValues = [0,$nieuwRegistratieID, intval($_POST["ddmPakket"]),intval($_POST["ddmStatus"]), $_POST["dpIngangsdatum"],"9999-12-31", $_POST["dpEinddatum"],intval($_POST["txtLicPeriode"]), $_POST["txtLicBedrag"], floatval($_POST["txtBTWPerc"])];
                        if($_POST["rgGeefKorting"] == "ja")
                            $aValues[] = 1;
                        else if($_POST["rgGeefKorting"] == "nee")
                            $aValues[] = 0;
                        $aValues[] = floatval($_POST["txtKortingPerc"]); $aValues[] = $_POST["ddmRedenKorting"];
                        (!empty($_POST["dpFactuurdatum"]) ? $aValues[] = $_POST["dpFactuurdatum"] : NULL);
                        (!empty($_POST["dpLaatsteIndex"]) ? $aValues[] = $_POST["dpLaatsteIndex"] : NULL);
                        $strDataTypes .= (!empty($_POST["dpLaatsteIndex"]) ? "s" : "");
                        $dmlStatement .= (!empty($_POST["dpLaatsteIndex"]) ? ", datumLaatsteIndex" : "");                        
                        $strDataTypes .= (!empty($_POST["dpFactuurdatum"]) ? "s" : "");
                        $dmlStatement .= (!empty($_POST["dpFactuurdatum"]) ? ", ekFactuurDatum" : "");
                        $dmlStatement .= " ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?";
                        $dmlStatement .= (!empty($_POST["dpLaatsteIndex"]) ? ",?" : "");
                        $dmlStatement .= (!empty($_POST["dpFactuurdatum"]) ? ",?" : "");
                        $dmlStatement .= ");";
                        $nieuwLicentieID = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                        
                        if($nieuwLicentieID != false)
                        {                            
                            if($_POST["chkBoekingen"] == "on")
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkHypotheken"] == "on")
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkADN"] == "on")
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkMaandbetalers"] == "on")
                                $aValues[] = 1; 
                            else
                                $aValues[] = 0; 

                            if($_POST["chkDeclaratie"] == "on") 
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkVertaling"] == "on")
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkRolls"] == "on")
                                $aValues[] =  1;
                            else
                                $aValues[] =  0;

                            if($_POST["chkPakketten"] == "on")
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkSubagenten"] == "on")
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkVolmacht"] == "on")
                                $aValues[] = 1;
                            else
                                $aValues[] = 0;

                            if($_POST["chkWebexport"] == "on")
                                $aValues[] = 1; 
                            else
                                $aValues[] = 0;

                            if($_POST["chkClientServer"] == "on")
                                $aValues[] = 1; 
                            else
                                $aValues[] = 0; 
                            
                            if(in_array(1, $aValues))
                            {
                                $dmlStatement = "INSERT INTO licentiemodules(heeftBoekingen, heeftHypotheken, heeftADN, heeftMaandBetalers, heeftDeclaratie, heeftBoekhouding, "
                                . "heeftRolls, heeftPakketten, heeftSubagenten, heeftVolmacht, heeftWebexport, heeftClientServer, licentieID)"
                                . "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                $strDataTypes = "iiiiiiiiiiiii";
                                $aValues = [$nieuwLicentieID];
                                $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                            }
                        }
                        
                        $dmlStatement = "INSERT INTO relatiebeheer(relatieID, kantoorID, bronID, bronOmschrijving, conversiePakket, vorigPakket, conversieDoor, producent,"
                        . "welkomstGeschenk";                        
                        $strDataTypes = "iiissssss";
                        $aValues = [0, $nieuwKantoorID, intval($_POST["ddmBron"]), $_POST["txtBron2"],
                        $_POST["ddmConversie"], $_POST["ddmVorigPakket"], $_POST["ddmBehandelaar"], $_POST["producent"], $_POST["txtWelkomstgeschenk"]];
                        $dmlStatement .= (!empty($_POST["dpVerstuurdOp"]) ? ",verstuurdOp " : "");
                        (!empty($_POST["dpVerstuurdOp"]) ? $aValues[] = $_POST["dpVerstuurdOp"] : NULL);
                        $strDataTypes .= (!empty($_POST["dpVerstuurdOp"]) ? "s" : "");
                        $dmlStatement .= (!empty($_POST["dpMailing"]) ? ",datumMailing " : "");
                        (!empty($_POST["dpMailing"]) ? $aValues[] = $_POST["dpMailing"] : NULL);
                        $strDataTypes .= (!empty($_POST["dpMailing"]) ? "s" : "");
                        $dmlStatement .= " ) VALUES(?,?,?,?,?,?,?,?,?";
                        $dmlStatement .= (!empty($_POST["dpVerstuurdOp"]) ? ",?" : "");
                        $dmlStatement .= (!empty($_POST["dpMailing"]) ? ",?" : "");
                        $dmlStatement .= ");";

                        $nieuwRelatieID = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                        
                        if($nieuwRelatieID != false)
                        {
                            if(!empty($_POST["txtDemoAantal"]) && !empty($_POST["dpDemo"]))
                            {
                                $dmlStatement = "INSERT INTO demosessie(id, relatieID, aantalPersonen, demoDatum) VALUES(?,?,?,?);";
                                $strDataTypes = "iiis";
                                $aValues = [0,$nieuwRelatieID, intval($_POST["txtDemoAantal"]), $_POST["dpDemo"]];
                                $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                            }
                        }                        

                        $dbDomain->closeConnection();
                        if($nieuwRegistratieID != false)
                            header("Location: Relatiekaart.php?id=" . $nieuwRegistratieID);
                    }
                }
            }
        }
        else if($_POST["btnSubmit"] == "VASTLEGGEN" && $_POST["typeForm"] == "edit")
        {
            $isFormValid = true;
            if(empty($_POST["producent"]) || !isset($_POST["producent"]))
                $_POST["producent"] = "";
            $_POST["txtKortingPerc"] = str_replace(",",".",$_POST["txtKortingPerc"]);
            $_POST["txtBTWPerc"] = str_replace(",",".",$_POST["txtBTWPerc"]);
            
            $_POST["txtKortingPerc"] = filter_input(INPUT_POST, "txtKortingPerc", FILTER_VALIDATE_FLOAT, ["options" => ["decimal"]]);
            $_POST["txtBTWPerc"] = filter_input(INPUT_POST, "txtBTWPerc", FILTER_VALIDATE_FLOAT, ["options" => ["decimal"]]);
            if(!empty($_POST["txtKortingPerc"]) && $_POST["txtKortingPerc"] === false)                
            {
                $jQueryShowError = "$(document).ready(function () {";
                $jQueryShowError .= "alert(\"Ingevoerde kortingspercentage is ongeldig! Vul een punt i.p.v. een comma.\");";
                $jQueryShowError .= "});";
                file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                $isFormValid = false;
            }
            if(!empty($_POST["txtBTWPerc"]) && $_POST["txtBTWPerc"] === false)
            {
                $jQueryShowError = "$(document).ready(function () {";
                $jQueryShowError .= "alert(\"Ingevoerde btw-percentage is ongeldig! Vul een punt i.p.v. een comma.\");";
                $jQueryShowError .= "});";
                file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                $isFormValid = false;
            }
            
            if($isFormValid)
            {
                $dbDomain->openConnection();

                $_POST["regID"] = filter_input(INPUT_POST, "regID", FILTER_SANITIZE_NUMBER_INT);

                $params = "kantoorID";
                $table = "kantoor";
                $condition = " WHERE registratieID = " . $_POST["regID"] . ";";
                $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
                $kantoorID = 0;
                if($result != false)
                    if($result->num_rows > 0)
                    {
                        $row = $result->fetch_array();
                        $kantoorID = $row[0];
                    }

                $params = "licentieID";
                $table = "licentie";
                $condition = " WHERE registratieID = " . $_POST["regID"] . ";";
                $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);                
                $licentieID = 0;
                if($result != false)
                    if($result->num_rows > 0)
                    {
                        $row = $result->fetch_array();
                        $licentieID = $row[0];
                    }


                $params = "relatieID";
                $table = "relatiebeheer";
                $condition = " WHERE kantoorID = " . $kantoorID . ";";
                $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
                $relatieID = 0;
                if($result != false)
                    if($result->num_rows > 0)
                    {
                        $row = $result->fetch_array();
                        $relatieID = $row[0];
                    }

                $isBewaakt = 0;
                if($_POST["bewaking"] == "on")
                    $isBewaakt = 1;
                
                $dmlStatement = "UPDATE registratie SET bewaking = ?, websiteURL = ?, urlLinkedIn = ?, opmerkingen = ?"
                . " WHERE registratieID = ?;";                            
                
                $strDataTypes = "isssi";                
                $aValues = [$isBewaakt, $_POST["txtWebsite"], $_POST["txtLinkedIn"], $_POST["txtArNotities"], $_POST["regID"]];
                $numAffectedRows = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");

                $dmlStatement = "UPDATE kantoor SET kantoorNaam = ?, oudKantoorNaam = ?, kvkNr = ?, telNr1 = ?, telNr2 = ?, emailAdres = ?, ipAdres = ?, ipBan = ?, BIC = ?, IBAN = ?, autoIncasso = ?, aantalGebruikers = ?, loginWachtwoord = ?,"
                . "contactpersoonFormelenaam = ?, contactpersoonVoornaam = ?, contactpersoonAchternaam = ?, vestigingsAdres = ?, vestigingsPostcode = ?, vestigingsWoonplaats = ?, bezoekAdres = ?, bezoekPostcode = ?, bezoekWoonplaats = ?,"
                . "postAdres = ?, postPostcode = ?, postWoonplaats = ?, mandaatNr = ?, factuurPerMail = ?, werktMetApp = ?, werktMetAplaza = ? "
                . " WHERE registratieID = ?;";

                $strDataTypes = "ssissssissiissssssssssssssiiii";
                $aValues = array(); 
                $aValues[] = $_POST["txtKantoornaam"]; $aValues[] = $_POST["txtKantoornaam_oud"]; $aValues[] = intval($_POST["txtKvKNr"]); $aValues[] = $_POST["txtTelNr"]; $aValues[] = $_POST["txtTelNr2"];
                $aValues[] = $_POST["txtEmailadres"]; $aValues[] = "X";
                if($_POST["chkBlokkade"] == "on")
                    $aValues[] = 1;
                else
                    $aValues[] = 0;
                $aValues[] = $_POST["ddmBIC"]; $aValues[] = $_POST["txtIBAN"];
                if($_POST["rgIncasso"] == "ja")
                    $aValues[] = 1;
                else if($_POST["rgIncasso"] == "nee")
                    $aValues[] = 0;
                $aValues[] = intval($_POST["txtAantalGebr"]); $aValues[] = $_POST["txtWachtwoord"]; $aValues[] = $_POST["txtContactpersoon"]; $aValues[] = $_POST["txtCPvoornaam"]; $aValues[] = $_POST["txtCPachternaam"];
                $aValues[] = $_POST["txtVestigingsadres"]; $aValues[] = $_POST["txtVestigingsPostcode"]; $aValues[] = $_POST["txtVestigingsWoonplaats"]; $aValues[] = $_POST["txtBezoekadres"]; $aValues[] = $_POST["txtBezoekPostcode"]; $aValues[] = $_POST["txtBezoekWoonplaats"];
                $aValues[] = $_POST["txtPostadres"]; $aValues[] = $_POST["txtPostPostcode"]; $aValues[] = $_POST["txtPostWoonplaats"]; $aValues[] = $_POST["txtMandaatnr"];
                if($_POST["rgFactuurMail"] == "ja")
                    $aValues[] = 1;
                else if($_POST["rgFactuurMail"] == "nee")
                    $aValues[] = 0;
                if($_POST["rgWerktMetApp"] == "ja")
                    $aValues[] = 1; 
                else if($_POST["rgWerktMetApp"] == "nee")
                    $aValues[] = 0;
                $aValues[] = 0; $aValues[] = $_POST["regID"];
                $numAffectedRows = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");

                $dmlStatement = "UPDATE licentie SET pakketID = ?, status = ?, ingangsDatum = ?, geldigTot = ?, supportTot = ?,"
                . " licentiePeriode = ?, licentieBedrag = ?, btwPercentage = ?, heeftKorting = ?, hoogteKorting = ?, redenKorting = ?";

                $strDataTypes = "iisssisdids";
                $aValues = [intval($_POST["ddmPakket"]),intval($_POST["ddmStatus"]), $_POST["dpIngangsdatum"],"9999-12-31", $_POST["dpEinddatum"],intval($_POST["txtLicPeriode"]), $_POST["txtLicBedrag"], floatval($_POST["txtBTWPerc"])];
                if($_POST["rgGeefKorting"] == "ja")
                    $aValues[] = 1;
                else if($_POST["rgGeefKorting"] == "nee")
                    $aValues[] = 0;
                $aValues[] = floatval($_POST["txtKortingPerc"]); $aValues[] = $_POST["ddmRedenKorting"];
                (!empty($_POST["dpLaatsteIndex"]) ? $aValues[] = $_POST["dpLaatsteIndex"] : NULL);
                (!empty($_POST["dpFactuurdatum"]) ? $aValues[] = $_POST["dpFactuurdatum"] : NULL);
                $strDataTypes .= (!empty($_POST["dpLaatsteIndex"]) ? "s" : "");
                $strDataTypes .= (!empty($_POST["dpFactuurdatum"]) ? "s" : "");
                $dmlStatement .= (!empty($_POST["dpLaatsteIndex"]) ? ",datumLaatsteIndex = ?" : "");
                $dmlStatement .= (!empty($_POST["dpFactuurdatum"]) ? ",ekFactuurDatum = ?" : "");
                $aValues[] = $_POST["regID"];
                $strDataTypes .= "i";
                $dmlStatement .= " WHERE registratieID = ?;";
                $numAffectedRows = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");                
                
                if($licentieID != 0 && $licentieID != false)
                {
                    $params = "licentieID";
                    $table = "licentiemodules";
                    $condition = " WHERE licentieID = " . $licentieID . ";";
                    $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
                    $currentID = 0;
                    if($result != false)
                        if($result->num_rows > 0)
                        {
                            $row = $result->fetch_array();
                            $currentID = $row[0];
                        }
                    $aValues = array();
                    if($_POST["chkBoekingen"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkHypotheken"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkADN"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkMaandbetalers"] == "on")
                        $aValues[] = 1; 
                    else
                        $aValues[] = 0; 

                    if($_POST["chkDeclaratie"] == "on") 
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkVertaling"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkRolls"] == "on")
                        $aValues[] =  1;
                    else
                        $aValues[] =  0;

                    if($_POST["chkPakketten"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkSubagenten"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkVolmacht"] == "on")
                        $aValues[] = 1;
                    else
                        $aValues[] = 0;

                    if($_POST["chkWebexport"] == "on")
                        $aValues[] = 1; 
                    else
                        $aValues[] = 0;

                    if($_POST["chkClientServer"] == "on")
                        $aValues[] = 1; 
                    else
                        $aValues[] = 0;     
                    if($currentID != 0)
                    {
                        $dmlStatement = "UPDATE licentiemodules SET heeftBoekingen = ?, heeftHypotheken = ?, heeftADN = ?, heeftMaandBetalers = ?, heeftDeclaratie = ?, heeftBoekhouding = ?, "
                        . "heeftRolls = ?, heeftPakketten = ?, heeftSubagenten = ?, heeftVolmacht = ?, heeftWebexport = ?, heeftClientServer = ?"
                        . " WHERE licentieID = ?;";
                        $strDataTypes = "iiiiiiiiiiiii";
                        $aValues[] = $licentieID;
                        $numAffectedRows = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");
                    }
                    else
                    {
                        $dmlStatement = "INSERT INTO licentiemodules(heeftBoekingen, heeftHypotheken, heeftADN, heeftMaandBetalers, heeftDeclaratie, heeftBoekhouding, "
                        . "heeftRolls, heeftPakketten, heeftSubagenten, heeftVolmacht, heeftWebexport, heeftClientServer, licentieID)"
                        . "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        $strDataTypes = "iiiiiiiiiiiii";
                        $aValues[] = $licentieID;
                        $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                    }
                }

                $dmlStatement = "UPDATE relatiebeheer SET bronID = ?, bronOmschrijving = ?, conversiePakket = ?, vorigPakket = ?, conversieDoor = ?, producent = ?,"
                . "welkomstGeschenk = ?";
                $strDataTypes = "issssss";
                $aValues = [intval($_POST["ddmBron"]), $_POST["txtBron2"],
                $_POST["ddmConversie"], $_POST["ddmVorigPakket"], $_POST["ddmBehandelaar"], $_POST["producent"], $_POST["txtWelkomstgeschenk"]];            
                (!empty($_POST["dpVerstuurdOp"]) ? $aValues[] = $_POST["dpVerstuurdOp"] : NULL);
                $strDataTypes .= (!empty($_POST["dpVerstuurdOp"]) ? "s" : "");
                $dmlStatement .= (!empty($_POST["dpVerstuurdOp"]) ? ", verstuurdOp = ?" : "");
                (!empty($_POST["dpMailing"]) ? $aValues[] = $_POST["dpMailing"] : NULL);
                $strDataTypes .= (!empty($_POST["dpMailing"]) ? "s" : "");
                $dmlStatement .= (!empty($_POST["dpMailing"]) ? ", datumMailing = ?" : "");
                $aValues[] = $kantoorID;
                $strDataTypes .= "i";
                $dmlStatement .= " WHERE kantoorID = ?;";
                $numAffectedRows = $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");

                
                if(!empty($_POST["txtDemoAantal"]) && !empty($_POST["dpDemo"]))
                {   
                    if($relatieID != 0 || $relatieID != false)
                    {
                        $params = "id";
                        $table = "demosessie";
                        $condition = " WHERE relatieID = " . $relatieID . ";";
                        $result = $dbDomain->getSelectiveResult($params, $table, $condition, false, null, null);
                        $demoID = 0;
                        if($result != false)
                            if($result->num_rows > 0)
                            {
                                $row = $result->fetch_array();
                                $demoID = $row[0];
                            }
                        if($demoID != 0)
                        {
                            $dmlStatement = "UPDATE demosessie SET aantalPersonen = ?, demoDatum = ? WHERE relatieID = ?;";            
                            $strDataTypes = "isi";
                            $aValues = [intval($_POST["txtDemoAantal"]), $_POST["dpDemo"], $relatieID];
                            $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "update");  
                        }
                        else
                        {
                            $dmlStatement = "INSERT INTO demosessie(id, relatieID, aantalPersonen, demoDatum) VALUES(?,?,?,?);";
                            $strDataTypes = "iiis";
                            $aValues = [0,$relatieID, intval($_POST["txtDemoAantal"]), $_POST["dpDemo"]];
                            $dbDomain->executeStatement($dmlStatement, $strDataTypes, $aValues, "insert");
                        }
                    }                    
                }         
                if($result != false)
                    $result->free();
                $dbDomain->closeConnection();            
                header("Location: Relatiekaart.php?id=" . filter_input(INPUT_POST, "regID", FILTER_SANITIZE_NUMBER_INT));
            }
        }
    ?>
    <?php 
        if ($_SESSION['ingelogd'] == "ja")
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
            . "$('input').css('color', 'black');"
            . "$('select').css('color', 'black');"
            . "$('btnUitlegKorting').css('color', 'black');"
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
            . "$('#btnSubmit').addClass('u-border-black');"
            . "$('#btnSubmit').addClass('u-hover-black');"
            . "$('#btnSubmit').addClass('u-text-black');"
            . "$('#btnSubmit').addClass('u-text-hover-white');"
            . "$('#btnSubmit').css('border', '0 none transparent !important');"
            . "});</script>";
        }
    ?>
    <?php
        if(isset($_GET["id"]) && !empty($_GET["id"]) && empty($_POST["regID"]))
        {
            $_POST["regID"] = filter_input(INPUT_GET, "id", FILTER_VALIDATE_INT);            
            unset($_GET["id"]);
        }
        if(isset($_GET["typeForm"]) && !empty($_GET["typeForm"]) && empty($_POST["typeForm"]))
        {
            $_POST["typeForm"] = $_GET["typeForm"];
            unset($_GET["id"]);
        }
    
        //Onderstaande Javascript leegmaken om zodat alleen de bijhorende functionaliteiten van dit venster wordt aangeroepen
        $fp = fopen("../../Resource/JS/addUI.js", "w");
        fclose($fp);
    
        $jQueryVerversForm = "$(document).ready(function () {";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);     
        $jQueryVerversForm = "";
        
        function fillCbxStatus($huidigeStatus, $dbDomain)
        {
            $table = "statuscode";
            $condition = " ORDER BY statuscode;";
            $result = $dbDomain->getResult($table, $condition, false, null, null);
            $status = false;
            
            if($result != false)
            {
                while($row = $result->fetch_assoc())
                {
                    if($huidigeStatus === $row["statuscode"])
                        $status = true;
                    else
                        $status = false;
                    
                    $jQueryVerversForm = " $('#ddmStatus').append('<option value=\"" . $row["statuscode"] . "\" " . ($status ? "selected" : "") . ">" . $row["statuscode"] . " - " . $row["omschrijving"] .  "</option>');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result->free();
            }
        }        
        
        function fillComboBoxBIC($huidigeBIC, $dbDomain)
        {
            $table2 = "BIC";
            $condition2 = " ORDER BY omschrijving;";
            $result2 = $dbDomain->getResult($table2, $condition2, false, null, null);

            $isBIC = false;

            if($result2 != false)
            {
                while($row2 = $result2->fetch_assoc())
                {
                    if($huidigeBIC === $row2["BIC"])
                        $isBIC = true;
                    else
                        $isBIC = false;

                    $jQueryVerversForm = " $('#ddmBIC').append('<option value=\"" . $row2["BIC"] . "\" " . ($isBIC ? "selected" : "") . ">" . $row2["BIC"] . " - " . $row2["omschrijving"] .  "</option>');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result2->free();
            }
        }
        
        function fillComboBoxPakket($pakket, $dbDomain)
        {
            $tabel3 = "pakketten ";
            $condition3 = " ORDER BY omschrijving";
            $result3 = $dbDomain->getResult($tabel3, $condition3, false, null, null);

            if($result3 != false)
            {
                while($row3 = $result3->fetch_assoc())
                {
                    if($row3["id"] === $pakket)
                    {
                        $jQueryVerversForm = " $('#ddmPakket').append('<option value=\"" . $row3["id"] . "\" selected>" . $row3["Omschrijving"] . "</option>');";
                    }
                    else
                    {
                        $jQueryVerversForm = " $('#ddmPakket').append('<option value=\"" . $row3["id"] . "\">" . $row3["Omschrijving"] . "</option>');";
                    }

                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result3->free();
            }
        }
        
        function fillCB_Bron($bron, $dbDomain)
        {
            $table4 = "bronnen ";
            $condition4 = " ORDER BY id";
            $result4 = $dbDomain->getResult($table4, $condition4, false, null, null);

            if($result4 != false)
            {
                while($row4 = $result4->fetch_assoc())
                {
                    $jQueryVerversForm = " $('#ddmBron').append('";

                    $jQueryVerversForm .= "<option value=\"" . $row4["id"] . "\"";

                    if($bron === $row4["id"])
                        $jQueryVerversForm .= " selected";

                    $jQueryVerversForm .= ">" . $row4["id"] . " - " . $row4["omschrijving"] . "</option>";

                    $jQueryVerversForm .= "');";

                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result4->free();
            }
        }
        
        function fillCB_Behandelaar($behandelaar, $dbDomain)
        {
            $table5 = "users";
            $condition5 = " WHERE active = 1 ORDER BY fullname;";
            $result5 = $dbDomain->getResult($table5, $condition5, false, null, null);

            if($result5 != false)
            {
                while($row5 = $result5->fetch_assoc())
                {
                    $jQueryVerversForm = " $('#ddmBehandelaar').append('";

                    $jQueryVerversForm .= "<option value=\"" . $row5["username"] . "\"";

                    if($row5["username"] === $behandelaar)
                        $jQueryVerversForm .= " selected";

                    $jQueryVerversForm .= ">" . $row5["fullname"] . "</option>";

                    $jQueryVerversForm .= "');";

                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result5->free();
            }
        }
        
        function fillCB_Conversie($conversie, $dbDomain)
        {
            $table6 = "concurrenten ";
            $condition6 = " ORDER BY pakket";
            $result6 = $dbDomain->getResult($table6, $condition6, false, null, null);

            if($result6 != false)
            {
                while($row6 = $result6->fetch_assoc())
                {
                    $jQueryVerversForm = " $('#ddmConversie').append('";

                    $jQueryVerversForm .= "<option value=\"" . $row6["pakket"] . "\"";
                    if($conversie === $row6["pakket"])
                        $jQueryVerversForm .= " selected";
                    $jQueryVerversForm .= ">" . $row6["pakket"] . "</option>";

                    $jQueryVerversForm .= "');";

                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result6->free();
            }
        }
        
        function fillCB_VorigPakket($vorigPakket, $dbDomain)
        {
            $table7 = "concurrenten ";
            $condition7 = " ORDER BY pakket";
            $result7 = $dbDomain->getResult($table7, $condition7, false, null, null);

            if($result7 != false)
            {
                while($row7 = $result7->fetch_assoc())
                {
                    $jQueryVerversForm = " $('#ddmVorigPakket').append('";
                    $jQueryVerversForm .= "<option value=\"" . $row7["pakket"] . "\"";
                    if($vorigPakket === $row7["pakket"])
                        $jQueryVerversForm .= " selected";
                    $jQueryVerversForm .= ">" . $row7["pakket"] . "</option>";
                    $jQueryVerversForm .= "');";

                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result7->free();
            }
        }
        
        function fillCB_Producent($producent, $dbDomain)
        {            
            if($_SESSION["ingelogdAdmin"] == "ja")
            {
                $table5 = "users";
                $condition5 = " WHERE active = 1 ORDER BY fullname;";
            
                $jQueryVerversForm = "$('#lblProducent').append('Producent*:');";
                $jQueryVerversForm .= "$('#tdProducent').append('";                                

                $jQueryVerversForm .= "<select name=\"producent\"><option value=\"n.v.t.\">n.v.t.</option>";

                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                
                $result8 = $dbDomain->getResult($table5, $condition5, false, null, null);

                if($result8 != false)
                {
                    while($row8 = $result8->fetch_assoc())
                    {
                        $jQueryVerversForm = "<option value=\"" . $row8["username"] . "\"";

                        if($row8["username"] === $producent)
                            $jQueryVerversForm .= " selected";

                        $jQueryVerversForm .= ">" . $row8["fullname"] . "</option>";

                        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                    }
                    $result8->free();
                }

                $jQueryVerversForm = "</select>');";
                file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            }            
        }
        
        function fillCbxRedenKorting($huidigeReden, $dbDomain)
        {
            $table9 = "redenkorting";
            $condition9 = " ORDER BY Id;";
            $result9 = $dbDomain->getResult($table9, $condition9, false, null, null);
            $redenKorting = false;
            
            if($result9 != false)
            {
                while($row9 = $result9->fetch_assoc())
                {
                    if($huidigeReden === $row9["omschrijving"])
                        $status = true;
                    else
                        $status = false;
                    
                    $jQueryVerversForm = " $('#ddmRedenKorting').append('<option value=\"" . $row9["Id"] . "\" " . ($status ? "selected" : "") . ">" . $row9["Id"] . " - " . $row9["omschrijving"] .  "</option>');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result9->free();
            }
        }
        
        if($_POST["typeForm"] == "new")
        {
            $dbDomain->openConnection();
            
            fillCbxStatus(11, $dbDomain);
            fillComboBoxBIC(null, $dbDomain);
            fillComboBoxPakket(null, $dbDomain);           
            fillCB_Bron(null, $dbDomain);
            fillCB_Behandelaar(null, $dbDomain);
            fillCB_Conversie(null, $dbDomain);
            fillCB_VorigPakket(null, $dbDomain);            
            fillCB_Producent(null, $dbDomain);
            fillCbxRedenKorting(null, $dbDomain);
            
            $jQueryVerversForm = " $('#tdBlokkade').append('<input type=\"checkbox\" name=\"chkBlokkade\">');";
            $jQueryVerversForm = " $('#dpLaatsteIndex').val('" . date("Y-m-d") . "');";
            $jQueryVerversForm .= " $('#dpIngangsdatum').val('" . date_format(date_create("9999-12-31"), "Y-m-d") . "');";
            $jQueryVerversForm .= " $('#dpEinddatum').val('" . date_format(date_create("9999-12-31"), "Y-m-d") . "');";
            $jQueryVerversForm .= "$('#chkPakketten').prop('checked', true);";
            file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
            
            $dbDomain->closeConnection();
        }
        else if($_POST["typeForm"] == "edit")
        {              
            $dbDomain->openConnection();
            $table = "kantoor";
            $condition = " INNER JOIN registratie ON kantoor.registratieID = registratie.registratieID"
            . " INNER JOIN licentie ON registratie.registratieID = licentie.registratieID"
            . " LEFT OUTER JOIN licentiemodules ON licentie.licentieID = licentiemodules.licentieID"
            . " LEFT OUTER JOIN relatiebeheer ON kantoor.kantoorID = relatiebeheer.kantoorID"
            . " LEFT OUTER JOIN demosessie ON relatiebeheer.relatieID = demosessie.relatieID"
            . " LEFT OUTER JOIN mkboek ON kantoor.kantoorID = mkboek.kantoorID";
            $condition .= " WHERE registratie.registratieID = " . $_POST["regID"] . ";";
            $result = $dbDomain->getResult($table, $condition, false, null, null);
            if($result != false)
            {
                if($result->num_rows > 0)
                {
                    $row = $result->fetch_assoc();
                    
                    if($row["pakketID"] != '1' && $row["pakketID"] != '11')
                        $jQueryVerversForm = "$('.assistentCRM').css('display', 'none')";
                    else
                        $jQueryVerversForm = "";                    
                    
                    $werktMetApp = false;
                    $geefKorting = false;
                    $isAutIncasso = false;
                    $factuurMail = false;
                    
                    if($row["werktMetApp"] == "1")
                        $werktMetApp = true;
                    if($row["heeftKorting"] == "1")
                        $geefKorting = true;
                    if($row["autoIncasso"] == "1")
                        $isAutIncasso = true;
                    if($row["factuurPerMail"] == "1")
                        $factuurMail = true;
                        
                    $jQueryVerversForm .= " $('#titelRelatieKaart').append('Muteren licentiegegevens: " . $row["registratieID"] . " - " . $row["kantoorNaam"] . "');";
                    $jQueryVerversForm .= " $('#txtKantoornaam').val('" . $row["kantoorNaam"] . "');";
                    $jQueryVerversForm .= " $('#txtKantoornaam_oud').val('" . $row["oudKantoorNaam"] . "');";
                    if($row["ipBan"] == "1")
                    {
                        $jQueryVerversForm .= " $('#tdBlokkade').append('<input type=\"checkbox\" name=\"chkBlokkade\" checked><font color=red>!!!!!!!!!!!!!!!!!!!!!!!</font>');";
                    }
                    else
                        $jQueryVerversForm .= " $('#tdBlokkade').append('<input type=\"checkbox\" name=\"chkBlokkade\">');";
                    
                    if($_SESSION["fullname"] == "Romy Tyszka")
                    {
                        if($row["bewaking"] == "1")
                            $jQueryVerversForm .= "$('#tdBewaking').append('<b>Bewaking?</b>&nbsp;&nbsp;<input type=\"checkbox\" name=\"bewaking\" checked><font color=red>!!!!!!!!!!!!!!!!!!!!!!!</font>');";
                        else
                            $jQueryVerversForm .= "$('#tdBewaking').append('<b>Bewaking?</b>&nbsp;&nbsp;<input type=\"checkbox\" name=\"bewaking\">');";
                    }
                    $jQueryVerversForm .= " $('#txtContactpersoon').val('" . $row["contactpersoonFormelenaam"] . "');";
                    $jQueryVerversForm .= " $('#txtCPvoornaam').val('" . $row["contactpersoonVoornaam"] . "');";
                    $jQueryVerversForm .= " $('#txtCPachternaam').val('" . $row["contactpersoonAchternaam"] . "');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                    if(isset($row["opmerkingen"]) && !empty($row["opmerkingen"]))
                    {
                        $jQueryVerversForm = " $('#txtArNotities').val('" . str_replace(array("\r\n", "\n\r", "\r", "\n"),"&#13;&#10;",$row["opmerkingen"]) . "');";
                        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                    }                    
                    $jQueryVerversForm = " $('#txtPostadres').val('" . $row["postAdres"] . "');";
                    $jQueryVerversForm .= " $('#txtPostPostcode').val('" . $row["postPostcode"] . "');";
                    $jQueryVerversForm .= " $('#txtPostWoonplaats').val('" . $row["postWoonplaats"] . "');";
                    $jQueryVerversForm .= " $('#txtBezoekadres').val('" . $row["bezoekAdres"] . "');";
                    $jQueryVerversForm .= " $('#txtBezoekPostcode').val('" . $row["bezoekPostcode"] . "');";
                    $jQueryVerversForm .= " $('#txtBezoekWoonplaats').val('" . $row["bezoekWoonplaats"] . "');";
                    $jQueryVerversForm .= " $('#txtVestigingsadres').val('" . $row["vestigingsAdres"] . "');";
                    $jQueryVerversForm .= " $('#txtVestigingsPostcode').val('" . $row["vestigingsPostcode"] . "');";
                    $jQueryVerversForm .= " $('#txtVestigingsWoonplaats').val('" . $row["vestigingsWoonplaats"] . "');";                    
                    
                    $jQueryVerversForm .= " $('#txtTelNr').val('" . $row["telNr1"] . "');";
                    $jQueryVerversForm .= " $('#txtTelNr2').val('" . $row["telNr2"] . "');";
                    $jQueryVerversForm .= " $('#txtIBAN').val('" . $row["IBAN"] . "');";
                    
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

                    fillComboBoxBIC($row["BIC"], $dbDomain);
                    
                    $jQueryVerversForm = " $('#txtEmailadres').val('" . $row["emailAdres"] . "');";
                    $jQueryVerversForm .= " $('#txtWebsite').val('" . $row["websiteURL"] . "');";
                    $jQueryVerversForm .= " $('#txtMandaatnr').val('" . $row["mandaatNr"] . "');";
                    $jQueryVerversForm .= " $('#txtLinkedIn').val('" . $row["urlLinkedIn"] . "');";
                    $jQueryVerversForm .= " $('#txtKvKNr').val('" . $row["kvkNr"] . "');";
                    $jQueryVerversForm .= " $('#txtWachtwoord').val('" . $row["loginWachtwoord"] . "');";
                    
                    ($werktMetApp ? $jQueryVerversForm .= "$('#rgWerktMetApp').val('ja');" : $jQueryVerversForm .= "$('#rgWerktMetApp').val('nee');");              
                    
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

                    fillComboBoxPakket($row["pakketID"],$dbDomain);
                    
                    $jQueryVerversForm = " $('#txtAantalGebr').val('" . $row["aantalGebruikers"] . "');";
                    $jQueryVerversForm .= " $('#dpIngangsdatum').val('" . date_format(date_create($row["ingangsDatum"]), "Y-m-d") . "');";
                    $jQueryVerversForm .= " $('#dpEinddatum').val('" . date_format(date_create($row["supportTot"]), "Y-m-d") . "');";
                    
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

                    fillCbxStatus($row["status"], $dbDomain);
                    
                    $jQueryVerversForm = "";
                    
                    if($row["heeftBoekhouding"] == "1")
                        $jQueryVerversForm .= "$('#chkBoekhouding').prop('checked', true);";
                    if($row["heeftBoekingen"] == "1")
                        $jQueryVerversForm .= "$('#chkBoekingen').prop('checked', true);";
                    if($row["heeftHypotheken"] == "1")
                        $jQueryVerversForm .= "$('#chkHypotheken').prop('checked', true);";
                    if($row["heeftADN"] == "1")
                        $jQueryVerversForm .= "$('#chkADN').prop('checked', true);";
                    if($row["heeftMaandBetalers"] == "1")
                        $jQueryVerversForm .= "$('#chkMaandbetalers').prop('checked', true);";
                    if($row["heeftDeclaratie"] == "1")
                        $jQueryVerversForm .= "$('#chkDeclaratie').prop('checked', true);";
                    if($row["heeftRolls"] == "1")
                        $jQueryVerversForm .= "$('#chkRolls').prop('checked', true);";
                    if($row["heeftPakketten"] == "1")
                        $jQueryVerversForm .= "$('#chkPakketten').prop('checked', true);";
                    if($row["heeftSubagenten"] == "1")
                        $jQueryVerversForm .= "$('#chkSubagenten').prop('checked', true);";
                    if($row["heeftVolmacht"] == "1")
                        $jQueryVerversForm .= "$('#chkVolmacht').prop('checked', true);";
                    if($row["heeftWebexport"] == "1")
                        $jQueryVerversForm .= "$('#chkWebexport').prop('checked', true);";
                    if($row["heeftClientServer"] == "1")
                        $jQueryVerversForm .= "$('#chkClientServer').prop('checked', true);";
                    
                    $jQueryVerversForm .= " $('#txtLicPeriode').val('" . $row["licentiePeriode"] . "');";
                    if(!empty($row["ekFactuurDatum"]))
                        $jQueryVerversForm .= " $('#dpFactuurdatum').val('" . date_format(date_create($row["ekFactuurDatum"]), "Y-m-d") . "');";
                    
                    if (empty($row["licentieBedrag"]))
                        $licentieBedragIncBtw = 0;
                    else
                    {
                        $licentieBedrag = floatval($row["licentieBedrag"]);
                        $btwPercentage = floatval($row["btwPercentage"]);
                        $licentieBedragIncBtw = ($licentieBedrag * ($btwPercentage++)) / 100;
                    }

                    $licentieBedragIncBtw = (round($licentieBedragIncBtw * 100)) / 100;
                    
                    $jQueryVerversForm .= " $('#txtLicBedrag').val('" . $licentieBedragIncBtw . "');";
                    $jQueryVerversForm .= " $('#txtBTWPerc').val('" . str_replace(".",",",strval($row["btwPercentage"])) . "');";
                    if(!empty($row["datumLaatsteIndex"]))
                        $jQueryVerversForm .= " $('#dpLaatsteIndex').val('" . date_format(date_create($row["datumLaatsteIndex"]), "Y-m-d") . "');";
                    
                    ($geefKorting ? $jQueryVerversForm .= "$('#rgGeefKorting').val('ja');" : $jQueryVerversForm .= "$('#rgGeefKorting').val('nee');");                                     
                                        
                    $jQueryVerversForm .= " $('#txtKortingPerc').append('" . str_replace(".",",",strval($row["hoogteKorting"])) . "');";                    
                    
                    ($isAutIncasso ? $jQueryVerversForm .= "$('#rgIncasso').val('ja');" : $jQueryVerversForm .= "$('#rgIncasso').val('nee');");
                    
                    ($factuurMail ? $jQueryVerversForm .= "$('#rgFactuurMail').val('ja');" : $jQueryVerversForm .= "$('#rgFactuurMail').val('nee');");
                    
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                    
                    $jQueryVerversForm = "";
                    if(!empty($row["demoDatum"]))
                        $jQueryVerversForm .= " $('#dpDemo').val('" . date_format(date_create($row["demoDatum"]), "Y-m-d") . "');";                    
                    if(!empty($row["aantalPersonen"]))
                        $jQueryVerversForm .= "$('#txtDemoAantal').val('" . $row["aantalPersonen"] . "');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                    
                    fillCbxRedenKorting($row["redenKorting"], $dbDomain);
                    
                    fillCB_Bron($row["bronID"], $dbDomain);
                    
                    $jQueryVerversForm = " $('#txtBron2').val('" . $row["bronOmschrijving"] . "');";
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

                    fillCB_Behandelaar($row["conversieDoor"], $dbDomain);                    

                    fillCB_Conversie($row["conversiePakket"], $dbDomain);
                    
                    fillCB_VorigPakket($row["vorigPakket"], $dbDomain);
                    
                    fillCB_Producent($row["producent"], $dbDomain);
                    
                    if(!empty($row["datumMailing"]))
                        $jQueryVerversForm = " $('#dpMailing').val('" . date_format(date_create($row["datumMailing"]), "Y-m-d") . "');";                    
                    $jQueryVerversForm .= " $('#txtWelkomstgeschenk').val('" . $row["welkomstGeschenk"] . "');";
                    if(!empty($row["verstuurdOp"]))
                        $jQueryVerversForm .= " $('#dpVerstuurdOp').val('" . date_format(date_create($row["verstuurdOp"]), "Y-m-d") . "');";
                    
                    file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);
                }
                $result->free();
            }
            $dbDomain->closeConnection();
        }
        
        $jQueryVerversForm = "$('#vinkAlleModules').click(function () {";
        
        $jQueryVerversForm .= "$('#chkBoekingen').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkMaandbetalers').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkBoekhouding').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkSubagenten').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkWebexport').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkDeclaratie').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkHypotheken').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkRolls').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkVolmacht').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkClientServer').prop('checked', true);";
        $jQueryVerversForm .= "$('#chkADN').prop('checked', 'true');";
        
        $jQueryVerversForm .= "});"; 
        
        $jQueryVerversForm .= "$('#vinkGeenModules').click(function () {";
        
        $jQueryVerversForm .= "$('#chkBoekingen').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkMaandbetalers').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkBoekhouding').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkSubagenten').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkWebexport').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkDeclaratie').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkHypotheken').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkRolls').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkVolmacht').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkClientServer').prop('checked', false);";
        $jQueryVerversForm .= "$('#chkADN').prop('checked', false);";
            
        $jQueryVerversForm .= "})});";
        file_put_contents("../../Resource/JS/addUI.js", $jQueryVerversForm, FILE_APPEND);

    ?>
    <?php
//        if(error_get_last() !== null)
//        {
//            $aError = error_get_last();
//            $jQueryShowError = "$(document).ready(function () {";
//            $jQueryShowError .= "alert(\"Foutmelding:" . $aError["message"] . " in " . str_replace("\\", "->", $aError["file"]) . " op regel " . $aError["line"] . "\");";
//            $jQueryShowError .= "});";
//            file_put_contents("../../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
//        }
    ?>
    <script type="text/javascript" src="../../Resource/JS/addUI.js"></script>
    <script type="text/javascript" src="../../Resource/JS/Test/zoekKvK.js"></script>
    <script type="text/javascript" src="../../Resource/JS/showError.js"></script>    
    <script src="https://code.jquery.com/qunit/qunit-2.15.0.js"></script>
    <meta property="og:title" content="Relatieform">
    <meta property="og:type" content="website">
    <meta name="theme-color" content="#478ac9">
    <link rel="canonical" href="index.php">
    <meta property="og:url" content="index.php">
  </head>
  <body class="u-body">
    <header class="u-grey-40" id="sec-aa4e">
    </header>
    <div id="mainContainer">
        <div id="main">
            <section id="navMenu">
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
                <a href="Relatiekaart.php?id=<?php echo $_POST["regID"];?>" class="u-border-2 u-btn u-button-style u-none" style="border:0 none #fff !important">Terug naar relatiekaart</a>                
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
<!--            <section>
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
                <div id="qunit"></div>
                <div id="qunit-fixture"></div>
            </section>-->
            <form name="frmRelatieKaart" action="Relatieform.php" method="POST">
            <section class="u-section-1" id="sec-42ff">
              <h5 class="u-text u-text-1" id="titelRelatieKaart"></h5>
              <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
              <div class="u-table u-table-responsive u-table-1">
                  <table class="u-table-entity">
                    <colgroup>
                      <col width="13.8%">
                      <col width="13.1%">
                      <col width="17.10000000000001%">
                      <col width="17%">
                      <col width="18.2%">
                      <col width="20.90000000000001%">
                    </colgroup>
                    <tbody class="u-table-body">
                      <tr style="height: 30px;">
                        <td class="u-table-cell u-table-cell-1">Kantoornaam*:</td>
                        <td class="u-table-cell" id="tdKantoorNaam">
                            <input type="text" id="txtKantoornaam" name="txtKantoornaam" value="" required>
                            <select id="ddmKantoren" style="display:none"></select>
                        </td>
                        <td class="u-table-cell"><input type="button" id="btnZoekKvK" value="zoek KvK"></td>
                        <td class="u-table-cell u-table-cell-4" colspan="3"><font color=red>Let op: hier mogen geen spaties aan het einde voorkomen​*</font></td>                        
                        <td class="u-table-cell u-table-cell-5"></td>
                        <td class="u-table-cell"></td>
                      </tr>
                      <tr style="height: 30px;">
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-7">evt. oude kantoornaam:</td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtKantoornaam_oud" name="txtKantoornaam_oud" value=""></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">Blokkade</td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdBlokkade"></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-11" id="tdBewaking"></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      </tr>
                      <tr style="height: 30px;">
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Contactpersoon:</td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtContactpersoon" name="txtContactpersoon" value=""></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-15" colspan="4"><font color="red">Noteren als "t.a.v. de heer J. Jansen" of "t.a.v. mevrouw W. de Wit</font></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-17"></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      </tr>
                      <tr style="height: 30px;">
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-19">Voornaam:</td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtCPvoornaam" name="txtCPvoornaam" value=""></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell">Achternaam:</td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtCPachternaam" name="txtCPachternaam" value=""></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-23"></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      </tr>
                      <tr style="height: 30px;">
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-31">Vestigingsadres*:</td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtVestigingsadres" name="txtVestigingsadres" value="" required></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtVestigingsPostcode" name="txtVestigingsPostcode" value="" required></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtVestigingsWoonplaats" name="txtVestigingsWoonplaats" value="" required></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-35"></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      </tr>
                      <tr style="height: 30px;">
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-31">Postadres*:</td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtPostadres" name="txtPostadres" value="" required></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtPostPostcode" name="txtPostPostcode" value="" required></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtPostWoonplaats" name="txtPostWoonplaats" value="" required></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-35"></td>
                        <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      </tr>
                    </tbody>
                  </table> 
              </div>
            </section>
            <section class="u-section-2" id="sec-7bf0">
              <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
              <div class="u-table u-table-responsive u-table-1">
                <table class="u-table-entity">
                  <colgroup>
                    <col width="20.4%">
                    <col width="19.1%">
                    <col width="29.1%">
                    <col width="31.5%">
                  </colgroup>
                  <tbody class="u-table-body">
                    <tr style="height: 30px;">
                      <td class="u-table-cell u-table-cell-1">Telefoon*:</td>
                      <td class="u-table-cell"><input type="text" id="txtTelNr" name="txtTelNr" value="" required></td>
                      <td class="u-table-cell u-table-cell-3">IBAN:</td>
                      <td class="u-table-cell"><input type="text" id="txtIBAN" name="txtIBAN" value=""></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-5">Telefoon2:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtTelNr2" name="txtTelNr2" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-7">BIC:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><select id="ddmBIC" name="ddmBIC"><option value="" selected>GEEN</option></select></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">Emailadres:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtEmailadres" name="txtEmailadres" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-11">Mandaatnummer:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtMandaatnr" name="txtMandaatnr" value=""></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Website*:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtWebsite" name="txtWebsite" value="" required></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-15"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-17">KvK-nummer:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtKvKNr" name="txtKvKNr" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-19">LinkedIn:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtLinkedIn" name="txtLinkedIn" value=""></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-21">Login password*:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtWachtwoord" name="txtWachtwoord" value="" required></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-23">Werkt met de app:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdWerktMetApp">   
                          <input type="radio" id="rbJaApp" name="rgWerktMetApp" value="ja"><label for="rbJaApp">Ja</label>
                          <input type="radio" id="rbJaNee" name="rgWerktMetApp" value="nee" checked><label for="rbNeeApp">Nee</label>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </section>
            <section class="u-section-3" id="sec-eba9">
              <div class="u-border-3 u-border-custom-color-1 u-line u-line-horizontal u-line-1"></div>
              <div class="u-table u-table-responsive u-table-1">
                <table class="u-table-entity">
                  <colgroup>
                    <col width="19%">
                    <col width="21.5%">
                    <col width="28.1%">
                    <col width="31.5%">
                  </colgroup>
                  <tbody class="u-table-body">
                    <tr style="height: 30px;">
                      <td class="u-table-cell u-table-cell-1">Pakket*:</td>
                      <td class="u-table-cell"><select id="ddmPakket" name="ddmPakket" required><option value="" selected>--Kies een pakket--</option></select></td>
                      <td class="u-table-cell u-table-cell-3">Aantal gebruikers*:</td>
                      <td class="u-table-cell"><input type="text" id="txtAantalGebr" name="txtAantalGebr" value="1" required></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-5">Ingangsdatum*:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="date" id="dpIngangsdatum" name="dpIngangsdatum" value="" required></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-7">Einddatum*:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="date" id="dpEinddatum" name="dpEinddatum" value="" required></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-9">Status*:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-10">
                          <select id="ddmStatus" name="ddmStatus" required>
                              <option value="" selected>--Kies een status--</option>
                          </select>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-11"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-grey-25 u-table-cell u-table-cell-12"></td>
                    </tr>
                    <tr style="height: 30px;" class="assistentCRM">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Modules:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdChkModules1">
                          <input type="checkbox" name="chkBoekingen" id="chkBoekingen"><label for="chkBoekingen">Boekingen</label>
                          <input type="checkbox" name="chkMaandbetalers" id="chkMaandbetalers"><label for="chkMaandbetalers">Maandbetalers</label>

                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdChkModules2">
                          <input type="checkbox" name="chkBoekhouding" id="chkBoekhouding"><label for="chkBoekhouding">Boekhouding</label>
                          <input type="checkbox" name="chkSubagenten" id="chkSubagenten"><label for="chkSubagenten">Subagenten</label>

                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdChkModules3">
                          <input type="checkbox" name="chkWebexport" id="chkWebexport"><label for="chkWebexport">Webexport</label>
                          <input type="checkbox" name="chkHypotheken" id="chkHypotheken"><label for="chkHypotheken">Hypotheken</label>
                      </td>
                    </tr>
                    <tr style="height: 30px;" class="assistentCRM"
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-17"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdChkModules4">
                          <input type="checkbox" name="chkDeclaratie" id="chkDeclaratie"><label for="chkDeclaratie">Declaratie</label>
                          <input type="checkbox" name="chkRolls" id="chkRolls"><label for="chkRolls">Rolls</label>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdChkModules5">
                          <input type="checkbox" name="chkVolmacht" id="chkVolmacht"><label for="chkVolmacht">Volmacht</label>
                          <input type="checkbox" name="chkClientServer" id="chkClientServer"><label for="chkClientServer">ClientServer</label>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdChkModules6">
                          <input type="checkbox" name="chkADN" id="chkADN"><label for="chkADN">ADN</label>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <p id="vinkAlleModules" data-page-id="2439312792" class="assistentCRM u-active-none u-btn u-button-style u-hover-none u-none u-text-custom-color-1 u-btn-1">Alles aan</p> |
              <p id="vinkGeenModules" data-page-id="2439312792" class="assistentCRM u-active-none u-btn u-button-style u-hover-none u-none u-text-custom-color-1 u-btn-2">Alles uit</p>
            </section>
            <section class="u-section-4 assistentCRM" id="sec-d72c">
              <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
              <div class="u-table u-table-responsive u-table-1">
                <table class="u-table-entity">
                  <colgroup>
                    <col width="12.6%">
                    <col width="14.3%">
                    <col width="16.5%">
                    <col width="18.7%">
                    <col width="13.7%">
                    <col width="24.3%">
                  </colgroup>
                  <tbody class="u-table-body">
                    <tr style="height: 30px;">
                      <td class="u-table-cell u-table-cell-1">Licentieperiode in mnd:</td>
                      <td class="u-table-cell"><input type="text"  id="txtLicPeriode" name="txtLicPeriode" value=""></td>
                      <td class="u-table-cell u-table-cell-3"></td>
                      <td class="u-table-cell u-table-cell-4">e.k. factuurdatum:</td>
                      <td class="u-table-cell"><input type="date" id="dpFactuurdatum" name="dpFactuurdatum" value=""></td>
                      <td class="u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-7">Licentiebedrag excl. btw:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtLicBedrag" name="txtLicBedrag" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-10">laatste index*:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="date" id="dpLaatsteIndex" name="dpLaatsteIndex" value="" required></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">BTW %:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtBTWPerc" name="txtBTWPerc" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-15"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-16"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-19">Korting?</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdGeefKorting">
                        <input type="radio" id="rbWelKorting" name="rgGeefKorting" value="ja"><label for="rbWelKorting">Ja</label>
                        <input type="radio" id="rbGeenKorting" name="rgGeefKorting" value="nee" checked><label for="rbGeenKorting">Nee</label>                  
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-21"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-22">Reden korting:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell">
                          <select id="ddmRedenKorting" name="ddmRedenKorting">
                              <option value="" selected>Maak een keuze!</option>
                          </select></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><font>Let op!! Per datum alleen CFD óf commerciele korting! Niet beide!</font></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-25"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-28">Korting %</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtKortingPerc" name="txtKortingPerc" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell">
                          <button type="button" id="btnUitlegKorting" name="btnUitlegKorting" onclick="alert('Vul hier het oorspronkelijke percentage korting in.\n\nDat is handig als je later een offerte moet maken voor\neen uitbreiding. Dan hoef je niet terug te zoeken met\nhoeveel korting je rekening moet houden.');"> ? </button>
                      </td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-31">Aut. incasso:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdIncasso">
                        <input type="radio" id="rbWelIncasso" name="rgIncasso" value="ja"><label for="rbWelIncasso">Ja</label>
                        <input type="radio" id="rbGeenIncasso" name="rgIncasso" value="nee" checked><label for="rbGeenIncasso">Nee</label>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-34">Factuur per mail:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdFactuurMail">
                        <input type="radio" id="rbWelFactMail" name="rgFactuurMail" value="ja"><label for="rbWelFactMail">Ja</label>
                        <input type="radio" id="rbGeenFactMail" name="rgFactuurMail" value="nee" checked><label for="rbGeenFactMail">Nee</label>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </section>
            <section class="u-section-5 assistentCRM" id="sec-4d4d">
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
                      <td class="u-table-cell"><input type="date" id="dpDemo" name="dpDemo" value=""></td>
                      <td class="u-table-cell">Aantal personen bij demo</td>
                      <td class="u-table-cell"><input type="text" id="txtDemoAantal" name="txtDemoAantal" value=""></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-5">Bron:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell">
                          <select id="ddmBron" name="ddmBron">
                              <option value="" selected>Maak een keuze!</option>
                          </select>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtBron2" name="txtBron2" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-9">Conversie door:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell">
                          <select id="ddmBehandelaar" name="ddmBehandelaar">
                              <option value="" selected>n.v.t.</option>
                          </select>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-13">Conversie gedaan vanuit:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell">
                          <select id="ddmConversie" name="ddmConversie">
                              <option value="" selected>GEEN</option>
                          </select>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-17">Vorig pakket:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell">
                          <select id="ddmVorigPakket" name="ddmVorigPakket">
                              <option value="" selected>GEEN</option>
                          </select>
                      </td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-21" id="lblProducent"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell" id="tdProducent"></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-23">Datum mailing:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="date" id="dpMailing" name="dpMailing" value=""></td>
                    </tr>
                    <tr style="height: 30px;">
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-25">Welkomstgeschenk:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="text" id="txtWelkomstgeschenk" name="txtWelkomstgeschenk" value=""></td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell u-table-cell-27">VerstuurdOp:</td>
                      <td class="u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell"><input type="date" id="dpVerstuurdOp" name="dpVerstuurdOp" value=""></td>
                    </tr>
                  </tbody>
                </table>                
              </div>               
            </section>
            <section class="u-section-9" id="sec-f653">
                <div class="u-border-3 u-border-custom-color-1 u-expanded-width u-line u-line-horizontal u-line-1"></div>
                <p class="u-align-center u-text u-text-1">Notities:</p>     
                <textarea placeholder="" rows="4" cols="50" id="txtArNotities" name="txtArNotities" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></textarea>
                <input id="btnSubmit" name="btnSubmit" type="submit" class="u-border-2 u-btn u-button-style u-none u-btn-1" value="VASTLEGGEN">
            </section>
                <input type="hidden" name="typeForm" value="<?php echo $_POST["typeForm"];?>">
                <input type="hidden" name="regID" value="<?php echo $_POST["regID"];?>">
            </form>
        </div>
    </div>
  </body>
</html>