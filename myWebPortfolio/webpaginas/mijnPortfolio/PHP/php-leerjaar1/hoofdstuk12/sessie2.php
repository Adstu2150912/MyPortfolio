<?php
session_start();
//vergeet de naam variabele in de sessie;
unset($_SESSION['naam']);

if (isset($_SESSION['naam'])) {
    $naam = $_SESSION['naam'];
} else {
    $naam = 'onbekend';
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
        Je naam is nu <?php echo $naam; ?> geworden.
        <br><a href="form.php" title="Wat was je naam?">Zeg je naam nog eens in form.php</a>
        </p>
        </section>
    </body>
</html>


