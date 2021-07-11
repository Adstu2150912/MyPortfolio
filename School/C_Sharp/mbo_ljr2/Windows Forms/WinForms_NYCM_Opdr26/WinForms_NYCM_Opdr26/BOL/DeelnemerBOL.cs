/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     DeelnemerBOL.cs

Omschrijving:    Business Object Layer Deelnemers Taak NYCM

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinForms_NYCM_Opdr26
{
    public class DeelnemerBOL
    {
        //Declarering en initializering: attributen met bijhorende auto properties
        private string _Naam;

        public string Naam
        {
            get
            {
                return _Naam;
            }
            set
            {
                _Naam = value;
            }
        }

        private int _rugNummer;

        public int RugNummer
        {
            get
            {
                return _rugNummer;
            }
            set
            {
                _rugNummer = value;
            }
        }

        private int _chipNummerH201;

        public int ChipNummerH201
        {
            get
            {
                return _chipNummerH201;
            }
            set
            {
                _chipNummerH201 = value;
            }
        }

        //constructor
        public DeelnemerBOL()
        {
            _chipNummerH201 = 0;
        }
    }
}
