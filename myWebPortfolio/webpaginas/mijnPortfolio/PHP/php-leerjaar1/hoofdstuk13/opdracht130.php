<?php
DEFINE("LEVEL","../");
include LEVEL."includes/functies.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <link type="text/css" rel="stylesheet" href="../css/style.css">
    <meta charset="utf-8" />
    <title>Opdrachten PHP periode 3</title>
	<script src="../../../../scripts/jquery-3.2.0.min.js"></script>
	<script src="../../../../scripts/Script.js"></script>
    <script>
        $(document).ready(function () {
            $('header > h1').empty('*');
            $('header > h1').css('display', 'none');
            $('header > h1').append("Hier treft u een uitgewerkte opdracht uit mijn eerste mbo leerjaar").fadeIn(1000);
            $('section > nav > h3 > a').empty();
            $('section > nav > h3 > a').css('display', 'none');
            $('section > nav > h3 > a').append("Portfoliowebsite <br/> Adam Oubelkas").fadeIn(1000);
			$('section > #main').animate({width: "80%", height: "100vh"}, 900);
        });
    </script>
</head>
	<body>
        <header>
            <h1></h1>
        </header>
        <section>
            <nav>
				<h3><a href="../index.html">Portfoliowebsite <br/> Adam Oubelkas</a></h3>
                <ul>
                    <li>
                        <a href="../webpaginas/Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
                    </li>
                    <li>
                        <a href="../webpaginas/Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
                    </li>
                    <li>
                        <a href="../webpaginas/Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
                    </li>
                    <li>
                        <a href="../webpaginas/Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
                    </li>
                </ul>
            </nav>
            <div id="main">
				<div id="wrapper">
					<h2>Opdracht 130</h2>
					<table>
						<thead>
							<tr>
								<td>Hoofdstuk</td>
								<td>Onderwerpen</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>0</td>
								<td>Inleiding</td>
							</tr>
							<tr>
								<td>1</td>
								<td>Variabelen en waardes</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Strings koppelen</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Stringfuncties</td>
							</tr>
							<tr>
								<td>4</td>
								<td>Nog meer stringfuncties</td>
							</tr>
							<tr>
								<td>5</td>
								<td>'GET' parameters</td>
							</tr>
							<tr>
								<td>6</td>
								<td>Getallen: bits en bytes</td>
							</tr>
							<tr>
								<td>7</td>
								<td>Beslissingen met if- en else-statements</td>
							</tr>
							<tr>
								<td>8</td>
								<td>While loop</td>
							</tr>
							<tr>
								<td>9</td>
								<td>Functies</td>
							</tr>
							<tr>
								<td>10</td>
								<td>Arrays</td>
							</tr>
							<tr>
								<td>11</td>
								<td>Formulier</td>
							</tr>
							<tr>
								<td>12</td>
								<td>Sessie</td>
							</tr>
						</tbody>
					</table>
					<p>
						<?php
						//uitwerking opdracht 130
						?>
					</p>
			</div>
		</div>
        </section>
        <footer>
            <p>&copy 2020 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
        </footer>
	</body>
</html>