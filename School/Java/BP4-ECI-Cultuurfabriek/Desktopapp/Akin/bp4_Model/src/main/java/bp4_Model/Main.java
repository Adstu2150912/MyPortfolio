package bp4_Model;

import View.BeheerderInlogScherm;
import bp4_Model.DataTypes.Beheerder;
import bp4_Model.Database.Beheerders;
import bp4_Model.Database.DatabaseConnection;
import bp4_Model.Database.Events;
import bp4_Model.Database.Exposities;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author akina
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void initialize() {
        DatabaseHandlers.connection = new DatabaseConnection("jdbc:mysql://172.104.237.208:3306/beroepsProduct4", "PROJECT", "Administrator1!");
        DatabaseHandlers.dbbeheerder = new Beheerders(DatabaseHandlers.connection, "Beheerder");
        DatabaseHandlers.dbevent = new Events(DatabaseHandlers.connection, "Event");
        DatabaseHandlers.dbexpositie = new Exposities(DatabaseHandlers.connection, "Expositie");
    }

    public static void testDatabase() {

//        testGebruikers();
//        testReserveringen();
    }

    public static void testBeheerders() {
        Beheerder[] testBeheerders = new Beheerder[5];
        testBeheerders[0] = new Beheerder("beheerder1", "Test1", "test1");
        testBeheerders[1] = new Beheerder("beheerder2", "Test2", "test2");
        testBeheerders[2] = new Beheerder("beheerder3", "Test3", "test3");
        testBeheerders[3] = new Beheerder("beheerder4", "Test4", "test4");
        testBeheerders[4] = new Beheerder("beheerder5", "Test5", "test5");

        DatabaseHandlers.dbbeheerder.DeleteAll();

        DatabaseHandlers.dbbeheerder.insertDataIntoTable(testBeheerders);
        DatabaseHandlers.dbbeheerder.selectAll();

        for (Object instance : DatabaseHandlers.dbbeheerder.getResults()) {
            System.out.print("variable beheerder : " + ((Beheerder) instance).getBeheerder());
            System.out.print("      variable gebruikersnaam : " + ((Beheerder) instance).getGebruikersnaam());
            System.out.print("      variable wachtwoord : " + ((Beheerder) instance).getWachtwoord());
        }

        testBeheerders[1] = testBeheerders[0];
        testBeheerders[1].setBeheerder("beheerdertest");

        DatabaseHandlers.dbbeheerder.UpdateDataIntoTable(testBeheerders[0], testBeheerders[1]);
        DatabaseHandlers.dbbeheerder.selectAll();

        for (Object instance : DatabaseHandlers.dbbeheerder.getResults()) {
            System.out.print("variable beheerder : " + ((Beheerder) instance).getBeheerder());
            System.out.print("      variable gebruikersnaam : " + ((Beheerder) instance).getGebruikersnaam());
            System.out.print("      variable wachtwoord : " + ((Beheerder) instance).getWachtwoord());

        }

        DatabaseHandlers.dbbeheerder.deleteSpecificData(testBeheerders[0]);
        DatabaseHandlers.dbbeheerder.selectAll();

        for (Object instance : DatabaseHandlers.dbbeheerder.getResults()) {
            System.out.print("variable voornaam : " + ((Beheerder) instance).getBeheerder());
            System.out.print("      variable achternaam : " + ((Beheerder) instance).getGebruikersnaam());
            System.out.print("      variable voorletters : " + ((Beheerder) instance).getWachtwoord());
          

        }

    }

    public void start(Stage mainStage){
        BeheerderInlogScherm beheerderInlogScherm = new BeheerderInlogScherm();
        Scene scene = new Scene(beheerderInlogScherm, 800, 800);
        mainStage.setScene(scene);
        mainStage.setTitle("ECI");
        mainStage.show();
    }

    public static void main(String[] args) {

//        start reading database | 30s
//        staring application    | 15s
//        login                  | 10s
//        5s
        System.out.println("******************************************************START*******************************************************");
        initialize();
        //testDatabase();
        launch(args);
        System.out.println("*******************************************************END********************************************************");

    }
}
