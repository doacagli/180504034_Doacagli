package com.example.nolurson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Klient extends Person{

    public Klient(String vorname, String nachname, String BurgerId, String adresse, String geburtsdatum, String telefonnummer, String geschlecht, String mailAdresse, String beruf, String eheStatus, String terminDatum, List<Rechtsfall> rechtsfall) {
        super(vorname, nachname, BurgerId, adresse, geburtsdatum, telefonnummer, geschlecht, mailAdresse);
    }

    public Klient(String burgerId, String vorname, String nachname, String geburtsdatum, String adresse, String telefonnummer, String geschlecht, String email, String beruf, String eheStatus, String termin) {
        super();
    }

    public Klient(String burgerId, String vorname, String nachname) {
       super();
    }

    public Klient() {

    }
    @Override
    public String toString(){
        return super.toString();
    }
}

