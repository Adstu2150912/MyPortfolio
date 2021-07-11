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
import javafx.scene.control.ScrollPane;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 17-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: KlantWeergaveScherm.java
 */

public class KlantWeergaveScherm {
	public final Button btnKlant, btnPatiënt, btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen;
	private Label lblKlant, lblNaam, lblGeslacht, lblGeboorteDatum, lblTelefoonNr, lblEmailAdres, lblWoonAdres, lblPatiënt;
	private Text txtNaam, txtGeslacht, txtGeboorteDatum, txtTelefoonNr, txtEmailAdres;
	private ScrollPane scrlPnWoonAdres, scrlPnPatiënt;
	public final VBox hoofdContainer;
	public FlowPane hoofdMenu, subMenu;
	public GridPane hoofdVenster;
	
	public KlantWeergaveScherm() 
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
		lblKlant = new Label("Klant:");
		lblNaam = new Label("Naam:");
		lblGeslacht = new Label("Geslacht:");
		lblGeboorteDatum = new Label("Geboortedatum:");
		lblTelefoonNr = new Label("Telefoonnummer:");
		lblEmailAdres = new Label("Emailadres:");
		lblWoonAdres = new Label("Woonadres");
		lblPatiënt = new Label("Patiënt:");		
		hoofdContainer = new VBox();
		txtNaam = new Text();
		txtGeslacht = new Text();
		txtGeboorteDatum = new Text();
		txtTelefoonNr = new Text();
		txtEmailAdres = new Text();
		scrlPnWoonAdres = new ScrollPane();
		scrlPnPatiënt = new ScrollPane();
		
		scrlPnWoonAdres.setMinViewportHeight(50);
		scrlPnWoonAdres.setMinViewportWidth(100);
		scrlPnPatiënt.setMinViewportHeight(50);
		scrlPnPatiënt.setMinViewportWidth(100);
		
		subMenu.setVisible(false);
		
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
		
		txtNaam.setFont(new Font("Verdana", 14));
		txtGeslacht.setFont(new Font("Verdana", 14));
		txtGeboorteDatum.setFont(new Font("Verdana", 14));
		txtTelefoonNr.setFont(new Font("Verdana", 14));
		txtEmailAdres.setFont(new Font("Verdana", 14));
		
		
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
		hoofdVenster.add(lblPatiënt, 2, 1);
		
		hoofdVenster.add(txtNaam, 1, 1);
		hoofdVenster.add(txtGeslacht, 1, 2);
		hoofdVenster.add(txtGeboorteDatum, 1, 3);
		hoofdVenster.add(txtTelefoonNr, 1, 4);
		hoofdVenster.add(txtEmailAdres, 1, 5);
		hoofdVenster.add(scrlPnWoonAdres, 0,6);
		hoofdVenster.add(scrlPnPatiënt, 2, 2);
		
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
	}
	
	public void klantGegevensVerwerken(Klant selectedKlant)
	{
		txtNaam.setText(selectedKlant.getNaam());
		txtGeslacht.setText(selectedKlant.getGeslacht() ? "Vrouw" : "Man"); // false = Man; true = vrouw
		txtGeboorteDatum.setText(selectedKlant.getGeboorteDatum());
		txtTelefoonNr.setText(selectedKlant.getTelefoonNummer());
		txtEmailAdres.setText(selectedKlant.getEmailAdres());
		scrlPnWoonAdres.setContent(new Text(selectedKlant.getWoonAdres()));
		scrlPnPatiënt.setContent(new Text("Patiëntnummer: " + Integer.toString(selectedKlant.getPatiëntNummer())
				+ "; Patiëntnaam: " + selectedKlant.getPatiëntNaam() + ";"));
	}
}
