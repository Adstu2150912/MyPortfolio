package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Activiteit;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.IoTApparaat;
import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.R;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.TableViewAdapter;
import com.AAAD.Beroepsproduct3.SmartBrabant.TableView.TableViewListener;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.TableViewController;
import com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel.VMDBFunctionaliteit;
import com.evrencoskun.tableview.TableView;

import java.io.Serializable;

public class IoT_ActiviteitFragment extends Fragment
{
    private Plaats huidigePlaats;
    private TableView mTableView, mTableView2;
    private TableViewController mTableAdapter, mTableAdapter2;
    private ProgressBar mProgressBar, mProgressBar2;
    private VMDBFunctionaliteit dbFunctionaliteit = new VMDBFunctionaliteit();

    public IoT_ActiviteitFragment() {} // Vereiste lege openbare constructor
    public IoT_ActiviteitFragment(Plaats selectedPlaats)
    {
        this.huidigePlaats = selectedPlaats;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iot_activiteit, container, false);

        RelativeLayout relativeLayout = view.findViewById(R.id.tabellenVenster);
        TextView tvinformNoData = view.findViewById(R.id.tvInfoNoData);

        mTableView = (TableView) view.findViewById(R.id.tvActiviteit);
        mTableView2 = (TableView) view.findViewById(R.id.tvIoTApparaat);

        mTableAdapter = new TableViewController();
        mTableView.setAdapter(mTableAdapter);

        mTableView.setTableViewListener(new TableViewListener(mTableView));

        ObservableList<Activiteit> selectedActiviteitList = dbFunctionaliteit.getActivityDataFromVM(view.getContext(), huidigePlaats);
        if(selectedActiviteitList != null)
            if(selectedActiviteitList.size() > 0)
                mTableAdapter.setActiviteitenLijst(selectedActiviteitList);
            else
                mTableView.setVisibility(View.INVISIBLE);
        else
            mTableView.setVisibility(View.INVISIBLE);

        mTableAdapter2 = new TableViewController();
        mTableView2.setAdapter(mTableAdapter2);

        mTableView2.setTableViewListener(new TableViewListener(mTableView2));

        ObservableList<IoTApparaat> selectedIoTList = dbFunctionaliteit.getIoTDataFromVM(view.getContext(), huidigePlaats);
        if(selectedIoTList != null)
            if(selectedIoTList.size() > 0)
                mTableAdapter2.setIoTLijst(selectedIoTList);
            else
                mTableView2.setVisibility(View.INVISIBLE);
        else
            mTableView2.setVisibility(View.INVISIBLE);

        if(mTableView.getVisibility() == View.INVISIBLE && mTableView2.getVisibility() == View.INVISIBLE)
        {
            tvinformNoData.setText("Momenteel is er geen data beschikbaar over de IoT-apparatuur en activiteiten binnen " + huidigePlaats.getNaam() + ". Excuses voor het ongemak.");
            relativeLayout.setVisibility(View.INVISIBLE);
            tvinformNoData.setVisibility(View.VISIBLE);
        }
        else
            relativeLayout.setVisibility(View.VISIBLE);

        return view;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
//    {
//
//    }
}
