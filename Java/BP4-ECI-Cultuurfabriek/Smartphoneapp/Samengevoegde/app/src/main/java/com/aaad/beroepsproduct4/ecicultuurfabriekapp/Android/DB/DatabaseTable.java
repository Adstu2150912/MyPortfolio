/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;


/**
 *
 * @author swkoe
 */


public abstract class DatabaseTable
{
    protected String sTableName;
    protected DatabaseConnection database;
    protected boolean initialized = false;
    private Context mContext;

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Activity getmActivity() {
        return mActivity;
    }

    public void setmActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }

    private Activity mActivity;
    
    public abstract void fillDataFromResultSet(JSONArray data);
    public abstract void insertDataIntoTable(Object instance);
    public abstract void UpdateDataIntoTable(Object fromInstance, Object toInstance);
    public abstract void deleteSpecificData(Object instance);
    
    public void insertDataIntoTable(Object[] instances)
    {
        for(Object instance : instances)
        {
            insertDataIntoTable(instance);
        }
    }

    
    public void selectAll()
    {

    }

    public void select(String sCondition)
    {

    }
    public void select(String sField, String sOperator, String sValue)
    {

    }

    public void DeleteAll()
    {

        String statement = "DELETE_FROM_" + this.sTableName + ";";
        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?dml=delete&statement=" + statement);
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

    public void Delete(String sCondition)
    {
        String statement = "DELETE_FROM_" + this.sTableName + "_" + sCondition;
        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?dml=delete&statement=" + statement);
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("HTTP_ACCEPT", "application/json");
        database.setPostDataParams(postDataParams);
        database.setContentType(new AbstractMap.SimpleEntry<String, String>("connection", "close"));
        this.executeDelete();
    }

    public void Delete(String sField, String sOperator, String sValue)
    {
        String statement = "DELETE_FROM_" + this.sTableName + "_WHERE_" + sField + "_" + sOperator + "_" + sValue + ";";
        this.setDatabase(new DatabaseConnection(getmContext(), getmActivity()));
        database.setApiPath("http://172.104.237.208/Controller/RestController.php?dml=delete&statement=" + statement);
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("HTTP_ACCEPT", "application/json");
        database.setPostDataParams(postDataParams);
        database.setContentType(new AbstractMap.SimpleEntry<String, String>("connection", "close"));
        this.executeDelete();
    }


    private void executeDelete()
    {
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
 
    protected void setDatabase(DatabaseConnection setDatabase)
    {
        database = setDatabase;
    }
    
    public void close()
    {

    }
}
