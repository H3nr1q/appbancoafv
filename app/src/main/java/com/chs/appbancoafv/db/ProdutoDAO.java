package com.chs.appbancoafv.db;

import android.database.Cursor;

import com.chs.appbancoafv.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends DAO<Produto> {
    public static ProdutoDAO instance;

    public ProdutoDAO(){

    }

    @Override
    public boolean saveOrEdit(Produto object) {
        return false;
    }

    @Override
    public List<Produto> searchByName(String name) {
        return null;
    }

    @Override
    public boolean deletar(Produto object) {
        return false;
    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public Produto searchContactById(int id) {
        return null;
    }

    public synchronized static ProdutoDAO getInstance() {
        if (instance == null){
            instance = new ProdutoDAO();
        }
        return instance;
    }

    public List<Produto> listaProduto(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM " + "GUA_PRODUTOS" + ";";
        Cursor c = getReadableDB().rawQuery(sql, null);
        while (c.moveToNext()){
            Produto p = new Produto();
            p.setPRO_CODIGO(c.getString(c.getColumnIndex("PRO_CODIGO")));
            p.setPRO_DESCRICAO(c.getString(c.getColumnIndex("PRO_DESCRICAO")));
            produtos.add(p);

        }
        c.close();
        return produtos;

    }

}
