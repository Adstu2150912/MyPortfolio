package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.R;


public class ExpositieInformatie extends AppCompatActivity {

    ImageView expositieFoto;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expositie_informatie);

        expositieFoto= (ImageView)findViewById(R.id.fotoView);
        expositieFoto.setImageResource(R.drawable.eci);




    }
}