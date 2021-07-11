package com.AAAD.Beroepsproduct3.SmartBrabant.TableView;

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
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Activiteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.IoTApparaat;
import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
//import com.evrencoskun.tableviewsample2.data.database.entity.User;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.holder.CellViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.holder.ColumnHeaderViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.holder.GenderCellViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.holder.MoneyCellViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.holder.RowHeaderViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.CellModel;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.ColumnHeaderModel;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.RowHeaderModel;

import java.util.List;

/**
 * Created by evrencoskun on 27.11.2017.
 */

//public class MyTableAdapter extends AbstractTableAdapter<ColumnHeaderModel, RowHeaderModel,
//        CellModel> {
//
//    private MyTableViewModel myTableViewModel;
//
//    public MyTableAdapter(Context p_jContext) {
//        super(p_jContext);
//
//        this.myTableViewModel = new MyTableViewModel();
//    }
//
//
//    @Override
//    public AbstractViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
//        View layout;
//
//        switch (viewType) {
//            case MyTableViewModel.GENDER_TYPE:
//                // Get gender cell xml Layout
//                layout = LayoutInflater.from(mContext).inflate(R.layout
//                        .tableview_gender_cell_layout, parent, false);
//
//                return new GenderCellViewHolder(layout);
//
//
//            case MyTableViewModel.MONEY_TYPE:
//                // Get money cell xml Layout
//                layout = LayoutInflater.from(mContext).inflate(R.layout
//                        .tableview_money_cell_layout, parent, false);
//
//                // Create the relevant view holder
//                return new MoneyCellViewHolder(layout);
//            default:
//                // Get default Cell xml Layout
//                layout = LayoutInflater.from(mContext).inflate(R.layout.tableview_cell_layout,
//                        parent, false);
//
//                // Create a Cell ViewHolder
//                return new CellViewHolder(layout);
//        }
//    }
//
//    @Override
//    public void onBindCellViewHolder(AbstractViewHolder holder, Object p_jValue, int
//            p_nXPosition, int p_nYPosition) {
//        CellModel cell = (CellModel) p_jValue;
//
//        if (holder instanceof CellViewHolder) {
//            // Get the holder to update cell item text
//            ((CellViewHolder) holder).setCellModel(cell, p_nXPosition);
//
//        } else if (holder instanceof GenderCellViewHolder) {
//            ((GenderCellViewHolder) holder).setCellModel(cell);
//        } else if (holder instanceof MoneyCellViewHolder) {
//            ((MoneyCellViewHolder) holder).setCellModel(cell);
//        }
//
//    }
//
//    @Override
//    public AbstractSorterViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {
//        View layout = LayoutInflater.from(mContext).inflate(R.layout
//                .tableview_column_header_layout, parent, false);
//
//        return new ColumnHeaderViewHolder(layout, getTableView());
//    }
//
//    @Override
//    public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, Object p_jValue, int
//            p_nXPosition) {
//        ColumnHeaderModel columnHeader = (ColumnHeaderModel) p_jValue;
//
//        // Get the holder to update cell item text
//        ColumnHeaderViewHolder columnHeaderViewHolder = (ColumnHeaderViewHolder) holder;
//
//        columnHeaderViewHolder.setColumnHeaderModel(columnHeader, p_nXPosition);
//    }
//
//    @Override
//    public AbstractViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {
//
//        // Get Row Header xml Layout
//        View layout = LayoutInflater.from(mContext).inflate(R.layout.tableview_row_header_layout,
//                parent, false);
//
//        // Create a Row Header ViewHolder
//        return new RowHeaderViewHolder(layout);
//    }
//
//    @Override
//    public void onBindRowHeaderViewHolder(AbstractViewHolder holder, Object p_jValue, int
//            p_nYPosition) {
//
//        RowHeaderModel rowHeaderModel = (RowHeaderModel) p_jValue;
//
//        RowHeaderViewHolder rowHeaderViewHolder = (RowHeaderViewHolder) holder;
//        rowHeaderViewHolder.row_header_textview.setText(rowHeaderModel.getData());
//
//    }
//
//    @Override
//    public View onCreateCornerView() {
//        return LayoutInflater.from(mContext).inflate(R.layout.tableview_corner_layout, null, false);
//    }
//
//    @Override
//    public int getColumnHeaderItemViewType(int position) {
//        return 0;
//    }
//
//    @Override
//    public int getRowHeaderItemViewType(int position) {
//        return 0;
//    }
//
//    @Override
//    public int getCellItemViewType(int position) {
//        return myTableViewModel.getCellItemViewType(position);
//    }
//
//}
