<?php
/***********************
* printGroet()
* @param geen parameters 
* @return geen return
**************************/ 

//Aanmaken functie voor het begroeten client
function printGroet ($achternaam, $voornaam, $leeftijd) {

    //wat is de lokale tijdszone
    date_default_timezone_set('Europe/Amsterdam');

    //Geeft het uur van de dag terug in 24uurs notatie
    $uur = date('G');
    //Tijd tussen 11:59 en 16:00
    if ($uur >= 12 && $uur < 16) {
        $dagdeel = "middag";
    }
	  //Tijd tussen 05:00 en 12:00
    elseif($uur > 5 && $uur < 12) {
        $dagdeel = "ochtend";
    }
	  //Tijd tussen 16:00 en 23:00
    elseif( $uur> 16 && $uur<= 23) {
        $dagdeel = "avond";
    }
	  //Tijd tussen 23:00 en 05:00
    else {
        $dagdeel = "nacht";
    }

	//Als client ouder is dan of gewoon 30 jaar oud is, begroet diegene formeel
	if($leeftijd >= 30){
		echo "Hallo meneer $achternaam, goede-$dagdeel" .  ".";
	}
	//Als client jonger is 30 jaar, begroet diegene formeel
	else{
		echo "He $voornaam, fijne $dagdeel he?";
	}
}
?>