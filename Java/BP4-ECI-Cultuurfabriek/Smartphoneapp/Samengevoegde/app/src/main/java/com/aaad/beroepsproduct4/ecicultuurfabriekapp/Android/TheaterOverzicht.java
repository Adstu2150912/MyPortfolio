package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android;

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

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Theater;

public class TheaterOverzicht extends AppCompatActivity {

    ListView theaterListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_overzicht);

        theaterview[] theaters = new theaterview[5];
        theaters[0] = new theaterview(new Theater(1,"pollo","pieter","drama","60 min","hallooo"), R.drawable.eci);
        theaters[1] = new theaterview(new Theater(2,"pollo","pieter","drama","60 min","hallooo"), R.drawable.eci);
        theaters[2] = new theaterview(new Theater(3,"pollo","pieter","drama","60 min","hallooo"), R.drawable.eci);
        theaters[3] = new theaterview(new Theater(4,"pollo","pieter","drama","60 min","hallooo"), R.drawable.eci);
        theaters[4] = new theaterview(new Theater(5,"pollo","pieter","drama","60 min","hallooo"), R.drawable.eci);

        theaterListView = findViewById(R.id.theaterlistview);
        theaterAdapterview naam = new theaterAdapterview(this, R.layout.customlayout, theaters);
        theaterListView.setAdapter(naam);

        theaterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    class theaterview
    {
        public Theater theater;
        public int url;

        public theaterview(Theater theater, int url)
        {
            this.theater = theater;
            this.url = url;
        }
    }

    class theaterAdapterview extends ArrayAdapter
    {
        Context mContext;
        int mResource;

        public theaterAdapterview(Context context, int resource, theaterview[] objects)
        {
            super(context, resource, objects);
            mContext = context;
            mResource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //View customlayout = layoutInflater.inflate(R.layout.customlayout, parent ,false);

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);


            ImageView fotoView = convertView.findViewById(R.id.fotoView);
            TextView hoofdTitel = convertView.findViewById(R.id.hoofdTitel);
            TextView genre = convertView.findViewById(R.id.genre);

            theaterview data = (theaterview) getItem(position);

            fotoView.setImageResource(data.url);
            hoofdTitel.setText(data.theater.getTheaterNaam());
            genre.setText(data.theater.getTheaterGenre());



            return convertView;

        }

    }
}
