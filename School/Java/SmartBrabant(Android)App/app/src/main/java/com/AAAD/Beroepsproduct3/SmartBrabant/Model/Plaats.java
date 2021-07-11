package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import java.io.Serializable;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 12-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: Plaats.java
 */
public class Plaats implements Serializable
{
    private String naam, gemeente, tevredenheid;
    private int gemeentePop, stadPop, metroPop, isSMART;
    private double oppervlakte;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getTevredenheid() {
        return tevredenheid;
    }

    public void setTevredenheid(String tevredenheid) {
        this.tevredenheid = tevredenheid;
    }

    public int getGemeentePop() {
        return gemeentePop;
    }

    public void setGemeentePop(int gemeentePop) {
        this.gemeentePop = gemeentePop;
    }

    public int getStadPop() {
        return stadPop;
    }

    public void setStadPop(int stadPop) {
        this.stadPop = stadPop;
    }

    public int getMetroPop() {
        return metroPop;
    }

    public void setMetroPop(int metroPop) {
        this.metroPop = metroPop;
    }

    public Integer getStatus() {
        return isSMART;
    }

    public void setStatus(Integer Status) {
        isSMART = Status;
    }

    public double getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(double oppervlakte) {
        this.oppervlakte = oppervlakte;
    }

    @Override
    public String toString()
    {
        return this.getNaam();
    }

    public Plaats()
    {

    }
}
