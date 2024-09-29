<!DOCTYPE html>
<html lang="en">
  <head>
    <link type="text/css" rel="stylesheet" href="../../css/style.css"/>
    <meta charset="utf-8" />
    <title>Opdrachten PHP periode 3</title>
    <script src="../../../../../../scripts/jquery-3.2.0.min.js"></script>
    <script src="../../../../../../scripts/Script.js"></script>
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
          <a href="../../../../../../index.html">
            Portfoliowebsite <br/> Adam Oubelkas
          </a>
        </h3>
        <ul>
          <li>
            <a href="../../../../../Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
          </li>
          <li>
            <a href="../../../../../Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
          </li>
          <li>
            <a href="../../../../../Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
          </li>
          <li>
            <a href="../../../../../Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
          </li>
        </ul>
      </nav>
      <div id="main">
        <div id="wrapper">
          <h2>Opdracht 20</h2>
          <p>
            <?php
                // declaring variabelen van woorden en namen

                $voornaam = "Adam";
                $achternaam = "Oubelkas";
                $leeftijd = "27 jaar";
                $woonplaats = "Raamsdonksveer.";
                $hobbies = "fitnessen, internetten, gamen en filosoferen.";
                $jongereBroers = "Anis en Elias.";
                $halfBroer = "Joseph Oubelkas.";
                $vervolgopleiding = "hbo - Informatica";
                $vervolgschool = "Avans Hogeschool.";
                $gewensteBeroep = "Back-End Developer/Web-developer";

                // declaring variabelen van zinnen

                $zin1 = "Mijn naam is $voornaam $achternaam, en ik ben $leeftijd oud.";
                $zin2 = "<br>";
                $zin3 = "Ik woon in $woonplaats";
                $zin4 = "<br>";
                $zin5 = "Mijn hobbies zijn $hobbies";
                $zin6 = "<br>";
                $zin7 = "Ik heb namelijk twee jongere broertjes: $jongereBroers";
                $zin8 = " En ik heb een oudere halfbroer: $halfBroer";
                $zin9 = "<br>";
                $zin10 = "Na succesvol afronden van mijn huidige opleiding ben ik van plan om $vervolgopleiding te volgen aan het $vervolgschool";
                $zin11 = "<br>";
                $zin12 = "Uiteindelijk wil ik een $gewensteBeroep worden.";

                //variabelen printen in browser

                echo $zin1 . $zin2 . $zin3 . $zin4 . $zin5 . $zin6 . $zin7 . $zin8 . $zin9 . $zin10 . $zin11 . $zin12 ;
				    ?>
          </p>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2024 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
