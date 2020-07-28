<?php
//begin met PHP sessie    
session_start();
//hier worden alle highscores opgeslagen in een sessie array
$_SESSION['highScores'];
//als de onderstaande GET variabel een waarde heeft, koppel die waarde aan sessievariabel
//hierdoor wordt deze waarde opgeslagen in een sessiearray
if(isset($_GET['newHighscore'])){
        array_push($_SESSION['highScores'], $_GET['newHighscore']); 
}
//Sorteer de waardes in sessie array van hoog naar laag
rsort($_SESSION['highScores']);

//Koppel de keys aan bijhorende indexwaarde van sessie array 'highScores'
$_SESSION['highScores'] = array( "eerste" => $_SESSION['highScores'][0],
"tweede" => $_SESSION['highScores'][1],
"derde" => $_SESSION['highScores'][2]
);

//koppel onderstaande variabel 'aSessie' aan sessie array 'highScores'
$aSessie = $_SESSION['highScores'];

//Zet de Array om in een JSON string
$jsonString = json_encode($aSessie);

//print JSON String uit
echo $jsonString;

?>