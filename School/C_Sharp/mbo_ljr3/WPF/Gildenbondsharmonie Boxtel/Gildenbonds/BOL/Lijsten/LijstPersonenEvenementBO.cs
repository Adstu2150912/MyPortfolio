/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstPersonenEvenementBO.cs

Omschrijving:    Business Object LijstPersonenEvenement

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    public class LijstPersonenEvenementBO
    {
        //onderstaande attributen als LijstPersonenEvenementgegevens declareren
        public string Voorletters { get; set; }
        public string Voornaam { get; set; }
        public string Tussenvoegsel { get; set; }
        public string Achternaam { get; set; }
        public string EvenementNaam { get; set; }
        public string EvenementType { get; set; }
        public string BeginDatum { get; set; }
        public string EindDatum { get; set; }

        //constructor
        public LijstPersonenEvenementBO()
        {

        }
    }
}
