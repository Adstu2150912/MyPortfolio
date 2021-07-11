package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Film_Informatie extends AppCompatActivity {

    ImageView filmFoto;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film__informatie);

        filmFoto= (ImageView)findViewById(R.id.fotoView);
        filmFoto.setImageResource(R.drawable.eci);




    }
}
