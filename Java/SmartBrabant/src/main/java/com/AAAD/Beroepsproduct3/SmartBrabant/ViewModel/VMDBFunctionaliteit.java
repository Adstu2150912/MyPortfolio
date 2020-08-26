package com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Advies;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Burger;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.DBFunctionaliteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;

import javafx.collections.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: VMDBfunctionaliteit.java
 */

public class VMDBFunctionaliteit extends DBFunctionaliteit
{
	//Haal gegevens uit de ViewModel op voor alle activiteiten
	public ObservableList getActivityDataFromVM(Plaats selectedPlaats) 
	{
		return this.getActivityDataFromDB(selectedPlaats);
	};
	
	
	//Haal gegevens uit de ViewModel op voor alle burgers
	public Burger getCitizenDataFromVM(int bsnNummer)
	{
		return this.getCitizenDataFromDB(bsnNummer);
	}
	
	//Haal gegevens uit de ViewModel op voor het advies van de door de gebruiker geselecteerde plaats
	public Advies getAdviceDataFromVM(Plaats selectedPlaats)
	{
		return this.getAdviceDataFromDB(selectedPlaats);
	}
	
	//Haal gegevens uit de ViewModel op voor alle IoT-apparaten
	public ObservableList getIoTDataFromVM(Plaats selectedPlaats)
	{
		return this.getIoTDataFromDB(selectedPlaats);
	}
	
	//Haal gegevens uit de ViewModel op voor alle plaatsen
	public ObservableList getGeoDataFromVM()
	{
		return this.getGeoDataFromDB();
	}
	
	//Voer gegevens uit de geselecteerde burger en plaats in de ViewModel
	public Boolean setFeedbackFormToVM(Burger burger)
	{
		return this.setFeedbackFormToDB(burger);
	};
}
