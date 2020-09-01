/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     InstrumentGebruik.xaml.cs

Omschrijving:    Overzicht van Instrumenten die gebruikt worden door verenigingsleden

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
    /// Interaction logic for InstrumentGebruik.xaml
    /// </summary>
    public partial class InstrumentGebruik : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstInstrumentGebruikVM lijstInstrumentGebruikVM = new LijstInstrumentGebruikVM();
        
        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //variabel voor het bewaren van gegeven 'tussenvoegsel' uit de Data Access layer
        string tussenvoegsel = "";

        //constructor
        public InstrumentGebruik()
        {
            InitializeComponent();
            this.DataContext = lijstInstrumentGebruikVM;
        }


        //Implementatie: methoden

        public void UpdateUI(List<string> listFilter)
        {
            LijstPersoonInstrumentBL lijstPersonenInstrumentBL = new LijstPersoonInstrumentBL();
            DataSet dsLijstInstrumentGebruik = new DataSet();

            if (listFilter.Count > 0)
            {
                dsLijstInstrumentGebruik = lijstPersonenInstrumentBL.Sort(listFilter);
                if (dsLijstInstrumentGebruik.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Instrument bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstInstrumentGebruikVM.LijstInstrumentGebruiken.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstInstrumentGebruikVM.LijstInstrumentGebruiken.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstInstrumentGebruik.Tables[0].Rows)
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

                            lijstInstrumentGebruikVM.LijstInstrumentGebruiken.Add(new LijstPersonenInstrumentBO
                            {
                                Voornaam = (string)item[0],
                                Voorletters = (string)item[1],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[3],
                                Instrument = (string)item[4],
                                InstrumentType = (string)item[5],
                                Merk = (string)item[6],
                                SerieNummer = (int)item[7]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Instrument'");
                        }
                    }
                }

            }
            else
            {
                dsLijstInstrumentGebruik = lijstPersonenInstrumentBL.Read();
                if (dsLijstInstrumentGebruik.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Instrument bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstInstrumentGebruikVM.LijstInstrumentGebruiken.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstInstrumentGebruikVM.LijstInstrumentGebruiken.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstInstrumentGebruik.Tables[0].Rows)
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

                            lijstInstrumentGebruikVM.LijstInstrumentGebruiken.Add(new LijstPersonenInstrumentBO
                            {
                                Voornaam = (string)item[0],
                                Voorletters = (string)item[1],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[3],
                                Instrument = (string)item[4],
                                InstrumentType = (string)item[5],
                                Merk = (string)item[6],
                                SerieNummer = (int)item[7]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Instrument'");
                        }
                    }
                }
            }
        }

        private void UIInstrumentGebruik_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik);
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstEvenementBL lijstInstrumentBL = new LijstEvenementBL();
            switch (ckbFilterInstrumentType.IsChecked)
            {
                case true:
                    lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik.Add("instrumenttype");
                    UpdateUI(lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik);
                    break;
                case false:
                    lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik.Remove("instrumenttype");
                    UpdateUI(lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik);
                    break;
            }
            switch (ckbFilterAchternaam.IsChecked)
            {
                case true:
                    lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik.Add("achternaam");
                    UpdateUI(lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik);
                    break;
                case false:
                    lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik.Remove("achternaam");
                    UpdateUI(lijstInstrumentGebruikVM.FilterLijstInstrumentGebruik);
                    break;
            }
        }
    }
}
