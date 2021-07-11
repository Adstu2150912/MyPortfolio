package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.content.Context;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Cursus;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Cursuscategorie;
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
 * Bestandsnaam: DBCursus.java
 */
public class DBCursus extends DatabaseTable
{
    private ArrayList<Cursus> dataset = new ArrayList<Cursus>();
    
    public DBCursus(String sTableName, Context context, Activity activity)
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
                        Cursus selectedCursus = new Cursus();
                        selectedCursus.setCategorieID(jsonObject.getInt("categorieID"));
                        selectedCursus.setCursusID(jsonObject.getInt("cursusID"));
                        selectedCursus.setDocentID(jsonObject.getInt("docentID"));
                        selectedCursus.setCursusNaam(jsonObject.getString("cursusNaam"));
                        selectedCursus.setBeschrijving(jsonObject.getString("beschrijving"));
                        selectedCursus.setDoelGroep(jsonObject.getString("doelGroep"));
                        selectedCursus.setStartDatum(jsonObject.getString("startDatum"));
                        selectedCursus.setDag(jsonObject.getString("dag"));
                        selectedCursus.setTijd(jsonObject.getString("tijd"));
                        selectedCursus.setDuur(jsonObject.getInt("duur"));
                        selectedCursus.setFrequentie(jsonObject.getString("frequentie"));
                        selectedCursus.setLesAantal(jsonObject.getInt("lesAantal"));
                        selectedCursus.setLesPrijs(jsonObject.getDouble("lesPrijs"));
                        dataset.add(selectedCursus);
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
    
    public Cursus[] getResults()
    {
        Cursus[] DataArray = new Cursus[dataset.toArray().length];
        for(int i = 0; i < dataset.toArray().length; i++)
        {
            DataArray[i] = dataset.get(i);
        }

        return DataArray;
    }

    public void insertDataIntoTable(Object instance)
    {
        this.select("cursusID", "EQUALS", ((Cursus) instance).getCursusID().toString());
        if(dataset.toArray().length >= 1)
        {
            StandardDebugActions.error("DBCursus.insertDataIntoTable: Current Primary Key (CursusID " + ((Cursus) instance).getCursusID() + ") already exists");
            return;
        }

        DatabaseHandlers.dbCursusCategorie.select("categorieID", "EQUALS", ((Cursus) instance).getCategorieID().toString());
        if(DatabaseHandlers.dbCursusCategorie.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.insertDataIntoTable: new foreign key 'FK_Cursus_Cursuscategorie' (categorieID " + ((Cursus) instance).getCategorieID() + ") does not exists");
            return;
        }

        DatabaseHandlers.dbDocent.select("docentID", "EQUALS", ((Cursus) instance).getDocentID().toString());
        if(DatabaseHandlers.dbDocent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.insertDataIntoTable: new foreign key 'FK_Cursus_Docent' (docentID " + ((Cursus) instance).getDocentID() + ") does not exists");
            return;
        }

        String query = "INSERT_INTO_" + sTableName + "_"
                + "("
                + "cursusID,"
                + "cursusNaam,"
                + "beschrijving,"
                + "doelGroep,"
                + "startDatum,"
                + "dag,"
                + "tijd,"
                + "duur,"
                + "frequentie,"
                + "lesAantal,"
                + "lesPrijs,"
                + "categorieID,"
                + "docentID"
                + ")_VALUES_(";

        query += ((Cursus) instance).getCursusID()           + ",";
        query += "'" + ((Cursus) instance).getCursusNaam()        + "',";
        query += "'" + ((Cursus) instance).getBeschrijving()      + "',";
        query += "'" + ((Cursus) instance).getDoelGroep()     + "',";
        query += "'" + ((Cursus) instance).getStartDatum()        + "',";
        query += "'" + ((Cursus) instance).getDag()    + "',";
        query += "'" + ((Cursus) instance).getTijd()          + "',";
        query += "'" + ((Cursus) instance).getDuur()      + "',";
        query += "'" + ((Cursus) instance).getFrequentie()      + "',";
        query += ((Cursus) instance).getLesAantal()  + ",";
        query += ((Cursus) instance).getLesPrijs()      + ",";
        query += ((Cursus) instance).getCategorieID()      + ",";
        query += ((Cursus) instance).getDocentID();
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
        this.select("cursusID", "EQUALS", ((Cursus) fromInstance).getCursusID().toString());
        if(dataset.toArray().length <- 0)
        {
            StandardDebugActions.error("DBCursus.UpdateDataIntoTable: Current instance Cursus not in database; cannot update");
            return;
        }

        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("DBCursus.UpdateDataIntoTable: Current Primary Key (CursusID " + ((Cursus) fromInstance).getCursusID() + ") already exists");
            return;
        }

        DatabaseHandlers.dbCursusCategorie.select("categorieID", "EQUALS", ((Cursus) toInstance).getCategorieID().toString());
        if(DatabaseHandlers.dbCursusCategorie.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.UpdateDataIntoTable: new foreign key 'FK_Cursus_Cursuscategorie' (CategorieID " + ((Cursus) toInstance).getCategorieID() + ") does not exists");
            return;
        }

        DatabaseHandlers.dbDocent.select("docentID", "EQUALS", ((Cursus) toInstance).getDocentID().toString());
        if(DatabaseHandlers.dbDocent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.UpdateDataIntoTable: new foreign key 'FK_Cursus_Docent' (DocentID " + ((Cursus) toInstance).getDocentID() + ") does not exist");
            return;
        }

        String query = "UPDATE_" + sTableName + "_";
        query += "SET_cursusNaam_EQUALS_'" + ((Cursus)toInstance).getCursusNaam() + "'_";
        query += ",_beschrijving_EQUALS_'" + ((Cursus)toInstance).getBeschrijving() + "'";
        query += ",_doelGroep_EQUALS_'" + ((Cursus)toInstance).getDoelGroep() + "'";
        query += ",_startDatum_EQUALS_'" + ((Cursus)toInstance).getStartDatum() + "'";
        query += ",_dag_EQUALS_'" + ((Cursus)toInstance).getDag() + "'";
        query += ",_tijd_EQUALS_'" + ((Cursus)toInstance).getTijd() + "'";
        query += ",_duur_EQUALS_" + ((Cursus)toInstance).getDuur() + "";
        query += ",_frequentie_EQUALS_'" + ((Cursus)toInstance).getFrequentie() + "'";
        query += ",_lesAantal_EQUALS_" + ((Cursus)toInstance).getLesAantal() + "";
        query += ",_lesPrijs_EQUALS_" + ((Cursus)toInstance).getLesPrijs() + "";
        query += ",_categorieID_EQUALS_" + ((Cursus)toInstance).getCategorieID() + "";
        query += ",_docentID_EQUALS_" + ((Cursus)toInstance).getDocentID() + "";
        query += "_WHERE_cursusID_EQUALS_" + ((Cursus) fromInstance).getCursusID() + " ;";

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
        if(instance instanceof Cursus)
            this.Delete("cursusID", "EQUALS",  ((Cursus) instance).getCursusID().toString());
        else if(instance instanceof Docent)
        {
            DatabaseHandlers.dbDocent.select("docentID", "EQUALS", ((Docent) instance).getDocentID().toString());
            if(DatabaseHandlers.dbDocent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBCursus.deleteSpecificData: foreign key 'FK_Cursus_Docent' (docentID " + ((Docent) instance).getDocentID() + ") does not exists");
                return;
            }
            this.Delete("docentID", "EQUALS", ((Docent) instance).getDocentID().toString());
        }
        else if(instance instanceof Cursuscategorie)
        {
            DatabaseHandlers.dbCursusCategorie.select("categorieID", "EQUALS", ((Cursuscategorie) instance).getCategorieID().toString());
            if(DatabaseHandlers.dbCursusCategorie.getResults().length <= 0)
            {
                StandardDebugActions.error("DBCursus.deleteSpecificData: foreign key 'FK_Cursus_Cursuscategorie' (categorieID " + ((Cursuscategorie) instance).getCategorieID() + ") does not exists");
                return;
            }
            this.Delete("categorieID", "EQUALS", ((Cursuscategorie) instance).getCategorieID().toString());
        }
    }
}
