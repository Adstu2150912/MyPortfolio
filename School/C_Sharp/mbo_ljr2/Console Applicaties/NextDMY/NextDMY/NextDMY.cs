/************************** Module Header *******************************\
Project:         NextDMY (Next Day Month Year)
Auteur:          Adam Oubelkas
Aanmaakdatum:    12 september 2018
Module naam:     NextDMY.cs

Omschrijving:    Hier staan alle velden (fields) en functies (methods) voor de gewenste functionaliteit van de applicatie

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NextDMY
{
    public class NextDMY
    {
        public int inputDay;
        public int inputMonth;
        public int inputYear;
        public string inputYN;

        public int nextDay = 0;
        public int nextMonth = 0;
        public int nextYear = 0;

        public bool isLeapYear = false;
        public bool isNullNextDate = true;
        public bool endProgram = false;

        public void StoreInput()
        {
            Console.WriteLine("\n\nEr moet een geldige datum in cijfers worden ingevoerd\n\nVoer eerst een dag in:\n");
            Int32.TryParse(Console.ReadLine(), out inputDay);
            Console.WriteLine("\nVoer een maand in:\n");
            Int32.TryParse(Console.ReadLine(), out inputMonth);
            Console.WriteLine("\nVoer een jaar in:\n");
            Int32.TryParse(Console.ReadLine(), out inputYear);
        }

        public void CalculateNextYear()
        {
            if (inputYear % 4 == 0 && inputYear % 100 != 0 || inputYear % 400 == 0)
            {
                isLeapYear = true;
            }
        }

        public void ValidateInputDMY()
        {
                if (inputDay <= 1 && inputMonth <= 0 || inputMonth > 12 || inputYear <= 1)
                {
                    Console.WriteLine("\nUw invoer (datum) is ongeldig: \"" + inputDay.ToString()
                    + "/" + inputMonth.ToString() + "/" + inputYear.ToString() + "\"\nProbeer het opnieuw\n\n");
                }
                else
                {
                    nextYear = inputYear;

                    switch (inputMonth)
                    {
                        case 1:
                            if (inputDay > 31)
                            {
                                Console.WriteLine("\nUw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 31)
                                {
                                    nextDay = 1;
                                    nextMonth = 2;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }

                                isNullNextDate = false;
                            }
                            break;
                        case 2:
                            if (inputDay > 29 && isLeapYear == true)
                            {
                                Console.WriteLine("\nUw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                + "\"\nProbeer het opnieuw\n\n");
                            }
                            else if (inputDay > 28 && isLeapYear == false)
                            {
                                Console.WriteLine("\nUw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 29 && isLeapYear == true)
                                {
                                    nextDay = 1;
                                    nextMonth = 3;
                                }
                                else if (inputDay == 28 && isLeapYear == false)
                                {
                                    nextDay = 1;
                                    nextMonth = 3;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }

                                isNullNextDate = false;
                            }
                            break;
                        case 3:
                            if (inputDay > 31)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 31)
                                {
                                    nextDay = 1;
                                    nextMonth = 4;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 4:
                            if (inputDay > 30)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 30)
                                {
                                    nextDay = 1;
                                    nextMonth = 5;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 5:
                            if (inputDay > 31)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 31)
                                {
                                    nextDay = 1;
                                    nextMonth = 6;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 6:
                            if (inputDay > 30)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 30)
                                {
                                    nextDay = 1;
                                    nextMonth = 7;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 7:
                            if (inputDay > 31)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 31)
                                {
                                    nextDay = 1;
                                    nextMonth = 8;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 8:
                            if (inputDay > 31)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 31)
                                {
                                    nextDay = 1;
                                    nextMonth = 9;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 9:
                            if (inputDay > 30)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 30)
                                {
                                    nextDay = 1;
                                    nextMonth = 10;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 10:
                            if (inputDay > 31)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 31)
                                {
                                    nextDay = 1;
                                    nextMonth = 11;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 11:
                            if (inputDay > 30)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 30)
                                {
                                    nextDay = 1;
                                    nextMonth = 12;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                        case 12:
                            if (inputDay > 31)
                            {
                                Console.WriteLine("Uw invoer (dag) is ongeldig: \"" + inputDay.ToString()
                                    + "\"\nProbeer het opnieuw\n\n");
                            }
                            else
                            {
                                if (inputDay == 31)
                                {
                                    nextDay = 1;
                                    nextMonth = 1;
                                    nextYear = ++inputYear;
                                    --inputYear;
                                }
                                else
                                {
                                    nextDay = ++inputDay;
                                    --inputDay;
                                    nextMonth = inputMonth;
                                }
                                isNullNextDate = false;
                            }
                            break;
                    }
                }
        }

        public void ConfirmNextDMY()
        {
            if (isNullNextDate == false)
            {
                while (isNullNextDate == false && endProgram == false)
                {
                    Console.WriteLine("\nDit is uw invoerdatum: \"" + inputDay.ToString()
                    + "/" + inputMonth.ToString() + "/" + inputYear.ToString() + "\"");
                    Console.WriteLine("\n\nDit is de volgende datum van uw invoerdatum: \"" + nextDay + "/" + nextMonth + "/" + nextYear + "\"");
                    Console.WriteLine("\n\nWilt u opnieuw een nieuwe datum invoeren? (Y/N)");
                    inputYN = Console.ReadLine();

                    if (inputYN == "Y")
                    {
                        isNullNextDate = true;
                    }
                    else if (inputYN == "N")
                    {
                        endProgram = true;
                    }
                    else
                    {
                        Console.WriteLine("Uw invoer is ongeldig. Invoer moet 'Y' of 'N' zijn.");
                    }
                }
            }
        }
    }
}
