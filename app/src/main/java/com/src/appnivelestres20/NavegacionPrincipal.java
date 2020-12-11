package com.src.appnivelestres20;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class NavegacionPrincipal extends Fragment {

    private View myfragmento;
    private ImageView imageViewPrueba;


    public NavegacionPrincipal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myfragmento = inflater.inflate(R.layout.fragment_tecnicas,container,false);
        imageViewPrueba = (ImageView)myfragmento.findViewById(R.id.idTecnicas);

        return myfragmento;
    }
}