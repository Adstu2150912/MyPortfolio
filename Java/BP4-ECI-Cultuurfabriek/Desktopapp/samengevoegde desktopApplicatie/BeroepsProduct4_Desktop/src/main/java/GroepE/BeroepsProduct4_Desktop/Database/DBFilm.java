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
import GroepE.BeroepsProduct4_Desktop.DataTypes.Film;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;


/**
 *
 * @author dahir
 */
public class DBFilm extends DatabaseTable {
    
    private ArrayList<Film> dataset = new ArrayList<Film>();
    
    
    public DBFilm (DatabaseConnection toConnect, String sTableName){
        
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
              Film geselecteerdeFilm = new Film();
              geselecteerdeFilm.setEventid(data.getInt("eventid"));
              geselecteerdeFilm.setFilmNaam(data.getString("filmNaam"));
              geselecteerdeFilm.setLand(data.getString("land"));
              geselecteerdeFilm.setRegisseur(data.getString("regisseur"));
              geselecteerdeFilm.setFilmGenre(data.getString("filmGenre"));
              geselecteerdeFilm.setDuur(data.getString("duur"));
              geselecteerdeFilm.setBeschrijving(data.getString("beschrijving"));
              
              dataset.add(geselecteerdeFilm); 
            }
    }
    

    catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
   public Film [] getResults() {
       
       Film [] DataArray = new Film[dataset.toArray().length];
       
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
            StandardDebugActions.error("DBFilm.insertDataIntoTable: Current Film is not initialized");
            return;
        }
        
        this.select("eventid = " + ((Film)instance).getEventid() + "");
        if(dataset.toArray().length >= 1) 
            {
            StandardDebugActions.error("DBFilm.insertDataIntoTable: Current Primary Key (EventID " + ((Film) instance).getEventid()+ ") already exists");
            return;
        }
        
        DatabaseHandlers.dbevent.select("eventid =" + ((Film) instance).getEventid()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBFilm.insertDataIntoTable: new foreign key 'FK_Film_Event' (EventID " + ((Film) instance).getEventid()+ ") does not exists");
            return;
        }     
        
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "eventid, "
                    + "filmNaam, "
                    + "land, "
                    + "regisseur, "
                    + "filmGenre, "
                    + "duur, "
                  + " beschrijving ) VALUES (";
        
        query += " " + ((Film) instance).getEventid()+ ", ";
        query += "'" + ((Film) instance).getFilmNaam()+ "', ";
        query += "'" + ((Film) instance).getLand()+ "', ";
        query += "'" + ((Film) instance).getRegisseur()+ "', ";
        query += "'" + ((Film) instance).getFilmGenre()+ "', ";
        query += "'" + ((Film) instance).getDuur()+ "', ";
        query += "'" + ((Film) instance).getBeschrijving()+ "' ";
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
            StandardDebugActions.error("DBFilm.UpdateDataIntoTable: Current Film is not initialized");
            return;
        }
        
        this.select("eventid=" + ((Film) fromInstance).getEventid()+ "");
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("DBFilm.UpdateDataIntoTable: Current instance Film not in database; cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBFilm.UpdateDataIntoTable: Current Primary Key (EventID " + ((Film) fromInstance).getEventid()+ ") already exists");
            return;
        }    
        
        DatabaseHandlers.dbevent.select("eventid=" + ((Film) toInstance).getEventid()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBFilm.UpdateDataIntoTable: new foreign key 'FK_Film_Event' (EventId " + ((Film) toInstance).getEventid()+ ") does not exists");
            return;
        }     
        
        
        
        String query = "UPDATE " + sTableName + " ";
        query += "SET filmNaam = '" + ((Film)toInstance).getFilmNaam()+ "' ";
        query += ", land = '" + ((Film)toInstance).getLand()+ "'";
        query += ", regisseur = '" + ((Film)toInstance).getRegisseur()+ "'";
        query += ", filmGenre = '" + ((Film)toInstance).getFilmGenre()+ "'";
        query += ", duur = '" + ((Film)toInstance).getDuur()+ "'";
        query += ", beschrijving = '" + ((Film)toInstance).getBeschrijving()+ "'";
        query += " WHERE eventid = " + ((Film) fromInstance).getEventid()+ " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    

    
       
    @Override
         public void deleteSpecificData(Object instance)
    {
        if(instance instanceof Film)
            this.Delete("eventid = " + ((Film) instance).getEventid());
        else if(instance instanceof Event)
        {
            DatabaseHandlers.dbevent.select("eventid=" + ((Event) instance).getEventid()+ "");
            if(DatabaseHandlers.dbevent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBFilm.deleteSpecificData: foreign key 'Film_Event_FK' (eventid " + ((Event) instance).getEventid()+ ") does not exists");
                return;
            }          
            this.Delete("eventid = " + ((Event) instance).getEventid());
        }            
             
    }
    
        
  }
