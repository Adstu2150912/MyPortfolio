/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstKNMOVM.cs

Omschrijving:    Viewmodel LijstKNMO

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel; // Voor gebruik van ObservableCollection
using System.ComponentModel; // Voor gebruik van de INotifyPropertyChanged klasse
using Gildenbondsharmonie.BOL; //Voor gebruik van business objecten

namespace Gildenbondsharmonie.ViewModel
{
    public class LijstKNMOVM : INotifyPropertyChanged
    {        
        //Hier worden alles LijstKNMOen bewaard die in de UI getoond moeten worden
        public ObservableCollection<LijstKNMOBO> LijstKNMO { get; set; }

        //Hier worden de door de gebruiker gefilterde velden uit de UI/View opgeslagen
        public List<string> FilterLijstKNMO { get; set; }

        //Hier wordt de geboortejaren uit de Data Access Layer opgeslagen
        public ObservableCollection<int> LijstGeboorteJaren { get; set; }

        //Hier wordt het geselecteerde jaar uit de UI/View opgeslagen
        public int SelectedJaar { get; set; }

        //constructor
        public LijstKNMOVM()
        {
            LijstKNMO = new ObservableCollection<LijstKNMOBO>();
            FilterLijstKNMO = new List<string>();
            LijstGeboorteJaren = new ObservableCollection<int>();
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void OnPropertyChanged(string info)
        {
            PropertyChangedEventHandler handler = PropertyChanged;
            if (handler != null)
            {
                handler(this, new PropertyChangedEventArgs(info));
            }
        }
    }
}
