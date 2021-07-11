package com.AAAD.CBR_Docs.View;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.beans.property.Property;
import javafx.collections.*;
import javafx.embed.swing.SwingNode;
import javafx.scene.control.Label;

import com.github.lgooddatepicker.components.TimePicker;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.SwingUtilities;

import com.AAAD.CBR_Docs.Model.*;
import com.AAAD.CBR_Docs.ViewModel.VMExamenSet;

/**
 * De klasse ExamenBeheerScherm representeert een gebruikerscherm waarin diverse examens beheert kunnen worden.
 * Instanties van <code>ExamenBeheerScherm</code> kun je aan een <code>HoofdScherm</code> toevoegen.
 * <br>
 * <br>
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: ExamenBeheerScherm.java
 * @author Adam Oubelkas
 * @version 0.1
 * @since Aanmaakdatum: 7-12-2019
 * @see HoofdScherm
 */

public class ExamenBeheerScherm
{
	public final Button btnZoeken, btnInvoeren, btnBewerken, btnVerwijderen, btnHome, btnExamens, btnStatistieken;
	public final VBox hoofdContainer;
	public final FlowPane hoofdMenu;
	public final GridPane hoofdVenster;
	public final Label lblKopExamens, lblKopGeselecteerdeExamen, lblKandidaat, lblCategorie, lblExamenLocatie, lblKoppeling, lblExamenCode, lblResultaat, lblExamenDatum, lblExamenTijd, lblHerexamen, lblKopRijOpleider;
	public TextArea txtArRijOpleiderWeergave; //Weergave van de rijopleider verandert afhankelijk van de geselecteerde kandidaat
	public final ComboBox<KandidaatSet> cbxKandidaat;
	public final ComboBox<CategorieSet> cbxCategorie;
	public final ComboBox<ExamenLocatieSet> cbxExamenLocatie;
	public final ComboBox<KoppelingBedieningSoort> cbxKoppeling;
	public final ComboBox<Resultaat> cbxResultaat;
	public final ComboBox<String> cbxZoekTerm;
	public final TextField txtExamenCode, txtZoekVeld;
	public final DatePicker dpExamenDatum, dpZoekDatum;
	public final TimePicker tpExamenTijd;
	//public final DateTimePicker tpExamenTijd;
	public final SwingNode tpPanel;
	public final CheckBox chkBxHerexamen;
	public TableView<ExamenSet> selectieTabel;
	public VMExamenSet vmExamenSet;
	public ExamenSet examenSet;
	public KandidaatSet kandidaatSet;
	public ExamenLocatieSet examenLocatieSet;
	public CategorieSet categorieSet;
	public KoppelingBedieningSoort kopBedienSoort;
	public Resultaat resultaat;
	private final Alert userAlert; //Popup bericht weergeven voor de gebruiker
	
	public ExamenBeheerScherm()
	{		
		hoofdMenu = new FlowPane();	
		hoofdVenster = new GridPane();
		hoofdContainer = new VBox();
		
		btnHome = new Button("Home");
		btnExamens = new Button("Examens");
		btnStatistieken = new Button("Toon statistieken");
		
		double nColumns; //Aantal benodigde kolommen voor node-elementen in een GridPane
		double nRows; //Aantal benodige rijen voor de node-elementen in een GridPane
		
		userAlert = new Alert(Alert.AlertType.NONE);
		
		vmExamenSet = new VMExamenSet();
		examenSet = new ExamenSet();
		kandidaatSet = new KandidaatSet();
		examenLocatieSet = new ExamenLocatieSet();
		categorieSet = new CategorieSet();
		kopBedienSoort = new KoppelingBedieningSoort();
		resultaat = new Resultaat();
		
		selectieTabel =  new TableView<ExamenSet>();
		
		lblKopExamens = new Label("Examens:");
		lblKopGeselecteerdeExamen = new Label("Geselecteerde Examen:");
		
		btnZoeken = new Button("Zoeken");
		btnInvoeren = new Button("Invoeren");
		btnBewerken = new Button("Bewerken");
		btnVerwijderen = new Button("Verwijderen");
		
		lblKandidaat = new Label("Kandidaat:");
		lblCategorie = new Label("Categorie:");
		lblExamenLocatie = new Label("Examenlocatie:");
		lblKoppeling = new Label("Soort koppeling:");
		lblExamenCode = new Label("Examencode:");
		lblResultaat = new Label("Resultaat:");
		lblExamenDatum = new Label("Examendatum:");
		lblExamenTijd = new Label("Examentijd:");
		lblHerexamen = new Label("Herexamen?:");
		lblKopRijOpleider = new Label("Rijopleider:");
		txtArRijOpleiderWeergave = new TextArea();
		
		cbxKandidaat = new ComboBox<KandidaatSet>();
		cbxCategorie = new ComboBox<CategorieSet>();
		cbxExamenLocatie = new ComboBox<ExamenLocatieSet>();
		cbxKoppeling = new ComboBox<KoppelingBedieningSoort>();
		cbxResultaat = new ComboBox<Resultaat>();
		//Hieronder is een lijst van alle geldige zoektermen die als keuzewaardes in een combobox aan de gebruiker wordt getoond
		cbxZoekTerm = new ComboBox<String>(FXCollections.observableArrayList("Toon alles","Examencode", "Herexamen?", "Examendatum", "Koppelingbedieningsoort", "Resultaat", "Productcode", "Categoriecode", "Examenlocatienaam", "Kandidaatnaam", "Kandidaatcode", "Opleidernaam", "Opleidercode"));
		
		txtExamenCode = new TextField();
		txtZoekVeld = new TextField();
		
		dpZoekDatum = new DatePicker();
		dpExamenDatum = new DatePicker();
		tpExamenTijd = new TimePicker();
		
		chkBxHerexamen = new CheckBox();
		
		dpZoekDatum.setValue(LocalDate.now());
		dpExamenDatum.setValue(LocalDate.now());
		
		//tpExamenTijd.setLocale(new Locale("nl")); //Toon Nederlandstalige tijden
		//tpExamenTijd = new DateTimePicker();		
		
		//tpExamenTijd.getSettings().setFormatForMenuTimes("hh:mm");  //Toon Nederlandstalige tijden in de items van deze timepicker
		//tpExamenTijd.getSettings().setFormatForDisplayTime("hh:mm");  //Toon Nederlandstalige tijden in de geselecteerde item van deze timepicker
		tpExamenTijd.getSettings().use24HourClockFormat(); //Toon Nederlandstalige tijden in de items van deze timepicker
		tpExamenTijd.setTimeToNow();
		
		tpPanel = new SwingNode(); //Omdat tpExamenTijd geen Node is, moet deze in een speciale 'Node' zitten zodat tpExamenTijd alsnog aanwezig kan zijn in een GridPane
		
		try 
		{
			SwingUtilities.invokeAndWait(		
				new Runnable()  
				{
					@Override
					public void run() 
					{
						tpPanel.setContent(tpExamenTijd);
					}
				}			
			);			
		}
		catch(InterruptedException iemsg)
		{
			System.out.println("Interrupted Exception: " + iemsg.getMessage());
		}
		catch(InvocationTargetException itemsg)
		{
			System.out.println("Invocation Target Exception: " + itemsg.getMessage());
		}			
		
		lblKopExamens.setFont(new Font("Myriad-pro", 20));
		lblKopExamens.setTextFill(Color.DARKCYAN);		
		lblKopGeselecteerdeExamen.setFont(new Font("Myriad-pro", 20));
		lblKopGeselecteerdeExamen.setTextFill(Color.DARKCYAN);
		
		lblKandidaat.setFont(new Font("Arial", 14));
		lblCategorie.setFont(new Font("Arial", 14));
		lblExamenLocatie.setFont(new Font("Arial", 14));
		lblKoppeling.setFont(new Font("Arial", 14));
		lblExamenCode.setFont(new Font("Arial", 14));
		lblResultaat.setFont(new Font("Arial", 14));
		lblExamenDatum.setFont(new Font("Arial", 14));
		lblExamenTijd.setFont(new Font("Arial", 14));
		lblHerexamen.setFont(new Font("Arial", 14));
		lblKopRijOpleider.setFont(new Font("Arial", 14));
		txtArRijOpleiderWeergave.setFont(new Font("Arial", 14));
		
		txtExamenCode.setFont(new Font("Verdana", 14));
		txtZoekVeld.setFont(new Font("Verdana", 14));		
		txtArRijOpleiderWeergave.setFont(new Font("Verdana", 14));
		txtArRijOpleiderWeergave.setEditable(false); //Deze control is alleen bedoeld voor weergave van rijopleider die gekoppeld is aan de door de gebruiker geselecteerde examen
		
		btnInvoeren.setFont(new Font("Arial", 18));
		btnBewerken.setFont(new Font("Arial", 18));
		btnVerwijderen.setFont(new Font("Arial", 18));
		
		btnHome.setTextFill(Color.WHITE);
		btnHome.setStyle("-fx-background-color:#0588F0;");
		btnHome.setFont(new Font("Myriad-pro", 20));
		btnExamens.setTextFill(Color.WHITE);
		btnExamens.setStyle("-fx-background-color:#0588F0;");
		btnExamens.setFont(new Font("Myriad-pro", 20));
		btnStatistieken.setTextFill(Color.WHITE);
		btnStatistieken.setStyle("-fx-background-color:#0588F0;");
		btnStatistieken.setFont(new Font("Myriad-pro", 20));
		
		hoofdVenster.setHgap(10);
		hoofdVenster.setVgap(5);
		hoofdVenster.setPadding(new Insets(10, 15, 20, 25));
		hoofdVenster.setStyle("-fx-background-color:#FFFFFF;");
		hoofdMenu.setStyle("-fx-background-color:#0588F0; -fx-opacity:1;");				
		
		hoofdMenu.getChildren().addAll(btnHome, btnExamens, btnStatistieken);													
		
		kandidaatSet.fillCbxKandidaat(cbxKandidaat);
		categorieSet.fillCbxCategorie(cbxCategorie);
		examenLocatieSet.fillCbxExamenLocatie(cbxExamenLocatie);
		kopBedienSoort.fillCbxKoppeling(cbxKoppeling);
		resultaat.fillCbxResultaat(cbxResultaat);		
				
		cbxZoekTerm.getSelectionModel().select(0); //Laat de gebruiker zien dat alle gegevens getoond worden in het selectietabel
		cbxKandidaat.getSelectionModel().select(0);
		cbxCategorie.getSelectionModel().select(0);
		cbxExamenLocatie.getSelectionModel().select(0);
		cbxKoppeling.getSelectionModel().select(0);
		cbxResultaat.getSelectionModel().select(1); //Zet de geselecteerde waarde op 'N.t.b.'
		
		hoofdVenster.add(lblKopExamens, 0, 0);		
		hoofdVenster.add(txtZoekVeld, 0, 1);
		hoofdVenster.add(btnZoeken, 1, 1);
		hoofdVenster.add(cbxZoekTerm, 2, 1);
		hoofdVenster.add(selectieTabel, 0, 2);
		hoofdVenster.add(lblKopGeselecteerdeExamen, 3, 0);
		hoofdVenster.add(lblKandidaat, 3, 1);
		hoofdVenster.add(cbxKandidaat, 4, 1);
		hoofdVenster.add(lblCategorie, 3, 2);
		hoofdVenster.add(cbxCategorie, 4, 2);
		hoofdVenster.add(lblExamenLocatie, 3, 3);
		hoofdVenster.add(cbxExamenLocatie, 4, 3);
		hoofdVenster.add(lblKoppeling, 3, 4);
		hoofdVenster.add(cbxKoppeling, 4, 4);
		hoofdVenster.add(lblExamenCode, 3, 5);
		hoofdVenster.add(txtExamenCode, 4, 5);
		hoofdVenster.add(lblResultaat, 3, 6);
		hoofdVenster.add(cbxResultaat, 4, 6);
		hoofdVenster.add(lblExamenDatum, 3, 7);
		hoofdVenster.add(dpExamenDatum, 4, 7);		
		hoofdVenster.add(lblExamenTijd, 3, 8);
		hoofdVenster.add(tpPanel, 4, 8);
		hoofdVenster.add(lblHerexamen, 3, 9);
		hoofdVenster.add(chkBxHerexamen, 4, 9);
		hoofdVenster.add(lblKopRijOpleider, 5, 1);
		hoofdVenster.add(txtArRijOpleiderWeergave, 5, 2);
		hoofdVenster.add(btnInvoeren, 3, 11);
		hoofdVenster.add(btnBewerken, 4, 11);
		hoofdVenster.add(btnVerwijderen, 5, 11);					
		
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
		
		double maxWidthTable = selectieTabel.getColumns().size() * 6;
		double maxWidthCbx = hoofdVenster.getChildren().size() * 4;
		
		selectieTabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		selectieTabel.setPrefWidth(maxWidthTable);
		txtArRijOpleiderWeergave.setPrefSize(250, 250);
		
		cbxZoekTerm.setPrefWidth(maxWidthCbx);
		//cbxKandidaat.setPrefWidth(maxWidthCbx);
		cbxCategorie.setPrefWidth(hoofdVenster.getChildren().size() * 10);
		cbxExamenLocatie.setPrefWidth(hoofdVenster.getChildren().size() * 10);
		//cbxKoppeling.setPrefWidth(maxWidthCbx);
		//cbxResultaat.setPrefWidth(maxWidthCbx);
		
		
		hoofdContainer.getChildren().addAll(hoofdMenu, hoofdVenster);		
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);						
		
		TableColumn<ExamenSet, String> examenCodeCol = new TableColumn<ExamenSet, String>("Examencode");
		examenCodeCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropExamenCode"));
		
		TableColumn<ExamenSet, String> examDatumCol = new TableColumn<ExamenSet, String>("Examdatum");
		examDatumCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropExamDatum"));
		
		TableColumn<ExamenSet, String> examTijdCol = new TableColumn<ExamenSet, String>("Examtijd");
		examTijdCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropExamTijd"));
		
		TableColumn<ExamenSet, String> kopBedienSoortCol = new TableColumn<ExamenSet, String>("Koppelingbedieningsoort");
		kopBedienSoortCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropKopBedienSoort"));
		
		TableColumn<ExamenSet, String> resultaatCol = new TableColumn<ExamenSet, String>("Resultaat");
		resultaatCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropResultaat"));
		
		TableColumn<ExamenSet, String> productCodeCol = new TableColumn<ExamenSet, String>("Productcode");
		productCodeCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropProductCode"));
		
		TableColumn<ExamenSet, String> categorieCodeCol = new TableColumn<ExamenSet, String>("Categoriecode");
		categorieCodeCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropCategorieCode"));
		
		TableColumn<ExamenSet, String> examLocNaamCol = new TableColumn<ExamenSet, String>("Examenlocatienaam");
		examLocNaamCol.setCellValueFactory(new PropertyValueFactory<ExamenSet, String>("strPropExamLocNaam"));
		
		selectieTabel.getColumns().setAll(examenCodeCol, kopBedienSoortCol, resultaatCol, categorieCodeCol, productCodeCol);									
		
		this.selectieTabelVerversen();
		
		this.btnInvoeren.setOnAction(event ->
		{
			if(!this.valideerGebruikersInvoer("Invoeren examen mislukt!"))
				this.nieuweExamenSetInvoeren();
		});
		
		this.btnBewerken.setOnAction(event ->
		{
			if(!this.valideerGebruikersInvoer("Bewerken examen mislukt!"))
				this.examenSetBewerken();
		});
		
		this.btnVerwijderen.setOnAction(event ->
		{
			if(!txtExamenCode.getText().isEmpty())
				this.examenSetVerwijderen();
			else
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Verwijderen examen mislukt!");
				userAlert.setContentText("Invoerveld Examencode is leeg!");
				userAlert.showAndWait();
			}
		});
		
		this.selectieTabel.setOnMouseClicked(event -> 
		{
			if(!this.selectieTabel.getSelectionModel().isEmpty())
				this.examenSetSelecteren();
		});
		
		this.selectieTabel.setOnKeyPressed(event -> 
		{
			if(!this.selectieTabel.getSelectionModel().isEmpty())
				this.examenSetSelecteren();
		});
		
		this.btnZoeken.setOnAction(event -> 
		{
			if(hoofdVenster.getChildren().contains(txtZoekVeld))
				this.zoekExamenSet(txtZoekVeld.getText());
			else if(hoofdVenster.getChildren().contains(dpZoekDatum))
				this.zoekExamenSet(dpZoekDatum.getValue().toString());
		});
		
		this.cbxZoekTerm.setOnAction(event ->
		{
			if(cbxZoekTerm.getSelectionModel().getSelectedItem().toString() == "Examendatum" && hoofdVenster.getChildren().contains(txtZoekVeld))
			{
				hoofdVenster.getChildren().remove(txtZoekVeld);
				hoofdVenster.add(dpZoekDatum, 0, 1);
			}
			else if(hoofdVenster.getChildren().contains(dpZoekDatum))
			{
				hoofdVenster.getChildren().remove(dpZoekDatum);
				hoofdVenster.add(txtZoekVeld, 0, 1);
			}				
		});
		
		this.tpPanel.setOnMouseClicked(event -> 
		{
			SwingUtilities.invokeLater
			(		
				new Runnable()  
				{
					@Override
					public void run() 
					{
						//tpExamenTijd.updateUI();
						tpExamenTijd.openPopup();
						//tpExamenTijd.togglePopup();
						Boolean testPopUptp = tpExamenTijd.isPopupOpen();
						System.out.println("PopUpMenu tpExamenTijd is " + (testPopUptp ? "open" : "gesloten"));
					}
				}			
			);
		});
	}
	
	public void selectieTabelVerversen()
	{
		try 
		{			
			vmExamenSet.weergeven(selectieTabel);
		}
		catch(SQLException sqlexc)
		{
			userAlert.setAlertType(AlertType.ERROR);
			userAlert.setHeaderText("Probleem met database");
			userAlert.setContentText("Er vinden problemen plaats in de database. Neem contact op met de ontwikkelaar.");
			System.out.println(sqlexc.getLocalizedMessage());
			userAlert.showAndWait();
		}		
	}
	
	public void zoekExamenSet(String zoekWaarde)
	{
		try 
		{
			if(cbxZoekTerm.getValue().toString() == "Toon alles")
				vmExamenSet.weergeven(selectieTabel);
			else if(!cbxZoekTerm.getValue().isEmpty())
			{
				switch(cbxZoekTerm.getValue().toString())
				{
					case "Examendatum":
						vmExamenSet.zoeken(selectieTabel, "ExamDatum", zoekWaarde, false);
						break;
					case "Koppelingbedieningsoort":
						vmExamenSet.zoeken(selectieTabel, "KopBedienSoort", zoekWaarde, false);
						break;
					case "Productcode":
						vmExamenSet.zoeken(selectieTabel, "ProductCode", zoekWaarde, false);
						break;
					case "Categoriecode":
						vmExamenSet.zoeken(selectieTabel, "CategorieCode", zoekWaarde, false);
						break;
					case "Examenlocatienaam":
						vmExamenSet.zoeken(selectieTabel, "ExamLocNaam", zoekWaarde, false);
						break;
					case "Kandidaatnaam":
						vmExamenSet.zoeken(selectieTabel, "KandiNaam", zoekWaarde, false);
						break;
					case "Kandidaatcode":
						vmExamenSet.zoeken(selectieTabel, "KandiCode", zoekWaarde, false);
						break;
					case "Herexamen?":
						vmExamenSet.zoeken(selectieTabel, "IsHerexamen", "1", true);	
						break;
					default:
						vmExamenSet.zoeken(selectieTabel, cbxZoekTerm.getValue().toString(), zoekWaarde, false);
						break;
				}				
			}								
			else 
			{
				userAlert.setAlertType(Alert.AlertType.WARNING);
				userAlert.setHeaderText("Zoekterm verplicht!");
				userAlert.setContentText("Om examens op te zoeken, moet u een zoekterm kiezen uit de keuzeveld naast het zoekveld.");
				userAlert.showAndWait();
			}
		}
		catch(SQLException sqlexc)
		{
			userAlert.setAlertType(AlertType.ERROR);
			userAlert.setHeaderText("Probleem met database");
			userAlert.setContentText("Er vinden problemen plaats in de database. Neem contact op met de ontwikkelaar.");
			System.out.println(sqlexc.getLocalizedMessage());
			userAlert.showAndWait();
		}
	}
	
	public void nieuweExamenSetInvoeren()
	{
		try
		{
			try 
			{
				examenSet.setKandiCode(cbxKandidaat.getValue().getKandiCode());
				examenSet.setKandiNaam(cbxKandidaat.getValue().getKandiNaam());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Invoeren examen mislukt!");
				userAlert.setContentText("Keuzeveld voor kandidaat is leeg!");
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try
			{
				examenSet.setExamenCode(txtExamenCode.getText());
			}
			catch(IllegalArgumentException iae)
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Invoeren examen mislukt!");
				userAlert.setContentText("Invoerveld voor examencode is ongeldig! Dit invoerveld moet alleen tekst bevatten!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setStrPropExamDatum(dpExamenDatum.getValue().toString());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Invoeren examen mislukt!");
				userAlert.setContentText("Invoerveld voor examendatum is niet ingevuld!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				SwingUtilities.invokeLater
				(		
					new Runnable()  
					{
						@Override
						public void run() 
						{
							examenSet.setStrPropExamTijd(tpExamenTijd.getTime().toString());
						}
					}			
				);
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Invoeren examen mislukt!");
				userAlert.setContentText("Invoerveld voor examentijd is niet ingevuld!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setStrPropExamLocNaam(cbxExamenLocatie.getValue().getExamLocNaam());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Keuzeveld voor examenlocatie is leeg!");
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}

			try 
			{
				examenSet.setStrPropKopBedienSoort(cbxKoppeling.getValue().getKopBedienSoort());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Invoeren examen mislukt!");
				userAlert.setContentText("Keuzeveld voor soort koppeling is leeg!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{			
				examenSet.setStrPropCategorieCode(cbxCategorie.getValue().getCategorieCode());
				examenSet.setStrPropProductCode(cbxCategorie.getValue().getProductCode());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Invoeren examen mislukt!");
				userAlert.setContentText("Keuzeveld voor categorie is leeg!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setStrPropResultaat(cbxResultaat.getValue().getResultaat());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Invoeren examen mislukt!");
				userAlert.setContentText("Keuzeveld voor resultaat is leeg!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			examenSet.setIsHerexamen(chkBxHerexamen.isSelected());
			
			examenSet.invoeren();
			userAlert.setAlertType(AlertType.INFORMATION);
			userAlert.setHeaderText("Invoeren examen geslaagd!");
			userAlert.setContentText("Het nieuwe examen is succesvol ingevoerd in de database.");
			userAlert.showAndWait();
			this.selectieTabelVerversen();
		}
		catch(SQLException sqlexc)
		{
			userAlert.setAlertType(AlertType.ERROR);
			userAlert.setHeaderText("Probleem met database");
			userAlert.setContentText("Er vinden problemen plaats in de database. Neem contact op met de ontwikkelaar.");
			System.out.println(sqlexc.getLocalizedMessage());
			userAlert.showAndWait();
		}
		catch(IllegalArgumentException iae) 
		{
			System.out.println(iae.getMessage());
		}
		catch(RuntimeException rte)
		{
			System.out.println(rte.getMessage());
		}
	}
	
	public void examenSetBewerken()
	{
		try 
		{
			try 
			{
				examenSet.setExamenCode(txtExamenCode.getText());
			}
			catch(IllegalArgumentException iae)
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Invoerveld voor examencode is ongeldig! Dit invoerveld moet uitsluitend tekst bevatten!");
				System.out.println(iae.getLocalizedMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getLocalizedMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setKandiCode(cbxKandidaat.getValue().getKandiCode());
				examenSet.setKandiNaam(cbxKandidaat.getValue().getKandiNaam());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Keuzeveld voor kandidaat is leeg!");
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setStrPropExamDatum(dpExamenDatum.getValue().toString());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Invoerveld voor examendatum is niet ingevuld!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				SwingUtilities.invokeLater
				(		
					new Runnable()  
					{
						@Override
						public void run() 
						{
							examenSet.setStrPropExamTijd(tpExamenTijd.getTime().toString());
						}
					}			
				);
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Invoerveld voor examentijd is niet ingevuld!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setStrPropExamLocNaam(cbxExamenLocatie.getValue().getExamLocNaam());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Keuzeveld voor examenlocatie is leeg!");
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setStrPropKopBedienSoort(cbxKoppeling.getValue().getKopBedienSoort());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Keuzeveld voor soort koppeling is leeg!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{			
				examenSet.setStrPropCategorieCode(cbxCategorie.getValue().getCategorieCode());
				examenSet.setStrPropProductCode(cbxCategorie.getValue().getProductCode());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Keuzeveld voor categorie is leeg!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			try 
			{
				examenSet.setStrPropResultaat(cbxResultaat.getValue().getResultaat());
			}
			catch(IllegalArgumentException iae) 
			{
				userAlert.setAlertType(Alert.AlertType.ERROR);
				userAlert.setHeaderText("Bewerken examen mislukt!");
				userAlert.setContentText("Keuzeveld voor resultaat is leeg!");			
				System.out.println(iae.getMessage());
				userAlert.showAndWait();
				throw iae;
			}
			catch(RuntimeException rte)
			{
				System.out.println(rte.getMessage());
				throw rte;
			}
			
			examenSet.setIsHerexamen(chkBxHerexamen.isSelected());
			
			examenSet.bewerken();
			userAlert.setAlertType(AlertType.INFORMATION);
			userAlert.setHeaderText("Bewerken examen geslaagd!");
			userAlert.setContentText("Het geselecteerde examen is succesvol bewerkt in de database.");
			userAlert.showAndWait();			
			this.selectieTabelVerversen();
		}
		catch(SQLException sqlexc)
		{
			userAlert.setAlertType(AlertType.ERROR);
			userAlert.setHeaderText("Probleem met database");
			userAlert.setContentText("Er vinden problemen plaats in de database. Neem contact op met de ontwikkelaar.");
			System.out.println(sqlexc.getLocalizedMessage());
			userAlert.showAndWait();
		}
		catch(IllegalArgumentException iae) 
		{
			userAlert.setAlertType(Alert.AlertType.ERROR);
			userAlert.setHeaderText("Bewerken examen mislukt!");
			userAlert.setContentText(iae.getLocalizedMessage());			
			System.out.println(iae.getMessage());
			userAlert.showAndWait();
		}
		catch(RuntimeException rte)
		{
			System.out.println(rte.getMessage());
		}
	}
	
	public void examenSetVerwijderen()
	{
		try 
		{
			examenSet.setExamenCode(txtExamenCode.getText());
			examenSet.verwijderen();
			this.selectieTabelVerversen();
			cbxKandidaat.getSelectionModel().select(0);
			cbxCategorie.getSelectionModel().select(0);
			cbxExamenLocatie.getSelectionModel().select(0);
			cbxKoppeling.getSelectionModel().select(0);
			cbxResultaat.getSelectionModel().select(0);
			dpExamenDatum.setValue(LocalDate.now());
			SwingUtilities.invokeLater
			(		
				new Runnable()  
				{
					@Override
					public void run() 
					{
						tpExamenTijd.clear();
					}
				}			
			);
			chkBxHerexamen.setSelected(false);
		 	txtExamenCode.clear();
		 	txtArRijOpleiderWeergave.clear();
			userAlert.setAlertType(AlertType.INFORMATION);
			userAlert.setHeaderText("Verwijderen examen geslaagd!");
			userAlert.setContentText("Het geselecteerde examen is succesvol verwijderd uit de database.");
			userAlert.showAndWait();
		}
		catch(SQLException sqlexc)
		{
			userAlert.setAlertType(AlertType.ERROR);
			userAlert.setHeaderText("Probleem met database");
			userAlert.setContentText("Er vinden problemen plaats in de database. Neem contact op met de ontwikkelaar.");
			System.out.println(sqlexc.getLocalizedMessage());
			userAlert.showAndWait();
		}
		catch(IllegalArgumentException iae) 
		{
			userAlert.setAlertType(Alert.AlertType.ERROR);
			userAlert.setHeaderText("Verwijderen examen mislukt!");
			userAlert.setContentText(iae.getLocalizedMessage());	
			System.out.println(iae.getMessage());
			userAlert.showAndWait();
		}
		catch(RuntimeException rte)
		{
			System.out.println(rte.getMessage());
		}
	}
	
	public void examenSetSelecteren()
	{
		try 
		{
		 	ExamenSet selectedExamenSet = selectieTabel.getSelectionModel().getSelectedItem();
		 	KandidaatSet selectedKandidaat = new KandidaatSet();
		 	CategorieSet selectedCategorie = new CategorieSet();
		 	KoppelingBedieningSoort selectedKoppeling = new KoppelingBedieningSoort();
		 	Resultaat selectedResultaat = new Resultaat();
		 	ExamenLocatieSet selectedExamenLocatie = new ExamenLocatieSet();
		 	
		 	selectedKandidaat.setKandiCode(selectedExamenSet.getKandiCode());
		 	selectedKandidaat.setKandiNaam(selectedExamenSet.getKandiNaam());
		 	selectedKandidaat.setOpleiderCode(selectedExamenSet.getOpleiderCode());
		 	selectedKandidaat.setOpleiderNaam(selectedExamenSet.getOpleiderNaam());
		 	
		 	selectedCategorie.setCategorieCode(selectedExamenSet.getStrPropCategorieCode());
		 	selectedCategorie.setCategorieNaam(selectedExamenSet.getCategorieNaam());
		 	selectedCategorie.setProductCode(selectedExamenSet.getStrPropProductCode());
		 	selectedCategorie.setProductNaam(selectedExamenSet.getProductNaam());
		 	
		 	selectedKoppeling.setKopBedienSoort(selectedExamenSet.getStrPropKopBedienSoort());
		 	selectedResultaat.setResultaat(selectedExamenSet.getStrPropResultaat());
		 	selectedExamenLocatie.setExamLocNaam(selectedExamenSet.getStrPropExamLocNaam());		 			 		 
			
//			cbxKandidaat.getSelectionModel().select(selectedKandidaat);
//			cbxCategorie.getSelectionModel().select(selectedCategorie);
//			cbxExamenLocatie.getSelectionModel().select(selectedExamenLocatie);
//			cbxKoppeling.getSelectionModel().select(selectedKoppeling);
//			cbxResultaat.getSelectionModel().select(selectedResultaat);	
		 	
			cbxKandidaat.setValue(selectedKandidaat);
			cbxCategorie.setValue(selectedCategorie);
			cbxExamenLocatie.setValue(selectedExamenLocatie);
			cbxKoppeling.setValue(selectedKoppeling);
			cbxResultaat.setValue(selectedResultaat);
			
		 	dpExamenDatum.setValue(selectedExamenSet.getExamDatum());
			SwingUtilities.invokeLater
			(		
				new Runnable()  
				{
					@Override
					public void run() 
					{
						tpExamenTijd.setTime(selectedExamenSet.getExamTijd());
					}
				}			
			);		 	
		 	//LocalDateTime newLDT = LocalDateTime.of(selectedExamenSet.getExamDatum(), selectedExamenSet.getExamTijd());
		 	//dpExamenDatum.setDateTimeValue(newLDT);
			chkBxHerexamen.setSelected(selectedExamenSet.getIsHerexamen());
		 	txtExamenCode.setText(selectedExamenSet.getStrPropExamenCode());
		 	txtArRijOpleiderWeergave.setText(selectedExamenSet.getOpleiderSet()); //txtArRijOpleiderWeergave.setText(selectedExamenSet.zoeken("KandiCode", selectedExamenSet.getKandiCode()).selectieExamenLijst.get(0).getOpleiderSet());
		}
//		catch(SQLException sqlexc)
//		{
//			userAlert.setAlertType(AlertType.ERROR);
//			userAlert.setHeaderText("Onbekende probleemen met applicatie");
//			userAlert.setContentText("Er vinden problemen plaats in de applicatie. Neem contact op met de ontwikkelaar.");
//			System.out.println(sqlexc.getLocalizedMessage());
//			userAlert.showAndWait();
//		}
		catch(NullPointerException npe)
		{
			System.out.println(npe.getMessage());
		}
		catch(RuntimeException rte)
		{
			System.out.println(rte.getMessage());
		}
	}
	
	public Boolean valideerGebruikersInvoer(String alertHeaderText)
	{
		userAlert.setContentText(""); //Leeg de meest recente boodschaptekst
		String validationMsg = "Volgende invoervelden zijn leeg:";
		Boolean isInvoerOngeldig = false;
		if(cbxKandidaat.getValue().getKandiNaam() == "Geen" || cbxKandidaat.getValue().getKandiNaam().isEmpty())
		{
			validationMsg += "\n-Kandidaat";
			isInvoerOngeldig = true;
		}
		if(txtExamenCode.getText().isEmpty() == true)
		{
			validationMsg += "\n-Examencode";
			isInvoerOngeldig = true;
		}
		if(dpExamenDatum.getValue().toString().isEmpty()) 
		{
			validationMsg += "\n-Examendatum";
			isInvoerOngeldig = true;
		}			
		SwingUtilities.invokeLater
		(	
			new Runnable()  
			{
				@Override
				public void run() 
				{
					if(tpExamenTijd.getTime() == null)
					{
						userAlert.setContentText("\n-Examentijd"); //doorgeven van deze string waarde, aan de globale variabel 'validationMsg', kan alleen via een globale object
					}
				}
			}			
		);
		if(!userAlert.getContentText().isEmpty()) 
		{
			validationMsg += userAlert.getContentText();
			isInvoerOngeldig = true;
		}			
		if(cbxExamenLocatie.getValue().getExamLocNaam() == "Geen" || cbxExamenLocatie.getValue().getExamLocNaam().isEmpty())
		{
			validationMsg += "\n-Examenlocatienaam";
			isInvoerOngeldig = true;
		}			
		if(cbxCategorie.getValue().getCategorieNaam() == "Geen" || cbxCategorie.getValue().getCategorieNaam().isEmpty())
		{
			validationMsg += "\n-Categorie";
			isInvoerOngeldig = true;
		}			
		if(cbxResultaat.getValue().getResultaat() == "Geen" || cbxResultaat.getValue().getResultaat().isEmpty())
		{
			validationMsg += "\n-Resultaat";
			isInvoerOngeldig = true;
		}			
		if(cbxKoppeling.getValue().getKopBedienSoort() == "Geen" || cbxKoppeling.getValue().getKopBedienSoort().isEmpty())
		{
			validationMsg += "\n-Koppelingbedieningsoort";
			isInvoerOngeldig = true;
		}		
		
		if(isInvoerOngeldig == true) 
		{
			userAlert.setAlertType(Alert.AlertType.ERROR);
			userAlert.setHeaderText(alertHeaderText);
			userAlert.setContentText(validationMsg);
			userAlert.showAndWait();
		}
		
		if(txtExamenCode.getText().length() > 6)
		{
			isInvoerOngeldig = true;
			userAlert.setAlertType(Alert.AlertType.ERROR);
			userAlert.setHeaderText("Invoerveld Examencode ongeldig!");
			userAlert.setContentText("\n\nInvoerveld Examencode mag niet meer dan 6 karakters bevatten!");
			userAlert.showAndWait();			
		}
		
		return isInvoerOngeldig;
	}
}
