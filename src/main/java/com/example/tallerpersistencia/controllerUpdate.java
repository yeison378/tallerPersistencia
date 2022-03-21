package com.example.tallerpersistencia;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controllerUpdate implements Initializable {

    @FXML
    private TextField OS,almacenamiento,camFrontal,camPrincipal,campoId,modelo,ram,id;


    @FXML
    private Button btnActualizar,btnBuscar,btnCancelar;


    @FXML
    private ComboBox<String> huella;

    @FXML
    private Label textEncontrado,textNoEncontrado,objetoActualizado,actualizacionCacelada;


    ArrayList<Celular> persistencia = Persistencia.leerCsvEquipos();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    descativarBtn();
    huella.setItems(FXCollections.observableArrayList("Si", "No"));

    textEncontrado.setVisible(false);
    textNoEncontrado.setVisible(false);
    objetoActualizado.setVisible(false);
    actualizacionCacelada.setVisible(false);

    btnCancelar.setDisable(true);
    }

    @FXML
    void eventActualizar(ActionEvent event) {
        actualizacion();
        textEncontrado.setVisible(false);
        textNoEncontrado.setVisible(false);

        descativarBtn();
        objetoActualizado.setVisible(true);
        btnCancelar.setDisable(true);
    }

    @FXML
    void eventFoco(MouseEvent event) {
        objetoActualizado.setVisible(false);
        actualizacionCacelada.setVisible(false);
    }

    @FXML
    void eventBuscar(ActionEvent event) {
        textEncontrado.setVisible(false);
        textNoEncontrado.setVisible(false);

        activarCampos(campoId.getText());
    }

    @FXML
    void eventCancelar(ActionEvent event) {
        textEncontrado.setVisible(false);
        textNoEncontrado.setVisible(false);

        descativarBtn();

        actualizacionCacelada.setVisible(true);

        btnCancelar.setDisable(true);
    }

    public void descativarBtn(){
        OS.setDisable(true);
        almacenamiento.setDisable(true);
        camFrontal.setDisable(true);
        camPrincipal.setDisable(true);
        modelo.setDisable(true);
        ram.setDisable(true);
        id.setDisable(true);
        btnActualizar.setDisable(true);
        huella.setDisable(true);

        OS.setText("");
        almacenamiento.setText("");
        camFrontal.setText("");
        camPrincipal.setText("");
        modelo.setText("");
        ram.setText("");
        id.setText("");
        huella.getSelectionModel().clearSelection();

        campoId.setText("");
        campoId.setDisable(false);
        btnBuscar.setDisable(false);
    }

    public void activarBtn(){
        OS.setDisable(false);
        almacenamiento.setDisable(false);
        camFrontal.setDisable(false);
        camPrincipal.setDisable(false);
        modelo.setDisable(false);
        ram.setDisable(false);
//        id.setDisable(false);
        btnActualizar.setDisable(false);
        huella.setDisable(false);

        campoId.setDisable(true);
        btnBuscar.setDisable(true);
    }

    public int buscarId(String id){
        for (int i = 0; i < persistencia.size(); i++) {
            if(persistencia.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }

    public void activarCampos(String id){
        if(buscarId(id) != -1){
            textEncontrado.setVisible(true);
            setCampos(buscarId(id));
            activarBtn();
            btnCancelar.setDisable(false);

        }else{
            textNoEncontrado.setVisible(true);
        }
    }

    public void setCampos(int i){

        OS.setText(persistencia.get(i).getSistemaOperativo());
        almacenamiento.setText(persistencia.get(i).getAlmacenamiento());
        camFrontal.setText(persistencia.get(i).getCamaraFrontal());
        camPrincipal.setText(persistencia.get(i).getCamaraPrincipal());
        modelo.setText(persistencia.get(i).getModelo());
        ram.setText(persistencia.get(i).getRam());
        id.setText(persistencia.get(i).getId());
        if(persistencia.get(i).getHuella().equalsIgnoreCase("si")){
            huella.getSelectionModel().select(0);
        }else if(persistencia.get(i).getHuella().equalsIgnoreCase("no")){
            huella.getSelectionModel().select(1);
        }

        huella.setDisable(true);

    }
    public void actualizacion(){
        int i = buscarId(id.getText());
//        System.out.println(i+" "+id.getId());
        Celular cl = new Celular();
        cl.setId(id.getText());
        cl.setModelo(modelo.getText());
        cl.setCamaraPrincipal(camPrincipal.getText());
        cl.setCamaraFrontal(camFrontal.getText());
        cl.setSistemaOperativo(OS.getText());
        cl.setRam(ram.getText());
        cl.setAlmacenamiento(almacenamiento.getText());
        cl.setHuella(huella.getValue());

        persistencia.set(i,cl);
        Persistencia.escribirEquipos(persistencia);


    }


}
