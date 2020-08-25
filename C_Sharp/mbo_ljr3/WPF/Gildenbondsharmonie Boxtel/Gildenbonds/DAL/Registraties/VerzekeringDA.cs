/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     VerzekeringDA.cs

Omschrijving:    Data Access Object Verzekering

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
    public class VerzekeringDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public VerzekeringDA()
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

                        CommandText = "SELECT * FROM Verzekering"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "Verzekering");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public int Create(VerzekeringBO verzekering)
        {
            // Hier wordt een variabel gedeclareerd waarin het aantal gewijzigde rijen in de tabel opgeslagen wordt
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina VerzekeringRegistratie wordt
                //in het business object VerzekeringBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Verzekering in te voeren
                    CommandText =
                    "INSERT INTO Verzekering(serienummer, aanschafprijs, aanschafdatum, afschrijvingsdatum, leverancier, verzekerd, verzekeringswaarde) VALUES(" +
                    "@serienummer, @aanschafprijs, @aanschafdatum, @afschrijvingsdatum, @leverancier, @verzekerd, @verzekeringswaarde)"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@serienummer", verzekering.Serienummer);
                cmd.Parameters.AddWithValue("@aanschafprijs", verzekering.Aanschafprijs);
                cmd.Parameters.AddWithValue("@aanschafdatum", verzekering.Aanschafdatum);
                cmd.Parameters.AddWithValue("@afschrijvingsdatum", verzekering.Afschrijvingsdatum);
                cmd.Parameters.AddWithValue("@leverancier", verzekering.Leverancier);
                cmd.Parameters.AddWithValue("@verzekerd", verzekering.Verzekerd);
                cmd.Parameters.AddWithValue("@verzekeringswaarde", verzekering.Verzekeringswaarde);

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

        public int Update(VerzekeringBO verzekering)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina VerzekeringRegistratie wordt
                //in het business object VerzekeringBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Verzekering in te voeren
                    CommandText = "UPDATE Verzekering SET serienummer = @serienummer, aanschafprijs = @aanschafprijs, aanschafdatum = @aanschafdatum, afschrijvingsdatum = @afschrijvingsdatum," +
                    "leverancier = @leverancier, verzekerd = @verzekerd, verzekeringswaarde = @verzekeringswaarde WHERE verzekeringID = @verzekeringID;"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@verzekeringID", verzekering.VerzekeringID);
                cmd.Parameters.AddWithValue("@serienummer", verzekering.Serienummer);
                cmd.Parameters.AddWithValue("@aanschafprijs", verzekering.Aanschafprijs);
                cmd.Parameters.AddWithValue("@aanschafdatum", verzekering.Aanschafdatum);
                cmd.Parameters.AddWithValue("@afschrijvingsdatum", verzekering.Afschrijvingsdatum);
                cmd.Parameters.AddWithValue("@leverancier", verzekering.Leverancier);
                cmd.Parameters.AddWithValue("@verzekerd", verzekering.Verzekerd);
                cmd.Parameters.AddWithValue("@verzekeringswaarde", verzekering.Verzekeringswaarde);

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
                                CommandText = "DELETE FROM Verzekering WHERE verzekeringID = " + selectedResultaten[i]
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
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM Verzekering", con);
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

        public DataSet Select(List<string> selectPersonen)
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

                        CommandText = "SELECT verzekeringID",
                    };

                    for (int i = 0; i < selectPersonen.Count; i++)
                    {
                        cmd.CommandText += ", " + selectPersonen[i];
                    }

                    cmd.CommandText += " FROM Verzekering;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Verzekering tabel uit de database
                    da.Fill(ds, "Verzekering");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterVerzekering)
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
                        CommandText = "SELECT verzekeringID" + selectedColumns[0],
                    };

                    for (int i = 1; i < selectedColumns.Count; i++)
                    {
                        cmd.CommandText += ", " + selectedColumns[i];
                    }

                    cmd.CommandText += " FROM Verzekering ORDER BY " + filterVerzekering[0];

                    for (int i = 1; i < filterVerzekering.Count; i++)
                    {
                        cmd.CommandText += ", " + filterVerzekering[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Verzekering tabel uit de database
                    da.Fill(ds, "Verzekering");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterVerzekering)
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
                        CommandText = "SELECT verzekeringID" + selectedColumns[0],
                    };

                    for (int i = 1; i < selectedColumns.Count; i++)
                    {
                        cmd.CommandText += ", " + selectedColumns[i];
                    }

                    cmd.CommandText += " FROM Verzekering GROUP BY " + filterVerzekering[0];

                    for (int i = 1; i < filterVerzekering.Count; i++)
                    {
                        cmd.CommandText += ", " + filterVerzekering[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Verzekering tabel uit de database
                    da.Fill(ds, "Verzekering");
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
