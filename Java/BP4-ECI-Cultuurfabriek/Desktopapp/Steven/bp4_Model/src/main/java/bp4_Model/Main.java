/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp4_Model;

import bp4_Model.DataTypes.Gebruiker;
import bp4_Model.DataTypes.Reservering;
import bp4_Model.Database.DatabaseConnection;
import bp4_Model.Database.Emails;
import bp4_Model.Database.Gebruikers;
import bp4_Model.Database.Reserveringen;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author swkoe
 */
public class Main
{

    /**
     *
     */
    
    public static void initialize()
    {
        DatabaseHandlers.connection     = new DatabaseConnection("jdbc:mysql://172.104.237.208:3306/beroepsProduct4", "PROJECT", "Administrator1!");
        DatabaseHandlers.emails         = new Emails(DatabaseHandlers.connection, "EMAIL");
        DatabaseHandlers.gebruikers     = new Gebruikers(DatabaseHandlers.connection, "GEBRUIKERS");
        DatabaseHandlers.reserveringen  = new Reserveringen(DatabaseHandlers.connection, "RESERVERINGEN");
    }
    
    public static void testDatabase()
    {
//        testEmails();
//        testGebruikers();
//        testReserveringen();
    }
    
    
    public static void testEmails()
    {
        String[] TestEmails = {"test6"};
//        DatabaseHandlers.emails.DeleteAll();
//
        DatabaseHandlers.emails.insertDataIntoTable(TestEmails);
        DatabaseHandlers.emails.selectAll();
        
        
        for(Object instance : DatabaseHandlers.emails.getResults())
        {
            System.out.println(instance);
        }
        
        DatabaseHandlers.emails.deleteSpecificData(TestEmails[0]);
        DatabaseHandlers.emails.selectAll();
        
        
        for(Object instance : DatabaseHandlers.emails.getResults())
        {
            System.out.println(instance);
        }
        
    }
    
    public static void testGebruikers()
    {
        Gebruiker[] testgebruikers = new Gebruiker[5];
        testgebruikers[0] = new Gebruiker("test1", "Test", "test", " ", "MAN", Date.valueOf(LocalDate.now()), "Tiel", "Test", "1", "12345421123", "987987987");
        testgebruikers[1] = new Gebruiker("test2", "Test", "test", " ", "MAN", Date.valueOf(LocalDate.now()), "Tiel", "Test", "1", "12345421123", "987987987");
        testgebruikers[2] = new Gebruiker("test3", "Test", "test", " ", "MAN", Date.valueOf(LocalDate.now()), "Tiel", "Test", "1", "12345421123", "987987987");
        testgebruikers[3] = new Gebruiker("test4", "Test", "test", " ", "MAN", Date.valueOf(LocalDate.now()), "Tiel", "Test", "1", "12345421123", "987987987");
        testgebruikers[4] = new Gebruiker("test5", "Test", "test", " ", "MAN", Date.valueOf(LocalDate.now()), "Tiel", "Test", "1", "12345421123", "987987987");
        
        DatabaseHandlers.gebruikers.DeleteAll();

        DatabaseHandlers.gebruikers.insertDataIntoTable(testgebruikers);
        DatabaseHandlers.gebruikers.selectAll();


        for(Object instance : DatabaseHandlers.gebruikers.getResults())
        {
            System.out.print(  "variable voornaam : " + ((Gebruiker)instance).getsVoornaam());
            System.out.print(  "      variable achternaam : " + ((Gebruiker)instance).getsAchternaam());
            System.out.print(  "      variable voorletters : " + ((Gebruiker)instance).getsVoorletters());
            System.out.print(  "      variable straatnaam : " + ((Gebruiker)instance).getsStraatNaam());
            System.out.print(  "      variable huisnummer : " + ((Gebruiker)instance).getsHuisnummer());
            System.out.println("      variable iban : " + ((Gebruiker)instance).getsIbanNummer());

        }

        testgebruikers[1] = testgebruikers[0];
        testgebruikers[1].setsAchternaam("BERNARD");

        DatabaseHandlers.gebruikers.UpdateDataIntoTable(testgebruikers[0], testgebruikers[1]);
        DatabaseHandlers.gebruikers.selectAll();


        for(Object instance : DatabaseHandlers.gebruikers.getResults())
        {
            System.out.print(  "variable voornaam : " + ((Gebruiker)instance).getsVoornaam());
            System.out.print(  "      variable achternaam : " + ((Gebruiker)instance).getsAchternaam());
            System.out.print(  "      variable voorletters : " + ((Gebruiker)instance).getsVoorletters());
            System.out.print(  "      variable straatnaam : " + ((Gebruiker)instance).getsStraatNaam());
            System.out.print(  "      variable huisnummer : " + ((Gebruiker)instance).getsHuisnummer());
            System.out.println("      variable iban : " + ((Gebruiker)instance).getsIbanNummer());

        }
        
        DatabaseHandlers.gebruikers.deleteSpecificData(testgebruikers[0]);
        DatabaseHandlers.gebruikers.selectAll();


        for(Object instance : DatabaseHandlers.gebruikers.getResults())
        {
            System.out.print(  "variable voornaam : " + ((Gebruiker)instance).getsVoornaam());
            System.out.print(  "      variable achternaam : " + ((Gebruiker)instance).getsAchternaam());
            System.out.print(  "      variable voorletters : " + ((Gebruiker)instance).getsVoorletters());
            System.out.print(  "      variable straatnaam : " + ((Gebruiker)instance).getsStraatNaam());
            System.out.print(  "      variable huisnummer : " + ((Gebruiker)instance).getsHuisnummer());
            System.out.println("      variable iban : " + ((Gebruiker)instance).getsIbanNummer());

        }
        

    }

    public static void testReserveringen()
    {
        Reservering[] testReserveringen = new Reservering[5];
        testReserveringen[0] = new Reservering("test1", 2, 2);
        testReserveringen[1] = new Reservering("test2", 2, 5);
        testReserveringen[2] = new Reservering("test3", 2, 5);
        testReserveringen[3] = new Reservering("test4", 2, 5);
        testReserveringen[4] = new Reservering("test5", 2, 5);

        DatabaseHandlers.reserveringen.DeleteAll();

        DatabaseHandlers.reserveringen.insertDataIntoTable(testReserveringen);
        DatabaseHandlers.reserveringen.selectAll();


        for(Object instance : DatabaseHandlers.reserveringen.getResults())
        {
            System.out.print(    "variable Email : " + ((Reservering)instance).getsEmail());
            System.out.print(    "      variable achternaam : " + ((Reservering)instance).getnAantalTickets());
            System.out.println(  "      variable voorletters : " + ((Reservering)instance).getnEventID());

        }
        
        testReserveringen[1] = testReserveringen[0];
        testReserveringen[1].setnAantalTickets(44);
        testReserveringen[1].setnEventID(5);
        
        DatabaseHandlers.reserveringen.insertDataIntoTable(testReserveringen[0]);
        DatabaseHandlers.reserveringen.UpdateDataIntoTable(testReserveringen[0], testReserveringen[1]);
        DatabaseHandlers.reserveringen.selectAll();


        for(Object instance : DatabaseHandlers.reserveringen.getResults())
        {
            System.out.print(    "variable Email : " + ((Reservering)instance).getsEmail());
            System.out.print(    "      variable achternaam : " + ((Reservering)instance).getnAantalTickets());
            System.out.println(  "      variable voorletters : " + ((Reservering)instance).getnEventID());

        }
        
        DatabaseHandlers.reserveringen.deleteSpecificData(testReserveringen[1]);
        DatabaseHandlers.reserveringen.selectAll();


        for(Object instance : DatabaseHandlers.reserveringen.getResults())
        {
            System.out.print(    "variable Email : " + ((Reservering)instance).getsEmail());
            System.out.print(    "      variable achternaam : " + ((Reservering)instance).getnAantalTickets());
            System.out.println(  "      variable voorletters : " + ((Reservering)instance).getnEventID());

        }
    }
    
    public static void main(String[] args)
    {

//        start reading database | 30s
//        staring application    | 15s
//        login                  | 10s

//        5s


        System.out.println("******************************************************START*******************************************************");
        initialize();
        testDatabase();
        System.out.println("*******************************************************END********************************************************");
        
    }
}