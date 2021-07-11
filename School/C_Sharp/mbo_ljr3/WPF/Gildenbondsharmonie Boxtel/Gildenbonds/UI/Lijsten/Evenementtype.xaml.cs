/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     Evenementtypes.xaml.cs

Omschrijving:    Overzicht van Evenementtypes

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
    /// Interaction logic for Evenementtype.xaml
    /// </summary>
    public partial class Evenementtype : Page
    {
        //Hier worden alle objecten bewaard die in de UI getoond moeten worden
        static LijstEvenementTypeVM lijstEvenementTypeVM = new LijstEvenementTypeVM();

        //Hieronder wordt het aantal objecten van de lijst uit de viewmodel bewaard
        int countList;

        //constructor
        public Evenementtype()
        {
            InitializeComponent();
            this.DataContext = lijstEvenementTypeVM;
        }

        //Implementatie: methoden

        public void UpdateUI()
        {
            DataSet dsLijstEvenementType = new DataSet();
            LijstEvenementBL lijstEvenementTypeBL = new LijstEvenementBL();

            dsLijstEvenementType = lijstEvenementTypeBL.Read();
            if (dsLijstEvenementType.Tables.Count == 0)
            {
                MessageBox.Show("De tabel Evenement bestaat niet of is leeg", "Foutmelding");
            }
            else
            {
                countList = lijstEvenementTypeVM.LijstEvenementTypes.Count;
                //Maak de onderstaande lijst leeg en begin opnieuw met vullen
                for (int i = countList - 1; i >= 0; i--)
                {
                    lijstEvenementTypeVM.LijstEvenementTypes.RemoveAt(i);
                }

                //lus door alle rijen van de tabel
                foreach (DataRow item in dsLijstEvenementType.Tables[0].Rows)
                {
                    try
                    {
                        lijstEvenementTypeVM.LijstEvenementTypes.Add(new LijstEvenementBO
                        {
                            EvenementType = (string)item[1],
                            Beschrijving = (string)item[7]
                        });
                    }
                    catch (Exception msg)
                    {
                        MessageBox.Show(msg.Message, "Foutmelding datarow in dataset 'Evenement'");
                    }
                }
            }
        }

        private void UIEvenementType_Loaded(object sender, RoutedEventArgs e)
        {
            UpdateUI();
        }
    }
}
