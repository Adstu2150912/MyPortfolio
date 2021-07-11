/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    29 november 2018
Module naam:     LijstPersoonEvenementDA.cs

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
    public class LijstPersoonEvenementDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public LijstPersoonEvenementDA()
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

                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, evenementnaam, evenementtype, begindatum, einddatum " +
                        "FROM Evenement " +
                        "INNER JOIN EvenementVerenigingslid ON Evenement.evenementID = EvenementVerenigingslid.evenementID " +
                        "INNER JOIN Verenigingslid ON EvenementVerenigingslid.verenigingslidID = Verenigingslid.verenigingslidID " +
                        "INNER JOIN Persoon ON Verenigingslid.persoonID = Persoon.persoonID "

                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "LijstPersoonEvenement");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public DataSet Sort(List<string> filterLijstPersoonEvenement)
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
                        CommandText = "SELECT voornaam, voorletters, tussenvoegsel, achternaam, evenementnaam, evenementtype, begindatum, einddatum " +
                        "FROM Evenement " +
                        "INNER JOIN EvenementVerenigingslid ON Evenement.evenementID = EvenementVerenigingslid.evenementID " +
                        "INNER JOIN Verenigingslid ON EvenementVerenigingslid.verenigingslidID = Verenigingslid.verenigingslidID " +
                        "INNER JOIN Persoon ON Verenigingslid.persoonID = Persoon.persoonID "
                    };

                    cmd.CommandText += "ORDER BY " + filterLijstPersoonEvenement[0];

                    for (int i = 1; i < filterLijstPersoonEvenement.Count; i++)
                    {
                        cmd.CommandText += ", " + filterLijstPersoonEvenement[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de LijstPersoonEvenement tabel uit de database
                    da.Fill(ds, "LijstPersoonEvenement");
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
