/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     VerenigingslidDA.cs

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
    public class VerenigingslidDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public VerenigingslidDA()
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

                        CommandText = "SELECT * FROM Verenigingslid"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "Verenigingslid");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public int Create(VerenigingslidBO verengingslid)
        {
            // Hier wordt een variabel gedeclareerd waarin het aantal gewijzigde rijen in de tabel opgeslagen wordt
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina VerenigingslidRegistratie wordt
                //in het business object VerenigingslidBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe verengingslid in te voeren
                    CommandText = "IF EXISTS(SELECT persoonID FROM Persoon WHERE persoonID = @persoonID) " +
                    "INSERT INTO Verenigingslid(persoonID, lidnummer, startdatum) VALUES(" +
                    "@persoonID, @lidnummer, @startdatum);"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@persoonID", verengingslid.PersoonID);
                cmd.Parameters.AddWithValue("@lidnummer", verengingslid.Lidnummer);
                cmd.Parameters.AddWithValue("@startdatum", verengingslid.Startdatum);

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

        public int Update(VerenigingslidBO verenigingslid)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina VerenigingslidRegistratie wordt
                //in het business object VerenigingslidBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe verenigingslid in te voeren
                    CommandText = "UPDATE Verenigingslid SET persoonID = @persoonID, lidnummer = @lidnummer, startdatum = @startdatum WHERE verenigingslidID = @verenigingslidID;"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@verenigingslidID", verenigingslid.VerenigingslidID);
                cmd.Parameters.AddWithValue("@persoonID", verenigingslid.PersoonID);
                cmd.Parameters.AddWithValue("@lidnummer", verenigingslid.Lidnummer);
                cmd.Parameters.AddWithValue("@startdatum", verenigingslid.Startdatum);

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

        public int Delete(List<int> selectedResultaten)
        {
            int result = 0;

            if (selectedResultaten != null)
            {
                //Creeër een nieuw SQL connectie object met de connectiestring
                using (SqlConnection con = new SqlConnection(connectionString))
                {
                    try
                    {
                        for (int i = 0; i < selectedResultaten.Count; i++)
                        {
                            SqlCommand DeleteCommand = new SqlCommand
                            {
                                Connection = con,
                                CommandType = CommandType.Text,
                                CommandText = "DELETE FROM Verenigingslid WHERE verenigingslidID = " + selectedResultaten[i]
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
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM Verenigingslid", con);
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

        public DataSet Select(List<string> selectVerenigingsleden)
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

                        CommandText = "SELECT verenigingslidID",
                    };

                    for (int i = 0; i < selectVerenigingsleden.Count; i++)
                    {
                        cmd.CommandText += ", " + selectVerenigingsleden[i];
                    }

                    cmd.CommandText += " FROM Verenigingslid;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Verenigingslid tabel uit de database
                    da.Fill(ds, "Verenigingslid");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterVerenigingslid)
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

                    cmd.CommandText += " FROM Verenigingslid ORDER BY " + filterVerenigingslid[0];

                    for (int i = 1; i < filterVerenigingslid.Count; i++)
                    {
                        cmd.CommandText += ", " + filterVerenigingslid[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Verenigingslid tabel uit de database
                    da.Fill(ds, "Verenigingslid");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterVerenigingslid)
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

                    cmd.CommandText += " FROM Verenigingslid GROUP BY " + filterVerenigingslid[0];

                    for (int i = 1; i < filterVerenigingslid.Count; i++)
                    {
                        cmd.CommandText += ", " + filterVerenigingslid[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Verenigingslid tabel uit de database
                    da.Fill(ds, "Verenigingslid");
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
