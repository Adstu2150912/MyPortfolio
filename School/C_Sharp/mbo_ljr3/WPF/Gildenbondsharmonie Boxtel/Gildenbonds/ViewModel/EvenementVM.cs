/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     EvenementVM.cs

Omschrijving:    Viewmodel Evenement

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
    public class EvenementVM : INotifyPropertyChanged
    {
        //constructor
        public EvenementVM()
        {
            Evenementen = new ObservableCollection<EvenementBO>();
            _SelectedEvenement = new EvenementBO();
        }

        //Hier worden alles evenementen bewaard die in de UI getoond moeten worden
        public ObservableCollection<EvenementBO> Evenementen { get; set; }

        private EvenementBO _SelectedEvenement;
        public EvenementBO SelectedEvenement
        {
            get
            {
                return _SelectedEvenement;
            }
            set
            {
                _SelectedEvenement = value;
                OnPropertyChanged("SelectedEvenement");
                if (SelectedEvenement != null)
                {
                    EvenementKwalificatie = "Geselecteerde evenement: " + SelectedEvenement.EvenementNaam + "\n" + SelectedEvenement.EvenementType + "\n"
                    + SelectedEvenement.Locatie + "\n" + SelectedEvenement.BeginDatum + " t/m " + SelectedEvenement.EindDatum + "\n"
                    + SelectedEvenement.StartTijd + " t/m " + SelectedEvenement.EindTijd + "\n" + SelectedEvenement.Locatie + "\n" 
                    + SelectedEvenement.Beschrijving;
                    if (SelectedEvenement.VerenigingslidID > 0)
                    {
                        EvenementKwalificatie += "\nVerenigingslid met verenigingslidID " + SelectedEvenement.VerenigingslidID + " is gegaan naar "
                         + SelectedEvenement.EvenementNaam;
                    }

                    VisibilityEvenement = Visibility.Visible;
                }
            }
        }

        private string _EvenementKwalificatie;
        public string EvenementKwalificatie
        {
            get
            {
                return _EvenementKwalificatie;
            }
            set
            {
                _EvenementKwalificatie = value;
                OnPropertyChanged("EvenementKwalificatie");
            }
        }

        //Hier wordt bepaald of de tekstblock voor de visuele weergave van de geselecteerde listitem in de UI, met daarin de kwalificatiezin, zichtbaar of onzichtbaar is
        private Enum _VisibilityEvenement;
        public Enum VisibilityEvenement
        {
            get
            {
                return _VisibilityEvenement;
            }
            set
            {
                _VisibilityEvenement = value;
                OnPropertyChanged("VisibilityEvenement");
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
