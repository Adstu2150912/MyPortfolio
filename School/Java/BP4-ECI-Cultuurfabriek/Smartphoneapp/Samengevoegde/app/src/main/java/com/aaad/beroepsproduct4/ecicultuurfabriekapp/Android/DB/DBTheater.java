package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Event;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Theater;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseHandlers;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;
import com.mysql.cj.xdevapi.JsonNumber;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class DBTheater extends DatabaseTable {

    private ArrayList<Theater> dataset = new ArrayList<Theater>();

    public DBTheater(String sTableName, Context context, Activity activity)
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
                        Theater geselecteerdeTheater = new Theater();
                        geselecteerdeTheater.setEventid(jsonObject.getInt("eventid"));
                        geselecteerdeTheater.setTheaterNaam(jsonObject.getString("theaterNaam"));
                        geselecteerdeTheater.setRegisseur(jsonObject.getString("regisseur"));
                        geselecteerdeTheater.setTheaterGenre(jsonObject.getString("theaterGenre"));
                        geselecteerdeTheater.setDuur(jsonObject.getString("duur"));
                        geselecteerdeTheater.setBeschrijving(jsonObject.getString("beschrijving"));

                        dataset.add(geselecteerdeTheater);
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


    public Theater [] getResults() {

        Theater [] DataArray = new Theater[dataset.toArray().length];

        for(int i = 0; i < dataset.toArray().length; i++)
        {
            DataArray[i] = dataset.get(i);
        }
        return DataArray;
    }

    @Override
    public void insertDataIntoTable(Object instance)
    {
        this.select("eventid", "EQUALS", ((Theater)instance).getEventid().toString());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBTheater.insertDataIntoTable: Current Primary Key (EventID " + ((Theater) instance).getEventid()+ ") already exists");
            return;
        }

        DatabaseHandlers.dbEvent.select("eventid", "EQUALS", ((Theater) instance).getEventid()+ "");
        if(DatabaseHandlers.dbEvent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBTheater.insertDataIntoTable: new foreign key 'FK_Theater_Event' (EventID " + ((Theater) instance).getEventid()+ ") does not exists");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "_"
                + "("
                + "eventid,"
                + "theaterNaam,"
                + "regisseur,"
                + "theaterGenre,"
                + "duur,"
                + "beschrijving)_VALUES_(";

        query += ((Theater) instance).getEventid() + ",";
        query += "'" + ((Theater) instance).getTheaterNaam()+ "',";
        query += "'" + ((Theater) instance).getRegisseur()+ "',";
        query += "'" + ((Theater) instance).getTheaterGenre()+ "',";
        query += "'" + ((Theater) instance).getDuur()+ "',";
        query += "'" + ((Theater) instance).getBeschrijving()+ "'";
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
        this.select("eventid", "EQUALS", ((Theater) fromInstance).getEventid().toString());
        if(dataset.toArray().length <- 0)
        {
            StandardDebugActions.error("DBTheater.UpdateDataIntoTable: Current instance Theatervoorstelling is not in database; cannot update");
            return;
        }

        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBTheater.UpdateDataIntoTable: Current Primary Key (EventID " + ((Theater) fromInstance).getEventid()+ ") already exists");
            return;
        }

        DatabaseHandlers.dbEvent.select("eventid", "EQUALS", + ((Theater) toInstance).getEventid()+ "");
        if(DatabaseHandlers.dbEvent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBTheater.UpdateDataIntoTable: new foreign key 'FK_Theater_Event' (EventId " + ((Theater) toInstance).getEventid()+ ") does not exists");
            return;
        }

        String query = "UPDATE_" + sTableName + "_";
        query += "SET_theaterNaam_EQUALS_'" + ((Theater)toInstance).getTheaterNaam()+ "'";
        query += ",regisseur_EQUALS_'" + ((Theater)toInstance).getRegisseur()+ "'";
        query += ",TheaterGenre_EQUALS_'" + ((Theater)toInstance).getTheaterGenre()+ "'";
        query += ",duur_EQUALS_'" + ((Theater)toInstance).getDuur()+ "'";
        query += ",beschrijving_EQUALS_'" + ((Theater)toInstance).getBeschrijving()+ "'";
        query += "_WHERE_eventid_EQUALS_" + ((Theater) fromInstance).getEventid()+ ";";

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
        if(instance instanceof Theater)
            this.Delete("eventid", "EQUALS", ((Theater) instance).getEventid().toString());
        else if(instance instanceof Event)
        {
            DatabaseHandlers.dbEvent.select("eventid","EQUALS", ((Event) instance).getEventid()+ "");
            if(DatabaseHandlers.dbEvent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBTheater.deleteSpecificData: foreign key 'Theater_Event_FK' (eventid " + ((Event) instance).getEventid()+ ") does not exists");
                return;
            }
            this.Delete("_WHERE_eventid_EQUALS_" + ((Event) instance).getEventid());
        }
    }
}

