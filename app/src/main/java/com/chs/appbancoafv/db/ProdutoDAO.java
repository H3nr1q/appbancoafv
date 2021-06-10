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
            p.setCODIGO(c.getString(c.getColumnIndex("PRO_CODIGO")));
            p.setDESCRICAO(c.getString(c.getColumnIndex("PRO_DESCRICAO")));
            p.setESTOQUE(c.getString(c.getColumnIndex("ESE_ESTOQUE")));
            p.setLEGENDA(c.getString(c.getColumnIndex("PRO_LEGENDA")));
            p.setVRMAX(c.getString(c.getColumnIndex("PRP_VRMAX")));
            p.setVRMIN(c.getString(c.getColumnIndex("PRP_VRMIN")));
            produtos.add(p);

        }
        c.close();
        return produtos;

    }

}
