<?php
	include("functies.php")
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
          <h2>Opdracht 92</h2>
			<!--Gemaakt op 2-12-2016 door Adam Oubelkas uit IO1E4-->
			<table border="1">
				<tr><th></th><th>Beschrijving</th><th>Bedrag</th><th>Totaal</th><th>BTW</th></tr>
				<?php
			
				$uur = 2;
				$uurprijs = 90;
				$btw = 21;
				$subtotaal = product($uur, $uurprijs);
				$btwbedrag = berekenBtw($btw, $subtotaal);
				$totaal = berekenTotaal($subtotaal, $btwbedrag);

				echo "<tr><td>$uur uur</td><td>Advieswerkzaamheden</td><td>&euro; $uurprijs</td><td>$subtotaal</td><td>$btw %</td></tr>";
				echo "<tr><td colspan = '2'></td><td>$subtotaal</td><td>$subtotaal</td></tr>";
				echo "<tr><td colspan='2'></td><td>21%BTW</td><td>$btwbedrag</td><td></td></tr>";
				echo "<tr><td colspan='2'></td><td>Totaal</td><td>$totaal</td><td></td></tr>";
				?>
			</table>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
