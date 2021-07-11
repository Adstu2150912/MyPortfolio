package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.ViewModel;

import com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model.DBDocent;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: VMDocent.java
 */
public class VMDocent extends DBDocent
{
    //Er mag slechts 1 instantie(exemplaar) bestaan uit deze klasse, binnen de gehele applicatie
    private static VMDocent instance = new VMDocent();

    private VMDocent(){}

    //Via deze methode kan het exemplaar van deze klasse opgehaald worden
    protected static VMDocent getInstance()
    {
        return instance;
    }
}
