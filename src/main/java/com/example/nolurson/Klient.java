package com.example.nolurson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Klient extends Person{
    private String DateinNummer;

    public Klient(String vorname, String nachname, String BurgerId, String adresse, String geburtsdatum,String telefonnummer,  String geschlecht, String mailAdresse, String DateinNummer) {
        super(vorname, nachname, BurgerId, adresse,geburtsdatum,telefonnummer, geschlecht, mailAdresse);
        this.DateinNummer=DateinNummer;

    }


    public Klient(String BurgerID) {
        super(BurgerID);
    }

    public String getDateinNummer() {
        return DateinNummer;
    }

    public void setDateinNummer(String dateinNummer) {
        DateinNummer = dateinNummer;
    }

    @Override
    public String toString(){
        return super.toString()+" "+ getDateinNummer();
    }
}

