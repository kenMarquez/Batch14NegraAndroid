package com.devf.claseobjetos;

import android.util.Log;

/**
 * Created by Ken on 06/04/17.
 */

public class Documental extends Largometraje {

    private String conflicto;


    public Documental(String nombre, float precio) {
        super(nombre, precio);
    }

    public void reproducir() {
        Log.e("myLog", "Reproduciendo documental : " + getNombre());
    }

    public String getConflicto() {
        return conflicto;
    }

    public void setConflicto(String conflicto) {
        this.conflicto = conflicto;
    }
}
