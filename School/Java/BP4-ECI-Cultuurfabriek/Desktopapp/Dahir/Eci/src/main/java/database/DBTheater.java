/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import com.mycompany.eci.model.Theater;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public void fillDataFromResultSet(ResultSet data)
    {
        try
        {
            dataset.clear();
            while(data.next())
            {
              Theater geselecteerdeTheater = new Theater();
              geselecteerdeTheater.setEventId(data.getInt("eventId"));
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
    
    public void insertDataIntoTable(Object instance)
    {
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("eventId = " + ((Theater)instance).getEventId() + "");
        if(dataset.toArray().length >= 1) 
            {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "eventId, "
                    + "theaterNaam, "
                    + "regisseur "
                    + "theaterGenre "
                    + "duur "
                  + ") beschrijving (";
        
        query += " " + ((Theater) instance).getEventId()+ ", ";
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
    
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("eventId=" + ((Theater) fromInstance).getEventId()+ "");
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
        query += "SET theaterNaam = '" + ((Theater)toInstance).getTheaterNaam()+ "' ";
        query += ", regisseur = '" + ((Theater)toInstance).getRegisseur()+ "'";
        query += ", TheaterGenre = '" + ((Theater)toInstance).getTheaterGenre()+ "'";
        query += ", duur = '" + ((Theater)toInstance).getDuur()+ "'";
        query += ", beschrijving = '" + ((Theater)toInstance).getBeschrijving()+ "'";
        query += "WHERE eventId = " + ((Theater) fromInstance).getEventId()+ " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
       
         public void deleteSpecificData(Object instance)
    {
        this.Delete("eventId = " + ((Integer) instance));
    }

    @Override
    public void insertDataIntoTable(Object fromInstance, Object toInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
