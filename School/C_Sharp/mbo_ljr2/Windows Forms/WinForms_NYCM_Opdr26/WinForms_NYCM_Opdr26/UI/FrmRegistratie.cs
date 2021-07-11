/************************** Module Header *******************************\
Project:         3-Tier Windows Forms NYCM
Auteur:          Adam Oubelkas
Aanmaakdatum:    19 mei 2018
Module naam:     FrmRegistratie.cs

Omschrijving:    Presentation layer Registratie(s) Taak NYCM

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
    public partial class FrmRegistratie : Form
    {
        //Initialisatie: lijst voor alle gewenste registratiespunten
        List<string> stdRegistratiePuntW501 = new List<string>() {"5 km", "10 km", "15 km", "20 km", "25 km", "30 km", "35 km", "40 km", "Finish"};
        public FrmRegistratie()
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
        // en pas de vorm zodanig aan dat alles zichtbaar wordt
        private void SizeForm()
        {
            // Voeg de kolombreedtes toe
            int wid = 0;
            foreach (ColumnHeader col in lvRegistratie.Columns)
            {
                wid += col.Width;
            }

            // Pas de ListView en vorm aan
            lvRegistratie.Width = wid + 5;
            this.ClientSize = new Size(
                lvRegistratie.Right + lvRegistratie.Left,
                this.ClientSize.Height
            );
        }

        private void BtnInvoeren_Click(object sender, EventArgs e)
        {
            RegistratieBOL registratie = new RegistratieBOL(); //Data object van klasse
            RegistratieBLL registratieBLL = new RegistratieBLL(); //Methoden object van klasse
            bool IsNull = true;

            try
            {
                DataSet ds = registratieBLL.Read();
                if (ds.Tables.Count == 0)
                {
                    MessageBox.Show("Foutmelding:\nHet tabel over registraties kan niet gelezen worden");
                }
                else
                {
                    if (cbChipNm.SelectedValue.ToString() != "" || tdRegTd.Text != "" || cbRegpt.SelectedValue.ToString() != "" || tdJaar.Text != "")
                    {
                        if (int.TryParse(cbChipNm.SelectedValue.ToString(), out int ChipNm) != true)
                        {
                            MessageBox.Show("Foutmelding:\nU heeft een lege chipnummer geselecteerd\nProbeer het opnieuw");
                            IsNull = false;
                        }
                        else
                        {
                            IsNull = true;
                        }

                        if (int.TryParse(tdRegTd.Text, out int Regtd) != true)
                        {
                            MessageBox.Show("Foutmelding:\nU heeft een lege of verkeerde registratietijd ingevuld\nProbeer het opnieuw");
                            IsNull = false;
                        }
                        else
                        {
                            IsNull = true;
                        }

                        if (cbRegpt.SelectedValue.ToString() == "")
                        {
                            MessageBox.Show("Foutmelding:\nU heeft een lege registratiepunt geselecteerd\nProbeer het opnieuw");
                            IsNull = false;
                        }
                        else
                        {
                            IsNull = true;
                        }

                        if (int.TryParse(tdJaar.Text, out int Jaar) != true)
                        {
                            MessageBox.Show("Foutmelding:\nU heeft een lege of verkeerde jaartal ingevuld\nProbeer het opnieuw");
                            IsNull = false;
                        }
                        else
                        {
                            IsNull = true;
                        }

                        if (ChipNm > 0 && Regtd > 0 && cbRegpt.SelectedValue != null && Jaar > 0 && IsNull == true)
                        {
                            //lus door alle rijen van tabel tblDeelnemer
                            for (int i = 0; i < (ds.Tables[0].Rows.Count); i++)
                            {
                                DataRow row = ds.Tables[0].Rows[i];

                                if (ChipNm == Int32.Parse(row["ChipNummerD201"].ToString()))
                                {
                                    IsNull = false;
                                    MessageBox.Show("Foutmelding:\nHet door u geselecteerde chipnummer bestaat al\nVoer een nieuwe chipnummer in");
                                    break;
                                }
                            }

                            if (IsNull == true)
                            {
                                registratie.ChipNummerD201 = ChipNm;
                                registratie.RegistratieTijd = Regtd;
                                registratie.RegistratiePuntW501 = cbRegpt.SelectedValue.ToString();
                                registratie.Jaar = Jaar;
                                registratieBLL.Create(registratie);

                                // Vul de listitems met de data uit de volgende rij
                                ListViewItem lvItem = new ListViewItem()
                                {
                                    Text = registratie.ChipNummerD201.ToString()
                                };

                                lvItem.SubItems.Add(registratie.RegistratieTijd.ToString());
                                lvItem.SubItems.Add(registratie.RegistratiePuntW501);
                                lvItem.SubItems.Add(registratie.Jaar.ToString());

                                // Voeg de nieuwe listitems toe aan de listview
                                lvRegistratie.Items.Add(lvItem);
                                lvRegistratie.Sort();

                                // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                                SetListViewColumnSizes(lvRegistratie, -1);
                                SizeForm();

                                lblWeergave.Text = "Chipnummer " + lvItem.Text 
                                + " registreert voor de NYCM in het jaartal " 
                                + lvItem.SubItems[3].Text + " bij het registratiepunt " 
                                + lvItem.SubItems[2].Text 
                                + " de registratietijd " + lvItem.SubItems[1].Text;
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

        private void FrmRegistratie_Load(object sender, EventArgs e)
        {
            DeelnemerBLL deelnemerBLL = new DeelnemerBLL();
            RegistratieBLL registratieBLL = new RegistratieBLL();
            try
            {
                DataSet ds = deelnemerBLL.Read();

                if (ds.Tables.Count == 0)
                {
                    MessageBox.Show("Foutmelding:\nHet tabel over deelnemers kan niet gelezen worden");
                }

                else
                {
                    if(ds.Tables[0].Rows.Count > 0)
                    {
                        //Maak de itemlijst van de combobox cbChipNm
                        cbChipNm.DataSource = ds.Tables["tblDeelnemer"];
                        cbChipNm.DisplayMember = "ChipNummerH201";
                        cbChipNm.ValueMember = "chipNummerH201";

                        // Initialiseer de geselecteerde index van de combobox cbChipNm
                        cbChipNm.SelectedIndex = 0;

                        lvRegistratie.Items.Clear();
                        ds = registratieBLL.Read();
                        cbRegpt.DataSource = stdRegistratiePuntW501;

                        // Initialiseer de geselecteerde index van de combobox cbRegPt
                        cbRegpt.SelectedIndex = 0;

                        //lus door alle rijen van tabel tblRegistratie
                        for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                        {
                            DataRow row = ds.Tables[0].Rows[i];

                            if (row.RowState != DataRowState.Deleted)
                            {
                                // Vul de listitems met de data uit de volgende rij
                                ListViewItem lvItem = new ListViewItem()
                                {
                                    Text = row["ChipNummerD201"].ToString()
                                };

                                for (int ii = 1; ii < ds.Tables[0].Columns.Count; ii++)
                                {
                                    lvItem.SubItems.Add(row[ii].ToString());
                                }

                                // Voeg de nieuwe listitems toe aan de listview
                                lvRegistratie.Items.Add(lvItem);
                            }
                            lvRegistratie.Sort();
                        }

                        if (lvRegistratie.Items.Count > 0)
                        {
                            ListViewItem d = lvRegistratie.Items[0];

                            cbChipNm.Text = d.Text;
                            tdRegTd.Text = d.SubItems[1].Text;
                            cbRegpt.Text = d.SubItems[2].Text;
                            tdJaar.Text = d.SubItems[3].Text;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void VerwijderRegistratieToolStripMenuItem_Click(object sender, EventArgs e)
        {
            RegistratieBLL registratieBLL = new RegistratieBLL();
            DataSet ds = registratieBLL.Read();

            if (ds.Tables[0].Rows.Count != 0 && lvRegistratie.SelectedItems.Count != 0)
            {
                registratieBLL.Delete(lvRegistratie.SelectedIndices[0]);
                lvRegistratie.Items.RemoveAt(lvRegistratie.SelectedIndices[0]);
            }
        }

        private void AlleRegistratiesVerwijderenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            RegistratieBLL registratieBLL = new RegistratieBLL();
            DataSet ds = registratieBLL.Read();
            if (ds.Tables[0].Rows.Count != 0)
            {
                registratieBLL.DeleteAll();
                ds.Tables[0].Rows.Clear();
                lvRegistratie.Items.Clear();
            }
        }
    }
}
