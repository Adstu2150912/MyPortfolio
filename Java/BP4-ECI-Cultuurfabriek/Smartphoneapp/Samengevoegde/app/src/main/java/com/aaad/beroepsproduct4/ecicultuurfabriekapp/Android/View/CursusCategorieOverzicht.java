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

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Cursus;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.R;

public class CursusCategorieOverzicht extends AppCompatActivity {
    ListView cursusListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursus_categorie_overzicht);

        cursusView[] cursus = new cursusView[5];

        cursus[0] = new cursusView(new Cursus(1, "*cursus1*", "*beschrijving1*", "*doelGroep1*", "2020-05-15", "vr", "17:55:00", 4, "Wekelijks 1 keer", 10, 1.23, 1, 1),  R.drawable.eci);
        cursus[1] = new cursusView(new Cursus(2, "*cursus2*", "*beschrijving2*", "*doelGroep2*", "2020-05-15", "vr", "17:57:00", 5, "Wekelijks 1 keer", 10, 2.23, 1, 2),  R.drawable.eci);
        cursus[2] = new cursusView(new Cursus(3, "*cursus3*", "*beschrijving3*", "*doelGroep3*", "2020-05-15", "vr", "17:58:00", 6, "Wekelijks 1 keer", 10, 3.23, 1, 3),  R.drawable.eci);
        cursus[3] = new cursusView(new Cursus(4, "*cursus4*", "*beschrijving4*", "*doelGroep4*", "2020-05-15", "vr", "17:59:00", 7, "Wekelijks 1 keer", 10, 4.23, 3, 1),  R.drawable.eci);
        cursus[4] = new cursusView(new Cursus(5, "*cursus5*", "*beschrijving5*", "*doelGroep5*", "2020-05-15", "vr", "18:00:00", 8, "Wekelijks 1 keer", 10, 5.23, 3, 2),  R.drawable.eci);

        cursusListView = findViewById(R.id.cursusListView);
        cursusAdapterView naam = new cursusAdapterView(this, R.layout.customlayout, cursus);
        cursusListView.setAdapter(naam);

        cursusListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Intent myIntent = new Intent(view.getContext(),CursusCategorieInfo.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 1){

                    Intent myIntent = new Intent(view.getContext(),CursusCategorieInfo.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 2){

                    Intent myIntent = new Intent(view.getContext(),CursusCategorieInfo.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 3){

                    Intent myIntent = new Intent(view.getContext(),CursusCategorieInfo.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 4){

                    Intent myIntent = new Intent(view.getContext(),CursusCategorieInfo.class);
                    startActivityForResult(myIntent,0);
                }
            }
        });
    }

    class cursusView
    {
        public Cursus cursus;
        public int url;

        public cursusView(Cursus cursus, int url)
        {
            this.cursus = cursus;
            this.url = url;
        }
    }

    class cursusAdapterView extends ArrayAdapter
    {
        Context mContext;
        int mResource;

        public cursusAdapterView(Context context, int resource, cursusView[] objects)
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

            cursusView data = (cursusView) getItem(position);

            fotoView.setImageResource(data.url);
            hoofdTitel.setText(data.cursus.getCursusNaam());
            beschrijving.setText(data.cursus.getBeschrijving());
            return convertView;

        }
    }
}
