/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     PersoonBO.cs

Omschrijving:    Business Object Persoon

\************************************************************************/


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    // Overerving van klasse IEquatable waarmee instanties van klasse PersoonBO met elkaar vergeleken kan worden 
    // en vervolgens van dezelfde objectdefinitie worden voorzien
    // zodat het mogelijk is om de selecteditem van de listview in de UI/View altijd te koppelen met dezelfde instantie van klasse PersoonBO
    public class PersoonBO : IEquatable<PersoonBO>
    {
        //constructor
        public PersoonBO()
        {

        }

        //primaire sleutel van deze klasse declareren
        public int PersoonID { get; set; }

        //onderstaande attributen als persoonsgegevens declareren
        public int WoonadresID { get; set; }
        public string Voorletters { get; set; }
        public string Voornaam { get; set; }
        public string Tussenvoegsel { get; set; }
        public string Achternaam { get; set; }
        public string Geslacht { get; set; }
        public DateTime GeboorteDatum { get; set; }
        public string TelefoonNummer { get; set; }
        public string MobielNummer { get; set; }
        public string EmailAdres { get; set; }
        public string GroepNaam { get; set; }
        public string GroepType { get; set; }

        // Zorg ervoor dat de huidige instantie dezelfde objectdefinitie heeft als de volgende instantie
        // door het unieke gegeven van de huidige instantie te koppelen aan hetzelfde unieke gegeven van de volgende instantie 
        public virtual bool Equals(PersoonBO anderePersoon)
        {
            return this.PersoonID == anderePersoon.PersoonID;
        }

        //Hier wordt pas de objectdefinitie van de volgende instantie overschreven met de objectdefinitie van de huidige instantie
        public override bool Equals(object obj)
        {
            return base.Equals(obj as PersoonBO);
        }
    }
}
