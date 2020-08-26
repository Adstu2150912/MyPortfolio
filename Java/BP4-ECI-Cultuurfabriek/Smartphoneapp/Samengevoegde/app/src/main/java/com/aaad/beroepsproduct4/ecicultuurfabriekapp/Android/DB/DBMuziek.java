package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Event;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Muziek;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseHandlers;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class DBMuziek extends DatabaseTable {

    private ArrayList<Muziek> dataset = new ArrayList<Muziek>();


    public DBMuziek(String sTableName, Context context, Activity activity)
    {
        this.sTableName = sTableName;
        this.setmActivity(activity);
        this.setmContext(context);
    }

    @Override
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
                        Muziek geselecteerdeMuziek = new Muziek();
                        geselecteerdeMuziek.setEventid(jsonObject.getInt("eventid"));
                        geselecteerdeMuziek.setEvenementNaam(jsonObject.getString("evenementNaam"));
                        geselecteerdeMuziek.setArtiest(jsonObject.getString("artiest"));
                        geselecteerdeMuziek.setMuziekGenre(jsonObject.getString("muziekGenre"));
                        geselecteerdeMuziek.setZaal(jsonObject.getString("zaal"));
                        geselecteerdeMuziek.setBeschrijving(jsonObject.getString("beschrijving"));

                        dataset.add(geselecteerdeMuziek);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }

    public Muziek [] getResults() {

        Muziek [] DataArray = new Muziek[dataset.toArray().length];

        for(int i = 0; i < dataset.toArray().length; i++)
        {
            DataArray[i] = dataset.get(i);
        }
        return DataArray;
    }

    @Override
    public void select(String sField, String sOperator, String sValue)
    {
        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?view=single&table=" + sTableName + "&condition=" + sField + "_" + sOperator + "_" + sValue);
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
//        this.select("eventid", "EQUALS", ((Muziek)instance).getEventid().toString());
//        if(dataset.toArray().length >= 1)
//        {
//            StandardDebugActions.error("DBMuziek.insertDataIntoTable: Current Primary Key (EventID " + ((Muziek) instance).getEventid()+ ") already exists");
//            return;
//        }

//        DatabaseHandlers.dbevent.select("eventid=" + ((Muziek) instance).getEventid()+ "");
//        if(DatabaseHandlers.dbevent.getResults().length <= 0)
//        {
//            StandardDebugActions.error("DBMuziek.insertDataIntoTable: new foreign key 'FK_Muziek_Event' (EventID " + ((Muziek) instance).getEventid()+ ") does not exists");
//            return;
//        }

        this.select("_WHERE_eventid_EQUALS_" + ((Muziek)instance).getEventid() + "");
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBMuziek.insertDataIntoTable: Current Primary Key (EventID " + ((Muziek) instance).getEventid()+ ") already exists");
            return;
        }

        DatabaseHandlers.dbEvent.select("_WHERE_eventid_EQUALS_" + ((Muziek) instance).getEventid()+ "");
        if(DatabaseHandlers.dbEvent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBMuziek.insertDataIntoTable: new foreign key 'FK_Muziek_Event' (EventID " + ((Muziek) instance).getEventid()+ ") does not exists");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "_"
                + "("
                + "eventid,"
                + "evenementNaam,"
                + "artiest,"
                + "muziekGenre,"
                + "zaal,"
                + "beschrijving)_VALUES_(";

        query += ((Muziek) instance).getEventid()+ ",";
        query += "'" + ((Muziek) instance).getEvenementNaam()+ "',";
        query += "'" + ((Muziek) instance).getArtiest()+ "',";
        query += "'" + ((Muziek) instance).getMuziekGenre()+ "',";
        query += "'" + ((Muziek) instance).getZaal()+ "',";
        query += "'" + ((Muziek) instance).getBeschrijving()+ "'";
        query += ");";

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
//        this.select("eventid", "EQUALS", ((Muziek) fromInstance).getEventid().toString());
//        if(dataset.toArray().length <- 0)
//        {
//            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: Current instance Evenement is not in database; cannot update");
//            return;
//        }
//
//        if(dataset.toArray().length <= 0)
//        {
//            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: Current Primary Key (EventID " + ((Muziek) fromInstance).getEventid()+ ") already exists");
//            return;
//        }

//        DatabaseHandlers.dbevent.select("eventid=" + ((Muziek) toInstance).getEventid()+ "");
//        if(DatabaseHandlers.dbevent.getResults().length <= 0)
//        {
//            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: new foreign key 'FK_Muziek_Event' (EventId " + ((Muziek) toInstance).getEventid()+ ") does not exists");
//            return;
//        }

        this.select("_WHERE_eventid_EQUALS_" + ((Muziek) fromInstance).getEventid()+ "");
        if(dataset.toArray().length <- 0)
        {
            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: Current instance Evenement is not in database; cannot update");
            return;
        }

        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: Current Primary Key (EventID " + ((Muziek) fromInstance).getEventid()+ ") already exists");
            return;
        }

        DatabaseHandlers.dbEvent.select("_WHERE_eventid_EQUALS_" + ((Muziek) toInstance).getEventid()+ "");
        if(DatabaseHandlers.dbEvent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBMuziek.UpdateDataIntoTable: new foreign key 'FK_Muziek_Event' (EventId " + ((Muziek) toInstance).getEventid()+ ") does not exists");
            return;
        }

        String query = "UPDATE_" + sTableName + "_";
        query += "SET_evenementNaam_EQUALS_'" + ((Muziek)toInstance).getEvenementNaam()+ "'_";
        query += ",artiest_EQUALS_'" + ((Muziek)toInstance).getArtiest()+ "'";
        query += ",muziekGenre_EQUALS_'" + ((Muziek)toInstance).getMuziekGenre()+ "'";
        query += ",_zaal_EQUALS_'" + ((Muziek)toInstance).getZaal()+ "'";
        query += ",_beschrijving_EQUALS_'" + ((Muziek)toInstance).getBeschrijving()+ "'";
        query += "_WHERE_eventid_EQUALS_" + ((Muziek) fromInstance).getEventid()+ "_;";

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
        if(instance instanceof Muziek)
            this.Delete("eventid", "EQUALS", ((Muziek) instance).getEventid().toString());
        else if(instance instanceof Event)
        {
            DatabaseHandlers.dbEvent.select("_WHERE_eventid_EQUALS_" + ((Event) instance).getEventid()+ "");
            if(DatabaseHandlers.dbEvent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBTheater.deleteSpecificData: foreign key 'Muziek_Event_FK' (eventid " + ((Event) instance).getEventid()+ ") does not exists");
                return;
            }
            this.Delete("_WHERE_eventid_EQUALS_" + ((Event) instance).getEventid());
        }

    }
}
