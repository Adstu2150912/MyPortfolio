/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     WoonadresBO.cs

Omschrijving:    Business Object Woonadres

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    // Overerving van klasse IEquatable waarmee instanties van klasse WoonadresBO met elkaar vergeleken kan worden 
    // en vervolgens van dezelfde objectdefinitie worden voorzien
    // zodat het mogelijk is om de selecteditem van de listview in de UI/View altijd te koppelen met dezelfde instantie van klasse WooonadresBO
    public class WoonadresBO : IEquatable<WoonadresBO>
    {
        //constructor
        public WoonadresBO()
        {

        }

        // primaire sleutel van deze klasse declareren
        public int WoonadresID { get; set; }

        //onderstaande attributen als woonadresgegevens declareren
        public string Straatnaam { get; set; }
        public int Straatnummer { get; set; }
        public string Postcode { get; set; }
        public string Plaats { get; set; }

        // Zorg ervoor dat de huidige instantie dezelfde objectdefinitie heeft als de volgende instantie
        // door het unieke gegeven van de huidige instantie te koppelen aan hetzelfde unieke gegeven van de volgende instantie 
        public virtual bool Equals(WoonadresBO andereWoonadres)
        {
            return this.WoonadresID == andereWoonadres.WoonadresID;
        }

        //Hier wordt pas de objectdefinitie van de volgende instantie overschreven met de objectdefinitie van de huidige instantie
        public override bool Equals(object obj)
        {
            return base.Equals(obj as WoonadresBO);
        }
    }
}
