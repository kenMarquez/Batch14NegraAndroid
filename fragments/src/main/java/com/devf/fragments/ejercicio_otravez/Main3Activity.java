package com.devf.fragments.ejercicio_otravez;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.devf.fragments.R;
import com.devf.fragments.ejercicio.ContadorFragment;

public class Main3Activity extends AppCompatActivity implements ContadorFragment2.OnFragmentInteractionListener {

    public static final String TAG_CONTADOR1 = "CONTADOR1";
    public static final String TAG_CONTADOR2 = "CONTADOR2";
    private ContadorFragment2 contador1Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        cargarContador1();
        cargarContador2();


    }

    private void cargarContador1() {
        contador1Fragment = ContadorFragment2.newInstance(R.color.colorCount1);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, contador1Fragment, TAG_CONTADOR1)
                .commit();
    }

    private void cargarContador2() {
        ContadorFragment2 fragment = ContadorFragment2.newInstance(R.color.colorCount2);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container2, fragment, TAG_CONTADOR2)
                .commit();
    }


    @Override
    public void onContadorClick(String tag) {
        switch (tag) {
            case TAG_CONTADOR1:
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentByTag(TAG_CONTADOR2);
                if (fragment != null && fragment instanceof ContadorFragment2) {
                    ContadorFragment2 contadorFragment = (ContadorFragment2) fragment;
                    contadorFragment.sumarFragment();
                }
                break;
            case TAG_CONTADOR2:
                contador1Fragment.sumarFragment();
                break;
        }
    }
}
