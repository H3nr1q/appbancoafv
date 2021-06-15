package com.chs.appbancoafv.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chs.appbancoafv.utils.AppBancoAfv;

import java.io.IOException;

public class DbHelperAfv extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.chs.appbancoafv/files/Ferraz/Guarani/Banco/";

    private static String DB_NAME = "bancomovel";

//    private final Context myContext;

    private SQLiteDatabase myDatabase;

    public static DbHelperAfv dbHelperAfv;


    public void createDatabase() throws IOException{
//        boolean dbExist = checkDatabase();
//        if(dbExist){
//
//        }else{
//            this.getReadableDatabase();
//        }

    }

    private boolean checkDatabase() {
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch (SQLException e){


        }
        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    public void openDataBase() throws SQLException{
        String myPath = DB_PATH + DB_NAME;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }


//    public DbHelperAfv(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, Context myContext) {
//        super(AppBancoAfv.getInstance(), DB_NAME, null, 1);
//        this.myContext = myContext;
//    }

    public DbHelperAfv() {
        super(AppBancoAfv.getInstance(), DB_NAME, null, 1);
//        this.myContext = myContext;
    }

    public synchronized static DbHelperAfv getInstance(){
        if(dbHelperAfv == null){
            dbHelperAfv = new DbHelperAfv();
        }
        return dbHelperAfv;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        boolean dbExist = checkDatabase();
        if(dbExist){

        }else{
            this.getReadableDatabase();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
