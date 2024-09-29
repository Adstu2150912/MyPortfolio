<?php
/*verzend() {
    
}*/
include('../scripts/functies.php');

$s['to'] = 'adamoubelkas@outlook.com';
$s['subject'] = 'Reactie op portfolio site';
$s['body'] = 'hallo, dit is een bericht';

sendEmail($s);

sleep(3);

header('location: Contact.html');

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
        <script src="../scripts/jquery-3.1.1.min.js"></script>
        <script src="../scripts/Script.js"></script>
        <script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Bedankt voor uw vraag of bericht. U krijgt zo snel mogelijk een reactie.").fadeIn(1000);
                 $('header > h3 > a').empty();
                $('header > h3 > a').css('display', 'none');
                $('header > h3 > a').append("Portfoliowebsite - Adam Oubelkas <br> (Nog onder voorbehoud!)").fadeIn(1000);
            });
        </script>
    </head>
    <body>
        <header>
            <h3><a href="../index.html">Portfoliowebsite - Adam Oubelkas</a></h3>
            <h1></h1>
        </header>
        <section>
            <nav>
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
                    <li>
                        <a href="../webpaginas/Contact.html" id="Contact">Contact</a>
                    </li>
                </ul>
            </nav>
            <div id="main">
                
            </div>
        </section>
        <footer>
            <p>&copy 2024 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP5.5 en JQuery 3.1.1.</p>
        </footer>
    </body>
</html>
