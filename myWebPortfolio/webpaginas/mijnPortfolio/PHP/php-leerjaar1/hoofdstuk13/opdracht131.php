<?php
/**
 * Created by PhpStorm.
 * User: Appie97
 * Date: 2/10/2017
 * Time: 9:57 AM
var_dump($_GET);
*/
?>
<?php
DEFINE("LEVEL","../");
include LEVEL."includes/functies.php";
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
<!--Gemaakt op 10 februari 2017 door Adam Oubelkas uit IO1E4-->
    <!--Als dit formulier is ingevuld en op de submit knop gedrukt is,
    wordt het verzonden naar 'verzend.php' waarin je de visuele weergave in kan zien-->
    <form method="get" action="verzend.php">
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
