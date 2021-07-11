/*
Auteur: Adam Oubelkas
Project: Elektronisch Patiëntendossier - De Graafschap
Aanmaakdatum: 11-10-2019
Bestandsnaam: DeGraafschapDB.sql
*/

DROP DATABASE IF EXISTS DeGraafschapDB;
CREATE DATABASE DeGraafschapDB;
USE DeGraafschapDB;

CREATE TABLE Patiënt
(
	Patiëntnummer INT NOT NULL
    ,Naam VARCHAR(255) NOT NULL
    ,Geslacht BIT NOT NULL /*0 = Man, 1 = Vrouw*/
    ,Diersoort VARCHAR(255) NOT NULL
    ,Dierras VARCHAR(255) NOT NULL
    ,Gewicht DECIMAL(3, 1) NOT NULL /*Gewicht in kg*/
    ,Geboortedatum DATE NOT NULL
    ,Labuitslag VARCHAR(255) NOT NULL
    ,Opnameverslag VARCHAR(255) NOT NULL
    ,Verblijfruimte VARCHAR(25)
    ,Aanwezigheid BIT /*0 = afwezig, 1 = aanwezig*/
    ,PRIMARY KEY (Patiëntnummer, Naam)
);

CREATE TABLE Klant
(
	Klantnummer INT NOT NULL
    ,Naam VARCHAR(255) NOT NULL
    ,Geslacht BIT NOT NULL /*0 = Man, 1 = Vrouw*/
    ,Geboortedatum DATE NOT NULL
    ,Woonadres VARCHAR(255) NOT NULL
    ,Telefoonnummer VARCHAR(30)
    ,Emailadres VARCHAR(50)
    ,PRIMARY KEY(Klantnummer, Naam)
    ,Patiëntnummer INT UNIQUE NOT NULL
    ,Patiëntnaam VARCHAR(255) UNIQUE NOT NULL
    ,CONSTRAINT FK_Klant_Patiënt FOREIGN KEY Klant(Patiëntnummer, Patiëntnaam) REFERENCES Patiënt(Patiëntnummer, Naam)
);

INSERT INTO Patiënt
VALUES 
(123, 'Jip', 0, 'Hond', 'Goldenretriever', 13.0, '2010-03-11', 'Positief, deze hond is nog gezond', 'Deze hond heeft door het dossier aanbevolen medicatie gekregen', 'Balie', 0)
,(456, 'Peter', 0, 'Vogel', 'Papegaai', 0.6, '2013-06-21', 'Negatief, deze vogel is niet gezond', 'Deze vogel heeft door het dossier aanbevolen behandeling gekregen', 'Wachtkamer', 1)
,(789, 'Kas', 1, 'Kat', 'Siamees', 5.0, '2016-10-31', 'Positief, deze kat is nog gezond', 'Deze hond heeft door het dossier aanbevolen opname gekregen', 'Behandelkamer', 1);

INSERT INTO Klant
VALUES
(987, 'Jan van Pan', 0, '1993-04-13', 'Bomenlaan 23, 1234AB Breda', '0123-456789', 'jan.vanpan@hotmail.nl', 123, 'Jip')
,(654, 'Piet de Dief', 0, '1986-07-23', "Bladenweg 45, 5678 CD 's-Hertogenbosch", '0546-213897', 'piet.dedief@hotmail.nl', 456, 'Peter')
,(321, 'Kees Mees', 1, '1989-11-02', 'Houtenwijk 67, 4532 EF Tilburg', '0936-748152', 'kees.mees@hotmail.nl', 789, 'Kas');

SELECT * FROM Klant JOIN Patiënt ON Klant.Patiëntnummer = Patiënt.Patiëntnummer;

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'tre!h9587sty#e';

SELECT * FROM Patiënt;
SELECT * FROM Klant;

SELECT COUNT(Patiëntnummer) AS AantalPatiëntNr FROM Patiënt;