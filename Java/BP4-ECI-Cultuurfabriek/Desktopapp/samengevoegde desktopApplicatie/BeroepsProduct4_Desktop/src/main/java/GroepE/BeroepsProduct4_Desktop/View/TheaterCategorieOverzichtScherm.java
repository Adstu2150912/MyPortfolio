/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;


import GroepE.BeroepsProduct4_Desktop.DataTypes.Theater;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
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
public class TheaterCategorieOverzichtScherm extends BorderPane{
    
    private GridPane gridtoevoegen = new GridPane(),gridUpdaten = new GridPane(), 
            gridVerwijderen = new GridPane(), gridTotaal = new GridPane();
    
    private Label theaterNaamToevoegenLabel = new Label("Theaternaam: "),theaterNaamUpdatenLabel = new Label("Theaternaam: "),
            theaterNaamVerwijderenLabel = new Label("Theaternaam: "), theaterGenreToevoegenLabel = new Label("Theatergenre: "),
            theaterGenreUpdatenLabel = new Label("Theatergenre: "),theaterGenreVerwijderenLabel = new Label("Theatergenre: "),
            theaterRegisseurToevoegenLabel = new Label("Regisseur: "),theaterRegisseurUpdatenLabel = new Label("Regisseur: "),
            theaterRegisseurVerwijderenLabel = new Label("Regisseur: "),theaterDuurToevoegenLabel = new Label("Duur: "),
            theaterDuurUpdatenLabel = new Label("Duur: "),theaterDuurVerwijderenLabel = new Label("Duur: "),
            theaterBeschrijvingToevoegenLabel = new Label("Beschrijving: "),theaterBeschrijvingUpdatenLabel = new Label("Beschrijving: "),
            theaterBeschrijvingVerwijderenLabel = new Label("Beschrijving: ");
    
    
    private TextField theaterNaamVak = new TextField(), theaterGenreVak = new TextField(), theaterNaamUpdaten = new TextField(), 
            theaterNaamVerwijderen = new TextField(), theaterGenreUpdaten = new TextField(), theaterGenreVerwijderen = new TextField(),
            theaterRegisseurVak = new TextField(),theaterRegisseurUpdaten = new TextField(),theaterRegisseurVerwijderen = new TextField(),
            theaterDuurVak = new TextField(),theaterDuurUpdaten = new TextField(),theaterDuurVerwijderen = new TextField();
    
    
    private TextArea theaterBeschrijvingVak = new TextArea(),theaterBeschrijvingUpdaten = new TextArea(),
            theaterBeschrijvingVerwijderen = new TextArea();
    
    
    private Button toevoegen = new Button("Toevoegen"), updaten = new Button("Updaten"), verwijderen = new Button("Verwijderen");
    
    
    private ChoiceBox theaterUpdaten = new ChoiceBox(),theaterVerwijderen = new ChoiceBox();
    
    
    
    
    public TheaterCategorieOverzichtScherm(){
        
        theaterNaamToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterNaamVak.setMaxSize(180, 30);
        
        
        theaterGenreToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterGenreVak.setMaxSize(180, 30);
        
        
        theaterNaamUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterNaamUpdaten.setMaxSize(180, 30);
        
        
        theaterGenreUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterGenreUpdaten.setMaxSize(180, 30);
        
        
        theaterNaamVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterNaamVerwijderen.setMaxSize(180, 30);
        
        
        theaterGenreVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterGenreVerwijderen.setMaxSize(180, 30);
        
        
        theaterRegisseurToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterRegisseurVak.setMaxSize(180, 30);
        
        
        theaterRegisseurUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterRegisseurUpdaten.setMaxSize(180, 30);
        
        
        theaterRegisseurVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterRegisseurVerwijderen.setMaxSize(180, 30);
        
        
        theaterDuurToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterDuurVak.setMaxSize(180, 30);
        
        
        theaterDuurUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterDuurUpdaten.setMaxSize(180, 30);
        
        
        theaterDuurVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterDuurVerwijderen.setMaxSize(180, 30);
        
        
        theaterBeschrijvingToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterBeschrijvingVak.setMaxSize(180, 100);
        
        
        theaterBeschrijvingUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterBeschrijvingUpdaten.setMaxSize(180, 100);
        
        
        theaterBeschrijvingVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        theaterBeschrijvingVerwijderen.setMaxSize(180, 100);
        
        
        Theater[] theaters = DatabaseHandlers.dbTheater.getResults();

        for (Theater instance : theaters) {
            theaterUpdaten.getItems().add(instance.getTheaterNaam());

            theaterVerwijderen.getItems().add(instance.getTheaterNaam());

        }
        
        theaterVerwijderen.setOnAction(event->{
            
            Theater selected = new Theater();
            for (Theater t : theaters) {
                if (t.getTheaterNaam() == theaterVerwijderen.getSelectionModel().getSelectedItem()) {
                    selected = t;
                    break;
                }
            }
            theaterNaamVerwijderen.setText(selected.getTheaterNaam());
            theaterGenreVerwijderen.setText(selected.getTheaterGenre());
            theaterRegisseurVerwijderen.setText(selected.getRegisseur());
            theaterDuurVerwijderen.setText(selected.getDuur());
            theaterBeschrijvingVerwijderen.setText(selected.getBeschrijving());
            
            
            
            
            
        });
        
        theaterUpdaten.setOnAction(event -> {

            Theater selected = new Theater();
            for (Theater t : theaters) {
                if (t.getTheaterNaam() == theaterUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = t;
                    break;
                }
            }
            theaterNaamUpdaten.setText(selected.getTheaterNaam());
            theaterGenreUpdaten.setText(selected.getTheaterGenre());
            theaterRegisseurUpdaten.setText(selected.getRegisseur());
            theaterDuurUpdaten.setText(selected.getDuur());
            theaterBeschrijvingUpdaten.setText(selected.getBeschrijving());
            
            

        });
        
        toevoegen.setOnAction(event -> {
            
            if (theaterNaamVak.getText() == "" || theaterGenreVak.getText() == "" || 
                    theaterRegisseurVak.getText() == "" || theaterDuurVak.getText() == "" || 
                    theaterBeschrijvingVak.getText() == "") { 
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Vul alle gegevens in!");
                alert.show();
            }
            
            else{
            
            Theater[] Theaters = new Theater[1];
            Theaters[0] = new Theater(1, theaterNaamVak.getText(), theaterRegisseurVak.getText(), 
                    theaterDuurVak.getText(),theaterGenreVak.getText(),theaterBeschrijvingVak.getText());
            DatabaseHandlers.dbTheater.insertDataIntoTable(Theaters);
            }
            
            
            
            theaterNaamVak.clear();
            theaterGenreVak.clear();
            theaterRegisseurVak.clear();
            theaterDuurVak.clear();
            theaterBeschrijvingVak.clear();

        });
        
        theaterNaamVerwijderen.setEditable(false);
        theaterGenreVerwijderen.setEditable(false);
        theaterRegisseurVerwijderen.setEditable(false);        
        theaterDuurVerwijderen.setEditable(false);        
        theaterBeschrijvingVerwijderen.setEditable(false);  

        verwijderen.setOnAction(event -> {
            Theater selected = new Theater();
            for (Theater t : theaters) {
                if (t.getTheaterNaam()== theaterVerwijderen.getSelectionModel().getSelectedItem()) {
                    selected = t;
                    break;
                }
            }
            
            
            DatabaseHandlers.dbTheater.deleteSpecificData(selected);
            theaterVerwijderen.getSelectionModel().clearSelection();
            
            
        });
        
        updaten.setOnAction(event -> {

            Theater selected = new Theater();
            for (Theater t : theaters) {
                if (t.getTheaterNaam()== theaterUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = t;
                    break;
                }
            }
            
            Theater updatedTheater = new Theater();
            updatedTheater.setEventid(selected.getEventid());
            updatedTheater.setTheaterNaam(theaterNaamUpdaten.getText());
            updatedTheater.setTheaterGenre(theaterGenreUpdaten.getText());
            updatedTheater.setRegisseur(theaterRegisseurUpdaten.getText());
            updatedTheater.setDuur(theaterDuurUpdaten.getText());
            updatedTheater.setBeschrijving(theaterBeschrijvingUpdaten.getText());
            
            

            DatabaseHandlers.dbTheater.UpdateDataIntoTable(selected, updatedTheater);
            theaterUpdaten.getSelectionModel().clearSelection();
            
            theaterNaamUpdaten.clear();
            theaterGenreUpdaten.clear();       
            theaterRegisseurUpdaten.clear();       
            theaterDuurUpdaten.clear();
            theaterBeschrijvingUpdaten.clear();
            
            
            
        });
        
        
        
        gridtoevoegen.setAlignment(Pos.CENTER);
        gridtoevoegen.setVgap(10);
        gridtoevoegen.setHgap(10);
        
        gridtoevoegen.add(theaterNaamToevoegenLabel, 0, 0);
        gridtoevoegen.add(theaterNaamVak, 1, 0);
        gridtoevoegen.add(theaterGenreToevoegenLabel, 0, 1);
        gridtoevoegen.add(theaterGenreVak, 1, 1);       
        gridtoevoegen.add(theaterRegisseurToevoegenLabel, 0, 2);
        gridtoevoegen.add(theaterRegisseurVak, 1, 2);
        gridtoevoegen.add(theaterDuurToevoegenLabel, 0, 3);
        gridtoevoegen.add(theaterDuurVak, 1, 3);
        gridtoevoegen.add(theaterBeschrijvingToevoegenLabel, 0, 4);
        gridtoevoegen.add(theaterBeschrijvingVak, 1, 4);
        gridtoevoegen.add(toevoegen, 1, 5);
        
        
        gridUpdaten.setAlignment(Pos.CENTER);
        gridUpdaten.setVgap(10);
        gridUpdaten.setHgap(10);
        
        gridUpdaten.add(theaterUpdaten, 0, 0);
        gridUpdaten.add(theaterNaamUpdatenLabel, 0, 1);
        gridUpdaten.add(theaterNaamUpdaten, 1, 1);
        gridUpdaten.add(theaterGenreUpdatenLabel, 0, 2);
        gridUpdaten.add(theaterGenreUpdaten, 1, 2);
        gridUpdaten.add(theaterRegisseurUpdatenLabel, 0, 3);
        gridUpdaten.add(theaterRegisseurUpdaten, 1, 3);
        gridUpdaten.add(theaterDuurUpdatenLabel, 0, 4);
        gridUpdaten.add(theaterDuurUpdaten, 1, 4);
        gridUpdaten.add(theaterBeschrijvingUpdatenLabel, 0, 5);
        gridUpdaten.add(theaterBeschrijvingUpdaten, 1, 5);
        gridUpdaten.add(updaten, 1, 6);
        
        
        gridVerwijderen.setAlignment(Pos.CENTER);
        gridVerwijderen.setVgap(10);
        gridVerwijderen.setHgap(10);
        
        gridVerwijderen.add(theaterVerwijderen, 0, 0);
        gridVerwijderen.add(theaterNaamVerwijderenLabel, 0, 1);
        gridVerwijderen.add(theaterNaamVerwijderen, 1, 1);
        gridVerwijderen.add(theaterGenreVerwijderenLabel, 0, 2);
        gridVerwijderen.add(theaterGenreVerwijderen, 1, 2);
        gridVerwijderen.add(theaterRegisseurVerwijderenLabel, 0, 3);
        gridVerwijderen.add(theaterRegisseurVerwijderen, 1, 3);
        gridVerwijderen.add(theaterDuurVerwijderenLabel, 0, 4);
        gridVerwijderen.add(theaterDuurVerwijderen, 1, 4);
        gridVerwijderen.add(theaterBeschrijvingVerwijderenLabel, 0, 5);
        gridVerwijderen.add(theaterBeschrijvingVerwijderen, 1, 5);
        gridVerwijderen.add(verwijderen, 1, 6);
        
        
        gridTotaal.setAlignment(Pos.CENTER);
        gridTotaal.setHgap(30);
        gridTotaal.add(gridtoevoegen, 0, 0);
        gridTotaal.add(gridUpdaten, 1, 0);
        gridTotaal.add(gridVerwijderen, 2, 0);
        
        
        this.setCenter(gridTotaal);
    
        
        
    }
    
}
