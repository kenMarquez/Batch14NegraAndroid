package com.devf.recyclerview.models;

/**
 * Created by Ken on 08/05/17.
 */

public class Promocion {

    private String titulo;
    private int descuento;
    private String descripcion;
    private String url;

    public Promocion() {
    }

    public Promocion(String titulo, int descuento, String descripcion, String url) {
        this.titulo = titulo;
        this.descuento = descuento;
        this.descripcion = descripcion;
        this.url = url;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "titulo='" + titulo + '\'' +
                ", descuento=" + descuento +
                ", descripcion='" + descripcion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
