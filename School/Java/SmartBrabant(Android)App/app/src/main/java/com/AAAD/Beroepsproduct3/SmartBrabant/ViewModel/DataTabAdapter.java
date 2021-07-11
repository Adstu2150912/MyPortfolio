package com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.View.IoT_ActiviteitFragment;
import com.AAAD.Beroepsproduct3.SmartBrabant.View.PlaatsAdviesFragment;
import com.AAAD.Beroepsproduct3.SmartBrabant.View.PlaatsInfoFragment;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 18-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: DataTabAdapter.java
 */
public class DataTabAdapter extends FragmentStatePagerAdapter
{
    private Context myContext;
    private Plaats huidigePlaats;
    int totalTabs;

    public DataTabAdapter(Context context, FragmentManager fm, int totalTabs, Plaats selectedPlaats){
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
        this.huidigePlaats = selectedPlaats;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                PlaatsAdviesFragment plaatsAdviesFragment = new PlaatsAdviesFragment(huidigePlaats);
                return plaatsAdviesFragment;
            case 1:
                IoT_ActiviteitFragment iot_activiteitFragment = new IoT_ActiviteitFragment(huidigePlaats);
                return iot_activiteitFragment;
            case 2:
                PlaatsInfoFragment plaatsInfoFragment = new PlaatsInfoFragment(huidigePlaats);
                return plaatsInfoFragment;
            default:
                return null;
        }
    }

    public int getCount(){
        return totalTabs;
    }

}
