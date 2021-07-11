package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.KlantInfo;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Gebruiker;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.Klantinlog;
import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.R;

public class GebruikerInzien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebruikerinzien);
        TextView txtEmail       = ((TextView) findViewById(R.id.txt_infoEmail));
        TextView txtInlognm     = ((TextView) findViewById(R.id.txt_infoInlognaam));
        TextView txtWachtw      = ((TextView) findViewById(R.id.txt_infoWachtwoord));
        TextView txtVoornm      = ((TextView) findViewById(R.id.txt_infoVoornaam));
        TextView txtAchternm    = ((TextView) findViewById(R.id.txt_infoAchternaam));
        TextView txtVoorltrs    = ((TextView) findViewById(R.id.txt_infoVoorletters));
        TextView txtGeslacht    = ((TextView) findViewById(R.id.txt_infoGeslacht));
        TextView txtGeboortedtm = ((TextView) findViewById(R.id.txt_infoGeboortedtm));
        TextView txtPlaats      = ((TextView) findViewById(R.id.txt_infoPlaats));
        TextView txtStrnm       = ((TextView) findViewById(R.id.txt_infoStraatnaam));
        TextView txtHuisnr      = ((TextView) findViewById(R.id.txt_infoHuisnummer));
        TextView txtTel         = ((TextView) findViewById(R.id.txt_infoTel));
        TextView txtIban        = ((TextView) findViewById(R.id.txt_infoIban));

        Klantinlog holderLogin = KlantInfo.logindata;
        Gebruiker holderKlant = KlantInfo.gebruiker;

        txtEmail.setText(holderKlant.getsEmail());
        txtInlognm.setText(holderLogin.getsInlognaam());
        txtWachtw.setText(holderLogin.getsWachtwoord());
        txtVoornm.setText(holderKlant.getsVoornaam());
        txtAchternm.setText(holderKlant.getsAchternaam());
        txtVoorltrs.setText(holderKlant.getsVoorletters());
        txtGeslacht.setText(holderKlant.getsGeslacht());
        txtGeboortedtm.setText(holderKlant.getGeboorteDatum().toString());
        txtPlaats.setText(holderKlant.getsPlaats());
        txtStrnm.setText(holderKlant.getsStraatNaam());
        txtHuisnr.setText(holderKlant.getsHuisnummer());
        txtTel.setText(holderKlant.getsTelefoonnummer());
        txtIban.setText(holderKlant.getsIbanNummer());
    }
}
