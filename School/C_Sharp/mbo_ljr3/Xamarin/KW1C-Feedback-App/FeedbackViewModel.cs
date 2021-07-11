using System;
using System.Collections.Generic;
using System.Text;
using Xamarin.Forms;
using System.ComponentModel;
using System.Collections.ObjectModel;

namespace KW1C_Feedback_App
{
    public class FeedbackViewModel
    {

        //Hierin wordt het object, uit de model 'Feedback', in opgeslagen
        public Feedback FeedbackItem { get; set; }

        public FeedbackViewModel(INavigation navigation)
        {
            FeedbackItem = new Feedback();
        }

    }
}
