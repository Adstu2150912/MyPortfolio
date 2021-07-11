package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Gebruiker;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Reservering;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;


/**
 *
 * @author swkoe
 */
public class DBReservering extends DatabaseTable
{
    private ArrayList<Reservering> dataset = new ArrayList<Reservering>();


    public DBReservering(String sTableName, Context context, Activity activity)
    {
        this.sTableName = sTableName;
        this.setmActivity(activity);
        this.setmContext(context);
    }

    public void fillDataFromResultSet(JSONArray data)
    {
        try
        {
            dataset.clear();
            if (data != null) {
                for (int i = 0; i < data.length(); i++) {
                    try
                    {
                        JSONObject jsonObject = data.getJSONObject(i);
                        Reservering reservering = new Reservering
                                (
                                        jsonObject.getString  ("EMAIL"),
                                        jsonObject.getInt     ("AANTALTICKETS"),
                                        jsonObject.getInt     ("EVENTID")
                                );
                        dataset.add(reservering);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
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
    public void select(String sCondition)
    {
        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?view=single&table=" + sTableName + "&condition=" + sCondition);
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("HTTP_ACCEPT", "application/json");
        database.setPostDataParams(postDataParams);
        database.setContentType(new AbstractMap.SimpleEntry<String, String>("connection", "close"));
        JSONArray data = null;
        try {
            database.execute();
            database.get();
            try{
                data = new JSONArray(database.getApiResponse());
                fillDataFromResultSet(data);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
                dataset.clear();
            }
            finally {
                database.cancel(true);
            }
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?view=all&table=" + sTableName);
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("HTTP_ACCEPT", "application/json");
        database.setPostDataParams(postDataParams);
        database.setContentType(new AbstractMap.SimpleEntry<String, String>("connection", "close"));
        JSONArray data = null;
        try {
            database.execute();
            database.get();
            try {
                data = new JSONArray(database.getApiResponse());
                fillDataFromResultSet(data);
            } catch (JSONException e) {
                e.printStackTrace();
                dataset.clear();
            } finally {
                database.cancel(true);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertDataIntoTable(Object instance)
    {
//        selectReservering("EVENT_ID_EQUALS_" + ((Reservering) instance).getnEventID());
//        if(dataset.toArray().length >= 1)
//        {
//            StandardDebugActions.error("Primary Key already exist");
//            return;
//        }

//        DatabaseHandlers.dbEmail.select("EML", "EQUALS","'" + ((Reservering) instance).getsEmail() + "'");
//        if(DatabaseHandlers.dbEmail.getResults().length <= 0)
//        {
//            StandardDebugActions.error("foreign key does not exist");
//            return;
//        }

        String selectPrimaryKey = "_WHERE_EMAIL_EQUALS_'" + ((Reservering) instance).getsEmail() + "'_AND_";
        selectPrimaryKey += "AANTALTICKETS_EQUALS_'" + ((Reservering) instance).getnAantalTickets() + "'_AND_";
        selectPrimaryKey += "EVENTID_EQUALS_'" + ((Reservering) instance).getnEventID() + "';";

        select(selectPrimaryKey);
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
//        this.select("EVENT_ID", "EQUALS", Integer.toString(((Reservering) instance).getnEventID()));

//        ArrayList<String> foreignCheck = new ArrayList<String>();
//        try
//        {
//            for(Object o : getResults())
//            {
//                foreignCheck.add(Integer.toString(((Reservering) o).getnEventID()));
//            }
//        } catch (Exception e)
//        {
//            StandardDebugActions.error(e);
//        }
//
//        if(foreignCheck.toArray().length <= 0)
//        {
//            StandardDebugActions.error("new foreign key does not exist");
//            return;
//        }

        DatabaseHandlers.dbEmail.select("EML", "EQUALS", ((Reservering) instance).getsEmail() + "'");
        if(DatabaseHandlers.dbEmail.getResults().length <= 0)
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }

        DatabaseHandlers.dbEvent.select("eventid", "EQUALS", Integer.toString(((Reservering) instance).getnEventID()));
        if(DatabaseHandlers.dbEvent.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }

//        INSERT INTO `beroepsProduct4`.`RESERVERINGEN` (`EMAIL`, `AANTAL_TICKETS`, `EVENT_ID`) VALUES ('test1', '15', '2');
        String query = "INSERT_INTO_"+ sTableName +"_('EMAIL','AANTALTICKETS','EVENTID')_VALUES_("
                + "'" + ((Reservering) instance).getsEmail() + "',"
                + "'" + ((Reservering) instance).getnAantalTickets() + "',"
                + "'" + ((Reservering) instance).getnEventID()  + "');";

        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?dml=insert&statement=" + query);
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("HTTP_ACCEPT", "application/json");
        database.setPostDataParams(postDataParams);
        database.setContentType(new AbstractMap.SimpleEntry<String, String>("connection", "close"));
        try {
            database.execute();
            database.get();
            try {
                JSONObject jsonObject = new JSONObject(database.getApiResponse());
                int dbSucces = jsonObject.getInt("success"); //0 = mislukte poging uitvoering van DML-statement; 1 = geslaagde poging uitvoering van DML-statement;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            finally {
                database.cancel(true);
            }
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        String selectPrimaryKey = "_WHERE_EMAIL_EQUALS_'" + ((Reservering) fromInstance).getsEmail() + "'_AND_";
        selectPrimaryKey += "AANTALTICKETS_EQUALS_'" + ((Reservering) fromInstance).getnAantalTickets() + "'_AND_";
        selectPrimaryKey += "EVENTID_EQUALS_'" + ((Reservering) fromInstance).getnEventID() + "';";

        this.select(selectPrimaryKey);
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key not exist exist");
            return;
        }

        DatabaseHandlers.dbEmail.select("EML", "EQUALS", ((Gebruiker) toInstance).getsEmail() + "'");
        if(DatabaseHandlers.dbEmail.getResults().length <= 0)
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }

        DatabaseHandlers.dbEvent.select("eventid", "EQUALS", Integer.toString(((Reservering) toInstance).getnEventID()));
        if(DatabaseHandlers.dbEvent.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }
//        database.connect();
//        database.readQuery("SELECT * FROM `EVENT_ID_TEST` WHERE (`EVENT_ID` = '" + ((Reservering) fromInstance).getnEventID() +"');");

//        ArrayList<String> foreignCheck = new ArrayList<String>();
//        try
//        {
//            for(Object o : getResults())
//            {
//                foreignCheck.add(Integer.toString(((Reservering) o).getnEventID()));
//            }
//        } catch (Exception e)
//        {
//            StandardDebugActions.error(e);
//        }
//
//        //DatabaseHandlers.dbEmail.select("EML", "EQUALS", ((Gebruiker) instance).getsEmail() + "'");
//        if(foreignCheck.toArray().length <= 0)
//        {
//            StandardDebugActions.error("new foreign key does not exist");
//            return;
//        }

//      UPDATE `beroepsProduct4`.`RESERVERINGEN` SET `AANTAL_TICKETS` = '5', `EVENT_ID` = '2' WHERE (`EMAIL` = 'test3') and (`EVENT_ID` = '5') and (`AANTAL_TICKETS` = '2');


        String query = "UPDATE_" + sTableName + "_";
        query       +=
                "SET_'EMAIL'_EQUALS_'"                   + ((Reservering) toInstance).getsEmail() + "'," +
                        "_'AANTALTICKETS'_EQUALS_'"               + ((Reservering) toInstance).getnAantalTickets() + "'," +
                        "'EVENTID'_EQUALS_'"                     + ((Reservering) toInstance).getnEventID()+ "'";

        query       += "_WHERE_"
                + "('EMAIL'_EQUALS_'" +            ((Reservering) fromInstance).getsEmail() + "')_AND_"
                + "('EVENTID'_EQUALS_'" +         ((Reservering) fromInstance).getnAantalTickets() + "')_AND_"
                + "('AANTALTICKETS'_EQUALS_'" +   ((Reservering) fromInstance).getnEventID() + "');";

        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?dml=update&statement=" + query);
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("HTTP_ACCEPT", "application/json");
        database.setPostDataParams(postDataParams);
        database.setContentType(new AbstractMap.SimpleEntry<String, String>("connection", "close"));
        try {
            database.execute();
            database.get();
            try {
                JSONObject jsonObject = new JSONObject(database.getApiResponse());
                int dbSucces = jsonObject.getInt("success"); //0 = mislukte poging uitvoering van DML-statement; 1 = geslaagde poging uitvoering van DML-statement;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            finally {
                database.cancel(true);
            }
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSpecificData(Object instance)
    {
        String selectPrimaryKey = "_WHERE_EMAIL_EQUALS_'" + ((Reservering) instance).getsEmail() + "'_AND_";
        selectPrimaryKey += "AANTALTICKETS_EQUALS_'" + ((Reservering) instance).getnAantalTickets() + "'_AND_";
        selectPrimaryKey += "EVENTID_EQUALS_'" + ((Reservering) instance).getnEventID() + "';";
        if(instance instanceof Reservering)
            this.Delete(selectPrimaryKey);
    }
}
