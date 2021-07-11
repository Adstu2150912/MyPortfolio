/************************** Module Header *******************************\
Project:		Toets Testauto
Auteur:			Adam Oubelkas
Aanmaakdatum:   4 april 2018 + 08:45
Module naam:	Testauto.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een autotest
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Testauto
{
	private:
		//leeg
	//testautogegevens declareren
	public:
		string Testauto_anm_amrk_atype[3];
	//constructor
	Testauto() {};
	//prototypes
	void InvoerenTestauto();
	void WeergevenTestauto();
};

//implementaties

void Testauto::InvoerenTestauto()
{
	cout << "\nVoer de naam de auto in:";
	getline(cin, Testauto_anm_amrk_atype[0]);
	cout << "\nVoer het merk van de auto in:";
	getline(cin, Testauto_anm_amrk_atype[1]);
	cout << "\nVoer het type van de auto in:";
	getline(cin, Testauto_anm_amrk_atype[2]);
}

void Testauto::WeergevenTestauto()
{
	cout << "\n\nTestauto " << Testauto_anm_amrk_atype[0] << " van het autotype "
	<< Testauto_anm_amrk_atype[2] << " is van het automerk " << Testauto_anm_amrk_atype[1] << ".";
}
