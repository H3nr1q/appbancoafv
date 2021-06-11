package com.chs.appbancoafv.presenter;

import com.chs.appbancoafv.db.ProdutoDAO;
import com.chs.appbancoafv.model.Produto;

import java.util.List;

public class ListaPresenter {
    private ProdutoView produtoView;
    private List<Produto> produtos;

    public ListaPresenter(ProdutoView view){
        produtoView = view;
    }

    public void listarProdutos(){
        produtos = ProdutoDAO.getInstance().listaProduto();
        produtoView.refreshList(produtos);
    }


    public interface ProdutoView {
        void refreshList(List<Produto> produtos);
    }
}
