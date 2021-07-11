package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

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
 * @author swkoe
 */
public class DBEmail extends DatabaseTable
{
    private ArrayList<String> dataset = new ArrayList<String>();

    public DBEmail(String sTableName, Context context, Activity activity)
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
                        this.dataset.add(jsonObject.getString("EML"));
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

    public String[] getResults()
    {
        String[] DataArray = new String[dataset.toArray().length];
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
        this.select("EML", "EQUALS", ((String) instance));
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBEmail.insertDataIntoTable: Current Primary Key (EML '" + ((String) instance) + "') already exists");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "(EML)_VALUES_('";
        query += ((String) instance);
        query += "');";

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
        this.select("EML", "EQUALS", ((String) fromInstance));
        if(dataset.toArray().length <- 0)
        {
            StandardDebugActions.error("DBEmail.UpdateDataIntoTable: Instance not in database cannot update");
            return;
        }

        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBEmail.UpdateDataIntoTable: Current Primary Key (EML '" + ((String) fromInstance) + "') already exists");
            return;
        }

        String query = "UPDATE_" + sTableName + "_";
        query       += "SET_EML_EQUALS_" + ((String)toInstance) + "_";
        query       += "WHERE_EML_EQUALS_" + ((String) fromInstance) + "_;";

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
        if(instance instanceof String)
            this.Delete("EML", "EQUALS", ((String) instance));
    }
}