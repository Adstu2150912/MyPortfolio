/************************** Module Header *******************************\
Project:		Hoofdstuk 17 - Leerlingegevens
Auteur:			Adam Oubelkas
Aanmaakdatum:   15 maart 2018 + 14:48
Module naam:	Datum.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream> //hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h> //gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

//een struct voor datumgegevens declareren

struct Datum
{
	int dag_maand_jaar[3];
};