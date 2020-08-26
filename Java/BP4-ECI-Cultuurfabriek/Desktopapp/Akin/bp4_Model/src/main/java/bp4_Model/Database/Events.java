/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp4_Model.Database;

import bp4_Model.DataTypes.Beheerder;
import bp4_Model.DataTypes.Event;
import bp4_Model.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author akina
 */
public class Events extends DatabaseTable {
    private ArrayList<Event> dataset = new ArrayList<Event>();
    
    
    public Events(DatabaseConnection toConnect, String sTableName)
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
                Event event = new Event(data.getInt("eventid"), data.getString("omschrijving"),data.getString("datum"),data.getString("tijd"), data.getDouble("prijs"));
                
                dataset.add(event); 
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Event[] getResults()
    {
        Event[] DataArray = new Event[dataset.toArray().length];
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
        
        

        String query = "INSERT INTO " + sTableName + " (`eventid`, `omschrijving`, `datum`, `tijd`, `prijs`) VALUES ("
                + "'" + ((Event) instance).getEventid() + "', "
                + "'" + ((Event) instance).getOmschrijving() + "', "
                + "'" + ((Event) instance).getDatum() + "', "
                + "'" + ((Event) instance).getTijd() + "', "
                + "'" + ((Event) instance).getPrijs()  + "' );";

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

        


        String query = "UPDATE " + sTableName + " ";
        query       +=
                "`eventid` = '"           + ((Event) toInstance).getEventid() + "', " +
                "`omschrijving`= '"             + ((Event) toInstance).getOmschrijving() + "', " +
                "`datum`= '"             + ((Event) toInstance).getDatum() + "', " +
                "`tijd`= '"             + ((Event) toInstance).getTijd() + "', " +
                "`prijs`= '"                 + ((Event) toInstance).getPrijs() + "' ";


        database.connect();
        database.executeQuery(query);
        database.close();
    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        //this.Delete(((Beheerder) instance) + "'");
    }
    
}
    

