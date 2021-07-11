/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     FEResultaat.cs

Omschrijving:    Presentation Layer Frontend Resultaat(en) Vestingloop

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
    public partial class FEResultaat : Form
    {
        //bewaar hier alle aangevinkte waardes uit de checklistbox 
        List<string> selectedResultaten = new List<string>();

        //constructor
        public FEResultaat()
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
            foreach (ColumnHeader col in lvFEResultaat.Columns)
            {
                wid += col.Width;
            }
        }

        private void FEResultaat_Load(object sender, EventArgs e)
        {
            FEResultaatBL resultaatBL = new FEResultaatBL();

            try
            {
                DataSet dsResultaat = resultaatBL.Read();

                //lus door alle rijen van de tabel
                for (int i = 0; i < dsResultaat.Tables[0].Rows.Count; i++)
                {
                    DataRow rowResultaat = dsResultaat.Tables[0].Rows[i];

                    if (rowResultaat.RowState != DataRowState.Deleted)
                    {
                        // Vul de listitems met de data uit de volgende rij
                        ListViewItem lvItem = new ListViewItem()
                        {
                            Text = rowResultaat["FE_Resultaat_ID"].ToString()
                        };
                        lvItem.SubItems.Add(rowResultaat["Deelnemer"].ToString());
                        lvItem.SubItems.Add(rowResultaat["RouteD204"].ToString());
                        lvItem.SubItems.Add(rowResultaat["Tijd"].ToString());
                        lvItem.SubItems.Add(rowResultaat["Rang"].ToString());
                        // Voeg de nieuwe listitems toe aan de listview
                        lvFEResultaat.Items.Add(lvItem);
                    }
                }
                // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                SetListViewColumnSizes(lvFEResultaat, -1);
                SizeForm();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void SelecterenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FEResultaatBL resultaatBL = new FEResultaatBL();
            FEResultaatBO resultaatBO = new FEResultaatBO();

            try
            {
                if (lvFEResultaat.SelectedItems.Count > 0)
                {
                    DataSet dsResultaat = resultaatBL.Read();
                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsResultaat.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowResultaat = dsResultaat.Tables[0].Rows[i];

                        if (rowResultaat.RowState != DataRowState.Deleted)
                        {
                            if(rowResultaat["FE_Resultaat_ID"].ToString() == lvFEResultaat.SelectedItems[0].Text)
                            {
                                resultaatBO.Deelnemer = rowResultaat["Deelnemer"].ToString();
                                resultaatBO.RouteD204 = rowResultaat["RouteD204"].ToString();
                                resultaatBO.Tijd = rowResultaat["Tijd"].ToString();
                                resultaatBO.Rang = int.Parse(rowResultaat["Rang"].ToString());
                            }
                        }
                    }
                    lblSelectieWeergave.Text = "Deelnemer " + resultaatBO.Deelnemer + " heeft route " + resultaatBO.RouteD204 + " in " + resultaatBO.Tijd + " gelopen en wordt rang " + resultaatBO.Rang.ToString();
                    lblSelectieWeergave.Visible = true;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void GroeperenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FEResultaatBL resultaatBL = new FEResultaatBL();

            try
            {
                if (selectedResultaten.Count > 0)
                {
                    lvFEResultaat.Columns.Clear();
                    lvFEResultaat.Columns.Add(new ColumnHeader());
                    lvFEResultaat.Columns[0].Text = "FE_Resultaat_ID";
                    lvFEResultaat.Columns[0].Width = 0;

                    for (int i = 0; i < selectedResultaten.Count; i++)
                    {
                        switch (selectedResultaten[i])
                        {
                            case "Deelnemer":
                                lvFEResultaat.Columns.Add(new ColumnHeader());
                                lvFEResultaat.Columns[++i].Text = "Deelnemer";
                                i--;
                                break;
                            case "Route":
                                lvFEResultaat.Columns.Add(new ColumnHeader());
                                lvFEResultaat.Columns[++i].Text = "Route";
                                i--;
                                break;
                            case "Tijd":
                                lvFEResultaat.Columns.Add(new ColumnHeader());
                                lvFEResultaat.Columns[++i].Text = "Tijd";
                                i--;
                                break;
                            case "Rang":
                                lvFEResultaat.Columns.Add(new ColumnHeader());
                                lvFEResultaat.Columns[++i].Text = "Rang";
                                i--;
                                break;
                        }
                    }

                    DataSet dsResultaat = resultaatBL.Group(selectedResultaten);

                    lvFEResultaat.Items.Clear();
                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsResultaat.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowResultaat = dsResultaat.Tables[0].Rows[i];

                        if (rowResultaat.RowState != DataRowState.Deleted)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            ListViewItem lvItem = new ListViewItem()
                            {
                                Text = rowResultaat["FE_Resultaat_ID"].ToString()
                            };
                            for (int ii = 0; ii < selectedResultaten.Count; ii++)
                            {
                                switch (selectedResultaten[ii])
                                {
                                    case "Deelnemer":
                                        lvItem.SubItems.Add(rowResultaat["Deelnemer"].ToString());
                                        break;
                                    case "Route":
                                        lvItem.SubItems.Add(rowResultaat["RouteD204"].ToString());
                                        break;
                                    case "Tijd":
                                        lvItem.SubItems.Add(rowResultaat["Tijd"].ToString());
                                        break;
                                    case "Rang":
                                        lvItem.SubItems.Add(rowResultaat["Rang"].ToString());
                                        break;
                                }
                            }
                            // Voeg de nieuwe listitems toe aan de listview
                            lvFEResultaat.Items.Add(lvItem);
                        }
                    }
                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvFEResultaat, -1);
                    SizeForm();
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void SorterenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FEResultaatBL resultaatBL = new FEResultaatBL();

            try
            {
                if (selectedResultaten.Count > 0)
                {

                    DataSet dsResultaat = resultaatBL.Filter(lvFEResultaat.Columns, selectedResultaten);

                    lvFEResultaat.Items.Clear();
                    //lus door alle rijen van de tabel
                    for (int i = 0; i < dsResultaat.Tables[0].Rows.Count; i++)
                    {
                        DataRow rowResultaat = dsResultaat.Tables[0].Rows[i];

                        if (rowResultaat.RowState != DataRowState.Deleted)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            ListViewItem lvItem = new ListViewItem()
                            {
                                Text = rowResultaat["FE_Resultaat_ID"].ToString()
                            };

                            for (int ii = 0; ii < lvFEResultaat.Columns.Count; ii++)
                            {
                                switch (lvFEResultaat.Columns[ii].Text)
                                {
                                    case "Deelnemer":
                                        lvItem.SubItems.Add(rowResultaat["Deelnemer"].ToString());
                                        break;
                                    case "Route":
                                        lvItem.SubItems.Add(rowResultaat["RouteD204"].ToString());
                                        break;
                                    case "Tijd":
                                        lvItem.SubItems.Add(rowResultaat["Tijd"].ToString());
                                        break;
                                    case "Rang":
                                        lvItem.SubItems.Add(rowResultaat["Rang"].ToString());
                                        break;
                                }
                            }
                            // Voeg de nieuwe listitems toe aan de listview
                            lvFEResultaat.Items.Add(lvItem);
                        }
                    }
                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvFEResultaat, -1);
                    SizeForm();
                    lvFEResultaat.Sort();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void ClbFilterResultaat_ItemCheck(object sender, ItemCheckEventArgs e)
        {
            if (e.NewValue == CheckState.Checked && !selectedResultaten.Contains(e.NewValue.ToString()))
            {
                selectedResultaten.Add(clbFilterResultaat.SelectedItem.ToString());
            }
            else if (e.NewValue == CheckState.Unchecked)
            {
                selectedResultaten.Remove(clbFilterResultaat.SelectedItem.ToString());
            }
        }
    }
}
