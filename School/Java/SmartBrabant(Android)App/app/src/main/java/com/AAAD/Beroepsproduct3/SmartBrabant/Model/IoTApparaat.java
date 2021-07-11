package com.AAAD.Beroepsproduct3.SmartBrabant.Model;
/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 12-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: IoTApparaat.java
 */
public class IoTApparaat
{
    private int IoTnummer, activiteitNummer;
    private String naam, dataSoort, plaatsNaam, activiteitNaam;

    public int getIoTnummer() {
        return IoTnummer;
    }

    public void setIoTnummer(int ioTnummer) {
        IoTnummer = ioTnummer;
    }

    public int getActiviteitNummer() {
        return activiteitNummer;
    }

    public void setActiviteitNummer(int activiteitNummer) {
        this.activiteitNummer = activiteitNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDataSoort() {
        return dataSoort;
    }

    public void setDataSoort(String dataSoort) {
        this.dataSoort = dataSoort;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    public String getActiviteitNaam() {
        return activiteitNaam;
    }

    public void setActiviteitNaam(String activiteitNaam) {
        this.activiteitNaam = activiteitNaam;
    }

    public IoTApparaat()
    {

    }
}
