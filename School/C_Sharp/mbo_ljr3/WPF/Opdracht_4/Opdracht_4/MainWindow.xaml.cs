/************************** Module Header *******************************\
Project:         Opdracht_4.1
Auteur:          Adam Oubelkas
Aanmaakdatum:    28 september 2018
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

namespace Opdracht_4
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

        private void TxtName_TextChanged(object sender, TextChangedEventArgs e)
        {
            if(txtName.Text.Length > 0)
            {
                tblkLengte.Visibility = Visibility.Visible;
            }
            else
            {
                tblkLengte.Visibility = Visibility.Hidden;
            }

        }
    }
}
