/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     LijstEvenementVM.cs

Omschrijving:    Viewmodel LijstEvenement

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
    public class LijstEvenementTypeVM : INotifyPropertyChanged
    {        
        //Hier worden alles LijstEvenementen bewaard die in de UI getoond moeten worden
        public ObservableCollection<LijstEvenementBO> LijstEvenementTypes { get; set; }


        //constructor
        public LijstEvenementTypeVM()
        {
            LijstEvenementTypes = new ObservableCollection<LijstEvenementBO>();
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
