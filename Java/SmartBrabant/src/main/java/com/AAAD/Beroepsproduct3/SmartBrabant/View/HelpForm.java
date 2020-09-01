package com.AAAD.Beroepsproduct3.SmartBrabant.View;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.control.Label;
import javafx.util.StringConverter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup; //Voor het laten selecteren van hooguit 1 waarde uit een reeks
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.geometry.Insets;
/**
 * De klasse FeedbackForm representeert een gebruikerscherm waar gebruiker hulp, m.b.t. deze applicatie, kan verzoeken aan de support desk van het softwarebedrijf, die verantwoordelijk is voor het onderhouden en beheren van de applicatie
 * <br>
 * <br>
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: HelpForm.java
 * @author Adam Oubelkas
 * @version 0.2
 * @since Aanmaakdatum: 07-03-2020
 */

public class HelpForm
{
	public final Button btnHome, btnFeedbackForm, btnHelp, btnBevestig;
	public final VBox hoofdContainer;
	public final FlowPane hoofdMenu;
	public final GridPane hoofdVenster;
	private final Alert userAlert; //Popup bericht weergeven voor de gebruiker
	private ToggleGroup tgSoortProbleem;
	private RadioButton rbBug, rbStoring, rbDefect;
	private final Label lblSchermTitel, lblProbleem, lblContext, lblSoortProbleem, lblOpmerkingen;
	private final TextField txtProbleem, txtContext, txtOpmerkingen;
	
	public HelpForm()
	{
		hoofdMenu = new FlowPane();	
		hoofdVenster = new GridPane();
		hoofdContainer = new VBox();
		
		btnHome = new Button("Home");
		btnFeedbackForm = new Button("Laat uw mening horen!");
		btnHelp = new Button("Help");
		btnBevestig = new Button("Bevestig");	
		
		lblSchermTitel = new Label("Vul hieronder uw verzoek");
		lblProbleem = new Label("Probleem:");
		lblContext = new Label("Waar treft het probleem:");
		lblSoortProbleem = new Label("Soort probleem:");
		lblOpmerkingen = new Label("Opmerkingen:");
		
		txtProbleem = new TextField();
		txtContext = new TextField();
		txtOpmerkingen = new TextField();
		
		tgSoortProbleem = new ToggleGroup();
		rbBug = new RadioButton("Bug");
		rbStoring = new RadioButton("Storing");
		rbDefect = new RadioButton("Defect");
		
		rbBug.setToggleGroup(tgSoortProbleem);
		rbStoring.setToggleGroup(tgSoortProbleem);
		rbDefect.setToggleGroup(tgSoortProbleem);
		
		double nColumns; //Aantal benodigde kolommen voor node-elementen in een GridPane
		double nRows; //Aantal benodige rijen voor de node-elementen in een GridPane
		
		userAlert = new Alert(Alert.AlertType.NONE);
		
		btnHome.setTextFill(Color.WHITE);
		btnHome.setStyle("-fx-background-color:#FF0000;");
		btnHome.setFont(new Font("Myriad-pro", 20));
		btnFeedbackForm.setTextFill(Color.WHITE);
		btnFeedbackForm.setStyle("-fx-background-color:#FF0000;");
		btnFeedbackForm.setFont(new Font("Myriad-pro", 20));
		btnHelp.setTextFill(Color.WHITE);
		btnHelp.setStyle("-fx-background-color:#FF0000;");
		btnHelp.setFont(new Font("Myriad-pro", 20));
		
		hoofdVenster.setHgap(10);
		hoofdVenster.setVgap(5);
		hoofdVenster.setPadding(new Insets(10, 15, 20, 25));
		hoofdMenu.setStyle("-fx-background-color:#FF0000; -fx-opacity:1;");
		hoofdVenster.setStyle("-fx-background-color:#DCDCE6;");
		hoofdVenster.setMinSize(700, 500);
		
		//Voeg hier alle controls toe in het hoofdVenster
		hoofdVenster.add(lblSchermTitel, 1, 1);
		hoofdVenster.add(lblProbleem, 1, 3);
		hoofdVenster.add(txtProbleem, 2, 3);
		hoofdVenster.add(lblContext, 1, 4);
		hoofdVenster.add(txtContext, 2, 4);
		hoofdVenster.add(lblSoortProbleem, 1, 5);
		hoofdVenster.add(rbBug, 2, 5);
		hoofdVenster.add(rbStoring, 3, 5);
		hoofdVenster.add(rbDefect, 4, 5);
		hoofdVenster.add(lblOpmerkingen, 1, 6);
		hoofdVenster.add(txtOpmerkingen, 2, 6);
		hoofdVenster.add(btnBevestig, 1, 8);
		
		
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
		
		hoofdMenu.getChildren().addAll(btnHome, btnFeedbackForm, btnHelp);
		hoofdContainer.getChildren().addAll(hoofdMenu, hoofdVenster);
		
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);	
	}
}
