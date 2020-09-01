/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     DeelnemerDAL.cs

Omschrijving:    Data Access Layer Deelnemers Taak NYCM

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
    public class DeelnemerDAL
    {
        //Maak een statische DataSet object waarin de deelnemersgegevens worden opgeslagen
        private static DataSet dsDeelnemer = new DataSet();
        //constructor
        public DeelnemerDAL()
        {
            //Test of de tabel 'tblDeelnemer' al bestaat
            if(dsDeelnemer.Tables["tblDeelnemer"] == null)
            {
                //Maak een nieuwe tabel
                DataTable table = new DataTable
                {
                    TableName = "tblDeelnemer"
                };

                table.Columns.Add("Naam", typeof(string));
                table.Columns.Add("RugNummer", typeof(int));
                table.Columns.Add("ChipNummerH201", typeof(int));

                //Voeg de structuur en de data van de tabel toe aan de DataSet
                dsDeelnemer.Tables.Add(table.Copy());
            }
        }

        //Implementatie: methodes
        public int Create(DeelnemerBOL deelnemer)
        {
            //Voeg het chipnummer, de deelnemersnaam en het rugnummer toe aan de deelnemer opslag structuur
            dsDeelnemer.Tables["tblDeelnemer"].Rows.Add(deelnemer.Naam, deelnemer.RugNummer, deelnemer.ChipNummerH201);

            return 1; // Het aantal rijen aangepast in de tabel
        }

        public int Delete(int selectedIndices)
        {
            if (dsDeelnemer.Tables["tblDeelnemer"].Rows.Count != 0)
            {
                dsDeelnemer.Tables["tblDeelnemer"].Rows.RemoveAt(selectedIndices);
                return 1; // Het aantal rijen aangepast in de tabel
            }
            else
            {
                return 0; // Het aantal rijen aangepast in de tabel
            }
        }

        public void DeleteAll()
        {
            dsDeelnemer.Tables["tblDeelnemer"].Clear();
        }

        public DataSet Read()
        {
            return dsDeelnemer;
        }
    }
}
