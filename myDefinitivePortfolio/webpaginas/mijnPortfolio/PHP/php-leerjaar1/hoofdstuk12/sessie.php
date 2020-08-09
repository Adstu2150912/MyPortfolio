<?php
session_start();

if (isset($_POST['naam'])) {
    $_SESSION['naam'] = $_POST['naam'];
} else {
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
        Je naam is <?php echo $_SESSION['naam']; 
        ?>.
        <br><a href="sessie1.php" title="Wat was je naam">sessie1.php</a>
        </p>
        </section>
    </body>
</html>

