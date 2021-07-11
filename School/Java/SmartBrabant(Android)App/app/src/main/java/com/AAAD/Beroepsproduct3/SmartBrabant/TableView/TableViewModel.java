package com.AAAD.Beroepsproduct3.SmartBrabant.TableView;

/*
 * Copyright (c) 2018. Evren Coşkun
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Activiteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.IoTApparaat;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.Cell;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.CellModel;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.ColumnHeader;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.ColumnHeaderModel;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.RowHeader;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by evrencoskun on 4.02.2018.
 */

public class TableViewModel {

    private static List<ColumnHeader> mColumnHeaderModelActiviteitenList, mColumnHeaderModelIoTList;
    private static List<RowHeader> mRowHeaderModelList, mRowHeaderModelActiviteitenList, mRowHeaderModelIoTList;
    private static List<List<Cell>> mCellModelList, mCellModelActiviteitenList, mCellModelIoTList;

    // Columns indexes
    public static final int MOOD_COLUMN_INDEX = 3;
    public static final int GENDER_COLUMN_INDEX = 4;

    // Constant values for icons
    public static final int SAD = 1;
    public static final int HAPPY = 2;
    public static final int BOY = 1;
    public static final int GIRL = 2;

    // Constant size for dummy data sets
    private static final int COLUMN_SIZE = 500;
    private static final int ROW_SIZE = 500;

    // Drawables
    @DrawableRes
    private final int mBoyDrawable;
    @DrawableRes
    private final int mGirlDrawable;
    @DrawableRes
    private final int mHappyDrawable;
    @DrawableRes
    private final int mSadDrawable;

    public TableViewModel() {
        // initialize drawables
        mBoyDrawable = R.drawable.ic_male;
        mGirlDrawable = R.drawable.ic_female;
        mHappyDrawable = R.drawable.ic_happy;
        mSadDrawable = R.drawable.ic_sad;
    }

    @NonNull
    private List<RowHeader> getSimpleRowHeaderList() {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            RowHeader header = new RowHeader(String.valueOf(i), "row " + i);
            list.add(header);
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    @NonNull
    private List<ColumnHeader> getRandomColumnHeaderList() {
        List<ColumnHeader> list = new ArrayList<>();

        for (int i = 0; i < COLUMN_SIZE; i++) {
            String title = "column " + i;
            int nRandom = new Random().nextInt();
            if (nRandom % 4 == 0 || nRandom % 3 == 0 || nRandom == i) {
                title = "large column " + i;
            }

            ColumnHeader header = new ColumnHeader(String.valueOf(i), title);
            list.add(header);
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    @NonNull
    private List<List<Cell>> getCellListForSortingTest() {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            List<Cell> cellList = new ArrayList<>();
            for (int j = 0; j < COLUMN_SIZE; j++) {
                Object text = "cell " + j + " " + i;

                final int random = new Random().nextInt();
                if (j == 0) {
                    text = i;
                } else if (j == 1) {
                    text = random;
                } else if (j == MOOD_COLUMN_INDEX) {
                    text = random % 2 == 0 ? HAPPY : SAD;
                } else if (j == GENDER_COLUMN_INDEX) {
                    text = random % 2 == 0 ? BOY : GIRL;
                }

                // Create dummy id.
                String id = j + "-" + i;

                Cell cell;
                if (j == 3) {
                    cell = new Cell(id, text);
                } else if (j == 4) {
                    // NOTE female and male keywords for filter will have conflict since "female"
                    // contains "male"
                    cell = new Cell(id, text);
                } else {
                    cell = new Cell(id, text);
                }
                cellList.add(cell);
            }
            list.add(cellList);
        }

        return list;
    }

    @DrawableRes
    public int getDrawable(int value, boolean isGender) {
        if (isGender) {
            return value == BOY ? mBoyDrawable : mGirlDrawable;
        } else {
            return value == SAD ? mSadDrawable : mHappyDrawable;
        }
    }

    @NonNull
    public List<List<Cell>> getCellList() {
        return getCellListForSortingTest();
    }

    @NonNull
    public List<RowHeader> getRowHeaderList() {
        return getSimpleRowHeaderList();
    }

    @NonNull
    public List<ColumnHeader> getColumnHeaderList() {
        return getRandomColumnHeaderList();
    }

    private static List<ColumnHeader> createColumnHeaderModelActiviteitenList() {
        List<ColumnHeader> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeader("1", "Activiteitnummer"));
        list.add(new ColumnHeader("2", "Activiteitnaam"));
        list.add(new ColumnHeader("3","Maatschappelijke factor"));
        list.add(new ColumnHeader("4", "Prioriteit"));
        list.add(new ColumnHeader("5","Datasoort"));
        list.add(new ColumnHeader("6","IoT-Apparaat"));
        list.add(new ColumnHeader("7","IoT-Apparaatnummer"));
        return list;
    }

    private static List<ColumnHeader> createColumnHeaderModelIoTList() {
        List<ColumnHeader> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeader("1", "IoT-Apparaatnummer"));
        list.add(new ColumnHeader("2", "IoT-Apparaatnaam"));
        list.add(new ColumnHeader("3", "Datasoort"));
        list.add(new ColumnHeader("4", "Activiteitnummer"));
        list.add(new ColumnHeader("5", "Activiteitnaam"));

        return list;
    }

    private static List<List<Cell>> createCellModelActiviteitenList(List<Activiteit> selectedList) {
        List<List<Cell>> lists = new ArrayList<>();

        // Creating cell model list from User list for Cell Items
        // In this example, User list is populated from web service

        for (int i = 0; i < selectedList.size(); i++) {
            Activiteit huidigeActiviteit = selectedList.get(i);

            List<Cell> currentlist = new ArrayList<>();

            // The order should be same with column header list;
            currentlist.add(new Cell("1-" + i, huidigeActiviteit.getActiviteitNummer()));
            currentlist.add(new Cell("2-" + i, huidigeActiviteit.getNaam()));
            currentlist.add(new Cell("3-" + i, huidigeActiviteit.getMaatFactor()));
            currentlist.add(new Cell("4-" + i, huidigeActiviteit.getPrioriteit()));
            currentlist.add(new Cell("5-" + i, huidigeActiviteit.getDataSoort()));
            currentlist.add(new Cell("6-" + i, huidigeActiviteit.getIoTNaam()));
            currentlist.add(new Cell("7-" + i, huidigeActiviteit.getIoTNummer()));

            lists.add(currentlist);
        }

        return lists;
    }

    private static List<List<Cell>> createCellModelIoTList(List<IoTApparaat> selectedList)
    {
        List<List<Cell>> lists = new ArrayList<>();

        // Creating cell model list from User list for Cell Items
        // In this example, User list is populated from web service

        for (int i = 0; i < selectedList.size(); i++) {
            IoTApparaat huidigeIoTApparaat = selectedList.get(i);

            List<Cell> currentlist = new ArrayList<>();

            // The order should be same with column header list;
            currentlist.add(new Cell("1-" + i, huidigeIoTApparaat.getIoTnummer()));
            currentlist.add(new Cell("2-" + i, huidigeIoTApparaat.getNaam()));
            currentlist.add(new Cell("3-" + i, huidigeIoTApparaat.getDataSoort()));
            currentlist.add(new Cell("4-" + i, huidigeIoTApparaat.getActiviteitNummer()));
            currentlist.add(new Cell("5-" + i, huidigeIoTApparaat.getActiviteitNaam()));

            // Add
            lists.add(currentlist);
        }

        return lists;
    }

    private static List<RowHeader> createRowHeaderList(int size) {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // In this example, Row headers just shows the index of the TableView List.
            list.add(new RowHeader(Integer.toString(i), String.valueOf(i + 1)));
        }
        return list;
    }


    public static List<ColumnHeader> getColumHeaderModelActiviteitenList() {
        return mColumnHeaderModelActiviteitenList;
    }

    public static List<ColumnHeader> getColumHeaderModelIoTList() {
        return mColumnHeaderModelIoTList;
    }

    public static List<RowHeader> getRowHeaderModelActiviteitenList() {
        return mRowHeaderModelActiviteitenList;
    }

    public static List<RowHeader> getRowHeaderModelIoTList() {
        return mRowHeaderModelIoTList;
    }

    public static List<List<Cell>> getCellModelActiviteitenList() {
        return mCellModelActiviteitenList;
    }

    public static List<List<Cell>> getCellModelIoTList() {
        return mCellModelIoTList;
    }


//    public void generateListForTableView(List<User> users) {
//        mColumnHeaderModelList = createColumnHeaderModelList();
//        mCellModelList = createCellModelList(users);
//        mRowHeaderModelList = createRowHeaderList(users.size());
//    }

//    public void generateListForTvPlaats(List<String> users) {
//        mColumnHeaderModelActiviteitenList = createColumnHeaderModelList();
//        mCellModelList = createCellModelList(users);
//        mRowHeaderModelList = createRowHeaderList(users.size());
//    }

    public static void generateListForTvActiviteit(List<Activiteit> activiteitList) {
        mColumnHeaderModelActiviteitenList = createColumnHeaderModelActiviteitenList();
        mCellModelActiviteitenList = createCellModelActiviteitenList(activiteitList);
        mRowHeaderModelActiviteitenList = createRowHeaderList(activiteitList.size());
    }

    public static void generateListForTvIoTApparaat(List<IoTApparaat> iotList) {
        mColumnHeaderModelIoTList = createColumnHeaderModelIoTList();
        mCellModelIoTList = createCellModelIoTList(iotList);
        mRowHeaderModelIoTList = createRowHeaderList(iotList.size());
    }
}
