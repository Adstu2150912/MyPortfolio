<?php

//Hier wordt $leeftijd geïnitializeert
$leeftijd = $_GET['leeftijd'];

//Hier wordt $naam gedeclareerd
$naam = $_GET['naam'];

//Voorwarde welke waarde aangetoont mag worden.
if ($leeftijd > 17) {
    echo "$naam is volwassen";
}
else {
    echo "$naam is nog een kind";
}


?>
