/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     RegistratieDAL.cs

Omschrijving:    Data Access Layer Registratie(s) Taak NYCM

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
    public class RegistratieDAL
    {
        //Maak een statische DataSet object waarin de registratiegegevens worden opgeslagen
        private static DataSet dsRegistratie = new DataSet();

        //constructor
        public RegistratieDAL()
        {
            //Test of de tabel 'tblRegistratie' al bestaat
            if (dsRegistratie.Tables["tblRegistratie"] == null)
            {
                //Maak een nieuwe tabel
                DataTable table = new DataTable
                {
                    TableName = "tblRegistratie"
                };

                table.Columns.Add("ChipNummerD201", typeof(int));
                table.Columns.Add("RegistratieTijd", typeof(int));
                table.Columns.Add("RegistratiePuntW501", typeof(string));
                table.Columns.Add("Jaar", typeof(int));

                //Voeg de structuur en de data van de tabel toe aan de DataSet
                dsRegistratie.Tables.Add(table.Copy());
            }
        }

        //Implementatie: methodes
        public int Create(RegistratieBOL registratie)
        {
            //Voeg het chipnummer, de registratiestijd, het registratiepunt en het jaar toe aan de registratie opslag structuur
            dsRegistratie.Tables["tblRegistratie"].Rows.Add(registratie.ChipNummerD201, registratie.RegistratieTijd, registratie.RegistratiePuntW501, registratie.Jaar);

            return 1; // Het aantal rijen aangepast in de tabel
        }

        public int Delete(int selectedIndices)
        {
            if (dsRegistratie.Tables["tblRegistratie"].Rows.Count != 0)
            {
                dsRegistratie.Tables["tblRegistratie"].Rows.RemoveAt(selectedIndices);
                return 1; // Het aantal rijen aangepast in de tabel
            }
            else
            {
                return 0; // Het aantal rijen aangepast in de tabel
            }
        }

        public void DeleteAll()
        {
            dsRegistratie.Tables["tblRegistratie"].Clear();
        }

        public DataSet Read()
        {
            return dsRegistratie;
        }
    }
}
