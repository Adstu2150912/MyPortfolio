/************************** Module Header *******************************\
Project:         H25 - Windows Forms Dominos
Auteur:          Adam Oubelkas
Aanmaakdatum:    2 mei 2018
Module naam:     FrmPizzaNaam.cs

Omschrijving:    Formuliervenster Pizza(s) Taak Domino's

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
    public partial class FrmPizzaNaam : Form
    {
        private List<PizzaNaam> PizzaNaam;
        private List<string> ListStandaardPizza = new List<string>() {"Hawai", "Hot Pepperoni", "Extravaganzza"};

        //constructor
        public FrmPizzaNaam(List<PizzaNaam> PizzaNaamInvoer)
        {
            InitializeComponent();
            PizzaNaam = PizzaNaamInvoer;
            if (PizzaNaam.Count == 0)
            {
                for (int i = 0; i < ListStandaardPizza.Count; i++)
                {
                    PizzaNaam Pizza = new PizzaNaam();
                    PizzaNaam.Add(Pizza);
                    PizzaNaam[PizzaNaam.Count - 1].PizzaNaamH201 = ListStandaardPizza[i];
                }
            }
        }

        ////Implementatie: methoden en events
        private void FrmPizzaNaam_Load(object sender, EventArgs e)
        {
            if(PizzaNaam.Count != 0)
            {
                for(int i = 0; i < PizzaNaam.Count; i++)
                {
                    ListViewItem ListViewItemPizzaItem = new ListViewItem(PizzaNaam[i].PizzaNaamH201);
                    lvPizzaNaam.Items.Add(ListViewItemPizzaItem);
                }
            }
        }

        private void btnBevestigen_Click(object sender, EventArgs e)
        {            

            if(txtPizzaNaam.Text != "")
            {
                //Hoofdverzameling H201 van alle pizzanamen
                PizzaNaam Pizza = new PizzaNaam();
                PizzaNaam.Add(Pizza);
                PizzaNaam[PizzaNaam.Count - 1].PizzaNaamH201 = txtPizzaNaam.Text;
                ListViewItem PizzaItem = new ListViewItem(PizzaNaam[PizzaNaam.Count - 1].PizzaNaamH201);
                lvPizzaNaam.Items.Add(PizzaItem);
            }
            else
            {
                MessageBox.Show("Foutmelding:\nU heeft het formulier niet volledig ingevuld\nProbeer het opnieuw");
            }

        }

        private void verwijderPizzaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(PizzaNaam.Count != 0 && lvPizzaNaam.SelectedItems.Count != 0)
            {
                PizzaNaam.RemoveAt(lvPizzaNaam.SelectedIndices[0]);
                lvPizzaNaam.Items.RemoveAt(lvPizzaNaam.SelectedIndices[0]);
            }
        }

        private void allePizzasVerwijderenToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(PizzaNaam.Count != 0)
            {
                lvPizzaNaam.Items.Clear();
                PizzaNaam.Clear();
            }
        }
    }
}

