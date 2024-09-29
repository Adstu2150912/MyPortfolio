<?php
//php en html code gemaakt door Adam Oubelkas uit IO1E4

$getal = 111997; // Neem je geboortedatum
$leeftijd = 27; //Neem je leeftijd - 27 jaar
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
          <h2>Opdracht 62</h2>
			<!--//php en html code gemaakt door Adam Oubelkas uit IO1E4-->
			<?php
				echo "<p>getal is $getal</p>";
				echo "<p>leeftijd = $leeftijd</p>";
				echo "<p>++getal = " . ++$getal . "</p>";
				echo "<p>getal /= leeftijd = " . ($getal / $leeftijd) . "</p>";
				echo "<p>getal = " . ceil($getal) . "</p>";
				echo "<p>--getal =" . --$getal . "</p>";
				echo "<p>getal += 50 = " . ($getal += 50) . "</p>";
				echo "<p>getal /= 3 = " . ($getal /= 3) . "</p>";
				echo "<p>getal = getal % 15 = getal rest 15 = " . ($getal % 15) . "</p>";
			?>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2024 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
