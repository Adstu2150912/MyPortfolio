package com.amiraal.prog3v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import DataTypes.Klant;

/**
 * gebruikers activiteit view
 * hier in deze class word de functionaliteit van de gebruikers vieuw afgehandeld
 *
 * @author Steven Koemans
 * @version 2.0.1
 */

public class Gebruikers_activiteit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebruikers);
    }

    /**
     * Wanneer de knop toevoegen word ingedrukt gebeurt er het volgende:
     * uit de textvelden word de data van de gebruiker toegevoegd aan een nieuwe gebruiker
     * vervolgens zetten wij de gebruiker in de database class om gebruikt te worden in de list view
     * en geven wij in een GebruikerToegevoegd_activity weer welke gebruiker is aangemaakt.
     * @param v
     */

    public void btn_toevoegen(View v)
    {
        String naam = ((EditText) findViewById(R.id.txf_gebruikersnaam)).getText().toString();
        String email = ((EditText) findViewById(R.id.txf_gebruikersEmail)).getText().toString();

        Log.d("debugger", ("Naam: " + naam + " Email: " + email));

        Klant klant = new Klant(naam, email);
        Database.Gebruikers.add(klant);

        Log.d("debugger", "Gebruiker info");
        Intent startIntent = new Intent(this,  GebruikerToegevoegd_activity.class);
        startIntent.putExtra("Type", "Klant");
        startIntent.putExtra("Naam", klant.getsNaam());
        startIntent.putExtra("Email", klant.getsEmail());
        startActivity(startIntent);
    }



}