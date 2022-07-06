package com.example.nolurson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Klient extends Person{
    private String beruf;
    private String eheStatus;
    private String terminDatum;
    private String burgerId;
    private String vorname;
    private String nachname;


    public Klient(String vorname, String nachname, String BurgerId, String adresse, String geburtsdatum, String telefonnummer, String geschlecht, String mailAdresse, String beruf, String eheStatus, String terminDatum, List<Rechtsfall> rechtsfall) {
        super(vorname, nachname, BurgerId, adresse, geburtsdatum, telefonnummer, geschlecht, mailAdresse);
        this.beruf=beruf;
        this.eheStatus=eheStatus;
        this.terminDatum=terminDatum;

    }

    public Klient(String burgerId, String vorname, String nachname, String geburtsdatum, String adresse, String telefonnummer, String geschlecht, String email, String beruf, String eheStatus, String termin) {
        super();
    }

    public Klient(String burgerId, String vorname, String nachname) {
       super();
    }

    public Klient() {

    }

    public String getBurgerId() {
        return burgerId;
    }

    public void setBurgerId(String burgerId) {
        this.burgerId = burgerId;
    }

    @Override
    public String getVorname() {
        return vorname;
    }

    @Override
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String getNachname() {
        return nachname;
    }

    @Override
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public String getEheStatus() {
        return eheStatus;
    }

    public void setEheStatus(String eheStatus) {
        this.eheStatus = eheStatus;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public String getTerminDatum() {
        String datum =dateFormat.format(terminDatum);
        return datum;
    }

    public void setTerminDatum(String terminDatum) {
        this.terminDatum = terminDatum;
    }

    @Override
    public String toString(){
        return super.toString()+" "+beruf+" "+eheStatus+" "+terminDatum;
    }
}

