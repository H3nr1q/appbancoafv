package com.chs.appbancoafv.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String PRO_CODIGO;
    private String PRO_DESCRICAO;

    public Produto() {

    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto();
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public String getPRO_CODIGO() {
        return PRO_CODIGO;
    }

    public void setPRO_CODIGO(String PRO_CODIGO) {
        this.PRO_CODIGO = PRO_CODIGO;
    }

    public String getPRO_DESCRICAO() {
        return PRO_DESCRICAO;
    }

    public void setPRO_DESCRICAO(String PRO_DESCRICAO) {
        this.PRO_DESCRICAO = PRO_DESCRICAO;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(PRO_CODIGO);
        dest.writeString(PRO_DESCRICAO);
    }

    @Override
    public String toString() {

        return PRO_CODIGO + "------" + PRO_DESCRICAO;
    }
}
