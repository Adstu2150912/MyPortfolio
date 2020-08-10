<?php
include('functies.php');
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title></title>
    </head>
    <body>
		<!--Gemaakt op 1-12-2016 door Adam Oubelkas uit IO1E4-->
        <?php 
			//Aanroepen van functie 'printGroet'
			$tafel=1;
			while($tafel<11) {
				PrintTafel($tafel);
				$tafel++;				
			}
		?>
    </body>
</html>
