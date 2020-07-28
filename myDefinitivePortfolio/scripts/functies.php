<?php
/*
Opdracht:       Portfoliowebsite
Auteur:         <Adam Oubelkas>
Aanmaakdatum:   <23-11-2016 + 14:09>
Bestandsnaam:   <functies.php>
*/ 

define('SALT', 'portfolio');

$wachtwoord;

//Checked of er al is ingelogd
//Zo ja, verwijs naar cijferlijstpagina
//Zo niet, verwijs naar het inlogpagina
function inloggen($w8w) {
    if(isset($_POST['wachtwoord'])) {
        $_SESSION['wachtwoord'] = $_POST['wachtwoord'];
        return header('location: cijferlijst.php');
    } else {
        return header('location: login.php');   
    }
}

//Checked of de ingevoerde wachtwoord klopt
//Zo ja, wordt de bezoeker verwezen naar de cijferlijst pagina
//Zo niet, dan krijgt de bezoeker een foutmelding
function isWachtwoord($isw8w) {
    if(isset($_POST['wachtwoord'])) {
        if($_POST['wachtwoord'] == 'sesam123'){
            $_SESSION['loggedIn'] = TRUE;
            header('location: cijferlijst.php');
        }
        else {
            return 'Voer een geldig wachtwoord in!';
        }
    }
}

//Checked of er een wachtwoord is ingevoerd
function isLeeg() {
    if(empty($wachtwoord)){
        return 'Het is verplicht om wachtwoord in te voeren!';
    }
}

/************************
* verzend mail via een post naar een andere host
* @param $sendArgs bevat minimaal een to, maar subject en body is ook fijn
* @return is 1 bij succesvolle verzending anders leeg of een andere foutmelding
****************/
function sendEmail($sendArgs){
    if (isset($sendArgs['to']) && !empty($sendArgs['to'])) {
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL,"http://itstudy.eu/kw1c/php/send.php");
        curl_setopt($ch, CURLOPT_POST, 1);
        //curl_setopt($ch, CURLOPT_POSTFIELDS, "postvar1=value1&postvar2=value2");
        $sendArgs['ha'] = hash('sha256', SALT.$sendArgs['to']);
        curl_setopt($ch, CURLOPT_POSTFIELDS, 
             http_build_query($sendArgs));
        // receive server response ...
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        $response = curl_exec ($ch);
        curl_close ($ch);
        return $response;
    }  
    else {
      return "geen to";   
    } 
}

?>