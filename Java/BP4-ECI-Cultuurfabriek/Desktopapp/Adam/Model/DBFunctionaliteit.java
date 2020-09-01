package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBFunctionaliteit.java
 */

public abstract class DBFunctionaliteit implements IDBFunctionaliteit
{
    protected Boolean dbResult = false; //Bewaar het resultaat van de meest recent uitgevoerde SQL-opdracht
    protected Connection dbConnection;
    protected ArrayList<String> dbStatements;
    protected String sqlLog;  

    @Override
    public abstract ObservableList getDataFromDB();
    
    @Override
    public abstract Boolean setDataToDB(int dmlType); //Parameter 'dmlType' geeft aan welk soort DML-statament uitgevoerd moet worden (0 = INSERT, 1 = UPDATE)

    @Override
    public boolean testDBConnection()
    {
        try
        {
            dbConnection = DBCPDataSource.getConnection();
            if(dbConnection.isValid(10))
                dbResult = true;
            else
                dbResult = false;            
        }
        catch(SQLException se)
        {
            System.out.println("SQL-error in DBFunctionaliteit.testDBConnection(): " + se.getMessage());
            dbResult = false;
        }
        finally
        {
            return dbResult;
        }
    }
    
    
}
