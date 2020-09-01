/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import GroepE.BeroepsProduct4_Desktop.Main;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursus;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Cursuscategorie;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Docent;
import java.util.ArrayList;
import java.util.Optional;
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
 * Auteur: Adam Oubelkas
 * Aanmaakdatum: 05-06-2020
 * Project: Beroepsproduct 4 - ECI-Cultuurfabriek
 * Bestandsnaam: CursusCategorievenster.java
 */
public class CursusCategorievenster extends BorderPane
{
    public ArrayList<Cursus> alCursus = new ArrayList<>();

    void GetResults() {
        // select narrow down
        // select query 
        // get res
        DatabaseHandlers.dbCursus.selectAll();
        alCursus.clear();
        for (Object instance : DatabaseHandlers.dbCursus.getResults()) {
            alCursus.add(((Cursus) instance));
        }
    }
    
    private GridPane gridEvent = new GridPane(), gridtoevoegen = new GridPane(), gridUpdaten = new GridPane(),
            gridVerwijderen = new GridPane(), gridTotaal = new GridPane();

    private Label lblAddCursusNaam = new Label("Cursusnaam: "), lblUpdateCursusNaam = new Label("Cursusnaam: "),
            lblDeleteCursusNaam = new Label("Cursusnaam: "), lblAddDoelgroep = new Label("Doelgroep: "),
            lblUpdateDoelgroep = new Label("Doelgroep: "), lblDeleteDoelgroep = new Label("Doelgroep: "),
            lblAddCursusBeschrijving = new Label("Beschrijving: "),
            lblUpdateCursusBeschrijving = new Label("Beschrijving: "), filmDeleteCursusBeschrijving = new Label("Beschrijving: ");

    private TextField txtCursusNaam = new TextField(), txtDoelgroep = new TextField(), txtUpdateCursusNaam = new TextField(),
            txtDeleteCursusNaam = new TextField(), txtUpdateDoelgroep = new TextField(), txtDeleteDoelgroep = new TextField();

    private TextArea txtBeschrijving = new TextArea(), txtUpdateBeschrijving = new TextArea(),
            txtDeleteBeschrijving = new TextArea();

    private Button toevoegen = new Button("Toevoegen"), updaten = new Button("Updaten"), verwijderen = new Button("Verwijderen");

    private ChoiceBox cursusUpdaten = new ChoiceBox(), cursusVerwijderen = new ChoiceBox();
    
    CursusCategorievenster()
    {
        lblAddCursusNaam.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtCursusNaam.setMaxSize(180, 30);

        lblAddDoelgroep.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtDoelgroep.setMaxSize(180, 30);

        lblUpdateCursusNaam.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtUpdateCursusNaam.setMaxSize(180, 30);

        lblUpdateDoelgroep.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtUpdateDoelgroep.setMaxSize(180, 30);

        lblDeleteCursusNaam.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtDeleteCursusNaam.setMaxSize(180, 30);

        lblDeleteDoelgroep.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtDeleteDoelgroep.setMaxSize(180, 30);

        lblAddCursusBeschrijving.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtBeschrijving.setMaxSize(180, 100);

        lblUpdateCursusBeschrijving.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtUpdateBeschrijving.setMaxSize(180, 100);

        filmDeleteCursusBeschrijving.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        txtDeleteBeschrijving.setMaxSize(180, 100);

        cursusUpdaten.setMinWidth(180);
        cursusVerwijderen.setMinWidth(180);

        Cursus[] aCursus = DatabaseHandlers.dbCursus.getResults();

        for (Cursus instance : aCursus) {
            cursusUpdaten.getItems().add(instance.getCursusNaam());

            cursusVerwijderen.getItems().add(instance.getCursusNaam());

        }
        
        cursusVerwijderen.setOnAction(event->{
            
            Cursus selected = new Cursus();
            for (Cursus c : aCursus) {
                if (c.getCursusNaam()== cursusVerwijderen.getSelectionModel().getSelectedItem()) {
                    selected = c;
                    break;
                }
            }
            txtDeleteCursusNaam.setText(selected.getCursusNaam());
            txtDeleteDoelgroep.setText(selected.getDoelGroep());
            txtDeleteBeschrijving.setText(selected.getBeschrijving());           
        });
        
        cursusUpdaten.setOnAction(event -> {

            Cursus selected = new Cursus();
            for (Cursus c : aCursus) {
                if (c.getCursusNaam() == cursusUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = c;
                    break;
                }
            }
            txtUpdateCursusNaam.setText(selected.getCursusNaam());
            txtUpdateDoelgroep.setText(selected.getDoelGroep());
            txtUpdateBeschrijving.setText(selected.getBeschrijving());
            
//            Main.root.setCenterPane(new FilmCategorieOverzichtScherm());
        });
        
        toevoegen.setOnAction(event -> {
            
            if (txtCursusNaam.getText() == "" || txtDoelgroep.getText() == "" || 
                    txtBeschrijving.getText() == "") { 
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Vul alle gegevens in!");
                alert.show();
            }
            
            else{
                Cursus[] aNewCursus = new Cursus[1];
                aNewCursus[0] = new Cursus();
                aNewCursus[0].setCursusNaam(txtCursusNaam.getText());
                aNewCursus[0].setDoelGroep(txtDoelgroep.getText());
                aNewCursus[0].setBeschrijving(txtBeschrijving.getText());
                DatabaseHandlers.dbCursus.insertDataIntoTable(aNewCursus);
            }        
            
            txtCursusNaam.clear();
            txtDoelgroep.clear();
            txtBeschrijving.clear();

        });
        
        txtDeleteCursusNaam.setEditable(false);
        txtDeleteDoelgroep.setEditable(false);      
        txtDeleteBeschrijving.setEditable(false);  

        verwijderen.setOnAction(event -> {
            Cursus selected = new Cursus();
            for (Cursus c : aCursus) {
                if (c.getCursusNaam()== cursusVerwijderen.getSelectionModel().getSelectedItem()) {
                    selected = c;
                    break;
                }
            }
            
            
            DatabaseHandlers.dbCursus.deleteSpecificData(selected);
            cursusVerwijderen.getSelectionModel().clearSelection();
            
            
        });
        
        

        updaten.setOnAction(event -> {

            Cursus selected = new Cursus();
            for (Cursus c : alCursus) {
                if (c.getCursusNaam()== cursusUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = c;
                    break;
                }
            }
            
            Cursus updatedCursus = new Cursus();
            updatedCursus.setCursusID(selected.getCursusID());
            updatedCursus.setCursusNaam(txtUpdateCursusNaam.getText());
            updatedCursus.setDoelGroep(txtUpdateDoelgroep.getText());
            updatedCursus.setBeschrijving(txtUpdateBeschrijving.getText());

            DatabaseHandlers.dbFilm.UpdateDataIntoTable(selected, updatedCursus);
            cursusUpdaten.getSelectionModel().clearSelection();
            
            txtUpdateCursusNaam.clear();
            txtUpdateDoelgroep.clear();
            txtUpdateBeschrijving.clear();      
        });

        gridtoevoegen.setAlignment(Pos.CENTER);
        gridtoevoegen.setVgap(10);
        gridtoevoegen.setHgap(10);

        gridtoevoegen.add(lblAddCursusNaam, 0, 0);
        gridtoevoegen.add(txtCursusNaam, 1, 0);
        gridtoevoegen.add(lblAddDoelgroep, 0, 1);
        gridtoevoegen.add(txtDoelgroep, 1, 1);
        gridtoevoegen.add(lblAddCursusBeschrijving, 0, 5);
        gridtoevoegen.add(txtBeschrijving, 1, 5);
        gridtoevoegen.add(toevoegen, 1, 6);

        gridUpdaten.setAlignment(Pos.CENTER);
        gridUpdaten.setVgap(10);
        gridUpdaten.setHgap(10);

        gridUpdaten.add(cursusUpdaten, 1, 0);
        gridUpdaten.add(lblUpdateCursusNaam, 0, 1);
        gridUpdaten.add(txtUpdateCursusNaam, 1, 1);
        gridUpdaten.add(lblUpdateDoelgroep, 0, 2);
        gridUpdaten.add(txtUpdateDoelgroep, 1, 2);
        gridUpdaten.add(lblUpdateCursusBeschrijving, 0, 6);
        gridUpdaten.add(txtUpdateBeschrijving, 1, 6);
        gridUpdaten.add(updaten, 1, 7);

        gridVerwijderen.setAlignment(Pos.CENTER);
        gridVerwijderen.setVgap(10);
        gridVerwijderen.setHgap(10);

        gridVerwijderen.add(cursusVerwijderen, 1, 0);
        gridVerwijderen.add(lblDeleteCursusNaam, 0, 1);
        gridVerwijderen.add(txtDeleteCursusNaam, 1, 1);
        gridVerwijderen.add(lblDeleteDoelgroep, 0, 2);
        gridVerwijderen.add(txtDeleteDoelgroep, 1, 2);
        gridVerwijderen.add(filmDeleteCursusBeschrijving, 0, 6);
        gridVerwijderen.add(txtDeleteBeschrijving, 1, 6);
        gridVerwijderen.add(verwijderen, 1, 7);

        gridTotaal.setAlignment(Pos.CENTER);
        gridTotaal.setHgap(30);
        gridTotaal.add(gridtoevoegen, 0, 0);
        gridTotaal.add(gridUpdaten, 1, 0);
        gridTotaal.add(gridVerwijderen, 2, 0);

        this.setCenter(gridTotaal);
    }
}
