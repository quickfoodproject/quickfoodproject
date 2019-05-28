package com.senai.wsquickfood.model;

public class TbFoto {

    private int bdId;
    private String bdFoto;

    public TbFoto() {
    }

    public TbFoto(int bdId) {
        this.bdId = bdId;
    }

    public TbFoto(int bdId, String bdFoto) {
        this.bdId = bdId;
        this.bdFoto = bdFoto;
    }

    public int getBdId() {
        return bdId;
    }

    public void setBdId(int bdId) {
        this.bdId = bdId;
    }

    public String getBdFoto() {
        return bdFoto;
    }

    public void setBdFoto(String bdFoto) {
        this.bdFoto = bdFoto;
    }

    @Override
    public String toString() {
        return "TbFoto{" + "bdId=" + bdId + ", bdFoto=" + bdFoto + '}';
    }

}
