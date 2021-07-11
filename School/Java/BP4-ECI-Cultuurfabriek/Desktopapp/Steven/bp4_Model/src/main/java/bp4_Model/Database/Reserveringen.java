/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp4_Model.Database;

import bp4_Model.DataTypes.Gebruiker;
import bp4_Model.DataTypes.Reservering;
import bp4_Model.DatabaseHandlers;
import bp4_Model.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author swkoe
 */
public class Reserveringen extends DatabaseTable
{
    private ArrayList<Reservering> dataset = new ArrayList<Reservering>();
    
    
    public Reserveringen(DatabaseConnection toConnect, String sTableName)
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
                Reservering reservering = new Reservering
                (
                    data.getString  ("EMAIL"), 
                    data.getInt     ("AANTAL_TICKETS"),
                    data.getInt     ("EVENT_ID")
                );
                
                
                dataset.add(reservering); 
            }
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }

    
    public Reservering[] getResults()
    {
        Reservering[] DataArray = new Reservering[dataset.toArray().length];
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

        String selectPrimaryKey = "EMAIL='" + ((Reservering) instance).getsEmail() + "' AND";
        selectPrimaryKey += " AANTAL_TICKETS='" + ((Reservering) instance).getnAantalTickets() + "' AND";
        selectPrimaryKey += " EVENT_ID='" + ((Reservering) instance).getnEventID() + "';";

        this.select(selectPrimaryKey);
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }

        DatabaseHandlers.emails.select("EML='" + ((Reservering) instance).getsEmail() + "'");
        if(DatabaseHandlers.emails.getResults().length <= 0)
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }
        
        database.connect();
        database.readQuery("SELECT * FROM `EVENT_ID_TEST` WHERE (`EVENT_ID` = '" + ((Reservering) instance).getnEventID() +"');");
        ResultSet data = database.getResult();
        
        ArrayList<String> foreignCheck = new ArrayList<>();
        try
        {
            while(data.next())
            {
                foreignCheck.add(data.getString("EVENT_ID"));
            }
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
        
        
//        fillDataFromResultSet(data);
        database.close();
        
        
//        DatabaseHandlers.emails.select("EML='" + ((Gebruiker) toInstance).getsEmail() + "'");
        if(foreignCheck.toArray().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }

//        INSERT INTO `beroepsProduct4`.`RESERVERINGEN` (`EMAIL`, `AANTAL_TICKETS`, `EVENT_ID`) VALUES ('test1', '15', '2');
        String query = "INSERT INTO "+ sTableName +" (`EMAIL`, `AANTAL_TICKETS`, `EVENT_ID`) VALUES ("
                + "'" + ((Reservering) instance).getsEmail() + "', "
                + "'" + ((Reservering) instance).getnAantalTickets() + "', "
                + "'" + ((Reservering) instance).getnEventID()  + "' );";

//        System.out.println(query);

        database.connect();
        database.executeQuery(query);
        database.close();
    }

    @Override
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        String selectPrimaryKey = "EMAIL='" + ((Reservering) fromInstance).getsEmail() + "' AND";
        selectPrimaryKey += " AANTAL_TICKETS='" + ((Reservering) fromInstance).getnAantalTickets() + "' AND";
        selectPrimaryKey += " EVENT_ID='" + ((Reservering) fromInstance).getnEventID() + "';";

        this.select(selectPrimaryKey);
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key not exist exist");
            return;
        }
        
        DatabaseHandlers.emails.select("EML='" + ((Reservering) toInstance).getsEmail() + "'");
        if(DatabaseHandlers.emails.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }
        
        database.connect();
        database.readQuery("SELECT * FROM `EVENT_ID_TEST` WHERE (`EVENT_ID` = '" + ((Reservering) fromInstance).getnEventID() +"');");
        ResultSet data = database.getResult();
        
        ArrayList<String> foreignCheck = new ArrayList<>();
        try
        {
            while(data.next())
            {
                foreignCheck.add(data.getString("EVENT_ID"));
            }
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
        
        
//        fillDataFromResultSet(data);
        database.close();
        
        
//        DatabaseHandlers.emails.select("EML='" + ((Gebruiker) toInstance).getsEmail() + "'");
        if(foreignCheck.toArray().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }

//      UPDATE `beroepsProduct4`.`RESERVERINGEN` SET `AANTAL_TICKETS` = '5', `EVENT_ID` = '2' WHERE (`EMAIL` = 'test3') and (`EVENT_ID` = '5') and (`AANTAL_TICKETS` = '2');
        

        String query = "UPDATE " + sTableName + " ";
        query       +=
                "SET `EMAIL` = '"                   + ((Reservering) toInstance).getsEmail() + "', " +
                "`AANTAL_TICKETS`= '"               + ((Reservering) toInstance).getnAantalTickets() + "', " +
                "`EVENT_ID`= '"                     + ((Reservering) toInstance).getnEventID()+ "' ";

        query       += "WHERE "
                  + "(`EMAIL` = '" +            ((Reservering) fromInstance).getsEmail() + "') AND "
                  + "(`EVENT_ID` = '" +         ((Reservering) fromInstance).getnAantalTickets() + "') AND "
                  + "(`AANTAL_TICKETS` = '" +   ((Reservering) fromInstance).getnEventID() + "');";




    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        String selectPrimaryKey = "EMAIL='" + ((Reservering) instance).getsEmail() + "' AND";
        selectPrimaryKey += " AANTAL_TICKETS='" + ((Reservering) instance).getnAantalTickets() + "' AND";
        selectPrimaryKey += " EVENT_ID='" + ((Reservering) instance).getnEventID() + "';";
        
        this.Delete(selectPrimaryKey);
    }
}