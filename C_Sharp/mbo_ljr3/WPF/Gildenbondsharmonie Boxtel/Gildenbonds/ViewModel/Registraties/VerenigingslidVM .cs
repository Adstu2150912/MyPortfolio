/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem GildenModelndsharmonie Modelxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     VerenigingslidVM.cs

Omschrijving:    Viewmodel Verenigingslid

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
    public class VerenigingslidVM : INotifyPropertyChanged
    {       
        //Hier worden alles Verenigingsleden bewaard die in de UI getoond moeten worden
        public ObservableCollection<VerenigingslidBO> Verenigingsleden { get; set; }

        private VerenigingslidBO _SelectedVerenigingslid;
        public VerenigingslidBO SelectedVerenigingslid
        {
            get
            {
                return _SelectedVerenigingslid;
            }
            set
            {
                _SelectedVerenigingslid = value;
                OnPropertyChanged("SelectedVerenigingslid");
                if (SelectedVerenigingslid != null)
                {
                    VerenigingslidKwalificatie = "Geselecteerde Verenigingslid:\nVerenigingslid met lidnummer" + SelectedVerenigingslid.Lidnummer + " is lid sinds "
                    + SelectedVerenigingslid.Startdatum;

                    VisibilityVerenigingslid = Visibility.Visible;
                }
            }
        }

        private string _VerenigingslidKwalificatie;
        public string VerenigingslidKwalificatie
        {
            get
            {
                return _VerenigingslidKwalificatie;
            }
            set
            {
                _VerenigingslidKwalificatie = value;
                OnPropertyChanged("VerenigingslidKwalificatie");
            }
        }

        //Hier wordt bepaald of de tekstblock voor de visuele weergave van de geselecteerde listitem in de UI, met daarin de kwalificatiezin, zichtbaar of onzichtbaar is
        private Enum _VisibilityVerenigingslid;
        public Enum VisibilityVerenigingslid
        {
            get
            {
                return _VisibilityVerenigingslid;
            }
            set
            {
                _VisibilityVerenigingslid = value;
                OnPropertyChanged("VisibilityVerenigingslid");
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        //constructor
        public VerenigingslidVM()
        {
            Verenigingsleden = new ObservableCollection<VerenigingslidBO>();
            _SelectedVerenigingslid = new VerenigingslidBO();
        }

 

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
