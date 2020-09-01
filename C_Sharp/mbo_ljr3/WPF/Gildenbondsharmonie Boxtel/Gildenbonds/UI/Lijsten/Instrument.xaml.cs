/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     Instrument.xaml.cs

Omschrijving:    Overzicht van Instrumenten

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
    /// Interaction logic for Instrument.xaml
    /// </summary>
    public partial class Instrument : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstInstrumentVM lijstInstrumentVM = new LijstInstrumentVM();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public Instrument()
        {
            InitializeComponent();
            this.DataContext = lijstInstrumentVM;
        }

        //Implementatie: methoden

        public void UpdateUI(List<string> listFilter)
        {
            LijstInstrumentBL lijstInstrumentBL = new LijstInstrumentBL();
            DataSet dsLijstInstrument = new DataSet();

            if (listFilter.Count > 0)
            {
                dsLijstInstrument = lijstInstrumentBL.Sort(listFilter);
                if (dsLijstInstrument.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Instrument bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstInstrumentVM.LijstInstrumenten.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstInstrumentVM.LijstInstrumenten.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstInstrument.Tables[0].Rows)
                    {
                        try
                        {
                            lijstInstrumentVM.LijstInstrumenten.Add(new LijstInstrumentBO
                            {
                                Instrument = (string)item[1],
                                InstrumentType = (string)item[2],
                                Merk = (string)item[3],
                                SerieNummer = (int)item[4],
                                AanschafPrijs = (decimal)item[5],
                                AanschafDatum = (DateTime)item[6],
                                AfschrijvingsDatum = (DateTime)item[7],
                                Leverancier = (string)item[8],
                                Verzekerd = (int)item[9],
                                VerzekeringsWaarde = (decimal)item[10]
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
                dsLijstInstrument = lijstInstrumentBL.Read();
                if (dsLijstInstrument.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Instrument bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstInstrumentVM.LijstInstrumenten.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstInstrumentVM.LijstInstrumenten.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstInstrument.Tables[0].Rows)
                    {
                        try
                        {
                            lijstInstrumentVM.LijstInstrumenten.Add(new LijstInstrumentBO
                            {
                                Instrument = (string)item[1],
                                InstrumentType = (string)item[2],
                                Merk = (string)item[3],
                                SerieNummer = (int)item[4],
                                AanschafPrijs = (decimal)item[5],
                                AanschafDatum = (DateTime)item[6],
                                AfschrijvingsDatum = (DateTime)item[7],
                                Leverancier = (string)item[8],
                                Verzekerd = (int)item[9],
                                VerzekeringsWaarde = (decimal)item[10]
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


        private void UIInstrument_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstEvenementBL lijstInstrumentBL = new LijstEvenementBL();
            switch (ckbFilterInstrumentType.IsChecked)
            {
                case true:
                    lijstInstrumentVM.FilterLijstInstrument.Add("instrument");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
                case false:
                    lijstInstrumentVM.FilterLijstInstrument.Remove("instrument");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
            }
            switch (ckbFilterAanschafprijs.IsChecked)
            {
                case true:
                    lijstInstrumentVM.FilterLijstInstrument.Add("aanschafprijs");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
                case false:
                    lijstInstrumentVM.FilterLijstInstrument.Remove("aanschafprijs");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
            }
            switch (ckbFilterAanschafdatum.IsChecked)
            {
                case true:
                    lijstInstrumentVM.FilterLijstInstrument.Add("aanschafdatum");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
                case false:
                    lijstInstrumentVM.FilterLijstInstrument.Remove("aanschafdatum");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
            }
            switch (ckbFilterAfschrijvingsdatum.IsChecked)
            {
                case true:
                    lijstInstrumentVM.FilterLijstInstrument.Add("afschrijvingsdatum");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
                case false:
                    lijstInstrumentVM.FilterLijstInstrument.Remove("afschrijvingsdatum");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
            }
            switch (ckbFilterVerzekerd.IsChecked)
            {
                case true:
                    lijstInstrumentVM.FilterLijstInstrument.Add("verzekerd");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
                case false:
                    lijstInstrumentVM.FilterLijstInstrument.Remove("verzekerd");
                    UpdateUI(lijstInstrumentVM.FilterLijstInstrument);
                    break;
            }
        }
    }
}
