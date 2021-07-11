package Model;

public class Expositie {
    private String expositie;
    private String omschrijving;
    private String startdatum;
    private String starttijd;
    private String einddatum;

    public Expositie() {

    }

    public Expositie(String expositie, String omschrijving, String startdatum, String starttijd, String einddatum) {
        this.expositie = expositie;
        this.omschrijving = omschrijving;
        this.startdatum = startdatum;
        this.starttijd = starttijd;
        this.einddatum = einddatum;
    }

    public String getExpositie() {
        return expositie;
    }

    public void setExpositie(String expositie) {
        this.expositie = expositie;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(String startdatum) {
        this.startdatum = startdatum;
    }

    public String getStarttijd() {
        return starttijd;
    }

    public void setStarttijd(String starttijd) {
        this.starttijd = starttijd;
    }

    public String getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(String einddatum) {
        this.einddatum = einddatum;
    }


}
