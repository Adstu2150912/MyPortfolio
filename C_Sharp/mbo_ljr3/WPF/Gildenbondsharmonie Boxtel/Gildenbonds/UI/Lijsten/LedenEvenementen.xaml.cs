/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     LedeninEvenement.xaml.cs

Omschrijving:    Overzicht van verenigingsleden die evenementen hebben bijgewoond

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
    /// Interaction logic for LedeninEvenement.xaml
    /// </summary>
    public partial class LedenEvenementen : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstLedenEvenementVM lijstLedenEvenementVM = new LijstLedenEvenementVM();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //variabel voor het bewaren van gegeven 'tussenvoegsel' uit de Data Access layer
        string tussenvoegsel = "";

        //constructor
        public LedenEvenementen()
        {
            InitializeComponent();
            this.DataContext = lijstLedenEvenementVM;
        }

        //Implementatie: methoden

        public void UpdateUI(List<string> listFilter)
        {
            LijstPersoonEvenementBL lijstLedenEvenementBL = new LijstPersoonEvenementBL();
            DataSet dsLijstLedenEvenement = new DataSet();

            if (listFilter.Count > 0)
            {
                dsLijstLedenEvenement = lijstLedenEvenementBL.Sort(listFilter);
                if (dsLijstLedenEvenement.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Evenement/Persoon bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstLedenEvenementVM.LijstLedenEvenementen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstLedenEvenementVM.LijstLedenEvenementen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstLedenEvenement.Tables[0].Rows)
                    {
                        try
                        {
                            if (item[2] != null)
                            {
                                tussenvoegsel = (string)item[2].ToString();
                            }
                            else
                            {
                                tussenvoegsel = "";
                            }

                            lijstLedenEvenementVM.LijstLedenEvenementen.Add(new LijstPersonenEvenementBO
                            {
                                Voornaam = (string)item[0],
                                Voorletters = (string)item[1],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[3],
                                EvenementNaam = (string)item[4],
                                EvenementType = (string)item[5],
                                BeginDatum = (string)item[6].ToString(),
                                EindDatum = (string)item[7].ToString()
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Evenement/Persoon'");
                        }
                    }
                }

            }
            else
            {
                dsLijstLedenEvenement = lijstLedenEvenementBL.Read();
                if (dsLijstLedenEvenement.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Evenement/Persoon bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstLedenEvenementVM.LijstLedenEvenementen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstLedenEvenementVM.LijstLedenEvenementen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstLedenEvenement.Tables[0].Rows)
                    {
                        try
                        {
                            if (item[2] != null)
                            {
                                tussenvoegsel = (string)item[2].ToString();
                            }
                            else
                            {
                                tussenvoegsel = "";
                            }

                            lijstLedenEvenementVM.LijstLedenEvenementen.Add(new LijstPersonenEvenementBO
                            {
                                Voornaam = (string)item[0],
                                Voorletters = (string)item[1],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[3],
                                EvenementNaam = (string)item[4],
                                EvenementType = (string)item[5],
                                BeginDatum = (string)item[6].ToString(),
                                EindDatum = (string)item[7].ToString()
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Evenement/Persoon'");
                        }
                    }
                }

            }
        }

        private void UILedenEvenementen_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstPersoonEvenementBL lijstPersonenEvenementBL = new LijstPersoonEvenementBL();
            switch (ckbFilterEvenementNaam.IsChecked)
            {
                case true:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Add("evenementnaam");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
                case false:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Remove("evenementnaam");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
            }
            switch (ckbFilterAchternaam.IsChecked)
            {
                case true:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Add("achternaam");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
                case false:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Remove("achternaam");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
            }
            switch (ckbFilterBeginDatum.IsChecked)
            {
                case true:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Add("begindatum");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
                case false:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Remove("begindatum");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
            }
            switch (ckbFilterEindDatum.IsChecked)
            {
                case true:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Add("einddatum");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
                case false:
                    lijstLedenEvenementVM.FilterLijstLedenEvenement.Remove("einddatum");
                    UpdateUI(lijstLedenEvenementVM.FilterLijstLedenEvenement);
                    break;
            }
        }
    }
}
