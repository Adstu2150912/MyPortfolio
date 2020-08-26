/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Event;
import java.sql.ResultSet;
import java.util.ArrayList;
import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Muziek;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
/**
 *
 * @author dahir
 */
public class DBMuziek extends DatabaseTable {
 
    private ArrayList<Muziek> dataset = new ArrayList<Muziek>();
    
    
    public DBMuziek (DatabaseConnection toConnect, String sTableName){
        
        this.sTableName = sTableName;
        this.setDatabase(toConnect);
         
    } 
    
    @Override
    public void fillDataFromResultSet(ResultSet data)
    {
        try
        {
            dataset.clear();
            while(data.next())
            {
              Muziek geselecteerdeMuziek = new Muziek();
              geselecteerdeMuziek.setEventid(data.getInt("eventid"));
              geselecteerdeMuziek.setEvenementNaam(data.getString("evenementNaam"));
              geselecteerdeMuziek.setArtiest(data.getString("artiest"));
              geselecteerdeMuziek.setMuziekGenre(data.getString("muziekGenre"));
              geselecteerdeMuziek.setZaal(data.getString("zaal"));
              geselecteerdeMuziek.setBeschrijving(data.getString("beschrijving"));
              
              dataset.add(geselecteerdeMuziek); 
            }
    }
    

    catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Muziek [] getResults() {
       
       Muziek [] DataArray = new Muziek[dataset.toArray().length];
       
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
            StandardDebugActions.error("DBMuziek.insertDataIntoTable: Current Evenement is not initialized");
            return;
        }
        
        this.select("eventid = " + ((Muziek)instance).getEventid() + "");
        if(dataset.toArray().length >= 1) 
            {
            StandardDebugActions.error("DBMuziek.insertDataIntoTable: Current Primary Key (EventID " + ((Muziek) instance).getEventid()+ ") already exists");
            return;
        }
        
        DatabaseHandlers.dbevent.select("eventid=" + ((Muziek) instance).getEventid()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBMuziek.insertDataIntoTable: new foreign key 'FK_Muziek_Event' (EventID " + ((Muziek) instance).getEventid()+ ") does not exists");
            return;
        }     
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "eventid, "
                    + "evenementNaam, "
                    + "artiest, "
                    + "muziekGenre, "
                    + "zaal, "
                  + " beschrijving ) VALUES (";
        
        query += " " + ((Muziek) instance).getEventid()+ ", ";
        query += "'" + ((Muziek) instance).getEvenementNaam()+ "', ";
        query += "'" + ((Muziek) instance).getArtiest()+ "', ";
        query += "'" + ((Muziek) instance).getMuziekGenre()+ "', ";
        query += "'" + ((Muziek) instance).getZaal()+ "', ";
        query += "'" + ((Muziek) instance).getBeschrijving()+ "' ";
        query += ");";        
        
        database.connect();
        database.executeQuery(query);
        database.close();
        
    }

   
    
    @Override
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        
        if(!initialized)
        {
            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: Current Evenement is not initialized");
            return;
        }
        
        this.select("eventid=" + ((Muziek) fromInstance).getEventid()+ "");
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: Current instance Evenement is not in database; cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: Current Primary Key (EventID " + ((Muziek) fromInstance).getEventid()+ ") already exists");
            return;
        }    
        
        DatabaseHandlers.dbevent.select("eventid=" + ((Muziek) toInstance).getEventid()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: new foreign key 'FK_Muziek_Event' (EventId " + ((Muziek) toInstance).getEventid()+ ") does not exists");
            return;
        }     
        
        String query = "UPDATE " + sTableName + " ";
        query += "SET evenementNaam = '" + ((Muziek)toInstance).getEvenementNaam()+ "' ";
        query += ", artiest = '" + ((Muziek)toInstance).getArtiest()+ "'";
        query += ", muziekGenre = '" + ((Muziek)toInstance).getMuziekGenre()+ "'";
        query += ", zaal = '" + ((Muziek)toInstance).getZaal()+ "'";
        query += ", beschrijving = '" + ((Muziek)toInstance).getBeschrijving()+ "'";
        query += " WHERE eventid = " + ((Muziek) fromInstance).getEventid()+ " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
   
        
            @Override
         public void deleteSpecificData(Object instance)
    {
        if(instance instanceof Muziek)
            this.Delete("eventid = " + ((Muziek) instance).getEventid());
        else if(instance instanceof Event)
        {
            DatabaseHandlers.dbevent.select("eventid=" + ((Event) instance).getEventid()+ "");
            if(DatabaseHandlers.dbevent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBTheater.deleteSpecificData: foreign key 'Muziek_Event_FK' (eventid " + ((Event) instance).getEventid()+ ") does not exists");
                return;
            }          
            this.Delete("eventid = " + ((Event) instance).getEventid());
        }            
             
    }
}
