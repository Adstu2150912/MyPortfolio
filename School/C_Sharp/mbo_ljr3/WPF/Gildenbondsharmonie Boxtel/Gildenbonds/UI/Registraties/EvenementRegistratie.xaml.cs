/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     EvenementRegistratie.xaml.cs

Omschrijving:    Invulformulier voor het registreren van evenementen

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
    /// Interaction logic for EvenementRegistratie.xaml
    /// </summary>
    public partial class EvenementRegistratie : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static EvenementVM evenementVM = new EvenementVM();

        //bewaar hier het huidige geselecteerde object voordat het leeg wordt ná het updaten van de UI
        EvenementBO selectedEvenement = new EvenementBO();

        //Hier worden de geselecteerde listviewitems uit de view opgeslagen
        List<int> selectedEvenementen = new List<int>();
        List<int> selectedVerenigingsleden = new List<int>();
        
        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        public EvenementRegistratie()
        {
            InitializeComponent();
            this.DataContext = evenementVM;
        }

        //Implementatie: methoden


        public void UpdateUI()
        {
            EvenementBL evenementBL = new EvenementBL();
            DataSet dsEvenement = new DataSet();

            dsEvenement = evenementBL.Read();

            if (dsEvenement.Tables.Count == 0)
            {
                MessageBox.Show("De tabel " + dsEvenement.DataSetName + " bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = evenementVM.Evenementen.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    evenementVM.Evenementen.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsEvenement.Tables[0].Rows)
                {
                    try
                    {
                        evenementVM.Evenementen.Add(new EvenementBO
                        {
                            EvenementNaam = (string)item[1],
                            EvenementType = (string)item[2],
                            BeginDatum = (DateTime)item[3],
                            EindDatum = (DateTime)item[4],
                            StartTijd = string.Format("{0:HH:mm}", item[5].ToString()),
                            EindTijd = string.Format("{0:HH:mm}", item[6].ToString()),
                            Locatie = (string)item[7],
                            Beschrijving = (string)item[8],
                            VerenigingslidID = (int)item[9]
                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset'" + dsEvenement.DataSetName + "'");
                    }
                }
            }
        }

        private void UIEvenememtRegistratie_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }

        private void BtnInvoeren_Click(object sender, RoutedEventArgs e)
        {
                try
                {
                    evenementVM.SelectedEvenement.EvenementNaam = txtEvenementNaam.Text;
                    evenementVM.SelectedEvenement.EvenementType = txtEvenementType.Text;
                    evenementVM.SelectedEvenement.BeginDatum = dpBeginDatum.SelectedDate.Value;
                    evenementVM.SelectedEvenement.EindDatum = dpEindDatum.SelectedDate.Value;
                    evenementVM.SelectedEvenement.StartTijd = string.Format("{0:HH:mm}", tpBeginTijd.CurrentTime);
                    evenementVM.SelectedEvenement.EindTijd = string.Format("{0:HH:mm}", tpEindTijd.CurrentTime);
                    evenementVM.SelectedEvenement.Locatie = txtLocatie.Text;

                    int.TryParse(txtVerenigingslid.Text, out int verenigingslidID);
                    evenementVM.SelectedEvenement.VerenigingslidID = verenigingslidID;

                    evenementVM.SelectedEvenement.Beschrijving = txtBeschrijving.Text;


                    EvenementBL evenementBL = new EvenementBL();
                    evenementBL.Create(evenementVM.SelectedEvenement);

                    selectedEvenement = evenementVM.SelectedEvenement;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    evenementVM.SelectedEvenement = selectedEvenement;
                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding invoeren");
                }
            
        }

        private void BtnBewerken_Click(object sender, RoutedEventArgs e)
        {
            if (lvEvenement.SelectedItems.Count > 0)
            {
                try
                {
                    selectedEvenement = lvEvenement.SelectedItem as EvenementBO;
                    evenementVM.SelectedEvenement.EvenementID = selectedEvenement.EvenementID;

                    evenementVM.SelectedEvenement.EvenementNaam = txtEvenementNaam.Text;
                    evenementVM.SelectedEvenement.EvenementType = txtEvenementType.Text;
                    evenementVM.SelectedEvenement.BeginDatum = dpBeginDatum.SelectedDate.Value;
                    evenementVM.SelectedEvenement.EindDatum = dpEindDatum.SelectedDate.Value;
                    evenementVM.SelectedEvenement.StartTijd = string.Format("{0:HH:mm}", tpBeginTijd.CurrentTime);
                    evenementVM.SelectedEvenement.EindTijd = string.Format("{0:HH:mm}", tpEindTijd.CurrentTime);
                    evenementVM.SelectedEvenement.Locatie = txtLocatie.Text;

                    int.TryParse(txtVerenigingslid.Text, out int verenigingslidID);
                    evenementVM.SelectedEvenement.VerenigingslidID = verenigingslidID;

                    evenementVM.SelectedEvenement.Beschrijving = txtBeschrijving.Text;


                    EvenementBL evenementBL = new EvenementBL();
                    evenementBL.Update(evenementVM.SelectedEvenement);

                    selectedEvenement = evenementVM.SelectedEvenement;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    evenementVM.SelectedEvenement = selectedEvenement;

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding bewerken");
                }
            }
        }

        private void BtnVerwijderen_Click(object sender, RoutedEventArgs e)
        {
            if (lvEvenement.SelectedItems.Count > 0)
            {
                try
                {
                    selectedEvenement = lvEvenement.SelectedItem as EvenementBO;

                    EvenementBL evenementBL = new EvenementBL();
                    
                    foreach(EvenementBO evenement in lvEvenement.SelectedItems)
                    {
                        selectedEvenementen.Add(evenement.EvenementID);
                        selectedVerenigingsleden.Add(evenement.VerenigingslidID);
                    }

                    evenementBL.Delete(selectedEvenementen, selectedEvenementen);
                    selectedEvenementen.Clear();
                    selectedVerenigingsleden.Clear();

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
