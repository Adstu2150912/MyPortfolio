using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using System.Collections.ObjectModel;

namespace KW1C_Feedback_App
{
    public partial class Startpagina : MasterDetailPage
    {
        private FeedbackViewModel ViewModel => (FeedbackViewModel)BindingContext;
        static ObservableCollection<Feedback> ocFeedback = new ObservableCollection<Feedback>();
        static ObservableCollection<string> scFeedback = new ObservableCollection<string>();
        
        //Begin vanaf 1 te tellen
        int countItems;

        int gemiddeldeCijferFeedback;

        public Startpagina()
        {
            InitializeComponent();
            BindingContext = new FeedbackViewModel(Navigation);

            VoegDocentenToe(cbxListDocent);
            VoegVakkenToe(cbxListVak);
            VoegLesUrenToe(cbxListLesuur);
        }

        private void VoegDocentenToe(Picker listDocent)
        {
            listDocent.Items.Add("M. van Meer");
            listDocent.Items.Add("W. van Bijnen");
            listDocent.Items.Add("R. Gijsbrechts");
            listDocent.Items.Add("A. Saebu");
            listDocent.Items.Add("B. Linsen");
            listDocent.Items.Add("A. Lambregts");
        }

        private void VoegVakkenToe(Picker listVak)
        {
            listVak.Items.Add("Javascript");
            listVak.Items.Add("Analyseren");
            listVak.Items.Add("HTML5");
            listVak.Items.Add("Xamarin");
            listVak.Items.Add("C#");
        }

        private void VoegLesUrenToe(Picker LesUrenToe)
        {
            LesUrenToe.Items.Add("08:30 - 09:30");
            LesUrenToe.Items.Add("09:30 - 10:30");
            LesUrenToe.Items.Add("10:45 - 11:45");
            LesUrenToe.Items.Add("11:45 - 12:45");
            LesUrenToe.Items.Add("13:15 - 14:15");
            LesUrenToe.Items.Add("14:30 - 15:30");
            LesUrenToe.Items.Add("15:30 - 16:30");
        }

        private void btnFeedbackOpslaan_Clicked(object sender, EventArgs e)
        {
            // Haal de geselecteerde waardes op uit het invoerformulier 
            // en sla ze op als attributen/properties van het ViewModel object 'feedbackItem' 
            if (cbxListDocent.SelectedItem != null && cbxListVak.SelectedItem != null && cbxListLesuur.SelectedItem != null
                && dpDate.Date != null)
            {
                ViewModel.FeedbackItem.DocentNaam = cbxListDocent.Items[cbxListDocent.SelectedIndex];
                ViewModel.FeedbackItem.VakNaam = cbxListVak.Items[cbxListVak.SelectedIndex];
                ViewModel.FeedbackItem.LesUur = cbxListLesuur.Items[cbxListLesuur.SelectedIndex];
                ViewModel.FeedbackItem.Datum = dpDate.Date.Day.ToString() + "/" + dpDate.Date.Month.ToString() + "/" + dpDate.Date.Year.ToString();
                ViewModel.FeedbackItem.CijferInteresse = Convert.ToInt32(slideInterresse.Value);
                ViewModel.FeedbackItem.CijferMoeilijkheid = Convert.ToInt32(slideMoeilijkheid.Value);
                ViewModel.FeedbackItem.CijferUitleg = Convert.ToInt32(slideUitleg.Value);
                ViewModel.FeedbackItem.CijferOpdracht = Convert.ToInt32(slideOpdracht.Value);
                ViewModel.FeedbackItem.CijferRelevantie = Convert.ToInt32(slideRelevantie.Value);

                ocFeedback.Add(ViewModel.FeedbackItem);
                countItems = ocFeedback.Count;
                gemiddeldeCijferFeedback = (ViewModel.FeedbackItem.CijferInteresse + ViewModel.FeedbackItem.CijferUitleg + ViewModel.FeedbackItem.CijferMoeilijkheid
                    + ViewModel.FeedbackItem.CijferOpdracht + ViewModel.FeedbackItem.CijferRelevantie) / 5;

                scFeedback.Add("Feedback " + countItems + ": " + ViewModel.FeedbackItem.DocentNaam + ", " + ViewModel.FeedbackItem.VakNaam + ", " + ViewModel.FeedbackItem.Datum);
                scFeedback.Add("Gemiddelde van feedback " + countItems + ": " + gemiddeldeCijferFeedback);

                //De resultaatpagina wordt geopend met de gegevens vanuit het ViewModel object
                Navigation.PushModalAsync(new Resultaatpagina(ViewModel.FeedbackItem));
            }
        }

        private void linkNaarOverzicht_Clicked(object sender, EventArgs e)
        {
            Detail = new NavigationPage(new Overzichtpagina());
        }

        private void linkNaarStartpagina_Clicked(object sender, EventArgs e)
        {
            Detail = new NavigationPage(new Startpagina());
        }

        private void slideInterresse_ValueChanged(object sender, ValueChangedEventArgs e)
        {
            slideInterresse.Value = Math.Round(e.NewValue);
        }

        private void slideUitleg_ValueChanged(object sender, ValueChangedEventArgs e)
        {
            slideUitleg.Value = Math.Round(e.NewValue);
        }

        private void slideMoeilijkheid_ValueChanged(object sender, ValueChangedEventArgs e)
        {
            slideMoeilijkheid.Value = Math.Round(e.NewValue);
        }

        private void slideOpdracht_ValueChanged(object sender, ValueChangedEventArgs e)
        {
            slideOpdracht.Value = Math.Round(e.NewValue);
        }

        private void slideRelevantie_ValueChanged(object sender, ValueChangedEventArgs e)
        {
            slideRelevantie.Value = Math.Round(e.NewValue);
        }
    }
}
