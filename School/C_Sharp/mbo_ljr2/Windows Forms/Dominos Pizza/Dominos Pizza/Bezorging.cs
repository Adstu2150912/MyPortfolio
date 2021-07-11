/************************** Module Header *******************************\
Project:         H25 - Windows Forms Dominos
Auteur:          Adam Oubelkas
Aanmaakdatum:    2 mei 2018
Module naam:     Bezorging.cs

Omschrijving:    Klasse Bezorging Taak Domino's

\************************************************************************/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominos_Pizza
{
    //Declarering en initializering: attributen met bijhorende auto properties
    public class Bezorging
    {
        private string _PostCode;

        public string PostCode
        {
            get
            {
                return _PostCode;
            }
            set
            {
                _PostCode = value;
            }
        }

        private int _HuisNummer;

        public int HuisNummer
        {
            get
            {
                return _HuisNummer;
            }
            set
            {
                _HuisNummer = value;
            }
        }

        private string _BezorgDag;

        public string BezorgDag
        {
            get
            {
                return _BezorgDag;
            }
            set
            {
                _BezorgDag = value;
            }
        }

        private string _BezorgTijd;

        public string BezorgTijd
        {
            get
            {
                return _BezorgTijd;
            }
            set
            {
                _BezorgTijd = value;
            }
        }

        private string _BestelCodeD202;

        public string BestelCodeD202
        {
            get
            {
                return _BestelCodeD202;
            }
            set
            {
                _BestelCodeD202 = value;
            }
        }

        private int _ActieCode;

        public int ActieCode
        {
            get
            {
                return _ActieCode;
            }
            set
            {
                _ActieCode = value;
            }
        }

        public Bezorging()
        {
            _BestelCodeD202 = "onbekend";
            _HuisNummer = 0;
            _PostCode = "onbekend";
            _BezorgDag = "onbekend";
            _BezorgTijd = "onbekend";
            _ActieCode = 0;
        }

    }
}
