package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import java.util.ArrayList;
import java.util.List;


/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 12-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: DBfunctionaliteit.java
 */
public abstract class DBFunctionaliteit
{
    protected boolean dbResult;
    DBHelper dbHelper;
    private static final String TAG = "DBFunctionaliteit";

    //Haal gegevens uit de database op voor alle activiteiten
    protected ObservableList getActivityDataFromDB(Context context, Plaats selectedPlaats)
    {
        ObservableList<Activiteit> selectieLijst = new ObservableArrayList();
//        SQLiteDatabase db = null;
        try
        {
            dbHelper = new DBHelper(context, "SmartBrabantDB");
//            db = dbHelper.getReadableDatabase();
            Cursor result = dbHelper.getData("SELECT * FROM Activiteit WHERE plaatsNaam = '" + selectedPlaats.getNaam() + "';");
            while (result.moveToNext())
            {
                //Hier wordt ieder activiteit aan een IoT-apparaat gekoppeld met overeenkomende datasoort
                Cursor result2 = dbHelper.getData("SELECT * FROM IoTApparaat WHERE dataSoort = '" + result.getString(5) + "' AND plaatsNaam = '" + result.getString(4) + "';");
                result2.moveToNext();
                Activiteit selectedActivity = new Activiteit();
                selectedActivity.setActiviteitNummer(result.getInt(1));
                selectedActivity.setMaatFactor(result.getString(2));
                selectedActivity.setNaam(result.getString(0));
                selectedActivity.setPrioriteit(result.getString(3));
                selectedActivity.setPlaatsNaam(result.getString(4));
                if(result2.getCount() > 0)
                    if(result2.getInt(1) != 0)
                        selectedActivity.setIoTNummer(result2.getInt(1));
                if(result2.getCount() > 0)
                    if(!result2.getString(0).isEmpty())
                        selectedActivity.setIoTNaam(result2.getString(0));
                selectieLijst.add(selectedActivity);
            }
        }
        catch(SQLiteException se)
        {
           // System.out.println("SQL-error in DBFunctionaliteit.getActivityDataFromDB(): " + se.getMessage());
            Log.e(TAG, "SQL-error in method getActivityDataFromDB(Context context, Plaats selectedPlaats): " + se.getMessage());
        }
        finally
        {
//            if(db != null)
//                db.endTransaction();
            dbHelper.close();
        }
        return selectieLijst;
    }

    //Haal gegevens uit de database op voor de geselecteerde burger
    protected Burger getCitizenDataFromDB(Context context, Integer bsnNummer)
    {
        //ObservableList<Burger> selectieLijst = new ObservableArrayList();
//        SQLiteDatabase db = null;
        Burger selectedBurger = null;
        try
        {
            dbHelper = new DBHelper(context, "SmartBrabantDB");
//            db = dbHelper.getReadableDatabase();
            Cursor result = dbHelper.getData("SELECT * FROM Burger WHERE BSNnummer = " + bsnNummer + ";");
            result.moveToNext();
//            while (result.moveToNext())
//            {
            if(result.getCount() > 0)
                selectedBurger = new Burger(result.getInt(0), result.getString(1),result.getString(3), result.getInt(2), result.getString(4));
//                selectedBurger.setBsnNummer(result.getInt(0));
//                selectedBurger.setNaam(result.getString(1));
//                selectedBurger.setTevredenheidPlaats(result.getInt(2));
//                selectedBurger.setPlaatsNaam(result.getString(3));
                //selectieLijst.add(selectedBurger);
//            }
        }
        catch(SQLiteException se)
        {
            //System.out.println("SQL-error in DBFunctionaliteit.getCitizenDataFromDB(): " + se.getMessage());
            Log.e(TAG, "SQL-error in method getCitizenDataFromDB(Context context): " + se.getMessage());
        }
        finally
        {
//            if(db != null)
//                db.endTransaction();
            dbHelper.close();
        }
        return selectedBurger;
    }

    //Haal gegevens uit de database op voor het advies van de door de gebruiker geselecteerde plaats
    protected Advies getAdviceDataFromDB(Context context, Plaats selectedPlaats)
    {
        Advies huidigAdvies = null;
        ArrayList<AbstractMap.SimpleEntry<String, String>> dataToepassingenLijst = new ArrayList<SimpleEntry<String, String>>();
        List<String> gebiedenLijst = new ArrayList<String>();
        String aanbevolenTechniek = null;
        String aanbevolenIoTApparaat = null;
//        SQLiteDatabase db = null;
        try
        {
            dbHelper = new DBHelper(context, "SmartBrabantDB");
//            db = dbHelper.getReadableDatabase();
            Cursor resultPlaatsFactor = dbHelper.getData("SELECT DISTINCT Activiteit.maatschappelijkeFactor"
            + " FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = '"
            + selectedPlaats.getNaam()  + "';");
            Cursor resultPlaats = dbHelper.getData("SELECT Plaats.naam, Activiteit.naam, Activiteit.activiteitNummer, Activiteit.maatschappelijkeFactor, Activiteit.prioriteit, Activiteit.dataSoort, IoTApparaat.naam, IoTApparaat.IoTnummer"
                    + " FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = '" + selectedPlaats.getNaam() + "' GROUP BY IoTApparaat.naam;");
            Cursor resultAanbeveling = dbHelper.getData("SELECT Activiteit.ActiviteitNummer, IoTApparaat.IoTnummer, IoTApparaat.naam, Activiteit.plaatsNaam, Activiteit.dataSoort FROM Activiteit JOIN IoTApparaat ON Activiteit.dataSoort = IoTApparaat.dataSoort WHERE Activiteit.plaatsNaam = '" + selectedPlaats.getNaam() + "';");

            while (resultPlaats.moveToNext())
            {
                dataToepassingenLijst.add(new AbstractMap.SimpleEntry<String, String>(resultPlaats.getString(6), resultPlaats.getString(5)));
            }
            while(resultPlaatsFactor.moveToNext())
            {
                gebiedenLijst.add(resultPlaatsFactor.getString(0));
            }

            //haal het IoTApparatuur op waarvan het dataSoort overeenkoment met het dataSoort van activiteiten uit het geselecteerde plaats
            resultAanbeveling.moveToNext();
            if(resultAanbeveling.getCount() > 0)
            {
                aanbevolenTechniek = resultAanbeveling.getString(4) + "meting";
                aanbevolenIoTApparaat = resultAanbeveling.getString(2);
                huidigAdvies = new Advies(dataToepassingenLijst, aanbevolenTechniek, aanbevolenIoTApparaat, gebiedenLijst, selectedPlaats.getNaam());
            }
            else
            {
                huidigAdvies = new Advies(dataToepassingenLijst, "", "", gebiedenLijst, selectedPlaats.getNaam());
                huidigAdvies.setPva("N.v.t.");
            }
        }
        catch(SQLiteException se)
        {
            //System.out.println("SQL-error in DBFunctionaliteit.getAdviceDataFromDB(): " + se.getMessage());
            Log.e(TAG, "SQL-error in method getAdviceDataFromDB(Context context, Plaats selectedPlaats): " + se.getMessage());
        }
        finally
        {
//            if(db != null)
//                db.endTransaction();
            dbHelper.close();
        }

        return huidigAdvies;
    }

    //Haal gegevens uit de database op voor alle IoT-apparaten
    protected ObservableList getIoTDataFromDB(Context context, Plaats selectedPlaats)
    {
        ObservableList<IoTApparaat> selectieLijst = new ObservableArrayList();
//        SQLiteDatabase db = null;
        try
        {
            dbHelper = new DBHelper(context, "SmartBrabantDB");
//            db = dbHelper.getReadableDatabase();
            Cursor result = dbHelper.getData("SELECT * FROM IoTApparaat WHERE plaatsNaam = '" + selectedPlaats.getNaam() + "';");
            Cursor result2 = null;
            while(result.moveToNext())
            {
                //Hier wordt ieder IoT-apparaat aan een activiteit gekoppeld met overeenkomende datasoort
                result2 = dbHelper.getData("SELECT * FROM Activiteit WHERE dataSoort = '" + result.getString(2) + "' AND plaatsNaam = '" + result.getString(3) + "';");
                result2.moveToNext();
                IoTApparaat selectedIoT = new IoTApparaat();
                selectedIoT.setActiviteitNummer(result.getInt(1));
                selectedIoT.setDataSoort(result.getString(2));
                selectedIoT.setNaam(result.getString(0));
                selectedIoT.setPlaatsNaam(result.getString(3));
                if(result2.getCount() > 0)
                    if(result2.getInt(1) != 0)
                        selectedIoT.setActiviteitNummer(result2.getInt(1));
                if(result2.getCount() > 0)
                    if(!result2.getString(0).isEmpty())
                        selectedIoT.setActiviteitNaam(result2.getString(0));
                selectieLijst.add(selectedIoT);
            }
        }
        catch(SQLiteException se)
        {
            //System.out.println("SQL-error in DBFunctionaliteit.getIoTDataFromDB(): " + se.getMessage());
            Log.e(TAG, "SQL-error in method getIoTDataFromDB(Context context, Plaats selectedPlaats): " + se.getMessage());
        }
        finally
        {
//            if(db != null)
//                db.endTransaction();
            dbHelper.close();
        }
        return selectieLijst;
    }

    //Haal gegevens uit de database op voor alle plaatsen
    protected ObservableList getGeoDataFromDB(Context context)
    {
        ObservableList<Plaats> selectieLijst = new ObservableArrayList();
//        SQLiteDatabase db = null;
        try
        {
            dbHelper = new DBHelper(context, "SmartBrabantDB");
//            db = dbHelper.getReadableDatabase();
            Cursor result = dbHelper.getData("SELECT * FROM Plaats");
            Cursor result2 = null;
            while(result.moveToNext())
            {
                //Hier wordt ieder IoT-apparaat aan een activiteit gekoppeld met overeenkomende datasoort
                result2 = dbHelper.getData("SELECT AVG(tevredenheidPlaats) AS tevredenHeid FROM Burger WHERE plaatsNaam = '" + result.getString(0) + "';");
                result2.moveToNext();
                Plaats selectedPlaats = new Plaats();
                selectedPlaats.setNaam(result.getString(0));
                selectedPlaats.setGemeentePop(result.getInt(1));
                selectedPlaats.setStatus(result.getInt(2));
                selectedPlaats.setOppervlakte(result.getDouble(3));
                selectedPlaats.setStadPop(result.getInt(4));
                selectedPlaats.setMetroPop(result.getInt(5));
                selectedPlaats.setGemeente(result.getString(6));
                selectedPlaats.setTevredenheid(Double.toString(result2.getDouble(0) * 100) + "%");
                selectieLijst.add(selectedPlaats);
            }
        }
        catch(SQLiteException se)
        {
            //System.out.println("SQL-error in DBFunctionaliteit.getGeoDataFromDB(): " + se.getMessage());
            Log.e(TAG, "SQL-error in method getGeoDataFromDB(Context context): " + se.getMessage());
        }
        finally
        {
//            if(db != null)
//                db.endTransaction();
            dbHelper.close();
        }
        return selectieLijst;
    }

    //Voer gegevens uit de geselecteerde burger en plaats in de database
    protected Boolean setFeedbackFormToDB(Context context, Burger burger)
    {
        Boolean isSuccesful = false;
        SQLiteDatabase db = null;
//        String whereArgs[] = {burger.getNaam(), Integer.toString(burger.getTevredenheidPlaats()), burger.getPlaatsNaam(), burger.getMening(),  Integer.toString(burger.getBsnNummer())};
        try
        {
            dbHelper = new DBHelper(context, "SmartBrabantDB");
            db = dbHelper.getWritableDatabase();

            String sqlUpdate = "UPDATE Burger SET naam=?, tevredenheidPlaats=?, plaatsNaam=?, mening=? WHERE BSNnummer=?";
            SQLiteStatement statement = db.compileStatement(sqlUpdate);

            ContentValues values = new ContentValues();
            values.put("naam", burger.getNaam());
            values.put("tevredenheidPlaats", burger.getTevredenheidPlaats());
            values.put("plaatsNaam", burger.getPlaatsNaam());
            values.put("mening", burger.getMening());
            statement.bindString(1, burger.getNaam());
            statement.bindLong(2, burger.getTevredenheidPlaats());
            statement.bindString(3, burger.getPlaatsNaam());
            statement.bindString(4, burger.getMening());
            statement.bindLong(5, burger.getBsnNummer());

            long result = 0;
            if(this.getCitizenDataFromDB(context, burger.getBsnNummer()) != null)
                result = statement.executeUpdateDelete();
                //result = db.update("Burger", values, "BSNnummer = ?", whereArgs);
            else
            {
                values.put("BSNnummer", burger.getBsnNummer());
                result = db.insert("Burger", null, values);
            }
            if (result == -1)
                isSuccesful = false;
            else
                isSuccesful = true;
            db.endTransaction();
        }
        catch(SQLiteException se)
        {
            //System.out.println("SQL-error in DBFunctionaliteit.setFeedbackFormToDB(): " + se.getMessage());
            Log.e(TAG, "SQL-error in method setFeedbackFormToDB(Context context, Burger burger): " + se.getMessage());
        }
        finally
        {
//            if(db != null)
//                db.endTransaction();
            dbHelper.close();
            return isSuccesful;
        }
    }
}
