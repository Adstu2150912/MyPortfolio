/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstEvenementBO.cs

Omschrijving:    Business Object LijstEvenement

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    public class LijstEvenementBO
    {

        //onderstaande attributen als LijstEvenementgegevens declareren
        public string EvenementNaam { get; set; }
        public string EvenementType { get; set; }
        public DateTime BeginDatum { get; set; }
        public DateTime EindDatum { get; set; }
        public DateTime BeginTijd { get; set; }
        public DateTime EindTijd { get; set; }
        public string Locatie { get; set; }
        public string Beschrijving { get; set; }

        //constructor
        public LijstEvenementBO()
        {

        }
    }
}
