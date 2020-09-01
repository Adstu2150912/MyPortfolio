/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstJubileaDA.cs

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
    public class LijstJubileaDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public LijstJubileaDA()
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

                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, straatnaam, straatnummer, postcode, plaats, telefoonnummer, mobielnummer, emailadres, lidnummer, instrument, startdatum, jubileaopmerking" +
                        " FROM Persoon " +
                        "FULL JOIN Woonadres ON Persoon.woonadresID = Woonadres.woonadresID " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN JubileaVerenigingslid ON Verenigingslid.verenigingslidID = JubileaVerenigingslid.verenigingslidID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID;"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "LijstJubilea");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public DataSet FilterJaarLidmaatschap(int jaarLidmaatschap)
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

                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, straatnaam, straatnummer, postcode, plaats, telefoonnummer, mobielnummer, emailadres, lidnummer, instrument, startdatum, jubileaopmerking" +
                        " FROM Persoon " +
                        "FULL JOIN Woonadres ON Persoon.woonadresID = Woonadres.woonadresID " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN JubileaVerenigingslid ON Verenigingslid.verenigingslidID = JubileaVerenigingslid.verenigingslidID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID " +
                        "GROUP BY voornaam, voorletters, tussenvoegsel, achternaam, straatnaam, straatnummer, postcode, plaats, telefoonnummer, mobielnummer, emailadres, lidnummer, instrument, startdatum, jubileaopmerking " +
                        "HAVING YEAR(GETDATE()) - YEAR(startdatum) = " + jaarLidmaatschap
                    };

                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstJubilea tabel uit de database
                    da.Fill(ds, "LijstJubilea");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> filterLijstJubilea)
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
                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, straatnaam, straatnummer, postcode, plaats, telefoonnummer, mobielnummer, emailadres, lidnummer, instrument, startdatum, jubileaopmerking" +
                        " FROM Persoon " +
                        "FULL JOIN Woonadres ON Persoon.woonadresID = Woonadres.woonadresID " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN JubileaVerenigingslid ON Verenigingslid.verenigingslidID = JubileaVerenigingslid.verenigingslidID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID "
                    };

                    cmd.CommandText += "ORDER BY " + filterLijstJubilea[0];

                    for (int i = 1; i < filterLijstJubilea.Count; i++)
                    {
                        cmd.CommandText += ", " + filterLijstJubilea[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstJubilea tabel uit de database
                    da.Fill(ds, "LijstJubilea");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> filterLijstJubilea)
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
                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, straatnaam, straatnummer, postcode, plaats, telefoonnummer, mobielnummer, emailadres, lidnummer, instrument, startdatum, jubileaopmerking" +
                        " FROM Persoon " +
                        "FULL JOIN Woonadres ON Persoon.woonadresID = Woonadres.woonadresID " +
                        "FULL JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.persoonID " +
                        "FULL JOIN JubileaVerenigingslid ON Verenigingslid.verenigingslidID = JubileaVerenigingslid.verenigingslidID " +
                        "FULL JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID "
                    };

                    cmd.CommandText += "GROUP BY " + filterLijstJubilea[0];

                    for (int i = 1; i < filterLijstJubilea.Count; i++)
                    {
                        cmd.CommandText += ", " + filterLijstJubilea[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstJubilea tabel uit de database
                    da.Fill(ds, "LijstJubilea");
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
