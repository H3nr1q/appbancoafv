package com.chs.appbancoafv.db;

import android.content.ContentValues;
import android.database.Cursor;

import com.chs.appbancoafv.model.Municipio;

import java.util.List;

public class MunicipioDAO extends DAO<Municipio> {
    public static MunicipioDAO instance;

    public synchronized static MunicipioDAO getInstance(){
        if (instance == null){
            instance = new MunicipioDAO();
        }
        return  instance;
    }

    public MunicipioDAO(){

    }

    @Override
    public boolean saveOrEdit(Municipio object) {
        return false;
    }

    @Override
    public List<Municipio> searchByName(String name) {
        return null;
    }

    @Override
    public boolean deletar(Municipio object) {
        return false;
    }

    @Override
    public List<Municipio> listar() {
        return null;
    }

    @Override
    public Municipio searchContactById(int id) {
        return null;
    }

    @Override
    protected ContentValues bindValues(Municipio municipio) {
        return null;
    }

    @Override
    protected Municipio bind(Cursor c) {
        return null;
    }



}
