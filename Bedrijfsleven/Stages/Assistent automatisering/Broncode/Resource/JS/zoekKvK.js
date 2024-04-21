/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('document').ready(function () 
{
    $('#txtKvKNr').change(function () 
    {
        if($('#txtKvKNr').val().length === 8)
            getKvKData('kvkNumber' + "=" + $('#txtKvKNr').val());
    });
    
    $('#txtKantoornaam').change(function () 
    {
        if($('#txtKantoornaam').val().length > 0)
            getKvKData('tradeName' + "=" + $('#txtKantoornaam').val());
    });
    
    $('#txtVestigingsadres').change(function () 
    {
        if($('#txtVestigingsadres').val().length > 0)
        {
            var straatNaam = $('#txtVestigingsadres').val().replace(/\d+/g,'');
            straatNaam.trim();
            var huisNr = $('#txtVestigingsadres').val().match(/\d+/);
            getKvKData('Street' + "=" + straatNaam + "&houseNumber=" + huisNr);     
        }
    });
    
    $('#txtVestigingsPostcode').change(function () 
    {
        if($('#txtVestigingsPostcode').val().length >= 6)
            getKvKData('Postalcode' + "=" + $('#txtVestigingsPostcode').val());
    });
    
    $('#txtVestigingsWoonplaats').change(function () 
    {
        if($('#txtVestigingsWoonplaats').val().length > 0)
            getKvKData('City' + "=" + $('#txtVestigingsWoonplaats').val());
    });
    
    $('#txtPostadres').change(function () 
    {
        if($('#txtPostadres').val().length > 0)
            getKvKData('Q' + "=" + $('#txtPostadres').val());        
    });
    
    $('#txtPostPostcode').change(function () 
    {
        if($('#txtPostPostcode').val().length >= 6)
            getKvKData('Postalcode' + '=' + $('#txtPostPostcode').val());
    });
    
    $('#txtPostWoonplaats').change(function () 
    {
        if($('#txtPostWoonplaats').val().length > 0)
            getKvKData('City' + "=" + $('#txtPostWoonplaats').val());
    });

    $('#ddmKantoren').change(function()
    {
        if($('#ddmKantoren').val().length > 0)
            getKvKData('kvkNumber' + "=" + $('#ddmKantoren').val());
    });
    
    function getKvKData(zoekCriteria)
    {
        $.ajax({
            url: "../../Utilities/AsyncVerzoek.php",
            method: "POST",
            contentType: "application/x-www-form-urlencoded",
            data: {"url":"https://api.kvk.nl/api/v2/search/companies?" + zoekCriteria,
            "soortOpdracht": "zoekKvK"},
            dataType: "json",
            success: function (response)
            {
                if("error" in response)
                {
                    if(response["error"]["code"] == 404)
                        alert("Foutmelding KvK API: Geen kantoor gevonden in handelsregister.");
                    else
                        alert("Foutmelding KvK API: " + response["error"]["code"] + " - " + response["error"]["message"] + ":" + response["error"]["reason"]);
                }
                else if("data" in response)
                {
                    if(response["data"]["items"].length > 1)
                    {
                        //if("branchNumber" in response[""])
                        if(response["data"]["items"][0]["kvkNumber"] != response["data"]["items"][1]["kvkNumber"])
                        {
                            $("#txtKantoornaam").css('display', 'none');                        
                            $("#ddmKantoren").css('display', 'inline-block');
                            $("#ddmKantoren").empty();
                            $("#ddmKantoren").append("<option value=\"\" selected>--Kies uw gewenste kantoor--</option>");
                            for(var index = 0; index < response["data"]["items"].length; index++)
                            {
                                if("currentName" in response["data"]["items"][index]["tradeNames"])
                                {
                                    $("#ddmKantoren").append("<option value=\"" + response["data"]["items"][index]["kvkNumber"] + "\">" 
                                    + response["data"]["items"][index]["tradeNames"]["currentName"] + "</option>");
                                }
                                else if("businessName" in response["data"]["items"][index]["tradeNames"])
                                {
                                    $("#ddmKantoren").append("<option value=\"" + response["data"]["items"][index]["kvkNumber"] + "\">" 
                                    + response["data"]["items"][index]["tradeNames"]["businessName"] + "</option>");
                                }
                                else if("shortBusinessName" in response["data"]["items"][index]["tradeNames"])
                                {
                                    $("#ddmKantoren").append("<option value=\"" + response["data"]["items"][index]["kvkNumber"] + "\">" 
                                    + response["data"]["items"][index]["tradeNames"]["shortBusinessName"] + "</option>");
                                }
                                else if("currentStatutoryNames" in response["data"]["items"][index]["tradeNames"])
                                {
                                    $("#ddmKantoren").append("<option value=\"" + response["data"]["items"][index]["kvkNumber"] + "\">" 
                                    + response["data"]["items"][index]["tradeNames"]["currentStatutoryNames"][0] + "</option>");
                                }
                            }
                        }
                        else
                        {
                            setSingleSetKvKData(response);
                        }
                    }
                    else
                    {
                        setSingleSetKvKData(response);
                    }
                }
                else
                {
                    alert("Foutmelding IQ: Zoekcriteria is ongeldig!");
                }
            },
            timeout: 0,
            error: function (result, errormsg, errorThrown)
            {
//                alert(JSON.stringify(result));
//                alert(errormsg + " - " + errorThrown);
                alert("Foutmelding KvK API: Geen kantoor gevonden in handelsregister.");
            }                        
        });
    }
    
    function setSingleSetKvKData(response)
    {
        $("#ddmKantoren").css('display', 'none');
        $("#ddmKantoren").empty();
        $("#txtKantoornaam").css('display', 'inline-block'); 
        if("currentStatutoryNames" in response["data"]["items"][0]["tradeNames"])
            $('#txtKantoornaam').val(response["data"]["items"][0]["tradeNames"]["currentStatutoryNames"][0]);
        else
            $('#txtKantoornaam').val(response["data"]["items"][0]["tradeNames"]["businessName"]);
        $('#txtKvKNr').val(response["data"]["items"][0]["kvkNumber"]);

        $('#txtVestigingsadres').val(response["data"]["items"][0]["addresses"][0]["street"] + " "
                + response["data"]["items"][0]["addresses"][0]["houseNumber"]);
        $('#txtVestigingsPostcode').val(response["data"]["items"][0]["addresses"][0]["postalCode"]);
        $('#txtVestigingsWoonplaats').val(response["data"]["items"][0]["addresses"][0]["city"]);  

        if(1 in response["data"]["items"][0]["addresses"])
        {
            if(response["data"]["items"][0]["addresses"][1]["type"] == "correspondentieadres")
            {
                $('#txtPostPostcode').val(response["data"]["items"][0]["addresses"][1]["postalCode"]);
                $('#txtPostadres').val(response["data"]["items"][0]["addresses"][1]["street"] + " "
                + response["data"]["items"][0]["addresses"][1]["houseNumber"]);
                $('#txtPostWoonplaats').val(response["data"]["items"][0]["addresses"][1]["city"]);
            }
        }
        else
        {
            $('#txtPostPostcode').val(response["data"]["items"][0]["addresses"][0]["postalCode"]);
            $('#txtPostadres').val(response["data"]["items"][0]["addresses"][0]["street"] + " "
            + response["data"]["items"][0]["addresses"][0]["houseNumber"]);
            $('#txtPostWoonplaats').val(response["data"]["items"][0]["addresses"][0]["city"]);
        }

        if(response["data"]["items"][0]["addresses"].length == 3)
        {
            $('#txtPostPostcode').val(response["data"]["items"][0]["addresses"][2]["postalCode"]);
            $('#txtPostadres').val(response["data"]["items"][0]["addresses"][2]["street"] + " "
            + response["data"]["items"][0]["addresses"][2]["houseNumber"]);
            $('#txtPostWoonplaats').val(response["data"]["items"][0]["addresses"][2]["city"]);
        }

        if("websites" in response["data"]["items"][0])
            $('#txtWebsite').val(response["data"]["items"][0]["websites"]);
    }
})

