package com.chs.appbancoafv.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chs.appbancoafv.R;
import com.google.android.material.textfield.TextInputLayout;


public class CadastroClienteEnderecosFragment extends CadastroClienteFragment {

    private TextInputLayout logradouro;
    private TextInputLayout numero;
    private TextInputLayout complemento;
    private TextInputLayout bairro;
    private TextInputLayout cep;
    private TextInputLayout uf;
    private TextInputLayout municipio;


    public static CadastroClienteEnderecosFragment newInstance(String param1, String param2) {
        CadastroClienteEnderecosFragment fragment = new CadastroClienteEnderecosFragment();
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
        View view = inflater.inflate(R.layout.fragment_cadastro_cliente_enderecos, container, false);
        logradouro = view.findViewById(R.id.textInputLogradouro);
        numero = view.findViewById(R.id.textInputNumero);
        complemento = view.findViewById(R.id.textInputComplemento);
        bairro = view.findViewById(R.id.textInputBairro);
        cep = view.findViewById(R.id.textInputCep);
        uf = view.findViewById(R.id.textInputEstado);
        municipio = view.findViewById(R.id.textInputMunicipio);

        if(getCliente() != null){
            if(getCliente().getEndereco() != null){
                if(logradouro.getEditText().getText() == null){
                    logradouro.getEditText().setText(getCliente().getEndereco());
                }
            }
            if(getCliente().getNumero() !=null){
                if(numero.getEditText().getText() == null){
                    numero.getEditText().setText(getCliente().getNumero());
                }
            }
            if(getCliente().getComplemento() != null){
                if(complemento.getEditText().getText()==null){
                    complemento.getEditText().setText(getCliente().getComplemento());
                }
            }
            if(getCliente().getBairro() !=null){
                if(bairro.getEditText().getText()==null){
                    bairro.getEditText().setText(getCliente().getBairro());
                }
            }
            if(getCliente().getCep() !=null){
                if(cep.getEditText().getText()==null){
                    cep.getEditText().setText(getCliente().getCep());
                }
            }
            if (getCliente().getCodMunicipio())
        }


        return view;
    }

    @Override
    public boolean isValid() {
        return false;
    }
}