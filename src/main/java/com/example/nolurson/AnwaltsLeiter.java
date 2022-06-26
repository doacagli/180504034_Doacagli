package com.example.nolurson;

import java.util.ArrayList;
import java.util.Date;

public class AnwaltsLeiter extends Benutzer {
    public AnwaltsLeiter(String vorname, String nachname, String BurgerId, String adresse, Date geburtsdatum, int telefonnummer, String geschlecht, String mailAdresse, String personalID, String pswort, String bname, String aStelle) {
        super(vorname, nachname, BurgerId, adresse, geburtsdatum, telefonnummer, geschlecht, mailAdresse, personalID, pswort, bname, aStelle);
    }
    private ArrayList<Klient> Klient;
    private ArrayList<Rechtsfall> Rechtsfall;
    private ArrayList<Termin> Termin;

    public void addKlient(Klient k){
        Klient.add(k);
    }
    public void delKlient(Klient k){
        Klient.remove(k);
    }
    public void addRechtsfall(Rechtsfall r){
        Rechtsfall.add(r);
    }
    public void delRechtsfall(Rechtsfall r){
        Rechtsfall.remove(r);
    }
    public void addTermin(Termin t){
        Termin.add(t);
    }
    public void delTermin(Termin t){
        Termin.remove(t);
    }

    @Override
    public String toString(){
        return super.toString();
    }

}