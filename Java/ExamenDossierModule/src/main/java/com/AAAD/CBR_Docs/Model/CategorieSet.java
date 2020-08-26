package com.AAAD.CBR_Docs.Model;

import javafx.scene.control.ComboBox;
//import javafx.scene.control.ListCell;
import javafx.util.StringConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AAAD.CBR_Docs.Model.DBCPDataSource;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: CategorieSet.java
 */

public class CategorieSet extends ProductSet
{
	private String categorieCode, categorieNaam;		

	public String getCategorieCode() 
	{
		return categorieCode;
	}

	public void setCategorieCode(String categorieCode) 
	{
		this.categorieCode = categorieCode;
	}

	public String getCategorieNaam() 
	{
		return categorieNaam;
	}

	public void setCategorieNaam(String categorieNaam) 
	{
		this.categorieNaam = categorieNaam;
	}
	
	public String getProductCode() 
	{
		return productCode;
	}
	
	public void setProductCode(String productCode)
	{
		this.productCode = productCode;
	}
	
	public String getProductNaam()
	{
		return productNaam;
	}
	
	public void setProductNaam(String productNaam)
	{
		 this.productNaam = productNaam;
	}

	public void fillCbxCategorie(ComboBox<CategorieSet> cbx)
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			Statement stat2 = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM CategorieSet;");
			ResultSet result2 = stat2.executeQuery("SELECT * FROM ProductSet;");
			
			CategorieSet categorieDummy = new CategorieSet();
			categorieDummy.setCategorieCode("-");
			categorieDummy.setCategorieNaam("Geen");
			categorieDummy.setProductCode("-");
			categorieDummy.setProductNaam("Geen");
			
			cbx.getItems().add(categorieDummy); //Voeg standaard keuzeoptie toe in deze combobox
			
			while(result.next())
			{
				CategorieSet newCategorie = new CategorieSet();
				newCategorie.categorieNaam = result.getString("CategorieNaam");
				newCategorie.categorieCode = result.getString("CategorieCode");			
				
				cbx.getItems().add(newCategorie);
			}
			while(result2.next())
			{
				for(CategorieSet x : cbx.getItems())
				{					
					if(x.categorieCode.equals(result2.getString("ProductCode")))
					{
						x.productCode = result2.getString("ProductCode");
						x.productNaam = result2.getString("ProductNaam");
					}
				}
			}
			con.close();
			//Pas de volledige weergave van de onderstaande combobox aan
			
			//Bron: https://stackoverflow.com/questions/41634789/javafx-combobox-display-text-but-return-id-on-selection
			cbx.setConverter(new StringConverter<CategorieSet>() 
			{
				@Override
				public String toString(CategorieSet item)
				{
					return "Categorie: [" + item.getCategorieCode() + "] " + item.getCategorieNaam() + "; Product: [" + item.getProductCode() + "] " + item.getProductNaam();
				}
				
				@Override
				public CategorieSet fromString(String text)
				{
					return cbx.getItems().stream().filter(ap -> ap.getCategorieNaam().equals(text)).findFirst().orElse(null);
				}
			});
			
			cbx.valueProperty().addListener((obs, oldval, newval) -> 
			{
				if(newval != null)
					System.out.println("Geselecteerde categorieset: Categorie " + newval.getCategorieNaam() + "; Product " + newval.getProductNaam() + ". CategorieCode: [" + newval.getCategorieCode() + "] ProductCode: [" + newval.getProductCode() + "]");
			});
			
			//Bron: https://stackoverflow.com/questions/50448815/javafx-combobox-displaying-object-not-its-property
			//cbx.setCellFactory(listview -> new CategorieListCell());
			//cbx.setButtonCell(new CategorieListCell());
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
	}
	
//	private static class CategorieListCell extends ListCell<CategorieSet>
//	{
//		@Override
//		public void updateItem(CategorieSet item, boolean empty)
//		{
//			super.updateItem(item, empty);
//			if(item != null)
//				setText("Categorie: [" + item.getCategorieCode() + "] " + item.getCategorieNaam() + "; Product: [" + item.getProductCode() + "] " + item.getProductNaam() ); //geef de unieke naam van dit object terug
//			else
//				setText(null);
//		}
//	}
//	
	public CategorieSet()
	{
		
	}
}
