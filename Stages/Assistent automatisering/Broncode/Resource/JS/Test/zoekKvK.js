/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('document').ready(function () 
{
    $('#btnZoekKvK').click(function()
    {
        var zoekCriteria = "";
        if($('#txtKantoornaam').val().length > 0)
            zoekCriteria += 'tradeName' + "=" + $('#txtKantoornaam').val();
        if($('#txtVestigingsadres').val().length > 0)
        {
            if(zoekCriteria != "")
                zoekCriteria += "&";
            var straatNaam = $('#txtVestigingsadres').val().replace(/\d+/g,'');
            straatNaam.trim();
            var huisNr = $('#txtVestigingsadres').val().match(/\d+/);
            zoekCriteria += 'Street' + "=" + straatNaam + "&houseNumber=" + huisNr;     
        }
        else if($('#txtPostadres').val().length > 0)
        {
            if(zoekCriteria != "")
                zoekCriteria += "&";
            var straatNaam = $('#txtPostadres').val().replace(/\d+/g,'');
            straatNaam.trim();
            var huisNr = $('#txtPostadres').val().match(/\d+/);
            zoekCriteria += 'Street' + "=" + straatNaam + "&houseNumber=" + huisNr;     
        }
        
        if($('#txtVestigingsPostcode').val().length >= 6)
        {
            if(zoekCriteria != "")
                zoekCriteria += "&";
            zoekCriteria += 'Postalcode' + "=" + $('#txtVestigingsPostcode').val();
        }
        else if($('#txtPostPostcode').val().length >= 6)
        {
            if(zoekCriteria != "")
                zoekCriteria += "&";
            zoekCriteria += 'Postalcode' + '=' + $('#txtPostPostcode').val();
        }        
        
        if($('#txtVestigingsWoonplaats').val().length > 0)
        {
            if(zoekCriteria != "")
                zoekCriteria += "&";
            zoekCriteria = 'City' + "=" + $('#txtVestigingsWoonplaats').val();
        }
        else if($('#txtPostWoonplaats').val().length > 0)
        {
            if(zoekCriteria != "")
                zoekCriteria += "&";
            zoekCriteria = 'City' + "=" + $('#txtPostWoonplaats').val();
        }
        
        if($('#txtKvKNr').val().length === 8)
        {
            if(zoekCriteria != "")
                zoekCriteria += "&";
            zoekCriteria += 'kvkNumber' + "=" + $('#txtKvKNr').val();
        }                
        
        //alert(zoekCriteria);
        
        getKvKData(zoekCriteria);
    });    

    $('#ddmKantoren').change(function()
    {
        if($('#ddmKantoren').val().length > 0)
            getKvKData('kvkNumber' + "=" + $('#ddmKantoren').val());
    });
    
    function getKvKData(zoekCriteria)
    {
        $.ajax({
            url: "https://api.kvk.nl/api/v2/testsearch/companies?" + zoekCriteria,
            method: "GET",
            contentType: "application/x-www-form-urlencoded",
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
                
                /*QUnit.test('KvK-API respons valideren op datatype NaN', function(assert) 
                {
                    assert.notEqual(response.length, NaN);
                }); 
                QUnit.test('KvK-API respons valideren op datatype string', function(assert) 
                {
                    assert.equal(response, string);
                }); 
                QUnit.test('KvK-API respons valideren op datatype object', function(assert) 
                {
                    assert.equal(response, object);
                }); 
                QUnit.test('KvK-API respons valideren op datatype null', function(assert) 
                {
                    assert.equal(response, null);
                });*/ 
            },
            timeout: 0,
            error: function (result, errormsg, errorThrown)
            {
                //alert(JSON.stringify(result));
                alert("HTTP-Statuscode: " + result["status"] + " - " + result["statusText"] + "\r\nMelding: " + result["responseJSON"]["message"]);
                //alert(errormsg);
                //alert(errorThrown);
                alert("Foutmelding KvK API: Geen kantoor gevonden in handelsregister.");
                
//                QUnit.test('KvK-API respons valideren op datatype NaN', function(assert) 
//                {
//                    assert.notEqual(result.length, NaN);
//                }); 
//                QUnit.test('KvK-API respons valideren op datatype string', function(assert) 
//                {
//                    assert.equal(result, string);
//                }); 
//                QUnit.test('KvK-API respons valideren op datatype object', function(assert) 
//                {
//                    assert.equal(result, object);
//                }); 
//                QUnit.test('KvK-API respons valideren op datatype null', function(assert) 
//                {
//                    assert.equal(result, null);
//                }); 
//                alert(JSON.stringify(result));
//                alert(errormsg + " - " + errorThrown);                
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
            switch(response["data"]["items"][0]["addresses"][1]["type"])
            {
                case "bezoekadres":
                    $('#txtBezoekPostcode').val(response["data"]["items"][0]["addresses"][1]["postalCode"]);
                    $('#txtBezoekadres').val(response["data"]["items"][0]["addresses"][1]["street"] + " "
                    + response["data"]["items"][0]["addresses"][1]["houseNumber"]);
                    $('#txtBezoekWoonplaats').val(response["data"]["items"][0]["addresses"][1]["city"]);
                    break;
                case "correspondentieadres":
                    $('#txtPostPostcode').val(response["data"]["items"][0]["addresses"][1]["postalCode"]);
                    $('#txtPostadres').val(response["data"]["items"][0]["addresses"][1]["street"] + " "
                    + response["data"]["items"][0]["addresses"][1]["houseNumber"]);
                    $('#txtPostWoonplaats').val(response["data"]["items"][0]["addresses"][1]["city"]);
                    break;
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

