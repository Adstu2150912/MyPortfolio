/*
     Opdracht:       opdracht 6.4
     Auteur:         Adam Oubelkas
     Aanmaakdatum:   2-4-2017
     Bestandsnaam:   opdracht6.4.sql
*/

--maak nieuwe database 'KNVB' aan
--CREATE DATABASE KNVB;
--GO

--maak gebruik van database 'KNVB'
USE KNVB;

--Maak nieuwe tabel 'voetbalclub aan'
/*CREATE TABLE voetbalclub(
	voetbalclubID		INT	NOT NULL,
	naam				VARCHAR(30),
	datumOprichting		SMALLDATETIME,
	begroting		    MONEY,
	competitie			VARCHAR(20),
	CONSTRAINT PK_voetbalclubID
	PRIMARY KEY (voetbalclubID)
)*/

--Maak nieuwe tabel 'bedrijf' aan
/*CREATE TABLE bedrijf(
	bedrijfID		INT NOT NULL,
	bedrijfsnaam	VARCHAR(20),
	KVKNNummer		INT,
	rekeningNummer	INT,
	SBI				VARCHAR(50),	
	CONSTRAINT PK_bedrijfID
	PRIMARY KEY (bedrijfID)
)*/

--Maak nieuwe tabel 'personalTrainer' aan
/*CREATE TABLE personalTrainer(
	personalTrainerID	INT NOT NULL,
	voornaam			VARCHAR(20),
	achternaam			VARCHAR(30),
	telefoonnummer		INT,
	vakgebied			VARCHAR(20),
	beschikbaarheid		VARCHAR(20),
	CONSTRAINT	PK_personalTrainerID
	PRIMARY KEY (personalTrainerID)
)*/

--voeg primaire sleutel 'bedrijfID' van tabel 'bedrijf'
--toe als refererende sleutel in tabel 'personalTrainer'
ALTER TABLE accommodatie
ADD CONSTRAINT FK_bedrijfID
FOREIGN KEY(bedrijfID)
REFERENCES bedrijf(bedrijfID);

ALTER TABLE speler
ADD voetbalclubID INT NOT NULL;
--Maak nieuwe tabel 'accommodatie' aan
/*CREATE TABLE accommodatie (
	accommodatieID INT NOT NULL,
	naam		  VARCHAR(30),
	soortType	  INT,
	adres	      VARCHAR(30),
	postcode	  CHAR(6),
	plaats		  VARCHAR(50),
	telefoonnummer INT,
	CONSTRAINT PK_accommodatieID
	PRIMARY KEY (accommodatieID),
);*/

--voeg primaire sleutel 'voetbalclubID' van tabel 'voetbalclub'
--toe als refererende sleutel in tabel 'accommodatie'
ALTER TABLE accommodatie
ADD CONSTRAINT FK_voetbalclubID
FOREIGN KEY(voetbalclubID)
REFERENCES voetbalclub(voetbalclubID);

--Maak nieuwe tabel 'speler' aan
CREATE TABLE speler(
	spelerID	INT NOT NULL,
	voetbalclubID INT NOT NULL,
	voornaam	VARCHAR(20),
	achternaam  VARCHAR(30),
	bijnaam		VARCHAR(10),
	geboortedatum SMALLDATETIME,
	lengte		CHAR(5),
	gewicht		CHAR(5),
	salaris		MONEY,
	specialiteit	VARCHAR(15),
	extrainformatie	VARCHAR(50),
	CONSTRAINT PK_spelerID
	PRIMARY KEY (spelerID)
)
--voeg primaire sleutel 'voetbalclubID' van tabel 'voetbalclub'
--toe als refererende sleutel in tabel 'speler'
ALTER TABLE speler
ADD FOREIGN KEY(voetbalclubID)
REFERENCES voetbalclub(voetbalclubID);

--voeg primaire sleutel 'personalTrainerID' van tabel 'personalTrainer'
--toe als refererende sleutel in tabel 'speler'
ALTER TABLE speler
ADD CONSTRAINT FK_personalTrainerID
FOREIGN KEY(personalTrainerID)
REFERENCES personalTrainer(personalTrainerID);

ALTER TABLE speler
ADD personalTrainerID INT NOT NULL;
/*
invoerolgorde:
Laag 1: voetbalclub, bedrijf
Laag 2: personalTrainer, accommodatie
Laag 3: speler
*/
--voeg 4 rijen toe in tabel voetbalclub en vul alle velden vol
INSERT INTO voetbalclub(voetbalclubID, naam, datumOprichting, begroting, competitie)
VALUES	(6328, 'Patat', 'March 3 1991', 1150, 'Bapao'),
		(3268, 'Bapao', 'February 2 1990', 3264, 'Patat'),
		(1768, 'frikandelSpeciaal', 'May 1 1989', 9328, 'Kroket'),
		(2179, 'Kroket', 'January 18 1988', 2034, 'frikandelSpeciaal');
--voeg twee bedrijven toe in tabel 'bedrijf'
INSERT INTO bedrijf(bedrijfID, bedrijfsnaam, KVKNNummer, rekeningNummer, SBI)
VALUES	(87324, 'roosvisé', 1324, 033214546945, 'jsadbe'),
		(10283, 'appeltje-eitje', 3124, 913248435932, 'saED');
--voeg 3 personal trainers toe in tabel 'personalTrainer'
INSERT INTO personalTrainer(personalTrainerID, voornaam, achternaam, telefoonnummer, vakgebied, beschikbaarheid)
VALUES 	(1380, 'jaap', 'jaapsen', 0123123012, 'keeper', 'aanwezig'),
		(1345, 'jan', 'jansen', 0921237971, 'aanval', 'afwezig'),
		(6801, 'piet', 'pietsen', 0621392438, 'verdediging', 'aanwezig');
--voeg voor ieder voetbalclub 2 accommodaties toe in tabel 'accommodatie'
INSERT INTO	accommodatie(accommodatieID, FK_voetbalclubID, naam, soortType, adres, postcode, plaats, telefoonnummer)
VALUES	(2134, 6328, 'asdd', 657121, 'awe\def','1234AB', 'wqljs', 912380242),
		(3249, 3268, 'afgsd', 23894, 'erelaa', '3289LL', 'kjassd', 32894012),
		(3300, 1768, 'wDKKl', 29382, 'QLDMas', '8932DJ', 'aisfu', 189233127),
		(1092, 2179, 'sadjh', 49230, 'KASDK', '3892UN', 'fsdlm', 9032173023);
--voeg 8 rijen toe aan tabel 'speler'
INSERT INTO speler(spelerID, FK_voetbalclubID, FK_personalTrainerID, voornaam, achternaam, bijnaam, geboortedatum, lengte, gewicht, salaris, specialiteit, extrainformatie)
VALUES	(1234, 6328, 6801, 'urlich', 'von liechtenstein', 'urgstein', 'April 1 1941', '1,80m', '70kg', 31456.23, 'aanval', 'dierenliefhebber en pacifist'),
		(4596, 3268, 1345, 'keizer', 'schneitzer', 'schnizel', 'April 1 1950', '1,77m', '66kg', 57032.98, 'aanval', 'aggresief, competitief'),
		(1391, 1768, 1345, 'euqine', 'Krabz', 'Da Krab', 'June 24 1957', '1,88m', '80kg', 32975.50, 'verdediging', 'tactische, introvert'),
		(0193, 6328, 6801, 'igy', 'Spram', 'Spigy', 'August 17 1962', '1,72m', '68kg', 21380.48, 'keeper', 'sportief'),
		(4389, 2179, 1345, 'Oz', 'dawisart', 'The OX', 'November 6 1954', '1,90m', '95kg', 59430.86, 'keeper', 'extravert, openhartig'),
		(9852, 3268, 1380, 'Neil', 'mcWane', 'The Wane', 'February 8 1948', '1,82m', '74kg', 45398.12, 'verdediging', 'pietje precies, arrogant'),
		(1208, 1768, 1380, 'Gwen', 'Lasser', 'Da Wimp', 'September 17 1965', '1,68m', '60kg', 13249.23, 'verdediging', 'zwakmoedig, naïef'),
		(3458, 2179, 6801, 'Derick', 'Smash', 'Smasher', 'March 28 1951', '1,74m', '71kg', 29324.32, 'aanval', 'gul, behulpzaam');
		