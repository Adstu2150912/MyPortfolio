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
 * Bestandsnaam: DBCursuscategorie.java
 */

public class DBCursusCategorie extends DBFunctionaliteit
{
    private Cursuscategorie currentCategorie;
    
    public ObservableList getDataFromDB()
    {
        return getCategorieDataFromDB();
    }
    
    private ObservableList getCategorieDataFromDB()
    {
        ObservableList<Cursuscategorie> selectieLijst = FXCollections.observableArrayList();
        dbConnection = null;
        dbStatements.clear();
        
        try 
        {
            dbConnection = DBCPDataSource.getConnection();
            Statement stat = dbConnection.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM beroepsProduct4.Cursuscategorie;");
            while(result.next())
            {	
                Cursuscategorie selectedCategorie = new Cursuscategorie();
                selectedCategorie.setCategorieID(result.getInt("categorieID"));
                selectedCategorie.setSubCategorie(result.getString("subCategorie"));
                selectedCategorie.setCategorieNaam(result.getString("categorieNaam"));
                selectedCategorie.setOmschrijving(result.getString("omschrijving"));             
                selectieLijst.add(selectedCategorie);
            }
        }
        catch(SQLException se) 
        {
            System.out.println("SQL-error in DBCursusCategorie.getDataFromDB(): " + se.getMessage());
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
                System.out.println("SQL-error in DBCursusCategorie.getDataFromDB(): " + se.getMessage());
            }
        }
                
        return selectieLijst;
    }

    @Override
    public Boolean setDataToDB(int dmlType)
    {
        return this.setCategorieDataToDB(dmlType);
    }
    
    public void setCategorie(Cursuscategorie selectedCategorie)
    {
        this.currentCategorie = selectedCategorie;
    }
    
    private Boolean setCategorieDataToDB(int dmlType)
    {
        dbResult = false;
        dbConnection = null;
        dbStatements.clear();
        Integer dbResultInt = 0;
        sqlLog = "\n";
        
        if(this.currentCategorie != null)
        {
            try
            {
                dbConnection = DBCPDataSource.getConnection();
                Statement stat = dbConnection.createStatement();
                
                switch(dmlType)
                {
                    case 0:
                        dbStatements.add("INSERT INTO Cursuscategorie VALUES ('" + currentCategorie.getSubCategorie() + "', '" + currentCategorie.getCategorieNaam() + "', '" + currentCategorie.getOmschrijving() + "');");
                        break;
                    case 1:
                        dbStatements.add("UPDATE Cursuscategorie SET subCategorie = '" + currentCategorie.getSubCategorie() + "', categorieNaam = '" + currentCategorie.getCategorieNaam() + "', omschrijving = '" + currentCategorie.getOmschrijving() + "' WHERE categorieID = " + currentCategorie.getCategorieID() + ";");
                        break;
                }
                
                int i = 0; //rangtelnummer lusiteratie
                for(String sqlString : dbStatements)
                {                    
                    ++i;
                    dbResultInt = stat.executeUpdate(sqlString);
                    if(dbResultInt > 0)
                        sqlLog += "\nStatement " + i + " op tabel 'Cursuscategorie' is succesvol uitgevoerd.";
                    else
                        sqlLog += "\nStatement " + i + " op tabel 'Cursuscategorie' is mislukt!";                                        
                }
            }
            catch(SQLException se)
            {
                    System.out.println("SQL-error in DBCursusCategorie.setCategorieDataToDB(): " + se.getMessage());
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
                    System.out.println("SQL-error in DBCursusCategorie.setCategorieDataToDB(): " + se.getMessage());
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
