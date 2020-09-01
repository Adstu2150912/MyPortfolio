/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.Database;

import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author swkoe
 */
public class DatabaseConnection
{

    private String sAddressIP;
    private String sUsername;
    private String sPassword;
    private Connection myConnection;
    private ResultSet result;
    private boolean isConnected = false;
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    

    /**
     *
     * @param sAddressIP
     * @param sPassword
     */
    public DatabaseConnection(String sAddressIP, String sUsername, String sPassword)
    {
        this.sAddressIP = sAddressIP;
        this.sUsername = sUsername;
        this.sPassword = sPassword;
        try
        {
            myConnection = DriverManager.getConnection(sAddressIP, sUsername, sPassword);
        }
        catch (Exception ex)
        {

        }
    }

    public String getsUsername()
    {
        return sUsername;
    }

    public void setsUsername(String sUsername)
    {
        this.sUsername = sUsername;
    }

    public String getsAddressIP()
    {
        return sAddressIP;
    }

    public void setsAddressIP(String sAddressIP)
    {
        this.sAddressIP = sAddressIP;
    }

    public String getsPassword()
    {
        return sPassword;
    }

    public void setsPassword(String sPassword)
    {
        this.sPassword = sPassword;
    }

    public void connect()
    {
        try
        {
//            Class.forName(DRIVER);
            myConnection.beginRequest();
            isConnected = true;
            
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
            isConnected = false;
        }
    }

    public boolean isConnected()
    {
        return isConnected;
    }
    
    public void readQuery(String sOutput)
    {
        try
        {
//            Class.forName(driver);
            Statement myQuery = myConnection.createStatement();
            result = myQuery.executeQuery(sOutput);
        } 
        catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }

    public void executeQuery(String sOutput)
    {
        try
        {
//            Class.forName(driver);
            Statement myQuery = myConnection.createStatement();
            myQuery.execute(sOutput);
        } 
        catch (SQLException e)
        {
            StandardDebugActions.error(e);
        }
    }
    
    public ResultSet getResult()
    {
        return result;
    }

    public void close()
    {
        try
        {
            myConnection.endRequest();
            isConnected = false;
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
            isConnected = false;
        }
    }

    public void exit()
    {
        try
        {
            myConnection.close();
            isConnected = false;
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
            isConnected = false;
        }
    }
}
