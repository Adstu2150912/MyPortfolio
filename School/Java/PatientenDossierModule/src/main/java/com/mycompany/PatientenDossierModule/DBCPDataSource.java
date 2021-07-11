package com.mycompany.PatientenDossierModule;

import java.sql.SQLException;
import java.sql.Connection;
import org.apache.commons.dbcp2.BasicDataSource;


/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 13-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: DBCPDataSource.java
 */
public class DBCPDataSource 
{
    private static BasicDataSource ds = new BasicDataSource();
    
    static
    {
        ds.setUrl("jdbc:mysql://localhost:3306/degraafschapdb?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("tre!h9587sty#e");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }
    
    public static Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }
    
    private DBCPDataSource()
    {
        
    }
}
