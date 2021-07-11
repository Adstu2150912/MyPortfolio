/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import java.sql.Date;
import javafx.scene.layout.GridPane;

/**
 *
 * @author swkoe
 */
public class GebruikerLogs extends GridPane implements CustomList
{
    int nRow = 0;


    @Override
    public void AddObjects(Object[] instances)
    {
        for(Object instance : instances) addObject(instance);
    }

    @Override
    public void addObject(Object instance)
    {
        if(instance instanceof Gebruiker)
        {
            ListRowGebruiker gui_gebruiker = new ListRowGebruiker(((Gebruiker)instance));
            this.add(gui_gebruiker, 0, nRow);
            nRow++;
        }
//            gebruikerslist.add(((Gebruiker)instance));
    }

    @Override
    public void clearObjects()
    {

    }

    public GebruikerLogs()
    {
        DatabaseHandlers.gebruikers.selectAll();
        AddObjects(DatabaseHandlers.gebruikers.getResults());
//        AddObjects(DatabaseHandlers.gebruikers.getResults());
//        AddObjects(DatabaseHandlers.gebruikers.getResults());
//        AddObjects(DatabaseHandlers.gebruikers.getResults());
//        AddObjects(DatabaseHandlers.gebruikers.getResults());
//        AddObjects(DatabaseHandlers.gebruikers.getResults());
//        AddObjects(DatabaseHandlers.gebruikers.getResults());
//        AddObjects(DatabaseHandlers.gebruikers.getResults());

        this.maxHeight(1000);
        this.setStyle("-fx-padding: 5px;");
    }


}
