package com.chs.appbancoafv.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chs.appbancoafv.R;
import com.google.android.material.textfield.TextInputLayout;


public class CadastroClienteBasicoFragment extends Fragment {
    TextInputLayout razaoSocial;
    TextInputLayout nomeFantasia;
    TextInputLayout fonePrincipal;
    TextInputLayout foneSecundario;
    TextInputLayout emailPrincipal;
    TextInputLayout emailSecundario;
    String tipoPessoa;

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
        Intent intent = new Intent();
        tipoPessoa = intent.getStringExtra("tipoPessoa");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_cliente_basico, container, false);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);


    }

    public void bindViews(View view){
        razaoSocial =  view.findViewById(R.id.textInputRazao);
        nomeFantasia = view.findViewById(R.id.txtInputFantasia);
        if (tipoPessoa == "J") {
            nomeFantasia.setVisibility(View.VISIBLE);
        }
        fonePrincipal = view.findViewById(R.id.textInputTelefone);
        foneSecundario = view.findViewById(R.id.textInputTelefoneSec);
        emailPrincipal = view.findViewById(R.id.textInputEmail);
        emailSecundario = view.findViewById(R.id.textInputEmailSec);


    }
}