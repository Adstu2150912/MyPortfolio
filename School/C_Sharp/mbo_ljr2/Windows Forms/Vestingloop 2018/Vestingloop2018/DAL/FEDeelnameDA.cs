/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     FEDeelnameDA.cs

Omschrijving:    Data Access Layer Frontend Deelname(s) Vestingloop

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
    public class FEDeelnameDA
    {
        //Bewaar de SQL verbinding waarin de deelnamegegevens worden opgeslagen
        string connectionString = ConfigurationManager.ConnectionStrings["MyConnectionString"].ConnectionString;

        //constructor
        public FEDeelnameDA()
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

        public DataSet Group(List<string> groepDeelname)
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

                        CommandText = "SELECT FE_Deelname_ID",
                    };

                    for (int i = 0; i < groepDeelname.Count; i++)
                    {
                        cmd.CommandText += ", " + groepDeelname[i];
                    }

                    cmd.CommandText += " FROM FE_Deelname;";
                    con.Open();
                    da.SelectCommand = cmd;

                    //Vul de DataSet ds met de FE_Deelname tabel uit de Vestingloop 2018 database
                    da.Fill(ds, "FE_Deelname");
                }
                catch (SqlException ex)
                {
                    MessageBox.Show("SQL Foutmelding:\n" + ex.Message);
                }
                con.Close();
            }
            return ds;
        }

        public DataSet Sort(ListView.ColumnHeaderCollection selectedColumns, List<string> filterDeelname)
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
                        CommandText = "SELECT " + selectedColumns[0].Text,
                    };

                    for (int i = 1; i < selectedColumns.Count; i++)
                    {
                        cmd.CommandText += ", " + selectedColumns[i].Text; 
                    }

                    cmd.CommandText += " FROM FE_Deelname ORDER BY " + filterDeelname[0];

                    for (int i = 1; i < filterDeelname.Count; i++)
                    {
                        cmd.CommandText += ", " + filterDeelname[i];
                    }

                    cmd.CommandText += ";";
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
    }
}
