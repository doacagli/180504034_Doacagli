package com.example.nolurson;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private Button deleteButton;

    @FXML
    private Button addButton;
    /*@FXML
    private AnchorPane anPane;
    @FXML
    private VBox ksc;*/
    @FXML
    private TableView<Klient> table_klient;

    @FXML
    private TableColumn<Klient, String> col_id;

    @FXML
    private TableColumn<Klient, String> col_nam;

    @FXML
    private TableColumn<Klient, String > col_vorn;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_nname;

    //public static KlientController klc;

    ObservableList<Klient> listKlient;
    int index = -1;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_id.setCellValueFactory(new PropertyValueFactory<Klient,String>("burgerId"));
        col_nam.setCellValueFactory(new PropertyValueFactory<Klient,String>("vorname"));
        col_vorn.setCellValueFactory(new PropertyValueFactory<Klient,String>("nachname"));


        listKlient = Database.getDataklients();
        table_klient.setItems(listKlient);

    }


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
    public void addKlient(){
        String burgerId = txt_id.getText();
        String vorname = txt_name.getText();
        String  nachname = txt_nname.getText();

        Klient klient = new Klient(burgerId, vorname, nachname);
        Database.addKlient(klient);


    }

    /*public void klientList() {

        ksc.getChildren().clear();
        ArrayList<Klient> klients = Database.getKlient();
        for(int i = 0; i < klients.size(); i++) {
            FXMLLoader klientItem = new FXMLLoader(getClass().getResource("KundeItem.fxml"));
            try {
                ksc.getChildren().add(klientItem.load());
                KundeItemController kundeItemController = klientItem.getController();
                kundeItemController.setKlientItem(klients.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/




}
