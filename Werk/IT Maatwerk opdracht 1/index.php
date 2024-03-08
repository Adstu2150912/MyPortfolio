<html>
	<head>
		<title>
			adamo.wp-concept.nl
		</title>

		<style>
		* { font-family: verdana; font-size: 10pt; COLOR: gray; }
		b { font-weight: bold; }
		table { height: 50%; border: 1px solid gray;}
		td { text-align: center; padding: 25;}

		</style>
	</head>
	<body>
		<center>
		<br><br><br><br>
			<table>
			<tr><td>Welcome to the home of <b>adamo.wp-concept.nl test</b></td></tr>
			<tr><td>To change this page, upload your website into the public_html directory</td></tr>
			<tr><td><img src="logo.png"></td></tr>
			<tr><td style="font-size: 8pt">Date Created: Fri Mar  1 10:16:56 2024</td></tr>
			</table>
		<br><br>

		<form method="post" action="index.html">
			<input type="radio" name="RB1" value="10" disabled="true" oninput="{$('txtDagBedrag').attr('disabled', 'false'); $('txtVastBedrag').attr('disabled', 'false');}">
				<label>Ik sponsor 10 euro per dag</label>
				<br/>
			<input type="radio" name="RB2" value="20" disabled="true" oninput="{$('txtDagBedrag').attr('disabled', 'false'); $('txtVastBedrag').attr('disabled', 'false');}">
				<label>Ik sponsor 25 euro per dag</label>
				<br/>
			<input type="radio" name="RB3" value="30" disabled="true" oninput="{$('txtDagBedrag').attr('disabled', 'false'); $('txtVastBedrag').attr('disabled', 'false');}">
				<label>Ik sponsor 50 euro per dag</label>
				<br/>
			<input type="radio" name="RB4" value="30" disabled="true" oninput="{$('txtDagBedrag').attr('disabled', 'false')}">
				<label>Ik sponsor 
					<input type="number" name="txtDagBedrag" value="5" disabled="true" /*onchange="{ { $('txtDagBedrag').val() }}"*/> 
					euro per dag
				</label>
				<br/>
			<input type="radio" name="RB5" value="30" disabled="true" oninput="{$('txtVastBedrag').attr('disabled', 'false')}">
				<label>Ik sponsor een vast bedrag, nl:
					<input type="text" name="txtVastBedrag" disabled="true"> 
					euro
				</label>
				<br/>
			<h2><i>Totaal sponsor bedrag:</i></h2>
				<h3><b></b></h3>
		</form>

		</center>
	</body>
</html>
