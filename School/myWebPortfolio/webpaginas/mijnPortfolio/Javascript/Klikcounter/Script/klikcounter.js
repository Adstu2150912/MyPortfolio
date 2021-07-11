//<!--Gemaakt op 9-12-2016 door Adam Oubelkas uit IO1E4-->

//declarering variabelen van vergelijkingen na te gaan voorin statements
var highscorelist = [0, 0, 0];
var highscore = 0;
var ronde = 0;
var aantal = highscorelist.length;

//huidige knop wordt vervangen door 'klik hier' knop
function hide(){
	document.getElementById('klikker').style.visibility = "hidden";
	document.getElementById('klikker2').style.visibility = "visible";
	document.getElementById('klikker2').innerHTML = "Klik hier!";
	ronde++;
	setTimeout(function () {
		// Deze code wordt pas na 5000 milliseconden uitgevoerd
		alert("Tijd is om, 5 seconden zijn voorbij!");
		highscorelist.unshift(highscore);
		//array 'highscorelist' wordt gesorteerd van groot naar klein
		highscorelist.sort(function (a, b) { return b - a });
		highscorelist.pop();
		//haal de hoogste highscores van groot naar klein
		document.getElementById('score1').innerHTML = highscorelist[0];
		document.getElementById('score2').innerHTML = highscorelist[1];
		document.getElementById('score3').innerHTML = highscorelist[2];
		document.getElementById('highscore').innerHTML = "Jouw highscore: " + highscore + "<br>Ronde: " + ronde + "<br>array: " + highscorelist;
		//verberg 'klik hier!' knop en maak de start knop zichtbaar
		document.getElementById('klikker').style.visibility = "visible";
		document.getElementById('klikker2').style.visibility = "hidden";
		highscore = 0;
	}, 5000);
}
//tel aantal keren klikken op de 'klik hier!' knop
function tijdstimer(){
	highscore++;
}


