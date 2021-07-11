/************************** Module Header *******************************\
Project:		Hoofdstuk 17 - Leerlingegevens
Auteur:			Adam Oubelkas
Aanmaakdatum:   15 maart 2018 + 14:48
Module naam:	UI_Leerlinggegevens_Hfst17.cpp

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream> //hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h> //gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies
#include "Datum.h"					 //Benodigde bibliotheken voor alle gewenste invoer- en weergeeffuncties
#include "Leerling.h"

//UI
int main()
{

	//Initialisatie
	//hieronder wordt de invoerfunctie aangeroepen
	InvoerenLeerling();
	InvoerenGeboortedatum();
	ZoekenOpLeerlingnummer();

	//UI
	cout << "\n\nThis application is made on March 15th 2018 by ";
	wcout << (wchar_t)0xA9;
	cout << " Adam Oubelkas\n\n";
	system("pause");
}