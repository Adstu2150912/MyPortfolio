
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
          <h2>Opdracht 81</h2>
			<p>
			<!--Gemaakt op 25/11/2016 door Adam Oubelkas uit IO1E4-->
				<?php
					//teller (1,2,3,4,5,6,7,8,9,10) ophogen zodat de loop stopt bij 10
					$teller = 1;
					//variabel voor de bijhorende tafel
					$tafel = 1;
					//printen van de tabelkop
					echo "<table border='1' style='float: left;'>
					<tr><th colspan='2'>Tafel van $tafel</th></tr>";
            
					//de tafel van 5 in rijen en cellen printen    
					while ($tafel < 11) {
					//twee cellen per rij uitprinten totdat er 10 rijen zijn 
							if($teller < 11){
							$uitkomst = $teller * $tafel;
							echo "<tr><td>$teller</td><td>$uitkomst</td></tr>";
							$teller++;
							}
					//Wanneer er 10 rijen zijn gemaakt voor 1 tabel, begin met nieuw tabel
							elseif($teller >= 11){
							echo "</table>";
							$tafel++;
							if($tafel < 11){
							echo "<table border='1' style='float: left;'>
					<tr><th colspan='2'>Tafel van $tafel</th></tr>";
                        
							$teller = 1;
							}
							}     
					}
					//afsluiten van de tabel
					echo    '</table>';
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
