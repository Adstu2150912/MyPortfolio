/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstKNMOBO.cs

Omschrijving:    Business Object LijstKNMO

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    public class LijstKNMOBO
    {

        //onderstaande attributen als LijstKNMOgegevens declareren
        public string Voorletters { get; set; }
        public string Tussenvoegsel { get; set; }
        public string Achternaam { get; set; }
        public DateTime GeboorteDatum { get; set; }
        public string Geslacht { get; set; }
        public string Instrument { get; set; }

        //constructor
        public LijstKNMOBO()
        {

        }
    }
}
