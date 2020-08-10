CREATE TABLE telaatmeldingen
(
	leerlingID		INT,
	leerlingCode	INT,
	voornaam		VARCHAR(50),
	achternaam		VARCHAR(50),
	klas			CHAR(5),
	datum			DATE,
	tijd			TIME,
	reden			VARCHAR(25),
	teLaatPas		BIT,
	mentorID		INT
);