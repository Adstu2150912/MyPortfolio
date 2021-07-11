package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: DBfunctionaliteit.java
 */

public abstract class DBFunctionaliteit
{
	protected boolean dbResult;
	//Haal gegevens uit de database op voor alle activiteiten
	protected ObservableList getActivityDataFromDB(Plaats selectedPlaats)
	{
		ObservableList<Activiteit> selectieLijst = FXCollections.observableArrayList();		
		Connection con = null;
		try 
		{
			con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Activiteit WHERE plaatsNaam = '" + selectedPlaats.getStrPropNaam() + "';");
			ResultSet result2 = null;
			while(result.next())
			{	
				Activiteit selectedActivity = new Activiteit();
				selectedActivity.setIntPropActivNum(result.getInt("activiteitNummer"));
				selectedActivity.setStrPropMaatFactor(result.getString("maatschappelijkeFactor"));
				selectedActivity.setStrPropNaam(result.getString("naam"));
				selectedActivity.setStrPropPrio(result.getString("prioriteit"));
				selectedActivity.setStrPropPlaatsNaam(result.getString("plaatsNaam"));
				selectedActivity.setStrPropDataSoort(result.getString("dataSoort"));
				selectieLijst.add(selectedActivity);
			}
			
			for(Activiteit o : selectieLijst)
			{
				//Hier wordt ieder activiteit aan een IoT-apparaat gekoppeld met overeenkomende datasoort
				result2 = stat.executeQuery("SELECT * FROM IoTApparaat WHERE dataSoort = '" + o.getStrPropDataSoort() + "' AND plaatsNaam = '" + o.getStrPropPlaatsNaam() + "';");
				if(result2.next()) 
				{
					if(result2.getInt("IoTnummer") != 0)
						o.setIntPropIoTNum(result2.getInt("IoTnummer"));
					if(!result2.getString("naam").isEmpty())
						o.setStrPropIoTNaam(result2.getString("naam"));	
				}
			}
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in DBFunctionaliteit.getActivityDataFromDB(): " + se.getMessage());
		}
		finally
		{
			try 
			{
				if(con != null)
					con.close();
			}
			catch(SQLException se)
			{
				System.out.println("SQL-error in DBFunctionaliteit.getActivityDataFromDB(): " + se.getMessage());
			}
		}
		return selectieLijst;
	};
	
	
	//Haal gegevens uit de database op voor alle burgers
	protected Burger getCitizenDataFromDB(int bsnNummer)
	{
//		ObservableList<Burger> selectieLijst = FXCollections.observableArrayList();
		Connection con = null;
		Burger huidigeBurger = null;
		try 
		{
			con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Burger BSNnummer WHERE BSNnummer = " + bsnNummer);
//			while(result.next())
//			{	
			if(result.next())
				huidigeBurger = new Burger(result.getInt("BSNnummer"), result.getString("naam"), result.getString("plaatsNaam"), result.getBoolean("tevredenheidPlaats"), result.getString("mening"));
//			huidigeBurger.setIntPropBSN(result.getInt("BSNnummer"));
//			huidigeBurger.setStrPropNaam(result.getString("naam"));
//			huidigeBurger.setStrPropPlaatsNaam(result.getString("plaatsNaam"));
//			huidigeBurger.setStrPropTevreden(Boolean.toString(result.getBoolean("tevredenheidPlaats")));
//			huidigeBurger.setMening(result.getString("mening"));
//				selectieLijst.add(huidigeBurger);
//			}
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in DBFunctionaliteit.getCitizenDataFromDB(): " + se.getMessage());
		}
		finally
		{
			try 
			{
				if(con != null)
					con.close();
			}
			catch(SQLException se)
			{
				System.out.println("SQL-error in DBFunctionaliteit.getCitizenDataFromDB(): " + se.getMessage());
			}
		}
		return huidigeBurger;
	}
	
	//Haal gegevens uit de database op voor het advies van de door de gebruiker geselecteerde plaats
	protected Advies getAdviceDataFromDB(Plaats selectedPlaats)
	{
		//ObservableList<Advies> selectieLijst = FXCollections.observableArrayList();
		
		ArrayList<AbstractMap.SimpleEntry<String, String>> dataToepassingenLijst = new ArrayList<SimpleEntry<String, String>>();
		
		Connection con = null;
		Advies huidigeAdvies = null;
		List<String> gebiedenLijst = new ArrayList<String>();
		String aanbevolenTechniek = null;
		String aanbevolenIoTApparaat = null;
		List<String> iotApparatenLijst = new ArrayList<String>();
		List<String> dataSoortenLijst = new ArrayList<String>();
		try 
		{
			con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
		
			ResultSet resultPlaats = stat.executeQuery("SELECT Plaats.naam AS Plaats, Activiteit.naam AS Activiteit, Activiteit.activiteitNummer, Activiteit.maatschappelijkeFactor AS Factor, Activiteit.prioriteit, Activiteit.dataSoort, IoTApparaat.naam AS IoTApparaat, IoTApparaat.IoTnummer"
					+ " FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE Activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = '" + selectedPlaats.getStrPropNaam() + "' GROUP BY IoTApparaat;");

//			ResultSet resultPrioHoog = stat.executeQuery("SELECT * FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND prioriteit='hoog' AND Plaats.naam = '" + selectedPlaats.getStrPropNaam() + "';");
//			ResultSet resultPrioMiddel = stat.executeQuery("SELECT * FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND prioriteit='middel' AND Plaats.naam = '" + selectedPlaats.getStrPropNaam() + "';");
//			ResultSet resultPrioLaag = stat.executeQuery("SELECT * FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND prioriteit='laag' AND Plaats.naam = '" + selectedPlaats.getStrPropNaam() + "';");
			
			while(resultPlaats.next())
			{	
				iotApparatenLijst.add(resultPlaats.getString("IoTApparaat"));
				dataSoortenLijst.add(resultPlaats.getString("Activiteit.dataSoort"));
				dataToepassingenLijst.add(new AbstractMap.SimpleEntry<String, String>(resultPlaats.getString("IoTApparaat"), resultPlaats.getString("Activiteit.dataSoort")));
			}	
			
			ResultSet resultPlaatsFactor= stat.executeQuery("SELECT DISTINCT Activiteit.maatschappelijkeFactor AS Factor"
			+ " FROM Plaats JOIN Activiteit ON Plaats.naam = Activiteit.plaatsNaam JOIN IoTApparaat ON Plaats.naam = IoTApparaat.plaatsNaam WHERE activiteit.dataSoort = IoTApparaat.dataSoort AND Plaats.naam = '" + selectedPlaats.getStrPropNaam() + "';");	
			
			while(resultPlaatsFactor.next())
			{
				gebiedenLijst.add(resultPlaatsFactor.getString("Factor"));
			}	
			
			ResultSet resultAanbeveling = stat.executeQuery("SELECT Activiteit.ActiviteitNummer, IoTApparaat.naam, IoTApparaat.IoTnummer, Activiteit.plaatsNaam, Activiteit.dataSoort FROM Activiteit JOIN IoTApparaat ON Activiteit.dataSoort = IoTApparaat.dataSoort WHERE Activiteit.plaatsNaam = '" + selectedPlaats.getStrPropNaam() + "';");
			//haal het IoTApparatuur op waarvan het dataSoort overeenkoment met het dataSoort van activiteiten uit het geselecteerde plaats
			if(resultAanbeveling.next() && !gebiedenLijst.contains("null") && !iotApparatenLijst.contains("null") && !dataSoortenLijst.contains("null")) 
			{
				aanbevolenTechniek = resultAanbeveling.getString("Activiteit.dataSoort") + "meting";
				aanbevolenIoTApparaat = resultAanbeveling.getString("IoTApparaat.naam");
				huidigeAdvies = new Advies(dataToepassingenLijst, aanbevolenTechniek, aanbevolenIoTApparaat, gebiedenLijst, selectedPlaats.getStrPropNaam());	
			}
			else
			{
				huidigeAdvies = new Advies(dataToepassingenLijst, aanbevolenTechniek, aanbevolenIoTApparaat, gebiedenLijst, selectedPlaats.getStrPropNaam());	
				huidigeAdvies.setPva("N.v.t.");
			}
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in DBFunctionaliteit.getAdviceDataFromDB(): " + se.getMessage());
		}
		finally
		{
			try 
			{
				if(con != null)
					con.close();
			}
			catch(SQLException se)
			{
				System.out.println("SQL-error in DBFunctionaliteit.getAdviceDataFromDB(): " + se.getMessage());
			}
		}		
		
		return huidigeAdvies;
	}
	
	//Haal gegevens uit de database op voor alle IoT-apparaten
	protected ObservableList getIoTDataFromDB(Plaats selectedPlaats)
	{
		ObservableList<IoTApparaat> selectieLijst = FXCollections.observableArrayList();
		
		Connection con = null;
		try 
		{
			con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM IoTApparaat WHERE plaatsNaam = '" + selectedPlaats.getStrPropNaam() + "';");
			ResultSet result2 = null;
			while(result.next())
			{	
				IoTApparaat selectedIoT = new IoTApparaat();
				selectedIoT.setIntPropActivNum(result.getInt("IoTNummer"));
				selectedIoT.setStrPropDataSoort(result.getString("dataSoort"));
				selectedIoT.setStrPropNaam(result.getString("naam"));
				selectedIoT.setStrPropPlaatsNaam(result.getString("plaatsNaam"));
				selectieLijst.add(selectedIoT);
			}
			
			for(IoTApparaat o : selectieLijst)
			{
				//Hier wordt ieder IoT-apparaat aan een activiteit gekoppeld met overeenkomende datasoort
				result2 = stat.executeQuery("SELECT * FROM Activiteit WHERE dataSoort = '" + o.getStrPropDataSoort() + "' AND plaatsNaam = '" + o.getStrPropPlaatsNaam() + "';");
				if(result2.next())
				{
					if(result2.getInt("activiteitNummer") != 0)
						o.setIntPropIoTNum(result2.getInt("activiteitNummer"));
					if(!result2.getString("naam").isEmpty())
						o.setStrPropActivNaam(result2.getString("naam"));	
				}
			}
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in DBFunctionaliteit.getIoTDataFromDB(): " + se.getMessage());
		}
		finally
		{
			try 
			{
				if(con != null)
					con.close();
			}
			catch(SQLException se)
			{
				System.out.println("SQL-error in DBFunctionaliteit.getIoTDataFromDB(): " + se.getMessage());
			}
		}	
		
		return selectieLijst;
	}
	
	//Haal gegevens uit de database op voor alle plaatsen
	protected ObservableList getGeoDataFromDB()
	{
		ObservableList<Plaats> selectieLijst = FXCollections.observableArrayList();
		
		Connection con = null;
		try 
		{
			con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Plaats;");
			ResultSet result2 = null;
			while(result.next())
			{	
				Plaats selectedPlaats = new Plaats();
				selectedPlaats.setStrPropNaam(result.getString("naam"));
				selectedPlaats.setStrPropStatus(result.getBoolean("isSmart") ? "ja" : "nee");
				selectedPlaats.setStrPropOppervlakte(Double.toString(result.getDouble("oppervlakte")) + " km2");
				selectedPlaats.setIntPropGemeentePop(result.getInt("gemeentelijkePopulatie"));
				selectedPlaats.setIntPropStadPop(result.getInt("stedelijkePopulatie"));
				selectedPlaats.setIntPropMetroPop(result.getInt("metroPopulatie"));
				selectedPlaats.setStrPropGemeente(result.getString("gemeente"));		
				selectieLijst.add(selectedPlaats);
			}
			
			for(Plaats o : selectieLijst)
			{
				//Haal tevredenheid van alle burgers op die over de huidige plaats heeft aangegeven
				result2 = stat.executeQuery("SELECT AVG(tevredenheidPlaats) AS tevredenHeid FROM Burger WHERE plaatsNaam = '" + o.getStrPropNaam() + "';");
				if(result2.next())
					o.setStrPropTevreden(Double.toString(result2.getDouble("tevredenHeid") * 100) + "%");		
			}
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in DBFunctionaliteit.getGeoDataFromDB(): " + se.getMessage());
		}
		finally
		{
			try 
			{
				if(con != null)
					con.close();
			}
			catch(SQLException se)
			{
				System.out.println("SQL-error in DBFunctionaliteit.getGeoDataFromDB(): " + se.getMessage());
			}
		}	
		
		return selectieLijst;
	}
	
	//Voer gegevens uit de geselecteerde burger en plaats in de database
	protected Boolean setFeedbackFormToDB(Burger burger)
	{
		Connection con = null;
		int dbResult = 0;
		try 
		{
			con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			
			String sqlStatement = null;
			
			if(this.getCitizenDataFromDB(burger.getIntPropBSN()) != null)
				sqlStatement = "UPDATE Burger SET naam = '" + burger.getStrPropNaam() + "', tevredenheidPlaats = " + (burger.getTevredenheidPlaats() ? 1 : 0) + ", mening = '" + burger.getMening() + "', plaatsNaam = '" + burger.getStrPropPlaatsNaam() + "' WHERE BSNnummer = " + burger.getIntPropBSN() + ";";		
			else
				sqlStatement = "INSERT INTO Burger VALUES (" + burger.getIntPropBSN() + ",'" + burger.getStrPropNaam()  + "'," + (burger.getTevredenheidPlaats() ? 1 : 0) + ",'" + burger.getStrPropPlaatsNaam() + "','" + burger.getMening() + "');";			
			
			dbResult = stat.executeUpdate(sqlStatement);
			if(dbResult > 0)
				return true;
			else
				return false;	
		}
		catch(SQLException se)
		{
			System.out.println("SQL-error in DBFunctionaliteit.setFeedbackFormToDB(): " + se.getMessage());
			if(dbResult > 0)
				return true;
			else
				return false;	
		}
		finally
		{
			try 
			{
				if(con != null)
					con.close();
			}
			catch(SQLException se)
			{
				System.out.println("SQL-error in DBFunctionaliteit.setFeedbackFormToDB(): " + se.getMessage());
			}
		}	
	};
}
