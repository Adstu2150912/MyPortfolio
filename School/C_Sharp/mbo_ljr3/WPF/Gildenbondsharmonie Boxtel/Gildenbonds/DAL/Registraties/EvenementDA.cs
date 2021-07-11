/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     EvenementDA.cs

beschrijving:    Data Access Object Evenement

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
    public class EvenementDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public EvenementDA()
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

                        CommandText = "SELECT * FROM Evenement FULL JOIN EvenementVerenigingslid ON Evenement.evenementID = EvenementVerenigingslid.evenementID;"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "EvenementEvenementverenigingslid");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public int Create(EvenementBO evenement)
        {
            // Hier wordt een variabel gedeclareerd waarin het aantal gewijzigde rijen in de tabel opgeslagen wordt
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina EvenementRegistratie wordt
                //in het business object EvenementBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Evenement in te voeren
                    CommandText =
                    "INSERT INTO Evenement(evenementnaam, evenementtype, begindatum, einddatum, starttijd, eindtijd, locatie, beschrijving) VALUES(" +
                    "@evenementnaam, @evenementtype, @begindatum, @einddatum, @starttijd, @eindtijd, @locatie, @beschrijving);"
                    + "IF EXISTS(SELECT evenementID FROM Evenement WHERE evenementID = @evenementID) INSERT INTO Evenementverenigingslid(evenementID, verenigingslidID)"
                    + "VALUES(@evenementID, @verenigingslidID);"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@evenementnaam", evenement.EvenementNaam);
                cmd.Parameters.AddWithValue("@evenementtype", evenement.EvenementType);
                cmd.Parameters.AddWithValue("@begindatum", evenement.BeginDatum);
                cmd.Parameters.AddWithValue("@einddatum", evenement.EindDatum);
                cmd.Parameters.AddWithValue("@starttijd", evenement.StartTijd);
                cmd.Parameters.AddWithValue("@eindtijd", evenement.EindTijd);
                cmd.Parameters.AddWithValue("@locatie", evenement.Locatie);
                cmd.Parameters.AddWithValue("@beschrijving", evenement.Beschrijving);
                cmd.Parameters.AddWithValue("@evenementID", evenement.EvenementID);
                cmd.Parameters.AddWithValue("@verenigingslidID", evenement.VerenigingslidID);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    dbresult = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return dbresult; // Aantal rijen aangepast in de tabel
        }

        public int Update(EvenementBO evenement)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina EvenementRegistratie wordt
                //in het business object EvenementBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Evenement in te voeren
                    CommandText = "UPDATE Evenement SET evenementnaam = @evenementnaam, evenementtype = @evenementtype, begindatum = @begindatum, einddatum = @einddatum," +
                    "starttijd = @starttijd, eindtijd = @eindtijd, locatie = @locatie, beschrijving = @beschrijving" +
                    " WHERE evenementID = @evenementID;"
                    + "IF EXISTS(SELECT verenigingslidID FROM JubileaVerenigingslid WHERE verenigingslidID = @verenigingslidID) UPDATE EvenementVerenigingslid SET evenementID = @evenementID, verenigingslidID = @verenigingslidID WHERE evenementID = @evenementID AND verenigingslidID = @verenigingslidID;"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@evenementID", evenement.EvenementID);
                cmd.Parameters.AddWithValue("@evenementnaam", evenement.EvenementNaam);
                cmd.Parameters.AddWithValue("@evenementtype", evenement.EvenementType);
                cmd.Parameters.AddWithValue("@begindatum", evenement.BeginDatum);
                cmd.Parameters.AddWithValue("@einddatum", evenement.EindDatum);
                cmd.Parameters.AddWithValue("@starttijd", evenement.StartTijd);
                cmd.Parameters.AddWithValue("@eindtijd", evenement.EindTijd);
                cmd.Parameters.AddWithValue("@locatie", evenement.Locatie);
                cmd.Parameters.AddWithValue("@beschrijving", evenement.Beschrijving);
                cmd.Parameters.AddWithValue("@verenigingslidID", evenement.VerenigingslidID);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    dbresult = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return dbresult; // Aantal rijen aangepast in de tabel
        }

        public int Delete(List<int> selectedEvenementen, List<int> selectedVerenigingsleden)
        {
            int result = 0;

            if (selectedEvenementen != null)
            {
                //Creeër een nieuw SQL connectie object met de connectiestring
                using (SqlConnection con = new SqlConnection(connectionString))
                {
                    try
                    {
                        for (int i = 0; i < selectedEvenementen.Count; i++)
                        {
                            SqlCommand DeleteCommand = new SqlCommand
                            {
                                Connection = con,
                                CommandType = CommandType.Text,
                                CommandText = "DELETE FROM Evenement WHERE evenementID = " + selectedEvenementen[i] + "; " +
                                "DELETE FROM EvenementVerenigingslid WHERE evenementID = " + selectedEvenementen[i] + " AND WHERE verenigingslidID = " + selectedVerenigingsleden[i]
                            };
                            //Open de Database connectie met de connectie string
                            con.Open();
                            result = DeleteCommand.ExecuteNonQuery();     //Voer het commando uit op de database
                            con.Close();
                        }
                    }
                    catch (SqlException msg)
                    {
                        MessageBox.Show(msg.Message, "SQL Foutmelding");
                    }
                }
                return result; // Het aantal rijen aangepast in de tabel
            }
            else
            {
                return result; // Het aantal rijen aangepast in de tabel
            }
        }

        public void DeleteAll()
        {
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM Evenement; DELETE FROM EvenementVerenigingslid;", con);
                    con.Open();
                    DeleteAllCommand.ExecuteNonQuery();     //Voer het commando uit op de database
                    con.Close();
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
        }

        public DataSet Select(List<string> selectEvenementen)
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

                        CommandText = "SELECT ",
                    };

                    for (int i = 0; i < selectEvenementen.Count; i++)
                    {
                        cmd.CommandText += ", " + selectEvenementen[i];
                    }

                    cmd.CommandText += " FROM Evenement FULL JOIN Evenementverenigingslid ON Evenement.evenementID = Evenementverenigingslid.evenementID;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Evenement tabel uit de database
                    da.Fill(ds, "Evenement");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterEvenement)
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
                        CommandText = "SELECT " + selectedColumns[0],
                    };

                    for (int i = 1; i < selectedColumns.Count; i++)
                    {
                        cmd.CommandText += ", " + selectedColumns[i];
                    }

                    cmd.CommandText += " FROM Evenement FULL JOIN Evenementverenigingslid ON Evenement.evenementID = Evenementverenigingslid.evenementID ORDER BY " + filterEvenement[0];

                    for (int i = 1; i < filterEvenement.Count; i++)
                    {
                        cmd.CommandText += ", " + filterEvenement[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Evenement tabel uit de database
                    da.Fill(ds, "Evenement");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterEvenement)
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
                        CommandText = "SELECT " + selectedColumns[0],
                    };

                    for (int i = 1; i < selectedColumns.Count; i++)
                    {
                        cmd.CommandText += ", " + selectedColumns[i];
                    }

                    cmd.CommandText += " FROM Evenement FULL JOIN Evenementverenigingslid ON Evenement.evenementID = Evenementverenigingslid.evenementID GROUP BY " + filterEvenement[0];

                    for (int i = 1; i < filterEvenement.Count; i++)
                    {
                        cmd.CommandText += ", " + filterEvenement[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Evenement tabel uit de database
                    da.Fill(ds, "Evenement");
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
