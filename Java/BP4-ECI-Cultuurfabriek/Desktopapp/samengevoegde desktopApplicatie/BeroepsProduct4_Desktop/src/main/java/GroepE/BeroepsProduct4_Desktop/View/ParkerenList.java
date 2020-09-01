/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.Main;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Parkeren;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Thobi
 */
public class ParkerenList extends GridPane{
    
    Parkeren parkeren;
    Text txt_email = new Text("");
    //Text txt_date = new Text("");
    Text txt_parkeerplek = new Text("");
    Text txt_opmerking = new Text("");

    
        public void resetParkeren(Parkeren toSet)
    {
        parkeren = toSet;
        resetParkeren();
    }

    
    public void resetParkeren(){
        txt_email.setText(parkeren.getsEML());
        //txt_date.setText(parkeren.getsDate());
        txt_parkeerplek.setText (parkeren.getsParkeerplek());
        txt_opmerking.setText (parkeren.getsOpmerking());
        
    }
    
    
        
    public ParkerenList(Parkeren toSet){
        
        parkeren = toSet;
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px");

        this.add(txt_email,0,0);
        //this.add(txt_date,1,0);
        this.add(txt_parkeerplek,2,0);
        this.add(txt_opmerking,3,0);
    
    }
}
