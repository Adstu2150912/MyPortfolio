<?php
function isPriem($getal){
	
	//tellen vanaf index 0
	$teller = 0;
	//priemgetallen tot met 20
	$priemgetallen = array(2,3,5,7,11,13,17,19);

	//alle integers in array $priemgetallen vergelijken met gegeven parameter (integer)
		while($teller < count($priemgetallen)){
			//Pas als gegeven parameter gedeeld door 1 en (&&) gedeeld door parameter zelf gelijk is aan 1 van priemgetallen, print gegeven parameter uit   
			if($getal / 1 == $priemgetallen[$teller]){
				return "getal " . $getal . " is een priemgetal!" ;
				$teller = count($priemgetallen);
			}
			
			elseif($teller == count($priemgetallen) - 1){

				return "getal " . $getal . " is GEEN priemgetal!";
				
			}
			$teller++;
		}
}
?>
