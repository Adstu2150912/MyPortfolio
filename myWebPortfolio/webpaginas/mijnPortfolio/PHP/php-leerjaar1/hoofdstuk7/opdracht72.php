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
          <h2>Opdracht 72</h2>
			<p>
			<?php
				//Met isset functie een default waarde geven wanneer geen waarde door client wordt opgegeven

				if (isset($_GET['aantalpersonen']))
				{
					$aantalpersonen = $_GET['aantalpersonen'];
				}
				else 
				{
					$aantalpersonen = 1;
				}
				if (isset($_GET['bezoeksnummer']))
				{
					$bezoeksnummer = $_GET['bezoeksnummer'];
				}
				else
				{
					$bezoeksnummer = 1;
				}

				//Hier wordt d.m.v. if en else statements vergelijkt welke waardes teruggegeven moet worden

				//Wanneer aantal personen en als bezoeksnummer gelijk is aan 1 print 35% korting uit
				if ($aantalpersonen == 1)
				{
					if ($bezoeksnummer == 1)
					{
						echo "Aantal personen op één pas: <br> <hr>";
						echo "$aantalpersonen <br> <hr>";
						echo "Korting bezoek $bezoeksnummer :<br> <hr>";
						echo "35% <hr>";
					}
				}

				/*Wanneer aantal personen gelijk is aan-/of groter is dan 1 
				en ook bezoeksnummer gelijk is aan-/of groter is dan 2 print 10% korting uit*/
				/*Maar bezoeksnummer moet NIET gelijk zijn aan 5*/
				/*else*/ if ($aantalpersonen >= 1  && $bezoeksnummer >= 2 )
				{
					if ($bezoeksnummer <> 5)
					{
						echo "Aantal personen op één pas:<br> <hr>";
						echo "$aantalpersonen <br> <hr>";
						echo "Korting bezoek $bezoeksnummer :<br> <hr>";
						echo "10% <hr>";
					}
				}

				//Wanneer aantal personen gelijk is aan 5 en wanneer bezoeksnummer gelijk is aan 5
				//print dan 20% korting uit
				/*else*/ if ($aantalpersonen == 5)
				{
					if ($bezoeksnummer == 5)
					{
						echo "Aantal personen op één pas:<br> <hr>";
						echo "$aantalpersonen <br> <hr>";
						echo "Korting bezoek $bezoeksnummer :<br> <hr>";
						echo "20% <hr>";
					}
				}

				//Wanneer aantal personen gelijk is aan 4 en ook bezoeksnummer gelijk is aan 5 
				//print dan 30% korting uit
				/*else*/ if ($aantalpersonen == 4 && $bezoeksnummer == 5)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "30% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 3 en ook bezoeksnummer gelijk is aan 5
				//print dan 33% korting uit
				/*else*/ if ($aantalpersonen == 3 && $bezoeksnummer == 5)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "33% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 2 en ook bezoeksnummer gelijk is aan 5
				//print dan 50% korting uit
				/*else*/ if ($aantalpersonen == 2 && $bezoeksnummer == 5)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "50% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 1 en ook bezoeksnummer gelijk is aan 5
				//print dan 50% korting uit
				/*else*/ if ($aantalpersonen == 1 && $bezoeksnummer == 5)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "50% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 6 en ook bezoeksnummer gelijk is aan 5
				//print dan 16,66% korting uit
				/*else*/ if ($aantalpersonen == 6 && $bezoeksnummer == 5)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "16,66% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 6 en ook bezoeksnummer gelijk is aan 1
				//print dan 15% korting uit
				/*else*/ if ($aantalpersonen == 6 && $bezoeksnummer == 1)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "15% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 5 en ook bezoeksnummer gelijk is aan 1
				//print dan 20% korting uit
				/*else*/ if ($aantalpersonen == 5 && $bezoeksnummer == 1)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "20% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 4 en ook bezoeksnummer gelijk is aan 1
				//print dan 25% korting uit
				/*else*/ if ($aantalpersonen == 4 && $bezoeksnummer == 1)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "25% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 3 en ook bezoeksnummer gelijk is aan 1
				//print dan 30% korting uit
				/*else*/if ($aantalpersonen == 3 && $bezoeksnummer == 1)
				{
					echo "Aantal personen op één pas:<br> <hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "30% <hr>";
				}

				//Wanneer aantal personen gelijk is aan 2 en ook bezoeksnummer gelijk is aan 1
				//print dan 35% korting uit
				/*else*/ if ($aantalpersonen == 2  && $bezoeksnummer == 1)
				{
					echo "Aantal personen op één pas:<br><hr>";
					echo "$aantalpersonen <br> <hr>";
					echo "Korting bezoek $bezoeksnummer :<br> <hr>";
					echo "35% <hr>";
				}
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
