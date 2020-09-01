/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Cursus;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Docent;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 11-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBDocent.java
 */
public class DBDocent extends DatabaseTable 
{
    private ArrayList<Docent> dataset = new ArrayList<Docent>();
    
    public DBDocent(String sTableName, Context context, Activity activity)
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
                    try {
                        JSONObject jsonObject = data.getJSONObject(i);
                        Docent selectedDocent = new Docent();
                        selectedDocent.setDocentID(jsonObject.getInt("docentID"));
                        selectedDocent.setDocentNaam(jsonObject.getString("docNaam"));
                        selectedDocent.setBeschrijving(jsonObject.getString("beschrijving"));
                        selectedDocent.setDiscipline(jsonObject.getString("discipline"));
                        dataset.add(selectedDocent);
                    } catch (JSONException e) {
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
    
    public Docent[] getResults()
    {
        Docent[] DataArray = new Docent[dataset.toArray().length];
        for(int i = 0; i < dataset.toArray().length; i++)
        {
            DataArray[i] = dataset.get(i);
        }
        return DataArray;
    }
    
    @Override
    public void insertDataIntoTable(Object instance)
    {
        this.select("docentID", "EQUALS", ((Docent) instance).getDocentID().toString());
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("DBDocent.insertDataIntoTable: Primary Key (DocentID " + ((Docent) instance).getDocentID() + ") already exists");
            return;
        }     
        
        String query = "INSERT_INTO_" + sTableName + " "
                  + "("
                    + "docentID,"
                    + "docNaam,"
                    + "beschrijving,"
                    + "discipline"
                  + ")_VALUES_(";
        
        query += ((Docent) instance).getDocentID()           + ",";
        query += "'" + ((Docent) instance).getDocentNaam()        + "',";
        query += "'" + ((Docent) instance).getBeschrijving()      + "',";
        query += "'" + ((Docent) instance).getDiscipline()      + "'";
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
        this.select("docentID", "EQUALS", ((Docent) fromInstance).getDocentID().toString());
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("DBDocent.UpdateDataIntoTable: Current instance Docent not in database; cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBDocent.UpdateDataIntoTable: Current Primary Key (DocentID " + ((Docent) fromInstance).getDocentID() + ") already exists");
            return;
        }      
        
        String query = "UPDATE_" + sTableName + "_";
        query += "SET_docNaam_EQUALS_'" + ((Docent)toInstance).getDocentNaam() + "'";
        query += ",beschrijving_EQUALS_'" + ((Docent)toInstance).getBeschrijving() + "'";
        query += ",discipline_EQUALS_'" + ((Docent)toInstance).getDiscipline() + "'";
        query += "_WHERE_docentID_EQUALS_" + ((Docent) fromInstance).getDocentID() + ";";

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
        if(instance instanceof Docent)
            this.Delete("docentID", "EQUALS", ((Docent) instance).getDocentID().toString());
        else if(instance instanceof Cursus)
            this.Delete("docentID", "EQUALS", ((Cursus) instance).getDocentID().toString());
    }
}
