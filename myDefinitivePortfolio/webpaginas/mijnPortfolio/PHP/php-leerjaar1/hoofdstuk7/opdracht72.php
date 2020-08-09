<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>opdracht 72</title>
    </head>
    <body>
<!--Code gemaakt door Adam Oubelkas - IO1E4-->
        <?php

//Met isset functie een default waarde geven wanneer geen waarde door client wordt opgegeven

if (isset($_GET['aantalpersonen']))
{
	$aantalpersonen = $_GET['aantalpersonen'];
	
}
else 
{
	$aantalpersonen = 1;
}
if (isset($_GET['bezoeksnummer']))
{
	$bezoeksnummer = $_GET['bezoeksnummer'];
}

else
{
	$bezoeksnummer = 1;
}

//Hier wordt d.m.v. if en else statements vergelijkt welke waardes teruggegeven moet worden

//Wanneer aantal personen en als bezoeksnummer gelijk is aan 1 print 35% korting uit
if ($aantalpersonen == 1)
{
	if ($bezoeksnummer == 1)
	{
	echo "Aantal personen op één pas: <br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "35% <hr>";
	}
}

/*Wanneer aantal personen gelijk is aan-/of groter is dan 1 
en ook bezoeksnummer gelijk is aan-/of groter is dan 2 print 10% korting uit*/
/*Maar bezoeksnummer moet NIET gelijk zijn aan 5*/
/*else*/ if ($aantalpersonen >= 1  && $bezoeksnummer >= 2 )
	{
		if ($bezoeksnummer <> 5)
		{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "10% <hr>";
	}
	}

//Wanneer aantal personen gelijk is aan 5 en wanneer bezoeksnummer gelijk is aan 5
//print dan 20% korting uit
/*else*/ if ($aantalpersonen == 5)
	{
		if ($bezoeksnummer == 5)
		{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "20% <hr>";
		}
	}

//Wanneer aantal personen gelijk is aan 4 en ook bezoeksnummer gelijk is aan 5 
//print dan 30% korting uit
/*else*/ if ($aantalpersonen == 4 && $bezoeksnummer == 5)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "30% <hr>";
}

//Wanneer aantal personen gelijk is aan 3 en ook bezoeksnummer gelijk is aan 5
//print dan 33% korting uit
/*else*/ if ($aantalpersonen == 3 && $bezoeksnummer == 5)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "33% <hr>";
}

//Wanneer aantal personen gelijk is aan 2 en ook bezoeksnummer gelijk is aan 5
//print dan 50% korting uit
/*else*/ if ($aantalpersonen == 2 && $bezoeksnummer == 5)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "50% <hr>";
}

//Wanneer aantal personen gelijk is aan 1 en ook bezoeksnummer gelijk is aan 5
//print dan 50% korting uit
/*else*/ if ($aantalpersonen == 1 && $bezoeksnummer == 5)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "50% <hr>";
}

//Wanneer aantal personen gelijk is aan 6 en ook bezoeksnummer gelijk is aan 5
//print dan 16,66% korting uit
/*else*/ if ($aantalpersonen == 6 && $bezoeksnummer == 5)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "16,66% <hr>";
}

//Wanneer aantal personen gelijk is aan 6 en ook bezoeksnummer gelijk is aan 1
//print dan 15% korting uit
/*else*/ if ($aantalpersonen == 6 && $bezoeksnummer == 1)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "15% <hr>";
}

//Wanneer aantal personen gelijk is aan 5 en ook bezoeksnummer gelijk is aan 1
//print dan 20% korting uit
/*else*/ if ($aantalpersonen == 5 && $bezoeksnummer == 1)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "20% <hr>";
}

//Wanneer aantal personen gelijk is aan 4 en ook bezoeksnummer gelijk is aan 1
//print dan 25% korting uit
/*else*/ if ($aantalpersonen == 4 && $bezoeksnummer == 1)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "25% <hr>";
}

//Wanneer aantal personen gelijk is aan 3 en ook bezoeksnummer gelijk is aan 1
//print dan 30% korting uit
/*else*/if ($aantalpersonen == 3 && $bezoeksnummer == 1)
{
	echo "Aantal personen op één pas:<br> <hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "30% <hr>";
}

//Wanneer aantal personen gelijk is aan 2 en ook bezoeksnummer gelijk is aan 1
//print dan 35% korting uit
/*else*/ if ($aantalpersonen == 2  && $bezoeksnummer == 1)
{
	echo "Aantal personen op één pas:<br><hr>";
	echo "$aantalpersonen <br> <hr>";
	echo "Korting bezoek $bezoeksnummer :<br> <hr>";
	echo "35% <hr>";
}

?>
    </body>
</html>
