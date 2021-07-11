package com.mycompany.PatientenDossierModule;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.*;


/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 20-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: VerwijderKlantScherm.java
 */

public class VerwijderKlantScherm 
{
	public final Button btnKlant, btnPatiënt, btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen, btnBevestigen;
	private final Label lblKlant;
	public final VBox hoofdContainer;
	public FlowPane hoofdMenu, subMenu;
	public GridPane hoofdVenster;
	private ObservableList<Klant> klantenLijst = FXCollections.observableArrayList();
	public TableView<Klant> selectieTabel = new TableView<Klant>(klantenLijst);
	
	public VerwijderKlantScherm()
	{
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
		lblKlant = new Label("Verwijder klant:");
		hoofdContainer = new VBox();			
		
		subMenu.setVisible(false);		
		
		lblKlant.setFont(new Font("Arial", 18));
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
		
		
		//hoofdMenu.setPadding(new Insets(10, 15, 20, 25));
		hoofdMenu.setStyle("-fx-background-color:#000000; -fx-opacity:1;");
		subMenu.setStyle("-fx-background-color:#568780;");		
		
		hoofdVenster.setHgap(10);
		hoofdVenster.setVgap(5);
		hoofdVenster.setPadding(new Insets(10, 15, 20, 25));
		hoofdVenster.setStyle("-fx-background-color:#DCDCE6;");		
		
		hoofdMenu.getChildren().addAll(btnKlant, btnPatiënt);		
		subMenu.getChildren().addAll(btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen);		
		
		hoofdVenster.add(lblKlant, 0, 0);
		hoofdVenster.add(selectieTabel, 0, 1, 3, 3);
		hoofdVenster.add(btnBevestigen, 5, 5);			
		
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
				
		//  hoofdContainer.setSpacing(5);
        //  hoofdContainer.setPadding(new Insets(10));
		
		hoofdContainer.getChildren().addAll(hoofdMenu, subMenu, hoofdVenster);
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);		
		
		this.selectieKlant();
	}
	
	//Haal alle klanten op die bestaan in de database
	public void selectieKlant()
	{
		try 
		{
			Connection con = DBCPDataSource.getConnection();
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM Klant");
			
			while(result.next())
			{	
				Klant huidigeKlant = new Klant();
				huidigeKlant.setNaam(result.getString("Naam"));
				huidigeKlant.setKlantNummer(result.getInt("Klantnummer"));
				huidigeKlant.setGeboorteDatum(result.getString("Geboortedatum"));
				huidigeKlant.setWoonAdres(result.getString("Woonadres"));
				huidigeKlant.setTelefoonNummer(result.getString("Telefoonnummer"));
				huidigeKlant.setEmailAdres(result.getString("Patiëntnaam"));
				huidigeKlant.setGeslacht(result.getBoolean("Geslacht"));
				huidigeKlant.setPatiëntNaam(result.getString("Patiëntnaam"));
				huidigeKlant.setPatiëntNummer(result.getInt("Patiëntnummer"));
				klantenLijst.add(huidigeKlant);
			}
			
			TableColumn<Klant, String> NaamCol = new TableColumn<Klant, String>("Naam");
			NaamCol.setCellValueFactory(new PropertyValueFactory("naam"));
			
			TableColumn<Klant, String> KlantNrCol = new TableColumn<Klant, String>("Klantnummer");
			KlantNrCol.setCellValueFactory(new PropertyValueFactory("klantNummer"));
			
			TableColumn<Klant, String> GebDatumCol = new TableColumn<Klant, String>("GeboorteDatum");
			GebDatumCol.setCellValueFactory(new PropertyValueFactory("geboorteDatum"));
			
			selectieTabel.getColumns().setAll(KlantNrCol, NaamCol, GebDatumCol);
			
			//selectieTabel.setItems(klantenLijst);
			//selectieTabel.getSelectionModel().getSelectedItem().getPatiëntNummer();
		}
		catch(SQLException se) 
		{
			System.out.println(se.getMessage());
		}	
	}
}
