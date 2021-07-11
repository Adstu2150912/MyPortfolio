package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

public class Theater {

    private Integer eventid;
    private String theaterNaam;
    private String regisseur;
    private String theaterGenre;
    private String duur;
    private String beschrijving;


    public Theater(){

    }

    public Theater(Integer eventid, String theaterNaam, String regisseur, String theaterGenre, String duur, String beschrijving){

        this.eventid = eventid;
        this.theaterNaam = theaterNaam;
        this.regisseur = regisseur;
        this.theaterGenre = theaterGenre;
        this.duur = duur;
        this.beschrijving = beschrijving;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getTheaterNaam() {
        return theaterNaam;
    }

    public void setTheaterNaam(String theaterNaam) {
        this.theaterNaam = theaterNaam;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public String getTheaterGenre() {
        return theaterGenre;
    }

    public void setTheaterGenre(String theaterGenre) {
        this.theaterGenre = theaterGenre;
    }

    public String getDuur() {
        return duur;
    }

    public void setDuur(String duur) {
        this.duur = duur;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }


}
