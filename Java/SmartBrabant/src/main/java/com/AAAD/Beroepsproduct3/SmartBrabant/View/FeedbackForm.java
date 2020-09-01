package com.AAAD.Beroepsproduct3.SmartBrabant.View;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.VMDBFunctionaliteit;

import javafx.scene.control.Label;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Activiteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Advies;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Burger;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.IoTApparaat;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
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
 * De klasse FeedbackForm representeert een gebruikerscherm waar gebruiker feedback, over eigen tevredenheid van een bepaalde plaats, kan sturen naar de Provinciale Staten
 * <br>
 * <br>
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 07-03-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: FeedbackForm.java
 * @author Adam Oubelkas
 * @version 0.2
 * @since Aanmaakdatum: 07-03-2020
 */

public class FeedbackForm
{
	public final Button btnHome, btnFeedbackForm, btnHelp, btnBevestig;
	public final VBox hoofdContainer;
	public final FlowPane hoofdMenu;
	public final GridPane hoofdVenster;
	private VMDBFunctionaliteit viewModelDB;
	private Alert userAlert; //Popup bericht weergeven voor de gebruiker
	public final ComboBox<Plaats> cbxPlaats;
	private Plaats selectedPlaats;
	private ToggleGroup tgTevredenheid;
	private RadioButton rbTevreden, rbOntevreden;
	private final Label lblSchermTitel, lblBSNnummer, lblNaam, lblPlaats, lblTevredenheid, lblMening;
	private final TextField txtBSNnummer, txtNaam, txtMening;
	
	public FeedbackForm()
	{
		viewModelDB = new VMDBFunctionaliteit();
		
		hoofdMenu = new FlowPane();	
		hoofdVenster = new GridPane();
		hoofdContainer = new VBox();
		
		btnHome = new Button("Home");
		btnFeedbackForm = new Button("Laat uw mening horen!");
		btnHelp = new Button("Help");
		btnBevestig = new Button("Bevestig");
		
		lblSchermTitel = new Label("Geef uw mening over Noord-Brabant!");
		lblBSNnummer = new Label("Uw BSNnummer:");
		lblNaam = new Label("Uw naam:");
		lblPlaats = new Label("Uw voorkeur van plaats:");
		lblTevredenheid = new Label("Uw tevredenheid over geselecteerde plaats:");
		lblMening = new Label("Uw mening");
		
		tgTevredenheid = new ToggleGroup();
		rbTevreden = new RadioButton("Tevreden");
		rbOntevreden = new RadioButton("Ontevreden");
		
		rbTevreden.setToggleGroup(tgTevredenheid);
		rbOntevreden.setToggleGroup(tgTevredenheid);
		
		txtBSNnummer = new TextField();
		txtNaam = new TextField();
		txtMening = new TextField();
		
		double nColumns; //Aantal benodigde kolommen voor node-elementen in een GridPane
		double nRows; //Aantal benodige rijen voor de node-elementen in een GridPane
		
		cbxPlaats = new ComboBox<Plaats>(viewModelDB.getGeoDataFromVM());
		
		cbxPlaats.setConverter(new StringConverter<Plaats>() 
		{
			@Override
			public String toString(Plaats item)
			{
				return "[" + item.getStrPropNaam() + "]";
			}
			
			@Override
			public Plaats fromString(String text)
			{
				return cbxPlaats.getItems().stream().filter(ap -> ap.getStrPropNaam().equals(text)).findFirst().orElse(null);
			}
		});
		
		cbxPlaats.getSelectionModel().select(0);
		
		//laat onderstaande veld alleen nummers opslaan
		txtBSNnummer.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	txtBSNnummer.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
	
		
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
		hoofdVenster.add(lblBSNnummer, 1, 3);
		hoofdVenster.add(txtBSNnummer, 2, 3);
		hoofdVenster.add(lblNaam, 1, 4);
		hoofdVenster.add(txtNaam, 2, 4);
		hoofdVenster.add(lblPlaats, 1, 5);
		hoofdVenster.add(cbxPlaats, 2, 5);
		hoofdVenster.add(lblTevredenheid, 1, 6);
		hoofdVenster.add(rbTevreden, 2, 6);
		hoofdVenster.add(rbOntevreden, 3, 6);
		hoofdVenster.add(lblMening, 1, 7);
		hoofdVenster.add(txtMening, 2, 7);
		hoofdVenster.add(btnBevestig, 1, 9);
		
		
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
		
		if(cbxPlaats.getSelectionModel().getSelectedItem() != null)
		{
			selectedPlaats = cbxPlaats.getSelectionModel().getSelectedItem();
		}
		
		this.cbxPlaats.setOnAction(event ->
		{
			if(cbxPlaats.getSelectionModel().getSelectedItem() != null)
			{
				selectedPlaats = cbxPlaats.getSelectionModel().getSelectedItem();
			}
		});
	}		
	
	public Boolean sendFeedbackToDB()
	{
		boolean isFormValid = true;
		String invalidFields = "";
		boolean selectedTevredenheid = false;
		
		//Valideer onderstaande tekst op numerieke waarde en aantal karakters
		if(!txtBSNnummer.getText().matches("[0-9]*") && txtBSNnummer.getText().length() >= 8)
		{
			isFormValid = false;
			invalidFields += " BSNnummer; ";
		}
		
		//Waarde van onderstaande tekstveld mag niet groter zijn dan de maximaal toegestane karakters van overeenkomende veld uit de database
		if(txtNaam.getText().length() >= 256)
		{
			isFormValid = false;
			invalidFields += " Naam; ";
		}
		
		if(selectedPlaats == null)
		{
			isFormValid = false;
			invalidFields += " Plaats; ";
		}
		
		if(!rbOntevreden.isSelected() && !rbTevreden.isSelected())
		{
			isFormValid = false;
			invalidFields += " Tevredenheid; ";
		}
		
		//Waarde van onderstaande tekstveld mag niet groter zijn dan de maximaal toegestane karakters van overeenkomende veld uit de database
		if(txtMening.getText().length() >= 256)
		{
			isFormValid = false;
			invalidFields += " Mening; ";
		}
		
		if(isFormValid)
		{
			if(rbTevreden.isSelected())
				selectedTevredenheid = true;
			
			Burger huidigeBurger = new Burger(Integer.parseInt(txtBSNnummer.getText()), txtNaam.getText(), selectedPlaats.getStrPropNaam(), selectedTevredenheid, txtMening.getText());
			isFormValid = viewModelDB.setFeedbackFormToVM(huidigeBurger);
			if(isFormValid)
			{
				userAlert = new Alert(AlertType.CONFIRMATION, "Gegevens uit dit formulier zijn succesvol opgeslagen in de database!", ButtonType.OK);
				userAlert.setHeaderText("Feedbackformulier is succesvol verstuurd");
				userAlert.showAndWait();
			}
			else
			{
				userAlert = new Alert(AlertType.ERROR, "Gegevens uit dit formulier zijn niet opgeslagen in de database! Raadpleeg de ontwikkelaar.", ButtonType.OK);
				userAlert.setHeaderText("Het versturen van dit feedbackformulier is mislukt");
				userAlert.showAndWait();
			}
			
		}
		else
		{
			userAlert = new Alert(AlertType.WARNING, "Volgende velden zijn niet goed ingevuld: " + invalidFields, ButtonType.OK);
			userAlert.setHeaderText("Formulier is ongeldig!");
			userAlert.showAndWait();
		}
			
		return isFormValid;	
	}
}
