$(document).ready(function () {
    //bewaar hieronder de willekeurige getal als bepalend factor voor het selecteren van een quizvraag
    //Hierdoor kan de gebruiker bij elke bezoek van deze quiz een andere volgorde aan vragen krijgen
    var ranNum;
    //bewaar hieronder voor de gebruiker de huidige score 
    //waarvan de punten bijkomen of erafgaan afhankelijk van juistheid antwoorden van de gebruiker
    var huidigeScore = 0;

    //Onderstaande zijn alle vragen die de gebruiker moet beantwoorden in de quiz om punten voor eigen score te verzamelen
    var vragen = [vraag1 = { vraag: "Hoe heet Nintendo's nieuwste product?", antwoord: 'Nintendo Switch', optie1: 'Nintendo Swift', optie2: 'New Nintendo Wii', optie3: 'Nintendo Wii U', optie4: 'Nintendo Switch' },
    vraag2 = { vraag: "Welke computertaal is NIET front-end?", antwoord: 'PHP', optie1: 'HTML', optie2: 'JavaScript', optie3: 'PHP', optie4: 'CSS' },
    vraag3 = { vraag: "Wat is waar?", antwoord: 'Boolean is waar OF niet waar', optie1: 'Boolean is waar OF niet waar', optie2: 'False IS NIET gelijk aan False', optie3: 'True IS gelijk aan False', optie4: 'False heeft nooit geen waarde' },
    vraag4 = { vraag: "Welke component heeft een permanente opslagruimte?", antwoord: 'HDD', optie1: 'ODD', optie2: 'RAM', optie3: 'HDD', optie4: 'VRAM' }];

    $('header > h1').empty();
    $('header > h1').css('display', 'none');
    $('header > h1').append("Dit is een Quiz, gemaakt d.m.v. JQuery 3.1.1.").fadeIn(1000);
    $('header > h3 > a').empty('*');
    $('header > h3 > a').css('display', 'none');
    $('header > h3 > a').append("Portfoliowebsite - Adam Oubelkas <br> (Nog onder voorbehoud!)").fadeIn(1000);
    $('input[name="naamclient"]').focus();

    //Leg de spelregels voor de Quiz uit aan de gebruiker
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

        //Als de gebruiker de spelregels begrijpt, kan de Quiz beginnen door onderstaande knop te laten klikken
        $('#spelregels > input').click(function () {
            $('#spelregels').remove();
            ranNum = Math.floor((Math.random() * vragen.length) + -1);
            $('form[name="quizForm"] > h3').append(vragen = vragen[ranNum].vraag);
            for (i = 0; i < vragen[ranNum].length; i++) {
                $('form[name="quizForm"] > #optie' + ranNum).after(vragen = vragen[ranNum][i]);
            }
            vragen.splice(ranNum, 1);
            $('form[name="quizForm"]').fadeIn(800);
        });
    });

    //Als een vraag uit een Quiz is beantwoord, verwijs de gebruiker dan naar de volgende vraag
    //Dit gaat net zo lang door totdat alle vragen zijn beantwoord of de tijd voorbij
    $('input[name="meerkeuzevraag"]').change(function () {
        //Haal de waarde van de geselecteerde antwoorde op 
        document.querySelector('input[name="meerkeuzevraag"]:checked').value;

        //Maak alvast heel het formulier leeg ter voorbereiding van de eventuele volgende vraag
        $('form[name="quizForm"] > h3').empty();

        for (i = 0; i < vragen[ranNum].length; i++) {
            $('form[name="quizForm"] > #optie' + ranNum).empty();
        }

        //Als nog niet alle vragen door de gebruiker zijn beantwoord, laat de quiz dan doorgaan
        //Zo wel, dan is de quiz afgelopen en moet een totaaloverzicht van vragen, punten en score aan de gebruiker getoond worden
        if (vragen.length > 0) {
            ranNum = Math.floor((Math.random() * vragen.length) + -1);
            $('form[name="quizForm"] > h3').append(vragen = vragen[ranNum].vraag);
            for (i = 0; i < vragen[ranNum].length; i++) {
                $('form[name="quizForm"] > #optie' + ranNum).after(vragen = vragen[ranNum][i]);
            }
            vragen.splice(ranNum, 1);
            $('form[name="quizForm"]').fadeIn(800);
        }
        else
        {
        }
    });

});


    