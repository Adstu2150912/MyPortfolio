/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:48
Module naam:	Burger.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Burger
{
	private:
		//leeg
	public:
		//Burgersgegevens declareren
		int bsn_h202;
	Burger() {};
	//Prototype
	void InvoerenBurger();
};




//Implementatie
void Burger::InvoerenBurger()
{
	cout << "\nVoer de BSN in van de burger:";
	cin >> bsn_h202;
	cin.ignore(1000, '\n');
}