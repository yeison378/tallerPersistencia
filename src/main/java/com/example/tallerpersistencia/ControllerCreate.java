package com.example.tallerpersistencia;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerCreate implements Initializable {


    @FXML
    private TextField almacenamiento, camFrontal, camPrincipal, modelo, os, ram;

    @FXML
    private Button btnAgregar, btnCancelar;

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

    @FXML
    private ComboBox<String> huellaBox;
    ArrayList<Celular> persistencia = Persistencia.leerCsvEquipos();

    ObservableList<Celular> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colModelo.setCellValueFactory(new PropertyValueFactory<Celular, String>("modelo"));
        colCamPrincipal.setCellValueFactory(new PropertyValueFactory<Celular, String>("camaraPrincipal"));
        colCamFrontal.setCellValueFactory(new PropertyValueFactory<Celular, String>("camaraFrontal"));
        colOs.setCellValueFactory(new PropertyValueFactory<Celular, String>("sistemaOperativo"));
        colRam.setCellValueFactory(new PropertyValueFactory<Celular, String>("ram"));
        colAlmacenamiento.setCellValueFactory(new PropertyValueFactory<Celular, String>("almacenamiento"));
        colHuella.setCellValueFactory(new PropertyValueFactory<Celular, String>("huella"));
        colId.setCellValueFactory(new PropertyValueFactory<Celular, String>("id"));

        huellaBox.setItems(FXCollections.observableArrayList("Si", "No"));

        tabla.setItems(list);
        agregaraTabla();
    }


    @FXML
    void eventAgregar(ActionEvent event) {
        int id = Integer.parseInt(persistencia.get(persistencia.size() - 1).getId()) + 1;
        Celular celular = new Celular(id + "", modelo.getText(), os.getText(), camPrincipal.getText(), camFrontal.getText(), ram.getText(), almacenamiento.getText(), huellaBox.getValue());
        persistencia.add(celular);
        Persistencia.escribirEquipos(persistencia);
        list.add(celular);
        tabla.setItems(list);
    }

    @FXML
    void eventCancelar(ActionEvent event) {
        almacenamiento.setText("");
        camFrontal.setText("");
        camPrincipal.setText("");
        modelo.setText("");
        os.setText("");
        ram.setText("");

    }

    public void agregaraTabla() {
        for (Celular c : persistencia) {
            list.add(c);
            tabla.setItems(list);
        }
    }

}
