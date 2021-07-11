package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseHandlers;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.FilmOverzicht;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.KlantInfo;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.MainActivity;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Reservering;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.R;

public class Reserveringen extends AppCompatActivity {

    private int nEventID = 0;

    public void btn_reserveren()
    {
        int nAantal = 0;
        try
        {
            nAantal = Integer.parseInt(((EditText) findViewById(R.id.txf_resAantalTickets)).getText().toString());
        }
        catch (Exception ex)
        {
            StandardDebugActions.error("parse not oke");
            StandardDebugActions.error(ex);
        }

        Reservering nieuweRes = new Reservering(KlantInfo.gebruiker.getsEmail(), nAantal, nEventID);
        DatabaseHandlers.dbReservering.insertDataIntoTable(nieuweRes);

        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserveringen);
        this.nEventID = this.getIntent().getIntExtra("EventID", 0);

        ((TextView) findViewById(R.id.txt_resEVID)).setText(nEventID);
    }
}
