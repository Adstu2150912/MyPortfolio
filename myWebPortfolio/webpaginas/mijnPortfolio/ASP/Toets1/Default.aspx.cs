using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
/*
Opdracht:       ASP toets Periode 3 Versie B
Auteur:         <Adam Oubelkas>
Aanmaakdatum:   <3-4-2017 + 13:20>
Bestandsnaam:   <Default.aspx.cs>
 */
public partial class _Default : System.Web.UI.Page
{
    //Als de pagina geladen, kijk dan wat de geselecteerde waarde is van rblInloggen
    protected void Page_Load(object sender, EventArgs e)
    {
        //Als de geselecteerde waarde '1' is, toon Opdracht 1 van deze Toets 
        if(rblInloggen.SelectedValue == "1")
        {
            pnlOpdracht1.Visible = true;
            pnlOpdracht2.Visible = false;
            lblTitel.Text = "<h1>" + "Inloggen bij Network" + "</h1>";
        }
        //Als de geselecteerde waarde '2' is, toon Opdracht 2 van deze Toets 
        else if (rblInloggen.SelectedValue == "2")
        {
            pnlOpdracht1.Visible = false;
            pnlOpdracht2.Visible = true;
            lblTitel.Text = "<h1>" + "Registreren bij Network" + "</h1>";
            lblMelding.Visible = false;
            lblMeldingOpdracht2.Text = "";
        }

    }
    //Als op de button 'Log in' geklikt wordt, kijk dan wat de geselecteerde waarde is van de rblInloggen
    protected void btnLogin_Click(object sender, EventArgs e)
    {
        //Als de geselecteerde waarde '1' is, toon onderstaande melding 
        if (rblInloggen.SelectedValue == "1")
        {
            lblMelding.Text = txtBijnaam.Text + ", je bent succesvol ingelogd!";
            lblMelding.Visible = true;
        }
    }
    //Kijk hier of de checkbox 'cbVoorwaarden' aangevinkt is of niet
    protected void cbVoorwaarden_CheckedChanged(object sender, EventArgs e)
    {
        //Als de checkbox aangevinkt is, maak dan de button 'btnAccountMaken' klikbaar
        if(cbVoorwaarden.Checked == true)
        {
            btnAccountMaken.Enabled = true;

        }
        //Anders, maak de button 'btnAccountMaken' niet klikbaar
        else
        {
            btnAccountMaken.Enabled = false;
        }
    }

    //Achterhaal wat de geselecteerde waarde is van 'rbGeslacht'
    //Bepaal aan de hand daarvan wat voor soort spel er in de melding moet komen te staan
    protected void btnAccountMaken_Click(object sender, EventArgs e)
    {
        string gratisSpel;
        if(rbGeslacht.SelectedValue == "Man")
        {
            gratisSpel = "Men";
        }
        else if(rbGeslacht.SelectedValue == "Vrouw")
        {
            gratisSpel = "Woman";   
        }
        else
        {
            gratisSpel = "Human";
        }
        //Sla huidige datum van de kalender opgeteld met 2 dagen op in string variabel 
        string activeerDatum = DateTime.Today.AddDays(2).ToShortDateString();
        lblMeldingOpdracht2.Text = txtVoornaam.Text + ", gefeliciteerd! Het account met e-mailadres " + txtEmailadres.Text + " is succesvol aangemaakt." + "Vanwege de huidige drukte wordt dit account geactiveerd op: " + activeerDatum + ". Om u tegemoet te komen krijgt u van ons het volgende spel gratis: The " + gratisSpel + ". Met vriendelijke groet, @Network Team";
    }
}