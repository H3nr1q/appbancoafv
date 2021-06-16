package com.chs.appbancoafv.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chs.appbancoafv.R;


public class CadastroClienteBasicoFragment extends Fragment {

    public CadastroClienteBasicoFragment() {
        // Required empty public constructor
    }

    public static CadastroClienteBasicoFragment newInstance(String param1, String param2) {
        CadastroClienteBasicoFragment fragment = new CadastroClienteBasicoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_cliente_basico, container, false);
    }
}