<?php
/**
 * Created by PhpStorm.
 * User: Adam Oubelkas
 * Date: 3/8/2017
 * Time: 1:36 PM
 */
DEFINE("LEVEL","../");
include LEVEL."includes/functies.php";
include LEVEL."includes/kaarten.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/css" rel="stylesheet" href="../css/style.css">
    <meta charset="utf-8" />
    <title>Opdrachten PHP periode 3</title>
	<script src="../../../../../scripts/jquery-3.2.0.min.js"></script>
	<script src="../../../../../scripts/Script.js"></script>
    <script src="../includes/js/trekKaart.js'"></script>
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
	<style>
        <?php
        $tel=0;
        while ($tel < count($aNumbers)) {
            echo "\n.".$aNumbers[$tel]." { background-position-x: -". ($tel)*79 ."px; }";
            $tel++;
        }
        ?>
    </style>
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
				<h1>Opdracht 160: Black Jack</h1>
				<!--Geef hier het maximale bedrag dat kan worden besteedt-->
				<h2 id="userSaldo">Uw saldo: €<?php echo $_SESSION['userSaldo'];?></h2>
				<?php
					echo "<div id='dealer' style='position:relative'>";
					$deg = -45;
					while ($tel < 52) {
						//echo "<p class='blind' style='left:". $tel*4 ."px; transform: rotate(". $deg ."deg)'></p>";
						echo "<p class='blind' style='left:". $tel*4 ."px'></p>";
						//$deg = -45 + ($tel * 90/52);
						$tel++;
					}
					echo "</div>";
					$totaal = 0;
					echo "<div class='game'>";
					//Start van het spel; trek 2 kaarten
					if ($_SESSION['nieuwspel']) {
						echo "<hr>";
						// trek 2 kaarten
						$kaart = trekKaart();
						$kaart = trekKaart();
						$_SESSION['nieuwspel'] = false;
					} // trek 1 kaart
					elseif (isset($_GET['trek']) && !$_SESSION['nieuwspel']) {
						echo "<hr>";
						printGetrokkenKaarten();
						$kaart = trekKaart();
					}
					elseif (isset($_GET['opnieuw'])) {
						echo "<hr>";
						resetSpel();
						header ('location: opdracht160.php');
						//Bereken nieuw willekeurig bedrag wanneer het spel opnieuw begint
						$_SESSION['userSaldo'] = rand(1,100);
					}
					//Als een bedrag is ingezet, kijk dan of het ingevoerde bedrag valide is
					elseif (isset($_GET['inzet'])){
						echo "<hr>";
						//ververs het bedrag
							$_SESSION['userSaldo'] -= $_GET['bedrag'];

						echo "\n<script language='JavaScript'>$(document).ready(function () { $(\".game > form > label\").after(\"<input type='submit' name='trek' value='Trek nog een kaart'>\"); });</script>\n";
						printGetrokkenKaarten();
						//Als speler meer inzet dan huidige saldo, geef dan onderstaande waarschuwing
						if($_GET['bedrag'] > $_SESSION['userSaldo']){
							 echo "<h1>Onvoldoende saldo!" . "<br>" . "Het bedrag dat uw heeft ingezet is meer dan uw huidige saldo!</h1>";
							 echo "<br>" . "<hr>";
						}
						//Als speler geen valide bedrag boven 0 euro invoert, geef dan onderstaande waarschuwing
						elseif ($_GET['bedrag'] <= 0){
							echo "<h1>Ongeldige invoerbedrag!" . "<br>" . "Voer een bedrag méér dan €0 in!</h1>";
							echo "<br>" . "<hr>";
						}
					}
					//Passen en nu is het de beurt aan de computer
					else {


						printGetrokkenKaarten();
						//TODO
						//....
						echo "<script language='JavaScript'></script>";

            
					}
					echo "<form method='get'>";
					echo "<label> Totale score: " . $_SESSION['totaalspeler'] . "</label>";
					//echo "<input type='submit' name='trek' value='".$_SESSION['totaalspeler']." Trek nog een kaart'>";
					echo "<input type='number' name='bedrag'>";
					echo "<input type='submit' name='inzet' value='Zet bedrag in'>";
					echo "<input type='submit' name='pas' value='Pas'>";
					echo "<input type='submit' name='opnieuw' value='Reset'>";
					echo "</form>";
					echo "</div>";
				?>
			</div>
		</div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
        </footer>
	</body>
</html>