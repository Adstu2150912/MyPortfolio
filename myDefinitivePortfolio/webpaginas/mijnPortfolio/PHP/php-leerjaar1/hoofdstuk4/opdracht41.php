<?php

//Stringvariabel declareren

$mop = "Weekend! Waarom gaat een Belg op vrijdag door het raam naar buiten? Het weekend staat voor de deur.";

//Hier begint het eerste letter in de eerste positie en loopt daaruit acht letters af

echo substr($mop,0,8)."<br>";

//Hier begint het eerste letter in de vijfentwintigste positie en loopt daaruit 4 letters af

echo substr($mop,25,4)."<br>";

//Hier begint het eerste letter in de vierennegenste positie en loopt daaruit 4 letters af

echo substr($mop,94)."<br>";

//Hier begint het eerste letter in de negenste positie afgeteld vanuit het einde van de zin

echo substr($mop,-90)."<br>";

//Hier begint het eerste letter in de achtenzestigste positie en loopt daaruit 29 letters af

echo substr($mop,68,29)."<br>";

?>

