package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableList;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Activiteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Advies;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.IoTApparaat;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.TableViewAdapter;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.TableViewListener;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.DataTabAdapter;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.VMDBFunctionaliteit;
import com.evrencoskun.tableview.TableView;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 16-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: HomeActivity.java
 */
public class HomeActivity extends AppCompatActivity implements Serializable
{
    private static final String LOG_TAG = HomeActivity.class.getSimpleName();
    TabLayout tab;
    ViewPager pager;
    private Plaats huidigePlaats;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_iot_activiteit, new
//                    IoT_ActiviteitFragment(), IoT_ActiviteitFragment.class.getSimpleName()).commit();
//        }

        Intent i = getIntent();
        huidigePlaats = (Plaats)i.getSerializableExtra("huidigePlaats");

//        IoT_ActiviteitFragment ioT_activiteitFragment = new IoT_ActiviteitFragment(huidigePlaats);
//        PlaatsDataFragment plaatsDataFragment = new PlaatsDataFragment(huidigePlaats);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.HoofdContainer, plaatsDataFragment, plaatsDataFragment.getClass().getSimpleName()).addToBackStack(null).commit();
//            getSupportFragmentManager().beginTransaction().replace(R.id.HoofdContainer, ioT_activiteitFragment, ioT_activiteitFragment.getClass().getSimpleName()).addToBackStack(null).commit();
//        }
        Button btnFeedbackForm = (Button) findViewById(R.id.btnFeedbackForm);
        Button btnHelpForm = (Button) findViewById(R.id.btnHelpForm);

        tab = findViewById(R.id.tabToonData);
        tab.addTab(tab.newTab().setText("Toon advies"));
        tab.addTab(tab.newTab().setText("Toon Activiteiten en apparatuur"));
        tab.addTab(tab.newTab().setText("Toon algemene info over " + huidigePlaats.getNaam()));
        tab.setTabGravity(TabLayout.GRAVITY_FILL);

        pager = findViewById(R.id.vpToonData);
        DataTabAdapter dataTabAdapter = new DataTabAdapter(this, getSupportFragmentManager(), tab.getTabCount(), huidigePlaats);
        pager.setAdapter(dataTabAdapter);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnFeedbackForm.setOnClickListener(v ->
        {
            Intent iFeedbackForm = new Intent(v.getContext(), FeedbackFormActivity.class);
            iFeedbackForm.putExtra("huidigePlaats", huidigePlaats);
            startActivity(iFeedbackForm);
        });

        btnHelpForm.setOnClickListener(v ->
        {
            Intent iHelpForm = new Intent(v.getContext(), HelpForm.class);
            iHelpForm.putExtra("huidigePlaats", huidigePlaats);
            startActivity(iHelpForm);
        });
        //Fragment objecten ophalen uit xml bestanden voor toegang tot de hier onderliggende controls
//        Fragment plaatsDataFragment = getFragmentManager().findFragmentById(R.id.fragment_plaatdata);
//        Fragment iot_ActiviteitFragment = getFragmentManager().findFragmentById(R.id.fragment_iot_activiteit);
//        View vPlaats = plaatsDataFragment.getView();
//        View vIoTActiviteitFragment = iot_ActiviteitFragment.getView();

    }
}
