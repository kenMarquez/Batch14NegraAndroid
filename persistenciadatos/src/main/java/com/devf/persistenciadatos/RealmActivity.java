package com.devf.persistenciadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.devf.persistenciadatos.models.Usuario;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {

    private long id = 1;

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        /**
         * Le indico a Realm sobre que contexto va a trabajar
         */
        Realm.init(RealmActivity.this);

        /**
         * Inicio la configuración que va a tener realm
         */
        RealmConfiguration config = new RealmConfiguration.Builder()
                .build();

        Realm.setDefaultConfiguration(config);

        tvData = (TextView) findViewById(R.id.tv_data);
        findViewById(R.id.fab).setOnClickListener(view -> guardar());

        findViewById(R.id.btn_get_data).setOnClickListener(v -> obtenerData());


        findViewById(R.id.btn_get_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerData();
            }
        });


    }

    private void obtenerData() {
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<Usuario> query = realm.where(Usuario.class);
        RealmResults<Usuario> results = query.findAll();
        tvData.setText("");
        for (Usuario usuario : results) {
            tvData.append(usuario.toString() + "\n");
        }


    }

    private void guardar() {

        // Obtain a Realm instance
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();


        Usuario usuario = realm.createObject(Usuario.class, realm.where(Usuario.class).count() + 1);
        usuario.setEdad(35);
        usuario.setEmail("emai@algo.com");
        usuario.setNombre("Chuchito " + id);
        usuario.setTelefono(55443322);
        usuario.setNombreUsuario("Yisus");
//        usuario.setId(id++);

        realm.commitTransaction();
        Log.e("myLog", "Guardo un usuario");

    }

}


