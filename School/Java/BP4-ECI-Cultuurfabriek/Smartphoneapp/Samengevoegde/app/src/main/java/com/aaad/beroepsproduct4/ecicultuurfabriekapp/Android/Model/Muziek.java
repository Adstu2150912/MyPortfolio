package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

public class Muziek {

    private Integer eventid = null;
    private String evenementNaam = null;
    private String artiest = null;
    private String muziekGenre = null;
    private String zaal = null;
    private String beschrijving = null;


    public Muziek(){

    }

    public Muziek(Integer eventid, String evenementNaam, String artiest, String muziekGenre, String zaal, String beschrijving){

        this.eventid = eventid;
        this.evenementNaam = evenementNaam;
        this.artiest = artiest;
        this.muziekGenre = muziekGenre;
        this.zaal = zaal;
        this.beschrijving = beschrijving;

    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getEvenementNaam() {
        return evenementNaam;
    }

    public void setEvenementNaam(String evenementNaam) {
        this.evenementNaam = evenementNaam;
    }

    public String getArtiest() {
        return artiest;
    }

    public void setArtiest(String artiest) {
        this.artiest = artiest;
    }

    public String getMuziekGenre() {
        return muziekGenre;
    }

    public void setMuziekGenre(String muziekGenre) {
        this.muziekGenre = muziekGenre;
    }

    public String getZaal() {
        return zaal;
    }

    public void setZaal(String zaal) {
        this.zaal = zaal;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }


}


