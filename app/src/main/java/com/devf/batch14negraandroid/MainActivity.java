package com.devf.batch14negraandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        estructuraDeDatos();

    }

    public void estructuraDeDatos() {

        //arreglo
        String[] miArreglo;
        miArreglo = new String[10];
        miArreglo = new String[]{"1","2","3"};


        for (int i = 0; i < miArreglo.length; i++) {
            miArreglo[i] = "Posición" + i;
            Log.e("myLog", miArreglo[i]);
        }

        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(1);
        listaEnteros.add(2);
        listaEnteros.add(3);
        listaEnteros.add(4);


        Log.e("myLog", sumaLista(listaEnteros) + "");
    }

    public int sumaLista(List<Integer> listaEnteros) {
        int suma = 0;
        for (int i = 0; i < listaEnteros.size(); i++) {
            suma = suma + listaEnteros.get(i);
        }
        return suma;
    }


}
