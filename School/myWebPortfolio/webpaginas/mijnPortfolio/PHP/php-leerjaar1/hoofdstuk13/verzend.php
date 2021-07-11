<?php
/**
 * Created by PhpStorm.
 * User: Appie97
 * Date: 2/10/2017
 * Time: 10:06 AM
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
				<!--print waarde 'naam', vanuit opdracht131.php, via GET parameter uit-->
				<h2>Opdracht 131 - Rapport <?php echo $_GET['naam']?></h2>
				<!--print waardes 'vak','naam','klas', 'vakcijfer', 'cijfer' uit, vanuit opdracht131.php, via GET parameter-->
				<p>Voor het vak <?php echo $_GET['vak']?> heeft <?php echo $_GET['naam']?> uit klas <?php echo $_GET['klas']?> het cijfer <span id="vakcijfer"><?php echo $_GET['cijfer']?></span> gehaald.</p>
			</div>
		</div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
        </footer>
	</body>
</html>
