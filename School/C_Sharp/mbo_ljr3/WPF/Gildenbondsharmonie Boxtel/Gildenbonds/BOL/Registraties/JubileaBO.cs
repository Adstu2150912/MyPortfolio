/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     JubileaBO.cs

Omschrijving:    Business Object Jubilea

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    // Overerving van klasse IEquatable waarmee instanties van klasse JubileaBO met elkaar vergeleken kan worden 
    // en vervolgens van dezelfde objectdefinitie worden voorzien
    // zodat het mogelijk is om de selecteditem van de listview in de UI/View altijd te koppelen met dezelfde instantie van klasse JubileaBO
    public class JubileaBO : IEquatable<JubileaBO>
    {
        // primaire sleutel van deze klasse declareren
        public int JubileaID { get; set; }

        //onderstaande attributen als jubileagegevens declareren
        public string Naam { get; set; }
        public string Omschrijving { get; set; }
        public string JubileaOpmerking { get; set; }
        public int VerenigingslidID { get; set; }

        //constructor
        public JubileaBO()
        {

        }

        

        // Zorg ervoor dat de huidige instantie dezelfde objectdefinitie heeft als de volgende instantie
        // door het unieke gegeven van de huidige instantie te koppelen aan hetzelfde unieke gegeven van de volgende instantie 
        public virtual bool Equals(JubileaBO andereJubilea)
        {
            return this.JubileaID == andereJubilea.JubileaID;
        }

        //Hier wordt pas de objectdefinitie van de volgende instantie overschreven met de objectdefinitie van de huidige instantie
        public override bool Equals(object obj)
        {
            return base.Equals(obj as JubileaBO);
        }
    }
}
