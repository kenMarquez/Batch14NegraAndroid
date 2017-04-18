package com.devf.claseobjetos;

/**
 * Created by Ken on 06/04/17.
 */

public class Largometraje {

    private String nombre;
    private int audiencia;
    private int duracion;
    private float precio;

    public Largometraje(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Largometraje{" +
                "nombre='" + nombre + '\'' +
                ", audiencia=" + audiencia +
                ", duracion=" + duracion +
                ", precio=" + precio +
                '}';
    }


}
