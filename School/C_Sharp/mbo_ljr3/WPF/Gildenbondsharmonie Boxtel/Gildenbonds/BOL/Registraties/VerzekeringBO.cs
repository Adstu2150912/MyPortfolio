/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     VerzekeringBO.cs

Omschrijving:    Business Object Verzekering

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    // Overerving van klasse IEquatable waarmee instanties van klasse VerzekeringBO met elkaar vergeleken kan worden 
    // en vervolgens van dezelfde objectdefinitie worden voorzien
    // zodat het mogelijk is om de selecteditem van de listview in de UI/View altijd te koppelen met dezelfde instantie van klasse VerzekeringBO
    public class VerzekeringBO : IEquatable<VerzekeringBO>
    {        
        // primaire sleutel van deze klasse declareren
        public int VerzekeringID { get; set; }

        //onderstaande attributen als verzekeringsgegevens declareren
        public int Serienummer { get; set; }
        public decimal Aanschafprijs { get; set; }
        public DateTime Aanschafdatum { get; set; }
        public DateTime Afschrijvingsdatum { get; set; }
        public string Leverancier { get; set; }
        public int Verzekerd { get; set; }
        public decimal Verzekeringswaarde { get; set; }

        public VerzekeringBO()
        {

        }

        // Zorg ervoor dat de huidige instantie dezelfde objectdefinitie heeft als de volgende instantie
        // door het unieke gegeven van de huidige instantie te koppelen aan hetzelfde unieke gegeven van de volgende instantie 
        public virtual bool Equals(VerzekeringBO andereVerzekering)
        {
            return this.VerzekeringID == andereVerzekering.VerzekeringID;
        }

        //Hier wordt pas de objectdefinitie van de volgende instantie overschreven met de objectdefinitie van de huidige instantie
        public override bool Equals(object obj)
        {
            return base.Equals(obj as VerzekeringBO);
        }
    }
}
