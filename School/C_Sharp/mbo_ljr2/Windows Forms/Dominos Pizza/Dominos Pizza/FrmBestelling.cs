/************************** Module Header *******************************\
Project:         H25 - Windows Forms Dominos
Auteur:          Adam Oubelkas
Aanmaakdatum:    2 mei 2018
Module naam:     FrmBestelling.cs

Omschrijving:    Formuliervenster Bestelling Taak Domino's

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
    public partial class FrmBestelling : Form
    {
        private List<PizzaNaam> pizzaNaam;
        private List<Bestelling> bestelling;

        private List<string> ListStdPizzaGrootteType = new List<string>() { "Medium", "Italian", "Large" };
        private List<string> ListStdPizzaBodemType = new List<string>() { "Fresh Pan", "Cheesy Crunch", "Classic" };

        //constructor
        public FrmBestelling(List<PizzaNaam> PizzaNaamInvoer, List<Bestelling> BestellingInvoer)
        {
            InitializeComponent();
            pizzaNaam = PizzaNaamInvoer;
            bestelling = BestellingInvoer;
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
            foreach (ColumnHeader col in lvBestelling.Columns)
            {
                wid += col.Width;
            }

            // Pas de ListView en vorm aan
            lvBestelling.Width = wid + 5;
            this.ClientSize = new Size(
                lvBestelling.Right + lvBestelling.Left,
                this.ClientSize.Height);
        }

        //Implementatie: methoden en events
        private void btnBevestigen_Click(object sender, EventArgs e)
        {
            try
            {
                if (txtBestelCode.Text != "" && tbAantal.Text != "" && cbPizzaNm.SelectedItem != null &&
                    cbPizzaGrootteType.SelectedItem != null &&
                    cbPizzaBodemType.SelectedItem != null)
                {

                    //Hoofdverzameling H202 van alle bestelcodes
                    Bestelling BestellingNm = new Bestelling();
                    bestelling.Add(BestellingNm);
                    bestelling[bestelling.Count - 1].BestelCodeH202 = txtBestelCode.Text;

                    //toekenning deelverzameling aan hoofdverzameling
                    bestelling[bestelling.Count - 1].PizzaNaamD201 = cbPizzaNm.SelectedItem.ToString();

                    bestelling[bestelling.Count - 1].PizzaGrootteType = cbPizzaGrootteType.SelectedItem.ToString();
                    bestelling[bestelling.Count - 1].PizzaBodemType = cbPizzaBodemType.SelectedItem.ToString();
                    Int32.TryParse(tbAantal.Text, out int Aantal);
                    bestelling[bestelling.Count - 1].Aantal = Aantal;

                    ListViewItem BestellingItem = new ListViewItem()
                    {
                        Text = bestelling[bestelling.Count - 1].BestelCodeH202
                    };

                    BestellingItem.SubItems.Add(bestelling[bestelling.Count - 1].PizzaNaamD201);
                    BestellingItem.SubItems.Add(bestelling[bestelling.Count - 1].PizzaGrootteType);
                    BestellingItem.SubItems.Add(bestelling[bestelling.Count - 1].PizzaBodemType);
                    BestellingItem.SubItems.Add(bestelling[bestelling.Count - 1].Aantal.ToString());
                    lvBestelling.Items.Add(BestellingItem);

                    // Pas de grootte aan van de velden zodat de gegevens zichtbaar worden 
                    SetListViewColumnSizes(lvBestelling, -1);
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

        private void FrmBestelling_Load(object sender, EventArgs e)
        {
            if(pizzaNaam.Count != 0)
            {
                if(pizzaNaam.Count > 2)
                {
                    for (int i = 0; i < pizzaNaam.Count; i++)
                    {
                        cbPizzaNm.Items.Add(pizzaNaam[i].PizzaNaamH201);

                        if (i < ListStdPizzaGrootteType.Count)
                        {
                            cbPizzaGrootteType.Items.Add(ListStdPizzaGrootteType[i]);
                        }

                        if (i < ListStdPizzaBodemType.Count)
                        {
                            cbPizzaBodemType.Items.Add(ListStdPizzaBodemType[i]);
                        }
                    }
                }
                else
                {
                    for (int i = 0; i < ListStdPizzaGrootteType.Count; i++)
                    {
                        if(i < pizzaNaam.Count)
                        {
                            cbPizzaNm.Items.Add(pizzaNaam[i].PizzaNaamH201);
                        }

                        cbPizzaGrootteType.Items.Add(ListStdPizzaGrootteType[i]);
                        cbPizzaBodemType.Items.Add(ListStdPizzaBodemType[i]);       
                    }
                }
            }
        }

        private void verwijderBestellingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(bestelling.Count != 0 && lvBestelling.SelectedItems.Count != 0)
            {
                bestelling.RemoveAt(lvBestelling.SelectedIndices[0]);
                lvBestelling.Items.RemoveAt(lvBestelling.SelectedIndices[0]);
            }
        }

        private void alleBestellingenVerwijderenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(bestelling.Count != 0)
            {
                lvBestelling.Items.Clear();
                bestelling.Clear();
            }
        }
    }
}
