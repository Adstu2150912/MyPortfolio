package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Gebruiker;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseHandlers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;


/**
 *
 * @author swkoe
 */
public class DBGebruiker extends DatabaseTable
{
    private ArrayList<Gebruiker> dataset = new ArrayList<Gebruiker>();


    public DBGebruiker(String sTableName, Context context, Activity activity)
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
                        Date huidigeGDTM = new Date(0);
                        JSONObject jsonObject = data.getJSONObject(i);
                        try{
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            huidigeGDTM  = (Date) dateFormat.parse(jsonObject.getString("GDTM"));
                        }
                        catch(ParseException e){
                            e.printStackTrace();
                        }
                        Gebruiker gebruiker = new Gebruiker
                                (
                                        jsonObject.getString("EMAIL"),
                                        jsonObject.getString("VOORNAAM"),
                                        jsonObject.getString("ACHTERNAAM"),
                                        jsonObject.getString("VOORLETTERS"),
                                        jsonObject.getString("GESLACHT"),
                                        huidigeGDTM,
                                        jsonObject.getString("PLAATS"),
                                        jsonObject.getString("STRAATNAAM"),
                                        jsonObject.getString("HUISNUMMER"),
                                        jsonObject.getString("TELEFOONNUMMER"),
                                        jsonObject.getString("IBAN")
                                );

                        dataset.add(gebruiker);
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

    public Gebruiker[] getResults()
    {
        Gebruiker[] DataArray = new Gebruiker[dataset.toArray().length];
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
        this.select("EMAIL", "EQUALS", ((Gebruiker) instance).getsEmail());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBGebruiker.insertDataIntoTable: Current Primary Key (EMAIL '" + ((Gebruiker) instance).getsEmail() + "') already exists");
            return;
        }

        DatabaseHandlers.dbEmail.select("_WHERE_EML_EQUALS_'" + ((Gebruiker) instance).getsEmail() + "'");
        if(DatabaseHandlers.dbEmail.getResults().length <= 0)
        {
            StandardDebugActions.error("foreign key does not exist");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "_('EMAIL','VOORNAAM','ACHTERNAAM','VOORLETTERS','GESLACHT','GDTM','PLAATS','STRAATNAAM','HUISNUMMER','TELEFOONNUMMER','IBAN')_VALUES_("
                + "'" + ((Gebruiker) instance).getsEmail() + "',"
                + "'" + ((Gebruiker) instance).getsVoornaam() + "',"
                + "'" + ((Gebruiker) instance).getsAchternaam() + "',"
                + "'" + ((Gebruiker) instance).getsVoornaam() + "',"
                + "'" + ((Gebruiker) instance).getsGeslacht() + "',"
                + "'" + ((Gebruiker) instance).getGeboorteDatum().toString() + "',"
                + "'" + ((Gebruiker) instance).getsPlaats() + "',"
                + "'" + ((Gebruiker) instance).getsStraatNaam() + "',"
                + "'" + ((Gebruiker) instance).getsHuisnummer() + "',"
                + "'" + ((Gebruiker) instance).getsTelefoonnummer() + "',"
                + "'" + ((Gebruiker) instance).getsIbanNummer()  + "');";

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
        this.select("EMAIL", "EQUALS", ((Gebruiker) fromInstance).getsEmail());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBGebruiker.insertDataIntoTable: Current Primary Key (EMAIL '" + ((Gebruiker) fromInstance).getsEmail() + "') already exists");
            return;
        }

        this.select("EMAIL", "EQUALS", "'" + ((Gebruiker) fromInstance).getsEmail() + "'");
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }

        /*DatabaseHandlers.emails.select("EML='" + ((Gebruiker) toInstance).getsEmail() + "'");
        if(DatabaseHandlers.emails.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key does not exist");
            return;
        } */


        String query = "UPDATE_" + sTableName + "_";
        query       +=
                "SET_'EMAIL'EQUALS'"           + ((Gebruiker) toInstance).getsEmail() + "'," +
                        "'VOORNAAM'EQUALS'"             + ((Gebruiker) toInstance).getsVoornaam() + "'," +
                        "'ACHTERNAAM'EQUALS'"           + ((Gebruiker) toInstance).getsAchternaam() + "'," +
                        "'VOORLETTERS'EQUALS'"          + ((Gebruiker) toInstance).getsVoorletters() + "'," +
                        "'GESLACHT'EQUALS'"             + ((Gebruiker) toInstance).getsGeslacht() + "'," +
                        "'GDTM'EQUALS'"                 + ((Gebruiker) toInstance).getGeboorteDatum().toString() + "'," +
                        "'PLAATS'EQUALS'"               + ((Gebruiker) toInstance).getsPlaats() + "'," +
                        "'STRAATNAAM'EQUALS'"           + ((Gebruiker) toInstance).getsStraatNaam() + "'," +
                        "'HUISNUMMER'EQUALS'"           + ((Gebruiker) toInstance).getsHuisnummer() + "'," +
                        "'TELEFOONNUMMER'EQUALS'"       + ((Gebruiker) toInstance).getsTelefoonnummer() + "'," +
                        "'IBAN'EQUALS'"                 + ((Gebruiker) toInstance).getsIbanNummer() + "'";

        query       += "_WHERE_('EMAIL'EQUALS'" + ((Gebruiker) fromInstance).getsEmail() + "');";

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
        if(instance instanceof Gebruiker)
            this.Delete("EMAIL", "EQUALS", ((Gebruiker) instance).getsEmail());
    }

}
