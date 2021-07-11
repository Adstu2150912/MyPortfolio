package com.amiraal.prog3v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * De gebruikerToegevoegd_activity is de gui handler om weer te geven welke persoon is toegevoegd aan de database class.
 * hierbij word verwacht dat via de extra data de juiste velden worden ingevoerd om weer te geven
 *
 * @author Steven Koemans
 * @version 2.0.1
 *
 */

public class GebruikerToegevoegd_activity extends AppCompatActivity {

    /**
     * Bij deze functie word de juiste xml view weer gegeven en de extra data die we ontvangen hebben gezet in de TextView
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebruikertoegevoegd);

        Intent i = getIntent();
        String type = i.getStringExtra("Type");
        String naam = i.getStringExtra("Naam");
        String email = i.getStringExtra("Email");
        String tel;
        if(type.equalsIgnoreCase("Klant"))
        {
            tel = "-";
            ((TextView)findViewById(R.id.txt_ToegevoegdeUserTelOutput)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.txt_ToegevoegdeUserTel)).setVisibility(View.INVISIBLE);
        }
        else
        {
            tel = i.getStringExtra("Tel");
            ((TextView)findViewById(R.id.txt_ToegevoegdeUserTelOutput)).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.txt_ToegevoegdeUserTel)).setVisibility(View.VISIBLE);
        }

        ((TextView)findViewById(R.id.txt_ToegevoegdeUserType)).setText(type);
        ((TextView)findViewById(R.id.txt_ToegevoegdeUserNaamOutput)).setText(naam);
        ((TextView)findViewById(R.id.txt_ToegevoegdeUserEmailOutput)).setText(email);
        ((TextView)findViewById(R.id.txt_ToegevoegdeUserTelOutput)).setText(tel);

    }
}
