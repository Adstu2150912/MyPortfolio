/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author swkoe
 */
public class DBGebruikers extends DatabaseTable
{
    private ArrayList<Gebruiker> dataset = new ArrayList<Gebruiker>();
    
    
    public DBGebruikers(DatabaseConnection toConnect, String sTableName)
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
                Gebruiker gebruiker = new Gebruiker
                (
                          data.getString("EMAIL"),
                          data.getString("VOORNAAM"),
                          data.getString("ACHTERNAAM"),
                          data.getString("VOORLETTERS"),
                          data.getString("GESLACHT"),
                          data.getDate("GDTM"), 
                          data.getString("PLAATS"),
                          data.getString("STRAATNAAM"),
                          data.getString("HUISNUMMER"),
                          data.getString("TELEFOONNUMMER"),
                          data.getString("IBAN")
                );
                
                dataset.add(gebruiker); 
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public Gebruiker[] getResults()
    {
        Gebruiker[] DataArray = new Gebruiker[dataset.toArray().length];
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
        
        this.select("EMAIL='" + ((Gebruiker) instance).getsEmail() + "'");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        DatabaseHandlers.emails.select("EML='" + ((Gebruiker) instance).getsEmail() + "'");
        if(DatabaseHandlers.emails.getResults().length <= 0) 
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }

        String query = "INSERT INTO " + sTableName + " (`EMAIL`, `VOORNAAM`, `ACHTERNAAM`, `VOORLETTERS`, `GESLACHT`, `GDTM`, `PLAATS`, `STRAATNAAM`, `HUISNUMMER`, `TELEFOONNUMMER`, `IBAN`) VALUES ("
                + "'" + ((Gebruiker) instance).getsEmail() + "', "
                + "'" + ((Gebruiker) instance).getsVoornaam() + "', "
                + "'" + ((Gebruiker) instance).getsAchternaam() + "', "
                + "'" + ((Gebruiker) instance).getsVoornaam() + "', "
                + "'" + ((Gebruiker) instance).getsGeslacht() + "', "
                + "'" + ((Gebruiker) instance).getGeboorteDatum().toString() + "', "
                + "'" + ((Gebruiker) instance).getsPlaats() + "', "
                + "'" + ((Gebruiker) instance).getsStraatNaam() + "', "
                + "'" + ((Gebruiker) instance).getsHuisnummer() + "', "
                + "'" + ((Gebruiker) instance).getsTelefoonnummer() + "', "
                + "'" + ((Gebruiker) instance).getsIbanNummer()  + "' );";

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

        this.select("EMAIL='" + ((Gebruiker) fromInstance).getsEmail() + "'");
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }

        /*DatabaseHandlers.emails.select("EML='" + ((Gebruiker) toInstance).getsEmail() + "'");
        if(DatabaseHandlers.emails.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        } */


        String query = "UPDATE " + sTableName + " ";
        query       +=
                "SET `EMAIL` = '"           + ((Gebruiker) toInstance).getsEmail() + "', " +
                "`VOORNAAM`= '"             + ((Gebruiker) toInstance).getsVoornaam() + "', " +
                "`ACHTERNAAM`= '"           + ((Gebruiker) toInstance).getsAchternaam() + "', " +
                "`VOORLETTERS`= '"          + ((Gebruiker) toInstance).getsVoorletters() + "', " +
                "`GESLACHT`= '"             + ((Gebruiker) toInstance).getsGeslacht() + "', " +
                "`GDTM`= '"                 + ((Gebruiker) toInstance).getGeboorteDatum().toString() + "', " +
                "`PLAATS`= '"               + ((Gebruiker) toInstance).getsPlaats() + "', " +
                "`STRAATNAAM`= '"           + ((Gebruiker) toInstance).getsStraatNaam() + "', " +
                "`HUISNUMMER`= '"           + ((Gebruiker) toInstance).getsHuisnummer() + "', " +
                "`TELEFOONNUMMER`= '"       + ((Gebruiker) toInstance).getsTelefoonnummer() + "', " +
                "`IBAN`= '"                 + ((Gebruiker) toInstance).getsIbanNummer() + "' ";

        query       += "WHERE (`EMAIL` = '" + ((Gebruiker) fromInstance).getsEmail() + "');";

        database.connect();
        database.executeQuery(query);
        database.close();
    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        this.Delete("EMAIL='" + ((Gebruiker) instance).getsEmail() + "'");
    }
    
}
