package com.AAAD.Beroepsproduct3.SmartBrabant;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.AAAD.Beroepsproduct3.SmartBrabant.View.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.geotools.ows.ServiceException;
import org.opengis.referencing.FactoryException;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Controller;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.DataBean;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.GoogleMaps;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 26-02-2020
 * Project: Beroepsproduct 3 - SmartBrabant
 * Bestandsnaam: MainClass.java
 */

public class MainClass extends Application
{
	Scene hoofdScene, feedbackFormScene, helpFormScene;
	HoofdScherm hoofdScherm;
	FeedbackForm feedbackForm;
	HelpForm helpForm;
	
	public void start(Stage mainStage)
	{
		hoofdScherm = new HoofdScherm();
		feedbackForm = new FeedbackForm();
		helpForm = new HelpForm();
		
		hoofdScene = new Scene(hoofdScherm.hoofdContainer);
		feedbackFormScene = new Scene(feedbackForm.hoofdContainer);
		helpFormScene = new Scene(helpForm.hoofdContainer);
		
		mainStage.setScene(hoofdScene);
		mainStage.setTitle("Beroepsproduct 3 - SmartBrabant");
		mainStage.show();
		
		//HoofdScherm events
		
		hoofdScherm.btnHome.setOnMouseEntered(event -> 
		{
			hoofdScherm.btnHome.setTextFill(Color.RED);
			hoofdScherm.btnHome.setStyle("-fx-background-color:#FFFFFF;");		
		});
		
		hoofdScherm.btnHome.setOnMouseExited(event -> 
		{
			hoofdScherm.btnHome.setTextFill(Color.WHITE);
			hoofdScherm.btnHome.setStyle("-fx-background-color:#FF0000;");	
		});
		
		hoofdScherm.btnFeedbackForm.setOnMouseEntered(event -> 
		{
			hoofdScherm.btnFeedbackForm.setTextFill(Color.RED);
			hoofdScherm.btnFeedbackForm.setStyle("-fx-background-color:#FFFFFF;");					
		});
		
		hoofdScherm.btnFeedbackForm.setOnMouseExited(event -> 
		{
			hoofdScherm.btnFeedbackForm.setTextFill(Color.WHITE);
			hoofdScherm.btnFeedbackForm.setStyle("-fx-background-color:#FF0000;");	
		});
		
		hoofdScherm.btnHelp.setOnMouseEntered(event -> 
		{
			hoofdScherm.btnHelp.setTextFill(Color.RED);
			hoofdScherm.btnHelp.setStyle("-fx-background-color:#FFFFFF;");					
		});
		
		hoofdScherm.btnHelp.setOnMouseExited(event -> 
		{
			hoofdScherm.btnHelp.setTextFill(Color.WHITE);
			hoofdScherm.btnHelp.setStyle("-fx-background-color:#FF0000;");	
		});
		
		hoofdScherm.btnFeedbackForm.setOnAction(event ->
		{
			mainStage.setScene(feedbackFormScene);
		});
		
		hoofdScherm.btnHelp.setOnAction(event ->
		{
			mainStage.setScene(helpFormScene);
		});
		
		//FeedbackForm events
		
		feedbackForm.btnHome.setOnMouseEntered(event -> 
		{
			feedbackForm.btnHome.setTextFill(Color.RED);
			feedbackForm.btnHome.setStyle("-fx-background-color:#FFFFFF;");		
		});
		
		feedbackForm.btnHome.setOnMouseExited(event -> 
		{
			feedbackForm.btnHome.setTextFill(Color.WHITE);
			feedbackForm.btnHome.setStyle("-fx-background-color:#FF0000;");	
		});
		
		feedbackForm.btnFeedbackForm.setOnMouseEntered(event -> 
		{
			feedbackForm.btnFeedbackForm.setTextFill(Color.RED);
			feedbackForm.btnFeedbackForm.setStyle("-fx-background-color:#FFFFFF;");					
		});
		
		feedbackForm.btnFeedbackForm.setOnMouseExited(event -> 
		{
			feedbackForm.btnFeedbackForm.setTextFill(Color.WHITE);
			feedbackForm.btnFeedbackForm.setStyle("-fx-background-color:#FF0000;");	
		});
		
		feedbackForm.btnHelp.setOnMouseEntered(event -> 
		{
			feedbackForm.btnHelp.setTextFill(Color.RED);
			feedbackForm.btnHelp.setStyle("-fx-background-color:#FFFFFF;");					
		});
		
		feedbackForm.btnHelp.setOnMouseExited(event -> 
		{
			feedbackForm.btnHelp.setTextFill(Color.WHITE);
			feedbackForm.btnHelp.setStyle("-fx-background-color:#FF0000;");	
		});
		
		feedbackForm.btnBevestig.setOnAction(event ->
		{
			if(feedbackForm.sendFeedbackToDB())
			{
				hoofdScherm.updateUI();
				mainStage.setScene(hoofdScene);
			}
				
		});	
		
		feedbackForm.btnHome.setOnAction(event -> 
		{
			mainStage.setScene(hoofdScene);
		});
		
		feedbackForm.btnHelp.setOnAction(event -> 
		{
			mainStage.setScene(helpFormScene);
		});
		
		//HelpForm events
		
		helpForm.btnHome.setOnMouseEntered(event -> 
		{
			helpForm.btnHome.setTextFill(Color.RED);
			helpForm.btnHome.setStyle("-fx-background-color:#FFFFFF;");		
		});
		
		helpForm.btnHome.setOnMouseExited(event -> 
		{
			helpForm.btnHome.setTextFill(Color.WHITE);
			helpForm.btnHome.setStyle("-fx-background-color:#FF0000;");	
		});
		
		helpForm.btnFeedbackForm.setOnMouseEntered(event -> 
		{
			helpForm.btnFeedbackForm.setTextFill(Color.RED);
			helpForm.btnFeedbackForm.setStyle("-fx-background-color:#FFFFFF;");					
		});
		
		helpForm.btnFeedbackForm.setOnMouseExited(event -> 
		{
			helpForm.btnFeedbackForm.setTextFill(Color.WHITE);
			helpForm.btnFeedbackForm.setStyle("-fx-background-color:#FF0000;");	
		});
		
		helpForm.btnHelp.setOnMouseEntered(event -> 
		{
			helpForm.btnHelp.setTextFill(Color.RED);
			helpForm.btnHelp.setStyle("-fx-background-color:#FFFFFF;");					
		});
		
		helpForm.btnHelp.setOnMouseExited(event -> 
		{
			helpForm.btnHelp.setTextFill(Color.WHITE);
			helpForm.btnHelp.setStyle("-fx-background-color:#FF0000;");	
		});
		
		helpForm.btnBevestig.setOnAction(event ->
		{
			mainStage.setScene(hoofdScene);
		});
		
		helpForm.btnHome.setOnAction(event -> 
		{
			mainStage.setScene(hoofdScene);
		});
		
		helpForm.btnFeedbackForm.setOnAction(event -> 
		{
			mainStage.setScene(feedbackFormScene);
		});
				
	}
	
    public static void main( String[] args )
    {
        launch(args);
    }
}
