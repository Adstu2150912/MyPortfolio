/************************** Module Header *******************************\
Project:         H25 - Windows Forms Dominos
Auteur:          Adam Oubelkas
Aanmaakdatum:    2 mei 2018
Module naam:     WinForms_Dominos_Opdr25.cs

Omschrijving:    Hoofdprogramma Taak Domino's

\************************************************************************/
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Dominos_Pizza
{
    public partial class WinForms_Dominos_Opdr25 : Form
    {
        public List<PizzaNaam> PizzaNaam;
        private List<Bestelling> Bestelling;
        private List<Bezorging> Bezorging;

        public WinForms_Dominos_Opdr25()
        {
            InitializeComponent();
            PizzaNaam = new List<PizzaNaam>();
            Bestelling = new List<Bestelling>();
            Bezorging = new List<Bezorging>();
        }

        private void afsluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void pizzanaamToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach(Form x in this.MdiChildren)
            {
                if(x.Text == "Pizza")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if(found == false)
            {
                FrmPizzaNaam p = new FrmPizzaNaam(PizzaNaam);
                p.MdiParent = this;
                p.Show();
            }
        }


        private void bestellingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Bestelling")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if (found == false && PizzaNaam.Count != 0)
            {
                FrmBestelling b = new FrmBestelling(PizzaNaam, Bestelling);
                b.MdiParent = this;
                b.Show();
            }

            if(PizzaNaam.Count == 0)
            {
                MessageBox.Show("Foutmelding:\nU heeft het formulier \"Pizza\" niet volledig ingevuld\nProbeer het opnieuw");
            }
        }

        private void bezorgingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Bezorging")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if (found == false && Bestelling.Count != 0)
            {
                FrmBezorging b = new FrmBezorging(Bestelling, Bezorging);
                b.MdiParent = this;
                b.Show();
            }
            
            if(Bestelling.Count == 0)
            {
                MessageBox.Show("Foutmelding:\nU heeft het formulier \"Bestelling\" niet volledig ingevuld\nProbeer het opnieuw");
            }
        }

        private void alleVenstersSluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            foreach(Form x in this.MdiChildren)
            {
                x.Close();
            }
        }

    }
}
