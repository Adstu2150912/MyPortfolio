/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Reservering;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import javafx.scene.layout.GridPane;

/**
 *
 * @author swkoe
 */
public class Reserveringen extends GridPane implements CustomList 
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
        if(instance instanceof Reservering)
        {
            ListRowReservering gui_gebruiker = new ListRowReservering(((Reservering)instance));
            this.add(gui_gebruiker, 0, nRow);
            nRow++;
        }
//            gebruikerslist.add(((Gebruiker)instance));
    }

    @Override
    public void clearObjects()
    {

    }

    public Reserveringen()
    {
        DatabaseHandlers.reserveringen.selectAll();
        AddObjects(DatabaseHandlers.reserveringen.getResults());
        
    }
    
}
