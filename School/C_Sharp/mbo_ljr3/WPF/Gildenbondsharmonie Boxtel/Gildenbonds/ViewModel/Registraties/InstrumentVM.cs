/************************** Module Header *******************************\
Project:         3-Tier WPF-Applicatie - Administratiesysteem Gildenbondsharmonie Boxtel
Auteur:          Adam Oubelkas
Aanmaakdatum:    27 november 2018
Module naam:     InstrumentVM.cs

Omschrijving:    Viewmodel Instrument

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
    public class InstrumentVM : INotifyPropertyChanged
    {
        //constructor
        public InstrumentVM()
        {
            Instrumenten = new ObservableCollection<InstrumentBO>();
            _SelectedInstrument = new InstrumentBO();
        }

        //Hier worden alles Instrumenten bewaard die in de UI getoond moeten worden
        public ObservableCollection<InstrumentBO> Instrumenten { get; set; }

        private InstrumentBO _SelectedInstrument;
        public InstrumentBO SelectedInstrument
        {
            get
            {
                return _SelectedInstrument;
            }
            set
            {
                _SelectedInstrument = value;
                OnPropertyChanged("SelectedInstrument");
                if (SelectedInstrument != null)
                {
                    InstrumentKwalificatie = "Geselecteerde Instrument:\n" + SelectedInstrument.Instrument + " type " + SelectedInstrument.InstrumentType 
                    + " van merk" + SelectedInstrument.Merk + " heeft verzekering met verzekeringsID " + SelectedInstrument.VerzekeringID + "\nVerenigingslid met verenigingsID "
                    + SelectedInstrument.VerenigingslidID + " gebruikt instrument " + SelectedInstrument.Instrument;
                    VisibilityInstrument = Visibility.Visible;
                }
            }
        }

        private string _InstrumentKwalificatie;
        public string InstrumentKwalificatie
        {
            get
            {
                return _InstrumentKwalificatie;
            }
            set
            {
                _InstrumentKwalificatie = value;
                OnPropertyChanged("InstrumentKwalificatie");
            }
        }

        //Hier wordt bepaald of de tekstblock voor de visuele weergave van de geselecteerde listitem in de UI, met daarin de kwalificatiezin, zichtbaar of onzichtbaar is
        private Enum _VisibilityInstrument;
        public Enum VisibilityInstrument
        {
            get
            {
                return _VisibilityInstrument;
            }
            set
            {
                _VisibilityInstrument = value;
                OnPropertyChanged("VisibilityInstrument");
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
