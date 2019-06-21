package com.senai.wsquickfood.model;

public class TbFoto {

    private int bdID;
    private String bdFoto;

    public TbFoto() {
    }

    public TbFoto(int bdId) {
        this.bdID = bdId;
    }

    public TbFoto(int bdId, String bdFoto) {
        this.bdID = bdId;
        this.bdFoto = bdFoto;
    }

    public int getBdId() {
        return bdID;
    }

    public void setBdId(int bdId) {
        this.bdID = bdId;
    }

    public String getBdFoto() {
        return bdFoto;
    }

    public void setBdFoto(String bdFoto) {
        this.bdFoto = bdFoto;
    }

    @Override
    public String toString() {
        return "TbFoto{" + "bdId=" + bdID + ", bdFoto=" + bdFoto + '}';
    }

}
