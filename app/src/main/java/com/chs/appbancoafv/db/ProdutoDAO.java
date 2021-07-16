package com.chs.appbancoafv.db;

import android.content.ContentValues;
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

    @Override
    protected ContentValues bindValues(Produto produto) {
        return null;
    }

    @Override
    protected Produto bind(Cursor c) {
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
        String sql = "SELECT " +
                "PRO_CODIGO, " +
                "PRO_DESCRICAO, " +
                "CASE " +
                "WHEN PRO_STATUS = 'N' THEN 'EM LINHA'  " +
                "WHEN PRO_STATUS = 'P' THEN 'P. ESTOQUE'  " +
                "WHEN PRO_STATUS = 'R' THEN 'PROMOCAO'  " +
                "WHEN PRO_STATUS = 'L' THEN 'LANCAMENTO' " +
                "END AS PRO_LEGENDA," +
                "ESE_ESTOQUE, " +
                "MAX(CAST(PRP_PRECOS AS REAL(6,4))) AS PRP_VRMAX, " +
                "MIN(CAST(PRP_PRECOS AS REAL(6,4))) AS PRP_VRMIN " +
                "FROM GUA_PRODUTOS " +
                "LEFT JOIN GUA_ESTOQUEEMPRESA ON (ESE_EMPRESA = PRO_CODIGOEMPRESA AND ESE_CODIGO = PRO_CODIGO )" +
                "LEFT JOIN GUA_PRECOS ON (PRP_CODIGO = PRO_CODIGO)" +
                "GROUP BY PRO_CODIGO;";
        Cursor c = getReadableDB().rawQuery(sql, null);
        while (c.moveToNext()){
            Produto p = new Produto();
            p.setCodigo(c.getString(c.getColumnIndex("PRO_CODIGO")));
            p.setDescricao(c.getString(c.getColumnIndex("PRO_DESCRICAO")));
            p.setEstoque(c.getString(c.getColumnIndex("ESE_ESTOQUE")));
            p.setLegenda(c.getString(c.getColumnIndex("PRO_LEGENDA")));
            p.setVrmax(c.getString(c.getColumnIndex("PRP_VRMAX")));
            p.setVrmin(c.getString(c.getColumnIndex("PRP_VRMIN")));
            produtos.add(p);

        }
        c.close();
        return produtos;

    }

    public List<Produto> posicionaProduto(String digitouTexto){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT " +
                "PRO_CODIGO, " +
                "PRO_DESCRICAO, " +
                "CASE " +
                "WHEN PRO_STATUS = 'N' THEN 'EM LINHA'  " +
                "WHEN PRO_STATUS = 'P' THEN 'P. ESTOQUE'  " +
                "WHEN PRO_STATUS = 'R' THEN 'PROMOCAO'  " +
                "WHEN PRO_STATUS = 'L' THEN 'LANCAMENTO' " +
                "END AS PRO_LEGENDA," +
                "ESE_ESTOQUE, " +
                "MAX(CAST(PRP_PRECOS AS REAL(6,4))) AS PRP_VRMAX, " +
                "MIN(CAST(PRP_PRECOS AS REAL(6,4))) AS PRP_VRMIN " +
                "FROM GUA_PRODUTOS " +
                "LEFT JOIN GUA_ESTOQUEEMPRESA ON (ESE_EMPRESA = PRO_CODIGOEMPRESA AND ESE_CODIGO = PRO_CODIGO )" +
                "LEFT JOIN GUA_PRECOS ON (PRP_CODIGO = PRO_CODIGO) " +
                "WHERE PRO_CODIGO LIKE "+ "'%"+ digitouTexto + "%' " +
                "OR PRO_DESCRICAO LIKE "+ "'%"+ digitouTexto + "%' " +
                "GROUP BY PRO_CODIGO;";
        Cursor c = getReadableDB().rawQuery(sql,null);


        while (c.moveToNext()){
            Produto p = new Produto();
            p.setCodigo(c.getString(c.getColumnIndex("PRO_CODIGO")));
            p.setDescricao(c.getString(c.getColumnIndex("PRO_DESCRICAO")));
            p.setEstoque(c.getString(c.getColumnIndex("ESE_ESTOQUE")));
            p.setLegenda(c.getString(c.getColumnIndex("PRO_LEGENDA")));
            p.setVrmax(c.getString(c.getColumnIndex("PRP_VRMAX")));
            p.setVrmin(c.getString(c.getColumnIndex("PRP_VRMIN")));
            produtos.add(p);

        }
        c.close();
        return produtos;

    }


    public List<Produto> buscaProdutoStatus(String status){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT " +
                "PRO_CODIGO, " +
                "PRO_DESCRICAO, " +
                "CASE " +
                "WHEN PRO_STATUS = 'N' THEN 'EM LINHA'  " +
                "WHEN PRO_STATUS = 'P' THEN 'P. ESTOQUE'  " +
                "WHEN PRO_STATUS = 'R' THEN 'PROMOCAO'  " +
                "WHEN PRO_STATUS = 'L' THEN 'LANCAMENTO' " +
                "END AS PRO_LEGENDA," +
                "ESE_ESTOQUE, " +
                "MAX(CAST(PRP_PRECOS AS REAL(6,4))) AS PRP_VRMAX, " +
                "MIN(CAST(PRP_PRECOS AS REAL(6,4))) AS PRP_VRMIN " +
                "FROM GUA_PRODUTOS " +
                "LEFT JOIN GUA_ESTOQUEEMPRESA ON (ESE_EMPRESA = PRO_CODIGOEMPRESA AND ESE_CODIGO = PRO_CODIGO )" +
                "LEFT JOIN GUA_PRECOS ON (PRP_CODIGO = PRO_CODIGO) " +
                "WHERE PRO_STATUS LIKE "+ "'%"+ status + "%' " +
                "GROUP BY PRO_CODIGO;";
        Cursor c = getReadableDB().rawQuery(sql,null);


        while (c.moveToNext()){
            Produto p = new Produto();
            p.setCodigo(c.getString(c.getColumnIndex("PRO_CODIGO")));
            p.setDescricao(c.getString(c.getColumnIndex("PRO_DESCRICAO")));
            p.setEstoque(c.getString(c.getColumnIndex("ESE_ESTOQUE")));
            p.setLegenda(c.getString(c.getColumnIndex("PRO_LEGENDA")));
            p.setVrmax(c.getString(c.getColumnIndex("PRP_VRMAX")));
            p.setVrmin(c.getString(c.getColumnIndex("PRP_VRMIN")));
            produtos.add(p);

        }
        c.close();
        return produtos;

    }


    public List<Produto> listaPrecosProduto(String codigoProduto){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT " +
                "PRC_DESCRICAO, " +
                "CAST(PRP_PRECOS AS REAL(6,4)) AS PRP_PRECO, " +
                "PRP_UNIVENDA " +
                "FROM GUA_PRECOS " +
                "INNER JOIN GUA_CABTABPRECO ON (PRC_CODIGO = PRP_TABELAPRECO) " +
                "WHERE PRP_CODIGO = "+ "'"+ codigoProduto + "' " +
                "ORDER BY PRP_PRECOS ASC;";

        Cursor c = getReadableDB().rawQuery(sql, null);

        while (c.moveToNext()){
            Produto p = new Produto();
            p.setTabela(c.getString(c.getColumnIndex("PRC_DESCRICAO")));
            p.setPreco(c.getString(c.getColumnIndex("PRP_PRECO")));
            p.setEmbalagem(c.getString(c.getColumnIndex("PRP_UNIVENDA")));
            produtos.add(p);
        }
        c.close();
        return produtos;
    }

}
