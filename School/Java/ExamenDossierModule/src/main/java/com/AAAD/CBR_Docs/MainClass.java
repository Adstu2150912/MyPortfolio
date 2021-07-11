package com.AAAD.CBR_Docs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.AAAD.CBR_Docs.View.*;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 25-11-2019
 * Project: CBRDocs - Examendossier
 * Bestandsnaam: MainClass.java
 */

public class MainClass extends Application 
{
	Scene hoofdScene, examenBeheerScene, examenStatistiekenScene;
	HoofdScherm hoofdScherm;
	ExamenBeheerScherm examenBeheerScherm;
	ExamenStatistiekenScherm examenStatistiekenScherm;
	
	@Override
	public void start(Stage mainStage) 
	{
		hoofdScherm = new HoofdScherm();
		examenBeheerScherm = new ExamenBeheerScherm();
		examenStatistiekenScherm = new ExamenStatistiekenScherm();
		
		hoofdScene = new Scene(hoofdScherm.hoofdContainer);
		examenBeheerScene = new Scene(examenBeheerScherm.hoofdContainer);
		examenStatistiekenScene = new Scene(examenStatistiekenScherm.hoofdContainer);
		
		mainStage.setScene(hoofdScene);
		mainStage.setTitle("CBRDocs - Examendossiers");
		mainStage.show();
		
		hoofdScherm.btnExamens.setOnAction(event -> 
		{
			mainStage.setScene(examenBeheerScene);
		});
		
		hoofdScherm.btnStatistieken.setOnAction(event -> 
		{
			examenStatistiekenScherm.getExamenStatistieken();
			mainStage.setScene(examenStatistiekenScene);
		});
		
		examenBeheerScherm.btnHome.setOnAction(event -> 
		{
			mainStage.setScene(hoofdScene);
		});
		
		examenBeheerScherm.btnStatistieken.setOnAction(event -> 
		{
			examenStatistiekenScherm.getExamenStatistieken();
			mainStage.setScene(examenStatistiekenScene);
		});
		
		examenStatistiekenScherm.btnHome.setOnAction(event -> 
		{
			mainStage.setScene(hoofdScene);
		});
		
		examenStatistiekenScherm.btnExamens.setOnAction(event -> 
		{
			mainStage.setScene(examenBeheerScene);
		});		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
