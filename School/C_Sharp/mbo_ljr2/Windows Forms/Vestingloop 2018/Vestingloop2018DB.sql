/*
Naam:	        Database voor Vestingloop 2018
Auteur:         Adam Oubelkas
Aanmaakdatum:   15-6-2018 + 11:58
Bestandsnaam:   Vestingloop2018DB.sql
*/

USE MASTER;
GO

IF EXISTS(SELECT * FROM sys.databases WHERE NAME = 'Vestingloop2018DB')
DROP DATABASE Vestingloop2018DB;
GO

CREATE DATABASE Vestingloop2018DB;
GO

USE Vestingloop2018DB;

CREATE TABLE BE_Deelname
(
	BE_Deelname_ID	INT IDENTITY(1,1) CONSTRAINT PK_BE_Deelname PRIMARY KEY CLUSTERED
	,Deelnemer			VARCHAR(50)	NOT NULL
	,Afkomst			VARCHAR(50) NOT NULL
	,Leeftijd			TINYINT		NOT NULL
);

CREATE TABLE BE_Geo_Route
(
	RouteH204	VARCHAR(6) CONSTRAINT PK_BE_Geo_Route PRIMARY KEY CLUSTERED
	,[Geo-coödinaten] VARCHAR(MAX) 
);

CREATE TABLE FE_Deelname
(
	FE_Deelname_ID	INT IDENTITY(1,1) CONSTRAINT PK_FE_Deelname PRIMARY KEY CLUSTERED
	,BE_Deelname_ID	INT CONSTRAINT FK_FE_Deelname_BE_Deelname FOREIGN KEY REFERENCES BE_Deelname(BE_Deelname_ID)
	,Deelnemer		VARCHAR(50)	NOT NULL
	,Afkomst		VARCHAR(50) NOT NULL
	,Leeftijd		TINYINT		NOT NULL
);

CREATE TABLE BE_Resultaat
(
	 BE_Resultaat_ID INT IDENTITY(1,1) CONSTRAINT PK_BE_Resultaat PRIMARY KEY CLUSTERED
	,BE_Deelname_ID INT CONSTRAINT FK_BE_Resultaat_BE_Deelname FOREIGN KEY REFERENCES BE_Deelname(BE_Deelname_ID)
	,Deelnemer	VARCHAR(50) NOT NULL
	,RouteD204	VARCHAR(6) CONSTRAINT FK_BE_Resultaat_BE_Geo_Route FOREIGN KEY REFERENCES BE_Geo_Route(RouteH204)
	,Tijd		TIME(0) DEFAULT 'N.v.t.'
	,Rang		INT	DEFAULT 'N.v.t.'
);

CREATE TABLE FE_Resultaat
(
	FE_Resultaat_ID INT IDENTITY(1,1) CONSTRAINT PK_FE_Resultaat PRIMARY KEY CLUSTERED
	,BE_Resultaat_ID INT CONSTRAINT FK_FE_Resultaat_BE_Resultaat FOREIGN KEY REFERENCES BE_Resultaat(BE_Resultaat_ID)
	,Deelnemer		VARCHAR(50) NOT NULL
	,RouteD204		VARCHAR(6) NOT NULL
	,Tijd			TIME(0) DEFAULT 'N.v.t.'
	,Rang			INT DEFAULT 'N.v.t.'
);

GO

INSERT INTO BE_Deelname(Deelnemer, Afkomst, Leeftijd)
VALUES('Hans Jaapen', 'Nederland(Gelderland)', 47)
,('John Norton', 'Engeland', 32)
,('Lindsey von Dusseldorf', 'Duitsland', 38);

INSERT INTO BE_Geo_Route(RouteH204, [Geo-coödinaten])
VALUES('5km', '[23.4582348,37.5062675],[23.4577141,37.5066109]')
,('10km', '[24.4582348,37.5062675],[24.4577141,37.5066109]')
,('15km', '[25.4582348,37.5062675],[25.4577141,37.5066109]');

INSERT INTO BE_Resultaat(BE_Deelname_ID, Deelnemer, RouteD204, Tijd, Rang)
VALUES(1, 'Hans Jaapen', '5km', '02:00:00', 3)
,(2, 'John Norton', '10km', '01:00:00', 1)
,(3, 'Lindsey von Dusseldorf', '15km', '01:30:00', 2);

INSERT INTO FE_Deelname(BE_Deelname_ID, Deelnemer, Afkomst, Leeftijd)
VALUES(1, 'Hans Jaapen', 'Nederland(Gelderland)', 47)
, (2, 'John Norton', 'Engeland', 32)
, (3, 'Lindsey von Dusseldorf', 'Duitsland', 38);

INSERT INTO FE_Resultaat(BE_Resultaat_ID, Deelnemer, RouteD204, Tijd, Rang)
VALUES(1, 'Hans Jaapen', '5km', '02:00:00', 3)
,(2, 'John Norton', '10km', '01:00:00', 1)
,(3, 'Lindsey von Dusseldorf', '15km', '01:30:00', 2);