/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     WoonadresRegistratie.xaml.cs

Omschrijving:    Invulformulier voor het registreren van woonadressen

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
    /// Interaction logic for WoonadresRegistratie.xaml
    /// </summary>
    public partial class WoonadresRegistratie : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static WoonadresVM woonadresVM = new WoonadresVM();

        //bewaar hier het huidige geselecteerde object voordat het leeg wordt ná het updaten van de UI
        WoonadresBO selectedWoonadres = new WoonadresBO();

        //Hier worden de primaire/vreemde sleutels (ID's) van geselecteerde listviewitem uit de view opgeslagen
        List<int> selectedWoonadressen = new List<int>();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public WoonadresRegistratie()
        {
            InitializeComponent();
            this.DataContext = woonadresVM;
        }

        //Implementatie: methoden

        public void UpdateUI()
        {
            WoonadresBL woonadresBL = new WoonadresBL();
            DataSet dsWoonadres = new DataSet();

            dsWoonadres = woonadresBL.Read();

            if (dsWoonadres.Tables.Count == 0)
            {
                MessageBox.Show("De tabel Woonadres bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = woonadresVM.Woonadresen.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    woonadresVM.Woonadresen.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsWoonadres.Tables[0].Rows)
                {
                    try
                    {
                        woonadresVM.Woonadresen.Add(new WoonadresBO
                        {
                            Straatnaam = (string)item[1],
                            Straatnummer = (int)item[2],
                            Postcode = (string)item[3],
                            Plaats = (string)item[4]
                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Woonadres'");
                    }
                }
            }
        }

        private void UIWoonadresRegistratie_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }

        private void BtnInvoeren_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                woonadresVM.SelectedWoonadres.Straatnaam= txtStraatnaam.Text;
                int.TryParse(txtStraatnummer.Text, out int straatnummer);
                woonadresVM.SelectedWoonadres.Straatnummer = straatnummer;
                woonadresVM.SelectedWoonadres.Postcode = txtPostcode.Text;
                woonadresVM.SelectedWoonadres.Plaats = txtPlaats.Text;


                WoonadresBL woonadresBL = new WoonadresBL();
                woonadresBL.Create(woonadresVM.SelectedWoonadres);

                selectedWoonadres = woonadresVM.SelectedWoonadres;

                //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                //waardoor het geselecteerde listviewitem leeg wordt 
                //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                UpdateUI();

                woonadresVM.SelectedWoonadres = selectedWoonadres;
            }
            catch (Exception msg)
            {
                MessageBox.Show(msg.Message, "Foutmelding invoeren");
            }
        }

        private void BtnBewerken_Click(object sender, RoutedEventArgs e)
        {
            if(lvWoonadres.SelectedItems.Count > 0)
            {
                try
                {
                    selectedWoonadres = lvWoonadres.SelectedItem as WoonadresBO;
                    woonadresVM.SelectedWoonadres.WoonadresID= selectedWoonadres.WoonadresID;

                    woonadresVM.SelectedWoonadres.Straatnaam = txtStraatnaam.Text;
                    int.TryParse(txtStraatnummer.Text, out int straatnummer);
                    woonadresVM.SelectedWoonadres.Straatnummer = straatnummer;
                    woonadresVM.SelectedWoonadres.Postcode = txtPostcode.Text;
                    woonadresVM.SelectedWoonadres.Plaats = txtPlaats.Text;


                    WoonadresBL woonadresBL = new WoonadresBL();
                    woonadresBL.Update(woonadresVM.SelectedWoonadres);

                    selectedWoonadres = woonadresVM.SelectedWoonadres;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    woonadresVM.SelectedWoonadres = selectedWoonadres;
                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding invoeren");
                }
            }
        }

        private void BtnVerwijderen_Click(object sender, RoutedEventArgs e)
        {
            if (lvWoonadres.SelectedItems.Count > 0)
            {
                try
                {
                    selectedWoonadres = lvWoonadres.SelectedItem as WoonadresBO;

                    WoonadresBL woonadresBL= new WoonadresBL();

                    foreach (WoonadresBO woonadres in lvWoonadres.SelectedItems)
                    {
                        selectedWoonadressen.Add(woonadres.WoonadresID);
                    }

                    woonadresBL.Delete(selectedWoonadressen);
                    selectedWoonadressen.Clear();

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
