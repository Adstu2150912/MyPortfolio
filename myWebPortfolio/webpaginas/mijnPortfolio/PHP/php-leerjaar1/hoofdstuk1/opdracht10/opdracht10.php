<?php
    // variabelen declareren
    $naam = 'Adam Oubelkas'; // de waarde 'Adam Oubelkas' is een string (tekenreeks).
    $leeftijd = 19; // de waarde 19 is van het type getal. 
    $woonplaats = 'Raamsdonksveer.'; //de waarde 'Raamsdonksveer.' is een string.
    $hobbies = 'fitnessen, internetten, gamen en filosoferen.';//de waarde 'fitnessen, internetten, gamen en filosoferen.' is een string.
    $aantalBroers = 3; //de waarde 3 is van het type getal.
    $broers = 'Anis en Elias.'; //de waarde "Anis en Elias." is van het type getal.
    $halfbroer = 'Joseph Oubelkas.'; //de waarde 'Joseph Oubelkas.' is een string (tekenreeks).
    $vervolgopleiding = 'hbo - informatica'; // de waarde 'hbo - informatica' is een string (tekenreeks).
    $vervolgschool = 'Avans hoge school.'; // de waarde 'Avans hoge school.' is een string (tekenreeks).
    $gewensteBeroep = 'Back-End developer/Mobiele applicatiedeveloper'; //de waarde 'Back-End developer/Mobiele applicatiedeveloper' is een string (tekenreeks).


    // strings met variabelen printen in browser 
    echo 'Mijn naam is ' . $naam . ', en ik ben ' . $leeftijd . ' jaar oud.';
    echo '<br>';
    echo ' Ik woon in ' . $woonplaats ;
    echo '<br>';
    echo ' Mijn hobbies zijn ' . $hobbies ;
    echo '<br>';
    echo ' Ik heb ' . ' namelijk twee jongere broertjes: ' . $broers . ' En een halfbroer: ' . $halfbroer ;
    echo '<br>';
    echo 'Na succesvol afronden van mijn huidige opleiding ben ik van plan om ' . $vervolgopleiding . ' te volgen aan het ' . $vervolgschool;
    echo '<br>';
    echo 'Uiteindelijk wil ik een ' . $gewensteBeroep . ' worden.'; 
    
?> 
