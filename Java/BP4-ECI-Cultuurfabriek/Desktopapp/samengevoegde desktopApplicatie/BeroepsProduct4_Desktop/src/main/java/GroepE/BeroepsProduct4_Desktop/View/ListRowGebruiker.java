/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.Main;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author swkoe
 */
public class ListRowGebruiker extends GridPane
{
    Gebruiker gebruiker;
    Text txt_email = new Text("");
    Text txt_naam = new Text("");
    Text txt_achternaam = new Text("");
    Text txt_straat = new Text("");
    Text txt_nummer = new Text("");
    Text txt_plaats = new Text("");
    Text txt_iban = new Text("");
    Text txt_gender = new Text("");
    Button btn_Edit = new Button("Edit");

    private void btn_edit_click()
    {
        ((HoofdScherm)Main.root).setCenterPane(new GebruikerReg(gebruiker));
    }

    public void resetGebruiker(Gebruiker toSet)
    {
        gebruiker = toSet;
        resetGebruiker();
    }


    public void resetGebruiker()
    {
        txt_email.setText(gebruiker.getsEmail());
        txt_naam.setText(gebruiker.getsVoornaam());
        txt_achternaam.setText(gebruiker.getsAchternaam());
        txt_straat.setText(gebruiker.getsStraatNaam());
        txt_nummer.setText(gebruiker.getsHuisnummer());
        txt_plaats.setText(gebruiker.getsPlaats());
        txt_iban.setText(gebruiker.getsIbanNummer());
        txt_gender.setText(gebruiker.getsGeslacht());
    }


    public ListRowGebruiker(Gebruiker toSet)
    {
        gebruiker = toSet;
        resetGebruiker();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(10);
        this.getColumnConstraints().add(col1);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(10);
        this.getColumnConstraints().add(col2);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(10);
        this.getColumnConstraints().add(col3);

        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(10);
        this.getColumnConstraints().add(col4);

        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPercentWidth(10);
        this.getColumnConstraints().add(col5);

        ColumnConstraints col6 = new ColumnConstraints();
        col6.setPercentWidth(10);
        this.getColumnConstraints().add(col6);

        ColumnConstraints col7 = new ColumnConstraints();
        col7.setPercentWidth(10);
        this.getColumnConstraints().add(col7);

        ColumnConstraints col8 = new ColumnConstraints();
        col8.setPercentWidth(15);
        this.getColumnConstraints().add(col8);

        ColumnConstraints col9 = new ColumnConstraints();
        col9.setPercentWidth(5);
        this.getColumnConstraints().add(col9);

        btn_Edit.setOnAction(event -> btn_edit_click());

        this.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px");

        this.add(txt_email,0,0);
        this.add(txt_naam,1,0);
        this.add(txt_achternaam,2,0);
        this.add(txt_straat,3,0);
        this.add(txt_nummer,4,0);
        this.add(txt_plaats,5,0);
        this.add(txt_iban,6,0);
        this.add(txt_gender,7,0);
        this.add(btn_Edit,8,0);
//        this.add(,0,0),8,0)
//        this.add(,0,0)
//        this.add(,0,0)

    }
}