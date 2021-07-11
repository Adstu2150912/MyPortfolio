/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 juni 2018
Module naam:     FEResultaatBO.cs

Omschrijving:    Business Object Layer Frontend Resultaat(en) Vestingloop

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Vestingloop2018
{
    public class FEResultaatBO
    {
        //Declarering en initializering: attributen met bijhorende auto properties

        private int _FEResultaatID;
        public int FEResultaatID
        {
            get
            {
                return _FEResultaatID;
            }
            set
            {
                _FEResultaatID = value;
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

        private string _RouteD204;
        public string RouteD204
        {
            get
            {
                return _RouteD204;
            }
            set
            {
                _RouteD204 = value;
            }
        }

        private string _Tijd;
        public string Tijd
        {
            get
            {
                return _Tijd;
            }
            set
            {
                _Tijd = value;
            }
        }

        private int _Rang;
        public int Rang
        {
            get
            {
                return _Rang;
            }
            set
            {
                _Rang = value;
            }
        }

        //constructor
        public FEResultaatBO()
        {
            Deelnemer = "Onbekend";
            RouteD204 = "Onbekend";
            Tijd = "Onbekend";
            Rang = 0;
        }
    }
}
