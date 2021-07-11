/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:39
Module naam:	UI_Waterschapsverkiezing_Hfd12.cpp

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies
					 //Benodigde bibliotheken voor alle gewenste invoer- en weergeeffuncties
#include "Burger.h"
#include "District.h"
#include "Stemmer.h"
#include "Organisatie.h"
#include "Kandidaat.h"
#include "Verkiezingsjaar.h"
#include "Stemmen.h"
#include "Hoogheemraadschap.h"

//UI
int main()
{
	Stemmen stem1;
	Kandidaat kandidaat1;
	Stemmer stemmer1;
	Hoogheemraadschap hoogheemraadschap1;

	//Initialisatie
	//hieronder worden de invoerfuncties aangeroepen
	stemmer1.InvoerenStemmer();
	kandidaat1.InvoerenKandidaat();
	stem1.InvoerenStemmen(stemmer1, kandidaat1);
	hoogheemraadschap1.InvoerenHoogheemraadschap();
	//UI
	//hieronder worden weergeeffuncties aangeroepen
	stemmer1.WeergevenStemmer();
	kandidaat1.WeergevenKandidaat();
	stem1.WeergevenStemmen();
	hoogheemraadschap1.WeergevenHoogheemraadschap();
	cout << "\n\nThis application is made on March 8th 2018 by ";
	wcout << (wchar_t)0xA9;
	cout << " Adam Oubelkas\n\n";
	system("pause");
}