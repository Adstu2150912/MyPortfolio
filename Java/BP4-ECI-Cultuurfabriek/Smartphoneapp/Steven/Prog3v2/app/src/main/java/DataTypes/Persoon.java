package DataTypes;

/**
 * Abstract persoon class is de verzameling van alle generieke persoon data
 * @author Steven Koemans
 * @version 2.0.1
 */

public abstract class Persoon
{
    protected String sNaam;
    protected String sEmail;


    /**
     * gets the sNaam String variable
     * @return sNaam
     */
    public String getsNaam()
    {
        return sNaam;
    }

    /**
     * Sets the sNaam String variable
     * @param sNaam
     */
    public void setsNaam(String sNaam)
    {
        this.sNaam = sNaam;
    }

    /**
     * gets sEmail String variable
     * @return sEmail
     */
    public String getsEmail()
    {
        return sEmail;
    }

    /**
     * Sets sEmail String variable
     * @param sEmail
     */
    public void setsEmail(String sEmail)
    {
        this.sEmail = sEmail;
    }
}