package com.AAAD.Beroepsproduct3.SmartBrabant.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.AAAD.Beroepsproduct3.SmartBrabant.Model.Plaats;
import com.AAAD.Beroepsproduct3.SmartBrabant.View.HomeActivity;

public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener
{
    Context huidigeContext;
    Plaats selectedPlaats;
    Button btnGOTO;
    public SpinnerActivity(Spinner spinner, Context context, Button button)
    {
        this.huidigeContext = context;
        this.btnGOTO = button;
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id)
    {
//        // An item was selected. You can retrieve the selected item using
//        if(huidigeContext.getClass().getSimpleName() == "MainActivity")
//        {
//            Plaats selectedPlaats = (Plaats) parent.getItemAtPosition(pos);
//            if(selectedPlaats != null)
//            {
//                Intent i = new Intent(view.getContext(), HomeActivity.class);
//                startActivity(i);
//            }
//        }
    }

    public void onNothingSelected(AdapterView<?> parent)
    {
        // Another interface callback
    }

}
