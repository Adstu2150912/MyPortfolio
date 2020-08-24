/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:47
Module naam:	Organisatie.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Organisatie
{
	private:
		//leeg
	public:
		//Organisatiegegevens declareren
		string org_h204;
	Organisatie() {};
	//Prototype
	void InvoerenOrganisatie();
};



//Implementatie
void Organisatie::InvoerenOrganisatie()
{
	cout << "\nVoer de gewenste organisatie in:";
	getline(cin, org_h204);
}