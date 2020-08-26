package com.AAAD.Beroepsproduct3.SmartBrabant.TableView.holder;
/**
 * Copyright (c) 2017 Evren Coşkun
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * */
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.CellModel;
import org.fabiomsr.moneytextview.MoneyTextView;

/**
 * Created by evrencoskun on 22.12.2017.
 */

public class MoneyCellViewHolder extends AbstractViewHolder {
    public final MoneyTextView cell_textview;
    public final LinearLayout cell_container;

    public MoneyCellViewHolder(View itemView) {
        super(itemView);
        cell_textview = itemView.findViewById(R.id.money_cell_data);
        cell_container = itemView.findViewById(R.id.cell_container);
    }

    public void setCellModel(CellModel p_jModel) {

        // Set text
        cell_textview.setAmount(Float.parseFloat((String) p_jModel.getData()));

        // It is necessary to remeasure itself.
        cell_container.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        cell_textview.requestLayout();
    }

    @Override
    public void setSelected(SelectionState p_nSelectionState) {
        super.setSelected(p_nSelectionState);

        if (p_nSelectionState == SelectionState.SELECTED) {
            changeColorOfMoneyTextView(R.color.selected_text_color);
        } else {
            changeColorOfMoneyTextView(R.color.unselected_text_color);
        }
    }

    private void changeColorOfMoneyTextView(@ColorRes int id) {
        int color = ContextCompat.getColor(cell_textview.getContext(), id);

        cell_textview.setBaseColor(color);
        cell_textview.setDecimalsColor(color);
        cell_textview.setSymbolColor(color);
    }
}
