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

public class ControllerRead implements Initializable {
    @FXML
    private Button btnBuscar;

    @FXML
    private TextField campoTexto;

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
    private RadioButton radAlmacenamiento,radHuella,radId,radMOdel,radOs,radRam;

    ArrayList<Celular> persistencia = Persistencia.leerCsvEquipos();
    ObservableList<Celular> list = FXCollections.observableArrayList();

    public ControllerRead(){

    }

    @FXML
    void eventBuscar(ActionEvent event) {

        tabla.getItems().clear();
        if(radHuella.isSelected()){
            buscarHuella(campoTexto.getText());
        }else if(radId.isSelected()){
            buscarId(campoTexto.getText());
        }else if(radOs.isSelected()){
            buscarOs(campoTexto.getText());
        }else if(radRam.isSelected()){
            buscarRam(campoTexto.getText());
        }else if(radAlmacenamiento.isSelected()){
            buscarAlmacenamiento(campoTexto.getText());
        }else if(radMOdel.isSelected()){
            buscarModelo(campoTexto.getText());
        }

        campoTexto.setText("");


    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup rad = new ToggleGroup();

        radHuella.setToggleGroup(rad);
        radId.setToggleGroup(rad);
        radOs.setToggleGroup(rad);
        radRam.setToggleGroup(rad);
        radAlmacenamiento.setToggleGroup(rad);
        radMOdel.setToggleGroup(rad);

        btnBuscar.setDisable(true);
        campoTexto.setDisable(true);

        colModelo.setCellValueFactory(new PropertyValueFactory<Celular, String>("modelo"));
        colCamPrincipal.setCellValueFactory(new PropertyValueFactory<Celular, String>("camaraPrincipal"));
        colCamFrontal.setCellValueFactory(new PropertyValueFactory<Celular, String>("camaraFrontal"));
        colOs.setCellValueFactory(new PropertyValueFactory<Celular, String>("sistemaOperativo"));
        colRam.setCellValueFactory(new PropertyValueFactory<Celular, String>("ram"));
        colAlmacenamiento.setCellValueFactory(new PropertyValueFactory<Celular, String>("almacenamiento"));
        colHuella.setCellValueFactory(new PropertyValueFactory<Celular, String>("huella"));
        colId.setCellValueFactory(new PropertyValueFactory<Celular, String>("id"));

    }

    @FXML
    void eventSelect(ActionEvent event) {


        if(radHuella.isSelected()){
            campoTexto.setPromptText("HUELLA");
        }else if(radId.isSelected()){
            campoTexto.setPromptText("ID");
        }else if(radOs.isSelected()){
            campoTexto.setPromptText("S. OPERATIVO");
        }else if(radRam.isSelected()){
            campoTexto.setPromptText("RAM");
        }else if(radAlmacenamiento.isSelected()){
            campoTexto.setPromptText("ALMACENANIEMTO");
        }else if(radMOdel.isSelected()){
            campoTexto.setPromptText("MODELO");
        }

        btnBuscar.setDisable(false);
        campoTexto.setDisable(false);
        tabla.getItems().clear();

    }

    public void buscarId(String id){

        for (Celular e:persistencia) {
            if(e.getId().equalsIgnoreCase(id)){
                list.add(e);
                tabla.setItems(list);
            }
        }
    }

    public void buscarHuella(String huella){
        ArrayList<Celular> resultado = new ArrayList<>();
        for (Celular e:persistencia) {
            if(e.getHuella().equalsIgnoreCase(huella)){
                resultado.add(e);
            }
        }

        addTable(resultado);

    }

    public void buscarOs(String os){
        ArrayList<Celular> resultado = new ArrayList<>();
        for (Celular e:persistencia) {
            if(e.getSistemaOperativo().equalsIgnoreCase(os)){
                resultado.add(e);
            }
        }

        addTable(resultado);

    }

    public void buscarRam(String ram){
        ArrayList<Celular> resultado = new ArrayList<>();
        for (Celular e:persistencia) {
            if(e.getRam().equalsIgnoreCase(ram)){
                resultado.add(e);
            }
        }

        addTable(resultado);

    }

    public void buscarAlmacenamiento(String almacenamiento){
        ArrayList<Celular> resultado = new ArrayList<>();
        for (Celular e:persistencia) {
            if(e.getAlmacenamiento().equalsIgnoreCase(almacenamiento)){
                resultado.add(e);
            }
        }

        addTable(resultado);

    }

    public void buscarModelo(String modelo){
        ArrayList<Celular> resultado = new ArrayList<>();
        for (Celular e:persistencia) {
            if(e.getModelo().equalsIgnoreCase(modelo)){
                resultado.add(e);
            }
        }

        addTable(resultado);

    }

    public void addTable(ArrayList<Celular> celulars){
        for (Celular c : celulars) {
            list.add(c);
            tabla.setItems(list);
        }
    }
}
