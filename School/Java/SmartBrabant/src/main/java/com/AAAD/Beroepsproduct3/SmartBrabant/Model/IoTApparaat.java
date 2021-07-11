package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 25-02-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: IoTApparaat.java
 */

public class IoTApparaat
{
	private int IoTnummer;
	private String naam, dataSoort, plaatsNaam;
	private StringProperty privStrPropNaam, privStrPropDataSoort, privStrPropPlaatsNaam, privStrPropActivNaam;
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
	
	public StringProperty pubStrPropActivNaam() 
	{
		if(privStrPropActivNaam == null) 
			privStrPropActivNaam = new SimpleStringProperty(this, "StrPropActivNaam");
		return privStrPropActivNaam;
	}

	public String getStrPropActivNaam() 
	{
		return pubStrPropActivNaam().get();
	}

	public void setStrPropActivNaam(String value) 
	{
		pubStrPropActivNaam().set(value);
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
	
	public IoTApparaat()
	{
		
	}
}
