package com.example.tallerpersistencia;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Persistencia {

    public static ArrayList<Celular> leerCsvEquipos(){
        ArrayList<Celular>equipos = new ArrayList<>();
        Path filePath = Paths.get("Archivos/datosEquipo.csv");

        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;
            while ((linea = br.readLine()) != null){

                String arreglo [] = linea.split(",");
                Celular cl = new Celular();
                cl.setId(arreglo[0]);
                cl.setModelo(arreglo[1]);
                cl.setCamaraPrincipal(arreglo[2]);
                cl.setCamaraFrontal(arreglo[3]);
                cl.setSistemaOperativo(arreglo[4]);
                cl.setRam(arreglo[5]);
                cl.setAlmacenamiento(arreglo[6]);
                cl.setHuella(arreglo[7]);


                equipos.add(cl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
/*        for(Equipos a: equipos){
            System.out.println(a);
        }*/
        return equipos;
    }

    public static void escribirEquipos(ArrayList<Celular> equipo){
        File archivo = new File("Archivos/datosEquipo.csv");
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);

            for(Celular a:equipo){
                String linea = a.getId()+","+a.getModelo()+","+a.getCamaraPrincipal()+","+a.getCamaraFrontal()+","+a.getSistemaOperativo()+","+a.getRam()+","+a.getAlmacenamiento()+","+a.getHuella();
                pw.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fichero != null){
                    fichero.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
