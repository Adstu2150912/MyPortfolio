package com.amiraal.prog3v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

/**
 * een activeiten gui build om aan te geven welke persoonen in de database zitten
 * @author Steven Koemans
 * @version 2.0.1
 */

public class Personen_activiteit extends AppCompatActivity {

    /**
     * Wanneer deze class aangeroepen word door de gui maakt hij een list op de gui view om de database values te zien
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personen);

        ListView pLijst = (ListView) findViewById(R.id.list_personen);
        PersonListAdapter personenlijst = new PersonListAdapter(this, R.layout.adapter_view_layout, Database.Gebruikers);
        pLijst.setAdapter(personenlijst);
    }
}
