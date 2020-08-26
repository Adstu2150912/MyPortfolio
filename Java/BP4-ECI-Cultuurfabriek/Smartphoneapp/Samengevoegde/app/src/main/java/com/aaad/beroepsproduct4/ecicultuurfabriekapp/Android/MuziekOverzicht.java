package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Muziek;

public class MuziekOverzicht extends AppCompatActivity {
    ListView muziekListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muziek_overzicht);

        muziekview[] evenement = new muziekview[5];
        evenement[0] = new muziekview(new Muziek(1,"Hiphop-allday","Tupac","Hiphop","3","gezellig"), R.drawable.eci);
        evenement[1] = new muziekview(new Muziek(2,"Hiphop-allday","Tupac","Hiphop","3","gezellig"), R.drawable.eci);
        evenement[2] = new muziekview(new Muziek(3,"Hiphop-allday","Tupac","Hiphop","3","gezellig"), R.drawable.eci);
        evenement[3] = new muziekview(new Muziek(4,"Hiphop-allday","Tupac","Hiphop","3","gezellig"), R.drawable.eci);
        evenement[4] = new muziekview(new Muziek(5,"Hiphop-allday","Tupac","Hiphop","3","gezellig"), R.drawable.eci);

        muziekListView = findViewById(R.id.muzieklistview);
        muziekAdapterview naam = new muziekAdapterview(this, R.layout.customlayout, evenement);
        muziekListView.setAdapter(naam);

        muziekListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Intent myIntent = new Intent(view.getContext(),Film_Informatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 1){

                    Intent myIntent = new Intent(view.getContext(),Film_Informatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 2){

                    Intent myIntent = new Intent(view.getContext(),Film_Informatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 3){

                    Intent myIntent = new Intent(view.getContext(),Film_Informatie.class);
                    startActivityForResult(myIntent,0);
                }

                if(position == 4){

                    Intent myIntent = new Intent(view.getContext(),Film_Informatie.class);
                    startActivityForResult(myIntent,0);
                }
            }
        });
    }

    class muziekview
    {
        public Muziek muziek;
        public int url;

        public muziekview(Muziek muziek, int url)
        {
            this.muziek = muziek;
            this.url = url;
        }
    }

    class muziekAdapterview extends ArrayAdapter
    {
        Context mContext;
        int mResource;

        public muziekAdapterview(Context context, int resource, muziekview[] objects)
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
            TextView genre = convertView.findViewById(R.id.genre);

            muziekview data = (muziekview) getItem(position);

            fotoView.setImageResource(data.url);
            hoofdTitel.setText(data.muziek.getEvenementNaam());
            genre.setText(data.muziek.getMuziekGenre());



            return convertView;

        }

    }
}
