package com.chs.appbancoafv.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String CODIGO;
    private String DESCRICAO;
    private String LEGENDA;
    private String VRMAX;
    private String VRMIN;
    private String ESTOQUE;

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

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public String getLEGENDA() {
        return LEGENDA;
    }

    public void setLEGENDA(String LEGENDA) {
        this.LEGENDA = LEGENDA;
    }

    public String getVRMAX() {
        return VRMAX;
    }

    public void setVRMAX(String VRMAX) {
        this.VRMAX = VRMAX;
    }

    public String getVRMIN() {
        return VRMIN;
    }

    public void setVRMIN(String VRMIN) {
        this.VRMIN = VRMIN;
    }

    public String getESTOQUE() {
        return ESTOQUE;
    }

    public void setESTOQUE(String ESTOQUE) {
        this.ESTOQUE = ESTOQUE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CODIGO);
        dest.writeString(DESCRICAO);
        dest.writeString(LEGENDA);
        dest.writeString(VRMAX);
        dest.writeString(VRMIN);
        dest.writeString(ESTOQUE);
    }

    @Override
    public String toString() {

        return CODIGO;
    }
}
