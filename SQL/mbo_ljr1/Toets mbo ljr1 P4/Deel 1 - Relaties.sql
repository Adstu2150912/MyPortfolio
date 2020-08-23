USE MASTER;
GO

CREATE DATABASE SQLrelaties;
GO

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