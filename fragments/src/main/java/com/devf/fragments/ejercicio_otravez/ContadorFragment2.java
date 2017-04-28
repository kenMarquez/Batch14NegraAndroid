package com.devf.fragments.ejercicio_otravez;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devf.fragments.R;
import com.devf.fragments.ejercicio.ContadorFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContadorFragment2 extends Fragment {

    public static final String ARG_COLOR = "ARG_COLOR";

    @BindView(R.id.contador_tv_count)
    TextView tvContador;

    @BindView(R.id.contador_root_layout)
    RelativeLayout rootLayout;

    private int mResColor;
    private OnFragmentInteractionListener mListener;


    public ContadorFragment2() {
        // Required empty public constructor
    }

    public static ContadorFragment2 newInstance(int resColor) {
        ContadorFragment2 fragment = new ContadorFragment2();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, resColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();
            mResColor = args.getInt(ARG_COLOR);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contador_fragment2, container, false);
        ButterKnife.bind(this, view);
        rootLayout.setBackgroundResource(mResColor);
        return view;
    }


    @OnClick(R.id.contador_root_layout)
    public void onRootLayoutClick() {
        mListener.onContadorClick(getTag());
    }

    public void sumarFragment() {
        int value = Integer.parseInt(tvContador.getText().toString());
        tvContador.setText((value + 1) + "");
    }

    public interface OnFragmentInteractionListener {

        public void onContadorClick(String tag);

    }

}
