/************************** Module Header *******************************\
Project:         Hello World WPF
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

namespace WPF_Hello_World
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        //constructor
        public MainWindow()
        {
            InitializeComponent();
        }

        //muis-klik event
        private void BtnGroet_Click(object sender, RoutedEventArgs e)
        {
            if(RbTaalKeuzeNL.IsChecked == true)
            {
                if(CbHoofdletters.IsChecked == true)
                {
                    lblGroet.Content = "GOEDEDAG " + txtGroet.Text.ToUpper();
                }
                else
                {
                    lblGroet.Content = "goededag " + txtGroet.Text.ToLower();
                }
            }
            else if(RbTaalKeuzeEN.IsChecked == true)
            {
                if(CbHoofdletters.IsChecked == true)
                {
                    lblGroet.Content = "HELLO " + txtGroet.Text.ToUpper();
                }
                else
                {
                    lblGroet.Content = "hello " + txtGroet.Text.ToLower();
                }
            }
        }
    }
}
