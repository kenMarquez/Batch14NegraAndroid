package com.devf.fragments.clase1;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.devf.fragments.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        changeFragment(R.id.container1, BlankFragment.newInstance(R.color.color1));


        /**
         * Obtenemos la orientación del dispositivo
         * si es 1 esta en vertical
         * 2 horizontal
         */
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == 1) {

            findViewById(R.id.container2).setVisibility(View.GONE);
//            findViewById(R.id.container3).setVisibility(View.GONE);
        } else {
//            findViewById(R.id.container3).setVisibility(View.GONE);

            changeFragment(R.id.container2, BlankFragment.newInstance(R.color.color2));
//            changeFragment(R.id.container3, BlankFragment.newInstance(R.color.color3));
        }

    }


    public void changeFragment(int resContainer, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(resContainer, fragment)
                .commit();
    }


}
