/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstGroepVM.cs

Omschrijving:    Viewmodel LijstGroep

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
    public class LijstGroepVM : INotifyPropertyChanged
    {        
        //Hier worden alles LijstGroepen bewaard die in de UI getoond moeten worden
        public ObservableCollection<LijstGroepBO> LijstGroepen { get; set; }

        //Hier worden de door de gebruiker gefilterde velden opgeslagen
        public List<string> FilterLijstGroep { get; set; }

        //Hier wordt het geselecteerde groep uit de UI/View opgeslagen
        public string SelectedGroep { get; set; }

        //constructor
        public LijstGroepVM()
        {
            LijstGroepen = new ObservableCollection<LijstGroepBO>();
            FilterLijstGroep = new List<string>();
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
