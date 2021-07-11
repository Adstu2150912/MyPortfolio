/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 juni 2018
Module naam:     FEDeelnameBO.cs

Omschrijving:    Business Object Layer Frontend Deelname(s) Vestingloop

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Vestingloop2018
{
    public class FEDeelnameBO
    {
        //Declarering en initializering: attributen met bijhorende auto properties

        private int _FEDeelnameID;
        public int FEDeelnameID
        {
            get
            {
                return _FEDeelnameID;
            }
            set
            {
                _FEDeelnameID = value;
            }
        }

        private string _Deelnemer;
        public string Deelnemer
        {
            get
            {
                return _Deelnemer;
            }
            set
            {
                _Deelnemer = value;
            }
        }

        private string _Afkomst;
        public string Afkomst
        {
            get
            {
                return _Afkomst;
            }
            set
            {
                _Afkomst = value;
            }
        }

        private int _Leeftijd;
        public int Leeftijd
        {
            get
            {
                return _Leeftijd;
            }
            set
            {
                _Leeftijd = value;
            }
        }

        //constructor
        public FEDeelnameBO()
        {
            Deelnemer = "onbekend";
            Afkomst = "onbekend";
            Leeftijd = 0;
        }
    }
}
