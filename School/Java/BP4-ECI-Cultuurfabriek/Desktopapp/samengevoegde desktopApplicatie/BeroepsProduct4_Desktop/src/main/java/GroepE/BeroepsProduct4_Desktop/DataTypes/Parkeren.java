/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.DataTypes;

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

    public Parkeren(String test3, String paaat, String stoter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
