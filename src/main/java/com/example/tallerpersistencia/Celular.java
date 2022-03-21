package com.example.tallerpersistencia;

public class Celular {

    private String id;
    private String modelo;
    private String sistemaOperativo;
    private String camaraPrincipal;
    private String camaraFrontal;
    private String ram;
    private String almacenamiento;
    private String huella;

    public Celular(){

    }

    public Celular(String id, String modelo, String sistemaOperativo, String camaraPrincipal, String camaraFrontal, String ram, String almacenamiento, String huella) {
        this.id = id;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.camaraPrincipal = camaraPrincipal;
        this.camaraFrontal = camaraFrontal;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.huella = huella;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getCamaraPrincipal() {
        return camaraPrincipal;
    }

    public void setCamaraPrincipal(String camaraPrincipal) {
        this.camaraPrincipal = camaraPrincipal;
    }

    public String getCamaraFrontal() {
        return camaraFrontal;
    }

    public void setCamaraFrontal(String camaraFrontal) {
        this.camaraFrontal = camaraFrontal;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }
}
