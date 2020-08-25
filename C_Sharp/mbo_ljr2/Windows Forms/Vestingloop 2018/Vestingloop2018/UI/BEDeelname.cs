/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     BEDeelname.cs

Omschrijving:    Presentation Layer Backend Deelname(s) Vestingloop

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
    public partial class BEDeelname : Form
    {
        //constructor
        public BEDeelname()
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
            foreach (ColumnHeader col in lvBEDeelname.Columns)
            {
                wid += col.Width;
            }
        }

        private void RbSelectFEDeelname_CheckedChanged(object sender, EventArgs e)
        {
            if(RbSelectFEDeelname.Checked == true)
            {
                BEDeelnameBL deelnameBL = new BEDeelnameBL();

                try
                {
                    lvBEDeelname.Items.Clear();
                    lvBEDeelname.Columns.Clear();
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[0].Text = "FE_Deelname_ID";
                    lvBEDeelname.Columns[0].Width = 0;
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[1].Text = "Deelnemer";
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[2].Text = "Afkomst";
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[3].Text = "Leeftijd";

                    DataSet dsDeelname = deelnameBL.ReadFE();

                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsDeelname.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowDeelname = dsDeelname.Tables[0].Rows[i];

                        if (rowDeelname.RowState != DataRowState.Deleted)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            ListViewItem lvItem = new ListViewItem()
                            {
                                Text = rowDeelname["FE_Deelname_ID"].ToString()
                            };
                            lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Afkomst"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Leeftijd"].ToString());
                            // Voeg de nieuwe listitems toe aan de listview
                            lvBEDeelname.Items.Add(lvItem);
                        }
                    }

                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvBEDeelname, -1);
                    SizeForm();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Foutmelding:\n" + ex.Message);
                }
            }
        }

        private void RbSelectBEDeelname_CheckedChanged(object sender, EventArgs e)
        {
            if (RbSelectBEDeelname.Checked == true)
            {
                BEDeelnameBL deelnameBL = new BEDeelnameBL();

                try
                {
                    lvBEDeelname.Items.Clear();
                    lvBEDeelname.Columns.Clear();
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[0].Text = "BE_Deelname_ID";
                    lvBEDeelname.Columns[0].Width = 0;
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[1].Text = "Deelnemer";
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[2].Text = "Afkomst";
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[3].Text = "Leeftijd";

                    DataSet dsDeelname = deelnameBL.ReadBE();

                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsDeelname.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowDeelname = dsDeelname.Tables[0].Rows[i];

                        if (rowDeelname.RowState != DataRowState.Deleted)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            ListViewItem lvItem = new ListViewItem()
                            {
                                Text = rowDeelname["BE_Deelname_ID"].ToString()
                            };
                            lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Afkomst"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Leeftijd"].ToString());
                            // Voeg de nieuwe listitems toe aan de listview
                            lvBEDeelname.Items.Add(lvItem);
                        }
                    }

                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvBEDeelname, -1);
                    SizeForm();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Foutmelding:\n" + ex.Message);
                }
            }
        }

        private void BtnSelectieUitvoer_Click(object sender, EventArgs e)
        {
            BEDeelnameBL deelnameBL = new BEDeelnameBL();
            try
            {
                switch (btnSelectieUitvoer.Text)
                {
                    case "Invoeren":
                        if (RbSelectFEDeelname.Checked == true)
                        {
                            FEDeelnameBO deelnameBO = new FEDeelnameBO
                            {
                                FEDeelnameID = int.Parse(lbDeelnameID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                Afkomst = tbAfkomst.Text,
                                Leeftijd = int.Parse(tbLeeftijd.Text)
                            };
                            deelnameBL.CreateFE(deelnameBO);
                            this.Refresh();
                        }
                        else if (RbSelectBEDeelname.Checked == true)
                        {
                            BEDeelnameBO deelnameBO = new BEDeelnameBO
                            {
                                BEDeelnameID = int.Parse(lbDeelnameID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                Afkomst = tbAfkomst.Text,
                                Leeftijd = int.Parse(tbLeeftijd.Text)
                            };
                            deelnameBL.CreateBE(deelnameBO);
                            this.Refresh();
                        }
                        break;
                    case "Bewerken":
                        if (RbSelectFEDeelname.Checked == true)
                        {
                            FEDeelnameBO deelnameBO = new FEDeelnameBO
                            {
                                FEDeelnameID = int.Parse(lbDeelnameID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                Afkomst = tbAfkomst.Text,
                                Leeftijd = int.Parse(tbLeeftijd.Text)
                            };
                            deelnameBL.UpdateFE(deelnameBO);
                            this.Refresh();
                        }
                        else if (RbSelectBEDeelname.Checked == true)
                        {
                            BEDeelnameBO deelnameBO = new BEDeelnameBO
                            {
                                BEDeelnameID = int.Parse(lbDeelnameID.Text),
                                Deelnemer = tbDeelnemer.Text,
                                Afkomst = tbAfkomst.Text,
                                Leeftijd = int.Parse(tbLeeftijd.Text)
                            };
                            deelnameBL.UpdateBE(deelnameBO);
                            this.Refresh();
                        }
                        break;
                    case "Verwijderen":
                        //Gebruik onderstaande List om meerdere selecties voor verwijdering op te slaan
                        List<int> selectedDeelnames = new List<int>();
                        if (RbSelectFEDeelname.Checked == true)
                        {
                            for(int i = 0; i < lvBEDeelname.SelectedItems.Count; i++)
                            {
                                selectedDeelnames.Add(int.Parse(lvBEDeelname.SelectedItems[0].Text));
                            }
                            deelnameBL.DeleteFE(selectedDeelnames);
                            this.Refresh();
                        }
                        else if(RbSelectBEDeelname.Checked == true)
                        {
                            for (int i = 0; i < lvBEDeelname.SelectedItems.Count; i++)
                            {
                                selectedDeelnames.Add(int.Parse(lvBEDeelname.SelectedItems[0].Text));
                            }
                            deelnameBL.DeleteBE(selectedDeelnames);
                            this.Refresh();
                        }
                        break;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void InvoerenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(lvBEDeelname.SelectedItems.Count > 0)
            {
                lbDeelnameID.Text = lvBEDeelname.SelectedItems[0].Text;
                tbDeelnemer.Text = lvBEDeelname.SelectedItems[0].SubItems[1].Text;
                tbAfkomst.Text = lvBEDeelname.SelectedItems[0].SubItems[2].Text;
                tbLeeftijd.Text = lvBEDeelname.SelectedItems[0].SubItems[3].Text;
                btnSelectieUitvoer.Enabled = true;
            }

            btnSelectieUitvoer.Text = "Invoeren";
        }

        private void BewerkenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(lvBEDeelname.SelectedItems.Count > 0)
            {
                lbDeelnameID.Text = lvBEDeelname.SelectedItems[0].Text;
                tbDeelnemer.Text = lvBEDeelname.SelectedItems[0].SubItems[1].Text;
                tbAfkomst.Text = lvBEDeelname.SelectedItems[0].SubItems[2].Text;
                tbLeeftijd.Text = lvBEDeelname.SelectedItems[0].SubItems[3].Text;
                btnSelectieUitvoer.Enabled = true;
            }
            btnSelectieUitvoer.Text = "Bewerken";
        }

        private void VerwijderenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (lvBEDeelname.SelectedItems.Count > 0)
            {
                lbDeelnameID.Text = lvBEDeelname.SelectedItems[0].Text;
                tbDeelnemer.Text = lvBEDeelname.SelectedItems[0].SubItems[1].Text;
                tbAfkomst.Text = lvBEDeelname.SelectedItems[0].SubItems[2].Text;
                tbLeeftijd.Text = lvBEDeelname.SelectedItems[0].SubItems[3].Text;
                btnSelectieUitvoer.Enabled = true;
            }
            btnSelectieUitvoer.Text = "Verwijderen";
        }

        private void BEDeelname_Load(object sender, EventArgs e)
        {
            BEDeelnameBL deelnameBL = new BEDeelnameBL();

            try
            {
                    lvBEDeelname.Items.Clear();
                    lvBEDeelname.Columns.Clear();
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    if (RbSelectFEDeelname.Checked == true)
                    {
                        lvBEDeelname.Columns[0].Text = "FE_Deelname_ID";
                    }
                    else if (RbSelectBEDeelname.Checked == true)
                    {
                        lvBEDeelname.Columns[0].Text = "BE_Deelname_ID";
                    }
                    lvBEDeelname.Columns[0].Width = 0;
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[1].Text = "Deelnemer";
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[2].Text = "Afkomst";
                    lvBEDeelname.Columns.Add(new ColumnHeader());
                    lvBEDeelname.Columns[3].Text = "Leeftijd";

                    DataSet dsDeelname = deelnameBL.ReadFE();

                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsDeelname.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowDeelname = dsDeelname.Tables[0].Rows[i];

                        if (rowDeelname.RowState != DataRowState.Deleted)
                        {
                            ListViewItem lvItem = new ListViewItem();
                            if (RbSelectFEDeelname.Checked == true)
                            {
                            // Vul de listitems met de data uit de volgende rij
                                lvItem.Text = rowDeelname["FE_Deelname_ID"].ToString();
                            }
                            else if (RbSelectBEDeelname.Checked == true)
                            {
                                lvItem.Text = rowDeelname["BE_Deelname_ID"].ToString();
                            }
                            lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Afkomst"].ToString());
                            lvItem.SubItems.Add(rowDeelname["Leeftijd"].ToString());
                            // Voeg de nieuwe listitems toe aan de listview
                            lvBEDeelname.Items.Add(lvItem);
                        }
                    }

                    lbDeelnameID.Text = lvBEDeelname.Items[0].Text;
                    tbDeelnemer.Text = lvBEDeelname.Items[0].SubItems[1].Text;
                    tbAfkomst.Text = lvBEDeelname.Items[0].SubItems[2].Text;
                    tbLeeftijd.Text = lvBEDeelname.Items[0].SubItems[3].Text;

                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvBEDeelname, -1);
                    SizeForm();
                
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }
    }
}