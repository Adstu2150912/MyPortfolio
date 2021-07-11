/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

import android.util.Log;

import java.sql.SQLException;

/**
 *
 * @author swkoe
 */
public class StandardDebugActions
{
    
    public static void error(String sOutput)
    {
        Log.d("Debugger", sOutput);
    }
    
    public static void error(Exception sOutput)
    {
        Log.d("Debugger", sOutput.getMessage());
    } 
    
    public static void error(SQLException sOutput)
    {
        Log.d("Debugger", sOutput.getMessage());
    }

}
