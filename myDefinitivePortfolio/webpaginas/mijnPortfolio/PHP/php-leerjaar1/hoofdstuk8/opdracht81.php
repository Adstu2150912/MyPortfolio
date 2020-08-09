

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>opdracht 81</title>
    </head>
    <body>
		<!--Gemaakt op 25/11/2016 door Adam Oubelkas uit IO1E4-->
        <?php
			//teller (1,2,3,4,5,6,7,8,9,10) ophogen zodat de loop stopt bij 10
			$teller = 1;
		//variabel voor de bijhorende tafel
            $tafel = 1;
    //printen van de tabelkop
    echo "<table border='1' style='float: left;'>
            <tr><th colspan='2'>Tafel van $tafel</th></tr>";
            
            //de tafel van 5 in rijen en cellen printen    
            while ($tafel < 11) {
				//twee cellen per rij uitprinten totdat er 10 rijen zijn 
                       if($teller < 11){
                        $uitkomst = $teller * $tafel;
                        echo "<tr><td>$teller</td><td>$uitkomst</td></tr>";
                        $teller++;
                        }
				//Wanneer er 10 rijen zijn gemaakt voor 1 tabel, begin met nieuw tabel
                      elseif($teller >= 11){
                        echo "</table>";
						$tafel++;
						if($tafel < 11){
                        echo "<table border='1' style='float: left;'>
            <tr><th colspan='2'>Tafel van $tafel</th></tr>";
                        
                        $teller = 1;
						}
                      }     
            }
    //afsluiten van de tabel
    echo    '</table>';
?>
    </body>
</html>
