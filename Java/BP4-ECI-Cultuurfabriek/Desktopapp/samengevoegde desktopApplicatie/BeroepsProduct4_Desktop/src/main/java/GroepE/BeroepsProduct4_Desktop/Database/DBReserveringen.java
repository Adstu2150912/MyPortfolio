/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Reservering;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author swkoe
 */
public class DBReserveringen extends DatabaseTable
{
    private ArrayList<Reservering> dataset = new ArrayList<Reservering>();
    
    
    public DBReserveringen(DatabaseConnection toConnect, String sTableName)
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
                    data.getInt     ("AANTALTICKETS"),
                    data.getInt     ("EVENTID")
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
        selectPrimaryKey += " AANTALTICKETS='" + ((Reservering) instance).getnAantalTickets() + "' AND";
        selectPrimaryKey += " EVENTID='" + ((Reservering) instance).getnEventID() + "';";

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
        
        DatabaseHandlers.dbevent.select("eventid =" + ((Reservering) instance).getnEventID()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }

//        INSERT INTO `beroepsProduct4`.`RESERVERINGEN` (`EMAIL`, `AANTAL_TICKETS`, `EVENT_ID`) VALUES ('test1', '15', '2');
        String query = "INSERT INTO "+ sTableName +" (`EMAIL`, `AANTALTICKETS`, `EVENTID`) VALUES ("
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
        selectPrimaryKey += " AANTALTICKETS='" + ((Reservering) fromInstance).getnAantalTickets() + "' AND";
        selectPrimaryKey += " EVENTID='" + ((Reservering) fromInstance).getnEventID() + "';";

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
        
        DatabaseHandlers.dbevent.select("eventid =" + ((Reservering) toInstance).getnEventID()+ "");
        if(DatabaseHandlers.dbevent.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }

//      UPDATE `beroepsProduct4`.`RESERVERINGEN` SET `AANTAL_TICKETS` = '5', `EVENT_ID` = '2' WHERE (`EMAIL` = 'test3') and (`EVENT_ID` = '5') and (`AANTAL_TICKETS` = '2');
        

        String query = "UPDATE " + sTableName + " ";
        query       +=
                "SET `EMAIL` = '"                   + ((Reservering) toInstance).getsEmail() + "', " +
                "`AANTALTICKETS`= '"               + ((Reservering) toInstance).getnAantalTickets() + "', " +
                "`EVENTID`= '"                     + ((Reservering) toInstance).getnEventID()+ "' ";

        query       += "WHERE "
                  + "(`EMAIL` = '" +            ((Reservering) fromInstance).getsEmail() + "') AND "
                  + "(`EVENTID` = '" +         ((Reservering) fromInstance).getnAantalTickets() + "') AND "
                  + "(`AANTALTICKETS` = '" +   ((Reservering) fromInstance).getnEventID() + "');";




    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        String selectPrimaryKey = "EMAIL='" + ((Reservering) instance).getsEmail() + "' AND";
        selectPrimaryKey += " AANTALTICKETS='" + ((Reservering) instance).getnAantalTickets() + "' AND";
        selectPrimaryKey += " EVENTID='" + ((Reservering) instance).getnEventID() + "';";
        
        this.Delete(selectPrimaryKey);
    }
}