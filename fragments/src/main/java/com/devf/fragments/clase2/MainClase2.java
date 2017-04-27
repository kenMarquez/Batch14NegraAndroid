package com.devf.fragments.clase2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.devf.fragments.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainClase2 extends AppCompatActivity implements OnPruebaInteractionListener {

    public static final String TAG_FRAGMENT_PRUEBA = "TAG_FRAGMENT_PRUEBA";

    @BindView(R.id.activity_tv)
    public TextView tvActivity;

    private PruebaFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clase2);
        ButterKnife.bind(this);

        /**
         * Creo el fragment que estare utilizando
         */
        fragment = PruebaFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, fragment,TAG_FRAGMENT_PRUEBA)
                .commit();




    }


    @Override
    public void setTextTv(String text) {
        tvActivity.setText(text);
    }

    @OnClick(R.id.activity_btn)
    public void clickActivityBtn() {
//        fragment.setTextFragment("Lo que quieras");

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_PRUEBA);
        if (fragment != null){
            if (fragment instanceof PruebaFragment){
                PruebaFragment fragment1 = (PruebaFragment) fragment;
                fragment1.setTextFragment("Lop que quieras");
            }
        }
    }
}
