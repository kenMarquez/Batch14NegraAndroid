package com.devf.conceptosandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Clickeable clickeable = new Button();
        clickeable.onDrag();
        clickeable = new Input();
        clickeable.onDrag();
        Context context = this;
        Log.e("myLog", "OnCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("myLog", "OnStart");

    }

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public int factorial2(int n) {

        return n * factorial2(n - 1);

    }

    /**
     * Ejercicio:
     * Al estar en modo landscape , imprimir la suma de los primeros 100 números
     * ,cambiar los colores  de mi app y cambiar el texto que esta en el centro y todo
     * desde el metodo onResume del ciclo de vida de mi actividad.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("myLog", "fac: " + factorial2(20));
    }

    @Override
    protected void onPause() {
        Log.e("myLog", "OnPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("myLog", "OnStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("myLog", "OnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.e("myLog", "onRestart");
        super.onRestart();
    }


    public void click(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
