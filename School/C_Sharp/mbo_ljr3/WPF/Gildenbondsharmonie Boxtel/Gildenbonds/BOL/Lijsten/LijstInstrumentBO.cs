/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstInstrumentBO.cs

Omschrijving:    Business Object LijstInstrument

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    public class LijstInstrumentBO
    {        
        //onderstaande attributen als LijstInstrumentgegevens declareren
        public string Instrument { get; set; }
        public string InstrumentType { get; set; }
        public string Merk { get; set; }
        public int SerieNummer { get; set; }
        public decimal AanschafPrijs { get; set; }
        public DateTime AanschafDatum { get; set; }
        public DateTime AfschrijvingsDatum { get; set; }
        public string Leverancier { get; set; }
        public int Verzekerd { get; set; }
        public decimal VerzekeringsWaarde{ get; set; }

        //constructor
        public LijstInstrumentBO()
        {

        }


    }
}
