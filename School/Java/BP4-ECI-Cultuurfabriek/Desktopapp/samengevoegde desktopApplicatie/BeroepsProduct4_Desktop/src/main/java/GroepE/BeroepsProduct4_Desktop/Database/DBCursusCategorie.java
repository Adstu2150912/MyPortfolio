/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursus;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursuscategorie;
import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 11-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBCursusCategorie.java
 */
public class DBCursusCategorie extends DatabaseTable
{
    private ArrayList<Cursuscategorie> dataset = new ArrayList<Cursuscategorie>();
    
    public DBCursusCategorie(DatabaseConnection toConnect, String sTableName)
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
                Cursuscategorie selectedCategorie = new Cursuscategorie();
                selectedCategorie.setCategorieID(data.getInt("categorieID"));
                selectedCategorie.setCategorieNaam(data.getString("categorieNaam"));
                selectedCategorie.setOmschrijving(data.getString("omschrijving"));
                selectedCategorie.setSubCategorie(data.getString("subCategorie"));
                
                dataset.add(selectedCategorie); 
            }            
        } 
        catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
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
            StandardDebugActions.error("DBCursusCategorie.insertDataIntoTable: Current cursus not initialized");
            return;
        }
        
        this.select("categorieID = " + ((Cursuscategorie) instance).getCategorieID() + "");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("DBCursusCategorie.insertDataIntoTable: Current Primary Key (CategorieID " + ((Cursuscategorie) instance).getCategorieID() + ") already exists");
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
            StandardDebugActions.error("DBCursusCategorie.UpdateDataIntoTable: Not initialized");
            return;
        }
        
        this.select("categorieID=" + ((Cursuscategorie) fromInstance).getCategorieID() + "");
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("DBCursusCategorie.UpdateDataIntoTable: Instance not in database cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBCursusCategorie.UpdateDataIntoTable: Current Primary Key (CategorieID " + ((Cursuscategorie) fromInstance).getCategorieID() + ") already exists");
            return;
        }    
        
        String query = "UPDATE " + sTableName + " ";
        query += "SET subCategorie = '" + ((Cursuscategorie)toInstance).getSubCategorie() + "' ";
        query += ", categorieNaam = '" + ((Cursuscategorie)toInstance).getCategorieNaam() + "'";
        query += ", omschrijving = '" + ((Cursuscategorie)toInstance).getOmschrijving() + "'";
        query += "WHERE categorieID = " + ((Cursuscategorie) fromInstance).getCategorieID() + " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void deleteSpecificData(Object instance)
    {
        if(instance instanceof Cursuscategorie)            
            this.Delete("categorieID = " + ((Cursuscategorie) instance).getCategorieID());
        else if(instance instanceof Cursus)
            this.Delete("categorieID = " + ((Cursus) instance).getCategorieID());
    }
}
