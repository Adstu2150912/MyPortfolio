package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Parkeren;
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
public class DBParkeren extends DatabaseTable{
    private ArrayList<Parkeren> dataset = new ArrayList<Parkeren>();


    public DBParkeren(String sTableName, Context context, Activity activity)
    {
        this.sTableName = sTableName;
        this.setmActivity(activity);
        this.setmContext(context);
    }

    public void fillDataFromResultSet(JSONArray data)
    {
//        try
//        {
//            dataset.clear();
//            if (data != null) {
//                for (int i = 0; i < data.length(); i++) {
//                    try
//                    {
//                        JSONObject jsonObject = data.getJSONObject(i);
//                        Parkeren parkeren = new Parkeren
//                                (
//                                        jsonObject.getString("Email"),
//                                        jsonObject.getDate("Datum"),
//                                        jsonObject.getString("Parkkeerplek"),
//                                        jsonObject.getString("Opmerking")
//                                );
//                        dataset.add(parkeren);
//                    }
//                    catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } catch (Exception e)
//        {
//            StandardDebugActions.error(e);
//        }
    }

    public Parkeren[] getResults()
    {
        Parkeren[] DataArray = new Parkeren[dataset.toArray().length];
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
        this.select("Email", "EQUALS", "'" + ((Parkeren) instance).getsEML() + "'");
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }

        DatabaseHandlers.dbParkeren.select("Email","EQUALS","'" + ((Parkeren) instance).getsEML() + "'");
        if(DatabaseHandlers.dbParkeren.getResults().length <= 0)
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "_('Email','Datum','Parkkeerplek','Opmerking')_VALUES_("
                + "'" + ((Parkeren) instance).getsEML() + "',"
                + "'" + ((Parkeren) instance).getsDate() + "',"
                + "'" + ((Parkeren) instance).getsParkeerplek() + "',"
                + "'" + ((Parkeren) instance).getsOpmerking() + "');";


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
        this.select("Email", "EQUALS", "'" + ((Parkeren) fromInstance).getsEML() + "'");
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }

        DatabaseHandlers.dbParkeren.select("Email", "EQUALS", "'" + ((Parkeren) fromInstance).getsEML() + "'");
        if(DatabaseHandlers.dbParkeren.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        }


        String query = "UPDATE_" + sTableName + "_";
        query       +=
                "SET_'Email'_EQUALS_'"          + ((Parkeren) toInstance).getsEML() + "'," +
                        "'Datum'_EQUALS_'"             + ((Parkeren) toInstance).getsDate() + "'," +
                        "'Parkkeerplek'_EQUALS_'"      + ((Parkeren) toInstance).getsParkeerplek() + "'," +
                        "'Opmerking'_EQUALS_'"         + ((Parkeren) toInstance).getsOpmerking() + "',";


        query       += "_WHERE_('Email'_EQUALS_'" + ((Parkeren) fromInstance).getsEML() + "');";

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
        if(instance instanceof Parkeren)
            this.Delete("Email", "EQUALS", "'" + ((Parkeren) instance).getsEML() + "'");
    }
}
