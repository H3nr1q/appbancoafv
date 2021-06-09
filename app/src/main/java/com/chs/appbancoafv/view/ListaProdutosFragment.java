package com.chs.appbancoafv.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.adapter.RecyclerAdapterProdutos;
import com.chs.appbancoafv.db.ProdutoDAO;
import com.chs.appbancoafv.model.Produto;

import java.util.List;


public class ListaProdutosFragment extends Fragment {
    private List<Produto> produtoList;
    private RecyclerView recyclerView;




    public ListaProdutosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_produtos, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvProdutos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapterProdutos adapterProdutos = new RecyclerAdapterProdutos(produtoList);
        recyclerView.setAdapter(adapterProdutos);

    }

    @Override
    public void onResume() {
        super.onResume();
        produtoList = ProdutoDAO.getInstance().listaProduto();
    }
}