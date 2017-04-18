package com.devf.claseobjetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Pelicula pelicula = new Pelicula("Moana", 100f);
        Documental documental = new Documental("Vida salvaje", 50f);

        reproducirLoqueSea(pelicula);
        reproducirLoqueSea(documental);
    }

    public void reproducirPelicula(Pelicula pelicula) {
        pelicula.reproducir();
    }

    private void reproducirDocumental(Documental documental) {
        documental.reproducir();
    }

    public void reproducirLoqueSea(Largometraje largometraje) {
        if (largometraje instanceof Pelicula) {
            Pelicula pelicula = (Pelicula) largometraje;
            pelicula.reproducir();
        }else if (largometraje instanceof  Documental){
            Documental documental = (Documental) largometraje;
            documental.reproducir();
        }



    }


}
