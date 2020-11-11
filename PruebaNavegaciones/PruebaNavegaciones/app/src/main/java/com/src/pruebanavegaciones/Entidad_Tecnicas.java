package com.src.pruebanavegaciones;

import java.io.Serializable;

public class Entidad_Tecnicas implements Serializable {
    private int imgFoto;
    private String titulo;
    private String contenido;

    public Entidad_Tecnicas(int imgFoto, String titulo, String contenido){
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getImgFoto() { return imgFoto;}

    public String getTitulo() {return titulo;}

    public String getContenido() {return contenido;}
}