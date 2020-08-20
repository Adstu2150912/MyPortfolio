<?php
//reeks met diverse fruitsoorten met bijhorende kenmerken
$aFruits = array(
    'appel' => "https://nl.wikipedia.org/wiki/Appel_(vrucht)"
    ,'peer' => 'sappig'
    ,'sinaasappel' => 'zuur'
    ,'kiwi' => 'gezond'
    ,'banaan' => 'zoet'
    ,'meloen' => 'heerlijk'
    ,'kersen' => 'zalig'
);

?>

<?php
DEFINE("LEVEL","../");
include LEVEL . "includes/functies.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>
        simpele zoekmachine voor fruit
    </title>
    <link type="text/css" rel="stylesheet" href="zoekFruit.css">
    <meta charset="utf-8" />
	<script src="../../../../../../scripts/jquery-3.2.0.min.js"></script>
	<script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Zoek een fruit op!").fadeIn(1000);
			});
	</script>
    <meta charset="utf-8" />
</head>
<body>
<header>          
     <h1></h1>
        </header>
		<nav>
			<h3><a href="../../../../../../../index.html">Portfolio website <br> Adam Oubelkas</a></h3>
                <ul>
                    <li>
                        <a href="../../../../../../webpaginas/Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
                    </li>
                    <li>
                        <a href="../../../../../../webpaginas/Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
                    </li>
                    <li>
                        <a href="../../../../../../webpaginas/Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
                    </li>
                    <li>
                        <a href="../../../../../../webpaginas/Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
                    </li>
                </ul>
            </nav>
        <section>          
			<div id="main">
				<div>
					<form method="get" action="zoekFruit.php">
						<label>Zoek fruit:</label>
						<input type="text" name="zoekFruit" value="">
						<br>
						<input type="submit" name="zoek" value="Verzend">
						<br>
						<h3>Resultaten</h3>
						<br>
						<label>
							<?php
							//Als er een invoer is verstuurd via het formulier, haal dan die waarde op via de onderstaande GET parameter
							if(isset($_GET['zoekFruit'])){
								//Als invoer gelijk is aan één van de keys in array $aFruits, print key met bijhorende value
								if(array_key_exists($_GET['zoekFruit'], $aFruits) && $_GET['zoekFruit'] == 'appel'){
									echo "Bedoelt uw: " . "<a href=" . $aFruits[$_GET['zoekFruit']] . ">" . $_GET['zoekFruit'] . "</a> ?";
								}
								else if(array_key_exists($_GET['zoekFruit'], $aFruits))
								{
									echo $_GET['zoekFruit'] . " is " . $aFruits[$_GET['zoekFruit']];
								}
								//Anders is er geen overeenkomst tussen de invoer en één van de keys
								else{
									echo $_GET['zoekFruit'] . " bestaat niet! Typ uw gewenste fruit ALLEEN in kleine letters!";
								}
							}
							?>
						</label>
					</form>
				</div>
			</div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP 7.1 en JQuery 3.2.0.</p>
        </footer>
    </body>
</html>