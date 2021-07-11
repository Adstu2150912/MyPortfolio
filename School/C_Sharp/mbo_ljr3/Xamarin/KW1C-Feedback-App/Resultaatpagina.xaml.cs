using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;


namespace KW1C_Feedback_App
{
	public partial class Resultaatpagina : ContentPage
	{

        public Resultaatpagina (Feedback feedbackItem)
		{
			InitializeComponent();

            BindingContext = feedbackItem;
		}

        private void linkNaarStartPagina_Clicked(object sender, EventArgs e)
        {
            Navigation.PushModalAsync(new Overzichtpagina());
        }
    }
}