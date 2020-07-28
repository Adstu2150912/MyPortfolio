<?php
/**
 * Created by PhpStorm.
 * User: D.Lyte
 * Date: 4/7/2017
 * Time: 8:47 AM
 */
//Deze zin moet ontleden worden om erachter te komen hoe vaak een lidwoord voorkomt
$zin = "Rond de wedstrijd Ajax-Feyenoord zijn zondag in Rotterdam achttien relschoppers opgepakt. Volgens de politie zijn ze aangehouden voor zaken als belediging, bedreiging, vernieling en het gooien van vuurwerk. Ajax won in de Arena met 2-1.";

//Sla in onderstaande variabelen op waar $zin in verschillende arrays zijn ontleden door de lidwoord
$aLidwoord_De = explode('de', $zin);
$aLidwoord_Het = explode('het', $zin);
$aLidwoord_Een = explode('een', $zin);

//Onderstaande variabelen worden  in de volgende loops gebruikt om het aantal lidwoorden bij te houden
$aantalLidwoorden_De = 0;
$aantalLidwoorden_Het = 0;
$aantalLidwoorden_Een = 0;

//Tel het aantal lidwoorden 'De'
for($i = 0; $i < count($aLidwoord_De); $i++){
    $aantalLidwoorden_De++;
}
//Tel het aantal lidwoorden 'Het'
for($i = 0; $i < count($aLidwoord_Het); $i++){
    $aantalLidwoorden_Het++;
}
//Tel het aantal lidwoorden 'Een'
for($i = 0; $i < count($aLidwoord_Een); $i++){
    $aantalLidwoorden_Een++;
}
//Maak van de string een array met de functie 'str_split'
$aZin =  str_split($zin);

//$aantalLidwoorden_De = substr_count($zin, 'de');
//$aantalLidwoorden_Het = substr_count($zin, 'het');
//$aantalLidwoorden_Een = substr_count($zin, 'een');

for($tel = 0; $tel < count($aLidwoord_De); $tel++){
    echo $aLidwoord_De[$tel];
    echo "<br>";
}

echo "<br>";

for($tel = 0; $tel < count($aLidwoord_Het); $tel++){
    echo $aLidwoord_Het[$tel];
    echo "<br>";
}

echo "<br>";

for($tel = 0; $tel < count($aLidwoord_Een); $tel++){
    echo $aLidwoord_Een[$tel];
    echo "<br>";
}

echo "<hr>";

for($tel=0; $tel < count($aZin); $tel++){
    echo $aZin[$tel];
}

echo "<hr>";

echo "Deze zin bevat " . $aantalLidwoorden_De . " lidwoorden met 'de', " . "<br>" . $aantalLidwoorden_Het . " lidwoorden met het en " . $aantalLidwoorden_Een . " lidwoorden met 'een'.";

?>