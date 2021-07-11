<?php
$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];
$call = $_POST['call'];
$website = $_POST['website'];
$priority = $_POST['priority'];
$type = $_POST['type'];
$message = $_POST['message'];
/*$formcontent = "From: $name \n Call Back: $call \n Website: $website \n Priority: $priority \n Type $type \n Message $message";*/
$formcontent = "From: $name \n Call Back: $email \n Website: $website \n Type $type \n Message $message";
$recipient = "adam.oubelkas@edu-kw1c.nl";
$subject = "Contact Form";
$mailheader = "From: $email \r\n";
mail($recipient, $subject, $formcontent, $mailheader) or print_r(error_get_last() );
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
                $('header > h1').append("Welkom gast! Login om verder te gaan").fadeIn(1000);
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
                
                <?php echo "Bedankt!" . " -" . "<a href='../webpaginas/Contact.html' style='text-decoration:none;color:#ff0099;'> Return Home</a>"; ?>
                
            </div>
        </section>
        <footer>
            <p>&copy 2017 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP5.5 en JQuery 3.1.1.</p>
        </footer>
    </body>
</html>
