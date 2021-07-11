package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: IDBfunctionaliteit.java
 */

public interface IDBfunctionaliteit 
{
	//Haal gegevens uit de database op voor het geselecteerde java object
	public void getDataFromDB();
	
	//Voer gegevens uit het geselecteerde java object in de database
	public void setDataToDB();
}
