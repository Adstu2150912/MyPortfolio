<?php
/**
 * Created by PhpStorm.
 * User: Appie97
 * Date: 2/10/2017
 * Time: 10:06 AM
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
    <!--print de waardes van 'naam' en 'klas', vanuit opdracht131.php, via GET parameter uit-->
    <title>Opdracht 131: Rapport <?php echo $_GET['naam']?>/<?php echo $_GET['klas']?></title>
</head>
<body>

<header>
    <!--print de waardes 'naam' en 'klas', vanuit opdracht131.php, via GET parameter uit-->
    <h1>Opdracht 131: Rapport <?php echo $_GET['naam']?>/<?php echo $_GET['klas']?></h1>
</header>
<nav>
    <!--print PHP-opdrachten als navigatieknoppen uit-->
    <ul><?php printOpdrachten(); ?></ul>
</nav>
<div id="wrapper">
    <!--print waarde 'naam', vanuit opdracht131.php, via GET parameter uit-->
    <h2>Rapport <?php echo $_GET['naam']?></h2>
    <!--print waardes 'vak','naam','klas', 'vakcijfer', 'cijfer' uit, vanuit opdracht131.php, via GET parameter-->
    <p>Voor het vak <?php echo $_GET['vak']?> heeft <?php echo $_GET['naam']?> uit klas <?php echo $_GET['klas']?> het cijfer <span id="vakcijfer"><?php echo $_GET['cijfer']?></span> gehaald.</p>
</div>
</body>
</html>
