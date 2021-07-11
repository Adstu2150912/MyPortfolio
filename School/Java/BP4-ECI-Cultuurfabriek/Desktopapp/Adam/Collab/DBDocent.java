/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Collab;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 11-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBDocent.java
 */
public class DBDocent extends DatabaseTable 
{
    private ArrayList<Docent> dataset = new ArrayList<Docent>();
    
    public DBDocent(DatabaseConnection toConnect, String sTableName)
    {
        this.sTableName = sTableName;
        this.setDatabase(toConnect);
    }
    
    public void fillDataFromResultSet(ResultSet data)
    {
        try
        {
            dataset.clear();
            while(data.next())
            {
                Docent selectedDocent = new Docent();
                selectedDocent.setDocentID(data.getInt("docentID"));
                selectedDocent.setDocNaam(data.getInt("docNaam"));
                selectedDocent.setBeschrijving(data.getInt("beschrijving"));
                selectedDocent.setDiscipline(data.getString("discipline"));
                dataset.add(selectedDocent); 
            }            
        } 
        catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Docent[] getResults()
    {
        Docent[] DataArray = new Docent[dataset.toArray().length];
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
        
        this.select("docentID = " + ((Docent) instance).getDocentID() + "");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }     
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "docentID, "
                    + "docNaam, "
                    + "beschrijving, "
                    + "discipline "
                  + ") VALUES (";
        
        query += " " + ((Docent) instance).getDocentID()           + ", ";
        query += "'" + ((Docent) instance).getDocNaam()        + "', ";
        query += "'" + ((Docent) instance).getBeschrijving()      + "', ";
        query += "'" + ((Docent) instance).getDiscipline()      + "' ";
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
        
        this.select("docentID=" + ((Docent) fromInstance).getDocentID + "");
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
        query += "SET docNaam = '" + ((Docent)toInstance).getDocNaam + "' ";
        query += ", beschrijving = '" + ((Docent)toInstance).getBeschrijving + "'";
        query += ", discipline = '" + ((Docent)toInstance).getDiscipline + "'";
        query += "WHERE docentID = " + ((Docent) fromInstance).getDocentID + " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void deleteSpecificData(Object instance)
    {
        this.Delete("docentID = " + ((Integer) instance));
    }
}
