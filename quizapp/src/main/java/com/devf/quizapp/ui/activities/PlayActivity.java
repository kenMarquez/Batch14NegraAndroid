package com.devf.quizapp.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.devf.quizapp.ui.fragments.ScoreFragment;
import com.devf.quizapp.utils.Constants;
import com.devf.quizapp.R;

import com.devf.quizapp.models.Pregunta;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.devf.quizapp.ui.fragments.QuestionFragment;

public class PlayActivity extends AppCompatActivity {

    @BindView(R.id.play_tv_username)
    TextView tvUserName;

    private String mUserName;

    private List<Pregunta> mListPreguntas = new ArrayList<>();

    private int mQuestionPosition;

    private int mContador;
    private QuestionFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        getIntentData();
        getData();
        initViews();


        /**
         * Inicio la primer pregunta
         */
        changeFragment(QuestionFragment.newInstance(mListPreguntas.get(mQuestionPosition = 0).getTitle()));

    }


    /**
     * Inicializamos la lista de preguntas con sus respuestas correctas
     */
    private void getData() {
        mListPreguntas.add(new Pregunta(getString(R.string.question1), 1));
        mListPreguntas.add(new Pregunta(getString(R.string.question2), 0));
        mListPreguntas.add(new Pregunta(getString(R.string.question3), 1));
        mListPreguntas.add(new Pregunta(getString(R.string.question4), 0));
        mListPreguntas.add(new Pregunta(getString(R.string.question5), 0));
    }

    private void initViews() {
        tvUserName.setText(mUserName);
    }

    /**
     * Obtenemos los datos del intent
     */
    public void getIntentData() {
        /**
         * Obtenemos el intent que mando a llamar esta actividad y
         * obtenemos el bundle que contiene
         */
        Bundle extras = getIntent().getExtras();
        //Verificamos que tenga datos el Bundle
        if (extras != null) {
            //Obtenemos el username guardado en los extras
            mUserName = extras.getString(Constants.INTENT_KEY_USERNAME);
        }
    }


    @OnClick(R.id.quiz_img_arrow_right)
    public void next() {

        int respuesta = mFragment.getValue();
        if (respuesta == -1) {
            Toast.makeText(PlayActivity.this, "Debes elegir una respuesta " + mContador, Toast.LENGTH_LONG).show();
        } else {

            if (respuesta == mListPreguntas.get(mQuestionPosition).getValue()) {
                mContador++;
            }


            if (mQuestionPosition < mListPreguntas.size() - 1) {
                changeFragment(QuestionFragment.newInstance(mListPreguntas.get(++mQuestionPosition).getTitle()));
            } else {
                Toast.makeText(PlayActivity.this, "Tu puntaje es: " + mContador, Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_rigth_enter, R.anim.slide_left_exit)
                        .replace(R.id.frame_layout, ScoreFragment.newInstance(mUserName, mContador))
                        .commit();
            }
        }

    }


    /**
     * Metodo para cambiar el fragmento que esta en el frame layout de la pantalla
     *
     * @param fragment
     */
    public void changeFragment(QuestionFragment fragment) {
        /**
         *Obtengo el FragmentManaget que me ayuda con las transacciones
         *que necesite hacer con mis fragmentos
         */
        mFragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_rigth_enter, R.anim.slide_left_exit)
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}
