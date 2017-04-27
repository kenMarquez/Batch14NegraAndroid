package com.devf.fragments.clase2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.devf.fragments.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainClase3 extends AppCompatActivity  implements OnPruebaInteractionListener{
    @BindView(R.id.activity_tv)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clase3);
        ButterKnife.bind(this);

        PruebaFragment fragment = PruebaFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, fragment)
                .commit();


    }

    public void setText(String text){
        textView.setText(text);
    }


    @Override
    public void setTextTv(String text) {
        textView.setText(text);
    }
}
