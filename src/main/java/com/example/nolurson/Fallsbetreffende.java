package com.example.nolurson;

import java.util.Date;

public class Fallsbetreffende extends Person{
    private String DateinNummer;

    public Fallsbetreffende(String vorname, String nachname, String BurgerId, String adresse, String geburtsdatum, String telefonnummer, String geschlecht, String mailAdresse, String DateinNummer) {
        super(vorname, nachname, BurgerId, adresse, geburtsdatum, telefonnummer, geschlecht, mailAdresse);
        this.DateinNummer= DateinNummer;
    }

    public String getDateinNummer() {
        return DateinNummer;
    }

    public void setDateinNummer(String DateinNummer) {
        this.DateinNummer = DateinNummer;
    }

    @Override
    public String toString(){
        return super.toString()+" "+DateinNummer;
    }
}
