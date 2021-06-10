package com.chs.appbancoafv.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
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

import java.util.ArrayList;
import java.util.List;


public class ListaProdutosFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Produto> produtos = new ArrayList<>();
    private List<Produto> produtosFiltrados = new ArrayList<>();
    private ProdutoDAO produtoDAO;




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
        produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.listaProduto();
        produtosFiltrados.addAll(produtos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapterProdutos adapterProdutos = new RecyclerAdapterProdutos(produtos);
        recyclerView.setAdapter(adapterProdutos);

    }

    @Override
    public void onResume() {
        super.onResume();
        produtos = ProdutoDAO.getInstance().listaProduto();
        produtosFiltrados.clear();
        produtosFiltrados.addAll(produtos);
        recyclerView.invalidate();
    }
}