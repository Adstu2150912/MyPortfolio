package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBHelper.java
 */

public class DBHelper
{
    //Er mag slechts 1 instantie(exemplaar) bestaan uit deze klasse, binnen de gehele applicatie
    private static DBHelper instance = new DBHelper();

    //Deze constructuur mag NIET buiten deze klasse worden aangeroepen
    private DBHelper() { }

    //Via deze methode kan het exemplaar van deze klasse opgehaald worden
    public static DBHelper getInstance() { return instance; }
}
