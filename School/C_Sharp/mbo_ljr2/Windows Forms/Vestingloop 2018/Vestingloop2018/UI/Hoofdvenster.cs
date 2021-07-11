/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     Hoofdvenster.cs

Omschrijving:    Hoofdprogramma Vestingloop

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

namespace Vestingloop2018
{
    public partial class Hoofdvenster : Form
    {
        //constructor
        public Hoofdvenster()
        {
            InitializeComponent();
        }

        private void AfsluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void FEDeelnameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Frontend Deelname")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if (found == false)
            {
                FEDeelname a = new FEDeelname
                {
                    MdiParent = this
                };
                a.Show();
            }
        }

        private void AlleFrontendVenstersAfsluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text.Substring(0, 8) == "Frontend")
                {
                    x.Close();
                }
            }
        }

        private void FEResultaatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Frontend Resultaat")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if (found == false)
            {
                FEResultaat a = new FEResultaat
                {
                    MdiParent = this
                };
                a.Show();
            }
        }

        private void BEDeelnameToolStripMenuItem_Click(object sender, EventArgs e)
        {

            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Backend Deelname")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if (found == false)
            {
                BEDeelname a = new BEDeelname
                {
                    MdiParent = this
                };
                a.Show();
            }

        }

        private void BEResultaatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool found = false;
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text == "Backend Resultaat")
                {
                    x.Activate();
                    found = true;
                    break;
                }
            }
            if (found == false)
            {
                BEResultaat a = new BEResultaat
                {
                    MdiParent = this
                };
                a.Show();
            }
        }

        private void AlleBackendVenstersAfsluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            foreach (Form x in this.MdiChildren)
            {
                if (x.Text.Substring(0, 7) == "Backend")
                {
                    x.Close();
                }
            }
        }
    }
}
