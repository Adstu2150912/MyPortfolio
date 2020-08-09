<?php
	include("functies.php")
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>opdracht 92</title>
    </head>
    <body>
		<!--Gemaakt op 2-12-2016 door Adam Oubelkas uit IO1E4-->
        <table border="1">
			<tr><th></th><th>Beschrijving</th><th>Bedrag</th><th>Totaal</th><th>BTW</th></tr>
			<?php
			
			$uur = 2;
			$uurprijs = 90;
			$btw = 21;
			$subtotaal = product($uur, $uurprijs);
			$btwbedrag = berekenBtw($btw, $subtotaal);
			$totaal = berekenTotaal($subtotaal, $btwbedrag);

			echo "<tr><td>$uur uur</td><td>Advieswerkzaamheden</td><td>&euro; $uurprijs</td><td>$subtotaal</td><td>$btw %</td></tr>";
			echo "<tr><td colspan = '2'></td><td>$subtotaal</td><td>$subtotaal</td></tr>";
			echo "<tr><td colspan='2'></td><td>21%BTW</td><td>$btwbedrag</td><td></td></tr>";
			echo "<tr><td colspan='2'></td><td>Totaal</td><td>$totaal</td><td></td></tr>";
			?>
		</table>
    </body>
</html>
