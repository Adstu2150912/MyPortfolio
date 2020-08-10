<?php
/**************
* Omschrijving: berekend product van 2 getallen
* @param  $g1 eerste getal
* @param  $g2 tweede getal
* @return $uitkomst: het product van de 2 getallen
**************/

//bereken uur vermenigvuldigd met uurprijs
function product($g1, $g2) {

    $uitkomst = $g1 * $g2;

    return $uitkomst;
}

/*************
*Omschrijving: berekend subtotaal met btw eroverheen
* @param  $btw: Belasting Toegevoegde Waarde is 21%
* @param  $subtotaal: subtotaal van eerste getal opgeteld met tweede getal
* @return $subtotaalbtw: subtotaal vermenigvuldigd met btw
*************/

//bereken subtotaal vermenigvuldigd met btw
function berekenBtw($btw, $subtotaal){
	
	$subtotaalbtw = $subtotaal * $btw/100;

	return $subtotaalbtw;
}

/*************
*Omschrijving: berekend totaal met btwbedrag 
* @param  $subtotaal: subtotaal van eerste getal opgeteld met tweede getal
* @param  $btwbedrag: btwbedrag van subtotaal vermenigvuldigd met btw
* @return $Totaal: subtotaal opgeteld met btwbedrag
*************/

//bereken subtotaal opgeteld met btw bedrag
function berekenTotaal($subtotaal, $btwbedrag){
	
	$Totaal = $subtotaal + $btwbedrag;

	return $Totaal;
}
?>

