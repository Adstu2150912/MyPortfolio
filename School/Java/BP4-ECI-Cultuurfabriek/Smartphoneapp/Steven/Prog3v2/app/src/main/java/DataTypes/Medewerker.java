package DataTypes;

/**
 * Extentie van persoon geeft aan wat voor persoon gebruiker is plus onthoud extra data
 * @author Steven Koemans
 * @version 2.0.1
 * @see DataTypes.Persoon
 */

public class Medewerker extends Persoon
{
    protected String sTelefoon;

    /**
     * contructor voor de mederwerker class om de startwaardes te zetten in de class
     * @param sNaam
     * @param sEmail
     * @param sTelefoon
     */
    public Medewerker(String sNaam, String sEmail, String sTelefoon)
    {
        this.sNaam = sNaam;
        this.sEmail = sEmail;
        this.sTelefoon = sTelefoon;
    }

    /**
     * get sTelefoon String variable
     * @return sTelefoon
     */
    public String getsTelefoon()
    {
        return sTelefoon;
    }

    /**
     * Sets sTelefoon String variable
     * @param sTelefoon
     */
    public void setsTelefoon(String sTelefoon)
    {
        this.sTelefoon = sTelefoon;
    }
}
