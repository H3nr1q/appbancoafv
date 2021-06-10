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
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_produtos, container, false);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_busca_produto, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String digitouTexto) {
                produtos = ProdutoDAO.getInstance().posicionaProduto(digitouTexto);
                produtosFiltrados.addAll(produtos);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                RecyclerAdapterProdutos adapterProdutos = new RecyclerAdapterProdutos(produtos);
                recyclerView.setAdapter(adapterProdutos);
                return false;
            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvProdutos);
        produtos = ProdutoDAO.getInstance().listaProduto();
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
    }

}