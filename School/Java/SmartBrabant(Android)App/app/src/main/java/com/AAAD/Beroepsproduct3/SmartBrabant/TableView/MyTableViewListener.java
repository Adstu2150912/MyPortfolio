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
 * */
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.listener.ITableViewListener;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.holder.ColumnHeaderViewHolder;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.popup.ColumnHeaderLongPressPopup;

/**
 * Created by evrencoskun on 2.12.2017.
 */

//public class MyTableViewListener implements ITableViewListener {
//    private static final String LOG_TAG = MyTableViewListener.class.getSimpleName();
//
//    private ITableView mTableView;
//
//    public MyTableViewListener(ITableView pTableView) {
//        this.mTableView = pTableView;
//    }
//
//    @Override
//    public void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {
//        Log.d(LOG_TAG, "onCellClicked has been clicked for x= " + column + " y= " + row);
//    }
//
//    @Override
//    public void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {
//        Log.d(LOG_TAG, "onCellLongPressed has been clicked for " + row);
//    }
//
//    @Override
//    public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int
//            column) {
//        Log.d(LOG_TAG, "onColumnHeaderClicked has been clicked for " + column);
//    }
//
//    @Override
//    public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int
//            column) {
//        if (columnHeaderView != null && columnHeaderView instanceof ColumnHeaderViewHolder) {
//
//            // Create Long Press Popup
//            ColumnHeaderLongPressPopup popup = new ColumnHeaderLongPressPopup(
//                    (ColumnHeaderViewHolder) columnHeaderView, mTableView);
//
//            // Show
//            popup.show();
//        }
//    }
//
//    @Override
//    public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {
//        Log.d(LOG_TAG, "onRowHeaderClicked has been clicked for " + row);
//    }
//
//    @Override
//    public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder owHeaderView, int row) {
//        Log.d(LOG_TAG, "onRowHeaderLongPressed has been clicked for " + row);
//    }
//}
