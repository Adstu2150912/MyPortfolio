package com.AAAD.CBR_Docs.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.ListCell;
import javafx.util.StringConverter;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: Resultaat.java
 */

public class Resultaat 
{
	protected String resultaat;
	
	public String getResultaat() {
		return resultaat;
	}

	public void setResultaat(String resultaat) {
		this.resultaat = resultaat;
	}

	public void fillCbxResultaat(ComboBox<Resultaat> cbx)
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Resultaat;");
			
			Resultaat resultaatDummy = new Resultaat();
			resultaatDummy.setResultaat("Geen");
			cbx.getItems().add(resultaatDummy); //Voeg standaard keuzeoptie toe in deze combobox
			
			while(result.next())
			{				
				Resultaat newResultaat = new Resultaat();
				newResultaat.resultaat = result.getString("Resultaat");
				cbx.getItems().add(newResultaat);
			}
			con.close();
			//Pas de volledige weergave van de onderstaande combobox aan
			
			//Bron: https://stackoverflow.com/questions/41634789/javafx-combobox-display-text-but-return-id-on-selection
			cbx.setConverter(new StringConverter<Resultaat>() 
			{
				@Override
				public String toString(Resultaat item)
				{
					return item.getResultaat();
				}
				
				@Override
				public Resultaat fromString(String text)
				{
					return cbx.getItems().stream().filter(ap -> ap.getResultaat().equals(text)).findFirst().orElse(null);
				}
			});
			
			cbx.valueProperty().addListener((obs, oldval, newval) -> 
			{
				if(newval != null)
					System.out.println("Geselecteerde resultaat: " + newval.getResultaat());
			});
			
			//Bron: https://stackoverflow.com/questions/50448815/javafx-combobox-displaying-object-not-its-property
			
			//cbx.setCellFactory(listview -> new ResultaatListCell());
			//cbx.setButtonCell(new ResultaatListCell());
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
//	private static class ResultaatListCell extends ListCell<Resultaat>
//	{
//		@Override
//		public void updateItem(Resultaat item, boolean empty)
//		{
//			super.updateItem(item, empty);
//			if(item != null)
//				setText(item.getResultaat()); //geef de unieke naam van dit object terug
//			else
//				setText(null);
//		}
//	}
	
	public Resultaat()
	{
		
	}
}
