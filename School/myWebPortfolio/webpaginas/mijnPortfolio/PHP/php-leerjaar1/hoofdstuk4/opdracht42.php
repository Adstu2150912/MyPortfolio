<!DOCTYPE html>
<html lang="en">
  <head>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
    <meta charset="utf-8" />
    <title>Opdrachten PHP periode 3</title>
    <script src="../../../../../scripts/jquery-3.2.0.min.js"></script>
    <script src="../../../../../scripts/Script.js"></script>
    <script>
      $(document).ready(function () {
      $('header > h1').empty('*');
      $('header > h1').css('display', 'none');
      $('header > h1').append("Hier treft u een uitgewerkte opdracht uit mijn eerste mbo leerjaar").fadeIn(1000);
      $('section > nav > h3 > a').empty();
      $('section > nav > h3 > a').css('display', 'none');
      $('section > nav > h3 > a').append("Portfoliowebsite <br/> Adam Oubelkas").fadeIn(1000);
      $('section > #main').animate({width: "80%", height: "100vh"}, 900);
      });
    </script>
  </head>
  <body>
    <header>
      <h1></h1>
    </header>
    <section>
      <nav>
        <h3>
          <a href="../../../../../index.html">
            Portfoliowebsite <br/> Adam Oubelkas
          </a>
        </h3>
        <ul>
          <li>
            <a href="../../../../Wie-ben-ik.html" id="Wie-ben-ik">Wie ben ik?</a>
          </li>
          <li>
            <a href="../../../../Mijn-opleidingen.html" id="Mijn-opleidingen">Mijn Opleidingen</a>
          </li>
          <li>
            <a href="../../../../Mijn-portfolio.html" id="Mijn-portfolio">Mijn Portfolio</a>
          </li>
          <li>
            <a href="../../../../Mijn-hobby.html" id="Mijn-hobbys">Mijn Hobby's</a>
          </li>
        </ul>
      </nav>
      <div id="main">
        <div id="wrapper">
          <h2>Opdracht 42</h2>
          <p>
            <?php
            //declareren variabel $mop

            $mop = "Weekend! Waarom gaat een Belg op vrijdag door het raam naar buiten? Het weekend staat voor de deur."; 

            //De functie substr pakt hier de string vanaf rechts en loopt af tot en met de negentigste positie  
                $mop = substr($mop,-90)."<br>";
                echo $mop;

            //De functie str_replace zorgt ervoor dat de string "Belg" vervangen wordt door een nieuwe string "blondje"   
                $mop = str_replace("Belg", "blondje", $mop) . "<br>";
                echo $mop; 
            //Deze substr_replace positioneert de gegeven nieuwe string die je wilt plaatsen in de variable $mop aan de hand van de gegeven cöordinaten 
                $mop = substr_replace($mop, "gooit", 7, 4) . "<br>";
                echo $mop;
            //Deze str_replace zorgt ervoor dat de string "op vrijdag" vervangen wordt door de string "tijdens een spelletje" in de variabel $mop
                $mop = str_replace("op vrijdag", "tijdens een spelletje", $mop) . "<br>";
                echo $mop;

            //Deze str_replace zorgt ervoor dat de string "Het weekend staat voor de deur" vervangen wordt door de string "." in de variabel $mop   
                $mop = str_replace("Het weekend staat voor de deur"," ",$mop);
                echo $mop;

            //Deze substr_replace positioneert de gegeven nieuwe string die je wilt plaatsen in de variable $mop aan de hand van de gegeven cöordinaten
                $mop = substr_replace($mop, "de dobbelsteen tegen het plafond? Wie het hoogst gooit, mag beginnen.",-72 , 59);
                echo $mop;
            ?>
          </p>
        </div>
      </div>
    </section>
    <footer>
      <p>&copy 2024 Adam Oubelkas <br> Gemaakt in HTML5, CSS3, PHP7.1 en JQuery 3.2.0.</p>
    </footer>
  </body>
</html>
