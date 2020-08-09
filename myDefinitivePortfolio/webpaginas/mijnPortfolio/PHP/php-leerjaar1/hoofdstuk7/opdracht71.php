<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>opdracht71</title>
    </head>
    <body>
<!--Code gemaakt door Adam Oubelkas - IO1E4-->
<?php

/*Standaard waarde*/

$allrisk = "Je hebt allrisk gekozen <br>";

/*Als er geen waarde is ingevoerd door client, geef standaard waarde*/

if(isset($_GET['verzekering'])){
	$verzekering = $_GET["verzekering"] ;
}
else {
	
	$verzekering = 	"Je hebt allrisk gekozen";
	
	echo $allrisk;
	
	}

//variabelen verzekeringstypes declareren en initializeren

$WA =					"Je hebt WA gekozen <br>
						<hr>
						Je bent verzekerd tegen: <br> 
						<hr>
						Schade aan anderen <br>
						<hr>
						Je bent niet verzekerd tegen: <br>
						<hr>
						Schade door brand, storm en natuur <br> 
						Ruitschade <br>
						Diefstal <br>
						Schade door aanrijding en overige schade <br>";


$WACascobeperkt = "Je hebt WA + Casco beperkt gekozen <br>
						<hr>
						Je bent verzekerd tegen: <br> 
						<hr>
						Schade aan anderen <br>
						Schade door brand, storm en natuur <br> 
						Ruitschade <br>
						Diefstal <br>
						<hr>
						Je bent niet verzekerd tegen: <br>
						<hr>
						Schade door aanrijding en overige schade <br>";

$WACascoALLRISK = "Je hebt WA + Casco + ALLRISK gekozen <br>
						<hr>
						Je bent verzekerd tegen: <br> 
						<hr>
						Schade aan anderen <br>
						Schade door brand, storm en natuur <br> 
						Ruitschade <br>
						Diefstal <br>
						Schade door aanrijding en overige schade <br>
						<hr>";

//if statements uitvoeren om te bepalen of deze waardes wel of niet worden uitgeprint

if ($verzekering == "WA" ) 
{
	echo $WA;
}

if ($verzekering == "WACascobeperkt" ) 
{
	echo $WACascobeperkt;
}

if ($verzekering == "WACascoALLRISK" ) 
{
	echo $WACascoALLRISK;
}

?>
        

    </body>
</html>
