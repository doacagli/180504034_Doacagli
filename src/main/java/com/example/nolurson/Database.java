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
            ResultSet res = stmt.executeQuery("SELECT * FROM Person");
            if (res.next()) {
                System.out.println("username: " + res.getString("NAME"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addUser() throws SQLException {
        stmt = conn.createStatement();
        //stmt.executeUpdate("INSERT INTO BENUTZER(Benutzername, Passwort, PersonalID) VALUES( )



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

    public static void addKlient(Klient k){
        String sql = "INSERT INTO Kunde (BURGERID, NAME, LASTNAME) VALUES(?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,k.getBurgerId());
//            ps.setString(2,k.getVorname());
//            ps.setString(3,k.getNachname());

            ps.executeUpdate();
                } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static ObservableList listBenutzer() {
        ObservableList<Benutzer> arr = FXCollections.observableArrayList();

        try{
            stmt = conn.createStatement();
            ResultSet res= stmt.executeQuery("SELECT Benutzername, PersonalID FROM Benutzer");
            while (res.next()){
                String s = res.getString("Benutzername");
                String s1 = res.getString("PersonalID");
                System.out.println(s + s1);

                arr.add(new Benutzer(s,s1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arr;
    }
    public static void deleteBenutzer(String BurgerID){
        try {
            System.out.println("DELETE FROM Benutzer WHERE Benutzer.PersonalID="+BurgerID);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Benutzer WHERE Benutzer.PersonalID="+BurgerID);
            //stmt.executeUpdate("DELETE FROM Person WHERE Person.BurgerID="+BurgerID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


