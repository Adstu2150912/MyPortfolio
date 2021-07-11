package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

import java.sql.Date;

/**
 *
 * @author Thobi
 */
public class Parkeren {
    private String sEML;
    private Date sDate;
    private String sParkeerplek;
    private String sOpmerking;

    public Parkeren(

            String sEML,
            Date sDate,
            String sParkeerplek,
            String sOpmerking

    ){
        this.sEML = sEML;
        this.sDate = sDate;
        this.sParkeerplek = sParkeerplek;
        this.sOpmerking = sOpmerking;
    }


    public String getsEML() {
        return sEML;
    }

    public Date getsDate() {
        return sDate;
    }

    public String getsParkeerplek() {
        return sParkeerplek;
    }

    public String getsOpmerking() {
        return sOpmerking;
    }

    public void setsEML(String sEML) {
        this.sEML = sEML;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public void setsParkeerplek(String sParkeerplek) {
        this.sParkeerplek = sParkeerplek;
    }

    public void setsOpmerking(String sOpmerking) {
        this.sOpmerking = sOpmerking;
    }
}
