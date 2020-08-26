package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: dbCursus.java
 */

public abstract class DBCursus extends DBFunctionaliteit
{
    private Cursus currentCursus;

    public ObservableList getDataFromDB()
    {
        return this.getCursusDataFromDB();
    }

    private ObservableList getCursusDataFromDB()
    {
        ObservableList<Cursus> selectieLijst = new ObservableArrayList();
        return selectieLijst;
    }

    public Boolean setDataToDB()
    {
        return this.setCursusDataToDB();
    }

    private Boolean setCursusDataToDB()
    {
        dbResult = false;
        return dbResult;
    }

    public void setCursus(Cursus selectedCursus)
    {
        this.currentCursus = selectedCursus;
    }
}
