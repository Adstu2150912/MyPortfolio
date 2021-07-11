/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop;

import GroepE.BeroepsProduct4_Desktop.Database.DBBeheerder;
import GroepE.BeroepsProduct4_Desktop.Database.DBCursus;
import GroepE.BeroepsProduct4_Desktop.Database.DBCursusCategorie;
import GroepE.BeroepsProduct4_Desktop.Database.DBDocent;
import GroepE.BeroepsProduct4_Desktop.Database.DatabaseConnection;
import GroepE.BeroepsProduct4_Desktop.Database.DBEmails;
import GroepE.BeroepsProduct4_Desktop.Database.DBEvent;
import GroepE.BeroepsProduct4_Desktop.Database.DBExpositie;
import GroepE.BeroepsProduct4_Desktop.Database.DBFilm;
import GroepE.BeroepsProduct4_Desktop.Database.DBGebruikers;
import GroepE.BeroepsProduct4_Desktop.Database.DBKlantinlog;
import GroepE.BeroepsProduct4_Desktop.Database.DBParkeren;
import GroepE.BeroepsProduct4_Desktop.Database.DBMuziek;
import GroepE.BeroepsProduct4_Desktop.Database.DBReserveringen;
import GroepE.BeroepsProduct4_Desktop.Database.DBTheater;
import GroepE.BeroepsProduct4_Desktop.View.BeheerderInlogScherm;
import GroepE.BeroepsProduct4_Desktop.View.HoofdScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author swkoe
 */
public class Main extends Application
{
    public static Pane root;// = new HoofdScherm();
    public static Stage thisStage;
    
    public static void initialize()
    {
        DatabaseHandlers.connection         = new DatabaseConnection("jdbc:mysql://172.104.237.208:3306/beroepsProduct4", "PROJECT", "Administrator1!");
        DatabaseHandlers.emails             = new DBEmails(DatabaseHandlers.connection, "EMAIL");
        DatabaseHandlers.gebruikers         = new DBGebruikers(DatabaseHandlers.connection, "GEBRUIKERS");
        DatabaseHandlers.reserveringen      = new DBReserveringen(DatabaseHandlers.connection, "RESERVERINGEN");
        DatabaseHandlers.dbCursus           = new DBCursus(DatabaseHandlers.connection, "Cursus");
        DatabaseHandlers.dbDocent           = new DBDocent(DatabaseHandlers.connection, "Docent");
        DatabaseHandlers.dbCursusCategorie  = new DBCursusCategorie(DatabaseHandlers.connection, "Cursuscategorie");
        DatabaseHandlers.dbFilm             = new DBFilm(DatabaseHandlers.connection, "Film");
        DatabaseHandlers.dbMuziek           = new DBMuziek(DatabaseHandlers.connection, "Muziek");
        DatabaseHandlers.dbTheater          = new DBTheater(DatabaseHandlers.connection, "Theater");
        DatabaseHandlers.dbevent            = new DBEvent(DatabaseHandlers.connection, "Event");
        DatabaseHandlers.dbbeheerder         = new DBBeheerder(DatabaseHandlers.connection, "Beheerder");
        DatabaseHandlers.dbexpositie        = new DBExpositie(DatabaseHandlers.connection, "Expositie");
        DatabaseHandlers.dbKlantinlog       = new DBKlantinlog(DatabaseHandlers.connection, "KlantInlog");
        DatabaseHandlers.dbparkeren         = new DBParkeren(DatabaseHandlers.connection,"Parkeren");
        
        Debug.testDatabase();
        
        PublicData.AutoDatabaseRefresh = new databaseThread();
        PublicData.AutoDatabaseRefresh.start();
        
//        ((databaseThread)PublicData.AutoDatabaseRefresh).sFilmWhereClause = "DATE > 2000/12/12"  + "AND" + "adawadsadaw";
//        ((databaseThread)PublicData.AutoDatabaseRefresh).forceUpdate();
//        
//        DatabaseHandlers.dbFilm.getResults();
    }
    
    public static void main(String[] args)
    {

//        start reading database | 30s
//        staring application    | 15s
//        login                  | 10s

//        5s
        
        System.out.println("******************************************************START*******************************************************");
        PublicData.lActive = true;
        initialize();
        launch(args);
        PublicData.lActive = false;
        System.out.println("*******************************************************END********************************************************");
    }
    
    public static void hardRefresh()
    {
        // roep dit niet zomaar aan
        
        Scene stage = new Scene(root, 1300, 1000);
        
        thisStage.setTitle("ECI culture");
        thisStage.setScene(stage);
        thisStage.show();
    }
    

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        root = new BeheerderInlogScherm();
        Scene stage = new Scene(root, 1300, 1000);
        
        primaryStage.setTitle("ECI culture");
        primaryStage.setScene(stage);
        primaryStage.show();
        thisStage = primaryStage;
    }
}