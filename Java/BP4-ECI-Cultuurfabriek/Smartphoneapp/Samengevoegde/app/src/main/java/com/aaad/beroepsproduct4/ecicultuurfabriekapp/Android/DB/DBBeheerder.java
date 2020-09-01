package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Beheerder;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class DBBeheerder extends DatabaseTable {
    private ArrayList<Beheerder> dataset = new ArrayList<Beheerder>();


    public DBBeheerder(String sTableName, Context context, Activity activity)
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
                        Beheerder beheerder = new Beheerder();
                        beheerder.setBeheerder(jsonObject.getString("beheerder"));
                        beheerder.setGebruikersnaam(jsonObject.getString("gebruikersnaam"));
                        beheerder.setWachtwoord(jsonObject.getString("wachtwoord"));
                        dataset.add(beheerder);
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
        this.select("'beheerder'", "EQUALS", ((Beheerder) instance).getBeheerder());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBBeheerder.insertDataIntoTable: Current Primary Key (Beheerder '" + ((Beheerder) instance).getBeheerder() + "') already exists");
            return;
        }
        String query = "INSERT_INTO_" + sTableName + "_('beheerder','gebruikersnaam','wachtwoord')_VALUES_("
                + "'" + ((Beheerder) instance).getBeheerder() + "',"
                + "'" + ((Beheerder) instance).getGebruikersnaam() + "',"
                + "'" + ((Beheerder) instance).getWachtwoord()  + "' );";

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
        this.select("'beheerder'", "EQUALS", ((Beheerder) fromInstance).getBeheerder());
        if(dataset.toArray().length <- 0)
        {
            StandardDebugActions.error("DBBeheerder.UpdateDataIntoTable: Instance not in database cannot update");
            return;
        }

        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBBeheerder.UpdateDataIntoTable: Current Primary Key (Beheerder '" + ((Beheerder) fromInstance).getBeheerder() + "') already exists");
            return;
        }
        String query = "UPDATE_" + sTableName + "_";
        query       +=
                "'beheerder'_EQUALS_'"           + ((Beheerder) toInstance).getBeheerder() + "'," +
                        "'gebruikersnaam'_EQUALS_'"             + ((Beheerder) toInstance).getGebruikersnaam() + "'," +
                        "'wachtwoord'_EQUALS_'"                 + ((Beheerder) toInstance).getWachtwoord() + "'";

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
        if(instance instanceof Beheerder)
            this.Delete("beheerder", "EQUALS", ((Beheerder) instance).getBeheerder());
    }
}
