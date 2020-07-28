
<!DOCTYPE html>
<!--
Opdracht:       Portfoliowebsite
Auteur:         <Adam Oubelkas>
Aanmaakdatum:   <23-1-2017 + 09:20>
Bestandsnaam:   <Contact.html>
-->
<html lang="en">
    <head>
        <!--Omschrijving van de webpagina-->
		<meta name="description" content="contactpagina">
		<!--Toekennen van sleutelwoorden-->
		<meta name="keywords" content="contactgegevens, feedback, formulier">
		<!--Tekstset declareren-->
        <meta charset="utf-8" />
        <!--Titel webpagina-->
        <title>Mijn hobby's</title>
		<!--Linken naar extern CSS-bestand-->
        <link href="../css/Contact.css" rel="stylesheet" type="text/css">
        <script src="../scripts/jquery-3.1.1.min.js"></script>
        <script src="../scripts/Script.js"></script>
        <script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Heeft u vragen of suggesties? Stel ze!").fadeIn(1000);
            });
        </script>
    </head>
    <body>
        <header>
            <h3><a href="../index.html">Portfoliowebsite - Adam Oubelkas <br> (Nog onder voorbehoud!)</a></h3>
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
                <div id="contactgegevens">
                    <h3>Contactgegevens</h3>
                    <p>E-mail: adam.oubelkas@edu-kw1c.nl</p>
                    <p>Tel: 06-82193955</p>
                </div>
                <p id="lebelcontact">Uw mening telt! Laat het hiernaast weten!</p>
                <div id="formulier">
                    <form method="post" action="mail.php">
                        <fieldset>
                            <legend>Stuur een bericht</legend>
                            <label>Naam</label><br>
                            <input type="text"><br>
                            <label>E-mail</label><br>
                            <input type="email"><br>
                            <label>Website-adres</label><br>
                            <input type="url"><br>
                            <label>Geslacht:</label>
			                <input id="female" type="radio" name="gender" value="f">
			                <label for="female">Vrouw</label>
			                <input id="male" type="radio" name="gender" value="m">
			                <label for="male">Man</label><br>
                            <label>Type reactie:</label>
                            <input id="vraag" type="radio" name="message" value="vraag">
			                <label for="vraag">vraag</label>
			                <input id="reactie" type="radio" name="message" value="reactie">
			                <label for="reactie">reactie</label><br>
                            <label>Onderwerp</label><br>
                            <input type="text"><br>
                            <label>Bericht</label><br>
                            <textarea name="berichtje" cols="40" rows="7"></textarea><br>
                            <button type="submit">Verstuur</button>
                        </fieldset>
                    </form>
                </div>
                
            </div>
        </section>
        <footer>
            <p>&copy 2017 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP5.5 en JQuery 3.1.1.</p>
        </footer>
    </body>
</html>