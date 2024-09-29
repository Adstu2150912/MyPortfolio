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
          <h2>Opdracht 71</h2>
			<p>
				<?php
					/*Standaard waarde*/

					$allrisk = "Je hebt allrisk gekozen <br>";

					/*Als er geen waarde is ingevoerd door client, geef standaard waarde*/

					if(isset($_GET['verzekering'])){
						$verzekering = $_GET["verzekering"] ;
					}
					else {
	
						$verzekering = 	"Je hebt allrisk gekozen";
	
						echo $allrisk;
	
						}

					//variabelen verzekeringstypes declareren en initializeren

					$WA =					"Je hebt WA gekozen <br>
											<hr>
											Je bent verzekerd tegen: <br> 
											<hr>
											Schade aan anderen <br>
											<hr>
											Je bent niet verzekerd tegen: <br>
											<hr>
											Schade door brand, storm en natuur <br> 
											Ruitschade <br>
											Diefstal <br>
											Schade door aanrijding en overige schade <br>";


					$WACascobeperkt = "Je hebt WA + Casco beperkt gekozen <br>
											<hr>
											Je bent verzekerd tegen: <br> 
											<hr>
											Schade aan anderen <br>
											Schade door brand, storm en natuur <br> 
											Ruitschade <br>
											Diefstal <br>
											<hr>
											Je bent niet verzekerd tegen: <br>
											<hr>
											Schade door aanrijding en overige schade <br>";

					$WACascoALLRISK = "Je hebt WA + Casco + ALLRISK gekozen <br>
											<hr>
											Je bent verzekerd tegen: <br> 
											<hr>
											Schade aan anderen <br>
											Schade door brand, storm en natuur <br> 
											Ruitschade <br>
											Diefstal <br>
											Schade door aanrijding en overige schade <br>
											<hr>";

					//if statements uitvoeren om te bepalen of deze waardes wel of niet worden uitgeprint

					if ($verzekering == "WA" ) 
					{
						echo $WA;
					}

					if ($verzekering == "WACascobeperkt" ) 
					{
						echo $WACascobeperkt;
					}

					if ($verzekering == "WACascoALLRISK" ) 
					{
						echo $WACascoALLRISK;
					}
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
