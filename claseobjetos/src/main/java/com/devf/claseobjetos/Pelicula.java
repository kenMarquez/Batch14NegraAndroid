package com.devf.claseobjetos;

import android.util.Log;

/**
 * Created by Ken on 06/04/17.
 */

public class Pelicula extends Largometraje {


    private int noActores;
    private String efectos;
    private String sinopsis;


    public Pelicula(String nombre, float precio) {
        super(nombre, precio);
    }

    public void reproducir() {
        Log.e("myLog", "Reproduciendo pelicula : " + getNombre());
    }

    public int getNoActores() {
        return noActores;
    }

    public void setNoActores(int noActores) {
        this.noActores = noActores;
    }

    public String getEfectos() {
        return efectos;
    }

    public void setEfectos(String efectos) {
        this.efectos = efectos;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
