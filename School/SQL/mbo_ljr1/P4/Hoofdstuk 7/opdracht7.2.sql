USE world
-- Schrijf de volgende UPDATE-statements:
-- 1. Voorspel wie de nieuwe President van Frankrijk wordt (Macron of Le Pen). Pas Frankrijk aan zodat jouw voorspelling als president in de tabel staat.
UPDATE country
SET headOfState = 'Macron'
WHERE name = 'France';
-- 2. Pas alle landen aan waar George W. Bush president is naar Donald J. Trump.
UPDATE country
SET headOfState = 'Donald J. Trump'
WHERE name = 'George W. Bush';
-- 3. Het leven in Europa is goed. Verhoog de levensverwachting van alle landen in Europa met 2 jaar.
UPDATE country
SET lifeExpectancy = lifeExpectancy - 2
WHERE continent = 'Europe';
-- 4. Pas de volgende gegevens van het land 'British Indian Ocean Territory' aan:
--		Inwoners: 2.500
--		Levensverwachting: 74,3
--		Gnp: 42.300
UPDATE country
SET population = 2500, lifeExpectancy = 74.3, gnp = 42300
WHERE name = 'British Indian Ocean Territory';
-- 5. Voor je verjaardag heb jij het 'Bouvet Island' kado gekregen. Pas de volgende gegevens aan:
--		Staatshoofd: <Jouw naam>
--		Inwoners: <zelf invullen>
--		IndepYear: <Jouw geboortejaar>
--		LocalName: <zelf invullen>
UPDATE country
SET headOfState = 'Adam Oubelkas', population = 32, indepYear = 1997, localName = 'Republic of Apes'
WHERE name = 'Bouvet Island';
-- 6. Alle landen met een oppervlakte tussen de 0 en 1.000 km2 of een levensverwachting van kleiner dan 40 jaar krijgen de toevoeging '(negatief)' achter hun naam. Pas zowel de naam als de lokale naam aan. Voorbeeld Mozambique wordt Mozambique (negatief).
UPDATE country
SET name = name + '(negative)', localName = localName + '(negative)'
WHERE surfaceArea BETWEEN 0 AND 1000 OR lifeExpectancy < 40;


SELECT name, localname, surfaceArea
FROM country
WHERE surfaceArea BETWEEN 0 AND 1000 OR lifeExpectancy < 40;
-- Geef antwoord op de volgende vragen d.m.v. een SQL-statement (dus niet het antwoord):
-- 7. Geef de namen van de Afrikaanse landen waarvan de levensverwachting tussen de 60 en 70 jaar is.
SELECT name
FROM country
WHERE continent = 'Africa' AND lifeExpectancy BETWEEN 60 AND 70;
-- 8. Geef de lokale namen van alle Aziatische landen die een republiek zijn en grotere zijn dan 30.000 km2.
SELECT localName
FROM country
WHERE continent = 'Asia' and governmentForm = 'Republic' AND surfaceArea > 30000;
-- 9. Geef de namen, levensverwachting en landcode van alle landen waar de staatshoofd Elisabeth II of Harald V is.
SELECT name, lifeExpectancy, code
FROM country
WHERE headOfState = 'Elisabeth II' or headOfState = 'Harald V';
-- 10. Geef de namen, continenten en regios van alle landen die in Europa liggen en minder dan 10.000.000 inwoners hebben of alle landen in Azië met een levensverwachting hoger of gelijk aan 70 jaar.
SELECT name, continent, region
FROM country
WHERE continent = 'Europe' AND population < 10000000 OR continent = 'Asia' AND lifeExpectancy >= 70;
-- 11a. Geef alle continenten waar de staatsvorm een 'Federal Republic' is.
SELECT continent
FROM country
WHERE governmentForm = 'Federal Republic';
-- 11b. Geef alle continenten waar de staatsvorm een 'Federal Republic' is. (continenten worden maar eenmaal getoond).
SELECT DISTINCT continent
FROM country
WHERE governmentForm = 'Federal Republic';
-- 12. Geef alle staatshoofden van de landen waarbij de landcode tussen de 'RA' en de 'TZ' zit (staatshoofden worden maar eenmaal getoond).
SELECT DISTINCT headOfState
FROM country
WHERE code BETWEEN 'RA' AND 'TZ'; 
/*
SELECT name, localname
FROM country
WHERE surfaceArea BETWEEN 0 AND 1000 OR lifeExpectancy < 40;
*/
-- ALTER TABLE country
-- ALTER COLUMN name varchar(200) NOT NULL;

  

