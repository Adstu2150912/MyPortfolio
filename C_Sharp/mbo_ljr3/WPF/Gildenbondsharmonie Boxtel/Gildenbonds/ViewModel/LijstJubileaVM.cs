/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstJubileaVM.cs

Omschrijving:    Viewmodel LijstJubilea

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
    public class LijstJubileaVM : INotifyPropertyChanged
    {        
        //Hier worden alles LijstJubileaen bewaard die in de UI getoond moeten worden
        public ObservableCollection<LijstJubileaBO> LijstJubilarissen { get; set; }

        //Hier worden de door de gebruiker gefilterde velden opgeslagen
        public List<string> FilterLijstJubilea { get; set; }

        //Hier wordt het geselecteerde jaar aan lidmaatschap uit de UI/View opgeslagen
        public int SelectedLidmaatschap { get; set; }

        //constructor
        public LijstJubileaVM()
        {
            LijstJubilarissen = new ObservableCollection<LijstJubileaBO>();
            FilterLijstJubilea = new List<string>();
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
