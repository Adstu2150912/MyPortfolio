package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

/**
 *
 * @author Thobi
 */
public class Klantinlog {
    private String sEML;
    private String sInlognaam;
    private String sWachtwoord;

    public Klantinlog(

            String sEMl,
            String sInlognaam,
            String sWachtwoord

    ){

        this.sEML = sEML;
        this.sInlognaam = sInlognaam;
        this.sWachtwoord = sWachtwoord;

    }


    public String getsEML() {
        return sEML;
    }

    public String getsInlognaam() {
        return sInlognaam;
    }

    public String getsWachtwoord() {
        return sWachtwoord;
    }

    public void setsEML(String sEML) {
        this.sEML = sEML;
    }

    public void setsInlognaam(String sInlognaam) {
        this.sInlognaam = sInlognaam;
    }

    public void setsWachtwoord(String sWachtwoord) {
        this.sWachtwoord = sWachtwoord;
    }
}