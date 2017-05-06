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


    }

    private void obtenerData() {
        updateUser();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Usuario> results = realm.where(Usuario.class)
                .findAll();

        tvData.setText("");
        for (Usuario usuario : results) {
            tvData.append(usuario.toString() + "\n");
        }


    }

    private void guardar() {

        // Obtain a Realm instance
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        long count = realm.where(Usuario.class).count();
        Usuario usuario = realm.createObject(Usuario.class, count + 1);
        usuario.setEdad(35);
        usuario.setEmail("emai@algo.com");
        usuario.setNombre("Chuchito " + id);
        usuario.setTelefono(55443322);
        usuario.setNombreUsuario("Yisus");
//        usuario.setId(id++);

        realm.commitTransaction();
        Log.e("myLog", "Guardo un usuario");

    }

    public void updateUser() {
        // Obtain a Realm instance
        Realm realm = Realm.getDefaultInstance();

        Usuario usuario = new Usuario();
        usuario.setEdad(21);
        usuario.setEmail("emai@algo.com");
        usuario.setNombre("El Erik!! SHi shi ");
        usuario.setTelefono(55443322);
        usuario.setNombreUsuario("Yisus");
        usuario.setId(4);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(usuario);
        realm.commitTransaction();
    }


}


