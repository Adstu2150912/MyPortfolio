/************************** Module Header *******************************\
Project:         Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    26 november 2018
Module naam:     MainWindow.xaml.cs

Omschrijving:    Hoofdprogramma van het hoofdvenster in de presentatielaag

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
using Gildenbondsharmonie.UI; //Voor gebruik van UI schermen

namespace Gildenbondsharmonie
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void ApplicatieAfsluiten_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }

        private void OpenLijstKNMO_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new KNMO();
        }

        private void OpenLijstGildenbonds_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new Vereniging();
        }

        private void OpenLijstGroepen_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new Groep();
        }

        private void OpenLijstVerjaardagen_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new Verjaardag();
        }

        private void OpenLijstJubilarissen_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new Jubilea();
        }

        private void OpenLijstInstrumenten_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new Instrument();
        }

        private void OpenLijstLedenInstrumenten_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Content = new InstrumentGebruik();
        }

        private void OpenLijstEvenementtypes_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new Evenementtype();
        }

        private void OpenLijstEvenementen_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new Evenement();
        }

        private void OpenLijstLedenEvenementen_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new LedenEvenementen();
        }

        private void LijstenAfsluiten_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = 350;
            fGildenbonds.Width = 700;
            fGildenbonds.Content = null;
        }

        private void OpenRegistratieGildenbonds_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new VerenigingslidRegistratie();
        }

        private void OpenRegistratiePersoon_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new PersoonRegistratie();
        }

        private void OpenRegistratieInstrument_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new InstrumentRegistratie();
        }

        private void OpenRegistratieJubilea_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new JubileaRegistratie();
        }

        private void OpenRegistratieEvenement_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = Double.NaN;
            fGildenbonds.Width = Double.NaN;
            fGildenbonds.Content = new EvenementRegistratie();
        }

        private void RegistratiesAfsluiten_Click(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = 350;
            fGildenbonds.Width = 700;
            fGildenbonds.Content = null;
        }

        private void HoofdVenster_Loaded(object sender, RoutedEventArgs e)
        {
            fGildenbonds.Height = 350;
            fGildenbonds.Width = 700;
        }
    }
}
