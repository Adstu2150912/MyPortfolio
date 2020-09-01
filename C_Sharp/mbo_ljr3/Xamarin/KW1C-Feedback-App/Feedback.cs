using System;
using System.Collections.Generic;
using System.Text;
using System.ComponentModel;
using SQLite;
using System.Collections.ObjectModel;

namespace KW1C_Feedback_App
{
    public class Feedback
    {
        //aanwijzingen voor SQLite voor de primaire sleutel
        [PrimaryKey, AutoIncrement]
        public int ID { get; set; }
        public string Naam { get; set; }

        //gegevens over het onderwerp feedback
        private string _DocentNaam;
        public string DocentNaam { get { return _DocentNaam; } set { _DocentNaam = value; } }

        private string _VakNaam;
        public string VakNaam { get { return _VakNaam; } set { _VakNaam = value;} }

        private string _LesUur;
        public string LesUur { get { return _LesUur; } set { _LesUur = value;} }

        private string _Datum;
        public string Datum { get { return _Datum; } set { _Datum = value;} }

        //Gebruiksbeoordeling middels cijfers over het onderwerp

        private int _CijferInteresse;
        public int CijferInteresse { get { return _CijferInteresse; } set { _CijferInteresse = value;} }

        private int _CijferUitleg;
        public int CijferUitleg { get { return _CijferUitleg; } set { _CijferUitleg = value;} }

        private int _CijferMoeilijkheid;
        public int CijferMoeilijkheid { get { return _CijferMoeilijkheid; } set { _CijferMoeilijkheid = value;} }

        private int _CijferOpdracht;
        public int CijferOpdracht { get { return _CijferOpdracht; } set { _CijferOpdracht = value;} }

        private int _CijferRelevantie;
        public int CijferRelevantie { get { return _CijferRelevantie; } set { _CijferRelevantie = value;} }

        public Feedback()
        {
            
        }
    }
}
