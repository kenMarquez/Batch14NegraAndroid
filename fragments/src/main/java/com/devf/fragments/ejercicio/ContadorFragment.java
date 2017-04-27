package com.devf.fragments.ejercicio;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devf.fragments.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContadorFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_COLOR = "ARG_COLOR";
    private int resColor;

    private int contador;
    private TextView tvContador;
    private OnFragmentInteraction mListener;


    public static ContadorFragment newInstace(int resColor) {
        //Creo una intancia de CuartoFragment
        ContadorFragment fragment = new ContadorFragment();
        //Creo el bundle que guardara los datos que guardare en mi fragmneto
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, resColor);
        //Asocio mi bundle a mi fragmento
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            //obtengo los bundle de mi fragmento
            Bundle bundle = getArguments();
            //obtengo el color que tenía guardado
            resColor = bundle.getInt(ARG_COLOR);
        }
    }

    public ContadorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contador1, container, false);
        View rooLayout = view.findViewById(R.id.contador_root_layout);

        tvContador = (TextView) view.findViewById(R.id.contador_tv_count);
        tvContador.setText("" + 0);

        rooLayout.setBackgroundResource(resColor);
        rooLayout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Main2Activity) {
            mListener = (Main2Activity) context;
        }
    }

    public void increment() {
        tvContador.setText("" + contador++);
    }

    @Override
    public void onClick(View view) {
        mListener.onFragmentClickListener(getTag());
    }

    public interface OnFragmentInteraction {

        public void onFragmentClickListener(String tagFragment);
    }
}
