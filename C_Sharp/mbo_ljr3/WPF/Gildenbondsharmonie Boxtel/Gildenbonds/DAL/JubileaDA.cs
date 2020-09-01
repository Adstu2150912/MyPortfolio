/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     JubileaDA.cs

Omschrijving:    Data Access Object Jubilea

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
    public class JubileaDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public JubileaDA()
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

                        CommandText = "SELECT * FROM Jubilea FULL JOIN JubileaVerenigingslid ON Jubilea.jubileaID = JubileaVerenigingslid.jubileaID"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "Jubilea");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public int Create(JubileaBO Jubilea)
        {
            // Hier wordt een variabel gedeclareerd waarin het aantal gewijzigde rijen in de tabel opgeslagen wordt
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina JubileaRegistratie wordt
                //in het business object JubileaBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Jubilea in te voeren
                    CommandText =
                    "INSERT INTO Jubilea(naam, omschrijving) VALUES(" +
                    "@naam, @omschrijving);" +
                    "IF EXISTS(SELECT jubileaID FROM Jubilea WHERE jubileaID = @jubileaID) INSERT INTO JubileaVerenigingslid(jubileaID, verenigingslidID, jubileaopmerking)" +
                    "VALUES(@jubileaID, @verenigingslidID, @jubileaopmerking);"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@naam", Jubilea.Naam);
                cmd.Parameters.AddWithValue("@omschrijving", Jubilea.Omschrijving);
                cmd.Parameters.AddWithValue("@jubileaID", Jubilea.JubileaID);
                cmd.Parameters.AddWithValue("@verenigingslidID", Jubilea.VerenigingslidID);
                cmd.Parameters.AddWithValue("@jubileaopmerking", Jubilea.JubileaOpmerking);

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

        public int Update(JubileaBO Jubilea)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina JubileaRegistratie wordt
                //in het business object JubileaBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Jubilea in te voeren
                    CommandText = "UPDATE Jubilea SET naam = @naam, omschrijving = @omschrijving" +
                    "WHERE JubileaID = @JubileaID;" +

                    "IF EXISTS(SELECT verenigingslidID FROM JubileaVerenigingslid WHERE verenigingslidID = @verenigingslidID) UPDATE JubileaVerenigingslid SET jubileaID = @jubileaID, verenigingslidID = @verenigingslidID, jubileaopmerking = @jubileaopmerking" +
                    "WHERE JubileaID = @JubileaID AND verenigingslidID = @verenigingslidID;"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@JubileaID", Jubilea.JubileaID);
                cmd.Parameters.AddWithValue("@naam", Jubilea.Naam);
                cmd.Parameters.AddWithValue("@omschrijving", Jubilea.Omschrijving);
                cmd.Parameters.AddWithValue("@jubileaID", Jubilea.JubileaID);
                cmd.Parameters.AddWithValue("@verenigingslidID", Jubilea.VerenigingslidID);
                cmd.Parameters.AddWithValue("@jubileaopmerking", Jubilea.JubileaOpmerking);

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

        public int Delete(List<int> selectedJubilarissen, List<int> selectedVerenigingsleden)
        {
            int result = 0;

            if (selectedJubilarissen != null)
            {
                //Creeër een nieuw SQL connectie object met de connectiestring
                using (SqlConnection con = new SqlConnection(connectionString))
                {
                    try
                    {
                        for (int i = 0; i < selectedJubilarissen.Count; i++)
                        {
                            SqlCommand DeleteCommand = new SqlCommand
                            {
                                Connection = con,
                                CommandType = CommandType.Text,
                                CommandText = "DELETE FROM Jubilea WHERE jubileaID = " + selectedJubilarissen[i] + "; "
                                + "DELETE FROM JubileaVerenigingslid WHERE jubileaID = " + selectedJubilarissen[i] + " AND WHERE verenigingslidID = " + selectedVerenigingsleden[i]
                   
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
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM Jubilea; DELETE FROM JubileaVerenigingslid;", con);
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

        public DataSet Select(List<string> selectJubilarissen)
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

                    for (int i = 0; i < selectJubilarissen.Count; i++)
                    {
                        cmd.CommandText += ", " + selectJubilarissen[i];
                    }

                    cmd.CommandText += " FROM Jubilea FULL JOIN JubileaVerenigingslid ON Jubilea.jubileaID = JubileaVerenigingslid.jubileaID;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Jubilea tabel uit de database
                    da.Fill(ds, "Jubilea");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterJubilea)
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

                    cmd.CommandText += " FROM Jubilea FULL JOIN JubileaVerenigingslid ON Jubilea.jubileaID = JubileaVerenigingslid.jubileaID ORDER BY " + filterJubilea[0];

                    for (int i = 1; i < filterJubilea.Count; i++)
                    {
                        cmd.CommandText += ", " + filterJubilea[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Jubilea tabel uit de database
                    da.Fill(ds, "Jubilea");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterJubilea)
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

                    cmd.CommandText += " FROM Jubilea FULL JOIN JubileaVerenigingslid ON Jubilea.jubileaID = JubileaVerenigingslid.jubileaID GROUP BY " + filterJubilea[0];

                    for (int i = 1; i < filterJubilea.Count; i++)
                    {
                        cmd.CommandText += ", " + filterJubilea[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Jubilea tabel uit de database
                    da.Fill(ds, "Jubilea");
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
