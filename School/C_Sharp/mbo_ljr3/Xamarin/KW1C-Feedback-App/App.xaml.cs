using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

[assembly: XamlCompilation(XamlCompilationOptions.Compile)]
namespace KW1C_Feedback_App
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();

            MainPage = new Startpagina();
        }

        static FeedbackItemDB _db;

        public static FeedbackItemDB DB
        {
            get
            {
                if(_db == null)
                {
                    _db = new FeedbackItemDB();
                }
                return DB;
            }
        }

        protected override void OnStart()
        {
            // Handle when your app starts
        }

        protected override void OnSleep()
        {
            // Handle when your app sleeps
        }

        protected override void OnResume()
        {
            // Handle when your app resumes
        }
    }
}
