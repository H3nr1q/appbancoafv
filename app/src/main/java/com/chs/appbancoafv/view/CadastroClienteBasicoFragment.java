package com.chs.appbancoafv.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.model.Cliente;
import com.chs.appbancoafv.utils.MaskEditUtil;
import com.chs.appbancoafv.utils.StringUtils;
import com.chs.appbancoafv.utils.ValidarEmailUtils;
import com.google.android.material.textfield.TextInputLayout;


public class CadastroClienteBasicoFragment extends CadastroClienteFragment {
    TextInputLayout razaoSocial;
    TextInputLayout nomeFantasia;
    TextInputLayout fonePrincipal;
    TextInputLayout foneSecundario;
    TextInputLayout emailPrincipal;
    TextInputLayout emailSecundario;
    String tipoPessoa;
    TextWatcher textWatcher;
    private Cliente cliente;
    static ValidarEmailUtils validarEmailUtils;

    public CadastroClienteBasicoFragment() {
        // Required empty public constructor
    }


    public static CadastroClienteBasicoFragment newInstance(Cliente cliente) {
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
        View view = inflater.inflate(R.layout.fragment_cadastro_cliente_basico, container, false);
        razaoSocial =  view.findViewById(R.id.textInputRazao);
        nomeFantasia = view.findViewById(R.id.txtInputFantasia);
        fonePrincipal = view.findViewById(R.id.textInputTelefone);
        foneSecundario = view.findViewById(R.id.textInputTelefoneSec);
        emailPrincipal = view.findViewById(R.id.textInputEmail);
        emailSecundario = view.findViewById(R.id.textInputEmailSec);
        validarEmailUtils = new ValidarEmailUtils();

        if (getCliente() != null){
            if(getCliente().getRazao() != null){
                if(razaoSocial.getEditText().getText() == null){
                    razaoSocial.getEditText().setText(getCliente().getRazao());
                }
            }
            if(getCliente().getFantasia() != null){
                if (nomeFantasia.getEditText().getText() == null){
                    nomeFantasia.getEditText().setText(getCliente().getFantasia());
                }
            }
            if(getCliente().getTelefone() != null){
                if(fonePrincipal.getEditText().getText() == null){
                    fonePrincipal.getEditText().setText(getCliente().getTelefone());
                }
            }
            if (getCliente().getFax() != null){
                if(foneSecundario.getEditText().getText() == null){
                    foneSecundario.getEditText().setText(getCliente().getFax());
                }
            }
            if (getCliente().getEmail() != null){
                if(emailPrincipal.getEditText().getText() == null){
                    emailPrincipal.getEditText().setText(getCliente().getEmail());
                }
            }
            if (getCliente().getEmailNf() != null){
                if(emailSecundario.getEditText().getText() == null){
                    emailSecundario.getEditText().setText(getCliente().getEmailNf());
                }
            }
            razaoSocial.getEditText().setText(getCliente().getRazao());
            nomeFantasia.getEditText().setText(getCliente().getFantasia());
            fonePrincipal.getEditText().setText(getCliente().getTelefone());
            foneSecundario.getEditText().setText(getCliente().getFax());
            emailPrincipal.getEditText().setText(getCliente().getEmail());
            emailSecundario.getEditText().setText(getCliente().getEmailNf());

        }


        if(getActivity() != null) {
            if (getCliente() != null) {
                if (getActivity().getIntent().getStringExtra("cgccpf") != null) {
                    getCliente().setCgccpf(getActivity().getIntent().getStringExtra("cgccpf"));
                    tipoPessoa = getActivity().getIntent().getStringExtra("tipoPessoa");
                    getCliente().setTipoPessoa(tipoPessoa);
                    if (tipoPessoa.equals("J")) {
                        nomeFantasia.setVisibility(View.VISIBLE);
                    }
                } else{
                    if (getCliente().getFantasia() != null){
                        if (!getCliente().getFantasia().isEmpty()){
                            nomeFantasia.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        }

        return view;
   }

    @Override
    public boolean isValid() {

        boolean isValid = true;

        if (razaoSocial != null){
            if(StringUtils.isNullOrEmpty(razaoSocial.getEditText().getText().toString())){
                razaoSocial.setError("Campo obrigatório");
                isValid = false;
            }else if (razaoSocial.getError() !=null){
                razaoSocial.setError(null);
            }
            if (getCliente() != null){
                getCliente().setRazao(razaoSocial.getEditText().getText().toString());
            }
        }

        if(nomeFantasia != null && nomeFantasia.getVisibility() == View.VISIBLE){
            if (StringUtils.isNullOrEmpty(nomeFantasia.getEditText().getText().toString())){
                nomeFantasia.setError("Campo obrigatório");
                isValid = false;
            }else if (nomeFantasia.getError() != null){
                nomeFantasia.setError(null);
            }
            if (getCliente() != null){
                getCliente().setFantasia(nomeFantasia.getEditText().getText().toString());
            }

        }

        if(fonePrincipal != null){
            if(StringUtils.isNullOrEmpty(fonePrincipal.getEditText().getText().toString())){
                fonePrincipal.setError("Campo obrigatório");;
                isValid = false;
            } else if (fonePrincipal.getError()!=null){
                fonePrincipal.setError(null);
            }
            if(getCliente() != null){
                getCliente().setTelefone(fonePrincipal.getEditText().getText().toString());
            }
        }

        if(foneSecundario != null){
            if(StringUtils.isNullOrEmpty(foneSecundario.getEditText().getText().toString())){
                foneSecundario.setError("Campo obritarório");
                isValid = false;
            }else if(foneSecundario.getError() !=null){
                foneSecundario.setError(null);
            }
            if (getCliente()!=null){
                getCliente().setFax(foneSecundario.getEditText().getText().toString());
            }
        }

        if(emailPrincipal !=null){
            if(StringUtils.isNullOrEmpty(emailPrincipal.getEditText().getText().toString())){
                emailPrincipal.setError("Campo obrigatório");
                isValid = false;
            }else if(validarEmailUtils.isValidEmailAdrressRegex(
                    emailPrincipal.getEditText().getText().toString().trim()) == false){
                emailPrincipal.setError("Formato de e-mail inválido");
                isValid = false;
            } else if(emailPrincipal.getError() !=null){
                emailPrincipal.setError(null);
            }
            if (getCliente() != null){
                getCliente().setEmail(emailPrincipal.getEditText().getText().toString());
            }
        }

        if(emailSecundario !=null) {
            if (StringUtils.isNullOrEmpty(emailSecundario.getEditText().getText().toString())) {
                emailSecundario.setError("Campo obrigatório");
                isValid = false;
            } else if (validarEmailUtils.isValidEmailAdrressRegex(
                    emailSecundario.getEditText().getText().toString().trim()) == false) {
                emailSecundario.setError("Formato de e-mail inválido");
                isValid = false;
            } else if (emailSecundario.getError() != null) {
                emailSecundario.setError(null);
            }
            if (getCliente() != null) {
                getCliente().setEmailNf(emailSecundario.getEditText().getText().toString());
            }
        }

        return isValid;


    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

}