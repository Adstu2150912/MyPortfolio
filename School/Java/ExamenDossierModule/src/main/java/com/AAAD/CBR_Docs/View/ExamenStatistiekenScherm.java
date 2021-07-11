package com.AAAD.CBR_Docs.View;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.sql.SQLException;

import com.AAAD.CBR_Docs.Model.*;

/**
 * De klasse ExamenBeheerScherm representeert een gebruikerscherm waarin statistieken in tekst bekeken kunnen worden.
 * Instanties van <code>ExamenStatistiekenScherm</code> kun je aan een <code>HoofdScherm</code> toevoegen.
 * <br>
 * <br>
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: ExamenStatistiekenScherm.java
 * @author Adam Oubelkas
 * @version 0.1
 * @since Aanmaakdatum: 7-12-2019
 * @see HoofdScherm
 */

public class ExamenStatistiekenScherm
{
	public final Label lblKopStatistieken, lblExamenLocatie, lblCategorie, lblRijOpleider,
	lblTotaalEerstVol, lblTotaalEersteOnVol, lblEersteAutomaatVol, lblEersteAutomaatOnVol, lblEersteCombiVol, lblEersteCombiOnVol, lblEersteHandVol, lblEersteHandOnVol, lblTotaalHerVol, lblTotaalHerOnVol, lblHerAutomaatVol, lblHerAutomaatOnVol, lblHerCombiVol, lblHerCombiOnvol, lblHerHandVol, lblHerHandOnvol,
	lblTotaalEerstVolWaarde,lblTotaalEersteOnVolWaarde, lblEersteAutomaatVolWaarde, lblEersteAutomaatOnVolWaarde, lblEersteCombiVolWaarde, lblEersteCombiOnVolWaarde, lblEersteHandVolWaarde, lblEersteHandOnVolWaarde, lblTotaalHerVolWaarde, lblTotaalHerOnVolWaarde, lblHerAutomaatVolWaarde, lblHerAutomaatOnVolWaarde, lblHerCombiVolWaarde, lblHerCombiOnvolWaarde, lblHerHandVolWaarde, lblHerHandOnvolWaarde;	
	public final Button btnFilter, btnHome, btnExamens, btnStatistieken;;
	public final ComboBox cbxExamenLocatie, cbxCategorie, cbxRijOpleider;
	private final CategorieSet categorieSet;
	private final OpleiderSet opleiderSet;
	private final ExamenLocatieSet examenLocatieSet;
	private final ExamenSet examenSet;
	private final Alert userAlert; //Popup bericht weergeven voor de gebruiker
	public final VBox hoofdContainer;
	public final FlowPane hoofdMenu;
	public final GridPane hoofdVenster; 
	
	public ExamenStatistiekenScherm()
	{
		hoofdMenu = new FlowPane();	
		hoofdVenster = new GridPane();
		hoofdContainer = new VBox();
		
		btnHome = new Button("Home");
		btnExamens = new Button("Examens");
		btnStatistieken = new Button("Toon statistieken");
		
		btnHome.setTextFill(Color.WHITE);
		btnHome.setStyle("-fx-background-color:#0588F0;");
		btnHome.setFont(new Font("Myriad-pro", 20));
		btnExamens.setTextFill(Color.WHITE);
		btnExamens.setStyle("-fx-background-color:#0588F0;");
		btnExamens.setFont(new Font("Myriad-pro", 20));
		btnStatistieken.setTextFill(Color.WHITE);
		btnStatistieken.setStyle("-fx-background-color:#0588F0;");
		btnStatistieken.setFont(new Font("Myriad-pro", 20));
		
		double nColumns; //Aantal benodigde kolommen voor node-elementen in een GridPane
		double nRows; //Aantal benodige rijen voor de node-elementen in een GridPane
		
		userAlert = new Alert(Alert.AlertType.NONE);
		
		categorieSet = new CategorieSet();
		opleiderSet = new OpleiderSet();
		examenLocatieSet = new ExamenLocatieSet();
		examenSet = new ExamenSet();
		
		lblKopStatistieken = new Label("Examenstatistieken");
		lblTotaalEerstVol = new Label("Totaal eerste examens/toetsen voldoende:");
		lblTotaalEerstVolWaarde = new Label();
		lblTotaalEersteOnVol = new Label("Totaal eerste examens/toetsen onvoldoende:");
		lblTotaalEersteOnVolWaarde = new Label();
		lblEersteAutomaatVol = new Label("Eerste examens/toetsen automaat voldoende:");
		lblEersteAutomaatVolWaarde = new Label();
		lblEersteAutomaatOnVol = new Label("Eerste examens/toetsen automaat onvoldoende:");
		lblEersteAutomaatOnVolWaarde = new Label();
		lblEersteCombiVol = new Label("Eerste examens/toetsen combi voldoende:");
		lblEersteCombiVolWaarde = new Label();
		lblEersteCombiOnVol = new Label("Eerste examens/toetsen combi onvoldoende:");
		lblEersteCombiOnVolWaarde = new Label();
		lblEersteHandVol = new Label("Eerste examens/toetsen handgeschakeld voldoende:");
		lblEersteHandVolWaarde = new Label();
		lblEersteHandOnVol = new Label("Eerste examens/toetsen handgeschakeld onvoldoende:");
		lblEersteHandOnVolWaarde = new Label();
		lblTotaalHerVol = new Label("Totaal herexamens/toetsen voldoende:");
		lblTotaalHerVolWaarde = new Label();
		lblTotaalHerOnVol = new Label("Totaal herexamens/toetsen onvoldoende:");
		lblTotaalHerOnVolWaarde = new Label();
		lblHerAutomaatVol = new Label("Herexamens/toetsen automaat voldoende:");
		lblHerAutomaatVolWaarde = new Label();
		lblHerAutomaatOnVol = new Label("Herexamens/toetsen automaat onvoldoende:");
		lblHerAutomaatOnVolWaarde = new Label();
		lblHerCombiVol = new Label("Herexamens/toetsen combi voldoende:");
		lblHerCombiVolWaarde = new Label();
		lblHerCombiOnvol = new Label("Herexamens/toetsen combi onvoldoende:");
		lblHerCombiOnvolWaarde = new Label();
		lblHerHandVol = new Label("Herexamens/toetsen handgeschakeld voldoende:");
		lblHerHandVolWaarde = new Label();
		lblHerHandOnvol = new Label("Herexamens/toetsen handgeschakeld onvoldoende:");
		lblHerHandOnvolWaarde = new Label();
		
		lblExamenLocatie = new Label("Examenlocatie:");
		lblCategorie = new Label("Categorie:");
		lblRijOpleider = new Label("Rijopleider:");
		
		lblKopStatistieken.setFont(new Font("Myriad-pro", 20));
		lblKopStatistieken.setTextFill(Color.DARKCYAN);		
		
		cbxExamenLocatie = new ComboBox<ExamenLocatieSet>(); //Keuzeveld voor het sorteren van statistieken op examenlocatienaam
		cbxCategorie = new ComboBox<CategorieSet>(); //Keuzeveld voor het sorteren van statistieken op categoriecode
		cbxRijOpleider = new ComboBox<OpleiderSet>(); //Keuzeveld voor het sorteren van statistieken op opleidernaam
		 
		btnFilter = new Button("Filter");
		btnFilter.setFont(new Font("Arial", 18));		
		
		categorieSet.fillCbxCategorie(cbxCategorie);
		examenLocatieSet.fillCbxExamenLocatie(cbxExamenLocatie);
		opleiderSet.fillCbxOpleider(cbxRijOpleider);
		
		cbxCategorie.getSelectionModel().select(0);
		cbxExamenLocatie.getSelectionModel().select(0);
		cbxRijOpleider.getSelectionModel().select(0);
		
		hoofdVenster.setHgap(10);
		hoofdVenster.setVgap(5);
		hoofdVenster.setPadding(new Insets(10, 15, 20, 25));
		hoofdVenster.setStyle("-fx-background-color:#FFFFFF;");
		hoofdMenu.setStyle("-fx-background-color:#0588F0; -fx-opacity:1;");				
		
		cbxCategorie.setPrefWidth(250);
		cbxExamenLocatie.setPrefWidth(250);
		cbxRijOpleider.setPrefWidth(250);
		
		hoofdMenu.getChildren().addAll(btnHome, btnExamens, btnStatistieken);
		
		hoofdVenster.add(lblKopStatistieken, 0, 0);
		hoofdVenster.add(cbxCategorie, 0, 1);
		hoofdVenster.add(cbxExamenLocatie, 1, 1);
		hoofdVenster.add(cbxRijOpleider, 2, 1);
		hoofdVenster.add(btnFilter, 3, 1);
		hoofdVenster.add(lblTotaalEerstVol, 0, 2);
		hoofdVenster.add(lblTotaalEerstVolWaarde, 1, 2);
		hoofdVenster.add(lblTotaalEersteOnVol, 0, 3);
		hoofdVenster.add(lblTotaalEersteOnVolWaarde, 1, 3);
		hoofdVenster.add(lblEersteAutomaatVol, 0, 4);
		hoofdVenster.add(lblEersteAutomaatVolWaarde, 1, 4);
		hoofdVenster.add(lblEersteAutomaatOnVol, 0, 5);
		hoofdVenster.add(lblEersteAutomaatOnVolWaarde, 1, 5);
		hoofdVenster.add(lblEersteCombiVol, 0, 6);
		hoofdVenster.add(lblEersteCombiVolWaarde, 1, 6);
		hoofdVenster.add(lblEersteCombiOnVol, 0, 7);
		hoofdVenster.add(lblEersteCombiOnVolWaarde, 1, 7);
		hoofdVenster.add(lblEersteHandVol, 0, 8);
		hoofdVenster.add(lblEersteHandVolWaarde, 1, 8);
		hoofdVenster.add(lblEersteHandOnVol, 0, 9);
		hoofdVenster.add(lblEersteHandOnVolWaarde, 1, 9);
		hoofdVenster.add(lblTotaalHerVol, 3, 2);
		hoofdVenster.add(lblTotaalHerVolWaarde, 4, 2);
		hoofdVenster.add(lblTotaalHerOnVol, 3, 3);
		hoofdVenster.add(lblTotaalHerOnVolWaarde, 4, 3);
		hoofdVenster.add(lblHerAutomaatVol, 3, 4);
		hoofdVenster.add(lblHerAutomaatVolWaarde, 4, 4);
		hoofdVenster.add(lblHerAutomaatOnVol, 3, 5);
		hoofdVenster.add(lblHerAutomaatOnVolWaarde, 4, 5);
		hoofdVenster.add(lblHerCombiVol, 3, 6);
		hoofdVenster.add(lblHerCombiVolWaarde, 4, 6);
		hoofdVenster.add(lblHerCombiOnvol, 3, 7);
		hoofdVenster.add(lblHerCombiOnvolWaarde, 4, 7);
		hoofdVenster.add(lblHerHandVol, 3, 8);
		hoofdVenster.add(lblHerHandVolWaarde, 4, 8);
		hoofdVenster.add(lblHerHandOnvol, 3, 9);
		hoofdVenster.add(lblHerHandOnvolWaarde, 4, 9);
	
		hoofdContainer.getChildren().addAll(hoofdMenu, hoofdVenster);
		
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
		
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);		
		
		this.btnFilter.setOnAction(event -> 
		{
			this.getExamenStatistieken();
		});
	}
	
	public void getExamenStatistieken()
	{
		try 
		{
			if(!cbxExamenLocatie.getSelectionModel().isEmpty() || !cbxCategorie.getSelectionModel().isEmpty() || !cbxRijOpleider.getSelectionModel().isEmpty())
			{
				//Als de gebruiker heeft aangegeven om te filteren op waardes anders dan 'Geen' (Deze waarde heeft de index 0), toon de statistieken waarvan de examens deze waardes bevatten
				if(cbxExamenLocatie.getSelectionModel().getSelectedIndex() != 0 || cbxCategorie.getSelectionModel().getSelectedIndex() != 0 || cbxRijOpleider.getSelectionModel().getSelectedIndex() != 0)
					examenSet.toonExamenStatistieken((OpleiderSet)cbxRijOpleider.getSelectionModel().getSelectedItem(), (CategorieSet)cbxCategorie.getSelectionModel().getSelectedItem(), (ExamenLocatieSet)cbxExamenLocatie.getSelectionModel().getSelectedItem());
				else //De gebruiker heeft aangegeven om geen filter toe te passen, dus worden statistieken over alle examens opgehaald uit de database
					examenSet.toonExamenStatistieken();	
			}
			else //De gebruiker heeft aangegeven om geen filter toe te passen, dus worden statistieken over alle examens opgehaald uit de database
				examenSet.toonExamenStatistieken();
			
			lblTotaalEerstVolWaarde.setText(Integer.toString(examenSet.getTotaalExamensVol()));
			lblTotaalEersteOnVolWaarde.setText(Integer.toString(examenSet.getTotaalExamensOnvol()));
			lblEersteAutomaatVolWaarde.setText(Integer.toString(examenSet.getExamensAutomaatVol()));
			lblEersteAutomaatOnVolWaarde.setText(Integer.toString(examenSet.getExamensAutomaatOnvol()));
			lblEersteCombiVolWaarde.setText(Integer.toString(examenSet.getExamensCombiVol()));
			lblEersteCombiOnVolWaarde.setText(Integer.toString(examenSet.getExamensCombiOnvol()));
			lblEersteHandVolWaarde.setText(Integer.toString(examenSet.getExamensHandVol()));
			lblEersteHandOnVolWaarde.setText(Integer.toString(examenSet.getExamensHandOnvol()));
			lblTotaalHerVolWaarde.setText(Integer.toString(examenSet.getTotaalHerExamensVol()));
			lblTotaalHerOnVolWaarde.setText(Integer.toString(examenSet.getTotaalHerExamensOnvol()));
			lblHerAutomaatVolWaarde.setText(Integer.toString(examenSet.getHerexamenAutomaatVol()));
			lblHerAutomaatOnVolWaarde.setText(Integer.toString(examenSet.getHerexamenAutomaatOnvol()));
			lblHerCombiVolWaarde.setText(Integer.toString(examenSet.getHerexamenCombiVol()));
			lblHerCombiOnvolWaarde.setText(Integer.toString(examenSet.getHerexamenCombiOnvol()));
			lblHerHandVolWaarde.setText(Integer.toString(examenSet.getHerexamenHandVol()));
			lblHerHandOnvolWaarde.setText(Integer.toString(examenSet.getHerexamenHandOnvol()));
		}
		catch(SQLException msg)
		{
			userAlert.setAlertType(AlertType.ERROR);
			userAlert.setHeaderText("Probleem met database");
			userAlert.setContentText("Er vinden problemen plaats in de database. Neem contact op met de ontwikkelaar.");
			userAlert.showAndWait();
		}
	}
}
