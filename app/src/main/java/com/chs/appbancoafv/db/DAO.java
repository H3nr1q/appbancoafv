package com.chs.appbancoafv.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public abstract class DAO<Param> {
    public DAO(){}
    public final SQLiteDatabase getWritableDB(){
        return DbHelperAfv.getInstance().getWritableDatabase();
    }
    public final SQLiteDatabase getReadableDB(){
        return DbHelperAfv.getInstance().getReadableDatabase();
    }
    public abstract boolean saveOrEdit(Param object);
    public abstract List<Param> searchByName(String name);
    public abstract boolean deletar(Param object);
    public abstract List<Param> listar();
    public abstract Param searchContactById(int id);
}
