/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Reservering;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import GroepE.BeroepsProduct4_Desktop.Main;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author swkoe
 */
public class ListRowReservering  extends GridPane
{
    Reservering resevering;
    Text txt_email = new Text("");
    Text txt_aantal = new Text("");
    Text txt_eventID = new Text("");
    Button btn_Edit = new Button("Delete");

    private void btn_edit_click()
    {
        DatabaseHandlers.reserveringen.deleteSpecificData(resevering);
        ((HoofdScherm)Main.root).setCenterPane(new Reserveringen());
    }

    public void resetResevering(Reservering toSet)
    {
        resevering = toSet;
        resetReservering();
    }


    public void resetReservering()
    {
        txt_email.setText(resevering.getsEmail());
        txt_aantal.setText("" + resevering.getnAantalTickets());
        txt_eventID.setText("" + resevering.getnEventID());
    }


    public ListRowReservering(Reservering toSet)
    {
        resevering = toSet;
        resetReservering();
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        this.getColumnConstraints().add(col1);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        this.getColumnConstraints().add(col2);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        this.getColumnConstraints().add(col3);

        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(25);
        this.getColumnConstraints().add(col4);
        
        btn_Edit.setOnAction(event -> btn_edit_click());

        this.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px");

        this.add(txt_email,0,0);
        this.add(txt_aantal,1,0);
        this.add(txt_eventID,2,0);
        this.add(btn_Edit,3,0);
    }
}