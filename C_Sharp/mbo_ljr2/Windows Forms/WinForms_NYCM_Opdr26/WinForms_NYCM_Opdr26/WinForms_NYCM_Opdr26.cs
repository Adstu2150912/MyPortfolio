/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     WinForms_NYCM_Opdr26.cs

Omschrijving:    Hoofdprogramma Taak NYCM

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

namespace WinForms_NYCM_Opdr26
{
    public partial class WinForms_NYCM_Opdr26 : Form
    {
        private DeelnemerBOL deelnemer;

        public WinForms_NYCM_Opdr26()
        {
            InitializeComponent();
            deelnemer = new DeelnemerBOL();
        }

        private void afsluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void alleVenstersAfsluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            foreach(Form x in this.MdiChildren)
            {
                x.Close();
            }
        }

        private void deelnemerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Deelnemer")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if (found == false)
            {
                FrmDeelnemer d = new FrmDeelnemer(deelnemer);
                d.MdiParent = this;
                d.Show();
            }
        }

        private void registratieToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Registratie")
                {
                    x.Activate();
                    found = true;
                    if (deelnemer.ChipNummerH201 > 0)
                    {
                        x.Show();
                    }
                    else
                    {
                        MessageBox.Show("Foutmelding:\nHet formulier voor deelnemers is niet volledig ingevuld en ingevoerd");
                    }
                    break;
                }
            }
            if (found == false)
            {
                FrmRegistratie r = new FrmRegistratie();
                r.MdiParent = this;
                if (deelnemer.ChipNummerH201 > 0)
                {
                    r.Show();
                }
                else
                {
                    MessageBox.Show("Foutmelding:\nHet formulier voor deelnemers is niet volledig ingevuld");
                }
            }
        }
    }
}
