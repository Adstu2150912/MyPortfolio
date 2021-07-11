/************************** Module Header *******************************\
Project:		Toets Testauto
Auteur:			Adam Oubelkas
Aanmaakdatum:   4 april 2018 + 08:43
Module naam:	UI_Testauto_Toets.cpp

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een autotest
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

//Benodigde bibliotheken voor alle gewenste invoer- en weergeeffuncties
#include "Persoon.h"
#include "Testauto.h"
#include "Beoordelen.h"

//UI
int main()
{
	//lokale object voor functieaanroepen
	Beoordelen beoordeling1;

	//Initialisatie
	//hieronder wordt de invoerfunctie aangeroepen
	beoordeling1.InvoerenBeoordelen();
	
	//UI
	//hieronder wordt weergeeffunctie aangeroepen
	beoordeling1.WeergevenBeoordelen();
	system("pause");
}
