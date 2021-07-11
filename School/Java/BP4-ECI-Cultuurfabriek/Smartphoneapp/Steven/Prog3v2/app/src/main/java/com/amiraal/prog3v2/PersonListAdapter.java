package com.amiraal.prog3v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import DataTypes.Klant;
import DataTypes.Medewerker;
import DataTypes.Persoon;

/**
 * class om de custom list te vullen met de persoon entiteit met zijn children klant en medewerker
 * @author Steven koemans
 * @version 2.0.1
 * @see android.widget.ArrayAdapter
 * @see DataTypes.Persoon
 * @see DataTypes.Klant
 * @see DataTypes.Medewerker
 */

public class PersonListAdapter extends ArrayAdapter
{
    private Context mContext;
    private int mResource;

    /**
     * Constructor zet de juiste waardes in de adapter om de view te vullen
     * @param context
     * @param resource
     * @param objects
     */

    public PersonListAdapter(Context context, int resource, ArrayList<Persoon> objects)
    {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    /**
     * Converteer de values van de lijst intance naar juiste lijst gui om in een lijstview te tonen
     * @param position
     * @param convertView
     * @param parent
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        String naam = ((Persoon)getItem(position)).getsNaam();
        String email = ((Persoon)getItem(position)).getsEmail();
        String type = "Klant";
        String tel = "-";

        Persoon persoon;


        if(((Persoon)getItem(position)) instanceof Medewerker)
        {
            type = "Medewerker";
            tel = ((Medewerker)getItem(position)).getsTelefoon();
            persoon = new Medewerker(naam, email, tel);
        }
        else
        {
            persoon = new Klant(naam, email);
        }

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView listnaam = (TextView) convertView.findViewById(R.id.txt_listName);
        TextView listType = (TextView) convertView.findViewById(R.id.txt_listTypeUser);
        TextView listEmail = (TextView) convertView.findViewById(R.id.txt_listEmail);
        TextView listTel = (TextView) convertView.findViewById(R.id.txt_listTel);

        listnaam.setText(naam);
        listType.setText(type);
        listEmail.setText(email);
        listTel.setText(tel);

        return convertView;
    }
}
