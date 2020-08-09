<?php
session_start();

if (isset($_SESSION['naam'])) {
    $naam = $_SESSION['naam'];
} else {
    //als de sessie niet bestaat stuur ik de pagina terug naar het formulier
    header('location: form.php');
}
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Formulier en Sessie</title>
         <style>
            section {
                width:  40%;
                margin:  auto;
                padding:  1em;
                border: 1px solid black;
            }
        </style>
    </head>
    <body>      
        <section>
        <p>
        Je naam is nog steeds <?php echo $naam; ?>.
        <br><a href="sessie2.php" title="Wat was je naam?">sessie2.php</a>
        </p>
        </section>
    </body>
</html>

