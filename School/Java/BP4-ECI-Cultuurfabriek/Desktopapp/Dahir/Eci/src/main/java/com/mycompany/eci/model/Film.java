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
public class Film {
    
    private Integer eventId = null;
    private String filmNaam = null;
    private String land = null;
    private String regisseur = null;
    private String filmGenre = null;
    private String duur = null;
    private String beschrijving = null;


public Film(){

}

public Film(Integer eventId, String filmNaam, String land, String regisseur, String filmGenre, String duur, String beschrijving){

    this.eventId = eventId;
    this.filmNaam = filmNaam;
    this.land = land;
    this.regisseur = regisseur;
    this.filmGenre = filmGenre;
    this.duur = duur;
    this.beschrijving = beschrijving;
}

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getFilmNaam() {
        return filmNaam;
    }

    public void setFilmNaam(String filmNaam) {
        this.filmNaam = filmNaam;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
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