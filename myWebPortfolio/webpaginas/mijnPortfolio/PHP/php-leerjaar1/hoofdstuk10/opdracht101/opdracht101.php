<?php
//Variabel array met stringwaardes
$namen = array('Joey', 'Bart', 'Ndubuisi',  'Mitchell', 'Danush', 'Henrico','Shailesh', 'Lars','abu', 'Luuk', 'Gijs', 'Joep', 'Duncan', "Brain", 'Ayoub', 'Cherwin', 'Koen', 'Adam');
//aantal stringwaardes in $namen
$aantal = count($namen);
//tellen vanaf eerste positie (index 0) 
$tel = 0;
//hoogste aantal letters in een stringwaarde
$maxlen = 0;
//langstenaam onthouden
$langstenaam = '';
//kortstenaam onthouden
$kortstenaam = '';

//Langste naam bepalen door if statement met bijhorende string waardes te herhalen 
while($tel < $aantal){
	
	if(strlen($namen[$tel]) > $maxlen){
		$maxlen = strlen($namen[$tel]);
		$langstenaam = $namen[$tel];
	}
	$tel++;
}

$maxlen;
$tel = 0;
//Kortste naam bepalen 

while($tel < $aantal){
	if(strlen($namen[$tel]) < $maxlen){
		$maxlen = strlen($namen[$tel]);
		$kortstenaam = $namen[$tel];
	}
	
	$tel++;
}

$tel = 0;

 
echo "Kortste naam: " . $kortstenaam . "<br>";

echo "Langste naam: " . $langstenaam . "<br>";

echo "Namen met 'a' erin: ";

//namen met 'a' uit array $namen halen  

while($tel < $aantal){
	//Als 'a' string in stringwaarde zit, print stringwaarde uit
	if(stripos($namen[$tel], 'a') > -1){
		echo $namen[$tel];
		//Alle stringwaardes vooraf laatste stringwaarde afsluiten met komma
			if($tel < ($aantal - 2) )
			{
				echo ", ";
			}
		
	}
	$tel++;
}

echo "." . "<br>";

$tel = 0;

echo "Namen die  eindigen met 'n': ";

//Stringwaardes uithalen waarvan 'n' in laatste positie bevindt (hoogste index)
while($tel < $aantal){
	//Wanneer lengte eraf 1 gelijk is aan 'n' als hoogste index, print stringwaarde uit
	if(strlen($namen[$tel]) - 1 == strrpos($namen[$tel], 'n'))
	{
		echo $namen[$tel];
		//Alle stringwaardes vooraf laatste stringwaarde afsluiten met komma
			if($tel < ($aantal - 2) )
			{
				echo ", ";
			}
		
	}
	$tel++;
} 

echo "." . "<br>";
echo "<br>";

$tel = 0;
//stringwaarde met meeste klinkers bewaren
$meesteklinkers = '';
//tellen vanaf eerste positie in array $klinkers
$klinkertel = 0;
//alle klinkers bewaren
$klinkers = array('a', 'e', 'i', 'o', 'u');
echo "Namen met meeste klinkers: ";

//Zoek stringwaarde met meeste klinkers
while($tel < $aantal){
	//Vergelijk ieder klinker in array $klinkers met gegeven stringwaardes
	while($klinkertel < count($klinkers)){
		//Zodra gegeven stringwaarde meer klinkers dan $meesteklinkers heeft, is $meesteklinkers gelijk aan stringwaarde 
		if(substr_count($namen[$tel], $klinkers[$klinkertel]) > substr_count($meesteklinkers, $klinkers[$klinkertel])/*substr_count($namen[$tel], $klinkers[$klinkertel + 1]) && $tel < $aantal */){

			$meesteklinkers = $namen[$tel];
			
		}
		$klinkertel++;
	}
	$tel++;
}

echo $meesteklinkers;

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title></title>
    </head>
    <body>
        
    </body>
</html>
