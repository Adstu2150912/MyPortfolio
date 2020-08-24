/************************** Module Header *******************************\
Project:		Hoofdstuk 12 - Taak Waterschapsverkiezing
Auteur:			Adam Oubelkas
Aanmaakdatum:   8 maart 2018 + 08:39
Module naam:	Hoogheemraadschap.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Hoogheemraadschap
{
	private:
		//Hoogheemraadschapsgegevens declareren
		string hoog_h206;
		string dst_d203;
	public:
		//leeg
	Hoogheemraadschap() {};
	//Prototypes
	void InvoerenHoogheemraadschap();
	void WeergevenHoogheemraadschap();
};



void Hoogheemraadschap::InvoerenHoogheemraadschap()
{
	cout << "\nVoer de naam van het Hoogheemraadschap in:";
	getline(cin, hoog_h206);
	//toekennen
	District district2;
	dst_d203 = district2.dst_h203;
}

void Hoogheemraadschap::WeergevenHoogheemraadschap()
{
	cout << "\n\nHet Hoogheemraadschap " << hoog_h206 << " beheert het water in het district " << dst_d203;
}