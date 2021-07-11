package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.R;

public class CursusCategorieInfo extends AppCompatActivity {
    ImageView cursusCategorieFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursus_categorie_info);

        cursusCategorieFoto = (ImageView)findViewById(R.id.fotoView);
        cursusCategorieFoto.setImageResource(R.drawable.eci);
    }
}
