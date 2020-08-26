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
 * Aanmaakdatum: 27-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: ExamenLocatieSet.java
 */

public class ExamenLocatieSet 
{
	private String examLocNaam, examLocStraatnm, examLocHuisNrToev, examLocPost, examLocPlaats;
	private int examLocHuisNr;		
	
	public String getExamLocNaam() {
		return examLocNaam;
	}

	public void setExamLocNaam(String examLocNaam) {
		this.examLocNaam = examLocNaam;
	}

	protected String getExamLocStraatnm() {
		return examLocStraatnm;
	}

	protected void setExamLocStraatnm(String examLocStraatnm) {
		this.examLocStraatnm = examLocStraatnm;
	}

	protected String getExamLocHuisNrToev() {
		return examLocHuisNrToev;
	}

	protected void setExamLocHuisNrToev(String examLocHuisNrToev) {
		this.examLocHuisNrToev = examLocHuisNrToev;
	}

	protected String getExamLocPost() {
		return examLocPost;
	}

	protected void setExamLocPost(String examLocPost) {
		this.examLocPost = examLocPost;
	}

	protected String getExamLocPlaats() {
		return examLocPlaats;
	}

	protected void setExamLocPlaats(String examLocPlaats) {
		this.examLocPlaats = examLocPlaats;
	}

	protected int getExamLocHuisNr() {
		return examLocHuisNr;
	}

	protected void setExamLocHuisNr(int examLocHuisNr) {
		this.examLocHuisNr = examLocHuisNr;
	}

	public void fillCbxExamenLocatie(ComboBox<ExamenLocatieSet> cbx)
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM ExamenLocatieSet;");
			
			ExamenLocatieSet examenLocatieDummy = new ExamenLocatieSet();
			examenLocatieDummy.setExamLocNaam("Geen");
			cbx.getItems().add(examenLocatieDummy); //Voeg standaard keuzeoptie toe in deze combobox
			
			while(result.next())
			{
				ExamenLocatieSet newExamenLocatie = new ExamenLocatieSet();
				newExamenLocatie.examLocNaam = result.getString("ExamLocNaam");
				newExamenLocatie.examLocStraatnm = result.getString("ExamLocStraatNm");
				newExamenLocatie.examLocHuisNr = result.getInt("ExamLocHuisNr");
				newExamenLocatie.examLocHuisNrToev = result.getString("ExamLocHuisNrToev");
				newExamenLocatie.examLocPost = result.getString("ExamLocPost");
				newExamenLocatie.examLocPlaats = result.getString("ExamLocPlaats");
				cbx.getItems().add(newExamenLocatie);
			}
			con.close();		
			//Pas de volledige weergave van de onderstaande combobox aan
			
			//Bron: https://stackoverflow.com/questions/41634789/javafx-combobox-display-text-but-return-id-on-selection
			cbx.setConverter(new StringConverter<ExamenLocatieSet>() 
			{
				@Override
				public String toString(ExamenLocatieSet item)
				{
					return item.getExamLocNaam();
				}
				
				@Override
				public ExamenLocatieSet fromString(String text)
				{
					return cbx.getItems().stream().filter(ap -> ap.getExamLocNaam().equals(text)).findFirst().orElse(null);
				}
			});
			
			cbx.valueProperty().addListener((obs, oldval, newval) -> 
			{
				if(newval != null)
					System.out.println("Geselecteerde examenlocatieset: " + newval.getExamLocNaam() + ". ID: " + newval.getExamLocNaam());
			});
			
			//Bron: https://stackoverflow.com/questions/50448815/javafx-combobox-displaying-object-not-its-property
			
			//cbx.setCellFactory(listview -> new ExamenLocatieListCell());
			//cbx.setButtonCell(new ExamenLocatieListCell());
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
//	private static class ExamenLocatieListCell extends ListCell<ExamenLocatieSet>
//	{
//		@Override
//		public void updateItem(ExamenLocatieSet item, boolean empty)
//		{
//			super.updateItem(item, empty);
//			if(item != null)
//				setText(item.getExamLocNaam()); //geef de unieke naam van dit object terug
//			else
//				setText(null);
//		}
//	}
	
	public ExamenLocatieSet()
	{
		
	}
}
