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
          <h2>Opdracht 41</h2>
          <p>
            <?php

            //Stringvariabel declareren

            $mop = "Weekend! Waarom gaat een Belg op vrijdag door het raam naar buiten? Het weekend staat voor de deur.";

            //Hier begint het eerste letter in de eerste positie en loopt daaruit acht letters af

            echo substr($mop,0,8)."<br>";

            //Hier begint het eerste letter in de vijfentwintigste positie en loopt daaruit 4 letters af

            echo substr($mop,25,4)."<br>";

            //Hier begint het eerste letter in de vierennegenste positie en loopt daaruit 4 letters af

            echo substr($mop,94)."<br>";

            //Hier begint het eerste letter in de negenste positie afgeteld vanuit het einde van de zin

            echo substr($mop,-90)."<br>";

            //Hier begint het eerste letter in de achtenzestigste positie en loopt daaruit 29 letters af

            echo substr($mop,68,29)."<br>";

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

