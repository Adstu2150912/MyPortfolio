/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     VerenigingslidBO.cs

Omschrijving:    Business Object Verenigingslid

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    // Overerving van klasse IEquatable waarmee instanties van klasse VerenigingslidBO met elkaar vergeleken kan worden 
    // en vervolgens van dezelfde objectdefinitie worden voorzien
    // zodat het mogelijk is om de selecteditem van de listview in de UI/View altijd te koppelen met dezelfde instantie van klasse VerenigingslidBO
    public class VerenigingslidBO : IEquatable<VerenigingslidBO>
    {
        //constructor
        public VerenigingslidBO()
        {

        }

        // primaire sleutel van deze klasse declareren
        public int VerenigingslidID { get; set; }

        //onderstaande attributen als verenigingslidgegevens declareren
        public int Lidnummer { get; set; }
        public int PersoonID { get; set; }
        public DateTime Startdatum { get; set; }

        // Zorg ervoor dat de huidige instantie dezelfde objectdefinitie heeft als de volgende instantie
        // door het unieke gegeven van de huidige instantie te koppelen aan hetzelfde unieke gegeven van de volgende instantie 
        public virtual bool Equals(VerenigingslidBO andereVerenigingslid)
        {
            return this.VerenigingslidID == andereVerenigingslid.VerenigingslidID;
        }

        //Hier wordt pas de objectdefinitie van de volgende instantie overschreven met de objectdefinitie van de huidige instantie
        public override bool Equals(object obj)
        {
            return base.Equals(obj as VerenigingslidBO);
        }
    }
}
