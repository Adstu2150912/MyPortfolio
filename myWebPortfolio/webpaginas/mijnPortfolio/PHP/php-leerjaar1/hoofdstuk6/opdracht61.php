<?php
    
//php en html code gemaakt door Adam Oubelkas uit IO1E4

//Met $_GET parameter variabelen initializeren
$getal1 = $_GET['getal1'];
$getal2 = $_GET['getal2'];

//Met isset()functie voorkom je foutmeldingen
if (isset($_GET['getal1'])) {

    $naam = $_GET['getal1'];
} else {

    $naam = "getal2";
} 

if (isset($_GET['getal2'])) {

    $naam = $_GET['getal2'];
} else {

    $naam = "getal1";
} 

//Waarde $getal1 en $getal2 in een string  
//echo "getal1 is $getal1";
//echo "<br>";
//echo "getal2 is $getal2";

//echo "<hr>";
//de verschillende rekenkundige operatoren
$plus = "$getal1 + $getal2 = " . $getal1 + $getal2;
$min = " $getal1 - $getal2 = " . $getal1 - $getal2;
$keer = " $getal1 * $getal2 = " . $getal1 * $getal2;
$delen = " $getal1 / $getal2 = " . $getal1 / $getal2;
$modulus = " $getal1 % $getal2 = " . $getal1 % $getal2;
$machtgetal1 = " $getal1 tot de macht $getal2 = " . pow($getal1, $getal2);
$machtgetal2 = " $getal2 tot de macht $getal1 = " . pow($getal2, $getal1);

//Waardes variabelen waarvan gebruik operatoren uitprinten
//echo "<br>".$plus;
//echo "<br>".$min;
//echo "<br>".$keer;
//echo "<br>".$delen;
//echo "<br>".$modulus;
//echo "<br>".$machtgetal1;
//echo "<br>".$machtgetal2;
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
          <h2>Opdracht 61</h2>
            <!--php en html code gemaakt door Adam Oubelkas uit IO1E4-->
			<?php
				echo "<p>getal1 is " . $getal1 . "($getal1)</p><br/>";
				echo "<p>getal2 is " . $getal2 . "($getal2)</p><br/><hr/><br/>";
				echo "<p>$getal1 + $getal2 = (" . $getal1 . " + " . $getal2 . " =) " . ($getal1 + $getal2) . "</p>";	
				echo "<p>$getal1 - $getal2 = (" . $getal1 . " - " . $getal2 . " =) " . ($getal1 - $getal2) . "</p>";
				echo "<p>$getal1 x $getal2 = (" . $getal1 . " * " . $getal2 . " =) " . ($getal1 * $getal2) . "</p>";
				echo "<p>$getal1 : $getal2 = (" . $getal1 . " / " . $getal2 . " =) " . ($getal1 / $getal2) . "</p>";
				echo "<p>$getal1 rest $getal2 = (" . $getal1 . " % " . $getal2 . " =) " . ($getal1 % $getal2) . "</p>";
			?>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>

