package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;

import java.net.URL;

public class GoogleMaps extends Pane 
{
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();
    
    double lat;
    double lon;
	public final Button btnHome, btnFeedbackForm, btnToonAdvies;
	public final VBox hoofdContainer;
	public final FlowPane hoofdMenu;
	public final GridPane hoofdVenster;

    public GoogleMaps() 
    {
    	
		hoofdMenu = new FlowPane();	
		hoofdVenster = new GridPane();
		hoofdContainer = new VBox();
		
		btnHome = new Button("Home");
		btnToonAdvies = new Button("Toon advies");
		btnFeedbackForm = new Button("Laat uw mening horen!");		
		
		btnHome.setTextFill(Color.WHITE);
		btnHome.setStyle("-fx-background-color:#FF0000;");
		btnHome.setFont(new Font("Myriad-pro", 20));
		btnToonAdvies.setTextFill(Color.WHITE);
		btnToonAdvies.setStyle("-fx-background-color:#FF0000;");
		btnToonAdvies.setFont(new Font("Arial", 18));
		btnFeedbackForm.setTextFill(Color.WHITE);
		btnFeedbackForm.setStyle("-fx-background-color:#FF0000;");
		btnFeedbackForm.setFont(new Font("Myriad-pro", 20));
		
		hoofdMenu.setStyle("-fx-background-color:#FF0000; -fx-opacity:1;");
		hoofdVenster.setStyle("-fx-background-color:#DCDCE6;");
		
		hoofdVenster.setMinSize(700, 500);
		
        final URL urlGoogleMaps = getClass().getResource("/com/AAAD/Beroepsproduct3/SmartBrabant/View/demo.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
        webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> e) {
                System.out.println(e.toString());
            }
        });

        //getChildren().add(webView);

        final TextField latitude = new TextField("" + 35.857908 * 1.00007);
        final TextField longitude = new TextField("" + 10.598997 * 1.00007);
        Button update = new Button("Update");
        update.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                lat = Double.parseDouble(latitude.getText());
                lon = Double.parseDouble(longitude.getText());

                System.out.printf("%.2f %.2f%n", lat, lon);

                webEngine.executeScript("" +
                    "window.lat = " + lat + ";" +
                    "window.lon = " + lon + ";" +
                    "document.goToLocation(window.lat, window.lon);"
                );
            }
        });

        HBox toolbar  = new HBox();
        toolbar.getChildren().addAll(latitude, longitude, update);

        getChildren().addAll(toolbar);
        
		hoofdMenu.getChildren().addAll(btnHome, btnFeedbackForm);
		hoofdVenster.getChildren().addAll(webView, toolbar);
		hoofdContainer.getChildren().addAll(hoofdMenu, hoofdVenster);
		
		VBox.setVgrow(hoofdVenster, Priority.ALWAYS);	
    }    
}
