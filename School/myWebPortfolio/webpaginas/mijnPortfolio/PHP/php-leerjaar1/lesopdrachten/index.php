<?php
    DEFINE("LEVEL","./");
    include "includes/functies.php";
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <meta charset="utf-8" />
        <title>Opdrachten overzicht PHP periode 3</title>
    </head>
    <body>
        <header><h1>ICT academie AO</h1></header>
        <nav>
            <ul>
                <?php
                    printOpdrachten();
                ?>
            </ul>
        </nav>
        <div id="wrapper">
            <h2>Opdrachten PHP periode 3</h2>
            <p>Dit is de startpagina van de website waarin je alle opdrachten van PHP uitwerkt en oplevert.
            </p>
	    </div>
    </body>
</html>