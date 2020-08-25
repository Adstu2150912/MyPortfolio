/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     VerzekeringVM.cs

Omschrijving:    Viewmodel Verzekering

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
    public class VerzekeringVM : INotifyPropertyChanged
    {
        //constructor
        public VerzekeringVM()
        {
            Verzekeringen = new ObservableCollection<VerzekeringBO>();
            _SelectedVerzekering = new VerzekeringBO();
        }

        //Hier worden alles Verzekeringen bewaard die in de UI getoond moeten worden
        public ObservableCollection<VerzekeringBO> Verzekeringen { get; set; }

        private VerzekeringBO _SelectedVerzekering;
        public VerzekeringBO SelectedVerzekering
        {
            get
            {
                return _SelectedVerzekering;
            }
            set
            {
                _SelectedVerzekering = value;
                OnPropertyChanged("SelectedVerzekering");
                if (SelectedVerzekering != null)
                {
                    VerzekeringKwalificatie = "Geselecteerde Verzekering:\nVerzekering met verzekeringID" + SelectedVerzekering.VerzekeringID + " van leverancier " + SelectedVerzekering.Leverancier + " heeft verzekeringswaarde van € " + SelectedVerzekering.Verzekeringswaarde;
                    VisibilityVerzekering = Visibility.Visible;
                }
            }
        }

        private string _VerzekeringKwalificatie;
        public string VerzekeringKwalificatie
        {
            get
            {
                return _VerzekeringKwalificatie;
            }
            set
            {
                _VerzekeringKwalificatie = value;
                OnPropertyChanged("VerzekeringKwalificatie");
            }
        }

        //Hier wordt bepaald of de tekstblock voor de visuele weergave van de geselecteerde listitem in de UI, met daarin de kwalificatiezin, zichtbaar of onzichtbaar is
        private Enum _VisibilityVerzekering;
        public Enum VisibilityVerzekering
        {
            get
            {
                return _VisibilityVerzekering;
            }
            set
            {
                _VisibilityVerzekering = value;
                OnPropertyChanged("VisibilityVerzekering");
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
