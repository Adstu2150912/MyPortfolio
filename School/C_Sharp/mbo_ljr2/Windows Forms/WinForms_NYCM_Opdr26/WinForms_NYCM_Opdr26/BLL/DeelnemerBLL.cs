/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     DeelnemerBLL.cs

Omschrijving:    Business Logic Layer Deelnemers Taak NYCM

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
    public class DeelnemerBLL
    {
        public int Create(DeelnemerBOL deelnemer)
        {
            DeelnemerDAL deelnemerDAL = new DeelnemerDAL();
            return deelnemerDAL.Create(deelnemer);
        }

        public int Delete(int selectedIndices)
        {
            DeelnemerDAL deelnemerDAL = new DeelnemerDAL();
            return deelnemerDAL.Delete(selectedIndices);
        }

        public void DeleteAll()
        {
            DeelnemerDAL deelnemerDAL = new DeelnemerDAL();
            deelnemerDAL.DeleteAll();
        }

        public DataSet Read()
        {
            DeelnemerDAL deelnemerDAL = new DeelnemerDAL();
            return deelnemerDAL.Read();
        }

        //constructor
        public DeelnemerBLL()
        {

        }
    }
}
