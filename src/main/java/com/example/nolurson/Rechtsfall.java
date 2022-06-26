package com.example.nolurson;

public class Rechtsfall {
    private String Anwalt;
    private String RechtsfallArten;
    private String DateinNummer;

    public Rechtsfall(String anwalt, String rechtsfallArten, String dateinNummer) {
        Anwalt = anwalt;
        RechtsfallArten = rechtsfallArten;
        DateinNummer = dateinNummer;
    }

    public String getAnwalt() {
        return Anwalt;
    }

    public void setAnwalt(String anwalt) {
        Anwalt = anwalt;
    }

    public String getRechtsfallArten() {
        return RechtsfallArten;
    }

    public void setRechtsfallArten(String rechtsfallArten) {
        RechtsfallArten = rechtsfallArten;
    }

    public String getDateinNummer() {
        return DateinNummer;
    }

    public void setDateinNummer(String dateinNummer) {
        DateinNummer = dateinNummer;
    }
    @Override
    public String toString(){
        return Anwalt+" "+RechtsfallArten+" "+DateinNummer;
    }

}
