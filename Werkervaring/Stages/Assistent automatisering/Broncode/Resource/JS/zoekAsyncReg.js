/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('document').ready(function () {
    $('#btnSubmit').click(function () {
        if($('#ddmRegistratieVeld option:checked').val() !== "" && $('#txtRegistratieWaarde').val() !== "" || $('#txtFactuurnummer').val() !== "")
        {
            //var zoekType = $('#ddmRegistratieVeld option:checked').val();
            //var zoekTabel = zoekType.substr(0, zoekType.indexOf("."));
            //var zoekVeld = zoekType.substr((zoekType.indexOf(".") + 1), zoekType.length - (zoekType.indexOf(".") + 1));
            $.ajax({
                url: "../../Utilities/AsyncVerzoek.php",
                method: "POST",
                contentType: "application/x-www-form-urlencoded",
                data: { "registratieWaarde":$('#txtRegistratieWaarde').val(), 
                        "factuurNummer":$('#txtFactuurnummer').val(),
                        "soortOpdracht":"zoekRegistraties"},
                dataType: "json",
                success: function (response, msg)
                {
                    //alert(msg + " - " + response);
                    //var response = JSON.parse(response);
                    //alert(msg + " - " + response[0][0]);
                    //alert(JSON.stringify(response));
                    //alert(response[0]);
                    //alert(response[0][0]);
                    var tblRegistratie = "";
                    //var registratieID is in dit geval een index van de huidige element uit de huidige lus
                    for(var index in response)
                    {
                        if("failure" in response)
                        {
                            if(response["failure"] === true)
                                tblRegistratie = "<tr style=\"height: 76px;\"><td colspan=\"7\" style=\"text-align:center\">" + response["errorMsg"] + "</td>"
                                + "<td></td>"
                                + "</tr>"; 
                        }
                        else
                        {
                            tblRegistratie += "<tr style=\"height: 76px;\">";
                            tblRegistratie += "<td class=\"u-border-1 u-border-grey-30 u-grey-50 u-table-cell u-table-cell-8\"><a href=\"Relatiekaart.php?id=" + response[index]["registratieID"] + "&pakket=" + response[index]["pakketID"] + "\">" + response[index]["kantoorNaam"];
                            if(response[index]["oudKantoorNaam"] !== null)
                                if(response[index]["oudKantoorNaam"].length > 0)
                                    tblRegistratie += " / " + response[index]["oudKantoorNaam"];
                            tblRegistratie += "</a></td>";
                            if(response[index]["contactpersoonVoorletters"] !== null && response[index]["contactpersoonVoornaam"] !== null && response[index]["contactpersoonAchternaam"] !== null)
                                tblRegistratie += "<td class=\"u-border-1 u-border-grey-30 u-grey-50 u-table-cell u-table-cell-8\">" + response[index]["contactpersoonVoorletters"] + " (" + response[index]["contactpersoonVoornaam"] + ") " + response[index]["contactpersoonAchternaam"] + "</td>";
                            else if(response[index]["contactpersoonVoornaam"] !== null && response[index]["contactpersoonAchternaam"] !== null)
                                tblRegistratie += "<td class=\"u-border-1 u-border-grey-30 u-grey-50 u-table-cell u-table-cell-8\">" + response[index]["contactpersoonVoornaam"] + " " + response[index]["contactpersoonAchternaam"] + "</td>";
                            else
                                tblRegistratie += "<td class=\"u-border-1 u-border-grey-30 u-grey-50 u-table-cell u-table-cell-8\">" + response[index]["contactpersoonFormelenaam"] + "</td>";
                            tblRegistratie += "</tr>'";
                        }
                    }
                    $('#tblRegistraties > tbody').empty();
                    $('#tblRegistraties > tbody').append(tblRegistratie);
                    $('#tblRegistraties').css('display', 'table');
                    $('html, body').animate({scrollTop: $('#tblRegistraties').offset().top},'fast');
                },
                error: function (result, errormsg, errorThrown)
                {
                    //alert(JSON.stringify(result));
                    //alert(errormsg + " - " + errorThrown);
                    $('#tblRegistraties').css('display', 'none');
                }
            });
        }
    });
})


