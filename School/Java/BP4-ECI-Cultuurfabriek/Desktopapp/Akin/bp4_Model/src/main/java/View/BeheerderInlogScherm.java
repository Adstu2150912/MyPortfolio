package View;

import bp4_Model.DataTypes.Beheerder;
import bp4_Model.DatabaseHandlers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author akina
 */
public class BeheerderInlogScherm extends Pane {

    private GridPane grid;
    private Label gebruikersnaam = new Label("Gebruikersnaam :");
    private Label wachtwoord = new Label("Wachtwoord :");
    private TextField gebruikersnaamveld = new TextField();
    private TextField wachtwoordveld = new TextField();
    private Button inloggen = new Button("inloggen");
    private Label error = new Label("Gegevens zijn onjuist");

    public BeheerderInlogScherm() {
        grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.relocate(20, 20);
        grid.add(gebruikersnaam, 0, 0);
        grid.add(wachtwoord, 0, 1);
        grid.add(gebruikersnaamveld, 1, 0);
        grid.add(wachtwoordveld, 1, 1);
        grid.add(inloggen, 1, 2);
        getChildren().add(grid);

        inloggen.setOnAction(event -> {
           // try {
            DatabaseHandlers.dbbeheerder.select("gebruikersnaam = '" + gebruikersnaamveld.getText() + "' and wachtwoord = '" + wachtwoordveld.getText() + "'");
            
            if (DatabaseHandlers.dbbeheerder.getResults().length > 0) {
                //Beheerder beheerder = new Beheerder();
                getChildren().clear();
                getChildren().add(new BeheerderExpositieOverzichtScherm());
                //getChildren().add(new BeheerderOverzichtScherm(beheerder));
                System.out.println("ingelogd als beheerder");
            } else {
                grid.getChildren().remove(error);
                grid.add(error, 1, 5);
            }
            
            //} catch (Exception se){
            //    System.out.println(se.getMessage());
            //}

        });
    }
}
