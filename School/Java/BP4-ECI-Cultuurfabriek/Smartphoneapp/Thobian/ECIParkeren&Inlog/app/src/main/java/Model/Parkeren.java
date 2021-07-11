package Model;

public class Parkeren {
    private String Parkeerplek = null;
    private String ParkeerOpmerking = null;

    public Parkeren (String ParkeerOpmerking,String Parkeerplek){
        this.ParkeerOpmerking = Parkeerplek;
        this.ParkeerOpmerking = ParkeerOpmerking;
    }

    public String getParkeerplek() {
        return Parkeerplek;
    }

    public void setParkeerplek(String parkeerplek) {
        Parkeerplek = parkeerplek;
    }

    public String getParkeerOpmerking() {
        return ParkeerOpmerking;
    }

    public void setParkeerOpmerking(String parkeerOpmerking) {
        ParkeerOpmerking = parkeerOpmerking;
    }
}
