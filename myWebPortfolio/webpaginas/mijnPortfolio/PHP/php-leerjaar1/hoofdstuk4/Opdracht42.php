<?php
//declareren variabel $mop

$mop = "Weekend! Waarom gaat een Belg op vrijdag door het raam naar buiten? Het weekend staat voor de deur."; 

//De functie substr pakt hier de string vanaf rechts en loopt af tot en met de negentigste positie  
    $mop = substr($mop,-90)."<br>";
    echo $mop;

//De functie str_replace zorgt ervoor dat de string "Belg" vervangen wordt door een nieuwe string "blondje"   
    $mop = str_replace("Belg", "blondje", $mop) . "<br>";
    echo $mop; 
//Deze substr_replace positioneert de gegeven nieuwe string die je wilt plaatsen in de variable $mop aan de hand van de gegeven cöordinaten 
    $mop = substr_replace($mop, "gooit", 7, 4) . "<br>";
    echo $mop;
//Deze str_replace zorgt ervoor dat de string "op vrijdag" vervangen wordt door de string "tijdens een spelletje" in de variabel $mop
    $mop = str_replace("op vrijdag", "tijdens een spelletje", $mop) . "<br>";
    echo $mop;

//Deze str_replace zorgt ervoor dat de string "Het weekend staat voor de deur" vervangen wordt door de string "." in de variabel $mop   
    $mop = str_replace("Het weekend staat voor de deur"," ",$mop);
    echo $mop;

//Deze substr_replace positioneert de gegeven nieuwe string die je wilt plaatsen in de variable $mop aan de hand van de gegeven cöordinaten
    $mop = substr_replace($mop, "de dobbelsteen tegen het plafond? Wie het hoogst gooit, mag beginnen.",-72 , 59);
    echo $mop;

?>
