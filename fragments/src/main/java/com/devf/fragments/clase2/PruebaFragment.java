package com.devf.fragments.clase2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.devf.fragments.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PruebaFragment extends Fragment {

    @BindView(R.id.fragment_tv)
    TextView tvFragment;

    private OnPruebaInteractionListener mListener;


    public PruebaFragment() {
        // Required empty public constructor
    }

    /**
     * Crea una instancia de Prueba fragment
     *
     * @return
     */
    public static PruebaFragment newInstance() {
        PruebaFragment pruebaFragment = new PruebaFragment();
        return pruebaFragment;
    }

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);




        if (context instanceof OnPruebaInteractionListener) {
            mListener = (OnPruebaInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prueba, container, false);
        //Inicializo butterknife con el fragmento y la vista con la que estara trabajando
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * Metodo que se ejecuta cuando el boton del fragment es precionado
     */
    @OnClick(R.id.fragment_btn)
    public void onClickFragmentBtn() {
        if (mListener != null) {
            mListener.setTextTv("asljdalksdj");
        }

    }

    /**
     * Al texview del fragmento le asignare el texto que viene como
     * parametro
     *
     * @param text
     */
    public void setTextFragment(String text) {
        tvFragment.setText(text);
    }


    /**
     * ÑERA!!!
     */
//        if (getActivity() instanceof MainClase2) {
//            MainClase2 mainClase2 = (MainClase2) getActivity();
//            mainClase2.setTvActivityText("Texto cambiado desde el fragmento");
//        } else if (getActivity() instanceof MainClase3) {
//            MainClase3 mainClase3 = (MainClase3) getActivity();
//            mainClase3.setText("texto coambiado desde el fragmento 3");
//        }


}
