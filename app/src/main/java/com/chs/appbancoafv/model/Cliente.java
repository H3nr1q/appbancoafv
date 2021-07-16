package com.chs.appbancoafv.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente implements Parcelable {
    private String codigo;
    private String razao;
    private String fantasia;
    private String cgccpf;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String codMunicipio;
    private String telefone;
    private String fax;
    private String enderecoEntrega;
    private String numeroEntrega;
    private String complementoEntrega;
    private String bairroEntrega;
    private String codMunicipioEntrega;
    private String email;
    private String emailNf;
    private String tipoPessoa;
    private String cep;

    public Cliente() {

    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente();
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCgccpf() {
        return cgccpf;
    }

    public void setCgccpf(String cgccpf) {
        this.cgccpf = cgccpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getNumeroEntrega() {
        return numeroEntrega;
    }

    public void setNumeroEntrega(String numeroEntrega) {
        this.numeroEntrega = numeroEntrega;
    }

    public String getComplementoEntrega() {
        return complementoEntrega;
    }

    public void setComplementoEntrega(String complementoEntrega) {
        this.complementoEntrega = complementoEntrega;
    }

    public String getBairroEntrega() {
        return bairroEntrega;
    }

    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    public String getCodMunicipioEntrega() {
        return codMunicipioEntrega;
    }

    public void setCodMunicipioEntrega(String codMunicipioEntrega) {
        this.codMunicipioEntrega = codMunicipioEntrega;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailNf() {
        return emailNf;
    }

    public void setEmailNf(String emailNf) {
        this.emailNf = emailNf;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(codigo);
        dest.writeString(razao);
        dest.writeString(fantasia);
        dest.writeString(cgccpf);
        dest.writeString(endereco);
        dest.writeString(numero);
        dest.writeString(complemento);
        dest.writeString(bairro);
        dest.writeString(codMunicipio);
        dest.writeString(telefone);
        dest.writeString(fax);
        dest.writeString(enderecoEntrega);
        dest.writeString(numeroEntrega);
        dest.writeString(complementoEntrega);
        dest.writeString(bairroEntrega);
        dest.writeString(codMunicipioEntrega);
        dest.writeString(email);
        dest.writeString(emailNf);
        dest.writeString(tipoPessoa);
        dest.writeString(cep);
    }

    @Override
    public String toString() {
        return codigo;
    }

    public static String generateId(){
        return new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
    }
}
