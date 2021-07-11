package com.AAAD.Beroepsproduct3.SmartBrabant.Model;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 12-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: Advies.java
 */
public class Advies
{
    private int adviesNummer;
    private String pva, plaatsNaam, strlijstToepassingen;

    public int getAdviesNummer() {
        return adviesNummer;
    }

    public void setAdviesNummer(int adviesNummer) {
        this.adviesNummer = adviesNummer;
    }

    public String getPva() {
        return pva;
    }

    public void setPva(String pva) {
        this.pva = pva;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    /*
     * In dit advies moet het volgende staan:
     *alle realistische mogelijkheden om het slim in te richten
     *hoe ieder mogelijkheid toegepast kan worden
     *welke mogelijkheid het meest geschikt is voor de geselecteerde plaats
     * */
    public Advies(ArrayList<AbstractMap.SimpleEntry<String, String>> dataToepassingenLijst, String aanbevolenTechniek, String aanbevolenIoTapparaat, List<String> aanbevolenGebiedenLijst, String selectedPlaats)
    {
        ListIterator<SimpleEntry<String, String>> litrDataToeLijst = dataToepassingenLijst.listIterator(); //Haal hier de verkenner van de betreffende lijst op zodat een plan van aanpak voor een advies geschreven kan worden
        ListIterator<String> litrGebiedenLijst = aanbevolenGebiedenLijst.listIterator();

        this.pva = "Uit de slimme technieken ";

        while(litrDataToeLijst.hasNext())
        {
            SimpleEntry<String, String> huidigeTechniek = litrDataToeLijst.next();
            //Als de lijstenverkenner bij het laatste element is aangekomen, voeg dan onderstaande string toe, voorafgaand het element, in de PvA(Plan van Aanpak)
            if(litrDataToeLijst.hasPrevious() && !litrDataToeLijst.hasNext())
                this.pva += " en ";
            this.pva += huidigeTechniek.getValue() + " meting,";
            this.strlijstToepassingen += this.getLineSeparators(1) + huidigeTechniek.getValue() + " meting wordt gedaan middels " + huidigeTechniek.getKey() + this.getLineSeparators(1);

        }

        this.pva += " wordt " + aanbevolenTechniek + " aangeraden toe te passen door gebruik te maken van IoT-apparaat '" + aanbevolenIoTapparaat + "'";
        this.pva += "Door deze techniek toe te passen in ";

        if(!litrGebiedenLijst.hasNext())
            this.pva += "bepaalde ";

        while(litrGebiedenLijst.hasNext())
        {
            this.pva += litrGebiedenLijst.next() + " ";
        }

        this.pva += "gebieden van " + selectedPlaats + ", zal deze plaats zich beter kunnen functioneren als SMART-city.";
        this.pva += "Dit komt niet alleen " + selectedPlaats + " maar ook de burgers van deze plaats ten goede.";
        this.pva += this.getLineSeparators(2) + "Deze technieken kunnen als volgt toegepast worden:" + this.strlijstToepassingen;
    }

    private String getLineSeparators(int aantal)
    {
        String strLine = "";

        for(int i = 0; i < aantal; i++)
        {
            strLine += "\n";
        }

        return strLine;
    }
}
