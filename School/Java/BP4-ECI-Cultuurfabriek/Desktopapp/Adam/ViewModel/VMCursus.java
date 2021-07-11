package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.ViewModel;

import com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Model.DBCursus;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: VMCursus.java
 */
public class VMCursus extends DBCursus
{
    //Er mag slechts 1 instantie(exemplaar) bestaan uit deze klasse, binnen de gehele applicatie
    private static VMCursus instance = new VMCursus();
    
    private VMCursus(){}
    
        //Via deze methode kan het exemplaar van deze klasse opgehaald worden
    protected static VMCursus getInstance()
    {
        return instance;
    }
}
