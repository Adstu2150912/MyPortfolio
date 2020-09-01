package com.AAAD.CBR_Docs.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import com.AAAD.CBR_Docs.Model.DBCPDataSource;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 27-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: ExamenSet.java
 */

public class ExamenSet extends KandidaatExamenSet
{
	private StringProperty privStrPropExamenCode, privStrPropExamDatum, privStrPropExamTijd, privStrPropKopBedienSoort, privStrPropResultaat, privStrPropProductCode, privStrPropCategorieCode, privStrPropExamLocNaam;
	protected String kopBedienSoort, resultaat, productCode, categorieCode, productNaam, categorieNaam, examLocNaam;
	protected LocalDate examDatum;
	protected LocalTime examTijd;
	private int totaalExamensVol, totaalExamensOnvol, examensAutomaatVol, examensAutomaatOnvol, examensCombiVol, examensCombiOnvol, examensHandVol, examensHandOnvol,
	totaalHerExamensVol, totaalHerExamensOnvol, herexamenAutomaatVol, herexamenAutomaatOnvol, herexamenCombiVol, herexamenCombiOnvol, herexamenHandVol, herexamenHandOnvol;
	private ObservableList<ExamenSet> selectieExamenLijst;
	private Boolean isHerexamen;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
	
	public int getTotaalExamensVol() {
		return totaalExamensVol;
	}

	public void setTotaalExamensVol(int totaalExamensVol) {
		this.totaalExamensVol = totaalExamensVol;
	}

	public int getTotaalExamensOnvol() {
		return totaalExamensOnvol;
	}

	public void setTotaalExamensOnvol(int totaalExamensOnvol) {
		this.totaalExamensOnvol = totaalExamensOnvol;
	}

	public int getExamensAutomaatVol() {
		return examensAutomaatVol;
	}

	public void setExamensAutomaatVol(int examensAutomaatVol) {
		this.examensAutomaatVol = examensAutomaatVol;
	}

	public int getExamensAutomaatOnvol() {
		return examensAutomaatOnvol;
	}

	public void setExamensAutomaatOnvol(int examensAutomaatOnvol) {
		this.examensAutomaatOnvol = examensAutomaatOnvol;
	}

	public int getExamensCombiVol() {
		return examensCombiVol;
	}

	public void setExamensCombiVol(int examensCombiVol) {
		this.examensCombiVol = examensCombiVol;
	}

	public int getExamensCombiOnvol() {
		return examensCombiOnvol;
	}

	public void setExamensCombiOnvol(int examensCombiOnvol) {
		this.examensCombiOnvol = examensCombiOnvol;
	}

	public int getExamensHandVol() {
		return examensHandVol;
	}

	public void setExamensHandVol(int examensHandVol) {
		this.examensHandVol = examensHandVol;
	}

	public int getExamensHandOnvol() {
		return examensHandOnvol;
	}

	public void setExamensHandOnvol(int examensHandOnvol) {
		this.examensHandOnvol = examensHandOnvol;
	}

	public int getTotaalHerExamensVol() {
		return totaalHerExamensVol;
	}

	public void setTotaalHerExamensVol(int totaalHerExamensVol) {
		this.totaalHerExamensVol = totaalHerExamensVol;
	}

	public int getTotaalHerExamensOnvol() {
		return totaalHerExamensOnvol;
	}

	public void setTotaalHerExamensOnvol(int totaalHerExamensOnvol) {
		this.totaalHerExamensOnvol = totaalHerExamensOnvol;
	}

	public int getHerexamenAutomaatVol() {
		return herexamenAutomaatVol;
	}

	public void setHerexamenAutomaatVol(int herexamenAutomaatVol) {
		this.herexamenAutomaatVol = herexamenAutomaatVol;
	}

	public int getHerexamenAutomaatOnvol() {
		return herexamenAutomaatOnvol;
	}

	public void setHerexamenAutomaatOnvol(int herexamenAutomaatOnvol) {
		this.herexamenAutomaatOnvol = herexamenAutomaatOnvol;
	}

	public int getHerexamenCombiVol() {
		return herexamenCombiVol;
	}

	public void setHerexamenCombiVol(int herexamenCombiVol) {
		this.herexamenCombiVol = herexamenCombiVol;
	}

	public int getHerexamenCombiOnvol() {
		return herexamenCombiOnvol;
	}

	public void setHerexamenCombiOnvol(int herexamenCombiOnvol) {
		this.herexamenCombiOnvol = herexamenCombiOnvol;
	}

	public int getHerexamenHandVol() {
		return herexamenHandVol;
	}

	public void setHerexamenHandVol(int herexamenHandVol) {
		this.herexamenHandVol = herexamenHandVol;
	}

	public int getHerexamenHandOnvol() {
		return herexamenHandOnvol;
	}

	public void setHerexamenHandOnvol(int herexamenHandOnvol) {
		this.herexamenHandOnvol = herexamenHandOnvol;
	}

	public StringProperty pubStrPropExamenCode() 
	{
		if(privStrPropExamenCode == null) 
		{
			privStrPropExamenCode = new SimpleStringProperty(this, "strPropExamenCode");
		}
		return privStrPropExamenCode;
	}

	public String getStrPropExamenCode() 
	{
		return pubStrPropExamenCode().get();
	}


	public void setStrPropExamenCode(String value) 
	{
		pubStrPropExamenCode().set(value);
	}
	
	public StringProperty pubStrPropExamDatum()
	{
		if(privStrPropExamDatum == null)
		{
			privStrPropExamDatum = new SimpleStringProperty(this, "strPropExamDatum");
		}
		return privStrPropExamDatum;
	}
	
	public String getStrPropExamDatum()
	{
		return pubStrPropExamDatum().get();
	}
	
	public void setStrPropExamDatum(String value)
	{
		pubStrPropExamDatum().set(value);
	}
	
	public StringProperty pubStrPropExamTijd()
	{
		if(privStrPropExamTijd == null)
		{
			privStrPropExamTijd = new SimpleStringProperty(this, "strPropExamTijd");
		}
		return privStrPropExamTijd;
	}
	
	public String getStrPropExamTijd()
	{
		return pubStrPropExamTijd().get();
	}
	
	public void setStrPropExamTijd(String value)
	{
		pubStrPropExamTijd().set(value);
	}
	
	public StringProperty pubStrPropKopBedienSoort()
	{
		if(privStrPropKopBedienSoort == null)
		{
			privStrPropKopBedienSoort = new SimpleStringProperty(this, "strPropKopBedienSoort");
		}
		return privStrPropKopBedienSoort;
	}
	
	public String getStrPropKopBedienSoort()
	{
		return pubStrPropKopBedienSoort().get();
	}
	
	public void setStrPropKopBedienSoort(String value)
	{
		pubStrPropKopBedienSoort().set(value);
	}
	
	public StringProperty pubStrPropResultaat()
	{
		if(privStrPropResultaat == null)
		{
			privStrPropResultaat = new SimpleStringProperty(this, "strPropResultaat");
		}
		return privStrPropResultaat;
	}
	
	public String getStrPropResultaat()
	{
		return pubStrPropResultaat().get();
	}
	
	public void setStrPropResultaat(String value)
	{
		pubStrPropResultaat().set(value);
	}
	
	public StringProperty pubStrPropProductCode()
	{
		if(privStrPropProductCode == null)
		{
			privStrPropProductCode = new SimpleStringProperty(this, "strPropProductCode");
		}
		return privStrPropProductCode;
	}
	
	public String getStrPropProductCode()
	{
		return pubStrPropProductCode().get();
	}
	
	public void setStrPropProductCode(String value)
	{
		pubStrPropProductCode().set(value);
	}
	
	public StringProperty pubStrPropCategorieCode()
	{
		if(privStrPropCategorieCode == null)
		{
			privStrPropCategorieCode = new SimpleStringProperty(this, "strPropCategorieCode");
		}
		return privStrPropCategorieCode;
	}
	
	public String getStrPropCategorieCode()
	{
		return pubStrPropCategorieCode().get();
	}
	
	public void setStrPropCategorieCode(String value)
	{
		pubStrPropCategorieCode().set(value);
	}
	
	public StringProperty pubStrPropExamLocNaam()
	{
		if(privStrPropExamLocNaam == null)
		{
			privStrPropExamLocNaam = new SimpleStringProperty(this, "strPropExamLocNaam");
		}
		return privStrPropExamLocNaam;
	}
	
	public String getStrPropExamLocNaam()
	{
		return pubStrPropExamLocNaam().get();
	}
	
	public void setStrPropExamLocNaam(String value)
	{
		pubStrPropExamLocNaam().set(value);
	}
	
	public LocalDate getExamDatum()
	{
		return examDatum;
	}
	
	public void setExamDatum(LocalDate value)
	{
		examDatum = value;
	}
	
	public LocalTime getExamTijd()
	{
		return examTijd;
	}
	
	public void setExamTijd(LocalTime value)
	{
		examTijd = value;
	}
	
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
	
	public String getOpleiderCode()
	{
		return this.opleiderCode;
	}
	
	public void setOpleiderCode(String value)
	{
		this.opleiderCode = value;
	}
	
	public String getOpleiderNaam()
	{
		return this.opleiderNaam;
	}
	
	public void setOpleiderNaam(String value)
	{
		this.opleiderNaam = value;
	}
	
	public String getOpleiderSet()
	{
		return (this.getOpleiderNaam() + " [" + this.getOpleiderCode() + "]");
	}	
	
	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getCategorieNaam() {
		return categorieNaam;
	}

	public void setCategorieNaam(String categorieNaam) {
		this.categorieNaam = categorieNaam;
	}
	
	public Boolean getIsHerexamen() {
		return isHerexamen;
	}

	public void setIsHerexamen(Boolean isHerexamen) {
		this.isHerexamen = isHerexamen;
	}

	public void invoeren() throws SQLException
	{
		//int dbResult = 0;
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			
			String insertStatement = "INSERT INTO ExamenSet VALUES ('" + this.getExamenCode() + "','" + this.getStrPropExamDatum() + "','" + this.getStrPropExamTijd() + "','" + this.getStrPropKopBedienSoort()
			+ "','" + this.getStrPropResultaat() + "','" + this.getStrPropProductCode() + "','" + this.getStrPropCategorieCode() + "','" + this.getStrPropExamLocNaam()  + "', " + this.getIsHerexamen() + ");";			
			
			stat.executeUpdate(insertStatement);
			con.close();
			this.kandidaatInvoeren();
			//dbResult = this.kandidaatInvoeren();
			//return dbResult;
		}
		catch(SQLException se)
		{
			if(!con.isClosed())
				con.close();
			System.out.println("SQL-error in invoeren() uit klasse ExamenSet: " + se.getMessage());
			throw se;
			//return dbResult;
		}
	}
	
	public void bewerken() throws SQLException
	{
		this.kandidaatBewerken();
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			
			String updateStatement = "UPDATE ExamenSet SET Examencode = '" + this.getExamenCode() + "', ExamDatum = '" + this.getStrPropExamDatum() + "', ExamTijd = '" + this.getStrPropExamTijd() + "', KopBedienSoort = '" + this.getStrPropKopBedienSoort()
			+ "', Resultaat = '" + this.getStrPropResultaat() + "', ProductCode = '" + this.getStrPropProductCode() + "', CategorieCode = '" + this.getStrPropCategorieCode() + "', ExamLocNaam = '" + this.getStrPropExamLocNaam()  + "', IsHerexamen = " + this.getIsHerexamen() + " WHERE Examencode = '" + this.getExamenCode() + "';";			
			
			stat.executeUpdate(updateStatement);
			//return 1; //Geef aan dat de uitvoering van de update-statement succesvol is uitgevoerd
		}
		catch(SQLException se)
		{
			System.out.println("SQL-error in bewerken() uit klasse ExamenSet: " + se.getMessage());	
			throw se;
			//return 0; //Geef aan dat de uitvoering de update-statement is mislukt
		}
		finally
		{
			con.close();
		}
	}
	
	public void verwijderen() throws SQLException
	{
		this.kandidaatVerwijderen();
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			
			String deleteStatement = "DELETE FROM ExamenSet WHERE Examencode = '" + this.getExamenCode() + "';";			
			
			stat.executeUpdate(deleteStatement);	
			//return 1;  //Geef aan dat de uitvoering van de delete-statement succesvol is uitgevoerd
		}
		catch(SQLException se)
		{
			System.out.println("SQL-error in verwijderen() uit klasse ExamenSet: " + se.getMessage());	
			throw se;
			//return 0; //Geef aan dat de uitvoering de delete-statement is mislukt
		}
		finally
		{
			con.close();
		}
	}
	
	//Onderstaande methode is bedoeld voor het tonen van alle rijen uit de tabel ExamenSet
	public void weergeven(TableView<ExamenSet> tbView) throws SQLException
	{
		//VMExamenSet newExamenSet = new VMExamenSet();//this.kandidaatWeergeven();
		selectieExamenLijst = FXCollections.observableArrayList();
		tbView.setItems(selectieExamenLijst);
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM vwZoekExamenSet");
			
			while(result.next())
			{
				ExamenSet newExamenSet = new ExamenSet();
				newExamenSet.setStrPropExamenCode(result.getString("Examencode"));
				if(result.getDate("ExamDatum") != null)
				{
					newExamenSet.setStrPropExamDatum(sdf.format(result.getDate("ExamDatum")));
					newExamenSet.setExamDatum(result.getDate("ExamDatum").toLocalDate());		
				}			
				if(result.getTime("ExamTijd") != null)
				{
					newExamenSet.setStrPropExamTijd(result.getString("ExamTijd"));
					newExamenSet.setExamTijd(result.getTime("ExamTijd").toLocalTime());
				}
				newExamenSet.setStrPropKopBedienSoort(result.getString("KopBedienSoort"));
				newExamenSet.setStrPropResultaat(result.getString("Resultaat"));
				newExamenSet.setStrPropProductCode(result.getString("ProductCode"));
				newExamenSet.setStrPropCategorieCode(result.getString("CategorieCode"));
				newExamenSet.setProductNaam(result.getString("ProductNaam"));
				newExamenSet.setCategorieNaam(result.getString("CategorieNaam"));
				newExamenSet.setStrPropExamLocNaam(result.getString("ExamLocNaam"));
				newExamenSet.setKandiCode(result.getString("KandiCode"));
				newExamenSet.setKandiNaam(result.getString("KandiNaam"));
				newExamenSet.setOpleiderCode(result.getString("Opleidercode"));
				newExamenSet.setOpleiderNaam(result.getString("Opleidernaam"));
				newExamenSet.setIsHerexamen(result.getBoolean("IsHerexamen"));
//				for(KandidaatExamenSet a : newExamenSet.selectieKandidaatLijst)
//				{
//					if(this.getStrPropExamenCode() == a.examenCode)
//					{
//						this.setKandiCode(a.kandiCode);
//						this.setKandiNaam(a.kandiNaam);
//					}
//				}
				selectieExamenLijst.add(newExamenSet);
			}						
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in weergeven() uit klasse ExamenSet: " + se.getMessage());
		}
		finally
		{
			con.close();
		}
	}
	
	//Onderstaande methode is bedoeld voor het tonen van één door de gebruiker geselecteerde rij
	public void weergeven(TableView<ExamenSet> tbView, String selectedExamenCode) throws SQLException
	{
		//VMExamenSet newExamenSet = new VMExamenSet(); //this.kandidaatWeergeven(selectedExamenCode);
		selectieExamenLijst = FXCollections.observableArrayList();
		tbView.setItems(selectieExamenLijst);
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM vwZoekExamenSet WHERE ExamenSet.Examencode = " + selectedExamenCode);
			while(result.next())
			{				
				ExamenSet newExamenSet = new ExamenSet();
				newExamenSet.setStrPropExamenCode(selectedExamenCode);
				if(result.getDate("ExamDatum") != null)
				{
					newExamenSet.setStrPropExamDatum(sdf.format(result.getDate("ExamDatum")));
					newExamenSet.setExamDatum(result.getDate("ExamDatum").toLocalDate());		
				}	
				if(result.getTime("ExamTijd") != null)
				{
					newExamenSet.setStrPropExamTijd(result.getString("ExamTijd"));
					newExamenSet.setExamTijd(result.getTime("ExamTijd").toLocalTime());
				}
				newExamenSet.setStrPropKopBedienSoort(result.getString("KopBedienSoort"));
				newExamenSet.setStrPropResultaat(result.getString("Resultaat"));
				newExamenSet.setStrPropProductCode(result.getString("ProductCode"));
				newExamenSet.setStrPropCategorieCode(result.getString("CategorieCode"));
				newExamenSet.setProductNaam(result.getString("ProductNaam"));
				newExamenSet.setCategorieNaam(result.getString("CategorieNaam"));
				newExamenSet.setStrPropExamLocNaam(result.getString("ExamLocNaam"));
				newExamenSet.setKandiCode(result.getString("KandiCode"));
				newExamenSet.setKandiNaam(result.getString("KandiNaam"));
				newExamenSet.setOpleiderCode(result.getString("Opleidercode"));
				newExamenSet.setOpleiderNaam(result.getString("Opleidernaam"));
				newExamenSet.setIsHerexamen(result.getBoolean("IsHerexamen"));
//				for(KandidaatExamenSet a : newExamenSet.selectieKandidaatLijst)
//				{
//					if(this.getStrPropExamenCode() == a.examenCode)
//					{
//						this.setKandiCode(a.kandiCode);
//						this.setKandiNaam(a.kandiNaam);
//					}
//				}
					
				selectieExamenLijst.add(newExamenSet);
			}			
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in weergeven(TableView tbView, String selectedExamenCode) uit klasse ExamenSet:" + se.getMessage());
		}
		finally
		{
			con.close();
		}
	}	
	
	//Onderstaande methode is bedoeld voor het zoeken van rij(en) uit de database, a.d.h.v. de gebruiker ingevoerde zoekterm en zoekwaarde 
	public void zoeken(TableView<ExamenSet> tbView, String zoekTerm, String zoekWaarde, Boolean isHerexamen) throws SQLException
	{
		//VMExamenSet newExamenSet = new VMExamenSet();
		selectieExamenLijst = FXCollections.observableArrayList();
		tbView.setItems(selectieExamenLijst);
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM vwZoekExamenSet WHERE " + zoekTerm + (isHerexamen ? (" = " + 1) : (" LIKE '%" + zoekWaarde)) + "%';");
			
			while(result.next())
			{	
				ExamenSet newExamenSet = new ExamenSet();
				newExamenSet.setStrPropExamenCode(result.getString("Examencode"));
				if(result.getDate("ExamDatum") != null)
				{
					newExamenSet.setStrPropExamDatum(sdf.format(result.getDate("ExamDatum")));
					newExamenSet.setExamDatum(result.getDate("ExamDatum").toLocalDate());		
				}	
				if(result.getTime("ExamTijd") != null)
				{
					newExamenSet.setStrPropExamTijd(result.getString("ExamTijd"));
					newExamenSet.setExamTijd(result.getTime("ExamTijd").toLocalTime());
				}
				newExamenSet.setStrPropKopBedienSoort(result.getString("KopBedienSoort"));
				newExamenSet.setStrPropResultaat(result.getString("Resultaat"));
				newExamenSet.setStrPropProductCode(result.getString("ProductCode"));
				newExamenSet.setStrPropCategorieCode(result.getString("CategorieCode"));
				newExamenSet.setStrPropExamLocNaam(result.getString("ExamLocNaam"));
				newExamenSet.setKandiNaam(result.getString("KandiNaam"));
				newExamenSet.setKandiCode(result.getString("KandiCode"));
				newExamenSet.setOpleiderNaam(result.getString("Opleidernaam"));
				newExamenSet.setOpleiderCode(result.getString("Opleidercode"));
				selectieExamenLijst.add(newExamenSet);
			}			
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in zoeken(TableView tbView, String zoekTerm, String zoekWaarde) uit klasse ExamenSet:" + se.getMessage());
		}
		finally
		{
			con.close();
		}
	}
	
	/*Onderstaande methode is bedoeld voor het tonen van diverse statistieken. Deze kunnen gesorteerd worden op, de gebruiker geselecteerde, rijopleider, categorie en/of examenlocatienaam*/
	public void toonExamenStatistieken() throws SQLException
	{
		Connection con = DBCPDataSource.getConnection();;
		try 
		{
			Statement stat = con.createStatement();			
			ResultSet result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende'"); //Totaal Eerste Examens/Toetsen Voldoende
			result.next();
			this.totaalExamensVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND IsHerexamen = 0"); //Totaal Eerste Examens/Toetsen Onvoldoende
			result.next();
			this.totaalExamensOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 0"); //Eerste Examens/Toetsen Automaat Voldoende
			result.next();
			this.examensAutomaatVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 0"); //Eerste Examens/Toetsen Automaat Onvoldoende
			result.next();
			this.examensAutomaatOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 0"); //Eerste Examens/Toetsen Combi Voldoende
			result.next();
			this.examensCombiVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 0"); //Eerste Examens/Toetsen Combi Onvoldoende
			result.next();
			this.examensCombiOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 0"); //Eerste Examens/Toetsen Handgeschakeld Voldoende
			result.next();
			this.examensHandVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 0"); //Eerste Examens/Toetsen Handgeschakeld Onvoldoende
			result.next();
			this.examensHandOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND IsHerexamen = 1"); //Totaal Herexamens Voldoende
			result.next();
			this.totaalHerExamensVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND IsHerexamen = 1"); //Totaal Herexamens Onvoldoende
			result.next();
			this.totaalHerExamensOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 1"); //Herexamens Automaat Voldoende
			result.next();
			this.herexamenAutomaatVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 1"); //Herexamens Automaat Onvoldoende
			result.next();
			this.herexamenAutomaatOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 1"); //Herexamens Combi Voldoende
			result.next();
			this.herexamenCombiVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 1"); //Herexamens Combi Onvoldoende
			result.next();
			this.herexamenCombiOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 1"); //Herexamens Handgeschakeld Voldoende
			result.next();
			this.herexamenHandVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 1"); //Herexamens Handgeschakeld Onvoldoende
			result.next();
			this.herexamenHandOnvol = result.getInt("AantalExamens");
//			this.totaalExamensVol = 0;
//			this.totaalExamensOnvol = 0;
//			this.examensAutomaatVol = 0;
//			this.examensAutomaatOnvol = 0;
//			this.examensCombiVol = 0;
//			this.examensCombiOnvol = 0;
//			this.examensHandVol = 0;
//			this.examensHandOnvol = 0;
//			this.totaalHerExamensVol = 0;
//			this.totaalHerExamensOnvol = 0;
//			this.herexamenAutomaatVol = 0;
//			this.herexamenAutomaatOnvol = 0;
//			this.herexamenCombiVol = 0;
//			this.herexamenCombiOnvol = 0;
//			this.herexamenHandVol = 0;
//			this.herexamenHandOnvol = 0;
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in toonExamenStatistieken() uit klasse ExamenSet: " + se.getMessage());
		}
		finally 
		{
			con.close();
		}
	}
	
	
	/*Onderstaande methode is bedoeld voor het tonen van diverse statistieken. Deze kunnen gesorteerd worden op, de gebruiker geselecteerde, rijopleider, categorie en/of examenlocatienaam*/
	public void toonExamenStatistieken(OpleiderSet selectedOpleider, CategorieSet selectedCategorie, ExamenLocatieSet selectedExamenLocatie) throws SQLException
	{
		Connection con = DBCPDataSource.getConnection();
		try 
		{
			Statement stat = con.createStatement();
			String filterVelden = "";			
			
			if(selectedOpleider != null)
				if(selectedOpleider.getOpleiderNaam() != "Geen") 
					filterVelden += (" AND Opleidercode = '" + selectedOpleider.getOpleiderCode() + "'");						
			if(selectedCategorie != null)
				if(selectedCategorie.getCategorieNaam() != "Geen")
					filterVelden += (" AND CategorieCode = '" + selectedCategorie.getCategorieCode() + "'");
			if(selectedExamenLocatie != null)
				if(selectedExamenLocatie.getExamLocNaam() != "Geen")
					filterVelden += (" AND ExamLocNaam  = '" + selectedExamenLocatie.getExamLocNaam() + "'");			
			
			ResultSet result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende'" + filterVelden + ";"); //Totaal Eerste Examens/Toetsen Voldoende
			result.next();
			this.totaalExamensVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND IsHerexamen = 0" + filterVelden + ";"); //Totaal Eerste Examens/Toetsen Onvoldoende
			result.next();
			this.totaalExamensOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 0" + filterVelden + ";"); //Eerste Examens/Toetsen Automaat Voldoende
			result.next();
			this.examensAutomaatVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 0" + filterVelden + ";"); //Eerste Examens/Toetsen Automaat Onvoldoende
			result.next();
			this.examensAutomaatOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 0" + filterVelden + ";"); //Eerste Examens/Toetsen Combi Voldoende
			result.next();
			this.examensCombiVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 0" + filterVelden + ";"); //Eerste Examens/Toetsen Combi Onvoldoende
			result.next();
			this.examensCombiOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 0" + filterVelden + ";"); //Eerste Examens/Toetsen Handgeschakeld Voldoende
			result.next();
			this.examensHandVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 0" + filterVelden + ";"); //Eerste Examens/Toetsen Handgeschakeld Onvoldoende
			result.next();
			this.examensHandOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND IsHerexamen = 1" + filterVelden + ";"); //Totaal Herexamens Voldoende
			result.next();
			this.totaalHerExamensVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND IsHerexamen = 1" + filterVelden + ";"); //Totaal Herexamens Onvoldoende
			result.next();
			this.totaalHerExamensOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 1" + filterVelden + ";"); //Herexamens Automaat Voldoende
			result.next();
			this.herexamenAutomaatVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Automaat' AND IsHerexamen = 1" + filterVelden + ";"); //Herexamens Automaat Onvoldoende
			result.next();
			this.herexamenAutomaatOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 1" + filterVelden + ";"); //Herexamens Combi Voldoende
			result.next();
			this.herexamenCombiVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Combi' AND IsHerexamen = 1" + filterVelden + ";"); //Herexamens Combi Onvoldoende
			result.next();
			this.herexamenCombiOnvol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Voldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 1" + filterVelden + ";"); //Herexamens Handgeschakeld Voldoende
			result.next();
			this.herexamenHandVol = result.getInt("AantalExamens");
			result = stat.executeQuery("SELECT COUNT(Examencode) AS AantalExamens FROM vwExamenStatistieken WHERE Resultaat = 'Onvoldoende' AND KopBedienSoort = 'Handgeschakeld' AND IsHerexamen = 1" + filterVelden + ";"); //Herexamens Handgeschakeld Onvoldoende
			result.next();
			this.herexamenHandOnvol = result.getInt("AantalExamens");
//			this.totaalExamensVol = 0;
//			this.totaalExamensOnvol = 0;
//			this.examensAutomaatVol = 0;
//			this.examensAutomaatOnvol = 0;
//			this.examensCombiVol = 0;
//			this.examensCombiOnvol = 0;
//			this.examensHandVol = 0;
//			this.examensHandOnvol = 0;
//			this.totaalHerExamensVol = 0;
//			this.totaalHerExamensOnvol = 0;
//			this.herexamenAutomaatVol = 0;
//			this.herexamenAutomaatOnvol = 0;
//			this.herexamenCombiVol = 0;
//			this.herexamenCombiOnvol = 0;
//			this.herexamenHandVol = 0;
//			this.herexamenHandOnvol = 0;
		}
		catch(SQLException se) 
		{
			System.out.println("SQL-error in toonExamenStatistieken(String selectedOpleider, String selectedCategorie, String selectedExamenLocatie) uit klasse ExamenSet: " + se.getMessage());
		}
		finally
		{
			con.close();
		}
	}
		
	public ExamenSet()
	{
		
	}
}
