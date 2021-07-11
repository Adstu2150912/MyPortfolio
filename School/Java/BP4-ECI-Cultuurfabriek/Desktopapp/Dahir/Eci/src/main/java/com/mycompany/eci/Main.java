/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eci;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author dahir
 */
public class Main extends Application{
    
    public void start(Stage mainStage){
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,1000,1000);
        
        mainStage.setScene(scene);
        mainStage.setTitle("BP4");
        mainStage.show();
        
    }
    
    public static void main(String [] args){
        launch(args);
    }
}
