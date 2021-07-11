/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:39
Module naam:	Stemmen.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Stemmen : private Verkiezingsjaar
{
	private:
		//leeg
	public:
		//Stemgegevens declareren
		int bsnstem_bsnkan_vjr[3];
	Stemmen() {};
	//Prototypes
	void InvoerenStemmen(Stemmer, Kandidaat);
	void WeergevenStemmen();
};


//Implementatie
void Stemmen::InvoerenStemmen(Stemmer stem, Kandidaat kan)
{
	bsnstem_bsnkan_vjr[0] = stem.bsnstem_d202;
	bsnstem_bsnkan_vjr[1] = kan.bsnkan_d202;
	InvoerenVerkiezingsjaar();
	bsnstem_bsnkan_vjr[2] = vjr_h205;
}

void Stemmen::WeergevenStemmen()
{
	cout << "\n\nBurgerservicenummer " << bsnstem_bsnkan_vjr[0] << " stemt op burgerservicenummer " << bsnstem_bsnkan_vjr[1] << " in het verkiezingsjaar " << bsnstem_bsnkan_vjr[2];
}