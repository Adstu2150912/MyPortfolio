package com.AAAD.CBR_Docs.View;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * De klasse HoofdScherm representeert een gebruikerscherm waar de applicatie en gebruiker mee start
 * <br>
 * <br>
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: HoofdScherm.java
 * @author Adam Oubelkas
 * @version 0.1
 * @since Aanmaakdatum: 3-12-2019
 */

public class HoofdScherm 
{
	public final Button btnHome, btnExamens, btnStatistieken;
	public final VBox hoofdContainer;
	public final FlowPane hoofdMenu;
	public final GridPane hoofdVenster;
	
	public HoofdScherm()
	{		
		hoofdMenu = new FlowPane();	
		hoofdVenster = new GridPane();
		hoofdContainer = new VBox();
		
		btnHome = new Button("Home");
		btnExamens = new Button("Examens");
		btnStatistieken = new Button("Toon statistieken");
		
		Image logo = new Image("file:src/main/resources/com/AAAD/CBR_Docs/IMG/CBR_Logo.png");
		ImageView  iView = new ImageView(logo);
		
		btnHome.setTextFill(Color.WHITE);
		btnHome.setStyle("-fx-background-color:#0588F0;");
		btnHome.setFont(new Font("Myriad-pro", 20));
		btnExamens.setTextFill(Color.WHITE);
		btnExamens.setStyle("-fx-background-color:#0588F0;");
		btnExamens.setFont(new Font("Myriad-pro", 20));
		btnStatistieken.setTextFill(Color.WHITE);
		btnStatistieken.setStyle("-fx-background-color:#0588F0;");
		btnStatistieken.setFont(new Font("Myriad-pro", 20));
		
		iView.setFitHeight(201);
		iView.setFitWidth(300);		
		iView.setPreserveRatio(true); //oorspronkelijke aspect ratio van het bronmateriaal behouden
		
		hoofdMenu.setStyle("-fx-background-color:#0588F0; -fx-opacity:1;");
		hoofdVenster.setStyle("-fx-background-color:#DCDCE6;");
				
		hoofdMenu.getChildren().addAll(btnHome, btnExamens, btnStatistieken);
		hoofdVenster.getChildren().add(iView);
		hoofdContainer.getChildren().addAll(hoofdMenu, hoofdVenster);
		
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);	
	}
}
