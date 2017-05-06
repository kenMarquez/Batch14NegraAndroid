package com.devf.persistenciadatos;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Ken on 05/05/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * Le indico a Realm sobre que contexto va a trabajar
         */
        Realm.init(this);

        /**
         * Inicio la configuración que va a tener realm
         */
        RealmConfiguration config = new RealmConfiguration.Builder()
                .build();

        Realm.setDefaultConfiguration(config);
    }
}
