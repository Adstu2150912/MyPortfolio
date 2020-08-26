package GroepE.BeroepsProduct4_Desktop.DataTypes;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 06-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: Docent.java
 */

public class Docent
{
    private String docentNaam, beschrijving, discipline;
    private Integer docentID;

    public String getDocentNaam() {
        return docentNaam;
    }

    public void setDocentNaam(String docentNaam) {
        this.docentNaam = docentNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Integer getDocentID() {
        return docentID;
    }

    public void setDocentID(Integer docentID) {
        this.docentID = docentID;
    }

    public Docent()
    {

    }
    
    public Docent(Integer docentID, String docentNaam, String beschrijving, String discipline)
    {
        this.setDocentID(docentID);
        this.setDocentNaam(docentNaam);
        this.setBeschrijving(beschrijving);
        this.setDiscipline(discipline);
    }
}
