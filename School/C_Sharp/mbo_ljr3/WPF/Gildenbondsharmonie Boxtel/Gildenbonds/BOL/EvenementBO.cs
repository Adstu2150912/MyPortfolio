/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     EvenementBO.cs

Omschrijving:    Business Object Evenement

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    // Overerving van klasse IEquatable waarmee instanties van klasse EvenementBO met elkaar vergeleken kan worden 
    // en vervolgens van dezelfde objectdefinitie worden voorzien
    // zodat het mogelijk is om de selecteditem van de listview in de UI/View altijd te koppelen met dezelfde instantie van klasse EvenementBO
    public class EvenementBO : IEquatable<EvenementBO>
    {
        //constructor
        public EvenementBO()
        {

        }

        //primaire sleutel van deze klasse declareren
        public int EvenementID { get; set; }

        //onderstaande attributen als evenementgegevens declareren
        public string EvenementNaam { get; set; }
        public string EvenementType { get; set; }
        public DateTime BeginDatum { get; set; }
        public DateTime EindDatum { get; set; }
        public DateTime StartTijd { get; set; }
        public DateTime EindTijd { get; set; }
        public String Locatie { get; set; }
        public String Omschrijving { get; set; }
        public int VerenigingslidID { get; set; }

        // Zorg ervoor dat de huidige instantie dezelfde objectdefinitie heeft als de volgende instantie
        // door het unieke gegeven van de huidige instantie te koppelen aan hetzelfde unieke gegeven van de volgende instantie 
        public virtual bool Equals(EvenementBO andereEvenement)
        {
            return this.EvenementID == andereEvenement.EvenementID;
        }

        //Hier wordt pas de objectdefinitie van de volgende instantie overschreven met de objectdefinitie van de huidige instantie
        public override bool Equals(object obj)
        {
            return base.Equals(obj as EvenementBO);
        }
    }
}
