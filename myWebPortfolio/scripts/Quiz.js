$(document).ready(function () {
    $('header > h1').empty();
    $('header > h1').css('display', 'none');
    $('header > h1').append("Dit is een Quiz, gemaakt d.m.v. JQuery 3.1.1.").fadeIn(1000);
    $('header > h3 > a').empty('*');
    $('header > h3 > a').css('display', 'none');
    $('header > h3 > a').append("Portfoliowebsite - Adam Oubelkas <br> (Nog onder voorbehoud!)").fadeIn(1000);
    $('input[name="naamclient"]').focus();
    $('input[name="verstuurnaamClient"]').click(function () {
        var naamClient = $('input[name="naamclient"]').val();
        $('header > h1').empty();
        $('header > h1').css('display', 'none');
        $('header > h1').append("Welkom " + naamClient + ", bij de Quiz!").fadeIn(1000);
        $('#proloog').remove();
        $('#main > #spelregels').append('<h1>Dit zijn de spelregels:</h1>' + '<p>Er zijn 4 vragen in totaal</p>' + '<p>Dit zijn meerkeuzevragen over ICT</p>' +
        '<p>Per GOEDE antwoord krijg je 10 punten ERBIJ, en per FOUTE antwoord 3 punten ERAF <br> Aan het einde van deze Quiz krijg je het resultaat te zien met daarbij de vraag om een tweede poging te doen</p>' +
        '<p>Je mag maximaal 2 pogingen doen over heel de Quiz!</p>' + '<p>Je krijgt maximaal 5 seconden per vraag</p>' +
        '<p>Succes!!</p> <input type="button" value="Begrepen!">').fadeIn(1000).css('text-align', 'center');
        $('#spelregels > input').click(function () {
            var vragen = [vraag1 = { vraag: "Hoe heet Nintendo's nieuwste product?", antwoord: 'Nintendo Switch', optie1: 'Nintendo Swift', optie2: 'New Nintendo Wii', optie3: 'Nintendo Wii U', optie4: 'Nintendo Switch' },
                vraag2 = { vraag: "Welke computertaal is NIET front-end?", antwoord: 'PHP', optie1: 'HTML', optie2: 'JavaScript', optie3: 'PHP', optie4: 'CSS' },
                vraag3 = { vraag: "Wat is waar?", antwoord: 'Boolean is waar OF niet waar', optie1: 'Boolean is waar OF niet waar', optie2: 'False IS NIET gelijk aan False', optie3: 'True IS gelijk aan False', optie4: 'False heeft nooit geen waarde' },
                vraag4 = { vraag: "Welke component heeft een permanente opslagruimte?", antwoord: 'HDD', optie1: 'ODD', optie2: 'RAM', optie3: 'HDD', optie4: 'VRAM'}];
            $('#spelregels').remove();
            $('form[name="Quiz"] > h3').append(vragen = vraag4.vraag);
            $('form[name="Quiz"] > #optie1').after(vragen = vraag3.optie3);
            $('form[name="Quiz"]').fadeIn(800);
            var correcteAntwoorden = [];
            /*for (var i = 0; i < vragen.length; i++) {
                
                }
                $('form[name="Quiz"] > h3').append(vragen = vraag1.vraag);
            }*/



        });
        //Deze array hergebruiken voor for-loop
        var vragen = [vraag1 = { vraag: "Hoe heet Nintendo's nieuwste product?", antwoord: 'Nintendo Switch', optie1: 'Nintendo Swift', optie2: 'New Nintendo Wii', optie3: 'Nintendo Wii U', optie4: 'Nintendo Switch' },
                vraag2 = { vraag: "Welke computertaal is NIET front-end?", antwoord: 'PHP', optie1: 'HTML', optie2: 'JavaScript', optie3: 'PHP', optie4: 'CSS' },
                vraag3 = { vraag: "Wat is waar?", antwoord: 'Boolean is waar OF niet waar', optie1: 'Boolean is waar OF niet waar', optie2: 'False IS NIET gelijk aan False', optie3: 'True IS gelijk aan False', optie4: 'False heeft nooit geen waarde' },
                vraag4 = { vraag: "Welke component heeft een permanente opslagruimte?", antwoord: 'HDD', optie1: 'ODD', optie2: 'RAM', optie3: 'HDD', optie4: 'VRAM'}];
    });

});


    