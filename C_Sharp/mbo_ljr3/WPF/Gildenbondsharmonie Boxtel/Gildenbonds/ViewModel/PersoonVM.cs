/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     PersoonVM.cs

Omschrijving:    Viewmodel Persoon

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
    public class PersoonVM : INotifyPropertyChanged
    {
        //constructor
        public PersoonVM()
        {
            Personen = new ObservableCollection<PersoonBO>();
            _SelectedPersoon = new PersoonBO();
        }

        //Hier worden alles Persoonen bewaard die in de UI getoond moeten worden
        public ObservableCollection<PersoonBO> Personen { get; set; }

        private PersoonBO _SelectedPersoon;
        public PersoonBO SelectedPersoon
        {
            get
            {
                return _SelectedPersoon;
            }
            set
            {
                _SelectedPersoon = value;
                OnPropertyChanged("SelectedPersoon");
                if (SelectedPersoon != null)
                {
                    PersoonKwalificatie = "Geselecteerde Persoon:\n" + SelectedPersoon.Voornaam + " " + SelectedPersoon.Achternaam + " van " + SelectedPersoon.GroepType + " groep "
                    + SelectedPersoon.GroepNaam;
                    VisibilityPersoon = Visibility.Visible;
                }
            }
        }

        private string _PersoonKwalificatie;
        public string PersoonKwalificatie
        {
            get
            {
                return _PersoonKwalificatie;
            }
            set
            {
                _PersoonKwalificatie = value;
                OnPropertyChanged("PersoonKwalificatie");
            }
        }

        //Hier wordt bepaald of de tekstblock voor de visuele weergave van de geselecteerde listitem in de UI, met daarin de kwalificatiezin, zichtbaar of onzichtbaar is
        private Enum _VisibilityPersoon;
        public Enum VisibilityPersoon
        {
            get
            {
                return _VisibilityPersoon;
            }
            set
            {
                _VisibilityPersoon = value;
                OnPropertyChanged("VisibilityPersoon");
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
