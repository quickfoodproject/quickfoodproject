package com.senai.wsquickfood.model;

import java.io.Serializable;

public class TbAvaliacao implements Serializable {

    private int bdID;
    private boolean bdJaCurtiu;
    private TbReceita bdFKReceita;
    private TbUsuario bdFKUsuario;
    private String bdComentario;

    public TbAvaliacao() {
    }

    public TbAvaliacao(int bdID) {
        this.bdID = bdID;
    }

    public boolean isBdJaCurtiu() {
        return bdJaCurtiu;
    }

    public void setBdJaCurtiu(boolean bdJaCurtiu) {
        this.bdJaCurtiu = bdJaCurtiu;
    }

    public String getBdComentario() {
        return bdComentario;
    }

    public void setBdComentario(String bdComentario) {
        this.bdComentario = bdComentario;
    }

    public int getBdID() {
        return bdID;
    }

    public void setBdID(int bdID) {
        this.bdID = bdID;
    }

    public boolean getbdJaCurtiu() {
        return bdJaCurtiu;
    }

    public void setbdJaCurtiu(boolean bdJaCurtiu) {
        this.bdJaCurtiu = bdJaCurtiu;
    }

    public TbReceita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(TbReceita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    }

    public TbUsuario getBdFKUsuario() {
        return bdFKUsuario;
    }

    public void setBdFKUsuario(TbUsuario bdFKUsuario) {
        this.bdFKUsuario = bdFKUsuario;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbavaliacao[ bdID=" + bdID + " ]";
    }
    
}
