<?php
/**
 * Created by PhpStorm.
 * User: Appie97
 * Date: 2/10/2017
 * Time: 9:57 AM
*/
?>

<?php
DEFINE("LEVEL","../");
include LEVEL."includes/functies.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/css" rel="stylesheet" href="../css/style.css">
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
			<h3><a href="../../../../../index.html">Portfoliowebsite <br/> Adam Oubelkas</a></h3>
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
				<h2>Opdracht 131</h2>
				<!--Gemaakt op 10 februari 2017 door Adam Oubelkas uit IO1E4-->
				<!--Als dit formulier is ingevuld en op de submit knop gedrukt is,
				wordt het verzonden naar 'verzend.php' waarin je de visuele weergave in kan zien-->
				<form method="get" action="verzend.php">
					<label>Naam: </label>
					<input type="text" name="naam" value="">
					<br>
					<label>Klas: </label>
					<input type="text" name="klas" value="">
					<br>
					<label>Leerlingnummer: </label>
					<input type="text" name="leerlingnummer" value="">
					<br>
					<label>Vak:</label>
					<select name='vak'>
						<option value='PHP'>PHP</option>
						<option value='javascript'>Javascript</option>
						<option value='ASP'>ASP</option>
						<option value='SQL'>SQL</option>
					</select>
					<br>
					<label>Cijfer: </label>
					<input type="number" name="cijfer" value="">
					<br>
					<input type="submit" name="verzend" value="Verzend">
				</form>
			</div>
		</div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
        </footer>
	</body>
</html>