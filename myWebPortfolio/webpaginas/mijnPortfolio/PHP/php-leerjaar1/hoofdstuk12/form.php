<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Formulier en $_GET</title>
         <style>
            section {
                width:  40%;
                margin:  auto;
                padding:  1em;
                border: 1px solid black;
            }
            label {
                 display:  inline-block;
                 width: 100px;
             }
             input {
                 margin: 0.1em;
             }
        </style>
    </head>
    <body>      
        <section>
        <p>
Wat is je naam?
        </p>      
         </p>
        <form method="post" action="sessie.php">
            <label>Naam : </label>
            <input type="text" value="" name ="naam">
            <br><input type="submit" name="verzend" value="verzend">
        </form>       
        </section>
    </body>
</html>
