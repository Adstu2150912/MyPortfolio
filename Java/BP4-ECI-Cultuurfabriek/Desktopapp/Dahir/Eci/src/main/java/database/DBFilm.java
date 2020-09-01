/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mycompany.eci.model.Film;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public void fillDataFromResultSet(ResultSet data)
    {
        try
        {
            dataset.clear();
            while(data.next())
            {
              Film geselecteerdeFilm = new Film();
              geselecteerdeFilm.setEventId(data.getInt("eventId"));
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
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("eventId = " + ((Film)instance).getEventId() + "");
        if(dataset.toArray().length >= 1) 
            {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "eventId, "
                    + "filmNaam, "
                    + "land, "
                    + "regisseur "
                    + "filmGenre "
                    + "duur "
                  + ") beschrijving (";
        
        query += " " + ((Film) instance).getEventId()+ ", ";
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
        
        this.select("eventId=" + ((Film) fromInstance).getEventId()+ "");
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
        query += "SET filmNaam = '" + ((Film)toInstance).getFilmNaam()+ "' ";
        query += ", land = '" + ((Film)toInstance).getLand()+ "'";
        query += ", regisseur = '" + ((Film)toInstance).getRegisseur()+ "'";
        query += ", filmGenre = '" + ((Film)toInstance).getFilmGenre()+ "'";
        query += ", duur = '" + ((Film)toInstance).getDuur()+ "'";
        query += ", beschrijving = '" + ((Film)toInstance).getBeschrijving()+ "'";
        query += "WHERE eventId = " + ((Film) fromInstance).getEventId()+ " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
       
         public void deleteSpecificData(Object instance)
    {
        this.Delete("eventId = " + ((Integer) instance));
    }
    
        
  }


