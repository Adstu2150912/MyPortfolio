package com.AAAD.CBR_Docs.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javafx.scene.control.ListCell;
import javafx.util.StringConverter;
import javafx.scene.control.ComboBox;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: KoppelingBedieningSoort.java
 */

public class KoppelingBedieningSoort 
{
	private String kopBedienSoort;		
	
	public String getKopBedienSoort() {
		return kopBedienSoort;
	}

	public void setKopBedienSoort(String kopBedienSoort) {
		this.kopBedienSoort = kopBedienSoort;
	}

	public void fillCbxKoppeling(ComboBox<KoppelingBedieningSoort> cbx)
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM KoppelingBedieningSoort;");
			
			KoppelingBedieningSoort koppelingDummy = new KoppelingBedieningSoort();
			koppelingDummy.setKopBedienSoort("Geen");
			cbx.getItems().add(koppelingDummy); //Voeg standaard keuzeoptie toe in deze combobox
			
			while(result.next())
			{
				KoppelingBedieningSoort newKoppeling = new KoppelingBedieningSoort();
				newKoppeling.kopBedienSoort = result.getString("KopBedienSoort");
				cbx.getItems().add(newKoppeling);
			}
			con.close();	
			//Pas de volledige weergave van de onderstaande combobox aan
			
			//Bron: https://stackoverflow.com/questions/41634789/javafx-combobox-display-text-but-return-id-on-selection
			cbx.setConverter(new StringConverter<KoppelingBedieningSoort>() 
			{
				@Override
				public String toString(KoppelingBedieningSoort item)
				{
					return item.getKopBedienSoort();
				}
				
				@Override
				public KoppelingBedieningSoort fromString(String text)
				{
					return cbx.getItems().stream().filter(ap -> ap.getKopBedienSoort().equals(text)).findFirst().orElse(null);
				}
			});
			
			cbx.valueProperty().addListener((obs, oldval, newval) -> 
			{
				if(newval != null)
					System.out.println("Geselecteerde koppelingbedieningsoort: " + newval.getKopBedienSoort());
			});
			
			//Bron: https://stackoverflow.com/questions/50448815/javafx-combobox-displaying-object-not-its-property
			
			//cbx.setCellFactory(listview -> new KopBedienSoortListCell());
			//cbx.setButtonCell(new KopBedienSoortListCell());
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
//	private static class KopBedienSoortListCell extends ListCell<KoppelingBedieningSoort>
//	{
//		@Override
//		public void updateItem(KoppelingBedieningSoort item, boolean empty)
//		{
//			super.updateItem(item, empty);
//			if(item != null)
//				setText(item.getKopBedienSoort()); //geef de unieke naam van dit object terug
//			else
//				setText(null);
//		}
//	}
	
	public KoppelingBedieningSoort()
	{
		
	}
}
