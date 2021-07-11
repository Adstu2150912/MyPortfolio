package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBBeheerder;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBCursus;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBCursusCategorie;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBDocent;
//import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBFilm;
//import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBMuziek;
//import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBTheater;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBEmail;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBEvent;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBExpositie;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBFilm;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBGebruiker;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBKlantInlog;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBMuziek;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBParkeren;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBReservering;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DBTheater;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseConnection;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseHandlers;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View.CursusCategorieOverzicht;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View.DebugActivity;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View.GebruikerInfo_main;

public class MainActivity extends AppCompatActivity {

    private Button gebruikerKnop, filmOverzichtKnop, muziekOverzichtKnop, theaterOverzichtKnop, cursusOverzichtKnop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Test begin", "******************************************************START*******************************************************");
        initialize();
        DebugActivity.testDatabase();
        Log.d("Test eind", "*******************************************************END********************************************************");


        filmOverzichtKnop = (Button) findViewById(R.id.filmbutton);
        muziekOverzichtKnop = (Button) findViewById(R.id.muziekbutton);
        theaterOverzichtKnop = (Button) findViewById(R.id.theaterbutton);
        cursusOverzichtKnop = (Button) findViewById(R.id.cursusButton);

        gebruikerKnop = (Button) findViewById(R.id.btn_naarGebruiker);


        filmOverzichtKnop.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (MainActivity.this, FilmOverzicht.class);
                startActivity(intent);
            }
        }));

        muziekOverzichtKnop.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (MainActivity.this, MuziekOverzicht.class);
                startActivity(intent);

            }
        }));

        theaterOverzichtKnop.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (MainActivity.this, TheaterOverzicht.class);
                startActivity(intent);

            }
        }));

        gebruikerKnop.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (MainActivity.this, GebruikerInfo_main.class);
                startActivity(intent);
            }
        }));

        cursusOverzichtKnop.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (MainActivity.this, CursusCategorieOverzicht.class);
                startActivity(intent);
            }
        }));

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel running task(s) to avoid memory leaks
        if (DatabaseHandlers.connection != null)
            DatabaseHandlers.connection.cancel(true);
    }



    public void initialize()
    {
        //DatabaseHandlers.connection = new DatabaseConnection(this, this);
        DatabaseHandlers.dbCursus           = new DBCursus("Cursus", this, this);
        DatabaseHandlers.dbDocent           = new DBDocent("Docent", this, this);
        DatabaseHandlers.dbCursusCategorie  = new DBCursusCategorie("Cursuscategorie", this, this);
        DatabaseHandlers.dbFilm             = new DBFilm("Film", this, this);
        DatabaseHandlers.dbMuziek           = new DBMuziek("Muziek", this, this);
        DatabaseHandlers.dbTheater          = new DBTheater("Theater", this, this);
        DatabaseHandlers.dbEmail            = new DBEmail("EMAIL", this, this);
        DatabaseHandlers.dbGebruiker        = new DBGebruiker("GEBRUIKERS", this, this);
        DatabaseHandlers.dbReservering      = new DBReservering("RESERVERINGEN", this, this);
        DatabaseHandlers.dbEvent            = new DBEvent("Event", this, this);
        DatabaseHandlers.dbBeheerder        = new DBBeheerder("Beheerder", this, this);
        DatabaseHandlers.dbExpositie        = new DBExpositie("Expositie", this, this);
        DatabaseHandlers.dbKlantInlog       = new DBKlantInlog("KlantInlog", this, this);
        DatabaseHandlers.dbParkeren         = new DBParkeren("Parkeren", this, this);
    }
}
