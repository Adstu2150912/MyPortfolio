/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstVerenigingVM.cs

Omschrijving:    Viewmodel LijstVereniging

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
    public class LijstVerenigingVM : INotifyPropertyChanged
    {        
        //Hier worden alles LijstVerenigingen bewaard die in de UI getoond moeten worden
        public ObservableCollection<LijstVerenigingBO> LijstVerenigingen { get; set; }

        //Hier worden de door de gebruiker gefilterde velden opgeslagen
        public List<string> FilterLijstVereniging { get; set; }

        //constructor
        public LijstVerenigingVM()
        {
            LijstVerenigingen = new ObservableCollection<LijstVerenigingBO>();
            FilterLijstVereniging = new List<string>();
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
