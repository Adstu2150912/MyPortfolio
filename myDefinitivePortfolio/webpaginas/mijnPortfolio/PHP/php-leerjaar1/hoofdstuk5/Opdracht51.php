<?php

//declareren belangrijke variabelen
$naam = $_GET['naam'];
$leeftijd = $_GET['leeftijd'];
$plaats = $_GET['plaats'];

//initializering van de opdracht

// hier wordt niks verandert, dus alleen echo 

echo "Ik ben $naam.";

//Hier 

if ($leeftijd > 25){
    echo "Ik ben best oud.";
}
else {
    echo "Ik ben best jong.";
}

if ($plaats == "Den Bosch"){
    echo "Ik ben een bosschenaar.";
}
else {
    echo "Ik ben geen bosschenaar.";
}


?>
