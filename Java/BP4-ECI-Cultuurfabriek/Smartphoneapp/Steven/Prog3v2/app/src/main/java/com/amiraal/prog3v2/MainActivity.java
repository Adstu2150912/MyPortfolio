package com.amiraal.prog3v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * this is the main gui class of the android application and the home view of the application
 *
 * @author Steven Koemans
 * @version 2.0.1
 *
 */

public class MainActivity extends AppCompatActivity
{

    /**
     * deze activiteit word aangeroepen wanneer de class door een startactivity word aangeroepen in de intent
     * hierbij zetten we de juiste activity
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * wanneer de knop valuta omrekenen is ingedrukt gebeurt het volgende:
     * debug welke view we gaan openen via intent
     * select deze intent
     * start de activity die we in de intent hebben geselecteerd
     * @param v
     */

    public void valutaOmrekenen(View v)
    {
        Log.d("debugger", "Valuta omrekenen");

        Intent startIntent = new Intent(this,  ValutaOmrekenen_activity.class);
        startActivity(startIntent);
    }

    /**
     * wanneer de knop gebruiker toevoegen is ingedrukt gebeurt het volgende:
     * debug welke view we gaan openen via intent
     * select deze intent
     * start de activity die we in de intent hebben geselecteerd
     * @param v
     */
    public void gebruikerToevoegen(View v)
    {
        Log.d("debugger", "gebruiker toevoegen");

        Intent startIntent = new Intent(this,  Gebruikers_activiteit.class);
        startActivity(startIntent);
    }

    /**
     * wanneer de knop medewerker toevoegen is ingedrukt gebeurt het volgende:
     * debug welke view we gaan openen via intent
     * select deze intent
     * start de activity die we in de intent hebben geselecteerd
     * @param v
     */

    public void werknemerToevoegen(View v)
    {
        Log.d("debugger", "werknemer toevoegen");

        Intent startIntent = new Intent(MainActivity.this,  Medewerker_activity.class);
        startActivity(startIntent);
    }

    /**
     * wanneer de knop personen weergeven is ingedrukt gebeurt het volgende:
     * debug welke view we gaan openen via intent
     * select deze intent
     * start de activity die we in de intent hebben geselecteerd
     * @param v
     */
    public void personenWeergeven(View v)
    {
        Log.d("debugger", "personenen weergeven");

        Intent startIntent = new Intent(MainActivity.this,  Personen_activiteit.class);
        startActivity(startIntent);
    }
}
