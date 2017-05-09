package com.devf.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.devf.recyclerview.models.Promocion;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    List<Promocion> mPromos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        poblarPromos();
        settingRecyclerView();
    }

    public void poblarPromos() {
        mPromos.add(new Promocion("Audifonos", 40, getString(R.string.text_description_dummy), ""));
        mPromos.add(new Promocion("Tv 50 LED Smart TV", 10, getString(R.string.text_description_dummy), ""));
        mPromos.add(new Promocion("Bocinas 5000 WATS", 20, getString(R.string.text_description_dummy), ""));
        mPromos.add(new Promocion("Mac Book pro 13 ", 90, getString(R.string.text_description_dummy), ""));
        mPromos.add(new Promocion("Dron ", 40, getString(R.string.text_description_dummy), ""));
        mPromos.add(new Promocion("Iphone 10 plus", 1, getString(R.string.text_description_dummy), ""));
        mPromos.add(new Promocion("Pizza", 15, getString(R.string.text_description_dummy), ""));

    }

    private void settingRecyclerView() {

        PromoAdapter promoAdapter = new PromoAdapter(mPromos);

        //LayoutManager Como se mostraran los elementos
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //Adaptador de los elementos
        recyclerView.setAdapter(promoAdapter);


    }
}
