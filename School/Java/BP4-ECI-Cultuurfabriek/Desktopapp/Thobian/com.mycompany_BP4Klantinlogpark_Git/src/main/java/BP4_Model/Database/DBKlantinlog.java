/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BP4_Model.Database;

import BP4_Model.Table.Klantinlog;
import BP4_Model.DatabaseHandlers;
import BP4_Model.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thobi
 */
public class DBKlantinlog extends DatabaseTable
{
    private ArrayList<Klantinlog> dataset = new ArrayList<Klantinlog>();
    
    
    public DBKlantinlog(DatabaseConnection toConnect, String sTableName)
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
                Klantinlog klantinlog = new Klantinlog
                (
                          data.getString("Email"), 
                          data.getString("Inlognaam"),
                          data.getString("Wachtwoord")
                );
                
                
                dataset.add(klantinlog); 
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Klantinlog[] getResults()
    {
        Klantinlog[] DataArray = new Klantinlog[dataset.toArray().length];
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
        
        this.select("Email='" + ((Klantinlog) instance).getsEML() + "'");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        DatabaseHandlers.Klantinloggen.select("Email='" + ((Klantinlog) instance).getsEML() + "'");
        if(DatabaseHandlers.Klantinloggen.getResults().length <= 0) 
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }
        
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "Email, "
                    + "Inlognaam, "
                    + "Wachtwoord, "

                  + ") VALUES (";
        
        query += "'" + ((Klantinlog) instance).getsEML()           + "', ";
        query += "'" + ((Klantinlog) instance).getsInlognaam()        + "', ";
        query += "'" + ((Klantinlog) instance).getsWachtwoord()      + "', ";

        query += ");";
        
//        System.out.println(query);
        
        
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

        this.select("Email='" + ((Klantinlog) fromInstance).getsEML() + "'");
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }

        DatabaseHandlers.parkeren.select("Email='" + ((Klantinlog) toInstance).getsEML() + "'");
        if(DatabaseHandlers.parkeren.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }


        String query = "UPDATE " + sTableName + " ";
        query       +=
                "SET `Email` = '"          + ((Klantinlog) toInstance).getsEML() + "', " +
                "`Inlognaam`= '"      + ((Klantinlog) toInstance).getsInlognaam() + "', " +
                "`Wachtwoord`= '"         + ((Klantinlog) toInstance).getsWachtwoord() + "', ";


        query       += "WHERE (`Email` = '" + ((Klantinlog) fromInstance).getsEML() + "');";

        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void deleteSpecificData(Object instance)
    {
        this.Delete("Email='" + ((Klantinlog) instance).getsEML() + "'");
    }
}
