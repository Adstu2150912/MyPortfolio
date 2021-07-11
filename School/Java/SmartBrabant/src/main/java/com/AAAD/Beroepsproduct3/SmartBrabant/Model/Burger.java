package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 25-02-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: Burger.java
 */

public class Burger
{
	private int bsnNummer;
	private Boolean tevredenheidPlaats;
	private String naam, plaatsNaam, mening;
	
	private IntegerProperty privIntPropBSN;
	private StringProperty privStrPropNaam, privStrPropPlaatsNaam, privStrPropTevreden;
	
	public Boolean getTevredenheidPlaats() {
		return tevredenheidPlaats;
	}

	public void setTevredenheidPlaats(Boolean tevredenheidPlaats) {
		this.tevredenheidPlaats = tevredenheidPlaats;
	}

	public StringProperty pubStrPropNaam() 
	{
		if(privStrPropNaam == null) 
			privStrPropNaam = new SimpleStringProperty(this, "StrPropNaam");
		return privStrPropNaam;
	}

	public String getStrPropNaam() 
	{
		return pubStrPropNaam().get();
	}

	public void setStrPropNaam(String value) 
	{
		pubStrPropNaam().set(value);
	}
	
	public StringProperty pubStrPropPlaatsNaam() 
	{
		if(privStrPropPlaatsNaam == null) 
			privStrPropPlaatsNaam = new SimpleStringProperty(this, "StrPropPlaatsNaam");
		return privStrPropPlaatsNaam;
	}

	public String getStrPropPlaatsNaam() 
	{
		return pubStrPropPlaatsNaam().get();
	}

	public void setStrPropPlaatsNaam(String value) 
	{
		pubStrPropPlaatsNaam().set(value);
	}
	
	public StringProperty pubStrPropTevreden() 
	{
		if(privStrPropTevreden == null) 
			privStrPropTevreden = new SimpleStringProperty(this, "StrPropTevreden");
		return privStrPropTevreden;
	}

	public String getStrPropTevreden() 
	{
		return pubStrPropTevreden().get();
	}

	public void setStrPropTevreden(String value) 
	{
		pubStrPropTevreden().set(value);
	}
	
	public IntegerProperty pubIntPropBSN() 
	{
		if(privIntPropBSN == null) 
			privIntPropBSN = new SimpleIntegerProperty(this, "IntPropBSN");
		return privIntPropBSN;
	}

	public Integer getIntPropBSN() 
	{
		return pubIntPropBSN().get();
	}

	public void setIntPropBSN(Integer value) 
	{
		pubIntPropBSN().set(value);
	}
	
	public String getMening() {
		return mening;
	}

	public void setMening(String mening) {
		this.mening = mening;
	}

	public Burger(int selectedBSNnummer, String selectedNaam, String selectedPlaats, Boolean tevredenheid, String mening)
	{
		this.setIntPropBSN(selectedBSNnummer);
		this.setStrPropNaam(selectedNaam);
		this.setStrPropPlaatsNaam(selectedPlaats);
		this.setTevredenheidPlaats(tevredenheid);
		this.setMening(mening);
	}
}
