/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mycompany.eci.model.Film;
import com.mycompany.eci.model.Muziek;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public void fillDataFromResultSet(ResultSet data)
    {
        try
        {
            dataset.clear();
            while(data.next())
            {
              Muziek geselecteerdeMuziek = new Muziek();
              geselecteerdeMuziek.setEventId(data.getInt("eventId"));
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
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("eventId = " + ((Muziek)instance).getEventId() + "");
        if(dataset.toArray().length >= 1) 
            {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "eventId, "
                    + "evenementNaam, "
                    + "artiest, "
                    + "muziekGenre "
                    + "zaal "
                  + ") beschrijving (";
        
        query += " " + ((Muziek) instance).getEventId()+ ", ";
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
    public void insertDataIntoTable(Object fromInstance, Object toInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("eventId=" + ((Muziek) fromInstance).getEventId()+ "");
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
        query += "SET evenementNaam = '" + ((Muziek)toInstance).getEvenementNaam()+ "' ";
        query += ", artiest = '" + ((Muziek)toInstance).getArtiest()+ "'";
        query += ", muziekGenre = '" + ((Muziek)toInstance).getMuziekGenre()+ "'";
        query += ", zaal = '" + ((Muziek)toInstance).getZaal()+ "'";
        query += ", beschrijving = '" + ((Muziek)toInstance).getBeschrijving()+ "'";
        query += "WHERE eventId = " + ((Muziek) fromInstance).getEventId()+ " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
        public void deleteSpecificData(Object instance)
    {
        this.Delete("eventId = " + ((Integer) instance));
    }
}
