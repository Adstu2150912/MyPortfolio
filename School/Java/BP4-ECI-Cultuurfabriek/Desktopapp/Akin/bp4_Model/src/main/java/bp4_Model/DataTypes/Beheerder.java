/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp4_Model.DataTypes;

/**
 *
 * @author akina
 */
public class Beheerder {
    private String beheerder;
    private String gebruikersnaam;
    private String wachtwoord;
    
    public Beheerder(){
        
    }
    
    public Beheerder(String beheerder, String gebruikersnaam, String wachtwoord) {
        this.beheerder = beheerder;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public String getBeheerder() {
        return beheerder;
    }

    public void setBeheerder(String beheerder) {
        this.beheerder = beheerder;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
    
    
    
    
}
