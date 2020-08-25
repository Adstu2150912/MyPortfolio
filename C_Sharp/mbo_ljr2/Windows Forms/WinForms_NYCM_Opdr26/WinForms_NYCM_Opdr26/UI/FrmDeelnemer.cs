/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     FrmDeelnemer.cs

Omschrijving:    Presentation Layer Registratie(s) Taak NYCM

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
    public partial class FrmDeelnemer : Form
    {
        //Declarering: klasse variabel
        private DeelnemerBOL deelnemerIsReady;

        public FrmDeelnemer(DeelnemerBOL InvoerDeelnemer)
        {
            InitializeComponent();
            //Initialisatie: instantie klasse  
            deelnemerIsReady = InvoerDeelnemer;
        }

        //Implementatie: methoden en events

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
            foreach (ColumnHeader col in lvDeelnemer.Columns)
            {
                wid += col.Width;
            }

            // Pas de ListView en vorm aan
            lvDeelnemer.Width = wid + 5;
            this.ClientSize = new Size(
                lvDeelnemer.Right + lvDeelnemer.Left,
                this.ClientSize.Height
            );
        }

        private void BtnInvoeren_Click(object sender, EventArgs e)
        {
            DeelnemerBOL deelnemer = new DeelnemerBOL(); //Data object van klasse
            DeelnemerBLL deelnemerBLL = new DeelnemerBLL(); //Methoden object van klasse

            bool IsNull = true;

            try
            {          
                DataSet ds = deelnemerBLL.Read();
                if (ds.Tables.Count == 0)
                {
                    MessageBox.Show("Foutmelding:\nHet tabel over deelnemer kan niet gelezen worden");
                }
                else
                {
                    if (tbDeelnm.Text != "" || tbRugnm.Text != "" || tbChipnm.Text != "")
                    {
                        if (tbDeelnm.Text != "")
                        {
                            IsNull = true;
                        }
                        else
                        { 
                            MessageBox.Show("Foutmelding:\nU heeft een lege of verkeerde naam ingevuld\nProbeer het opnieuw");
                            IsNull = false;
                        }

                        if (int.TryParse(tbRugnm.Text, out int RugNm) == true)
                        {
                            IsNull = true;
                        }
                        else
                        {
                            MessageBox.Show("Foutmelding:\nU heeft een lege of verkeerde rugnummer ingevuld\nProbeer het opnieuw");
                            IsNull = false;
                        }

                        if (int.TryParse(tbChipnm.Text, out int ChipNmH201) == true)
                        {
                            IsNull = true;
                        }
                        else
                        {
                            MessageBox.Show("Foutmelding:\nU heeft een lege of verkeerde chipnummer ingevuld\nProbeer het opnieuw");
                            IsNull = false;
                        }

                        if (tbDeelnm.Text != "" && RugNm > 0 && ChipNmH201 > 0 && IsNull == true)
                        {
                            //lus door alle rijen van tabel tblDeelnemer
                            for (int i = 0; i < (ds.Tables[0].Rows.Count); i++)
                            {
                                DataRow row = ds.Tables[0].Rows[i];

                                if (ChipNmH201 == Int32.Parse(row["ChipNummerH201"].ToString()))
                                {
                                    IsNull = false;
                                    MessageBox.Show("Foutmelding:\nHet door u ingevulde chipnummer bestaat al\nVoer een nieuwe chipnummer in");
                                    break;
                                }
                            }

                            if (IsNull == true)
                            {
                                deelnemer.Naam = tbDeelnm.Text;
                                deelnemer.RugNummer = RugNm;
                                deelnemer.ChipNummerH201 = ChipNmH201;
                                deelnemerBLL.Create(deelnemer);
                                deelnemerIsReady.ChipNummerH201 = deelnemer.ChipNummerH201;

                                // Vul de listitems met de data uit de volgende rij
                                ListViewItem lvItem = new ListViewItem()
                                {
                                    Text = deelnemer.Naam
                                };

                                // Voeg de nieuwe listitems toe aan de listview
                                lvItem.SubItems.Add(deelnemer.RugNummer.ToString());
                                lvItem.SubItems.Add(deelnemer.ChipNummerH201.ToString());
                                lvDeelnemer.Items.Add(lvItem);
                                lvDeelnemer.Sort();

                                // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                                SetListViewColumnSizes(lvDeelnemer, -1);
                                SizeForm();

                                lblWeergave.Text = "Deelnemer " + lvItem.Text + " heeft het rugnummer " + lvItem.SubItems[1].Text + " en het chipnummer " + lvItem.SubItems[2].Text;
                                lblWeergave.Visible = true;
                            }
                        }    
                    }
                    else
                    {
                        MessageBox.Show("Foutmelding:\nU heeft het formulier niet volledig ingevuld!\nProbeer het opnieuw");
                    }
                }                
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void FrmDeelnemer_Load(object sender, EventArgs e)
        {
            DeelnemerBLL deelnemerBLL = new DeelnemerBLL();

            try
            {
                DataSet ds = deelnemerBLL.Read();


                if (ds.Tables.Count == 0)
                {
                    MessageBox.Show("Het tabel over deelnemers kan niet gelezen worden");
                }
                else
                {
                    //lus door alle rijen van tabel tblDeelnemer
                    for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                    {
                        DataRow row = ds.Tables[0].Rows[i];

                        if (row.RowState != DataRowState.Deleted)
                        {
                            // Vul de listitems met de data uit de volgende rij
                            ListViewItem lvItem = new ListViewItem()
                            {
                                Text = row["Naam"].ToString()
                            };

                            for (int ii = 1; ii < ds.Tables[0].Columns.Count; ii++)
                            {
                                lvItem.SubItems.Add(row[ii].ToString());
                            }

                            // Voeg de nieuwe listitems toe aan de listview
                            lvDeelnemer.Items.Add(lvItem);
                        }
                        lvDeelnemer.Sort();
                    }

                    if (lvDeelnemer.Items.Count > 0)
                    {
                        ListViewItem d = lvDeelnemer.Items[0];

                        tbDeelnm.Text = d.Text;
                        tbRugnm.Text = d.SubItems[1].Text;
                        tbChipnm.Text = d.SubItems[2].Text;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void VerwijderDeelnemerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DeelnemerBLL deelnemerBLL = new DeelnemerBLL();
            DataSet ds = deelnemerBLL.Read();
            //verwijder de geselecteerde items in de listview en dataset (de eerste tabel(tblDeelnemer): index 0) van deelnemer
            if (lvDeelnemer.SelectedItems.Count != 0)
            {
                deelnemerBLL.Delete(lvDeelnemer.SelectedIndices[0]);
                lvDeelnemer.Items.RemoveAt(lvDeelnemer.SelectedIndices[0]);
            }
            else if (ds.Tables[0].Rows.Count == 0)
            {
                deelnemerIsReady.ChipNummerH201 = 0;
            }
        }

        private void AlleDeelnemersVerwijderenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DeelnemerBLL deelnemerBLL = new DeelnemerBLL();
            DataSet ds = deelnemerBLL.Read();
            if (ds.Tables[0].Rows.Count != 0)
            {
                deelnemerBLL.DeleteAll();
                lvDeelnemer.Items.Clear();
                deelnemerIsReady.ChipNummerH201 = 0;
            }
        }
    }
}