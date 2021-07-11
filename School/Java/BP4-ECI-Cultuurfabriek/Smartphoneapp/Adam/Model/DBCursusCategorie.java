package com.aaad.beroepsproduct4.eci_cultuurfabriekapp.Model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: dbCursuscategorie.java
 */

public abstract class DBCursusCategorie extends DBFunctionaliteit
{
    private Cursuscategorie currentCategorie;

    public ObservableList getDataFromDB()
    {
        return getCategorieDataFromDB();
    }

    private ObservableList getCategorieDataFromDB()
    {
        ObservableList<Cursuscategorie> selectieLijst = new ObservableArrayList();
        return selectieLijst;
    }

    public Boolean setDataToDB()
    {
        return this.setCategorieDataToDB();
    }

    private Boolean setCategorieDataToDB()
    {
        dbResult = false;

        if(this.currentCategorie != null)
        {

        }

        return dbResult;
    }

    public void setCategorie(Cursuscategorie selectedCategorie)
    {
        this.currentCategorie = selectedCategorie;
    }
}
