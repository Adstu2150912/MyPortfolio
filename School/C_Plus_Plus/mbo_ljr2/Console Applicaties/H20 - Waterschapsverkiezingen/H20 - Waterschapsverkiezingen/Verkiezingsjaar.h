/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:46
Module naam:	Verkiezingsjaar.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Verkiezingsjaar
{
	private:
		//leeg
	public:
		//Verkiezingsjaar declareren
		int vjr_h205;
	Verkiezingsjaar() {};
	//Prototype
	void InvoerenVerkiezingsjaar();
};

//Implementatie
void Verkiezingsjaar::InvoerenVerkiezingsjaar()
{
	cout << "\nVoer het gewenste verkiezingsjaar in:";
	cin >> vjr_h205;
	cin.ignore(1000,'\n');
}