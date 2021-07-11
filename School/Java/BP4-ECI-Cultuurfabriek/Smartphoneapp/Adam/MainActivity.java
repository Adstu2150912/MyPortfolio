package com.aaad.beroepsproduct4.eci_cultuurfabriekapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: MainActivity.java
 */
public class MainActivity extends AppCompatActivity implements Serializable
{
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    TabLayout tab;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
