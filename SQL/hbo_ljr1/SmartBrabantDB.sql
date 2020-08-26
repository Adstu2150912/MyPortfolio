/*
Auteur: Adam Oubelkas
Project: Beroepsproduct 3 - SmartBrabant
Aanmaakdatum: 25-02-2020
Bestandsnaam: SmartBrabant.sql
*/

DROP DATABASE IF EXISTS SmartBrabantDB;
CREATE DATABASE SmartBrabantDB;
USE SmartBrabantDB;

/*Laag 1*/

/*Uit CogNIAM-Analyse afgeleide verzameling 'isPlaatsSMART'*/

CREATE TABLE Plaats
(
	naam VARCHAR(255) PRIMARY KEY /*CogNIAM verzamelingscode: H2001*/
	,gemeentelijkePopulatie INT(7) /*CogNIAM verzamelingscode: D2002*/
	,isSmart BIT /*CogNIAM verzamelingscode: D2003*/
	,oppervlakte DECIMAL(4,1) NULL /*gebruikte eenheid: vierkante km*/
	,stedelijkePopulatie INT(7) NULL /*CogNIAM verzamelingscode: D2002*/
	,metroPopulatie INT(7) NULL /*CogNIAM verzamelingscode: D2002*/
	,gemeente VARCHAR(255)
);

/*Laag 2*/

/*Uit CogNIAM-Analyse afgeleide verzameling 'ActiviteitHeeftPrioriteitVoorProbleem'*/

CREATE TABLE Activiteit
(
	activiteitNummer INT(6) PRIMARY KEY AUTO_INCREMENT /*CogNIAM verzamelingscode: D2005*/
    ,naam VARCHAR(255) /*CogNIAM verzamelingscode: D2004*/
	,maatschappelijkeFactor VARCHAR(30) /*CogNIAM verzamelingscode: D2006*/
	,prioriteit VARCHAR(11) NULL /*CogNIAM verzamelingscode: D2007*/
	,plaatsNaam VARCHAR(255)  /*CogNIAM verzamelingscode: D2001*/
    ,dataSoort VARCHAR(255)
	,CONSTRAINT FK_Activiteit_Plaats FOREIGN KEY Activiteit(plaatsNaam) REFERENCES Plaats(naam) 
);

/*Uit CogNIAM-Analyse afgeleide verzameling 'IoT-apparaatIsGevestigdEnVerwerktData'*/

CREATE TABLE IoTapparaat
(
	IoTnummer INT(6) PRIMARY KEY AUTO_INCREMENT /*CogNIAM verzamelingscode: D2009*/
	,naam VARCHAR(255) /*CogNIAM verzamelingscode: D2008*/
	,dataSoort VARCHAR(255) /*CogNIAM verzamelingscode: D2010*/
	,plaatsNaam VARCHAR(255) /*CogNIAM verzamelingscode: D2001*/
	,CONSTRAINT FK_IoTapparaat_Plaats FOREIGN KEY IoTapparaat(plaatsNaam) REFERENCES Plaats(naam) 
);

/*Uit CogNIAM-Analyse afgeleide verzameling 'IsBurgerTevredenOverPlaats'*/

CREATE TABLE Burger
(
	BSNnummer INT(9) PRIMARY KEY /*CogNIAM verzamelingscode: D2012*/
	, naam VARCHAR(255) NULL /*CogNIAM verzamelingscode: D2011*/
	, tevredenheidPlaats bit /*CogNIAM verzamelingscode: D2013 (Tevreden = 1; Ontevreden = 0)*/
	, plaatsNaam VARCHAR(255) /*CogNIAM verzamelingscode: D2001*/
    , mening VARCHAR(255) NULL
	, CONSTRAINT FK_Burger_Plaats FOREIGN KEY Burger(plaatsNaam) REFERENCES Plaats(naam) 
);

/*Uit CogNIAM-Analyse afgeleide verzameling 'AdviesBevatPvA'*/

CREATE TABLE Advies 
(
	 adviesNummer INT(6) PRIMARY KEY AUTO_INCREMENT /*CogNIAM verzamelingscode: D2014*/
	 , planVanAanpak VARCHAR(255) /*CogNIAM verzamelingscode: D2015*/
	 , plaatsNaam VARCHAR(255) /*CogNIAM verzamelingscode: D2001*/
	 , CONSTRAINT FK_Advies_Plaats FOREIGN KEY Advies(plaatsNaam) REFERENCES Plaats(naam) 
);


/*Database vullen met testgegevens*/

/*Laag 1*/
INSERT INTO Plaats
VALUES('Breda', 183873, 1, 128.7, 180420, 324812, 'Breda')
,('Tilburg', 217259, 1, 119.2, 233339, 300249, 'Tilburg')
,('Oosterhout', 55616, 0, 73.1, NULL, NULL, 'Oosterhout')
,('Eindhoven', 	231642, 1, 88.9, 337487, 19045, 'Eindhoven')
,('s-Hertogenbosch', 154205, 1, 91.8, 169714, 198000, 's-Hertogenbosch')
,('Raamsdonksveer', 12345, 0, 17.4, NULL, NULL, 'Geertruidenberg');

/*Laag 2*/
INSERT INTO Activiteit(naam, maatschappelijkeFactor, prioriteit, plaatsNaam, dataSoort)
VALUES('criminaliteit', 'economisch', 'hoog', 'Tilburg', 'licht')
,('mileuvervuiling', 'milieu', 'middelmatig', 'Oosterhout', 'gas')
,('verkeersopstopping', 'verkeers', 'laag', 'Breda', 'gas')
,('geluidsoverlast', 'milieu', 'hoog', 'Tilburg', 'geluid')
,('conflict op terras', 'sociaal', 'hoog', 'Tilburg', 'licht')
,('geluidsoverlast', 'milieu', 'laag', 'Oosterhout', 'geluid')
,('criminaliteit', 'economisch', 'middelmatig', 'Oosterhout', 'licht');

INSERT INTO IoTapparaat(naam, dataSoort, plaatsNaam)
VALUES('MQ-3', 'geur', 's-Hertogenbosch')
,('MH-Z19', 'gas', 'Breda')
,('BMP280', 'geluid', 'Tilburg');

INSERT INTO Burger
VALUES(4792537, 'Jip', 0, 'Raamsdonksveer', NULL)
,(6550213, 'Janneke', 0, 'Oosterhout', NULL)
,(2525436, 'Klaas', 1, 'Breda', NULL);

INSERT INTO Advies(planVanAanpak, plaatsNaam)
VALUES('Uit de slimme technieken geluidsmeting, geurmeting en klimaatmeting, wordt geluidsmeting aangeraden toe te passen door gebruik te maken van IoT-apparaat MQ-3', 's-Hertogenbosch')
,('Uit de slimme technieken geluidsmeting, geurmeting en klimaatmeting, wordt klimaatmeting aangeraden toe te passen door gebruik te maken van IoT-apparaat MH-Z19', 'Breda')
,('"Uit de slimme technieken geluidsmeting, geurmeting en klimaatmeting, wordt geurmeting aangeraden toe te passen door gebruik te maken van IoT-apparaat BMP280"', 'Tilburg');

-- SELECT * FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND prioriteit = 'middel' OR prioriteit = 'laag';

-- SELECT AVG(tevredenheidPlaats) FROM Burger;

-- SELECT * /*Activiteit.dataSoort, IoTApparaat.naam AS IoTApparaat*/ /*DISTINCT COUNT(Activiteit.dataSoort)*/ /*COUNT(DISTINCT Activiteit.activiteitNummer) AS aantalActiviteiten, COUNT(DISTINCT IoTApparaat.IoTnummer) AS aantalIoTApparaten*/ FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Activiteit.dataSoort = IoTApparaat.dataSoort WHERE Plaats.naam = "Tilburg" GROUP BY Plaats.naam HAVING COUNT(DISTINCT activiteit.activiteitNummer) > COUNT(DISTINCT IoTApparaat.IoTnummer);
SELECT Activiteit.ActiviteitNummer, IoTApparaat.IoTnummer, Activiteit.plaatsNaam FROM Activiteit JOIN IoTApparaat ON Activiteit.dataSoort = IoTApparaat.dataSoort;

-- MySQL
SELECT DISTINCT Activiteit.maatschappelijkeFactor AS Factor FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = 'Breda';
SELECT Plaats.naam AS Plaats, Activiteit.naam AS Activiteit, Activiteit.activiteitNummer, Activiteit.maatschappelijkeFactor AS Factor, Activiteit.prioriteit, Activiteit.dataSoort, IoTApparaat.naam AS IoTApparaat, IoTApparaat.IoTnummer FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = 'Breda' GROUP BY IoTApparaat;
SELECT Activiteit.ActiviteitNummer, IoTApparaat.IoTnummer, IoTApparaat.naam, Activiteit.plaatsNaam, Activiteit.dataSoort FROM Activiteit JOIN IoTApparaat ON Activiteit.dataSoort = IoTApparaat.dataSoort WHERE Activiteit.plaatsNaam = 'Breda';

SELECT DISTINCT Activiteit.maatschappelijkeFactor  FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = 'Breda';
SELECT Plaats.naam, Activiteit.naam, Activiteit.activiteitNummer, Activiteit.maatschappelijkeFactor, Activiteit.prioriteit, Activiteit.dataSoort, IoTApparaat.naam, IoTApparaat.IoTnummer  FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = 'Breda'  GROUP BY IoTApparaat.naam;
SELECT Activiteit.ActiviteitNummer, IoTApparaat.IoTnummer, IoTApparaat.naam, Activiteit.plaatsNaam, Activiteit.dataSoort FROM Activiteit JOIN IoTApparaat ON Activiteit.dataSoort = IoTApparaat.dataSoort WHERE Activiteit.plaatsNaam = 'Breda';

-- SQLite statements
SELECT DISTINCT Activiteit.maatschappelijkeFactor FROM Activiteit JOIN IoTApparaat ON Activiteit.plaatsNaam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Activiteit.plaatsNaam = 'Breda';
SELECT Activiteit.plaatsNaam, Activiteit.naam, Activiteit.activiteitNummer, Activiteit.maatschappelijkeFactor, Activiteit.prioriteit, Activiteit.dataSoort, IoTApparaat.naam, IoTApparaat.IoTnummer FROM Activiteit JOIN IoTApparaat ON Activiteit.plaatsNaam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Activiteit.plaatsNaam = 'Breda' GROUP BY IoTApparaat.naam;
SELECT Activiteit.ActiviteitNummer, IoTApparaat.IoTnummer, IoTApparaat.naam, Activiteit.plaatsNaam, Activiteit.dataSoort FROM Activiteit JOIN IoTApparaat ON Activiteit.dataSoort = IoTApparaat.dataSoort WHERE Activiteit.plaatsNaam = 'Breda';

SELECT AVG(tevredenheidPlaats) AS tevredenHeid, Plaats.naam, isSmart, oppervlakte, gemeentelijkePopulatie, stedelijkePopulatie, metroPopulatie, gemeente FROM Plaats JOIN Burger ON Plaats.naam = Burger.plaatsNaam;