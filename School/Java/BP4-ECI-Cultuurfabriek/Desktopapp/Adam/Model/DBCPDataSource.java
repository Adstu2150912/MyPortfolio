package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Model;

import java.sql.*;
//import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 06-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: DBCPDataSource.java
 */

public class DBCPDataSource 
{	
    private static Connection myConnection;
    
    public static Connection getConnection() throws SQLException
    {
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://172.104.237.208:3306/beroepsProduct4", "PROJECT", "Administrator1!");
            //Onderstaande inloggegevens moeten nog in de clientside vercijferd worden
            //en pas in de serverside ontcijferd worden!!        
//            ds.setUrl("jdbc:mysql://172.104.237.208:3306/beroepsProduct4?useSSL=false");
//            ds.setUsername("PROJECT");
//            ds.setPassword("Administrator1!");
//            ds.setMinIdle(5);
//            ds.setMaxIdle(10);
//            ds.setMaxOpenPreparedStatements(100);
        }
        catch(Exception e)
        {
        }
                
        return myConnection;
    }
	
    public DBCPDataSource()
    {

    }
}
