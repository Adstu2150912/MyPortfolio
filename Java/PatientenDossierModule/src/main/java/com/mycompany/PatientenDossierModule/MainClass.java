package com.mycompany.PatientenDossierModule;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 13-10-2019
 * Project: Elektronisch Patiëntendossier - De Graafschap
 * Bestandsnaam: MainClass.java
 */
public class MainClass extends Application
{	
	Scene startScene, selectieKlantScene, klantWeergaveScene, invoerKlantScene, selectiePatiëntScene, patiëntWeergaveScene, 
	invoerPatiëntScene, bewerkKlantScene, bewerkPatiëntScene, verwijderKlantScene, verwijderPatiëntScene;
	private boolean isKlant, isPatiënt, bekijkKlant, bekijkPatiënt, invoerKlant, invoerPatiënt, bewerkKlant, 
	bewerkPatiënt, verwijderKlant, verwijderPatiënt;
	Startscherm startScherm = new Startscherm();
	SelectieKlantScherm selectieKlantScherm = new SelectieKlantScherm();
	KlantWeergaveScherm klantWeergaveScherm = new KlantWeergaveScherm();
	InvoerKlantScherm invoerKlantScherm = new InvoerKlantScherm();
	SelectiePatiëntScherm selectiePatiëntScherm = new SelectiePatiëntScherm();	
	PatiëntWeergaveScherm patiëntWeergaveScherm = new PatiëntWeergaveScherm();
	InvoerPatiëntScherm invoerPatiëntScherm = new InvoerPatiëntScherm();
	BewerkKlantScherm bewerkKlantScherm = new BewerkKlantScherm();
	BewerkPatiëntScherm bewerkPatiëntScherm = new BewerkPatiëntScherm();
	VerwijderKlantScherm verwijderKlantScherm = new VerwijderKlantScherm();
	VerwijderPatiëntScherm verwijderPatiëntScherm = new VerwijderPatiëntScherm();
	
	@Override
	public void start(Stage mainStage) 
	{
		isKlant = isPatiënt = bekijkKlant = bekijkPatiënt = invoerKlant = invoerPatiënt =  bewerkKlant = bewerkPatiënt = verwijderKlant = verwijderPatiënt = false;
		
		startScene = new Scene(startScherm.hoofdContainer);
		selectieKlantScene = new Scene(selectieKlantScherm.hoofdContainer);						
		klantWeergaveScene = new Scene(klantWeergaveScherm.hoofdContainer);
		invoerKlantScene = new Scene(invoerKlantScherm.hoofdContainer);
		selectiePatiëntScene = new Scene(selectiePatiëntScherm.hoofdContainer);
		patiëntWeergaveScene = new Scene(patiëntWeergaveScherm.hoofdContainer);
		invoerPatiëntScene = new Scene(invoerPatiëntScherm.hoofdContainer);
		bewerkKlantScene = new Scene(bewerkKlantScherm.hoofdContainer);
		bewerkPatiëntScene = new Scene(bewerkPatiëntScherm.hoofdContainer);
		verwijderKlantScene = new Scene(verwijderKlantScherm.hoofdContainer);
		verwijderPatiëntScene = new Scene(verwijderPatiëntScherm.hoofdContainer);
		
		mainStage.setScene(startScene);
		mainStage.setTitle("PetMedic - Patiëntendossier");
		mainStage.show();
		
		//klikevents startscherm		
		startScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				startScherm.subMenu.setVisible(isKlant);				
			}
			else
			{
				isKlant = true;
				startScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
			//System.out.println("Er is op knop 'Klant' geklikt...");
		});
		
		startScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				startScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				startScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;
			}	
			//System.out.println("Knop 'Patiënt' is geklikt...");
		});
		
		startScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		startScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		startScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false; 
				verwijderKlant = false; 
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false; 						
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		startScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;				
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false; 
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				bewerkKlant = false;
			}
		});
		
		//klikevents selectiescherm klant		
		selectieKlantScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectieKlantScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectieKlantScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		selectieKlantScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				selectieKlantScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				selectieKlantScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;				
			}	
		});
		
		selectieKlantScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		selectieKlantScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		selectieKlantScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		selectieKlantScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		
		selectieKlantScherm.btnBevestigen.setOnAction(event ->
		{
			if(bekijkKlant) 
			{
				int huidigeKlantNr = selectieKlantScherm.selectieTabel.getSelectionModel().getSelectedItem().getKlantNummer();
				Klant geselecteerdeKlant = new Klant();
				geselecteerdeKlant.klantWeergeven(huidigeKlantNr);
				//selectieKlantScherm.selectedKlant = geselecteerdeKlant;
				klantWeergaveScherm.klantGegevensVerwerken(geselecteerdeKlant);
				mainStage.setScene(klantWeergaveScene);
			}
			else if(bewerkKlant)
			{
				int huidigeKlantNr = selectieKlantScherm.selectieTabel.getSelectionModel().getSelectedItem().getKlantNummer();
				Klant geselecteerdeKlant = new Klant();
				geselecteerdeKlant.klantWeergeven(huidigeKlantNr);
				bewerkKlantScherm.klantGegevensVerwerken(geselecteerdeKlant);
				mainStage.setScene(bewerkKlantScene);
			}
		});
		
		//klikevents klantweergavescherm
		klantWeergaveScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				klantWeergaveScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				klantWeergaveScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		klantWeergaveScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				klantWeergaveScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				klantWeergaveScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;				
			}	
		});
		
		klantWeergaveScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		klantWeergaveScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		klantWeergaveScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		klantWeergaveScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		//klikevents invoerKlantScherm
		invoerKlantScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				klantWeergaveScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				klantWeergaveScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		invoerKlantScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				klantWeergaveScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				klantWeergaveScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;				
			}	
		});
		
		invoerKlantScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		invoerKlantScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		invoerKlantScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		invoerKlantScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		invoerKlantScherm.btnBevestigen.setOnAction(event ->
		{
			Klant geselecteerdeKlant = new Klant();
			geselecteerdeKlant.klantWeergeven(invoerKlantScherm.klantInvoeren());				
			klantWeergaveScherm.klantGegevensVerwerken(geselecteerdeKlant);
			mainStage.setScene(klantWeergaveScene);
		});
		
		//klikevents selectiePatiëntScherm
		selectiePatiëntScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		selectiePatiëntScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				selectiePatiëntScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				selectiePatiëntScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;				
			}	
		});
		
		selectiePatiëntScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		selectiePatiëntScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		selectiePatiëntScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		selectiePatiëntScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		selectiePatiëntScherm.btnBevestigen.setOnAction(event ->
		{
			if(bekijkPatiënt) 
			{
				int huidigePatiëntNr = selectiePatiëntScherm.selectieTabel.getSelectionModel().getSelectedItem().getPatiëntNummer();
				Patiënt geselecteerdePatiënt = new Patiënt();
				geselecteerdePatiënt.patiëntWeergeven(huidigePatiëntNr);
				//selectiePatiëntScherm.selectedPatiënt = geselecteerdePatiënt;
				patiëntWeergaveScherm.patiëntGegevensVerwerken(geselecteerdePatiënt);
				mainStage.setScene(patiëntWeergaveScene);
			}
			else if(bewerkPatiënt)
			{
				int huidigePatiëntNr = selectiePatiëntScherm.selectieTabel.getSelectionModel().getSelectedItem().getPatiëntNummer();
				Patiënt geselecteerdePatiënt = new Patiënt();
				geselecteerdePatiënt.patiëntWeergeven(huidigePatiëntNr);
				bewerkPatiëntScherm.patiëntGegevensVerwerken(geselecteerdePatiënt);
				mainStage.setScene(bewerkPatiëntScene);
			}
		});
		
		//klikevents PatiëntWeergaveScherm
		patiëntWeergaveScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		patiëntWeergaveScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				startScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				startScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;
			}	
		});
		
		patiëntWeergaveScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		patiëntWeergaveScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		patiëntWeergaveScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		patiëntWeergaveScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		
		//klikevents InvoerPatiëntScherm
		invoerPatiëntScherm.btnBevestigen.setOnAction(event ->
		{			
			invoerPatiëntScherm.patiëntInvoeren();				
			patiëntWeergaveScherm.patiëntGegevensVerwerken(invoerPatiëntScherm.nieuwePatiënt);
			mainStage.setScene(patiëntWeergaveScene);
		});
		
		invoerPatiëntScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		invoerPatiëntScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				startScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				startScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;
			}	
		});
		
		invoerPatiëntScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		invoerPatiëntScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		invoerPatiëntScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		invoerPatiëntScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		//klikevents BewerkKlantScherm
		bewerkKlantScherm.btnBevestigen.setOnAction(event ->
		{
			bewerkKlantScherm.klantBewerken();				
			klantWeergaveScherm.klantGegevensVerwerken(bewerkKlantScherm.huidigeKlant);
			mainStage.setScene(klantWeergaveScene);
		});
		
		bewerkKlantScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		bewerkKlantScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				startScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				startScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;
			}	
		});
		
		bewerkKlantScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		bewerkKlantScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});		
		
		bewerkKlantScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		bewerkKlantScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		//klikevents BewerkPatiëntScherm
		bewerkPatiëntScherm.btnBevestigen.setOnAction(event ->
		{
			bewerkPatiëntScherm.patiëntBewerken();				
			patiëntWeergaveScherm.patiëntGegevensVerwerken(bewerkPatiëntScherm.huidigePatiënt);
			mainStage.setScene(patiëntWeergaveScene);			
		});
		
		bewerkPatiëntScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		bewerkPatiëntScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				startScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				startScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;
			}	
		});
		
		bewerkPatiëntScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		bewerkPatiëntScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});	
		
		bewerkPatiëntScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		bewerkPatiëntScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		//klikevents VerwijderKlantScherm
		verwijderKlantScherm.btnBevestigen.setOnAction(event ->
		{
			Klant geselecteerdeKlant = verwijderKlantScherm.selectieTabel.getSelectionModel().getSelectedItem();
			geselecteerdeKlant.klantVerwijderen();
			mainStage.setScene(startScene);			
		});
		
		verwijderKlantScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		verwijderKlantScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				startScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				startScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;
			}	
		});
		
		verwijderKlantScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		verwijderKlantScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		verwijderKlantScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		verwijderKlantScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});
		
		//klikevents VerwijderPatiëntScherm
		verwijderPatiëntScherm.btnBevestigen.setOnAction(event ->
		{
			Patiënt geselecteerdePatiënt = verwijderPatiëntScherm.selectieTabel.getSelectionModel().getSelectedItem();
			geselecteerdePatiënt.patiëntVerwijderen();
			mainStage.setScene(startScene);
		});
		
		verwijderPatiëntScherm.btnKlant.setOnAction( event -> 
		{
			if(isKlant == true) 
			{
				isKlant = isPatiënt = false;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
			}
			else
			{
				isKlant = true;
				selectiePatiëntScherm.subMenu.setVisible(isKlant);
				isPatiënt = false;
			}			
		});
		
		verwijderPatiëntScherm.btnPatiënt.setOnAction( event -> 
		{
			if(isPatiënt == true) 
			{
				isPatiënt = isKlant = false;
				startScherm.subMenu.setVisible(isPatiënt);
			}
			else
			{
				isPatiënt = true;
				startScherm.subMenu.setVisible(isPatiënt);
				isKlant = false;
			}	
		});
		
		verwijderPatiëntScherm.btnBekijken.setOnAction(event -> 
		{
			if(isKlant == true) 
			{
				mainStage.setScene(selectieKlantScene);
				bekijkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				invoerKlant = false;
				invoerPatiënt = false; 
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bekijkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		verwijderPatiëntScherm.btnInvoeren.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(invoerKlantScene);
				invoerKlant = true;
				isKlant = false;
				isPatiënt = false; 
				bekijkPatiënt = false;
				bekijkKlant = false; 
				invoerPatiënt = false;
				bewerkKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(invoerPatiëntScene);
				invoerPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant =  false;
				bewerkKlant = false;
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		verwijderPatiëntScherm.btnBewerken.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(selectieKlantScene);
				bewerkKlant = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false; 
				bewerkPatiënt = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(selectiePatiëntScene);
				bewerkPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkKlant = false;
				verwijderKlant = false;
				verwijderPatiënt = false;
			}
		});
		
		verwijderPatiëntScherm.btnVerwijderen.setOnAction(event ->
		{
			if(isKlant == true)
			{
				mainStage.setScene(verwijderKlantScene);
				verwijderKlant = true;
				isKlant = false; 
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerPatiënt = false;
				invoerKlant = false;
				bewerkPatiënt = false;
				bewerkKlant = false;
				verwijderPatiënt = false;
			}
			else if(isPatiënt == true)
			{
				mainStage.setScene(verwijderPatiëntScene);
				verwijderPatiënt = true;
				isKlant = false;
				isPatiënt = false;
				bekijkPatiënt = false;
				bekijkKlant = false;
				invoerKlant = false;
				invoerPatiënt = false;
				bewerkPatiënt = false;
				verwijderKlant = false; 
				bewerkKlant = false;
			}
		});		
	}	
	
    public static void main( String[] args )
    {
        launch(args);
    }
}
