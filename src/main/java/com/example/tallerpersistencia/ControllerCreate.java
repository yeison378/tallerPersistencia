package com.example.tallerpersistencia;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCreate implements Initializable {



    @FXML
    private TextField almacenamiento,camFrontal,camPrincipal,huella,modelo,os,ram;

    @FXML
    private Button btnAgregar,btnCancelar;

    @FXML
    private TableView<Celular> tabla;

    @FXML
    private TableColumn<Celular, String> colAlmacenamiento;

    @FXML
    private TableColumn<Celular, String> colCamFrontal;

    @FXML
    private TableColumn<Celular, String> colCamPrincipal;

    @FXML
    private TableColumn<Celular, String> colHuella;

    @FXML
    private TableColumn<Celular, String> colId;

    @FXML
    private TableColumn<Celular, String> colModelo;

    @FXML
    private TableColumn<Celular, String> colOs;

    @FXML
    private TableColumn<Celular, String> colRam;

    ObservableList<Celular> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colModelo.setCellValueFactory(new PropertyValueFactory<Celular,String>("modelo"));
        colCamPrincipal.setCellValueFactory(new PropertyValueFactory<Celular,String>("camaraPrincipal"));
        colCamFrontal.setCellValueFactory(new PropertyValueFactory<Celular,String>("camaraFrontal"));
        colOs.setCellValueFactory(new PropertyValueFactory<Celular,String>("sistemaOperativo"));
        colRam.setCellValueFactory(new PropertyValueFactory<Celular,String>("ram"));
        colAlmacenamiento.setCellValueFactory(new PropertyValueFactory<Celular,String>("almacenamiento"));
        colHuella.setCellValueFactory(new PropertyValueFactory<Celular,String>("huella"));
        colId.setCellValueFactory(new PropertyValueFactory<Celular,String>("id"));
        System.out.println("error");
        tabla.setItems(list);
    }


    @FXML
    void eventAgregar(ActionEvent event) {
        Celular celular = new Celular("1",modelo.getText(),os.getText(),camPrincipal.getText(),camFrontal.getText(),ram.getText(),almacenamiento.getText(),huella.getText());
        list.add(celular);
        tabla.setItems(list);
    }

    @FXML
    void eventCancelar(ActionEvent event) {
        almacenamiento.setText("");
        camFrontal.setText("");
        camPrincipal.setText("");
        huella.setText("");
        modelo.setText("");
        os.setText("");
        ram.setText("");
    }

}
