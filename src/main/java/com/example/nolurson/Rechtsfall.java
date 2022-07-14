package com.example.nolurson;

public class Rechtsfall {
    private String PersonalID;
    private String TerminDatum;
    private String DateinNummer;
    private String RechtsfallArten;
    private String BurgerID;
    private String Fallsbetreffende;



    public Rechtsfall(String PersonalID, String RechtsfallArten,String DateinNummer,String BI,String Fb, String TerminDatum) {
        this.PersonalID = PersonalID;
        this.TerminDatum = TerminDatum;
        this.DateinNummer = DateinNummer;
        this.RechtsfallArten = RechtsfallArten;
        this.BurgerID = BI;
        this.Fallsbetreffende = Fb;

    }

    public String getRechtsfallArten() {
        return RechtsfallArten;
    }

    public void setRechtsfallArten(String rechtsfallArten) {
        RechtsfallArten = rechtsfallArten;
    }

    public String getBurgerID() {
        return BurgerID;
    }

    public void setBurgerID(String burgerID) {
        BurgerID = burgerID;
    }

    public String getFallsbetreffende() {
        return Fallsbetreffende;
    }

    public void setFallsbetreffende(String fallsbetreffende) {
        Fallsbetreffende = fallsbetreffende;
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


    public String getDateinNummer() {
        return DateinNummer;
    }

    public void setDateinNummer(String dateinNummer) {
        DateinNummer = dateinNummer;
    }
    @Override
    public String toString(){
        return PersonalID+" "+TerminDatum+" "+DateinNummer;
    }

}
