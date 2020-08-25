/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     FEResultaatDA.cs

Omschrijving:    Data Access Layer Frontend Resultaat(en) Vestingloop

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;              //Voor de klasse DataSet, Datatable en SQL
using System.Data.SqlClient;    //Voor SQL
using System.Configuration;     //Voor het uitlezen van de Web.config
using System.Windows.Forms;     //Voor het tonen van (fout)meldingen en gebruik van kolommen uit listview

namespace Vestingloop2018
{
    public class FEResultaatDA
    {
        //Bewaar de SQL verbinding waarin de resultaatgegevens worden opgeslagen
        string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public FEResultaatDA()
        {

        }

        //Implementatie: methodes

        public DataSet Read()
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

                    //Vul de DataSet ds met de FE_Deelname tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "FE_Resultaat");
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
            }
            return ds;
        }

        public DataSet Group(List<string> groepResultaat)
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
                        CommandText = "SELECT FE_Resultaat_ID",
                    };

                    for (int i = 0; i < groepResultaat.Count; i++)
                    {
                        if(groepResultaat[i] == "Route")
                        {
                            cmd.CommandText += ", " + groepResultaat[i] + "D204";
                        }
                        else
                        {
                            cmd.CommandText += ", " + groepResultaat[i];
                        }
                    }

                    cmd.CommandText += " FROM FE_Resultaat;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de FE_Resultaat tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "FE_Resultaat");
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(ListView.ColumnHeaderCollection selectedColumns, List<string> filterResultaat)
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
                        CommandText = "SELECT " + selectedColumns[0].Text
                    };

                    for (int i = 1; i < selectedColumns.Count; i++)
                    {
                        if (selectedColumns[i].Text == "Route")
                        {
                            cmd.CommandText += ", RouteD204";
                        }
                        else
                        {
                            cmd.CommandText += ", " + selectedColumns[i].Text;
                        }
                    }


                    if (filterResultaat[0] == "Route")
                    {
                        //Pak alleen cijfers uit een string zodat records op numerieke waarde gesorteerd kunnen worden
                        cmd.CommandText += " FROM FE_Resultaat ORDER BY CAST(PATINDEX('%[^0-9]%', " + filterResultaat[0] + "D204) AS INT)";
                    }
                    else
                    {
                        cmd.CommandText += " FROM FE_Resultaat ORDER BY " + filterResultaat[0];
                    }

                    for (int i = 1; i < filterResultaat.Count; i++)
                    {
                        if(filterResultaat[i] == "Route")
                        {
                            //Pak alleen cijfers uit een string zodat records op numerieke waarde gesorteerd kunnen worden
                            cmd.CommandText += ", CAST(PATINDEX('%[^0-9]%', " + filterResultaat[i] + "D204) AS INT)";
                        }
                        else
                        {
                            cmd.CommandText += ", " + filterResultaat[i];
                        }
                    }

                    cmd.CommandText += ";";
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de FE_Deelname tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "FE_Resultaat");
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
