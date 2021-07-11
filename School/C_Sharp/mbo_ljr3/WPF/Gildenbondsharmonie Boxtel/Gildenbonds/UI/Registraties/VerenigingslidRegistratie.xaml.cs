/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     VerenigingslidRegistratie.xaml.cs

Omschrijving:    Invulformulier voor het registreren van verenigingsleden

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
    /// Interaction logic for VerenigingslidRegistratie.xaml
    /// </summary>
    public partial class VerenigingslidRegistratie : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static VerenigingslidVM verenigingslidVM = new VerenigingslidVM();

        //bewaar hier het huidige geselecteerde object voordat het leeg wordt ná het updaten van de UI
        VerenigingslidBO selectedVerenigingslid = new VerenigingslidBO();

        //Hier worden de primaire/vreemde sleutels (ID's) van geselecteerde listviewitem uit de view opgeslagen
        List<int> selectedVerenigingsleden = new List<int>();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public VerenigingslidRegistratie()
        {
            InitializeComponent();
            this.DataContext = verenigingslidVM;
        }

        //Implementatie: methoden

        public void UpdateUI()
        {
            VerenigingslidBL verenigingslidBL = new VerenigingslidBL();
            DataSet dsVerenigingslid = new DataSet();

            dsVerenigingslid = verenigingslidBL.Read();

            if (dsVerenigingslid.Tables.Count == 0)
            {
                MessageBox.Show("De tabel Verenigingslid bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = verenigingslidVM.Verenigingsleden.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    verenigingslidVM.Verenigingsleden.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsVerenigingslid.Tables[0].Rows)
                {
                    try
                    {
                        verenigingslidVM.Verenigingsleden.Add(new VerenigingslidBO
                        {
                            Lidnummer = (int)item[1],
                            PersoonID = (int)item[2],
                            Startdatum = (DateTime)item[3]
                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Verenigingslid'");
                    }
                }
            }
        }


        private void BtnInvoeren_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int.TryParse(txtLidnummer.Text, out int lidnummer);
                verenigingslidVM.SelectedVerenigingslid.Lidnummer = lidnummer;
                int.TryParse(txtPersoonID.Text, out int persoonID);
                verenigingslidVM.SelectedVerenigingslid.PersoonID = persoonID;
                verenigingslidVM.SelectedVerenigingslid.Startdatum= dpStartdatum.SelectedDate.Value;


                VerenigingslidBL verenigingslidBL = new VerenigingslidBL();
                verenigingslidBL.Create(verenigingslidVM.SelectedVerenigingslid);

                selectedVerenigingslid = verenigingslidVM.SelectedVerenigingslid;

                //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                //waardoor het geselecteerde listviewitem leeg wordt 
                //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                UpdateUI();

                verenigingslidVM.SelectedVerenigingslid = selectedVerenigingslid;
            }
            catch (Exception msg)
            {
                MessageBox.Show(msg.Message, "Foutmelding invoeren");
            }
        }

        private void BtnBewerken_Click(object sender, RoutedEventArgs e)
        {
            if (lvVereniging.SelectedItems.Count > 0)
            {
                try
                {
                    selectedVerenigingslid = lvVereniging.SelectedItem as VerenigingslidBO;
                    verenigingslidVM.SelectedVerenigingslid.VerenigingslidID= selectedVerenigingslid.VerenigingslidID;

                    int.TryParse(txtLidnummer.Text, out int lidnummer);
                    verenigingslidVM.SelectedVerenigingslid.Lidnummer = lidnummer;
                    int.TryParse(txtPersoonID.Text, out int persoonID);
                    verenigingslidVM.SelectedVerenigingslid.PersoonID = persoonID;
                    verenigingslidVM.SelectedVerenigingslid.Startdatum = dpStartdatum.SelectedDate.Value;


                    VerenigingslidBL verenigingslidBL = new VerenigingslidBL();
                    verenigingslidBL.Update(verenigingslidVM.SelectedVerenigingslid);

                    selectedVerenigingslid = verenigingslidVM.SelectedVerenigingslid;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    verenigingslidVM.SelectedVerenigingslid = selectedVerenigingslid;

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding bewerken");
                }
            }
        }

        private void BtnVerwijderen_Click(object sender, RoutedEventArgs e)
        {
            if (lvVereniging.SelectedItems.Count > 0)
            {
                try
                {
                    selectedVerenigingslid = lvVereniging.SelectedItem as VerenigingslidBO;

                    VerenigingslidBL verenigingslidBL = new VerenigingslidBL();

                    foreach (VerenigingslidBO verenigingslid in lvVereniging.SelectedItems)
                    {
                        selectedVerenigingsleden.Add(verenigingslid.PersoonID);
                    }

                    verenigingslidBL.Delete(selectedVerenigingsleden);
                    selectedVerenigingsleden.Clear();

                    UpdateUI();

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding Verwijderen");
                }
            }
        }

        private void UIVerenigingslidRegistratie_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }
    }
}
