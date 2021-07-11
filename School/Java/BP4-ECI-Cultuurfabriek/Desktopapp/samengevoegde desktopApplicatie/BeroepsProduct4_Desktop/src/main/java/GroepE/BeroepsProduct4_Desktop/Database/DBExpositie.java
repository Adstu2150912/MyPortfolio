package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Expositie;
import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author akina
 */
public class DBExpositie extends DatabaseTable {
    private ArrayList<Expositie> dataset = new ArrayList<Expositie>();
    
    
    public DBExpositie(DatabaseConnection toConnect, String sTableName)
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
                Expositie expositie = new Expositie(data.getString("expositie"), data.getString("omschrijving"),data.getString("startdatum"),data.getString("starttijd"), data.getString("einddatum"));
                
                dataset.add(expositie); 
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Expositie[] getResults()
    {
        Expositie[] DataArray = new Expositie[dataset.toArray().length];
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
        
        

        String query = "INSERT INTO " + sTableName + " (`expositie`, `omschrijving`, `startdatum`, `starttijd`, `einddatum`) VALUES ("
                + "'" + ((Expositie) instance).getExpositie() + "', "
                + "'" + ((Expositie) instance).getOmschrijving() + "', "
                + "'" + ((Expositie) instance).getStartdatum() + "', "
                + "'" + ((Expositie) instance).getStarttijd() + "', "
                + "'" + ((Expositie) instance).getEinddatum()  + "' );";

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
                "`expositie` = '"           + ((Expositie) toInstance).getExpositie() + "', " +
                "`omschrijving`= '"             + ((Expositie) toInstance).getOmschrijving() + "', " +
                "`startdatum`= '"             + ((Expositie) toInstance).getStartdatum() + "', " +
                "`starttijd`= '"             + ((Expositie) toInstance).getStarttijd() + "', " +
                "`einddatum`= '"                 + ((Expositie) toInstance).getEinddatum() + "' ";


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
    
