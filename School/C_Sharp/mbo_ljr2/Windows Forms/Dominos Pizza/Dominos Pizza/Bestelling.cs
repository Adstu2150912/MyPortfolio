/************************** Module Header *******************************\
Project:         H25 - Windows Forms Dominos
Auteur:          Adam Oubelkas
Aanmaakdatum:    2 mei 2018
Module naam:     Bestelling.cs

Omschrijving:    Klasse Bestelling Taak Domino's

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominos_Pizza
{
    public class Bestelling
    {

        //Declarering en initializering: attributen met bijhorende auto properties
        private string _BestelCodeH202;

        public string BestelCodeH202
        {
            get
            {
                return _BestelCodeH202;
            }
            set
            {
                _BestelCodeH202 = value;
            }
        }

        private string _PizzaNaamD201;

        public string PizzaNaamD201
        {
            get
            {
                return _PizzaNaamD201;
            }
            set
            {
                _PizzaNaamD201 = value;
            }
        }

        private string _PizzaGrootteType;

        public string PizzaGrootteType
        {
            get
            {
                return _PizzaGrootteType;
            }
            set
            {
                _PizzaGrootteType = value;
            }
        }

        private string _PizzaBodemType;

        public string PizzaBodemType
        {
            get
            {
                return _PizzaBodemType;
            }
            set
            {
                _PizzaBodemType = value;
            }
        }

        private int _Aantal;

        public int Aantal
        {
            get
            {
                return _Aantal;
            }
            set
            {
                _Aantal = value;
            }
        }

        //constructor
        public Bestelling()
        {
            _BestelCodeH202 = "onbekend";
            _PizzaGrootteType = "onbekend";
            _PizzaBodemType = "onbekend";
            _PizzaNaamD201 = "onbekend";
            _Aantal = 0;
        }
    }
}
