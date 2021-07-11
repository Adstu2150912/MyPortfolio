/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Cursus;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Cursuscategorie;
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
 * Bestandsnaam: DBCursusCategorie.java
 */
public class DBCursusCategorie extends DatabaseTable
{
    private ArrayList<Cursuscategorie> dataset = new ArrayList<Cursuscategorie>();
    
    public DBCursusCategorie(String sTableName, Context context, Activity activity)
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
                        Cursuscategorie selectedCategorie = new Cursuscategorie();
                        selectedCategorie.setCategorieID(jsonObject.getInt("categorieID"));
                        selectedCategorie.setCategorieNaam(jsonObject.getString("categorieNaam"));
                        selectedCategorie.setOmschrijving(jsonObject.getString("omschrijving"));
                        selectedCategorie.setSubCategorie(jsonObject.getString("subCategorie"));
                        dataset.add(selectedCategorie);
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
    
    public Cursuscategorie[] getResults()
    {
        Cursuscategorie[] DataArray = new Cursuscategorie[dataset.toArray().length];
        for(int i = 0; i < dataset.toArray().length; i++)
        {
            DataArray[i] = dataset.get(i);
        }
        return DataArray;
    }
    
    @Override
    public void insertDataIntoTable(Object instance)
    {
        this.select("categorieID", "EQUALS", ((Cursuscategorie) instance).getCategorieID().toString());
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("DBCursusCategorie.insertDataIntoTable: Current Primary Key (CategorieID " + ((Cursuscategorie) instance).getCategorieID() + ") already exists");
            return;
        }
        
        String query = "INSERT_INTO_" + sTableName + "_"
                  + "("
                    + "categorieID,"
                    + "subCategorie,"
                    + "categorieNaam,"
                    + "omschrijving"
                  + ")_VALUES_(";
        
        query +=  ((Cursuscategorie) instance).getCategorieID() + ",";
        query += "'" + ((Cursuscategorie) instance).getSubCategorie() + "',";
        query += "'" + ((Cursuscategorie) instance).getCategorieNaam() + "',";
        query += "'" + ((Cursuscategorie) instance).getOmschrijving() + "'";
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
        this.select("categorieID", "EQUALS", ((Cursuscategorie) fromInstance).getCategorieID().toString());
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("DBCursusCategorie.UpdateDataIntoTable: Instance not in database cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBCursusCategorie.UpdateDataIntoTable: Current Primary Key (CategorieID " + ((Cursuscategorie) fromInstance).getCategorieID() + ") already exists");
            return;
        }    
        
        String query = "UPDATE_" + sTableName + "_";
        query += "SET_subCategorie_EQUALS_'" + ((Cursuscategorie)toInstance).getSubCategorie() + "'";
        query += ",categorieNaam_EQUALS_'" + ((Cursuscategorie)toInstance).getCategorieNaam() + "'";
        query += ",omschrijving_EQUALS_'" + ((Cursuscategorie)toInstance).getOmschrijving() + "'";
        query += "_WHERE_categorieID_EQUALS_" + ((Cursuscategorie) fromInstance).getCategorieID() + ";";

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
        if(instance instanceof Cursuscategorie)            
            this.Delete("categorieID", "EQUALS", ((Cursuscategorie) instance).getCategorieID().toString());
        else if(instance instanceof Cursus)
            this.Delete("categorieID", "EQUALS", ((Cursus) instance).getCategorieID().toString());
    }
}
