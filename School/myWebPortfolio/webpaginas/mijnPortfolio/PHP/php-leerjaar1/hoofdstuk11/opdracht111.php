<?php
//Variabel $getal is gelijk aan 0
$getal = NULL;
//Variabel $msg met instructieve informatie	
$msg = "vul een getal in tussen 10 en 20";
//Wanneer er een getal is ingevoerd variabel $getal is gelijk aan ingevoerde getal
if(isset($_GET['getal'])) {
	$getal = $_GET['getal'];
    //Wanneer client getal tussen 10 en 20 ingevuld heeft, koppel $msg aan bijhorende string
		if($getal > 10 && $getal < 20){
		$msg = "bedankt voor uw getal $getal";
		}
        //Als voorafgaande if statement false is, koppel $msg aan onderstaande string ernaast 
		else {
			$msg = "getal is niet tussen 10 en 20";
		}
        //Als client leeg formulier verstuurd, koppel $msg aan onderstaande string ernaast 
		if(empty($_GET['getal'])) {
		$msg = 'getal is verplicht!';
		}
}
//empty();
?>

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
	<style>
		#wrapper > h2 > form {
			width:  40%;
			margin:  auto;
			padding:  1em;
			border: 1px solid black;
		}
	</style>
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
          <h2>Opdracht 111</h2>
			<form method="get" action="opdracht111.php">
				<label>Getal 1: </label><input type="text" value="<?php echo $getal ?>" name ="getal">
				<input type="submit" name="verzend" value="verzend">
			</form>
			<p><?php echo $msg; ?></p>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
