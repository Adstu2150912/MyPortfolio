/*
Naam:	        Database voor Gildenbondsharmonie Boxtel
Auteur:         Adam Oubelkas
Aanmaakdatum:   22-11-2018 + 12:28
Bestandsnaam:   GildenbondsharmonieDB.sql
*/

USE MASTER;
GO

IF EXISTS(SELECT * FROM sys.databases WHERE NAME = 'GildenbondsharmonieDB')
DROP DATABASE GildenbondsharmonieDB;
GO

CREATE DATABASE GildenbondsharmonieDB;
GO

USE GildenbondsharmonieDB;

--Laag 1

--Verzameling woonadressen van de personen
CREATE TABLE Woonadres
(
	woonadresID INT IDENTITY(1,1) CONSTRAINT PK_Woonadres PRIMARY KEY CLUSTERED
	,straatnaam VARCHAR(30) NOT NULL
	,straatnummer SMALLINT NOT NULL
	,postcode CHAR(6) NOT NULL
	,plaats VARCHAR(30) NOT NULL
);

--Verzameling instrumentenverzekeringen van Gildenbondsharmonie
CREATE TABLE Verzekering
(
	verzekeringID INT IDENTITY(1,1) CONSTRAINT PK_Verzekering PRIMARY KEY CLUSTERED
	,serienummer VARCHAR(25) NOT NULL UNIQUE
	,aanschafprijs DECIMAL NOT NULL
	,aanschafdatum DATE NOT NULL
	,afschrijvingsdatum DATE NOT NULL
	,leverancier VARCHAR(30) NOT NULL
	,verzekerd BIT NOT NULL
	,verzekeringswaarde DECIMAL NOT NULL
);

--Verzameling jubilarissen van de vereniging
CREATE TABLE Jubilea
(
	jubileaID INT IDENTITY(1,1) CONSTRAINT PK_Jubilea PRIMARY KEY CLUSTERED
	,naam VARCHAR(50) NOT NULL
	,omschrijving VARCHAR(MAX)
);

--Verzameling evenementen van Gildenbondsharmonie
CREATE TABLE Evenement
(
	evenementID INT IDENTITY(1,1) CONSTRAINT PK_Evenement PRIMARY KEY CLUSTERED
	,evenementnaam VARCHAR(50) NOT NULL
	,evenementtype VARCHAR(30) NOT NULL
	,begindatum DATE NOT NULL
	,einddatum DATE NOT NULL
	,starttijd TIME(0) NOT NULL
	,eindtijd TIME(0) NOT NULL
	,locatie VARCHAR(MAX) NOT NULL
	,beschrijving VARCHAR(MAX)
);



--Laag 2

--Verzameling van alle personen die bijdrage leveren of hebben geleverd aan de vereniging
CREATE TABLE Persoon
(
	persoonID INT IDENTITY(1,1) CONSTRAINT PK_Persoon PRIMARY KEY CLUSTERED
	,woonadresID INT CONSTRAINT FK_Persoon_Woonadres FOREIGN KEY REFERENCES Woonadres(woonadresID) NOT NULL
	,voorletters VARCHAR(10) NOT NULL
	,voornaam VARCHAR(20) NOT NULL
	,tussenvoegsel VARCHAR(10)
	,achternaam VARCHAR(20) NOT NULL
	,geslacht CHAR(1) NOT NULL CHECK(geslacht = 'm' OR geslacht = 'v')
	,geboortedatum DATE NOT NULL
	,telefoonnummer VARCHAR(15)
	,mobielnummer VARCHAR(15)
	,emailadres VARCHAR(50)
	,groepnaam VARCHAR(20) NOT NULL --Soort groep die bijdragen of hebben bijgedragen aan de Gildenbondsharmonie. De vaste soort groepen zijn als volgt: Bestuur, Oud leden, Sponsors, Donateurs, Evenementen commissie, Instrumenten commissie.
	,groeptype CHAR(6) NOT NULL --Type groep binnen de Gildenbondsharmonie. De vaste type groepen (Intern, Extern).
);



--Laag 3

--Verzameling verenigingsleden van de Gildenbondsharmonie
CREATE TABLE Verenigingslid
(
	verenigingslidID	INT IDENTITY(1,1) CONSTRAINT PK_Verenigingslid PRIMARY KEY CLUSTERED
	,lidnummer INT NOT NULL UNIQUE
	,persoonID INT CONSTRAINT FK_Verenigingslid_Persoon FOREIGN KEY REFERENCES Persoon(persoonID) UNIQUE NOT NULL
	,startdatum DATE NOT NULL
);

--Laag 4

--Verzameling instrumenten van Gildenbondsharmonie
CREATE TABLE Instrument
(
	instrumentID INT IDENTITY(1,1) CONSTRAINT PK_Instrument PRIMARY KEY CLUSTERED
	,instrument VARCHAR(50) NOT NULL
	,instrumenttype VARCHAR(30) NOT NULL
	,merk VARCHAR(30) NOT NULL
	,verzekeringID INT CONSTRAINT FK_Instrument_Verzekering FOREIGN KEY REFERENCES Verzekering(verzekeringID) NOT NULL
	,verenigingslidID INT CONSTRAINT FK_Instrument_Verenigingslid FOREIGN KEY REFERENCES Verenigingslid(verenigingslidID)
);

--Koppeltabel met daarin verzamelingen van de associaties tussen Jubilea en Verenigingslid
CREATE TABLE JubileaVerenigingslid
(
	jubileaID INT CONSTRAINT FK_Jubilea_Verengingslid FOREIGN KEY REFERENCES Jubilea(jubileaID)
	,verenigingslidID INT CONSTRAINT FK_Verenigingslid_Jubilea FOREIGN KEY REFERENCES Verenigingslid(verenigingslidID)
	,jubileaopmerking VARCHAR(MAX)
);

--Koppeltabel met daarin verzamelingen van de associaties tussen Evenement en Verenigingslid
CREATE TABLE EvenementVerenigingslid
(
	evenementID INT CONSTRAINT FK_Evenement_Verenigingslid FOREIGN KEY REFERENCES Evenement(evenementID)
	,verenigingslidID INT CONSTRAINT FK_Verenigingslid_Evenement FOREIGN KEY REFERENCES Verenigingslid(verenigingslidID)
);

GO



-- setup a variable to take the file data
DECLARE @fileData XML = NULL

-- import the file contents into the variable

SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\Woonadres.XML', SINGLE_BLOB) x;

--Gegevens invoeren


--Laag 1

INSERT INTO Woonadres(straatnaam, straatnummer, postcode, plaats)
SELECT-- 'xData' is our xml content alias
   xData.value('straatnaam[1]','VARCHAR(30)') straatnaam,
   xData.value('straatnummer[1]','SMALLINT') straatnummer,
   xData.value('postcode[1]','CHAR(6)') postcode,
   xData.value('plaats[1]','VARCHAR(30)') plaats
FROM @fileData.nodes('/Woonadressen/Woonadres') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\Verzekering.XML', SINGLE_BLOB) x;

INSERT INTO Verzekering(serienummer, aanschafprijs, aanschafdatum, afschrijvingsdatum, leverancier, verzekerd, verzekeringswaarde)
SELECT-- 'xData' is our xml content alias
   xData.value('serienummer[1]','INT') serienummer,
   xData.value('aanschafprijs[1]','DECIMAL') aanschafprijs,
   xData.value('aanschafdatum[1]','DATE') aanschafdatum,
   xData.value('afschrijvingsdatum[1]','DATE') afschrijvingsdatum,
   xData.value('leverancier[1]','VARCHAR(50)') leverancier,
   xData.value('verzekerd[1]','BIT') verzekerd,
   xData.value('verzekeringswaarde[1]','DECIMAL') verzekeringswaarde 
FROM @fileData.nodes('/Verzekeringen/Verzekering') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\Jubilea.XML', SINGLE_BLOB) x;

INSERT INTO Jubilea(naam)
SELECT-- 'xData' is our xml content alias
   xData.value('naam[1]','VARCHAR(30)') naam
FROM @fileData.nodes('/Jubilarissen/Jubilea') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\Evenement.XML', SINGLE_BLOB) x;

INSERT INTO Evenement(evenementnaam, beschrijving, evenementtype, locatie, begindatum, einddatum, starttijd, eindtijd)
SELECT-- 'xData' is our xml content alias
   xData.value('evenementnaam[1]','VARCHAR(50)') evenementnaam,
   xData.value('beschrijving[1]','VARCHAR(MAX)') beschrijving,
   xData.value('evenementtype[1]','VARCHAR(30)') evenementtype,
   xData.value('locatie[1]','VARCHAR(MAX)') locatie,
   xData.value('begindatum[1]','DATE') begindatum,
   xData.value('einddatum[1]','DATE') einddatum,
   xData.value('starttijd[1]','TIME(0)') starttijd,
   xData.value('eindtijd[1]','TIME(0)') eindtijd
FROM @fileData.nodes('/Evenementen/Evenement') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\Persoon.XML', SINGLE_BLOB) x;
--Laag 2

INSERT INTO Persoon(voorletters, voornaam, tussenvoegsel, achternaam, geboortedatum, geslacht, telefoonnummer, mobielnummer, emailadres, groeptype, groepnaam, woonadresID)
SELECT-- 'xData' is our xml content alias
   xData.value('voorletters[1]','VARCHAR(10)') voorletters,
   xData.value('voornaam[1]','VARCHAR(20)') voornaam,
   xData.value('tussenvoegsel[1]','VARCHAR(10)') tussenvoegsel,
   xData.value('achternaam[1]','VARCHAR(20)') achternaam,
   xData.value('geboortedatum[1]','DATE') geboortedatum,
   xData.value('geslacht[1]','CHAR(1)') geslacht,
   xData.value('telefoonnummer[1]','VARCHAR(15)') telefoonnummer,
   xData.value('mobielnummer[1]','VARCHAR(15)') mobielnummer,
   xData.value('emailadres[1]','VARCHAR(50)') emailadres,
   xData.value('groeptype[1]','CHAR(6)') groeptype,
   xData.value('groepnaam[1]','VARCHAR(20)') groepnaam,
   xData.value('woonadresID[1]','INT') woonadresID
FROM @fileData.nodes('/Personen/Persoon') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\Verenigingslid.XML', SINGLE_BLOB) x;
--Laag 3

INSERT INTO Verenigingslid(lidnummer, persoonID, startdatum)
SELECT-- 'xData' is our xml content alias
   xData.value('lidnummer[1]','INT') lidnummer,
   xData.value('persoonID[1]','INT') persoonID,
   xData.value('startdatum[1]','DATE') startdatum
FROM @fileData.nodes('/Verenigingsleden/Verenigingslid') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\Instrument.XML', SINGLE_BLOB) x;
--Laag 4

INSERT INTO Instrument(instrument, instrumenttype, merk, verzekeringID, verenigingslidID)
SELECT-- 'xData' is our xml content alias
   xData.value('instrument[1]','VARCHAR(50)') instrument,
   xData.value('instrumenttype[1]','VARCHAR(30)') instrumenttype,
   xData.value('merk[1]','VARCHAR(30)') merk,
   xData.value('verzekeringID[1]','INT') verzekeringID,
   xData.value('verenigingslidID[1]','INT') verenigingslidID
FROM @fileData.nodes('/Instrumenten/Instrument') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\JubileaVerenigingslid.XML', SINGLE_BLOB) x;

INSERT INTO JubileaVerenigingslid(jubileaID, verenigingslidID, jubileaopmerking)
SELECT-- 'xData' is our xml content alias
   xData.value('jubileaID[1]','INT') jubileaID,
   xData.value('verenigingslidID[1]','INT') verenigingslidID,
   xData.value('jubileaopmerking[1]','VARCHAR(MAX)') jubileaopmerking
FROM @fileData.nodes('/JubileaVerenigingsleden/JubileaVerenigingslid') AS x(xData); -- this is the xpath to the individual records we want to extract


SELECT @fileData=BulkColumn from OPENROWSET(BULK'H:\School\Multidisciplinair project semester 5\B1-K2-W1\XML tabellen\EvenementVerenigingslid.XML', SINGLE_BLOB) x;

INSERT INTO EvenementVerenigingslid(evenementID, verenigingslidID)
SELECT-- 'xData' is our xml content alias
   xData.value('evenementID[1]','INT') evenementID,
   xData.value('verenigingslidID[1]','INT') verenigingslidID
FROM @fileData.nodes('/EvenementVerenigingsleden/EvenementVerenigingslid') AS x(xData); -- this is the xpath to the individual records we want to extract

--Tabellen exporteren in XML

SELECT *
FROM Woonadres 
FOR XML PATH('Woonadres'), ROOT ('Woonadressen');

SELECT *
FROM Verzekering
FOR XML PATH('Verzekering'), ROOT ('Verzekeringen');

SELECT *
FROM Jubilea
FOR XML PATH('Jubilea'), ROOT('Jubilarissen');

SELECT *
FROM Evenement
FOR XML PATH('Evenement'), ROOT('Evenementen');

SELECT *
FROM Persoon
FOR XML PATH('Persoon'), ROOT('Personen');

SELECT *
FROM Verenigingslid
FOR XML PATH('Verenigingslid'), ROOT('Verenigingsleden');

SELECT *
FROM Instrument
FOR XML PATH('Instrument'), ROOT('Instrumenten');

SELECT *
FROM JubileaVerenigingslid
FOR XML PATH('JubileaVerenigingslid'), ROOT('JubileaVerenigingsleden');

SELECT *
FROM EvenementVerenigingslid
FOR XML PATH('EvenementVerenigingslid'), ROOT('EvenementVerenigingsleden');

--Tabellen selecteren

SELECT *
FROM Woonadres;

SELECT *
FROM Verzekering;

SELECT *
FROM Jubilea;

SELECT *
FROM Evenement;

SELECT *
FROM Persoon;

SELECT *
FROM Verenigingslid;

SELECT *
FROM Instrument;

SELECT *
FROM JubileaVerenigingslid;

SELECT *
FROM EvenementVerenigingslid;

SELECT voornaam, voorletters, tussenvoegsel, achternaam, instrument, instrumenttype, merk, serienummer
FROM Persoon
INNER JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.verenigingslidID 
INNER JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID
INNER JOIN Verzekering ON Instrument.verzekeringID = Verzekering.verzekeringID;

SELECT FORMAT(starttijd, N'hh\:mm'), FORMAT(eindtijd, N'hh\:mm') FROM Evenement FULL JOIN EvenementVerenigingslid ON Evenement.evenementID = EvenementVerenigingslid.evenementID;

SELECT JubileaVerenigingslid.jubileaID, naam, JubileaVerenigingslid.verenigingslidID, jubileaopmerking FROM Jubilea FULL JOIN JubileaVerenigingslid ON Jubilea.jubileaID = JubileaVerenigingslid.jubileaID