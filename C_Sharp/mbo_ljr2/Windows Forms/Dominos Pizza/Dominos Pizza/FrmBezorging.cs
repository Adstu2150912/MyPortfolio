/************************** Module Header *******************************\
Project:         H25 - Windows Forms Dominos
Auteur:          Adam Oubelkas
Aanmaakdatum:    2 mei 2018
Module naam:     FrmBezorging.cs

Omschrijving:    Formuliervenster Bezorging Taak Domino's

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
    public partial class FrmBezorging : Form
    {
        private List<Bestelling> bestelling;
        private List<Bezorging> bezorging;

        //constructor
        public FrmBezorging(List<Bestelling> BestellingInvoer, List<Bezorging> BezorgingInvoer)
        {
            InitializeComponent();
            bestelling = BestellingInvoer;
            bezorging = BezorgingInvoer;
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
            foreach (ColumnHeader col in lvBezorging.Columns)
            {
                wid += col.Width;
            }

            // Pas de ListView en vorm aan
            lvBezorging.Width = wid + 5;
            this.ClientSize = new Size(
                lvBezorging.Right + lvBezorging.Left,
                this.ClientSize.Height);
        }

        //Implementatie: methoden en events
        private void FrmBezorging_Load(object sender, EventArgs e)
        {
            if(bestelling.Count != 0)
            {
                for (int i = 0; i < bestelling.Count; i++)
                {
                    if (bestelling[i].BestelCodeH202 != "onbekend")
                    {
                        cbBestelCode.Items.Add(bestelling[i].BestelCodeH202);
                    }
                }
            }
            else if(bezorging.Count != 0)
            {
                bezorging.Clear();
            }
        }

        private void btnBevestigen_Click(object sender, EventArgs e)
        {
            try
            {

                if (tbPostCode.Text != "" && tbHuisNummer.Text != "" && txtBezorgdag.Text != "" && txtBezorgtijd.Text != ""
                    && cbBestelCode.SelectedItem != null)
                {
                    Bezorging BezorgingsNm = new Bezorging();
                    bezorging.Add(BezorgingsNm);

                    bezorging[bezorging.Count - 1].PostCode = tbPostCode.Text;
                    Int32.TryParse(tbHuisNummer.Text, out int HuisNummer);
                    bezorging[bezorging.Count - 1].HuisNummer = HuisNummer;
                    bezorging[bezorging.Count - 1].BezorgDag = txtBezorgdag.Text;
                    bezorging[bezorging.Count - 1].BezorgTijd = txtBezorgtijd.Text;
                    Int32.TryParse(tbactieCode.Text, out int ActieCode);
                    //Toekenning deelverzameling aan hoofdverzameling
                    bezorging[bezorging.Count - 1].BestelCodeD202 = cbBestelCode.SelectedItem.ToString();
                    bezorging[bezorging.Count - 1].ActieCode = ActieCode;

                    if (tbactieCode.Text != "" && bezorging[bezorging.Count - 1].ActieCode != 0)
                    {
                        ListViewItem BezorgingsItem = new ListViewItem()
                        {
                            Text = bezorging[bezorging.Count - 1].PostCode
                        };
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].HuisNummer.ToString());
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgDag);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgTijd);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BestelCodeD202);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].ActieCode.ToString());
                        lvBezorging.Items.Add(BezorgingsItem);
                    }
                    else if(tbactieCode.Text != "" && bezorging[bezorging.Count - 1].HuisNummer != 0 && bezorging[bezorging.Count - 1].ActieCode != 0)
                    {
                        ListViewItem BezorgingsItem = new ListViewItem()
                        {
                            Text = bezorging[bezorging.Count - 1].PostCode
                        };
                        BezorgingsItem.SubItems.Add("");
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgDag);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgTijd);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BestelCodeD202);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].ActieCode.ToString());
                        lvBezorging.Items.Add(BezorgingsItem);
                    }
                    else if (bezorging[bezorging.Count - 1].HuisNummer != 0 && bezorging[bezorging.Count - 1].ActieCode != 0)
                    {
                        ListViewItem BezorgingsItem = new ListViewItem()
                        {
                            Text = bezorging[bezorging.Count - 1].PostCode
                        };
                        BezorgingsItem.SubItems.Add("");
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgDag);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgTijd);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BestelCodeD202);
                        lvBezorging.Items.Add(BezorgingsItem);
                    }
                    else
                    {
                        ListViewItem BezorgingsItem = new ListViewItem()
                        {
                            Text = bezorging[bezorging.Count - 1].PostCode
                        };
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].HuisNummer.ToString());
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgDag);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BezorgTijd);
                        BezorgingsItem.SubItems.Add(bezorging[bezorging.Count - 1].BestelCodeD202);
                        lvBezorging.Items.Add(BezorgingsItem);
                    }

                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvBezorging, -1);
                    SizeForm();
                }
                else
                {
                    MessageBox.Show("Foutmelding:\nU heeft het formulier niet volledig ingevuld\nProbeer het opnieuw");
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show("Foutmelding:\n" + ex.Message);
            }
        }

        private void verwijderBezorgingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(bezorging.Count != 0 && lvBezorging.SelectedItems.Count != 0)
            {
                lvBezorging.Items.RemoveAt(lvBezorging.SelectedIndices[0]);
            }
        }

        private void alleBezorgingenVerwijderenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(bezorging.Count != 0)
            {
                lvBezorging.Items.Clear();
            }
        }
    }
}
