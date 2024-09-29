<?php
  /*php-pagina met php functies*/
  DEFINE("LEVEL","./");
  include('../../../../scripts/functies.php');
  include('includes/functies.php');
  /*sessie erbij halen*/
  session_start();
  /*if-elseconstructie*/
  if(isset($_SESSION['loggedIn']) == false){
      header('location: ../../../login.php');
  }
  else {
      if($_SESSION['loggedIn'] != true) {
          header('location: ../../../login.php');
      }
  }
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <meta charset="utf-8" />
        <title>Opdrachten overzicht PHP mbo leerjaar 1</title>
		<script src="../../../../scripts/jquery-3.2.0.min.js"></script>
		<script src="../../../../scripts/Script.js"></script>
        <script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Hier treft u een overzicht van alle verwijzingen naar alle in mbo leerjaar 1 uitgewerkte PHP opdrachten").fadeIn(1000);
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
				<h3><a href="../../../../index.html">Portfoliowebsite <br/> Adam Oubelkas</a></h3>
                <ul>
                    <li>
                        <a href="../../../Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
                    </li>
                    <li>
                        <a href="../../../Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
                    </li>
                    <li>
                        <a href="../../../Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
                    </li>
                    <li>
                        <a href="../../../Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
                    </li>
                </ul>
            </nav>
            <div id="main">
				<div id="wrapper">
					<ul>
						<?php
							printOpdrachten();
						?>
					</ul>
				</div>
			</div>
        </section>
        <footer>
            <p>&copy 2024 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
        </footer>
    </body>
</html>
