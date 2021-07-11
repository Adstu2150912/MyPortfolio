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
 * Bestandsnaam: DBCursus.java
 */

public abstract class DBCursus extends DBFunctionaliteit
{
    private Cursus currentCursus;
    
    public ObservableList getDataFromDB()
    {
        return this.getCursusDataFromDB();
    }
    
    private ObservableList getCursusDataFromDB()
    {
        ObservableList<Cursus> selectieLijst = FXCollections.observableArrayList();
        dbConnection = null;
        dbStatements.clear();
        
        try 
        {
            dbConnection = DBCPDataSource.getConnection();
            Statement stat = dbConnection.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM beroepsProduct4.Cursus;");
            while(result.next())
            {	
                Cursus selectedCursus = new Cursus();
                selectedCursus.setCategorieID(result.getInt("categorieID"));
                selectedCursus.setCursusID(result.getInt("cursusID"));
                selectedCursus.setDocentID(result.getInt("docentID"));
                selectedCursus.setCursusNaam(result.getString("cursusNaam"));
                selectedCursus.setBeschrijving(result.getString("beschrijving"));
                selectedCursus.setDoelGroep(result.getString("doelGroep"));
                selectedCursus.setStartDatum(result.getString("startDatum"));
                selectedCursus.setDag(result.getString("dag"));
                selectedCursus.setTijd(result.getString("tijd"));
                selectedCursus.setDuur(result.getInt("duur"));
                selectedCursus.setFrequentie(result.getString("frequentie"));
                selectedCursus.setLesAantal(result.getInt("lesAantal"));
                selectedCursus.setLesPrijs(result.getDouble("lesPrijs"));                
                selectieLijst.add(selectedCursus);
            }
        }
        catch(SQLException se) 
        {
            System.out.println("SQL-error in DBCursus.getDataFromDB(): " + se.getMessage());
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
                System.out.println("SQL-error in DBCursus.getDataFromDB(): " + se.getMessage());
            }
        }
                
        return selectieLijst;
    }

    @Override
    public Boolean setDataToDB(int dmlType)
    {
        return this.setCursusDataToDB(dmlType);
    }
    
    public void setCursus(Cursus selectedCursus)
    {
        this.currentCursus = selectedCursus;        
        
    }
    
    private Boolean setCursusDataToDB(int dmlType)
    {
        dbResult = false;
        dbConnection = null;
        dbStatements.clear();
        Integer dbResultInt = 0;
        sqlLog = "\n";        
        
        if(this.currentCursus != null)
        {
            try
            {
                dbConnection = DBCPDataSource.getConnection();
                Statement stat = dbConnection.createStatement();
                
                switch(dmlType)
                {
                    case 0:
                        dbStatements.add("INSERT INTO Cursus VALUES ('" + currentCursus.getCursusNaam() + "', '" + currentCursus.getBeschrijving() 
                        + "','" + currentCursus.getDoelGroep() + "', '" + currentCursus.getStartDatum() + "', '" + currentCursus.getDag() + "', '" 
                        + currentCursus.getTijd() + "'," + currentCursus.getDuur() + ", '" + currentCursus.getFrequentie() + "'," + currentCursus.getLesAantal() 
                        + "," + currentCursus.getLesPrijs() + "," + currentCursus.getCategorieID() + "," + currentCursus.getDocentID() + ");");
                        break;
                    case 1:
                        dbStatements.add("UPDATE Cursus SET cursusNaam = '" + currentCursus.getCursusNaam() + "', beschrijving = '" + currentCursus.getBeschrijving() 
                        + "', doelGroep = '" + currentCursus.getDoelGroep() + "', startDatum ='" + currentCursus.getStartDatum() + "', dag = '" + currentCursus.getDag() + "', tijd ='" + currentCursus.getTijd() + "', duur = " + currentCursus.getDuur() 
                        + ", frequentie = '" + currentCursus.getFrequentie() + "', lesAantal = " + currentCursus.getLesAantal() + ", lesPrijs = " + currentCursus.getLesPrijs() + ", categorieID = " + currentCursus.getCategorieID() + ", docentID = " + currentCursus.getDocentID() 
                        + " WHERE cursusID =" + currentCursus.getCursusID() + ";");
                        break;
                }
                
                int i = 0; //rangtelnummer lusiteratie
                for(String sqlString : dbStatements)
                {                    
                    ++i;
                    dbResultInt = stat.executeUpdate(sqlString);
                    if(dbResultInt > 0)
                        sqlLog += "\nStatement " + i + " op tabel 'Cursus' is succesvol uitgevoerd.";
                    else
                        sqlLog += "\nStatement " + i + " op tabel 'Cursus' is mislukt!";                                        
                }
            }
            catch(SQLException se)
            {
                    System.out.println("SQL-error in DBCursus.setCursusDataToDB(): " + se.getMessage());
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
                    System.out.println("SQL-error in DBCursus.setCursusDataToDB(): " + se.getMessage());
                }
                finally
                {
                    System.out.println(sqlLog);
                    return dbResult;
                }
            }
        }
        else
            return dbResult;
    }
}
