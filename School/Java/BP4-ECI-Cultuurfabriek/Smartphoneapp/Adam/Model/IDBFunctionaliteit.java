package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model;

import androidx.databinding.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: IDBFunctionaliteit.java
 */
public interface IDBFunctionaliteit
{
    public abstract ObservableList getDataFromDB();
    public abstract Boolean setDataToDB();
}
