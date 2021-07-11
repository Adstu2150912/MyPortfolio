/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     BEDeelnameDA.cs

Omschrijving:    Data Access Layer Backend Deelname(s) Vestingloop

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL
using System.Data.SqlClient;    //Voor SQL
using System.Configuration;     //Voor het uitlezen van de Web.config
using System.Windows.Forms;     //Voor het tonen van (fout)meldingen

namespace Vestingloop2018
{
    public class BEDeelnameDA
    {
        //Bewaar de SQL verbinding waarin de deelnamegegevens worden opgeslagen
        string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public BEDeelnameDA()
        {

        }

        //Implementatie: methodes

        public int CreateFE(FEDeelnameBO deelname)
        {
            int result = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier FEDeelname wordt
                //in het data object FEDeelname getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "IF EXISTS(SELECT BE_Deelname_ID FROM BE_Deelname WHERE BE_Deelname_ID = @Deelname_ID) " +
                    "INSERT INTO FE_Deelname(BE_Deelname_ID, Deelnemer, Afkomst, Leeftijd) VALUES(" +
                    "@Deelname_ID, @Deelnemer, @Afkomst, @Leeftijd)"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@Deelname_ID", deelname.FEDeelnameID);
                cmd.Parameters.AddWithValue("@Deelnemer", deelname.Deelnemer);
                cmd.Parameters.AddWithValue("@Afkomst", deelname.Afkomst);
                cmd.Parameters.AddWithValue("@Leeftijd", deelname.Leeftijd);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    result = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch(SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return result; // Aantal rijen aangepast in de tabel
        }

        public int CreateBE(BEDeelnameBO deelname)
        {
            int result = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier BEDeelname wordt
                //in het data object BEDeelname getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "INSERT INTO BE_Deelname(Deelnemer, Afkomst, Leeftijd) VALUES(@Deelnemer, @Afkomst, @Leeftijd)"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@Deelnemer", deelname.Deelnemer);
                cmd.Parameters.AddWithValue("@Afkomst", deelname.Afkomst);
                cmd.Parameters.AddWithValue("@Leeftijd", deelname.Leeftijd);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    result = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return result; // Aantal rijen aangepast in de tabel
        }

        public int UpdateFE(FEDeelnameBO deelname)
        {
            int result = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier FEDeelname wordt
                //in het data object FEDeelname getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "UPDATE FE_Deelname SET Deelnemer = @Deelnemer, Afkomst = @Afkomst, Leeftijd = @Leeftijd WHERE FE_Deelname_ID = @FE_Deelname_ID"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@FE_Deelname_ID", deelname.FEDeelnameID);
                cmd.Parameters.AddWithValue("@Deelnemer", deelname.Deelnemer);
                cmd.Parameters.AddWithValue("@Afkomst", deelname.Afkomst);
                cmd.Parameters.AddWithValue("@Leeftijd", deelname.Leeftijd);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    result = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return result; // Aantal rijen aangepast in de tabel
        }

        public int UpdateBE(BEDeelnameBO deelname)
        {
            int result = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier BEDeelname wordt
                //in het data object BEDeelname getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "UPDATE BE_Deelname SET Deelnemer = @Deelnemer, Afkomst = @Afkomst, Leeftijd = @Leeftijd WHERE BE_Deelname_ID = @BE_Deelname_ID"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@BE_Deelname_ID", deelname.BEDeelnameID);
                cmd.Parameters.AddWithValue("@Deelnemer", deelname.Deelnemer);
                cmd.Parameters.AddWithValue("@Afkomst", deelname.Afkomst);
                cmd.Parameters.AddWithValue("@Leeftijd", deelname.Leeftijd);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    result = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return result; // Aantal rijen aangepast in de tabel
        }

        public int DeleteFE(List<int> selectedDeelnames)
        {
            int result = 0;

            if (selectedDeelnames != null)
            {
                //Creeër een nieuw SQL connectie object met de connectiestring
                using (SqlConnection con = new SqlConnection(connectionString))
                {
                    try
                    {
                        for (int i = 0; i < selectedDeelnames.Count; i++)
                        {
                            SqlCommand DeleteCommand = new SqlCommand
                            {
                                Connection = con,
                                CommandType = CommandType.Text,
                                CommandText = "DELETE FROM FE_Deelname WHERE FE_Deelname_ID = " + selectedDeelnames[i]
                            };
                            //Open de Database connectie met de connectie string
                            con.Open();
                            result = DeleteCommand.ExecuteNonQuery();     //Voer het commando uit op de database
                            con.Close();
                        }
                    }
                    catch (SqlException ex)
                    {
                        MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                    }
                }
                return result; // Het aantal rijen aangepast in de tabel
            }
            else
            {
                return result; // Het aantal rijen aangepast in de tabel
            }
        }

        public int DeleteBE(List<int> selectedDeelnames)
        {
            int result = 0;

            if (selectedDeelnames != null)
            {
                //Creeër een nieuw SQL connectie object met de connectiestring
                using (SqlConnection con = new SqlConnection(connectionString))
                {
                    try
                    {
                        for (int i = 0; i < selectedDeelnames.Count; i++)
                        {
                            SqlCommand DeleteCommand = new SqlCommand
                            {
                                Connection = con,
                                CommandType = CommandType.Text,
                                CommandText = "DELETE FROM BE_Deelname WHERE BE_Deelname_ID = " + selectedDeelnames[i]
                            };
                            //Open de Database connectie met de connectie string
                            con.Open();
                            result = DeleteCommand.ExecuteNonQuery();     //Voer het commando uit op de database
                            con.Close();
                        }
                    }
                    catch (SqlException ex)
                    {
                        MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                    }
                }
                return result; // Het aantal rijen aangepast in de tabel
            }
            else
            {
                return result; // Het aantal rijen aangepast in de tabel
            }
        }

        public void DeleteAllFE()
        {
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM FE_Deelname", con);
                    con.Open();
                    DeleteAllCommand.ExecuteNonQuery();     //Voer het commando uit op de database
                    con.Close();
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
            }
        }

        public void DeleteAllBE()
        {
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM BE_Deelname", con);
                    con.Open();
                    DeleteAllCommand.ExecuteNonQuery();     //Voer het commando uit op de database
                    con.Close();
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
            }
        }

        public DataSet ReadFE()
        {
            DataSet ds = new DataSet();
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    //Alle dat uit het Windows Forms formulier FEDeelname wordt
                    //in het data object FEDeelname gestopt. Dit dataobject geven we via de Business Logic Layer door naar de Data Access Layer
                    //in de Data Access Layer wordt de connectie met de database verzorgt.

                    SqlDataAdapter da = new SqlDataAdapter();   //Creeër een nieuw SqlCommand object

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,                   //De verbinding
                        CommandType = CommandType.Text,     //Type command is Text

                        CommandText = "SELECT * FROM FE_Deelname"
                    };

                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de FE_Deelname tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "FE_Deelname");
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
            }
            return ds;
        }

        public DataSet ReadBE()
        {
            DataSet ds = new DataSet();
            //Creeër een nieuw SQL connectie object met de connectiestring
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                try
                {
                    //Alle dat uit het Windows Forms formulier BEDeelname wordt
                    //in het data object BEDeelname gestopt. Dit dataobject geven we via de Business Logic Layer door naar de Data Access Layer
                    //in de Data Access Layer wordt de connectie met de database verzorgt.

                    SqlDataAdapter da = new SqlDataAdapter();   //Creeër een nieuw SqlCommand object

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,                   //De verbinding
                        CommandType = CommandType.Text,     //Type command is Text

                        CommandText = "SELECT * FROM BE_Deelname"
                    };

                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de BE_Deelname tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "BE_Deelname");
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
            }
            return ds;
        }
    }
}
