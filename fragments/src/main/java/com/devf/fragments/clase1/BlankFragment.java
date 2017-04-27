package com.devf.fragments.clase1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.devf.fragments.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    @BindView(R.id.root_layout)
    RelativeLayout relativeLayout;

    private int mResColor;


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(int resColor) {
        BlankFragment blankFragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt("color", resColor);
        blankFragment.setArguments(args);
        return blankFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            mResColor = bundle.getInt("color");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this, view);
        relativeLayout.setBackgroundResource(mResColor);
        return view;
    }

}
