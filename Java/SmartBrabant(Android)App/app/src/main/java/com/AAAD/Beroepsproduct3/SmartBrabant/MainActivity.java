package com.AAAD.Beroepsproduct3.SmartBrabant;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 02-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: MainActivity.java
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.View.HomeActivity;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.PlaatsAdapter;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.SpinnerActivity;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.VMDBFunctionaliteit;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable
{
    private VMDBFunctionaliteit dbFunctionaliteit = new VMDBFunctionaliteit();
    private SpinnerActivity spinnerActivity;
    private Plaats selectedPlaats;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.ts_spinner_plaats);
        Button btnBevestig = (Button) findViewById(R.id.btnBevestig);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, dbFunctionaliteit.getGeoDataFromVM(this).hashCode(), android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

        btnBevestig.setOnClickListener(v -> {
            if(selectedPlaats != null)
            {
                Intent i = new Intent(v.getContext(), HomeActivity.class);
                i.putExtra("huidigePlaats", selectedPlaats);
                startActivity(i);
            }
        });
//        spinnerActivity = new SpinnerActivity(spinner, this, btnBevestig);
    }
}
