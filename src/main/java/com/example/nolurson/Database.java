package com.example.nolurson;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;


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
            //stm.executeUpdate("INSERT INTO Person (NAME,LASTNAME,ID,AGE) VALUES('Doa','Cagli','123456789',22)");
            //stm.executeUpdate("INSERT INTO PERSONAL(USERNAME, PASSWORD) VALUES('Doacagli','123456')");
//            ResultSet res = stmt.executeQuery("SELECT * FROM Person");
//            if (res.next()) {
//                System.out.println("username: " + res.getString("NAME"));
//            }
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
            ResultSet res= stmt.executeQuery("SELECT Klient.DateinNummer, Klient.BurgerID, Person.Vorname, Person.Nachname, Person.BurgerID, Person.Adresse, Person.Telefonnummer, Person.Geburtsdatum, Person.MailAdresse, Person.Geschlecht FROM Person, Klient WHERE Person.BurgerID == Klient.BurgerID");
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

                arr.add(new Klient(s,s1,s2,s3,s4,s5,s6,s7,s8));
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

    public static Boolean addKlient(String BurgerID, String n, String nn, String  gbd, String ma, String add, String tel, String gs, String dn){
        if(!Database.containKlient(BurgerID)){
            //System.out.println(GDatum);
            String s1 = "INSERT INTO Person (BurgerID,Vorname,Nachname,Adresse,Telefonnummer, Geburtsdatum, MailAdresse, Geschlecht) VALUES('"+BurgerID+"','"+n+"','"+nn+"','" + gbd + "','"+ma+"','"+add+"','"+tel+"','"+gs+"');";
            String s2 = "INSERT INTO Klient (BurgerID, DateinNummer) VALUES('"+BurgerID+"','"+gs+"');";
        /*System.out.println(s1);
        System.out.println(s2);*/

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
    //String vorname, String nachname, String BurgerId, String adresse, String geburtsdatum, String  telefonnummer, String geschlecht, String mailAdresse,  String bname, String pswort,String personalID, String aStelle
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
            ResultSet res= stmt.executeQuery("SELECT Rechtsfall.DateinNummer, Rechtsfall.TerminDatum, Rechtsfall.PersonalID, Rechtsfall.BurgerID, Fallsbetreffende.BurgerId, Fallsbetreffende.DateinNummer FROM Rechtsfall, Klient, Fallsbetreffende WHERE (Rechtsfall.DateinNummer == Fallsbetreffende.DateinNummer)");
            while (res.next()){
                String s = res.getString("PersonalID");
                String s1 = res.getString("TerminDatum");
                String s2 = res.getString("DateinNummer");
                String s3 = res.getString("BurgerId");
                String s4 = res.getString("BurgerID");

                arr.add(new Rechtsfall(s,s1,s2,s3,s4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }

}


