package com.chs.appbancoafv.view;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.chs.appbancoafv.model.Cliente;

public abstract class CadastroClienteFragment extends Fragment {
    private ICadastroCliente mOnCadastroClienteListener;

    public CadastroClienteFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ICadastroCliente){
            mOnCadastroClienteListener = (ICadastroCliente) context;
        }
    }

    protected Cliente getCliente(){
        return  mOnCadastroClienteListener.getCliente();

    }

    public abstract boolean isValid();
}
