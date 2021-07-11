package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Klantinlog;
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
 * @author Thobi
 */
public class DBKlantInlog extends DatabaseTable{
    private ArrayList<Klantinlog> dataset = new ArrayList<Klantinlog>();


    public DBKlantInlog(String sTableName, Context context, Activity activity)
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
                        Klantinlog klantinlog = new Klantinlog
                                (
                                        jsonObject.getString("Email"),
                                        jsonObject.getString("Inlognaam"),
                                        jsonObject.getString("Wachtwoord")
                                );
                        dataset.add(klantinlog);
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

    public Klantinlog[] getResults()
    {
        Klantinlog[] DataArray = new Klantinlog[dataset.toArray().length];
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
        this.select("Email", "EQUALS", ((Klantinlog) instance).getsEML());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBKlantInlog.insertDataIntoTable: Current Primary Key (Email '" + ((Klantinlog) instance).getsEML()+ "') already exists");
            return;
        }

//        DatabaseHandlers.dbKlantInlog.select("Email='" + ((Klantinlog) instance).getsEML() + "'");
//        if(DatabaseHandlers.dbKlantInlog.getResults().length <= 0)
//        {
//            StandardDebugActions.error("foreign key does not exist");
//            return;
//        }

        DatabaseHandlers.dbEmail.select("_WHERE_EML_EQUALS_'" + ((Klantinlog) instance).getsEML()+ "'");
        if(DatabaseHandlers.dbEmail.getResults().length <= 0)
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "_"
                + "("
                + "Email,"
                + "Inlognaam,"
                + "Wachtwoord,"

                + ")_VALUES_(";

        query += "'" + ((Klantinlog) instance).getsEML() + "',";
        query += "'" + ((Klantinlog) instance).getsInlognaam() + "',";
        query += "'" + ((Klantinlog) instance).getsWachtwoord() + "',";

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
//        this.select("EMAIL", "EQUALS", ((Klantinlog) fromInstance).getsEML());
//        if(dataset.toArray().length >= 1)
//        {
//            StandardDebugActions.error("DBKlantInlog.updateDataIntoTable: Current Primary Key (EMAIL '" + ((Klantinlog) fromInstance).getsEML()+ "') already exists");
//            return;
//        }

        /*DatabaseHandlers.dbparkeren.select("Email='" + ((Klantinlog) toInstance).getsEML() + "'");
        if(DatabaseHandlers.dbparkeren.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }*/


        this.select("_WHERE_Email_EQUALS_'" + ((Klantinlog) fromInstance).getsEML() + "'");
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBKlantInlog.updateDataIntoTable: Primary Key already exist");
            return;
        }

        DatabaseHandlers.dbEmail.select("_WHERE_EML_EQUALS_'" + ((Klantinlog) toInstance).getsEML()+ "'");
        if(DatabaseHandlers.dbEmail.getResults().length <= 0)
        {
            StandardDebugActions.error("DBKlantInlog.updateDataIntoTable: new foreign key does not exist");
            return;
        }

        String query = "UPDATE_" + sTableName + "_";
        query       +=
                "SET_'Email'EQUALS'"          + ((Klantinlog) toInstance).getsEML() + "'," +
                        "'Inlognaam'EQUALS'"      + ((Klantinlog) toInstance).getsInlognaam() + "'," +
                        "'Wachtwoord'EQUALS'"         + ((Klantinlog) toInstance).getsWachtwoord() + "',";


        query       += "_WHERE_('Email'EQUALS'" + ((Klantinlog) fromInstance).getsEML() + "');";

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
        if(instance instanceof Klantinlog)
            this.Delete("Email", "EQUALS", ((Klantinlog) instance).getsEML());
    }
}
