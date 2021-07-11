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
          <h2>Opdracht 10</h2>
          <p>
            <?php
              // variabelen declareren
              $naam = 'Adam Oubelkas'; // de waarde 'Adam Oubelkas' is een string (tekenreeks).
              $leeftijd = 23; // de waarde 23 is van het type getal. 
              $woonplaats = 'Raamsdonksveer.'; //de waarde 'Raamsdonksveer.' is een string.
              $hobbies = 'fitnessen, internetten, gamen en filosoferen.';//de waarde 'fitnessen, internetten, gamen en filosoferen.' is een string.
              $aantalBroers = 3; //de waarde 3 is van het type getal.
              $broers = 'Anis en Elias.'; //de waarde "Anis en Elias." is van het type getal.
              $halfbroer = 'Joseph Oubelkas.'; //de waarde 'Joseph Oubelkas.' is een string (tekenreeks).
              $vervolgopleiding = 'hbo - Informatica'; // de waarde 'hbo - Informatica' is een string (tekenreeks).
              $vervolgschool = 'Avans Hogeschool.'; // de waarde 'Avans Hogeschool.' is een string (tekenreeks).
              $gewensteBeroep = 'Back-End developer/Mobiele applicatiedeveloper'; //de waarde 'Back-End developer/Mobiele applicatiedeveloper' is een string (tekenreeks).


              // strings met variabelen printen in browser 
              echo 'Mijn naam is ' . $naam . ', en ik ben ' . $leeftijd . ' jaar oud.';
              echo '<br>';
              echo ' Ik woon in ' . $woonplaats ;
              echo '<br>';
              echo ' Mijn hobbies zijn ' . $hobbies ;
              echo '<br>';
              echo ' Ik heb ' . ' namelijk twee jongere broertjes: ' . $broers . ' En een halfbroer: ' . $halfbroer ;
              echo '<br>';
              echo 'Na succesvol afronden van mijn huidige opleiding ben ik van plan om ' . $vervolgopleiding . ' te volgen aan het ' . $vervolgschool;
              echo '<br>';
              echo 'Uiteindelijk wil ik een ' . $gewensteBeroep . ' worden.'; 
				    ?>
          </p>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html> 
