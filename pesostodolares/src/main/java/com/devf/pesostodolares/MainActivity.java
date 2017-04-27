package com.devf.pesostodolares;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Variables globales que vamos a utlilizar en varios metodos
     */
    EditText inputPesos;
    EditText inputDolares;

    Button btnConvertirPtoD;
    Button btnConvertirDtoP;
    View rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Referenciamos los EditeText que estan en mi layout
         * los obtenemos mediante el id y los tenemos que castear al
         * tipo de vista que estamos creando
         */
        this.inputPesos = (EditText) findViewById(R.id.input_pesos);
        this.inputDolares = (EditText) findViewById(R.id.input_dolares);
        this.btnConvertirPtoD = (Button) findViewById(R.id.btn_convertir_a_dolres);
        this.btnConvertirDtoP = (Button) findViewById(R.id.btn_convertir_a_pesos);
        this.rootView = findViewById(R.id.layout_root);

        /**
         * Agregamos el escuchador a los botones del evento de click
         */
        this.btnConvertirDtoP.setOnClickListener(this);
        this.btnConvertirPtoD.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        /**
         * Con el swich identificamos que tipo de vista es ala que se le esta dando click
         */
        switch (view.getId()) {
            case R.id.btn_convertir_a_dolres:
                //Convertimos pesos a dolares

                //validar que no este vacio el campo de pesos
                if (!inputPesos.getText().toString().isEmpty()) {
                    //obtenemos el texto del input de dolares
                    String dolares = inputPesos.getText().toString();
                    //Convertimos el valor a flotante
                    float dolaresFloat = Float.parseFloat(dolares);
                    //Hacemos la conversión a pesos
                    float pesos = dolaresFloat / 18.79f;
                    //Mostramos el resultado en el input de pesos
                    inputDolares.setText(pesos + "");

                } else {

                    Toast.makeText(MainActivity.this, R.string.message_empty_input, Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_convertir_a_pesos:
                //Convertimos dolares a pesos

                //validar que no este vacio el campo de dolares
                if (!inputDolares.getText().toString().isEmpty()) {
                    //obtenemos el texto del input de dolares
                    String dolares = inputDolares.getText().toString();
                    //Convertimos el valor a flotante
                    float dolaresFloat = Float.parseFloat(dolares);
                    //Hacemos la conversión a pesos
                    float pesos = dolaresFloat * 18.79f;
                    //Mostramos el resultado en el input de pesos
                    inputPesos.setText(pesos + "");

                } else {
                    Snackbar.make(rootView, R.string.message_empty_input, Snackbar.LENGTH_SHORT).show();
                }
                break;

        }


    }


}
