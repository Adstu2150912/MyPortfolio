package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.ViewModel;

import com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model.DBCursusCategorie;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: VMCursusCategorie.java
 */
public class VMCursusCategorie extends DBCursusCategorie
{
    //Er mag slechts 1 instantie(exemplaar) bestaan uit deze klasse, binnen de gehele applicatie
    private static VMCursusCategorie instance = new VMCursusCategorie();

    private VMCursusCategorie(){}

    //Via deze methode kan het exemplaar van deze klasse opgehaald worden
    protected static VMCursusCategorie getInstance()
    {
        return instance;
    }
}