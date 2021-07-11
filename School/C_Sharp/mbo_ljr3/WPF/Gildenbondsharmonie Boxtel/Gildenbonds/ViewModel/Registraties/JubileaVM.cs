/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     JubileaVM.cs

Omschrijving:    Viewmodel Jubilea

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
    public class JubileaVM : INotifyPropertyChanged
    {
        //constructor
        public JubileaVM()
        {
            Jubilarissen = new ObservableCollection<JubileaBO>();
            _SelectedJubilea = new JubileaBO();
        }

        //Hier worden alles Jubileaen bewaard die in de UI getoond moeten worden
        public ObservableCollection<JubileaBO> Jubilarissen { get; set; }

        private JubileaBO _SelectedJubilea;
        public JubileaBO SelectedJubilea
        {
            get
            {
                return _SelectedJubilea;
            }
            set
            {
                _SelectedJubilea = value;
                OnPropertyChanged("SelectedJubilea");
                if (SelectedJubilea != null)
                {
                    JubileaKwalificatie = "Geselecteerde Jubilea:\n" + SelectedJubilea.Naam + "\nOmschrijving: "
                    + SelectedJubilea.Omschrijving;
                    if(SelectedJubilea.VerenigingslidID > 0)
                    {
                        JubileaKwalificatie += "\nVerenigingslid met verenigingslidID " + SelectedJubilea.VerenigingslidID + " heeft opmerking over jubilea " 
                         + SelectedJubilea.Naam + ":\n" + SelectedJubilea.JubileaOpmerking + "\n";
                    }
                    VisibilityJubilea = Visibility.Visible;
                }
            }
        }

        private string _JubileaKwalificatie;
        public string JubileaKwalificatie
        {
            get
            {
                return _JubileaKwalificatie;
            }
            set
            {
                _JubileaKwalificatie = value;
                OnPropertyChanged("JubileaKwalificatie");
            }
        }

        //Hier wordt bepaald of de tekstblock voor de visuele weergave van de geselecteerde listitem in de UI, met daarin de kwalificatiezin, zichtbaar of onzichtbaar is
        private Enum _VisibilityJubilea;
        public Enum VisibilityJubilea
        {
            get
            {
                return _VisibilityJubilea;
            }
            set
            {
                _VisibilityJubilea = value;
                OnPropertyChanged("VisibilityJubilea");
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
