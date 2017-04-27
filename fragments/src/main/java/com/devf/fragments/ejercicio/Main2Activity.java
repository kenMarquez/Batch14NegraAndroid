package com.devf.fragments.ejercicio;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.devf.fragments.R;

public class Main2Activity extends AppCompatActivity implements ContadorFragment.OnFragmentInteraction {


    public static final String TAG_CONTADOR1 = "CONTADOR1";
    public static final String TAG_CONTADOR2 = "CONTADOR2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cargarContador1();

        cargarContador2();

    }

    private void cargarContador1() {
        ContadorFragment contadorFragment = ContadorFragment.newInstace(R.color.colorCount1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout2, contadorFragment, TAG_CONTADOR2)
                .commit();
    }

    private void cargarContador2() {
        ContadorFragment contadorFragment = ContadorFragment.newInstace(R.color.colorCount2);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, contadorFragment, TAG_CONTADOR1)
                .commit();
    }


    @Override
    public void onFragmentClickListener(String tagFragment) {
        switch (tagFragment) {
            case TAG_CONTADOR1:
                incrementFragment(TAG_CONTADOR2);
                break;
            case TAG_CONTADOR2:
                incrementFragment(TAG_CONTADOR1);
                break;
        }
    }

    private void incrementFragment(String tag) {
        ContadorFragment fragment = (ContadorFragment)
                getSupportFragmentManager().findFragmentByTag(tag);

        if (fragment != null) {
            fragment.increment();
        }
    }
}
