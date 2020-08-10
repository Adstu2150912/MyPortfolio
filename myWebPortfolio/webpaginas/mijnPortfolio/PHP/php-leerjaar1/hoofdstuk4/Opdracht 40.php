<?php
    //Copy & Paste by Adam Oubelkas - IO1E4

$sZin = "Dit is een zin. dit is een tweede zin. Dit een derde.";

/*
strpos zoekt vanaf de linkerkant en stopt als het gevonden is
strrpos zoekt vanaf de rechterkant en stopt als het gevonden is
stripos als de eerste maar dan zonder onderscheid van hoofd of kleine letters
strripos als de tweede maar dan zonder onderscheid van hoofd of kleine letters
*/

$dit = "dit";

echo strpos ($sZin, "$dit"). "<br>";
echo strrpos ($sZin, "$dit"). "<br>";
echo stripos ($sZin, "$dit"). "<br>";
echo strripos ($sZin, "$dit"). "<br>";

?>
