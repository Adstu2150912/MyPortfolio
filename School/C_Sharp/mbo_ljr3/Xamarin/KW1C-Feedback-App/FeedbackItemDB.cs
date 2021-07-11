using System;
using System.Collections.Generic;
using System.Text;
using SQLite;
using Xamarin.Forms;
using System.Linq;

namespace KW1C_Feedback_App
{
    public class FeedbackItemDB
    {

        static object locker = new object();
        SQLiteConnection dbconn;

        public FeedbackItemDB()
        {
            dbconn = DependencyService.Get<ISQLite>().GetConnection();
            // create the tables
            dbconn.CreateTable<Feedback>();
        }

        public IEnumerable<Feedback> GetItems()
        {
            lock (locker)
            {
                return (from i in dbconn.Table<Feedback>() select i).ToList();
            }
        }

        public Feedback GetItem(int id)
        {
            lock (locker)
            {
                return dbconn.Table<Feedback>().FirstOrDefault(x => x.ID == id);
            }
        }

        public int SaveItem(Feedback item)
        {
            lock (locker)
            {
                if (item.ID != 0)
                {
                    dbconn.Update(item);
                    return item.ID;
                }
                else
                {
                    return dbconn.Insert(item);
                }
            }
        }

        public int DeleteItem(int id)
        {
            lock (locker)
            {
                return dbconn.Delete<Feedback>(id);
            }
        }

    }
}
