package com.example.nolurson;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RechtsfallController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button logout;

    @FXML
    private Button backToButton;
    @FXML
    private DatePicker date_rechts;

    @FXML
    private TextField txt_dateinn;

    @FXML
    private TextField txt_bid;

    @FXML
    private TextField txt_pid;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;
    @FXML
    private TableView<Rechtsfall> tab_recht;

    @FXML
    private TableColumn<Rechtsfall, String> col_datein;

    @FXML
    private TableColumn<Rechtsfall, String> col_bid;

    @FXML
    private TableColumn<Rechtsfall, String> col_pid;

    @FXML
    private TableColumn<Rechtsfall, String> col_terdat;
    @FXML
    private TableColumn<Rechtsfall, String> col_falls;


    public void backTo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_datein.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String>("DateinNummer"));
        col_bid.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String >("BurgerID"));
        col_pid.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String >("PersonalID"));
        col_terdat.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String>("TerminDatum"));
        col_falls.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String >("BurgerId"));

        tab_recht.setItems(List());

    }
    @FXML
    public ObservableList List(){
        ObservableList arr = Database.listRechtsfall();

        return arr;
    }


}
