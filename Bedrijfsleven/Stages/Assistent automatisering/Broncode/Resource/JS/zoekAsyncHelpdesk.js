$('document').ready(function () {
    $('#btnSubmit').click(function () {
        if($('#ddmCategorieVeld option:checked').val() !== "" || $('#txtZoekWaarde').val() !== "")
        {
            $.ajax({
                url: "../../Utilities/AsyncVerzoek.php",
                method: "POST",
                contentType: "application/x-www-form-urlencoded",
                data: {"categorie":$('#ddmCategorieVeld option:checked').val(),
                        "zoekwaarde":$('#txtZoekWaarde').val(),
                        "soortOpdracht":"zoekopdrachtHelpdesk"},
                dataType: "json",
                success: function (response, msg)
                {
                    //alert(msg + " - " + response);
                    //var response = JSON.parse(response);
                    //alert(msg + " - " + response[0][0]);
                    //alert(JSON.stringify(response));
                    var tblHelpdesk = "";
                    $('#tblHelpdesk > tbody').empty();
                    if("failure" in response)
                    {
                        if(response["failure"] === true)
                        {
                            tblHelpdesk += "<tr style=\"height: 76px;\"><td colspan=\"3\" style=\"text-align:center\">" + response["errorMsg"] + "</td><td></td><td></td><tr>"; 
                            alert("Geen zoekresultaten voor '" + $('#txtZoekWaarde').val() + "' gevonden met categorie '" + $('#ddmCategorieVeld option:checked').val() + "' in de database!");
                        }
                    }
                    else
                    {
                        //alert(response[helpdeskItem]);
                        //var helpdeskitem is in dit geval een index van de huidige element uit de huidige lus
                        for(var helpdeskItem in response)
                        {
                            //if(response[helpdeskItem][3] !== "" && response[helpdeskItem][3] !== null)
                                //response[helpdeskItem][3] = response[helpdeskItem][3].replace(/(?:\r\n|\r|\n)/g,"<br><br>");
                            tblHelpdesk += "<tr style=\"height: 76px;\"><td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" 
                            + "<a href=\"HelpdeskItem.php?regID=" + response[helpdeskItem][0] + "&typeForm=edit&ticketID=" + response[helpdeskItem][1] + "\">" 
                            + response[helpdeskItem][2] + "</a></td>"
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response[helpdeskItem][3] + "</td>"
                            + "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response[helpdeskItem][4] + "</td>"
                            tblHelpdesk += "</tr>";
                        }
                    }
                            
                    $('#tblHelpdesk > tbody').append(tblHelpdesk);
                    $('#tblHelpdesk').css('display', 'table');
                    $('html, body').animate({scrollTop: $('#tblHelpdesk').offset().top},'fast');
                },
                error: function (result, errormsg, errorThrown)
                {
                    $('#tblHelpdesk').css('display', 'none');
                    //alert(errormsg + " - " + errorThrown);
                }
            });
        }
    });
});


