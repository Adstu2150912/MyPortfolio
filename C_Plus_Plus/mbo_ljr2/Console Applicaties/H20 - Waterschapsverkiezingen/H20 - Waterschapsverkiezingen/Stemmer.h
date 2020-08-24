/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:39
Module naam:	Stemmer.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Stemmer
{
	private:		
		//stemmersgegevens declareren
		string stm_h201;	
		string dststem_d203;
	public:
		int bsnstem_d202;
	Stemmer() {};
	//Prototypes
	void InvoerenStemmer();
	void WeergevenStemmer();
};




//Implementatie
void Stemmer::InvoerenStemmer() 
{
	cout << "\nVoer de naam van de stemmer in:";
	getline(cin, stm_h201);
	//toekennen
	Burger burger1;
	District district1;
	burger1.InvoerenBurger();
	district1.InvoerenDistrict();
	bsnstem_d202 = burger1.bsn_h202;
	dststem_d203 = district1.dst_h203;
}

void Stemmer::WeergevenStemmer() 
{
	cout << "\n\nStemmer " << stm_h201 << " met het burgerservicenummer " << bsnstem_d202 << " woont in het district " << dststem_d203;
}