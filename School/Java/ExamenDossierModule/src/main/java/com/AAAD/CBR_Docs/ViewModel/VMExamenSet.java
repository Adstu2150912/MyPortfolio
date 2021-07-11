package com.AAAD.CBR_Docs.ViewModel;

import java.sql.SQLException;
import com.AAAD.CBR_Docs.Model.*;
import javafx.scene.control.TableView;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 1-12-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: VMExamenSet.java
 */

public class VMExamenSet 
{
	private ExamenSet examenSet;
	//Hieronder worden alle resultaten bewaard uit een SQL-query
	//public ObservableList<ExamenSet> selectieExamenLijst = FXCollections.observableArrayList();
	//public ObservableList<KandidaatExamenSet> selectieKandidaatLijst = FXCollections.observableArrayList();		
	
	public void weergeven(TableView<ExamenSet> tbView) throws SQLException
	{
		try 
		{
			examenSet = new ExamenSet();
			examenSet.weergeven(tbView);
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in weergeven() uit klasse ExamenSet: " + se.getMessage());
		}
	}
	
	public void weergeven(TableView<ExamenSet> tbView, String selectedExamenCode) throws SQLException
	{
		try 
		{
			examenSet = new ExamenSet();
			examenSet.weergeven(tbView, selectedExamenCode);
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in weergeven(TableView tbView, String selectedExamenCode) uit klasse ExamenSet:" + se.getMessage());
		}
	}
	
	public void zoeken(TableView<ExamenSet> tbView, String zoekTerm, String zoekWaarde, Boolean isHerexamen) throws SQLException
	{
		try 
		{
			examenSet = new ExamenSet();
			examenSet.zoeken(tbView, zoekTerm, zoekWaarde, isHerexamen);
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in zoeken(TableView tbView, String zoekTerm, String zoekWaarde) uit klasse ExamenSet:" + se.getMessage());
		}
	}	
	
	public VMExamenSet()
	{
		
	}
}
