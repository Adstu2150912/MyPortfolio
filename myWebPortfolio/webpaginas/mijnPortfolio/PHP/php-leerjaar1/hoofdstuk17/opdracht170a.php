<?php
/**
 * Created by PhpStorm.
 * User: Adam Oubelkas
 * Date: 2/17/2017
 * Time: 9:37 AM
 */

$aPersoonsvorm = array(
    'Henrico' => ' is '
,'Adam' => ' heeft '
,'Lars' => ' doet '
,'Duncan' => ' zegt: Hé, heb je rooie kuel op jouwe broodje?! En is '
, 'Meneer Van Meer' => ' behoort tot '
, 'Meneer Van Den Berg' => ' vindt '
, 'Mitchell' => ' heet '
, 'Joey' => ' wordt '
, 'Bies' => ' is bekend als '
, 'Meneer Van Rijswijk' => ' behoort tot: '
, 'Bart' => ' heet '
, 'Meneer Saebu' => ' behoort tot: '
, 'Felbe' => ' is '
, 'Mevrouw Lambregts' => ' heeft '
);
//reeks met diverse fruitsoorten met bijhorende kenmerken
$aFruits = array(
    'Mitchell' => ' Boosted Napoleon'
, 'Joey' => ' Pino en Poetin'
, 'Bart' => ' Filthy Frank'
, 'Henrico' => ' Pepe'
, 'Bies' => ' iBooster'
, 'Meneer Saebu' => ' kalen koppen niet te stoppen!!'
, 'Meneer Van Meer' => ' kalen koppen niet te stoppen!!'
, 'Meneer Van Den Berg' => ' Ajax niet beter dan Feyenoord'
, 'Meneer Van Rijswijk' => ' dikke koppen niet te stoppen'
, 'Adam' => ' Dikke Neus'
, 'Duncan' => ' Slightly Feminine'
, 'Lars' => ' controlleer en herstel'
, 'Felbe' => ' dik, bol, dik en bol!'
, 'Mevrouw Lambregts' => ' kikkerogen'
);

?>

<?php
DEFINE("LEVEL","../");
include LEVEL . "includes/functies.php";
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
    <form method="get" action="opdracht170a.php">
        <label>Zoek fruit:</label>
        <input type="text" name="zoekFruit" value="">
        <br>
        <input type="submit" name="zoek" value="Verzend">
        <br>
        <h3>Resultaten</h3>
        <br>
        <label><?php
            if(isset($_GET['zoekFruit'])){
                if(array_key_exists($_GET['zoekFruit'], $aFruits)){
                    echo $_GET['zoekFruit'] .  $aPersoonsvorm[$_GET['zoekFruit']]  . $aFruits[$_GET['zoekFruit']];
                    //array_flip($aFruits);
                }
                else{
                    echo $_GET['zoekFruit'] . " bestaat niet";
                    //array_flip($aFruits);
                }

            }
            ?>
        </label>
    </form>
</div>
</body>
</html>
