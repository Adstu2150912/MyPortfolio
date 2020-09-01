

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
          <h2>Opdracht 100</h2>
		  <?php

			//Variabel gekoppeld met array van cijfers
			$cijfers = array(7.5, 7.0, 5.0, 8.4, 9.0, 7.0, 3.0, 1.8, 8.3, 7.8, 7.0);
			//$aantal telt het aantal cijfers in array $cijfers
			$aantal = count($cijfers);
			//Pas achteraf wordt hoogste getal opgeslagen van array $cijfers 
			$max = 0;
			//Pas achteraf wordt laagste getal opgeslagen van array $cijfers
			$min;
			//Alle indexes/indices langs gaan vanuit eerste positie
			$tel = 0;
			//Alle arraywaardes vooraf opgeteld en hierin opgeslagen
			$totaalsom = 0;
	 

			//Deel A Aantal cijfers benoemen
			echo "Ik heb " . $aantal . " cijfers gehaald" . "<br>";

			//Deel B Cijferlijst weergeven door while loop
			echo "Mijn cijfers zijn: ";

			while($tel < $aantal){
					echo $cijfers[$tel];
					echo ", ";
					$tel++;
				}
			//Deel C Hoogste cijfer opnoemen door $tel = 0 en if statement herhalen tot laatste positie 
			echo "<br>";
			$tel = 0;

			while($tel < $aantal){
				if($cijfers[$tel] > $max){
					$max = $cijfers[$tel];
					}
					$tel++;
				}
				echo "Mijn hoogste cijfer: " . $max ."<br>";

			//Deel D laagste cijfer
			$tel = 0;
			//Vergelijking doen om laagste waarde op te halen
			$max;

			while($tel < $aantal){
				if($cijfers[$tel] < $max){
					$max = $cijfers[$tel];
					$min = $max;
				}
	
				$tel++;

			}

			echo "Mijn laagste cijfer: " . $min . "<br>";

			//Deel E gemiddelde weergeven met twee decimalen
			$tel = 0;

			while ($tel < $aantal) {
				$cijfers[$tel];
				$totaalsom += $cijfers[$tel];
				$tel++;
			}

			echo "Mijn gemiddelde is: " . round(($totaalsom/11), 2) . "<br>";

			//Deel F aantal onvoldoendes waarbij alles < 6 onvoldoende is

			$tel = 0;
			$onvoldoendes = 0;
			while($tel < $aantal) {
	
				if($cijfers[$tel] < 6){
					$onvoldoendes++;
				}
				$tel++;
			}

			echo "Aantal onvoldoendes: " . $onvoldoendes;
		?>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
