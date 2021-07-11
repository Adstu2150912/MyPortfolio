/************************** Module Header *******************************\
Project:		Toets Testauto
Auteur:			Adam Oubelkas
Aanmaakdatum:   4 april 2018 + 08:44
Module naam:	Persoon.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een autotest
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Persoon
{
	private:
		//leeg
	//persoongegeven declareren
	public:
		int bsn_h201;
	//constructor
	Persoon() {};
	//prototypes
	void InvoerenPersoon();
};

//Implementaties

void Persoon::InvoerenPersoon()
{
	cout << "Voer uw BSN in:";
	cin >> bsn_h201;
	cin.ignore(1000, '\n');
}