﻿/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstVerenigingBO.cs

Omschrijving:    Business Object LijstVereniging

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gildenbondsharmonie.BOL
{
    public class LijstVerenigingBO
    {        
        //onderstaande attributen als LijstVereniginggegevens declareren
        public int Lidnummer { get; set; }
        public string Voorletters { get; set; }
        public string Voornaam { get; set; }
        public string Tussenvoegsel { get; set; }
        public string Achternaam { get; set; }
        public string Instrument { get; set; }
        public string TelefoonNummer { get; set; }
        public string MobielNummer { get; set; }
        public string EmailAdres { get; set; }
        public string Straatnaam { get; set; }
        public int Straatnummer { get; set; }
        public string Postcode { get; set; }
        public string Plaats { get; set; }

        //constructor
        public LijstVerenigingBO()
        {

        }


    }
}
