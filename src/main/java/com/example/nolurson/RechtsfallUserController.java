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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RechtsfallUserController implements Initializable {
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
    private TextField txt_fal;

    @FXML
    private Button addButton;
    @FXML
    private Button but_update;

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
    @FXML
    private TableColumn<Rechtsfall, String> col_fal;
    @FXML
    private ChoiceBox<String> myChoicebox;

    @FXML
    private Label errorMessage;

    private String [] Rechtsfall={"Scheidung", "Erbschafts"};



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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_pid.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String >("PersonalID"));
        col_fal.setCellValueFactory(new PropertyValueFactory<Rechtsfall, String >("RechtsfallArten"));
        col_datein.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String>("DateinNummer"));
        col_bid.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String >("BurgerID"));
        col_falls.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String >("Fallsbetreffende"));
        col_terdat.setCellValueFactory(new PropertyValueFactory<Rechtsfall,String>("TerminDatum"));
        tab_recht.setItems(List());
        myChoicebox.getItems().addAll(Rechtsfall);


    }
    @FXML
    public ObservableList List(){
        ObservableList arr = Database.listRechtsfall();
        return arr;
    }
    public void deleteRechtsfall(ActionEvent event) throws IOException {
        Database.deleteRechtsfall(txt_dateinn.getText());
        errorMessage.setText("Erfolgreich!");

    }
    public void addRechtsfall(ActionEvent event){
        Boolean b = Database.addRechtsfall(txt_pid.getText(),myChoicebox.getValue(),txt_dateinn.getText(),txt_bid.getText(),txt_fal.getText(),date_rechts.getValue().toString());

        if(b){
            errorMessage.setText("Einfuegen erfolgreich!");
        }else{
            errorMessage.setText("Die Personal ist schon auf dem System befunden.");
        }
    }

    public void updateWerten(ActionEvent event){
        Database.updateRechtsfallTerminDatum(txt_dateinn.getText(),date_rechts.getValue().toString());
        errorMessage.setText("Einfuegen erfolgreich!");

    }

}
