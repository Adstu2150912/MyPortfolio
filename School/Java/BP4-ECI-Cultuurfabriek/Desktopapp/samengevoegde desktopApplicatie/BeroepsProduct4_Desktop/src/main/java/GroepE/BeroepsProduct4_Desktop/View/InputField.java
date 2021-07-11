/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroepE.BeroepsProduct4_Desktop.View;

import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author swkoe
 */
public class InputField extends GridPane
{
    private Text txt_label;
    private TextField txf_input;

    public void setLabel(String sOutput)
    {
        txt_label.setText(sOutput);
    }

    public void setText(String sOutput)
    {
        txf_input.setText(sOutput);
    }

    public String getText()
    {
        return txf_input.getText();
    }


    public InputField refresh()
    {
        this.getChildren().removeAll();

        try
        {
            txt_label.prefWidth(this.getParent().getScaleX() * 0.5);
            txf_input.prefWidth(this.getParent().getScaleX() * 0.5);
        }
        catch (Exception ex)
        {

        }

        this.add(txt_label, 0, 0);
        this.add(txf_input, 1, 0);
        return this;
    }

    public InputField(String labelText, String fieldOutput)
    {
        txt_label = new Text();
        txf_input = new TextField();

        txt_label.setTextAlignment(TextAlignment.JUSTIFY);
        txt_label.setStyle("-fx-font-size: 16px");

        this.setLabel(labelText);
        this.setText(fieldOutput);

        this.add(txt_label, 0, 0);
        this.add(txf_input, 1, 0);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        this.getColumnConstraints().addAll(col1, col2);
    }
}
