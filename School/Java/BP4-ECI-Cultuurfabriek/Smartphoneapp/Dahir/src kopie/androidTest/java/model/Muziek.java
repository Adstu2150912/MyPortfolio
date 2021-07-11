package model;

public class Muziek {

    private Integer eventId = null;
    private String evenementNaam = null;
    private String artiest = null;
    private String muziekGenre = null;
    private String zaal = null;
    private String beschrijving = null;


    public Muziek(){

    }

    public Muziek(Integer eventId, String evenementNaam, String artiest, String muziekGenre, String zaal, String beschrijving){

        this.eventId = eventId;
        this.evenementNaam = evenementNaam;
        this.artiest = artiest;
        this.muziekGenre = muziekGenre;
        this.zaal = zaal;
        this.beschrijving = beschrijving;

    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEvenementNaam() {
        return evenementNaam;
    }

    public void setEvenementNaam(String evenementNaam) {
        this.evenementNaam = evenementNaam;
    }

    public String getArtiest() {
        return artiest;
    }

    public void setArtiest(String artiest) {
        this.artiest = artiest;
    }

    public String getMuziekGenre() {
        return muziekGenre;
    }

    public void setMuziekGenre(String muziekGenre) {
        this.muziekGenre = muziekGenre;
    }

    public String getZaal() {
        return zaal;
    }

    public void setZaal(String zaal) {
        this.zaal = zaal;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }


}
