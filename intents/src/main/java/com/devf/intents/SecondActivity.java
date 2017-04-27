package com.devf.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Referencio el textview
        TextView tvUsername = (TextView) findViewById(R.id.tv_username);
        //Obtengo el intent que llamo esta actividad y
        //obtengo el bundle de esta misma
        Bundle extras = getIntent().getExtras();
        //Verifico que el bundle no sea null
        if (extras != null) {
            //Obtengo el texto de username guardado en el bundle
            String username = extras.getString(Constants.INTENT_KEY_USERNAME);
            //Le asigno el texto de username a mi textview
            tvUsername.setText(username);
        }

        findViewById(R.id.btn_regresar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Creo el intent que regresare
        Intent returnIntent = new Intent();
        //Configuro los datos que regresare en el intent
        returnIntent.putExtra(Constants.INTENT_KEY_SALUDO, "Hola como estas");
        //ejecuto el metodo para avisar que estoy retornando algo
        setResult(RESULT_OK, returnIntent);
        //Finalizo mi actividad
        finish();

    }

}
