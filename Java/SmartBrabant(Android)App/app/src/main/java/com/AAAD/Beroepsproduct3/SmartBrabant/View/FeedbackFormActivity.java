package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Burger;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.VMDBFunctionaliteit;

import java.io.Serializable;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 15-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: FeedbackForm.java
 */
public class FeedbackFormActivity extends AppCompatActivity implements Serializable
{
    private static final String LOG_TAG = FeedbackFormActivity.class.getSimpleName();
    private VMDBFunctionaliteit dbFunctionaliteit = new VMDBFunctionaliteit();
    private Plaats selectedPlaats, huidigePlaats;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackform);
        Intent iHome = getIntent();
        huidigePlaats = (Plaats)iHome.getSerializableExtra("huidigePlaats");

        EditText etBSNnummer = (EditText) findViewById(R.id.etBSNnummer);
        EditText etNaam = (EditText) findViewById(R.id.etNaam);
        Spinner spinner = (Spinner) findViewById(R.id.ts_spinner_plaats);
        RadioGroup rgTevredenheid = (RadioGroup) findViewById(R.id.rgTevredenheidPlaats);
        RadioButton rbTevreden = (RadioButton) findViewById(R.id.rbTevreden);
        RadioButton rbOntevreden = (RadioButton) findViewById(R.id.rbOntevreden);
        EditText etMening = (EditText) findViewById(R.id.etMening);
        Button btnBevestig = (Button) findViewById(R.id.btnBevestig);
        ArrayAdapter<Plaats> adapter = new ArrayAdapter<Plaats>(this, android.R.layout.simple_spinner_item, dbFunctionaliteit.getGeoDataFromVM(this));
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id)
            {
                selectedPlaats = (Plaats) parent.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // Another interface callback
            }
        });

        btnBevestig.setOnClickListener(v ->
        {
            Boolean isFormValid = true;
            String invalidFields = "";
            Integer selectedTevredenheid = 0;

            if(etBSNnummer.getText().toString().isEmpty())
            {
                invalidFields += " BSNnummer; ";
                isFormValid = false;
            }

            if(etNaam.getText().toString().isEmpty())
            {
                invalidFields += " Naam; ";
                isFormValid = false;
            }

            if(selectedPlaats == null)
            {
                invalidFields += " Voorkeur plaats; ";
                isFormValid = false;
            }

            if(rgTevredenheid.getCheckedRadioButtonId() != rbTevreden.getId() && rgTevredenheid.getCheckedRadioButtonId() != rbOntevreden.getId())
            {
                invalidFields += " Tevredenheid; ";
                isFormValid = false;
            }
//            if(etMening.getText().toString().isEmpty())
//            {
//                isFormValid = false;
//                invalidFields += " Mening; ";
//            }


            if(isFormValid)
            {
                if(rbTevreden.isChecked())
                    selectedTevredenheid = 1;
                else if(rbOntevreden.isChecked())
                    selectedTevredenheid = 0;
                Burger huidigeBurger = new Burger(Integer.parseInt(etBSNnummer.getText().toString()), etNaam.getText().toString(), selectedPlaats.getNaam(),selectedTevredenheid, etMening.getText().toString());
                Boolean isInsertSucces = dbFunctionaliteit.setFeedbackFormToVM(this, huidigeBurger);
                if(isInsertSucces)
                {
                    toastMessage("Het versturen van dit formulier is geslaagd!");
                    Intent iFeedbackForm = new Intent(v.getContext(), HomeActivity.class);
                    iFeedbackForm.putExtra("huidigePlaats", huidigePlaats);
                    navigateUpTo(iFeedbackForm);
                }
                else
                    toastMessage("Het versturen van dit formulier is niet gelukt! Raadpleeg de ontwikkelaar.");
            }
            else
                toastMessage("Formulier is ongeldig; Volgende velden zijn niet goed ingevuld: " + invalidFields);
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
