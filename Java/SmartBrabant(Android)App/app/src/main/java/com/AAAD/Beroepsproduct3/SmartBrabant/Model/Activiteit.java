package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 12-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: Activiteit.java
 */
public class Activiteit
{
    private int activiteitNummer, IoTNummer;
    private String naam, maatFactor, prioriteit, plaatsNaam, dataSoort, IoTNaam;

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

    public String getMaatFactor() {
        return maatFactor;
    }

    public void setMaatFactor(String maatFactor) {
        this.maatFactor = maatFactor;
    }

    public String getPrioriteit() {
        return prioriteit;
    }

    public void setPrioriteit(String prioriteit) {
        this.prioriteit = prioriteit;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    public String getDataSoort() {
        return dataSoort;
    }

    public void setDataSoort(String dataSoort) {
        this.dataSoort = dataSoort;
    }

    public int getIoTNummer() {
        return IoTNummer;
    }

    public void setIoTNummer(int ioTNummer) {
        IoTNummer = ioTNummer;
    }

    public String getIoTNaam() {
        return IoTNaam;
    }

    public void setIoTNaam(String ioTNaam) {
        IoTNaam = ioTNaam;
    }

    public Activiteit()
    {

    }
}
