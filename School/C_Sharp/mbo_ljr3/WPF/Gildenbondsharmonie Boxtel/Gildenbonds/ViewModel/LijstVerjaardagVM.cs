/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    30 november 2018
Module naam:     LijstVerjaardagVM.cs

Omschrijving:    Viewmodel LijstVerjaardag

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
    public class LijstVerjaardagVM : INotifyPropertyChanged
    {        
        //Hier worden alles LijstVerjaardagen bewaard die in de UI getoond moeten worden
        public ObservableCollection<LijstVerjaardagBO> LijstVerjaardagen { get; set; }

        //Hier worden de door de gebruiker gefilterde velden uit de UI/View opgeslagen
        public List<string> FilterLijstVerjaardag { get; set; }

        //Hier wordt de geboortejaren uit de Data Access Layer opgeslagen
        public ObservableCollection<int> LijstGeboorteMaanden { get; set; }

        //Hier wordt het geselecteerde maand uit de UI/View opgeslagen
        public int SelectedMaand { get; set; }

        //constructor
        public LijstVerjaardagVM()
        {
            LijstVerjaardagen = new ObservableCollection<LijstVerjaardagBO>();
            FilterLijstVerjaardag = new List<string>();
            LijstGeboorteMaanden = new ObservableCollection<int>();
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
