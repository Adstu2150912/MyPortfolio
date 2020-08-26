package com.AAAD.Beroepsproduct3.SmartBrabant.Model;
/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 12-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: Burger.java
 */
public class Burger
{
    private int bsnNummer, tevredenheidPlaats;
    private String naam, plaatsNaam, mening;

    public int getBsnNummer() {
        return bsnNummer;
    }

    public void setBsnNummer(int bsnNummer) {
        this.bsnNummer = bsnNummer;
    }

    public Integer getTevredenheidPlaats() {
        return tevredenheidPlaats;
    }

    public void setTevredenheidPlaats(Integer tevredenheidPlaats) {
        this.tevredenheidPlaats = tevredenheidPlaats;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    public String getMening() {
        return mening;
    }

    public void setMening(String mening) {
        this.mening = mening;
    }

    public Burger(int selectedBSNNummer, String selectedNaam, String selectedPlaatsNaam, int selectedTevredenheidPlaats, String selectedMening)
    {
        this.setBsnNummer(selectedBSNNummer);
        this.setNaam(selectedNaam);
        this.setPlaatsNaam(selectedPlaatsNaam);
        this.setTevredenheidPlaats(selectedTevredenheidPlaats);
        this.setMening(selectedMening);
    }
}
