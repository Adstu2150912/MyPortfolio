/*
     Opdracht:       opdracht 6.2
     Auteur:         Adam Oubelkas
     Aanmaakdatum:   2-4-2017
     Bestandsnaam:   opdracht6.2.sql
*/

/*
	Volgorde bachman-diagram:
	Eerst moeten de tabellen 'school' en 'mentor' aangemaakt worden.
	Gevolgd door de tabel 'klas'.
	Tot slot tabel 'leerling'. 
	Verklaring:
	tabel 'leerling' vangt de vreemde sleutel 'klasnr' van tabel 'klas' waarin 'klasnr' de primaire sleutel is.
	tabel 'klas' neemt ook primaire sleutels in als vreemde sleutels van tabellen 'school' en 'mentor'.
	Oftewel: tabellen 'leerling' is afhankelijk van tabel 'klas'.
	tabel 'klas' is afhankelijk van tabellen 'mentor' en 'school'	  
*/

--maak nieuwe database 'De Boeg' aan
--CREATE DATABASE DeBoeg;
--GO

--Gebruik database 'De Boeg'
USE DeBoeg;

--Maak nieuwe tabel 'school' aan
CREATE TABLE school (
	schoolNr	INT				NOT NULL,
	naam		VARCHAR(30),
	adres		VARCHAR(30),
	postcode	CHAR(6),
	plaats		VARCHAR(50),
	telefoonnummer TINYINT,
	CONSTRAINT PK_schoolNr 
	PRIMARY KEY (schoolNr)	
);
--Maak nieuwe tabel 'mentor' aan
CREATE TABLE mentor (
	mentorNr	INT NOT NULL,
	voornaam	VARCHAR(255),
	achternaam	VARCHAR(255),
	geboortedatum	SMALLDATETIME,
	CONSTRAINT PK_mentorNr 
	PRIMARY KEY (mentorNr)
);
--Maak nieuwe tabel 'klas' aan
CREATE TABLE klas (
	klasNr		SMALLINT NOT NULL,
	naam		VARCHAR(255),
	niveau		VARCHAR(20),
	leerjaar	TINYINT,
	opmerking	VARCHAR(100),
);

--Maak nieuwe tabel 'leerling' aan
CREATE TABLE leerling (
	leerlingNr	INT NOT NULL,
	voornaam	VARCHAR(20),
	achternaam	VARCHAR(30),
	emailadres	VARCHAR(35),
	CONSTRAINT PK_leerlingNr 
	PRIMARY KEY (leerlingNr)	
);

ALTER TABLE klas
ADD schoolNr	INT NOT NULL;
--voeg primaire sleutel 'schoolNr' van tabel 'school'
--toe als refererende sleutel in tabel 'klas'
ALTER TABLE klas
ADD CONSTRAINT FK_schoolNr
FOREIGN KEY(schoolNr)
REFERENCES school(schoolNr);

--voeg primaire sleutel 'mentorNr' van tabel 'mentor'
--toe als refererende sleutel in tabel 'klas'

ALTER TABLE klas
ADD mentorNr	INT NOT NULL;


ALTER TABLE klas
ADD CONSTRAINT FK_mentorNr
FOREIGN KEY(mentorNr)
REFERENCES mentor(MentorNr);


ALTER TABLE klas
ADD KlasNr INT NOT NULL PRIMARY KEY(KlasNr);
--voeg primaire sleutel 'klasNr' van tabel 'klas'
--toe als refererende sleutel in tabel 'leerling'
ALTER TABLE leerling
ADD CONSTRAINT FK_klasNr
FOREIGN KEY(klasNr)
REFERENCES klas(klasNr);