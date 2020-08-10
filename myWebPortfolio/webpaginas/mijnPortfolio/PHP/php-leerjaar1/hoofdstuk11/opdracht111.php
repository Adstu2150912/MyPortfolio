<?php
//Variabel $getal is gelijk aan 0
$getal = NULL;
//Variabel $msg met instructieve informatie	
$msg = "vul een getal in tussen 10 en 20";
//Wanneer er een getal is ingevoerd variabel $getal is gelijk aan ingevoerde getal
if(isset($_GET['getal'])) {
	$getal = $_GET['getal'];
    //Wanneer client getal tussen 10 en 20 ingevuld heeft, koppel $msg aan bijhorende string
		if($getal > 10 && $getal < 20){
		$msg = "bedankt voor uw getal $getal";
		}
        //Als voorafgaande if statement false is, koppel $msg aan onderstaande string ernaast 
		else {
			$msg = "getal is niet tussen 10 en 20";
		}
        //Als client leeg formulier verstuurd, koppel $msg aan onderstaande string ernaast 
		if(empty($_GET['getal'])) {
		$msg = 'getal is verplicht!';
		}
}




//empty();
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Formulier en $_GET</title>
         <style>
            section {
                width:  40%;
                margin:  auto;
                padding:  1em;
                border: 1px solid black;
            }
        </style>
    </head>
    <body>      
        <section>      
        <form method="get" action="opdracht111.php">
            <label>Getal 1: </label><input type="text" value="<?php echo $getal ?>" name ="getal">
            <input type="submit" name="verzend" value="verzend">
        </form>
        <p><?php echo $msg; ?></p>
        </section>
    </body>
</html>
