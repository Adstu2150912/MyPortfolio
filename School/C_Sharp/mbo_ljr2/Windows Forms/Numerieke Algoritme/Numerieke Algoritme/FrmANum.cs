/************************** Module Header *******************************\
Project:         Numerieke algoritme
Auteur:          Adam Oubelkas
Aanmaakdatum:    3 juni 2018
Module naam:     FrmANum.cs

Omschrijving:    getal verdelen over numerieke array(s) door een algoritme.

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
using System.Diagnostics;

namespace Numerieke_Algoritme
{
    public partial class FrmANum : Form
    {
        List<string> Alfabet = new List<string>()
        { "A", "B", "C", "D", "E", "F", "G",
        "H", "I", "J" , "K", "L", "M", "N",
        "O", "P", "Q", "R", "S", "T", "U",
        "V", "W", "X", "Y", "Z"};

        private string ArrayNaam = "";

        private static Random rand = new Random(DateTime.Now.Second);
        private int uRandomNumber = rand.Next(1, 27);

        public FrmANum()
        {
            InitializeComponent();
        }

        // Koppel de listView's veldmaten aan dezelfde waarde
        private void SetListViewColumnSizes(ListView lvw, int width)
        {
            foreach (ColumnHeader col in lvw.Columns)
                col.Width = width;
        }

        // Zorg ervoor dat de gegevens in de Listview passen
        // en pas de vorm zodanig aan dat alles zichtbaar wordt
        private void SizeForm()
        {
            // Voeg de kolombreedtes toe
            int wid = 0;
            foreach (ColumnHeader col in lvNumArrays.Columns)
            {
                wid += col.Width;
            }

            // Pas de ListView en vorm aan
            lvNumArrays.Width = wid + 5;
            this.ClientSize = new Size(
                lvNumArrays.Right + lvNumArrays.Left,
                this.ClientSize.Height
            );
        }

        private void afsluitenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnInvoeren_Click(object sender, EventArgs e)
        {
            try
            {
                lvNumArrays.Items.Clear();
                decimal.TryParse(txtGetal.Text, out decimal invoerGetal);
                int i = 0;
                List<int> Getallen = new List<int>();
                ListViewItem lviGetallen = new ListViewItem() {};
                Stopwatch stopWatch = new Stopwatch();

                stopWatch.Start();
                while (i < invoerGetal)
                {
                    i++;
                    Getallen.Add(i);

                    if(Getallen[Getallen.Count - 1] >= 2 && (uRandomNumber++) % i == 0 && rbVoorkeur1.Checked)
                    {
                        if (lvNumArrays.Items.Count > 0 && !ckbVoorkeur3.Checked)
                        {
                            for (int ii = 0; ii < lvNumArrays.Items.Count; ii++)
                            {
                                if (lvNumArrays.Items[ii].Text.Contains(ArrayNaam))
                                {
                                    ArrayNaam = "Array " + (lvNumArrays.Items.Count + 1);
                                }
                            }
                        }

                        else if (lvNumArrays.Items.Count > 0)
                        {
                            for (int ii = 0; ii < lvNumArrays.Items.Count; ii++)
                            {
                                if (lvNumArrays.Items[ii].Text.Contains(ArrayNaam))
                                {
                                    uRandomNumber = rand.Next(0, (Alfabet.Count));
                                    ArrayNaam = Alfabet[uRandomNumber].ToString() + (uRandomNumber / i);
                                }
                            }
                        }

                        else
                        {
                            if (!ckbVoorkeur3.Checked)
                            {
                                ArrayNaam = "Array " + (lvNumArrays.Items.Count + 1);
                            }
                            else
                            {
                                uRandomNumber = rand.Next(0, 26);
                                ArrayNaam = Alfabet[uRandomNumber].ToString() + (uRandomNumber / i);
                            }
                        }

                        lviGetallen.Text = ArrayNaam;
                        lviGetallen.SubItems.Add(Getallen[0].ToString() + " t/m " + Getallen[(Getallen.Count - 2)].ToString());
                        lviGetallen.SubItems.Add((Getallen.Count - 1).ToString());
                        lvNumArrays.Items.Add(lviGetallen);

                        SetListViewColumnSizes(lvNumArrays, -1);
                        SizeForm();
                        Getallen = new List<int>() { Getallen[Getallen.Count - 1] };
                        lviGetallen = new ListViewItem() { };
                    }

                    else if ((Getallen[Getallen.Count - 1] / Getallen[0]) >= 2 && rbVoorkeur2.Checked)
                    {
                        if (lvNumArrays.Items.Count > 0 && !ckbVoorkeur3.Checked)
                        {
                            for (int ii = 0; ii < lvNumArrays.Items.Count; ii++)
                            {
                                if (lvNumArrays.Items[ii].Text.Contains(ArrayNaam))
                                {
                                    ArrayNaam = "Array " + (lvNumArrays.Items.Count + 1);
                                }
                            }
                        }

                        else if (lvNumArrays.Items.Count > 0)
                        {
                            for (int ii = 0; ii < lvNumArrays.Items.Count; ii++)
                            {
                                if (lvNumArrays.Items[ii].Text.Contains(ArrayNaam))
                                {
                                    uRandomNumber = rand.Next(0, (Alfabet.Count));
                                    ArrayNaam = Alfabet[uRandomNumber].ToString() + (uRandomNumber / i);
                                }
                            }
                        }

                        else
                        {
                            if (!ckbVoorkeur3.Checked)
                            {
                                ArrayNaam = "Array " + (lvNumArrays.Items.Count + 1);
                            }
                            else
                            {
                                uRandomNumber = rand.Next(0, (Alfabet.Count));
                                ArrayNaam = Alfabet[uRandomNumber].ToString() + (uRandomNumber / i);
                            }
                        }

                        lviGetallen.Text = ArrayNaam;
                        lviGetallen.SubItems.Add(Getallen[0].ToString() + " t/m " + Getallen[(Getallen.Count - 2)].ToString());
                        lviGetallen.SubItems.Add((Getallen.Count - 1).ToString());
                        lvNumArrays.Items.Add(lviGetallen);

                        SetListViewColumnSizes(lvNumArrays, -1);
                        SizeForm();

                        Getallen = new List<int>() { Getallen[Getallen.Count - 1] };
                        lviGetallen = new ListViewItem() { };
                    }
                }

                if (i == invoerGetal)
                {
                    if (lvNumArrays.Items.Count > 0 && !ckbVoorkeur3.Checked)
                    {
                        for (int ii = 0; ii < lvNumArrays.Items.Count; ii++)
                        {
                            if (lvNumArrays.Items[ii].Text.Contains(ArrayNaam))
                            {
                                ArrayNaam = "Array " + (lvNumArrays.Items.Count + 1);
                            }
                        }
                    }

                    else if (lvNumArrays.Items.Count > 0)
                    {
                        for (int ii = 0; ii < lvNumArrays.Items.Count; ii++)
                        {
                            if (lvNumArrays.Items[ii].Text.Contains(ArrayNaam))
                            {
                                uRandomNumber = rand.Next(0, (Alfabet.Count));
                                ArrayNaam = Alfabet[uRandomNumber].ToString() + (uRandomNumber / i);
                            }
                        }
                    }

                    else
                    {
                        if (!ckbVoorkeur3.Checked)
                        {
                            uRandomNumber = rand.Next(0, (Alfabet.Count));
                            ArrayNaam = "Array " + (lvNumArrays.Items.Count + 1);
                        }
                        else
                        {
                            uRandomNumber = rand.Next(0, (Alfabet.Count));
                            ArrayNaam = Alfabet[uRandomNumber].ToString() + (uRandomNumber / i);
                        }
                    }

                    lviGetallen.Text = ArrayNaam;
                    lviGetallen.SubItems.Add(Getallen[0].ToString() + " t/m " + Getallen[(Getallen.Count - 1)].ToString());
                    lviGetallen.SubItems.Add((Getallen.Count).ToString());
                    lvNumArrays.Items.Add(lviGetallen);

                    SetListViewColumnSizes(lvNumArrays, -1);
                    SizeForm();

                    lblTotalRows.Text = "Totaal aantal rijen: " + lvNumArrays.Items.Count;
                    lblTotalRows.Visible = true;
                }

                stopWatch.Stop();
                //Pak de looptijd als een TimeSpan waarde
                TimeSpan ts = stopWatch.Elapsed;

                //Formateer en weergeef de TimeSpan waarde
                string Looptijd = String.Format("{0:00}:{1:00}:{2:00}.{3:00}",
                ts.Hours, ts.Minutes, ts.Seconds,
                ts.Milliseconds / 10);

                lblLoopTijd.Text = "Looptijd in h-m-s-ms: " + Looptijd;
                lblLoopTijd.Visible = true;
            }
            catch(Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }
    }
}
