/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import GroepE.BeroepsProduct4_Desktop.StandardDebugActions;
import java.util.ArrayList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

/**
 *
 * @author swkoe
 */
public class CustomMenuBar extends Pane
{
    private MenuBar menuBar = new MenuBar();
    private ArrayList<Menu> menus = new ArrayList<>();

    public Menu selectMenu(String sSelected)
    {
        for(Menu toCheck : menus)
        {
            if(toCheck.getText().equalsIgnoreCase(sSelected))
            {
                return toCheck;
            }
        }
        return null;
    }

    public void removeMenu(String toRemove)
    {
        Menu exist = selectMenu(toRemove);
        if(exist != null)  menus.remove(exist);
    }

    public void removeMenu(Menu toRemove)
    {
        Menu exist = selectMenu(toRemove.getText());
        if(exist != null)  menus.remove(exist);
    }


    public void addMenu(Menu toAdd)
    {
        Menu exist = selectMenu(toAdd.getText());
        if(exist != null)
        {
            for(int i = 0; i < menus.toArray().length;i++)
            {
                if(menus.get(i).equals(exist))
                {
                    menus.set(i, toAdd);
                }
            }
        }
        else
        {
            menus.add(toAdd);
        }
    }

    public MenuItem getMenuItem(Menu getLocation, String toGet)
    {
        for(MenuItem toCheck : getLocation.getItems())
        {
            if(toCheck.getText().equalsIgnoreCase(toGet)) return toCheck;
        }
        return null;
    }

    public void removeMenuItem(String menu, String item)
    {
        Menu selectedMenu = selectMenu(menu);
        MenuItem selectedItem = getMenuItem(selectedMenu, item);

        selectedMenu.getItems().remove(selectedItem);
        addMenu(selectedMenu);
    }

    public void addMenuItem(String toAddTo, MenuItem toAdd)
    {
        Menu existingMenu = this.selectMenu(toAddTo);
        if(existingMenu != null)
        {
            MenuItem existingItem = getMenuItem(existingMenu, toAdd.getText());
            if(existingItem != null)
            {
                for(int i = 0; i < existingMenu.getItems().size();i++)
                {
                    if(existingMenu.getItems().get(i).equals(existingItem))
                    {
                        existingMenu.getItems().set(i, toAdd);
                    }
                }
            }
            else
            {
                existingMenu.getItems().add(toAdd);
            }
            this.addMenu(existingMenu);
            StandardDebugActions.println("succesfull add to Existing menu");
        }
        else
        {
            StandardDebugActions.println("failed, menu not exist");
        }
    }


    public CustomMenuBar build()
    {
//        menuBar
        this.getChildren().remove(menuBar);
        menuBar.getMenus().clear();

        for(Menu instance : menus)
        {
            menuBar.getMenus().add(instance);
        }

        this.getChildren().add(menuBar);
        menuBar.prefWidthProperty().bind(this.widthProperty());
        menuBar.setStyle("-fx-background-color: yellow;");
        return this;
    }


    public CustomMenuBar()
    {
        menuBar.prefWidthProperty().bind(this.widthProperty());
        menuBar.setStyle("-fx-background-color: yellow;");
        this.getChildren().add(menuBar);
    }
}
