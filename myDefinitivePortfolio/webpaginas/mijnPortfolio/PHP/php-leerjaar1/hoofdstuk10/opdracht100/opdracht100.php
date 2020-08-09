<?php

//Variabel gekoppeld met array van cijfers
$cijfers = array(7.5, 7.0, 5.0, 8.4, 9.0, 7.0, 3.0, 1.8, 8.3, 7.8, 7.0);
//$aantal telt het aantal cijfers in array $cijfers
$aantal = count($cijfers);
//Pas achteraf wordt hoogste getal opgeslagen van array $cijfers 
$max = 0;
//Pas achteraf wordt laagste getal opgeslagen van array $cijfers
$min;
//Alle indexes/indices langs gaan vanuit eerste positie
$tel = 0;
//Alle arraywaardes vooraf opgeteld en hierin opgeslagen
$totaalsom = 0;
	 

//Deel A Aantal cijfers benoemen
echo "Ik heb " . $aantal . " cijfers gehaald" . "<br>";

//Deel B Cijferlijst weergeven door while loop
echo "Mijn cijfers zijn: ";

while($tel < $aantal){
		echo $cijfers[$tel];
		echo ", ";
		$tel++;
	}
//Deel C Hoogste cijfer opnoemen door $tel = 0 en if statement herhalen tot laatste positie 
echo "<br>";
$tel = 0;

while($tel < $aantal){
	if($cijfers[$tel] > $max){
		$max = $cijfers[$tel];
		}
		$tel++;
	}
	echo "Mijn hoogste cijfer: " . $max ."<br>";

//Deel D laagste cijfer
$tel = 0;
//Vergelijking doen om laagste waarde op te halen
$max;

while($tel < $aantal){
	if($cijfers[$tel] < $max){
		$max = $cijfers[$tel];
		$min = $max;
	}
	
	$tel++;

}

echo "Mijn laagste cijfer: " . $min . "<br>";

//Deel E gemiddelde weergeven met twee decimalen
$tel = 0;

while ($tel < $aantal) {
	$cijfers[$tel];
	$totaalsom += $cijfers[$tel];
	$tel++;
}

echo "Mijn gemiddelde is: " . round(($totaalsom/11), 2) . "<br>";

//Deel F aantal onvoldoendes waarbij alles < 6 onvoldoende is

$tel = 0;
$onvoldoendes = 0;
while($tel < $aantal) {
	
	if($cijfers[$tel] < 6){
		$onvoldoendes++;
	}
	$tel++;
}

echo "Aantal onvoldoendes: " . $onvoldoendes;


?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>opdracht 100</title>
    </head>
    <body>
        
    </body>
</html>
