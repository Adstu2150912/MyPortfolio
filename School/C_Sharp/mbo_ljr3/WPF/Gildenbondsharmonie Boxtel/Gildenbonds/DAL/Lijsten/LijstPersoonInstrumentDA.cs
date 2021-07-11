/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstPersoonInstrumentDA.cs

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
    public class LijstPersoonInstrumentDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public LijstPersoonInstrumentDA()
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

                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, instrument, instrumenttype, merk, serienummer  " +
                        "FROM Persoon " +
                        "INNER JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.verenigingslidID  " +
                        "INNER JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID " +
                        "INNER JOIN Verzekering ON Instrument.verzekeringID = Verzekering.verzekeringID "
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "LijstPersoonInstrument");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public DataSet Sort(List<string> filterLijstPersoonInstrument)
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
                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, instrument, instrumenttype, merk, serienummer  " +
                        "FROM Persoon " +
                        "INNER JOIN Verenigingslid ON Persoon.persoonID = Verenigingslid.verenigingslidID  " +
                        "INNER JOIN Instrument ON Verenigingslid.verenigingslidID = Instrument.verenigingslidID " +
                        "INNER JOIN Verzekering ON Instrument.verzekeringID = Verzekering.verzekeringID "
                    };

                    cmd.CommandText += "ORDER BY " + filterLijstPersoonInstrument[0];

                    for (int i = 1; i < filterLijstPersoonInstrument.Count; i++)
                    {
                        cmd.CommandText += ", " + filterLijstPersoonInstrument[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstPersoonInstrument tabel uit de database
                    da.Fill(ds, "LijstPersoonInstrument");
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
