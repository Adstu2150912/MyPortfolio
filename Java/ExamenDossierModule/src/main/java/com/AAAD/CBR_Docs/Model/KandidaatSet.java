package com.AAAD.CBR_Docs.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

//import javafx.scene.control.ListCell;
import javafx.util.StringConverter;
import javafx.scene.control.ComboBox;

//import com.AAAD.CBR_Docs.ViewModel.VMExamenSet;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: KandidaatSet.java
 */

public class KandidaatSet extends RijOpleidingSet
{
	protected String kandiNaam, kandiStrnm, kandiHuisNrToev, kandiPost, kandiPlaats;
	protected int kandiHuisNr;
	private String kandiCode;
	
	public String getKandiCode()
	{
		return this.kandiCode;
	}
	
	public void setKandiCode(String value)
	{
		this.kandiCode = value;
	}
	
	public String getKandiNaam()
	{
		return this.kandiNaam;
	}
	
	public void setKandiNaam(String value)
	{
		this.kandiNaam = value;
	}
	
	public void fillCbxKandidaat(ComboBox<KandidaatSet> cbx)
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			Statement stat2 = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM KandidaatSet;");			
			ResultSet result2 = stat2.executeQuery("SELECT * FROM RijOpleidingSet JOIN OpleiderSet ON RijOpleidingSet.Opleidercode = OpleiderSet.Opleidercode;");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			
			KandidaatSet kandidaatDummy = new KandidaatSet();
			kandidaatDummy.setKandiCode("-");
			kandidaatDummy.setKandiNaam("Geen");
			cbx.getItems().add(kandidaatDummy); //Voeg standaard keuzeoptie toe in deze combobox
			
			while(result.next())
			{
				KandidaatSet newKandidaat = new KandidaatSet();
				newKandidaat.kandiNaam = result.getString("KandiNaam");
				newKandidaat.kandiCode = result.getString("KandiCode");
				newKandidaat.kandiStrnm = result.getString("KandiStrnm");
				newKandidaat.kandiHuisNr = result.getInt("KandiHuisNr");
				newKandidaat.kandiHuisNrToev = result.getString("KandiHuisNrToev");
				newKandidaat.kandiPost = result.getString("KandiPost");
				newKandidaat.kandiPlaats = result.getString("KandiPlaats");
				cbx.getItems().add(newKandidaat);
			}
			while(result2.next())
			{
				for(KandidaatSet x : cbx.getItems())
				{
					if(x.kandiCode.equals(result2.getString("KandiCode")))
					{
						x.opleiderCode = result2.getString("OpleiderSet.Opleidercode");
						x.opleiderNaam = result2.getString("OpleiderSet.Opleidernaam");
						if(result2.getDate("OpleiderStart") != null)
							x.opleiderStart = sdf.format(result2.getDate("OpleiderStart"));
						if(result2.getDate("OpleiderEind") != null)
							x.opleiderEind = sdf.format(result2.getDate("OpleiderEind"));
						x.opleiderStrnm = result2.getString("OpleiderStrnm");
						x.opleiderHuisNr = result2.getInt("OpleiderHuisNr");
						x.opleiderHuisNrToev = result2.getString("OpleiderHuisNrToev");
						x.opleiderPost = result2.getString("OpleiderPost");
						x.opleiderPlaats = result2.getString("OpleiderPlaats");						
					}
				}
			}
			con.close();
			//Pas de volledige weergave van de onderstaande combobox aan
			
			//Bron: https://stackoverflow.com/questions/41634789/javafx-combobox-display-text-but-return-id-on-selection
			cbx.setConverter(new StringConverter<KandidaatSet>() 
			{
				@Override
				public String toString(KandidaatSet item)
				{
					return "[" + item.getKandiCode() + "] " + item.getKandiNaam();
				}
				
				@Override
				public KandidaatSet fromString(String text)
				{
					return cbx.getItems().stream().filter(ap -> ap.getKandiNaam().equals(text)).findFirst().orElse(null);
				}
			});
			
			cbx.valueProperty().addListener((obs, oldval, newval) -> 
			{
				if(newval != null)
					System.out.println("Geselecteerde kandidaatset: " + newval.getKandiNaam() + ". ID: " + newval.getKandiCode());
			});
			
			//Bron: https://stackoverflow.com/questions/50448815/javafx-combobox-displaying-object-not-its-property
			
			//cbx.setCellFactory(listview -> new KandidaatListCell());
			//cbx.setButtonCell(new KandidaatListCell());
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
//	private static class KandidaatListCell extends ListCell<KandidaatSet>
//	{
//		@Override
//		public void updateItem(KandidaatSet item, boolean empty)
//		{
//			super.updateItem(item, empty);
//			if(item != null)
//				setText("[" + item.getKandiCode() + "] " + item.getKandiNaam()); //geef de unieke naam van dit object terug
//			else
//				setText(null);
//		}
//	}
	
	public KandidaatSet()
	{
		
	}
}
