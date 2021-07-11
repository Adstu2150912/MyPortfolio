package com.mycompany.PatientenDossierModule;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.*;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup; //Voor het laten selecteren van hooguit 1 waarde uit een reeks

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 19-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: InvoerKlantScherm.java
 */

public class InvoerKlantScherm 
{
	public final Button btnKlant, btnPatiënt, btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen, btnBevestigen;
	private Label lblKlant, lblNaam, lblGeslacht, lblGeboorteDatum, lblTelefoonNr, lblEmailAdres, lblWoonAdres, lblPatiënt;
	private TextField txtfNaam, txtfGeboorteDatum, txtfTelefoonNr, txtfEmailAdres;
	private ToggleGroup tglGpGeslacht;
	private RadioButton rbMan, rbVrouw;
	private TextArea txtArWoonAdres;
	public final VBox hoofdContainer;
	public FlowPane hoofdMenu, subMenu;
	public GridPane hoofdVenster;
	private ObservableList<Patiënt> patiëntenLijst = FXCollections.observableArrayList();
	public TableView<Patiënt> selectieTabel = new TableView<Patiënt>(patiëntenLijst);
	private int nieuweKlantNr;
	
	public InvoerKlantScherm()
	{
		nieuweKlantNr = 0;
		double nColumns; //Aantal benodigde kolommen voor node-elementen in een GridPane
		double nRows; //Aantal benodige rijen voor de node-elementen in een GridPane
		hoofdMenu = new FlowPane();
		subMenu = new FlowPane(); //Menu dat pas verschijnt op het moment dat de knop 'Klant' of Patiënt is geklikt
		hoofdVenster = new GridPane();
		btnKlant = new Button("Klant");
		btnPatiënt = new Button("Patiënt");
		btnBekijken = new Button("Bekijken");
		btnInvoeren = new Button("Invoeren");
		btnBewerken = new Button("Bewerken");
		btnVerwijderen = new Button("Verwijderen");
		btnBevestigen = new Button("Bevestigen");
		lblKlant = new Label("Klant:");
		lblNaam = new Label("Naam:");
		lblGeslacht = new Label("Geslacht:");
		lblGeboorteDatum = new Label("Geboortedatum:");
		lblTelefoonNr = new Label("Telefoonnummer:");
		lblEmailAdres = new Label("Emailadres:");
		lblWoonAdres = new Label("Woonadres");
		lblPatiënt = new Label("Selecteer patiënt:");
		hoofdContainer = new VBox();
		txtfNaam = new TextField();
		tglGpGeslacht = new ToggleGroup();
		rbMan = new RadioButton();
		rbVrouw = new RadioButton();
		txtfGeboorteDatum = new TextField();
		txtfTelefoonNr = new TextField();
		txtfEmailAdres = new TextField();
		txtArWoonAdres = new TextArea();
		
		subMenu.setVisible(false);
		
		rbMan.setToggleGroup(tglGpGeslacht);
		rbVrouw.setToggleGroup(tglGpGeslacht);
		rbMan.setSelected(true);
		
		rbMan.setText("Man");
		rbVrouw.setText("Vrouw");
		
		lblKlant.setFont(new Font("Arial", 20));
		lblKlant.setTextFill(Color.DARKCYAN);
		
		btnKlant.setTextFill(Color.WHITE);
		btnKlant.setStyle("-fx-background-color:#000000;");
		btnKlant.setFont(new Font("Myriad-pro", 20));
		btnPatiënt.setTextFill(Color.WHITE);
		btnPatiënt.setStyle("-fx-background-color:#000000;");
		btnPatiënt.setFont(new Font("Myriad-pro", 20));
		btnBekijken.setTextFill(Color.WHITE);
		btnBekijken.setStyle("-fx-background-color:#568780;");
		btnBekijken.setFont(new Font("Myriad-pro", 20));
		btnInvoeren.setTextFill(Color.WHITE);
		btnInvoeren.setStyle("-fx-background-color:#568780;");
		btnInvoeren.setFont(new Font("Myriad-pro", 20));
		btnBewerken.setTextFill(Color.WHITE);
		btnBewerken.setStyle("-fx-background-color:#568780;");
		btnBewerken.setFont(new Font("Myriad-pro", 20));
		btnVerwijderen.setTextFill(Color.WHITE);
		btnVerwijderen.setStyle("-fx-background-color:#568780;");
		btnVerwijderen.setFont(new Font("Myriad-pro", 20));
		
		hoofdMenu.setStyle("-fx-background-color:#000000; -fx-opacity:1;");
		subMenu.setStyle("-fx-background-color:#568780;");
		
		txtfNaam.setFont(new Font("Verdana", 14));
		txtfGeboorteDatum.setFont(new Font("Verdana", 14));
		txtfTelefoonNr.setFont(new Font("Verdana", 14));
		txtfEmailAdres.setFont(new Font("Verdana", 14));
		txtArWoonAdres.setFont(new Font("Verdana", 14));	
		
		hoofdVenster.setHgap(10);
		hoofdVenster.setVgap(5);
		hoofdVenster.setPadding(new Insets(10, 15, 20, 25));
		hoofdVenster.setStyle("-fx-background-color:#DCDCE6;");
		
		hoofdMenu.getChildren().addAll(btnKlant, btnPatiënt);		
		subMenu.getChildren().addAll(btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen);		
		
		hoofdVenster.add(lblKlant, 0, 0);
		hoofdVenster.add(lblNaam, 0, 1);
		hoofdVenster.add(lblGeslacht, 0, 2);
		hoofdVenster.add(lblGeboorteDatum, 0, 3);
		hoofdVenster.add(lblTelefoonNr, 0, 4);
		hoofdVenster.add(lblEmailAdres, 0, 5);
		hoofdVenster.add(lblWoonAdres, 0, 6);
		hoofdVenster.add(lblPatiënt, 3, 1);
		
		hoofdVenster.add(txtfNaam, 1, 1);
		hoofdVenster.add(rbMan, 1, 2);
		hoofdVenster.add(rbVrouw, 2, 2);
		hoofdVenster.add(txtfGeboorteDatum, 1, 3);
		hoofdVenster.add(txtfTelefoonNr, 1, 4);
		hoofdVenster.add(txtfEmailAdres, 1, 5);
		hoofdVenster.add(txtArWoonAdres, 0, 7);
		hoofdVenster.add(selectieTabel, 4, 1);
		hoofdVenster.add(btnBevestigen, 7, 7);
		
		//JavaFX GridPane resizing of pane children
		//http://stackoverflow.com/questions/22298336/ddg#22299143
		nColumns = Math.floor(Math.sqrt(hoofdVenster.getChildren().size()) * 2 / 1.618); //1.618 == Golden Ratio
		nRows = Math.ceil(hoofdVenster.getChildren().size() / nColumns);

		for (int j = 0; j < nColumns; j++) {
		    ColumnConstraints cc = new ColumnConstraints();
		    cc.setHgrow(Priority.ALWAYS);
		    hoofdVenster.getColumnConstraints().add(cc);
		}

		for (int j = 0; j < nRows; j++) {
		    RowConstraints rc = new RowConstraints();
		    rc.setVgrow(Priority.ALWAYS);
		    hoofdVenster.getRowConstraints().add(rc);
		}
		
		hoofdContainer.getChildren().addAll(hoofdMenu, subMenu, hoofdVenster);
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);
		
		this.selectiePatiënt();
	}
	
	//Sla de, door de gebruiker gemaakte, nieuwe klant op in de database
	public int klantInvoeren()
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT COUNT(Klantnummer) AS AantalKlantNr FROM Klant");
			
			Klant nieuweKlant = new Klant();			
			Patiënt huidigePatiënt = selectieTabel.getSelectionModel().getSelectedItem();
			while(result.next())
			{	
				nieuweKlantNr = (result.getInt("AantalKlantNr") + 1);				
			}
			nieuweKlant.setKlantNummer(nieuweKlantNr);
			nieuweKlant.setNaam(txtfNaam.getText());
			nieuweKlant.setPatiëntNummer(nieuweKlantNr);
			nieuweKlant.setGeslacht((rbMan.isSelected() ? false : true));
			nieuweKlant.setGeboorteDatum(txtfGeboorteDatum.getText());
			nieuweKlant.setWoonAdres(txtArWoonAdres.getText());
			nieuweKlant.setTelefoonNummer(txtfTelefoonNr.getText());
			nieuweKlant.setEmailAdres(txtfEmailAdres.getText());
			nieuweKlant.setPatiëntNummer(huidigePatiënt.getPatiëntNummer());
			nieuweKlant.setPatiëntNaam(huidigePatiënt.getNaam());
			
			nieuweKlant.klantInvoeren();
			
//			stat.executeUpdate("INSERT INTO Klant VALUE (" + nieuweKlantNr + ",'" + txtfNaam.getText() + "', " 
//			+ (rbMan.isSelected() ? 0 : 1) + ",'" + txtfGeboorteDatum.getText() + "','" + txtArWoonAdres.getText() 
//			+ "','" + txtfTelefoonNr.getText() + "','" + txtfEmailAdres.getText() + "'," + huidigePatiënt.getPatiëntNummer() 
//			+ ",'" + huidigePatiënt.getNaam() + "');");			
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}
		
		return nieuweKlantNr;
	}
	
	//Haal alle klanten op die bestaan in de database
	public void selectiePatiënt()
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Patiënt");
			
			while(result.next())
			{	
				Patiënt huidigePatiënt = new Patiënt();
				huidigePatiënt.setNaam(result.getString("Naam"));
				huidigePatiënt.setPatiëntNummer(result.getInt("Patiëntnummer"));
				huidigePatiënt.setGeboorteDatum(result.getString("Geboortedatum"));
				huidigePatiënt.setDierSoort(result.getString("Diersoort"));
				huidigePatiënt.setDierRas(result.getString("Dierras"));
				huidigePatiënt.setGewicht(result.getDouble("Gewicht"));
				huidigePatiënt.setGeslacht(result.getBoolean("Geslacht"));
				huidigePatiënt.setLabUitslag(result.getString("Labuitslag"));
				huidigePatiënt.setOpnameVerslag(result.getString("Opnameverslag"));
				huidigePatiënt.setVerblijfRuimte(result.getString("VerblijfRuimte"));
				huidigePatiënt.setAanwezigheid(result.getBoolean("Aanwezigheid"));
				patiëntenLijst.add(huidigePatiënt);
			}
			
			TableColumn<Patiënt, String> NaamCol = new TableColumn<Patiënt, String>("Naam");
			NaamCol.setCellValueFactory(new PropertyValueFactory("naam"));
			
			TableColumn<Patiënt, String> PatiëntNrCol = new TableColumn<Patiënt, String>("Patiëntnummer");
			PatiëntNrCol.setCellValueFactory(new PropertyValueFactory("patiëntNummer"));
			
			TableColumn<Patiënt, String> GebDatumCol = new TableColumn<Patiënt, String>("GeboorteDatum");
			GebDatumCol.setCellValueFactory(new PropertyValueFactory("geboorteDatum"));
			
			selectieTabel.getColumns().setAll(PatiëntNrCol, NaamCol, GebDatumCol);
			
			//selectieTabel.setItems(klantenLijst);
			//selectieTabel.getSelectionModel().getSelectedItem().getPatiëntNummer();
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}	
	}
}
