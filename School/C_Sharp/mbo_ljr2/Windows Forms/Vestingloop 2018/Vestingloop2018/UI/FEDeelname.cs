/************************** Module Header *******************************\
Project:         Vestingloop 2018
Auteur:          Adam Oubelkas
Aanmaakdatum:    18 juni 2018
Module naam:     FEDeelname.cs

Omschrijving:    Presentation Layer Frontend Deelname(s) Vestingloop

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
    public partial class FEDeelname : Form
    {
        //bewaar hier alle aangevinkte waardes uit de checklistbox 
        List<string> selectedDeelnames = new List<string>();

        //constructor
        public FEDeelname()
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
            foreach (ColumnHeader col in lvFEDeelname.Columns)
            {
                wid += col.Width;
            }
        }

        private void FEDeelname_Load(object sender, EventArgs e)
        {
            FEDeelnameBL deelnameBL = new FEDeelnameBL();

            try
            {
                DataSet dsDeelname = deelnameBL.Read();

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
                        lvFEDeelname.Items.Add(lvItem);
                    }
                }
                // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                SetListViewColumnSizes(lvFEDeelname, -1);
                SizeForm();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void SelecterenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FEDeelnameBL deelnameBL = new FEDeelnameBL();
            FEDeelnameBO deelnameBO = new FEDeelnameBO();

            try
            {
                if(lvFEDeelname.SelectedItems.Count > 0)
                {
                    DataSet dsDeelname = deelnameBL.Read();
                    //lus door alle rijen van de tabel
                    for (int ii = 0; ii < dsDeelname.Tables[0].Rows.Count; ii++)
                    {
                        DataRow rowDeelname = dsDeelname.Tables[0].Rows[ii];

                        if (rowDeelname.RowState != DataRowState.Deleted)
                        {
                            if (rowDeelname["FE_Deelname_ID"].ToString() == lvFEDeelname.SelectedItems[0].Text)
                            {
                                deelnameBO.Deelnemer = rowDeelname["Deelnemer"].ToString();
                                deelnameBO.Afkomst = rowDeelname["Afkomst"].ToString();
                                deelnameBO.Leeftijd = int.Parse(rowDeelname["Leeftijd"].ToString());

                            }
                        }
                    }
                    lblSelectieWeergave.Text = "Deelnemer " + deelnameBO.Deelnemer + " uit " + deelnameBO.Afkomst + " met leeftijd " + deelnameBO.Leeftijd.ToString() + " doet mee aan de Vestingloop 2018.";
                    lblSelectieWeergave.Visible = true;
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void GroeperenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FEDeelnameBL deelnameBL = new FEDeelnameBL();

            try
            {
                if (selectedDeelnames.Count > 0)
                {
                    lvFEDeelname.Columns.Clear();
                    lvFEDeelname.Columns.Add(new ColumnHeader());
                    lvFEDeelname.Columns[0].Text = "FE_Deelname_ID";
                    lvFEDeelname.Columns[0].Width = 0;

                    for(int i = 0;  i < selectedDeelnames.Count; i++)
                    {
                        switch (selectedDeelnames[i])
                        {
                            case "Deelnemer":
                                lvFEDeelname.Columns.Add(new ColumnHeader());
                                lvFEDeelname.Columns[++i].Text = "Deelnemer";
                                i--;
                                break;
                            case "Afkomst":
                                lvFEDeelname.Columns.Add(new ColumnHeader());
                                lvFEDeelname.Columns[++i].Text = "Afkomst";
                                i--;
                                break;
                            case "Leeftijd":
                                lvFEDeelname.Columns.Add(new ColumnHeader());
                                lvFEDeelname.Columns[++i].Text = "Leeftijd";
                                i--; //Check of er bugs ontstaan door deze decrement
                                break;
                        }
                    }

                    DataSet dsDeelname = deelnameBL.Group(selectedDeelnames);

                    lvFEDeelname.Items.Clear();
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
                            for (int ii = 0; ii < selectedDeelnames.Count; ii++)
                            {
                                switch (selectedDeelnames[ii])
                                {
                                    case "Deelnemer":
                                        lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                                        break;
                                    case "Afkomst":
                                        lvItem.SubItems.Add(rowDeelname["Afkomst"].ToString());
                                        break;
                                    case "Leeftijd":
                                        lvItem.SubItems.Add(rowDeelname["Leeftijd"].ToString());
                                        break;
                                }
                            }

                            // Voeg de nieuwe listitems toe aan de listview
                            lvFEDeelname.Items.Add(lvItem);
                        }
                    }
                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvFEDeelname, -1);
                    SizeForm();
                }

            }
            catch(Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void SorterenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FEDeelnameBL deelnameBL = new FEDeelnameBL();

            try
            {
                if (selectedDeelnames.Count > 0)
                {
                    DataSet dsDeelname = deelnameBL.Filter(lvFEDeelname.Columns, selectedDeelnames);

                    lvFEDeelname.Items.Clear();
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

                            for (int ii = 0; ii < lvFEDeelname.Columns.Count; ii++)
                            {
                                switch (lvFEDeelname.Columns[ii].Text)
                                {
                                    case "Deelnemer":
                                        lvItem.SubItems.Add(rowDeelname["Deelnemer"].ToString());
                                        break;
                                    case "Afkomst":
                                        lvItem.SubItems.Add(rowDeelname["Afkomst"].ToString());
                                        break;
                                    case "Leeftijd":
                                        lvItem.SubItems.Add(rowDeelname["Leeftijd"].ToString());
                                        break;
                                }
                            }
                            // Voeg de nieuwe listitems toe aan de listview
                            lvFEDeelname.Items.Add(lvItem);
                        }
                    }
                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvFEDeelname, -1);
                    SizeForm();
                    lvFEDeelname.Sort();
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void ClbFilterDeelname_ItemCheck(object sender, ItemCheckEventArgs e)
        {
               
               if(e.NewValue == CheckState.Checked && !selectedDeelnames.Contains(e.NewValue.ToString()))
               {
                    selectedDeelnames.Add(clbFilterDeelname.SelectedItem.ToString());
               }
               else if(e.NewValue == CheckState.Unchecked)
               {
                    selectedDeelnames.Remove(clbFilterDeelname.SelectedItem.ToString());
               }
        }
    }
}
