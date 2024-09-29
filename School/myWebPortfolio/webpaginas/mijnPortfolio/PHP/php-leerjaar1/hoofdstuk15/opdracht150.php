<?php
/**
 * Created by PhpStorm.
 * User: Adam Oubelkas
 * Date: 3/7/2017
 * Time: 12:45 PM
 */
?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
      <meta charset="utf-8" />
      <title>Opdrachten PHP periode 3</title>
      <script src="../../../../../scripts/jquery-3.2.0.min.js"></script>
      <script src="../../../../../scripts/Script.js"></script>
      <script>
        $(document).ready(function () {
        $('header > h1').empty('*');
        $('header > h1').css('display', 'none');
        $('header > h1').append("Hier treft u een uitgewerkte opdracht uit mijn eerste mbo leerjaar").fadeIn(1000);
        $('section > nav > h3 > a').empty();
        $('section > nav > h3 > a').css('display', 'none');
        $('section > nav > h3 > a').append("Portfoliowebsite <br/> Adam Oubelkas").fadeIn(1000);
        $('section > #main').animate({width: "80%", height: "100vh"}, 900);
        });
      </script>
    </head>
  <body>
    <header>
      <h1></h1>
    </header>
    <section>
      <nav>
        <h3>
          <a href="../../../../../index.html">
            Portfoliowebsite <br/> Adam Oubelkas
          </a>
        </h3>
        <ul>
          <li>
            <a href="../../../../Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
          </li>
          <li>
            <a href="../../../../Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
          </li>
          <li>
            <a href="../../../../Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
          </li>
          <li>
            <a href="../../../../Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
          </li>
        </ul>
      </nav>
      <div id="main">
        <div id="wrapper">
          <h2>Opdracht 150</h2>
            <?php
            //Bijhorende club per speler
            $aClubs = array("Jörgensen"=>"Feyenoord"
            ,"Ghoochannejhad"=>"sc Heerenveen"
            ,"Armenteros"=>"Heracles"
            ,"Weghorst"=>"AZ"
            ,"Dolberg"=>"Ajax"
            ,"ünal"=>"FC Twente"
            ,"v.Wolfswinkel"=>"Vitesse"
            ,"Klaassen"=>"Ajax"
            ,"Mahi"=>"FC Groningen"
            ,"Sol"=>"Willem"
            ,"Baker"=>"Vitesse"
            ,"Haller"=>"FC Utrecht"
            ,"Pereiro"=>"PSV");
            //Aantal doelpunten per speler
            $aDoelpunten = array("Jörgensen" => 15
            ,"Ghoochannejhad" => 13
            ,"Armenteros" => 10
            ,"Weghorst" => 10
            ,"Dolberg" => 10
            ,"ünal" => 10
            ,"v.Wolfswinkel" => 10
            ,"Klaassen" => 10
            ,"Mahi" => 9
            ,"Sol" => 9
            ,"Baker" => 9
            ,"Haller" => 9
            ,"Pereiro" => 8);
            //Aantal wedstrijden per speler
            $aWedstrijden = array(
                "Jörgensen" => 22
                ,"Ghoochannejhad" => 23
                ,"Armenteros" => 17
                ,"Weghorst" => 19
                ,"Dolberg" => 21
                ,"ünal" => 21
                ,"v.Wolfswinkel" => 21
                ,"Klaassen" => 21
                ,"Mahi" => 20
                ,"Sol" => 20
                ,"Baker" => 21
                ,"Haller" => 23
                ,"Pereiro" => 21
            );

            //Array voor Opdracht 150 deel 3
            $aClubDoelpunten = array();

            //Variabelen voor if- else statements
            $hoogstedoelpuntgemiddelde = 0;
            $FC_ClubTotaal = 0;
            $hoogstedoelpunten = 0;

            foreach ($aClubs as $key => $value) {
                //Opdracht 150 deel 1
                //bepaal welke speler hoogste doelpuntgemiddelde heeft
                //door aantal doelpunten te delen door aantal wedstrijden
                if (($aDoelpunten[$key] / $aWedstrijden[$key]) > $hoogstedoelpuntgemiddelde) {
                    $hoogstedoelpuntgemiddelde = ($aDoelpunten[$key] / $aWedstrijden[$key]);
                    $bestespeler = $key;
                }
                echo $key . " scoorde " . $aDoelpunten[$key] . " in " . $aWedstrijden[$key] . " wedstrijden. En dus heeft hij een doelpuntgemiddelde van " . ($aDoelpunten[$key] / $aWedstrijden[$key]) . "<br>";

                //Opdracht 150 deel 3
                //bepaal het totaal aan doelpunten van spelers van clubs die beginnen met FC
                if(substr($value, 0, 2) == "FC"){
                    $FC_ClubTotaal += $aDoelpunten[$key];
                }
                //Opdracht 150 deel 2
                //Bepaal welke club meeste doelpunten heeft
                if(isset($aClubDoelpunten[$value])){
                    $aClubDoelpunten[$value] += $aDoelpunten[$key];
                }
                else {
                    $aClubDoelpunten[$value] = $aDoelpunten[$key];
                }
            }
            //Opdracht 150 deel 2
            //Vergelijken welke club de meeste doelpunten heeft
            foreach ($aClubDoelpunten as $club => $doelpunten) {   
            if ($doelpunten > $hoogstedoelpunten) {
                    $hoogstedoelpunten = $doelpunten;
                    $besteclub = $club;
               }
                echo "<br>" . "Club " . $club . " heeft " . $doelpunten . " doelpunten gemaakt.";
            }
                echo "<hr>" . "Conclusie" . "<hr>". "speler " . $bestespeler . " heeft het hoogste doelpuntgemiddelde.";
                echo "<br>" . "club " .  $besteclub . " heeft de meeste doelpunten gescoord.";
                echo "<br>" . "alle FC clubs hebben samen in totaal " . $FC_ClubTotaal . " doelpunten.";
            ?>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2024 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>