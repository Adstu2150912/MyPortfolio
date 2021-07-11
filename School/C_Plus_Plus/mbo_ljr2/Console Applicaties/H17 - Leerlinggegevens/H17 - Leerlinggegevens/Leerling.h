/************************** Module Header *******************************\
Project:		Hoofdstuk 17 - Leerlingegevens
Auteur:			Adam Oubelkas
Aanmaakdatum:   15 maart 2018 + 13:48
Module naam:	Leerling.h

Omschrijving:

Hier wordt er gevraagd om gegevens in te vullen voor een Waterschapsverkiezing
\************************************************************************/
#include <iostream> //hieruit worden functies gebruikt voor input- en outputverwerkingen
#include <stdlib.h> //gebruikt C Standaard Algemene Utiliteits Bibliotheek
#include <string> //hieruit worden stringfuncties toegepast
#include <complex> //hierin zitten operatorenfuncties
using namespace std; //door deze namespace te gebruiken, is het niet meer nodig om telkens voorvoegsel 'std' te gebruiken voor bepaalde functies

#define maxLeerlingen 5

//een struct voor leerlinggegevens declareren
struct Leerling
{
	string nm;
	int nr_mobiel[2];
	Datum gebdatum;
};

int dg;
int mnd;
int jr;
int nee;
Leerling leerling[maxLeerlingen];


//prototypes
void InvoerenLeerling();
void InvoerenGeboortedatum();
void ZoekenOpLeerlingnummer();

//Implementatie
void InvoerenLeerling()
{
	//Leerling1
	leerling[0].nm = "Piet";
	leerling[0].nr_mobiel[0] = 1;
	leerling[0].nr_mobiel[1] = 123;
	leerling[0].gebdatum.dag_maand_jaar[0] = 01;
	leerling[0].gebdatum.dag_maand_jaar[1] = 01;
	leerling[0].gebdatum.dag_maand_jaar[2] = 1980;

	//Leerling2
	leerling[1].nm = "Mien";
	leerling[1].nr_mobiel[0] = 2;
	leerling[1].nr_mobiel[1] = 234;
	leerling[1].gebdatum.dag_maand_jaar[0] = 01;
	leerling[1].gebdatum.dag_maand_jaar[1] = 01;
	leerling[1].gebdatum.dag_maand_jaar[2] = 1980;

	//Leerling 3
	
	leerling[2].nm = "Jan";
	leerling[2].nr_mobiel[0] = 3;
	leerling[2].nr_mobiel[1] = 345;
	leerling[2].gebdatum.dag_maand_jaar[0] = 01;
	leerling[2].gebdatum.dag_maand_jaar[1] = 01;	
	leerling[2].gebdatum.dag_maand_jaar[2] = 1980;
	
	//Leerling 4

	leerling[3].nm = "Trui";
	leerling[3].nr_mobiel[0] = 4;
	leerling[3].nr_mobiel[1] = 456;
	leerling[3].gebdatum.dag_maand_jaar[0] = 21;
	leerling[3].gebdatum.dag_maand_jaar[1] = 06;
	leerling[3].gebdatum.dag_maand_jaar[2] = 1981;
	
	//Leerling 5
	
	leerling[4].nm = "Klaas";
	leerling[4].nr_mobiel[0] = 5;
	leerling[4].nr_mobiel[1] = 567;
	leerling[4].gebdatum.dag_maand_jaar[0] = 15;
	leerling[4].gebdatum.dag_maand_jaar[1] = 03;
	leerling[4].gebdatum.dag_maand_jaar[2] = 1969;
}

void InvoerenGeboortedatum()
{
	cout << "\nVoer het geboortedatum in.";
	cout << "\nVoer de dagwaarde in: ";
	cin >> dg;
	cout << "\nVoer de maandwaarde in: ";
	cin >> mnd;
	cout << "\nVoer de jaarwaarde in: ";
	cin >> jr;
}

void ZoekenOpLeerlingnummer()
{
	for (int i = 0; i < maxLeerlingen; i++) {
		if (leerling[i].gebdatum.dag_maand_jaar[0] == dg && leerling[i].gebdatum.dag_maand_jaar[1] == mnd && leerling[i].gebdatum.dag_maand_jaar[2] == jr)
		{
			cout << "\nGeboortedatum " << dg << "-" << mnd << "-" << jr << " hoort bij leerlingnaam " << leerling[i].nm;
		}
		else
		{
			nee += 1;
		}
	}

	if (nee == maxLeerlingen) 
	{
		cout << "Er bestaat geen leerling met het ingevoerde geboortedatum: " << dg << "-" << mnd << "-" << jr;
	}
}