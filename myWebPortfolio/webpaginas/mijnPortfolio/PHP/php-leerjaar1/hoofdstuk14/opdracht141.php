<?php
/**
 * Created by PhpStorm.
 * User: Adam Oubelkas
 * Date: 2/17/2017
 * Time: 9:45 AM
 */
?>
<?php
DEFINE("LEVEL","../");
include LEVEL . "includes/functies.php";
//Begin met sessie

if(session_start()){
    session_destroy();
}
else {
    session_start();
}

//Als sessievariabel 'leerlinggegevens' al bestaat, koppel variabel $leerlinggegevens aan $_SESSION['leerlinggegevens']
if(isset($_SESSION['leerlinggegevens'])){
    $leerlingegevens = $_SESSION['leerlinggegevens'];
}
elseif(empty($_GET['naam'])){
    $_SESSION['leerlinggegevens'] = ["onbekende naam", "onbekende klas", "onbekende leerlingnummer"];
}
//Zo niet, koppel $_SESSION['leerlinggegevens'] aan een array met indexwaardes $_GET['naam'],$_GET['klas'] en $_GET['leerlingnummer']
else {
    $_SESSION['leerlinggegevens'] = [$_GET['naam'],$_GET['klas'],$_GET['leerlingnummer']];
}
//koppel sessievariabel $_SESSION['rapport'], met indexwaarde $_GET['vak'], aan $_GET['cijfer'];
if(empty($_GET['vak'])){
    $_SESSION['rapport']['onbekende vak'] = 0;
}
else {
    $_SESSION['rapport'][$_GET['vak']] = $_GET['cijfer'];
}
?>
<!DOCTYPE html>
<!--Gemaakt op 24 februari 2017 door Adam Oubelkas uit IO1E4-->
<html lang="en">
<head>
    <link type="text/css" rel="stylesheet" href="../css/style.css">
    <meta charset="utf-8" />
    <!--print de eerste en tweede indexwaarde uit van sessievariabel 'leerlinggegevens' -->
    <title>Opdracht 141: Rapport <?php echo $_SESSION['leerlinggegevens'][0]?>/<?php echo $_SESSION['leerlinggegevens'][1]?></title>
</head>
<body>

<header>
    <!--print de eerste en tweede indexwaarde uit van sessievariabel 'leerlinggegevens' -->
    <h1>Opdracht 141: Rapport <?php echo $_SESSION['leerlinggegevens'][0]?>/<?php echo $_SESSION['leerlinggegevens'][1]?></h1>
</header>
<nav>
    <!--print PHP-opdrachten als navigatieknoppen uit-->
    <ul><?php printOpdrachten(); ?></ul>
</nav>
<div id="wrapper">
    <!--print de eerste indexwaarde uit van sessievariabel 'leerlinggegevens' -->
    <p>Rapport van  leerling <br><?php echo $_SESSION['leerlinggegevens'][0]?> met <br>
        <!--print de derde indexwaarde uit van sessievariabel 'leerlinggegevens' -->
    leerlingnummer <?php echo $_SESSION['leerlinggegevens'][2]?> <br>
        <!--print de tweede indexwaarde uit van sessievariabel 'leerlinggegevens' -->
    uit klas <?php echo $_SESSION['leerlinggegevens'][1]?></p>
    <table>
        <thead>
            <tr>
                <td>vak</td>
                <td>Cijfer</td>
            </tr>
        </thead>
        <tbody>
        <?php
        //Print alle $key waardes uit die gekoppeld zijn aan bijhorende $value, vanuit sessievariabel 'rapport'
        foreach ($_SESSION['rapport'] as $key => $value){
            echo "<tr><td>" . $key . "</td>" . "<td>" . $value . "</td></tr>";
        }
        ?>
        <tr><td>Gemiddelde</td>
            <td><?php
                $averageSum =0;
                foreach ($_SESSION['rapport'] as $key => $value){
                    $averageSum += $value;
                }

                $averageNum = $averageSum / (count($_SESSION['rapport']));
                echo $averageNum;?></td>
        </tr>
        </tbody>
    </table>
    <form method="get" action="opdracht141.php">
        <?php
`   `
        ?>
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
