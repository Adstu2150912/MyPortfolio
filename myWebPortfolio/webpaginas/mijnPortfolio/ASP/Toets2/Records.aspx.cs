using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    
    protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
    {
        string achtbaanFilter = ddlAchtbaan.SelectedValue;
        string connectieString;
        string geselecteerdeAchtbaan;
        string strSqlCommand = "";

        if (achtbaanFilter != "selecteer")
        {
            switch (achtbaanFilter)
            {
                case "hoogste":
                {
                    strSqlCommand = "SELECT TOP 1 naam FROM achtbaan ORDER BY hoogte DESC;";
                    break;
                }
                case "snelste":
                {
                    strSqlCommand = "SELECT TOP 1 naam FROM achtbaan ORDER BY snelheid DESC;";
                    break;
                }
                case "langste":
                {
                    strSqlCommand = "SELECT TOP 1 naam FROM achtbaan ORDER BY lengte DESC;";
                    break;
                }
            }

            connectieString = @"Data Source=DESKTOP-70HOQ1P;";
            connectieString += "Initial Catalog=achtbanen; Integrated Security=True";
            SqlConnection connectie = new SqlConnection(connectieString);
            SqlCommand cmdAchtbaan = new SqlCommand(strSqlCommand, connectie);
            connectie.Open();
            geselecteerdeAchtbaan = Convert.ToString(cmdAchtbaan.ExecuteScalar());
            connectie.Close();
            lblAchtbaan.Text = geselecteerdeAchtbaan;
        }
    }
}