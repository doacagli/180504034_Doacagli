package com.example.nolurson;

public class Rechtsfall {
    private String PersonalID;
    private String TerminDatum;
    private String DateinNummer;
    private String BurgerId;
    private String BurgerID;

    public Rechtsfall(String PersonalID, String TerminDatum, String DateinNummer, String BurgerId, String BurgerID) {
        this.PersonalID = PersonalID;
        this.TerminDatum = TerminDatum;
        this.DateinNummer = DateinNummer;
        this.BurgerId = BurgerId;
        this.BurgerID = BurgerID;
    }

    public String getPersonalID() {
        return PersonalID;
    }

    public void setPersonalID(String personalID) {
        PersonalID = personalID;
    }

    public String getTerminDatum() {
        return TerminDatum;
    }

    public void setTerminDatum(String terminDatum) {
        TerminDatum = terminDatum;
    }

    public String getBurgerId() {
        return BurgerId;
    }

    public void setBurgerId(String BurgerId) {
        BurgerId = BurgerId;
    }

    public String getBurgerID() {
        return BurgerID;
    }

    public void setBurgerID(String burgerID) {
        BurgerID = burgerID;
    }

    public String getDateinNummer() {
        return DateinNummer;
    }

    public void setDateinNummer(String dateinNummer) {
        DateinNummer = dateinNummer;
    }
    @Override
    public String toString(){
        return PersonalID+" "+TerminDatum+" "+DateinNummer+ " "+BurgerID+" "+BurgerId;
    }

}
