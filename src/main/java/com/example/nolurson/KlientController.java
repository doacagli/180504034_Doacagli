package com.example.nolurson;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class KlientController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button logout;

    @FXML
    private Button backToButton;

    @FXML
    private TableView<Klient> table_klient;

    @FXML
    private TableColumn<Klient, String> col_nam;

    @FXML
    private TableColumn<Klient, String> col_nachn;

    @FXML
    private TableColumn<Klient, String> col_id;

    @FXML
    private TableColumn<Klient, String> col_adresse;

    @FXML
    private TableColumn<Klient, String> col_tel;

    @FXML
    private TableColumn<Klient, String> col_bdate;

    @FXML
    private TableColumn<Klient, String> col_sex;

    @FXML
    private TableColumn<Klient, String> col_mail;

    @FXML
    private TableColumn<Klient, String> col_dateinnm;

    @FXML
    private Label errorMessage;

    private String[] Geschlecht ={"W","M","D"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_nam.setCellValueFactory(new PropertyValueFactory<Klient,String>("Vorname"));
        col_nachn.setCellValueFactory(new PropertyValueFactory<Klient,String>("Nachname"));
        col_id.setCellValueFactory(new PropertyValueFactory<Klient,String>("BurgerID"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<Klient, String >("Adresse"));
        col_tel.setCellValueFactory(new PropertyValueFactory<Klient, String>("Telefonnummer"));
        col_bdate.setCellValueFactory(new PropertyValueFactory<Klient, String>("Geburtsdatum"));
        col_sex.setCellValueFactory(new PropertyValueFactory<Klient, String>("Geschlecht"));
        col_mail.setCellValueFactory(new PropertyValueFactory<Klient, String >("MailAdresse"));
        col_dateinnm.setCellValueFactory(new PropertyValueFactory<Klient, String>("DateinNummer"));

        table_klient.setItems(List());

    }

    @FXML
    public ObservableList List(){
        ObservableList arr = Database.listKlient();

        return arr;
    }
    public void backTo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2UserController.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void logOut(ActionEvent event){
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }

}



