/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     KNMO.xaml.cs

Omschrijving:    Overzicht van verenigingsleden Gildenbonds voor de organisatie KNMO

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
    /// Interaction logic for KNMO.xaml
    /// </summary>
    public partial class KNMO : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstKNMOVM lijstKNMOVM = new LijstKNMOVM();

        //Hierin wordt een geboortejaar tijdelijk bewaard 
        // totdat het in de lijst aan geboortejaren van de viewmodel is gevuld
        int geboorteJaar;
        DateTime geboorteDatum;

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //variabel voor het bewaren van gegeven 'tussenvoegsel' uit de Data Access layer
        string tussenvoegsel = "";

        //constructor
        public KNMO()
        {
            InitializeComponent();
            this.DataContext = lijstKNMOVM;
        }

        //Implementatie: methoden

        private void UIKNMO_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstKNMOVM.FilterLijstKNMO);
        }

        public void UpdateUI(List<string> listFilter)
        {
            LijstKNMOBL lijstKNMOBL = new LijstKNMOBL();
            DataSet dslijstKNMO = new DataSet();

            if (listFilter.Count > 0)
            {
                dslijstKNMO = lijstKNMOBL.Sort(listFilter);
                if (dslijstKNMO.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel KNMO bestaat niet of is leeg", "Foutmelding");
                }
                else
                {

                    countList = lijstKNMOVM.LijstKNMO.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstKNMOVM.LijstKNMO.RemoveAt(i);
                    }

                    lijstKNMOVM.LijstGeboorteJaren.Clear();

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dslijstKNMO.Tables[0].Rows)
                    {
                        try
                        {
                            geboorteDatum = (DateTime)item[3];
                            if (item[1] != null)
                            {
                                tussenvoegsel = (string)item[1].ToString();
                            }
                            else
                            {
                                tussenvoegsel = "";
                            }

                            lijstKNMOVM.LijstKNMO.Add(new LijstKNMOBO
                            {

                                Voorletters = (string)item[0],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[2],
                                GeboorteDatum = geboorteDatum,
                                Geslacht = (string)item[4],
                                Instrument = (string)item[5]
                            });

                            geboorteJaar = geboorteDatum.Year;
                            lijstKNMOVM.LijstGeboorteJaren.Add(geboorteJaar);
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'KNMO'");
                        }
                    }
                }

            }
            else
            {
                dslijstKNMO = lijstKNMOBL.Read();
                if (dslijstKNMO.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel KNMO bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstKNMOVM.LijstKNMO.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstKNMOVM.LijstKNMO.RemoveAt(i);
                    }

                    lijstKNMOVM.LijstGeboorteJaren.Clear();

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dslijstKNMO.Tables[0].Rows)
                    {
                        try
                        {
                            geboorteDatum = (DateTime)item[3];
                            if (item[1] != null)
                            {
                                tussenvoegsel = (string)item[1].ToString();
                            }
                            else
                            {
                                tussenvoegsel = "";
                            }

                            lijstKNMOVM.LijstKNMO.Add(new LijstKNMOBO
                            {
                                Voorletters = (string)item[0],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[2],
                                GeboorteDatum = geboorteDatum,
                                Geslacht = (string)item[4],
                                Instrument = (string)item[5].ToString()
                            });

                            geboorteJaar = geboorteDatum.Year;
                            lijstKNMOVM.LijstGeboorteJaren.Add(geboorteJaar);
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'KNMO'");
                        }
                    }
                }
            }
        }

        private void FilterOrder()
        {
            switch (rbDescending.IsChecked)
            {
                case true:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("DESC") == false)
                    {
                        if (lijstKNMOVM.FilterLijstKNMO.Contains("ASC") == true)
                        {
                            lijstKNMOVM.FilterLijstKNMO.Remove("ASC");
                        }
                        lijstKNMOVM.FilterLijstKNMO.Add("DESC");
                    }
                    else
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("DESC");
                        if (lijstKNMOVM.FilterLijstKNMO.Count > 0)
                        {
                            lijstKNMOVM.FilterLijstKNMO.Add("DESC");
                        }
                    }
                    break;
                case false:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("DESC") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("DESC");
                    }
                    break;
            }

            switch (rbAscending.IsChecked)
            {
                case true:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("ASC") == false)
                    {
                        if (lijstKNMOVM.FilterLijstKNMO.Contains("DESC") == true)
                        {
                            lijstKNMOVM.FilterLijstKNMO.Remove("DESC");
                        }
                        lijstKNMOVM.FilterLijstKNMO.Add("ASC");
                    }
                    else
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("ASC");
                        if(lijstKNMOVM.FilterLijstKNMO.Count > 0)
                        {
                            lijstKNMOVM.FilterLijstKNMO.Add("ASC");
                        }                       
                    }
                    break;
                case false:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("ASC") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("ASC");
                    }
                    break;
            }

        }

        private void CheckboxFilter_Click(object sender, RoutedEventArgs e)
        {
            LijstKNMOBL lijstKNMOBL = new LijstKNMOBL();
            DataSet dslijstKNMO = new DataSet();

            if (lijstKNMOVM.SelectedJaar > 0)
            {
                dslijstKNMO = lijstKNMOBL.Select(lijstKNMOVM.SelectedJaar);
                if (dslijstKNMO.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel KNMO bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstKNMOVM.LijstKNMO.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstKNMOVM.LijstKNMO.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dslijstKNMO.Tables[0].Rows)
                    {
                        try
                        {
                            geboorteDatum = (DateTime)item[3];
                            lijstKNMOVM.LijstKNMO.Add(new LijstKNMOBO
                            {
                                Voorletters = (string)item[0],
                                Tussenvoegsel = (string)item[1],
                                Achternaam = (string)item[2],
                                GeboorteDatum = geboorteDatum,
                                Geslacht = (string)item[4],
                                Instrument = (string)item[5]
                            });

                            geboorteJaar = geboorteDatum.Year;
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'KNMO'");
                        }
                    }
                }
            }

            switch (ckbFilterVoorletters.IsChecked)
            {
                case true:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("voorletters") == false)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Add("voorletters");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);                      
                    }                    
                    break;
                case false:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("voorletters") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("voorletters");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
            }

            switch (ckbFilterTussenvoegsel.IsChecked)
            {
                case true:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("tussenvoegsel") == false)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Add("tussenvoegsel");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
                case false:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("tussenvoegsel") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("tussenvoegsel");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
            }

            switch (ckbFilterAchternaam.IsChecked)
            {
                case true:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("achternaam") == false)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Add("achternaam");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
                case false:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("achternaam") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("achternaam");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
            }

            switch (ckbFilterGeboorteDatum.IsChecked)
            {
                case true:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("geboortedatum") == false)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Add("geboortedatum");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
                case false:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("geboortedatum") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("geboortedatum");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
            }

            switch (ckbFilterGeslacht.IsChecked)
            {
                case true:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("geslacht") == false)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Add("geslacht");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
                case false:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("geslacht") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("geslacht");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
            }

            switch (ckbFilterInstrument.IsChecked)
            {
                case true:
                    if(lijstKNMOVM.FilterLijstKNMO.Contains("instrument") == false)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Add("instrument");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
                case false:
                    if (lijstKNMOVM.FilterLijstKNMO.Contains("instrument") == true)
                    {
                        lijstKNMOVM.FilterLijstKNMO.Remove("instrument");
                        FilterOrder();
                        UpdateUI(lijstKNMOVM.FilterLijstKNMO);
                    }
                    break;
            }
        }
    }
}
