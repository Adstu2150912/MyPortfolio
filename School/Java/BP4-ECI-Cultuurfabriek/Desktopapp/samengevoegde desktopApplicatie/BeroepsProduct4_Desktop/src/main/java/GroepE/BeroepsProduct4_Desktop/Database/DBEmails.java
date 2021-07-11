/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author swkoe
 */
public class DBEmails extends DatabaseTable
{
    private ArrayList<String> dataset = new ArrayList<String>();
    
    public DBEmails(DatabaseConnection toConnect, String sTableName)
    {
        this.sTableName = sTableName;
        this.setDatabase(toConnect);
    }

    @Override
    public void fillDataFromResultSet(ResultSet data)
    {
        try
        {
            this.dataset.clear();
            while(data.next())
            {
                this.dataset.add(data.getString("EML"));
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public String[] getResults()
    {
        String[] DataArray = new String[dataset.toArray().length];
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
        
        this.select("EML='" + ((String) instance) + "'");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        String query = "INSERT INTO " + sTableName + " (EML) VALUES ('";
        query += ((String) instance);
        query += "');";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }

    @Override
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("EML='" + ((String) fromInstance) + "'");
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("Instance not in database cannot update");
            return;
        }
        
        String query = "UPDATE " + sTableName + " ";
        query       += "SET EML = " + ((String)toInstance) + " ";
        query       += "WHERE EML = " + ((String) fromInstance) + " ;";
        
//        String query = "INSERT INTO " + sTableName + " (EML) VALUES ('";
//        query += ((String) instance);
//        query += "');";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        this.Delete("EML= '" + ((String) instance) + "'");
    }
}
