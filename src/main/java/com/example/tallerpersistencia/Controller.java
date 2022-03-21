package com.example.tallerpersistencia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button home,create,read,update,delete;

    @FXML
    private BorderPane central;

    @FXML
    private AnchorPane centro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("funciona");
        setPanelCenter("home");

    }

    @FXML
    void eventHome(ActionEvent event) {
        System.out.println("HOME");
        setPanelCenter("home");
    }

    @FXML
    void eventCreate(ActionEvent event) {
        System.out.println("CREATE");
        setPanelCenter("create");
    }

    @FXML
    void eventRead(ActionEvent event) {
        System.out.println("READ");
        setPanelCenter("read");
    }

    @FXML
    void eventUpdate(ActionEvent event) {
        System.out.println("UPDATE");
        setPanelCenter("update");
    }

    @FXML
    void eventDelete(ActionEvent event) {
        System.out.println("DELETE");
        setPanelCenter("delete");
    }

    private void setPanelCenter(String panel){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(panel+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        central.setCenter(root);
    }
}