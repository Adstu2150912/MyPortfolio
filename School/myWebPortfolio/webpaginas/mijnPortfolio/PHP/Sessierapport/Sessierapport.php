<?php
/**
 * Created by PhpStorm.
 * User: D.Lyte
 * Date: 4/12/2017
 * Time: 12:44 PM
 */

session_start();

//Als er GEEN leerlinggegevens zijn opgegeven, geef dan aan dat de leerlinggegevens onbekend zijn. 
if($_POST['naam'] == '' && empty($_SESSION['leerlinggegevens'])){
    $_SESSION['leerlinggegevens'] = ["onbekende naam", "onbekende leerlingnummer", "onbekende klas"];
}
//Zo niet, koppel $_SESSION['leerlinggegevens'] aan een array met indexwaardes $_POST['naam'],$_POST['klas'] en $_POST['leerlingnummer']
else {
    $_SESSION['leerlinggegevens'] = [$_POST['naam'],$_POST['leerlingnummer'], $_POST['klas']];
}
//Als er geen vak is met een cijfer, dan is het een onbekende vak met cijfer 0
if(empty($_POST['vak'])){
    if(array_search($_SESSION['onbekende vak'], $_SESSION['rapport']) == false){
        $_SESSION['rapport']['onbekende vak'] = 0;
    }
}

//koppel sessievariabel $_SESSION['rapport'], met indexwaarde $_POST['vak'], aan $_POST['cijfer'];
if(array_key_exists($_POST['vak'], $_SESSION['rapport']) == false){
    $_SESSION['rapport'][$_POST['vak']] += $_POST['cijfer'];
}

?>
<!DOCTYPE html>
<!--Gemaakt op 24 februari 2017 door Adam Oubelkas uit IO1E4-->
<html lang="en">
<head>
	<title>
        rapportoverzicht
    </title>
   <link type="text/css" rel="stylesheet" href="SessieRapport.css">
    <meta charset="utf-8" />
	<script src="../../../../../../scripts/jquery-3.2.0.min.js"></script>
	<script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Let op! Er kan slechts 1 cijfer worden ingevoerd voor één vak!").fadeIn(1000);
			});
	</script>
    <meta charset="utf-8" />
    <!--print de eerste en tweede indexwaarde uit van sessievariabel 'leerlinggegevens' -->
    <title>SessieRapport</title>
</head>
<body>
<header>          
     <h1></h1>
        </header>
		<nav>
			<h3><a href="../../../../../../../index.html">Portfolio website <br> Adam Oubelkas</a></h3>
                <ul>
                    <li>
                        <a href="../../../../../../webpaginas/Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
                    </li>
                    <li>
                        <a href="../../../../../../webpaginas/Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
                    </li>
                    <li>
                        <a href="../../../../../../webpaginas/Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
                    </li>
                    <li>
                        <a href="../../../../../../webpaginas/Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
                    </li>
                </ul>
            </nav>
        <section>          
            <div id="main">
				<div>
				<table>
				<!--print de eerste indexwaarde uit van sessievariabel 'leerlinggegevens' -->
				<!--<p>Rapport van  leerling <br><?php //echo $_SESSION['leerlinggegevens'][0]?> met <br>
					<!--print de derde indexwaarde uit van sessievariabel 'leerlinggegevens' -->
					<!--leerlingnummer <?php //echo $_SESSION['leerlinggegevens'][2]?> <br>
					<!--print de tweede indexwaarde uit van sessievariabel 'leerlinggegevens' -->
					<!--uit klas <?php //echo $_SESSION['leerlinggegevens'][1]?></p>-->
					<thead>
					<tr><td>Rapport van  leerling: <br><?php echo $_SESSION['leerlinggegevens'][0]?></td><td></td></tr>
						<tr><td>Leerlingnummer: <?php echo $_SESSION['leerlinggegevens'][1]?></td><td></td></tr>
						<tr><td>Klas: <?php echo $_SESSION['leerlinggegevens'][2]?></td><td></td></tr>
					<tr>
						<td>vak</td>
						<td>Cijfer</td>
					</tr>
					</thead>
					<tbody>
					<?php
					//Print alle $key waardes uit die gekoppeld zijn aan bijhorende $value, vanuit sessievariabel 'rapport'
					foreach ($_SESSION['rapport'] as $key => $value){
						//koppel sessievariabel $_SESSION['rapport'], met indexwaarde $_POST['vak'], aan $_POST['cijfer'];
							if(array_key_exists($_POST['vak'], $_SESSION['rapport']) == false) {
								echo "<tr><td>" . $_POST['vak'] . "</td>" . "<td>" . round($_POST['cijfer'], 2) . "</td></tr>";
							}
							else{
								echo "<tr><td>" . $key . "</td>" . "<td>" . $value . "</td></tr>";
							}
					}
					?>
					<tr><td>Gemiddelde</td>
						<td><?php
							$averageSum =0;
							foreach ($_SESSION['rapport'] as $key => $value){
								$averageSum += $value;
							}
							$averageNum = $averageSum / (count($_SESSION['rapport']));
							echo $averageNum;?></td>
					</tr>
					<tr><td>Resultaat</td>
					<td><?php
						if($averageNum >= 5.5){
							echo "Je bent over!";
						}
						else {
							echo "Je blijft zitten!";
						}
						?></td>
					</tr>
					</tbody>
				</table>
				<form method="post" action="Sessierapport.php">
					<?php
					`   `
					?>
					<label>Vak:</label>
					<select name='vak'>
						<option value='PHP'>PHP</option>
						<option value='Javascript'>Javascript</option>
						<option value='ASP'>ASP</option>
						<option value='SQL'>SQL</option>
					</select>
					<br>
					<label>Cijfer: </label>
					<input type="number" name="cijfer" value="">
					<br>
					<input type="submit" name="verzend" value="Verzend">
				</form>
				</div>
			</div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP 7.1 en JQuery 3.2.0.</p>
        </footer>
    </body>
</html>

