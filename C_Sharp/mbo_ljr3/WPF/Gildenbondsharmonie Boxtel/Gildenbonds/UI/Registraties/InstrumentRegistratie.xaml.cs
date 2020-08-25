/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     InstrumentRegistratie.xaml.cs

Omschrijving:    Invulformulier voor het registreren van instrumenten

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
    /// Interaction logic for InstrumentRegistratie.xaml
    /// </summary>
    public partial class InstrumentRegistratie : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static InstrumentVM instrumentVM = new InstrumentVM();

        //bewaar hier het huidige geselecteerde object voordat het leeg wordt ná het updaten van de UI
        InstrumentBO selectedInstrument = new InstrumentBO();

        //Hier worden de geselecteerde listviewitems uit de view opgeslagen
        List<int> selectedInstrumenten = new List<int>();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public InstrumentRegistratie()
        {
            InitializeComponent();
            this.DataContext = instrumentVM;
        }

        //Implementatie: methoden


        public void UpdateUI()
        {
            InstrumentBL instrumentBL = new InstrumentBL();
            DataSet dsInstrument = new DataSet();

            dsInstrument = instrumentBL.Read();

            if (dsInstrument.Tables.Count == 0)
            {
                MessageBox.Show("De tabel " + dsInstrument.DataSetName + " bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = instrumentVM.Instrumenten.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    instrumentVM.Instrumenten.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsInstrument.Tables[0].Rows)
                {
                    try
                    {
                        instrumentVM.Instrumenten.Add(new InstrumentBO
                        {
                            Instrument= (string)item[1],
                            InstrumentType = (string)item[2],
                            Merk = (string)item[3],
                            VerzekeringID = (int)item[4],
                            VerenigingslidID = (int)item[5]
                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset'" + dsInstrument.DataSetName + "'");
                    }
                }
            }
        }

        private void UIInstrumentRegistratie_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }

        private void BtnInvoeren_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                instrumentVM.SelectedInstrument.Instrument= txtInstrumentNaam.Text;
                instrumentVM.SelectedInstrument.InstrumentType = txtInstrumentType.Text;
                instrumentVM.SelectedInstrument.Merk = txtMerk.Text;
                int.TryParse(txtVerzekeringsID.Text, out int verzekeringsID);
                instrumentVM.SelectedInstrument.VerzekeringID = verzekeringsID;
                int.TryParse(txtVerenigingslidID.Text, out int verenigingslidID);
                instrumentVM.SelectedInstrument.VerenigingslidID = verenigingslidID;


                InstrumentBL instrumentBL = new InstrumentBL();
                instrumentBL.Create(instrumentVM.SelectedInstrument);

                selectedInstrument = instrumentVM.SelectedInstrument;

                //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                //waardoor het geselecteerde listviewitem leeg wordt 
                //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                UpdateUI();

                instrumentVM.SelectedInstrument = selectedInstrument;
            }
            catch (Exception msg)
            {
                MessageBox.Show(msg.Message, "Foutmelding invoeren");
            }
        }

        private void BtnBewerken_Click(object sender, RoutedEventArgs e)
        {
            if (lvInstrument.SelectedItems.Count > 0)
            {
                try
                {
                    selectedInstrument = lvInstrument.SelectedItem as InstrumentBO;
                    instrumentVM.SelectedInstrument.InstrumentID = selectedInstrument.InstrumentID;

                    instrumentVM.SelectedInstrument.Instrument = txtInstrumentNaam.Text;
                    instrumentVM.SelectedInstrument.InstrumentType = txtInstrumentType.Text;
                    instrumentVM.SelectedInstrument.Merk = txtMerk.Text;
                    int.TryParse(txtVerzekeringsID.Text, out int verzekeringsID);
                    instrumentVM.SelectedInstrument.VerzekeringID = verzekeringsID;
                    int.TryParse(txtVerenigingslidID.Text, out int verenigingslidID);
                    instrumentVM.SelectedInstrument.VerenigingslidID = verenigingslidID;


                    InstrumentBL instrumentBL = new InstrumentBL();
                    instrumentBL.Update(instrumentVM.SelectedInstrument);

                    selectedInstrument = instrumentVM.SelectedInstrument;

                    //Tijdens het updaten van de UI wordt de verzameling in de Itemssource van de listview leeggemaakt
                    //waardoor het geselecteerde listviewitem leeg wordt 
                    //met als gevolg dat het geselecteerde object in de Viewmodel, die verbonden is met het geselecteerde listviewitem, leeg wordt
                    UpdateUI();

                    instrumentVM.SelectedInstrument = selectedInstrument;

                }
                catch (Exception msg)
                {
                    MessageBox.Show(msg.Message, "Foutmelding bewerken");
                }
            }
        }

        private void BtnVerwijderen_Click(object sender, RoutedEventArgs e)
        {
            if (lvInstrument.SelectedItems.Count > 0)
            {
                try
                {
                    selectedInstrument = lvInstrument.SelectedItem as InstrumentBO;

                    InstrumentBL instrumentBL = new InstrumentBL();

                    foreach (InstrumentBO instrument in lvInstrument.SelectedItems)
                    {
                        selectedInstrumenten.Add(instrument.InstrumentID);                     
                    }

                    instrumentBL.Delete(selectedInstrumenten);
                    selectedInstrumenten.Clear();

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
