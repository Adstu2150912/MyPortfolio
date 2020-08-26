using System;
using System.Collections.Generic;
using System.Text;
using System.ComponentModel;
using Xamarin.Forms;
using System.Collections.ObjectModel;

namespace KW1C_Feedback_App
{
    public class OverviewViewModel
    {
        // Verzameling van alle string variabelen die de feedbackgegevens hebben overgeërfd van de objecten uit de feedbackobjectenlijst
        public ObservableCollection<string> StrFeedbackList { get; set; }

        // Verzameling van alle objecten met feedbackgegevens die bewaard worden in de SQLite database
        public ObservableCollection<Feedback> FeedbackList { get; set; }

        public OverviewViewModel()
        {
            StrFeedbackList = new ObservableCollection<string>();
            FeedbackList = new ObservableCollection<Feedback>();
        }
    }
}
