package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Expositie;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
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
    
    private ChoiceBox expositieUpdatenChoicebox = new ChoiceBox(),expositieVerwijderenChoicebox = new ChoiceBox();
    
    
    
    
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
        
        expositieUpdatenChoicebox.setMinWidth(180);
        expositieVerwijderenChoicebox.setMinWidth(180);
        
        Expositie[] exposities = DatabaseHandlers.dbexpositie.getResults();

        for (Expositie instance : exposities) {
            expositieUpdatenChoicebox.getItems().add(instance.getExpositie());

            expositieVerwijderenChoicebox.getItems().add(instance.getExpositie());

        }
        
        expositieVerwijderenChoicebox.setOnAction(event->{
            
            Expositie selected = new Expositie();
            for (Expositie e : exposities) {
                if (e.getExpositie() == expositieVerwijderenChoicebox.getSelectionModel().getSelectedItem()) {
                    selected = e;
                    break;
                }
            }
            expositieNaamVerwijderen.setText(selected.getExpositie());
            omschrijvingVerwijderen.setText(selected.getOmschrijving());
            startdatumVerwijderen.setText(selected.getStartdatum());
            startTijdVerwijderen.setText(selected.getStarttijd());
            eindDatumVerwijderen.setText(selected.getEinddatum());
            
            
            
            
            
            
        });
        
        expositieUpdatenChoicebox.setOnAction(event -> {

            Expositie selected = new Expositie();
            for (Expositie e : exposities) {
                if (e.getExpositie() == expositieUpdatenChoicebox.getSelectionModel().getSelectedItem()) {
                    selected = e;
                    break;
                }
            }
            expositieNaamUpdaten.setText(selected.getExpositie());
            omschrijvingUpdaten.setText(selected.getOmschrijving());
            startdatumUpdaten.setText(selected.getStartdatum());
            startTijdUpdaten.setText(selected.getStarttijd());
            eindDatumUpdaten.setText(selected.getEinddatum());
            
            
            

        });
        
        toevoegen.setOnAction(event -> {
            
            if (expositieNaamVeld.getText() == "" || omschrijvingVeld.getText() == "" || startdatumVeld.getText() == 
                  "" || startTijdVeld.getText() == "" || eindDatumVeld.getText() == "" ) { 
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Vul alle gegevens in!");
                alert.show();
            }
            
            else{
            
            Expositie[] Exposities = new Expositie[1];
            Exposities[0] = new Expositie(expositieNaamVeld.getText(), omschrijvingVeld.getText(),startdatumVeld.getText(), 
                    startTijdVeld.getText(), eindDatumVeld.getText());
            DatabaseHandlers.dbexpositie.insertDataIntoTable(Exposities);
            }
            
            
            
            expositieNaamVeld.clear();
            omschrijvingVeld.clear();
            startdatumVeld.clear();
            startTijdVeld.clear();
            eindDatumVeld.clear();
         

        });
        
        
        expositieNaamVerwijderen.setEditable(false);
        omschrijvingVerwijderen.setEditable(false);
        startdatumVerwijderen.setEditable(false);
        startTijdVerwijderen.setEditable(false);        
        eindDatumVerwijderen.setEditable(false);         

        verwijderen.setOnAction(event -> {
            Expositie selected = new Expositie();
            for (Expositie e : exposities) {
                if (e.getExpositie() == expositieVerwijderenChoicebox.getSelectionModel().getSelectedItem()) {
                    selected = e;
                    break;
                }
            }
            
            
            DatabaseHandlers.dbexpositie.deleteSpecificData(selected);
            expositieVerwijderenChoicebox.getSelectionModel().clearSelection();
            
            
        });
        
        

        updaten.setOnAction(event -> {

            Expositie selected = new Expositie();
            for (Expositie e : exposities) {
                if (e.getExpositie() == expositieUpdatenChoicebox.getSelectionModel().getSelectedItem()) {
                    selected = e;
                    break;
                }
            }
            
            Expositie updatedExpositie = new Expositie();
            updatedExpositie.setExpositie(selected.getExpositie());
            updatedExpositie.setOmschrijving(omschrijvingUpdaten.getText());
            updatedExpositie.setStartdatum(startdatumUpdaten.getText());
            updatedExpositie.setStarttijd(startTijdUpdaten.getText());
            updatedExpositie.setEinddatum(eindDatumUpdaten.getText());
           
            
            

            DatabaseHandlers.dbexpositie.UpdateDataIntoTable(selected, updatedExpositie);
            expositieUpdatenChoicebox.getSelectionModel().clearSelection();
            
            expositieNaamUpdaten.clear();
            omschrijvingUpdaten.clear();
            startdatumUpdaten.clear();        
            startTijdUpdaten.clear();       
            eindDatumUpdaten.clear();
          
            
            
            
        });
        
        
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
        gridtoevoegen.add(toevoegen, 1, 5);
        
        
        gridUpdaten.setAlignment(Pos.CENTER);
        gridUpdaten.setVgap(10);
        gridUpdaten.setHgap(10);
        
        gridUpdaten.add(expositieUpdatenChoicebox, 1, 0);
        gridUpdaten.add(expositieNaamUpdatenLabel, 0, 1);
        gridUpdaten.add(expositieNaamUpdaten, 1, 1);
        gridUpdaten.add(omschrijvingUpdatenLabel, 0, 2);
        gridUpdaten.add(omschrijvingUpdaten, 1, 2);
        gridUpdaten.add(startdatumUpdatenLabel, 0, 3);
        gridUpdaten.add(startdatumUpdaten, 1, 3);
        gridUpdaten.add(startTijdUpdatenLabel, 0, 4);
        gridUpdaten.add(startTijdUpdaten, 1, 4);
        gridUpdaten.add(eindDatumUpdatenLabel, 0, 5);
        gridUpdaten.add(eindDatumUpdaten, 1, 5);
        gridUpdaten.add(updaten, 1, 6);
        
        
        gridVerwijderen.setAlignment(Pos.CENTER);
        gridVerwijderen.setVgap(10);
        gridVerwijderen.setHgap(10);
        
        gridVerwijderen.add(expositieVerwijderenChoicebox, 1, 0);
        gridVerwijderen.add(expositieNaamVerwijderenLabel, 0, 1);
        gridVerwijderen.add(expositieNaamVerwijderen, 1, 1);
        gridVerwijderen.add(omschrijvingVerwijderenLabel, 0, 2);
        gridVerwijderen.add(omschrijvingVerwijderen, 1, 2);
        gridVerwijderen.add(startdatumVerwijderenLabel, 0, 3);
        gridVerwijderen.add(startdatumVerwijderen, 1, 3);
        gridVerwijderen.add(startTijdVerwijderenLabel, 0, 4);
        gridVerwijderen.add(startTijdVerwijderen, 1, 4);
        gridVerwijderen.add(eindDatumVerwijderenLabel, 0, 5);
        gridVerwijderen.add(eindDatumVerwijderen, 1, 5);
        gridVerwijderen.add(verwijderen, 1, 6);
        
        gridTotaal.setAlignment(Pos.CENTER);
        gridTotaal.setHgap(30);
        gridTotaal.add(gridtoevoegen, 0, 0);
        gridTotaal.add(gridUpdaten, 1, 0);
        gridTotaal.add(gridVerwijderen, 2, 0);
        
        
        
        this.setCenter(gridTotaal);
    }
    
}