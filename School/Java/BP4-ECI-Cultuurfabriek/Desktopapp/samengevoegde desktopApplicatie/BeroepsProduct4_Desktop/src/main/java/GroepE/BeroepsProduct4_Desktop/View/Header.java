///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GroepE.BeroepsProduct4_Desktop.View;
//
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.Label;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//
///**
// *
// * @author dahir
// */
//public class Header extends BorderPane{
//    
//    private Label logo = new Label();
//    private Label space_hbox = new Label();
//    private Label space_vbox = new Label();
//    private HBox hbox_logo = new HBox();
//    private VBox vbox_space_hbox_logo = new VBox();
//    
//   
//    
//    public Header()
//    {
//        HoofdScherm.buildManuBar();
//        HoofdScherm.setVisable();
//        
//        
//        logo.setText("LOGO");
//        logo.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
//        logo.setAlignment(Pos.CENTER_LEFT);
//        
//        hbox_logo.getChildren().addAll(space_hbox ,logo);
//        hbox_logo.setPadding(new Insets(5, 0, 0, 5));
//        hbox_logo.setSpacing(10);
//        
//        
//        vbox_space_hbox_logo.getChildren().addAll(space_vbox, hbox_logo);
//        vbox_space_hbox_logo.setSpacing(10);
//        
//        this.setCenter(vbox_space_hbox_logo);
//        this.setBackground(new Background(new BackgroundFill(Color.web("#FFFF00"),null,null)));
//        this.setBottom(HoofdScherm.menuBar);
//        this.setPrefHeight(80);
//        
//    }
//}
