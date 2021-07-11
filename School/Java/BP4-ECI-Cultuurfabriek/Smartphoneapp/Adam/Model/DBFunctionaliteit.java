package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model;

import androidx.databinding.ObservableList;

import java.util.ArrayList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBFunctionaliteit.java
 */

public abstract class DBFunctionaliteit implements IDBFunctionaliteit
{
    protected Boolean dbResult; //Bewaar het resultaat van de meest recent uitgevoerde SQL-opdracht
    protected String dbConnection;
    protected ArrayList<String> dbStatements;
    protected String sqlLog;

    @Override
    public abstract ObservableList getDataFromDB();
    @Override
    public abstract Boolean setDataToDB();
}
