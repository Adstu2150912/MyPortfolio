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
 * Aanmaakdatum: 20-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: PatiëntWeergaveScherm.java
 */

public class PatiëntWeergaveScherm {

	public final Button btnKlant, btnPatiënt, btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen;
	private Label lblKlant, lblNaam, lblGeslacht, lblGeboorteDatum, lblDierSoort, lblDierRas, lblGewicht, lblVerblijfRuimte, lblAanwezigheid, lblLabUitslag, lblOpnameVerslag;
	private Text txtNaam, txtGeslacht, txtGeboorteDatum, txtDierSoort, txtDierRas, txtGewicht, txtVerblijfRuimte, txtAanwezigheid;
	private ScrollPane scrlPnLabUitslag, scrlPnOpnameVerslag;
	public final VBox hoofdContainer;
	public FlowPane hoofdMenu, subMenu;
	public GridPane hoofdVenster;
	
	public PatiëntWeergaveScherm() 
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
		lblKlant = new Label("Patiënt:");
		lblNaam = new Label("Naam:");
		lblGeslacht = new Label("Geslacht:");
		lblGeboorteDatum = new Label("Geboortedatum:");
		lblDierSoort = new Label("Diersoort:");
		lblDierRas = new Label("Dierras:");
		lblGewicht = new Label("Gewicht:");
		lblVerblijfRuimte = new Label("Verblijfruimte:");
		lblAanwezigheid = new Label("Aanwezig:");
		lblLabUitslag = new Label("Labuitslag");
		lblOpnameVerslag = new Label("Opnameverslag");
		hoofdContainer = new VBox();
		txtNaam = new Text();
		txtGeslacht = new Text();
		txtGeboorteDatum = new Text();
		txtDierSoort = new Text();
		txtDierRas = new Text();
		txtGewicht = new Text();
		txtVerblijfRuimte = new Text();
		txtAanwezigheid = new Text();
		scrlPnLabUitslag = new ScrollPane();
		scrlPnOpnameVerslag = new ScrollPane();
		
		scrlPnLabUitslag.setMinViewportHeight(50);
		scrlPnLabUitslag.setMinViewportWidth(100);
		scrlPnOpnameVerslag.setMinViewportHeight(50);
		scrlPnOpnameVerslag.setMinViewportWidth(100);
			
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
		txtDierSoort.setFont(new Font("Verdana", 14));
		txtDierRas.setFont(new Font("Verdana", 14));
		txtGewicht.setFont(new Font("Verdana", 14));
		txtVerblijfRuimte.setFont(new Font("Verdana", 14));
		txtAanwezigheid.setFont(new Font("Verdana", 14));
						
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
		hoofdVenster.add(lblDierSoort, 0, 4);
		hoofdVenster.add(lblDierRas, 0, 5);
		hoofdVenster.add(lblGewicht, 0, 6);
		hoofdVenster.add(lblVerblijfRuimte, 0, 7);
		hoofdVenster.add(lblAanwezigheid, 0, 8);
		hoofdVenster.add(lblLabUitslag, 2, 1);
		hoofdVenster.add(lblOpnameVerslag, 2, 3);
		
		hoofdVenster.add(txtNaam, 1, 1);
		hoofdVenster.add(txtGeslacht, 1, 2);
		hoofdVenster.add(txtGeboorteDatum, 1, 3);
		hoofdVenster.add(txtDierSoort, 1, 4);
		hoofdVenster.add(txtDierRas, 1, 5);
		hoofdVenster.add(txtGewicht, 1, 6);
		hoofdVenster.add(txtVerblijfRuimte, 1, 7);
		hoofdVenster.add(txtAanwezigheid, 1, 8);
		hoofdVenster.add(scrlPnLabUitslag, 2, 2);
		hoofdVenster.add(scrlPnOpnameVerslag, 2, 4);
		
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
	
	public void patiëntGegevensVerwerken(Patiënt selectedPatiënt)
	{
		txtNaam.setText(selectedPatiënt.getNaam());
		txtGeslacht.setText(selectedPatiënt.getGeslacht() ? "Vrouw" : "Man"); // false = Man; true = vrouw
		txtGeboorteDatum.setText(selectedPatiënt.getGeboorteDatum());
		txtDierSoort.setText(selectedPatiënt.getDierSoort());
		txtDierRas.setText(selectedPatiënt.getDierRas());
		txtGewicht.setText(Double.toString(selectedPatiënt.getGewicht()) + "kg");
		txtAanwezigheid.setText(selectedPatiënt.isAanwezigheid() ? "Ja" : "Nee"); // false = Afwezig/Nee; true = Aanwezig/Ja		
		txtVerblijfRuimte.setText(selectedPatiënt.getVerblijfRuimte());
		scrlPnLabUitslag.setContent(new Text(selectedPatiënt.getLabUitslag()));
		scrlPnOpnameVerslag.setContent(new Text(selectedPatiënt.getOpnameVerslag()));
	}
}
