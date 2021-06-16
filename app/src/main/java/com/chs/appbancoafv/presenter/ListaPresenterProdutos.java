package com.chs.appbancoafv.presenter;

import com.chs.appbancoafv.db.ProdutoDAO;
import com.chs.appbancoafv.model.Produto;
import com.chs.appbancoafv.view.DialogPrecos;

import java.util.List;

public class ListaPresenterProdutos {
    private ProdutoView produtoView;
    private List<Produto> produtos;

    public ListaPresenterProdutos(ProdutoView view){
        produtoView = view;
    }

    public void listarProdutos(){
        produtos = ProdutoDAO.getInstance().listaProduto();
        produtoView.refreshList(produtos);
    }

    public void posicionaProduto(String digitouTexto){
        produtos = ProdutoDAO.getInstance().posicionaProduto(digitouTexto);
        produtoView.refreshList(produtos);
    }

    public void buscarStatus(String status){
        produtos = ProdutoDAO.getInstance().buscaProdutoStatus(status);
        produtoView.refreshList(produtos);
    }



    public interface ProdutoView {
        void refreshList(List<Produto> produtos);
    }
}
