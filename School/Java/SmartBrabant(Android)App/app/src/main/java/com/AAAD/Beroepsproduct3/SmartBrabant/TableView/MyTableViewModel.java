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

import android.icu.util.ICUUncheckedIOException;
import android.view.Gravity;

//import com.evrencoskun.tableviewsample2.data.database.entity.User;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Activiteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.IoTApparaat;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.CellModel;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.ColumnHeaderModel;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.model.RowHeaderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evrencoskun on 4.02.2018.
 */

public class MyTableViewModel {
    // View Types
    public static final int GENDER_TYPE = 1;
    public static final int MONEY_TYPE = 2;

    private List<ColumnHeaderModel> mColumnHeaderModelActiviteitenList, mColumnHeaderModelIoTList;
    private List<RowHeaderModel> mRowHeaderModelList, mRowHeaderModelActiviteitenList, mRowHeaderModelIoTList;
    private List<List<CellModel>> mCellModelList, mCellModelActiviteitenList, mCellModelIoTList;

    public int getCellItemViewType(int column) {

        switch (column) {
//            case 5:
//                // 5. column header is gender.
//                return GENDER_TYPE;
//            case 8:
//                // 8. column header is Salary.
//                return MONEY_TYPE;
            default:
                return 0;
        }
    }

     /*
       - Each of Column Header -
            "Id"
            "Name"
            "Nickname"
            "Email"
            "Birthday"
            "Gender"
            "Age"
            "Job"
            "Salary"
            "CreatedAt"
            "UpdatedAt"
            "Address"
            "Zip Code"
            "Phone"
            "Fax"
     */

    public int getColumnTextAlign(int column) {
        switch (column) {
            // Id
            case 0:
                return Gravity.CENTER;
            // Name
            case 1:
                return Gravity.LEFT;
            // Nickname
            case 2:
                return Gravity.LEFT;
            // Email
            case 3:
                return Gravity.LEFT;
            // BirthDay
            case 4:
                return Gravity.CENTER;
            // Gender (Sex)
            case 5:
                return Gravity.CENTER;
            // Age
            case 6:
                return Gravity.CENTER;
            // Job
            case 7:
                return Gravity.LEFT;
            // Salary
            case 8:
                return Gravity.CENTER;
            // CreatedAt
            case 9:
                return Gravity.CENTER;
            // UpdatedAt
            case 10:
                return Gravity.CENTER;
            // Address
            case 11:
                return Gravity.LEFT;
            // Zip Code
            case 12:
                return Gravity.RIGHT;
            // Phone
            case 13:
                return Gravity.RIGHT;
            // Fax
            case 14:
                return Gravity.RIGHT;
            default:
                return Gravity.CENTER;
        }

    }

    private List<ColumnHeaderModel> createColumnHeaderModelActiviteitenList() {
        List<ColumnHeaderModel> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeaderModel("Activiteitnummer"));
        list.add(new ColumnHeaderModel("Activiteitnaam"));
        list.add(new ColumnHeaderModel("Maatschappelijke factor"));
        list.add(new ColumnHeaderModel("Prioriteit"));
        list.add(new ColumnHeaderModel("Datasoort"));
        list.add(new ColumnHeaderModel("IoT-Apparaat"));
        list.add(new ColumnHeaderModel("IoT-Apparaatnummer"));
        return list;
    }

    private List<ColumnHeaderModel> createColumnHeaderModelIoTList() {
        List<ColumnHeaderModel> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeaderModel("IoT-Apparaatnummer"));
        list.add(new ColumnHeaderModel("IoT-Apparaatnaam"));
        list.add(new ColumnHeaderModel("Datasoort"));
        list.add(new ColumnHeaderModel("Activiteitnummer"));
        list.add(new ColumnHeaderModel("Activiteitnaam"));

        return list;
    }

    private List<List<CellModel>> createCellModelActiviteitenList(List<Activiteit> selectedList) {
        List<List<CellModel>> lists = new ArrayList<>();

        // Creating cell model list from User list for Cell Items
        // In this example, User list is populated from web service

        for (int i = 0; i < selectedList.size(); i++) {
            Activiteit huidigeActiviteit = selectedList.get(i);

            List<CellModel> currentlist = new ArrayList<>();

            // The order should be same with column header list;
            currentlist.add(new CellModel("1-" + i, huidigeActiviteit.getActiviteitNummer()));
            currentlist.add(new CellModel("2-" + i, huidigeActiviteit.getNaam()));
            currentlist.add(new CellModel("3-" + i, huidigeActiviteit.getMaatFactor()));
            currentlist.add(new CellModel("4-" + i, huidigeActiviteit.getPrioriteit()));
            currentlist.add(new CellModel("5-" + i, huidigeActiviteit.getDataSoort()));
            currentlist.add(new CellModel("6-" + i, huidigeActiviteit.getIoTNaam()));
            currentlist.add(new CellModel("7-" + i, huidigeActiviteit.getIoTNummer()));
            //list.add(new CellModel("2-" + i, user.name));        // "Id"
//            list.add(new CellModel("2-" + i, user.name));        // "Name"
//            list.add(new CellModel("3-" + i, user.nickname));    // "Nickname"
//            list.add(new CellModel("4-" + i, user.email));       // "Email"
//            list.add(new CellModel("5-" + i, user.birthdate));   // "BirthDay"
//            list.add(new CellModel("6-" + i, user.gender));      // "Gender"
//            list.add(new CellModel("7-" + i, user.age));         // "Age"
//            list.add(new CellModel("8-" + i, user.job));         // "Job"
//            list.add(new CellModel("9-" + i, user.salary));      // "Salary"
//            list.add(new CellModel("10-" + i, user.created_at)); // "CreatedAt"
//            list.add(new CellModel("11-" + i, user.updated_at)); // "UpdatedAt"
//            list.add(new CellModel("12-" + i, user.address));    // "Address"
//            list.add(new CellModel("13-" + i, user.zipcode));    // "Zip Code"
//            list.add(new CellModel("14-" + i, user.mobile));     // "Phone"
//            list.add(new CellModel("15-" + i, user.fax));        // "Fax"

            // Add
            lists.add(currentlist);
        }

        return lists;
    }

    private List<List<CellModel>> createCellModelIoTList(List<IoTApparaat> selectedList)
    {
        List<List<CellModel>> lists = new ArrayList<>();

        // Creating cell model list from User list for Cell Items
        // In this example, User list is populated from web service

        for (int i = 0; i < selectedList.size(); i++) {
            IoTApparaat huidigeIoTApparaat = selectedList.get(i);

            List<CellModel> currentlist = new ArrayList<>();

            // The order should be same with column header list;
            currentlist.add(new CellModel("1-" + i, huidigeIoTApparaat.getIoTnummer()));
            currentlist.add(new CellModel("2-" + i, huidigeIoTApparaat.getNaam()));
            currentlist.add(new CellModel("3-" + i, huidigeIoTApparaat.getDataSoort()));
            currentlist.add(new CellModel("4-" + i, huidigeIoTApparaat.getActiviteitNummer()));
            currentlist.add(new CellModel("5-" + i, huidigeIoTApparaat.getActiviteitNaam()));

            // Add
            lists.add(currentlist);
        }

        return lists;
    }

    private List<RowHeaderModel> createRowHeaderList(int size) {
        List<RowHeaderModel> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // In this example, Row headers just shows the index of the TableView List.
            list.add(new RowHeaderModel(String.valueOf(i + 1)));
        }
        return list;
    }


    public List<ColumnHeaderModel> getColumHeaderModelActiviteitenList() {
        return mColumnHeaderModelActiviteitenList;
    }

    public List<ColumnHeaderModel> getColumHeaderModelIoTList() {
        return mColumnHeaderModelIoTList;
    }

    public List<RowHeaderModel> getRowHeaderModelActiviteitenList() {
        return mRowHeaderModelActiviteitenList;
    }

    public List<RowHeaderModel> getRowHeaderModelIoTList() {
        return mRowHeaderModelIoTList;
    }

    public List<List<CellModel>> getCellModelActiviteitenList() {
        return mCellModelActiviteitenList;
    }

    public List<List<CellModel>> getCellModelIoTList() {
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

    public void generateListForTvActiviteit(List<Activiteit> activiteitList) {
        mColumnHeaderModelActiviteitenList = createColumnHeaderModelActiviteitenList();
        mCellModelActiviteitenList = createCellModelActiviteitenList(activiteitList);
        mRowHeaderModelActiviteitenList = createRowHeaderList(activiteitList.size());
    }

    public void generateListForTvIoTApparaat(List<IoTApparaat> entities) {
        mColumnHeaderModelIoTList = createColumnHeaderModelIoTList();
        mCellModelIoTList = createCellModelIoTList(entities);
        mRowHeaderModelIoTList = createRowHeaderList(entities.size());
    }

}



