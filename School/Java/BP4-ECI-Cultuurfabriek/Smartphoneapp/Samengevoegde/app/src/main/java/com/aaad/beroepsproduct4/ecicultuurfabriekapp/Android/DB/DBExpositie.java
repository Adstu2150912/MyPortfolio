package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Expositie;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author akina
 */
public class DBExpositie extends DatabaseTable {
    private ArrayList<Expositie> dataset = new ArrayList<Expositie>();


    public DBExpositie(String sTableName, Context context, Activity activity)
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
                        Expositie expositie = new Expositie(jsonObject.getString("expositie"), jsonObject.getString("omschrijving"),jsonObject.getString("startdatum"),jsonObject.getString("starttijd"), jsonObject.getString("einddatum"));
                        dataset.add(expositie);
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
        this.select("expositie", "EQUALS", ((Expositie) instance).getExpositie());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBExpositie.insertDataIntoTable: Current Primary Key (Expositie '" + ((Expositie) instance).getExpositie() + "') already exists");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "_('expositie','omschrijving','startdatum','starttijd','einddatum')_VALUES_("
                + "'" + ((Expositie) instance).getExpositie() + "',"
                + "'" + ((Expositie) instance).getOmschrijving() + "',"
                + "'" + ((Expositie) instance).getStartdatum() + "',"
                + "'" + ((Expositie) instance).getStarttijd() + "',"
                + "'" + ((Expositie) instance).getEinddatum()  + "');";

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
        this.select("expositie", "EQUALS", ((Expositie) fromInstance).getExpositie());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBExpositie.updateDataIntoTable: Current Primary Key (Expositie '" + ((Expositie) fromInstance).getExpositie() + "') already exists");
            return;
        }

        String query = "UPDATE_" + sTableName + "_";
        query       +=
                "'expositie'EQUALS'"           + ((Expositie) toInstance).getExpositie() + "'," +
                        "'omschrijving'EQUALS'"             + ((Expositie) toInstance).getOmschrijving() + "'," +
                        "'startdatum'EQUALS'"             + ((Expositie) toInstance).getStartdatum() + "'," +
                        "'starttijd'EQUALS'"             + ((Expositie) toInstance).getStarttijd() + "'," +
                        "'einddatum'EQUALS'"                 + ((Expositie) toInstance).getEinddatum() + "'";

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
        if(instance instanceof Expositie)
            this.Delete("expositie", "EQUALS", ((Expositie) instance).getExpositie());
    }
}
