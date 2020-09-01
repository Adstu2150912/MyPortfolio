/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop;

/**
 *
 * @author swkoe
 * 
 */
public class databaseThread extends Thread
{
    private static final int SECONDSTIMEOUT = 10;
    
    public String sFilmWhereClause = "";
    public String sTheaterWhereClause = "";
    public String sMuziekWhereClause = "";
    public String sCursusWhereClause = "";
    public String sExpoWhereClause = "";
    
    private boolean lRunning = true;
    
    
    public void forceUpdate()
    {
        lRunning = false;
    }
    
    
    @Override
    public void run()
    {
        while(PublicData.lActive == true)
        {
            StandardDebugActions.println("Database refresh");
            
            if(sFilmWhereClause.equalsIgnoreCase("")) DatabaseHandlers.dbFilm.selectAll();
            else DatabaseHandlers.dbFilm.select(sFilmWhereClause);
            
            if(sTheaterWhereClause.equalsIgnoreCase("")) DatabaseHandlers.dbTheater.selectAll();
            else DatabaseHandlers.dbTheater.select(sTheaterWhereClause);
            
            if(sMuziekWhereClause.equalsIgnoreCase("")) DatabaseHandlers.dbMuziek.selectAll();
            else DatabaseHandlers.dbMuziek.select(sMuziekWhereClause);
            
            if(sCursusWhereClause.equalsIgnoreCase("")) DatabaseHandlers.dbCursus.selectAll();
            else DatabaseHandlers.dbCursus.select(sCursusWhereClause);
            
            if(sExpoWhereClause.equalsIgnoreCase("")) DatabaseHandlers.dbexpositie.selectAll();
            else DatabaseHandlers.dbexpositie.select(sExpoWhereClause);

            lRunning = true;
            int i = 0;
            while(lRunning)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch(Exception ex)
                {
                    StandardDebugActions.error(ex);
                }

                if(i >= SECONDSTIMEOUT || PublicData.lActive == false)
                {
                    lRunning = false;
                }
                i++;

            }
        }
        
    }
}
