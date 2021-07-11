package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ComboBox;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 25-02-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: Plaats.java
 */

public class Plaats
{
	private String naam, gemeente;
	private int gemeentePop, stadPop, metroPop;
	private Boolean isSMART;
	private double oppervlakte;
	
	private StringProperty privStrPropNaam, privStrPropGemeente, privStrPropStatus, privStrPropOppervlakte, privStrPropTevreden;
	private IntegerProperty privIntPropGemeentePop, privIntPropStadPop, privIntPropMetroPop;
	
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
	
	public StringProperty pubStrPropGemeente() 
	{
		if(privStrPropGemeente == null) 
			privStrPropGemeente = new SimpleStringProperty(this, "StrPropGemeente");
		return privStrPropGemeente;
	}

	public String getStrPropGemeente() 
	{
		return pubStrPropGemeente().get();
	}

	public void setStrPropGemeente(String value) 
	{
		pubStrPropGemeente().set(value);
	}
	
	public StringProperty pubStrPropStatus() 
	{
		if(privStrPropStatus == null) 
			privStrPropStatus = new SimpleStringProperty(this, "StrPropStatus");
		return privStrPropStatus;
	}

	public String getStrPropStatus() 
	{
		return pubStrPropStatus().get();
	}

	public void setStrPropStatus(String value) 
	{
		pubStrPropStatus().set(value);
	}
	
	public StringProperty pubStrPropOppervlakte() 
	{
		if(privStrPropOppervlakte == null) 
			privStrPropOppervlakte = new SimpleStringProperty(this, "StrPropOppervlakte");
		return privStrPropOppervlakte;
	}

	public String getStrPropOppervlakte() 
	{
		return pubStrPropOppervlakte().get();
	}

	public void setStrPropOppervlakte(String value) 
	{
		pubStrPropOppervlakte().set(value);
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
	
	public IntegerProperty pubIntPropGemeentePop() 
	{
		if(privIntPropGemeentePop == null) 
			privIntPropGemeentePop = new SimpleIntegerProperty(this, "IntPropGemeentePop");
		return privIntPropGemeentePop;
	}

	public Integer getIntPropGemeentePop() 
	{
		return pubIntPropGemeentePop().get();
	}

	public void setIntPropGemeentePop(Integer value) 
	{
		pubIntPropGemeentePop().set(value);
	}
	
	public IntegerProperty pubIntPropStadPop() 
	{
		if(privIntPropStadPop == null) 
			privIntPropStadPop = new SimpleIntegerProperty(this, "IntPropStadPop");
		return privIntPropStadPop;
	}

	public Integer getIntPropStadPop() 
	{
		return pubIntPropStadPop().get();
	}

	public void setIntPropStadPop(Integer value) 
	{
		pubIntPropStadPop().set(value);
	}	
	
	public IntegerProperty pubIntPropMetroPop() 
	{
		if(privIntPropMetroPop == null) 
			privIntPropMetroPop = new SimpleIntegerProperty(this, "IntPropMetroPop");
		return privIntPropMetroPop;
	}

	public Integer getIntPropMetroPop() 
	{
		return pubIntPropMetroPop().get();
	}

	public void setIntPropMetroPop(Integer value) 
	{
		pubIntPropMetroPop().set(value);
	}
	
	public Plaats()
	{
		
	}
}
