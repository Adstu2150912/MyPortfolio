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
,'Duncan' => ' is '
, 'Meneer Van Meer' => ' behoort tot '
, 'Meneer Van Den Berg' => ' vindt '
, 'Mitchell' => ' heet '
, 'Joey' => ' wordt '
, 'Bies' => ' is bekend als '
, 'Meneer Van Rijswijk' => ' behoort tot '
, 'Bart' => ' heet '
, 'Meneer Saebu' => ' behoort tot '
, 'Felbe' => ' is '
, 'Saebu' => ' is een MLG 420 '
);
//reeks met diverse fruitsoorten met bijhorende kenmerken
$aNamen = array(
    'Mitchell' => 'Boosted Napoleon'
, 'Joey' => 'Pino en Poetin'
, 'Bart' => 'Filthy Frank'
, 'Henrico' => 'Pepe'
, 'Bies' => 'iBooster'
, 'Meneer Saebu' => 'kalen koppen niet te stoppen!!'
, 'Meneer Van Meer' => 'kalen koppen niet te stoppen!!'
, '' => ''
, 'Meneer Van Den Berg' => 'Ajax niet beter dan Feyenoord'
, 'Meneer Van Rijswijk' => 'dikke koppen niet te stoppen'
, 'Adam' => 'Dikke Neus'
, 'Duncan' => 'Slightly Feminine'
, 'Lars' => 'controlleer en herstel'
, 'Felbe' => 'dik, bol, dik en bol!'
, 'Saebu' => ' en geeft geen uitleg omdat hij redelijk lui is'
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
    <form method="get" action="170Spoof.php">
        <label>Zoek fruit:</label>
        <input type="text" name="zoekFruit" value="">
        <br>
        <input type="submit" name="zoek" value="Verzend">
        <br>
        <h3>Resultaten</h3>
        <br>
        <label><?php
            if(isset($_GET['zoekFruit'])){
                if(array_key_exists($_GET['zoekFruit'], $aPersoonsvorm)){
                    echo $_GET['zoekFruit'] .  $aPersoonsvorm[$_GET['zoekFruit']]  . $aNamen[$_GET['zoekFruit']];
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
