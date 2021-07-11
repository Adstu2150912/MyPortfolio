/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     Verjaardag.xaml.cs

Omschrijving:    Overzicht van verjaardagen verenigingsleden Gildenbonds

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
    /// Interaction logic for Verjaardag.xaml
    /// </summary>
    public partial class Verjaardag : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        LijstVerjaardagVM lijstVerjaardagVM = new LijstVerjaardagVM();

        //Hierin wordt een geboortemaand tijdelijk bewaard 
        // totdat het in de lijst aan geboortemaanden van de viewmodel is gevuld
        int geboorteMaand;
        DateTime geboorteDatum;

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public Verjaardag()
        {
            InitializeComponent();
            this.DataContext = lijstVerjaardagVM;
        }

        //Implementatie: methoden

        private void UIVerjaardag_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
        }

        public void UpdateUI(List<string> listFilter)
        {
            LijstVerjaardagBL lijstVerjaardagBL = new LijstVerjaardagBL();
            DataSet dsLijstVerjaardag = new DataSet();

            if (listFilter.Count > 0)
            {
                dsLijstVerjaardag = lijstVerjaardagBL.Sort(listFilter);
                if (dsLijstVerjaardag.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Verjaadag bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstVerjaardagVM.LijstVerjaardagen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstVerjaardagVM.LijstVerjaardagen.RemoveAt(i);
                    }

                    lijstVerjaardagVM.LijstGeboorteMaanden.Clear();

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstVerjaardag.Tables[0].Rows)
                    {
                        try
                        {
                            geboorteDatum = (DateTime)item[3];
                            lijstVerjaardagVM.LijstVerjaardagen.Add(new LijstVerjaardagBO
                            {
                                Voornaam = (string)item[0],
                                Tussenvoegsel = (string)item[1],
                                Achternaam = (string)item[2],
                                GeboorteDatum = geboorteDatum,
                                Instrument = (string)item[4]
                            });

                            geboorteMaand = geboorteDatum.Month;
                            lijstVerjaardagVM.LijstGeboorteMaanden.Add(geboorteMaand);
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Verjaardag'");
                        }
                    }
                }

            }
            else
            {
                dsLijstVerjaardag = lijstVerjaardagBL.Read();
                if (dsLijstVerjaardag.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel " + dsLijstVerjaardag.DataSetName + " bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstVerjaardagVM.LijstVerjaardagen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstVerjaardagVM.LijstVerjaardagen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstVerjaardag.Tables[0].Rows)
                    {
                        try
                        {
                            lijstVerjaardagVM.LijstVerjaardagen.Add(new LijstVerjaardagBO
                            {
                                Voornaam = (string)item[0],
                                Tussenvoegsel = (string)item[1],
                                Achternaam = (string)item[2],
                                GeboorteDatum = (DateTime)item[3],
                                Instrument = (string)item[4]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Verjaardag'");
                        }
                    }
                }
            }
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstKNMOBL lijstGroepBL = new LijstKNMOBL();

            if (lijstVerjaardagVM.SelectedMaand != 0)
            {
                lijstGroepBL.Select(lijstVerjaardagVM.SelectedMaand);
            }

            switch (ckbFilterVoornaam.IsChecked)
            {
                case true:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Add("voornaam");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
                case false:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Remove("voornaam");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
            }

            switch (ckbFilterTussenvoegsel.IsChecked)
            {
                case true:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Add("tussenvoegsel");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
                case false:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Remove("tussenvoegsel");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
            }

            switch (ckbFilterAchternaam.IsChecked)
            {
                case true:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Add("achternaam");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
                case false:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Remove("achternaam");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
            }

            switch (ckbFilterGeboorteDatum.IsChecked)
            {
                case true:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Add("geboortedatum");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
                case false:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Remove("geboortedatum");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
            }

            switch (ckbFilterInstrument.IsChecked)
            {
                case true:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Add("instrument");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
                case false:
                    lijstVerjaardagVM.FilterLijstVerjaardag.Remove("instrument");
                    UpdateUI(lijstVerjaardagVM.FilterLijstVerjaardag);
                    break;
            }
        }
    }
}
