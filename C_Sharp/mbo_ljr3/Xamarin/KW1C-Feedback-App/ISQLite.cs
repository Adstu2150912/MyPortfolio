using System;
using System.Collections.Generic;
using System.Text;
using SQLite;

namespace KW1C_Feedback_App
{
    public interface ISQLite
    {
        //alleen deze methode is platformspecifiek
        SQLiteConnection GetConnection();
    }
}
