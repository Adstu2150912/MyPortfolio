/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstEvenementTypeBO.cs

Omschrijving:    Business Object LijstEvenementType

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    public class LijstEvenementTypeBO
    {
        //onderstaande attributen als LijstEvenementTypegegevens declareren
        public string EvenementType { get; set; }
        public string Beschrijving { get; set; }

        //constructor
        public LijstEvenementTypeBO()
        {

        }
    }
}
