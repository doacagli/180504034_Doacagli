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

    public static Connection con = null;
    public static Statement stm;

    public static void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\e1805\\IdeaProjects\\demo1\\nolurson\\src\\main\\java\\com\\example\\nolurson\\anwaltdb.db";
            // create a connection to the database
            con = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            stm = con.createStatement();
            //stm.executeUpdate("INSERT INTO Person (NAME,LASTNAME,ID,AGE) VALUES('Doa','Cagli','123456789',22)");
            //stm.executeUpdate("INSERT INTO PERSONAL(USERNAME, PASSWORD) VALUES('Doacagli','123456')");
            ResultSet res = stm.executeQuery("SELECT * FROM Person");
            if (res.next()) {
                System.out.println("username: " + res.getString("NAME"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   public static boolean findUser(String username, String passwort) {
        //connect();
        try {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT USERNAME , Password FROM Personal");
            while (res.next()){
                String s1 = res.getString("USERNAME");
                String s2 = res.getString("PASSWORD");
                if(s1.equals(username) && s2.equals(passwort)){
                    return true;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public static void deleteKlient(){

    }

    public static void addKlient(){

    }
    public static void listKlient(){

    }
    public static ArrayList<Klient> getKlient() {
        ArrayList<Klient> kunden = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Klient");
            while(rs.next()) {
                String burgerId = rs.getString("BURGERID");
                String vorname = rs.getString("NAME");
                String nachname = rs.getString("LASTNAME");
                String sgeburtsdatum = rs.getString("BIRTHDATE");
                Date geburtsdatum = (Date) dateFormat.parse(sgeburtsdatum);
                String adresse = rs.getString("ADRESSE");
                String telefonnummer = rs.getString("TEL");
                String geschlecht = rs.getString("GESCHLECHT");
                String email = rs.getString("MAIL");
                String beruf = rs.getString("JOB");
                String eheStatus = rs.getString("EHE");
                String stermin = rs.getString("TERMIN");
                Date termin = (Date) dateFormat.parse(stermin);

                Klient klient = new Klient(burgerId, vorname, nachname, geburtsdatum, adresse, telefonnummer, geschlecht,email, beruf, eheStatus, termin);
                kunden.add(klient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return kunden;
    }
}


