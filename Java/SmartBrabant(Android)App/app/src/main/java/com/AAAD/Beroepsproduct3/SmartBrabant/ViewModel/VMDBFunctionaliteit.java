package com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel;

import android.app.ActivityOptions;
import android.content.Context;

import androidx.databinding.ObservableList;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Activiteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Advies;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Burger;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.DBFunctionaliteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.IoTApparaat;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 13-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: VMDBfunctionaliteit.java
 */

public class VMDBFunctionaliteit extends DBFunctionaliteit
{
	//Haal gegevens uit de ViewModel op voor alle activiteiten
	public ObservableList<Activiteit> getActivityDataFromVM(Context context, Plaats selectedPlaats)
	{
		return this.getActivityDataFromDB(context, selectedPlaats);
	};
	
	
	//Haal gegevens uit de ViewModel op voor de geselecteerde burger
	public Burger getCitizenDataFromVM(Context context, int bsnNummer)
	{
		return this.getCitizenDataFromDB(context, bsnNummer);
	}
	
	//Haal gegevens uit de ViewModel op voor het advies van de door de gebruiker geselecteerde plaats
	public Advies getAdviceDataFromVM(Context context, Plaats selectedPlaats)
	{
		return this.getAdviceDataFromDB(context, selectedPlaats);
	}
	
	//Haal gegevens uit de ViewModel op voor alle IoT-apparaten
	public ObservableList<IoTApparaat> getIoTDataFromVM(Context context, Plaats selectedPlaats)
	{
		return this.getIoTDataFromDB(context, selectedPlaats);
	}
	
	//Haal gegevens uit de ViewModel op voor alle plaatsen
	public ObservableList<Plaats> getGeoDataFromVM(Context context)
	{
		return this.getGeoDataFromDB(context);
	}

	//Haal de actuele tevredenheden uit de ViewModel op voor de geselecteerde plaats
	public String getGeoDataFromVM(Context context, Plaats huidigePlaats)
	{
		return this.getGeoDataFromDB(context, huidigePlaats);
	}
	
	//Voer gegevens uit de geselecteerde burger en plaats in de ViewModel
	public Boolean setFeedbackFormToVM(Context context, Burger burger)
	{
		return this.setFeedbackFormToDB(context, burger);
	};
}
