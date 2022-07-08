package com.example.nolurson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BenutzerController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button logout;

    @FXML
    private Button backToButton;

    @FXML
    private Button deleteUser;

    @FXML
    private Button addUser;
    
    @FXML
    private TextField deleteBenutzer;
    @FXML
    private Button deleteButton;
    

    @FXML
    private TableView<Benutzer> BenutzerTableView;

    @FXML
    private TableColumn<Benutzer, String> BenutzernameID;

    @FXML
    private TableColumn<Benutzer, String> PersonalIDID;

    @FXML
    private TextField keywordsTextfield;

    ObservableList<Benutzer> Benutzerlist = FXCollections.observableArrayList();
    //Benutzerlist = ListBenutzer();

    @FXML
    public ObservableList ListBenutzer(){
        ObservableList arr = Database.listBenutzer();
        return arr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {

            BenutzernameID.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("Benutzername"));
            PersonalIDID.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("PersonalID"));

            BenutzerTableView.setItems(ListBenutzer());
    }


    public void backTo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addUser(ActionEvent event) throws IOException {

    }

    public void deleteBenutzer(ActionEvent event) throws IOException {
        Database.deleteBenutzer(deleteBenutzer.getText());


    }

    public void logOut(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }

}
