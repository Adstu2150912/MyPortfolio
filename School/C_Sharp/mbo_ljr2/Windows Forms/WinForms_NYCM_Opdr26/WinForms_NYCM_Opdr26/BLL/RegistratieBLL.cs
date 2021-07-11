/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     RegistratieBLL.cs

Omschrijving:    Business Logic Layer Registratie(s) Taak NYCM

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL
using System.Data.SqlClient;    //Voor SQL
using System.Configuration;     //Voor het uitlezen van de Web.config
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinForms_NYCM_Opdr26
{
    public class RegistratieBLL
    {
        public int Create(RegistratieBOL registratie)
        {
            RegistratieDAL registratieDAL = new RegistratieDAL();
            return registratieDAL.Create(registratie);
        }

        public int Delete(int selectedIndices)
        {
            RegistratieDAL registratieDAL = new RegistratieDAL();
            return registratieDAL.Delete(selectedIndices);
        }

        public void DeleteAll()
        {
            RegistratieDAL registratieDAL = new RegistratieDAL();
            registratieDAL.DeleteAll();
        }

        public DataSet Read()
        {
            RegistratieDAL registratieDAL = new RegistratieDAL();
            return registratieDAL.Read();
        }

        //constructor
        public RegistratieBLL()
        {

        }
    }
}
