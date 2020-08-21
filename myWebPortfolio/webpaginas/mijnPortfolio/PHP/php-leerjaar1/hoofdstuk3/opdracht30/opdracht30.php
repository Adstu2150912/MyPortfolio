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
          <h2>Opdracht 30</h2>
          <p>
            <?php
              //declarering variabelen
    

              $collega1 = 'Ndubuisi';
              $collega2 = 'BartM';
              $collega3 = 'Mitchell';
              $collega4 = 'BartR';
              $collega5 = 'Henrico';
              $collega6 = 'Roy';
              $collega7 = 'Damian';
              $collega8 = 'Duncan';
              $collega9 = 'Hugo';
              $collega10 = 'Joep';

              $strlencollega1 = strlen($collega1);
              $strlencollega2 = strlen($collega2);
              $strlencollega3 = strlen($collega3);
              $strlencollega4 = strlen($collega4);
              $strlencollega5 = strlen($collega5);
              $strlencollega6 = strlen($collega6);
              $strlencollega7 = strlen($collega7);
              $strlencollega8 = strlen($collega8);
              $strlencollega9 = strlen($collega9);
              $strlencollega10 = strlen($collega10);


              //initialisering van variabelen samen met strings 

              echo "$collega6 (lengte $strlencollega6)";
              echo "<br>";
              echo "$collega9 (lengte $strlencollega9)";
              echo "<br>";
              echo "$collega10 (lengte $strlencollega10)";
              echo "<br>";
              echo "$collega2 (lengte $strlencollega2)";
              echo "<br>";
              echo "$collega4 (lengte $strlencollega4)";
              echo "<br>";
              echo "$collega7 (lengte $strlencollega7)";
              echo "<br>";
              echo "$collega8 (lengte $strlencollega8)";
              echo "<br>";
              echo "$collega5 (lengte $strlencollega5 )";
              echo "<br>";
              echo "$collega3 (lengte $strlencollega3)";
              echo "<br>";
              echo "$collega1 (lengte $strlencollega1)";
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

