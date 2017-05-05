package com.devf.persistenciadatos.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ken on 04/05/17.
 */

public class Usuario extends RealmObject {

    private String nombre;
    private String nombreUsuario;
    private int edad;
    private int telefono;
    private String email;
    @PrimaryKey
    private long id;


    public Usuario() {
    }

    public Usuario(String nombre, String nombreUsuario, int edad, int telefono, String email, long id) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name " + nombre + " edad: " + edad;
    }
}
