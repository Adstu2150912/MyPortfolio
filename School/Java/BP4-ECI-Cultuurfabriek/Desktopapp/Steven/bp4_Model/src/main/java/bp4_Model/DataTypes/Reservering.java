/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp4_Model.DataTypes;

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
