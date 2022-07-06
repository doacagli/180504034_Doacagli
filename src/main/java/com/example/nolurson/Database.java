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

    public static void addKlient(Klient k){
        String sql = "INSERT INTO Kunde (BURGERID, NAME, LASTNAME) VALUES(?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,k.getBurgerId());
            ps.setString(2,k.getVorname());
            ps.setString(3,k.getNachname());

            ps.executeUpdate();
                } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public static ObservableList<Klient> getDataklients(){

        ObservableList<Klient> klients = FXCollections.observableArrayList();
       try{
           stm = con.createStatement();
           //stm.executeUpdate("INSERT INTO Person (NAME,LASTNAME,ID,AGE) VALUES('Doa','Cagli','123456789',22)");
           //stm.executeUpdate("INSERT INTO Kunde (BURGERID, NAME, LASTNAME) VALUES('123456','DDD', 'CCC')");
           ResultSet res = stm.executeQuery("SELECT BURGERID, NAME, LASTNAME FROM Kunde");
           while (res.next()){
               String s = res.getString("BURGERID");
               String s1 = res.getString("NAME");
               String s2 = res.getString("LASTNAME");

               klients.add(new Klient(s,s1,s2));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return klients;
    }
    public static void signUpUser(ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try{
            connection
    }


}


