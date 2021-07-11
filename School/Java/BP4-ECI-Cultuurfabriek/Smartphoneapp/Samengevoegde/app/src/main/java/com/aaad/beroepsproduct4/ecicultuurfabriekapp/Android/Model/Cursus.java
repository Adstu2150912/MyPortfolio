package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 06-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: Cursus.java
 */

public class Cursus
{
    private Integer cursusID, duur, lesAantal, categorieID, docentID;
    private String cursusNaam, beschrijving, doelGroep, startDatum, dag, tijd, frequentie;
    private Double lesPrijs;

    public Integer getCursusID() {
        return cursusID;
    }

    public void setCursusID(Integer cursusID) {
        this.cursusID = cursusID;
    }

    public Integer getDuur() {
        return duur;
    }

    public void setDuur(Integer duur) {
        this.duur = duur;
    }

    public Integer getLesAantal() {
        return lesAantal;
    }

    public void setLesAantal(Integer lesAantal) {
        this.lesAantal = lesAantal;
    }

    public Integer getCategorieID() {
        return categorieID;
    }

    public void setCategorieID(Integer categorieID) {
        this.categorieID = categorieID;
    }

    public Integer getDocentID() {
        return docentID;
    }

    public void setDocentID(Integer docentID) {
        this.docentID = docentID;
    }

    public String getCursusNaam() {
        return cursusNaam;
    }

    public void setCursusNaam(String cursusNaam) {
        this.cursusNaam = cursusNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getDoelGroep() {
        return doelGroep;
    }

    public void setDoelGroep(String doelGroep) {
        this.doelGroep = doelGroep;
    }

    public String getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(String startDatum) {
        this.startDatum = startDatum;
    }

    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }

    public Double getLesPrijs() {
        return lesPrijs;
    }

    public void setLesPrijs(Double lesPrijs) {
        this.lesPrijs = lesPrijs;
    }

    public String getFrequentie() {
        return frequentie;
    }

    public void setFrequentie(String frequentie) {
        this.frequentie = frequentie;
    }

    public Cursus()
    {
        
    }
    
    public Cursus(Integer cursusID, String cursusNaam, String beschrijving, String doelGroep, String startDatum, String dag, String tijd, Integer duur, String frequentie, Integer lesAantal, Double lesPrijs, Integer categorieID, Integer docentID)
    {
        this.setCursusID(cursusID);
        this.setCursusNaam(cursusNaam);
        this.setBeschrijving(beschrijving);
        this.setDoelGroep(doelGroep);
        this.setStartDatum(startDatum);
        this.setDag(dag);
        this.setTijd(tijd);
        this.setDuur(duur);
        this.setFrequentie(frequentie);
        this.setLesAantal(lesAantal);
        this.setLesPrijs(lesPrijs);
        this.setCategorieID(categorieID);
        this.setDocentID(docentID);
    }
}
