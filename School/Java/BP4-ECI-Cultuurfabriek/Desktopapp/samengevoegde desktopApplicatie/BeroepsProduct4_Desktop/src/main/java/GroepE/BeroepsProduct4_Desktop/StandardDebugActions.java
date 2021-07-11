/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop;

import java.sql.SQLException;

/**
 *
 * @author swkoe
 */
public class StandardDebugActions
{
    
    public static void println(String sOutput)
    {
        System.out.println(sOutput);
    }
    
    public static void error(String sOutput)
    {
        System.err.println(sOutput);
    }
    
    public static void error(Exception sOutput)
    {
        System.err.println(sOutput);
    } 
    
    public static void error(SQLException sOutput)
    {
        System.err.println(sOutput);
    }
}
