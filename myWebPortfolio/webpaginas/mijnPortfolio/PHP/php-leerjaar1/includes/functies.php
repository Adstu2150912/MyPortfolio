<?php
/**
 * Created by PhpStorm.
 * User: Abu
 * Date: 2/5/2017
 * Time: 7:20 PM
 */

$aOpdrachten = [
    array( "file" => "hoofdstuk0/opdracht00/helloworld.php", "label" => "Opdracht 0 - Hello world")
    ,array( "file" => "hoofdstuk1/opdracht10/opdracht10.php", "label" => "Opdracht 10")
    ,array( "file" => "hoofdstuk2/opdracht20/opdracht20.php", "label" => "Opdracht 20")
    ,array( "file" => "hoofdstuk3/opdracht30/opdracht30.php", "label" => "Opdracht 30")
    ,array( "file" => "hoofdstuk4/opdracht40.php", "label" => "Opdracht 40")
    ,array( "file" => "hoofdstuk4/opdracht41.php", "label" => "Opdracht 41")
    ,array( "file" => "hoofdstuk4/opdracht42.php", "label" => "Opdracht 42")
    ,array( "file" => "hoofdstuk5/opdracht50.php", "label" => "Opdracht 50")
    ,array( "file" => "hoofdstuk5/opdracht51.php", "label" => "Opdracht 51")
    ,array( "file" => "hoofdstuk6/opdracht61.php", "label" => "Opdracht 61")
    ,array( "file" => "hoofdstuk6/opdracht62.php", "label" => "Opdracht 62")
    ,array( "file" => "hoofdstuk7/opdracht71.php", "label" => "Opdracht 71")
    ,array( "file" => "hoofdstuk7/opdracht72.php", "label" => "Opdracht 72")
    ,array( "file" => "hoofdstuk8/opdracht81.php", "label" => "Opdracht 81")
    ,array( "file" => "hoofdstuk9/opdracht90/opdracht90.php", "label" => "Opdracht 90")
    ,array( "file" => "hoofdstuk9/opdracht91/opdracht91.php", "label" => "Opdracht 91")
    ,array( "file" => "hoofdstuk9/opdracht92/opdracht92.php", "label" => "Opdracht 92")
    ,array( "file" => "hoofdstuk10/opdracht100/opdracht100.php", "label" => "Opdracht 100")
    ,array( "file" => "hoofdstuk10/opdracht101/opdracht101.php", "label" => "Opdracht 101")
    ,array( "file" => "hoofdstuk10/opdracht102/opdracht102.php", "label" => "Opdracht 102")
    ,array( "file" => "hoofdstuk11/opdracht110/opdracht110.html", "label" => "Opdracht 110")
    ,array( "file" => "hoofdstuk11/opdracht111.php", "label" => "Opdracht 111")
    ,array( "file" => "hoofdstuk12/form.php", "label" => "Opdracht 120")
    ,array( "file" => "hoofdstuk13/opdracht130.php", "label" => "Opdracht 130")
    ,array( "file" => "hoofdstuk13/opdracht131.php", "label" => "Opdracht 131")
    ,array( "file" => "hoofdstuk14/opdracht140.php", "label" => "Opdracht 140")
    ,array( "file" => "hoofdstuk14/opdracht141.php", "label" => "Opdracht 141")
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