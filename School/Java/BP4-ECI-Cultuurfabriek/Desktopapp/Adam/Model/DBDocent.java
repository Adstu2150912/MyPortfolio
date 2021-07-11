package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 06-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBDocent.java
 */

public abstract class DBDocent extends DBFunctionaliteit
{
    private Docent currentDocent;
    
    public ObservableList getDataFromDB()
    {
        return this.getDocentDataFromDB();
    }
    
    private ObservableList getDocentDataFromDB()
    {
        ObservableList<Docent> selectieLijst = FXCollections.observableArrayList();
        dbConnection = null;
        dbStatements.clear();
        
        try 
        {
            dbConnection = DBCPDataSource.getConnection();
            Statement stat = dbConnection.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM beroepsProduct4.Docent;");
            while(result.next())
            {	
                Docent selectedDocent = new Docent();
                selectedDocent.setDocentID(result.getInt("docentID"));
                selectedDocent.setDocentNaam(result.getString("docNaam"));
                selectedDocent.setBeschrijving(result.getString("beschrijving"));
                selectedDocent.setDiscipline(result.getString("discipline"));             
                selectieLijst.add(selectedDocent);
            }
        }
        catch(SQLException se) 
        {
            System.out.println("SQL-error in DBDocent.getDataFromDB(): " + se.getMessage());
        }
        finally
        {
            try 
            {
                if(dbConnection != null)
                    dbConnection.close();
            }
            catch(SQLException se)
            {
                System.out.println("SQL-error in DBDocent.getDataFromDB(): " + se.getMessage());
            }
        }
                
        return selectieLijst;
    }

    @Override
    public Boolean setDataToDB(int dmlType)
    {
        return this.setDocentDataToDB(dmlType);
    }
    
    public void setDocent(Docent selectedDocent)
    {
        this.currentDocent = selectedDocent;
    }
    
    private Boolean setDocentDataToDB(int dmlType)
    {
        dbResult = false;
        dbConnection = null;
        dbStatements.clear();
        Integer dbResultInt = 0;
        sqlLog = "\n";    
        
        if(this.currentDocent != null)
        {
            try
            {
                dbConnection = DBCPDataSource.getConnection();
                Statement stat = dbConnection.createStatement();
                
                switch(dmlType)
                {
                    case 0:
                        dbStatements.add("INSERT INTO Docent VALUES ('" + currentDocent.getDocentNaam() + "', '" + currentDocent.getBeschrijving() + "', '" + currentDocent.getDiscipline() + "');");
                        break;
                    case 1:
                        dbStatements.add("UPDATE Docent SET docNaam = '" + currentDocent.getDocentNaam() + "', beschrijving = '" + currentDocent.getBeschrijving() + "', discipline = '" + currentDocent.getDiscipline() + "' WHERE docentID = " + currentDocent.getDocentID() + ";");
                        break;
                }
                
                int i = 0; //rangtelnummer lusiteratie
                for(String sqlString : dbStatements)
                {                    
                    ++i;
                    dbResultInt = stat.executeUpdate(sqlString);
                    if(dbResultInt > 0)
                        sqlLog += "\nStatement " + i + " op tabel 'Docent' is succesvol uitgevoerd.";
                    else
                        sqlLog += "\nStatement " + i + " op tabel 'Docent' is mislukt!";                                        
                }
            }
            catch(SQLException se)
            {
                    System.out.println("SQL-error in DBDocent.setDocentDataToDB(): " + se.getMessage());
            }
            finally
            {
                try 
                {
                    if(dbConnection != null)
                        dbConnection.close();
                }
                catch(SQLException se)
                {                            
                    System.out.println("SQL-error in DBDocent.setDocentDataToDB(): " + se.getMessage());
                }
                finally
                {
                    return dbResult;
                }
            }
        }
        else
            return dbResult;
    }
}
