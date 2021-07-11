package com.AAAD.CBR_Docs.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

//import javafx.scene.control.ListCell;
import javafx.util.StringConverter;
import javafx.scene.control.ComboBox;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 27-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: OpleiderSet.java
 */

public class OpleiderSet
{
	protected String opleiderNaam, opleiderStart, opleiderEind, opleiderStrnm, opleiderHuisNrToev, opleiderPost, opleiderPlaats;
	protected int opleiderHuisNr;
	private String opleiderCode;	
	
	public String getOpleiderNaam() {
		return opleiderNaam;
	}

	public void setOpleiderNaam(String opleiderNaam) {
		this.opleiderNaam = opleiderNaam;
	}

	public String getOpleiderCode() {
		return opleiderCode;
	}

	public void setOpleiderCode(String opleiderCode) {
		this.opleiderCode = opleiderCode;
	}

	public void fillCbxOpleider(ComboBox<OpleiderSet> cbx)
	{
		try
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM OpleiderSet;");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			
			OpleiderSet opleiderDummy = new OpleiderSet();
			opleiderDummy.setOpleiderCode("-");
			opleiderDummy.setOpleiderNaam("Geen");
			cbx.getItems().add(opleiderDummy); //Voeg standaard keuzeoptie toe in deze combobox
			
			while(result.next())
			{
				OpleiderSet newOpleider = new OpleiderSet();
				newOpleider.opleiderCode = result.getString("Opleidercode");
				newOpleider.opleiderNaam = result.getString("Opleidernaam");
				if(result.getDate("OpleiderStart") != null)
					newOpleider.opleiderStart = sdf.format(result.getDate("OpleiderStart"));
				if(result.getDate("OpleiderEind") != null)
					newOpleider.opleiderEind = sdf.format(result.getDate("OpleiderEind"));
				newOpleider.opleiderStrnm = result.getString("OpleiderStrnm");
				newOpleider.opleiderHuisNr = result.getInt("OpleiderHuisNr");
				newOpleider.opleiderHuisNrToev = result.getString("OpleiderHuisNrToev");
				newOpleider.opleiderPost = result.getString("OpleiderPost");
				newOpleider.opleiderPlaats = result.getString("OpleiderPlaats");
				cbx.getItems().add(newOpleider);
			}
			con.close();
			//Pas de volledige weergave van de onderstaande combobox aan
			
			//Bron: https://stackoverflow.com/questions/41634789/javafx-combobox-display-text-but-return-id-on-selection
			cbx.setConverter(new StringConverter<OpleiderSet>() 
			{
				@Override
				public String toString(OpleiderSet item)
				{
					return "[" + item.opleiderCode + "] " + item.opleiderNaam;
				}
				
				@Override
				public OpleiderSet fromString(String text)
				{
					return cbx.getItems().stream().filter(ap -> ap.getOpleiderNaam().equals(text)).findFirst().orElse(null);
				}
			});
			
			cbx.valueProperty().addListener((obs, oldval, newval) -> 
			{
				if(newval != null)
					System.out.println("Geselecteerde opleiderset: " + newval.getOpleiderNaam() + ". ID: " + newval.getOpleiderCode());
			});
			
			//Bron: https://stackoverflow.com/questions/50448815/javafx-combobox-displaying-object-not-its-property			
			
//			cbx.setCellFactory(listview -> new OpleiderListCell());
//			cbx.setButtonCell(cbx.getCellFactory().call(null));
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
//	private static class OpleiderListCell extends ListCell<OpleiderSet>
//	{
//		@Override
//		public void updateItem(OpleiderSet item, boolean empty)
//		{
//			super.updateItem(item, empty);
//			if(item != null)
//				setText("[" + item.opleiderCode + "] " + item.opleiderNaam); //geef de unieke naam van dit object terug
//			else
//				setText(null);
//		}
//	}
	
	public OpleiderSet()
	{
		
	}
}
