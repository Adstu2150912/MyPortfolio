package com.amiraal.prog3v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import DataTypes.Medewerker;

/**
 * Gui activiteiten class waar gui elementen worden afgehandeld
 *
 * @author Steven Koemans
 * @version 2.0.1
 *
 */

public class Medewerker_activity extends AppCompatActivity {

    /**
     * Gui handler van de Medewerker activity zorgt voor wanneer de class naar de front word geroepen dat de juiste waardes in gui worden gezet
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medewerker);
    }

    /**
     * Wanneer de knop toevoegen word ingedrukt gebeurt er het volgende:
     * uit de textvelden word de data van de mederwerker toegevoegd aan een nieuwe mederwerker
     * vervolgens zetten wij de mederwerker in de database class om mederwerker te worden in de list view
     * en geven wij in een GebruikerToegevoegd_activity weer welke mederwerker is aangemaakt.
     * @param v
     */
    public void toevoegen(View v)
    {
        String naam = ((EditText) findViewById(R.id.txf_WerknemerNaam)).getText().toString();
        String email = ((EditText) findViewById(R.id.txf_WerknemerEmail)).getText().toString();
        String tel = ((EditText) findViewById(R.id.txf_WerknemersTel)).getText().toString();


        Log.d("debugger", ("Naam: " + naam + " Email: " + email + " Tel: " + tel));

        Medewerker medewerker = new Medewerker(naam, email, tel);
        Database.Gebruikers.add(medewerker);

        Log.d("debugger", "Gebruiker info");
        Intent startIntent = new Intent(this,  GebruikerToegevoegd_activity.class);
        startIntent.putExtra("Type", "Medewerker");
        startIntent.putExtra("Naam", medewerker.getsNaam());
        startIntent.putExtra("Email", medewerker.getsEmail());
        startIntent.putExtra("Tel", medewerker.getsTelefoon());
        startActivity(startIntent);
    }
}
