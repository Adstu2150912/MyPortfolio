/************************** Module Header *******************************\
Project:         Opdracht_4.3
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

namespace Opdracht_4._3
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    /// 
    public partial class MainWindow : Window
    {

        public MainWindow()
        {
            InitializeComponent();
            //gebruik de lijst aan personen als bron voor de onderstaande listbox
            lbxPersonFamilyName.ItemsSource = people;
        }

        //Hiermee kunnen nieuwe personen met bijhorende kenmerken worden aangemaakt
        public class Person
        {
            public int ID { get; set; }
            public string FirstName { get; set; }
            public string FamilyName { get; set; }
        }

        static Person ASaebu = new Person
        {
            ID = 1
    ,
            FirstName = "A."
    ,
            FamilyName = "Saebu"
        };

        static Person WvanBijnen = new Person
        {
            ID = 2
            ,
            FirstName = "W."
            ,
            FamilyName = "van Bijnen"
        };

        static Person BLinsen = new Person
        {
            ID = 3
            ,
            FirstName = "B."
            ,
            FamilyName = "Linsen"
        };

        List<Person> people = new List<Person> { ASaebu, WvanBijnen, BLinsen };
    }
}
