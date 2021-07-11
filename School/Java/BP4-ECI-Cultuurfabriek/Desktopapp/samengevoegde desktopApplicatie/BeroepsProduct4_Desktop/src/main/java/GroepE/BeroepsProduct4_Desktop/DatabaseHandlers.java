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
import GroepE.BeroepsProduct4_Desktop.Database.DBGebruikers;
import GroepE.BeroepsProduct4_Desktop.Database.DBReserveringen;
import GroepE.BeroepsProduct4_Desktop.Database.DBFilm;
import GroepE.BeroepsProduct4_Desktop.Database.DBMuziek;
import GroepE.BeroepsProduct4_Desktop.Database.DBTheater;
import GroepE.BeroepsProduct4_Desktop.Database.DBKlantinlog;
import GroepE.BeroepsProduct4_Desktop.Database.DBParkeren;



/**
 *
 * @author swkoe
 */
public class DatabaseHandlers
{
    public static DatabaseConnection connection;
    public static DBEmails emails;
    public static DBGebruikers gebruikers;
    public static DBReserveringen reserveringen; 
    public static DBCursus dbCursus;
    public static DBCursusCategorie dbCursusCategorie;
    public static DBDocent dbDocent;
    public static DBFilm dbFilm;
    public static DBMuziek dbMuziek;
    public static DBTheater dbTheater;
    public static DBBeheerder dbbeheerder;
    public static DBEvent dbevent;
    public static DBExpositie dbexpositie;
    public static DBKlantinlog dbKlantinlog;
    public static DBParkeren dbparkeren;
}
