/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eci.model;

/**
 *
 * @author dahir
 */
public class Theater {
    
    private Integer eventId;
    private String theaterNaam;
    private String regisseur;
    private String theaterGenre;
    private String duur;
    private String beschrijving;
    
    
    public Theater(){
        
    }
    
    public Theater(Integer eventId, String theaterNaam, String regisseur, String theaterGenre, String duur, String beschrijving){
        
        this.eventId = eventId;
        this.theaterNaam = theaterNaam;
        this.regisseur = regisseur;
        this.theaterGenre = theaterGenre;
        this.duur = duur;
        this.beschrijving = beschrijving;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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
