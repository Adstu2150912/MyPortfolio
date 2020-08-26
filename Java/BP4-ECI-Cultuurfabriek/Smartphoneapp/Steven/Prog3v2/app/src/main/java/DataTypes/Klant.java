package DataTypes;

/**
 * Extentie van persoon geeft aan wat voor persoon gebruiker is.
 * @author Steven Koemans
 * @version 2.0.1
 * @see DataTypes.Persoon
 */

public class Klant extends Persoon
{
    /**
     * Constructor voor de Klant class zet de standaart waardes in de variabelen
     * @param sNaam
     * @param sEmail
     */
    public Klant(String sNaam, String sEmail)
    {
        this.sNaam = sNaam;
        this.sEmail = sEmail;
    }
}
