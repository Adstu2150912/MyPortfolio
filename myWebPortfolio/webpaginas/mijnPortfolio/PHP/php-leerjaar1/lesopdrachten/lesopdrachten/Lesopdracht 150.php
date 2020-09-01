<?php
/**
 * Created by PhpStorm.
 * User: D.Lyte
 * Date: 2/22/2017
 * Time: 2:50 PM
 */
$aClubs = array("Jörgensen"=>"Feyenoord"
,"Ghoochannejhad"=>"sc Heerenveen"
,"Armenteros"=>"Heracles"
,"Weghorst"=>"AZ"
,"Dolberg"=>"Ajax"
,"ünal"=>"FC Twente"
,"v.Wolfswinkel"=>"Vitesse"
,"Klaassen"=>"Ajax"
,"Mahi"=>"FC Groningen"
,"Sol"=>"Willem"
,"Baker"=>"Vitesse"
,"Haller"=>"FC Utrecht"
,"Pereiro"=>"PSV");

$aDoelpunten = array("Jörgensen" => 15
,"Ghoochannejhad" => 13
,"Armenteros" => 10
,"Weghorst" => 10
,"Dolberg" => 10
,"ünal" => 10
,"v.Wolfswinkel" => 10
,"Klaassen" => 10
,"Mahi" => 9
,"Sol" => 9
,"Baker" => 9
,"Haller" => 9
,"Pereiro" => 8);

foreach ($aClubs as $key=>$value) {
    echo  "<br>" . "Speler "  . $key . " speelt bij " . $value . " en heeft " . $aDoelpunten[$key] . " doelpunten gescoord." ;
}

?>