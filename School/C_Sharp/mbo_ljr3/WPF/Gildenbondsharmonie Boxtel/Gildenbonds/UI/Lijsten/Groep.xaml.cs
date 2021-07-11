/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     Groep.xaml.cs

Omschrijving:    Overzicht van Groepen Personen

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
    /// Interaction logic for Groepen.xaml
    /// </summary>
    public partial class Groep : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstGroepVM lijstGroepVM = new LijstGroepVM();

        //Hieronder is een vaste lijst aan groepen
        //Waarmee de onderstaande combobox gevuld wordt
        List<string> listGroepen = new List<string> { "bestuur", "oud leden", "sponsors", "donateurs", "evenementen", "instrumenten" };

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public Groep()
        {
            InitializeComponent();
            this.DataContext = lijstGroepVM;
            cbxFilterGroep.ItemsSource = listGroepen;
            cbxFilterGroep.SelectedIndex = 0;
        }

        //Implementatie: methoden


        private void UIGroep_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstGroepVM.FilterLijstGroep);
        }

        public void UpdateUI(List<string> listFilter)
        {
            LijstGroepBL lijstGroepBL = new LijstGroepBL();
            DataSet dslijstGroep = new DataSet();

            if (listFilter.Count > 0)
            {
                dslijstGroep = lijstGroepBL.Sort(listFilter);
                if (dslijstGroep.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel " + dslijstGroep.DataSetName + " bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstGroepVM.LijstGroepen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstGroepVM.LijstGroepen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dslijstGroep.Tables[0].Rows)
                    {
                        try
                        {
                            lijstGroepVM.LijstGroepen.Add(new LijstGroepBO
                            {
                                Voornaam = (string)item[0],
                                Voorletters = (string)item[1],
                                Tussenvoegsel = (string)item[2],
                                Achternaam = (string)item[3],
                                Straatnaam = (string)item[4],
                                Straatnummer = (int)item[5],
                                Postcode = (string)item[6],
                                Plaats = (string)item[7],
                                TelefoonNummer = (string)item[8],
                                MobielNummer = (string)item[9],
                                EmailAdres = (string)item[10],
                                Lidnummer = (int)item[11]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset'" + dslijstGroep.DataSetName + "'");
                        }
                    }
                }

            }
            else
            {
                dslijstGroep = lijstGroepBL.Read();
                if (dslijstGroep.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel " + dslijstGroep.DataSetName + " bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstGroepVM.LijstGroepen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstGroepVM.LijstGroepen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dslijstGroep.Tables[0].Rows)
                    {
                        try
                        {
                            lijstGroepVM.LijstGroepen.Add(new LijstGroepBO
                            {
                                Voornaam = (string)item[0],
                                Voorletters = (string)item[1],
                                Tussenvoegsel = (string)item[2],
                                Achternaam = (string)item[3],
                                Straatnaam = (string)item[4],
                                Straatnummer = (int)item[5],
                                Postcode = (string)item[6],
                                Plaats = (string)item[7],
                                TelefoonNummer = (string)item[8],
                                MobielNummer = (string)item[9],
                                EmailAdres = (string)item[10],
                                Lidnummer = (int)item[11]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset'" + dslijstGroep.DataSetName + "'");
                        }
                    }
                }
            }
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstGroepBL LijstGroepBL = new LijstGroepBL();

            if (lijstGroepVM.SelectedGroep != null)
            {
                LijstGroepBL.Select(lijstGroepVM.SelectedGroep);
            }

            switch (ckbFilterVoornaam.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("voornaam");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("voornaam");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterVoorletters.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("voorletters");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("voorletters");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterTussenvoegsel.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("tussenvoegsel");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("tussenvoegsel");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterAchternaam.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("achternaam");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("achternaam");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterStraatnaam.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("straatnaam");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("straatnaam");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterStraatnummer.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("straatnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("straatnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterPostcode.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("postcode");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("postcode");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterPlaats.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("plaats");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("plaats");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterTelefoonNummer.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("telefoonnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("telefoonnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterMobielNummer.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("mobielnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("mobielnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterEmailAdres.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("emailadres");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("emailadres");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }

            switch (ckbFilterLidnummer.IsChecked)
            {
                case true:
                    lijstGroepVM.FilterLijstGroep.Add("lidnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
                case false:
                    lijstGroepVM.FilterLijstGroep.Remove("lidnummer");
                    UpdateUI(lijstGroepVM.FilterLijstGroep);
                    break;
            }
        }
    }
}
