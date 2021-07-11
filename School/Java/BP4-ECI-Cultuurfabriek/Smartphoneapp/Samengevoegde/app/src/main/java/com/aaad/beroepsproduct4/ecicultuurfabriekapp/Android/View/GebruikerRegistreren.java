package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB.DatabaseHandlers;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.KlantInfo;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.MainActivity;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Event;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Gebruiker;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Klantinlog;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.R;

import java.sql.Date;

public class GebruikerRegistreren extends AppCompatActivity {

    boolean lUpdate = false;

    public void btn_gebruikerResClick()
    {
        if(lUpdate)
            btn_bewerken();
        else
            btn_registreren();
    }

    public void btn_registreren()
    {
        String email            = ((EditText) findViewById(R.id.txf_regEmail)).getText().toString();
        String inlognaam        = ((EditText) findViewById(R.id.txf_regInlognaam)).getText().toString();
        String wachtwoord       = ((EditText) findViewById(R.id.txf_regWachtwoord)).getText().toString();
        String voornaam         = ((EditText) findViewById(R.id.txf_regVoornaam)).getText().toString();
        String achternaam       = ((EditText) findViewById(R.id.txf_regAchternaam)).getText().toString();
        String voorletters      = ((EditText) findViewById(R.id.txf_regVoorletters)).getText().toString();
        String geslacht         = ((EditText) findViewById(R.id.txf_regGeslacht)).getText().toString();
        String geboortedatum    = ((EditText) findViewById(R.id.txf_regGeboortedtm)).getText().toString();
        String plaats           = ((EditText) findViewById(R.id.txf_regPlaats)).getText().toString();
        String straatnaam       = ((EditText) findViewById(R.id.txf_regStraatnaam)).getText().toString();
        String huisnummer       = ((EditText) findViewById(R.id.txf_regtxf_regHuisnr)).getText().toString();
        String tel              = ((EditText) findViewById(R.id.txf_regTel)).getText().toString();
        String iban             = ((EditText) findViewById(R.id.txf_regIban)).getText().toString();

        int nDay    = 1;
        int nMonth  = 1;
        int nYear   = 2001;

        if
        (
                geboortedatum.split("-").length >= 3 ||
                        geboortedatum.split("/").length >= 3 ||
                        geboortedatum.split(" ").length >= 3
        )
        {
            String[] args;
            if(geboortedatum.contains("-"))
            {
                args = geboortedatum.split("-");
            }
            else if(geboortedatum.contains("/"))
            {
                args = geboortedatum.split("/");
            }
            else if(geboortedatum.contains(" "))
            {
                args = geboortedatum.split(" ");
            }
            else
            {
                args = new String[]{"1", "1", "2001"};
            }
            nYear = Integer.parseInt(args[2]);
            nMonth = Integer.parseInt(args[1]);
            nDay = Integer.parseInt(args[0]);
        }


        Klantinlog insertInlog    = new Klantinlog(email, inlognaam, wachtwoord);
        Gebruiker insertGebruiker = new Gebruiker(email, voornaam, achternaam, voorletters, geslacht, new Date(nYear, nMonth, nDay), plaats, straatnaam, huisnummer, tel, iban);

        // database insert
        // login
        // go to main

        DatabaseHandlers.dbKlantInlog.insertDataIntoTable(insertInlog);
        DatabaseHandlers.dbGebruiker.insertDataIntoTable(insertGebruiker);

        KlantInfo.logindata = insertInlog;
        KlantInfo.gebruiker = insertGebruiker;

        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }

    public void btn_bewerken()
    {
        String email            = ((EditText) findViewById(R.id.txf_regEmail)).getText().toString();
        String inlognaam        = ((EditText) findViewById(R.id.txf_regInlognaam)).getText().toString();
        String wachtwoord       = ((EditText) findViewById(R.id.txf_regWachtwoord)).getText().toString();
        String voornaam         = ((EditText) findViewById(R.id.txf_regVoornaam)).getText().toString();
        String achternaam       = ((EditText) findViewById(R.id.txf_regAchternaam)).getText().toString();
        String voorletters      = ((EditText) findViewById(R.id.txf_regVoorletters)).getText().toString();
        String geslacht         = ((EditText) findViewById(R.id.txf_regGeslacht)).getText().toString();
        String geboortedatum    = ((EditText) findViewById(R.id.txf_regGeboortedtm)).getText().toString();
        String plaats           = ((EditText) findViewById(R.id.txf_regPlaats)).getText().toString();
        String straatnaam       = ((EditText) findViewById(R.id.txf_regStraatnaam)).getText().toString();
        String huisnummer       = ((EditText) findViewById(R.id.txf_regtxf_regHuisnr)).getText().toString();
        String tel              = ((EditText) findViewById(R.id.txf_regTel)).getText().toString();
        String iban             = ((EditText) findViewById(R.id.txf_regIban)).getText().toString();

        int nDay    = 1;
        int nMonth  = 1;
        int nYear   = 2001;

        if
        (
                geboortedatum.split("-").length >= 3 ||
                geboortedatum.split("/").length >= 3 ||
                geboortedatum.split(" ").length >= 3
        )
        {
            String[] args;
            if(geboortedatum.contains("-"))
            {
                args = geboortedatum.split("-");
            }
            else if(geboortedatum.contains("/"))
            {
                args = geboortedatum.split("/");
            }
            else if(geboortedatum.contains(" "))
            {
                args = geboortedatum.split(" ");
            }
            else
            {
                args = new String[]{"1", "1", "2001"};
            }
            nYear = Integer.parseInt(args[2]);
            nMonth = Integer.parseInt(args[1]);
            nDay = Integer.parseInt(args[0]);
        }


        Klantinlog updateInlog    = new Klantinlog(email, inlognaam, wachtwoord);
        Gebruiker updateGebruiker = new Gebruiker(email, voornaam, achternaam, voorletters, geslacht, new Date(nYear, nMonth, nDay), plaats, straatnaam, huisnummer, tel, iban);

        // sql update
//        KlantInfo.logindata = updateInlog;
//        KlantInfo.gebruiker = updateGebruiker;

        DatabaseHandlers.dbKlantInlog.UpdateDataIntoTable(KlantInfo.logindata, updateInlog);
        DatabaseHandlers.dbGebruiker.UpdateDataIntoTable(KlantInfo.gebruiker, updateGebruiker);

        KlantInfo.logindata = updateInlog;
        KlantInfo.gebruiker = updateGebruiker;

        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebruikerregistreren);
        this.lUpdate = this.getIntent().getBooleanExtra("update", false);

        Button btn = ((Button) findViewById(R.id.btn_regAction));
        btn.setOnClickListener(Event -> btn_gebruikerResClick());
    }
}
