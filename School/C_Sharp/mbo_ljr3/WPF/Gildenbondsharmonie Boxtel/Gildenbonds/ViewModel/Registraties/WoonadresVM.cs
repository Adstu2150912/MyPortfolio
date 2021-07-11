/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     WoonadresVM.cs

Omschrijving:    Viewmodel Woonadres

\************************************************************************/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel; // Voor gebruik van ObservableCollection
using System.ComponentModel; // Voor gebruik van de INotifyPropertyChanged klasse
using Gildenbondsharmonie.BOL; //Voor gebruik van business objecten
using System.Windows; //Voor gebruik van Enumeration 'Visibility'

namespace Gildenbondsharmonie.ViewModel
{
    public class WoonadresVM : INotifyPropertyChanged
    {
        //constructor
        public WoonadresVM()
        {
            Woonadresen = new ObservableCollection<WoonadresBO>();
            _SelectedWoonadres = new WoonadresBO();
        }

        //Hier worden alles Woonadresen bewaard die in de UI getoond moeten worden
        public ObservableCollection<WoonadresBO> Woonadresen { get; set; }

        private WoonadresBO _SelectedWoonadres;
        public WoonadresBO SelectedWoonadres
        {
            get
            {
                return _SelectedWoonadres;
            }
            set
            {
                _SelectedWoonadres = value;
                OnPropertyChanged("SelectedWoonadres");
                if (SelectedWoonadres != null)
                {
                    WoonadresKwalificatie = "Geselecteerde Woonadres:\n" + SelectedWoonadres.Straatnaam + " " + SelectedWoonadres.Straatnummer + "\n" + SelectedWoonadres.Postcode 
                    + " " + SelectedWoonadres.Plaats;
                    VisibilityWoonadres = Visibility.Visible;
                }
            }
        }

        private string _WoonadresKwalificatie;
        public string WoonadresKwalificatie
        {
            get
            {
                return _WoonadresKwalificatie;
            }
            set
            {
                _WoonadresKwalificatie = value;
                OnPropertyChanged("WoonadresKwalificatie");
            }
        }

        //Hier wordt bepaald of de tekstblock voor de visuele weergave van de geselecteerde listitem in de UI, met daarin de kwalificatiezin, zichtbaar of onzichtbaar is
        private Enum _VisibilityWoonadres;
        public Enum VisibilityWoonadres
        {
            get
            {
                return _VisibilityWoonadres;
            }
            set
            {
                _VisibilityWoonadres = value;
                OnPropertyChanged("VisibilityWoonadres");
            }
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
