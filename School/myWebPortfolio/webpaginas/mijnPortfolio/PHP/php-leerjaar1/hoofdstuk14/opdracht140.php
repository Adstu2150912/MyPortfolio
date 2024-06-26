<?php
/**
 * Created by PhpStorm.
 * User: Adam Oubelkas
 * Date: 2/17/2017
 * Time: 9:37 AM
 */
?>
<?php
DEFINE("LEVEL","../");
include LEVEL . "includes/functies.php";
//Als client hier terugkomt, 
//maak dan voorgaande sessie leeg zodat client met een schone lei een rapport kan aanmaken

$_SESSION = array(); 
  
if (ini_get("session.use_cookies")) { 
    $params = session_get_cookie_params(); 
    setcookie(session_name(), '', time() - 42000, 
        $params["path"], $params["domain"], 
        $params["secure"], $params["httponly"] 
    ); 
}

session_destroy();
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>
        formulier voor invullen rapportgegevens
    </title>
    <link type="text/css" rel="stylesheet" href="../css/style.css">
    <meta charset="utf-8" />
	<script src="../../../../../scripts/jquery-3.2.0.min.js"></script>
	<script src="../../../../../scripts/Script.js"></script>
	<script>
            $(document).ready(function () {
                $('header > h1').empty('*');
                $('header > h1').css('display', 'none');
                $('header > h1').append("Vul onderstaande rapport in van gewenste leerling").fadeIn(1000);
			});
	</script>
</head>
<body>
 <header>          
     <h1></h1>
        </header>
        <nav>
			<h3><a href="../../../../../index.html">Portfoliowebsite <br/> Adam Oubelkas</a></h3>
            <ul>
                <li>
                    <a href="../../../../Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
                </li>
                <li>
                    <a href="../../../../Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
                </li>
                <li>
                    <a href="../../../../Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
                </li>
                <li>
                    <a href="../../../../Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
                </li>
            </ul>
        </nav>
        <section>          
            <div id="main">
				<div>
					<form method='post' action='opdracht141.php'>
						<label>Naam: </label><input name='naam' type='text' value=''>
						<label>Klas: </label><input name='klas' type='text' value=''>
						<label>Nummer: </label><input name='leerlingnummer' type='text' value=''>
						<label>Vak:</label>
						<select name='vak'>
							<option value='PHP'>PHP</option>
							<option value='Javascript'>Javascript</option>
							<option value='ASP'>ASP</option>
							<option value='SQL'>SQL</option>
						</select>
						<label>Cijfer: </label><input name='cijfer' type='number' value='5'>
						<input type='submit' value='verzend' name='verzend'>
					</form>
				</div>
         </div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP 7.1 en JQuery 3.2.0.</p>
        </footer>
    </body>
</html>
