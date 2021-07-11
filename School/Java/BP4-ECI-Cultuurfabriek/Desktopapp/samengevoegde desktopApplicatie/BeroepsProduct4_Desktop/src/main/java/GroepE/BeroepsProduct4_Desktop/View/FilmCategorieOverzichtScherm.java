/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Film;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import GroepE.BeroepsProduct4_Desktop.Main;
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
 *
 * @author dahir
 */
public class FilmCategorieOverzichtScherm extends BorderPane {

    public ArrayList<Film> films = new ArrayList<>();

    void GetResults() {
        // select narrow down
        // select query 
        // get res
        DatabaseHandlers.dbFilm.selectAll();
        films.clear();
        for (Object instance : DatabaseHandlers.dbFilm.getResults()) {
            films.add(((Film) instance));
        }

    }

    private GridPane gridEvent = new GridPane(), gridtoevoegen = new GridPane(), gridUpdaten = new GridPane(),
            gridVerwijderen = new GridPane(), gridTotaal = new GridPane();

    private Label filmNaamToevoegenLabel = new Label("Filmnaam: "), filmNaamUpdatenLabel = new Label("Filmnaam: "),
            filmNaamVerwijderenLabel = new Label("Filmnaam: "), filmGenreToevoegenLabel = new Label("Filmgenre: "),
            filmGenreUpdatenLabel = new Label("Filmgenre: "), filmGenreVerwijderenLabel = new Label("Filmgenre: "),
            filmLandToevoegenLabel = new Label("Land: "), filmLandUpdatenLabel = new Label("Land: "),
            filmLandVerwijderenLabel = new Label("Land: "), filmRegisseurToevoegenLabel = new Label("Regisseur: "),
            filmRegisseurUpdatenLabel = new Label("Regisseur: "), filmRegisseurVerwijderenLabel = new Label("Regisseur: "),
            filmDuurToevoegenLabel = new Label("Duur: "), filmDuurUpdatenLabel = new Label("Duur: "),
            filmDuurVerwijderenLabel = new Label("Duur: "), filmBeschrijvingToevoegenLabel = new Label("Beschrijving: "),
            filmBeschrijvingUpdatenLabel = new Label("Beschrijving: "), filmBeschrijvingVerwijderenLabel = new Label("Beschrijving: ");

    private TextField filmNaamVak = new TextField(), filmGenreVak = new TextField(), filmNaamUpdaten = new TextField(),
            filmNaamVerwijderen = new TextField(), filmGenreUpdaten = new TextField(), filmGenreVerwijderen = new TextField(),
            filmLandVak = new TextField(), filmLandUpdaten = new TextField(), filmLandVerwijderen = new TextField(),
            filmRegisseurVak = new TextField(), filmRegisseurUpdaten = new TextField(), filmRegisseurVerwijderen = new TextField(),
            filmDuurVak = new TextField(), filmDuurUpdaten = new TextField(), filmDuurVerwijderen = new TextField();

    private TextArea filmBeschrijvingVak = new TextArea(), filmBeschrijvingUpdaten = new TextArea(),
            filmBeschrijvingVerwijderen = new TextArea();

    private Button toevoegen = new Button("Toevoegen"), updaten = new Button("Updaten"), verwijderen = new Button("Verwijderen");

    private ChoiceBox filmUpdaten = new ChoiceBox(), filmVerwijderen = new ChoiceBox();

    public FilmCategorieOverzichtScherm() {

        filmNaamToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmNaamVak.setMaxSize(180, 30);

        filmGenreToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmGenreVak.setMaxSize(180, 30);

        filmNaamUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmNaamUpdaten.setMaxSize(180, 30);

        filmGenreUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmGenreUpdaten.setMaxSize(180, 30);

        filmNaamVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmNaamVerwijderen.setMaxSize(180, 30);

        filmGenreVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmGenreVerwijderen.setMaxSize(180, 30);

        filmLandToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmLandVak.setMaxSize(180, 30);

        filmLandUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmLandUpdaten.setMaxSize(180, 30);

        filmLandVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmLandVerwijderen.setMaxSize(180, 30);

        filmRegisseurToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmRegisseurVak.setMaxSize(180, 30);

        filmRegisseurUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmRegisseurUpdaten.setMaxSize(180, 30);

        filmRegisseurVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmRegisseurVerwijderen.setMaxSize(180, 30);

        filmDuurToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmDuurVak.setMaxSize(180, 30);

        filmDuurUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmDuurUpdaten.setMaxSize(180, 30);

        filmDuurVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmDuurVerwijderen.setMaxSize(180, 30);

        filmBeschrijvingToevoegenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmBeschrijvingVak.setMaxSize(180, 100);

        filmBeschrijvingUpdatenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmBeschrijvingUpdaten.setMaxSize(180, 100);

        filmBeschrijvingVerwijderenLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        filmBeschrijvingVerwijderen.setMaxSize(180, 100);

        filmUpdaten.setMinWidth(180);
        filmVerwijderen.setMinWidth(180);
        
        

        Film[] films = DatabaseHandlers.dbFilm.getResults();

        for (Film instance : films) {
            filmUpdaten.getItems().add(instance.getFilmNaam());

            filmVerwijderen.getItems().add(instance.getFilmNaam());

        }
        
        filmVerwijderen.setOnAction(event->{
            
            Film selected = new Film();
            for (Film f : films) {
                if (f.getFilmNaam() == filmVerwijderen.getSelectionModel().getSelectedItem()) {
                    selected = f;
                    break;
                }
            }
            filmNaamVerwijderen.setText(selected.getFilmNaam());
            filmGenreVerwijderen.setText(selected.getFilmGenre());
            filmLandVerwijderen.setText(selected.getLand());
            filmRegisseurVerwijderen.setText(selected.getRegisseur());
            filmDuurVerwijderen.setText(selected.getDuur());
            filmBeschrijvingVerwijderen.setText(selected.getBeschrijving());
            
            
            
            
            
        });
        
        filmUpdaten.setOnAction(event -> {

            Film selected = new Film();
            for (Film f : films) {
                if (f.getFilmNaam() == filmUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = f;
                    break;
                }
            }
            filmNaamUpdaten.setText(selected.getFilmNaam());
            filmGenreUpdaten.setText(selected.getFilmGenre());
            filmLandUpdaten.setText(selected.getLand());
            filmRegisseurUpdaten.setText(selected.getRegisseur());
            filmDuurUpdaten.setText(selected.getDuur());
            filmBeschrijvingUpdaten.setText(selected.getBeschrijving());
            
//            Main.root.setCenterPane(new FilmCategorieOverzichtScherm());
        });
        
        toevoegen.setOnAction(event -> {
            
            if (filmNaamVak.getText() == "" || filmGenreVak.getText() == "" || filmLandVak.getText() == 
                  "" || filmRegisseurVak.getText() == "" || filmDuurVak.getText() == "" || 
                    filmBeschrijvingVak.getText() == "") { 
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Vul alle gegevens in!");
                alert.show();
            }
            
            else{
            
            Film[] Films = new Film[1];
            Films[0] = new Film(1, filmNaamVak.getText(), filmGenreVak.getText(),filmRegisseurVak.getText(), 
                    filmLandVak.getText(), filmDuurVak.getText(), filmBeschrijvingVak.getText());
            DatabaseHandlers.dbFilm.insertDataIntoTable(Films);
            }
            
            
            
            filmNaamVak.clear();
            filmGenreVak.clear();
            filmLandVak.clear();
            filmRegisseurVak.clear();
            filmDuurVak.clear();
            filmBeschrijvingVak.clear();

        });
        
        
        filmNaamVerwijderen.setEditable(false);
        filmGenreVerwijderen.setEditable(false);
        filmLandVerwijderen.setEditable(false);
        filmRegisseurVerwijderen.setEditable(false);        
        filmDuurVerwijderen.setEditable(false);        
        filmBeschrijvingVerwijderen.setEditable(false);  

        verwijderen.setOnAction(event -> {
            Film selected = new Film();
            for (Film f : films) {
                if (f.getFilmNaam() == filmVerwijderen.getSelectionModel().getSelectedItem()) {
                    selected = f;
                    break;
                }
            }
            
            
            DatabaseHandlers.dbFilm.deleteSpecificData(selected);
            filmVerwijderen.getSelectionModel().clearSelection();
            
            
        });
        
        

        updaten.setOnAction(event -> {

            Film selected = new Film();
            for (Film f : films) {
                if (f.getFilmNaam() == filmUpdaten.getSelectionModel().getSelectedItem()) {
                    selected = f;
                    break;
                }
            }
            
            Film updatedFilm = new Film();
            updatedFilm.setEventid(selected.getEventid());
            updatedFilm.setFilmNaam(filmNaamUpdaten.getText());
            updatedFilm.setFilmGenre(filmGenreUpdaten.getText());
            updatedFilm.setLand(filmLandUpdaten.getText());
            updatedFilm.setRegisseur(filmRegisseurUpdaten.getText());
            updatedFilm.setDuur(filmDuurUpdaten.getText());
            updatedFilm.setBeschrijving(filmBeschrijvingUpdaten.getText());
            
            

            DatabaseHandlers.dbFilm.UpdateDataIntoTable(selected, updatedFilm);
            filmUpdaten.getSelectionModel().clearSelection();
            
            filmNaamUpdaten.clear();
            filmGenreUpdaten.clear();
            filmLandUpdaten.clear();        
            filmRegisseurUpdaten.clear();       
            filmDuurUpdaten.clear();
            filmBeschrijvingUpdaten.clear();
            
            
            
        });

        gridtoevoegen.setAlignment(Pos.CENTER);
        gridtoevoegen.setVgap(10);
        gridtoevoegen.setHgap(10);

        gridtoevoegen.add(filmNaamToevoegenLabel, 0, 0);
        gridtoevoegen.add(filmNaamVak, 1, 0);
        gridtoevoegen.add(filmGenreToevoegenLabel, 0, 1);
        gridtoevoegen.add(filmGenreVak, 1, 1);
        gridtoevoegen.add(filmLandToevoegenLabel, 0, 2);
        gridtoevoegen.add(filmLandVak, 1, 2);
        gridtoevoegen.add(filmRegisseurToevoegenLabel, 0, 3);
        gridtoevoegen.add(filmRegisseurVak, 1, 3);
        gridtoevoegen.add(filmDuurToevoegenLabel, 0, 4);
        gridtoevoegen.add(filmDuurVak, 1, 4);
        gridtoevoegen.add(filmBeschrijvingToevoegenLabel, 0, 5);
        gridtoevoegen.add(filmBeschrijvingVak, 1, 5);
        gridtoevoegen.add(toevoegen, 1, 6);

        gridUpdaten.setAlignment(Pos.CENTER);
        gridUpdaten.setVgap(10);
        gridUpdaten.setHgap(10);

        gridUpdaten.add(filmUpdaten, 1, 0);
        gridUpdaten.add(filmNaamUpdatenLabel, 0, 1);
        gridUpdaten.add(filmNaamUpdaten, 1, 1);
        gridUpdaten.add(filmGenreUpdatenLabel, 0, 2);
        gridUpdaten.add(filmGenreUpdaten, 1, 2);
        gridUpdaten.add(filmLandUpdatenLabel, 0, 3);
        gridUpdaten.add(filmLandUpdaten, 1, 3);
        gridUpdaten.add(filmRegisseurUpdatenLabel, 0, 4);
        gridUpdaten.add(filmRegisseurUpdaten, 1, 4);
        gridUpdaten.add(filmDuurUpdatenLabel, 0, 5);
        gridUpdaten.add(filmDuurUpdaten, 1, 5);
        gridUpdaten.add(filmBeschrijvingUpdatenLabel, 0, 6);
        gridUpdaten.add(filmBeschrijvingUpdaten, 1, 6);
        gridUpdaten.add(updaten, 1, 7);

        gridVerwijderen.setAlignment(Pos.CENTER);
        gridVerwijderen.setVgap(10);
        gridVerwijderen.setHgap(10);

        gridVerwijderen.add(filmVerwijderen, 1, 0);
        gridVerwijderen.add(filmNaamVerwijderenLabel, 0, 1);
        gridVerwijderen.add(filmNaamVerwijderen, 1, 1);
        gridVerwijderen.add(filmGenreVerwijderenLabel, 0, 2);
        gridVerwijderen.add(filmGenreVerwijderen, 1, 2);
        gridVerwijderen.add(filmLandVerwijderenLabel, 0, 3);
        gridVerwijderen.add(filmLandVerwijderen, 1, 3);
        gridVerwijderen.add(filmRegisseurVerwijderenLabel, 0, 4);
        gridVerwijderen.add(filmRegisseurVerwijderen, 1, 4);
        gridVerwijderen.add(filmDuurVerwijderenLabel, 0, 5);
        gridVerwijderen.add(filmDuurVerwijderen, 1, 5);
        gridVerwijderen.add(filmBeschrijvingVerwijderenLabel, 0, 6);
        gridVerwijderen.add(filmBeschrijvingVerwijderen, 1, 6);
        gridVerwijderen.add(verwijderen, 1, 7);

        gridTotaal.setAlignment(Pos.CENTER);
        gridTotaal.setHgap(30);
        gridTotaal.add(gridtoevoegen, 0, 0);
        gridTotaal.add(gridUpdaten, 1, 0);
        gridTotaal.add(gridVerwijderen, 2, 0);

        this.setCenter(gridTotaal);
    }

}
