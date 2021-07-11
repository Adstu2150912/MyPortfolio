/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstPersonenInstrumentBO.cs

Omschrijving:    Business Object LijstPersonenInstrument

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    public class LijstPersonenInstrumentBO
    {        
        //onderstaande attributen als LijstPersonenInstrumentgegevens declareren
        public string Instrument { get; set; }
        public string InstrumentType { get; set; }
        public string Merk { get; set; }
        public int SerieNummer { get; set; }
        public string Voornaam { get; set; }
        public string Voorletters { get; set; }
        public string Tussenvoegsel { get; set; }
        public string Achternaam { get; set; }

        //constructor
        public LijstPersonenInstrumentBO()
        {

        }

    }
}
