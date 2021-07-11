/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstInstrumentVM.cs

Omschrijving:    Viewmodel LijstInstrument

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
    public class LijstInstrumentVM : INotifyPropertyChanged
    {        
        //Hier worden alles LijstInstrumenten bewaard die in de UI getoond moeten worden
        public ObservableCollection<LijstInstrumentBO> LijstInstrumenten { get; set; }

        //Hier worden de door de gebruiker gefilterde velden opgeslagen
        public List<string> FilterLijstInstrument { get; set; }

        //constructor
        public LijstInstrumentVM()
        {
            LijstInstrumenten = new ObservableCollection<LijstInstrumentBO>();
            FilterLijstInstrument = new List<string>();
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
