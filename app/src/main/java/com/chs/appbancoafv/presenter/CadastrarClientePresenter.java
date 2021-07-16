package com.chs.appbancoafv.presenter;

import com.chs.appbancoafv.db.ClienteDAO;
import com.chs.appbancoafv.model.Cliente;

public class CadastrarClientePresenter {
    private CadastrarClienteView mCadastrarClienteView;

    public CadastrarClientePresenter(){

    }

    public CadastrarClienteView getmCadastrarClienteView() {
        return mCadastrarClienteView;
    }

    public void setmCadastrarClienteView(CadastrarClienteView mCadastrarClienteView){
        this.mCadastrarClienteView = mCadastrarClienteView;
    }

    public void salvarEditarCliente(Cliente cliente){
        ClienteDAO.getInstance().saveOrEdit(cliente);

    }

    public interface CadastrarClienteView{

    }

}
