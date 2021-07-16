package com.chs.appbancoafv.model;

public class Municipio {
    private String codMunicipio;
    private String nomeMunicipio;
    private String ufMunicipio;

    public Municipio(){

    }

    public Municipio(String codMunicipio, String nomeMunicipio, String ufMunicipio){
        this.codMunicipio = codMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.ufMunicipio = ufMunicipio;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getUfMunicipio() {
        return ufMunicipio;
    }

    public void setUfMunicipio(String ufMunicipio) {
        this.ufMunicipio = ufMunicipio;
    }
}
