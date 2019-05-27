package com.senai.wsquickfood.model;

import java.io.Serializable;

public class TbIngrediente implements Serializable {

    private int bdID;
    private String bdNome;
    private int quantidade;
    private int bdFkFoto;

    public TbIngrediente() {
    }

    public TbIngrediente(int bdID) {
        this.bdID = bdID;
    }

    public TbIngrediente(int bdID, String bdNome) {
        this.bdID = bdID;
        this.bdNome = bdNome;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getBdFkFoto() {
        return bdFkFoto;
    }

    public void setBdFkFoto(int bdFkFoto) {
        this.bdFkFoto = bdFkFoto;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingrediente[ bdID=" + bdID + " ]";
    }

}
