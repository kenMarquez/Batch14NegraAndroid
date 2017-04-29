package com.devf.quizapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devf.quizapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    public static final String ARG_TITLE = "ARG_TITLE";
    private String mTitle;

    @BindView(R.id.question_tv_title)
    TextView tvTitle;

    @BindView(R.id.question_btn_false)
    View btnFalse;

    @BindView(R.id.question_btn_true)
    View btnTrue;

    private int mValue = -1;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * New instance crea una instancia de QuestionFragment
     * Se encarga de asignar los parametros necesarios para
     * que este funcione adecuadamente
     *
     * @param title
     * @return
     */
    public static QuestionFragment newInstance(String title) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();
            mTitle = args.getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.bind(this, view);
        tvTitle.setText(mTitle);
        return view;
    }

    @OnClick({R.id.question_btn_false, R.id.question_btn_true})
    public void onClickk(View view) {
        switch (view.getId()) {
            case R.id.question_btn_false:
                mValue = 0;
                btnFalse.setBackgroundResource(R.color.btn_selected);
                btnTrue.setBackgroundResource(R.color.btn_unselected);
                break;
            case R.id.question_btn_true:
                mValue = 1;
                btnFalse.setBackgroundResource(R.color.btn_unselected);
                btnTrue.setBackgroundResource(R.color.btn_selected);
                break;
        }
    }

    public int getValue() {
        return mValue;
    }
}
