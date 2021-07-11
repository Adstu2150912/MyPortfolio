/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.eci.cultuurfabriekapp.View;

import com.aaad.beroepsproduct4.eci.cultuurfabriekapp.ViewModel.VMDocent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 11-05-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: MainClass.java
 */
public class MainClass extends Application
{
    Scene hoofdScene;
    //HoofdScherm hoofdScherm;
    VMDocent vmDocent;
    
    public void start(Stage mainStage)
    {
         vmDocent = vmDocent.getInstance();
         if(vmDocent.testDBConnection())
             System.out.println("Executed 'vmDocent.testDBConnection()' in MainClass.start(): " + "Verbinding met MySQL-server is succesvol!");
         else
             System.out.println("Executed 'vmDocent.testDBConnection()' in MainClass.start(): " + "Verbinding met MySQL-server is mislukt!");
        // hoofdScherm = new HoofdScherm();
        // hoofdScene = new Scene(hoofdScherm.hoofdContainer);
        // mainStage.setScene(hoofdScene);
        // mainStage.setTitle("Beroepsproduct 3 - SmartBrabant");
	// mainStage.show();
    }
    
    public static void main( String[] args )
    {
        launch(args);
    }
}
