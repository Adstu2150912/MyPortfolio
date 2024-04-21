/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('document').ready(function () 
{
   $('#ddmKantoren').change(function()
    {
        if($('#ddmKantoren').val().length > 0)
        {
            $.ajax({
            url: "../../Utilities/AsyncVerzoek.php",
            method: "POST",
            contentType: "application/x-www-form-urlencoded",
            data: {"regID":$('#ddmKantoren').val(),
            "soortOpdracht": "get3CXContact"},
            dataType: "json",
            success: function (response)
            {    
                if("failure" in response)
                {
                    if(response["failure"] === true)
                    {
                        alert(response["errorMsg"]);
                        $('#titelKopRelatie').after('<h5><font color=\"red\" style=\"background: white;\"><b>' + response["errorMsg"] + '</b></font></h5>');                        
                    }
                }
                else
                {
                    open('HelpdeskItem.php?regID=' + response["registratieID"] + '&typeForm=new&crmIntegratie=true', '_blank');
                    $("#tdWijzigLicentie").append("<td colspan=\"4\"><a href=\"Relatieform.php?id=" +  response["registratieID"] + "&typeForm=edit\" class=\"u-border-2 u-btn u-button-style u-none u-btn-2\">Licentie aanpassen</a></td>");
                    $("#lblAgenda").after("<a href=\"Agendaform.php?typeForm=new&regID=" + response["registratieID"] + "\"  class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" id=\"btnNieuwAgendaPunt\">Nieuw agendapunt aanmaken</a>");
                    $("#lblHelpdesk").after("<a href=\"HelpdeskItem.php?regID=" + response["registratieID"] + "&typeForm=new\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\" id=\"btnNieuwHelpdeskItem\">Nieuw item aanmaken</a>");
                    var werktMetApp = "n.t.b.";
                    var gebruiktIncasso = "n.t.b.";
                    var geefKorting = "n.t.b.";
                    var heeftBoekingen = false;
                    var heeftHypotheken = false;
                    var heeftADN = false;
                    var heeftMaandbetalers = false;
                    var heeftDeclaratie = false;
                    var heeftBoekhouding = false;
                    var heeftRolls = false;
                    var heeftPakketten = false;
                    var heeftSubagenten = false;
                    var heeftVolmacht = false;
                    var heeftWebExport = false;
                    var heeftClientServer = false;
                    var date = null;

                    if(response["ipBan"] == "1")            
                       $('#titelKopRelatie').after('<h5><font color=\"red\" style=\"background: white;\"><b>LET OP: BLOKKADE ***** LET OP: BLOKKADE ***** LET OP: BLOKKADE </b></font></h5>');
                    if(response["gebruikersNaam"] == "Romy Tyszka" && response["bewaking"] == "1")
                       $('#titelKopRelatie').after('<h5><font color=\"red\" style=\"background: white;\"><b>LET OP: BEWAKEN ***** LET OP: BEWAKEN ***** LET OP: BEWAKEN </b></font></h5>'); 

                    if("heeftOpenSaldo" in response)
                        if(response["heeftOpenSaldo"] == "true")
                            $('#titelKopRelatie').after('<a href=\"#" . "\"><H5><font color=\"red\" style=\"background: white;\">LET OP: DEZE RELATIE HEEFT EEN OPENSTAAND SALDO!&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; KLIK HIER</FONT></H5></a><br>');

                    if(response["isAdmin"] == "ja")
                    {
                        if(response["pakketID"] != 1 && response["pakketID"] != 11 && response["pakketID"] != 3 && response["pakketID"] != 4 && response["pakketID"] != 5)
                        {
                            $('#tblKantoorData1 > tbody').prepend('<tr style=\"height: 30px;\">'
                            + "<td class=\"u-table-cell u-table-cell-1\" id=\"lblExtKlantNr\"></td>"
                            + "<td class=\"u-table-cell\" id=\"extKlantNrWaarde\"></td>"
                            + "<td class=\"u-table-cell u-table-cell-3\"></td>"
                            + "<td class=\"u-table-cell\"></td>"
                            + "</tr>'");
                            $('#lblExtKlantNr').append('Extern klantnummer:');
                            $('#extKlantNrWaarde').append(response["externKlantNr"]);
                        }
                        $('#lblProducent').append('Producent:');
                        $('#producentWaarde').append(response["producent"]);
                    }

                    switch(parseInt(response["werktMetApp"]))
                    {
                        case 1:
                            werktMetApp = "Ja";
                            break;
                        case 0:
                            werktMetApp = "Nee";
                            break;
                    }

                    switch(parseInt(response["autoIncasso"]))
                    {
                        case 1:
                            gebruiktIncasso = "Ja";
                            break;
                        case 0:
                            gebruiktIncasso = "Nee";
                            break;
                    }

                    switch(parseInt(response["heeftKorting"]))
                    {
                        case 1:
                            geefKorting = "Ja";
                            break;
                        case 0:
                            geefKorting = "Nee";
                            break;
                    }

                    if(parseInt(response["heeftBoekingen"]) === 1)
                        heeftBoekingen = true;
                    if(parseInt(response["heeftHypotheken"]) === 1)
                        heeftHypotheken = true;
                    if(parseInt(response["heeftADN"]) === 1)
                        heeftADN = true;
                    if(parseInt(response["heeftMaandBetalers"]) === 1)
                        heeftMaandbetalers = true;
                    if(parseInt(response["heeftDeclaratie"]) === 1)
                        heeftDeclaratie = true;
                    if(parseInt(response["heeftBoekhouding"]) === 1)
                        heeftBoekhouding = true;
                    if(parseInt(response["heeftRolls"]) === 1)
                        heeftRolls = true;
                    if(parseInt(response["heeftPakketten"]) === 1)
                        heeftPakketten = true;
                    if(response["heeftSubagenten"] === 1)
                        heeftSubagenten = true;
                    if(response["heeftVolmacht"] === 1)
                        heeftVolmacht = true;
                    if(response["heeftWebexport"] === 1)
                        heeftWebExport = true;
                    if(response["heeftClientServer"] === 1)
                        heeftClientServer = true;

                    $('#titelKopRelatie').append("Registratie: " + response["registratieID"] + " - " + response["kantoorNaam"]);
                    $('#tdMsgKantoorkKeuze').empty();
                    $('#tdMsgKantoorkKeuze').append('Kantoornaam:');
                    $('#kantoorNaamWaarde').empty();
                    $('#kantoorNaamWaarde').append(response["kantoorNaam"]);
                    if(response["oudKantoorNaam"] != null)
                        $('#oudKantoorNaamWaarde').append(response["oudKantoorNaam"]);
                    if(response["contactpersoonFormelenaam"] != null)
                        $('#contactPersoonWaarde').append(response["contactpersoonFormelenaam"]);
                    if(response["contactpersoonVoornaam"] != null)
                        $('#cpVoornaamWaarde').append(response["contactpersoonVoornaam"]);           
                    $('#postAdres').append(response["postAdres"]);
                    $('#postAdres').append(" " + response["postPostcode"]);
                    $('#postAdres').append(" " + response["postWoonplaats"]);
                    $('#vestigingsAdres').append(response["vestigingsAdres"]);
                    $('#vestigingsAdres').append(" " + response["vestigingsPostcode"]);
                    $('#vestigingsAdres').append(" " + response["vestigingsWoonplaats"]);
                    $('#telNrWaarde').append(response["telNr1"]);
                    
//                    if(response["telNr1"] != null)
//                        $('#telNrWaarde').prop('onclick',open("HelpdeskItem.php?regID=" + response["registratieID"] + "&typeForm=new&crmIntegratie=true", "_blank"));
                    
                    if(response["IBAN"] != null)
                        $('#IBANWaarde').append(response["IBAN"]);
                    if(response["telNr2"] != null)
                    {
                        $('#telNr2Waarde').append(response["telNr2"]);
                        //$('#telNr2Waarde').prop('onclick',open("HelpdeskItem.php?regID=" + response["registratieID"] + "&typeForm=new&crmIntegratie=true", "_blank"));
                    }
                    if(response["BIC"] != null)
                        $('#BICWaarde').append(response["BIC"]);
                    $('#emailAdresWaarde').append(response["emailAdres"]);
                    if(response["mandaatNr"] != null)
                        $('#mandaatNrWaarde').append(response["mandaatNr"]);

                    if(response["websiteURL"] !== ".")
                        if(response["websiteURL"].includes("http://") || response["websiteURL"].includes("https://") || response["websiteURL"].includes("www"))
                            $('#webLinkWaarde').append("<a href=\"" + response["websiteURL"] + "\">" + response["websiteURL"] + "</a>");
                        else
                            $('#webLinkWaarde').append("<a href=\"http://" + response["websiteURL"] + "\">" + response["websiteURL"] + "</a>");

                    $('#werktMetAppWaarde').append(werktMetApp);
                    if(parseInt(response["kvkNr"]) != 0)
                        $('#kvkNummerWaarde').append(response["kvkNr"]);

                    if(response["urlLinkedIn"] != "" || response["urlLinkedIn"] != null)
                        $('#LinkedInWaarde').append("<a href=\"" + response["urlLinkedIn"] + ">" + response["urlLinkedIn"] + "</a>");

                    $('#loginPSWaarde').append(response["loginWachtwoord"]);

                    if(response["pakketID"] != 1 && response["pakketID"] != 11 && response["pakketID"] != 3 && response["pakketID"] != 4 && response["pakketID"] != 5)
                        $('#extKlantNrWaarde').append(response["externKlantNr"]);

                    if("pakketOmschrijving" in response)
                        $('#pakketWaarde').append(response["pakketID"] + " - " + response["pakketOmschrijving"]);
                    else
                        $('#pakketWaarde').append(response["pakketID"]);

                    $('#numUsersWaarde').append(response["aantalGebruikers"]);
                    date = new Date(response["ingangsDatum"]);
                    $('#ingangsDatumWaarde').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());
                    date = new Date(response["supportTot"]);
                    $('#eindDatumWaarde').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());

                    if("statusOmschrijving" in response)
                        $('#statusWaarde').append(response["statusOmschrijving"]);

                    if("huidigeVersie" in response)
                        $('#ass20VersieWaarde').append(response["huidigeVersie"]);
                    if("laatstIngelogd" in response)
                    {
                        date = new Date(response["laatstIngelogd"]);
                        $('#laatstInlogDatumTijd').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());
                    }

                    if(response["pakketID"] === 90 || response["pakketID"] === 91)
                    {
                        $('#tblLicentie > tbody').append(
                        "<tr><td colspan=\"4\">"
                        + "<p style=\"color:red\"><b>Verwijder een licentie alléén als je zeker weet dat die nooit meer nodig is! Een prospect verwijder je dus alleen als het bedrijf niet meer bestaat - het kan immers zijn dat iemand na jaren nog eens opduikt. Dan is het handig om de gegevens nog bij de hand te hebben.<br><br>Een \"probeersel\" kan je natuurlijk zonder problemen verwijderen.<br><br></b></p>"
                        + "</td><tr>" 
                        + "<td colspan=\"4\" class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">"
                        + "<input id=\"btnVerwijderProspect\" type=\"button\" value=\"Prospects verwijderen\" class=\"u-border-2 u-btn u-button-style u-none u-btn-1\">"
                        + "</td>"
                        + "</tr>");
                    }                

                    $('#moduleWaarde').append(
                    (heeftBoekingen ? "| Boekingen | " : "")
                    + (heeftHypotheken ? "Hypotheken | " : "" )
                    + (heeftADN ? "ADN | " : "")
                    + (heeftMaandbetalers ? "Maandbetalers | " : "")
                    + (heeftDeclaratie ? "Declaratie | " : "")
                    + (heeftBoekhouding ? "Boekhouding | " : "")
                    + (heeftRolls ? "Rolls | " : "")
                    + (heeftPakketten ? "Pakketten | " : "")
                    + (heeftSubagenten ? "Subagenten | " : "")
                    + (heeftVolmacht ? "Volmacht | " : "")
                    + (heeftWebExport ? "WebExport |" : "")
                    + (heeftClientServer ? "ClientServer |" : ""));

                    $('#lblLicBedrag').empty();
                    var licentieBedrag = 0;
                    if (response["licentieBedrag"] != "" && response["licentieBedrag"] != null && isNaN(parseFloat(response["licentieBedrag"].toString()).toFixed(2)) == false)
                    {
                        if(isNaN(parseFloat(response["btwPercentage"].toString()).toFixed(2)) == false)
                        {
                            $('#lblLicBedrag').append("Licentiebedrag incl. btw:");
                            licentieBedrag = parseFloat(response["licentieBedrag"].toString()).toFixed(2) * (1 + (parseFloat(response["btwPercentage"].toString()).toFixed(2) / 100));
                        }
                        else
                        {
                            $('#lblLicBedrag').append("Licentiebedrag excl. btw:");
                            licentieBedrag = parseFloat(response["licentieBedrag"].toString()).toFixed(2);
                        }
                        licentieBedrag = (Math.round(licentieBedrag * 100)) / 100;                    
                        $('#licBedragWaarde').append(licentieBedrag);
                    }          

                    if(response["licentiePeriode"] != null)
                        $('#licPeriodeWaarde').append(response["licentiePeriode"] + " mnd");
                    if(response["ekFactuurDatum"] != null)
                        $('#ekFacDatumWaarde').append(response["ekFactuurDatum"]);
                    date = new Date(response["datumLaatsteIndex"]);
                    $('#laatsteIndexWaarde').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());
                    if(response["btwPercentage"] != null)
                        $('#btwPercWaarde').append(response["btwPercentage"]);
                    $('#autoIncassoWaarde').append(gebruiktIncasso);
                    $('#heeftKortingWaarde').append(geefKorting);

                    if(geefKorting === "Ja")
                    {
                        $('#redenKortingWaarde').append(response["redenKorting"]);
                        $('#hoogteKortingWaarde').append(response["hoogteKorting"]);
                    }
                    if("stornos" in response)
                        $('#aantalStornoWaarde').append(response["stornos"]);                    

                    if(response["laatstOpgehaaldOp"] != null)
                    {
                        date = new Date(response["laatstOpgehaaldOp"]);
                        $('#recentDatumLicentieWaarde').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());
                    }
                    if(response["demoDatum"] != null)
                    {
                        date = new Date(response["demoDatum"]);
                        $('#demoDatumWaarde').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());
                    }

                    if("bron1" in response)
                        $('#bronWaarde').append(response["bron1"]);

                    if(response["bronOmschrijving"] != null)
                        $('#bron2Waarde').append(response["bronOmschrijving"]);
                    if(response["conversieDoor"] != null)
                        $('#conversiePersoonWaarde').append(response["conversieDoor"]);
                    if(response["conversiePakket"] != null)
                        $('#conPakketWaarde').append(response["conversiePakket"]);
                    if(response["vorigPakket"] != null)
                        $('#vorigPakketWaarde').append(response["vorigPakket"]);
                    if(response["datumMailing"] != null)
                    {
                        date = new Date(response["datumMailing"]);
                        $('#datumMailingWaarde').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());
                    }
                    if(response["welkomstGeschenk"] != null)
                        $('#welkomstgeschenkWaarde').append(response["welkomstGeschenk"]);
                    if(response["verstuurdOp"] != null)
                    {
                        date = new Date(response["verstuurdOp"]);
                        $('#verstuurdOpWaarde').append(((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear());
                    }

                    if(response["opmerkingen"] != "" || response["opmerkingen"] != null)
                    {
                        //response["opmerkingen"] = response["opmerkingen"].replace(/(?:\r\n|\r|\n)/g,"&#13;&#10;");
                        $('#txtArNotities').append(response["opmerkingen"]);
                    }
                    else
                        $('#txtArNotities').append('Er zijn geen opmerkingen');

                    if("agenda" in response)
                    {
                        for(var index in response["agenda"])
                        {
                            //if(response["agenda"][index]["tekst"] !== "" && response["agenda"][index]["tekst"] !== null)
                                //response["agenda"][index]["tekst"] = response["agenda"][index]["tekst"].replace(/(?:\r\n|\r|\n)/g,"<br><br>");
                            date = new Date(response["agenda"][index]["agendadatum"]);
                            var strDate = ((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '-' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '-' + date.getFullYear();
                            $('#tblAgenda > tbody').append("<tr style=\"height: 30px;\">" 
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response["agenda"][index]["van"] 
                            + "</td><td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response["agenda"][index]["voor"]
                            +  "</td><td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + strDate
                            + "</td><td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response["agenda"][index]["tekst"]
                            + "</td><td><a href=\"Agendaform.php?typeForm=edit&agendaID=" + response["agenda"][index]["agendaID"] 
                            + "&regID=" + response["agenda"][index]["regID"] + "\">wijzigen</a> | <a href=\"Relatiekaart.php?agendaID=" + response["agenda"][index]["agendaID"] + "&id=" + response["agenda"][index]["regID"] + "&pakket=" + response["agenda"][index]["pakketID"] + "\">afleggen</a></td>" 
                            + "</tr>");
                        }
                    }
                    else
                        $('#tblAgenda > tbody').append("<tr><td></td><td colspan=\"5\">Er zijn (voor deze relatie) geen openstaande agendapunten</td></tr>");                  

                    if("helpdesk" in response)
                    {                          
                        if("aantalTickets" in response)
                            $('#aantalHDWaarde').append(response["aantalTickets"] + " items");     
                        for(var index in response["helpdesk"])
                        {
                            //if(response["helpdesk"][index]["vraag"] !== "" && response["helpdesk"][index]["vraag"] !== null)
                                //response["helpdesk"][index]["vraag"] = response["helpdesk"][index]["vraag"].replace(/(?:\r\n|\r|\n)/g,"<br><br>");
                            $('#tblHelpdesk > tbody').append(
                            "<tr style=\"height: 30px;\">" 
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" 
                            + "<a href=\"HelpdeskItem.php?regID=" + response["registratieID"] + "&ticketID=" + response["helpdesk"][index]["ticketID"] + "\">" 
                            + response["helpdesk"][index]["datumtijd"] + "</a></td>"
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response["helpdesk"][index]["persoon"] + "</td>"
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response["helpdesk"][index]["Behandelaar"] + "</td>"
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response["helpdesk"][index]["vraag"] + "</td>"
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response["helpdesk"][index]["categorie"] + "</td>"
                            + "</tr>");
                        }                        
                    }
                    else
                    {
                        $('#aantalHDWaarde').append('0 items');
                        $('#sec-7a1b').append('Er zijn geen helpdeskitems die aan de voorwaarden voldoen');
                    }                   
                }                                                                    
            },
            error: function (result, errormsg, errorThrown)
            {
                //alert(errormsg + " - " + errorThrown);
            }
        });
        }
    }); 
});


