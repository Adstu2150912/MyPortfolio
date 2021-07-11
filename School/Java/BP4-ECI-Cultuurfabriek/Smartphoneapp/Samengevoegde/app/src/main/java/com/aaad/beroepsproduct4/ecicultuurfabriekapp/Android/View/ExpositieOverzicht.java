package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Expositie;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.R;

public class ExpositieOverzicht extends AppCompatActivity {
    ListView expositieListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expositie_overzicht);

        expositieView[] exposities = new expositieView[5];

        exposities[0] = new expositieView(new Expositie("*expositie1*", "*beschrijving1*", "*2020-05-22*", "12:00", "2020-05-23"),  R.drawable.eci);
        exposities[1] = new expositieView(new Expositie("*expositie2*", "*beschrijving2*", "*2020-05-23*", "13:00", "2020-05-24"),  R.drawable.eci);
        exposities[2] = new expositieView(new Expositie("*expositie3*", "*beschrijving3*", "*2020-05-24*", "14:00", "2020-05-25"),  R.drawable.eci);
        exposities[3] = new expositieView(new Expositie("*expositie4*", "*beschrijving4*", "*2020-05-25*", "12:00", "2020-05-26"),  R.drawable.eci);
        exposities[4] = new expositieView(new Expositie("*expositie5*", "*beschrijving5*", "*2020-05-26*", "13:00", "2020-05-27"),  R.drawable.eci);

        expositieListView = findViewById(R.id.listview);
        expositieAdapterView naam = new expositieAdapterView(this, R.layout.customlayout, exposities);
        expositieListView.setAdapter(naam);

        expositieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Intent myIntent = new Intent(view.getContext(),ExpositieInformatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 1){

                    Intent myIntent = new Intent(view.getContext(),ExpositieInformatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 2){

                    Intent myIntent = new Intent(view.getContext(),ExpositieInformatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 3){

                    Intent myIntent = new Intent(view.getContext(),ExpositieInformatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 4){

                    Intent myIntent = new Intent(view.getContext(),ExpositieInformatie.class);
                    startActivityForResult(myIntent,0);
                }
            }
        });
    }

    class expositieView
    {
        public Expositie expositie;
        public int url;

        public expositieView(Expositie expositie, int url)
        {
            this.expositie = expositie;
            this.url = url;
        }
    }

    class expositieAdapterView extends ArrayAdapter
    {
        Context mContext;
        int mResource;

        public expositieAdapterView(Context context, int resource, expositieView[] objects)
        {
            super(context, resource, objects);
            mContext = context;
            mResource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource,parent,false);

            ImageView fotoView = convertView.findViewById(R.id.fotoView);
            TextView hoofdTitel = convertView.findViewById(R.id.hoofdTitel);
            TextView beschrijving = convertView.findViewById(R.id.genre);

            expositieView data = (expositieView) getItem(position);

            fotoView.setImageResource(data.url);
            hoofdTitel.setText(data.expositie.getExpositie());
            beschrijving.setText(data.expositie.getOmschrijving());
            return convertView;

        }
    }
}