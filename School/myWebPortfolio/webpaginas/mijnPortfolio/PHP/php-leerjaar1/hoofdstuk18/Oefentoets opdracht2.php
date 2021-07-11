<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>Opdracht 18.2</title>
</head>
<body>
<?php
$gemiddeldeLeeftijdM = 0;
$gemiddeldeLeeftijdV = 0;
//het geslacht van man en vrouw
$aGente = array( 'jan'=> 'm',
    'alice'=> 'v',
    'veronica'=> 'v',
    'herman'=> 'm',
    'maria'=> 'v',
    'angelica' => 'v' ,
    'pieter' => 'm' ,
    'abdel' => 'm');

//De leeftijd
$aLeeftijd = array(
    'jan'=> 66,
    'alice'=> 21,
    'veronica'=> 45,
    'herman'=> 22,
    'maria'=> 62,
    'angelica' => 23,
    'pieter' => 46,
    'abdel' => 22);
//Lege array voor beide maken
$amannen = array();
$avrouwen = array();

foreach ($aLeeftijd as $naam => $leeftijd){
    if($aGente[$naam] == 'm'){
        $gemiddeldeLeeftijdM += $leeftijd;
        if(isset($amannen[$naam])){
            $amannen[$naam] += $aLeeftijd[$naam];
        }
        else{
            $amannen[$naam] = $aLeeftijd[$naam];
        }
    }
    elseif ($aGente[$naam] == 'v'){
        $gemiddeldeLeeftijdV +=$leeftijd;
        if(isset($avrouwen[$naam])){
            $avrouwen[$naam] += $aLeeftijd[$naam];
        }
        else{
            $avrouwen[$naam] = $aLeeftijd[$naam];
        }
    }

}
//Array mannen wegschrijven in een variabelen
$man = array_keys($amannen);

//Array vrouwen wegschrijven in een variabelen
$vrouw = array_keys($avrouwen);


?>

<?php
foreach($aGente as $key => $value){
    if($value == 'm'){
        $mLeeftijd = $aLeeftijd[$key];
        foreach($aGente as $_key => $_value){
            if($_value == 'v'){
                $vLeeftijd = $aLeeftijd[$_key];
                if(($mLeeftijd - $vLeeftijd) >= -5 && ($mLeeftijd - $vLeeftijd) <= 5){
                    echo $key . " en " . $_key . " Horen bij elkaar" . "<br>";
                }
            }
        }
    }
}



?>
</body>
</html>