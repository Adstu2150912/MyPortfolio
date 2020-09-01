/************************** Module Header *******************************\
Project:         H25 - Windows Forms Dominos
Auteur:          Adam Oubelkas
Aanmaakdatum:    2 mei 2018
Module naam:     PizzaNaam.cs

Omschrijving:    Klasse Pizza(s) Taak Domino's

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominos_Pizza
{
    public class PizzaNaam
    {
        //Declarering en initializering: attribuut met bijhorende auto property
        private string _PizzaNaamH201;
        public string PizzaNaamH201
        {
            get
            {
                return _PizzaNaamH201;
            }
            set
            {
                _PizzaNaamH201 = value;
            }
        }

        //constructor
        public PizzaNaam()
        {
            _PizzaNaamH201 = "onbekend";
        }
    }
}
