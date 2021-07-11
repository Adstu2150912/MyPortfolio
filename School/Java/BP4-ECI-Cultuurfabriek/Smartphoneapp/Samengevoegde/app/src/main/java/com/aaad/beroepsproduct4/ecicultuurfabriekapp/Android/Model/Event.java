package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

/**
 *
 * @author akina
 */
public class Event {

    private int eventid;
    private String omschrijving;
    private String datum;
    private String tijd;
    private double prijs;

    public Event() {

    }

    public Event(int eventid, String omschrijving, String datum, String tijd, double prijs) {
        this.eventid = eventid;
        this.omschrijving = omschrijving;
        this.datum = datum;
        this.tijd = tijd;
        this.prijs = prijs;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }


}