package com.chs.appbancoafv.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.adapter.RecyclerAdapterProdutos;
import com.chs.appbancoafv.adapter.RecyclerDialogPrecos;
import com.chs.appbancoafv.db.ProdutoDAO;
import com.chs.appbancoafv.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class DialogPrecos extends DialogFragment {

    private static final String ARG_CODIGO_PRODUTO = "codigoProduto";
    private RecyclerDialogPrecos adapterPrecos;
    private List<Produto> listaPrecosProdutos = new ArrayList<>();
    private List<Produto> listaPrecos = new ArrayList<>();
    RecyclerView recyclerView;
    View mView;
    private String codigoProduto;

    public DialogPrecos() {

    }

    public static DialogPrecos newInstance(String codigoProduto){
        DialogPrecos dialogPrecos = new DialogPrecos();
        Bundle args = new Bundle();
        args.putString(ARG_CODIGO_PRODUTO, codigoProduto);
        dialogPrecos.setArguments(args);
        return dialogPrecos;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            codigoProduto = getArguments().getString(ARG_CODIGO_PRODUTO);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

//        LayoutInflater.from(getContext()).inflate(R.layout.dialog_precos, null, false);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        mView = inflater.inflate(R.layout.dialog_precos, null,false);
        recyclerView = mView.findViewById(R.id.recyclerViewPrecos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listaPrecos = ProdutoDAO.getInstance().listaPrecosProduto(codigoProduto);
        listaPrecosProdutos.addAll(listaPrecos);


        adapterPrecos = new RecyclerDialogPrecos(listaPrecosProdutos);
        recyclerView.setAdapter(adapterPrecos);
        ((TextView)mView.findViewById(R.id.textoPrecos)).setText(codigoProduto);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

        dialogBuilder.setView(mView);
        return dialogBuilder.create();

    }



}
