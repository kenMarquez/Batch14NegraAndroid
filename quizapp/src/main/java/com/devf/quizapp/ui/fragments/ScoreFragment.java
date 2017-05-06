package com.devf.quizapp.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devf.quizapp.R;
import com.devf.quizapp.models.Historial;

import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreFragment extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_SCORE = "score";

    private int score;
    private String name;


    public ScoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters
     *
     * @return A new instance of fragment ScoreFragment.
     */
    public static ScoreFragment newInstance(String name, int score) {
        ScoreFragment fragment = new ScoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_SCORE, score);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            score = getArguments().getInt(ARG_SCORE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        ButterKnife.bind(this, view);
        TextView tvUserName = (TextView) view.findViewById(R.id.tv_username);
        TextView tvPuntaje = (TextView) view.findViewById(R.id.tv_puntaje);


        tvUserName.setText(name);
        tvPuntaje.setText(score + "");

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        long count = realm.where(Historial.class).count();
        Historial historial = realm.createObject(Historial.class, count + 1);
        historial.setScore(score);
        historial.setUserName(name);
        realm.commitTransaction();
        return view;
    }


}
