/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     Gildenbonds.xaml.cs

Omschrijving:    Overzicht van verenigingsleden binnen de muziekvereniging Gildenbonds

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
    /// Interaction logic for Gildenbonds.xaml
    /// </summary>
    public partial class Vereniging : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstVerenigingVM lijstVerenigingVM = new LijstVerenigingVM();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //variabel voor het bewaren van gegeven 'tussenvoegsel' uit de Data Access layer
        string tussenvoegsel = "";

        //constructor
        public Vereniging()
        {
            InitializeComponent();
            this.DataContext = lijstVerenigingVM;
        }

        //Implementatie: methoden

        public void UpdateUI(List<string> listFilter)
        {
            LijstVerenigingBL lijstVerenigingBL = new LijstVerenigingBL();
            DataSet dsLijstVereniging = new DataSet();

            if (listFilter.Count > 0)
            {
                dsLijstVereniging = lijstVerenigingBL.Sort(listFilter);
                if (dsLijstVereniging.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Verenigingslid bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstVerenigingVM.LijstVerenigingen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstVerenigingVM.LijstVerenigingen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstVereniging.Tables[0].Rows)
                    {
                        try
                        {
                            if (item[2] != null)
                            {
                                tussenvoegsel = (string)item[3].ToString();
                            }
                            else
                            {
                                tussenvoegsel = "";
                            }

                            lijstVerenigingVM.LijstVerenigingen.Add(new LijstVerenigingBO
                            {
                                Lidnummer = (int)item[0],
                                Voorletters = (string)item[1],
                                Voornaam = (string)item[2],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[4],
                                Straatnaam = (string)item[5],
                                Straatnummer = (int)item[6],
                                Postcode = (string)item[7],
                                Plaats = (string)item[8],
                                TelefoonNummer = (string)item[9],
                                MobielNummer = (string)item[10],
                                EmailAdres = (string)item[11],
                                Instrument = (string)item[12]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Verenigingslid'");
                        }
                    }
                }

            }
            else
            {
                dsLijstVereniging = lijstVerenigingBL.Read();
                if (dsLijstVereniging.Tables.Count == 0)
                {
                    MessageBox.Show("De tabel Verenigingslid bestaat niet of is leeg", "Foutmelding");
                }
                else
                {
                    countList = lijstVerenigingVM.LijstVerenigingen.Count;
                    //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                    for (int i = countList - 1; i >= 0; i--)
                    {
                        lijstVerenigingVM.LijstVerenigingen.RemoveAt(i);
                    }

                    //lus door alle rijen van de tabel
                    foreach (DataRow item in dsLijstVereniging.Tables[0].Rows)
                    {
                        try
                        {
                            if (item[2] != null)
                            {
                                tussenvoegsel = (string)item[3].ToString();
                            }
                            else
                            {
                                tussenvoegsel = "";
                            }

                            lijstVerenigingVM.LijstVerenigingen.Add(new LijstVerenigingBO
                            {

                                Lidnummer = (int)item[0],
                                Voornaam = (string)item[1],
                                Voorletters = (string)item[2],
                                Tussenvoegsel = tussenvoegsel,
                                Achternaam = (string)item[4],
                                Straatnaam = (string)item[5],
                                Straatnummer = (int)item[6],
                                Postcode = (string)item[7],
                                Plaats = (string)item[8],
                                TelefoonNummer = (string)item[9],
                                MobielNummer = (string)item[10],
                                EmailAdres = (string)item[11],
                                Instrument = (string)item[12]
                            });
                        }
                        catch (Exception msg)
                        {
                            MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Verenigingslid'");
                        }
                    }
                }
            }
        }

        private void UIVereniging_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI(lijstVerenigingVM.FilterLijstVereniging);
        }

        private void CheckboxFilter_MouseDown(object sender, MouseButtonEventArgs e)
        {
            LijstVerenigingBL lijstVerenigingBL = new LijstVerenigingBL();
            switch (ckbFilterGroep.IsChecked)
            {
                case true:
                    lijstVerenigingVM.FilterLijstVereniging.Add("groepnaam");
                    UpdateUI(lijstVerenigingVM.FilterLijstVereniging);
                    break;
                case false:
                    lijstVerenigingVM.FilterLijstVereniging.Remove("groepnaam");
                    UpdateUI(lijstVerenigingVM.FilterLijstVereniging);
                    break;
            }
            switch (ckbFilterAchternaam.IsChecked)
            {
                case true:
                    lijstVerenigingVM.FilterLijstVereniging.Add("achternaam");
                    UpdateUI(lijstVerenigingVM.FilterLijstVereniging);
                    break;
                case false:
                    lijstVerenigingVM.FilterLijstVereniging.Remove("achternaam");
                    UpdateUI(lijstVerenigingVM.FilterLijstVereniging);
                    break;
            }
        }

    }
}
