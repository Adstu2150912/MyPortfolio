<?php
	//functie 'PrintTafel print slechts 1 aangegeven tafel uit'
	 function PrintTafel ($tafel){

		 $teller = 1;
	 	
		 echo "<table border='1' style='float: left;'>
            <tr><th colspan='2'>Tafel van $tafel</th></tr>";

			while ($teller < 11) {
                        $uitkomst = $teller * $tafel;
                        echo "<tr><td>$teller</td><td>$uitkomst</td></tr>";
                        $teller++;  
            }
    echo    '</table>';
	 }
?>

