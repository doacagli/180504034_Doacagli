package com.example.nolurson;

import java.util.ArrayList;
import java.util.Date;

public class Anwalt extends Benutzer{
    public Anwalt(String vorname, String nachname, String BurgerId, String adresse, Date geburtsdatum, int telefonnummer, String geschlecht, String mailAdresse, String personalID, String pswort, String bname, String aStelle) {
        super(vorname, nachname, BurgerId, adresse, geburtsdatum, telefonnummer, geschlecht, mailAdresse, personalID, pswort, bname, aStelle);
    }

    private ArrayList<Klient> Klient;
    private ArrayList<Rechtsfall> Rechtsfall;

    public void addKlient(Klient k){
        Klient.add(k);
    }
    public void delKlient(Klient k){
        Klient.remove(k);
    }
    public void addRechtsfall(Rechtsfall r){
        Rechtsfall.add(r);
    }
    public void delRechtsfall(Rechtsfall r) {
        Rechtsfall.remove(r);
    }
    public void listRechtsfall(Rechtsfall r){ // void yanliş return ne verebilir ?
        Rechtsfall.listIterator();
    }

}
