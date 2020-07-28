<?php
/**
 * Created by PhpStorm.
 * User: Adam Oubelkas
 * Date: 2/17/2017
 * Time: 9:37 AM
 */
//reeks met diverse fruitsoorten met bijhorende kenmerken
$aFruits = array(
    'appel' => 'lekker'
    ,'peer' => 'sappig'
    ,'sinaasappel' => 'zuur'
    ,'kiwi' => 'gezond'
    ,'banaan' => 'zoet'
    ,'meloen' => 'heerlijk'
    ,'kersen' => 'zalig'
    , '' => ''
);

$aFruits = array_flip($aFruits);

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
    <form method="get" action="opdracht170.php">
        <label>Zoek fruit:</label>
        <input type="text" name="zoekFruit" value="">
        <br>
        <input type="submit" name="zoek" value="Verzend">
        <br>
        <h3>Resultaten</h3>
        <br>
        <label>
            <?php
            //Als er een invoer is verstuurd via het formulier, haal dan die waarde op via GET parameter
            if(isset($_GET['zoekFruit'])){
                //Als invoer gelijk is aan één van de keys in array $aFruits, print key met bijhorende value
                if(array_key_exists($_GET['zoekFruit'], $aFruits)){
                    echo $_GET['zoekFruit'] . " is " . $aFruits[$_GET['zoekFruit']];
                    //array_flip($aFruits);
                }
                //Anders is er geen overeenkomst tussen de invoer en één van de keys
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
