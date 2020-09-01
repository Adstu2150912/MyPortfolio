/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     Jubilea.xaml.cs

Omschrijving:    Overzicht van jubilarissen van muziekvereniging Gildenbonds

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
    /// Interaction logic for Jubilea.xaml
    /// </summary>
    public partial class Jubilea : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstJubileaVM lijstJubileaVM = new LijstJubileaVM();

        //Hieronder is een vaste lijst aan jaar lidmaatschappen 
        //Waarmee de onderstaande combobox gevuld wordt
        List<int> listJaarLidmaatschappen = new List<int> {12, 25, 40, 50, 60, 65};

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        public Jubilea()
        {
            InitializeComponent();
            this.DataContext = lijstJubileaVM;
            cbxFilterLidmaatschap.ItemsSource = listJaarLidmaatschappen;
            cbxFilterLidmaatschap.SelectedIndex = 0;
        }

        //Implementatie: methoden

        private void UIJubilea_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstJubileaVM.FilterLijstJubilea);
        }

        public void UpdateUI(List<string> listFilter)
        {
            LijstJubileaBL lijstJubileaBL = new LijstJubileaBL();
            DataSet dsLijstJubilea = new DataSet();

            if (listFilter.Count > 0)
            {
                dsLijstJubilea = lijstJubileaBL.Sort(listFilter);
                if (dsLijstJubilea.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel " + dsLijstJubilea.DataSetName + " bestaat niet of is leeg", "Foutmelding");
                }
                else
                {

                    countList = lijstJubileaVM.LijstJubilarissen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstJubileaVM.LijstJubilarissen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstJubilea.Tables[0].Rows)
                    {
                        try
                        {
                            lijstJubileaVM.LijstJubilarissen.Add(new LijstJubileaBO
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
                                Lidnummer = (int)item[11],
                                Instrument = (string)item[12],
                                StartDatum = (DateTime)item[13],
                                Opmerking = (string)item[14]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset'" + dsLijstJubilea.DataSetName + "'");
                        }
                    }
                }

            }
            else
            {
                dsLijstJubilea = lijstJubileaBL.Read();
                if (dsLijstJubilea.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel " + dsLijstJubilea.DataSetName + " bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstJubileaVM.LijstJubilarissen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstJubileaVM.LijstJubilarissen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstJubilea.Tables[0].Rows)
                    {
                        try
                        {
                            lijstJubileaVM.LijstJubilarissen.Add(new LijstJubileaBO
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
                                Lidnummer = (int)item[11],
                                Instrument = (string)item[12],
                                StartDatum = (DateTime)item[13],
                                Opmerking = (string)item[14]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset'" + dsLijstJubilea.DataSetName + "'");
                        }
                    }
                }
            }
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstJubileaBL lijstJubileaBL = new LijstJubileaBL();

            if (lijstJubileaVM.SelectedLidmaatschap != 0)
            {
                lijstJubileaBL.FilterLidmaatschap(lijstJubileaVM.SelectedLidmaatschap);
            }

            switch (ckbFilterVoornaam.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("voornaam");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("voornaam");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterVoorletters.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("voorletters");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("voorletters");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterTussenvoegsel.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("tussenvoegsel");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("tussenvoegsel");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterAchternaam.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("achternaam");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("achternaam");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterStraatNaam.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("straatnaam");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("straatnaam");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterStraatNummer.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("straatnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("straatnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterPostcode.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("postcode");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("postcode");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterPlaats.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("plaats");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("plaats");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterTelefoonNummer.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("telefoonnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("telefoonnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterMobielNummer.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("mobielnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("mobielnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterEmailAdres.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("emailadres");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("emailadres");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterLidnummer.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("lidnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("lidnummer");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterInstrument.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("instrument");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("instrument");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterStartdatum.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("startdatum");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("startdatum");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }

            switch (ckbFilterOpmerking.IsChecked)
            {
                case true:
                    lijstJubileaVM.FilterLijstJubilea.Add("opmerking");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
                case false:
                    lijstJubileaVM.FilterLijstJubilea.Remove("opmerking");
                    UpdateUI(lijstJubileaVM.FilterLijstJubilea);
                    break;
            }
        }
    }
}
