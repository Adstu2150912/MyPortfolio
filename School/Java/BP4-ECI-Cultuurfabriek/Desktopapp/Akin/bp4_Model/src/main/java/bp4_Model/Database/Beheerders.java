/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp4_Model.Database;

import bp4_Model.DataTypes.Beheerder;
import bp4_Model.DatabaseHandlers;
import bp4_Model.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author akina
 */
public class Beheerders extends DatabaseTable {
    private ArrayList<Beheerder> dataset = new ArrayList<Beheerder>();
    
    
    public Beheerders(DatabaseConnection toConnect, String sTableName)
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
                Beheerder beheerder = new Beheerder
                ( data.getString("beheerder"),data.getString("gebruikersnaam"),data.getString("wachtwoord"));
                
                dataset.add(beheerder); 
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Beheerder[] getResults()
    {
        Beheerder[] DataArray = new Beheerder[dataset.toArray().length];
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
        
        

        String query = "INSERT INTO " + sTableName + " (`beheerder`, `gebruikersnaam`, `wachtwoord`) VALUES ("
                + "'" + ((Beheerder) instance).getBeheerder() + "', "
                + "'" + ((Beheerder) instance).getGebruikersnaam() + "', "
                + "'" + ((Beheerder) instance).getWachtwoord()  + "' );";

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
                "`beheerder` = '"           + ((Beheerder) toInstance).getBeheerder() + "', " +
                "`gebruikersnaam`= '"             + ((Beheerder) toInstance).getGebruikersnaam() + "', " +
                "`wachtwoord`= '"                 + ((Beheerder) toInstance).getWachtwoord() + "' ";


        database.connect();
        database.executeQuery(query);
        database.close();
    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        //this.Delete(((Beheerder) instance)
    }
    
}
    

