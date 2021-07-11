package com.mycompany.PatientenDossierModule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 13-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: Klant.java
 */

public class Klant extends Patiënt
{
	private IntegerProperty klantNummer;
	private int patiëntNummer;
	private StringProperty naam, geboorteDatum;
	private String woonAdres, telefoonNummer, emailAdres, patiëntNaam;
	private boolean geslacht;
	private int dbResult;
	
	public int getKlantNummer() {
		return KlantNummer().get();
	}


	public void setKlantNummer(int value) {
		KlantNummer().set(value);
	}
	
	public IntegerProperty KlantNummer()
	{
		if(klantNummer == null) 
		{
			klantNummer = new SimpleIntegerProperty(this, "klantNummer");			
		}
		return klantNummer;
	}


	public int getPatiëntNummer() {
		return patiëntNummer;
	}


	public void setPatiëntNummer(int patiëntNummer) {
		this.patiëntNummer = patiëntNummer;
	}

	public StringProperty Naam() 
	{
		if(naam == null) 
		{
			naam = new SimpleStringProperty(this, "naam");
		}
		return naam;
	}

	public String getNaam() {
		return Naam().get();
	}


	public void setNaam(String value) {
		Naam().set(value);
	}

	public StringProperty GeboorteDatum()
	{
		if(geboorteDatum == null) 
		{
			geboorteDatum = new SimpleStringProperty(this, "geboorteDatum");			
		}
		return geboorteDatum;
	}

	public String getGeboorteDatum() {
		return GeboorteDatum().get();
	}


	public void setGeboorteDatum(String value) {
		GeboorteDatum().set(value);
	}


	public String getWoonAdres() {
		return woonAdres;
	}


	public void setWoonAdres(String woonAdres) {
		this.woonAdres = woonAdres;
	}


	public String getTelefoonNummer() {
		return telefoonNummer;
	}


	public void setTelefoonNummer(String telefoonNummer) {
		this.telefoonNummer = telefoonNummer;
	}


	public String getEmailAdres() {
		return emailAdres;
	}


	public void setEmailAdres(String emailAdres) {
		this.emailAdres = emailAdres;
	}


	public String getPatiëntNaam() {
		return patiëntNaam;
	}


	public void setPatiëntNaam(String patiëntNaam) {
		this.patiëntNaam = patiëntNaam;
	}


	public boolean getGeslacht() {
		return geslacht;
	}


	public void setGeslacht(boolean geslacht) {
		this.geslacht = geslacht;
	}
	
	public void klantInvoeren() 
	{		
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			
			String insertStatement = "INSERT INTO Klant VALUES (" + this.getKlantNummer() + ",'" + this.getNaam() + "'," + this.getGeslacht()
			+ ",'" + this.getGeboorteDatum() + "','" + this.getWoonAdres() + "','" + this.getTelefoonNummer() + "','" + this.getEmailAdres() + "',"
			+ this.getPatiëntNummer() + ",'" + this.getPatiëntNaam() + "')";
			
			dbResult = stat.executeUpdate(insertStatement);			
		}
		catch(SQLException se)
		{
			//Zodra er een fout is opgetreden(dbResult heeft integerwaarde 0 gekregen) tijdens het uitvoeren van de insert-statement,
			//print dan hierover de details in de debug-console
			if(dbResult == 0) 
			{
				System.out.println(se.getMessage());
			}
		}
	}

	public void klantBewerken()
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			
			String updateStatement = "UPDATE Klant SET Geslacht = " + this.getGeslacht()
			+ ", Geboortedatum = '" + this.getGeboorteDatum() + "', Woonadres = '" + this.getWoonAdres() + "', Telefoonnummer = '" + this.getTelefoonNummer() + "', Emailadres = '" + this.getEmailAdres() 
			+ "', Patiëntnummer = " + this.getPatiëntNummer() + ", Patiëntnaam = '" + this.getPatiëntNaam() + "' WHERE Klantnummer = " + this.getKlantNummer() + " AND Naam = '" + this.getNaam() + "';" ;
			
			dbResult = stat.executeUpdate(updateStatement);			
		}
		catch(SQLException se)
		{
			//Zodra er een fout is opgetreden(dbResult heeft integerwaarde 0 gekregen) tijdens het uitvoeren van de update-statement,
			//print dan hierover de details in de debug-console
			if(dbResult == 0) 
			{
				System.out.println(se.getMessage());
			}
		}
	}
	
	public void klantVerwijderen()
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			
			String deleteStatement = "DELETE FROM Klant WHERE Klantnummer = " + this.getKlantNummer();
			
			dbResult = stat.executeUpdate(deleteStatement);			
		}
		catch(SQLException se)
		{
			//Zodra er een fout is opgetreden(dbResult heeft integerwaarde 0 gekregen) tijdens het uitvoeren van de delete-statement,
			//print dan hierover de details in de debug-console
			if(dbResult == 0) 
			{
				System.out.println(se.getMessage());
			}
		}
	}
	
	public void klantWeergeven(int klantNummer)
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Klant WHERE Klantnummer = " + klantNummer);
			
			while(result.next())
			{				
				this.setNaam(result.getString("Naam"));
				this.setKlantNummer(result.getInt("Klantnummer"));
				this.setGeboorteDatum(result.getString("Geboortedatum"));
				this.setWoonAdres(result.getString("Woonadres"));
				this.setTelefoonNummer(result.getString("Telefoonnummer"));
				this.setEmailAdres(result.getString("Emailadres"));
				this.setGeslacht(result.getBoolean("Geslacht"));
				this.setPatiëntNaam(result.getString("Patiëntnaam"));
				this.setPatiëntNummer(result.getInt("Patiëntnummer"));
			}
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
	public Klant() 
	{
		
	}	
}
