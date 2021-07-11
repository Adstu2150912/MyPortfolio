--  Opdracht:		Toets SQL periode 4
--  Auteur:			<Adam Oubelkas>
--	Aanmaakdatum:	<15-06-2017>
--	Versie:			<A>


-----------------------------------------------------
----------------- DEEL 1 - Relaties -----------------
-----------------------------------------------------

USE MASTER;

CREATE DATABASE SQLrelaties;
GO

USE SQLrelaties;

CREATE TABLE data_base (
	databaseID			INT IDENTITY(1,1) PRIMARY KEY,
	SQLsyntax			VARCHAR(30)
)

CREATE TABLE gebruiker (
	gebruikerID			INT IDENTITY(1,1) PRIMARY KEY,
	geslacht			VARCHAR(10)
)

CREATE TABLE database_gebruiker (
	FOREIGN KEY(databaseID)
	REFERENCES data_base(databaseID),
	FOREIGN KEY(gebruikerID)
	REFERENCES gebruiker(gebruikerID),
	PRIMARY KEY (databaseID, gebruikerID)		
)

CREATE TABLE tabel (
	tabelID			INT IDENTITY(1,1) PRIMARY KEY,
	aantalKolommen INT NOT NULL
)

ALTER TABLE	data_base
ADD FOREIGN KEY(tabelID)
REFERENCES	tabel(tabelID);

ALTER TABLE	tabel
ADD FOREIGN KEY(databaseID)
REFERENCES	data_base(databaseID);



-----------------------------------------------------
-------- DEEL 2 - Update en select-statements -------
-----------------------------------------------------
USE music;

-- 1.
USE music;
UPDATE album
SET year = 1986, genre = 'Rock', subgenre = 'Thrash' 
WHERE position = 167;

-- 2.
USE music;
SELECT *
FROM album
WHERE year > 1965 AND artist = 'The Beatles';

-- 3.
USE music;
SELECT DISTINCT genre
FROM album
WHERE subgenre is NOT NULL;

-- 4.
USE music;
SELECT name, artist, year
FROM album
WHERE genre = 'Hip Hop' 
ORDER BY year DESC;

-- 5.

SELECT year, position AS [aantal]
FROM album
WHERE year = year AND position < 2;


-- Bonus.

SELECT artist
FROM album
WHERE AVG(year) = 1970;

---------------------------------------------
---------------------------------------------
--                                  _      --
--                                 | |     --
--      ___ _   _  ___ ___ ___  ___| |     --
--     / __| | | |/ __/ __/ _ \/ __| |     --
--     \__ \ |_| | (_| (_|  __/\__ \_|     --
--     |___/\__,_|\___\___\___||___(_)     --
--                                         --
---------------------------------------------
---------------------------------------------