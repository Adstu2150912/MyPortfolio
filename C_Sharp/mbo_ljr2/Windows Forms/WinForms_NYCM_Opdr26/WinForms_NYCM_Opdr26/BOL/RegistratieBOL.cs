/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     RegistratieBOL.cs

Omschrijving:    Business Object Layer Registratie(s) Taak NYCM

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinForms_NYCM_Opdr26
{
    public class RegistratieBOL
    {
        //Declarering en initializering: attributen met bijhorende auto properties

        private int _chipNummerD201;

        public int ChipNummerD201
        {
            get
            {
                return _chipNummerD201;
            }
            set
            {
                _chipNummerD201 = value;
            }
        }

        private int _registratieTijd;

        public int RegistratieTijd
        {
            get
            {
                return _registratieTijd;
            }
            set
            {
                _registratieTijd = value;
            }
        }

        private string _registratiePuntW501;

        public string RegistratiePuntW501
        {
            get
            {
                return _registratiePuntW501;
            }
            set
            {
                _registratiePuntW501 = value;
            }
        }

        private int _jaar;

        public int Jaar
        {
            get
            {
                return _jaar;
            }
            set
            {
                _jaar = value;
            }
        }

        //constructor
        public RegistratieBOL()
        {

        }
    }
}
