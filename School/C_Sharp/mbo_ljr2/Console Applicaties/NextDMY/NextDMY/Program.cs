/************************** Module Header *******************************\
Project:         NextDMY (Next Day Month Year)
Auteur:          Adam Oubelkas
Aanmaakdatum:    12 september 2018
Module naam:     Program.cs

Omschrijving:    Hier moet de datum van de volgende dag tonen aan de hand van de ingevoerde datum van de gebruiker

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NextDMY
{
    class Program
    {
        static void Main(string[] args)
        {
            NextDMY nextDMY = new NextDMY();
            do
            {
                nextDMY.StoreInput();
                nextDMY.CalculateNextYear();
                nextDMY.ValidateInputDMY();
                nextDMY.ConfirmNextDMY();
            }
            while (nextDMY.endProgram == false);
        }
    }
}
