<?php
/**
 * Created by PhpStorm.
 * User: Adam Oubelkas
 * Date: 2/17/2017
 * Time: 9:37 AM
 */
?>
<?php
DEFINE("LEVEL","../");
include LEVEL . "includes/functies.php";
session_destroy();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/css" rel="stylesheet" href="../css/style.css">
    <meta charset="utf-8" />
</head>
<body>
<header><h1>ICT academie AO</h1></header>
<nav><ul><?php printOpdrachten(); ?></ul></nav>
<div id="wrapper">
    <!--Gemaakt op 24 februari 2017 door Adam Oubelkas uit IO1E4-->
    <!--Als dit formulier is ingevuld en op de submit knop gedrukt is,
    wordt het verzonden naar 'opdracht141.php' waarin je de visuele weergave in kan zien-->
    <form method="get" action="opdracht141.php">
        <label>Naam: </label>
        <input type="text" name="naam" value="">
        <br>
        <label>Klas: </label>
        <input type="text" name="klas" value="">
        <br>
        <label>Leerlingnummer: </label>
        <input type="text" name="leerlingnummer" value="">
        <br>
        <label>Vak:</label>
        <select name='vak'>
            <option value='PHP'>PHP</option>
            <option value='javascript'>Javascript</option>
            <option value='ASP'>ASP</option>
            <option value='SQL'>SQL</option>
        </select>
        <br>
        <label>Cijfer: </label>
        <input type="number" name="cijfer" value="">
        <br>
        <input type="submit" name="verzend" value="Verzend">
    </form>
</div>
</body>
</html>
