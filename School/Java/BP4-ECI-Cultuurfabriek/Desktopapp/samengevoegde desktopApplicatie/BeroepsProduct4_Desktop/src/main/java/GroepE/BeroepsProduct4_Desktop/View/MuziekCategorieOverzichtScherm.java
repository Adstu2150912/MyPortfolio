/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;


import GroepE.BeroepsProduct4_Desktop.DataTypes.Muziek;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author dahir
 */
public class MuziekCategorieOverzichtScherm extends BorderPane{
    
    public ArrayList<Muziek> muziekEvenementen = new ArrayList<>();
    
    
    void GetResults() {
        // select narrow down
        // select query 
        // get res
        DatabaseHandlers.dbMuziek.selectAll();
        muziekEvenementen.clear();
        for (Object instance : DatabaseHandlers.dbMuziek.getResults()) {
            muziekEvenementen.add(((Muziek) instance));
        }

    }
    
    
    
    private GridPane gridtoevoegen = new GridPane(),gridUpdaten = new GridPane(), 
            gridVerwijderen = new GridPane(), gridTotaal = new GridPane();
    
    private Label evenementNaamToevoegenLabel = new Label("Evenementnaam: "),evenementNaamUpdatenLabel = new Label("Evenementnaam: "),
            evenementNaamVerwijderenLabel = new Label("Evenementnaam: "), evenementGenreToevoegenLabel = new Label("Evenementgenre: "),
            evenementGenreUpdatenLabel = new Label("Evenementgenre: "),evenementGenreVerwijderenLabel = new Label("Evenementgenre: "),
            evenementArtiestToevoegenLabel = new Label("Artiest: "),evenementArtiestUpdatenLabel = new Label("Artiest: "),
            evenementArtiestVerwijderenLabel = new Label("Artiest: "),evenementZaalToevoegenLabel = new Label("Zaal: "),
            evenementZaalUpdatenLabel = new Label("Zaal: "),evenementZaalVerwijderenLabel = new Label("Zaal: "),
            evenementBeschrijvingToevoegenLabel = new Label("Beschrijving: "),evenementBeschrijvingUpdatenLabel = new Label("Beschrijving: "),
            evenementBeschrijvingVerwijderenLabel = new Label("Beschrijving: ");
    
    
    private TextField evenementNaamVak = new TextField(), evenementGenreVak = new TextField(), evenementNaamUpdaten = new TextField(), 
            evenementNaamVerwijderen = new TextField(), evenementGenreUpdaten = new TextField(), evenementGenreVerwijderen = new TextField(),
            evenementArtiestVak = new TextField(),evenementArtiestUpdaten = new TextField(),evenementArtiestVerwijderen = new TextField(),
            evenementZaalVak = new TextField(),evenementZaalUpdaten = new TextField(),evenementZaalVerwijderen = new TextField();
    
    private TextArea evenementBeschrijvingVak = new TextArea(),evenementBeschrijvingUpdaten = new TextArea(),
            evenementBeschrijvingVerwijderen = new TextArea();
    
    
    private Button toevoegen = new Button("Toevoegen"), updaten = new Button("Updaten"), verwijderen = new Button("Verwijderen");
    
    
    private ChoiceBox evenementUpdaten = new ChoiceBox(), evenementVerwijderen = new ChoiceBox();
    
    
    
 
    
    public MuziekCategorieOverzichtScherm(){
        evenementNaamToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementNaamVak.setMaxSize(180, 30);
        
        
        evenementGenreToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementGenreVak.setMaxSize(180, 30);
 
        
        evenementNaamUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementNaamUpdaten.setMaxSize(180, 30);
        
        
        evenementGenreUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementGenreUpdaten.setMaxSize(180, 30);
        
        
        evenementNaamVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementNaamVerwijderen.setMaxSize(180, 30);
        
        
        evenementGenreVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementGenreVerwijderen.setMaxSize(180, 30);
        
        evenementArtiestToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementArtiestVak.setMaxSize(180, 30);
        
        
        evenementArtiestUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementArtiestUpdaten.setMaxSize(180, 30);
        
        
        evenementArtiestVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementArtiestVerwijderen.setMaxSize(180, 30);
        
        
        evenementZaalToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementZaalVak.setMaxSize(180, 30);
        
        
        evenementZaalUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementZaalUpdaten.setMaxSize(180, 30);
        
        
        evenementZaalVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementZaalVerwijderen.setMaxSize(180, 30);
        
        
        evenementBeschrijvingToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementBeschrijvingVak.setMaxSize(180, 100);
        
        
        evenementBeschrijvingUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementBeschrijvingUpdaten.setMaxSize(180, 100);
        
        
        evenementBeschrijvingVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        evenementBeschrijvingVerwijderen.setMaxSize(180, 100);
        
        Muziek[] evenementMuziek = DatabaseHandlers.dbMuziek.getResults();

        for (Muziek instance : evenementMuziek) {
            evenementUpdaten.getItems().add(instance.getEvenementNaam());

            evenementVerwijderen.getItems().add(instance.getEvenementNaam());

        }
        
        evenementVerwijderen.setOnAction(event->{
            
            Muziek selected = new Muziek();
            for (Muziek m : evenementMuziek) {
                if (m.getEvenementNaam()== evenementVerwijderen.getSelectionModel().getSelectedItem()) {
                    selected = m;
                    break;
                }
            }
            evenementNaamVerwijderen.setText(selected.getEvenementNaam());
            evenementGenreVerwijderen.setText(selected.getMuziekGenre());
            evenementArtiestVerwijderen.setText(selected.getArtiest());
            evenementZaalVerwijderen.setText(selected.getZaal());
            evenementBeschrijvingVerwijderen.setText(selected.getBeschrijving());
            
            evenementVerwijderen.getSelectionModel().clearSelection();
            
            
            
        });
        
            evenementUpdaten.setOnAction(event -> {

            Muziek selected = new Muziek();
            for (Muziek m : evenementMuziek) {
                if (m.getEvenementNaam()== evenementUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = m;
                    break;
                }
            }
            evenementNaamUpdaten.setText(selected.getEvenementNaam());
            evenementGenreUpdaten.setText(selected.getMuziekGenre());
            evenementArtiestUpdaten.setText(selected.getArtiest());
            evenementZaalUpdaten.setText(selected.getZaal());
            evenementBeschrijvingUpdaten.setText(selected.getBeschrijving());
            
            

        });
            
            toevoegen.setOnAction(event -> {
            
            if (evenementNaamVak.getText() == "" || evenementGenreVak.getText() == "" || evenementArtiestVak.getText() == 
                  "" || evenementZaalVak.getText() == "" || evenementBeschrijvingVak.getText() == "") { 
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Vul alle gegevens in!");
                alert.show();
            }  
            else {
                
            Muziek[] EvenementMuziek = new Muziek[1];
            EvenementMuziek[0] = new Muziek(1, evenementNaamVak.getText(), evenementGenreVak.getText(),
                    evenementArtiestVak.getText(), evenementZaalVak.getText(), evenementBeschrijvingVak.getText());
            DatabaseHandlers.dbMuziek.insertDataIntoTable(EvenementMuziek);
            }
            
            evenementNaamVak.clear();
            evenementGenreVak.clear();
            evenementArtiestVak.clear();
            evenementZaalVak.clear();
            evenementBeschrijvingVak.clear();

        });

            evenementNaamVerwijderen.setEditable(false);
            evenementGenreVerwijderen.setEditable(false);
            evenementArtiestVerwijderen.setEditable(false);
            evenementZaalVerwijderen.setEditable(false);        
            evenementBeschrijvingVerwijderen.setEditable(false);

            verwijderen.setOnAction(event -> {
                        Muziek selected = new Muziek();
                        for (Muziek m : evenementMuziek) {
                            if (m.getEvenementNaam()== evenementVerwijderen.getSelectionModel().getSelectedItem()) {
                                selected = m;
                                break;
                            }
                        }


                        DatabaseHandlers.dbMuziek.deleteSpecificData(selected);
                        evenementVerwijderen.getSelectionModel().clearSelection();


                    });   
            
            updaten.setOnAction(event -> {

            Muziek selected = new Muziek();
            for (Muziek m : evenementMuziek) {
                if (m.getEvenementNaam() == evenementUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = m;
                    break;
                }
            }
            
            Muziek updatedMuziek = new Muziek();
            updatedMuziek.setEventid(selected.getEventid());
            updatedMuziek.setEvenementNaam(evenementNaamUpdaten.getText());
            updatedMuziek.setMuziekGenre(evenementGenreUpdaten.getText());
            updatedMuziek.setArtiest(evenementArtiestUpdaten.getText());
            updatedMuziek.setZaal(evenementZaalUpdaten.getText());
            updatedMuziek.setBeschrijving(evenementBeschrijvingUpdaten.getText());
            
            

            DatabaseHandlers.dbMuziek.UpdateDataIntoTable(selected, updatedMuziek);
            evenementUpdaten.getSelectionModel().clearSelection();
            
            evenementNaamUpdaten.clear();
            evenementGenreUpdaten.clear();
            evenementArtiestUpdaten.clear();        
            evenementZaalUpdaten.clear();       
            evenementBeschrijvingUpdaten.clear();
            
            
            
            
        });
        
        
        gridtoevoegen.setAlignment(Pos.CENTER);
        gridtoevoegen.setVgap(10);
        gridtoevoegen.setHgap(10);
        
        gridtoevoegen.add(evenementNaamToevoegenLabel, 0, 0);
        gridtoevoegen.add(evenementNaamVak, 1, 0);
        gridtoevoegen.add(evenementGenreToevoegenLabel, 0, 1);
        gridtoevoegen.add(evenementGenreVak, 1, 1);       
        gridtoevoegen.add(evenementArtiestToevoegenLabel, 0, 2);
        gridtoevoegen.add(evenementArtiestVak, 1, 2);
        gridtoevoegen.add(evenementZaalToevoegenLabel, 0, 3);
        gridtoevoegen.add(evenementZaalVak, 1, 3);
        gridtoevoegen.add(evenementBeschrijvingToevoegenLabel, 0, 4);
        gridtoevoegen.add(evenementBeschrijvingVak, 1, 4);
        gridtoevoegen.add(toevoegen, 1, 5);
        
        
        gridUpdaten.setAlignment(Pos.CENTER);
        gridUpdaten.setVgap(10);
        gridUpdaten.setHgap(10);
        
        gridUpdaten.add(evenementUpdaten, 1, 0);
        gridUpdaten.add(evenementNaamUpdatenLabel, 0, 1);
        gridUpdaten.add(evenementNaamUpdaten, 1, 1);
        gridUpdaten.add(evenementGenreUpdatenLabel, 0, 2);
        gridUpdaten.add(evenementGenreUpdaten, 1, 2);
        gridUpdaten.add(evenementArtiestUpdatenLabel, 0, 3);
        gridUpdaten.add(evenementArtiestUpdaten, 1, 3);
        gridUpdaten.add(evenementZaalUpdatenLabel, 0, 4);
        gridUpdaten.add(evenementZaalUpdaten, 1, 4);
        gridUpdaten.add(evenementBeschrijvingUpdatenLabel, 0, 5);
        gridUpdaten.add(evenementBeschrijvingUpdaten, 1, 5);
        gridUpdaten.add(updaten, 1, 6);
        
        
        gridVerwijderen.setAlignment(Pos.CENTER);
        gridVerwijderen.setVgap(10);
        gridVerwijderen.setHgap(10);
        
        gridVerwijderen.add(evenementVerwijderen, 1, 0);
        gridVerwijderen.add(evenementNaamVerwijderenLabel, 0, 1);
        gridVerwijderen.add(evenementNaamVerwijderen, 1, 1);
        gridVerwijderen.add(evenementGenreVerwijderenLabel, 0, 2);
        gridVerwijderen.add(evenementGenreVerwijderen, 1, 2);
        gridVerwijderen.add(evenementArtiestVerwijderenLabel, 0, 3);
        gridVerwijderen.add(evenementArtiestVerwijderen, 1, 3);
        gridVerwijderen.add(evenementZaalVerwijderenLabel, 0, 4);
        gridVerwijderen.add(evenementZaalVerwijderen, 1, 4);
        gridVerwijderen.add(evenementBeschrijvingVerwijderenLabel, 0, 5);
        gridVerwijderen.add(evenementBeschrijvingVerwijderen, 1, 5);
        gridVerwijderen.add(verwijderen, 1, 6);
        
        
        gridTotaal.setAlignment(Pos.CENTER);
        gridTotaal.setHgap(30);
        gridTotaal.add(gridtoevoegen, 0, 0);
        gridTotaal.add(gridUpdaten, 1, 0);
        gridTotaal.add(gridVerwijderen, 2, 0);
        
        
        
        this.setCenter(gridTotaal);
    }
    
}
