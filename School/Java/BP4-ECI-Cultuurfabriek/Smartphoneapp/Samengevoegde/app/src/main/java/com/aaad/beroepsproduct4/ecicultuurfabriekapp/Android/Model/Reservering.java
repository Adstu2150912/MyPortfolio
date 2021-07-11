package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

/**
 *
 * @author swkoe
 */
public class Reservering
{
    private String sEmail;
    private int nAantalTickets;
    private int nEventID;

    public Reservering(String sEmail, int nAantalTickets, int nEventID)
    {
        this.sEmail = sEmail;
        this.nAantalTickets = nAantalTickets;
        this.nEventID = nEventID;
    }

    public String getsEmail()
    {
        return sEmail;
    }

    public void setsEmail(String sEmail)
    {
        this.sEmail = sEmail;
    }

    public int getnAantalTickets()
    {
        return nAantalTickets;
    }

    public void setnAantalTickets(int nAantalTickets)
    {
        this.nAantalTickets = nAantalTickets;
    }

    public int getnEventID()
    {
        return nEventID;
    }

    public void setnEventID(int nEventID)
    {
        this.nEventID = nEventID;
    }

}