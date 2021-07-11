/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     BEResultaatDA.cs

Omschrijving:    Data Access Layer Backend Resultaat(en) Vestingloop

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
    public class BEResultaatDA
    {
        //Bewaar de SQL verbinding waarin de resultaatgegevens worden opgeslagen
        string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public BEResultaatDA()
        {

        }

        //Implementatie: methodes

        public int CreateFE(FEResultaatBO resultaat)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier FEResultaat wordt
                //in het data object FEResultaat getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "IF EXISTS(SELECT BE_Resultaat_ID FROM BE_Resultaat WHERE BE_Resultaat_ID = @Resultaat_ID) " +
                    "INSERT INTO FE_Resultaat(BE_Resultaat_ID, Deelnemer, RouteD204, Tijd, Rang) VALUES(" +
                    "@Resultaat_ID, @Deelnemer, @RouteD204, @Tijd, @Rang)"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@Resultaat_ID", resultaat.FEResultaatID);
                cmd.Parameters.AddWithValue("@Deelnemer", resultaat.Deelnemer);
                cmd.Parameters.AddWithValue("@RouteD204", resultaat.RouteD204);
                cmd.Parameters.AddWithValue("@Tijd", resultaat.Tijd);
                cmd.Parameters.AddWithValue("@Rang", resultaat.Rang);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    dbresult = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return dbresult; // Aantal rijen aangepast in de tabel
        }

        //Alleen als de deelnemer bestaat kan er een resultaat aan gekoppeld worden
        public int CreateBE(BEResultaatBO resultaat)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier BEResultaat wordt
                //in het data object BEResultaat getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "INSERT INTO BE_Resultaat(BE_Deelname_ID, Deelnemer, RouteD204, Tijd, Rang) VALUES(" +
                    "(SELECT BE_Deelname_ID FROM BE_Deelname WHERE BE_Deelname_ID = @BE_Deelname_ID), @Deelnemer, @RouteD204, @Tijd, @Rang)"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@BE_Deelname_ID", resultaat.BEResultaatID);
                cmd.Parameters.AddWithValue("@Deelnemer", resultaat.Deelnemer);
                cmd.Parameters.AddWithValue("@RouteD204", resultaat.RouteD204);
                cmd.Parameters.AddWithValue("@Tijd", resultaat.Tijd);
                cmd.Parameters.AddWithValue("@Rang", resultaat.Rang);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    dbresult = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return dbresult; // Aantal rijen aangepast in de tabel
        }

        public int UpdateFE(FEResultaatBO resultaat)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier FEResultaat wordt
                //in het data object FEResultaat getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "UPDATE FE_Resultaat SET Deelnemer = @Deelnemer, RouteD204 = @RouteD204, Tijd = @Tijd, Rang = @Rang WHERE FE_Resultaat_ID = @FE_Resultaat_ID"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@FE_Resultaat_ID", resultaat.FEResultaatID);
                cmd.Parameters.AddWithValue("@Deelnemer", resultaat.Deelnemer);
                cmd.Parameters.AddWithValue("@RouteD204", resultaat.RouteD204);
                cmd.Parameters.AddWithValue("@Tijd", resultaat.Tijd);
                cmd.Parameters.AddWithValue("@Rang", resultaat.Rang);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    dbresult = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return dbresult; // Aantal rijen aangepast in de tabel
        }

        public int UpdateBE(BEResultaatBO resultaat)
        {
            int dbresult = 0;

            //Creeër een nieuw SQL Connection Object met de ConnectionString
            using (SqlConnection con = new SqlConnection(connectionString))
            {
                //Alle data uit het Windows Forms formulier BEResultaat wordt
                //in het data object BEResultaat getransporteerd via de Business Logic Layer
                //naar de Data Access Laag.
                //In de Data Access Laag wordt de connectie met de database verzorgt.

                //Creeër een nieuw SQL Command Object
                SqlCommand cmd = new SqlCommand
                {
                    //vul het SQL commando met relevante informatie
                    Connection = con,                   //De verbinding
                    CommandType = CommandType.Text,      //Type command is Text
                                                         //De SQL query string om een nieuwe deelname in te voeren
                    CommandText = "UPDATE BE_Resultaat SET Deelnemer = @Deelnemer, RouteD204 = @RouteD204, Tijd = @Tijd, Rang = @Rang WHERE BE_Resultaat_ID = @BE_Resultaat_ID"
                };

                //Vul de parameters 
                cmd.Parameters.Clear();                 //Maak de parameterlijst leeg voordat hij gevuld wordt
                cmd.Parameters.AddWithValue("@BE_Resultaat_ID", resultaat.BEResultaatID);
                cmd.Parameters.AddWithValue("@Deelnemer", resultaat.Deelnemer);
                cmd.Parameters.AddWithValue("@RouteD204", resultaat.RouteD204);
                cmd.Parameters.AddWithValue("@Tijd", resultaat.Tijd);
                cmd.Parameters.AddWithValue("@Rang", resultaat.Rang);

                try
                {
                    //Open de Database connectie met de connectie string
                    con.Open();
                    dbresult = cmd.ExecuteNonQuery();     //Voer het commando uit op de database
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return dbresult; // Aantal rijen aangepast in de tabel
        }

        public int DeleteFE(List<int> selectedResultaten)
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
                                CommandText = "DELETE FROM FE_Resultaat WHERE FE_Resultaat_ID = " + selectedResultaten[i]
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

        public int DeleteBE(List<int> selectedResultaten)
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
                                CommandText = "DELETE FROM BE_Resultaat WHERE BE_Resultaat_ID = " + selectedResultaten[i]
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
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM FE_Resultaat", con);
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
                    SqlCommand DeleteAllCommand = new SqlCommand("DELETE FROM BE_Resultaat", con);
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
                    //Alle dat uit het Windows Forms formulier FEResultaat wordt
                    //in het data object FEResultaat gestopt. Dit dataobject geven we via de Business Logic Layer door naar de Data Access Layer
                    //in de Data Access Layer wordt de connectie met de database verzorgt.

                    SqlDataAdapter da = new SqlDataAdapter();   //Creeër een nieuw SqlCommand object

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,                   //De verbinding
                        CommandType = CommandType.Text,     //Type command is Text

                        CommandText = "SELECT * FROM FE_Resultaat"
                    };

                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de BEResultaat tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "FE_Resultaat");
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
                    //Alle dat uit het Windows Forms formulier BEResultaat wordt
                    //in het data object BEResultaat gestopt. Dit dataobject geven we via de Business Logic Layer door naar de Data Access Layer
                    //in de Data Access Layer wordt de connectie met de database verzorgt.

                    SqlDataAdapter da = new SqlDataAdapter();   //Creeër een nieuw SqlCommand object

                    SqlCommand cmd = new SqlCommand()
                    {
                        Connection = con,                   //De verbinding
                        CommandType = CommandType.Text,     //Type command is Text

                        CommandText = "SELECT * FROM BE_Resultaat"
                    };

                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de BEResultaat tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "BE_Resultaat");
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
