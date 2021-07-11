/************************** Module Header *******************************\
Project:         Calendar_ListBox_Demo (WPF)
Auteur:          Adam Oubelkas
Aanmaakdatum:    23 september 2018
Module naam:     MainWindow.xaml.cs

Omschrijving:    Hoofdprogramma

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

namespace Calendar_ListBox_Demo
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        // constructor
        public MainWindow()
        {
            InitializeComponent();
        }

        // event vindt plaats wanneer selectie aan datums verandert
        private void Calendar_SelectedDatesChanged(object sender, SelectionChangedEventArgs e)
        {
            for(int i = 0; i < calendar.SelectedDates.Count; i++)
            {
                lbDatums.Items.Add(calendar.SelectedDates[i].ToShortDateString());
            }
        }
    }
}
