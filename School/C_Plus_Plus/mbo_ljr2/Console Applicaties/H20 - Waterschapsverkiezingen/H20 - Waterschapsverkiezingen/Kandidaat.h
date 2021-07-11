/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:39
Module naam:	Kandidaat.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties

using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Kandidaat
{
	private:	
		string org_d204;
	public:
		//Kandidaatsgegevens declareren
		string knd_h206;
		int bsnkan_d202;
		string dstkan_d203;
	Kandidaat() {};
	//Prototypes
	void InvoerenKandidaat();
	void WeergevenKandidaat();
};





//Implementatie
void Kandidaat::InvoerenKandidaat()
{
	cout << "\nVoer de naam van de kandidaat in:";
	getline(cin, knd_h206);
	//toekennen
	Burger burger1;
	District district1;
	Organisatie organisatie1;

	burger1.InvoerenBurger();
	district1.InvoerenDistrict();
	organisatie1.InvoerenOrganisatie();
	bsnkan_d202 = burger1.bsn_h202;
	org_d204 = organisatie1.org_h204;
	dstkan_d203 = district1.dst_h203;
}

void Kandidaat::WeergevenKandidaat()
{
	cout << "\n\nKandidaat " << knd_h206 << " met burgerservicenummer " << bsnkan_d202 << " van de organisatie " << org_d204 << " woont in het district " << dstkan_d203;
}
