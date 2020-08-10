<?php
/**
 * Created by PhpStorm.
 * User: D.Lyte
 * Date: 4/12/2017
 * Time: 2:42 PM
 */
?>



<?php
$aPersoon = array( 10=>'Barends', 20 => 'van Hulten', 30 => 'Jansen', 40 => 'Waili', 50=> 'Ketelaars');
//Maak van keys values, en values keys
$aPersoon = array_flip($aPersoon);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
</head>
<body>
<header><h1>ICT academie AO</h1></header>
<nav><ul><?php printOpdrachten(); ?></ul></nav>
<div id="wrapper">
    <form method="get" action="opdracht141.php">
        <label>Personen</label>
        <input list="personen">
        <datalist id="personen">
            <option>selecteer persoon</option>
            <?php
            //Maak van ieder key met bijhorende value een menuoptie
                foreach ($aPersoon as $key => $value){
                    //Maak een menuoptie voor 'Van Hulten' met attribuut 'selected'
                    if($value = 20){
                        echo '<option value=' .  $value . ' attribute="selected">'. $key . '</option>';
                    }
                    else{
                        echo '<option value=' .  $value . '>'. $key . '</option>';
                    }
                }
            ?>
        </datalist>
        <br>
        <input type="submit" name="verzend" value="Verzend">
    </form>
</div>
</body>
</html>

<?php
include "lijst.php";
session_start();
$aLijst2 = array(1,2,3,4,5,6,7,8,9,10);
$aGemiddelde;
for($i = 0; $i < count($_SESSION['getallen']); $i++){
    array_push($aLijst2, $_SESSION[$i]);
}

for($i = 0; $i < count($aLijst2); $i++){
    $gemiddelde[$ii] += $gemiddelde[$i++];
}

echo "Het gemiddelde van de sessiegetallen(aLijst) en aLijst2 is:" . $gemiddelde/count($gemiddelde) ;
?>

<?php
    $fruit = array(
        'appel' => 'lekker'
    ,'peer' => 'sappig'
    ,'sinaasappel' => 'zuur'
    ,'kiwi' => 'gezond'
    ,'banaan' => 'zoet'
    ,'meloen' => 'heerlijk'
    ,'kersen' => 'zalig'
    );

    $fruit = shuffle($fruit);
    echo "<ul>";
    foreach ($fruit as $key => $value){
        echo "<li>" . $key  . "=>" . $value . "</li>";
    }
    echo "</ul>"
?>
