/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     BEResultaat.cs

Omschrijving:    Presentation Layer Backend Resultaat(en) Vestingloop

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
    public partial class BEResultaat : Form
    {
        //Initialisatie: lijst voor alle gewenste routes
        List<string> RouteD204 = new List<string>() {"5km", "10km", "15km"};

        //constructor
        public BEResultaat()
        {
            InitializeComponent();
        }

        //Implementatie: methoden en events

        // Koppel de listView's veldmaten aan dezelfde waarde
        private void SetListViewColumnSizes(ListView lvw, int width)
        {
            foreach (ColumnHeader col in lvw.Columns)
                col.Width = width;
        }

        // Zorg ervoor dat de gegevens in de Listview passen
        // zodanig dat alles zichtbaar wordt
        private void SizeForm()
        {
            // Voeg de kolombreedtes toe
            int wid = 0;
            foreach (ColumnHeader col in lvBEResultaat.Columns)
            {
                wid += col.Width;
            }
        }

        private void BEResultaat_Load(object sender, EventArgs e)
        {
            BEResultaatBL resultaatBL = new BEResultaatBL();
            cbRoute.DataSource = RouteD204;

            try
            {
                lvBEResultaat.Items.Clear();
                lvBEResultaat.Columns.Clear();
                lvBEResultaat.Columns.Add(new ColumnHeader());
                if (RbSelectFEResultaat.Checked == true)
                {
                    lvBEResultaat.Columns[0].Text = "FE_Resultaat_ID";
                }
                else if (RbSelectBEResultaat.Checked == true)
                {
                    lvBEResultaat.Columns[0].Text = "BE_Resultaat_ID";
                }

                lvBEResultaat.Columns[0].Width = 0;
                lvBEResultaat.Columns.Add(new ColumnHeader());
                lvBEResultaat.Columns[1].Text = "Deelnemer";
                lvBEResultaat.Columns.Add(new ColumnHeader());
                lvBEResultaat.Columns[2].Text = "Route";
                lvBEResultaat.Columns.Add(new ColumnHeader());
                lvBEResultaat.Columns[3].Text = "Tijd";
                lvBEResultaat.Columns.Add(new ColumnHeader());
                lvBEResultaat.Columns[4].Text = "Rang";

                DataSet dsResultaat = resultaatBL.ReadFE();

                //lus door alle rijen van de tabel
                for (int i = 0; i < dsResultaat.Tables[0].Rows.Count; i++)
                {
                    DataRow rowDeelname = dsResultaat.Tables[0].Rows[i];

                    if (rowDeelname.RowState != DataRowState.Deleted)
                    {
                        ListViewItem lvItem = new ListViewItem();
                        if (RbSelectFEResultaat.Checked == true)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            lvItem.Text = rowDeelname["FE_Resultaat_ID"].ToString();
                        }
                        else if (RbSelectBEResultaat.Checked == true)
                        {
                            lvItem.Text = rowDeelname["BE_Resultaat_ID"].ToString();
                        }
                        lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                        lvItem.SubItems.Add(rowDeelname["RouteD204"].ToString());
                        lvItem.SubItems.Add(rowDeelname["Tijd"].ToString());
                        lvItem.SubItems.Add(rowDeelname["Rang"].ToString());
                        // Voeg de nieuwe listitems toe aan de listview
                        lvBEResultaat.Items.Add(lvItem);
                    }
                }

                lbResultaatID.Text = lvBEResultaat.Items[0].Text;
                tbDeelnemer.Text = lvBEResultaat.Items[0].SubItems[1].Text;
                cbRoute.Text = lvBEResultaat.Items[0].SubItems[2].Text;
                tbTijd.Text = lvBEResultaat.Items[0].SubItems[3].Text;
                tbRang.Text = lvBEResultaat.Items[0].SubItems[4].Text;

                // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                SetListViewColumnSizes(lvBEResultaat, -1);
                SizeForm();

            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void RbSelectFEResultaat_CheckedChanged(object sender, EventArgs e)
        {
            if (RbSelectFEResultaat.Checked == true)
            {
                BEResultaatBL resultaatBL = new BEResultaatBL();

                try
                {
                    lvBEResultaat.Items.Clear();
                    lvBEResultaat.Columns.Clear();
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[0].Text = "FE_Resultaat_ID";
                    lvBEResultaat.Columns[0].Width = 0;
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[1].Text = "Deelnemer";
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[2].Text = "Route";
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[3].Text = "Tijd";
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[4].Text = "Rang";

                    DataSet dsResultaat = resultaatBL.ReadFE();

                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsResultaat.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowDeelname = dsResultaat.Tables[0].Rows[i];

                        if (rowDeelname.RowState != DataRowState.Deleted)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            ListViewItem lvItem = new ListViewItem()
                            {
                                Text = rowDeelname["FE_Resultaat_ID"].ToString()
                            };
                            lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                            lvItem.SubItems.Add(rowDeelname["RouteD204"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Tijd"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Rang"].ToString());
                            // Voeg de nieuwe listitems toe aan de listview
                            lvBEResultaat.Items.Add(lvItem);
                        }
                    }

                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvBEResultaat, -1);
                    SizeForm();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Foutmelding:\n" + ex.Message);
                }
            }
        }

        private void RbSelectBEResultaat_CheckedChanged(object sender, EventArgs e)
        {
            if (RbSelectBEResultaat.Checked == true)
            {
                BEResultaatBL resultaatBL = new BEResultaatBL();

                try
                {
                    lvBEResultaat.Items.Clear();
                    lvBEResultaat.Columns.Clear();
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[0].Text = "BE_Resultaat_ID";
                    lvBEResultaat.Columns[0].Width = 0;
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[1].Text = "Deelnemer";
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[2].Text = "Route";
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[3].Text = "Tijd";
                    lvBEResultaat.Columns.Add(new ColumnHeader());
                    lvBEResultaat.Columns[4].Text = "Rang";

                    DataSet dsResultaat = resultaatBL.ReadBE();

                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsResultaat.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowDeelname = dsResultaat.Tables[0].Rows[i];

                        if (rowDeelname.RowState != DataRowState.Deleted)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            ListViewItem lvItem = new ListViewItem()
                            {
                                Text = rowDeelname["BE_Resultaat_ID"].ToString()
                            };
                            lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                            lvItem.SubItems.Add(rowDeelname["RouteD204"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Tijd"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Rang"].ToString());
                            // Voeg de nieuwe listitems toe aan de listview
                            lvBEResultaat.Items.Add(lvItem);
                        }
                    }

                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvBEResultaat, -1);
                    SizeForm();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Foutmelding:\n" + ex.Message);
                }
            }
        }

        private void InvoerenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (lvBEResultaat.SelectedItems.Count > 0)
            {
                lbResultaatID.Text = lvBEResultaat.SelectedItems[0].Text;
                tbDeelnemer.Text = lvBEResultaat.SelectedItems[0].SubItems[1].Text;
                cbRoute.Text = lvBEResultaat.SelectedItems[0].SubItems[2].Text;
                tbTijd.Text = lvBEResultaat.SelectedItems[0].SubItems[3].Text;
                tbRang.Text = lvBEResultaat.SelectedItems[0].SubItems[4].Text;
                btnSelectieUitvoer.Enabled = true;
            }

            btnSelectieUitvoer.Text = "Invoeren";
        }

        private void BewerkenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (lvBEResultaat.SelectedItems.Count > 0)
            {
                lbResultaatID.Text = lvBEResultaat.SelectedItems[0].Text;
                tbDeelnemer.Text = lvBEResultaat.SelectedItems[0].SubItems[1].Text;
                cbRoute.Text = lvBEResultaat.SelectedItems[0].SubItems[2].Text;
                tbTijd.Text = lvBEResultaat.SelectedItems[0].SubItems[3].Text;
                tbRang.Text = lvBEResultaat.SelectedItems[0].SubItems[4].Text;
                btnSelectieUitvoer.Enabled = true;
            }

            btnSelectieUitvoer.Text = "Bewerken";
        }

        private void VerwijderenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (lvBEResultaat.SelectedItems.Count > 0)
            {
                lbResultaatID.Text = lvBEResultaat.SelectedItems[0].Text;
                tbDeelnemer.Text = lvBEResultaat.SelectedItems[0].SubItems[1].Text;
                cbRoute.Text = lvBEResultaat.SelectedItems[0].SubItems[2].Text;
                tbTijd.Text = lvBEResultaat.SelectedItems[0].SubItems[3].Text;
                tbRang.Text = lvBEResultaat.SelectedItems[0].SubItems[4].Text;
                btnSelectieUitvoer.Enabled = true;
            }

            btnSelectieUitvoer.Text = "Verwijderen";
        }

        private void BtnSelectieUitvoer_Click(object sender, EventArgs e)
        {
            BEResultaatBL resultaatBL = new BEResultaatBL();
            try
            {
                switch (btnSelectieUitvoer.Text)
                {
                    case "Invoeren":
                        if (RbSelectFEResultaat.Checked == true)
                        {
                            FEResultaatBO resultaatBO = new FEResultaatBO
                            {
                                FEResultaatID = int.Parse(lbResultaatID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                RouteD204 = cbRoute.SelectedValue.ToString(),
                                Tijd = tbTijd.Text,
                                Rang = int.Parse(tbRang.Text),
                            };
                            resultaatBL.CreateFE(resultaatBO);
                        }
                        else if (RbSelectBEResultaat.Checked == true)
                        {
                            BEResultaatBO resultaatBO = new BEResultaatBO
                            {
                                BEResultaatID = int.Parse(lbResultaatID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                RouteD204 = cbRoute.SelectedValue.ToString(),
                                Tijd = tbTijd.Text,
                                Rang = int.Parse(tbRang.Text)
                            };
                            resultaatBL.CreateBE(resultaatBO);
                        }
                        break;
                    case "Bewerken":
                        if (RbSelectFEResultaat.Checked == true)
                        {
                            FEResultaatBO resultaatBO = new FEResultaatBO
                            {
                                FEResultaatID = int.Parse(lbResultaatID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                RouteD204 = cbRoute.SelectedValue.ToString(),
                                Tijd = tbTijd.Text,
                                Rang = int.Parse(tbRang.Text)
                            };
                            resultaatBL.UpdateFE(resultaatBO);
                        }
                        else if (RbSelectBEResultaat.Checked == true)
                        {
                            BEResultaatBO resultaatBO = new BEResultaatBO
                            {
                                BEResultaatID = int.Parse(lbResultaatID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                RouteD204 = cbRoute.SelectedValue.ToString(),
                                Tijd = tbTijd.Text,
                                Rang = int.Parse(tbRang.Text)
                            };
                            resultaatBL.UpdateBE(resultaatBO);
                        }
                        break;
                    case "Verwijderen":
                        //Gebruik onderstaande List om meerdere selecties voor verwijdering op te slaan
                        List<int> selectedResultaten = new List<int>();
                        if (RbSelectFEResultaat.Checked == true)
                        {
                            for (int i = 0; i < lvBEResultaat.SelectedItems.Count; i++)
                            {
                                selectedResultaten.Add(int.Parse(lvBEResultaat.SelectedItems[0].Text));
                            }
                            resultaatBL.DeleteFE(selectedResultaten);
                        }
                        else if (RbSelectBEResultaat.Checked == true)
                        {
                            for (int i = 0; i < lvBEResultaat.SelectedItems.Count; i++)
                            {
                                selectedResultaten.Add(int.Parse(lvBEResultaat.SelectedItems[0].Text));
                            }
                            resultaatBL.DeleteBE(selectedResultaten);
                        }
                        break;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }
    }
}
