<?php

include "kaarten.php";
include "functies.php";

?>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <link type="text/css" rel="stylesheet" href="style.css">
        <!--<link type="text/css" rel="stylesheet" href="style.css">-->
        <meta charset="utf-8" />
        <title>Kaarten opdracht</title>
        <style>
            <?php
            $tel=0;
            while ($tel < count($aNumbers)) {
                echo "\n.".$aNumbers[$tel]." { background-position-x: -". ($tel)*79 ."px; }";
                $tel++;
            }
            ?>
        </style>
    </head>
    <body>
    <header><h1>Black Jack</h1></header>
    <div id="wrapper">
        <h2>Kaarten</h2>
        <?php

        echo "<div style='position:relative'>";

        $deg = -45;
        while ($tel < 52) {
            //echo "<p class='blind' style='left:". $tel*4 ."px; transform: rotate(". $deg ."deg)'></p>";
            echo "<p class='blind' style='left:". $tel*4 ."px'></p>";
            //$deg = -45 + ($tel * 90/52);
            $tel++;
        }

        echo "</div>";
        $totaal = 0;
        echo "<div class='game'>";
        //Start van het spel; trek 2 kaarten
        if ($_SESSION['nieuwspel']) {
            echo "<hr>";
            // trek 2 kaarten
            $kaart = trekKaart();
            $kaart = trekKaart();
            $_SESSION['nieuwspel'] = false;
        } // trek 1 kaart
        elseif (isset($_GET['trek']) && !$_SESSION['nieuwspel']) {
            printGetrokkenKaarten();
            $kaart = trekKaart();
        }
        elseif (isset($_GET['opnieuw'])) {
            resetSpel();
            header ('location: blackjack2.php');
        }
        //Passen en nu is het de beurt aan de computer
        else {
            printGetrokkenKaarten();
            //TODO
            //....
        }

        echo "<form method='get'>";
        echo "<input type='submit' name='trek' value='".$_SESSION['totaalspeler']." Trek nog een kaart'>";
        echo "<input type='submit' name='pas' value='Pas'>";
        echo "<input type='submit' name='opnieuw' value='Reset'>";
        echo "</form>";
        echo "</div>";
        ?>
    </div>
    </body>
    </html>