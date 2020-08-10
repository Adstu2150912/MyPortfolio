<?php
/**
 * Created by PhpStorm.
 * User: Abu
 * Date: 2/5/2017
 * Time: 7:20 PM
 */

$aOpdrachten = [
    array( "file" => "hoofdstuk13/opdracht130.php", "label" => "Opdracht 130")
    ,array( "file" => "hoofdstuk13/opdracht131.php", "label" => "Opdracht 131")
    ,array( "file" => "hoofdstuk14/opdracht140.php", "label" => "Opdracht 140")
    ,array( "file" => "hoofdstuk15/opdracht150.php", "label" => "Opdracht 150")
    ,array( "file" => "hoofdstuk16/opdracht160.php", "label" => "Opdracht 160")
    ,array( "file" => "hoofdstuk17/opdracht170.php", "label" => "Opdracht 170")
];

/****
 * descr: print alle opdrachten als een listitem links
 * @param geen
 * @return niks
****/
function printOpdrachten() {
    global $aOpdrachten;

    foreach ( $aOpdrachten as $opdr) {
        echo "<li><a href='".LEVEL.$opdr["file"]."'>".$opdr["label"]."</a>";
    }
}

//Functie maken voor het printen van de array in een tabel
function printMenu($menuOptie){

    $aMenu = array( 'Nieuws' => 'http://nu.nl',
        'Contact' => 'contact.php',
        'Locatie' => 'locatie.php',
        'Zoeken' => 'zoeken.php' );
    //Begin met het aanmaken van een tabel zonder de tabel af te sluiten
    echo "<table>
            <tr>";
    //Print alle menu opties uit en print de opgegeven menu optie een ander achtergrond kleur, De foreach gaat de hele array langs om te zoeken wat je hebt opgegeven als parameter
    foreach ($aMenu as $key => $value){
        if($menuOptie == $key){
            echo "<td style='background-color: #6c0c11'><a href='" . $value .  "'>$menuOptie</a></td>";
        }
        else{

            echo "<td><a href='" . $value .  "'>$key</a></td>";
        }

    }
    //Hier wordt de tabel afgesloten
    echo  "</tr> </table>";
}



session_start();

if (!isset($_SESSION['stok'])) {
    $_SESSION['stok'] = array();
}

if (!isset($_SESSION['spel'])) {
    $_SESSION['spel'] = array("schoppen" => array() , "klaveren" => array(), "ruiten" => array(), "harten" => array()); 
    //Begin met een saldo van een willekeurig berekende bedrag tussen 1 t/m 100 euro
    $_SESSION['userSaldo']= rand(1, 100);
}

if (!isset($_SESSION['nieuwspel'])) {
    $_SESSION['nieuwspel'] = true;
    $_SESSION['totaalspeler'] = 0;
}

// trek kaart
// werk de sessie bij
// print kaart
function trekKaart() {
    global $aNumbers;
    global $aValues;
    $kleur = rand(0,3);
    $kaart = rand(0, 12);
    $kleuren = array("schoppen", "klaveren", "ruiten", "harten");
    //totaal optellen bij de vorige score
    $_SESSION['totaalspeler'] += $aValues[$kaart];
    //Voeg de kaart toe aan de sessie
    if (!in_array($aNumbers[$kaart],$_SESSION['spel'][$kleuren[$kleur]])) {
        $_SESSION['spel'][$kleuren[$kleur]][] = $aNumbers[$kaart];
    }
    echo "<p class='".$kleuren[$kleur]." ".$aNumbers[$kaart]."'></p>";
}

//Print vanuit de sessie de getrokken kaarten
function printGetrokkenKaarten() {
    //Toont alle getrokken kaarten uit de sessievariabele $_SESSION['spel']
    $getrokkenKaarten = $_SESSION['spel'];
    foreach($getrokkenKaarten as $kleur => $kaarten) {
        $tel = 0; $aantal = count($kaarten);
        while($tel < $aantal) {
            echo "<p class='".$kleur." ".$kaarten[$tel]."'></p>";
            $tel++;
        }
    }
}

function resetSpel() {
    $_SESSION['nieuwspel'] = true;
    $_SESSION['totaalspeler'] = 0;
    $_SESSION['spel'] = array("schoppen" => array() , "klaveren" => array(), "ruiten" => array(), "harten" => array());
}


?>