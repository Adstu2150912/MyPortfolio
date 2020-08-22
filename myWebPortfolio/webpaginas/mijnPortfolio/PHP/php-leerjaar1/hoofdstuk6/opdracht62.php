<?php
//php en html code gemaakt door Adam Oubelkas uit IO1E4

$getal = 13061997; // Neem je geboortedatum - 13 juni 1997 
//echo $getal;
//echo "<br>";
$leeftijd = 23; //Neem je leeftijd - 23 jaar
//echo $leeftijd;
//echo "<br>";
//$getal++; // $getal = 13061998
//echo $getal;
//echo "<br>";
//$getal /=$leeftijd; // $getal = $getal / $leeftijd = 687473.57894737
//echo $getal;
//echo "<br>";
//$getal = ceil($getal); //$getal = 687474 ($getal afgerond in hele getal (>= 0,45 = 1; < 0,45 = 0)) 
//echo $getal;
//echo "<br>";
//$getal--; //$getal = $getal - 1 = 687473
//echo $getal;
//echo "<br>";
//$getal +=50; //$getal = $getal + 50 = 687523
//echo $getal;
//echo "<br>";
//$getal /=3; //$getal = $getal / 3 = 229174.33333333
//echo $getal;
//echo "<br>";
//$getal = $getal % 15; //$getal = $getal rest 15 = 4
//echo $getal;
//echo "<br>";
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
      <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
