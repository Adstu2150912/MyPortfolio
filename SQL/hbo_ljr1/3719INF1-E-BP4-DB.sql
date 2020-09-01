/*
Auteur: Adam Oubelkas
Project: Beroepsproduct 4 - ECI-Cultuurfabriek
Aanmaakdatum: 04-05-2020
Bestandsnaam: 3719INF1-E-BP4-DB.sql
*/
USE beroepsProduct4;

/*Laag 1*/

/*Uit CogNIAM-Analyse afgeleide verzameling 'Cursuscategorie'*/
CREATE TABLE IF NOT EXISTS Cursuscategorie
(
	categorieID INTEGER PRIMARY KEY AUTO_INCREMENT /*CogNIAM verzamelingscode: H2001*/
	,subCategorie VARCHAR(50) NOT NULL /*CogNIAM verzamelingscode: D2003*/
	,categorieNaam VARCHAR(30) NOT NULL /*CogNIAM verzamelingscode: D2002*/
	,omschrijving VARCHAR(255) NOT NULL /*CogNIAM verzamelingscode: D2004*/
);

/*Uit CogNIAM-Analyse afgeleide verzameling 'Docent'*/
CREATE TABLE IF NOT EXISTS Docent
(
	docentID INTEGER PRIMARY KEY AUTO_INCREMENT /*CogNIAM verzamelingscode: H2006*/
    ,docNaam VARCHAR(100) NOT NULL /*CogNIAM verzamelingscode: D2007*/
    ,beschrijving VARCHAR(255) NULL /*CogNIAM verzamelingscode: D2005*/
    ,discipline VARCHAR(50) NOT NULL
);

/*Laag 2*/

/*Uit CogNIAM-Analyse afgeleide verzameling 'Cursus'*/
CREATE TABLE IF NOT EXISTS Cursus
(
	cursusID INTEGER PRIMARY KEY AUTO_INCREMENT /*CogNIAM verzamelingscode: H2008*/
    ,cursusNaam VARCHAR(100) NOT NULL /*CogNIAM verzamelingscode: D2009*/
    ,beschrijving VARCHAR(255) NULL /*CogNIAM verzamelingscode: D2005*/
    ,doelGroep VARCHAR(25) NOT NULL /*CogNIAM verzamelingscode: D2010*/
    ,startDatum DATE NOT NULL /*CogNIAM verzamelingscode: D2011*/
    ,dag VARCHAR(5) NOT NULL /*CogNIAM verzamelingscode: D2012*/
    ,tijd TIME(6) NOT NULL /*CogNIAM verzamelingscode: D2013*/
    ,duur INTEGER NOT NULL /*CogNIAM verzamelingscode: D2014*/
    ,frequentie VARCHAR(25) /*CogNIAM verzamelingscode: D2015*/
    ,lesAantal INTEGER /*CogNIAM verzamelingscode: D2016*/
    ,lesPrijs DECIMAL(5,2) /*CogNIAM verzamelingscode: D2017*/
    ,categorieID INTEGER NOT NULL /*CogNIAM verzamelingscode: D2001*/
    ,docentID INTEGER NOT NULL /*CogNIAM verzamelingscode: D2006*/
    ,CONSTRAINT FK_Cursus_Cursuscategorie FOREIGN KEY (categorieID) REFERENCES Cursuscategorie(categorieID)
    ,CONSTRAINT FK_Cursus_Docent FOREIGN KEY (docentID) REFERENCES Docent(docentID)
);

INSERT INTO Cursuscategorie
VALUES
('Piano', 'Muziek', '*omschrijving1*')
,('Toneel', 'Theater', 'omschrijving2')
,('Tekenen & Schilderen', 'Beeldende kunst', 'omschrijving3');

INSERT INTO Docent
VALUES
('Rini Ronckers', 1, '*beschrijving1*', 'beeldende kunst')
,('Michel Govers', 2, 'beschrijving2', 'beeldende kunst')
,('Ruth Houkes', 3, 'beschrijving3', 'beeldende kunst');

INSERT INTO Cursus
VALUES
('Beeldhouwen | 5 lessen', '*beschrijving5*', '18-21 jaar', '2019-09-28', 'za', '09:30:00', '180', 'tweewekelijks', 5, 128, 1)
,('Toneelklas volwassenen', '*beschrijving6*', 'ouder dan 21 jaar', '2020-01-13', 'ma', '20:15:00', 120, 'elke week', 10, 185, 2)
,('Big Band Boom', '*Beschrijving7*', '4-18 jaar', '2019-08-28', 'wo', '17:45:00', 60, 'elke dag', 36, 139, 3);


