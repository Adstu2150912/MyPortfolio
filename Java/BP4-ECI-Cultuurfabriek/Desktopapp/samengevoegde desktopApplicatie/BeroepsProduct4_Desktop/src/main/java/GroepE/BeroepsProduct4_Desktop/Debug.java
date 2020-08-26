/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursus;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursuscategorie;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Docent;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Reservering;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Film;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Klantinlog;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Muziek;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Theater;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Parkeren;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author swkoe
 */
public class Debug
{
    public static void testDatabase()
    {
//        testEmails();
//        testGebruikers();
//        testReserveringen();
//        testDBCursusCategorie();
//        testDBDocent();
//        testDBCursus();
        testDBFilm();
//        testDBMuziek();
//        testDBTheater();
//        testKlantinlog();
//        testDBParkeren();
        
    }
    
    public static void testDBParkeren(){
        Parkeren[] parkeren = new Parkeren[5];
        parkeren[0] = new Parkeren("test1", new Date (2020,1,1), "15","rolstoel");
        parkeren[1] = new Parkeren("test2", new Date (2020,1,1), "16","");
        parkeren[2] = new Parkeren("test3", new Date (2020,1,1), "17","kruiwagen");
        parkeren[3] = new Parkeren("test4", new Date (2020,1,1), "1118","slecht te been");
        parkeren[4] = new Parkeren("test5", new Date (2020,1,1), "1915","");
        
        DatabaseHandlers.dbparkeren.DeleteAll();
        DatabaseHandlers.dbparkeren.insertDataIntoTable(parkeren);
        DatabaseHandlers.dbparkeren.selectAll();
        for(Object instance : DatabaseHandlers.dbparkeren.getResults())
        {
            System.out.println( "Datum: " + ((Parkeren) instance).getsDate() + " Plek: " + ((Parkeren) instance).getsParkeerplek() + " Opmerking: " + ((Parkeren) instance).getsOpmerking());
        }
        
        System.out.println("******************************************************************************");
        
        DatabaseHandlers.dbparkeren.deleteSpecificData(parkeren[1]);
        DatabaseHandlers.dbparkeren.selectAll();
        for(Object instance : DatabaseHandlers.dbparkeren.getResults())
        {
            System.out.println( "Datum: " + ((Parkeren) instance).getsDate() + " Plek: " + ((Parkeren) instance).getsParkeerplek() + " Opmerking: " + ((Parkeren) instance).getsOpmerking());
        }
        System.out.println("******************************************************************************");
        
        Parkeren parkeren1Update = new Parkeren(parkeren[0].getsEML(), parkeren[0].getsDate(), parkeren[0].getsParkeerplek(), parkeren[0].getsOpmerking());
        parkeren1Update.setsEML("test2");
        parkeren1Update.setsDate(new Date (2020,1,1));
        parkeren1Update.setsParkeerplek("12");
        parkeren1Update.setsOpmerking("Slechte te lopen");

        DatabaseHandlers.dbparkeren.UpdateDataIntoTable(parkeren[0], parkeren1Update);
        DatabaseHandlers.dbparkeren.selectAll();
        for(Object instance : DatabaseHandlers.dbparkeren.getResults())
        {
            System.out.println( "Datum: " + ((Parkeren) instance).getsDate() + " Plek: " + ((Parkeren) instance).getsParkeerplek() + " Opmerking: " + ((Parkeren) instance).getsOpmerking());
        }
    }
    
    public static void testKlantinlog()
    {
//  
        Klantinlog[] klanten = new Klantinlog[5];
        klanten[0] = new Klantinlog("test1", "piet", "koter");
        klanten[1] = new Klantinlog("test2", "paat", "poter");
        klanten[2] = new Klantinlog("test3", "paaat", "stoter");
        klanten[3] = new Klantinlog("test4", "baat", "moter");
        klanten[4] = new Klantinlog("test5", "beer", "peer");
        
        DatabaseHandlers.dbKlantinlog.DeleteAll();
        DatabaseHandlers.dbKlantinlog.insertDataIntoTable(klanten);
        DatabaseHandlers.dbKlantinlog.selectAll();
        for(Object instance : DatabaseHandlers.dbKlantinlog.getResults())
        {
            System.out.println( "inlognaam: " + ((Klantinlog) instance).getsInlognaam() + " wachtwoord: " + ((Klantinlog) instance).getsWachtwoord());
        }
        
        System.out.println("******************************************************************************");
        
        DatabaseHandlers.dbKlantinlog.deleteSpecificData(klanten[1]);
        DatabaseHandlers.dbKlantinlog.selectAll();
        for(Object instance : DatabaseHandlers.dbKlantinlog.getResults())
        {
            System.out.println( "inlognaam: " + ((Klantinlog) instance).getsInlognaam() + " wachtwoord: " + ((Klantinlog) instance).getsWachtwoord());
        }
        
        System.out.println("******************************************************************************");
        
        Klantinlog klanten1Update = new Klantinlog(klanten[0].getsEML(), klanten[0].getsInlognaam(), klanten[0].getsWachtwoord());
        klanten1Update.setsEML("test2");
        klanten1Update.setsInlognaam("keesje");
        klanten1Update.setsWachtwoord("debugjecode");

        DatabaseHandlers.dbKlantinlog.UpdateDataIntoTable(klanten[0], klanten1Update);
        DatabaseHandlers.dbKlantinlog.selectAll();
        for(Object instance : DatabaseHandlers.dbKlantinlog.getResults())
        {
            System.out.println( "inlognaam: " + ((Klantinlog) instance).getsInlognaam() + " wachtwoord: " + ((Klantinlog) instance).getsWachtwoord());
        }
        System.out.println("******************************************************************************");
//        DatabaseHandlers.emails.DeleteAll();
//        DatabaseHandlers.emails.insertDataIntoTable(TestEmails);
//        DatabaseHandlers.emails.selectAll();
//        
//        for(Object instance : DatabaseHandlers.emails.getResults())
//        {
//            System.out.println(instance);
//        }
//        
//        DatabaseHandlers.emails.deleteSpecificData(TestEmails[0]);
//        DatabaseHandlers.emails.selectAll();
//        
//        
//        for(Object instance : DatabaseHandlers.emails.getResults())
//        {
//            System.out.println(instance);
//        }
//        
    }
    
    public static void testEmails()
    {
        String[] TestEmails = {"test6", "test7"};
//

//        DatabaseHandlers.emails.DeleteAll();
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
        testReserveringen[0] = new Reservering("test1", 2, 1);
        testReserveringen[1] = new Reservering("test2", 2, 1);
        testReserveringen[2] = new Reservering("test3", 2, 1);
        testReserveringen[3] = new Reservering("test4", 2, 1);
        testReserveringen[4] = new Reservering("test5", 2, 1);

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
    
    public static void testDBCursus()
    {
        Cursus[] testCursussen = new Cursus[5];
        testCursussen[0] = new Cursus(1, "*cursus1*", "*beschrijving1*", "*doelGroep1*", "2020-05-15", "vr", "17:55:00", 4, "Wekelijks 1 keer", 10, 1.23, 1, 1);
        testCursussen[1] = new Cursus(2, "*cursus2*", "*beschrijving2*", "*doelGroep2*", "2020-05-15", "vr", "17:57:00", 5, "Wekelijks 1 keer", 10, 2.23, 1, 2);
        testCursussen[2] = new Cursus(3, "*cursus3*", "*beschrijving3*", "*doelGroep3*", "2020-05-15", "vr", "17:58:00", 6, "Wekelijks 1 keer", 10, 3.23, 1, 3);
        testCursussen[3] = new Cursus(4, "*cursus4*", "*beschrijving4*", "*doelGroep4*", "2020-05-15", "vr", "17:59:00", 7, "Wekelijks 1 keer", 10, 4.23, 3, 1);
        testCursussen[4] = new Cursus(5, "*cursus5*", "*beschrijving5*", "*doelGroep5*", "2020-05-15", "vr", "18:00:00", 8, "Wekelijks 1 keer", 10, 5.23, 3, 2);

        DatabaseHandlers.dbCursus.DeleteAll();

        DatabaseHandlers.dbCursus.insertDataIntoTable(testCursussen);
        DatabaseHandlers.dbCursus.selectAll();


        for(Object instance : DatabaseHandlers.dbCursus.getResults())
        {
            System.out.print(    "variable cursusID : " + ((Cursus)instance).getCursusID());
            System.out.print(    "      variable cursusNaam : " + ((Cursus)instance).getCursusNaam());
            System.out.println(  "      variable lesPrijs : " + ((Cursus)instance).getLesPrijs());
        }
        
        testCursussen[1] = testCursussen[0];
        testCursussen[1].setLesPrijs(98.65);
        testCursussen[1].setCursusID(5);
        
        DatabaseHandlers.dbCursus.insertDataIntoTable(testCursussen[0]);
        DatabaseHandlers.dbCursus.UpdateDataIntoTable(testCursussen[0], testCursussen[1]);
        DatabaseHandlers.dbCursus.selectAll();

        for(Object instance : DatabaseHandlers.dbCursus.getResults())
        {
            System.out.print(    "variable cursusID : " + ((Cursus)instance).getCursusID());
            System.out.print(    "      variable cursusNaam : " + ((Cursus)instance).getCursusNaam());
            System.out.println(  "      variable lesPrijs : " + ((Cursus)instance).getLesPrijs());
        }
        
        DatabaseHandlers.dbCursus.deleteSpecificData(testCursussen[1]);
        DatabaseHandlers.dbCursus.selectAll();

        for(Object instance : DatabaseHandlers.dbCursus.getResults())
        {
            System.out.print(    "variable cursusID : " + ((Cursus)instance).getCursusID());
            System.out.print(    "      variable cursusNaam : " + ((Cursus)instance).getCursusNaam());
            System.out.println(  "      variable lesPrijs : " + ((Cursus)instance).getLesPrijs());
        }
    }
    
    public static void testDBDocent()
    {
        Docent[] testDocenten = new Docent[5];
        testDocenten[0] = new Docent(1, "*docent1*", "*beschrijving1*", "*discipline1*");
        testDocenten[1] = new Docent(2, "*docent2*", "*beschrijving2*", "*discipline2*");
        testDocenten[2] = new Docent(3, "*docent3*", "*beschrijving3*", "*discipline3*");
        testDocenten[3] = new Docent(4, "*docent4*", "*beschrijving4*", "*discipline4*");
        testDocenten[4] = new Docent(5, "*docent5*", "*beschrijving5*", "*discipline5*");

        for(Docent x : testDocenten)
        {
            DatabaseHandlers.dbCursus.deleteSpecificData(x);
        }
        
        DatabaseHandlers.dbDocent.DeleteAll();
        
        for(Docent x : testDocenten)
        {
            DatabaseHandlers.dbDocent.insertDataIntoTable(x);
        }

        DatabaseHandlers.dbDocent.selectAll();

        for(Object instance : DatabaseHandlers.dbDocent.getResults())
        {
            System.out.print(    "variable docentID : " + ((Docent)instance).getDocentID());
            System.out.print(    "      variable docentNaam : " + ((Docent)instance).getDocentNaam());
            System.out.println(  "      variable discipline : " + ((Docent)instance).getDiscipline());
        }
        
        testDocenten[1] = testDocenten[0];
        testDocenten[1].setDiscipline("*discipline123*");
        testDocenten[1].setDocentID(5);
        
        DatabaseHandlers.dbDocent.insertDataIntoTable(testDocenten[0]);
        DatabaseHandlers.dbDocent.UpdateDataIntoTable(testDocenten[0], testDocenten[1]);
        DatabaseHandlers.dbDocent.selectAll();


        for(Object instance : DatabaseHandlers.dbDocent.getResults())
        {
            System.out.print(    "variable docentID : " + ((Docent)instance).getDocentID());
            System.out.print(    "      variable docentNaam : " + ((Docent)instance).getDocentNaam());
            System.out.println(  "      variable discipline : " + ((Docent)instance).getDiscipline());
        }
        
        DatabaseHandlers.dbDocent.deleteSpecificData(testDocenten[1]);
        DatabaseHandlers.dbDocent.selectAll();


        for(Object instance : DatabaseHandlers.dbDocent.getResults())
        {
            System.out.print(    "variable docentID : " + ((Docent)instance).getDocentID());
            System.out.print(    "      variable docentNaam : " + ((Docent)instance).getDocentNaam());
            System.out.println(  "      variable discipline : " + ((Docent)instance).getDiscipline());
        }
    }
    
    public static void testDBCursusCategorie()
    {
        Cursuscategorie[] testCursusCategorien = new Cursuscategorie[5];
        testCursusCategorien[0] = new Cursuscategorie(1, "*subCategorie1*", "*categorieNaam1*", "*omschrijving1*");
        testCursusCategorien[1] = new Cursuscategorie(2, "*subCategorie2*", "*categorieNaam2*", "*omschrijving2*");
        testCursusCategorien[2] = new Cursuscategorie(3, "*subCategorie3*", "*categorieNaam3*", "*omschrijving3*");
        testCursusCategorien[3] = new Cursuscategorie(4, "*subCategorie4*", "*categorieNaam4*", "*omschrijving4*");
        testCursusCategorien[4] = new Cursuscategorie(5, "*subCategorie5*", "*categorieNaam5*", "*omschrijving5*");

        for(Cursuscategorie x : testCursusCategorien)
        {
            DatabaseHandlers.dbCursus.deleteSpecificData(x);
        }
        
        DatabaseHandlers.dbCursusCategorie.DeleteAll();
        
        for(Cursuscategorie x : testCursusCategorien)
        {
            DatabaseHandlers.dbCursusCategorie.insertDataIntoTable(x);
        }

        DatabaseHandlers.dbCursusCategorie.selectAll();

        for(Object instance : DatabaseHandlers.dbCursusCategorie.getResults())
        {
            System.out.print(    "variable categorieID : " + ((Cursuscategorie)instance).getCategorieID());
            System.out.print(    "      variable catergorieNaam : " + ((Cursuscategorie)instance).getCategorieNaam());
            System.out.println(    "      variable subCategorieNaam : " + ((Cursuscategorie)instance).getSubCategorie());
        }
        
        testCursusCategorien[1] = testCursusCategorien[0];
        testCursusCategorien[1].setSubCategorie("*subCategorie123*");
        testCursusCategorien[1].setCategorieID(5);
        
        DatabaseHandlers.dbCursusCategorie.insertDataIntoTable(testCursusCategorien[0]);
        DatabaseHandlers.dbCursusCategorie.UpdateDataIntoTable(testCursusCategorien[0], testCursusCategorien[1]);
        DatabaseHandlers.dbCursusCategorie.selectAll();


        for(Object instance : DatabaseHandlers.dbCursusCategorie.getResults())
        {
            System.out.print(    "variable categorieID : " + ((Cursuscategorie)instance).getCategorieID());
            System.out.print(    "      variable catergorieNaam : " + ((Cursuscategorie)instance).getCategorieNaam());
            System.out.println(    "      variable subCategorieNaam : " + ((Cursuscategorie)instance).getSubCategorie());
        }
        
        DatabaseHandlers.dbCursusCategorie.deleteSpecificData(testCursusCategorien[1]);
        DatabaseHandlers.dbCursusCategorie.selectAll();


        for(Object instance : DatabaseHandlers.dbCursusCategorie.getResults())
        {
            System.out.print(    "variable categorieID : " + ((Cursuscategorie)instance).getCategorieID());
            System.out.print(    "      variable catergorieNaam : " + ((Cursuscategorie)instance).getCategorieNaam());
            System.out.println(    "      variable subCategorieNaam : " + ((Cursuscategorie)instance).getSubCategorie());
        }
    }
    
    public static void testDBFilm()
    {
        Film[] testFilms = new Film[5];
        testFilms[0] = new Film(1, "Filmnaam1", "Land1", "Regisseur1 ", "Filmgenre1","Duur1", "Beschrijving1");
        testFilms[1] = new Film(2, "Filmnaam2", "Land2", "Regisseur2 ", "Filmgenre2","Duur2", "Beschrijving2");
        testFilms[2] = new Film(3, "Filmnaam3", "Land3", "Regisseur3 ", "Filmgenre3","Duur3", "Beschrijving3");
        testFilms[3] = new Film(4, "Filmnaam4", "Land4", "Regisseur4 ", "Filmgenre4","Duur4", "Beschrijving4");
        testFilms[4] = new Film(5, "Filmnaam5", "Land5", "Regisseur5 ", "Filmgenre5","Duur5", "Beschrijving5");
        
        
        DatabaseHandlers.dbFilm.DeleteAll();

        DatabaseHandlers.dbFilm.insertDataIntoTable(testFilms);
        DatabaseHandlers.dbFilm.selectAll();


        for(Object instance : DatabaseHandlers.dbFilm.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Film)instance).getEventid());
            System.out.print(  "      variable filmNaam : " + ((Film)instance).getFilmNaam());
            System.out.print(  "      variable land : " + ((Film)instance).getLand());
            System.out.print(  "      variable regisseur : " + ((Film)instance).getRegisseur());
            System.out.print(  "      variable filmGenre : " + ((Film)instance).getFilmGenre());
            System.out.print(  "      variable duur : " + ((Film)instance).getDuur());
            System.out.println("      variable beschrijving : " + ((Film)instance).getBeschrijving());

        }

        testFilms[1] = testFilms[0];
        testFilms[1].setFilmNaam("Badboys II");

        DatabaseHandlers.dbFilm.UpdateDataIntoTable(testFilms[0], testFilms[1]);
        DatabaseHandlers.dbFilm.selectAll();


        for(Object instance : DatabaseHandlers.dbFilm.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Film)instance).getEventid());
            System.out.print(  "      variable filmNaam : " + ((Film)instance).getFilmNaam());
            System.out.print(  "      variable land : " + ((Film)instance).getLand());
            System.out.print(  "      variable regisseur : " + ((Film)instance).getRegisseur());
            System.out.print(  "      variable filmGenre : " + ((Film)instance).getFilmGenre());
            System.out.print(  "      variable duur : " + ((Film)instance).getDuur());
            System.out.println("      variable beschrijving : " + ((Film)instance).getBeschrijving());

        }
        
        DatabaseHandlers.dbFilm.deleteSpecificData(testFilms[0]);
        DatabaseHandlers.dbFilm.selectAll();


        for(Object instance : DatabaseHandlers.dbFilm.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Film)instance).getEventid());
            System.out.print(  "      variable filmNaam : " + ((Film)instance).getFilmNaam());
            System.out.print(  "      variable land : " + ((Film)instance).getLand());
            System.out.print(  "      variable regisseur : " + ((Film)instance).getRegisseur());
            System.out.print(  "      variable filmGenre : " + ((Film)instance).getFilmGenre());
            System.out.print(  "      variable duur : " + ((Film)instance).getDuur());
            System.out.println("      variable beschrijving : " + ((Film)instance).getBeschrijving());

        }
        

    }
    
    public static void testDBMuziek()
    {
        Muziek[] testMuziek = new Muziek[5];
        testMuziek[0] = new Muziek(1, "Evenementnaam1", "Artiest1", "Muziekgenre1 ", "Zaal1","Beschrijving1");
        testMuziek[1] = new Muziek(2, "Evenementnaam2", "Artiest2", "Muziekgenre2 ", "Zaal2","Beschrijving2");
        testMuziek[2] = new Muziek(3, "Evenementnaam3", "Artiest3", "Muziekgenre3 ", "Zaal3","Beschrijving3");
        testMuziek[3] = new Muziek(4, "Evenementnaam4", "Artiest4", "Muziekgenre4 ", "Zaal4","Beschrijving4");
        testMuziek[4] = new Muziek(5, "Evenementnaam5", "Artiest5", "Muziekgenre5 ", "Zaal5","Beschrijving5");
        
        
        DatabaseHandlers.dbMuziek.DeleteAll();

        DatabaseHandlers.dbMuziek.insertDataIntoTable(testMuziek);
        DatabaseHandlers.dbMuziek.selectAll();


        for(Object instance : DatabaseHandlers.dbMuziek.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Muziek)instance).getEventid());
            System.out.print(  "      variable evenementNaam : " + ((Muziek)instance).getEvenementNaam());
            System.out.print(  "      variable artiest : " + ((Muziek)instance).getArtiest());
            System.out.print(  "      variable muziekGenre : " + ((Muziek)instance).getMuziekGenre());
            System.out.print(  "      variable zaal : " + ((Muziek)instance).getZaal());
            System.out.println("      variable beschrijving : " + ((Muziek)instance).getBeschrijving());

        }

        testMuziek[1] = testMuziek[0];
        testMuziek[1].setEvenementNaam("Disco Party");

        DatabaseHandlers.dbMuziek.UpdateDataIntoTable(testMuziek[0], testMuziek[1]);
        DatabaseHandlers.dbMuziek.selectAll();


        for(Object instance : DatabaseHandlers.dbMuziek.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Muziek)instance).getEventid());
            System.out.print(  "      variable evenementNaam : " + ((Muziek)instance).getEvenementNaam());
            System.out.print(  "      variable artiest : " + ((Muziek)instance).getArtiest());
            System.out.print(  "      variable muziekGenre : " + ((Muziek)instance).getMuziekGenre());
            System.out.print(  "      variable zaal : " + ((Muziek)instance).getZaal());
            System.out.println("      variable beschrijving : " + ((Muziek)instance).getBeschrijving());

        }
        
        DatabaseHandlers.dbMuziek.deleteSpecificData(testMuziek[0]);
        DatabaseHandlers.dbMuziek.selectAll();


        for(Object instance : DatabaseHandlers.dbMuziek.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Muziek)instance).getEventid());
            System.out.print(  "      variable evenementNaam : " + ((Muziek)instance).getEvenementNaam());
            System.out.print(  "      variable artiest : " + ((Muziek)instance).getArtiest());
            System.out.print(  "      variable muziekGenre : " + ((Muziek)instance).getMuziekGenre());
            System.out.print(  "      variable zaal : " + ((Muziek)instance).getZaal());
            System.out.println("      variable beschrijving : " + ((Muziek)instance).getBeschrijving());

        }
        

    }
    
    public static void testDBTheater()
    {
        Theater[] testTheater = new Theater[5];
        testTheater[0] = new Theater(1, "Theaternaam1","Regisseur1 ", "Theatergenre1","Duur1", "Beschrijving1");
        testTheater[1] = new Theater(2, "Theaternaam2","Regisseur2 ", "Theatergenre2","Duur2", "Beschrijving2");
        testTheater[2] = new Theater(3, "Theaternaam3","Regisseur3 ", "Theatergenre3","Duur3", "Beschrijving3");
        testTheater[3] = new Theater(4, "Theaternaam4","Regisseur4 ", "Theatergenre4","Duur4", "Beschrijving4");
        testTheater[4] = new Theater(5, "Theaternaam5","Regisseur5 ", "Theatergenre5","Duur5", "Beschrijving5");
        
        
        DatabaseHandlers.dbTheater.DeleteAll();

        DatabaseHandlers.dbTheater.insertDataIntoTable(testTheater);
        DatabaseHandlers.dbTheater.selectAll();


        for(Object instance : DatabaseHandlers.dbTheater.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Theater)instance).getEventid());
            System.out.print(  "      variable TheaterNaam : " + ((Theater)instance).getTheaterNaam());
            System.out.print(  "      variable regisseur : " + ((Theater)instance).getRegisseur());
            System.out.print(  "      variable TheaterGenre : " + ((Theater)instance).getTheaterGenre());
            System.out.print(  "      variable duur : " + ((Theater)instance).getDuur());
            System.out.println("      variable beschrijving : " + ((Theater)instance).getBeschrijving());

        }

        testTheater[1] = testTheater[0];
        testTheater[1].setTheaterNaam("Romeo en Julia");

        DatabaseHandlers.dbTheater.UpdateDataIntoTable(testTheater[0], testTheater[1]);
        DatabaseHandlers.dbTheater.selectAll();


        for(Object instance : DatabaseHandlers.dbTheater.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Theater)instance).getEventid());
            System.out.print(  "      variable TheaterNaam : " + ((Theater)instance).getTheaterNaam());
            System.out.print(  "      variable regisseur : " + ((Theater)instance).getRegisseur());
            System.out.print(  "      variable TheaterGenre : " + ((Theater)instance).getTheaterGenre());
            System.out.print(  "      variable duur : " + ((Theater)instance).getDuur());
            System.out.println("      variable beschrijving : " + ((Theater)instance).getBeschrijving());

        }
        
        DatabaseHandlers.dbTheater.deleteSpecificData(testTheater[0]);
        DatabaseHandlers.dbTheater.selectAll();


        for(Object instance : DatabaseHandlers.dbTheater.getResults())
        {
            System.out.print(  "      variable eventID : " + ((Theater)instance).getEventid());
            System.out.print(  "      variable TheaterNaam : " + ((Theater)instance).getTheaterNaam());
            System.out.print(  "      variable regisseur : " + ((Theater)instance).getRegisseur());
            System.out.print(  "      variable TheaterGenre : " + ((Theater)instance).getTheaterGenre());
            System.out.print(  "      variable duur : " + ((Theater)instance).getDuur());
            System.out.println("      variable beschrijving : " + ((Theater)instance).getBeschrijving());

        }
        

    }
    
}
