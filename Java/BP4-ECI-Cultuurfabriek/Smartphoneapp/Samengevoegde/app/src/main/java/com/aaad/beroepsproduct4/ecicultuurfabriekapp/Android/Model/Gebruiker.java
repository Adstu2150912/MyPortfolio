package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model;

import java.sql.Date;



/**
 *
 * @author Steven Koemans
 */
public class Gebruiker
{
    private String sEmail;
    private String sVoornaam;
    private String sAchternaam;
    private String sVoorletters;
    private String sGeslacht;
    private Date geboorteDatum;//  = new Date();
    private String sPlaats;
    private String sStraatNaam;
    private String sHuisnummer;
    private String sTelefoonnummer;
    private String sIbanNummer;

    public Gebruiker
            (
                    String sEmail,
                    String sVoornaam,
                    String sAchternaam,
                    String sVoorletters,
                    String sGeslacht,
                    Date geboorteDatum,
                    String sPlaats,
                    String sStraatNaam,
                    String sHuisnummer,
                    String sTelefoonnummer,
                    String sIbanNummer
            )
    {
        this.sEmail = sEmail;
        this.sVoornaam = sVoornaam;
        this.sAchternaam = sAchternaam;
        this.sVoorletters = sVoorletters;
        this.sGeslacht = sGeslacht;
        this.geboorteDatum = geboorteDatum;
        this.sPlaats = sPlaats;
        this.sStraatNaam = sStraatNaam;
        this.sHuisnummer = sHuisnummer;
        this.sTelefoonnummer = sTelefoonnummer;
        this.sIbanNummer = sIbanNummer;
    }

    public String getsStraatNaam()
    {
        return sStraatNaam;
    }

    public void setsStraatNaam(String sStraatNaam)
    {
        this.sStraatNaam = sStraatNaam;
    }

    public String getsEmail()
    {
        return sEmail;
    }

    public void setsEmail(String sEmail)
    {
        this.sEmail = sEmail;
    }

    public String getsVoornaam()
    {
        return sVoornaam;
    }

    public void setsVoornaam(String sVoornaam)
    {
        this.sVoornaam = sVoornaam;
    }

    public String getsAchternaam()
    {
        return sAchternaam;
    }

    public void setsAchternaam(String sAchternaam)
    {
        this.sAchternaam = sAchternaam;
    }

    public String getsVoorletters()
    {
        return sVoorletters;
    }

    public void setsVoorletters(String sVoorletters)
    {
        this.sVoorletters = sVoorletters;
    }

    public String getsGeslacht()
    {
        return sGeslacht;
    }

    public void setsGeslacht(String sGeslacht)
    {
        this.sGeslacht = sGeslacht;
    }

    public Date getGeboorteDatum()
    {
        return geboorteDatum;
    }

    public void setGeboorteDatum(Date geboorteDatum)
    {
        this.geboorteDatum = geboorteDatum;
    }

    public String getsPlaats()
    {
        return sPlaats;
    }

    public void setsPlaats(String sPlaats)
    {
        this.sPlaats = sPlaats;
    }

    public String getsHuisnummer()
    {
        return sHuisnummer;
    }

    public void setsHuisnummer(String sHuisnummer)
    {
        this.sHuisnummer = sHuisnummer;
    }

    public String getsTelefoonnummer()
    {
        return sTelefoonnummer;
    }

    public void setsTelefoonnummer(String sTelefoonnummer)
    {
        this.sTelefoonnummer = sTelefoonnummer;
    }

    public String getsIbanNummer()
    {
        return sIbanNummer;
    }

    public void setsIbanNummer(String sIbanNummer)
    {
        this.sIbanNummer = sIbanNummer;
    }
}

