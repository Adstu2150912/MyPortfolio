/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author dahir
 */
public class HoofdScherm extends BorderPane{
    
    public CustomMenuBar menuBar = new CustomMenuBar();
    
    private Label welkomtekst = new Label();
//    private BorderPane header = new Header();
    private BorderPane footer = new Footer();
    private VBox vbox = new VBox();
    private Button knopFilmCategroieOverzicht = new Button("Film"),
            knopMuziekCategroieOverzicht = new Button("Muziek"),
            knoptheaterCategorieOverzicht = new Button("Theater"),
            knopCursusCategorieOverzicht = new Button("Cursus");
    private static FilmCategorieOverzichtScherm filmCategorie = new FilmCategorieOverzichtScherm();
    private static MuziekCategorieOverzichtScherm muziekCategorie = new MuziekCategorieOverzichtScherm();
    private static TheaterCategorieOverzichtScherm theaterCategorie = new TheaterCategorieOverzichtScherm();
    private static BeheerderExpositieOverzichtScherm expositieScherm = new BeheerderExpositieOverzichtScherm();
    private static CursusCategorievenster cursusVenster = new CursusCategorievenster();
//    private static ParkerenList parkeren = new ParkerenList();
//    private GebruikerReg editGebruiker = new GebruikerReg();
    
    
    
    private Label logo = new Label();
    private Label space_hbox = new Label();
    private Label space_vbox = new Label();
    private HBox hbox_logo = new HBox();
    private VBox vbox_space_hbox_logo = new VBox();
    
    public void setCenterPane(Pane instance)
    {
        this.setCenter(instance);
    }
    public void setCenterPane(GridPane instance)
    {
        this.setCenter(instance);
    }
    public void setCenterPane(VBox instance)
    {
        this.setCenter(instance);
    }
    public void setCenterPane(HBox instance)
    {
        this.setCenter(instance);
    }
    
    public BorderPane buildHeader()
    {
        BorderPane paneReturn = new BorderPane();
        
        buildManuBar();
        setVisable();
        
        logo.setText("LOGO");
        logo.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        logo.setAlignment(Pos.CENTER_LEFT);
        
        hbox_logo.getChildren().addAll(space_hbox ,logo);
        hbox_logo.setPadding(new Insets(5, 0, 0, 5));
        hbox_logo.setSpacing(10);
        
        
        vbox_space_hbox_logo.getChildren().addAll(space_vbox, hbox_logo);
        vbox_space_hbox_logo.setSpacing(10);
        
        paneReturn.setCenter(vbox_space_hbox_logo);
        paneReturn.setBackground(new Background(new BackgroundFill(Color.web("#FFFF00"),null,null)));
        paneReturn.setBottom(menuBar);
        paneReturn.setPrefHeight(80);
        
        return paneReturn;
    }
    
    public void buildManuBar()
    {
        
        Menu mFilm      = new Menu("Film");
        Menu mTeater    = new Menu("Theater");
        Menu mMuziek    = new Menu("Muziek");
        Menu mCursus    = new Menu("Cursus");
        Menu mOnderwijs = new Menu("Onderwijs");
        Menu mExpo      = new Menu("Expositie");
        Menu mBeheerder = new Menu("Beheerder");
        Menu mGebruiker = new Menu("Gebruikers");
        
        MenuItem miFilmOverzicht            = new MenuItem("Film Overzicht");
        MenuItem miTheaterOverzicht         = new MenuItem("Theater Overzicht");
        MenuItem miMuziekOverzicht          = new MenuItem("Muziek Overzicht");
        MenuItem miCursusToevoegen          = new MenuItem("Cursus Toevoegen");
        MenuItem miCursusOverzicht          = new MenuItem("Cursus Overzicht");
        MenuItem miOnderwijsToevoegen       = new MenuItem("Onderwijs Toevoegen");
        MenuItem miOnderwijsOverzicht       = new MenuItem("Onderwijs Overzicht");
        MenuItem miExpoOverzicht            = new MenuItem("Expo Overzicht");
        MenuItem miGebruikerToevoegen       = new MenuItem("Gebruiker Toevoegen");
        MenuItem miGebruikerOverzicht       = new MenuItem("Gebruiker Overzicht");
        MenuItem miGebruikerReserveringen   = new MenuItem("Gebruiker Reserveringen");
        MenuItem miGebruikerParkeren        = new MenuItem("Gebruiker Parkeeroverzicht");
        
        miFilmOverzicht.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
            this.setCenter(filmCategorie);
            
        });
        miTheaterOverzicht.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
            this.setCenter(theaterCategorie);
        });
        miMuziekOverzicht.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
            this.setCenter(muziekCategorie);
        });
        miCursusToevoegen.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
        });
        miCursusOverzicht.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
            this.setCenter(cursusVenster);
        });
        miOnderwijsToevoegen.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
        });
        miOnderwijsOverzicht.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
        });
        
        miExpoOverzicht.setOnAction(event ->
        {
            StandardDebugActions.println("Menu bar click!");
            this.setCenter(expositieScherm);
        });
        
        
        miGebruikerToevoegen.setOnAction(event ->
        {
            StandardDebugActions.println("Opening view userReg!");
            this.setCenterPane(new GebruikerReg());
        });
        miGebruikerOverzicht.setOnAction(event ->
        {
            StandardDebugActions.println("Opening view UserListReg!");
            this.setCenterPane(new GebruikerLogs());
        });
        miGebruikerReserveringen.setOnAction(event ->
        {
            StandardDebugActions.println("Opening view reservListReg!");
            this.setCenterPane(new Reserveringen());
        });
        

        miGebruikerParkeren.setOnAction(event ->
        {
            StandardDebugActions.println("Opening view parkerenlist");
            this.setCenterPane(new ParkerenView());
        });



        
        mFilm.getItems().add(miFilmOverzicht);
        mTeater.getItems().add(miTheaterOverzicht);
        mMuziek.getItems().add(miMuziekOverzicht);
        mCursus.getItems().add(miCursusToevoegen);
        mCursus.getItems().add(miCursusOverzicht);
        mOnderwijs.getItems().add(miOnderwijsToevoegen);
        mOnderwijs.getItems().add(miOnderwijsOverzicht);
        mExpo.getItems().add(miExpoOverzicht);
        mGebruiker.getItems().add(miGebruikerToevoegen);
        mGebruiker.getItems().add(miGebruikerOverzicht);
        mGebruiker.getItems().add(miGebruikerReserveringen);
        mGebruiker.getItems().add(miGebruikerParkeren);
        
        
        menuBar.addMenu(mFilm     );
        menuBar.addMenu(mTeater   );
        menuBar.addMenu(mMuziek   );
        menuBar.addMenu(mCursus   );
        menuBar.addMenu(mOnderwijs);
        menuBar.addMenu(mExpo     );
        menuBar.addMenu(mBeheerder);
        menuBar.addMenu(mGebruiker);

        menuBar = menuBar.build();
    }
    
    
    public void setVisable()
    {
        menuBar.setVisible(true);
    }

    public void setInVisable()
    {
        menuBar.setVisible(false);
    }
    
    public HoofdScherm(){
        
        welkomtekst.setText("WELKOM!");
        welkomtekst.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        welkomtekst.setAlignment(Pos.CENTER);
        
        vbox.getChildren().addAll(welkomtekst);
        vbox.setAlignment(Pos.CENTER);
        
        this.setCenter(vbox);
        this.setTop(buildHeader());
        this.setBottom(footer);
    }
}
