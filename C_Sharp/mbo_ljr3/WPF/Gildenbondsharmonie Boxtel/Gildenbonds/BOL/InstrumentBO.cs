/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     InstrumentBO.cs

Omschrijving:    Business Object Instrument

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    // Overerving van klasse IEquatable waarmee instanties van klasse InstrumentBO met elkaar vergeleken kan worden 
    // en vervolgens van dezelfde objectdefinitie worden voorzien
    // zodat het mogelijk is om de selecteditem van de listview in de UI/View altijd te koppelen met dezelfde instantie van klasse InstrumentBO

    public class InstrumentBO : IEquatable<InstrumentBO>
    {
        //constructor
        public InstrumentBO()
        {

        }

        //primaire sleutel van deze klasse declareren
        public int InstrumentID { get; set; }

        //onderstaande attributen als instrumentgegevens declareren
        public string Instrument { get; set; }
        public string InstrumentType { get; set; }
        public string Merk { get; set; }
        public int VerzekeringID { get; set; }
        public int VerenigingslidID { get; set; }

        // Zorg ervoor dat de huidige instantie dezelfde objectdefinitie heeft als de volgende instantie
        // door het unieke gegeven van de huidige instantie te koppelen aan hetzelfde unieke gegeven van de volgende instantie 
        public virtual bool Equals(InstrumentBO andereInstrument)
        {
            return this.InstrumentID == andereInstrument.InstrumentID;
        }

        //Hier wordt pas de objectdefinitie van de volgende instantie overschreven met de objectdefinitie van de huidige instantie
        public override bool Equals(object obj)
        {
            return base.Equals(obj as InstrumentBO);
        }
    }
}
