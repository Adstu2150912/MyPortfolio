package GroepE.BeroepsProduct4_Desktop.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GroepE.BeroepsProduct4_Desktop.DataTypes.Gebruiker;
import GroepE.BeroepsProduct4_Desktop.DataTypes.Klantinlog;
import GroepE.BeroepsProduct4_Desktop.DatabaseHandlers;
import java.sql.Date;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author swkoe
 */
public class GebruikerReg extends GridPane
{
    private Gebruiker original;
    private Gebruiker update;
    
    private Klantinlog originalInlog;
    private Klantinlog updateInlog;
    
    private GridPane forum;
    private GridPane ButtonControlPannel;

    private Button btn_updateUser ;//= new Button();
    private Button btn_deleteUser ;//= new Button();
    private Button btn_insertUser ;//= new Button();
    private Button btn_refreshUser;//= new Button();

    private InputField Email            = new InputField("Email",         "");
    private InputField gebruikersNaam   = new InputField("Inlognaam",      "");
    private InputField wachtwoord       = new InputField("Password",      "");
    private InputField voornaam         = new InputField("Voornaam",      "");
    private InputField achternaam       = new InputField("Achternaam",    "");
    private InputField voorletters      = new InputField("voorletters",   "");
    private InputField geslacht         = new InputField("geslacht",      "");
    private InputField geboortedatum    = new InputField("geboortedatum", "");
    private InputField plaats           = new InputField("plaats",        "");
    private InputField straatnaam       = new InputField("straatnaam",    "");
    private InputField huisnummer       = new InputField("huisnummer",    "");
    private InputField telefoonnummer   = new InputField("tel",           "");
    private InputField ibannummer       = new InputField("iban",          "");


    private void CreateUpdateUser()
    {
        String sEmail            = Email.getText();
        String sGebruikersnaam   = gebruikersNaam.getText();
        String sWachtwoord       = wachtwoord.getText();
        String sVoornaam         = voornaam.getText();
        String sAchternaam       = achternaam.getText();
        String sVoorletters      = voorletters.getText();
        String sGeslacht         = geslacht.getText();
        String sGeboortedatum    = geboortedatum.getText();
        String sPlaats           = plaats.getText();
        String sStraatnaam       = straatnaam.getText();
        String sHuisnummer       = huisnummer.getText();
        String sTelefoonnummer   = telefoonnummer.getText();
        String sIbannummer       = ibannummer.getText();
        
        int nDay    = 1;
        int nMonth  = 1;
        int nYear   = 2001;
        
        if(sGeboortedatum.contains("-") && sGeboortedatum.split("-").length >= 3)
        {
            String[] args = sGeboortedatum.split("-");
            
            nYear = Integer.parseInt(args[0]);
            nMonth = Integer.parseInt(args[1]);
            nDay = Integer.parseInt(args[2]);
        }
        else if(sGeboortedatum.contains("/") && sGeboortedatum.split("/").length >= 3)
        {
            String[] args = sGeboortedatum.split("/");
            
            nYear = Integer.parseInt(args[0]);
            nMonth = Integer.parseInt(args[1]);
            nDay = Integer.parseInt(args[2]);
        }
        else if(sGeboortedatum.contains(" ") && sGeboortedatum.split(" ").length >= 3)
        {
            String[] args = sGeboortedatum.split(" ");
            
            nYear = Integer.parseInt(args[0]);
            nMonth = Integer.parseInt(args[1]);
            nDay = Integer.parseInt(args[2]);
        }
        
        
        update          = new Gebruiker(sEmail, sVoornaam, sAchternaam, sVoorletters, sGeslacht, new Date(nYear, nMonth, nDay), sPlaats, sStraatnaam, sHuisnummer, sTelefoonnummer, sIbannummer);
        updateInlog     = new Klantinlog(sEmail, sGebruikersnaam, sWachtwoord);
        
        
    }
    
    public void btn_updateUser()
    {
        CreateUpdateUser();
        if(original != null)
        {
            DatabaseHandlers.emails.insertDataIntoTable(update.getsEmail());
            DatabaseHandlers.gebruikers.UpdateDataIntoTable(original, update);
            DatabaseHandlers.dbKlantinlog.UpdateDataIntoTable(originalInlog, updateInlog);
            
            DatabaseHandlers.emails.deleteSpecificData(original.getsEmail());
        }
    }

    public void btn_deleteUser()
    {
        CreateUpdateUser();
        if(original != null)
        {
            DatabaseHandlers.gebruikers.deleteSpecificData(original);
            DatabaseHandlers.dbKlantinlog.deleteSpecificData(originalInlog);
            DatabaseHandlers.emails.deleteSpecificData(original.getsEmail());
        }
    }

    public void btn_insertUser()
    {
        CreateUpdateUser();
        DatabaseHandlers.emails.insertDataIntoTable(update.getsEmail());
        DatabaseHandlers.gebruikers.insertDataIntoTable(update);
        DatabaseHandlers.dbKlantinlog.insertDataIntoTable(updateInlog);
    }

    public void btn_refreshUser()
    {
        setGebruiker();
    }

    public void setGebruiker()
    {
        if(original == null) return;
        Email.setText(original.getsEmail());
        voornaam.setText(original.getsVoornaam());
        achternaam.setText(original.getsAchternaam());
        voorletters.setText(original.getsVoorletters());
        geslacht.setText(original.getsGeslacht());
        geboortedatum.setText(original.getGeboorteDatum().toString());
        plaats.setText(original.getsPlaats());
        straatnaam.setText(original.getsStraatNaam());
        huisnummer.setText(original.getsHuisnummer());
        telefoonnummer.setText(original.getsTelefoonnummer());
        ibannummer.setText(original.getsIbanNummer());
        
        if(originalInlog == null) return;
        gebruikersNaam.setText(originalInlog.getsInlognaam());
        wachtwoord.setText(originalInlog.getsWachtwoord());
    }


    public void buildForum()
    {
        forum = new GridPane();
        forum.add(Email, 0, 0);
        forum.add(gebruikersNaam, 0, 1);
        forum.add(wachtwoord, 0, 2);
        forum.add(voornaam, 0, 3);
        forum.add(achternaam, 0, 4);
        forum.add(voorletters, 0, 5);
        forum.add(geslacht, 0, 6);
        forum.add(geboortedatum, 0, 7);
        forum.add(plaats, 0, 8);
        forum.add(straatnaam, 0, 9);
        forum.add(huisnummer, 0, 10);
        forum.add(telefoonnummer, 0, 11);
        forum.add(ibannummer, 0, 12);

        forum.setStyle("");
    }

//    public void refreshForum()
//    {
//        forum.getChildren().removeAll();
//        forum.prefWidth(this.getParent().getScaleX() * 0.5);
//
//        Email.refresh();
//        gebruikersNaam.refresh();
//        wachtwoord.refresh();
//        voornaam.refresh();
//        achternaam.refresh();
//        voorletters.refresh();
//        geslacht.refresh();
//        geboortedatum.refresh();
//        plaats.refresh();
//        straatnaam.refresh();
//        huisnummer.refresh();
//        telefoonnummer.refresh();
//        ibannummer.refresh();
//
//        forum.add(Email, 0, 0);
//        forum.add(gebruikersNaam, 0, 1);
//        forum.add(wachtwoord, 0, 2);
//        forum.add(voornaam, 0, 3);
//        forum.add(achternaam, 0, 4);
//        forum.add(voorletters, 0, 5);
//        forum.add(geslacht, 0, 6);
//        forum.add(geboortedatum, 0, 7);
//        forum.add(plaats, 0, 8);
//        forum.add(straatnaam, 0, 9);
//        forum.add(huisnummer, 0, 10);
//        forum.add(telefoonnummer, 0, 11);
//        forum.add(ibannummer, 0, 12);
//    }

    public void buildButtons()
    {
        ButtonControlPannel = new GridPane();

        btn_updateUser  = new Button("Update");
        btn_deleteUser  = new Button("Delete");
        btn_insertUser  = new Button("Insert");
        btn_refreshUser = new Button("Refresh");

        double dsize = 750;//= this.getParent().getScaleX()/2;
        dsize /= 5;



        long size = Math.round(dsize);
        btn_updateUser.setStyle( String.format("-fx-pref-width: %dpx; -fx-min-width: %dpx; -fx-max-width: %dpx; -fx-pref-height: %dpx; -fx-min-height: %dpx; -fx-max-height: %dpx;", size, size, size, size, size, size));
        btn_deleteUser.setStyle( String.format("-fx-pref-width: %dpx; -fx-min-width: %dpx; -fx-max-width: %dpx; -fx-pref-height: %dpx; -fx-min-height: %dpx; -fx-max-height: %dpx;", size, size, size, size, size, size));
        btn_insertUser.setStyle( String.format("-fx-pref-width: %dpx; -fx-min-width: %dpx; -fx-max-width: %dpx; -fx-pref-height: %dpx; -fx-min-height: %dpx; -fx-max-height: %dpx;", size, size, size, size, size, size));
        btn_refreshUser.setStyle(String.format("-fx-pref-width: %dpx; -fx-min-width: %dpx; -fx-max-width: %dpx; -fx-pref-height: %dpx; -fx-min-height: %dpx; -fx-max-height: %dpx;", size, size, size, size, size, size));

        btn_updateUser.setOnAction(event ->  btn_updateUser());
        btn_deleteUser.setOnAction(event ->  btn_deleteUser());
        btn_insertUser.setOnAction(event ->  btn_insertUser());
        btn_refreshUser.setOnAction(event -> btn_refreshUser());

        ButtonControlPannel.add(btn_updateUser , 0, 0);
        ButtonControlPannel.add(btn_deleteUser , 1, 0);
        ButtonControlPannel.add(btn_insertUser , 0, 1);
        ButtonControlPannel.add(btn_refreshUser, 1, 1);

        for(int i = 0; i < 2; i++)
        {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(50);
            ButtonControlPannel.getColumnConstraints().add(col);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(50);
            ButtonControlPannel.getRowConstraints().add(row);
        }
    }



//    public GebruikerReg refresh()
//    {
//        this.getChildren().removeAll();
//        refreshForum();
//        buildButtons();
//
//        this.getChildren().add(forum);
//        this.getChildren().add(ButtonControlPannel);
//        return this;
//    }

    public GebruikerReg()
    {
        buildForum();
        buildButtons();

        for(int i = 0; i < 2; i++)
        {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(50);
            this.getColumnConstraints().add(col);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100);
            this.getRowConstraints().add(row);
        }

        this.add(forum, 0 ,0);
        this.add(ButtonControlPannel, 1 ,0);
//        this.getChildren().add(forum);
//        this.getChildren().add(ButtonControlPannel);

    }

    public GebruikerReg(Gebruiker gebruiker)
    {
        original = gebruiker;
        
////        DatabaseHandlers.dbKlantinlog.select(("Email='" + original.getsEmail() + "'"));
////        originalInlog = DatabaseHandlers.dbKlantinlog.getResults()[0];
//        
        setGebruiker();
        buildForum();
        buildButtons();

        for(int i = 0; i < 2; i++)
        {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(50);
            this.getColumnConstraints().add(col);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100);
            this.getRowConstraints().add(row);
        }

        this.setStyle("-fx-padding: 10px");

        this.add(forum, 0 ,0);
        this.add(ButtonControlPannel, 1 ,0);
//        this.getChildren().add(forum);
//        this.getChildren().add(ButtonControlPannel);

    }



}