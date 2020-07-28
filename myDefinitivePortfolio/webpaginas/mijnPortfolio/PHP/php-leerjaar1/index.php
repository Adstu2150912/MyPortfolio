<?php
  /*php-pagina met php functies*/
  DEFINE("LEVEL","./");
  include('../scripts/functies.php');
  include('includes/functies.php');
  /*sessie erbij halen*/
  session_start();
  /*if-elseconstructie*/
  if(isset($_SESSION['loggedIn']) == false){
      header('location: ../../../login.php');
  }
  else {
      if($_SESSION['loggedIn'] != true) {
          header('location: ../../../login.php');
      }
  }
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <meta charset="utf-8" />
        <title>Opdrachten overzicht PHP leerjaar 1</title>
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
            <h2>Opdrachten PHP Leerjaar 1</h2>
            <p>Dit is de startpagina van de website waarin ik alle opdrachten van PHP uitwerk en oplever.
            </p>
	    </div>
    </body>
</html>