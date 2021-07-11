<?php
/**
 * Created by PhpStorm.
 * User: D.Lyte
 * Date: 4/12/2017
 * Time: 12:44 PM
 */
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
<form method='get' action='Oefentoets%20opdracht4b.php'>
         <label>Naam: </label><input name='naam' type='text' value=''>
         <label>Klas: </label><input name='klas' type='text' value=''>
         <label>Nummer: </label><input name='leerlingnummer' type='text' value=''>
         <label>Vak: </label><select name='vak'>
             <option value='PHP'>PHP</option>
             <option value='Javascript'>Javascript</option>
             <option value='ASP'>ASP</option>
             <option value='SQL'>SQL</option>
         </select>
         <label>Cijfer: </label><input name='cijfer' type='number' value='5'>
         <input type='submit' value='verzend' name='verzend'>
         </form>
         </div>
</body>
</html>
