/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     WoonadresDA.cs

Omschrijving:    Data Access Object Woonadres

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
    public class WoonadresDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public WoonadresDA()
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

                        CommandText = "SELECT * FROM Woonadres"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "Woonadres");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public int Create(WoonadresBO woonadres)
        {
            // Hier wordt een variabel gedeclareerd waarin het aantal gewijzigde rijen in de tabel opgeslagen wordt
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina WoonadresRegistratie wordt
                //in het business object WoonadresBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Woonadres in te voeren
                    CommandText =
                    "INSERT INTO Woonadres(straatnaam, straatnummer, postcode, plaats) VALUES(" +
                    "@straatnaam, @straatnummer, @postcode, @plaats)"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@straatnaam", woonadres.Straatnaam);
                cmd.Parameters.AddWithValue("@straatnummer", woonadres.Straatnummer);
                cmd.Parameters.AddWithValue("@postcode", woonadres.Postcode);
                cmd.Parameters.AddWithValue("@plaats", woonadres.Plaats);

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

        public int Update(WoonadresBO woonadres)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina WoonadresRegistratie wordt
                //in het business object WoonadresBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Woonadres in te voeren
                    CommandText = "UPDATE Woonadres SET straatnaam = @straatnaam, straatnummer = @straatnummer, postcode = @postcode, plaats = @plaats," +
                    "WHERE woonadresID = @woonadresID;"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@woonadresID", woonadres.WoonadresID);
                cmd.Parameters.AddWithValue("@straatnaam", woonadres.Straatnaam);
                cmd.Parameters.AddWithValue("@straatnummer", woonadres.Straatnummer);
                cmd.Parameters.AddWithValue("@postcode", woonadres.Postcode);
                cmd.Parameters.AddWithValue("@plaats", woonadres.Plaats);

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
                                CommandText = "DELETE FROM Woonadres WHERE woonadresID = " + selectedResultaten[i]
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
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM Woonadres", con);
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

                        CommandText = "SELECT woonadresID",
                    };

                    for (int i = 0; i < selectPersonen.Count; i++)
                    {
                        cmd.CommandText += ", " + selectPersonen[i];
                    }

                    cmd.CommandText += " FROM Woonadres;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Woonadres tabel uit de database
                    da.Fill(ds, "Woonadres");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterWoonadres)
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

                    cmd.CommandText += " FROM Woonadres ORDER BY " + filterWoonadres[0];

                    for (int i = 1; i < filterWoonadres.Count; i++)
                    {
                        cmd.CommandText += ", " + filterWoonadres[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Woonadres tabel uit de database
                    da.Fill(ds, "Woonadres");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterWoonadres)
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

                    cmd.CommandText += " FROM Woonadres GROUP BY " + filterWoonadres[0];

                    for (int i = 1; i < filterWoonadres.Count; i++)
                    {
                        cmd.CommandText += ", " + filterWoonadres[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Woonadres tabel uit de database
                    da.Fill(ds, "Woonadres");
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
