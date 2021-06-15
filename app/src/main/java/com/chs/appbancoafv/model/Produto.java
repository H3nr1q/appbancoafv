package com.chs.appbancoafv.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String codigo;
    private String descricao;
    private String legenda;
    private String vrmax;
    private String vrmin;
    private String estoque;
    private String tabela;
    private String preco;
    private String embalagem;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getVrmax() {
        return vrmax;
    }

    public void setVrmax(String vrmax) {
        this.vrmax = vrmax;
    }

    public String getVrmin() {
        return vrmin;
    }

    public void setVrmin(String vrmin) {
        this.vrmin = vrmin;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(descricao);
        dest.writeString(legenda);
        dest.writeString(vrmax);
        dest.writeString(vrmin);
        dest.writeString(estoque);
        dest.writeString(tabela);
        dest.writeString(preco);
        dest.writeString(embalagem);
    }

    @Override
    public String toString() {

        return codigo;
    }
}
