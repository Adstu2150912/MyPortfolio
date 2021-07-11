/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BP4_Model.Database;

import BP4_Model.StandardDebugActions;
import java.sql.*;


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
            myConnection = DriverManager.getConnection(sAddressIP, sUsername, sPassword);
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
        catch (Exception e)
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
            myConnection.close();
            isConnected = false;
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
            isConnected = false;
        }
    }

}