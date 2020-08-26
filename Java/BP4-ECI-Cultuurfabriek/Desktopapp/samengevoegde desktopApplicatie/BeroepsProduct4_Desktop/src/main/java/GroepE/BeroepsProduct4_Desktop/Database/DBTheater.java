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
import GroepE.BeroepsProduct4_Desktop.DataTypes.Theater;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;

/**
 *
 * @author dahir
 */
public class DBTheater extends DatabaseTable {
    
    private ArrayList<Theater> dataset = new ArrayList<Theater>();
    
    public DBTheater (DatabaseConnection toConnect, String sTableName){
        
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
              Theater geselecteerdeTheater = new Theater();
              geselecteerdeTheater.setEventid(data.getInt("eventid"));
              geselecteerdeTheater.setTheaterNaam(data.getString("theaterNaam"));
              geselecteerdeTheater.setRegisseur(data.getString("regisseur"));
              geselecteerdeTheater.setTheaterGenre(data.getString("theaterGenre"));
              geselecteerdeTheater.setDuur(data.getString("duur"));
              geselecteerdeTheater.setBeschrijving(data.getString("beschrijving"));
              
              dataset.add(geselecteerdeTheater); 
            }
    }
    

    catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    
    public Theater [] getResults() {
       
       Theater [] DataArray = new Theater[dataset.toArray().length];
       
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
            StandardDebugActions.error("DBTheater.insertDataIntoTable: Current Theatervoorstelling is not initialized");
            return;
        }
        
        this.select("eventid = " + ((Theater)instance).getEventid()+ "");
        if(dataset.toArray().length >= 1) 
            {
            StandardDebugActions.error("DBTheater.insertDataIntoTable: Current Primary Key (EventID " + ((Theater) instance).getEventid()+ ") already exists");
            return;
        }
        
        DatabaseHandlers.dbevent.select("eventid=" + ((Theater) instance).getEventid()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBTheater.insertDataIntoTable: new foreign key 'FK_Theater_Event' (EventID " + ((Theater) instance).getEventid()+ ") does not exists");
            return;
        }   
        
        
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "eventid, "
                    + "theaterNaam, "
                    + "regisseur, "
                    + "theaterGenre, "
                    + "duur, "
                  + " beschrijving ) VALUES (";
        
        query += " " + ((Theater) instance).getEventid()+ ", ";
        query += "'" + ((Theater) instance).getTheaterNaam()+ "', ";
        query += "'" + ((Theater) instance).getRegisseur()+ "', ";
        query += "'" + ((Theater) instance).getTheaterGenre()+ "', ";
        query += "'" + ((Theater) instance).getDuur()+ "', ";
        query += "'" + ((Theater) instance).getBeschrijving()+ "' ";
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
            StandardDebugActions.error("DBTheater.UpdateDataIntoTable: Current Theatervoorstelling is not initialized");
            return;
        }
        
        this.select("eventid=" + ((Theater) fromInstance).getEventid()+ "");
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("DBTheater.UpdateDataIntoTable: Current instance Theatervoorstelling is not in database; cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBTheater.UpdateDataIntoTable: Current Primary Key (EventID " + ((Theater) fromInstance).getEventid()+ ") already exists");
            return;
        }    
        
        DatabaseHandlers.dbevent.select("eventid=" + ((Theater) toInstance).getEventid()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBTheater.UpdateDataIntoTable: new foreign key 'FK_Theater_Event' (EventId " + ((Theater) toInstance).getEventid()+ ") does not exists");
            return;
        }  
        
        String query = "UPDATE " + sTableName + " ";
        query += "SET theaterNaam = '" + ((Theater)toInstance).getTheaterNaam()+ "' ";
        query += ", regisseur = '" + ((Theater)toInstance).getRegisseur()+ "'";
        query += ", TheaterGenre = '" + ((Theater)toInstance).getTheaterGenre()+ "'";
        query += ", duur = '" + ((Theater)toInstance).getDuur()+ "'";
        query += ", beschrijving = '" + ((Theater)toInstance).getBeschrijving()+ "'";
        query += " WHERE eventid = " + ((Theater) fromInstance).getEventid()+ " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
       
   

                  @Override
         public void deleteSpecificData(Object instance)
    {
        if(instance instanceof Theater)
            this.Delete("eventid = " + ((Theater) instance).getEventid());
        else if(instance instanceof Event)
        {
            DatabaseHandlers.dbevent.select("eventid=" + ((Event) instance).getEventid()+ "");
            if(DatabaseHandlers.dbevent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBTheater.deleteSpecificData: foreign key 'Theater_Event_FK' (eventid " + ((Event) instance).getEventid()+ ") does not exists");
                return;
            }          
            this.Delete("eventid = " + ((Event) instance).getEventid());
        }            
             
    }
   
    
}

