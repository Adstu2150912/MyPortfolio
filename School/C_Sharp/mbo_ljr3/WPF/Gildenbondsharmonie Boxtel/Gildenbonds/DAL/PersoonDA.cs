/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     PersoonDA.cs

Omschrijving:    Data Access Object Persoon

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
    public class PersoonDA
    {
        // Bewaar de SQL verbinding waarin de objectgegevens worden verwerkt
        // de connectiestring mag alléén gelezen worden
        readonly string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public PersoonDA()
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

                        CommandText = "SELECT * FROM Persoon"
                    };

                    da.SelectCommand = cmd;

                    da.Fill(ds, "Persoon");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }

            return ds;
        }

        public int Create(PersoonBO persoon)
        {
            // Hier wordt een variabel gedeclareerd waarin het aantal gewijzigde rijen in de tabel opgeslagen wordt
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina PersoonRegistratie wordt
                //in het business object PersoonBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe persoon in te voeren
                    CommandText = "IF EXISTS(SELECT woonadresID FROM Woonadres WHERE woonadresID = @woonadresID) " +
                    "INSERT INTO Persoon(woonadresID, voorletters, voornaam, tussenvoegsel, achternaam, geslacht, geboortedatum, telefoonnummer, mobielnummer, emailadres, groepnaam, groeptype) VALUES(" +
                    "@woonadresID, @voorletters, @voornaam, @tussenvoegsel, @achternaam, @geslacht, @geboortedatum, @telefoonnummer, @mobielnummer, @emailadres, @groepnaam, @groeptype)"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@woonadresID", persoon.WoonadresID);
                cmd.Parameters.AddWithValue("@voorletters", persoon.Voorletters);
                cmd.Parameters.AddWithValue("@voornaam", persoon.Voornaam);
                cmd.Parameters.AddWithValue("@tussenvoegsel", persoon.Tussenvoegsel);
                cmd.Parameters.AddWithValue("@achternaam", persoon.Achternaam);
                cmd.Parameters.AddWithValue("@geslacht", persoon.Geslacht);
                cmd.Parameters.AddWithValue("@geboortedatum", persoon.GeboorteDatum);
                cmd.Parameters.AddWithValue("@telefoonnummer", persoon.TelefoonNummer);
                cmd.Parameters.AddWithValue("@mobielnummer", persoon.MobielNummer);
                cmd.Parameters.AddWithValue("@emailadres", persoon.EmailAdres);
                cmd.Parameters.AddWithValue("@groepnaam", persoon.GroepNaam);
                cmd.Parameters.AddWithValue("@groeptype", persoon.GroepType);
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

        public int Update(PersoonBO persoon)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het WPF formulierpagina PersoonRegistratie wordt
                //in het business object PersoonBO getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe Persoon in te voeren
                    CommandText = "UPDATE Persoon SET woonadresID = @woonadresID, voorletters = @Voorletters, voornaam = @voornaam, tussenvoegsel = @tussenvoegsel," +
                    "achternaam = @achternaam, geslacht = @geslacht, geboortedatum = @geboortedatum, telefoonnummer = @telefoonnummer, mobielnummer = @mobielnummer," +
                    "emailadres = @emailadres, groepnaam = @groepnaam, groeptype = @groeptype WHERE persoonID = @persoonID;"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@persoonID", persoon.PersoonID);
                cmd.Parameters.AddWithValue("@woonadresID", persoon.WoonadresID);
                cmd.Parameters.AddWithValue("@voorletters", persoon.Voorletters);
                cmd.Parameters.AddWithValue("@voornaam", persoon.Voornaam);
                cmd.Parameters.AddWithValue("@tussenvoegsel", persoon.Tussenvoegsel);
                cmd.Parameters.AddWithValue("@achternaam", persoon.Achternaam);
                cmd.Parameters.AddWithValue("@geslacht", persoon.Geslacht);
                cmd.Parameters.AddWithValue("@geboortedatum", persoon.GeboorteDatum);
                cmd.Parameters.AddWithValue("@telefoonnummer", persoon.TelefoonNummer);
                cmd.Parameters.AddWithValue("@mobielnummer", persoon.MobielNummer);
                cmd.Parameters.AddWithValue("@emailadres", persoon.EmailAdres);
                cmd.Parameters.AddWithValue("@groepnaam", persoon.GroepNaam);
                cmd.Parameters.AddWithValue("@groeptype", persoon.GroepType);

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
                                CommandText = "DELETE FROM Persoon WHERE persoonID = " + selectedResultaten[i]
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
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM Persoon", con);
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

                        CommandText = "SELECT persoonID",
                    };

                    for (int i = 0; i < selectPersonen.Count; i++)
                    {
                        cmd.CommandText += ", " + selectPersonen[i];
                    }

                    cmd.CommandText += " FROM Persoon;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Persoon tabel uit de database
                    da.Fill(ds, "Persoon");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(List<string> selectedColumns, List<string> filterPersoon)
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

                    cmd.CommandText += " FROM Persoon ORDER BY " + filterPersoon[0];

                    for (int i = 1; i < filterPersoon.Count; i++)
                    {
                        cmd.CommandText += ", " + filterPersoon[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Persoon tabel uit de database
                    da.Fill(ds, "Persoon");
                }
                catch (SqlException msg)
                {
                    MessageBox.Show(msg.Message, "SQL Foutmelding");
                }
            }
            return ds;
        }

        public DataSet Group(List<string> selectedColumns, List<string> filterPersoon)
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

                    cmd.CommandText += " FROM Persoon GROUP BY " + filterPersoon[0];

                    for (int i = 1; i < filterPersoon.Count; i++)
                    {
                        cmd.CommandText += ", " + filterPersoon[i];
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de Persoon tabel uit de database
                    da.Fill(ds, "Persoon");
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
