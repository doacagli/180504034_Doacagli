package com.example.nolurson;

import java.util.Date;


public class Person {
    private String Vorname;
    private String Nachname;
    private String BurgerID;
    private String Adresse;
    private Date Geburtsdatum;
    private int Telefonnummer;
    private String Geschlecht;
    private String MailAdresse;

    public Person(String Id){
        this.BurgerID =Id;
    }

    public Person() {

    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getBurgerID() {
        return BurgerID;
    }

    public void setBurgerID(String burgerID) {
        BurgerID = burgerID;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public Date getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public int getTelefonnummer() {
        return Telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        Telefonnummer = telefonnummer;
    }

    public String getGeschlecht() {
        return Geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        Geschlecht = geschlecht;
    }

    public String getMailAdresse() {
        return MailAdresse;
    }

    public void setMailAdresse(String mailAdresse) {
        MailAdresse = mailAdresse;
    }

    public Person(String vorname, String nachname,String BurgerId, String adresse, Date geburtsdatum, int telefonnummer, String geschlecht, String mailAdresse){
        Vorname=vorname;
        Nachname=nachname;
        this.BurgerID=BurgerId;
        Adresse=adresse;
        Geburtsdatum=geburtsdatum;
        Telefonnummer=telefonnummer;
        Geschlecht=geschlecht;
        MailAdresse=mailAdresse;

    }
    @Override
    public String toString(){
        return Vorname + " " + Nachname+" "+BurgerID+" "+Adresse+" "+Geburtsdatum+" "+Telefonnummer+" "+Geschlecht+" "+MailAdresse;
    }

    @Override
    public boolean equals(Object o){
        Person a =(Person) o;
        if(a.getBurgerID().equals(this.BurgerID)) return true;
        else return false;
    }


}
