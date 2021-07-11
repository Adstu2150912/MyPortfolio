package com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.databinding.ObservableList;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;

import java.util.List;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 15-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: PlaatsListAdapter.java
 */
public class PlaatsAdapter extends ArrayAdapter<Plaats>
{
    private int resourceLayout;
    private Context context;

    public PlaatsAdapter(Context context, int resource, ObservableList<Plaats> items)
    {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resourceLayout, null);
        }
        Plaats p = getItem(position);
        if(p != null){
            TextView plaatsNaam = v.findViewById(R.id.pliaPlaatsNaam);
            if(plaatsNaam != null){
                plaatsNaam.setText(String.format("%20s", p.getNaam()));
            }
        }
        return v;
    }
}
