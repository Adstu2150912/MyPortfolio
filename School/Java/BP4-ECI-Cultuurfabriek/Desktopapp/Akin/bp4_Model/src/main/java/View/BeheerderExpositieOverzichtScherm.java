/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import bp4_Model.DataTypes.Expositie;
import bp4_Model.DatabaseHandlers;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author akina
 */
public class BeheerderExpositieOverzichtScherm extends BorderPane {
    public ArrayList<Expositie> exposities = new ArrayList<>();
    
    
    void GetResults()
    {
        // select narrow down
        // select query 
        // get res
        DatabaseHandlers.dbexpositie.selectAll();
        exposities.clear();
        for(Object instance : DatabaseHandlers.dbexpositie.getResults()) exposities.add(((Expositie) instance));
        
    }
    
    
    
    private GridPane gridtoevoegen = new GridPane(),gridUpdaten = new GridPane(), 
            gridVerwijderen = new GridPane(), gridTotaal = new GridPane();
    
    private Label expositieNaamToevoegenLabel = new Label("Expositienaam: "),expositieNaamUpdatenLabel = new Label("Expositienaam: "),
            expositieNaamVerwijderenLabel = new Label("Expositienaam: "), omschrijvingToevoegenLabel = new Label("Omschrijving: "),
            omschrijvingUpdatenLabel = new Label("Omschrijving: "), omschrijvingVerwijderenLabel = new Label("Omschrijving: "),
            startdatumToevoegenLabel = new Label("Startdatum: "),startdatumUpdatenLabel = new Label("Startdatum: "),
            startdatumVerwijderenLabel = new Label("Startdatum: "),startTijdToevoegenLabel = new Label("StartTijd: "),
            startTijdUpdatenLabel = new Label("StartTijd: "),startTijdVerwijderenLabel = new Label("StartTijd: "),
            eindDatumToevoegenLabel = new Label("EindDatum: "),eindDatumUpdatenLabel = new Label("EindDatum: "),
            eindDatumVerwijderenLabel = new Label("EindDatum: ");
    
    private TextField expositieNaamVeld = new TextField(), expositieNaamUpdaten = new TextField(), expositieNaamVerwijderen = new TextField(), 
            startdatumVeld = new TextField(),startdatumUpdaten = new TextField(),startdatumVerwijderen = new TextField(),
            startTijdVeld = new TextField(),startTijdUpdaten = new TextField(),startTijdVerwijderen = new TextField(),
            eindDatumVeld = new TextField(),eindDatumUpdaten = new TextField(),eindDatumVerwijderen = new TextField();
    
    private TextArea omschrijvingVeld = new TextArea(),omschrijvingUpdaten = new TextArea(),
            omschrijvingVerwijderen = new TextArea();
    
    private Button toevoegen = new Button("Toevoegen"), updaten = new Button("Updaten"), verwijderen = new Button("Verwijderen");
    
    private ChoiceBox expositieNaam_Updaten_Choicebox = new ChoiceBox(),expositieNaam_Verwijderen_Choicebox = new ChoiceBox(),omschrijving_Updaten_Choicebox = new ChoiceBox(),
            omschrijving_Verwijderen_Choicebox = new ChoiceBox(),startdatum_Updaten_Choicebox = new ChoiceBox(),startdatum_Verwijderen_Choicebox = new ChoiceBox()
            ,startTijd_Updaten_Choicebox = new ChoiceBox(),startTijd_Verwijderen_Choicebox = new ChoiceBox(),eindDatum_Updaten_Choicebox = new ChoiceBox(),
            eindDatum_Verwijderen_Choicebox = new ChoiceBox();
    
    private HBox hbox_knop = new HBox(), hbox_knop_Updaten = new HBox(),hbox_knop_Verwijderen = new HBox();
    
    
    public BeheerderExpositieOverzichtScherm(){
        
        
        expositieNaamToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        expositieNaamVeld.setMaxSize(180, 30);
        
        
        omschrijvingToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        omschrijvingVeld.setMaxSize(180, 30);
        
        
        expositieNaamUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        expositieNaamUpdaten.setMaxSize(180, 30);
        
        
        
        omschrijvingUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        omschrijvingUpdaten.setMaxSize(180, 30);
        
        
        expositieNaamVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        expositieNaamVerwijderen.setMaxSize(180, 30);
        
        
        omschrijvingVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        omschrijvingVerwijderen.setMaxSize(180, 30);
        
        
        startdatumToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        startdatumVeld.setMaxSize(180, 30);
        
        
        startdatumUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        startdatumUpdaten.setMaxSize(180, 30);
        
        
        startdatumVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        startdatumVerwijderen.setMaxSize(180, 30);
        
        
        startTijdToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        startTijdVeld.setMaxSize(180, 30);
        
        
        startTijdUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        startTijdUpdaten.setMaxSize(180, 30);
        
        
        startTijdVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        startTijdVerwijderen.setMaxSize(180, 30);
        
        
        eindDatumToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        eindDatumVeld.setMaxSize(180, 30);
        
        
        eindDatumUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        eindDatumUpdaten.setMaxSize(180, 30);
        
        
        eindDatumVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        eindDatumVerwijderen.setMaxSize(180, 30);
        
        
        gridtoevoegen.setAlignment(Pos.CENTER);
        gridtoevoegen.setVgap(10);
        gridtoevoegen.setHgap(10);
        
        gridtoevoegen.add(expositieNaamToevoegenLabel, 0, 0);
        gridtoevoegen.add(expositieNaamVeld, 1, 0);
        gridtoevoegen.add(omschrijvingToevoegenLabel, 0, 1);
        gridtoevoegen.add(omschrijvingVeld, 1, 1);
        gridtoevoegen.add(startdatumToevoegenLabel, 0, 2);
        gridtoevoegen.add(startdatumVeld, 1, 2);
        gridtoevoegen.add(startTijdToevoegenLabel, 0, 3);
        gridtoevoegen.add(startTijdVeld, 1, 3);
        gridtoevoegen.add(eindDatumToevoegenLabel, 0, 4);
        gridtoevoegen.add(eindDatumVeld, 1, 4);
        gridtoevoegen.add(hbox_knop, 1, 5);
        
        
        gridUpdaten.setAlignment(Pos.CENTER);
        gridUpdaten.setVgap(10);
        gridUpdaten.setHgap(10);
        
        gridUpdaten.add(expositieNaamUpdatenLabel, 0, 0);
        gridUpdaten.add(expositieNaam_Updaten_Choicebox, 1, 0);
        gridUpdaten.add(expositieNaamUpdaten, 2, 0);
        gridUpdaten.add(omschrijvingUpdatenLabel, 0, 1);
        gridUpdaten.add(omschrijving_Updaten_Choicebox, 1, 1);
        gridUpdaten.add(omschrijvingUpdaten, 2, 1);
        gridUpdaten.add(startdatumUpdatenLabel, 0, 2);
        gridUpdaten.add(startdatum_Updaten_Choicebox, 1, 2);
        gridUpdaten.add(startdatumUpdaten, 2, 2);
        gridUpdaten.add(startTijdUpdatenLabel, 0, 3);
        gridUpdaten.add(startTijd_Updaten_Choicebox, 1, 3);
        gridUpdaten.add(startTijdUpdaten, 2, 3);
        gridUpdaten.add(eindDatumUpdatenLabel, 0, 4);
        gridUpdaten.add(eindDatum_Updaten_Choicebox, 1, 4);
        gridUpdaten.add(eindDatumUpdaten, 2, 4);
        gridUpdaten.add(hbox_knop_Updaten, 2, 5);
        
        
        gridVerwijderen.setAlignment(Pos.CENTER);
        gridVerwijderen.setVgap(10);
        gridVerwijderen.setHgap(10);
        
        gridVerwijderen.add(expositieNaamVerwijderenLabel, 0, 0);
        gridVerwijderen.add(expositieNaam_Verwijderen_Choicebox, 1, 0);
        gridVerwijderen.add(expositieNaamVerwijderen, 2, 0);
        gridVerwijderen.add(omschrijvingVerwijderenLabel, 0, 1);
        gridVerwijderen.add(omschrijving_Verwijderen_Choicebox, 1, 1);
        gridVerwijderen.add(omschrijvingVerwijderen, 2, 1);
        gridVerwijderen.add(startdatumVerwijderenLabel, 0, 2);
        gridVerwijderen.add(startdatum_Verwijderen_Choicebox, 1, 2);
        gridVerwijderen.add(startdatumVerwijderen, 2, 2);
        gridVerwijderen.add(startTijdVerwijderenLabel, 0, 3);
        gridVerwijderen.add(startTijd_Verwijderen_Choicebox, 1, 3);
        gridVerwijderen.add(startTijdVerwijderen, 2, 3);
        gridVerwijderen.add(eindDatumVerwijderenLabel, 0, 4);
        gridVerwijderen.add(eindDatum_Verwijderen_Choicebox, 1, 4);
        gridVerwijderen.add(eindDatumVerwijderen, 2, 4);
        gridVerwijderen.add(hbox_knop_Verwijderen, 2, 6);
        
        gridTotaal.setAlignment(Pos.CENTER);
        gridTotaal.setHgap(30);
        gridTotaal.add(gridtoevoegen, 0, 0);
        gridTotaal.add(gridUpdaten, 1, 0);
        gridTotaal.add(gridVerwijderen, 2, 0);
        
        
        
        this.setCenter(gridTotaal);
    }
    
}
    

