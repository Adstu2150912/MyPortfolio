<?php
    
//php en html code gemaakt door Adam Oubelkas uit IO1E4

//Met $_GET parameter variabelen initializeren
$getal1 = $_GET['getal1'];
$getal2 = $_GET['getal2'];

//Met isset()functie voorkom je foutmeldingen
if (isset($_GET['getal1'])) {

    $naam = $_GET['getal1'];
} else {

    $naam = "getal2";
} 

if (isset($_GET['getal2'])) {

    $naam = $_GET['getal2'];
} else {

    $naam = "getal1";
} 
//Waarde $getal1 en $getal2 in een string  
echo "getal1 is $getal1";
echo "<br>";
echo "getal2 is $getal2";

echo "<hr>";
//de verschillende rekenkundige operatoren
$plus = "$getal1 + $getal2 = " . $getal1 + $getal2;
$min = " $getal1 - $getal2 = " . $getal1 - $getal2;
$keer = " $getal1 * $getal2 = " . $getal1 * $getal2;
$delen = " $getal1 / $getal2 = " . $getal1 / $getal2;
$modulus = " $getal1 % $getal2 = " . $getal1 % $getal2;
$machtgetal1 = " $getal1 tot de macht $getal2 = " . pow($getal1, $getal2);
$machtgetal2 = " $getal2 tot de macht $getal1 = " . pow($getal2, $getal1);

//Waardes variabelen waarvan gebruik operatoren uitprinten
echo "<br>".$plus;
echo "<br>".$min;
echo "<br>".$keer;
echo "<br>".$delen;
echo "<br>".$modulus;
echo "<br>".$machtgetal1;
echo "<br>".$machtgetal2;
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>opdracht61</title>
    </head>
    <body>
        <!--php en html code gemaakt door Adam Oubelkas uit IO1E4-->
    <p>getal1 is $getal1(45)</p>
    <br>
    <p>getal2 is $getal2(6)</p>
        <hr>
    <br>
        <p>$getal1 + $getal2 = (45 + 6 =) 51</p>
        <p>$getal1 - $getal2 = (45 - 6 =) 39</p>
        <p>$getal1 * $getal2 = (45 * 6 =) 270</p>
        <p>$getal1 / $getal2 = (45 / 6 =) 7,5</p>
        <p>$getal1 % $getal2 = (45 % 6 = 45 rest 6 =) 3</p>
    
    </body>
</html>
