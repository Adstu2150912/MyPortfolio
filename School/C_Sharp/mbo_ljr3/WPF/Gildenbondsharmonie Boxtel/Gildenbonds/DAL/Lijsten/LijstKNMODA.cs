/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstKNMODA.cs

Omschrijving:    Data Access Object Evenement

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL
using System.Data.SqlClient;    //Voor SQL
using System.Configuration;     //Voor het uitlezen van de Web.config
using System.Windows;     //Voor het tonen van (fout)meldingen
using Gildenbondsharmonie.BOL; //Voor gebruik van Business objecten

namespace Gildenbondsharmonie.DAL
{
    public class LijstKNMODA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public LijstKNMODA()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
        {
            DataSet ds = new DataSet();

            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    SqlDataAdapter da = new SqlDataAdapter();

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,
                        CommandType = CommandType.Text,

                        CommandText = "SELECT voorletters, tussenvoegsel, achternaam, geboortedatum, geslacht, instrument FROM Persoon " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID;"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "LijstKNMO");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public DataSet Select(int selectJaar)
        {
            DataSet ds = new DataSet();
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    SqlDataAdapter da = new SqlDataAdapter();   //Creeër een nieuw SqlCommand object

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,                   //De verbinding
                        CommandType = CommandType.Text,     //Type command is Text

                        CommandText = "SELECT voorletters, tussenvoegsel, achternaam, geboortedatum, geslacht, instrument FROM Persoon " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID WHERE YEAR(geboortedatum) = " + selectJaar + ";"
                    };

                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstKNMO tabel uit de database
                    da.Fill(ds, "LijstKNMO");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> filterLijstKNMO)
        {
            DataSet ds = new DataSet();
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    SqlDataAdapter da = new SqlDataAdapter();   //Creeër een nieuw SqlCommand object

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,                   //De verbinding
                        CommandType = CommandType.Text,     //Type command is Text
                        CommandText = "SELECT voorletters, tussenvoegsel, achternaam, geboortedatum, geslacht, instrument FROM Persoon " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID "
                    };

                    cmd.CommandText += "ORDER BY " + filterLijstKNMO[0];

                    for (int i = 1; i < filterLijstKNMO.Count; i++)
                    {
                        if(filterLijstKNMO.Contains("ASC") == false && filterLijstKNMO.Contains("DESC") == false)
                        {
                            cmd.CommandText += ", " + filterLijstKNMO[i];
                        }
                    }

                    if(filterLijstKNMO.Contains("ASC"))
                    {
                        cmd.CommandText += " ASC;";
                    }

                    if(filterLijstKNMO.Contains("DESC"))
                    {
                        cmd.CommandText += " DESC;";
                    }

                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstKNMO tabel uit de database
                    da.Fill(ds, "LijstKNMO");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> filterLijstKNMO)
        {
            DataSet ds = new DataSet();
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    SqlDataAdapter da = new SqlDataAdapter();   //Creeër een nieuw SqlCommand object

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,                   //De verbinding
                        CommandType = CommandType.Text,     //Type command is Text
                        CommandText = "SELECT voorletters, tussenvoegsel, achternaam, geboortedatum, geslacht, instrument FROM Persoon " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID "
                    };

                    cmd.CommandText += "GROUP BY " + filterLijstKNMO[0];

                    for (int i = 1; i < filterLijstKNMO.Count; i++)
                    {
                        cmd.CommandText += ", " + filterLijstKNMO[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstKNMO tabel uit de database
                    da.Fill(ds, "LijstKNMO");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }
    }
}
