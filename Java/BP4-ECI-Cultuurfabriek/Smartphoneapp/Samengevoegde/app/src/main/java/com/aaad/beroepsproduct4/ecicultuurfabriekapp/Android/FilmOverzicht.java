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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseHandlers;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Film;

import java.util.ArrayList;

public class FilmOverzicht extends AppCompatActivity
{
    ListView filmListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_overzicht);

        filmview[] films = new filmview[5];
        films[0] = new filmview(new Film(1, "Avatar", "Nederland", "Pieter Broek", "Drama", "60 min", "wie leest er nou een beschrijving"), R.drawable.eci);
        films[1] = new filmview(new Film(2, "badboys", "nl", "pieter", "toneel", "6 jaar", "wie leest er nou een beschrijving"), R.drawable.eci);
        films[2] = new filmview(new Film(3, "avatar", "nl", "pieter", "toneel", "6 jaar", "wie leest er nou een beschrijving"), R.drawable.eci);
        films[3] = new filmview(new Film(4, "sunshine", "nl", "pieter", "toneel", "6 jaar", "wie leest er nou een beschrijving"), R.drawable.eci);
        films[4] = new filmview(new Film(5, "harry potter", "nl", "pieter", "toneel", "6 jaar", "wie leest er nou een beschrijving"), R.drawable.eci);

        filmListView = findViewById(R.id.listview);
        filmAdapterview naam = new filmAdapterview(this, R.layout.customlayout, films);
        filmListView.setAdapter(naam);

        filmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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


//        filmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intent = new Intent(FilmOverzicht.this, Film_Informatie.class);
//                intent.putExtra("filmInformatie", filmListView.getItemAtPosition(position).toString());
//                startActivity(intent);
//
//            }
//        });

    }

    class filmview
    {
        public Film film;
        public int url;

        public filmview(Film film, int url)
        {
            this.film = film;
            this.url = url;
        }
    }

    class filmAdapterview extends ArrayAdapter
    {
        Context mContext;
        int mResource;

        public filmAdapterview(Context context, int resource, filmview[] objects)
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

            filmview data = (filmview) getItem(position);

            fotoView.setImageResource(data.url);
            hoofdTitel.setText(data.film.getFilmNaam());
            genre.setText(data.film.getFilmGenre());


            return convertView;

        }

    }


//    class MyAdapter extends ArrayAdapter<String>{
//
//        Context context;
//        String filmNaam[];
//        String filmGenre [];
//        int foto[];
//
//        MyAdapter(Context c, String fNaam[], String fGenre[], int fOTO[]){
//            super(c, R.layout.customlayout, R.id.hoofdTitel);
//            this.context = c;
//            this.filmNaam = fNaam;
//            this.filmGenre = fGenre;
//            this.foto = fOTO;
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
//            View customlayout = layoutInflater.inflate(R.layout.customlayout, parent ,false);
//
//            ImageView fotoView = customlayout.findViewById(R.id.fotoView);
//            TextView hoofdTitel = customlayout.findViewById(R.id.hoofdTitel);
//            TextView genre = customlayout.findViewById(R.id.genre);
//
//            fotoView.setImageResource(foto[position]);
//            hoofdTitel.setText(filmNaam[position]);
//            genre.setText(filmGenre[position]);
//
//            return customlayout;
//
//        }
//    }

}
