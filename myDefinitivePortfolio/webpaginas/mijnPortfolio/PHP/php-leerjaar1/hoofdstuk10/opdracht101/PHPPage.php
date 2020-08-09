<?php

$naam = 'bennienu';

$laatstepos = strrpos('bennien', 'n');

$tel = 0;

if (strlen($naam) -1 == $laatstepos) {
	echo $naam;
}

/*
while($tel < $aantal){
	while($klinkertel < count($klinkers)){

		if(substr_count($namen[$tel], $klinkers[$klinkertel]) > 0 && substr_count($namen[$tel], $klinkers[$klinkertel]) > substr_count($namen[$tel + 1], $klinkers[$klinkertel]))
		{

			$meesteklinkers = $namen[$tel];
	
		}

		$klinkertel++;

	}

	$tel++;
}

echo $meesteklinkers;

*/

function aantalklinkers(namen ,klinker){
	
}

?>

