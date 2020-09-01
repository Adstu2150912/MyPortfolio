package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Event;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Film;
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

public class DBFilm extends DatabaseTable {

    private ArrayList<Film> dataset = new ArrayList<Film>();


    public DBFilm (String sTableName, Context context, Activity activity)
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
                        Film geselecteerdeFilm = new Film();
                        geselecteerdeFilm.setEventid(jsonObject.getInt("eventid"));
                        geselecteerdeFilm.setFilmNaam(jsonObject.getString("filmNaam"));
                        geselecteerdeFilm.setLand(jsonObject.getString("land"));
                        geselecteerdeFilm.setRegisseur(jsonObject.getString("regisseur"));
                        geselecteerdeFilm.setFilmGenre(jsonObject.getString("filmGenre"));
                        geselecteerdeFilm.setDuur(jsonObject.getString("duur"));
                        geselecteerdeFilm.setBeschrijving(jsonObject.getString("beschrijving"));
                        dataset.add(geselecteerdeFilm);
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

    public Film [] getResults() {

        Film [] DataArray = new Film[dataset.toArray().length];

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
    public void selectAll()
    {
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
    public void insertDataIntoTable(Object instance)
    {
        this.select("eventid", "EQUALS", ((Film)instance).getEventid().toString());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBFilm.insertDataIntoTable: Current Primary Key (EventID " + ((Film) instance).getEventid()+ ") already exists");
            return;
        }
        String query = "INSERT_INTO_" + sTableName + "_"
                + "("
                + "eventid,"
                + "filmNaam,"
                + "land,"
                + "regisseur,"
                + "filmGenre,"
                + "duur,"
                + "beschrijving)_VALUES_(";

        query += ((Film) instance).getEventid()+ ",";
        query += "'" + ((Film) instance).getFilmNaam()+ "',";
        query += "'" + ((Film) instance).getLand()+ "',";
        query += "'" + ((Film) instance).getRegisseur()+ "',";
        query += "'" + ((Film) instance).getFilmGenre()+ "',";
        query += "'" + ((Film) instance).getDuur()+ "',";
        query += "'" + ((Film) instance).getBeschrijving()+ "'";
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
        this.select("eventid", "EQUALS", ((Film) fromInstance).getEventid().toString());
        if(dataset.toArray().length <- 0)
        {
            StandardDebugActions.error("DBFilm.UpdateDataIntoTable: Current instance Film not in database; cannot update");
            return;
        }

        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBFilm.UpdateDataIntoTable: Current Primary Key (EventID " + ((Film) fromInstance).getEventid()+ ") already exists");
            return;
        }

        String query = "UPDATE_" + sTableName + "_";
        query += "SET_filmNaam_EQUALS_'" + ((Film)toInstance).getFilmNaam()+ "'";
        query += ",_land_EQUALS_'" + ((Film)toInstance).getLand()+ "'";
        query += ",_regisseur_EQUALS_'" + ((Film)toInstance).getRegisseur()+ "'";
        query += ",_filmGenre_EQUALS_'" + ((Film)toInstance).getFilmGenre()+ "'";
        query += ",_duur_EQUALS_'" + ((Film)toInstance).getDuur()+ "'";
        query += ",_beschrijving_EQUALS_'" + ((Film)toInstance).getBeschrijving()+ "'";
        query += "_WHERE_eventid_EQUALS_" + ((Film) fromInstance).getEventid()+ ";";

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
        if(instance instanceof Film)
            this.Delete("eventid", "EQUALS", ((Film) instance).getEventid().toString());
        else if(instance instanceof Event)
        {
            DatabaseHandlers.dbEvent.select("eventid", "EQUALS", Integer.toString(((Event) instance).getEventid()));
            if(DatabaseHandlers.dbEvent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBFilm.deleteSpecificData: foreign key 'Film_Event_FK' (eventid " + ((Event) instance).getEventid()+ ") does not exists");
                return;
            }
            this.Delete("eventid", "EQUALS", Integer.toString(((Event) instance).getEventid()));
        }
    }


}

