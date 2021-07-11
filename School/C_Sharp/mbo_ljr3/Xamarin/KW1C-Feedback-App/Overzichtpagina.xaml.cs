using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using System.Collections.ObjectModel;

namespace KW1C_Feedback_App
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Overzichtpagina : MasterDetailPage
    {
        private OverviewViewModel ViewModel = new OverviewViewModel();
        //Begin vanaf 1 te tellen
        int countItems;

        int gemiddeldeCijferFeedback;

        public Overzichtpagina ()
		{
            InitializeComponent();
            ViewModel.FeedbackList = (ObservableCollection <Feedback> ) App.DB.GetItems();

            if (ViewModel.FeedbackList.Count > 0)
            {
                foreach(Feedback item in ViewModel.FeedbackList)
                {
                    countItems = ViewModel.FeedbackList.Count;
                    gemiddeldeCijferFeedback = (item.CijferInteresse + item.CijferUitleg + item.CijferMoeilijkheid
                        + item.CijferOpdracht + item.CijferRelevantie) / 5;

                    ViewModel.StrFeedbackList.Add("Feedback " + countItems + ": " + item.DocentNaam + ", " + item.VakNaam + ", " + item.Datum);
                    ViewModel.StrFeedbackList.Add("Gemiddelde van feedback " + countItems + ": " + gemiddeldeCijferFeedback);
                }
            }
            lvFeedback.ItemsSource = ViewModel.StrFeedbackList;
        }

        private void LinkNaarOverzicht_Clicked(object sender, EventArgs e)
        {
            Detail = new NavigationPage(new Overzichtpagina());
        }

        private void LinkNaarInvoerpagina_Clicked(object sender, EventArgs e)
        {
            Detail = new NavigationPage(new Invoerpagina());
        }

        private void linkNaarResultaat_Clicked(object sender, EventArgs e)
        {
            Detail = new NavigationPage(new Resultaatpagina(App.DB.GetItem(countItems - 1)));
        }
    }
}