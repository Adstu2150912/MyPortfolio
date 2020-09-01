package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 15-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: FeedbackForm.java
 */
public class HelpForm extends AppCompatActivity
{
    private static final String LOG_TAG = HelpForm.class.getSimpleName();
    private Plaats huidigePlaats;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent iHome = getIntent();
        huidigePlaats = (Plaats)iHome.getSerializableExtra("huidigePlaats");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpform);

        Button btnBevestig = (Button) findViewById(R.id.btnBevestig);

        btnBevestig.setOnClickListener(v ->
        {
            toastMessage("Het versturen van dit formulier is geslaagd!");
            Intent iFeedbackForm = new Intent(v.getContext(), HomeActivity.class);
            iFeedbackForm.putExtra("huidigePlaats", huidigePlaats);
            navigateUpTo(iFeedbackForm);
        });
    }

    private void toastMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
