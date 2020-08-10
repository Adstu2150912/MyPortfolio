<?php
/*PHP-bestand met PHP-functies toevoegen*/
include('../scripts/functies.php');
/*sessie erbij halen*/
session_start();
/*if-elseconstructie*/
if(isset($_POST['wachtwoord'])){
   $errorMsg = isWachtwoord($_POST['wachtwoord']); 
}
/*else{
    $errorMsg = "Er is niks ingevuld, dit is verplicht!";
}*/

?>

<!DOCTYPE html>
<!--
Opdracht:       Portfoliowebsite
Auteur:         <Adam Oubelkas>
Aanmaakdatum:   <23-1-2017 + 09:20>
Bestandsnaam:   <login.php>
-->
<html lang="en">
    <head>
        <!--Omschrijving van de webpagina-->
		<meta name="description" content="loginpagina">
		<!--Toekennen van sleutelwoorden-->
		<meta name="keywords" content="Inloggen, Login, sessies, sessions">
		<!--Tekstset declareren-->
        <meta charset="utf-8" />
        <!--Titel webpagina-->
        <title>Mijn hobby's</title>
        <!--Link naar extern css bestand-->
        <link href="../css/login.css" rel="stylesheet" type="text/css">
        <script src="../scripts/jquery-3.2.0.min.js"></script>
		<script src="../scripts/Script.js"></script>
        <script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Welkom! Login om verder te gaan").fadeIn(1000);
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
            <div id="main">
                <form id="formulier" method="post" action="login.php">
                    <label>Wachtwoord </label><input type="password" value="" name="wachtwoord"> <!--echo isWachtwoord($_SESSION['wachtwoord']);--> 
                        <input type="submit" name="verzend" value="verzend">
                            </form>
                            <p id="infoPanel"><?php echo $errorMsg ?></p>               
            </div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
        </footer>
    </body>
</html>
