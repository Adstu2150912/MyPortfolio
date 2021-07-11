-- TOETS SQL - PERIODE 8
-- Versie: A
-- Naam: Adam Oubelkas
-- Klas: IO2B4

USE superheroes;
GO

-- STORED PROCEDURES
--1.
CREATE PROCEDURE spOverViewHeroes @publisherName VARCHAR(30) = NULL, @raceName VARCHAR (30) = NULL
AS
SELECT hero.name, publisher.name, race.name
FROM hero
INNER JOIN publisher ON hero.publisherId = publisher.publisherId
INNER JOIN race ON hero.raceId = race.raceId
WHERE publisher.name = @publisherName OR race.name = @raceName;  


-- 2.
EXEC spOverViewHeroes @publisherName = 'J. R. R. Tolkien';
GO

-- 3.
EXEC spOverViewHeroes @raceName = N'Eternal';
GO

-- TOEGANGSBEHEER
-- 4.
USE master;
GO

CREATE LOGIN Toets_SQL_P8
WITH PASSWORD = 'pwd123' MUST_CHANGE, 
CHECK_EXPIRATION = ON;
GO
 
EXEC sp_addsrvrolemember @loginame= Toets_SQL_P8,
@rolename = serveradmin;
GO


-- 5.
USE superheroes;
GO

CREATE USER dbUser1 FOR LOGIN Toets_SQL_P8;
GO
EXEC sp_addrolemember @rolename = db_ddladmin, @membername = dbUser1;

CREATE USER dbUser2 FOR LOGIN Toets_SQL_P8;
GO

CREATE ROLE user_ReadOnly;
GO

GRANT SELECT ON superheroes.hero TO user_ReadOnly;
EXEC sp_addrolemember user_ReadOnly, dbUser2;
GO

-- DATABASE & BACKUP
-- 6.
IF EXISTS (SELECT * FROM sys.databases WHERE NAME = 'toetsP8')
DROP DATABASE toetsP8;

CREATE DATABASE toetsP8
ON(NAME = 'toetsP8_dat', 
	FILENAME = 'C:\Users\X-Kai\Desktop\DatabaseToetsP8\toetsP8.mdf',
	SIZE = 20MB,
	MAXSIZE = 60MB,
	FILEGROWTH = 6MB)
LOG ON (
	NAME = 'toetsP8_log',
	FILENAME = 'C:\Users\X-Kai\Desktop\DatabaseToetsP8\toetsP8_log.ldf',
	SIZE = 2MB,
	MAXSIZE = 6MB,
	FILEGROWTH = 1MB)
GO

USE toetsP8;
GO


-- 7.
BACKUP DATABASE toetsP8
   TO DISK = 'C:\Users\X-Kai\Desktop\DatabaseToetsP8\toetsP8_Backup.bak';
GO

-- 8. 
ALTER DATABASE toetsP8
MODIFY NAME = toetsP8_corrupt;
GO


-- 9. 
IF EXISTS (SELECT * FROM sys.databases WHERE NAME = 'toetsP8_corrupt')
DROP DATABASE toetsP8_corrupt;

RESTORE DATABASE toetsP8_backup
   FROM DISK = 'C:\Users\X-Kai\Desktop\DatabaseToetsP8\toetsP8_Backup.bak';
GO


-- BONUS
-- 10.
-- Opmerking: In de toets zit een fout. In de toets wordt verwezen naar opgave 4, maar dit klopt niet.
-- De stored procedure moet een compleet nieuwe stored procedure worden.
-- Opgave 4 heeft niks met deze opgave te maken.
ALTER PROCEDURE spOverViewHeroes @colorName VARCHAR(30)
AS
SELECT hero.name, c1.name AS EyeColor, c2.name AS HairColor, c3.name AS SkinColor 
FROM hero
LEFT JOIN color AS c1 ON hero.eyeColorId = c1.colorId
LEFT JOIN color AS c2 ON hero.hairColorId = c2.colorId
LEFT JOIN color AS c3 ON hero.skinColorId = c3.colorId
WHERE c1.name = @colorName OR c2.name = @colorName OR c3.name = @colorName;

EXEC spOverViewHeroes @colorName = 'red';