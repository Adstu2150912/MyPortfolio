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
        string gekozenAchtbaan = ddlAchtbaan.SelectedValue;
        string connectieString;
        connectieString = @"Data Source=DESKTOP-5V08EHN\SQLEXPRESS2;";
        connectieString += "Initial Catalog=achtbanen; Integrated Security=True";
        SqlConnection connectie = new SqlConnection(connectieString);
        SqlCommand cmdAchtbaan = new SqlCommand("SELECT TOP 1 naam FROM achtbaan ORDER BY '" + gekozenAchtbaan + "' DESC;" , connectie);
        connectie.Open();
        string geselecteerdeAchtbaan = Convert.ToString(cmdAchtbaan.ExecuteScalar());
        connectie.Close();
        switch (gekozenAchtbaan)
        {
            case "":
                {
                    lblAchtbaan.Text = geselecteerdeAchtbaan;
                    break;
                }
        }
       
    }
}