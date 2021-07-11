package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 25-02-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: Activiteit.java
 */

public class Activiteit
{
	private int activiteitNummer;
	private String naam, maatFactor, prioriteit, plaatsNaam, dataSoort;
	private StringProperty privStrPropNaam, privStrPropDataSoort, privStrPropMaatFactor, privStrPropPrio, privStrPropPlaatsNaam, privStrPropIoTNaam;
	private IntegerProperty privIntPropActivNum, privIntPropIoTNum;
	
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
	
	public StringProperty pubStrPropDataSoort() 
	{
		if(privStrPropDataSoort == null) 
			privStrPropDataSoort = new SimpleStringProperty(this, "StrPropDataSoort");
		return privStrPropDataSoort;
	}

	public String getStrPropDataSoort() 
	{
		return pubStrPropDataSoort().get();
	}

	public void setStrPropDataSoort(String value) 
	{
		pubStrPropDataSoort().set(value);
	}
	
	public StringProperty pubStrPropMaatFactor() 
	{
		if(privStrPropMaatFactor == null) 
			privStrPropMaatFactor = new SimpleStringProperty(this, "StrPropMaatFactor");
		return privStrPropMaatFactor;
	}

	public String getStrPropMaatFactor() 
	{
		return pubStrPropMaatFactor().get();
	}

	public void setStrPropMaatFactor(String value) 
	{
		pubStrPropMaatFactor().set(value);
	}
	
	public StringProperty pubStrPropPrio() 
	{
		if(privStrPropPrio == null) 
			privStrPropPrio = new SimpleStringProperty(this, "StrPropPrio");
		return privStrPropPrio;
	}

	public String getStrPropPrio() 
	{
		return pubStrPropPrio().get();
	}

	public void setStrPropPrio(String value) 
	{
		pubStrPropPrio().set(value);
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
	
	public StringProperty pubStrPropIoTNaam() 
	{
		if(privStrPropIoTNaam == null) 
			privStrPropIoTNaam = new SimpleStringProperty(this, "StrPropIoTNaam");
		return privStrPropIoTNaam;
	}

	public String getStrPropIoTNaam() 
	{
		return pubStrPropIoTNaam().get();
	}

	public void setStrPropIoTNaam(String value) 
	{
		pubStrPropIoTNaam().set(value);
	}
	
	public IntegerProperty pubIntPropActivNum() 
	{
		if(privIntPropActivNum == null) 
			privIntPropActivNum = new SimpleIntegerProperty(this, "IntPropActivNum");
		return privIntPropActivNum;
	}

	public Integer getIntPropActivNum() 
	{
		return pubIntPropActivNum().get();
	}

	public void setIntPropActivNum(Integer value) 
	{
		pubIntPropActivNum().set(value);
	}	
	
	public IntegerProperty pubIntPropIoTNum() 
	{
		if(privIntPropIoTNum == null) 
			privIntPropIoTNum = new SimpleIntegerProperty(this, "IntPropIoTNum");
		return privIntPropIoTNum;
	}

	public Integer getIntPropIoTNum() 
	{
		return pubIntPropIoTNum().get();
	}

	public void setIntPropIoTNum(Integer value) 
	{
		pubIntPropIoTNum().set(value);
	}	
	
	public Activiteit()
	{
		
	}
}
