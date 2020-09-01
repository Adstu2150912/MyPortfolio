/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     PersoonRegistratie.xaml.cs

Omschrijving:    Invulformulier voor het registreren van personen

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
    /// Interaction logic for PersoonRegistratie.xaml
    /// </summary>
    public partial class PersoonRegistratie : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static PersoonVM persoonVM = new PersoonVM();

        //bewaar hier het huidige geselecteerde object voordat het leeg wordt ná het updaten van de UI
        PersoonBO selectedPersoon = new PersoonBO();

        //Hier worden de primaire/vreemde sleutels (ID's) van geselecteerde listviewitem uit de view opgeslagen
        List<int> selectedPersonen = new List<int>();

        //Hieronder staat een vaste lijste aan groepen en een vaste lijst aan groeptypes
        //Waarmee de onderstaande comboboxen gevuld wordt
        List<string> listGroepen = new List<string> { "bestuur", "oud leden", "sponsors", "donateurs", "evenementen", "instrumenten" };
        List<string> listGroepTypes = new List<string> { "intern", "extern"};

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public PersoonRegistratie()
        {
            InitializeComponent();
            this.DataContext = persoonVM;
            cbxGroepNaam.ItemsSource = listGroepen;
            cbxGroepType.ItemsSource = listGroepTypes;
        }


        //Implementatie: methoden

        public void UpdateUI()
        {
            PersoonBL persoonBL = new PersoonBL();
            DataSet dsPersoon= new DataSet();

            dsPersoon = persoonBL.Read();

            if (dsPersoon.Tables.Count == 0)
            {
                MessageBox.Show("De tabel Persoon bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = persoonVM.Personen.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    persoonVM.Personen.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsPersoon.Tables[0].Rows)
                {
                    try
                    {
                        persoonVM.Personen.Add(new PersoonBO
                        {
                            PersoonID = (int)item[0],
                            WoonadresID = (int)item[1],
                            Voorletters = (string)item[2],
                            Voornaam = (string)item[3],
                            Tussenvoegsel = (string)item[4],
                            Achternaam = (string)item[5],
                            Geslacht = (string)item[6],
                            GeboorteDatum = item[7].ToString(),
                            TelefoonNummer = (string)item[8],
                            MobielNummer = (string)item[9],
                            EmailAdres = (string)item[10],
                            GroepNaam = (string)item[11],
                            GroepType = (string)item[12]
                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Persoon'");
                    }
                }
            }
        }

        private void UIPersoonRegistratie_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }

        private void BtnInvoeren_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                persoonVM.SelectedPersoon.Voornaam = txtVoornaam.Text;
                persoonVM.SelectedPersoon.Voorletters = txtVoorletters.Text;
                persoonVM.SelectedPersoon.Tussenvoegsel = txtTussenvoegsel.Text;
                persoonVM.SelectedPersoon.Achternaam = txtAchterNaam.Text;
                persoonVM.SelectedPersoon.GeboorteDatum = dpGeboorteDatum.SelectedDate.Value.ToString("MM/dd/yyyy");

                if(rbGeslachtMan.IsChecked == true)
                {
                    persoonVM.SelectedPersoon.Geslacht = "m";
                }
                else if(rbGeslachtVrouw.IsChecked == true)
                {
                    persoonVM.SelectedPersoon.Geslacht = "v";
                } 

                int.TryParse(txtWoonadresID.Text, out int woonadres);
                persoonVM.SelectedPersoon.WoonadresID = woonadres;
                persoonVM.SelectedPersoon.EmailAdres = txtEmailAdres.Text;
                persoonVM.SelectedPersoon.TelefoonNummer = txtTelefoonNummer.Text;
                persoonVM.SelectedPersoon.MobielNummer = txtMobielNummer.Text;
                persoonVM.SelectedPersoon.GroepNaam = cbxGroepNaam.SelectedValue.ToString();
                persoonVM.SelectedPersoon.GroepType = cbxGroepType.SelectedValue.ToString();


                PersoonBL persoonBL = new PersoonBL();
                persoonBL.Create(persoonVM.SelectedPersoon);

                selectedPersoon = persoonVM.SelectedPersoon;

                //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                //waardoor het geselecteerde listviewitem leeg wordt 
                //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                UpdateUI();

                persoonVM.SelectedPersoon = selectedPersoon;
            }
            catch (Exception msg)
            {
                MessageBox.Show(msg.Message, "Foutmelding invoeren");
            }
        }

        private void BtnBewerken_Click(object sender, RoutedEventArgs e)
        {
            if (lvPersoon.SelectedItems.Count > 0)
            {
                try
                {
                    selectedPersoon = lvPersoon.SelectedItem as PersoonBO;
                    persoonVM.SelectedPersoon.PersoonID = selectedPersoon.PersoonID;

                    persoonVM.SelectedPersoon.Voornaam = txtVoornaam.Text;
                    persoonVM.SelectedPersoon.Voorletters = txtVoorletters.Text;
                    persoonVM.SelectedPersoon.Tussenvoegsel = txtTussenvoegsel.Text;
                    persoonVM.SelectedPersoon.Achternaam = txtAchterNaam.Text;
                    persoonVM.SelectedPersoon.GeboorteDatum = dpGeboorteDatum.SelectedDate.Value.ToString("MM/dd/yyyy");


                    if (rbGeslachtMan.IsChecked == true)
                    {
                        persoonVM.SelectedPersoon.Geslacht = "m";
                    }
                    else if (rbGeslachtVrouw.IsChecked == true)
                    {
                        persoonVM.SelectedPersoon.Geslacht = "v";
                    }

                    int.TryParse(txtWoonadresID.Text, out int woonadres);
                    persoonVM.SelectedPersoon.WoonadresID = woonadres;
                    persoonVM.SelectedPersoon.EmailAdres = txtEmailAdres.Text;
                    persoonVM.SelectedPersoon.TelefoonNummer = txtTelefoonNummer.Text;
                    persoonVM.SelectedPersoon.MobielNummer = txtMobielNummer.Text;
                    persoonVM.SelectedPersoon.GroepNaam = cbxGroepNaam.SelectedValue.ToString();
                    persoonVM.SelectedPersoon.GroepType = cbxGroepType.SelectedValue.ToString();

                    PersoonBL persoonBL = new PersoonBL();
                    persoonBL.Update(persoonVM.SelectedPersoon);

                    selectedPersoon = persoonVM.SelectedPersoon;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    persoonVM.SelectedPersoon = selectedPersoon;

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding bewerken");
                }
            }
        }

        private void BtnVerwijderen_Click(object sender, RoutedEventArgs e)
        {
            if (lvPersoon.SelectedItems.Count > 0)
            {
                try
                {
                    selectedPersoon = lvPersoon.SelectedItem as PersoonBO;

                    PersoonBL persoonBL = new PersoonBL();

                    foreach (PersoonBO persoon in lvPersoon.SelectedItems)
                    {
                        selectedPersonen.Add(persoon.PersoonID);
                    }

                    persoonBL.Delete(selectedPersonen);
                    selectedPersonen.Clear();

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
