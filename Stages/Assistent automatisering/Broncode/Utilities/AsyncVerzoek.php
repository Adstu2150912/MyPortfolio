<?php
/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 18-03-2021
 * Project: Afstudeeropdracht - ModernIQ
 * Bestandsnaam: AsyncVerzoek.php
 * Omschrijving: Een Utiliteits klasse voor het opvangen van asynchronische HTTP-verzoeken uit de front-end 
 * en achteraf terugsturen van HTTP-responses.
 * Hiermee kunnen webpagina's SQL-opdrachten uitvoeren en het resultaat hiervan ontvangen en weergeven 
 * zonder opnieuw te verversen of deze resultaat te tonen op een andere webpagina.
 */

//Toon hier geen geautomatiseerde PHP-foutmelding zodat de JSON-strings (HTTP-responses) niet hiermee gevuld worden
error_reporting(0);

include "BackendHelpdesk.php";

//Als er niet is ingelogd of de PHP-sessie is verlopen, dan moet de gebruiker worden teruggewezen naar het inlogpagina
if($_SESSION["ingelogd"] == "nee")
    header("Location: Inlogpagina-helpdesk.php");

switch($_POST["soortOpdracht"])
{
    case "zoekRegistraties":           
        $searchValid = false;          
        $aValues = array();
        $strDataTypes = "";
        $params2 = "registratie.registratieID, licentie.pakketID, kantoor.kantoorNaam, kantoor.contactpersoonFormelenaam, kantoor.oudKantoorNaam,kantoor.contactpersoonVoornaam,kantoor.contactpersoonAchternaam,kantoor.contactpersoonVoorletters";
        $table2 = "kantoor";
        $condition2 = " INNER JOIN registratie ON kantoor.registratieID = registratie.registratieID"
        .  " INNER JOIN licentie ON registratie.registratieID = licentie.registratieID "
        . " WHERE ";
        $dbDomain->openConnection();            
//            $fp = fopen("../Resource/JS/showError.js", "w");
//            fclose($fp);            
        if(!empty($_POST["txtFactuurnummer"]))
        {
//            if(preg_match("/^\d*$/", $_POST["txtFactuurnummer"]) === 1)
//            {
                $condition2 .= " registratie.registratieID IN (SELECT relatienummer FROM facturen WHERE factuurnummer LIKE ?);";
                $strDataTypes .= "s";
                $aValues[] = "%" . $_POST["factuurNummer"] . "%";
                $searchValid = true;                
//            }
//            else
//            {
////                    $jQueryShowError = "$(document).ready(function () {";
////                    $jQueryShowError .= "alert(\"Ongeldige factuurnummer '" . $_POST["factuurNummer"] . "'! Factuurnummer mag alleen cijfers bevatten\");";
////                    $jQueryShowError .= "});";
////                    file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
//                $searchValid = false;
//            }
        }
        else
        {
//        if(!empty($_POST["registratieWaarde"]))
//        {            
//            if(preg_match("/^\w+$/", $_POST["registratieWaarde"]) === 1)
//            {
                $searchValid = true;
                $strDataTypes .= "ssssss";

                $condition2 .= " registratie.registratieID > 0 AND kantoor.kantoorNaam LIKE ? "
                . " OR registratie.registratieID > 0 AND kantoor.oudKantoorNaam LIKE ? "
                . " OR registratie.registratieID > 0 AND kantoor.contactpersoonFormelenaam LIKE ? "
                . " OR registratie.registratieID > 0 AND kantoor.contactpersoonVoornaam LIKE ? "
                . " OR registratie.registratieID > 0 AND kantoor.contactpersoonAchternaam LIKE ? "
                . " OR registratie.registratieID > 0 AND kantoor.contactpersoonVoorletters LIKE ? ";

                $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
                $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
                $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
                $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
                $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
                $aValues[] = "%" . $_POST["registratieWaarde"] . "%";

//                if(is_numeric($_POST["registratieWaarde"]))
//                {
//                    $strDataTypes .= "iii";
//                    $condition2 .= " OR registratie.registratieID > 0 AND licentie.status = ? "
//                    . " OR registratie.registratieID > 0 AND licentie.pakketID = ? "
//                    . " OR registratie.registratieID > 0 AND registratie.registratieID = ?  ";
//                    $aValues[] = intval($_POST["registratieWaarde"]);
//                    $aValues[] = intval($_POST["registratieWaarde"]);
//                    $aValues[] = intval($_POST["registratieWaarde"]);
//                }
//                    $result = $dbDomain->getAllFields("registratie");        
//                    if($result != false)
//                    {
//                        while($row = $result->fetch_array())
//                        {
//                            if(count($aValues) === 0)
//                                $condition2 .= " registratie." . $row[0] . " LIKE ? ";
//                            else
//                                $condition2 .= " OR registratie." . $row[0] . " LIKE ? ";
//                            $strDataTypes .= "s";
//                            $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
//                        }
//                        $result->free();
//                    }                       
//                    
//                    $result2 = $dbDomain->getAllFields("kantoor");        
//                    
//                    if($result2 != false)
//                    {
//                        while($row2 = $result2->fetch_array())
//                        {
//                            $condition2 .= " OR kantoor." . $row2[0] . " LIKE ? ";
//                            $strDataTypes .= "s";
//                            $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
//                        }                    
//
//                        $result2->free();
//                    }
//
//                    $result3 = $dbDomain->getAllFields("licentie");
//                    if($result3 != false)
//                    {
//                        while($row3 = $result3->fetch_array())
//                        {
//                            $condition2 .= " OR licentie." . $row3[0] . " LIKE ? ";
//                            $strDataTypes .= "s";
//                            $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
//                        }
//                        $result3->free();
//                    }
//                    
//                    $result4 = $dbDomain->getAllFields("licentiemodules");        
//                    if($result4 != false)
//                    {
//                        while($row4 = $result4->fetch_array())
//                        {                        
//                            $condition2 .= " OR licentiemodules." . $row4[0] . " LIKE ? ";
//                            $strDataTypes .= "s";
//                            $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
//                        }
//                        $result4->free();
//                    }                    
//   
//                    $result5 = $dbDomain->getAllFields("relatiebeheer");        
//                    
//                    if($result5 != false)
//                    {
//                        while($row5 = $result5->fetch_array())
//                        {
//                            $condition2 .= " OR relatiebeheer." . $row5[0] . " LIKE ? ";
//                            $strDataTypes .= "s";
//                            $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
//                        }
//                        $result5->free();
//                    }                    
//
//                    $result6 = $dbDomain->getAllFields("demosessie");
//                    if($result6 != false)
//                    {
//                        while($row6 = $result6->fetch_array())
//                        {
//                            $condition2 .= " OR demosessie." . $row6[0] . " LIKE ? ";
//                            $strDataTypes .= "s";
//                            $aValues[] = "%" . $_POST["registratieWaarde"] . "%";
//                        }
//                        $result6->free();
//                    }                    
//                        
//                    $condition2 .= ";";
//        }
//            else
//            {
//                    $jQueryShowError = "$(document).ready(function () {";
//                    $jQueryShowError .= "alert(\"Ongeldige zoekcriteria van '" . $_POST["registratieWaarde"] . "'! Zoekcriteria mag alleen alfabetische karakters, cijfers en/of underscores bevatten\");";
//                    $jQueryShowError .= "});";
//                    file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
//                $searchValid = false;
//            }
        }
        if($searchValid)
        {
            $result2 = $dbDomain->getSelectiveResult($params2, $table2, $condition2, true, $strDataTypes, $aValues);
            if($result2 != false)
            {
                if($result2->num_rows > 0)
                {
                    $tblRegistratie = array();
                    $i = 0;
                    while($row2 = $result2->fetch_assoc())
                    {
                        $tblRegistratie[$i] = array("registratieID" => $row2["registratieID"], "pakketID" => $row2["pakketID"], "kantoorNaam" => $row2["kantoorNaam"], "oudKantoorNaam" => $row2["oudKantoorNaam"], "contactpersoonFormelenaam" => $row2["contactpersoonFormelenaam"], "contactpersoonVoornaam" => $row2["contactpersoonVoornaam"], "contactpersoonAchternaam" => $row2["contactpersoonAchternaam"], "contactpersoonVoorletters" => $row2["contactpersoonVoorletters"]);
                        $i++;
                    }

                    $aResponse = json_encode($tblRegistratie, JSON_FORCE_OBJECT);
                }
                else
                {
//                        $jQueryShowError = "$(document).ready(function () {";
//                        $jQueryShowError .= "alert(\"Geen zoekresultaten voor '" . $_POST["registratieWaarde"] ."' gevonden in de database!\");";
//                        $jQueryShowError .= "});";                    
//                        file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                    $aResponse = json_encode(array("failure" => true, "errorMsg" => "Geen zoekresultaten gevonden!"), JSON_FORCE_OBJECT);
                }

                $result2->free();
                echo $aResponse;                    
            }
            else
            {
//                    $jQueryShowError = "$(document).ready(function () {";
//                    $jQueryShowError .= "alert(\"Geen zoekresultaten voor '" . $_POST["registratieWaarde"] ."' gevonden in de database!\");";
//                    $jQueryShowError .= "});";                    
//                    file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                $aResponse = json_encode(array("failure" => true, "errorMsg" => "Geen zoekresultaten gevonden!"), JSON_FORCE_OBJECT);
                echo $aResponse;
            }                    
        }
        else
        {              
            $aResponse = json_encode(array("failure" => true, "errorMsg" => "Geen zoekresultaten gevonden!"), JSON_FORCE_OBJECT);
            echo $aResponse;
        }
        $dbDomain->closeConnection();        
        break;
    case "zoekopdrachtHelpdesk":
        if(isset($_POST["categorie"]) && !empty($_POST["categorie"]) || isset($_POST["zoekwaarde"]) && !empty($_POST["zoekwaarde"]))
        {
            $dbDomain->openConnection();
            $table = "helpdesk";
            $condition = " WHERE ";
            $strDataTypes = "";
            $aValues = array();
            if(isset($_POST["categorie"]) && !empty($_POST["categorie"]))
            {
                $condition .= " categorie = ? ";
                $strDataTypes .= "s";
                $aValues[] = $_POST["categorie"];
            }
            if(isset($_POST["zoekwaarde"]) && !empty($_POST["zoekwaarde"]))
            {
                if(isset($_POST["categorie"]) && !empty($_POST["categorie"]))
                    $condition .= " AND ";
                $condition .= " vraag LIKE ? OR ";                
                $aValues[] = "%" . $_POST["zoekwaarde"] . "%";
                if(isset($_POST["categorie"]) && !empty($_POST["categorie"]))
                {                    
                    $condition .= " categorie = ? AND ";
                    $strDataTypes .= "s";
                    $aValues[] = $_POST["categorie"];
                }
                $condition .= " antwoord LIKE ? ";
                $strDataTypes .= "ss";
                $aValues[] = "%" . $_POST["zoekwaarde"] . "%";
            }
            
            $condition .= " ORDER BY datumtijd DESC;";
            $result = $dbDomain->getResult($table, $condition, true, $strDataTypes, $aValues);
            if($result != false)
            {
                if($result->num_rows > 0)
                {
                    $tblHelpdesk = array();
                    $i = 0;
                    while($row = $result->fetch_assoc())
                    {
                        $row["vraag"] = str_replace(array("\r\n", "\n\r", "\r", "\n"),"<br><br>", $row["vraag"]);
                        $tblHelpdesk[$i] = array($row["RegistratieID"], $row["id"], $row["datumtijd"], $row["vraag"], $row["categorie"]);
                        $i++;
                    }                    
                    $aResponse = json_encode($tblHelpdesk, JSON_FORCE_OBJECT);                    
                }
                else
                {
//                    $jQueryShowError = "$(document).ready(function () {";
//                    $jQueryShowError .= "alert(\"Geen zoekresultaten voor '" . $_POST["zoekwaarde"] ."' gevonden in de database!\");";
//                    $jQueryShowError .= "});";
//                    file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                    $aResponse = json_encode(array("failure" => true, "errorMsg" => "Geen zoekresultaten gevonden!"), JSON_FORCE_OBJECT);
                }
                echo $aResponse;
                $result->free();
            }
            else
            {                
//                $jQueryShowError = "$(document).ready(function () {";
//                $jQueryShowError .= "alert(\"Geen zoekresultaten voor '" . $_POST["zoekwaarde"] ."' gevonden in de database!\");";
//                $jQueryShowError .= "});";
//                file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                $aResponse = json_encode(array("failure" => true, "errorMsg" => "Geen zoekresultaten gevonden!"), JSON_FORCE_OBJECT);
                echo $aResponse;
            }
        }
        break;
    case "verwijderProspect":
        $_POST["regID"] = filter_input(INPUT_POST, "regID", FILTER_VALIDATE_INT);
        if(isset($_POST["regID"]) && !empty($_POST["regID"] && $_POST["regID"] != false))
        {
            $dmlStatement = "DELETE FROM registratie WHERE registratieID = " . $_POST["regID"];
            $dbDomain->openConnection();
            $dbDomain->executeDML($dmlStatement, "delete");
            $dbDomain->closeConnection();
        }
        break;
    case "testIQSelectie":
        if(isset($_POST["sqlQuery"]) && !empty($_POST["sqlQuery"]))
        {
            $strRawString = $_POST["sqlQuery"];
            $strRawString = strtolower($strRawString);
            if(!str_contains($strRawString, "insert") || !str_contains($strRawString, "update") || !str_contains($strRawString, "delete"))
                $sqlQuery = $_POST["sqlQuery"];
            else
                $sqlQuery = "";
//            $sqlQuery = str_replace("(##/q/)", "\"", $sqlQuery);
//            $sqlQuery = str_replace("(#/q/)", "'", $sqlQuery);
            $dbDomain->openConnection();
            $result = $dbDomain->executeStatement($sqlQuery, null, null, "query");
            if($result != false)
            {
                if($result->num_rows > 0)
                {
                    
                    $response = array();
                    $aTableHeaders = array();
                    $aTableRows = array();
                    
                    //Haal alle veldnamen op van de resultset waarmee in het resultaatoverzicht op de webpagina gevuld wordt met juiste tabelheaders
                    for($i = 0; $i < $result->field_count; $i++)
                    {
                        $result->field_seek($i);
                        $currentField = $result->fetch_field();
                        $aTableHeaders[] = $currentField->name;
                    }
                    
                    while($row = $result->fetch_array())
                    {
                        $currentRow = array();
                        for($ii = 0; $ii < $result->field_count; $ii++)
                        {
                            $currentRow[] = $row[$ii];
                        }
                        $aTableRows[] = $currentRow;
                    }
                    $response[0] = $aTableHeaders;
                    $response[1] = $aTableRows;
                    $response = json_encode($response, JSON_FORCE_OBJECT);                    
                }
                else
                {
                    $response = json_encode(array("failure" => true, "errorMsg" => "Geen records gevonden!"), JSON_FORCE_OBJECT);
                }
                $result->free();
                echo $response;
            }
            else
            {
                $response = json_encode(array("failure" => true, "errorMsg" => "Ingevoerde SQL query is ongeldig!"), JSON_FORCE_OBJECT);
                echo $response;
            }            
            $dbDomain->closeConnection();
        }
        break;
    case "zoekSQLVelden":
        if(isset($_POST["tabelNaam"]) && !empty($_POST["tabelNaam"]))
        {
            $dbDomain->openConnection();
            $result = $dbDomain->getAllFields($_POST["tabelNaam"]);
            if($result != false)
            {
                if($result->num_rows > 0)
                {
                    $response = array();
                    
                    while($row = $result->fetch_array())
                    {
                        $response[] = $row[0];
                    }
                    
                    $response = json_encode($response, JSON_FORCE_OBJECT);
                    echo $response;
                }
                else
                {
                    $response = json_encode(array("failure" => true, "errorMsg" => "Geen records gevonden in tabel '" . $_POST["tabelNaam"] . "'!"), JSON_FORCE_OBJECT);
                    echo $response;
                }  
                $result->free();
            }            
            $dbDomain->closeConnection();
        }
        break;
    case "zoekKvK":        
        //$headers = array("Content-Type" => "application/x-www-form-urlencoded");
//        $ch = curl_init();
//        curl_setopt($ch, CURLOPT_URL, $_POST["url"]);
//        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'GET');
//        //curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
//        curl_setopt($ch, CURLOPT_POST, TRUE);        
//        curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
//        $responseKvK = curl_exec($ch);
//        curl_close($ch);
        //$strJSON = json_encode($responseKvK, JSON_FORCE_OBJECT);
//        $pemFile = tmpfile();
//        fwrite($pemFile, "../Resource/cacert.pem");//de locatiepad voor KvK certificaat
//        $tempPemPath = stream_get_meta_data("../Resource/cacert.pem");
//        $tempPemPath = $tempPemPath['uri'];
        //curl_setopt($ch, CURLOPT_SSLCERT, $tempPemPath); 
        $aOptions = [//CURLOPT_CAINFO => realpath("../Resource/cacert.pem"),
                    //CURLOPT_CAPATH => realpath("../Resource/cacert.pem"),
                    CURLOPT_SSL_VERIFYPEER => FALSE];
        //CURLOPT_CAINFO 
        $responseKvK = curl_get(str_replace(" ","%20", $_POST["url"]) . "&user_key=", NULL, $aOptions);
//        fclose($pemFile);
        echo $responseKvK;
        break;
    case "get3CXContact":
        $_POST["regID"] = filter_input(INPUT_POST, "regID", FILTER_VALIDATE_INT);
        if(isset($_POST["regID"]) && !empty($_POST["regID"]) && $_POST["regID"] != false)
        {
            $dbDomain->openConnection();
            $table = "kantoor";
            $condition = " INNER JOIN registratie ON kantoor.registratieID = registratie.registratieID"
            . " LEFT OUTER JOIN licentie ON registratie.registratieID = licentie.registratieID"
            . " LEFT OUTER JOIN licentiemodules ON licentie.licentieID = licentiemodules.licentieID"
            . " LEFT OUTER JOIN relatiebeheer ON kantoor.kantoorID = relatiebeheer.kantoorID"
            . " LEFT OUTER JOIN demosessie ON relatiebeheer.relatieID = demosessie.relatieID";
            $condition .= " WHERE registratie.registratieID = " . $_POST["regID"];
            $result = $dbDomain->getResult($table, $condition, false, null, null);
            if($result != false)
            {
                if($result->num_rows > 0)
                {
                    $row = $result->fetch_assoc();

                    $row["gebruikersNaam"] = $_SESSION["fullname"];
                    $row["isAdmin"] = $_SESSION["ingelogdAdmin"];
                    $tblFactuur = "facturen";
                    $conditionTblFact = " WHERE afgewerkt = 0 AND registratie_id = " . $_POST["regID"] . ";";

                    $rsFactuur = $dbDomain->getResult($tblFactuur, $conditionTblFact, false, null, null);
                    if($rsFactuur != false)
                    {
                        if($rsFactuur->num_rows > 0)
                            $row["heeftOpenSaldo"] = true;
                        else
                            $row["heeftOpenSaldo"] = false;
                        $rsFactuur->free();
                    }
                    
                    $row["opmerkingen"] = str_replace(array("\r\n", "\n\r", "\r", "\n"),"&#13;&#10;", $row["opmerkingen"]);
                    $row["hoogteKorting"] = str_replace(".",",",strval($row["hoogteKorting"]));
                    $row["btwPercentage"] = str_replace(".",",",strval($row["btwPercentage"]));
                            
                    $table2 = "pakketten";
                    $condition2 = " WHERE id = " . $row["pakketID"];
                    $result2 = $dbDomain->getResult($table2, $condition2, false, null, null);

                    if($result2 != false)
                    {
                        if($result2->num_rows > 0)
                        {
                            $row2 = $result2->fetch_assoc();
                            $row["pakketOmschrijving"] = $row2["Omschrijving"];                                   
                        }
                        $result2->free();
                    }

                    $params3 = "omschrijving";
                    $table3 = "statuscode";
                    $condition3 = " WHERE statuscode = " . $row["status"];
                    $result3 = $dbDomain->getSelectiveResult($params3, $table3, $condition3, false, null, null);

                    if($result3 != false)
                    {
                        if($result3->num_rows > 0)
                        {
                            $row3 = $result3->fetch_assoc();
                            $row["statusOmschrijving"] = $row3["omschrijving"];
                        }
                        $result3->free();
                    }

                    if ($row["pakketID"] == 1 || $row["pakketID"] == 11)
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

                            $row["huidigeVersie"] = $row4["versie"];
                            $row["laatstIngelogd"] = $row4["laatstIngelogd"];
                            $result4->free();
                        }                        
                    }

                    $params5 = "COUNT(registratie_id) AS aantal";
                    $tabel5 = "facturen";
                    $condition5 = " WHERE bijzonderheden LIKE '%storno%' AND DATEDIFF(DATE(NOW()), factuurdatum) < 180 AND registratie_id = " . $_POST["regID"];
                    $result5 = $dbDomain->getSelectiveResult($params5, $tabel5, $condition5, false, null, null);
                    if($result5 != false)
                    {
                        if($result5->num_rows > 0)
                        {   
                            $row5 = $result5->fetch_assoc();
                            $row["stornos"] = $row5["aantal"];
                        }
                        $result5->free();
                    }

                    if ($row["bronID"] != "" && !isset($row["bronID"]))
                    {
                        $params6 = "omschrijving";
                        $tabel6 = "bronnen";
                        $condition6 = " WHERE " . "id=" . $row["bronID"];
                        $result6 = $dbDomain->getSelectiveResult($params6, $tabel6, $condition6, false, null, null);
                        if ($result6 != false)
                        {    
                            if($result6->num_rows > 0)
                            {
                                $row6 = $result6->fetch_assoc();
                                $row["bron1"] = $row6["omschrijving"];                      
                            }            
                        }
                        $result6->free();
                    }

                    $table7 = "agenda";
                    $condition7 = " WHERE af = 0 AND registratieId = " . $row["registratieID"] . " ORDER BY agendadatum;";
                    $result7 = $dbDomain->getResult($table7, $condition7, false, null, null);

                    if ($result7 != false)
                    {
                        if($result7->num_rows > 0)
                        {
                            $aAgenda = array();
                            while($row7 = $result7->fetch_assoc())
                            {
                                if(isset($row7["tekst"]))
                                    $row7["tekst"] = str_replace(array("\r\n", "\n\r", "\r", "\n"),"<br><br>", $row7["tekst"]);
                                $aAgenda[] = array("agendaID" => $row7["id"], "van" => $row7["van"], "voor" => $row7["voor"], "agendadatum" => $row7["agendadatum"], "tekst" => $row7["tekst"]);
                            }
                            $row["agenda"] = $aAgenda;
                        }
                        $result7->free();
                    }

                    $table8 = "helpdesk";
                    $condition8 = " WHERE RegistratieID = " . $row["registratieID"] . " ORDER BY datumtijd DESC, sticky DESC;";
                    $result8 = $dbDomain->getResult($table8, $condition8, false, null, null);

                    if($result8 != false)
                    {
                        if($result8->num_rows > 0)
                        {
                            $row["aantalTickets"] = $result8->num_rows;
                            $aHelpdesk = array();
                            while($row8 = $result8->fetch_assoc())
                            {
                                if(isset($row8["vraag"]))
                                    $row8["vraag"] = str_replace(array("\r\n", "\n\r", "\r", "\n"),"<br><br>", $row8["vraag"]);
                                $aHelpdesk[] = ["ticketID" => $row8["id"],"datumtijd" => $row8["datumtijd"],"vraag" => $row8["vraag"],"categorie" => $row8["categorie"], "persoon" => $row8["persoon"], "Behandelaar" => $row8["Behandelaar"]];
                            }
                            $row["helpdesk"] = $aHelpdesk;
                        }
                        $result8->free();
                    }
                    $aResponse = json_encode($row, JSON_FORCE_OBJECT);
                    echo $aResponse;                                                           
                }
                else
                {
//                    $jQueryShowError = "$(document).ready(function () {";
//                    $jQueryShowError .= "alert(\"Ongeldige relatiekaart! Deze bestaat niet in de database.\");";
//                    $jQueryShowError .= "});";
//                    file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
                    $aResponse = json_encode(array("failure" => true, "errorMsg" => "Ongeldige relatiekaart! Deze bestaat niet in de database."), JSON_FORCE_OBJECT);
                    echo $aResponse;                    
                }
                $result->free();
                $dbDomain->closeConnection();
            }
            else
            {
                $aResponse = json_encode(array("failure" => true, "errorMsg" => "Ongeldige relatiekaart! Deze bestaat niet in de database."), JSON_FORCE_OBJECT);
                echo $aResponse;
            }
        }
        else
        {
//            $jQueryShowError = "$(document).ready(function () {";
//            $jQueryShowError .= "alert(\"Ongeldige registratieID! RegistratieID moet een cijfer zijn.\");";
//            $jQueryShowError .= "});";
//            file_put_contents("../Resource/JS/showError.js", $jQueryShowError, FILE_APPEND);
            $aResponse = json_encode(array("failure" => true, "errorMsg" => "Ongeldige registratieID! RegistratieID moet een cijfer zijn."), JSON_FORCE_OBJECT);
            echo $aResponse;  
        }
        break;
}

/**
 * Author:  David from Code2Design.com ¶ (https://www.php.net/manual/en/function.curl-exec.php#98628) 
* Send a GET requst using cURL
* @param string $url to request
* @param array $get values to send
* @param array $options for cURL
* @return string
*/
function curl_get($url, array $get = NULL, array $options = array())
{   
    $defaults = array(
        CURLOPT_URL => $url. (strpos($url, '?') === FALSE ? '?' : ''). http_build_query($get),
        CURLOPT_HEADER => 0,
        CURLOPT_RETURNTRANSFER => TRUE,
        CURLOPT_TIMEOUT => 4
    );
   
    $ch = curl_init();
    curl_setopt_array($ch, ($options + $defaults));
    if(!$result = curl_exec($ch))
    {
        $result = curl_error($ch);
        $result = json_encode($result, JSON_FORCE_OBJECT);
        //trigger_error(curl_error($ch));
    }
    curl_close($ch);
    return $result;
} 

?>

