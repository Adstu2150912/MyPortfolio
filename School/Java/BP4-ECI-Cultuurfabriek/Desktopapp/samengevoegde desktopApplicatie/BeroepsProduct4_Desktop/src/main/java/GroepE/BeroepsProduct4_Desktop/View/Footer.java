/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author dahir
 */
public class Footer extends BorderPane{
    
    private TextFlow footertext = new TextFlow(); 
    
    public Footer(){
        
        
        Text text1 = new Text("Copyright ©2020");
        text1.setFont(Font.font("Verdana",11));
        text1.setFill(Color.WHITE); 
        
        Text text2 = new Text("  Eci Cultuurfabriek.");
        text2.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        text2.setFill(Color.WHITE); 
        
        Text text3 = new Text(" All rights reserved.");
        text3.setFont(Font.font("Verdana",11));
        text3.setFill(Color.WHITE); 
        
        footertext.getChildren().addAll(text1,text2,text3);
        footertext.setPadding(new Insets(3,0,0,3));
        
        
        this.setCenter(footertext);
        this.setBackground(new Background(new BackgroundFill(Color.web("#FFFF00"),null,null)));
        this.setPrefHeight(30);
        
    }
    
}
