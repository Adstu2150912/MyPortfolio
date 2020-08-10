-- TOETS SQL P7
-- Naam: Adam Oubelkas
-- Klas: IO2B4
USE Movies;
GO

-- SUBQUERY
-- 1.
-- Toon de titel, budget en aantal oscars van de films die meer hebben dan Frozen
SELECT Title, BudgetDollars, OscarWins
FROM Film
WHERE BoxOfficeDollars > (SELECT BoxOfficeDollars FROM Film WHERE Title = 'Frozen');

--JOINS
-- 2.
-- Toon van ALLE films de titel, het genre en het land van herkomst.
SELECT F.Title, G.Genre, C.Country
FROM Film F
JOIN Genre G ON F.GenreID = G.GenreID
LEFT JOIN Country C ON F.CountryID = C.CountryID
ORDER BY C.Country;

-- 3.
--Toon de voor- en achternaam en de rol van alle acteurs van de film 'Demolition Man'.
SELECT firstName, FamilyName, [Role]
FROM Actor
INNER JOIN [Role] ON Actor.ActorID = [Role].ActorID
INNER JOIN Film ON [Role].FilmID = Film.FilmID
WHERE Title = 'Demolition Man';


-- 4.
-- Toon alle films waarvan de regisseur is overleden.
SELECT Title --moet dit zijn: SELECT *
FROM Film
LEFT JOIN Director ON Film.DirectorID = Director.DirectorID -- moet zijn INNER JOIN
WHERE Director.DoD IS NOT NULL;

/*
SELECT *
FROM Film
WHERE DirectorID IN (SELECT DirectorID
					FROM Director 
					WHERE DoD IS NOT NULL);
*/

--CARTESIAANS PRODUCT
-- Toon alle mogelijke combinaties van de tabellen certificate, Genre, Language.  Toon niet de primaire sleutels (ID's)
-- 5.
SELECT [Certificate], Genre, [Language]
FROM [Certificate]
CROSS JOIN Genre, [Language];
/*
CROSS JOIN [Certificate]
CROSS JOIN [Language]
*/

/*
SELECT [Certificate], Genre, [Language]
FROM [Certificate], Genre, [Language]; 
*/


--SCALAIRE FUNCTIES
-- Toon het laagste budget en de gemiddelde tijdsduur van alle Mad Max-Films (4-stuks)
-- 6.
SELECT MIN(BudgetDollars), AVG(RunTimeMinutes)
FROM Film
WHERE Title LIKE 'Mad Max%'

-- Toon de film(s) die op 27 oktober is/zijn uitgekomen. Jaar maakt niet uit.
-- 7.
SELECT *
FROM Film
WHERE CAST(MONTH(ReleaseDate) AS INT) = 10 AND CAST(DAY(ReleaseDate) AS INT) = 27; -- MONTH(ReleaseDate) = 10 AND DAY(ReleaseDate) = 27

--Toon de achternaam in hoofdletters van de acteurs waarvan de tweede en derde letter 'wa' is.

-- 8.
SELECT UPPER(FamilyName)
FROM Actor
WHERE SUBSTRING(FamilyName, 2, 1) = 'w' AND SUBSTRING(FamilyName, 3, 1) = 'a'; -- WHERE SUBSTRING(FamilyName, 2, 2) = 'wa';
-- WHERE FamilyName LIKE '_wa%';

--VIEWS
-- Maak een view waarin je alle films toont van regisseur 'Steven Spielberg'.
-- Toon de titel, release datum, review en de volledige naam van de regisseur (voornaam en achternaam)
-- 9.
CREATE VIEW vw_Steven_Spielberg_movies
AS
SELECT Title, ReleaseDate, Review, CONCAT(FirstName, + ' ' + FamilyName) AS VolledigeNaam
FROM Film
INNER JOIN Director ON Film.DirectorID = Director.DirectorID
WHERE FirstName = 'Steven' AND FamilyName = 'Spielberg';
 
-- 10.
ALTER VIEW vw_Steven_Spielberg_movies
AS
SELECT Title, ReleaseDate, Review, CONCAT(FirstName, + ' ' + FamilyName) AS VolledigeNaam
FROM Film
INNER JOIN Director ON Film.DirectorID = Director.DirectorID
WHERE FirstName = 'Steven' AND FamilyName = 'Spielberg'
AND CAST(YEAR(ReleaseDate) AS INT) > 2000; 
/*
AND YEAR(ReleaseDate) >= 2000
*/


-- 11.
DROP VIEW vw_Steven_Spielberg_movies;

-- CONSTRAINTS
-- Pas onderstaande CREATE aan, zodat die voldoet aan de volgende voorwaarden:
-- Voornaam en achternaam mogen NIET leeg zijn.
-- Bij klas wordt gecontroleerd of de waarde 'IO2A4' is.
-- De leerlingID en leerlingCode moeten uniek zijn.
-- Bij datum moet standaard de datum van vandaag ingevuld worden
-- telaatdpas staat standaard op 0
-- de leerlingID begint vanaf 3000 en wordt ieder keer verhoogt met 5


-- 12.
CREATE TABLE telaatmeldingen
(
	leerlingID		INT PRIMARY KEY IDENTITY(3000,5),
	leerlingCode	INT UNIQUE,
	voornaam		VARCHAR(50) NOT NULL,
	achternaam		VARCHAR(50) NOT NULL,
	klas			CHAR(5),
	datum			DATE DEFAULT '2018-04-11', -- DEFAULT CONVERT(DATE, GETDATE()),
	tijd			TIME,
	reden			VARCHAR(25),
	teLaatPas		BIT DEFAULT 0,
	mentorID		INT,
	CONSTRAINT chk_klas CHECK(klas = 'IO2A4' OR klas = 'IO2B4' OR klas = 'IO2C4'), -- CHECK(klas IN ('IO2A4', 'IO2B4', 'IO2C4'))
);

-- INDEX
-- Bedenk twee logische indexen voor de tabel telaatmeldingen. Kies zelf de kolommen waarvan je denkt die vaak worden gebruikt.
-- 13.

/*
CREATE INDEX idxTelaatMeldingenMentorID
ON telaatmeldingen(mentorID);

CREATE INDEX idxTelaatMeldingenAchternaam
ON telaatmeldingen(achternaam);

CREATE INDEX idxTelaatMeldingenMentorID
ON telaatmeldingen;

CREATE INDEX idxTelaatMeldingenAchternaam
ON telaatmeldingen;
*/
CREATE INDEX IX_leerlingID
ON telaatmeldingen(leerlingID)

CREATE INDEX IX_klas
ON telaatmeldingen(klas)

CREATE INDEX IX_voornaam
ON telaatmeldingen(voornaam)

CREATE INDEX IX_achternaam
ON telaatmeldingen(achternaam)

CREATE INDEX IX_leerlingCode
ON telaatmeldingen(leerlingCode)

CREATE INDEX IX_datum
ON telaatmeldingen(datum)

CREATE INDEX IX_tijd
ON telaatmeldingen(tijd)

-- 14.
DROP INDEX IX_leerlingID
ON telaatmeldingen

DROP INDEX IX_klas
ON telaatmeldingen

DROP INDEX IX_voornaam
ON telaatmeldingen

DROP INDEX IX_achternaam
ON telaatmeldingen

DROP INDEX IX_leerlingCode
ON telaatmeldingen

DROP INDEX IX_datum
ON telaatmeldingen

DROP INDEX IX_tijd
ON telaatmeldingen
