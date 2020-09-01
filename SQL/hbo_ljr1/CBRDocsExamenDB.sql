/*
Auteur: Adam Oubelkas
Project: CBRDocs - Examendossier
Aanmaakdatum: 25-11-2019
Bestandsnaam: CBRDocsExamenDB.sql
*/

DROP DATABASE IF EXISTS CBRDocsExamenDB;
CREATE DATABASE CBRDocsExamenDB;
USE CBRDocsExamenDB;

/*Laag 1*/

/*Uit CogNIAM-Analyse afgeleide hoofdverzamelingen van de verzameling CategorieSet*/
/*CogNIAM verzamelingcode: H2017*/
CREATE TABLE Categoriecode
(
	Categoriecode VARCHAR(10) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2018*/
CREATE TABLE Categorienaam
(
	CategorieNaam VARCHAR(255) PRIMARY KEY
);

/*Uit CogNIAM-Analyse afgeleide hoofdverzamelingen van de verzameling ProductSet*/
/*CogNIAM verzamelingcode: H2019*/
CREATE TABLE Productcode
(
	Productcode VARCHAR(10) PRIMARY KEY   
);
/*CogNIAM verzamelingcode: H2020*/
CREATE TABLE Productnaam
(
	Productnaam VARCHAR(255) PRIMARY KEY
);

/*Uit CogNIAM-Analyse afgeleide hoofdverzamelingen van de verzameling KandidaatSet*/
/*CogNIAM verzamelingcode: H2001*/
CREATE TABLE Kandidaatnaam
(
	KandiNaam VARCHAR(255) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2003*/
CREATE TABLE  Kandidaat_Straatnaam
(
	KandiStrnm VARCHAR(100) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2004*/
CREATE TABLE Kandidaat_Huisnummer
(
	KandiHuisNr INT(3) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2005*/
CREATE TABLE Kandidaat_Huisnummer_Toevoeging
(
	KandiHuisNrToev VARCHAR(2) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2006*/
CREATE TABLE Kandidaat_Postcode
(
	KandiPost VARCHAR(6) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2007*/
CREATE TABLE Kandidaat_PlaatsNaam
(
	KandiPlaats VARCHAR(100) PRIMARY KEY
);

/*Uit CogNIAM-Analyse afgeleide hoofdverzamelingen van de verzameling OpleiderSet*/
/*CogNIAM verzamelingcode: H2008*/
CREATE TABLE Opleidernaam
(
	OpleiderNaam VARCHAR(255) PRIMARY KEY
); 
/*CogNIAM verzamelingcode: H2010*/
CREATE TABLE Opleider_Startdatum
(
	OpleiderStart DATE PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2011*/
CREATE TABLE Opleider_Einddatum
(
	OpleiderEind DATE PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2012*/
CREATE TABLE Opleider_Straatnaam
(
	OpleiderStrnm VARCHAR(100) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2013*/
CREATE TABLE Opleider_Huisnummer
(
	OpleiderHuisNr INT(3) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2014*/
CREATE TABLE Opleider_Huisnummer_Toevoeging
(
	OpleiderHuisNrToev VARCHAR(2) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2015*/
CREATE TABLE Opleider_Postcode
(
	OpleiderPost VARCHAR(6) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2016*/
CREATE TABLE Opleider_Plaatsnaam
(
	OpleiderPlaats VARCHAR(100) PRIMARY KEY
);

/*Uit CogNIAM-Analyse afgeleide hoofdverzamelingen van de verzameling ExamenLocatieSet*/
/*CogNIAM verzamelingcode: H2026*/
CREATE TABLE Examenlocatie_Plaatsnaam
(
	ExamLocPlaats VARCHAR(100) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2025*/
CREATE TABLE Examenlocatie_Postcode
(
	ExamLocPost VARCHAR(6) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2024*/
CREATE TABLE Examenlocatie_Huisnummer_Toevoeging
(
	ExamLocHuisNrToev VARCHAR(2) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2023*/
CREATE TABLE Examenlocatie_Huisnummer
(
	ExamLocHuisNr INT(3) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2022*/
CREATE TABLE Examenlocatie_Straatnaam
(
	ExamLocStraatNm VARCHAR(100) PRIMARY KEY
);

/*Uit CogNIAM-Analyse afgeleide hoofdverzamelingen van de verzameling ExamenSet*/
/*CogNIAM verzamelingcode: H2028*/
CREATE TABLE KoppelingBedieningSoort
(
	KopBedienSoort VARCHAR(30) PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2029*/
CREATE TABLE ExamenDatum
(
	ExamDatum DATE PRIMARY KEY
);
/*CogNIAM verzamelingcode: H2030*/
CREATE TABLE Resultaat
(
	Resultaat VARCHAR(25) PRIMARY KEY
);

/*Laag 2*/
/*Uit CogNIAM-Analyse afgeleide deelverzamelingen binnen de verzameling CategorieSet*/
CREATE TABLE CategorieSet
(
	CategorieCode VARCHAR(10) PRIMARY KEY  /*CogNIAM verzamelingcode: D2017*/
    ,CategorieNaam VARCHAR(255) /*CogNIAM verzamelingcode: D2018*/ NOT NULL
    ,CONSTRAINT FK_CategorieSet_CategorieCode FOREIGN KEY CategorieSet(CategorieCode) REFERENCES CategorieCode(CategorieCode)
    ,CONSTRAINT FK_CategorieSet_CategorieNaam FOREIGN KEY CategorieSet(CategorieNaam) REFERENCES CategorieNaam(CategorieNaam) 
);

/*Uit CogNIAM-Analyse afgeleide deelverzamelingen binnen de verzameling ProductSet*/
CREATE TABLE ProductSet
(
	ProductCode VARCHAR(10) PRIMARY KEY /*CogNIAM verzamelingcode: D2019*/
    ,ProductNaam VARCHAR(255) /*CogNIAM verzamelingcode: D2020*/ NOT NULL
    ,CONSTRAINT FK_ProductSet_ProductCode FOREIGN KEY ProductSet(ProductCode) REFERENCES ProductCode(ProductCode)
	,CONSTRAINT FK_ProductSet_ProductNaam FOREIGN KEY ProductSet(ProductNaam) REFERENCES ProductNaam(ProductNaam)
);

/*Uit CogNIAM-Analyse afgeleide hoofd- en deelverzamelingen binnen de verzameling KandidaatSet*/
CREATE TABLE KandidaatSet
(
	KandiNaam VARCHAR(255) NOT NULL /*CogNIAM verzamelingcode: D2001*/
    ,KandiCode VARCHAR(6) PRIMARY KEY /*CogNIAM verzamelingcode: H2002*/
    ,KandiStrnm VARCHAR(100) NULL /*CogNIAM verzamelingcode: D2003*/
    ,KandiHuisNr INT(3) NULL /*CogNIAM verzamelingcode: D2004*/
    ,KandiHuisNrToev VARCHAR(2) NULL /*CogNIAM verzamelingcode: D2005*/
    ,KandiPost VARCHAR(6) NULL /*CogNIAM verzamelingcode: D2006*/
    ,KandiPlaats VARCHAR(100) NULL /*CogNIAM verzamelingcode: D2007*/
    ,CONSTRAINT FK_KandidaatSet_KandiNaam FOREIGN KEY KandidaatSet(KandiNaam) REFERENCES Kandidaatnaam(KandiNaam)
    ,CONSTRAINT FK_KandidaatSet_KandiStrnm FOREIGN KEY KandidaatSet(KandiStrnm) REFERENCES Kandidaat_Straatnaam(KandiStrnm)
    ,CONSTRAINT FK_KandidaatSet_KandiHuisNr FOREIGN KEY KandidaatSet(KandiHuisNr) REFERENCES Kandidaat_Huisnummer(KandiHuisNr)
    ,CONSTRAINT FK_KandidaatSet_KandiHuisNrToev FOREIGN KEY KandidaatSet(KandiHuisNrToev) REFERENCES Kandidaat_Huisnummer_Toevoeging(KandiHuisNrToev)
	,CONSTRAINT FK_KandidaatSet_KandiPost FOREIGN KEY KandidaatSet(KandiPost) REFERENCES Kandidaat_Postcode(KandiPost)
    ,CONSTRAINT FK_KandidaatSet_KandiPlaats FOREIGN KEY KandidaatSet(KandiPlaats) REFERENCES Kandidaat_PlaatsNaam(KandiPlaats)
);

/*Uit CogNIAM-Analyse afgeleide hoofd- en deelverzamelingen binnen de verzameling OpleiderSet*/
CREATE TABLE OpleiderSet
(
	Opleidernaam VARCHAR(255) NOT NULL /*CogNIAM verzamelingcode: D2008*/
    ,Opleidercode VARCHAR(6) PRIMARY KEY /*CogNIAM verzamelingcode: H2009*/
    ,OpleiderStart DATE NULL /*CogNIAM verzamelingcode: D2010*/
    ,OpleiderEind DATE NULL /*CogNIAM verzamelingcode: D2011*/
    ,OpleiderStrnm VARCHAR(100) NULL /*CogNIAM verzamelingcode: D2012*/
    ,OpleiderHuisNr INT(3) NULL /*CogNIAM verzamelingcode: D2013*/
    ,OpleiderHuisNrToev VARCHAR(2) NULL /*CogNIAM verzamelingcode: D2014*/
    ,OpleiderPost VARCHAR(6) NULL /*CogNIAM verzamelingcode: D2015*/
    ,OpleiderPlaats VARCHAR(100) NULL /*CogNIAM verzamelingcode: D2016*/
    ,CONSTRAINT FK_OpleiderSet_Opleidernaam FOREIGN KEY OpleiderSet(Opleidernaam) REFERENCES Opleidernaam(OpleiderNaam)
    ,CONSTRAINT FK_OpleiderSet_OpleiderStart FOREIGN KEY OpleiderSet(OpleiderStart) REFERENCES Opleider_Startdatum(OpleiderStart)
    ,CONSTRAINT FK_OpleiderSet_OpleiderEind FOREIGN KEY OpleiderSet(OpleiderEind) REFERENCES Opleider_Einddatum(OpleiderEind)
    ,CONSTRAINT FK_OpleiderSet_OpleiderStrnm FOREIGN KEY OpleiderSet(OpleiderStrnm) REFERENCES Opleider_Straatnaam(OpleiderStrnm)
    ,CONSTRAINT FK_OpleiderSet_OpleiderHuisNr FOREIGN KEY OpleiderSet(OpleiderHuisNr) REFERENCES Opleider_Huisnummer(OpleiderHuisNr)
    ,CONSTRAINT FK_OpleiderSet_OpleiderHuisNrToev FOREIGN KEY OpleiderSet(OpleiderHuisNrToev) REFERENCES Opleider_Huisnummer_Toevoeging(OpleiderHuisNrToev)
    ,CONSTRAINT FK_OpleiderSet_OpleiderPost FOREIGN KEY OpleiderSet(OpleiderPost) REFERENCES Opleider_Postcode(OpleiderPost)
    ,CONSTRAINT FK_OpleiderSet_OpleiderPlaats FOREIGN KEY OpleiderSet(OpleiderPlaats) REFERENCES Opleider_Plaatsnaam(OpleiderPlaats)    
);

/*Uit CogNIAM-Analyse afgeleide hoofd- en deelverzamelingen binnen de verzameling ExamenLocatieSet*/
CREATE TABLE ExamenLocatieSet
(
	ExamLocNaam VARCHAR(255) PRIMARY KEY /*CogNIAM verzamelingcode: H2021*/
    ,ExamLocStraatNm VARCHAR(100) NOT NULL /*CogNIAM verzamelingcode: D2022*/
    ,ExamLocHuisNr INT(3) NOT NULL /*CogNIAM verzamelingcode: D2023*/
    ,ExamLocHuisNrToev VARCHAR(2) NULL /*CogNIAM verzamelingcode: D2024*/
    ,ExamLocPost VARCHAR(6) NOT NULL /*CogNIAM verzamelingcode: D2025*/
    ,ExamLocPlaats VARCHAR(100) NOT NULL /*CogNIAM verzamelingcode: D2026*/
    ,CONSTRAINT FK_ExamenLocatieSet_ExamLocStraatNm FOREIGN KEY ExamenLocatieSet(ExamLocStraatNm) REFERENCES Examenlocatie_Straatnaam(ExamLocStraatNm)
    ,CONSTRAINT FK_ExamenLocatieSet_ExamLocHuisNr FOREIGN KEY ExamenLocatieSet(ExamLocHuisNr) REFERENCES Examenlocatie_Huisnummer(ExamLocHuisNr)
    ,CONSTRAINT FK_ExamenLocatieSet_ExamLocHuisNrToev FOREIGN KEY ExamenLocatieSet(ExamLocHuisNrToev) REFERENCES Examenlocatie_Huisnummer_Toevoeging(ExamLocHuisNrToev)
    ,CONSTRAINT FK_ExamenLocatieSet_ExamLocPost FOREIGN KEY ExamenLocatieSet(ExamLocPost) REFERENCES Examenlocatie_Postcode(ExamLocPost)
	,CONSTRAINT FK_ExamenLocatieSet_ExamLocPlaats FOREIGN KEY ExamenLocatieSet(ExamLocPlaats) REFERENCES Examenlocatie_Plaatsnaam(ExamLocPlaats)
);

/*Laag 3*/

/*Uit CogNIAM-Analyse afgeleide hoofd- en deelverzamelingen binnen de verzameling ExamenSet*/
CREATE TABLE ExamenSet
(
	Examencode VARCHAR(6) PRIMARY KEY /*CogNIAM verzamelingcode: H2027*/
    ,ExamDatum DATE NOT NULL /*CogNIAM verzamelingcode: D2029*/
    ,ExamTijd TIME NULL
    ,KopBedienSoort VARCHAR(30) NULL /*CogNIAM verzamelingcode: D2028*/
    ,Resultaat VARCHAR(25) NOT NULL /*CogNIAM verzamelingcode: D2030*/
    ,ProductCode VARCHAR(10) NOT NULL /*CogNIAM verzamelingcode: D2019*/
    ,CategorieCode VARCHAR(10) NOT NULL /*CogNIAM verzamelingcode: D2017*/
    ,ExamLocNaam VARCHAR(255) NOT NULL /*CogNIAM verzamelingcode: D2021*/
    ,IsHerexamen BIT NULL /*Hier wordt bepaalt of het examen wel of niet een herexamen is*/
    /*,CONSTRAINT FK_ExamenSet_Examendatum FOREIGN KEY ExamenSet(ExamDatum) REFERENCES ExamenDatum(ExamDatum)
    ,CONSTRAINT FK_ExamenSet_ExamenKopBedienSoort FOREIGN KEY ExamenSet(KopBedienSoort) REFERENCES KoppelingBedieningSoort(KopBedienSoort)
	,CONSTRAINT FK_ExamenSet_Resultaat FOREIGN KEY ExamenSet(Resultaat) REFERENCES Resultaat(Resultaat)
    ,CONSTRAINT FK_ExamenSet_ProductSet FOREIGN KEY ExamenSet(ProductCode) REFERENCES ProductSet(ProductCode) 
	,CONSTRAINT FK_ExamenSet_CategorieSet FOREIGN KEY ExamenSet(CategorieCode) REFERENCES CategorieSet(CategorieCode)
    ,CONSTRAINT FK_ExamenSet_ExamLocNaam FOREIGN KEY ExamenSet(ExamLocNaam) REFERENCES ExamenLocatieSet(ExamLocNaam)*/
);

/*Uit CogNIAM-Analyse afgeleide hoofd- en deelverzamelingen binnen de verzameling RijOpleidingSet*/
CREATE TABLE RijOpleidingSet
(
	KandiCode VARCHAR(6) NOT NULL /*CogNIAM verzamelingcode: D2002*/
    ,KandiNaam VARCHAR(255) NOT NULL /*CogNIAM verzamelingcode: D2001*/
    ,Opleidercode VARCHAR(6) NOT NULL /*CogNIAM verzamelingcode: D2009*/
    ,OpleiderNaam VARCHAR(255) NOT NULL /*CogNIAM verzamelingcode: D2008*/
    ,PRIMARY KEY(KandiCode, Opleidercode)
    ,CONSTRAINT FK_RijOpleidingSet_KandiCode FOREIGN KEY RijOpleidingSet(KandiCode) REFERENCES KandidaatSet(KandiCode)
    ,CONSTRAINT FK_RijOpleidingSet_KandiNaam FOREIGN KEY RijOpleidingSet(KandiNaam) REFERENCES KandidaatSet(KandiNaam)
	,CONSTRAINT FK_RijOpleidingSet_Opleidercode FOREIGN KEY RijOpleidingSet(Opleidercode) REFERENCES OpleiderSet(Opleidercode)
    ,CONSTRAINT FK_RijOpleiderSet_OpleiderNaam FOREIGN KEY RijOpleidingSet(OpleiderNaam) REFERENCES OpleiderSet(OpleiderNaam)
);

/*Laag 4*/

/*Uit CogNIAM-Analyse afgeleide hoofd- en deelverzamelingen binnen de verzameling KandidaatExamenSet*/
CREATE TABLE KandidaatExamenSet
(
	KandiCode VARCHAR(6) NOT NULL /*CogNIAM verzamelingcode: D2002*/
    ,KandiNaam VARCHAR(255) NOT NULL /*CogNIAM verzamelingcode: D2001*/
    ,Examencode VARCHAR(6) NOT NULL /*CogNIAM verzamelingcode: D2027*/
    ,PRIMARY KEY (KandiCode, Examencode)
    /*,CONSTRAINT FK_KandidaatExamenSet_KandiCode FOREIGN KEY KandidaatExamenSet(KandiCode) REFERENCES KandidaatSet(KandiCode)
	,CONSTRAINT FK_KandidaatExamenSet_KandiNaam FOREIGN KEY KandidaatExamenSet(KandiNaam) REFERENCES KandidaatSet(KandiNaam)
    ,CONSTRAINT FK_KandidaatExamenSet_Examencode FOREIGN KEY KandidaatExamenSet(Examencode) REFERENCES ExamenSet(Examencode)*/
);

/*View maken voor het opzoeken van alle overeenkomende opleiders, kandidaten en examens, op basis van de gebruiker gewenste zoekterm en zoekwaarde*/

CREATE VIEW vwZoekExamenSet
AS
SELECT ExamenSet.Examencode, ExamenSet.ExamDatum, ExamenSet.ExamTijd, ExamenSet.KopBedienSoort, ExamenSet.Resultaat, ExamenSet.ProductCode, ExamenSet.CategorieCode, ExamenSet.IsHerexamen,
CategorieSet.CategorieNaam, ProductSet.ProductNaam,
ExamenLocatieSet.ExamLocNaam, ExamenLocatieSet.ExamLocStraatNm, ExamenLocatieSet.ExamLocHuisNr, ExamenLocatieSet.ExamLocHuisNrToev, ExamenLocatieSet.ExamLocPost, ExamenLocatieSet.ExamLocPlaats,
KandidaatSet.KandiNaam, KandidaatSet.KandiCode, KandidaatSet.KandiStrnm, KandidaatSet.KandiHuisNr, KandidaatSet.KandiHuisNrToev, KandidaatSet.KandiPost, KandidaatSet.KandiPlaats,
OpleiderSet.Opleidernaam, OpleiderSet.Opleidercode, OpleiderSet.OpleiderStart, OpleiderSet.OpleiderEind, OpleiderSet.OpleiderStrnm, OpleiderSet.OpleiderHuisNr, OpleiderSet.OpleiderHuisNrToev, OpleiderSet.OpleiderPost, OpleiderSet.OpleiderPlaats
FROM ExamenSet
JOIN CategorieSet ON ExamenSet.CategorieCode = CategorieSet.CategorieCode
JOIN ProductSet ON ExamenSet.ProductCode = ProductSet.ProductCode
JOIN ExamenLocatieSet ON ExamenSet.ExamLocNaam = ExamenLocatieSet.ExamLocNaam
JOIN KandidaatExamenSet ON ExamenSet.Examencode = KandidaatExamenSet.Examencode
JOIN KandidaatSet ON KandidaatExamenSet.KandiCode = KandidaatSet.KandiCode
JOIN RijOpleidingSet ON KandidaatSet.KandiCode = RijOpleidingSet.KandiCode
JOIN OpleiderSet ON RijOpleidingSet.Opleidercode = OpleiderSet.Opleidercode;

/*View maken voor het ophalen en sorteren van statistieken over examens, op basis van de gebruiker gewenste sorteerwaarde(s)*/
CREATE VIEW vwExamenStatistieken
AS
SELECT ExamenSet.Examencode, OpleiderSet.Opleidercode, CategorieSet.CategorieCode, ExamenLocatieSet.ExamLocNaam, ExamenSet.Resultaat, ExamenSet.IsHerexamen, ExamenSet.KopBedienSoort
FROM ExamenSet
JOIN CategorieSet ON ExamenSet.CategorieCode = CategorieSet.CategorieCode
JOIN ProductSet ON ExamenSet.ProductCode = ProductSet.ProductCode
JOIN ExamenLocatieSet ON ExamenSet.ExamLocNaam = ExamenLocatieSet.ExamLocNaam
JOIN KandidaatExamenSet ON ExamenSet.Examencode = KandidaatExamenSet.Examencode
JOIN KandidaatSet ON KandidaatExamenSet.KandiCode = KandidaatSet.KandiCode
JOIN RijOpleidingSet ON KandidaatSet.KandiCode = RijOpleidingSet.KandiCode
JOIN OpleiderSet ON RijOpleidingSet.Opleidercode = OpleiderSet.Opleidercode;

/*Database vullen met testgegevens*/

/*Laag 1*/

INSERT INTO Categoriecode
VALUES
('A')
,('B')
,('C')
,('A-G')
,('A2')
,('ATH')
,('AVB-A')
,('AVB-A2')
,('B-T')
,('BTH')
,('AMTH')
,('AM')
,('BE')
,('ADR1')
,('ADRB')
,('ADRBV')
,('ADRT')
,('ADRTV')
,('C1')
,('C1E')
,('CE')
,('D')
,('LZV')
,('R2C')
,('RV1')
,('RV1L')
,('T')
,('T-TH')
,('TVP')
,('TVT')
,('V2C')
,('V2D')
,('V3C')
,('V3D')
,('B-RT')
,('A1')
,('ADR1V')
,('ADR7')
,('ADR7V')
,('VVW')
,('VW')
,('AVB-A1')
,('A2-G')
,('TVPC')
,('A-NO')
,('HEFP')
,('HEFT')
,('REP')
,('RV1P')
,('DE');

INSERT INTO Categorienaam
VALUES
('Praktijkexamen motor verkeersdeelneming A rechtstreeks')
,('Praktijkexamen personenauto') 
,('Vrachtauto C praktijk (C)')
,('Praktijkexamen motor verkeersdeelneming A getrapt')
,('Praktijkexamen motor verkeersdeelneming A2')
,('Theorie-examen motor')
,('Praktijkexamen motor voertuigbeheersing A')
,('Praktijkexamen motor voertuigbeheersing A2')
,('Tussentijdse toets personenauto')
,('Theorie-examen personenauto')
,('Theorie-examen bromfiets')
,('Praktijkexamen bromfiets')
,('Personenauto met Aanhangwagen')
,('ADR klasse 1 (ADR1)')
,('ADR basis (ADRB)')
,('ADR basis verlenging (ADRBV)')
,('ADR tank (ADRT)')
,('ADR tank verlenging (ADRTV)')
,('Vrachtauto C1 praktijk (C1)')
,('Vrachtauto C1 met aanhangwagen praktijk (C1E)')
,('Vrachtauto C met aanhangwagen praktijk (CE)')
,('Bus D praktijk (D)')
,('Lange en zware voertuigen (praktijk) (LZV)')
,('Vrachtauto rijbewijs  - theorie deel 2, administratie (R2C)')
,('Vrachtauto C / Bus D  theorie deel 1, Verkeer en Techniek (RV1)')
,('Vrachtauto C1/ Bus D1  - theorie deel 1, Verkeer en Techniek light (RV1L)')
,('T-rijbewijs praktijk')
,('T-rijbewijs theorie')
,('Taxi vakbekwaamheid praktijk volledig (TVP)')
,('Taxi vakbekwaamheid theorie (TVT)')
,('Vrachtauto rijbewijs met code 95 - theorie deel 2, administratie (V2C)')
,('Bus rijbewijs met code 95- theorie deel 2, administratie (V2D)')
,('Vrachtauto rijbewijs met code 95- theorie deel 3, administratie cases (V3C)')
,('Bus rijbewijs met code 95 - theorie deel 3, administratie cases (V3D)')
,('Praktijkexamen motor verkeersdeelneming A1')
,('ADR klasse 1 verlenging (ADR1V)')
,('ADR klasse 7 (ADR7)')
,('ADR klasse 7 verlenging (ADR7V)')
,('Veiligheidsadviseur wegvervoer verlenging (VVW)')
,('Veiligheidsadviseur wegvervoer (VW)')
,('Praktijkexamen motor voertuigbeheersing A1')
,('RIS-toets personenauto')
,('Praktijkexamen motor verkeersdeelneming A2 getrapt')
,('Taxi vakbekwaamheid praktijk beperkt (TVPC)')
,('nader onderzoek rijvaardigheid motor verkeersdeelneming A')
,('Vorkheftruck praktijk (HEFP)')
,('Vorkheftruck theorie (HEFT)')
,('Reachtruck praktijk (REP)')
,('Vrachtauto C/ Bus D  - theorie deel 1, Verkeer en Techniek plus (RV1P)')
,('Bus D met aanhangwagen praktijk (DE)');

INSERT INTO Productcode
VALUES
('A')
,('B')
,('C');

INSERT INTO Productnaam
VALUES
('praktijkexamen motor verkeersdeelneming A')
,('praktijkexamen personenauto')
,('Vrachtauto C praktijk (C)');

INSERT INTO Kandidaatnaam
VALUES
('Jan van Pan')
,('Piet de Dief')
,('Kees Mees')
,('Mies Dies')
,('Jan Jansen')
,('Henk Hansen')
,('Jip van Spring')
,('Janneke van Sprang')
,('Job van Capelle')
,('Iris Roos')
,('Roosje Bloem')
,('Wendel de Mengel')
,('Catrina van der Land')
,('Tim Klusser')
,('Tom van de Ruiter')
,('Pim Boon');

INSERT INTO Kandidaat_Straatnaam
VALUES
('Bomenlaan')
,('Bladenweg')
,('Houtenwijk')
,('Mirandastraat')
,('Klokkenberg')
,('Strooplaan')
,('Ferdinandweg')
,('Burgermeester Van Burgerwijk')
,('Capellelaan')
,('Sprangseweg')
,('Orpsewijk')
,('Strijkerberg');

INSERT INTO Kandidaat_Huisnummer
VALUES
(23)
,(45)
,(67)
,(31)
,(63)
,(26)
,(97)
,(13)
,(51)
,(24)
,(58)
,(42);

INSERT INTO Kandidaat_Huisnummer_Toevoeging
VALUES
('A')
,('B')
,('C');

INSERT INTO Kandidaat_Postcode
VALUES
('1234AB')
,('5678CD')
,('4532EF')
,('1487EE')
,('2489JH')
,('3652HK')
,('9247YI')
,('8411RF')
,('1345NM')
,('6193KJ')
,('7965HD')
,('6876VE')
,('4819JN')
,('1084UI')
,('9251HB')
,('1698GJ')
,('3491IO')
,('5913BY')
,('8972OK')
,('4319IK')
,('3692KF');

INSERT INTO Kandidaat_PlaatsNaam
VALUES
('Breda')
,('s-Hertogenbosch')
,('Tilburg')
,('Arnhem')
,('Utrecht')
,('Rotterdam')
,('Amsterdam')
,('Eindhoven')
,('Apeldoorn')
,('Emmen')
,('Zwolle')
,('Maastricht');

INSERT INTO Opleidernaam
VALUES
('Auto en Motorrijschool Erik Barella')
,('Rijschool Actief')
,('Verkeersschool "Jaco van der Male"');

INSERT INTO Opleider_Startdatum
VALUES
('1998-01-12')
,('1992-09-14')
,('1998-01-13');

INSERT INTO Opleider_Einddatum
VALUES
('9999-12-31')
,('9999-03-01')
,('9999-07-06');

INSERT INTO Opleider_Straatnaam
VALUES
('De Brigantijn')
,('Beukelsdijk')
,('Elzenhof');

INSERT INTO Opleider_Huisnummer
VALUES
(6)
,(201)
,(10);

INSERT INTO Opleider_Huisnummer_Toevoeging
VALUES
('B')
,('C');

INSERT INTO Opleider_Postcode
VALUES
('5247LK')
,('3022DH')
,('2935SM');

INSERT INTO Opleider_Plaatsnaam
VALUES
('ROSMALEN')
,('ROTTERDAM')
,('OUDERKERK AAN DEN IJSSEL');

INSERT INTO Examenlocatie_Straatnaam
VALUES
('Hambakenwetering')
,('Zwolleweg')
,('Lichtenvoordsestraatweg');

INSERT INTO Examenlocatie_Huisnummer
VALUES
(13)
,(10)
,(87);

INSERT INTO Examenlocatie_Huisnummer_Toevoeging
VALUES
('A')
,('B')
,('C');

INSERT INTO Examenlocatie_Postcode
VALUES
('5231DD')
,('2803PS')
,('7121RD');

INSERT INTO Examenlocatie_Plaatsnaam
VALUES
("'S-HERTOGENBOSCH")
,('GOUDA')
,('AALTEN');

INSERT INTO KoppelingBedieningSoort
VALUES
('Automaat')
,('Combi')
,('Handgeschakeld');

INSERT INTO Examendatum
VALUES
('2016-03-01')
,('2017-04-01')
,('2018-05-01');

INSERT INTO Resultaat
VALUES
('Voldoende')
,('Onvoldoende')
,('N.t.b.'); 

/*Laag 2*/

INSERT INTO CategorieSet
VALUES
('A', 'Praktijkexamen motor verkeersdeelneming A rechtstreeks')
,('B', 'Praktijkexamen personenauto')
,('C', 'Vrachtauto C praktijk (C)');

INSERT INTO ProductSet
VALUES
('A', 'praktijkexamen motor verkeersdeelneming A')
,('B', 'praktijkexamen personenauto')
,('C', 'Vrachtauto C praktijk (C)');

INSERT INTO KandidaatSet
VALUES
('Jan van Pan', '0A3B6C', 'Bomenlaan', 23, 'A', '1234AB', 'Breda')
,('Piet de Dief', '1B2C7D', 'Bladenweg', 45, 'B', '5678CD', 's-Hertogenbosch')
,('Kees Mees', '232E2D', 'Houtenwijk', 67, 'C', '4532EF', 'Tilburg')
,('Mies Dies', '34SA2K', 'Mirandastraat', 31, NULL, '1487EE', 'Arnhem')
,('Jan Jansen', '9U39IW', 'Klokkenberg', 63, NULL, '2489JH', 'Utrecht')
,('Henk Hansen', '3Y6WS2', 'Strooplaan', 26, NULL, '3652HK', 'Rotterdam')
,('Jip van Spring', '5SJ8X0', 'Ferdinandweg', 97, NULL, '9247YI', 'Amsterdam')
,('Janneke van Sprang', '2ET37F', 'Burgermeester Van Burgerwijk', 13, NULL, '8411RF', 'Eindhoven')
,('Job van Capelle', '6A91GJ', 'Capellelaan', 51, NULL, '1345NM', 'Apeldoorn')
,('Iris Roos', '3RQ12K', 'Sprangseweg', 24, NULL, '6193KJ', 'Emmen')
,('Roosje Bloem', '6B22T3', 'Orpsewijk', 58, NULL, '7965HD', 'Zwolle')
,('Wendel de Mengel', '7IP12Z', 'Strijkerberg', 42, NULL, '6876VE', 'Maastricht');

INSERT INTO OpleiderSet
VALUES
('Auto en Motorrijschool Erik Barella', '0003F8', '1998-01-12', '9999-12-31', 'De Brigantijn', 6, 'B', '5247LK', 'ROSMALEN')
,('Rijschool Actief', '0003U7', '1992-09-14', '9999-03-01', 'Beukelsdijk', 201, 'B', '3022DH', 'ROTTERDAM')
,('Verkeersschool "Jaco van der Male"', '0004Z8', '1998-01-13', '9999-07-06', 'Elzenhof', 10, 'C', '2935SM', 'OUDERKERK AAN DEN IJSSEL');

INSERT INTO ExamenLocatieSet
VALUES
('Den Bosch (Hambakenwetering 13A)', 'Hambakenwetering', 13, 'A', '5231DD', "'S-HERTOGENBOSCH")
,('Gouda (Zwolleweg 10)', 'Zwolleweg', 10, NULL, '2803PS', 'GOUDA')
,('Aalten (Lichtenvoordsestraatweg 87)', 'Lichtenvoordsestraatweg', 87, NULL, '7121RD', 'AALTEN');

/*Laag 3*/
INSERT INTO ExamenSet
VALUES
('EA24TH', '2016-03-01', NULL, 'Automaat', 'Voldoende', 'A', 'A', 'Den Bosch (Hambakenwetering 13A)', 0)
,('AW79NM', '2017-04-01', NULL, 'Combi', 'Onvoldoende', 'B', 'B', 'Gouda (Zwolleweg 10)', 1)
,('IR68DQ', '2018-05-01', NULL, 'Handgeschakeld', 'N.t.b.', 'C', 'C', 'Aalten (Lichtenvoordsestraatweg 87)', 0);

INSERT INTO RijOpleidingSet
VALUES
('0A3B6C', 'Jan van Pan', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('1B2C7D', 'Piet de Dief', '0003U7', 'Rijschool Actief')
,('232E2D', 'Kees Mees', '0004Z8', 'Verkeersschool "Jaco van der Male"')
,('2ET37F', 'Janneke van Sprang', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('34SA2K', 'Mies Dies', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('3RQ12K', 'Iris Roos', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('3Y6WS2', 'Henk Hansen', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('5SJ8X0', 'Jip van Spring', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('6A91GJ', 'Job van Capelle', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('6B22T3', 'Roosje Bloem', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('7IP12Z', 'Wendel de Mengel', '0003F8', 'Auto en Motorrijschool Erik Barella')
,('9U39IW', 'Jan Jansen', '0003F8', 'Auto en Motorrijschool Erik Barella');

/*Laag 4*/

INSERT INTO KandidaatExamenSet
VALUES
('0A3B6C', 'Jan van Pan', 'EA24TH')
,('1B2C7D', 'Piet de Dief','AW79NM')
,('2C3D8E', 'Kees Mees', 'IR68DQ');

SELECT * FROM vwZoekExamenSet;

SELECT * FROM OpleiderSet;
SELECT * FROM ExamenSet;
SELECT * FROM KandidaatExamenSet;
