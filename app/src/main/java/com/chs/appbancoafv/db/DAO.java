package com.chs.appbancoafv.db;

import android.content.ContentValues;
import android.database.Cursor;
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

    protected abstract ContentValues bindValues(Param param);

    protected abstract Param bind(Cursor c);

    protected String getString(Cursor c, String columName, String defaultField){
        if(columName == null || columName.isEmpty()) return defaultField;
        final String field = c.getString(c.getColumnIndex(columName));
        if(field == null){
            return defaultField;
        }
        return field;
    }

    protected String getString(Cursor c, String columName){
        return getString(c, columName, null);
    }

}
