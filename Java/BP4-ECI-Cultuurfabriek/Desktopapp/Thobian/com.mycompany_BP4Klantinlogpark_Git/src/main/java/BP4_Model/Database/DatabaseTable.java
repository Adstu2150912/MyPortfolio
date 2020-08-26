/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BP4_Model.Database;

import BP4_Model.StandardDebugActions;
import java.sql.ResultSet;

/**
 *
 * @author Thobi
 */
public abstract class DatabaseTable
{
    protected String sTableName;
    protected DatabaseConnection database;
    protected boolean initialized = false;
    
    public abstract void fillDataFromResultSet(ResultSet data);
    public abstract void insertDataIntoTable(Object instance);
    public abstract void UpdateDataIntoTable(Object fromInstance, Object toInstance);
    public abstract void deleteSpecificData(Object instance);
    
    public void insertDataIntoTable(Object[] instances)
    {
        for(Object instance : instances)
        {
            insertDataIntoTable(instance);
        }
    }

    
    public void selectAll()
    {
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        database.connect();
        database.readQuery("SELECT * FROM " + sTableName + ";");
        ResultSet data = database.getResult();
        fillDataFromResultSet(data);
        database.close();
    }

    public void select(String sCondition)
    {
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        database.connect();
        database.readQuery("SELECT * FROM " + sTableName + " WHERE " + sCondition + ";");
        ResultSet data = database.getResult();
        fillDataFromResultSet(data);
        database.close();
    }

    public void DeleteAll()
    {
        
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        database.connect();
        database.executeQuery("DELETE FROM " + sTableName + ";");
        database.close();
//        initialized = database.isConnected();
    }
    
    public void Delete(String sCondition)
    {
        
        if(!initialized)
        {
            StandardDebugActions.error("Not initialized");
            return;
        }
        
        database.connect();
        database.executeQuery("DELETE FROM " + sTableName + " WHERE " + sCondition + ";");
        database.close();
        
    }
 
    protected void setDatabase(DatabaseConnection setDatabase)
    {
        database = setDatabase;
        database.connect();
        initialized = database.isConnected();
        database.close();
        
    }
    
    public void close()
    {
        database.close();
        initialized = false;
    }
}
