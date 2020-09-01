package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import javafx.scene.control.Button;
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
import javafx.collections.*;
import javafx.geometry.Insets;



/**
 * De klasse HoofdScherm representeert een gebruikerscherm waar de applicatie en gebruiker mee start
 * <br>
 * <br>
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-02-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: HoofdScherm.java
 * @author Adam Oubelkas
 * @version 0.2
 * @since Aanmaakdatum: 26-02-2020
 */

public class HoofdScherm 
{
	public final Button btnHome, btnFeedbackForm, btnHelp, btnBevestig;
	public final VBox hoofdContainer;
	public final FlowPane hoofdMenu;
	public final GridPane hoofdVenster;
	private VMDBFunctionaliteit viewModelDB;
	private final Alert userAlert; //Popup bericht weergeven voor de gebruiker
	public final ComboBox<Plaats> cbxPlaats;
	public final TextArea txtArAdviesWaarde;
	public final Label lblSelectiePlaats, lblTevredenheid, lblTevredenheidWaarde, lblAdvies, lblInfoNoData, 
	lblInfoPlaatsTitel, lblPlaatsNaam, lblPlaatsNaamWaarde, lblGemeente, lblGemeenteWaarde, lblStatus, lblStatusWaarde, lblOppervlakte, lblOppervlakteWaarde, lblStadPop, lblStadPopWaarde,
	lblGemeentePop, lblGemeentePopWaarde, lblMetroPop, lblMetroPopWaarde; 
	public TableView<Activiteit> activiteitenTabel;
	public TableView<IoTApparaat> iotTabel;
	public Advies selectedAdvies;
	private Plaats selectedPlaats;
	
	
	public HoofdScherm()
	{
		viewModelDB = new VMDBFunctionaliteit();
		
		hoofdMenu = new FlowPane();	
		hoofdVenster = new GridPane();
		hoofdContainer = new VBox();
		
		btnHome = new Button("Home");
		btnFeedbackForm = new Button("Laat uw mening horen!");
		btnHelp = new Button("Help");
		btnBevestig = new Button("Bevestig");
		
		lblSelectiePlaats = new Label("Kies hieronder een woonplaats uit Noord-Brabant:");
		lblTevredenheid = new Label("Tevredenheid mensen over plaats:");
		lblTevredenheidWaarde = new Label();
		lblAdvies = new Label("Advies voor inrichting van de plaats als SMART-City:");
		lblInfoNoData = new Label("Momenteel is er geen data beschikbaar over de IoT-apparatuur en activiteiten binnen *plaats*. Excuses voor het ongemak.");
		lblInfoPlaatsTitel = new Label("Algemene info over *plaats*:");
		lblPlaatsNaam = new Label("Plaatsnaam:");
		lblPlaatsNaamWaarde = new Label();
		lblGemeente = new Label("Gemeente:");
		lblGemeenteWaarde = new Label();
		lblStatus = new Label("Is smart ingericht:");
		lblStatusWaarde = new Label();
		lblOppervlakte = new Label("Oppervlakte:");
		lblOppervlakteWaarde = new Label();
		lblStadPop = new Label("Stedelijke populatie:");
		lblStadPopWaarde = new Label();
		lblGemeentePop = new Label("Gemeentelijke populatie:");
		lblGemeentePopWaarde = new Label();
		lblMetroPop = new Label("Metropolitische populatie:");
		lblMetroPopWaarde = new Label();
		
		txtArAdviesWaarde = new TextArea();
		
		double nColumns; //Aantal benodigde kolommen voor node-elementen in een GridPane
		double nRows; //Aantal benodige rijen voor de node-elementen in een GridPane
		
		userAlert = new Alert(Alert.AlertType.NONE);
		
		cbxPlaats = new ComboBox<Plaats>(viewModelDB.getGeoDataFromVM());
		
//		cbxPlaats = new ComboBox<Plaats>();
//		
//		ObservableList plaatsenLijst = viewModelDB.getGeoDataFromVM();
//		ListIterator<Plaats> litrPlaatsenLijst = plaatsenLijst.listIterator();
//		
//		while(litrPlaatsenLijst.hasNext())
//		{
//			cbxPlaats.getItems().add(litrPlaatsenLijst.next());
//		}
		
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
		
		activiteitenTabel = new TableView();
		iotTabel = new TableView();
		
		cbxPlaats.getSelectionModel().select(0);
		
		txtArAdviesWaarde.setEditable(false); //Deze control is alleen bedoeld voor weergave van een advies die gekoppeld is aan de door de gebruiker geselecteerde plaats
		lblInfoNoData.setVisible(false);
		
		btnHome.setTextFill(Color.WHITE);
		btnHome.setStyle("-fx-background-color:#FF0000;");
		btnHome.setFont(new Font("Myriad-pro", 20));
		btnFeedbackForm.setTextFill(Color.WHITE);
		btnFeedbackForm.setStyle("-fx-background-color:#FF0000;");
		btnFeedbackForm.setFont(new Font("Myriad-pro", 20));
		btnHelp.setTextFill(Color.WHITE);
		btnHelp.setStyle("-fx-background-color:#FF0000;");
		btnHelp.setFont(new Font("Myriad-pro", 20));
		lblSelectiePlaats.setFont(new Font("Myriad-pro", 20));
		lblTevredenheid.setFont(new Font("Arial", 18));
		lblAdvies.setFont(new Font("Arial", 18));
		lblInfoNoData.setFont(new Font("Arial", 18));
		
		
		hoofdVenster.setHgap(10);
		hoofdVenster.setVgap(5);
		hoofdVenster.setPadding(new Insets(10, 15, 20, 25));
		hoofdMenu.setStyle("-fx-background-color:#FF0000; -fx-opacity:1;");
		hoofdVenster.setStyle("-fx-background-color:#DCDCE6;");
		hoofdVenster.setMinSize(700, 500);
		
		
		//Voeg hier alle controls toe in het hoofdVenster
		hoofdVenster.add(lblSelectiePlaats, 1, 1);
		hoofdVenster.add(cbxPlaats, 1, 3);
		//hoofdVenster.add(btnBevestig, 1, 4);
		hoofdVenster.add(lblTevredenheid, 3, 1);
		hoofdVenster.add(lblTevredenheidWaarde, 3, 2);
		hoofdVenster.add(lblAdvies, 3, 4);
		hoofdVenster.add(txtArAdviesWaarde, 3, 5);
		hoofdVenster.add(lblInfoNoData, 3, 7);
		hoofdVenster.add(activiteitenTabel, 3, 8);
		hoofdVenster.add(iotTabel, 3, 9);
		hoofdVenster.add(lblInfoPlaatsTitel, 5, 1);
		hoofdVenster.add(lblPlaatsNaam, 5, 3);
		hoofdVenster.add(lblPlaatsNaamWaarde, 6, 3);
		hoofdVenster.add(lblGemeente, 5, 4);
		hoofdVenster.add(lblGemeenteWaarde, 6, 4);
		hoofdVenster.add(lblStatus, 5, 5);
		hoofdVenster.add(lblStatusWaarde, 6, 5);
		hoofdVenster.add(lblOppervlakte, 5, 6);
		hoofdVenster.add(lblOppervlakteWaarde, 6, 6);
		hoofdVenster.add(lblStadPop, 5, 7);
		hoofdVenster.add(lblStadPopWaarde, 6, 7);
		hoofdVenster.add(lblGemeentePop, 5, 8);
		hoofdVenster.add(lblGemeentePopWaarde, 6, 8);
		hoofdVenster.add(lblMetroPop, 5, 9);
		hoofdVenster.add(lblMetroPopWaarde, 6, 9);
		
		
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
		
//		double maxWidthActivityTable = activiteitenTabel.getColumns().size() * 6;
//		double maxWidthCbx = hoofdVenster.getChildren().size() * 4;
		
		activiteitenTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//		activiteitenTabel.setPrefWidth(maxWidthActivityTable);
		txtArAdviesWaarde.setPrefSize(100, 200);
		
//		cbxPlaats.setPrefWidth(maxWidthCbx);
		
		hoofdMenu.getChildren().addAll(btnHome, btnFeedbackForm, btnHelp);
		hoofdContainer.getChildren().addAll(hoofdMenu, hoofdVenster);
		
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);	
		
		//kolommen per activiteit
		
		TableColumn<Activiteit, Integer> activNumCol = new TableColumn<Activiteit, Integer>("Activiteitnummer");
		activNumCol.setCellValueFactory(new PropertyValueFactory<Activiteit, Integer>("IntPropActivNum"));
		
		TableColumn<Activiteit, String> activNaamCol = new TableColumn<Activiteit, String>("Activiteitnaam");
		activNaamCol.setCellValueFactory(new PropertyValueFactory<Activiteit, String>("StrPropNaam"));
		
		TableColumn<Activiteit, String> maatFactorCol = new TableColumn<Activiteit, String>("Maatschappelijke factor");
		maatFactorCol.setCellValueFactory(new PropertyValueFactory<Activiteit, String>("StrPropMaatFactor"));
		
		TableColumn<Activiteit, String> prioCol = new TableColumn<Activiteit, String>("Prioriteit");
		prioCol.setCellValueFactory(new PropertyValueFactory<Activiteit, String>("StrPropPrio"));
		
		TableColumn<Activiteit, Integer> activIoTNumCol = new TableColumn<Activiteit, Integer>("IoT-nummer");
		activIoTNumCol.setCellValueFactory(new PropertyValueFactory<Activiteit, Integer>("IntPropIoTNum"));
		
		TableColumn<Activiteit, String> activIoTNaamCol = new TableColumn<Activiteit, String>("IoT-naam");
		activIoTNaamCol.setCellValueFactory(new PropertyValueFactory<Activiteit, String>("StrPropIoTNaam"));
		
		TableColumn<Activiteit, String> activDataSoortCol = new TableColumn<Activiteit, String>("Datasoort");
		activDataSoortCol.setCellValueFactory(new PropertyValueFactory<Activiteit, String>("StrPropDataSoort"));
		
		activiteitenTabel.getColumns().setAll(activNumCol, activNaamCol, maatFactorCol, prioCol, activDataSoortCol, activIoTNumCol, activIoTNaamCol);
		
		//kolommen per IoT-Apparaat
		
		TableColumn<IoTApparaat, Integer> iotNumCol = new TableColumn<IoTApparaat, Integer>("IoT-nummer");
		iotNumCol.setCellValueFactory(new PropertyValueFactory<IoTApparaat, Integer>("IntPropIoTNum"));
		
		TableColumn<IoTApparaat, String> iotNaamCol = new TableColumn<IoTApparaat, String>("IoT-Apparaat");
		iotNaamCol.setCellValueFactory(new PropertyValueFactory<IoTApparaat, String>("StrPropNaam"));
		
		TableColumn<IoTApparaat, String> iotDataCol = new TableColumn<IoTApparaat, String>("Datasoort");
		iotDataCol.setCellValueFactory(new PropertyValueFactory<IoTApparaat, String>("StrPropDataSoort"));
		
		TableColumn<IoTApparaat, Integer> iotActivNumCol = new TableColumn<IoTApparaat, Integer>("Activiteitnummer");
		iotActivNumCol.setCellValueFactory(new PropertyValueFactory<IoTApparaat, Integer>("IntPropActivNum"));
		
		TableColumn<IoTApparaat, String> iotActivNaamCol = new TableColumn<IoTApparaat, String>("Activiteitnaam");
		iotActivNaamCol.setCellValueFactory(new PropertyValueFactory<IoTApparaat, String>("StrPropActivNaam"));
		
		iotTabel.getColumns().setAll(iotNumCol, iotNaamCol, iotDataCol, iotActivNumCol, iotActivNaamCol);
		
		updateUI();
		
		this.cbxPlaats.setOnAction(event ->
		{
			updateUI();
		});
		
	}
	
	public void updateUI()
	{
		if(cbxPlaats.getSelectionModel().getSelectedItem() != null)
		{
			selectedPlaats = cbxPlaats.getSelectionModel().getSelectedItem();
			lblTevredenheid.setText("Tevredenheid mensen over " + selectedPlaats.getStrPropNaam() + ":");
			lblAdvies.setText("Advies voor inrichting van " + selectedPlaats.getStrPropNaam() + " als SMART-City:");
			lblInfoNoData.setText("Momenteel is er geen data beschikbaar over de IoT-apparatuur en activiteiten binnen " + selectedPlaats.getStrPropNaam() + ". \nExcuses voor het ongemak.");
			lblInfoPlaatsTitel.setText("Algemene info over " + selectedPlaats.getStrPropNaam());
			lblTevredenheidWaarde.setText(selectedPlaats.getStrPropTevreden());
			lblPlaatsNaamWaarde.setText(selectedPlaats.getStrPropNaam());
			lblGemeenteWaarde.setText(selectedPlaats.getStrPropGemeente());
			lblStatusWaarde.setText(selectedPlaats.getStrPropStatus());
			lblOppervlakteWaarde.setText(selectedPlaats.getStrPropOppervlakte());
			lblStadPopWaarde.setText(Integer.toString(selectedPlaats.getIntPropStadPop()));
			lblGemeentePopWaarde.setText(Integer.toString(selectedPlaats.getIntPropGemeentePop()));
			lblMetroPopWaarde.setText(Integer.toString(selectedPlaats.getIntPropMetroPop()));
			
			getAdviceForSelectedPlace();
			activiteitenTabelVerversen();
			iotTabelVerversen();
			
			if(activiteitenTabel.getItems().isEmpty() && iotTabel.getItems().isEmpty())
			{
				activiteitenTabel.setVisible(false);
				iotTabel.setVisible(false);
				lblInfoNoData.setVisible(true);					
			}
				
			else
			{
				lblInfoNoData.setVisible(false);					
				activiteitenTabel.setVisible(true);
				iotTabel.setVisible(true);
			}					
		}	
	}
	
	private void activiteitenTabelVerversen()
	{
		if(cbxPlaats.getSelectionModel().getSelectedItem() != null)
			activiteitenTabel.setItems(viewModelDB.getActivityDataFromVM(cbxPlaats.getSelectionModel().getSelectedItem()));
	}
	
	private void iotTabelVerversen()
	{
		if(cbxPlaats.getSelectionModel().getSelectedItem() != null)
			iotTabel.setItems(viewModelDB.getIoTDataFromVM(cbxPlaats.getSelectionModel().getSelectedItem()));
	}
	
	private void getAdviceForSelectedPlace()
	{
		if(cbxPlaats.getSelectionModel().getSelectedItem() != null)
		{
			selectedAdvies = viewModelDB.getAdviceDataFromVM(cbxPlaats.getSelectionModel().getSelectedItem());
			if(selectedAdvies != null)
				if(!selectedAdvies.getPva().isEmpty())
					txtArAdviesWaarde.setText(selectedAdvies.getPva());
				else
					txtArAdviesWaarde.setText("N.v.t.");
			else
				txtArAdviesWaarde.setText("N.v.t.");
		}
			
	}
		
}
