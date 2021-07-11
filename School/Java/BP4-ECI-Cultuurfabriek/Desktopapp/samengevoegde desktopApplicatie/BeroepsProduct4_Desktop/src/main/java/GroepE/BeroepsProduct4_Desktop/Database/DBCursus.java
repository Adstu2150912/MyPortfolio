package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursus;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursuscategorie;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Docent;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
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
            StandardDebugActions.error("DBCursus.insertDataIntoTable: Current Cursus is not initialized");
            return;
        }
        
        this.select("cursusID = " + ((Cursus) instance).getCursusID() + "");
        if(dataset.toArray().length >= 1) 
        {
            StandardDebugActions.error("DBCursus.insertDataIntoTable: Current Primary Key (CursusID " + ((Cursus) instance).getCursusID() + ") already exists");
            return;
        }
        
        DatabaseHandlers.dbCursusCategorie.select("categorieID=" + ((Cursus) instance).getCategorieID() + "");
        if(DatabaseHandlers.dbCursusCategorie.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.insertDataIntoTable: new foreign key 'FK_Cursus_Cursuscategorie' (categorieID " + ((Cursus) instance).getCategorieID() + ") does not exists");
            return;
        }     
        
        DatabaseHandlers.dbDocent.select("docentID=" + ((Cursus) instance).getDocentID() + "");
        if(DatabaseHandlers.dbDocent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.insertDataIntoTable: new foreign key 'FK_Cursus_Docent' (docentID " + ((Cursus) instance).getDocentID() + ") does not exists");
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
        query += "'" + ((Cursus) instance).getDag()    + "', ";
        query += "'" + ((Cursus) instance).getTijd()          + "', ";
        query += "'" + ((Cursus) instance).getDuur()      + "', ";
        query += "'" + ((Cursus) instance).getFrequentie()      + "', ";
        query += "" + ((Cursus) instance).getLesAantal()  + ", ";
        query += "" + ((Cursus) instance).getLesPrijs()      + ", ";
        query += "" + ((Cursus) instance).getCategorieID()      + ", ";
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
            StandardDebugActions.error("DBCursus.UpdateDataIntoTable: Current Cursus is not initialized");
            return;
        }
        
        this.select("cursusID=" + ((Cursus) fromInstance).getCursusID() + "");
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
        
        DatabaseHandlers.dbCursusCategorie.select("categorieID=" + ((Cursus) toInstance).getCategorieID() + "");
        if(DatabaseHandlers.dbCursusCategorie.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.UpdateDataIntoTable: new foreign key 'FK_Cursus_Cursuscategorie' (CategorieID " + ((Cursus) toInstance).getCategorieID() + ") does not exists");
            return;
        }     
        
        DatabaseHandlers.dbDocent.select("docentID=" + ((Cursus) toInstance).getDocentID() + "");
        if(DatabaseHandlers.dbDocent.getResults().length <= 0)
        {
            StandardDebugActions.error("DBCursus.UpdateDataIntoTable: new foreign key 'FK_Cursus_Docent' (DocentID " + ((Cursus) toInstance).getDocentID() + ") does not exist");
            return;
        }   
        
        String query = "UPDATE " + sTableName + " ";
        query += "SET cursusNaam = '" + ((Cursus)toInstance).getCursusNaam() + "' ";
        query += ", beschrijving = '" + ((Cursus)toInstance).getBeschrijving() + "'";
        query += ", doelGroep = '" + ((Cursus)toInstance).getDoelGroep() + "'";
        query += ", startDatum = '" + ((Cursus)toInstance).getStartDatum() + "'";
        query += ", dag = '" + ((Cursus)toInstance).getDag() + "'";
        query += ", tijd = '" + ((Cursus)toInstance).getTijd() + "'";
        query += ", duur = " + ((Cursus)toInstance).getDuur() + "";
        query += ", frequentie = '" + ((Cursus)toInstance).getFrequentie() + "'";
        query += ", lesAantal = " + ((Cursus)toInstance).getLesAantal() + "";
        query += ", lesPrijs = " + ((Cursus)toInstance).getLesPrijs() + "";
        query += ", categorieID = " + ((Cursus)toInstance).getCategorieID() + "";
        query += ", docentID = " + ((Cursus)toInstance).getDocentID() + "";
        query += " WHERE cursusID = " + ((Cursus) fromInstance).getCursusID() + " ;";
        
        database.connect();
        database.executeQuery(query);
        database.close();
    }
    
    @Override
    public void deleteSpecificData(Object instance)
    {
        if(instance instanceof Cursus)
            this.Delete("cursusID = " + ((Cursus) instance).getCursusID());
        else if(instance instanceof Docent)
        {
            DatabaseHandlers.dbDocent.select("docentID=" + ((Docent) instance).getDocentID() + "");
            if(DatabaseHandlers.dbDocent.getResults().length <= 0)
            {
                StandardDebugActions.error("DBCursus.deleteSpecificData: foreign key 'FK_Cursus_Docent' (docentID " + ((Docent) instance).getDocentID() + ") does not exists");
                return;
            }          
            this.Delete("docentID = " + ((Docent) instance).getDocentID());
        }            
        else if(instance instanceof Cursuscategorie)
        {
            DatabaseHandlers.dbCursusCategorie.select("categorieID=" + ((Cursuscategorie) instance).getCategorieID() + "");
            if(DatabaseHandlers.dbCursusCategorie.getResults().length <= 0)
            {
                StandardDebugActions.error("DBCursus.deleteSpecificData: foreign key 'FK_Cursus_Cursuscategorie' (categorieID " + ((Cursuscategorie) instance).getCategorieID() + ") does not exists");
                return;
            } 
            this.Delete("categorieID = " + ((Cursuscategorie) instance).getCategorieID());
        }          
    }
}
