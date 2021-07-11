/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     JubileaRegistratie.xaml.cs

Omschrijving:    Invulformulier voor het registreren van jubilarissen

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Data; // voor gebruik datasets
using Gildenbondsharmonie.ViewModel; // Voor gebruik van viewmodels
using Gildenbondsharmonie.BOL; //Voor gebruik van business objecten
using Gildenbondsharmonie.BLL; //Voor gebruik van business logic

namespace Gildenbondsharmonie.UI
{
    /// <summary>
    /// Interaction logic for JubileaRegistratie.xaml
    /// </summary>
    public partial class JubileaRegistratie : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static JubileaVM jubileaVM = new JubileaVM();

        //bewaar hier het huidige geselecteerde object voordat het leeg wordt ná het updaten van de UI
        JubileaBO selectedJubilea = new JubileaBO();

        //Hier worden de geselecteerde listviewitems uit de view opgeslagen
        List<int> selectedJubilarissen = new List<int>();
        List<int> selectedVerenigingsleden = new List<int>();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //variabel voor het bewaren van gegeven 'tussenvoegsel' uit de Data Access layer
        string jubileaopmerking= "";

        //constructor
        public JubileaRegistratie()
        {
            InitializeComponent();
            this.DataContext = jubileaVM;
        }

        //Implementatie: methoden

        public void UpdateUI()
        {
            JubileaBL jubileaBL = new JubileaBL();
            DataSet dsJubilea = new DataSet();

            dsJubilea = jubileaBL.Read();

            if (dsJubilea.Tables.Count == 0)
            {
                MessageBox.Show("De tabel Jubilea bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = jubileaVM.Jubilarissen.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    jubileaVM.Jubilarissen.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsJubilea.Tables[0].Rows)
                {
                    try
                    {
                        if (item[2] != null)
                        {
                            jubileaopmerking = (string)item[2].ToString();
                        }
                        else
                        {
                            jubileaopmerking = "";
                        }

                        jubileaVM.Jubilarissen.Add(new JubileaBO
                        {
                            JubileaID = (int)item[0],
                            Naam = (string)item[1],
                            Omschrijving = jubileaopmerking,
                            VerenigingslidID = (int)item[3],
                            JubileaOpmerking = (string)item[4],
                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset'Jubilea'");
                    }
                }
            }
        }

        private void UIJubileaRegistratie_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }

        private void BtnInvoeren_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                jubileaVM.SelectedJubilea.Naam= txtNaam.Text;
                jubileaVM.SelectedJubilea.Omschrijving= txtOmschrijving.Text;
                int.TryParse(txtVerenigingslidID.Text, out int verenigingslidID);
                jubileaVM.SelectedJubilea.VerenigingslidID = verenigingslidID;
                jubileaVM.SelectedJubilea.JubileaOpmerking = txtJubileaOpmerking.Text;


                JubileaBL jubileaBL = new JubileaBL();
                jubileaBL.Create(jubileaVM.SelectedJubilea);

                selectedJubilea = jubileaVM.SelectedJubilea;

                //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                //waardoor het geselecteerde listviewitem leeg wordt 
                //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                UpdateUI();

                jubileaVM.SelectedJubilea = selectedJubilea;
            }
            catch (Exception msg)
            {
                MessageBox.Show(msg.Message, "Foutmelding invoeren");
            }
        }

        private void BtnBewerken_Click(object sender, RoutedEventArgs e)
        {
            if (lvJubilea.SelectedItems.Count > 0)
            {
                try
                {
                    selectedJubilea = lvJubilea.SelectedItem as JubileaBO;
                    jubileaVM.SelectedJubilea.JubileaID= selectedJubilea.JubileaID;

                    jubileaVM.SelectedJubilea.Naam = txtNaam.Text;
                    jubileaVM.SelectedJubilea.Omschrijving= txtOmschrijving.Text;
                    int.TryParse(txtVerenigingslidID.Text, out int verenigingslidID);
                    jubileaVM.SelectedJubilea.VerenigingslidID= verenigingslidID;
                    jubileaVM.SelectedJubilea.JubileaOpmerking = txtJubileaOpmerking.Text;

                    JubileaBL jubileaBL = new JubileaBL();
                    jubileaBL.Update(jubileaVM.SelectedJubilea);

                    selectedJubilea = jubileaVM.SelectedJubilea;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    jubileaVM.SelectedJubilea= selectedJubilea;

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding bewerken");
                }
            }
        }

        private void BtnVerwijderen_Click(object sender, RoutedEventArgs e)
        {
            if (lvJubilea.SelectedItems.Count > 0)
            {
                try
                {
                    selectedJubilea = lvJubilea.SelectedItem as JubileaBO;

                    JubileaBL jubileaBL = new JubileaBL();

                    foreach (JubileaBO jubilea in lvJubilea.SelectedItems)
                    {
                        selectedJubilarissen.Add(jubilea.JubileaID);
                        selectedVerenigingsleden.Add(jubilea.VerenigingslidID);
                    }

                    jubileaBL.Delete(selectedJubilarissen, selectedVerenigingsleden);
                    selectedJubilarissen.Clear();

                    UpdateUI();

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding Verwijderen");
                }
            }
        }
    }
}
