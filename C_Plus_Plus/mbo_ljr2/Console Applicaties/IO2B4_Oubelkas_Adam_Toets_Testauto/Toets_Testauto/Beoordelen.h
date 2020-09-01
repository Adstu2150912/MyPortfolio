/************************** Module Header *******************************\
Project:		Toets Testauto
Auteur:			Adam Oubelkas
Aanmaakdatum:   4 april 2018 + 08:43
Module naam:	Beoordelen.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een autotest
\************************************************************************/
#include <iostream>//hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h>//gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

class Beoordelen
{
	//beoordelingsgegevens declareren
	private:
		int jr;
		string beoordeling;
		int bsn_d201;
		string autoNaam_d201;
		//globale object voor testautogegevens
		Testauto testauto1;
	public:
		//leeg
	//constructor
	Beoordelen() {};
	//prototypes
	void InvoerenBeoordelen();
	void WeergevenBeoordelen();
};

//implementaties

void Beoordelen::InvoerenBeoordelen()
{
	//lokale object voor personengegevens
	Persoon persoon1;

	persoon1.InvoerenPersoon();
	testauto1.InvoerenTestauto();

	//deelverzamelingen aan hoofdverzamelingen toekennen
	bsn_d201 = persoon1.bsn_h201;
	autoNaam_d201 = testauto1.Testauto_anm_amrk_atype[0];

	cout << "\nVoer het huidige jaartal in:";
	cin >> jr;
	cin.ignore(1000, '\n');

	cout << "\nVoer uw beoordeling over de auto in (voldoende of onvoldoende):";
	getline(cin, beoordeling);

	//waarderegel: er wordt voldoende of onvoldoende verwacht als beoordeling
	//zo niet, dan is de beoordeling niet van toepassing
	if(beoordeling != "voldoende" && beoordeling != "onvoldoende")
	{
		beoordeling = "n.v.t";
	}
}

void Beoordelen::WeergevenBeoordelen()
{
	testauto1.WeergevenTestauto();
	cout << "\n\nPersoon " << bsn_d201 << " beoordeelt testauto " << autoNaam_d201 
	<< " in het jaar " << jr << " met de beoordeling " << beoordeling << ".\n\n\n";
}
