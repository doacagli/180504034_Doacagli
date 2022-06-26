package com.example.nolurson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Klient extends Person{
    private String beruf;
    private String eheStatus;
    private Date terminDatum;
    private List<Rechtsfall> Rechtsfall;

    public Klient(String vorname, String nachname, String BurgerId, String adresse, Date geburtsdatum, int telefonnummer, String geschlecht, String mailAdresse, String beruf, String eheStatus, Date terminDatum, List<Rechtsfall> rechtsfall) {
        super(vorname, nachname, BurgerId, adresse, geburtsdatum, telefonnummer, geschlecht, mailAdresse);
        this.beruf=beruf;
        this.eheStatus=eheStatus;
        this.terminDatum=terminDatum;
        Rechtsfall=rechtsfall;
    }

    public Klient(String burgerId, String vorname, String nachname, java.sql.Date geburtsdatum, String adresse, String telefonnummer, String geschlecht, String email, String beruf, String eheStatus, java.sql.Date termin) {
        super();
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

    public void setTerminDatum(Date terminDatum) {
        this.terminDatum = terminDatum;
    }

    public List<com.example.nolurson.Rechtsfall> getRechtsfall() {
        return Rechtsfall;
    }

    public void setRechtsfall(List<com.example.nolurson.Rechtsfall> rechtsfall) {
        Rechtsfall = rechtsfall;
    }
    @Override
    public String toString(){
        return super.toString()+" "+beruf+" "+eheStatus+" "+Rechtsfall+" "+terminDatum;
    }
}
