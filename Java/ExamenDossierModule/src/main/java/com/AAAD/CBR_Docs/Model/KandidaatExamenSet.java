package com.AAAD.CBR_Docs.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.AAAD.CBR_Docs.ViewModel.VMExamenSet;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: KandidaatExamenSet.java
 */

public class KandidaatExamenSet extends KandidaatSet
{
	protected String kandiCode, kandiNaam, examenCode;
	
	public String getKandiCode() {
		return kandiCode;
	}

	public void setKandiCode(String kandiCode) {
		this.kandiCode = kandiCode;
	}

	public String getKandiNaam() {
		return kandiNaam;
	}

	public void setKandiNaam(String kandiNaam) {
		this.kandiNaam = kandiNaam;
	}

	public String getExamenCode() {
		return examenCode;
	}

	public void setExamenCode(String examenCode) {
		this.examenCode = examenCode;
	}

	protected void kandidaatInvoeren() throws SQLException
	{
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			
			String insertStatement = "INSERT INTO KandidaatExamenSet VALUES ('" + this.kandiCode + "','" + this.kandiNaam + "','" + this.examenCode + "');";			
			
			stat.executeUpdate(insertStatement);
			//return 1; //Geef aan dat de uitvoering van de insert-statement succesvol is uitgevoerd
		}
		catch(SQLException se)
		{
			//System.out.println(se.getMessage());
			throw se;
			//return 0; //Geef aan dat de uitvoering de insert-statement is mislukt
		}
		finally 
		{
			con.close();
		}
	}
	
	protected void kandidaatBewerken() throws SQLException
	{
		Connection con = DBCPDataSource.getConnection();
		try 
		{			
			Statement stat = con.createStatement();
			
			String updateStatement = "UPDATE KandidaatExamenSet SET KandiCode = '" + this.kandiCode + "', KandiNaam = '" + this.kandiNaam + "', Examencode = '" + this.examenCode + "' WHERE Examencode = '" + this.examenCode + "';";			
			
			stat.executeUpdate(updateStatement);
			//return 1; //Geef aan dat de uitvoering van de update-statement succesvol is uitgevoerd
		}
		catch(SQLException se)
		{
			//System.out.println(se.getMessage());
			throw se;
			//return 0; //Geef aan dat de uitvoering de update-statement is mislukt
		}
		finally
		{
			con.close();
		}
	}
	
	protected void kandidaatVerwijderen() throws SQLException
	{
		Connection con = DBCPDataSource.getConnection();
		try 
		{			
			Statement stat = con.createStatement();
			
			String deleteStatement = "DELETE FROM KandidaatExamenSet WHERE KandiCode = '" + this.kandiCode + "' AND Examencode = '" + this.examenCode + "';";			
			
			stat.executeUpdate(deleteStatement);
			//return 1; //Geef aan dat de uitvoering van de delete-statement succesvol is uitgevoerd
		}
		catch(SQLException se)
		{
			//System.out.println(se.getMessage());
			throw se;
			//return 0; //Geef aan dat de uitvoering de delete-statement is mislukt
		}
		finally
		{
			con.close();
		}
	}
	
	protected void kandidaatWeergeven() throws SQLException
	{
		//VMExamenSet newExamenSet = new VMExamenSet();
		Connection con = DBCPDataSource.getConnection();
		try 
		{			
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM KandidaatExamenSet");
			
			while(result.next())
			{			
				kandiCode = result.getString("KandiCode");
				kandiNaam = result.getString("KandiNaam");
				examenCode = result.getString("Examencode");
				//newExamenSet.selectieKandidaatLijst.add(this);
			}			
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
		finally 
		{
			con.close();
		}
		
		//return newExamenSet;
	}
	
	protected void kandidaatWeergeven(String selectedExamenCode) throws SQLException
	{
		//VMExamenSet newExamenSet = new VMExamenSet();
		Connection con = DBCPDataSource.getConnection();
		try 
		{			
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM KandidaatExamenSet WHERE Examencode = " + selectedExamenCode);
			
			while(result.next())
			{			
				kandiCode = result.getString("KandiCode");
				kandiNaam = result.getString("KandiNaam");
				examenCode = result.getString("Examencode");
				//newExamenSet.selectieKandidaatLijst.add(this);
			}			
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
		finally 
		{
			con.close();
		}
		//return newExamenSet;
	}
	
	public KandidaatExamenSet()
	{
		
	}
}
