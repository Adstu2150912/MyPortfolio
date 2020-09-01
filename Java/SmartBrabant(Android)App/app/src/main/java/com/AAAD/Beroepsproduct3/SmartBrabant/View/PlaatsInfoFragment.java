package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.VMDBFunctionaliteit;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 19-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: PlaatsInfoFragment.java
 */
public class PlaatsInfoFragment extends Fragment
{
    private Plaats huidigePlaats;
    private VMDBFunctionaliteit dbFunctionaliteit = new VMDBFunctionaliteit();

    public PlaatsInfoFragment(Plaats selectedPlaats)
    {
        this.huidigePlaats = selectedPlaats;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plaatsinfo, container, false);
        TextView tvFragmentTitel = view.findViewById(R.id.tvLblFragmentTitel);
        TextView tvPlaatsNaamWaarde = view.findViewById(R.id.tvPlaatsNaamWaarde);
        TextView tvGemeenteNaamWaarde = view.findViewById(R.id.tvPlaatsGemeenteWaarde);
        TextView tvStatusWaarde = view.findViewById(R.id.tvStatusWaarde);
        TextView tvOppervlakteWaarde = view.findViewById(R.id.tvOppervlakteWaarde);
        TextView tvStadPopWaarde = view.findViewById(R.id.tvStadPopWaarde);
        TextView tvGemeentePopWaarde = view.findViewById(R.id.tvGemeentePopWaarde);
        TextView tvMetroPopWaarde = view.findViewById(R.id.tvMetroPopWaarde);

        tvFragmentTitel.setText("Algemene info over " + huidigePlaats.getNaam() + ":");
        tvPlaatsNaamWaarde.setText(huidigePlaats.getNaam());
        tvGemeenteNaamWaarde.setText(huidigePlaats.getGemeente());
        if(huidigePlaats.getStatus() == 1) //Als huidige plaats smart is ingericht, laat de gebruiker dit weten
            tvStatusWaarde.setText("Ja");
        else
            tvStatusWaarde.setText("Nee");

        if(huidigePlaats.getOppervlakte() > 0)
            tvOppervlakteWaarde.setText(Double.toString(huidigePlaats.getOppervlakte()) + "km2");
        else
            tvOppervlakteWaarde.setText("n.v.t.");
        if(huidigePlaats.getStadPop() > 0)
            tvStadPopWaarde.setText(Integer.toString(huidigePlaats.getStadPop()));
        else
            tvStadPopWaarde.setText("n.v.t.");

        tvGemeentePopWaarde.setText(Integer.toString(huidigePlaats.getGemeentePop()));

        if(huidigePlaats.getMetroPop() > 0)
            tvMetroPopWaarde.setText(Integer.toString(huidigePlaats.getMetroPop()));
        else
            tvMetroPopWaarde.setText("n.v.t.");

        return view;
    }
}
