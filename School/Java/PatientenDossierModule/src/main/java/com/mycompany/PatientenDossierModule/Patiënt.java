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
 * Bestandsnaam: Patiënt.java
 */
public class Patiënt 
{
	public IntegerProperty patiëntNummer;
	public StringProperty naam, geboorteDatum;
	private boolean geslacht, aanwezigheid;
	private String dierSoort, dierRas, labUitslag, opnameVerslag, verblijfRuimte;
	private double gewicht;
	private int dbResult;
	
	public int getPatiëntNummer() {
		return PatiëntNummer().get();
	}

	public void setPatiëntNummer(int value) {
		PatiëntNummer().set(value);
	}
	
	public IntegerProperty PatiëntNummer()
	{
		if(patiëntNummer == null) 
		{
			patiëntNummer = new SimpleIntegerProperty(this, "patiëntNummer");			
		}
		return patiëntNummer;
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

	public boolean getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(boolean geslacht) {
		this.geslacht = geslacht;
	}

	public boolean isAanwezigheid() {
		return aanwezigheid;
	}

	public void setAanwezigheid(boolean aanwezigheid) {
		this.aanwezigheid = aanwezigheid;
	}

	public String getDierSoort() {
		return dierSoort;
	}

	public void setDierSoort(String dierSoort) {
		this.dierSoort = dierSoort;
	}

	public String getDierRas() {
		return dierRas;
	}

	public void setDierRas(String dierRas) {
		this.dierRas = dierRas;
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

	public String getLabUitslag() {
		return labUitslag;
	}

	public void setLabUitslag(String labUitslag) {
		this.labUitslag = labUitslag;
	}

	public String getOpnameVerslag() {
		return opnameVerslag;
	}

	public void setOpnameVerslag(String opnameVerslag) {
		this.opnameVerslag = opnameVerslag;
	}

	public String getVerblijfRuimte() {
		return verblijfRuimte;
	}

	public void setVerblijfRuimte(String verblijfRuimte) {
		this.verblijfRuimte = verblijfRuimte;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	public void patiëntInvoeren() 
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			
			String insertStatement = "INSERT INTO Patiënt VALUES (" + this.getPatiëntNummer() + ",'" + this.getNaam() + "'," + this.getGeslacht()
			+ ",'" + this.getDierSoort() + "','" + this.getDierRas() + "'," + this.getGewicht() + ",'" + this.getGeboorteDatum() + "', '"
			+ this.getLabUitslag() + "','" + this.getOpnameVerslag() + "','" + this.getVerblijfRuimte() + "'," + this.isAanwezigheid() + ");";
			
			dbResult = stat.executeUpdate(insertStatement);			
		}
		catch(SQLException se)
		{
			//Zodra er een fout is opgetreden(dbResult heeft integerwaarde 0 gekregen) tijdens het uitvoeren van de insert-statement,
			//print dan hierover de details in de debug-console
//			if(dbResult == 0) 
//			{
				System.out.println(se.getMessage());
//			}
		}
	}
	
	public void patiëntBewerken() 
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			
			String updateStatement = "UPDATE Patiënt SET Geslacht =" + this.getGeslacht()
			+ ", Diersoort = '" + this.getDierSoort() + "', Dierras = '" + this.getDierRas() + "', Gewicht = " + this.getGewicht() + ", Geboortedatum = '" + this.getGeboorteDatum() 
			+ "', Labuitslag = '" + this.getLabUitslag() + "', Opnameverslag = '" + this.getOpnameVerslag() + "', Verblijfruimte = '" + this.getVerblijfRuimte() + "', Aanwezigheid = " + this.isAanwezigheid() 
			+ " WHERE Patiëntnummer = " + this.getPatiëntNummer() + ";";
			
			dbResult = stat.executeUpdate(updateStatement);			
		}
		catch(SQLException se)
		{
			//Zodra er een fout is opgetreden(dbResult heeft integerwaarde 0 gekregen) tijdens het uitvoeren van de insert-statement,
			//print dan hierover de details in de debug-console
//			if(dbResult == 0) 
//			{
				System.out.println(se.getMessage());
//			}
		}
	}
	
	public void patiëntVerwijderen()
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			
			String deleteStatement = "DELETE FROM Patiënt WHERE Patiëntnummer = " + this.getPatiëntNummer() + ";";
			
			dbResult = stat.executeUpdate(deleteStatement);			
		}
		catch(SQLException se)
		{
			//Zodra er een fout is opgetreden(dbResult heeft integerwaarde 0 gekregen) tijdens het uitvoeren van de insert-statement,
			//print dan hierover de details in de debug-console
//			if(dbResult == 0) 
//			{
				System.out.println(se.getMessage());
//			}
		}
	}
	
	public void patiëntWeergeven(int patiëntNummer)
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Patiënt WHERE Patiëntnummer = " + patiëntNummer);
			
			while(result.next())
			{				
				this.setNaam(result.getString("Naam"));
				this.setPatiëntNummer(result.getInt("Patiëntnummer"));
				this.setGeboorteDatum(result.getString("Geboortedatum"));
				this.setDierSoort(result.getString("Diersoort"));
				this.setDierRas(result.getString("Dierras"));
				this.setLabUitslag(result.getString("LabUitslag"));
				this.setGeslacht(result.getBoolean("Geslacht"));
				this.setOpnameVerslag(result.getString("Opnameverslag"));
				this.setVerblijfRuimte(result.getString("Verblijfruimte"));
				this.setGewicht(result.getDouble("Gewicht"));
				this.setAanwezigheid(result.getBoolean("Aanwezigheid"));
				this.setPatiëntNummer(result.getInt("Patiëntnummer"));
			}
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
	public Patiënt()
	{
		
	}
}
