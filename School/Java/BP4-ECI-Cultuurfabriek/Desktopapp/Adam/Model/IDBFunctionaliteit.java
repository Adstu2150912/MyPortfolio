package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Model;

import javafx.collections.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 06-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: IDBFunctionaliteit.java
 */

public interface IDBFunctionaliteit 
{
    public abstract boolean testDBConnection(); 
    public abstract ObservableList getDataFromDB();
    public abstract Boolean setDataToDB(int dmlType); //Parameter 'dmlType' geeft aan welk soort DML-statament uitgevoerd moet worden (0 = INSERT, 1 = UPDATE)
}
