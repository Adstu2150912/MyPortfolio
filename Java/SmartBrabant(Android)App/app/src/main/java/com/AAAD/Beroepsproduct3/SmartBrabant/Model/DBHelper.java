package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 12-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: DBHelper.java
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String dbNaam) {
        super(context, dbNaam, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTBPlaats = "CREATE TABLE Plaats " + "(" +
                "naam TEXT PRIMARY KEY, "
                + "gemeentelijkePopulatie INTEGER NOT NULL, "
                + " isSmart INTEGER NOT NULL, "
                + " oppervlakte REAL,"
                + " stedelijkePopulatie INTEGER,"
                + " metroPopulatie INTEGER, "
                + " gemeente TEXT NOT NULL "
                + ");";
        String createTBActiviteit = "CREATE TABLE Activiteit " + "(" +
                " naam TEXT NOT NULL ,"
                + " activiteitNummer INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " maatschappelijkeFactor TEXT NOT NULL, "
                + " prioriteit TEXT, "
                + " plaatsNaam TEXT NOT NULL, "
                + " dataSoort TEXT NOT NULL, "
                + " FOREIGN KEY (plaatsNaam) REFERENCES Plaats(naam) "
                + ");";
        String createTBIoTApparaat = "CREATE TABLE IoTapparaat " + "(" +
                " naam TEXT NOT NULL "
                + ", IoTnummer INTEGER PRIMARY KEY AUTOINCREMENT "
                + ", dataSoort TEXT NOT NULL "
                + ", plaatsNaam TEXT NOT NULL "
                + ", FOREIGN KEY (plaatsNaam) REFERENCES Plaats(naam) "
                + ");";
        String createTBBurger = "CREATE TABLE Burger ("
                + "BSNnummer INTEGER PRIMARY KEY "
                + ", naam TEXT NOT NULL "
                + ", tevredenheidPlaats TEXT NOT NULL "
                + ", plaatsNaam TEXT NOT NULL "
                + ", mening TEXT "
                + ", FOREIGN KEY (plaatsNaam) REFERENCES Plaats(naam) "
                + ");";
        String createTBAdvies = "CREATE TABLE Advies ("
                + "adviesNummer INTEGER PRIMARY KEY AUTOINCREMENT "
                + ", planVanAanpak TEXT NOT NULL "
                + ", plaatsNaam TEXT NOT NULL "
                + ", FOREIGN KEY (plaatsNaam) REFERENCES Plaats(naam) "
                + ");";
        String insertTBPlaats = "INSERT INTO Plaats\n" +
                "VALUES('Breda', 183873, 1, 128.7, 180420, 324812, 'Breda')\n" +
                ",('Tilburg', 217259, 1, 119.2, 233339, 300249, 'Tilburg')\n" +
                ",('Oosterhout', 55616, 0, 73.1, NULL, NULL, 'Oosterhout')\n" +
                ",('Eindhoven', 231642, 1, 88.9, 337487, 19045, 'Eindhoven')\n" +
                ",('s-Hertogenbosch', 154205, 1, 91.8, 169714, 198000, 's-Hertogenbosch')\n" +
                ",('Raamsdonksveer', 12345, 0, 17.4, NULL, NULL, 'Geertruidenberg');";
        String insertTBActiviteit = "INSERT INTO Activiteit(naam, maatschappelijkeFactor, prioriteit, plaatsNaam, dataSoort)\n" +
                "VALUES('criminaliteit', 'economisch', 'hoog', 'Tilburg', 'licht')\n" +
                ",('mileuvervuiling', 'milieu', 'middelmatig', 'Oosterhout', 'gas')\n" +
                ",('verkeersopstopping', 'verkeers', 'laag', 'Breda', 'gas')\n" +
                ",('geluidsoverlast', 'milieu', 'hoog', 'Tilburg', 'geluid')\n" +
                ",('conflict op terras', 'sociaal', 'hoog', 'Tilburg', 'licht')\n" +
                ",('geluidsoverlast', 'milieu', 'laag', 'Oosterhout', 'geluid')\n" +
                ",('criminaliteit', 'economisch', 'middelmatig', 'Oosterhout', 'licht');";
        String insertTBIoTApparaat = "INSERT INTO IoTapparaat(naam, dataSoort, plaatsNaam)\n" +
                "VALUES('MQ-3', 'geur', 's-Hertogenbosch')\n" +
                ",('MH-Z19', 'gas', 'Breda')\n" +
                ",('BMP280', 'geluid', 'Tilburg');";
        String insertTBBurger = "INSERT INTO Burger\n" +
                "VALUES(4792537, 'Jip', 0, 'Raamsdonksveer', NULL)\n" +
                ",(6550213, 'Janneke', 0, 'Oosterhout', NULL)\n" +
                ",(2525436,'Klaas', 1, 'Breda', NULL);";
        String insertTBAdvies = "INSERT INTO Advies(planVanAanpak, plaatsNaam)\n" +
                "VALUES('Uit de slimme technieken geluidsmeting, geurmeting en klimaatmeting, wordt geluidsmeting aangeraden toe te passen door gebruik te maken van IoT-apparaat MQ-3', 's-Hertogenbosch')\n" +
                ",('Uit de slimme technieken geluidsmeting, geurmeting en klimaatmeting, wordt klimaatmeting aangeraden toe te passen door gebruik te maken van IoT-apparaat MH-Z19', 'Breda')\n" +
                ",('\"Uit de slimme technieken geluidsmeting, geurmeting en klimaatmeting, wordt geurmeting aangeraden toe te passen door gebruik te maken van IoT-apparaat BMP280\"', 'Tilburg');";
        db.execSQL(createTBPlaats);
        db.execSQL(createTBActiviteit);
        db.execSQL(createTBIoTApparaat);
        db.execSQL(createTBBurger);
        db.execSQL(createTBAdvies);
        db.execSQL(insertTBPlaats);
        db.execSQL(insertTBActiviteit);
        db.execSQL(insertTBIoTApparaat);
        db.execSQL(insertTBBurger);
        db.execSQL(insertTBAdvies);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //@Override
    //public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    //    onCreate(db);
    //}

//    public boolean addProduct(Product p) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COL_PRODUCTNUMBER, p.getProductNumber());
//        values.put(COL_PRODUCTNAME, p.getProductName());
//        values.put(COL_PRODUCTPRICE, p.getProductPrice());
//        long result = db.insert(TABLE_NAME, null, values);
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }

    public Cursor getData(String sqlQuery) {
        SQLiteDatabase db = this.getWritableDatabase();
        //String query = "SELECT * FROM " + tabelNaam;
        Cursor cursor = db.rawQuery(sqlQuery, null);
        return cursor;
    }
}

