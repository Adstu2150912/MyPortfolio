/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Collab;

import java.util.ArrayList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 11-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBCursusCategorie.java
 */
public class DBCursusCategorie 
{
    private ArrayList<Cursuscategorie> dataset = new ArrayList<Cursuscategorie>();
    
    public DBCursusCategorie(DatabaseConnection toConnect, String sTableName)
    {
        this.sTableName = sTableName;
        this.setDatabase(toConnect);
    }   
    
    public Cursuscategorie[] getResults()
    {
        Cursuscategorie[] DataArray = new Cursuscategorie[dataset.toArray().length];
        for(int i = 0; i < dataset.toArray().length; i++)
        {
            DataArray[i] = dataset.get(i);
        }
        return DataArray;
    }
    
    @Override
    public void insertDataIntoTable(Object instance)
    {
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("categorieID = " + ((Cursuscategorie) instance).getCategorieID() + "");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "categorieID, "
                    + "subCategorie, "
                    + "categorieNaam, "
                    + "omschrijving "
                  + ") VALUES (";
        
        query += " " + ((Cursuscategorie) instance).getCategorieID()           + ", ";
        query += "'" + ((Cursuscategorie) instance).getSubCategorie()        + "', ";
        query += "'" + ((Cursuscategorie) instance).getCategorieNaam()      + "', ";
        query += "'" + ((Cursuscategorie) instance).getOmschrijving()      + "' ";
        query += ");";        
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("categorieID=" + ((Cursuscategorie) fromInstance).getCategorieID + "");
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("Instance not in database cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }    
        
        String query = "UPDATE " + sTableName + " ";
        query += "SET subCategorie = '" + ((Cursuscategorie)toInstance).getSubCategorie + "' ";
        query += ", categorieNaam = '" + ((Cursuscategorie)toInstance).getCategorieNaam + "'";
        query += ", omschrijving = '" + ((Cursuscategorie)toInstance).getOmschrijving + "'";
        query += "WHERE categorieID = " + ((Cursuscategorie) fromInstance).getCategorieID + " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void deleteSpecificData(Object instance)
    {
        this.Delete("categorieID = " + ((Integer) instance));
    }
}
