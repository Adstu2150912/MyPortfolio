package com.amiraal.prog3v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * gui handler om de valuta omrekenen scherm te laten functioneren
 * @author Steven Koemans
 * @version 2.0.1
 */

public class ValutaOmrekenen_activity extends AppCompatActivity {

    /**
     * voor het zetten van de view word deze functie aangeroepen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valuta_omrekenen);
    }

    /**
     * Wanneer op de knop omrekenen word gedrukt zal de volgende code worden uit gevoerd
     * er word gekeken welke invoer waarde de gebruiker heeft ingevoerd
     * vervolgens word die waarde omgezet van euro's naar dollars of andersom afhankelijk van de geselecteerde mode
     * en tot slot word de uitvoer in de juiste textview gezet
     * @param v
     */
    public void omrekenen(View v) {
        String sToDouble = ((EditText) findViewById(R.id.txf_convertAmount)).getText().toString();
        double dToConvert = 1.0;
        try {
            dToConvert = Double.parseDouble(sToDouble);
        } catch (Exception ex) {
            Log.d("debugger", ex.getMessage());
        }

        boolean lEuro = ((RadioButton) findViewById(R.id.rbtn_euro)).isChecked();
        boolean lDollar = ((RadioButton) findViewById(R.id.rbtn_dollar)).isChecked();

        if (lEuro) {
            dToConvert *= 0.92;
            ((TextView) findViewById(R.id.txt_conversion)).setText("Bedrag in euro's");
        } else if (lDollar) {
            dToConvert /= 0.92;
            ((TextView) findViewById(R.id.txt_conversion)).setText("Bedrag in dollars");
        }

        ((TextView) findViewById(R.id.txt_calculatedValue)).setText(String.format("%.2f", dToConvert));

    }
}