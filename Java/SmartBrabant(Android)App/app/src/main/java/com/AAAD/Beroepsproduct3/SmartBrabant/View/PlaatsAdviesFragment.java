package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Advies;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.VMDBFunctionaliteit;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 18-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: PlaatsAdviesFragment.java
 */
public class PlaatsAdviesFragment extends Fragment
{
    private Plaats huidigePlaats;
    private Advies huidigAdvies;
    private VMDBFunctionaliteit dbFunctionaliteit = new VMDBFunctionaliteit();

    // Vereiste openbare constructor
    public PlaatsAdviesFragment(Plaats selectedPlaats)
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
        View view = inflater.inflate(R.layout.fragment_plaatsadvies, container, false);
        TextView tvLblTevredenheid = (TextView) view.findViewById(R.id.tvLblTevredenheid);
        TextView tvLblAdvies = (TextView) view.findViewById(R.id.tvLblAdvies);
        TextView tvTevredenheidWaarde = (TextView) view.findViewById(R.id.tvTevredenheidWaarde);
        TextView tvAdviesWaarde = (TextView) view.findViewById(R.id.tvAdviesWaarde);


        tvLblTevredenheid.setText("Tevredenheid mensen over " + huidigePlaats.getNaam() + ":");
        tvTevredenheidWaarde.setText(huidigePlaats.getTevredenheid());
        huidigAdvies = dbFunctionaliteit.getAdviceDataFromVM(view.getContext(), huidigePlaats);

        tvLblAdvies.setText("Advies voor inrichting van " + huidigePlaats.getNaam()+ " als SMART-City:");
        if(huidigAdvies != null)
            tvAdviesWaarde.setText(huidigAdvies.getPva());
        else
            tvAdviesWaarde.setText("N.v.t.");

        return  view;
    }
}
