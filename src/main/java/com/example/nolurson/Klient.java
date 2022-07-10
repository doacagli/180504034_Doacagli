package com.example.nolurson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Klient extends Person{
    private String DateinNummer;

    public Klient(String vorname, String nachname, String BurgerId, String adresse, String geburtsdatum, String telefonnummer, String geschlecht, String mailAdresse, List<Rechtsfall> rechtsfall) {
        super(vorname, nachname, BurgerId, adresse, geburtsdatum, telefonnummer, geschlecht, mailAdresse);
    }

    public Klient(String burgerId, String vorname, String nachname, String geburtsdatum, String adresse, String telefonnummer, String geschlecht, String email, String DateinNummer) {
        super(burgerId, vorname, nachname, geburtsdatum,adresse, telefonnummer, geschlecht, email);
        this.DateinNummer=DateinNummer;
    }

    public Klient() {

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

