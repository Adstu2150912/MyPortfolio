/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Parkeren;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thobi
 */
public class DBParkeren extends DatabaseTable{
    private ArrayList<Parkeren> dataset = new ArrayList<Parkeren>();
    
    
    public DBParkeren(DatabaseConnection toConnect, String sTableName)
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
                Parkeren parkeren = new Parkeren
                (
                          data.getString("Email"),
                          data.getDate("Datum"),
                          data.getString("Parkkeerplek"),
                          data.getString("Opmerking")
                );
                dataset.add(parkeren); 
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Parkeren[] getResults()
    {
        Parkeren[] DataArray = new Parkeren[dataset.toArray().length];
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
        
        this.select("Email='" + ((Parkeren) instance).getsEML() + "'");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        DatabaseHandlers.emails.select("EML='" + ((Parkeren) instance).getsEML()+ "'");
        if(DatabaseHandlers.emails.getResults().length <= 0) 
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }

        String query = "INSERT INTO " + sTableName + " (`Email`, `Datum`, `Parkkeerplek`, `Opmerking`) VALUES ("
                + "'" + ((Parkeren) instance).getsEML() + "', "
                + "'" + ((Parkeren) instance).getsDate() + "', "
                + "'" + ((Parkeren) instance).getsParkeerplek() + "', "
                + "'" + ((Parkeren) instance).getsOpmerking() + "'); ";
                
               
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

        this.select("Email='" + ((Parkeren) fromInstance).getsEML() + "'");
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }

        DatabaseHandlers.emails.select("EML='" + ((Parkeren) toInstance).getsEML()+ "'");
        if(DatabaseHandlers.emails.getResults().length <= 0) 
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }


        String query = "UPDATE " + sTableName + " ";
        query       +=
                "SET `Email` = '"          + ((Parkeren) toInstance).getsEML() + "', " +
                "`Datum`= '"             + ((Parkeren) toInstance).getsDate() + "', " +
                "`Parkkeerplek`= '"      + ((Parkeren) toInstance).getsParkeerplek() + "', " +
                "`Opmerking`= '"         + ((Parkeren) toInstance).getsOpmerking() + "' ";


        query       += "WHERE (`Email` = '" + ((Parkeren) fromInstance).getsEML() + "');";

        database.connect();
        database.executeQuery(query);
        database.close();
    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        this.Delete("Email='" + ((Parkeren) instance).getsEML() + "'");
    }
}
