package com.devf.quizapp.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.devf.quizapp.R;
import com.devf.quizapp.models.Historial;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class HistorialActivity extends AppCompatActivity {

    @BindView(R.id.tv_historial)
    public TextView tvHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        ButterKnife.bind(this);

        getHistorial();
    }

    private void getHistorial() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Historial> historialList = realm.where(Historial.class)
                .findAll();

        historialList = historialList.sort("score", Sort.DESCENDING);
        tvHistorial.setText("");
        for (int i = 0; i < historialList.size(); i++) {
            Historial historial = historialList.get(i);
            tvHistorial.append(i + "- " +
                    historial.getUserName() +
                    " puntaje: " + historial.getScore() +
                    "\n");
        }
    }


}
