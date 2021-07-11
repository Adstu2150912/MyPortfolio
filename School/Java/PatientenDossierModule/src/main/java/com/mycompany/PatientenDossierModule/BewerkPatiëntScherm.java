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
 * Aanmaakdatum: 20-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: BewerkPatiëntScherm.java
 */

public class BewerkPatiëntScherm 
{
	public final Button btnKlant, btnPatiënt, btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen, btnBevestigen;
	private Label lblPatiënt, lblNaam, lblGeslacht, lblGeboorteDatum, lblGewicht, lblDierSoort, lblDierRas, lblVerblijfRuimte, lblAanwezigheid, lblLabUitslag, lblOpnameVerslag;
	private TextField txtfNaam, txtfGeboorteDatum, txtfGewicht, txtfDierSoort, txtfDierRas, txtfVerblijfRuimte;
	private ToggleGroup tglGpGeslacht, tglGpAanwezigheid;
	private RadioButton rbMan, rbVrouw, rbAanwezig, rbAfwezig;
	private TextArea txtArLabUitslag, txtArOpnameVerslag;
	public final VBox hoofdContainer;
	public FlowPane hoofdMenu, subMenu;
	public GridPane hoofdVenster;
	private int huidigePatiëntNr;
	public Patiënt huidigePatiënt = new Patiënt();
	
	public BewerkPatiëntScherm()
	{
		huidigePatiëntNr = 0;
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
		lblPatiënt = new Label("Patiënt:");
		lblNaam = new Label("Naam:");
		lblGeslacht = new Label("Geslacht:");
		lblGeboorteDatum = new Label("Geboortedatum:");
		lblGewicht = new Label("Gewicht:");
		lblDierSoort = new Label("Diersoort:");
		lblDierRas = new Label("Dierras:");
		lblVerblijfRuimte = new Label("Verblijfruimte:");
		lblAanwezigheid = new Label("Aanwezig:");
		lblLabUitslag = new Label("Labuitslag");
		lblOpnameVerslag = new Label("Opnameverslag");
		hoofdContainer = new VBox();
		txtfNaam = new TextField();
		tglGpGeslacht = new ToggleGroup();
		tglGpAanwezigheid = new ToggleGroup();
		rbMan = new RadioButton();
		rbVrouw = new RadioButton();
		rbAanwezig = new RadioButton();
		rbAfwezig = new RadioButton();
		txtfGeboorteDatum = new TextField();
		txtfGewicht = new TextField();
		txtfDierSoort = new TextField();
		txtfDierRas = new TextField();
		txtfVerblijfRuimte = new TextField();
		txtArLabUitslag = new TextArea();
		txtArOpnameVerslag = new TextArea();
		subMenu.setVisible(false);
		
		rbMan.setToggleGroup(tglGpGeslacht);
		rbVrouw.setToggleGroup(tglGpGeslacht);
		rbMan.setSelected(true);
		
		rbAanwezig.setToggleGroup(tglGpAanwezigheid);
		rbAfwezig.setToggleGroup(tglGpAanwezigheid);
		rbAanwezig.setSelected(true);
		
		rbMan.setText("Man");
		rbVrouw.setText("Vrouw");
		
		rbAanwezig.setText("Ja");
		rbAfwezig.setText("Nee");
		
		lblPatiënt.setFont(new Font("Arial", 20));
		lblPatiënt.setTextFill(Color.DARKCYAN);
		
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
		txtfGewicht.setFont(new Font("Verdana", 14));
		txtfDierSoort.setFont(new Font("Verdana", 14));
		txtArLabUitslag.setFont(new Font("Verdana", 14));
		txtfDierRas.setFont(new Font("Verdana", 14));
		txtArOpnameVerslag.setFont(new Font("Verdana", 14));		
		txtfVerblijfRuimte.setFont(new Font("Verdana", 14));
		
		hoofdVenster.setHgap(10);
		hoofdVenster.setVgap(5);
		hoofdVenster.setPadding(new Insets(10, 15, 20, 25));
		hoofdVenster.setStyle("-fx-background-color:#DCDCE6;");
		
		hoofdMenu.getChildren().addAll(btnKlant, btnPatiënt);		
		subMenu.getChildren().addAll(btnBekijken, btnInvoeren, btnBewerken, btnVerwijderen);		
		
		hoofdVenster.add(lblPatiënt, 0, 0);
		hoofdVenster.add(lblGeslacht, 0, 2);
		hoofdVenster.add(lblGeboorteDatum, 0, 3);
		hoofdVenster.add(lblGewicht, 0, 4);
		hoofdVenster.add(lblDierSoort, 0, 5);
		hoofdVenster.add(lblDierRas, 0, 6);
		hoofdVenster.add(lblVerblijfRuimte, 0, 7);
		hoofdVenster.add(lblAanwezigheid, 0, 8);
		hoofdVenster.add(lblLabUitslag, 3, 1);
		hoofdVenster.add(lblOpnameVerslag, 3, 3);
		
		hoofdVenster.add(rbMan, 1, 2);
		hoofdVenster.add(rbVrouw, 2, 2);
		hoofdVenster.add(txtfGeboorteDatum, 1, 3);
		hoofdVenster.add(txtfGewicht, 1, 4);
		hoofdVenster.add(txtfDierSoort, 1, 5);
		hoofdVenster.add(txtfDierRas, 1, 6);
		hoofdVenster.add(txtfVerblijfRuimte, 1, 7);
		hoofdVenster.add(rbAanwezig, 1, 8);
		hoofdVenster.add(rbAfwezig, 2, 8);
		hoofdVenster.add(txtArLabUitslag, 3, 2);
		hoofdVenster.add(txtArOpnameVerslag, 3, 4);
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
	}
	
	//Sla de, door de gebruiker gemaakte, nieuwe patiënt op in de database
	public int patiëntBewerken()
	{			
		huidigePatiënt.setGeslacht((rbMan.isSelected() ? false : true));
		huidigePatiënt.setDierSoort(txtfDierSoort.getText());
		huidigePatiënt.setDierRas(txtfDierRas.getText());
		huidigePatiënt.setGewicht(Double.parseDouble(txtfGewicht.getText()));
		huidigePatiënt.setGeboorteDatum(txtfGeboorteDatum.getText());
		huidigePatiënt.setLabUitslag(txtArLabUitslag.getText());
		huidigePatiënt.setOpnameVerslag(txtArOpnameVerslag.getText());
		huidigePatiënt.setVerblijfRuimte(txtfVerblijfRuimte.getText());
		huidigePatiënt.setAanwezigheid(rbAanwezig.isSelected() ? true : false);
		
		huidigePatiënt.patiëntBewerken();
		
		return huidigePatiënt.getPatiëntNummer();
	}
	
	public void patiëntGegevensVerwerken(Patiënt selectedPatiënt)
	{
		huidigePatiënt = selectedPatiënt;
		//txtfNaam.setText(selectedPatiënt.getNaam());
		// geslacht: false = Man; true = vrouw;
		if(selectedPatiënt.getGeslacht()) 
		{
			rbVrouw.setSelected(true);
		}
		else
		{
			rbMan.setSelected(true);
		}
		txtfGeboorteDatum.setText(selectedPatiënt.getGeboorteDatum());
		txtfDierSoort.setText(selectedPatiënt.getDierSoort());
		txtfDierRas.setText(selectedPatiënt.getDierRas());
		txtfGewicht.setText(Double.toString(selectedPatiënt.getGewicht()));
		//Aanwezigheid: aanwezig = true; afwezig = false;
		if(selectedPatiënt.isAanwezigheid()) 
		{
			rbAanwezig.setSelected(true);
		}
		else
		{
			rbAfwezig.setSelected(true);
		}	
		txtfVerblijfRuimte.setText(selectedPatiënt.getVerblijfRuimte());
		txtArLabUitslag.setText(selectedPatiënt.getLabUitslag());
		txtArOpnameVerslag.setText(selectedPatiënt.getOpnameVerslag());
	}
}
