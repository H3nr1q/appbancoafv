package com.chs.appbancoafv.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

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

                if(radioButtonJuridico.isChecked()){
                    intent.putExtra("tipoPessoa", radioButtonJuridico.getTag().toString());
                    intent.putExtra("cgccpf", textInputLayoutCgccpf.getEditText().getText().toString());
                }else if (radioButtonFisico.isChecked()){
                    intent.putExtra("tipoPessoa", radioButtonFisico.getTag().toString());
                    intent.putExtra("cgccpf", textInputLayoutCgccpf.getEditText().getText().toString());
                }
                Cliente cliente = new Cliente();
                cliente.setCodigo(cliente.generateId());
                intent.putExtra("codigo", cliente.generateId());
                startActivity(intent);
            }
        });

        return dialogbuilder.create();





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
}
