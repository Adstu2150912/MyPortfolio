package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Collab;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 11-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBCursus.java
 */
public class DBCursus extends DatabaseTable
{
    private ArrayList<Cursus> dataset = new ArrayList<Cursus>();
    
    public DBCursus(DatabaseConnection toConnect, String sTableName)
    {
        this.sTableName = sTableName;
        this.setDatabase(toConnect);
    }
    
    public void fillDataFromResultSet(ResultSet data)
    {
        try
        {
            dataset.clear();
            while(data.next())
            {
                Cursus selectedCursus = new Cursus();
                selectedCursus.setCategorieID(data.getInt("categorieID"));
                selectedCursus.setCursusID(data.getInt("cursusID"));
                selectedCursus.setDocentID(data.getInt("docentID"));
                selectedCursus.setCursusNaam(data.getString("cursusNaam"));
                selectedCursus.setBeschrijving(data.getString("beschrijving"));
                selectedCursus.setDoelGroep(data.getString("doelGroep"));
                selectedCursus.setStartDatum(data.getString("startDatum"));
                selectedCursus.setDag(data.getString("dag"));
                selectedCursus.setTijd(data.getString("tijd"));
                selectedCursus.setDuur(data.getInt("duur"));
                selectedCursus.setFrequentie(data.getString("frequentie"));
                selectedCursus.setLesAantal(data.getInt("lesAantal"));
                selectedCursus.setLesPrijs(data.getDouble("lesPrijs"));                   
                
                dataset.add(selectedCursus); 
            }            
        } 
        catch (Exception e)
        {
            StandardDebugActions.error(e);
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
    
    @Override
    public void insertDataIntoTable(Object instance)
    {
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("cursusID = " + ((Cursus) instance).getCursusID() + "");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        DatabaseHandlers.DBCursusCategorie.select("categorieID=" + ((Cursus) toInstance).getCategorieID() + "");
        if(DatabaseHandlers.DBCursusCategorie.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key 'FK_Cursus_Cursuscategorie' does not exist");
            return;
        }     
        
        DatabaseHandlers.DBDocent.select("docentID=" + ((Cursus) toInstance).getDocentID() + "");
        if(DatabaseHandlers.DBDocent.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key 'FK_Cursus_Docent' does not exist");
            return;
        }  
        
        
        String query = "INSERT INTO " + sTableName + " "
                  + "("
                    + "cursusID, "
                    + "cursusNaam, "
                    + "beschrijving, "
                    + "doelGroep, "
                    + "startDatum, "
                    + "dag, "
                    + "tijd, "
                    + "duur, "
                    + "frequentie, "
                    + "lesAantal, "
                    + "lesPrijs, "
                    + "categorieID, "
                    + "docentID "
                  + ") VALUES (";
        
        query += " " + ((Cursus) instance).getCursusID()           + ", ";
        query += "'" + ((Cursus) instance).getCursusNaam()        + "', ";
        query += "'" + ((Cursus) instance).getBeschrijving()      + "', ";
        query += "'" + ((Cursus) instance).getDoelGroep()     + "', ";
        query += "'" + ((Cursus) instance).getStartDatum()        + "', ";
        query += "'" + ((Cursus) instance).getDag()    + ",' ";
        query += "'" + ((Cursus) instance).getTijd()          + "', ";
        query += "'" + ((Cursus) instance).getDuur()      + "', ";
        query += "'" + ((Cursus) instance).getFrequentie()      + "', ";
        query += "" + ((Cursus) instance).getLesAantal()  + ", ";
        query += "" + ((Cursus) instance).getLesPrijs()      + ", ";
        query += "" + ((Cursus) instance).getCategorieID()      + "', ";
        query += "" + ((Cursus) instance).getDocentID()      + " ";
        query += ");";        
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void UpdateDataIntoTable(Object fromInstance, Object toInstance)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        this.select("cursusID=" + ((Cursus) fromInstance).getCursusID + "");
        if(dataset.toArray().length <- 0) 
        {
            StandardDebugActions.error("Instance not in database cannot update");
            return;
        }
        
        if(dataset.toArray().length <= 0)
        {
            StandardDebugActions.error("Primary Key already exist");
            return;
        }
        
        DatabaseHandlers.DBCursusCategorie.select("categorieID=" + ((Cursus) toInstance).getCategorieID() + "");
        if(DatabaseHandlers.DBCursusCategorie.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key 'FK_Cursus_Cursuscategorie' does not exist");
            return;
        }     
        
        DatabaseHandlers.DBDocent.select("docentID=" + ((Cursus) toInstance).getDocentID() + "");
        if(DatabaseHandlers.DBDocent.getResults().length <= 0)
        {
            StandardDebugActions.error("new foreign key 'FK_Cursus_Docent' does not exist");
            return;
        }   
        
        String query = "UPDATE " + sTableName + " ";
        query += "SET cursusNaam = '" + ((Cursus)toInstance).getDocNaam + "' ";
        query += ", beschrijving = '" + ((Cursus)toInstance).getBeschrijving + "'";
        query += ", doelGroep = '" + ((Cursus)toInstance).getDiscipline + "'";
        query += ", startDatum = '" + ((Cursus)toInstance).getStartDatum + "'";
        query += ", dag = '" + ((Cursus)toInstance).getDag + "'";
        query += ", tijd = '" + ((Cursus)toInstance).getTijd + "'";
        query += ", duur = " + ((Cursus)toInstance).getDuur + "";
        query += ", frequentie = '" + ((Cursus)toInstance).getFrequentie + "'";
        query += ", lesAantal = " + ((Cursus)toInstance).getLesAantal + "";
        query += ", lesPrijs = " + ((Cursus)toInstance).getLesPrijs + "";
        query += ", categorieID = " + ((Cursus)toInstance).getCategorieID + "";
        query += ", docentID = " + ((Cursus)toInstance).getDocentID + "";
        query += "WHERE cursusID = " + ((Cursus) fromInstance).getCursusID + " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void deleteSpecificData(Object instance)
    {
        this.Delete("cursusID = " + ((Integer) instance));
    }
}
