package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.Model;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 06-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: Cursuscategorie.java
 */

public class Cursuscategorie
{
   private String subCategorie, categorieNaam, omschrijving;
   private Integer categorieID;

    public String getSubCategorie() {
        return subCategorie;
    }

    public void setSubCategorie(String subCategorie) {
        this.subCategorie = subCategorie;
    }

    public String getCategorieNaam() {
        return categorieNaam;
    }

    public void setCategorieNaam(String categorieNaam) {
        this.categorieNaam = categorieNaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Integer getCategorieID() {
        return categorieID;
    }

    public void setCategorieID(Integer categorieID) {
        this.categorieID = categorieID;
    }

    public Cursuscategorie()
   {

   }
}
