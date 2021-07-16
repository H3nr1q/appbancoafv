package com.chs.appbancoafv.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.model.Cliente;
import com.chs.appbancoafv.utils.MaskEditUtil;
import com.chs.appbancoafv.utils.StringUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DialogNewCliente extends DialogFragment implements View.OnClickListener{
    View mView;
    private RadioButton radioButtonJuridico, radioButtonFisico;
    private TextInputLayout textInputLayoutCgccpf;
    private TextInputEditText textInputEditTextCgccpf;
    private TextWatcher cpfCnpjTextWatcher;
    //private OnCriarNovoClienteListener criarNovoClienteListener;

    public DialogNewCliente() {

    }

    public static DialogNewCliente newInstance() {
        DialogNewCliente dialogNewCliente = new DialogNewCliente();
        Bundle args = new Bundle();
        dialogNewCliente.setArguments(args);
        return dialogNewCliente;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        mView = inflater.inflate(R.layout.layout_dialog_new_cliente, null, false);
        radioButtonFisico = mView.findViewById(R.id.radioBtPessoaFisica);
        radioButtonJuridico = mView.findViewById(R.id.radioBtPessoaJuridica);
        textInputLayoutCgccpf = mView.findViewById(R.id.textInputCgccpf);


        radioButtonFisico.setOnClickListener(this);
        radioButtonJuridico.setOnClickListener(this);

        if(radioButtonJuridico.isChecked()) {
            radioButtonJuridico.setChecked(true);
            radioButtonFisico.setChecked(false);
            if (!StringUtils.isNullOrEmpty(textInputLayoutCgccpf.getEditText().getText().toString()))
                textInputLayoutCgccpf.getEditText().getText().clear();
//                textInputLayoutCgccpf.getEditText().removeTextChangedListener(cpfCnpjTextWatcher);
                cpfCnpjTextWatcher = MaskEditUtil.mask(textInputLayoutCgccpf.getEditText(), MaskEditUtil.FORMAT_CNPJ);

        }
        textInputLayoutCgccpf.getEditText().addTextChangedListener(cpfCnpjTextWatcher);


        AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(getActivity());
        dialogbuilder.setTitle("Novo cliente");
        dialogbuilder.setView(mView);
        dialogbuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }) ;

        dialogbuilder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                   Intent intent = new Intent(getActivity(), CadastroClienteActivity.class);
                    if (radioButtonJuridico.isChecked()) {
                        intent.putExtra("tipoPessoa", radioButtonJuridico.getTag().toString());
                        intent.putExtra("cgccpf", textInputLayoutCgccpf.getEditText().getText().toString());
                    } else if (radioButtonFisico.isChecked()) {
                        intent.putExtra("tipoPessoa", radioButtonFisico.getTag().toString());
                        intent.putExtra("cgccpf", textInputLayoutCgccpf.getEditText().getText().toString());
                    }

                    //Alterei para não criar o objeto aqui e sim só definir no dialog o tipo de pessoa e recuperar a string do cnpj e cpf
//                    Cliente cliente = new Cliente();
//                    cliente.setCodigo(cliente.generateId());
//                    intent.putExtra("codigo", cliente.generateId());
                    startActivity(intent);


//
//                // Uma forma diferente de pegar os dados do dialog
//                Cliente cliente = new Cliente();
//                cliente.setCodigo(cliente.generateId());
//                cliente.setCgccpf(textInputLayoutCgccpf.getEditText().getText().toString());
//
//                /* Logica para verificar qual foi a opção usada pelo usuário */
//                cliente.setTipoPessoa(radioButtonJuridico.isChecked() ? "J" : "F");
//
//                /* 4 -  Envia para quem estiver ouvindo, no caso a "ListaClientesFragment".
//                * configuração esta que foi feita no passo "3" */
//                criarNovoClienteListener.onCriarNovoCliente(cliente);


            }
        });

        AlertDialog alertDialog = dialogbuilder.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                textInputLayoutCgccpf.getEditText().addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if(!StringUtils.isNullOrEmpty(s.toString())){
                            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                        }else{
                            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                        }
                    }
                });
            }
        });

        return alertDialog;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioBtPessoaJuridica:
                radioButtonJuridico.setChecked(true);
                radioButtonFisico.setChecked(false);
                textInputLayoutCgccpf.getEditText().getText().clear();
                textInputLayoutCgccpf.setHint("CNPJ");
                textInputLayoutCgccpf.getEditText().removeTextChangedListener(cpfCnpjTextWatcher);
                cpfCnpjTextWatcher = MaskEditUtil.mask(textInputLayoutCgccpf.getEditText(), MaskEditUtil.FORMAT_CNPJ);
                textInputLayoutCgccpf.getEditText().addTextChangedListener(cpfCnpjTextWatcher);
                break;

            case R.id.radioBtPessoaFisica:
                radioButtonJuridico.setChecked(false);
                radioButtonFisico.setChecked(true);
                textInputLayoutCgccpf.getEditText().getText().clear();
                textInputLayoutCgccpf.setHint("CPF");
                textInputLayoutCgccpf.getEditText().removeTextChangedListener(cpfCnpjTextWatcher);
                cpfCnpjTextWatcher = MaskEditUtil.mask(textInputLayoutCgccpf.getEditText(),MaskEditUtil.FORMAT_CPF);
                textInputLayoutCgccpf.getEditText().addTextChangedListener(cpfCnpjTextWatcher);
                break;
        }


    }

//    /* 2 - Cria o setter para ligar o listener do ouvinte. Como ser disse ao dialog
//    * quando quiser falar comigo, é assim que vou escutar */
//    public void setOnCriarNovoClienteListener(OnCriarNovoClienteListener listener) {
//        criarNovoClienteListener = listener;
//    }
//
//    /* 1 -  Define o ouvinte para o dialog */
//    interface OnCriarNovoClienteListener {
//        void onCriarNovoCliente(Cliente cliente);
//    }
}
