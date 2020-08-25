/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     Evenement.xaml.cs

Omschrijving:    Overzicht van Evenementen

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
    /// Interaction logic for Evenement.xaml
    /// </summary>
    public partial class Evenement : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstEvenementVM lijstEvenementVM= new LijstEvenementVM();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public Evenement()
        {
            InitializeComponent();
            this.DataContext = lijstEvenementVM;
        }


        //Implementatie: methoden


        public void UpdateUI(List<string> listFilter)
        {
            LijstEvenementBL lijstEvenementBL = new LijstEvenementBL();
            DataSet dsLijstEvenement = new DataSet();

            if(listFilter.Count > 0)
            {
                dsLijstEvenement = lijstEvenementBL.Sort(listFilter);
                if (dsLijstEvenement.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Evenement bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstEvenementVM.LijstEvenementen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstEvenementVM.LijstEvenementen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstEvenement.Tables[0].Rows)
                    {
                        try
                        {
                            lijstEvenementVM.LijstEvenementen.Add(new LijstEvenementBO
                            {
                                EvenementNaam = (string)item[0],
                                EvenementType = (string)item[1],
                                BeginDatum = (DateTime)item[2],
                                EindDatum = (DateTime)item[3],
                                BeginTijd = (DateTime)item[4],
                                EindTijd = (DateTime)item[5],
                                Locatie = (string)item[6],
                                Beschrijving = (string)item[7]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Evenement'");
                        }
                    }
                }

            }
            else
            {
                dsLijstEvenement = lijstEvenementBL.Read();
                if (dsLijstEvenement.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel " + dsLijstEvenement.DataSetName + " bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstEvenementVM.LijstEvenementen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstEvenementVM.LijstEvenementen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstEvenement.Tables[0].Rows)
                    {
                        try
                        {
                            lijstEvenementVM.LijstEvenementen.Add(new LijstEvenementBO
                            {
                                EvenementNaam = (string)item[0],
                                EvenementType = (string)item[1],
                                BeginDatum = (DateTime)item[2],
                                EindDatum = (DateTime)item[3],
                                BeginTijd = (DateTime)item[4],
                                EindTijd = (DateTime)item[5],
                                Locatie = (string)item[6],
                                Beschrijving = (string)item[7]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Evenement'");
                        }
                    }
                }
            }
        }

        private void UIEvenement_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstEvenementVM.FilterLijstEvenement);
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstEvenementBL lijstEvenementBL = new LijstEvenementBL();
            switch (ckbFilterBeginDatum.IsChecked)
            {
                case true:
                    lijstEvenementVM.FilterLijstEvenement.Add("begindatum");
                    UpdateUI(lijstEvenementVM.FilterLijstEvenement);
                    break;
                case false:
                    lijstEvenementVM.FilterLijstEvenement.Remove("begindatum");
                    UpdateUI(lijstEvenementVM.FilterLijstEvenement);
                    break;
            }
            switch (ckbFilterEindDatum.IsChecked)
            {
                case true:
                    lijstEvenementVM.FilterLijstEvenement.Add("einddatum");
                    UpdateUI(lijstEvenementVM.FilterLijstEvenement);
                    break;
                case false:
                    lijstEvenementVM.FilterLijstEvenement.Remove("einddatum");
                    UpdateUI(lijstEvenementVM.FilterLijstEvenement);
                    break;
            }
            switch (ckbFilterEvenementType.IsChecked)
            {
                case true:
                    lijstEvenementVM.FilterLijstEvenement.Add("evenementtype");
                    UpdateUI(lijstEvenementVM.FilterLijstEvenement);
                    break;
                case false:
                    lijstEvenementVM.FilterLijstEvenement.Remove("evenementtype");
                    UpdateUI(lijstEvenementVM.FilterLijstEvenement);
                    break;
            }
        }
    }
}
