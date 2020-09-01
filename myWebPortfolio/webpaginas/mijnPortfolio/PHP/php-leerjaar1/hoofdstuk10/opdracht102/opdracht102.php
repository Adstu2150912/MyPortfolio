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
          <h2>Opdracht 102</h2>
		  <?php
			include('functies.php');

			echo "De priemgetallen tot en met 23: " . "<br/><br/>";
			echo isPriem(0) . "<br/>";
			echo isPriem(1) . "<br/>";
			echo isPriem(2) . "<br/>";
			echo isPriem(3) . "<br/>";
			echo isPriem(4) . "<br/>";
			echo isPriem(5) . "<br/>";
			echo isPriem(6) . "<br/>";
			echo isPriem(7) . "<br/>";
			echo isPriem(8) . "<br/>";
			echo isPriem(9) . "<br/>";
			echo isPriem(10) . "<br/>";
			echo isPriem(11) . "<br/>";
			echo isPriem(12) . "<br/>";
			echo isPriem(13) . "<br/>";
			echo isPriem(14) . "<br/>";
			echo isPriem(15) . "<br/>";
			echo isPriem(16) . "<br/>";
			echo isPriem(17) . "<br/>";
			echo isPriem(18) . "<br/>";
			echo isPriem(19) . "<br/>";
			echo isPriem(20) . "<br/>";
			echo isPriem(21) . "<br/>";
			echo isPriem(22) . "<br/>";
			echo isPriem(23) . "<br/>";
			?>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
