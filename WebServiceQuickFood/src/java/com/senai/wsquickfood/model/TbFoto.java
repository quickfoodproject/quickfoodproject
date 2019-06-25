package com.senai.wsquickfood.model;

import java.sql.Blob;

public class TbFoto {

    private int bdId;
    private Blob bdFoto;
    private String fotoJson;

    public TbFoto() {
    }

    public TbFoto(Blob bdFoto) {
        this.bdFoto = bdFoto;
    }

    public TbFoto(int bdId) {
        this.bdID = bdId;
    }

    public TbFoto(int bdId, Blob bdFoto) {
        this.bdId = bdId;
        this.bdFoto = bdFoto;
    }

    public String getFotoJson() {
        return fotoJson;
    }

    public void setFotoJson(String FotoJson) {
        this.fotoJson = FotoJson;
    }

    public int getBdId() {
        return bdID;
    }

    public void setBdId(int bdId) {
        this.bdID = bdId;
    }

    public Blob getBdFoto() {
        return bdFoto;
    }

    public void setBdFoto(Blob bdFoto) {
        this.bdFoto = bdFoto;
    }

    @Override
    public String toString() {
        return "TbFoto{" + "bdId=" + bdID + ", bdFoto=" + bdFoto + '}';
    }

}
