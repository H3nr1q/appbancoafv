package com.chs.appbancoafv.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.db.ProdutoDAO;
import com.chs.appbancoafv.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Produto> produtos = new ArrayList<>();
    private List<Produto> produtosFiltrados = new ArrayList<>();
    private ProdutoDAO produtoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

    }

    private void bindViews(){
        listView = findViewById(R.id.lv_produtos);
        produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.listaProduto();
        produtosFiltrados.addAll(produtos);
        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_expandable_list_item_1, produtosFiltrados);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }
}