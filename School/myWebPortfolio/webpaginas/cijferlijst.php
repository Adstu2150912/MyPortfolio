<?php
  /*php-pagina met php functies*/
  include('../scripts/functies.php');
  /*sessie erbij halen*/
  session_start();
  /*if-elseconstructie*/
  if(isset($_SESSION['loggedIn']) == false){
      header('location: login.php');
  }
  else {
      if($_SESSION['loggedIn'] != true) {
          header('location: login.php');
  }
}
?>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Mijn cijferlijst</title>
        <link href="../css/schoollijst.css" rel="stylesheet" type="text/css">
        <script src="../scripts/jquery-3.2.0.min.js"></script>
        <script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Dit is mijn volledig cijferlijst").fadeIn(1000);
				$('section > #main').animate({ width: "80%", height: "100vh" }, 900);
            });
        </script>
    </head>
    <body>
        <header>            
            <h1></h1>
        </header>
		<nav>
			<h3><a href="../index.html">Portfoliowebsite <br/> Adam Oubelkas</a></h3>
            <ul>
                <li>
                    <a href="../webpaginas/Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
                </li>
                <li>
                    <a href="../webpaginas/Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
                </li>
                <li>
                    <a href="../webpaginas/Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
                </li>
                <li>
                    <a href="../webpaginas/Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
                </li>
            </ul>
        </nav>
        <section>         
            <div id="main">
                <div id="legenda">
					<p class="kolomA kolom1 ThreeColumnWidth">Vakken</p>
					<p class="kolomA kolom2 ThreeColumnWidth">Periodecijfers</p>
					<p class="kolomA kolom3 ThreeColumnWidth">Gemiddeldes</p>
				</div>
				<div id="gegevens">
					<div class="kolomB kolom1 ThreeColumnWidth">
						<p>HTML/CSS</p>
						<p>JavaScript/JQuery</p>
						<p>PHP</p>
						<p>ASP</p>
						<p>SQL</p>
						<p>HardwareAO</p>
						<p>Analyseren</p>
						<p>Nederlands</p>
						<p>Engels</p>
						<p>Rekenen</p>			
						<p>Loopbaan en Burgerschap (Let op! Hoogste haalbare cijfer = 7)</p>
						<p>Computertekenen (Let op! Hoogste haalbare cijfer = 7)</p>
						<p>Digitale Vaardigheden</p>
					</div>
					<div class="kolomB kolom2 ThreeColumnWidth">
						<p>8.4 - 7.5</p>
						<p>9.0 - 8.5 - 8.9</p>
						<p>7.0 - 6.8 - 8.2</p>
						<p>8.7</p>
						<p>7.3</p>
						<p>6.0 - 7.8</p>
						<p>7.5</p>
						<p>7.7 - 7.2 - 7.0</p>
						<p>8.3 - 8.5</p>
						<p>7.8 - 6.9 - 7.1</p>
						<p>7.0 - 7.0 - 7.0</p>
						<p>7.0 - 7.0 - 7.0</p>
						<p>7.5 - 7.2 - 8.0</p>
					</div>
					<div class="kolomB kolom3 ThreeColumnWidth">
						<p>8.0</p>
						<p>8.8</p>
						<p>7.3</p>
						<p>8.7</p>
						<p>7.3</p>
						<p>6.9</p>
						<p>7.5</p>
						<p>7.3</p>
						<p>8.4</p>
						<p>7.3</p>
						<p>7.0</p>
						<p>7.0</p>
						<p>7.6</p>
					</div>
				</div>
            </div>
        </section>
        <footer>
            <p>&copy 2024 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
        </footer>   
    </body>
</html>

