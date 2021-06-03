package com.chs.appbancoafv.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Produto implements Serializable {
    private String PRO_CODIGO;
    private String PRO_DESCRICAO;

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
    public String toString() {
        return PRO_CODIGO + "------" + PRO_DESCRICAO;
    }
}
