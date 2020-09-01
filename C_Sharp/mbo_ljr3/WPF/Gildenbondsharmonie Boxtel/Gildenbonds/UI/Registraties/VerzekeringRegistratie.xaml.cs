/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     VerzekeringRegistratie.xaml.cs

Omschrijving:    Invulformulier voor het registreren van Verzekeringen

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
    /// Interaction logic for VerzekeringRegistratie.xaml
    /// </summary>
    public partial class VerzekeringRegistratie : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static VerzekeringVM verzekeringVM = new VerzekeringVM();

        //bewaar hier het huidige geselecteerde object voordat het leeg wordt ná het updaten van de UI
        VerzekeringBO selectedVerzekering = new VerzekeringBO();

        //Hier worden de primaire/vreemde sleutels (ID's) van geselecteerde listviewitem uit de view opgeslagen
        List<int> selectedVerzekeringen = new List<int>();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public VerzekeringRegistratie()
        {
            InitializeComponent();
            this.DataContext = verzekeringVM;
        }

        //Implementatie: methoden

        public void UpdateUI()
        {
            VerzekeringBL verzekeringBL = new VerzekeringBL();
            DataSet dsverzekering = new DataSet();

            dsverzekering = verzekeringBL.Read();

            if (dsverzekering.Tables.Count == 0)
            {
                MessageBox.Show("De tabel Verzekering bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = verzekeringVM.Verzekeringen.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    verzekeringVM.Verzekeringen.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsverzekering.Tables[0].Rows)
                {
                    try
                    {
                        verzekeringVM.Verzekeringen.Add(new VerzekeringBO
                        {
                            Serienummer = (int)item[1],
                            Aanschafprijs = (decimal)item[2],
                            Aanschafdatum = (DateTime)item[3],
                            Afschrijvingsdatum = (DateTime)item[4],
                            Leverancier = (string)item[5],
                            Verzekerd = (int)item[6],
                            Verzekeringswaarde = (decimal)item[7]

                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Verzekering'");
                    }
                }
            }
        }

        private void UIVerzekeringRegistratie_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }

        private void BtnInvoeren_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int.TryParse(txtSerieNummer.Text, out int SerieNummer);
                verzekeringVM.SelectedVerzekering.Serienummer = SerieNummer;
                decimal.TryParse(txtAanschafprijs.Text, out decimal Aanschafprijs);
                verzekeringVM.SelectedVerzekering.Aanschafprijs = Aanschafprijs;
                verzekeringVM.SelectedVerzekering.Aanschafdatum = dpAanschafdatum.SelectedDate.Value;
                verzekeringVM.SelectedVerzekering.Afschrijvingsdatum = dpAfschrijvingsdatum.SelectedDate.Value;
                verzekeringVM.SelectedVerzekering.Leverancier = txtLeverancier.Text;
                int.TryParse(txtVerzekerd.Text, out int verzekerd);
                verzekeringVM.SelectedVerzekering.Verzekerd = verzekerd;
                decimal.TryParse(txtVerzekeringswaarde.Text, out decimal verzekeringswaarde);
                verzekeringVM.SelectedVerzekering.Verzekeringswaarde = verzekeringswaarde;


                VerzekeringBL verzekeringBL = new VerzekeringBL();
                verzekeringBL.Create(verzekeringVM.SelectedVerzekering);

                selectedVerzekering = verzekeringVM.SelectedVerzekering;

                //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                //waardoor het geselecteerde listviewitem leeg wordt 
                //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                UpdateUI();

                verzekeringVM.SelectedVerzekering = selectedVerzekering;
            }
            catch (Exception msg)
            {
                MessageBox.Show(msg.Message, "Foutmelding invoeren");
            }
        }

        private void BtnBewerken_Click(object sender, RoutedEventArgs e)
        {
            if (lvVerzekering.SelectedItems.Count > 0)
            {
                try
                {
                    selectedVerzekering = lvVerzekering.SelectedItem as VerzekeringBO;
                    verzekeringVM.SelectedVerzekering.VerzekeringID = selectedVerzekering.VerzekeringID;

                    int.TryParse(txtSerieNummer.Text, out int SerieNummer);
                    verzekeringVM.SelectedVerzekering.Serienummer = SerieNummer;
                    decimal.TryParse(txtAanschafprijs.Text, out decimal Aanschafprijs);
                    verzekeringVM.SelectedVerzekering.Aanschafprijs = Aanschafprijs;
                    verzekeringVM.SelectedVerzekering.Aanschafdatum = dpAanschafdatum.SelectedDate.Value;
                    verzekeringVM.SelectedVerzekering.Afschrijvingsdatum = dpAfschrijvingsdatum.SelectedDate.Value;
                    verzekeringVM.SelectedVerzekering.Leverancier = txtLeverancier.Text;
                    int.TryParse(txtVerzekerd.Text, out int verzekerd);
                    verzekeringVM.SelectedVerzekering.Verzekerd = verzekerd;
                    decimal.TryParse(txtVerzekeringswaarde.Text, out decimal verzekeringswaarde);
                    verzekeringVM.SelectedVerzekering.Verzekeringswaarde = verzekeringswaarde;


                    VerzekeringBL verzekeringBL = new VerzekeringBL();
                    verzekeringBL.Update(verzekeringVM.SelectedVerzekering);

                    selectedVerzekering = verzekeringVM.SelectedVerzekering;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    verzekeringVM.SelectedVerzekering = selectedVerzekering;

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding bewerken");
                }
            }
        }

        private void BtnVerwijderen_Click(object sender, RoutedEventArgs e)
        {
            if (lvVerzekering.SelectedItems.Count > 0)
            {
                try
                {
                    selectedVerzekering = lvVerzekering.SelectedItem as VerzekeringBO;

                    VerzekeringBL verzekeringBL = new VerzekeringBL();

                    foreach (VerzekeringBO verzekering in lvVerzekering.SelectedItems)
                    {
                        selectedVerzekeringen.Add(verzekering.VerzekeringID);
                    }

                    verzekeringBL.Delete(selectedVerzekeringen);
                    selectedVerzekeringen.Clear();

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
