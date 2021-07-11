using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using KW1C_Feedback_App.Droid;
using Xamarin.Forms;
using System.IO;
using SQLite;

[assembly: Dependency(typeof(SQLite_FeedbackItem))]

namespace KW1C_Feedback_App.Droid
{
    //overerving van de portable interface
    public class SQLite_FeedbackItem : ISQLite
    {
        public SQLite_FeedbackItem()
        {

        }

        //implementatie van de verbinding methode
        public SQLite.SQLiteConnection GetConnection()
        {
            try
            {
                var sqliteFilename = "FeedbackItemSQLite.db3";
                string documentsPath = System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal); //(SpecialFolder.Personal) LocalApplicationData/MyDocuments Documents folder
                var path = Path.Combine(documentsPath, sqliteFilename);
                // Maak de onderstaande verbinding
                var conn = new SQLite.SQLiteConnection(path);
                // Geef de databaseverbinding terug
                return conn;
            }
            catch (SQLiteException sqlex)
            {
                return null;
            }
        }
    }
}