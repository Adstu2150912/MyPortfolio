package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: dbDocent.java
 */

public abstract class DBDocent extends DBFunctionaliteit
{
    private Docent currentDocent;

    public ObservableList getDataFromDB()
    {
        return this.getDocentDataFromDB();
    }

    private ObservableList getDocentDataFromDB()
    {
        ObservableList<Docent> selectieLijst = new ObservableArrayList();
        return selectieLijst;
    }

    public Boolean setDataToDB()
    {
        return this.setDocentDataToDB();
    }

    private Boolean setDocentDataToDB()
    {
        dbResult = false;

        if(this.currentDocent != null)
        {

        }

        return dbResult;
    }

    public void setDocent(Docent selectedDocent)
    {
        this.currentDocent = selectedDocent;
    }
}
