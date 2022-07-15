package com.example.nolurson;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;


public class Database {

    public static Connection conn = null;
    public static Statement stmt;

    public static void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\e1805\\IdeaProjects\\demo1\\nolurson\\src\\main\\java\\com\\example\\nolurson\\anwaltdb.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   public static boolean findUser(String username, String passwort) {
        //connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Benutzername , Passwort, PersonalID FROM Benutzer");
            while (res.next()){
                String s1 = res.getString("Benutzername");
                String s2 = res.getString("Passwort");
                String s3 = res.getString("PersonalID");
                if(s1.equals(username) && s2.equals(passwort)){
                    return true;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public static boolean containUser(String benutzername, String BurgerID){
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Benutzername , BurgerID FROM Benutzer");
            while (res.next()){
                String s1 = res.getString("Benutzername");
                String s2 = res.getString("BurgerID");
                if(s1.equals(benutzername) && s2.equals(BurgerID)){
                    return true;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static boolean findAdmin(String Arbeitsstelle){
        try{
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Arbeitsstelle FROM Benutzer");
            while (res.next()){
                String s1 = res.getString("Arbeitsstelle");
                if(s1.equals(Arbeitsstelle)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ObservableList listBenutzer() {
        ObservableList<Benutzer> arr = FXCollections.observableArrayList();

        try{
            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Benutzername, Passwort, PersonalID, Arbeitsstelle, BurgerID FROM Benutzer");
            while (res.next()){
                String s = res.getString("Benutzername");
                String s1 = res.getString("Passwort");
                String s2 = res.getString("PersonalID");
                String s3 = res.getString("Arbeitsstelle");
                String s4 = res.getString("BurgerID");
                //System.out.println(s + s1);

                arr.add(new Benutzer(s,s1,s2,s3,s4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
    public static ObservableList listBenutzer1(String BurgerID) {
        ObservableList<Person> arr = FXCollections.observableArrayList();

        try{
            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Vorname, Nachname, BurgerID, Adresse, Geschlecht FROM Person WHERE BurgerID="+BurgerID);
            //System.out.println(BurgerID);
            while (res.next()){
                String s = res.getString("Vorname");
                String s1 = res.getString("Nachname");
                String s2 = res.getString("BurgerID");
                String s3 = res.getString("Adresse");
                String s7 = res.getString("Geschlecht");
                //System.out.println(s + s1);

                arr.add(new Person(s,s1,s2,s3,s7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
    public static ObservableList listBenutzer2(String BurgerID) {
        ObservableList<Person> arr = FXCollections.observableArrayList();

        try{
            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Telefonnummer, Geburtsdatum, MailAdresse FROM Person WHERE Person.BurgerID = '" + BurgerID +"'");
            while (res.next()){
                String s4 = res.getString("Telefonnummer");
                String s5 = res.getString("Geburtsdatum");
                String s6 = res.getString("Mailadresse");

                //System.out.println(s + s1);

                arr.add(new Person(s4,s5,s6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
    public static ObservableList listBenutzer3(String BurgerID) {
        ObservableList<Benutzer> arr = FXCollections.observableArrayList();

        try{
            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Benutzername, Passwort FROM Benutzer WHERE Benutzer.BurgerID = '" + BurgerID +"'");
            while (res.next()){
                String s4 = res.getString("Benutzername");
                String s5 = res.getString("Passwort");
                //System.out.println(s + s1);

                arr.add(new Benutzer(s4,s5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }

    public static void deleteBenutzer(String BurgerID){
        try {
            //System.out.println("DELETE FROM Benutzer WHERE Benutzer.PersonalID="+BurgerID);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Benutzer WHERE Benutzer.BurgerID="+BurgerID);
            stmt.executeUpdate("DELETE FROM Person WHERE Person.BurgerID="+BurgerID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //list Klient
    public static ObservableList<Klient> listKlient() {
        ObservableList<Klient> arr = FXCollections.observableArrayList();

        try{
            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Person.Vorname, Person.Nachname, Person.BurgerID, Person.Adresse, Person.Telefonnummer, Person.Geburtsdatum, Person.Geschlecht, Person.MailAdresse, Klient.DateinNummer, Klient.BurgerID FROM Person, Klient WHERE Person.BurgerID == Klient.BurgerID");

            while (res.next()){
                String s = res.getString("Vorname");
                String s1 = res.getString("Nachname");
                String s2 = res.getString("BurgerID");
                String s3 = res.getString("Adresse");
                String s4 = res.getString("Telefonnummer");
                String s5 = res.getString("Geburtsdatum");
                String s6 = res.getString("Geschlecht");
                String s7 = res.getString("MailAdresse");
                String s8 = res.getString("DateinNummer");
                System.out.println(s + s1);

                arr.add(new Klient(s,s1,s2,s3,s5,s4,s6,s7,s8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
    public static ObservableList<Fallsbetreffende> listFallsbetreffende() {
        ObservableList<Fallsbetreffende> arr = FXCollections.observableArrayList();

        try{
            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Person.Vorname, Person.Nachname, Person.BurgerID, Person.Adresse, Person.Telefonnummer, Person.Geburtsdatum, Person.Geschlecht, Person.MailAdresse, Fallsbetreffende.DateinNummer, Fallsbetreffende.BurgerId FROM Person, Fallsbetreffende WHERE Person.BurgerID == Fallsbetreffende.BurgerId");

            while (res.next()){
                String s = res.getString("Vorname");
                String s1 = res.getString("Nachname");
                String s2 = res.getString("BurgerID");
                String s3 = res.getString("Adresse");
                String s4 = res.getString("Telefonnummer");
                String s5 = res.getString("Geburtsdatum");
                String s6 = res.getString("Geschlecht");
                String s7 = res.getString("MailAdresse");
                String s8 = res.getString("DateinNummer");
                System.out.println(s + s1);

                arr.add(new Fallsbetreffende(s,s1,s2,s3,s5,s4,s6,s7,s8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
    //delete Klient
    public static void deleteKlient(String BurgerID){

        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Klient WHERE Klient.BurgerID="+BurgerID);
            stmt.executeUpdate("DELETE FROM Person WHERE Person.BurgerID="+BurgerID);
        }catch (Exception E){
            System.out.println(E);
        }
    }

    public static void deleteFallsbetreffende(String BurgerID){

        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Fallsbetreffende WHERE Fallsbetreffende.BurgerId="+BurgerID);
            stmt.executeUpdate("DELETE FROM Person WHERE Person.BurgerID="+BurgerID);
        }catch (Exception E){
            System.out.println(E);
        }
    }
    public static void deleteRechtsfall(String DateinNummer){

        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Klient WHERE Klient.DateinNummer="+DateinNummer);
            stmt.executeUpdate("DELETE FROM Fallsbetreffende WHERE Fallsbetreffende.DateinNummer="+DateinNummer);
            stmt.executeUpdate("DELETE FROM Rechtsfall WHERE Rechtsfall.DateinNummer="+DateinNummer);
        }catch (Exception E){
            System.out.println(E);
        }
    }
    public static void updateBenutzername(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Benutzer SET Benutzername = '" + Value + "' WHERE Benutzer.BurgerID = '" + BurgerID +"'");
            //"UPDATE Benutzer SET passwort = '" + pass + "' WHERE trID = '" + id +"'"


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePasswort(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Benutzer SET PAsswort = '" + Value + "' WHERE Benutzer.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateArbeitsstelle(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Benutzer SET Arbeitsstelle = '" + Value + "' WHERE Benutzer.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePersonalID(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Benutzer SET PersonalID = '" + Value + "' WHERE Benutzer.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserBenutzername(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Benutzer SET Benutzername = '" + Value + "' WHERE Benutzer.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserPasswort(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Benutzer SET Passwort = '" + Value + "' WHERE Benutzer.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserVorname(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Vorname = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserNachname(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Nachname = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserAdresse(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Adresse = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserTel(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Telefonnummer = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserMailAdresse(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET MailAdresse = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //control admin
    public static Boolean containAdmin(String Benutzername){
        //this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Arbeitsstelle,Benutzername FROM Benutzer ");
            while (res.next()){
                String s1 = res.getString("Arbeitsstelle");
                String s2 = res.getString("Benutzername");
                if(s1.equals("Admin") && s2.equals(Benutzername)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static boolean containKlient(String BurgerID) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT BurgerID FROM Person");
            while (res.next()){
                String s1 = res.getString("BurgerID");
                if(s1.equals(BurgerID)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static boolean containFallsbetreffende(String BurgerID) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT BurgerID FROM Person");
            while (res.next()){
                String s1 = res.getString("BurgerID");
                if(s1.equals(BurgerID)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static Boolean addKlient(String BurgerID, String n, String nn, String  gbd, String ma, String add, String tel, String gs, String dn){
        if(!Database.containKlient(BurgerID)){
            //System.out.println(GDatum);
            String s1 = "INSERT INTO Person (BurgerID,Vorname,Nachname,Adresse,Telefonnummer, Geburtsdatum, MailAdresse, Geschlecht) VALUES('"+BurgerID+"','"+n+"','"+nn+"','" + gbd + "','"+ma+"','"+add+"','"+tel+"','"+gs+"');";
            String s2 = "INSERT INTO Klient (BurgerID, DateinNummer) VALUES('"+BurgerID+"','"+dn+"');";

            try {
                stmt.executeUpdate(s1);
                stmt.executeUpdate(s2);
            }catch (Exception e){
                System.out.println(e);
            }
            return true;
        }else{
            return false;

        }

    }

    public static Boolean addFallsbetreffende(String BurgerID, String n, String nn, String  gbd, String ma, String add, String tel, String gs, String dn){
        if(!Database.containFallsbetreffende(BurgerID)){
            //System.out.println(GDatum);
            String s1 = "INSERT INTO Person (BurgerID,Vorname,Nachname,Adresse,Telefonnummer, Geburtsdatum, MailAdresse, Geschlecht) VALUES('"+BurgerID+"','"+n+"','"+nn+"','" + gbd + "','"+ma+"','"+add+"','"+tel+"','"+gs+"');";
            String s2 = "INSERT INTO Fallsbetreffende (BurgerId, DateinNummer) VALUES('"+BurgerID+"','"+dn+"');";

            try {
                stmt.executeUpdate(s1);
                stmt.executeUpdate(s2);
            }catch (Exception e){
                System.out.println(e);
            }
            return true;
        }else{
            return false;

        }

    }
    public static Boolean addRechtsfall(String PID, String RA,String DN, String BID, String FB, String TD){
        if(!Database.containRechtsfall(DN)){
            String s1 = "INSERT INTO Rechtsfall (PersonalID, RechtsfallArten, DateinNummer, BurgerID, Fallsbetreffende, TerminDatum) VALUES('"+PID+"','"+RA+"','"+DN+"','"+BID+"','"+FB+"','"+TD+"');";
            String s2 = "INSERT INTO Fallsbetreffende(BurgerId, DateinNummer) VALUES('"+FB+"','"+DN+"');";
            String s3 = "INSERT INTO Klient(BurgerID, DateinNummer) VALUES('"+BID+"','"+DN+"');";
            try {
                stmt.executeUpdate(s1);
                stmt.executeUpdate(s2);
                stmt.executeUpdate(s3);
            }catch (Exception e){
                System.out.println(e);
            }
            return true;
        }else{
            return false;

        }

    }

    public static boolean containRechtsfall(String DateinNummer) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT DateinNummer FROM Rechtsfall");
            while (res.next()){
                String s1 = res.getString("BurgerID");
                if(s1.equals(DateinNummer)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public static Boolean containBenutzer(String Benutzername, String passwort){
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT Benutzername , Passwort FROM Benutzer");
            while (res.next()){
                String s1 = res.getString("Benutzername");
                String s2 = res.getString("Passwort");
                if(s1.equals(Benutzername) && s2.equals(passwort)){
                    return true;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public static Boolean addBenutzer( String vorn, String nachn,String BurgerID, String  add, String gbd, String tel, String ges, String ma, String bn, String ps,String pid,String as){
        if(!Database.containBenutzer(bn,ps)){

            String s1 = "INSERT INTO Person (Vorname,Nachname,BurgerID,Adresse,Geburtsdatum,Telefonnummer,Geschlecht,MailAdresse) VALUES('"+vorn+"','"+nachn+"','"+BurgerID+"','" + add + "','"+gbd+"','"+tel+"','" + ges +"','"+ma+"');";
            String s2 = "INSERT INTO Benutzer (Benutzername,Passwort,PersonalID,Arbeitsstelle,BurgerID) VALUES('"+bn+"','"+ps+"','"+pid+"','"+as+"','"+BurgerID+"');";


            try {
                stmt.executeUpdate(s1);
                stmt.executeUpdate(s2);
            }catch (Exception e){
                System.out.println(e);
            }
            return true;
        }else{
            return false;

        }

    }
    public static ObservableList<Rechtsfall> listRechtsfall() {
        ObservableList<Rechtsfall> arr = FXCollections.observableArrayList();

        try{

            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Rechtsfall.PersonalID, Rechtsfall.RechtsfallArten, Rechtsfall.DateinNummer, Rechtsfall.BurgerID, Rechtsfall.Fallsbetreffende, Rechtsfall.TerminDatum, Fallsbetreffende.DateinNummer, Klient.DateinNummer FROM Rechtsfall, Fallsbetreffende, Klient WHERE Rechtsfall.DateinNummer = Fallsbetreffende.DateinNummer AND Rechtsfall.DateinNummer = Klient.DateinNummer");
            while (res.next()){
                String a = res.getString("PersonalID");
                String a5 = res.getString("RechtsfallArten");
                String a1 = res.getString("DateinNummer");
                String a2 = res.getString("BurgerID");
                String a3 = res.getString("Fallsbetreffende");
                String a4 = res.getString("TerminDatum");
                arr.add(new Rechtsfall(a,a5,a1,a2,a3,a4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
    public static void updateKlientVorname(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Vorname = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFbVorname(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Vorname = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFbNachname(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Nachname = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFbAdresse(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Adresse = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFbTel(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Telefonnummer = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFbGeburtsdatum(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Geburtsdatum = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFbMail(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET MailAdresse = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateFbDateinNummer(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Fallsbetreffende SET DateinNummer = '" + Value + "' WHERE Fallsbetreffende.BurgerId = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void updateRechtsfallTerminDatum(String DateinNummer, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Rechtsfall SET TerminDatum = '" + Value + "' WHERE Rechtsfall.DateinNummer = '" + DateinNummer +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateKlientNachname(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Nachname = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateKlientMail(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET MailAdresse = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateKlientAdresse(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Adresse = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateKlientTelefonnummer(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Telefonnummer = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateKlientGeburtsdatum(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Person SET Geburtsdatum = '" + Value + "' WHERE Person.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateKlientDateinNummer(String BurgerID, String Value){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Klient SET DateinNummer = '" + Value + "' WHERE Klient.BurgerID = '" + BurgerID +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}


