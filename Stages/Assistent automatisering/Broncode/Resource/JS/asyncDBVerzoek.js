$('document').ready(function () {
    $("#btnVerwijderProspect").click(function () {
        $.ajax({
            url: "../../Utilities/AsyncVerzoek.php",
            method: "POST",
            contentType: "application/x-www-form-urlencoded",
            data: {"regID":$('#regID').val(),
            "soortOpdracht": "verwijderProspect"},
            dataType: "json",
            success: function (response)
            {
                open("index.php", "_self");
            },
            error: function (result, errormsg, errorThrown)
            {
                //alert(errormsg + " - " + errorThrown);
            }
        });
    });
    $("#ddmTabel").change(function () {
        if($("#ddmTabel").val() != "")
        {
             $.ajax({
                url: "../../Utilities/AsyncVerzoek.php",
                method: "POST",
                contentType: "application/x-www-form-urlencoded",
                data: {"tabelNaam":$('#ddmTabel').val(),
                "soortOpdracht": "zoekSQLVelden"},
                dataType: "json",
                success: function (response)
                {
                    //var aResult = JSON.parse(JSON.stringify(response));                    
                    $('#tblSQLOverzicht > tbody').empty();
                    if("failure" in response)
                    {
                        if(response["failure"] === true)
                        {                            
                            $('#tblSQLOverzicht > tbody').append("<tr style=\"height: 76px;\"><td></td><td colspan=\"2\" style=\"text-align:center\">" + response["errorMsg"] + "</td><tr>"); 
                            alert(response["errorMsg"]);
                        }
                    }
                    else
                    {
                        for(var row in response)
                        {
                            var currentRow = "<tr style=\"height: 76px;\">"
                                currentRow += "<td></td>";
                                currentRow += "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response[row] + "</td>";
                            currentRow += "</tr>";
                            $('#tblSQLOverzicht > tbody').append(currentRow);
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
    $('#btnTestSelectie').click(function () {
        if($('#txtSelectie').val() !== "")
        {
            $.ajax({
                url: "../../Utilities/AsyncVerzoek.php",
                method: "POST",
                contentType: "application/x-www-form-urlencoded",
                data: {"sqlQuery":$('#txtSelectie').val(),
                "soortOpdracht": "testIQSelectie"},
                dataType: "json",
                success: function (response)
                {
                    //var aResult = JSON.parse(JSON.stringify(response));                    
                    $('#tblTestResultaat > thead').empty();                    
                    $('#tblTestResultaat > tbody').empty();
                    if("failure" in response)
                    {
                        if(response["failure"] === true)
                        {
                            $('#tblTestResultaat > thead').append("<tr style=\"height: 21px;\"><th class=\"u-border-1 u-border-grey-50 u-table-cell\">Foutmelding</th></tr>");
                            $('#tblTestResultaat > tbody').append("<tr style=\"height: 76px;\"><td style=\"text-align:center\">" + response["errorMsg"] + "</td><tr>"); 
                            alert(response["errorMsg"]);
                        }
                    }
                    else
                    {
                        var tblHeader = "<tr style=\"height: 21px;\">";
                        for(var header in response[0])
                        {
                            tblHeader += "<th class=\"u-border-1 u-border-grey-50 u-table-cell\">" 
                            + response[0][header]
                            + "</th>";
                        }
                        tblHeader += "</tr>";
                        $('#tblTestResultaat > thead').append(tblHeader);
                        for(var row in response[1])
                        {
                            var currentRow = "<tr style=\"height: 76px;\">"
                            for(var field in response[1][row])
                            {
                                currentRow += "<td class=\"u-border-1 u-border-grey-40 u-border-no-left u-border-no-right u-table-cell\">" + response[1][row][field] + "</td>";
                            }
                            currentRow += "</tr>";
                            $('#tblTestResultaat > tbody').append(currentRow);
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

